package com.hpplay.component.adjuster;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.browse.IBrowser;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class DeviceAdjuster {
    public static final int ACTIVE_STOP_TIME_OUT = 1000;
    public static final int AUTO_STOP_TIME_OUT = 10000;
    public static final String KEY_AIRPLAY_PORT = "airplay";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_DEVICE_IP = "deviceip";
    public static final String KEY_DEVICE_NAME = "devicename";
    public static final String KEY_DLNA_DESC = "dlna_mode_desc";
    public static final String KEY_LEBO_FEATURE = "lebofeature";
    public static final String KEY_LELINK_PORT = "lelinkport";
    public static final String KEY_LELINK_UID = " u";
    public static final String KEY_LELINK_VV = "vv";
    public static final String KEY_MAC = "devicemac";
    public static final String KEY_MIRROR_PORT = "mirror";
    public static final String KEY_RAOP_PORT = "raop";
    public static final String KEY_REMOTE_PORT = "remote";
    public static final String KEY_VERSION = "version";
    public static final String TAG = "DeviceAdjuster";
    private IBrowseResultListener browseResultListener = new IBrowseResultListener() {
        public void onBrowseResultCallback(int i10, Object obj) {
            if (DeviceAdjuster.this.isRequestDev.get()) {
                DeviceAdjuster.this.filterDevices(i10, obj);
            }
            if (DeviceAdjuster.this.mBrowseResultListener != null) {
                DeviceAdjuster.this.mBrowseResultListener.onBrowseResultCallback(i10, obj);
            }
        }
    };
    private boolean isFindDevice;
    /* access modifiers changed from: private */
    public AtomicBoolean isRequestDev = new AtomicBoolean();
    /* access modifiers changed from: private */
    public IBrowseResultListener mBrowseResultListener;
    private int mCurrentType;
    private ConcurrentHashMap<String, CopyOnWriteArraySet> mInfos = new ConcurrentHashMap<>();
    private ParamsMap mParamsMap;
    private ProtocolListener mRequestNewDeviceProtocolListener;
    private StopBrowseTask mStopBrowseTask;
    private Timer mTimer = new Timer();
    private CopyOnWriteArraySet<String> mValidInfos = new CopyOnWriteArraySet<>();

    public class StopBrowseTask extends TimerTask {
        public StopBrowseTask() {
        }

        public void run() {
            try {
                DeviceAdjuster.this.isRequestDev.set(false);
                ((IBrowser) ModuleLinker.getInstance().loadModule(ModuleIds.CLAZZ_ID968_BROWSECONTROLLER)).stopBrowse();
                CLog.i(DeviceAdjuster.TAG, " StopBrowseTask ");
                DeviceAdjuster.this.matchDevice();
            } catch (Exception e10) {
                CLog.w(DeviceAdjuster.TAG, (Throwable) e10);
            }
        }
    }

    private void claerTemp() {
        ConcurrentHashMap<String, CopyOnWriteArraySet> concurrentHashMap = this.mInfos;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.mValidInfos;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
    }

    private int convertType(int i10) {
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 1) {
            return 2;
        }
        return i10;
    }

    private void delayStopBrowse(long j10) {
        CLog.i(TAG, "delayStopBrowse ... " + j10);
        StopBrowseTask stopBrowseTask = this.mStopBrowseTask;
        if (stopBrowseTask != null) {
            stopBrowseTask.cancel();
            this.mTimer.purge();
        }
        StopBrowseTask stopBrowseTask2 = new StopBrowseTask();
        this.mStopBrowseTask = stopBrowseTask2;
        this.mTimer.schedule(stopBrowseTask2, j10);
    }

    private String deviceConvert(int i10, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mParamsMap.putParam(ParamsMap.ConnectParams.KEY_CONNECT_SUPPORT, new int[]{i10}).putParam("ip", jSONObject.optString(KEY_DEVICE_IP)).putParam("port", jSONObject.optString("lelinkport")).putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, jSONObject.optString("lelinkport")).putParam(ParamsMap.DeviceParams.KEY_RAOP_PORT, jSONObject.optString("raop")).putParam(ParamsMap.DeviceParams.KEY_SINK_NAME, jSONObject.optString(KEY_DEVICE_NAME)).putParam("vv", jSONObject.optString("vv")).putParam(ParamsMap.DeviceParams.KEY_MIRROR_PORT, jSONObject.optString("mirror")).putParam(ParamsMap.DeviceParams.KEY_AIRPLAY_PORT, jSONObject.optString("airplay")).putParam(ParamsMap.DeviceParams.KEY_CHANNEL_VERSION, jSONObject.optString("channel")).putParam("remote", jSONObject.optString("remote")).putParam(ParamsMap.DeviceParams.KEY_MAC, jSONObject.optString(KEY_MAC)).putParam(ParamsMap.PushParams.KEY_LOCATION_URI, jSONObject.optString("dlna_mode_desc"));
            String jason = this.mParamsMap.toJason();
            CLog.i(TAG, "covert device info " + jason);
            return jason;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b9 A[Catch:{ Exception -> 0x010e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void filterDevices(int r9, java.lang.Object r10) {
        /*
            r8 = this;
            java.lang.String r0 = "uid"
            java.lang.String r1 = "DeviceAdjuster"
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArraySet> r2 = r8.mInfos     // Catch:{ Exception -> 0x010e }
            if (r2 == 0) goto L_0x0117
            com.hpplay.component.common.ParamsMap r2 = r8.mParamsMap     // Catch:{ Exception -> 0x010e }
            if (r2 == 0) goto L_0x0117
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x010e }
            java.lang.String r3 = r10.toString()     // Catch:{ Exception -> 0x010e }
            r2.<init>(r3)     // Catch:{ Exception -> 0x010e }
            java.lang.String r3 = "deviceip"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ Exception -> 0x010e }
            java.lang.String r4 = "devicename"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ Exception -> 0x010e }
            java.lang.String r5 = " u"
            java.lang.String r2 = r2.optString(r5)     // Catch:{ Exception -> 0x010e }
            com.hpplay.component.common.ParamsMap r5 = r8.mParamsMap     // Catch:{ Exception -> 0x010e }
            java.lang.String r5 = r5.getStringParam(r0)     // Catch:{ Exception -> 0x010e }
            boolean r2 = android.text.TextUtils.equals(r2, r5)     // Catch:{ Exception -> 0x010e }
            java.lang.String r5 = "  type "
            java.lang.String r6 = "sink_name"
            if (r2 != 0) goto L_0x0083
            com.hpplay.component.common.ParamsMap r2 = r8.mParamsMap     // Catch:{ Exception -> 0x010e }
            java.lang.String r2 = r2.getIp()     // Catch:{ Exception -> 0x010e }
            boolean r2 = android.text.TextUtils.equals(r3, r2)     // Catch:{ Exception -> 0x010e }
            if (r2 != 0) goto L_0x0083
            com.hpplay.component.common.ParamsMap r2 = r8.mParamsMap     // Catch:{ Exception -> 0x010e }
            java.lang.String r2 = r2.getStringParam(r6)     // Catch:{ Exception -> 0x010e }
            boolean r2 = android.text.TextUtils.equals(r2, r4)     // Catch:{ Exception -> 0x010e }
            if (r2 == 0) goto L_0x0050
            goto L_0x0083
        L_0x0050:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010e }
            r2.<init>()     // Catch:{ Exception -> 0x010e }
            java.lang.String r7 = " no find new devices name "
            r2.append(r7)     // Catch:{ Exception -> 0x010e }
            r2.append(r4)     // Catch:{ Exception -> 0x010e }
            java.lang.String r4 = " new dev  "
            r2.append(r4)     // Catch:{ Exception -> 0x010e }
            java.lang.String r4 = "."
            java.lang.String r7 = ""
            java.lang.String r3 = r3.replace(r4, r7)     // Catch:{ Exception -> 0x010e }
            r2.append(r3)     // Catch:{ Exception -> 0x010e }
            java.lang.String r3 = " request "
            r2.append(r3)     // Catch:{ Exception -> 0x010e }
            com.hpplay.component.common.ParamsMap r3 = r8.mParamsMap     // Catch:{ Exception -> 0x010e }
            java.lang.String r3 = r3.getIp()     // Catch:{ Exception -> 0x010e }
            r2.append(r3)     // Catch:{ Exception -> 0x010e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x010e }
            com.hpplay.component.common.utils.CLog.i(r1, r2)     // Catch:{ Exception -> 0x010e }
            goto L_0x00b1
        L_0x0083:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010e }
            r2.<init>()     // Catch:{ Exception -> 0x010e }
            java.lang.String r3 = " find new devices "
            r2.append(r3)     // Catch:{ Exception -> 0x010e }
            r2.append(r4)     // Catch:{ Exception -> 0x010e }
            r2.append(r5)     // Catch:{ Exception -> 0x010e }
            r2.append(r9)     // Catch:{ Exception -> 0x010e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x010e }
            com.hpplay.component.common.utils.CLog.i(r1, r2)     // Catch:{ Exception -> 0x010e }
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r2 = r8.mValidInfos     // Catch:{ Exception -> 0x010e }
            java.lang.String r3 = r10.toString()     // Catch:{ Exception -> 0x010e }
            r2.add(r3)     // Catch:{ Exception -> 0x010e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArraySet> r2 = r8.mInfos     // Catch:{ Exception -> 0x010e }
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x010e }
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r4 = r8.mValidInfos     // Catch:{ Exception -> 0x010e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x010e }
        L_0x00b1:
            int r2 = r8.mCurrentType     // Catch:{ Exception -> 0x010e }
            int r3 = r8.convertType(r9)     // Catch:{ Exception -> 0x010e }
            if (r2 != r3) goto L_0x0117
            java.lang.String r2 = r10.toString()     // Catch:{ Exception -> 0x010e }
            com.hpplay.component.common.ParamsMap r3 = r8.mParamsMap     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = r3.getStringParam(r0)     // Catch:{ Exception -> 0x010e }
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x010e }
            if (r0 != 0) goto L_0x00d9
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x010e }
            com.hpplay.component.common.ParamsMap r0 = r8.mParamsMap     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = r0.getStringParam(r6)     // Catch:{ Exception -> 0x010e }
            boolean r10 = r10.contains(r0)     // Catch:{ Exception -> 0x010e }
            if (r10 == 0) goto L_0x0117
        L_0x00d9:
            boolean r10 = r8.isFindDevice     // Catch:{ Exception -> 0x010e }
            if (r10 != 0) goto L_0x0117
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010e }
            r10.<init>()     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = "mCurrentType "
            r10.append(r0)     // Catch:{ Exception -> 0x010e }
            int r0 = r8.mCurrentType     // Catch:{ Exception -> 0x010e }
            r10.append(r0)     // Catch:{ Exception -> 0x010e }
            r10.append(r5)     // Catch:{ Exception -> 0x010e }
            r10.append(r9)     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = "   convert "
            r10.append(r0)     // Catch:{ Exception -> 0x010e }
            int r9 = r8.convertType(r9)     // Catch:{ Exception -> 0x010e }
            r10.append(r9)     // Catch:{ Exception -> 0x010e }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x010e }
            com.hpplay.component.common.utils.CLog.i(r1, r9)     // Catch:{ Exception -> 0x010e }
            r9 = 1
            r8.isFindDevice = r9     // Catch:{ Exception -> 0x010e }
            r9 = 1000(0x3e8, double:4.94E-321)
            r8.delayStopBrowse(r9)     // Catch:{ Exception -> 0x010e }
            goto L_0x0117
        L_0x010e:
            r9 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r1, (java.lang.Throwable) r9)
            r9 = 0
            r8.delayStopBrowse(r9)
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.adjuster.DeviceAdjuster.filterDevices(int, java.lang.Object):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void matchDevice() {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " start match device "
            r0.append(r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArraySet> r1 = r9.mInfos
            int r1 = r1.size()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "DeviceAdjuster"
            com.hpplay.component.common.utils.CLog.i(r1, r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArraySet> r0 = r9.mInfos
            int r0 = r0.size()
            r1 = 0
            r2 = 20
            if (r0 <= 0) goto L_0x00da
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArraySet> r0 = r9.mInfos
            r3 = 2
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.Object r0 = r0.get(r3)
            java.util.concurrent.CopyOnWriteArraySet r0 = (java.util.concurrent.CopyOnWriteArraySet) r0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArraySet> r3 = r9.mInfos
            r4 = 1
            java.lang.String r5 = java.lang.String.valueOf(r4)
            java.lang.Object r3 = r3.get(r5)
            java.util.concurrent.CopyOnWriteArraySet r3 = (java.util.concurrent.CopyOnWriteArraySet) r3
            java.lang.String r5 = "sink_name"
            if (r0 == 0) goto L_0x0080
            java.util.Iterator r0 = r0.iterator()
            r6 = r1
        L_0x004a:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x0081
            java.lang.Object r6 = r0.next()
            java.lang.String r6 = (java.lang.String) r6
            com.hpplay.component.common.ParamsMap r7 = r9.mParamsMap
            java.lang.String r8 = "uid"
            java.lang.String r7 = r7.getStringParam(r8)
            boolean r7 = r6.contains(r7)
            if (r7 != 0) goto L_0x0070
            com.hpplay.component.common.ParamsMap r7 = r9.mParamsMap
            java.lang.String r7 = r7.getStringParam(r5)
            boolean r7 = r6.contains(r7)
            if (r7 == 0) goto L_0x004a
        L_0x0070:
            com.hpplay.component.common.protocol.ProtocolListener r0 = r9.mRequestNewDeviceProtocolListener
            if (r0 == 0) goto L_0x007f
            java.lang.String r1 = r9.deviceConvert(r4, r6)
            java.lang.String[] r1 = new java.lang.String[]{r1}
            r0.onResult(r2, r1)
        L_0x007f:
            return
        L_0x0080:
            r6 = r1
        L_0x0081:
            if (r3 == 0) goto L_0x00e1
            java.util.Iterator r0 = r3.iterator()
        L_0x0087:
            boolean r3 = r0.hasNext()
            r7 = 3
            if (r3 == 0) goto L_0x00b0
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            com.hpplay.component.common.ParamsMap r3 = r9.mParamsMap
            java.lang.String r3 = r3.getStringParam(r5)
            boolean r3 = r1.contains(r3)
            if (r3 == 0) goto L_0x0087
            com.hpplay.component.common.protocol.ProtocolListener r0 = r9.mRequestNewDeviceProtocolListener
            if (r0 == 0) goto L_0x00af
            java.lang.String r1 = r9.deviceConvert(r7, r1)
            java.lang.String[] r1 = new java.lang.String[]{r1}
            r0.onResult(r2, r1)
        L_0x00af:
            return
        L_0x00b0:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x00ca
            com.hpplay.component.common.protocol.ProtocolListener r0 = r9.mRequestNewDeviceProtocolListener
            if (r0 == 0) goto L_0x00e1
            java.lang.String r1 = r9.deviceConvert(r4, r6)
            java.lang.String r1 = r9.deviceConvert(r4, r1)
            java.lang.String[] r1 = new java.lang.String[]{r1}
            r0.onResult(r2, r1)
            goto L_0x00e1
        L_0x00ca:
            com.hpplay.component.common.protocol.ProtocolListener r0 = r9.mRequestNewDeviceProtocolListener
            if (r0 == 0) goto L_0x00e1
            java.lang.String r1 = r9.deviceConvert(r7, r1)
            java.lang.String[] r1 = new java.lang.String[]{r1}
            r0.onResult(r2, r1)
            goto L_0x00e1
        L_0x00da:
            com.hpplay.component.common.protocol.ProtocolListener r0 = r9.mRequestNewDeviceProtocolListener
            if (r0 == 0) goto L_0x00e1
            r0.onResult(r2, r1)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.adjuster.DeviceAdjuster.matchDevice():void");
    }

    private void rebrowse(int i10) {
        try {
            claerTemp();
            delayStopBrowse(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
            this.isRequestDev.set(true);
            IBrowser iBrowser = (IBrowser) ModuleLinker.getInstance().loadModule(ModuleIds.CLAZZ_ID968_BROWSECONTROLLER);
            iBrowser.stopBrowse();
            iBrowser.startBrowse(i10);
            CLog.i(TAG, "rebrowse ...browse type :" + i10);
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    public IBrowseResultListener getBrowseResultListener() {
        return this.browseResultListener;
    }

    public void requestNewDevices(int i10, ParamsMap paramsMap, ProtocolListener protocolListener) {
        try {
            this.mCurrentType = i10;
            String stringParam = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_SINK_NAME);
            String ip = paramsMap.getIp();
            this.isFindDevice = false;
            claerTemp();
            this.mParamsMap = paramsMap;
            this.mRequestNewDeviceProtocolListener = protocolListener;
            rebrowse(i10);
            CLog.i(TAG, "requestNewDevices ... requestName: " + stringParam + " request  " + ip.replace(".", ""));
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            protocolListener.onResult(20, (String[]) null);
        }
    }

    public void setBrowseInfosPoolListener(IBrowseResultListener iBrowseResultListener) {
        claerTemp();
        this.mBrowseResultListener = iBrowseResultListener;
    }

    public void stopRequestDevice() {
        this.mRequestNewDeviceProtocolListener = null;
        StopBrowseTask stopBrowseTask = this.mStopBrowseTask;
        if (stopBrowseTask != null) {
            stopBrowseTask.cancel();
            this.mTimer.purge();
        }
    }

    public void requestNewDevices(ParamsMap paramsMap, ProtocolListener protocolListener) {
        requestNewDevices(3, paramsMap, protocolListener);
    }
}
