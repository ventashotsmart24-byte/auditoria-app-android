package com.hpplay.cybergarage.upnp;

import android.text.TextUtils;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.http.HTTPRequestListener;
import com.hpplay.cybergarage.http.HTTPResponse;
import com.hpplay.cybergarage.http.HTTPServerList;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.soap.SOAPResponse;
import com.hpplay.cybergarage.upnp.control.ActionListener;
import com.hpplay.cybergarage.upnp.control.ActionRequest;
import com.hpplay.cybergarage.upnp.control.ActionResponse;
import com.hpplay.cybergarage.upnp.control.ControlRequest;
import com.hpplay.cybergarage.upnp.control.QueryListener;
import com.hpplay.cybergarage.upnp.control.QueryRequest;
import com.hpplay.cybergarage.upnp.device.Advertiser;
import com.hpplay.cybergarage.upnp.device.Description;
import com.hpplay.cybergarage.upnp.device.InvalidDescriptionException;
import com.hpplay.cybergarage.upnp.device.NTS;
import com.hpplay.cybergarage.upnp.device.PresentationListener;
import com.hpplay.cybergarage.upnp.device.ST;
import com.hpplay.cybergarage.upnp.device.SearchListener;
import com.hpplay.cybergarage.upnp.event.Subscriber;
import com.hpplay.cybergarage.upnp.event.Subscription;
import com.hpplay.cybergarage.upnp.event.SubscriptionRequest;
import com.hpplay.cybergarage.upnp.event.SubscriptionResponse;
import com.hpplay.cybergarage.upnp.ssdp.SSDPNotifyRequest;
import com.hpplay.cybergarage.upnp.ssdp.SSDPNotifySocket;
import com.hpplay.cybergarage.upnp.ssdp.SSDPPacket;
import com.hpplay.cybergarage.upnp.ssdp.SSDPSearchResponse;
import com.hpplay.cybergarage.upnp.ssdp.SSDPSearchResponseSocket;
import com.hpplay.cybergarage.upnp.ssdp.SSDPSearchSocketList;
import com.hpplay.cybergarage.upnp.xml.DeviceData;
import com.hpplay.cybergarage.util.Mutex;
import com.hpplay.cybergarage.util.TimerUtil;
import com.hpplay.cybergarage.xml.Node;
import com.hpplay.cybergarage.xml.XML;
import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;

public class Device implements HTTPRequestListener, SearchListener {
    private static final String CONFIG_ID = "configId";
    public static final String DEFAULT_DESCRIPTION_URI = "/description.xml";
    public static final int DEFAULT_DISCOVERY_WAIT_TIME = 300;
    public static final int DEFAULT_LEASE_TIME = 30;
    public static final String DEFAULT_PRESENTATION_URI = "/presentation";
    public static final int DEFAULT_STARTUP_WAIT_TIME = 1000;
    private static final String DEVICE_TYPE = "deviceType";
    public static final String ELEM_NAME = "device";
    private static final String FRIENDLY_NAME = "friendlyName";
    public static final int HTTP_DEFAULT_PORT = 4004;
    private static final String MANUFACTURE = "manufacturer";
    private static final String MANUFACTURE_URL = "manufacturerURL";
    private static final String MODEL_DESCRIPTION = "modelDescription";
    private static final String MODEL_NAME = "modelName";
    private static final String MODEL_NUMBER = "modelNumber";
    private static final String MODEL_URL = "modelURL";
    private static final String SERIAL_NUMBER = "serialNumber";
    private static final String TAG = "LB-Device";
    private static final String UDN = "UDN";
    private static final String UID = "UID";
    private static final String UPC = "UPC";
    public static final String UPNP_ROOTDEVICE = "upnp:rootdevice";
    private static final String URLBASE_NAME = "URLBase";
    private static Calendar cal = Calendar.getInstance();
    private static final String presentationURL = "presentationURL";
    private int bootId;
    private String devUUID;
    private Node deviceNode;
    private HashMap<String, byte[]> iconBytesMap;
    private String mDesc;
    private Mutex mutex;
    private PresentationListener presentationListener;
    private Node rootNode;
    private Object userData;
    private boolean wirelessMode;

    static {
        UPnP.initialize();
    }

    public Device(Node node, Node node2) {
        this.mutex = new Mutex();
        this.iconBytesMap = new HashMap<>();
        this.userData = null;
        this.rootNode = node;
        this.deviceNode = node2;
        setUUID(UPnP.createUUID());
        setWirelessMode(false);
    }

    private void deviceActionControlRecieved(ActionRequest actionRequest, Service service) {
        actionRequest.print();
        Action action = service.getAction(actionRequest.getActionName());
        if (action == null) {
            invalidActionControlRecieved(actionRequest);
            return;
        }
        try {
            action.getArgumentList().setReqArgs(actionRequest.getArgumentList());
            if (!action.performActionListener(actionRequest)) {
                invalidActionControlRecieved(actionRequest);
            }
        } catch (IllegalArgumentException unused) {
            invalidArgumentsControlRecieved(actionRequest);
        }
    }

    private void deviceControlRequestRecieved(ControlRequest controlRequest, Service service) {
        if (controlRequest.isQueryControl()) {
            deviceQueryControlRecieved(new QueryRequest(controlRequest), service);
        } else {
            deviceActionControlRecieved(new ActionRequest((HTTPRequest) controlRequest), service);
        }
    }

    private void deviceEventNewSubscriptionRecieved(Service service, SubscriptionRequest subscriptionRequest) {
        String callback = subscriptionRequest.getCallback();
        try {
            new URL(callback);
            long timeout = subscriptionRequest.getTimeout();
            String createSID = Subscription.createSID();
            Subscriber subscriber = new Subscriber();
            subscriber.setDeliveryURL(callback);
            subscriber.setTimeOut(timeout);
            subscriber.setSID(createSID);
            service.addSubscriber(subscriber);
            SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
            subscriptionResponse.setStatusCode(200);
            subscriptionResponse.setSID(createSID);
            subscriptionResponse.setTimeout(timeout);
            subscriptionResponse.print();
            subscriptionRequest.post(subscriptionResponse);
            subscriptionResponse.print();
            service.notifyAllStateVariables();
        } catch (Exception unused) {
            upnpBadSubscriptionRecieved(subscriptionRequest, 412);
        }
    }

    private void deviceEventRenewSubscriptionRecieved(Service service, SubscriptionRequest subscriptionRequest) {
        String sid = subscriptionRequest.getSID();
        Subscriber subscriber = service.getSubscriber(sid);
        if (subscriber == null) {
            upnpBadSubscriptionRecieved(subscriptionRequest, 412);
            return;
        }
        long timeout = subscriptionRequest.getTimeout();
        subscriber.setTimeOut(timeout);
        subscriber.renew();
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.setStatusCode(200);
        subscriptionResponse.setSID(sid);
        subscriptionResponse.setTimeout(timeout);
        subscriptionRequest.post(subscriptionResponse);
        subscriptionResponse.print();
    }

