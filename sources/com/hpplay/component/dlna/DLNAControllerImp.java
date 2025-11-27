package com.hpplay.component.dlna;

import android.text.TextUtils;
import com.hpplay.component.common.dlna.IDLNAController;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.upnp.UPnP;
import com.hpplay.cybergarage.upnp.event.EventListener;
import com.hpplay.cybergarage.xml.Node;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.cybergarage.xml.parser.XmlPullParser;
import java.io.ByteArrayInputStream;

public class DLNAControllerImp implements IDLNAController {
    private static final String CMD_TAG = "LLL@BBB";
    public static final String LOADING = "loading";
    public static final String PAUSED = "PAUSED_PLAYBACK";
    public static final String PLAYING = "PLAYING";
    public static final String RESULT_FAILED = "failed";
    public static final String RESULT_SUCCESSFUL = "successful";
    public static final String STOPPED = "STOPPED";
    private static final String TAG = "DLNAControllerImp";
    private static boolean isRetryHttp;
    private final EventListener eventListener = new EventListener() {
        public void eventNotifyReceived(String str, long j10, String str2, String str3) {
            CLog.i(DLNAControllerImp.TAG, " ====================>> value:" + str2 + " uuid " + str);
            if (!TextUtils.isEmpty(str3)) {
                if (str3.contains(DLNAControllerImp.PLAYING)) {
                    if (DLNAControllerImp.this.mProtocolListener != null && !DLNAControllerImp.this.isPlaying) {
                        boolean unused = DLNAControllerImp.this.isPlaying = true;
                        DLNAControllerImp.this.mProtocolListener.onResult(13, DLNAControllerImp.this.parseUrl(str3), str, String.valueOf(DLNAControllerImp.this.instanceId));
                    }
                    CLog.i(DLNAControllerImp.TAG, " PLAYING " + DLNAControllerImp.this.instanceId);
                } else if (str3.contains(DLNAControllerImp.PAUSED)) {
                    CLog.i(DLNAControllerImp.TAG, " PAUSED ");
                    boolean unused2 = DLNAControllerImp.this.isPlaying = false;
                    if (DLNAControllerImp.this.mProtocolListener != null) {
                        DLNAControllerImp.this.mProtocolListener.onResult(15, new String[0]);
                    }
                } else if (str3.contains(DLNAControllerImp.STOPPED)) {
                    CLog.i(DLNAControllerImp.TAG, " STOPPED " + DLNAControllerImp.this.instanceId);
                    boolean unused3 = DLNAControllerImp.this.isPlaying = false;
                    if (DLNAControllerImp.this.mProtocolListener != null) {
                        DLNAControllerImp.this.mProtocolListener.onResult(16, DLNAControllerImp.this.parseUrl(str3), str, String.valueOf(DLNAControllerImp.this.instanceId));
                    }
                }
                String unused4 = DLNAControllerImp.this.mUuid = str;
            }
        }
    };
    /* access modifiers changed from: private */
    public int instanceId;
    /* access modifiers changed from: private */
    public boolean isPlaying;
    private Device mCurrentDevce;
    private String mCurrentUrl;
    private int mCurrentVolume;
    private DLNASender mDlnaSender;
    private int mMaxVolume = 100;
    /* access modifiers changed from: private */
    public ProtocolListener mProtocolListener;
    /* access modifiers changed from: private */
    public String mUuid;

    private Device getDevice(Node node) {
        Node node2;
        if (node == null || (node2 = node.getNode((String) Device.ELEM_NAME)) == null) {
            return null;
        }
        return new Device(node, node2);
    }

    private void init(String str) {
        this.mCurrentVolume = this.mDlnaSender.getVoice();
        UPNPSubscriber.getInstance().startSubscribeServ(str);
        UPNPSubscriber.getInstance().setSubscribeEventListener(this.eventListener);
        CLog.i(TAG, " subscribePlayEvent ----------- >  " + UPNPSubscriber.getInstance().subscribePlayEvent(this.mCurrentDevce));
    }

    /* access modifiers changed from: private */
    public String parseUrl(String str) {
        try {
            Node node = new XmlPullParser().parse(new ByteArrayInputStream(str.getBytes())).getNode("InstanceID").getNode("AVTransportURI");
            if (node == null) {
                return "";
            }
            String value = node.getAttribute("val").getValue();
            CLog.i(TAG, value);
            return value;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return "";
        }
    }

    public String close() {
        CLog.i(TAG, " close " + this.instanceId);
        UPNPSubscriber.getInstance().removeSubscribeEventListener(this.eventListener);
        UPNPSubscriber.getInstance().unSubscribe(this.mCurrentDevce);
        this.isPlaying = false;
        this.mDlnaSender = null;
        this.mCurrentDevce = null;
        return null;
    }

