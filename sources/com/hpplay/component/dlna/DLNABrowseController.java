package com.hpplay.component.dlna;

import android.text.TextUtils;
import com.hpplay.component.adjuster.DeviceAdjuster;
import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.upnp.ControlPoint;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.upnp.Service;
import com.hpplay.cybergarage.upnp.device.DeviceChangeListener;
import com.hpplay.cybergarage.xml.Node;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;

public class DLNABrowseController {
    private static final String LELINK_NODE_KEY = "LELINKFT";
    private static final String LELINK_SERVICE_TYPE = "urn:upnp-org:serviceId:RenderingControl";
    private static final String MEDIA_RENDER = "urn:schemas-upnp-org:device:MediaRenderer:1";
    private static final String TAG = "DLNABrowseController";
    DeviceChangeListener deviceChangeListener = new DeviceChangeListener() {
        public void deviceAdded(int i10, Device device) {
            CLog.i(DLNABrowseController.TAG, "error code " + i10);
        }

        public void deviceRemoved(Device device) {
        }

        public void deviceAdded(Device device) {
            Node serviceNode;
            if (DLNABrowseController.isMediaRenderDevice(device) && !TextUtils.isEmpty(device.getLocation())) {
                DLNABrowseController.this.resolveDevice(device);
                Service service = device.getService(DLNABrowseController.LELINK_SERVICE_TYPE);
                if (service != null && (serviceNode = service.getServiceNode()) != null) {
                    Node node = serviceNode.getNode(DLNABrowseController.LELINK_NODE_KEY);
                    try {
                        if (TextUtils.isEmpty(node != null ? node.getValue() : null)) {
                            String access$200 = DLNABrowseController.this.parseLelinkInfo(device);
                            if (DLNABrowseController.this.mBrowseListener != null && !TextUtils.isEmpty(access$200)) {
                                DLNABrowseController.this.mBrowseListener.onBrowseResultCallback(2, access$200);
                            }
                        }
                    } catch (Exception e10) {
                        CLog.w(DLNABrowseController.TAG, (Throwable) e10);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public IBrowseResultListener mBrowseListener;
    private ControlPoint mControlPoint;
    private String mSsdp;

    private synchronized void getSsdp() {
        try {
            ControlPoint controlPoint = this.mControlPoint;
            if (controlPoint != null) {
                HashSet<String> ssdps = controlPoint.getSsdps();
                if (ssdps.size() > 0) {
                    Iterator<String> it = ssdps.iterator();
                    while (it.hasNext()) {
                        this.mSsdp += it.next();
                    }
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        return;
    }

    /* access modifiers changed from: private */
    public static boolean isMediaRenderDevice(Device device) {
        if (device == null || !"urn:schemas-upnp-org:device:MediaRenderer:1".equalsIgnoreCase(device.getDeviceType())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public String parseLelinkInfo(Device device) {
        String uRLBase = device.getURLBase();
        if (TextUtils.isEmpty(uRLBase)) {
            return null;
        }
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(uRLBase + "/dlna/Render/dmr_extra.xml").getElementsByTagName(LELINK_NODE_KEY).item(0).getTextContent();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void resolveDevice(Device device) {
        JSONObject jSONObject = new JSONObject();
        String uid = device.getUid();
        try {
            String location = device.getLocation();
            jSONObject.put("u", uid);
            jSONObject.put(DeviceAdjuster.KEY_DEVICE_NAME, device.getFriendlyName());
            jSONObject.put(DeviceAdjuster.KEY_DEVICE_IP, HTTP.getHost(location));
            jSONObject.put("port", HTTP.getPort(location));
            jSONObject.put("dlna_mode_desc", location);
            jSONObject.put("dlna_manufacturer", device.getManufacture());
            jSONObject.put("dlna_manufacturer_url", device.getManufactureURL());
            jSONObject.put("dlna_model_name", device.getModelName());
            jSONObject.put("dlna_model_url", device.getModelURL());
            jSONObject.put("dlna_model_description", device.getModelDescription());
            jSONObject.put("dlna_model_uuid", device.getUUID());
            jSONObject.put("udn_uuid", device.getUDN());
            if (device.getDrainage() != null) {
                jSONObject.put(BrowserInfo.KEY_DRAINAGE, device.getDrainage());
            }
            if (!(device.getSSDPPacket() == null || device.getSSDPPacket().getData() == null)) {
                jSONObject.put(BrowserInfo.KEY_SSDP_PACKET_DATA, new String(device.getSSDPPacket().getData()));
            }
            IBrowseResultListener iBrowseResultListener = this.mBrowseListener;
            if (iBrowseResultListener != null) {
                iBrowseResultListener.onBrowseResultCallback(1, jSONObject);
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    public String getErrorMsg() {
        getSsdp();
        return this.mSsdp;
    }

    public void search() {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append("start search ");
        if (this.mControlPoint == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        CLog.i(TAG, sb.toString());
        ControlPoint controlPoint = this.mControlPoint;
        if (controlPoint != null) {
            controlPoint.search();
        }
    }

    public void setBrowseListener(IBrowseResultListener iBrowseResultListener) {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append("setBrowseListener ");
        if (iBrowseResultListener == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        CLog.i(TAG, sb.toString());
        this.mBrowseListener = iBrowseResultListener;
    }

    public void startBrowse() {
        CLog.i(TAG, "start browse");
        if (this.mControlPoint != null) {
            stopBrowse();
        }
        ControlPoint controlPoint = new ControlPoint("");
        this.mControlPoint = controlPoint;
        controlPoint.addDeviceChangeListener(this.deviceChangeListener);
        ControlPoint controlPoint2 = this.mControlPoint;
        if (controlPoint2 != null) {
            controlPoint2.start();
        }
    }

    public void stopBrowse() {
        CLog.i(TAG, "stop browse");
        ControlPoint controlPoint = this.mControlPoint;
        if (controlPoint != null) {
            controlPoint.stopSearch();
            this.mControlPoint.stop();
            getSsdp();
            this.mControlPoint = null;
        }
    }
}