    private void deviceEventSubscriptionRecieved(SubscriptionRequest subscriptionRequest) {
        Service serviceByEventSubURL = getServiceByEventSubURL(subscriptionRequest.getURI());
        if (serviceByEventSubURL == null) {
            subscriptionRequest.returnBadRequest();
        } else if (!subscriptionRequest.hasCallback() && !subscriptionRequest.hasSID()) {
            upnpBadSubscriptionRecieved(subscriptionRequest, 412);
        } else if (subscriptionRequest.isUnsubscribeRequest()) {
            deviceEventUnsubscriptionRecieved(serviceByEventSubURL, subscriptionRequest);
        } else if (subscriptionRequest.hasCallback()) {
            deviceEventNewSubscriptionRecieved(serviceByEventSubURL, subscriptionRequest);
        } else if (subscriptionRequest.hasSID()) {
            deviceEventRenewSubscriptionRecieved(serviceByEventSubURL, subscriptionRequest);
        } else {
            upnpBadSubscriptionRecieved(subscriptionRequest, 412);
        }
    }

    private void deviceEventUnsubscriptionRecieved(Service service, SubscriptionRequest subscriptionRequest) {
        Subscriber subscriber = service.getSubscriber(subscriptionRequest.getSID());
        if (subscriber == null) {
            upnpBadSubscriptionRecieved(subscriptionRequest, 412);
            return;
        }
        service.removeSubscriber(subscriber);
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.setStatusCode(200);
        subscriptionRequest.post(subscriptionResponse);
        subscriptionResponse.print();
    }

    private void deviceQueryControlRecieved(QueryRequest queryRequest, Service service) {
        queryRequest.print();
        String varName = queryRequest.getVarName();
        if (!service.hasStateVariable(varName)) {
            invalidActionControlRecieved(queryRequest);
        } else if (!getStateVariable(varName).performQueryListener(queryRequest)) {
            invalidActionControlRecieved(queryRequest);
        }
    }

    private Advertiser getAdvertiser() {
        return getDeviceData().getAdvertiser();
    }

    private synchronized byte[] getDescriptionData(String str) {
        if (!isNMPRMode()) {
            updateURLBase(str);
        }
        Node rootNode2 = getRootNode();
        if (rootNode2 == null) {
            return new byte[0];
        }
        return (((new String() + "<?xml version=\"1.0\" encoding=\"utf-8\"?>") + "\n") + rootNode2.toString()).getBytes();
    }

    private String getDescriptionURI() {
        return getDeviceData().getDescriptionURI();
    }

    private DeviceData getDeviceData() {
        Node deviceNode2 = getDeviceNode();
        DeviceData deviceData = (DeviceData) deviceNode2.getUserData();
        if (deviceData != null) {
            return deviceData;
        }
        DeviceData deviceData2 = new DeviceData();
        deviceNode2.setUserData(deviceData2);
        deviceData2.setNode(deviceNode2);
        return deviceData2;
    }

    private HTTPServerList getHTTPServerList() {
        return getDeviceData().getHTTPServerList();
    }

    private String getNotifyDeviceNT() {
        if (!isRootDevice()) {
            return getUDN();
        }
        return "upnp:rootdevice";
    }

    private String getNotifyDeviceTypeNT() {
        return getDeviceType();
    }

    private String getNotifyDeviceTypeUSN() {
        return getUDN() + "::" + getDeviceType();
    }

    private String getNotifyDeviceUSN() {
        if (!isRootDevice()) {
            return getUDN();
        }
        return getUDN() + "::" + "upnp:rootdevice";
    }

    private SSDPSearchSocketList getSSDPSearchSocketList() {
        return getDeviceData().getSSDPSearchSocketList();
    }

    private void httpGetRequestRecieved(HTTPRequest hTTPRequest) {
        byte[] bArr;
        String uri = hTTPRequest.getURI();
        CLog.d(TAG, "httpGetRequestRecieved = " + uri);
        if (uri == null) {
            hTTPRequest.returnBadRequest();
            return;
        }
        byte[] bArr2 = new byte[0];
        boolean isDescriptionURI = isDescriptionURI(uri);
        String str = XML.DEFAULT_CONTENT_LANGUAGE;
        String str2 = "text/xml; charset=\"utf-8\"";
        if (isDescriptionURI) {
            String localAddress = hTTPRequest.getLocalAddress();
            if (localAddress == null || localAddress.length() <= 0) {
                localAddress = HostInterface.getInterface();
            }
            if (!TextUtils.isEmpty(this.mDesc)) {
                updateURLBase(localAddress);
                bArr = this.mDesc.getBytes();
            } else {
                bArr = getDescriptionData(localAddress);
            }
        } else {
            Device deviceByDescriptionURI = getDeviceByDescriptionURI(uri);
            if (deviceByDescriptionURI != null) {
                bArr = deviceByDescriptionURI.getDescriptionData(hTTPRequest.getLocalAddress());
            } else {
                Service serviceBySCPDURL = getServiceBySCPDURL(uri);
                if (serviceBySCPDURL != null) {
                    bArr = serviceBySCPDURL.getSCPDData();
                } else if (isIconBytesURI(uri)) {
                    Icon iconByURI = getIconByURI(uri);
                    str = null;
                    if (iconByURI != null) {
                        str2 = iconByURI.getMimeType();
                        bArr2 = iconByURI.getBytes();
                    } else {
                        str2 = null;
                    }
                    bArr = bArr2;
                } else {
                    hTTPRequest.returnBadRequest();
                    return;
                }
            }
        }
        HTTPResponse hTTPResponse = new HTTPResponse();
        hTTPResponse.setStatusCode(200);
        if (str2 != null) {
            hTTPResponse.setContentType(str2);
        }
        if (str != null) {
            hTTPResponse.setContentLanguage(str);
        }
        hTTPResponse.setContent(bArr);
        hTTPRequest.post(hTTPResponse);
    }

    private void httpPostRequestRecieved(HTTPRequest hTTPRequest) {
        if (hTTPRequest.isSOAPAction()) {
            soapActionRecieved(hTTPRequest);
        } else {
            hTTPRequest.returnBadRequest();
        }
    }

    private void initializeLoadedDescription() {
        setDescriptionURI(DEFAULT_DESCRIPTION_URI);
        setLeaseTime(30);
        setHTTPPort(HTTP_DEFAULT_PORT);
        if (!hasUDN()) {
            updateUDN();
        }
    }

    private void invalidActionControlRecieved(ControlRequest controlRequest) {
        ActionResponse actionResponse = new ActionResponse();
        actionResponse.setFaultResponse(401);
        controlRequest.post(actionResponse);
    }

    private void invalidArgumentsControlRecieved(ControlRequest controlRequest) {
        ActionResponse actionResponse = new ActionResponse();
        actionResponse.setFaultResponse(402);
        controlRequest.post(actionResponse);
    }

    private boolean isDescriptionURI(String str) {
        String descriptionURI = getDescriptionURI();
        if (str == null || descriptionURI == null) {
            return false;
        }
        return descriptionURI.equals(str);
    }

    public static boolean isDeviceNode(Node node) {
        return ELEM_NAME.equals(node.getName());
    }