    public boolean connect(String str, String str2, ProtocolListener protocolListener) {
        try {
            this.instanceId = hashCode();
            CLog.i(TAG, "--------------------------- >  connect");
            Device device = getDevice(UPnP.getXMLParser().parseUrl(str));
            this.mCurrentDevce = device;
            if (device == null) {
                return false;
            }
            device.setLocation(str);
            CLog.i(TAG, this.mCurrentDevce.getFriendlyName() + " getManufacture :" + this.mCurrentDevce.getManufacture() + " getManufactureURL: " + this.mCurrentDevce.getManufactureURL());
            DLNASender dLNASender = new DLNASender(this.mCurrentDevce, str2);
            this.mDlnaSender = dLNASender;
            dLNASender.retryHttpSwitch(isRetryHttp);
            this.mProtocolListener = protocolListener;
            init(str2);
            return true;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public String escapeXMLChars(String str) {
        return XML.escapeXMLChars(str);
    }

    public void retryHttp(boolean z10) {
        isRetryHttp = z10;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0145, code lost:
        switch(r0) {
            case 0: goto L_0x01e0;
            case 1: goto L_0x01d9;
            case 2: goto L_0x01d0;
            case 3: goto L_0x01bc;
            case 4: goto L_0x01b5;
            case 5: goto L_0x0181;
            case 6: goto L_0x014a;
            default: goto L_0x0148;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x014c, code lost:
        if (r1.mCurrentVolume > 0) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014e, code lost:
        r1.mCurrentVolume = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0150, code lost:
        r0 = r1.mCurrentVolume - 10;
        r1.mCurrentVolume = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0156, code lost:
        if (r0 >= 0) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0158, code lost:
        r1.mCurrentVolume = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015a, code lost:
        com.hpplay.component.common.utils.CLog.i(TAG, " remain volume " + r1.mMaxVolume + " " + r1.mCurrentVolume);
        r9 = r1.mDlnaSender.setVoice(r1.mCurrentVolume);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0181, code lost:
        r0 = r1.mCurrentVolume;
        r3 = r1.mMaxVolume;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0185, code lost:
        if (r0 < r3) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0187, code lost:
        r1.mCurrentVolume = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x018a, code lost:
        r1.mCurrentVolume = r0 + 10;
        com.hpplay.component.common.utils.CLog.i(TAG, "add volume " + r1.mMaxVolume + " " + r1.mCurrentVolume);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01ac, code lost:
        r9 = r1.mDlnaSender.setVoice(r1.mCurrentVolume);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b5, code lost:
        r9 = r1.mDlnaSender.stop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01bc, code lost:
        r5 = new java.lang.String[]{r1.mDlnaSender.getTransportState(), r1.mCurrentUrl, r1.mUuid};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d0, code lost:
        r5[0] = r1.mDlnaSender.getPositionInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d9, code lost:
        r9 = r1.mDlnaSender.resume();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e0, code lost:
        r9 = r1.mDlnaSender.pause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ec, code lost:
        if (r2.contains(com.hpplay.component.common.dlna.IDLNAController.GET_MEDIA_INFO) != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01f2, code lost:
        if (r2.contains(com.hpplay.component.common.dlna.IDLNAController.GET_POSITION_INFO) != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01f8, code lost:
        if (r2.contains(com.hpplay.component.common.dlna.IDLNAController.GET_TRANSPORT_INFO) != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01fa, code lost:
        if (r9 == false) goto L_0x01fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01fc, code lost:
        r8 = "successful";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01fe, code lost:
        r5[0] = r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0100 A[SYNTHETIC, Splitter:B:29:0x0100] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0108 A[Catch:{ Exception -> 0x0201 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0112 A[Catch:{ Exception -> 0x0201 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011a A[Catch:{ Exception -> 0x0201 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0124 A[Catch:{ Exception -> 0x0201 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x012e A[Catch:{ Exception -> 0x0201 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0138 A[Catch:{ Exception -> 0x0201 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] sendAction(java.lang.String r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "\r\n"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "play url "
            r3.append(r4)
            java.lang.String r4 = r1.mCurrentUrl
            r3.append(r4)
            java.lang.String r4 = "  mateData =========> "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "DLNAControllerImp"
            com.hpplay.component.common.utils.CLog.i(r4, r3)
            r3 = 1
            java.lang.String[] r5 = new java.lang.String[r3]
            r6 = 0
            java.lang.String r7 = "Play"
            boolean r7 = r2.startsWith(r7)     // Catch:{ Exception -> 0x0201 }
            java.lang.String r8 = "failed"
            java.lang.String r9 = "LLL@BBB"
            r11 = 2
            if (r7 == 0) goto L_0x00bb
            java.lang.String[] r7 = r2.split(r9)     // Catch:{ Exception -> 0x00b5 }
            r9 = r7[r3]     // Catch:{ Exception -> 0x00b5 }
            r1.mCurrentUrl = r9     // Catch:{ Exception -> 0x00b5 }
            com.hpplay.component.dlna.DLNASender r12 = r1.mDlnaSender     // Catch:{ Exception -> 0x00b5 }
            r13 = r7[r11]     // Catch:{ Exception -> 0x00b5 }
            boolean r9 = r12.play(r9, r13)     // Catch:{ Exception -> 0x00b5 }
            if (r9 != 0) goto L_0x00a3
            com.hpplay.component.dlna.DLNASender r7 = r1.mDlnaSender     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r7 = r7.getDesc()     // Catch:{ Exception -> 0x00b3 }
            com.hpplay.component.dlna.DLNASender r12 = r1.mDlnaSender     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r12 = r12.getErrMsg()     // Catch:{ Exception -> 0x00b3 }
            com.hpplay.component.dlna.DLNASender r13 = r1.mDlnaSender     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r13 = r13.getLocation()     // Catch:{ Exception -> 0x00b3 }
            com.hpplay.component.dlna.DLNASender r14 = r1.mDlnaSender     // Catch:{ Exception -> 0x00b3 }
            int r14 = r14.getErrCode()     // Catch:{ Exception -> 0x00b3 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b3 }
            r15.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r10 = "location_uri"
            r15.append(r10)     // Catch:{ Exception -> 0x00b3 }
            r15.append(r0)     // Catch:{ Exception -> 0x00b3 }
            r15.append(r13)     // Catch:{ Exception -> 0x00b3 }
            r15.append(r0)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r10 = "desc"
            r15.append(r10)     // Catch:{ Exception -> 0x00b3 }
            r15.append(r0)     // Catch:{ Exception -> 0x00b3 }
            r15.append(r7)     // Catch:{ Exception -> 0x00b3 }
            r15.append(r0)     // Catch:{ Exception -> 0x00b3 }
            r15.append(r12)     // Catch:{ Exception -> 0x00b3 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b3 }
            r0.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r7 = "errMsg"
            java.lang.String r10 = r15.toString()     // Catch:{ Exception -> 0x00b3 }
            r0.put(r7, r10)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r7 = "errCode"
            r0.put(r7, r14)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ Exception -> 0x00b3 }
            r5[r6] = r8     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b3 }
            r5[r3] = r0     // Catch:{ Exception -> 0x00b3 }
            return r5
        L_0x00a3:
            int r0 = r7.length     // Catch:{ Exception -> 0x00b3 }
            r10 = 3
            if (r0 <= r10) goto L_0x00f4
            com.hpplay.component.dlna.DLNASender r0 = r1.mDlnaSender     // Catch:{ Exception -> 0x00b3 }
            r7 = r7[r10]     // Catch:{ Exception -> 0x00b3 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x00b3 }
            r0.setStartPosition(r7)     // Catch:{ Exception -> 0x00b3 }
            goto L_0x00f4
        L_0x00b3:
            r0 = move-exception
            goto L_0x00b7
        L_0x00b5:
            r0 = move-exception
            r9 = 0
        L_0x00b7:
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ Exception -> 0x0201 }
            goto L_0x00f4
        L_0x00bb:
            java.lang.String r0 = "SetVolume"
            boolean r0 = r2.startsWith(r0)     // Catch:{ Exception -> 0x0201 }
            if (r0 == 0) goto L_0x00d4
            java.lang.String[] r0 = r2.split(r9)     // Catch:{ Exception -> 0x0201 }
            com.hpplay.component.dlna.DLNASender r7 = r1.mDlnaSender     // Catch:{ Exception -> 0x0201 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x0201 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0201 }
            boolean r9 = r7.setVoice(r0)     // Catch:{ Exception -> 0x0201 }
            goto L_0x00f4
        L_0x00d4:
            java.lang.String r0 = "Seek"
            boolean r0 = r2.startsWith(r0)     // Catch:{ Exception -> 0x0201 }
            if (r0 == 0) goto L_0x00f3
            java.lang.String[] r0 = r2.split(r9)     // Catch:{ Exception -> 0x0201 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x0201 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0201 }
            com.hpplay.component.dlna.DLNASender r7 = r1.mDlnaSender     // Catch:{ Exception -> 0x0201 }
            int r0 = r0 * 1000
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0201 }
            boolean r9 = r7.seek(r0)     // Catch:{ Exception -> 0x0201 }
            goto L_0x00f4
        L_0x00f3:
            r9 = 0
        L_0x00f4:
            int r0 = r17.hashCode()     // Catch:{ Exception -> 0x0201 }
            java.lang.String r7 = "GetTransportInfo"
            java.lang.String r10 = "GetPositionInfo"
            switch(r0) {
                case -1850559411: goto L_0x0138;
                case -1218595054: goto L_0x012e;
                case 2587682: goto L_0x0124;
                case 76887510: goto L_0x011a;
                case 663224269: goto L_0x0112;
                case 726000028: goto L_0x0108;
                case 871896033: goto L_0x0100;
                default: goto L_0x00ff;
            }
        L_0x00ff:
            goto L_0x0142
        L_0x0100:
            boolean r0 = r2.equals(r7)     // Catch:{ Exception -> 0x0201 }
            if (r0 == 0) goto L_0x0142
            r0 = 3
            goto L_0x0143
        L_0x0108:
            java.lang.String r0 = "decvolume"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0201 }
            if (r0 == 0) goto L_0x0142
            r0 = 6
            goto L_0x0143
        L_0x0112:
            boolean r0 = r2.equals(r10)     // Catch:{ Exception -> 0x0201 }
            if (r0 == 0) goto L_0x0142
            r0 = 2
            goto L_0x0143
        L_0x011a:
            java.lang.String r0 = "Pause"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0201 }
            if (r0 == 0) goto L_0x0142
            r0 = 0
            goto L_0x0143
        L_0x0124:
            java.lang.String r0 = "Stop"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0201 }
            if (r0 == 0) goto L_0x0142
            r0 = 4
            goto L_0x0143
        L_0x012e:
            java.lang.String r0 = "incvloume"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0201 }
            if (r0 == 0) goto L_0x0142
            r0 = 5
            goto L_0x0143
        L_0x0138:
            java.lang.String r0 = "Resume"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0201 }
            if (r0 == 0) goto L_0x0142
            r0 = 1
            goto L_0x0143
        L_0x0142:
            r0 = -1
        L_0x0143:
            java.lang.String r12 = " "
            switch(r0) {
                case 0: goto L_0x01e0;
                case 1: goto L_0x01d9;
                case 2: goto L_0x01d0;
                case 3: goto L_0x01bc;
                case 4: goto L_0x01b5;
                case 5: goto L_0x0181;
                case 6: goto L_0x014a;
                default: goto L_0x0148;
            }
        L_0x0148:
            goto L_0x01e6
        L_0x014a:
            int r0 = r1.mCurrentVolume     // Catch:{ Exception -> 0x0201 }
            if (r0 > 0) goto L_0x0150
            r1.mCurrentVolume = r6     // Catch:{ Exception -> 0x0201 }
        L_0x0150:
            int r0 = r1.mCurrentVolume     // Catch:{ Exception -> 0x0201 }
            int r0 = r0 + -10
            r1.mCurrentVolume = r0     // Catch:{ Exception -> 0x0201 }
            if (r0 >= 0) goto L_0x015a
            r1.mCurrentVolume = r6     // Catch:{ Exception -> 0x0201 }
        L_0x015a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0201 }
            r0.<init>()     // Catch:{ Exception -> 0x0201 }
            java.lang.String r3 = " remain volume "
            r0.append(r3)     // Catch:{ Exception -> 0x0201 }
            int r3 = r1.mMaxVolume     // Catch:{ Exception -> 0x0201 }
            r0.append(r3)     // Catch:{ Exception -> 0x0201 }
            r0.append(r12)     // Catch:{ Exception -> 0x0201 }
            int r3 = r1.mCurrentVolume     // Catch:{ Exception -> 0x0201 }
            r0.append(r3)     // Catch:{ Exception -> 0x0201 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0201 }
            com.hpplay.component.common.utils.CLog.i(r4, r0)     // Catch:{ Exception -> 0x0201 }
            com.hpplay.component.dlna.DLNASender r0 = r1.mDlnaSender     // Catch:{ Exception -> 0x0201 }
            int r3 = r1.mCurrentVolume     // Catch:{ Exception -> 0x0201 }
            boolean r9 = r0.setVoice(r3)     // Catch:{ Exception -> 0x0201 }
            goto L_0x01e6
        L_0x0181:
            int r0 = r1.mCurrentVolume     // Catch:{ Exception -> 0x0201 }
            int r3 = r1.mMaxVolume     // Catch:{ Exception -> 0x0201 }
            if (r0 < r3) goto L_0x018a
            r1.mCurrentVolume = r3     // Catch:{ Exception -> 0x0201 }
            goto L_0x01ac
        L_0x018a:
            int r0 = r0 + 10
            r1.mCurrentVolume = r0     // Catch:{ Exception -> 0x0201 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0201 }
            r0.<init>()     // Catch:{ Exception -> 0x0201 }
            java.lang.String r3 = "add volume "
            r0.append(r3)     // Catch:{ Exception -> 0x0201 }
            int r3 = r1.mMaxVolume     // Catch:{ Exception -> 0x0201 }
            r0.append(r3)     // Catch:{ Exception -> 0x0201 }
            r0.append(r12)     // Catch:{ Exception -> 0x0201 }
            int r3 = r1.mCurrentVolume     // Catch:{ Exception -> 0x0201 }
            r0.append(r3)     // Catch:{ Exception -> 0x0201 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0201 }
            com.hpplay.component.common.utils.CLog.i(r4, r0)     // Catch:{ Exception -> 0x0201 }
        L_0x01ac:
            com.hpplay.component.dlna.DLNASender r0 = r1.mDlnaSender     // Catch:{ Exception -> 0x0201 }
            int r3 = r1.mCurrentVolume     // Catch:{ Exception -> 0x0201 }
            boolean r9 = r0.setVoice(r3)     // Catch:{ Exception -> 0x0201 }
            goto L_0x01e6
        L_0x01b5:
            com.hpplay.component.dlna.DLNASender r0 = r1.mDlnaSender     // Catch:{ Exception -> 0x0201 }
            boolean r9 = r0.stop()     // Catch:{ Exception -> 0x0201 }
            goto L_0x01e6
        L_0x01bc:
            r12 = 3
            java.lang.String[] r5 = new java.lang.String[r12]     // Catch:{ Exception -> 0x0201 }
            com.hpplay.component.dlna.DLNASender r0 = r1.mDlnaSender     // Catch:{ Exception -> 0x0201 }
            java.lang.String r0 = r0.getTransportState()     // Catch:{ Exception -> 0x0201 }
            r5[r6] = r0     // Catch:{ Exception -> 0x0201 }
            java.lang.String r0 = r1.mCurrentUrl     // Catch:{ Exception -> 0x0201 }
            r5[r3] = r0     // Catch:{ Exception -> 0x0201 }
            java.lang.String r0 = r1.mUuid     // Catch:{ Exception -> 0x0201 }
            r5[r11] = r0     // Catch:{ Exception -> 0x0201 }
            goto L_0x01e6
        L_0x01d0:
            com.hpplay.component.dlna.DLNASender r0 = r1.mDlnaSender     // Catch:{ Exception -> 0x0201 }
            java.lang.String r0 = r0.getPositionInfo()     // Catch:{ Exception -> 0x0201 }
            r5[r6] = r0     // Catch:{ Exception -> 0x0201 }
            goto L_0x01e6
        L_0x01d9:
            com.hpplay.component.dlna.DLNASender r0 = r1.mDlnaSender     // Catch:{ Exception -> 0x0201 }
            boolean r9 = r0.resume()     // Catch:{ Exception -> 0x0201 }
            goto L_0x01e6
        L_0x01e0:
            com.hpplay.component.dlna.DLNASender r0 = r1.mDlnaSender     // Catch:{ Exception -> 0x0201 }
            boolean r9 = r0.pause()     // Catch:{ Exception -> 0x0201 }
        L_0x01e6:
            java.lang.String r0 = "GetMediaInfo"
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x0201 }
            if (r0 != 0) goto L_0x0205
            boolean r0 = r2.contains(r10)     // Catch:{ Exception -> 0x0201 }
            if (r0 != 0) goto L_0x0205
            boolean r0 = r2.contains(r7)     // Catch:{ Exception -> 0x0201 }
            if (r0 != 0) goto L_0x0205
            if (r9 == 0) goto L_0x01fe
            java.lang.String r8 = "successful"
        L_0x01fe:
            r5[r6] = r8     // Catch:{ Exception -> 0x0201 }
            goto L_0x0205
        L_0x0201:
            r0 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r4, (java.lang.Throwable) r0)
        L_0x0205:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = r5[r6]
            com.hpplay.component.common.utils.CLog.i(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.dlna.DLNAControllerImp.sendAction(java.lang.String):java.lang.String[]");
    }
}
