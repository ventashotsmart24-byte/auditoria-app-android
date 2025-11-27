package com.hpplay.sdk.source.process;

import android.content.Context;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.KeepAliveUtitls;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class DevicePreChecker extends Thread {
    public static final int ALL_ONLINE = 1;
    public static final int OFFLINE = 0;
    public static final int ONLY_ONE_ONLINE = 2;
    private static final String TAG = "DevicePreChecker";
    private boolean isRunning = false;
    private long mCheckStartTime;
    private Context mContext;
    private final ConcurrentHashMap<String, OnDevicePreCheckResultCallback> mResultMap = new ConcurrentHashMap<>();
    private final LinkedBlockingQueue<LelinkServiceInfo> mServiceInfos = new LinkedBlockingQueue<>();

    public interface OnDevicePreCheckResultCallback {
        void onResult(LelinkServiceInfo lelinkServiceInfo, int i10);
    }

    public DevicePreChecker(Context context) {
        this.mContext = context;
    }

    private void callback(LelinkServiceInfo lelinkServiceInfo, int i10) {
        try {
            SourceLog.i(TAG, "=============> callback use time  " + (System.currentTimeMillis() - this.mCheckStartTime) + " state " + i10);
            String lelinkServiceKey = getLelinkServiceKey(lelinkServiceInfo);
            OnDevicePreCheckResultCallback onDevicePreCheckResultCallback = this.mResultMap.get(lelinkServiceKey);
            if (onDevicePreCheckResultCallback != null) {
                onDevicePreCheckResultCallback.onResult(lelinkServiceInfo, i10);
                this.mResultMap.remove(lelinkServiceKey);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    private boolean checkIM(BrowserInfo browserInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(browserInfo);
        String httpPostCheckTvState = KeepAliveUtitls.httpPostCheckTvState(arrayList);
        if (httpPostCheckTvState != null) {
            return httpPostCheckTvState.contains("state:true");
        }
        return false;
    }

    public static String getLelinkServiceKey(LelinkServiceInfo lelinkServiceInfo) {
        return lelinkServiceInfo.getName() + lelinkServiceInfo.getIp();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void release() {
        this.isRunning = false;
        interrupt();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b A[ADDED_TO_REGION, Catch:{ Exception -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2 A[Catch:{ Exception -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3 A[Catch:{ Exception -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A[Catch:{ Exception -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d0 A[Catch:{ Exception -> 0x00db }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            java.lang.String r0 = "DevicePreChecker"
            super.run()
            r1 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r12.isRunning = r1
        L_0x000c:
            boolean r3 = r12.isRunning
            r4 = 0
            if (r3 == 0) goto L_0x00df
            java.util.concurrent.LinkedBlockingQueue<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r3 = r12.mServiceInfos     // Catch:{ Exception -> 0x00db }
            java.lang.Object r3 = r3.take()     // Catch:{ Exception -> 0x00db }
            com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3     // Catch:{ Exception -> 0x00db }
            if (r3 != 0) goto L_0x001d
            goto L_0x00df
        L_0x001d:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00db }
            r12.mCheckStartTime = r5     // Catch:{ Exception -> 0x00db }
            r5 = 4
            r6 = 3
            r7 = 0
            java.util.Map r8 = r3.getBrowserInfos()     // Catch:{ Exception -> 0x0053 }
            java.lang.Object r8 = r8.get(r2)     // Catch:{ Exception -> 0x0053 }
            com.hpplay.sdk.source.browse.data.BrowserInfo r8 = (com.hpplay.sdk.source.browse.data.BrowserInfo) r8     // Catch:{ Exception -> 0x0053 }
            java.util.Map r9 = r3.getBrowserInfos()     // Catch:{ Exception -> 0x0050 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0050 }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ Exception -> 0x0050 }
            com.hpplay.sdk.source.browse.data.BrowserInfo r9 = (com.hpplay.sdk.source.browse.data.BrowserInfo) r9     // Catch:{ Exception -> 0x0050 }
            java.util.Map r10 = r3.getBrowserInfos()     // Catch:{ Exception -> 0x004e }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x004e }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x004e }
            com.hpplay.sdk.source.browse.data.BrowserInfo r10 = (com.hpplay.sdk.source.browse.data.BrowserInfo) r10     // Catch:{ Exception -> 0x004e }
            r7 = r10
            goto L_0x0059
        L_0x004e:
            r10 = move-exception
            goto L_0x0056
        L_0x0050:
            r10 = move-exception
            r9 = r7
            goto L_0x0056
        L_0x0053:
            r10 = move-exception
            r8 = r7
            r9 = r8
        L_0x0056:
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r10)     // Catch:{ Exception -> 0x00db }
        L_0x0059:
            if (r8 == 0) goto L_0x00a0
            if (r7 == 0) goto L_0x00a0
            android.content.Context r7 = r12.mContext     // Catch:{ Exception -> 0x00db }
            boolean r7 = com.hpplay.common.utils.NetworkUtil.isWifiConnected(r7)     // Catch:{ Exception -> 0x00db }
            if (r7 != 0) goto L_0x009a
            android.content.Context r7 = r12.mContext     // Catch:{ Exception -> 0x00db }
            boolean r7 = com.hpplay.sdk.source.utils.HpplayUtil.isWifiApOpen(r7)     // Catch:{ Exception -> 0x00db }
            if (r7 == 0) goto L_0x006e
            goto L_0x009a
        L_0x006e:
            java.util.Map r7 = r3.getBrowserInfos()     // Catch:{ Exception -> 0x00db }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00db }
            java.lang.Object r5 = r7.get(r5)     // Catch:{ Exception -> 0x00db }
            com.hpplay.sdk.source.browse.data.BrowserInfo r5 = (com.hpplay.sdk.source.browse.data.BrowserInfo) r5     // Catch:{ Exception -> 0x00db }
            if (r5 == 0) goto L_0x0098
            boolean r5 = r12.checkIM(r5)     // Catch:{ Exception -> 0x00db }
            if (r5 != 0) goto L_0x0098
            java.util.Map r5 = r3.getBrowserInfos()     // Catch:{ Exception -> 0x00db }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00db }
            r5.remove(r6)     // Catch:{ Exception -> 0x00db }
            java.util.Map r5 = r3.getBrowserInfos()     // Catch:{ Exception -> 0x00db }
            r5.remove(r2)     // Catch:{ Exception -> 0x00db }
            r5 = 2
            goto L_0x009b
        L_0x0098:
            r5 = 0
            goto L_0x009b
        L_0x009a:
            r5 = 1
        L_0x009b:
            r12.callback(r3, r5)     // Catch:{ Exception -> 0x00db }
            goto L_0x000c
        L_0x00a0:
            if (r8 == 0) goto L_0x00b3
            java.lang.String r5 = r8.getName()     // Catch:{ Exception -> 0x00db }
            java.lang.String r6 = r8.getIp()     // Catch:{ Exception -> 0x00db }
            int r7 = r8.getPort()     // Catch:{ Exception -> 0x00db }
            boolean r5 = com.hpplay.sdk.source.utils.KeepAliveUtitls.tcpCheckTvState(r5, r6, r7)     // Catch:{ Exception -> 0x00db }
            goto L_0x00cc
        L_0x00b3:
            if (r9 == 0) goto L_0x00c6
            java.lang.String r5 = r9.getName()     // Catch:{ Exception -> 0x00db }
            java.lang.String r6 = r9.getIp()     // Catch:{ Exception -> 0x00db }
            int r7 = r9.getPort()     // Catch:{ Exception -> 0x00db }
            boolean r5 = com.hpplay.sdk.source.utils.KeepAliveUtitls.tcpCheckTvState(r5, r6, r7)     // Catch:{ Exception -> 0x00db }
            goto L_0x00cc
        L_0x00c6:
            if (r7 == 0) goto L_0x00d6
            boolean r5 = r12.checkIM(r7)     // Catch:{ Exception -> 0x00db }
        L_0x00cc:
            if (r5 == 0) goto L_0x00d0
            r5 = 1
            goto L_0x00d1
        L_0x00d0:
            r5 = 0
        L_0x00d1:
            r12.callback(r3, r5)     // Catch:{ Exception -> 0x00db }
            goto L_0x000c
        L_0x00d6:
            r12.callback(r3, r4)     // Catch:{ Exception -> 0x00db }
            goto L_0x000c
        L_0x00db:
            r1 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x00df:
            r12.isRunning = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.process.DevicePreChecker.run():void");
    }

    public void setOnDevicePreCheckResult(LelinkServiceInfo lelinkServiceInfo, OnDevicePreCheckResultCallback onDevicePreCheckResultCallback) {
        String lelinkServiceKey = getLelinkServiceKey(lelinkServiceInfo);
        this.mServiceInfos.add(lelinkServiceInfo);
        this.mResultMap.put(lelinkServiceKey, onDevicePreCheckResultCallback);
    }
}
