package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.os.Bundle;
import com.umeng.analytics.pro.cd;

public class b implements cd {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14506a = "RealTimeDebugSwitch";

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f14507b;

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public void d(Activity activity) {
        f14507b--;
    }

    public void e(Activity activity) {
    }

    public static boolean d() {
        return f14507b > 0;
    }

    public void a(Activity activity) {
    }

    public void b(Activity activity) {
    }

    public void c(Activity activity) {
        f14507b++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.app.Activity r11, android.os.Bundle r12) {
        /*
            r10 = this;
            int r12 = f14507b
            if (r12 != 0) goto L_0x012c
            android.content.Intent r12 = r11.getIntent()
            java.lang.String r0 = "MobclickRT"
            if (r12 == 0) goto L_0x0118
            android.net.Uri r12 = r12.getData()
            if (r12 == 0) goto L_0x0103
            java.lang.String r1 = r12.getScheme()
            if (r1 == 0) goto L_0x00ee
            java.lang.String r2 = "um."
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x00ee
            java.lang.String r1 = "debugkey"
            java.lang.String r2 = r12.getQueryParameter(r1)
            java.lang.String r3 = "sendaging"
            java.lang.String r12 = r12.getQueryParameter(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x012c
            boolean r3 = android.text.TextUtils.isEmpty(r12)
            r4 = 0
            if (r3 != 0) goto L_0x0044
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0043 }
            long r6 = r12.longValue()     // Catch:{ all -> 0x0043 }
            goto L_0x0045
        L_0x0043:
        L_0x0044:
            r6 = r4
        L_0x0045:
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            r12.put(r1, r2)
            r3 = 0
            r8 = 8215(0x2017, float:1.1512E-41)
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 >= 0) goto L_0x0076
            boolean r12 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r12 == 0) goto L_0x006f
            java.lang.String r12 = "--->>> call turnOffRealTimeDebug because sendaging < 0"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r12)
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            android.content.Context r11 = r11.getApplicationContext()
            com.umeng.analytics.CoreProtocol r12 = com.umeng.analytics.CoreProtocol.getInstance(r11)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r11, r8, r12, r3)
            goto L_0x012c
        L_0x006f:
            java.lang.String r11 = "--->>> Not currently in RealTimeDebug mode and doing nothing."
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r11)
            goto L_0x012c
        L_0x0076:
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x00cb
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r12)
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r3 = "startTime"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a1 }
            r12.put(r3, r4)     // Catch:{ all -> 0x00a1 }
            r3 = 60
            int r5 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0092
            r6 = r3
        L_0x0092:
            r3 = 240(0xf0, double:1.186E-321)
            int r5 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0099
            r6 = r3
        L_0x0099:
            java.lang.String r3 = "period"
            r12.put(r3, r6)     // Catch:{ all -> 0x00a1 }
            r12.put(r1, r2)     // Catch:{ all -> 0x00a1 }
        L_0x00a1:
            android.content.Context r11 = r11.getApplicationContext()
            r1 = 8214(0x2016, float:1.151E-41)
            com.umeng.analytics.CoreProtocol r3 = com.umeng.analytics.CoreProtocol.getInstance(r11)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r11, r1, r3, r12)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "--->>> turnOnRealTimeDebug[persistent] dk: "
            r11.append(r12)
            r11.append(r2)
            java.lang.String r12 = "; period: "
            r11.append(r12)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r11)
            goto L_0x012c
        L_0x00cb:
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r12)
            android.content.Context r11 = r11.getApplicationContext()
            com.umeng.analytics.CoreProtocol r12 = com.umeng.analytics.CoreProtocol.getInstance(r11)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r11, r8, r12, r3)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "--->>> turnOnRealTimeDebug[non-persistent] dk: "
            r11.append(r12)
            r11.append(r2)
            java.lang.String r11 = r11.toString()
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r11)
            goto L_0x012c
        L_0x00ee:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "--->>> scheme: "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r11)
            goto L_0x012c
        L_0x0103:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "--->>> uri: "
            r11.append(r1)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r11)
            goto L_0x012c
        L_0x0118:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "--->>> intent: "
            r11.append(r1)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r11)
        L_0x012c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.vshelper.b.a(android.app.Activity, android.os.Bundle):void");
    }

    public void b(Activity activity, Bundle bundle) {
    }
}
