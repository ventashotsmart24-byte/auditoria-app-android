package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.b;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class w implements aa.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14442a = "session_start_time";

    /* renamed from: b  reason: collision with root package name */
    public static final String f14443b = "session_end_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f14444c = "session_id";

    /* renamed from: d  reason: collision with root package name */
    public static final String f14445d = "pre_session_id";

    /* renamed from: e  reason: collision with root package name */
    public static final String f14446e = "a_start_time";

    /* renamed from: f  reason: collision with root package name */
    public static final String f14447f = "a_end_time";

    /* renamed from: g  reason: collision with root package name */
    public static final String f14448g = "fg_count";

    /* renamed from: h  reason: collision with root package name */
    private static String f14449h = null;

    /* renamed from: i  reason: collision with root package name */
    private static Context f14450i = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f14451j = false;

    /* renamed from: k  reason: collision with root package name */
    private static long f14452k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f14453l = true;

    /* renamed from: m  reason: collision with root package name */
    private static long f14454m;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final w f14455a = new w();

        private a() {
        }
    }

    public static w a() {
        return a.f14455a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14450i);
        if (sharedPreferences != null) {
            long j10 = sharedPreferences.getLong(f14448g, 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(f14448g, j10 + 1);
                edit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f14448g, 0);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f14450i == null && context != null) {
            f14450i = context.getApplicationContext();
        }
        String d10 = aa.a().d(f14450i);
        try {
            f(context);
            q.a(f14450i).d((Object) null);
        } catch (Throwable unused) {
        }
        return d10;
    }

    private void f(Context context) {
        q.a(context).b(context);
        q.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f14450i == null && context != null) {
                f14450i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences != null) {
                if (sharedPreferences.getLong(f14446e, 0) == 0) {
                    MLog.e("onPause called before onResume");
                    return;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
                edit.putLong(f14447f, longValue);
                edit.putLong(f14443b, longValue);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private w() {
        aa.a().a((aa.a) this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f14448g, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void a(Context context, long j10) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14450i);
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(f14442a, j10);
            edit.commit();
        }
    }

    public void b(Context context, Object obj) {
        long j10;
        try {
            if (f14450i == null) {
                f14450i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                j10 = System.currentTimeMillis();
            } else {
                j10 = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14450i);
            if (sharedPreferences != null) {
                f14452k = sharedPreferences.getLong(f14447f, 0);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f14452k);
                String string = sharedPreferences.getString(f.aF, "");
                String appVersionName = UMUtils.getAppVersionName(f14450i);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    if (!TextUtils.isEmpty(string)) {
                        if (!string.equals(appVersionName)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                            edit.putLong(f14442a, j10);
                            edit.commit();
                            q.a(f14450i).a((Object) null, true);
                            String c10 = aa.a().c(f14450i);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + c10);
                            f14451j = true;
                            a(f14450i, j10, true);
                            return;
                        }
                    }
                    if (aa.a().e(f14450i)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                        f14451j = true;
                        edit.putLong(f14442a, j10);
                        edit.commit();
                        a(f14450i, j10, false);
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
                    f14451j = false;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f14450i == null && context != null) {
                f14450i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14450i);
            if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
                String string = sharedPreferences.getString(f.aF, "");
                String appVersionName = UMUtils.getAppVersionName(f14450i);
                if (TextUtils.isEmpty(string)) {
                    edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                    edit.putString(f.aF, appVersionName);
                    edit.commit();
                } else if (!string.equals(appVersionName)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                    int i10 = sharedPreferences.getInt("versioncode", 0);
                    String string2 = sharedPreferences.getString("pre_date", "");
                    String string3 = sharedPreferences.getString("pre_version", "");
                    String string4 = sharedPreferences.getString(f.aF, "");
                    edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                    edit.putString(f.aF, appVersionName);
                    edit.putString("vers_date", string2);
                    edit.putString("vers_pre_version", string3);
                    edit.putString("cur_version", string4);
                    edit.putInt("vers_code", i10);
                    edit.putString("vers_name", string);
                    edit.commit();
                    if (f14453l) {
                        f14453l = false;
                    }
                    if (f14451j) {
                        f14451j = false;
                        b(f14450i, longValue, true);
                        b(f14450i, longValue);
                        return;
                    }
                    return;
                }
                if (f14451j) {
                    f14451j = false;
                    if (f14453l) {
                        f14453l = false;
                    }
                    f14449h = e(context);
                    MLog.d("创建新会话: " + f14449h);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f14449h);
                    return;
                }
                f14449h = sharedPreferences.getString("session_id", (String) null);
                edit.putLong(f14446e, longValue);
                edit.putLong(f14447f, 0);
                edit.commit();
                MLog.d("延续上一个会话: " + f14449h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f14449h);
                if (f14453l) {
                    f14453l = false;
                    if (FieldManager.allow(d.E)) {
                        Context context2 = f14450i;
                        UMWorkDispatch.sendEventEx(context2, q.a.E, CoreProtocol.getInstance(context2), (Object) null, 0);
                    }
                }
                f(context);
                q.a(f14450i).a(false);
            }
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String c(Context context) {
        try {
            if (f14449h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", (String) null);
            }
        } catch (Throwable unused) {
        }
        return f14449h;
    }

    @Deprecated
    public String c() {
        return c(f14450i);
    }

    public boolean b(Context context, long j10, boolean z10) {
        String a10;
        long j11;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null || (a10 = aa.a().a(f14450i)) == null) {
                return false;
            }
            long j12 = sharedPreferences.getLong(f14446e, 0);
            long j13 = sharedPreferences.getLong(f14447f, 0);
            if (j12 <= 0 || j13 != 0) {
                return false;
            }
            if (z10) {
                try {
                    j11 = f14452k;
                    if (j11 == 0) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j10);
                        j11 = j10;
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f14452k);
                    }
                    c(f14450i, Long.valueOf(j11));
                } catch (Throwable unused) {
                }
            } else {
                c(f14450i, Long.valueOf(j10));
                j11 = j10;
            }
            JSONObject jSONObject = new JSONObject();
            if (z10) {
                jSONObject.put(g.d.a.f14261g, j11);
            } else {
                jSONObject.put(g.d.a.f14261g, j10);
            }
            JSONObject b10 = b.a().b();
            if (b10 != null && b10.length() > 0) {
                jSONObject.put("__sp", b10);
            }
            JSONObject c10 = b.a().c();
            if (c10 != null && c10.length() > 0) {
                jSONObject.put("__pp", c10);
            }
            if (FieldManager.allow(d.E)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f14454m);
                jSONObject.put(g.d.a.f14262h, f14454m);
                f14454m = 0;
            } else {
                jSONObject.put(g.d.a.f14262h, 0);
            }
            k.a(context).a(a10, jSONObject, k.a.END);
            q.a(f14450i).e();
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public void b(Context context, long j10) {
        if (PreferenceWrapper.getDefault(context) != null) {
            try {
                q.a(f14450i).c((Object) null);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(Context context, long j10, boolean z10) {
        String b10 = aa.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b10);
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j10);
            JSONObject b11 = b.a().b();
            if (b11 != null && b11.length() > 0) {
                jSONObject.put("__sp", b11);
            }
            JSONObject c10 = b.a().c();
            if (c10 != null && c10.length() > 0) {
                jSONObject.put("__pp", c10);
            }
            k.a(context).a(b10, jSONObject, k.a.INSTANTSESSIONBEGIN);
            q.a(context).a((Object) jSONObject, z10);
        } catch (Throwable unused) {
        }
        return b10;
    }

    @Deprecated
    public String b() {
        return f14449h;
    }

    public void a(String str, String str2, long j10, long j11, long j12) {
        a(f14450i, str2, j10, j11, j12);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f14450i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void a(String str, long j10, long j11, long j12) {
        if (!TextUtils.isEmpty(str)) {
            a(str, j10);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0067 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082 A[Catch:{ Exception -> 0x0095 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r7, java.lang.String r8, long r9, long r11, long r13) {
        /*
            r6 = this;
            java.lang.String r0 = f14449h
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0014
            com.umeng.analytics.pro.aa r0 = com.umeng.analytics.pro.aa.a()
            android.content.Context r1 = f14450i
            java.lang.String r0 = r0.a((android.content.Context) r1)
            f14449h = r0
        L_0x0014:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x0097
            java.lang.String r0 = f14449h
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0023
            goto L_0x0097
        L_0x0023:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0067 }
            r0.<init>()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "__f"
            r0.put(r1, r11)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r11 = "__g"
            r0.put(r11, r13)     // Catch:{ Exception -> 0x0067 }
            com.umeng.analytics.b r11 = com.umeng.analytics.b.a()     // Catch:{ Exception -> 0x0067 }
            org.json.JSONObject r11 = r11.b()     // Catch:{ Exception -> 0x0067 }
            if (r11 == 0) goto L_0x0047
            int r12 = r11.length()     // Catch:{ Exception -> 0x0067 }
            if (r12 <= 0) goto L_0x0047
            java.lang.String r12 = "__sp"
            r0.put(r12, r11)     // Catch:{ Exception -> 0x0067 }
        L_0x0047:
            com.umeng.analytics.b r11 = com.umeng.analytics.b.a()     // Catch:{ Exception -> 0x0067 }
            org.json.JSONObject r11 = r11.c()     // Catch:{ Exception -> 0x0067 }
            if (r11 == 0) goto L_0x005c
            int r12 = r11.length()     // Catch:{ Exception -> 0x0067 }
            if (r12 <= 0) goto L_0x005c
            java.lang.String r12 = "__pp"
            r0.put(r12, r11)     // Catch:{ Exception -> 0x0067 }
        L_0x005c:
            com.umeng.analytics.pro.k r11 = com.umeng.analytics.pro.k.a((android.content.Context) r7)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r12 = f14449h     // Catch:{ Exception -> 0x0067 }
            com.umeng.analytics.pro.k$a r1 = com.umeng.analytics.pro.k.a.END     // Catch:{ Exception -> 0x0067 }
            r11.a((java.lang.String) r12, (org.json.JSONObject) r0, (com.umeng.analytics.pro.k.a) r1)     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x0095 }
            r11.<init>()     // Catch:{ Exception -> 0x0095 }
            java.lang.String r12 = "__e"
            r11.put(r12, r9)     // Catch:{ Exception -> 0x0095 }
            com.umeng.analytics.pro.k r9 = com.umeng.analytics.pro.k.a((android.content.Context) r7)     // Catch:{ Exception -> 0x0095 }
            com.umeng.analytics.pro.k$a r10 = com.umeng.analytics.pro.k.a.BEGIN     // Catch:{ Exception -> 0x0095 }
            r9.a((java.lang.String) r8, (org.json.JSONObject) r11, (com.umeng.analytics.pro.k.a) r10)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r9 = "header_foreground_count"
            boolean r9 = com.umeng.commonsdk.config.FieldManager.allow(r9)     // Catch:{ Exception -> 0x0095 }
            if (r9 == 0) goto L_0x0095
            f14454m = r13     // Catch:{ Exception -> 0x0095 }
            r6.d(r7)     // Catch:{ Exception -> 0x0095 }
            android.content.Context r0 = f14450i     // Catch:{ Exception -> 0x0095 }
            r1 = 8213(0x2015, float:1.1509E-41)
            com.umeng.analytics.CoreProtocol r2 = com.umeng.analytics.CoreProtocol.getInstance(r0)     // Catch:{ Exception -> 0x0095 }
            r3 = 0
            r4 = 0
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEventEx(r0, r1, r2, r3, r4)     // Catch:{ Exception -> 0x0095 }
        L_0x0095:
            f14449h = r8
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.w.a(android.content.Context, java.lang.String, long, long, long):void");
    }

    private void a(String str, long j10) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14450i);
        if (sharedPreferences != null) {
            long j11 = sharedPreferences.getLong(f14443b, 0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("__ii", str);
                jSONObject.put("__e", j10);
                jSONObject.put(g.d.a.f14261g, j11);
                double[] location = AnalyticsConfig.getLocation();
                if (location != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("lat", location[0]);
                    jSONObject2.put("lng", location[1]);
                    jSONObject2.put("ts", System.currentTimeMillis());
                    jSONObject.put(g.d.a.f14259e, jSONObject2);
                }
                Class<?> cls = Class.forName("android.net.TrafficStats");
                Class cls2 = Integer.TYPE;
                Method method = cls.getMethod("getUidRxBytes", new Class[]{cls2});
                Method method2 = cls.getMethod("getUidTxBytes", new Class[]{cls2});
                int i10 = f14450i.getApplicationInfo().uid;
                if (i10 != -1) {
                    long longValue = ((Long) method.invoke((Object) null, new Object[]{Integer.valueOf(i10)})).longValue();
                    long longValue2 = ((Long) method2.invoke((Object) null, new Object[]{Integer.valueOf(i10)})).longValue();
                    if (longValue > 0) {
                        if (longValue2 > 0) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(f.H, longValue);
                            jSONObject3.put(f.G, longValue2);
                            jSONObject.put(g.d.a.f14258d, jSONObject3);
                        }
                    }
                    k.a(f14450i).a(str, jSONObject, k.a.NEWSESSION);
                    x.a(f14450i);
                    n.c(f14450i);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