    private boolean isPresentationRequest(HTTPRequest hTTPRequest) {
        String uri;
        String presentationURL2;
        if (!hTTPRequest.isGetRequest() || (uri = hTTPRequest.getURI()) == null || (presentationURL2 = getPresentationURL()) == null) {
            return false;
        }
        return uri.startsWith(presentationURL2);
    }

    public static final void notifyWait() {
        TimerUtil.waitRandom(300);
    }

    private void setAdvertiser(Advertiser advertiser) {
        getDeviceData().setAdvertiser(advertiser);
    }

    private void setDescriptionFile(File file) {
        getDeviceData().setDescriptionFile(file);
    }

    private void setDescriptionURI(String str) {
        getDeviceData().setDescriptionURI(str);
    }

    private void setURLBase(String str) {
        CLog.i(TAG, "set base url " + str);
        if (isRootDevice()) {
            if (!TextUtils.isEmpty(this.mDesc)) {
                this.mDesc = String.format(this.mDesc, new Object[]{str});
            }
            Node node = getRootNode().getNode(URLBASE_NAME);
            if (node != null) {
                node.setValue(str);
                return;
            }
            Node node2 = new Node(URLBASE_NAME);
            node2.setValue(str);
            getRootNode().hasNodes();
            getRootNode().insertNode(node2, 1);
        }
    }

    private void setUUID(String str) {
        this.devUUID = str;
    }

    private void soapActionRecieved(HTTPRequest hTTPRequest) {
        Service serviceByControlURL = getServiceByControlURL(hTTPRequest.getURI());
        if (serviceByControlURL != null) {
            deviceControlRequestRecieved(new ActionRequest(hTTPRequest), serviceByControlURL);
        } else {
            soapBadActionRecieved(hTTPRequest);
        }
    }

    private void soapBadActionRecieved(HTTPRequest hTTPRequest) {
        SOAPResponse sOAPResponse = new SOAPResponse();
        sOAPResponse.setStatusCode(400);
        hTTPRequest.post(sOAPResponse);
    }

    private boolean stop(boolean z10) {
        if (z10) {
            try {
                byebye();
            } catch (Exception e10) {
                CLog.w(TAG, (Throwable) e10);
            }
        }
        HTTPServerList hTTPServerList = getHTTPServerList();
        hTTPServerList.stop();
        hTTPServerList.close();
        hTTPServerList.clear();
        SSDPSearchSocketList sSDPSearchSocketList = getSSDPSearchSocketList();
        sSDPSearchSocketList.stop();
        sSDPSearchSocketList.close();
        sSDPSearchSocketList.clear();
        Advertiser advertiser = getAdvertiser();
        if (advertiser != null) {
            advertiser.stop();
            setAdvertiser((Advertiser) null);
        }
        return true;
    }

    private void updateBootId() {
        this.bootId = UPnP.createBootId();
    }

