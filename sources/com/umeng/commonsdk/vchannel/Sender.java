package com.umeng.commonsdk.vchannel;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.a;
import com.umeng.commonsdk.internal.b;
import java.util.Map;

public class Sender {
    private static long INTERVAL_THRESHOLD = 500;
    public static final String VCHANNEL_VERSION = "1.0.0";
    private static Map<String, String> customHeader;
    private static long lastTriggerTime;

    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|6|7|(2:11|(2:14|12))|15|16|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void handleEvent(android.content.Context r6, com.umeng.commonsdk.vchannel.b r7) {
        /*
            if (r6 != 0) goto L_0x000a
            java.lang.String r6 = "MobclickRT"
            java.lang.String r7 = "--->>> Sender:handleEvent: context is null."
            com.umeng.commonsdk.debug.UMRTLog.e(r6, r7)
            return
        L_0x000a:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0059 }
            r1.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r0 = "v_sdk_v"
            java.lang.String r2 = "1.0.0"
            r1.put(r0, r2)     // Catch:{ all -> 0x0040 }
            java.util.Map<java.lang.String, java.lang.String> r0 = customHeader     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0040
            int r0 = r0.size()     // Catch:{ all -> 0x0040 }
            if (r0 <= 0) goto L_0x0040
            java.util.Map<java.lang.String, java.lang.String> r0 = customHeader     // Catch:{ all -> 0x0040 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x0040 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0040 }
        L_0x002a:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0040 }
            java.util.Map<java.lang.String, java.lang.String> r3 = customHeader     // Catch:{ all -> 0x0040 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0040 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0040 }
            goto L_0x002a
        L_0x0040:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0059 }
            r2.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r0 = "analytics"
            org.json.JSONObject r7 = r7.d()     // Catch:{ all -> 0x0059 }
            r2.put(r0, r7)     // Catch:{ all -> 0x0059 }
            java.lang.String r3 = com.umeng.commonsdk.vchannel.a.f15148c     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = "v"
            java.lang.String r5 = "1.0.0"
            r0 = r6
            com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.vchannel.Sender.handleEvent(android.content.Context, com.umeng.commonsdk.vchannel.b):void");
    }

    public static void onEvent(Context context, String str, Map<String, Object> map) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: context is null.");
        } else if (TextUtils.isEmpty(str)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: eventID is null or an empty string.");
        } else if (map == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: map is null.");
        } else if (!UMFrUtils.isOnline(context)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: Network unavailable.");
        } else if (System.currentTimeMillis() - lastTriggerTime < INTERVAL_THRESHOLD) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: The interval between events is less than 500 milliseconds.");
        } else {
            b bVar = new b(context);
            bVar.a(str);
            bVar.a(System.currentTimeMillis());
            bVar.a(map);
            try {
                UMWorkDispatch.sendEvent(context, a.f14764o, b.a(context).a(), bVar);
            } catch (Throwable unused) {
            }
            lastTriggerTime = System.currentTimeMillis();
        }
    }

    public static void setCustomHeader(Map<String, String> map) {
        if (map != null) {
            customHeader = map;
        }
    }
}
