package com.umeng.commonsdk.internal.crash;

import android.content.Context;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.a;
import com.umeng.commonsdk.internal.b;

public class UMCrashManager {
    private static final String CM_VERSION = "2.0";
    private static boolean isReportCrash = false;
    private static Object mObject = new Object();

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|(5:9|(1:11)|12|13|14)|15|16|17|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0083 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void buildEnvelope(android.content.Context r10, java.lang.Object r11) {
        /*
            java.lang.String r0 = "MobclickRT"
            java.lang.String r1 = "--->>> UMCrashManager.buildEnvelope enter."
            com.umeng.commonsdk.debug.UMRTLog.e(r0, r1)
            java.lang.Object r0 = mObject     // Catch:{ all -> 0x008a }
            monitor-enter(r0)     // Catch:{ all -> 0x008a }
            if (r10 == 0) goto L_0x0085
            if (r11 != 0) goto L_0x000f
            goto L_0x0085
        L_0x000f:
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0087 }
            boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x0083
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r1.<init>()     // Catch:{ all -> 0x0087 }
            java.io.File r2 = r10.getFilesDir()     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = com.umeng.commonsdk.stateless.a.f14849f     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0087 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0087 }
            r2.<init>(r1)     // Catch:{ all -> 0x0087 }
            boolean r3 = r2.isDirectory()     // Catch:{ all -> 0x0087 }
            if (r3 != 0) goto L_0x003f
            r2.mkdir()     // Catch:{ all -> 0x0087 }
        L_0x003f:
            java.lang.String r2 = "c"
            r3 = 10
            com.umeng.commonsdk.stateless.d.a((android.content.Context) r10, (java.lang.String) r1, (java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x0087 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0083 }
            r5.<init>()     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = "c_sdk_v"
            java.lang.String r2 = "2.0"
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0083 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0083 }
            r1.<init>()     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r2 = "content"
            r1.put(r2, r11)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r11 = "ts"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0083 }
            r1.put(r11, r2)     // Catch:{ JSONException -> 0x0083 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0083 }
            r11.<init>()     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r2 = "crash"
            r11.put(r2, r1)     // Catch:{ JSONException -> 0x0083 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0083 }
            r6.<init>()     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = "tp"
            r6.put(r1, r11)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r7 = com.umeng.commonsdk.statistics.UMServerURL.PATH_INNER_CRASH     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r8 = "c"
            java.lang.String r9 = "2.0"
            r4 = r10
            com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x0083 }
        L_0x0083:
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            goto L_0x008a
        L_0x0085:
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            return
        L_0x0087:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            throw r10     // Catch:{ all -> 0x008a }
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.crash.UMCrashManager.buildEnvelope(android.content.Context, java.lang.Object):void");
    }

    public static void reportCrash(Context context, Throwable th) {
        synchronized (mObject) {
            if (!isReportCrash) {
                isReportCrash = true;
                UMWorkDispatch.sendEvent(context, a.f14770u, b.a(context).a(), a.a(th));
            }
        }
    }
}