    private void updateConfigId(Device device) {
        DeviceList deviceList = device.getDeviceList();
        int size = deviceList.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            Device device2 = deviceList.getDevice(i11);
            updateConfigId(device2);
            i10 = (i10 + device2.getConfigId()) & UPnP.CONFIGID_UPNP_ORG_MAX;
        }
        ServiceList serviceList = device.getServiceList();
        int size2 = serviceList.size();
        for (int i12 = 0; i12 < size2; i12++) {
            Service service = serviceList.getService(i12);
            service.updateConfigId();
            i10 = (i10 + service.getConfigId()) & UPnP.CONFIGID_UPNP_ORG_MAX;
        }
        Node deviceNode2 = getDeviceNode();
        if (deviceNode2 != null) {
            deviceNode2.setAttribute(CONFIG_ID, (i10 + UPnP.caluculateConfigId(deviceNode2.toString())) & UPnP.CONFIGID_UPNP_ORG_MAX);
        }
    }

    private void updateUDN() {
        setUDN(Subscription.UUID + getUUID());
    }

    private void updateURLBase(String str) {
        setURLBase(HostInterface.getHostURL(str, getHTTPPort(), ""));
    }

    private void upnpBadSubscriptionRecieved(SubscriptionRequest subscriptionRequest, int i10) {
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.setErrorResponse(i10);
        subscriptionRequest.post(subscriptionResponse);
    }

    public void addDevice(Device device) {
        Node node = getDeviceNode().getNode(DeviceList.ELEM_NAME);
        if (node == null) {
            node = new Node(DeviceList.ELEM_NAME);
            getDeviceNode().addNode(node);
        }
        node.addNode(device.getDeviceNode());
        device.setRootNode((Node) null);
        if (getRootNode() == null) {
            Node node2 = new Node(RootDescription.ROOT_ELEMENT);
            node2.setNameSpace("", RootDescription.ROOT_ELEMENT_NAMESPACE);
            Node node3 = new Node("specVersion");
            Node node4 = new Node("major");
            node4.setValue("1");
            Node node5 = new Node("minor");
            node5.setValue("0");
            node3.addNode(node4);
            node3.addNode(node5);
            node2.addNode(node3);
            setRootNode(node2);
        }
    }

    public boolean addIcon(Icon icon) {
        Node deviceNode2 = getDeviceNode();
        if (deviceNode2 == null) {
            return false;
        }
        Node node = deviceNode2.getNode(IconList.ELEM_NAME);
        if (node == null) {
            node = new Node(IconList.ELEM_NAME);
            deviceNode2.addNode(node);
        }
        Node node2 = new Node(Icon.ELEM_NAME);
        if (icon.getIconNode() != null) {
            node2.set(icon.getIconNode());
        }
        node.addNode(node2);
        if (!icon.hasURL() || !icon.hasBytes()) {
            return true;
        }
        this.iconBytesMap.put(icon.getURL(), icon.getBytes());
        return true;
    }

    public void addService(Service service) {
        Node node = getDeviceNode().getNode("serviceList");
        if (node == null) {
            node = new Node("serviceList");
            getDeviceNode().addNode(node);
        }
        node.addNode(service.getServiceNode());
    }

    public void announce(String str) {
        String locationURL = getLocationURL(str);
        SSDPNotifySocket sSDPNotifySocket = new SSDPNotifySocket(str);
        SSDPNotifyRequest sSDPNotifyRequest = new SSDPNotifyRequest();
        sSDPNotifyRequest.setServer(UPnP.getServerName());
        sSDPNotifyRequest.setLeaseTime(getLeaseTime());
        sSDPNotifyRequest.setLocation(locationURL);
        sSDPNotifyRequest.setNTS(NTS.ALIVE);
        sSDPNotifyRequest.setBootId(getBootId());
        if (isRootDevice()) {
            String notifyDeviceNT = getNotifyDeviceNT();
            String notifyDeviceUSN = getNotifyDeviceUSN();
            sSDPNotifyRequest.setNT(notifyDeviceNT);
            sSDPNotifyRequest.setUSN(notifyDeviceUSN);
            sSDPNotifySocket.post(sSDPNotifyRequest);
            String udn = getUDN();
            sSDPNotifyRequest.setNT(udn);
            sSDPNotifyRequest.setUSN(udn);
            sSDPNotifySocket.post(sSDPNotifyRequest);
        }
        String notifyDeviceTypeNT = getNotifyDeviceTypeNT();
        String notifyDeviceTypeUSN = getNotifyDeviceTypeUSN();
        sSDPNotifyRequest.setNT(notifyDeviceTypeNT);
        sSDPNotifyRequest.setUSN(notifyDeviceTypeUSN);
        sSDPNotifySocket.post(sSDPNotifyRequest);
        sSDPNotifySocket.close();
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            serviceList.getService(i10).announce(str);
        }
        DeviceList deviceList = getDeviceList();
        int size2 = deviceList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            deviceList.getDevice(i11).announce(str);
        }
    }

    public void byebye(String str) {
        SSDPNotifySocket sSDPNotifySocket = new SSDPNotifySocket(str);
        SSDPNotifyRequest sSDPNotifyRequest = new SSDPNotifyRequest();
        sSDPNotifyRequest.setNTS(NTS.BYEBYE);
        if (isRootDevice()) {
            String notifyDeviceNT = getNotifyDeviceNT();
            String notifyDeviceUSN = getNotifyDeviceUSN();
            sSDPNotifyRequest.setNT(notifyDeviceNT);
            sSDPNotifyRequest.setUSN(notifyDeviceUSN);
            sSDPNotifySocket.post(sSDPNotifyRequest);
        }
        String notifyDeviceTypeNT = getNotifyDeviceTypeNT();
        String notifyDeviceTypeUSN = getNotifyDeviceTypeUSN();
        sSDPNotifyRequest.setNT(notifyDeviceTypeNT);
        sSDPNotifyRequest.setUSN(notifyDeviceTypeUSN);
        sSDPNotifySocket.post(sSDPNotifyRequest);
        sSDPNotifySocket.close();
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            serviceList.getService(i10).byebye(str);
        }
        DeviceList deviceList = getDeviceList();
        int size2 = deviceList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            deviceList.getDevice(i11).byebye(str);
        }
    }

    public void deviceSearchReceived(SSDPPacket sSDPPacket) {
        deviceSearchResponse(sSDPPacket);
    }

    public void deviceSearchResponse(SSDPPacket sSDPPacket) {
        int i10;
        String st = sSDPPacket.getST();
        if (st != null) {
            boolean isRootDevice = isRootDevice();
            String udn = getUDN();
            if (isRootDevice) {
                udn = udn + "::upnp:rootdevice";
            }
            if (ST.isAllDevice(st)) {
                String notifyDeviceNT = getNotifyDeviceNT();
                if (isRootDevice) {
                    i10 = 3;
                } else {
                    i10 = 2;
                }
                for (int i11 = 0; i11 < i10; i11++) {
                    postSearchResponse(sSDPPacket, notifyDeviceNT, udn);
                }
            } else if (ST.isRootDevice(st)) {
                if (isRootDevice) {
                    postSearchResponse(sSDPPacket, "upnp:rootdevice", udn);
                }
            } else if (ST.isUUIDDevice(st)) {
                String udn2 = getUDN();
                if (st.equals(udn2)) {
                    postSearchResponse(sSDPPacket, udn2, udn);
                }
            } else if (ST.isURNDevice(st)) {
                String deviceType = getDeviceType();
                if (st.equals(deviceType)) {
                    postSearchResponse(sSDPPacket, deviceType, getUDN() + "::" + deviceType);
                }
            }
            ServiceList serviceList = getServiceList();
            int size = serviceList.size();
            for (int i12 = 0; i12 < size; i12++) {
                serviceList.getService(i12).serviceSearchResponse(sSDPPacket);
            }
            DeviceList deviceList = getDeviceList();
            int size2 = deviceList.size();
            for (int i13 = 0; i13 < size2; i13++) {
                deviceList.getDevice(i13).deviceSearchResponse(sSDPPacket);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getAbsoluteURL(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0178
            int r0 = r7.length()
            if (r0 > 0) goto L_0x000a
            goto L_0x0178
        L_0x000a:
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0014 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x0014 }
            return r7
        L_0x0014:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r1 = "/"
            if (r0 != 0) goto L_0x0023
            boolean r0 = android.text.TextUtils.equals(r9, r8)
            if (r0 != 0) goto L_0x011e
        L_0x0023:
            if (r9 == 0) goto L_0x011e
            int r0 = r9.length()
            if (r0 <= 0) goto L_0x011e
            boolean r0 = r9.endsWith(r1)
            java.lang.String r2 = "FAILED URL "
            java.lang.String r3 = "LB-Device"
            java.lang.String r4 = ":"
            java.lang.String r5 = "http://"
            if (r0 == 0) goto L_0x008d
            boolean r0 = r7.startsWith(r1)
            if (r0 != 0) goto L_0x0040
            goto L_0x008d
        L_0x0040:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = com.hpplay.cybergarage.http.HTTP.getHost(r9)
            r0.append(r5)
            r0.append(r4)
            int r4 = com.hpplay.cybergarage.http.HTTP.getPort(r9)
            r0.append(r4)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x006a }
            r4.<init>(r0)     // Catch:{ Exception -> 0x006a }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x006a }
            return r7
        L_0x006a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = "  \r\n"
            r4.append(r0)
            r4.append(r7)
            java.lang.String r0 = " \r\n  "
            r4.append(r0)
            r4.append(r9)
            java.lang.String r0 = r4.toString()
            com.hpplay.component.common.utils.CLog.i(r3, r0)
            goto L_0x00f9
        L_0x008d:
            boolean r0 = r9.endsWith(r1)
            if (r0 != 0) goto L_0x00bd
            boolean r0 = r7.startsWith(r1)
            if (r0 != 0) goto L_0x00bd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = com.hpplay.cybergarage.http.HTTP.getHost(r9)
            r0.append(r5)
            r0.append(r4)
            int r4 = com.hpplay.cybergarage.http.HTTP.getPort(r9)
            r0.append(r4)
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            goto L_0x00dd
        L_0x00bd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = com.hpplay.cybergarage.http.HTTP.getHost(r9)
            r0.append(r5)
            r0.append(r4)
            int r4 = com.hpplay.cybergarage.http.HTTP.getPort(r9)
            r0.append(r4)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
        L_0x00dd:
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x00e7 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x00e7 }
            return r7
        L_0x00e7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.hpplay.component.common.utils.CLog.i(r3, r0)
        L_0x00f9:
            java.lang.String r9 = com.hpplay.cybergarage.http.HTTP.getAbsoluteURL(r9, r7)
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0107 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x0107 }
            return r7
        L_0x0107:
            com.hpplay.cybergarage.upnp.Device r9 = r6.getRootDevice()
            if (r9 == 0) goto L_0x011e
            java.lang.String r8 = r9.getLocation()
            java.lang.String r9 = com.hpplay.cybergarage.http.HTTP.getHost(r8)
            int r8 = com.hpplay.cybergarage.http.HTTP.getPort(r8)
            java.lang.String r8 = com.hpplay.cybergarage.http.HTTP.getRequestHostURL(r9, r8)
        L_0x011e:
            if (r8 == 0) goto L_0x0177
            int r9 = r8.length()
            if (r9 <= 0) goto L_0x0177
            boolean r9 = r8.endsWith(r1)
            if (r9 == 0) goto L_0x0151
            boolean r9 = r7.startsWith(r1)
            if (r9 != 0) goto L_0x0133
            goto L_0x0151
        L_0x0133:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            r0 = 1
            java.lang.String r0 = r7.substring(r0)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x016a }
            r0.<init>(r9)     // Catch:{ Exception -> 0x016a }
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x016a }
            return r7
        L_0x0151:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x016a }
            r0.<init>(r9)     // Catch:{ Exception -> 0x016a }
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x016a }
            return r7
        L_0x016a:
            java.lang.String r8 = com.hpplay.cybergarage.http.HTTP.getAbsoluteURL(r8, r7)
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x0177 }
            r9.<init>(r8)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x0177 }
        L_0x0177:
            return r7
        L_0x0178:
            java.lang.String r7 = ""
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.cybergarage.upnp.Device.getAbsoluteURL(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public Action getAction(String str) {
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ActionList actionList = serviceList.getService(i10).getActionList();
            int size2 = actionList.size();
            for (int i11 = 0; i11 < size2; i11++) {
                Action action = actionList.getAction(i11);
                String name = action.getName();
                if (name != null && name.equals(str)) {
                    return action;
                }
            }
        }
        DeviceList deviceList = getDeviceList();
        int size3 = deviceList.size();
        for (int i12 = 0; i12 < size3; i12++) {
            Action action2 = deviceList.getDevice(i12).getAction(str);
            if (action2 != null) {
                return action2;
            }
        }
        return null;
    }

    public int getBootId() {
        return this.bootId;
    }

    public int getConfigId() {
        Node deviceNode2 = getDeviceNode();
        if (deviceNode2 == null) {
            return 0;
        }
        return deviceNode2.getAttributeIntegerValue(CONFIG_ID);
    }

    public String getDesc() {
        Node node = this.rootNode;
        if (node != null) {
            return node.toString();
        }
        Node node2 = this.deviceNode;
        if (node2 != null) {
            return node2.toString();
        }
        return null;
    }

    public File getDescriptionFile() {
        return getDeviceData().getDescriptionFile();
    }

    public String getDescriptionFilePath() {
        File descriptionFile = getDescriptionFile();
        if (descriptionFile == null) {
            return "";
        }
        return descriptionFile.getAbsoluteFile().getParent();
    }

    public Device getDevice(String str) {
        DeviceList deviceList = getDeviceList();
        int size = deviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Device device = deviceList.getDevice(i10);
            if (device.isDevice(str)) {
                return device;
            }
            Device device2 = device.getDevice(str);
            if (device2 != null) {
                return device2;
            }
        }
        return null;
    }

    public Device getDeviceByDescriptionURI(String str) {
        DeviceList deviceList = getDeviceList();
        int size = deviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Device device = deviceList.getDevice(i10);
            if (device.isDescriptionURI(str)) {
                return device;
            }
            Device deviceByDescriptionURI = device.getDeviceByDescriptionURI(str);
            if (deviceByDescriptionURI != null) {
                return deviceByDescriptionURI;
            }
        }
        return null;
    }

    public DeviceList getDeviceList() {
        DeviceList deviceList = new DeviceList();
        Node node = getDeviceNode().getNode(DeviceList.ELEM_NAME);
        if (node == null) {
            return deviceList;
        }
        int nNodes = node.getNNodes();
        for (int i10 = 0; i10 < nNodes; i10++) {
            Node node2 = node.getNode(i10);
            if (isDeviceNode(node2)) {
                deviceList.add(new Device(node2));
            }
        }
        return deviceList;
    }

    public Node getDeviceNode() {
        return this.deviceNode;
    }

    public String getDeviceType() {
        return getDeviceNode().getNodeValue(DEVICE_TYPE);
    }

    public String getDrainage() {
        String opt = getOpt();
        if (TextUtils.isEmpty(opt)) {
            return null;
        }
        try {
            int indexOf = opt.indexOf("ds=");
            if (indexOf < 0) {
                return null;
            }
            String substring = opt.substring(indexOf + 3);
            if (TextUtils.isDigitsOnly(substring)) {
                return substring;
            }
            return substring.substring(0, substring.indexOf(";"));
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public long getElapsedTime() {
        return (System.currentTimeMillis() - getTimeStamp()) / 1000;
    }

    public String getFriendlyName() {
        return getDeviceNode().getNodeValue(FRIENDLY_NAME);
    }

    public InetAddress[] getHTTPBindAddress() {
        return getDeviceData().getHTTPBindAddress();
    }

    public int getHTTPPort() {
        return getDeviceData().getHTTPPort();
    }

    public Icon getIcon(int i10) {
        IconList iconList = getIconList();
        if (i10 >= 0 || iconList.size() - 1 >= i10) {
            return iconList.getIcon(i10);
        }
        return null;
    }

    public Icon getIconByURI(String str) {
        IconList iconList = getIconList();
        if (iconList.size() <= 0) {
            return null;
        }
        int size = iconList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Icon icon = iconList.getIcon(i10);
            if (icon.isURL(str)) {
                return icon;
            }
        }
        return null;
    }

    public IconList getIconList() {
        byte[] bArr;
        IconList iconList = new IconList();
        Node node = getDeviceNode().getNode(IconList.ELEM_NAME);
        if (node == null) {
            return iconList;
        }
        int nNodes = node.getNNodes();
        for (int i10 = 0; i10 < nNodes; i10++) {
            Node node2 = node.getNode(i10);
            if (Icon.isIconNode(node2)) {
                Icon icon = new Icon(node2);
                if (icon.hasURL() && (bArr = this.iconBytesMap.get(icon.getURL())) != null) {
                    icon.setBytes(bArr);
                }
                iconList.add(icon);
            }
        }
        return iconList;
    }

    public String getInterfaceAddress() {
        SSDPPacket sSDPPacket = getSSDPPacket();
        if (sSDPPacket == null) {
            return "";
        }
        return sSDPPacket.getLocalAddress();
    }

    public int getLeaseTime() {
        SSDPPacket sSDPPacket = getSSDPPacket();
        if (sSDPPacket != null) {
            return sSDPPacket.getLeaseTime();
        }
        return getDeviceData().getLeaseTime();
    }

    public String getLocation() {
        SSDPPacket sSDPPacket = getSSDPPacket();
        if (sSDPPacket != null) {
            return sSDPPacket.getLocation();
        }
        return getDeviceData().getLocation();
    }

    public String getLocationURL(String str) {
        return HostInterface.getHostURL(str, getHTTPPort(), getDescriptionURI());
    }

    public String getManufacture() {
        return getDeviceNode().getNodeValue("manufacturer");
    }

    public String getManufactureURL() {
        return getDeviceNode().getNodeValue(MANUFACTURE_URL);
    }

    public String getModelDescription() {
        return getDeviceNode().getNodeValue(MODEL_DESCRIPTION);
    }

    public String getModelName() {
        return getDeviceNode().getNodeValue(MODEL_NAME);
    }

    public String getModelNumber() {
        return getDeviceNode().getNodeValue(MODEL_NUMBER);
    }

    public String getModelURL() {
        return getDeviceNode().getNodeValue(MODEL_URL);
    }

    public String getMulticastIPv4Address() {
        return getDeviceData().getMulticastIPv4Address();
    }

    public String getMulticastIPv6Address() {
        return getDeviceData().getMulticastIPv6Address();
    }

    public String getOpt() {
        SSDPPacket sSDPPacket = getSSDPPacket();
        if (sSDPPacket != null) {
            return sSDPPacket.getOpt();
        }
        return null;
    }

    public Device getParentDevice() {
        if (isRootDevice()) {
            return null;
        }
        return new Device(getDeviceNode().getParentNode().getParentNode());
    }

    public PresentationListener getPresentationListener() {
        return this.presentationListener;
    }

    public String getPresentationURL() {
        return getDeviceNode().getNodeValue(presentationURL);
    }

    public Device getRootDevice() {
        Node node;
        Node rootNode2 = getRootNode();
        if (rootNode2 == null || (node = rootNode2.getNode((String) ELEM_NAME)) == null) {
            return null;
        }
        return new Device(rootNode2, node);
    }

    public Node getRootNode() {
        Node node = this.rootNode;
        if (node != null) {
            return node;
        }
        Node node2 = this.deviceNode;
        if (node2 == null) {
            return null;
        }
        return node2.getRootNode();
    }

    public int getSSDPAnnounceCount() {
        if (isNMPRMode() && isWirelessMode()) {
            return 4;
        }
        return 1;
    }

    public InetAddress[] getSSDPBindAddress() {
        return getDeviceData().getSSDPBindAddress();
    }

    public String getSSDPIPv4MulticastAddress() {
        return getDeviceData().getMulticastIPv4Address();
    }

    public String getSSDPIPv6MulticastAddress() {
        return getDeviceData().getMulticastIPv6Address();
    }

    public SSDPPacket getSSDPPacket() {
        if (!isRootDevice()) {
            return null;
        }
        return getDeviceData().getSSDPPacket();
    }

    public int getSSDPPort() {
        return getDeviceData().getSSDPPort();
    }

    public String getSerialNumber() {
        return getDeviceNode().getNodeValue(SERIAL_NUMBER);
    }

    public Service getService(String str) {
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Service service = serviceList.getService(i10);
            if (service.isService(str)) {
                return service;
            }
        }
        DeviceList deviceList = getDeviceList();
        int size2 = deviceList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Service service2 = deviceList.getDevice(i11).getService(str);
            if (service2 != null) {
                return service2;
            }
        }
        return null;
    }

    public Service getServiceByControlURL(String str) {
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Service service = serviceList.getService(i10);
            if (service.isControlURL(str)) {
                return service;
            }
        }
        DeviceList deviceList = getDeviceList();
        int size2 = deviceList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Service serviceByControlURL = deviceList.getDevice(i11).getServiceByControlURL(str);
            if (serviceByControlURL != null) {
                return serviceByControlURL;
            }
        }
        return null;
    }

    public Service getServiceByEventSubURL(String str) {
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Service service = serviceList.getService(i10);
            if (service.isEventSubURL(str)) {
                return service;
            }
        }
        DeviceList deviceList = getDeviceList();
        int size2 = deviceList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Service serviceByEventSubURL = deviceList.getDevice(i11).getServiceByEventSubURL(str);
            if (serviceByEventSubURL != null) {
                return serviceByEventSubURL;
            }
        }
        return null;
    }

    public Service getServiceBySCPDURL(String str) {
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Service service = serviceList.getService(i10);
            if (service.isSCPDURL(str)) {
                return service;
            }
        }
        DeviceList deviceList = getDeviceList();
        int size2 = deviceList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Service serviceBySCPDURL = deviceList.getDevice(i11).getServiceBySCPDURL(str);
            if (serviceBySCPDURL != null) {
                return serviceBySCPDURL;
            }
        }
        return null;
    }

    public ServiceList getServiceList() {
        ServiceList serviceList = new ServiceList();
        Node node = getDeviceNode().getNode("serviceList");
        if (node == null) {
            return serviceList;
        }
        int nNodes = node.getNNodes();
        for (int i10 = 0; i10 < nNodes; i10++) {
            Node node2 = node.getNode(i10);
            if (Service.isServiceNode(node2)) {
                serviceList.add(new Service(node2));
            }
        }
        return serviceList;
    }

    public Icon getSmallestIcon() {
        IconList iconList = getIconList();
        int size = iconList.size();
        Icon icon = null;
        for (int i10 = 0; i10 < size; i10++) {
            Icon icon2 = iconList.getIcon(i10);
            if (icon == null || icon2.getWidth() < icon.getWidth()) {
                icon = icon2;
            }
        }
        return icon;
    }

    public StateVariable getStateVariable(String str, String str2) {
        StateVariable stateVariable;
        if (str == null && str2 == null) {
            return null;
        }
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Service service = serviceList.getService(i10);
            if ((str == null || service.getServiceType().equals(str)) && (stateVariable = service.getStateVariable(str2)) != null) {
                return stateVariable;
            }
        }
        DeviceList deviceList = getDeviceList();
        int size2 = deviceList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            StateVariable stateVariable2 = deviceList.getDevice(i11).getStateVariable(str, str2);
            if (stateVariable2 != null) {
                return stateVariable2;
            }
        }
        return null;
    }

    public Service getSubscriberService(String str) {
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Service service = serviceList.getService(i10);
            if (str.equals(service.getSID())) {
                return service;
            }
        }
        DeviceList deviceList = getDeviceList();
        int size2 = deviceList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Service subscriberService = deviceList.getDevice(i11).getSubscriberService(str);
            if (subscriberService != null) {
                return subscriberService;
            }
        }
        return null;
    }

    public long getTimeStamp() {
        SSDPPacket sSDPPacket = getSSDPPacket();
        if (sSDPPacket != null) {
            return sSDPPacket.getTimeStamp();
        }
        return 0;
    }

    public String getUDN() {
        return getDeviceNode().getNodeValue(UDN);
    }

    public String getUPC() {
        return getDeviceNode().getNodeValue(UPC);
    }

    public String getURLBase() {
        if (isRootDevice()) {
            return getRootNode().getNodeValue(URLBASE_NAME);
        }
        return "";
    }

    public String getUUID() {
        return this.devUUID;
    }

    public String getUid() {
        return getDeviceNode().getNodeValue(UID);
    }

    public Object getUserData() {
        return this.userData;
    }

    public boolean hasPresentationListener() {
        if (this.presentationListener != null) {
            return true;
        }
        return false;
    }

    public boolean hasUDN() {
        String udn = getUDN();
        if (udn == null || udn.length() <= 0) {
            return false;
        }
        return true;
    }

    public boolean hasUid() {
        String uid = getUid();
        if (uid == null || uid.length() <= 0) {
            return false;
        }
        return true;
    }

    public void httpRequestRecieved(HTTPRequest hTTPRequest) {
        hTTPRequest.print();
        CLog.i("httpRequestRecieved", " httpReq " + hTTPRequest.toString() + "  host " + hTTPRequest.getRequestHost());
        if (hasPresentationListener() && isPresentationRequest(hTTPRequest)) {
            getPresentationListener().httpRequestRecieved(hTTPRequest);
        } else if (hTTPRequest.isGetRequest() || hTTPRequest.isHeadRequest()) {
            httpGetRequestRecieved(hTTPRequest);
        } else if (hTTPRequest.isPostRequest()) {
            httpPostRequestRecieved(hTTPRequest);
        } else if (hTTPRequest.isSubscribeRequest() || hTTPRequest.isUnsubscribeRequest()) {
            deviceEventSubscriptionRecieved(new SubscriptionRequest(hTTPRequest));
        } else {
            hTTPRequest.returnBadRequest();
        }
    }

    public boolean isDevice(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith(getUDN()) || str.equals(getFriendlyName()) || str.endsWith(getDeviceType())) {
            return true;
        }
        return false;
    }

    public boolean isDeviceType(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(getDeviceType());
    }

    public boolean isExpired() {
        if (((long) (getLeaseTime() + 60)) < getElapsedTime()) {
            return true;
        }
        return false;
    }

    public boolean isIconBytesURI(String str) {
        if (this.iconBytesMap.get(str) != null) {
            return true;
        }
        Icon iconByURI = getIconByURI(str);
        if (iconByURI != null) {
            return iconByURI.hasBytes();
        }
        return false;
    }

    public boolean isNMPRMode() {
        Node deviceNode2 = getDeviceNode();
        if (deviceNode2 == null || deviceNode2.getNode(UPnP.INMPR03) == null) {
            return false;
        }
        return true;
    }

    public boolean isRootDevice() {
        return getRootNode().getNode(ELEM_NAME).getNodeValue(UDN).equals(getUDN());
    }

    public boolean isRunning() {
        if (getAdvertiser() != null) {
            return true;
        }
        return false;
    }

    public boolean isWirelessMode() {
        return this.wirelessMode;
    }

    public boolean loadDescription(InputStream inputStream) {
        try {
            Node parse = UPnP.getXMLParser().parse(inputStream);
            this.rootNode = parse;
            if (parse != null) {
                Node node = parse.getNode(ELEM_NAME);
                this.deviceNode = node;
                if (node != null) {
                    initializeLoadedDescription();
                    setDescriptionFile((File) null);
                    return true;
                }
                throw new InvalidDescriptionException(Description.NOROOTDEVICE_EXCEPTION);
            }
            throw new InvalidDescriptionException(Description.NOROOT_EXCEPTION);
        } catch (Exception e10) {
            throw new InvalidDescriptionException(e10);
        }
    }

    public void lock() {
        this.mutex.lock();
    }

    public boolean postSearchResponse(SSDPPacket sSDPPacket, String str, String str2) {
        try {
            String locationURL = getRootDevice().getLocationURL(sSDPPacket.getLocalAddress());
            SSDPSearchResponse sSDPSearchResponse = new SSDPSearchResponse();
            sSDPSearchResponse.setLeaseTime(getLeaseTime());
            sSDPSearchResponse.setDate(cal);
            sSDPSearchResponse.setST(str);
            sSDPSearchResponse.setUSN(str2);
            sSDPSearchResponse.setLocation(locationURL);
            sSDPSearchResponse.setBootId(getBootId());
            sSDPSearchResponse.setMYNAME(getFriendlyName());
            TimerUtil.waitRandom(sSDPPacket.getMX() * 1000);
            String remoteAddress = sSDPPacket.getRemoteAddress();
            int remotePort = sSDPPacket.getRemotePort();
            SSDPSearchResponseSocket sSDPSearchResponseSocket = new SSDPSearchResponseSocket();
            sSDPSearchResponse.print();
            int sSDPAnnounceCount = getSSDPAnnounceCount();
            for (int i10 = 0; i10 < sSDPAnnounceCount; i10++) {
                sSDPSearchResponseSocket.post(remoteAddress, remotePort, sSDPSearchResponse);
            }
            return true;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public boolean removePresentationURL() {
        return getDeviceNode().removeNode(presentationURL);
    }

    public void setActionListener(ActionListener actionListener) {
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            serviceList.getService(i10).setActionListener(actionListener);
        }
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setDeviceNode(Node node) {
        this.deviceNode = node;
    }

    public void setDeviceType(String str) {
        getDeviceNode().setNode(DEVICE_TYPE, str);
    }

    public void setFriendlyName(String str) {
        getDeviceNode().setNode(FRIENDLY_NAME, str);
    }

    public void setHTTPBindAddress(InetAddress[] inetAddressArr) {
        getDeviceData().setHTTPBindAddress(inetAddressArr);
    }

    public void setHTTPPort(int i10) {
        getDeviceData().setHTTPPort(i10);
    }

    public void setLeaseTime(int i10) {
        getDeviceData().setLeaseTime(i10);
        Advertiser advertiser = getAdvertiser();
        if (advertiser != null) {
            announce();
            advertiser.restart();
        }
    }

    public void setLocation(String str) {
        getDeviceData().setLocation(str);
    }

    public void setManufacture(String str) {
        getDeviceNode().setNode("manufacturer", str);
    }

    public void setManufactureURL(String str) {
        getDeviceNode().setNode(MANUFACTURE_URL, str);
    }

    public void setModelDescription(String str) {
        getDeviceNode().setNode(MODEL_DESCRIPTION, str);
    }

    public void setModelName(String str) {
        getDeviceNode().setNode(MODEL_NAME, str);
    }

    public void setModelNumber(String str) {
        getDeviceNode().setNode(MODEL_NUMBER, str);
    }

    public void setModelURL(String str) {
        getDeviceNode().setNode(MODEL_URL, str);
    }

    public void setMulticastIPv4Address(String str) {
        getDeviceData().setMulticastIPv4Address(str);
    }

    public void setMulticastIPv6Address(String str) {
        getDeviceData().setMulticastIPv6Address(str);
    }

    public void setNMPRMode(boolean z10) {
        Node deviceNode2 = getDeviceNode();
        if (deviceNode2 != null) {
            if (z10) {
                deviceNode2.setNode(UPnP.INMPR03, "1.0");
                deviceNode2.removeNode(URLBASE_NAME);
                return;
            }
            deviceNode2.removeNode(UPnP.INMPR03);
        }
    }

    public void setPresentationListener(PresentationListener presentationListener2) {
        this.presentationListener = presentationListener2;
        if (presentationListener2 != null) {
            setPresentationURL(DEFAULT_PRESENTATION_URI);
        } else {
            removePresentationURL();
        }
    }

    public void setPresentationURL(String str) {
        getDeviceNode().setNode(presentationURL, str);
    }

    public void setQueryListener(QueryListener queryListener) {
        ServiceList serviceList = getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            serviceList.getService(i10).setQueryListener(queryListener);
        }
    }

    public void setRootNode(Node node) {
        this.rootNode = node;
    }

    public void setSSDPBindAddress(InetAddress[] inetAddressArr) {
        getDeviceData().setSSDPBindAddress(inetAddressArr);
    }

    public void setSSDPPacket(SSDPPacket sSDPPacket) {
        getDeviceData().setSSDPPacket(sSDPPacket);
    }

    public void setSSDPPort(int i10) {
        getDeviceData().setSSDPPort(i10);
    }

    public void setSerialNumber(String str) {
        getDeviceNode().setNode(SERIAL_NUMBER, str);
    }

    public void setUDN(String str) {
        getDeviceNode().setNode(UDN, str);
    }

    public void setUPC(String str) {
        getDeviceNode().setNode(UPC, str);
    }

    public void setUid(String str) {
        getDeviceNode().setNode(UID, str);
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public void setWirelessMode(boolean z10) {
        this.wirelessMode = z10;
    }

    public boolean start() {
        UPnP.setEnable(9);
        stop(true);
        int hTTPPort = getHTTPPort();
        HTTPServerList hTTPServerList = getHTTPServerList();
        int i10 = 0;
        while (!hTTPServerList.open(hTTPPort)) {
            i10++;
            if (100 < i10) {
                return false;
            }
            setHTTPPort(hTTPPort + 1);
            hTTPPort = getHTTPPort();
        }
        hTTPServerList.addRequestListener(this);
        hTTPServerList.start();
        SSDPSearchSocketList sSDPSearchSocketList = getSSDPSearchSocketList();
        if (!sSDPSearchSocketList.open()) {
            return false;
        }
        sSDPSearchSocketList.addSearchListener(this);
        sSDPSearchSocketList.start();
        updateBootId();
        updateConfigId();
        announce();
        Advertiser advertiser = new Advertiser(this);
        setAdvertiser(advertiser);
        advertiser.start();
        return true;
    }

    public void unlock() {
        this.mutex.unlock();
    }

    public void getSSDPIPv4MulticastAddress(String str) {
        getDeviceData().setMulticastIPv4Address(str);
    }

    public void getSSDPIPv6MulticastAddress(String str) {
        getDeviceData().setMulticastIPv6Address(str);
    }

    public void setActionListener(ActionListener actionListener, boolean z10) {
        setActionListener(actionListener);
        if (z10) {
            DeviceList deviceList = getDeviceList();
            int size = deviceList.size();
            for (int i10 = 0; i10 < size; i10++) {
                deviceList.getDevice(i10).setActionListener(actionListener, true);
            }
        }
    }

    public void setQueryListener(QueryListener queryListener, boolean z10) {
        setQueryListener(queryListener);
        if (z10) {
            DeviceList deviceList = getDeviceList();
            int size = deviceList.size();
            for (int i10 = 0; i10 < size; i10++) {
                deviceList.getDevice(i10).setQueryListener(queryListener, true);
            }
        }
    }

    public Device() {
        this((Node) null, (Node) null);
    }

    public boolean loadDescription(String str) {
        try {
            Node parse = UPnP.getXMLParser().parse(str);
            this.rootNode = parse;
            if (parse != null) {
                Node node = parse.getNode(ELEM_NAME);
                this.deviceNode = node;
                if (node != null) {
                    initializeLoadedDescription();
                    setDescriptionFile((File) null);
                    return true;
                }
                throw new InvalidDescriptionException(Description.NOROOTDEVICE_EXCEPTION);
            }
            throw new InvalidDescriptionException(Description.NOROOT_EXCEPTION);
        } catch (Exception e10) {
            throw new InvalidDescriptionException(e10);
        }
    }

    public Device(Node node) {
        this((Node) null, node);
    }

    public StateVariable getStateVariable(String str) {
        return getStateVariable((String) null, str);
    }

    public Device(File file) {
        this((Node) null, (Node) null);
        loadDescription(file);
    }

    public Device(InputStream inputStream) {
        this((Node) null, (Node) null);
        loadDescription(inputStream);
    }

    public boolean stop() {
        return stop(true);
    }

    public Device(String str) {
        this(new File(str));
    }

    public void updateConfigId() {
        updateConfigId(this);
    }

    public boolean loadDescription(File file) {
        try {
            Node parse = UPnP.getXMLParser().parse(file);
            this.rootNode = parse;
            if (parse != null) {
                Node node = parse.getNode(ELEM_NAME);
                this.deviceNode = node;
                if (node != null) {
                    initializeLoadedDescription();
                    setDescriptionFile(file);
                    return true;
                }
                throw new InvalidDescriptionException(Description.NOROOTDEVICE_EXCEPTION, file);
            }
            throw new InvalidDescriptionException(Description.NOROOT_EXCEPTION, file);
        } catch (Exception e10) {
            throw new InvalidDescriptionException(e10);
        }
    }

    public void byebye() {
        String[] strArr;
        InetAddress[] hTTPBindAddress = getDeviceData().getHTTPBindAddress();
        if (hTTPBindAddress != null) {
            strArr = new String[hTTPBindAddress.length];
            for (int i10 = 0; i10 < hTTPBindAddress.length; i10++) {
                strArr[i10] = hTTPBindAddress[i10].getHostAddress();
            }
        } else {
            int nHostAddresses = HostInterface.getNHostAddresses();
            strArr = new String[nHostAddresses];
            for (int i11 = 0; i11 < nHostAddresses; i11++) {
                strArr[i11] = HostInterface.getHostAddress(i11);
            }
        }
        for (int i12 = 0; i12 < strArr.length; i12++) {
            String str = strArr[i12];
            if (str != null && str.length() > 0) {
                int sSDPAnnounceCount = getSSDPAnnounceCount();
                for (int i13 = 0; i13 < sSDPAnnounceCount; i13++) {
                    byebye(strArr[i12]);
                }
            }
        }
    }

    public void announce() {
        String[] strArr;
        notifyWait();
        InetAddress[] hTTPBindAddress = getDeviceData().getHTTPBindAddress();
        if (hTTPBindAddress != null) {
            strArr = new String[hTTPBindAddress.length];
            for (int i10 = 0; i10 < hTTPBindAddress.length; i10++) {
                strArr[i10] = hTTPBindAddress[i10].getHostAddress();
            }
        } else {
            int nHostAddresses = HostInterface.getNHostAddresses();
            strArr = new String[nHostAddresses];
            for (int i11 = 0; i11 < nHostAddresses; i11++) {
                strArr[i11] = HostInterface.getHostAddress(i11);
            }
        }
        for (int i12 = 0; i12 < strArr.length; i12++) {
            String str = strArr[i12];
            if (!(str == null || str.length() == 0)) {
                int sSDPAnnounceCount = getSSDPAnnounceCount();
                for (int i13 = 0; i13 < sSDPAnnounceCount; i13++) {
                    announce(strArr[i12]);
                }
            }
        }
    }

    public String getAbsoluteURL(String str) {
        String str2;
        String str3;
        Device rootDevice = getRootDevice();
        if (rootDevice != null) {
            str2 = rootDevice.getURLBase();
            str3 = rootDevice.getLocation();
        } else {
            str2 = null;
            str3 = null;
        }
        return getAbsoluteURL(str, str2, str3);
    }
}
