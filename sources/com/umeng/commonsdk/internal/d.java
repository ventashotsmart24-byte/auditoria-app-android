package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bt.aT, a.f14754e);
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, bt.aI, a.f14754e);
            if (buildEnvelopeWithExtHeader != null && !buildEnvelopeWithExtHeader.has("exception")) {
                ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
            }
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            i(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null && UMEnvelopeBuild.getTransmissionSendFlag()) {
            i(context);
        }
    }

    public static JSONObject d(Context context) {
        JSONObject b10;
        JSONArray g10;
        JSONObject a10;
        JSONArray k10;
        JSONArray j10;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.L) && (j10 = j(applicationContext)) != null && j10.length() > 0) {
                    jSONObject2.put("rs", j10);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && (k10 = k(applicationContext)) != null && k10.length() > 0) {
                    jSONObject2.put("by", k10);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (Exception e12) {
                UMCrashManager.reportCrash(applicationContext, e12);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (Exception e13) {
                UMCrashManager.reportCrash(applicationContext, e13);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ar) && (a10 = a()) != null && a10.length() > 0) {
                    jSONObject2.put("build", a10);
                }
            } catch (Exception e14) {
                UMCrashManager.reportCrash(applicationContext, e14);
            }
            try {
                JSONObject e15 = e(applicationContext);
                if (e15 != null && e15.length() > 0) {
                    jSONObject2.put("scr", e15);
                }
            } catch (Exception e16) {
                UMCrashManager.reportCrash(applicationContext, e16);
            }
            try {
                JSONObject f10 = f(applicationContext);
                if (f10 != null && f10.length() > 0) {
                    jSONObject2.put("sinfo", f10);
                }
            } catch (Exception e17) {
                UMCrashManager.reportCrash(applicationContext, e17);
            }
            try {
                if (UMConfigure.shouldCollectApl()) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "shouldCollectApl switch is on.");
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.ai) && (g10 = g(applicationContext)) != null && g10.length() > 0) {
                        jSONObject2.put("appls", g10);
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "shouldCollectApl switch is off.");
                }
            } catch (Exception e18) {
                UMCrashManager.reportCrash(applicationContext, e18);
            }
            try {
                JSONObject h10 = h(applicationContext);
                if (h10 != null && h10.length() > 0) {
                    jSONObject2.put("mem", h10);
                }
            } catch (Exception e19) {
                UMCrashManager.reportCrash(applicationContext, e19);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.as) && (b10 = b()) != null && b10.length() > 0) {
                    jSONObject2.put(bt.f13929w, b10);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(bt.aA, jSONObject2);
            } catch (JSONException e20) {
                UMCrashManager.reportCrash(applicationContext, e20);
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", a.c(context));
                jSONObject.put("a_nav_h", a.d(context));
                if (!(context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null)) {
                    jSONObject.put("a_den", (double) displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(context, e10);
            }
        }
        return jSONObject;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:2|3|4|5|(3:7|8|9)(1:10)|11|(3:13|14|15)|16|17|(3:19|20|21)|22|24|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0081 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject f(android.content.Context r5) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r5 == 0) goto L_0x00a7
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r1 = r5.getPackageName()
            java.lang.String r2 = "a_fit"
            long r3 = com.umeng.commonsdk.internal.utils.a.a(r5, r1)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = "a_alut"
            long r3 = com.umeng.commonsdk.internal.utils.a.b(r5, r1)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = "a_c"
            java.lang.String r3 = com.umeng.commonsdk.internal.utils.a.c(r5, r1)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = "a_uid"
            int r1 = com.umeng.commonsdk.internal.utils.a.d(r5, r1)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r2, r1)     // Catch:{ Exception -> 0x00a3 }
            boolean r1 = com.umeng.commonsdk.internal.utils.a.a()     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = "a_root"
            if (r1 == 0) goto L_0x0040
            r1 = 1
            r0.put(r2, r1)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x0044
        L_0x0040:
            r1 = 0
            r0.put(r2, r1)     // Catch:{ Exception -> 0x00a3 }
        L_0x0044:
            java.lang.String r1 = "tf"
            java.lang.String r2 = com.umeng.commonsdk.internal.utils.a.b()     // Catch:{ Exception -> 0x00a3 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = "s_fs"
            float r2 = com.umeng.commonsdk.internal.utils.a.a(r5)     // Catch:{ Exception -> 0x00a3 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x00a3 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = "a_meid"
            java.lang.String r2 = com.umeng.commonsdk.statistics.common.DeviceConfig.getMeid(r5)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = "a_imsi"
            java.lang.String r2 = com.umeng.commonsdk.statistics.common.DeviceConfig.getImsi(r5)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = "st"
            long r2 = com.umeng.commonsdk.internal.utils.a.c()     // Catch:{ Exception -> 0x00a3 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSimICCID(r5)     // Catch:{ Exception -> 0x00a3 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00a3 }
            if (r2 != 0) goto L_0x0081
            java.lang.String r2 = "a_iccid"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0081 }
        L_0x0081:
            java.lang.String r1 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSecondSimIMEi(r5)     // Catch:{ Exception -> 0x00a3 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00a3 }
            if (r2 != 0) goto L_0x0090
            java.lang.String r2 = "a_simei"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0090 }
        L_0x0090:
            java.lang.String r1 = "hn"
            java.lang.String r2 = com.umeng.commonsdk.internal.utils.a.d()     // Catch:{ Exception -> 0x00a3 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = "ts"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a3 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r1 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1)
        L_0x00a7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.d.f(android.content.Context):org.json.JSONObject");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r6 = r6.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray g(android.content.Context r6) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            if (r6 == 0) goto L_0x004e
            android.content.Context r6 = r6.getApplicationContext()
            java.util.List r1 = com.umeng.commonsdk.internal.utils.a.f(r6)
            if (r1 == 0) goto L_0x004e
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x004e
            java.util.Iterator r1 = r1.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r1.next()
            com.umeng.commonsdk.internal.utils.a$a r2 = (com.umeng.commonsdk.internal.utils.a.C0202a) r2
            if (r2 == 0) goto L_0x001b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0049 }
            r3.<init>()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = "a_pn"
            java.lang.String r5 = r2.f14800a     // Catch:{ Exception -> 0x0049 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = "a_la"
            java.lang.String r2 = r2.f14801b     // Catch:{ Exception -> 0x0049 }
            r3.put(r4, r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = "ts"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0049 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0049 }
            r0.put(r3)     // Catch:{ Exception -> 0x0049 }
            goto L_0x001b
        L_0x0049:
            r2 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r2)
            goto L_0x001b
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.d.g(android.content.Context):org.json.JSONArray");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r5 = r5.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject h(android.content.Context r5) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r5 == 0) goto L_0x002d
            android.content.Context r5 = r5.getApplicationContext()
            android.app.ActivityManager$MemoryInfo r1 = com.umeng.commonsdk.internal.utils.a.g(r5)
            if (r1 == 0) goto L_0x002d
            java.lang.String r2 = "t"
            long r3 = r1.totalMem     // Catch:{ Exception -> 0x0029 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r2 = "f"
            long r3 = r1.availMem     // Catch:{ Exception -> 0x0029 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r1 = "ts"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0029 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r1 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1)
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.d.h(android.content.Context):org.json.JSONObject");
    }

    private static void i(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, 32769, b.a(context).a(), (Object) null, 5000);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, a.f14771v, b.a(context).a(), (Object) null, 5000);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00af */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.json.JSONArray j(android.content.Context r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x00c2
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ all -> 0x00be }
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ all -> 0x00be }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x00c2
            r2 = 2147483647(0x7fffffff, float:NaN)
            java.util.List r1 = r1.getRunningServices(r2)     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x00c2
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x00be }
            if (r2 != 0) goto L_0x00c2
            r2 = 0
        L_0x0021:
            int r3 = r1.size()     // Catch:{ all -> 0x00be }
            if (r2 >= r3) goto L_0x0090
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x00be }
            android.app.ActivityManager$RunningServiceInfo r3 = (android.app.ActivityManager.RunningServiceInfo) r3     // Catch:{ all -> 0x00be }
            android.content.ComponentName r3 = r3.service     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x00be }
            android.app.ActivityManager$RunningServiceInfo r3 = (android.app.ActivityManager.RunningServiceInfo) r3     // Catch:{ all -> 0x00be }
            android.content.ComponentName r3 = r3.service     // Catch:{ all -> 0x00be }
            java.lang.String r3 = r3.getClassName()     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x00be }
            android.app.ActivityManager$RunningServiceInfo r3 = (android.app.ActivityManager.RunningServiceInfo) r3     // Catch:{ all -> 0x00be }
            android.content.ComponentName r3 = r3.service     // Catch:{ all -> 0x00be }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x008d
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008d }
            r3.<init>()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r4 = "sn"
            java.lang.Object r5 = r1.get(r2)     // Catch:{ JSONException -> 0x008d }
            android.app.ActivityManager$RunningServiceInfo r5 = (android.app.ActivityManager.RunningServiceInfo) r5     // Catch:{ JSONException -> 0x008d }
            android.content.ComponentName r5 = r5.service     // Catch:{ JSONException -> 0x008d }
            java.lang.String r5 = r5.getClassName()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x008d }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r4 = "pn"
            java.lang.Object r5 = r1.get(r2)     // Catch:{ JSONException -> 0x008d }
            android.app.ActivityManager$RunningServiceInfo r5 = (android.app.ActivityManager.RunningServiceInfo) r5     // Catch:{ JSONException -> 0x008d }
            android.content.ComponentName r5 = r5.service     // Catch:{ JSONException -> 0x008d }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x008d }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x008d }
            if (r0 != 0) goto L_0x008a
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x008d }
            r4.<init>()     // Catch:{ JSONException -> 0x008d }
            r0 = r4
        L_0x008a:
            r0.put(r3)     // Catch:{ JSONException -> 0x008d }
        L_0x008d:
            int r2 = r2 + 1
            goto L_0x0021
        L_0x0090:
            if (r0 == 0) goto L_0x00c2
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00be }
            r1.<init>()     // Catch:{ all -> 0x00be }
            java.lang.String r2 = "ts"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00a5 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x00a5 }
            java.lang.String r2 = "ls"
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x00a5 }
        L_0x00a5:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x00be }
            r2.<init>()     // Catch:{ all -> 0x00be }
            java.lang.String r3 = "sers"
            r2.put(r3, r1)     // Catch:{ JSONException -> 0x00af }
        L_0x00af:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x00be }
            r1.<init>()     // Catch:{ all -> 0x00be }
            r1.put(r2)     // Catch:{ all -> 0x00b9 }
            r0 = r1
            goto L_0x00c2
        L_0x00b9:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x00bf
        L_0x00be:
            r1 = move-exception
        L_0x00bf:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r7, r1)
        L_0x00c2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.d.j(android.content.Context):org.json.JSONArray");
    }

    private static JSONArray k(Context context) {
        JSONArray jSONArray = new JSONArray();
        String a10 = j.a(context);
        if (!TextUtils.isEmpty(a10)) {
            try {
                jSONArray.put(new JSONObject(a10));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONObject b() {
        try {
            d.a a10 = com.umeng.commonsdk.internal.utils.d.a();
            if (a10 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", a10.f14814a);
                jSONObject.put("pla", a10.f14815b);
                jSONObject.put("cpus", a10.f14816c);
                jSONObject.put("fea", a10.f14817d);
                jSONObject.put(bd.f13843c, a10.f14818e);
                jSONObject.put("arc", a10.f14819f);
                jSONObject.put("var", a10.f14820g);
                jSONObject.put("par", a10.f14821h);
                jSONObject.put("rev", a10.f14822i);
                jSONObject.put("har", a10.f14823j);
                jSONObject.put("rev", a10.f14824k);
                jSONObject.put("ser", a10.f14825l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getApplicationContext().getPackageManager()) != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
            a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
            a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
            a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
            a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
        }
    }

    private static void a(JSONObject jSONObject, String str, boolean z10) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            if (z10) {
                try {
                    jSONObject.put(str, 1);
                } catch (Exception unused) {
                }
            } else {
                jSONObject.put(str, 0);
            }
        }
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            int i10 = Build.VERSION.SDK_INT;
            jSONObject.put("a_rv", Build.getRadioVersion());
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            if (i10 >= 21) {
                JSONArray jSONArray = new JSONArray();
                for (String put : Build.SUPPORTED_32_BIT_ABIS) {
                    jSONArray.put(put);
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                for (String put2 : Build.SUPPORTED_64_BIT_ABIS) {
                    jSONArray2.put(put2);
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                for (String put3 : Build.SUPPORTED_ABIS) {
                    jSONArray3.put(put3);
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("a_sa", jSONArray3);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a10 = k.a(context);
            if (!TextUtils.isEmpty(a10)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(a10);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (jSONObject2.has(k.f14837d)) {
                        jSONObject.put(k.f14837d, jSONObject2.opt(k.f14837d));
                    }
                    if (jSONObject2.has(k.f14836c)) {
                        jSONObject.put(k.f14836c, jSONObject2.opt(k.f14836c));
                    }
                    if (jSONObject2.has(k.f14835b)) {
                        jSONObject.put(k.f14835b, jSONObject2.opt(k.f14835b));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
