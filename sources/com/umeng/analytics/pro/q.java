package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrashUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class q {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Context f14362a = null;

    /* renamed from: l  reason: collision with root package name */
    private static final String f14363l = "first_activate_time";

    /* renamed from: m  reason: collision with root package name */
    private static final String f14364m = "ana_is_f";

    /* renamed from: n  reason: collision with root package name */
    private static final String f14365n = "thtstart";

    /* renamed from: o  reason: collision with root package name */
    private static final String f14366o = "dstk_last_time";

    /* renamed from: p  reason: collision with root package name */
    private static final String f14367p = "dstk_cnt";

    /* renamed from: q  reason: collision with root package name */
    private static final String f14368q = "gkvc";

    /* renamed from: r  reason: collision with root package name */
    private static final String f14369r = "ekvc";

    /* renamed from: t  reason: collision with root package name */
    private static final String f14370t = "-1";

    /* renamed from: x  reason: collision with root package name */
    private static final String f14371x = "com.umeng.umcrash.UMCrashUtils";

    /* renamed from: y  reason: collision with root package name */
    private static Class<?> f14372y;

    /* renamed from: z  reason: collision with root package name */
    private static Method f14373z;

    /* renamed from: b  reason: collision with root package name */
    private c f14374b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f14375c;

    /* renamed from: d  reason: collision with root package name */
    private String f14376d;

    /* renamed from: e  reason: collision with root package name */
    private String f14377e;

    /* renamed from: f  reason: collision with root package name */
    private int f14378f;

    /* renamed from: g  reason: collision with root package name */
    private JSONArray f14379g;

    /* renamed from: h  reason: collision with root package name */
    private final int f14380h;

    /* renamed from: i  reason: collision with root package name */
    private int f14381i;

    /* renamed from: j  reason: collision with root package name */
    private int f14382j;

    /* renamed from: k  reason: collision with root package name */
    private long f14383k;

    /* renamed from: s  reason: collision with root package name */
    private final long f14384s;

    /* renamed from: u  reason: collision with root package name */
    private boolean f14385u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f14386v;

    /* renamed from: w  reason: collision with root package name */
    private Object f14387w;

    public static class a {
        public static final int A = 8209;
        public static final int B = 8210;
        public static final int C = 8211;
        public static final int D = 8212;
        public static final int E = 8213;
        public static final int F = 8214;
        public static final int G = 8215;

        /* renamed from: a  reason: collision with root package name */
        public static final int f14388a = 4097;

        /* renamed from: b  reason: collision with root package name */
        public static final int f14389b = 4098;

        /* renamed from: c  reason: collision with root package name */
        public static final int f14390c = 4099;

        /* renamed from: d  reason: collision with root package name */
        public static final int f14391d = 4100;

        /* renamed from: e  reason: collision with root package name */
        public static final int f14392e = 4101;

        /* renamed from: f  reason: collision with root package name */
        public static final int f14393f = 4102;

        /* renamed from: g  reason: collision with root package name */
        public static final int f14394g = 4103;

        /* renamed from: h  reason: collision with root package name */
        public static final int f14395h = 4104;

        /* renamed from: i  reason: collision with root package name */
        public static final int f14396i = 4105;

        /* renamed from: j  reason: collision with root package name */
        public static final int f14397j = 4106;

        /* renamed from: k  reason: collision with root package name */
        public static final int f14398k = 4352;

        /* renamed from: l  reason: collision with root package name */
        public static final int f14399l = 4353;

        /* renamed from: m  reason: collision with root package name */
        public static final int f14400m = 4354;

        /* renamed from: n  reason: collision with root package name */
        public static final int f14401n = 4355;

        /* renamed from: o  reason: collision with root package name */
        public static final int f14402o = 4356;

        /* renamed from: p  reason: collision with root package name */
        public static final int f14403p = 4357;

        /* renamed from: q  reason: collision with root package name */
        public static final int f14404q = 4358;

        /* renamed from: r  reason: collision with root package name */
        public static final int f14405r = 8193;

        /* renamed from: s  reason: collision with root package name */
        public static final int f14406s = 8194;

        /* renamed from: t  reason: collision with root package name */
        public static final int f14407t = 8195;

        /* renamed from: u  reason: collision with root package name */
        public static final int f14408u = 8196;

        /* renamed from: v  reason: collision with root package name */
        public static final int f14409v = 8197;

        /* renamed from: w  reason: collision with root package name */
        public static final int f14410w = 8199;

        /* renamed from: x  reason: collision with root package name */
        public static final int f14411x = 8200;

        /* renamed from: y  reason: collision with root package name */
        public static final int f14412y = 8201;

        /* renamed from: z  reason: collision with root package name */
        public static final int f14413z = 8208;
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final q f14414a = new q();

        private b() {
        }
    }

    static {
        h();
    }

    public static q a(Context context) {
        if (f14362a == null && context != null) {
            f14362a = context.getApplicationContext();
        }
        return b.f14414a;
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (a(this.f14383k, this.f14381i)) {
                    this.f14381i++;
                } else {
                    return;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (a(this.f14383k, this.f14382j)) {
                    this.f14382j++;
                } else {
                    return;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f14379g == null) {
                    this.f14379g = new JSONArray();
                }
                this.f14379g.put(jSONObject);
                k.a(f14362a).a(this.f14379g);
                this.f14379g = new JSONArray();
                return;
            }
            if (this.f14379g.length() >= this.f14378f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                k.a(f14362a).a(this.f14379g);
                this.f14379g = new JSONArray();
            }
            if (this.f14383k == 0) {
                this.f14383k = System.currentTimeMillis();
            }
            this.f14379g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(f.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                    if (jSONObject2.has(f.f14199n) && (optJSONObject2 = jSONObject2.getJSONArray(f.f14199n).optJSONObject(0)) != null) {
                        String optString = optJSONObject2.optString("id");
                        if (!TextUtils.isEmpty(optString)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                            k.a(f14362a).b(optString);
                        }
                    }
                }
                k.a(f14362a).b();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
                Context context = f14362a;
                UMWorkDispatch.sendEvent(context, a.f14399l, CoreProtocol.getInstance(context), (Object) null);
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has(f.f14199n)) {
                k.a(f14362a).a(true, false);
            }
            k.a(f14362a).b();
        } catch (Exception unused) {
        }
    }

    private static void h() {
        Class<String> cls = String.class;
        Class<UMCrashUtils> cls2 = UMCrashUtils.class;
        try {
            f14372y = cls2;
            Method declaredMethod = cls2.getDeclaredMethod("setPuidAndProvider", new Class[]{cls, cls});
            if (declaredMethod != null) {
                f14373z = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        JSONObject b10 = b(UMEnvelopeBuild.maxDataSpace(f14362a));
        if (b10 != null && b10.length() >= 1) {
            JSONObject jSONObject = (JSONObject) b10.opt("header");
            JSONObject jSONObject2 = (JSONObject) b10.opt("content");
            if (f14362a != null && jSONObject != null && jSONObject2 != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
                JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f14362a, jSONObject, jSONObject2);
                if (buildEnvelopeWithExtHeader != null) {
                    try {
                        if (buildEnvelopeWithExtHeader.has("exception")) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                        }
                    } catch (Throwable unused) {
                    }
                    if (UMConfigure.isDebugLog()) {
                        e(buildEnvelopeWithExtHeader);
                    }
                    b((Object) buildEnvelopeWithExtHeader);
                }
            }
        }
    }

    private void j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject a10 = a(UMEnvelopeBuild.maxDataSpace(f14362a));
        if (a10 != null && a10.length() >= 1) {
            JSONObject jSONObject = (JSONObject) a10.opt("header");
            JSONObject jSONObject2 = (JSONObject) a10.opt("content");
            Context context = f14362a;
            if (context != null && jSONObject != null && jSONObject2 != null && (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) != null) {
                try {
                    if (buildEnvelopeWithExtHeader.has("exception")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                    }
                } catch (Throwable unused) {
                }
                if (UMConfigure.isDebugLog()) {
                    d(buildEnvelopeWithExtHeader);
                }
                a((Object) buildEnvelopeWithExtHeader);
            }
        }
    }

    private JSONObject k() {
        JSONObject l10 = l();
        if (l10 != null) {
            try {
                l10.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return l10;
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!(AnalyticsConfig.mWrapperType == null || AnalyticsConfig.mWrapperVersion == null)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f14362a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f14194i), verticalType);
            String str = "9.7.9";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f14362a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), str);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), str);
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f14362a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f14362a, "pr_ve", (String) null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14362a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f14362a, f.at, "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.av), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.av), imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f14362a, f.au, "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.aw), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.aw), imprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.an), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.ap), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f14364m, 0).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f14197l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f14198m), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f14197l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f14198m), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f14362a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String m() {
        String str = "0";
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f14362a, "pr_ve", (String) null);
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(this.f14376d)) {
                    return this.f14376d;
                }
                if (this.f14375c == null) {
                    this.f14375c = PreferenceWrapper.getDefault(f14362a);
                }
                String string = this.f14375c.getString("pre_version", "");
                String appVersionName = DeviceConfig.getAppVersionName(f14362a);
                if (TextUtils.isEmpty(string)) {
                    this.f14375c.edit().putString("pre_version", str).putString("cur_version", appVersionName).commit();
                } else {
                    str = this.f14375c.getString("cur_version", "");
                    if (!appVersionName.equals(str)) {
                        this.f14375c.edit().putString("pre_version", str).putString("cur_version", appVersionName).commit();
                    } else {
                        str = string;
                    }
                }
                this.f14376d = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        str = str2;
        this.f14376d = str;
        return str;
    }

    private String n() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f14362a, "ud_da", (String) null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f14377e)) {
                    return this.f14377e;
                }
                if (this.f14375c == null) {
                    this.f14375c = PreferenceWrapper.getDefault(f14362a);
                }
                String string = this.f14375c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f14375c.edit().putString("pre_date", string).commit();
                } else {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(format)) {
                        this.f14375c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
                str = string;
            }
        } catch (Throwable unused) {
        }
        this.f14377e = str;
        return str;
    }

    private void o() {
        try {
            this.f14381i = 0;
            this.f14382j = 0;
            this.f14383k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f14362a).edit().putLong(f14366o, System.currentTimeMillis()).putInt(f14367p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(w.a().b())) {
                b(f14362a);
            }
            if (this.f14379g.length() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < this.f14379g.length(); i10++) {
                JSONObject optJSONObject = this.f14379g.optJSONObject(i10);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || f14370t.equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        if (r6.equals(r4) != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q() {
        /*
            r7 = this;
            java.lang.String r0 = "__i"
            org.json.JSONArray r1 = r7.f14379g
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0057
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            r2 = 0
        L_0x0010:
            org.json.JSONArray r3 = r7.f14379g
            int r3 = r3.length()
            if (r2 >= r3) goto L_0x0055
            org.json.JSONArray r3 = r7.f14379g     // Catch:{ all -> 0x0052 }
            org.json.JSONObject r3 = r3.getJSONObject(r2)     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x004f
            int r4 = r3.length()     // Catch:{ all -> 0x0052 }
            if (r4 <= 0) goto L_0x004f
            java.lang.String r4 = r3.optString(r0)     // Catch:{ all -> 0x0052 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = "-1"
            if (r5 != 0) goto L_0x0038
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x004b
        L_0x0038:
            com.umeng.analytics.pro.w r4 = com.umeng.analytics.pro.w.a()     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0052 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0052 }
            if (r5 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r6 = r4
        L_0x0048:
            r3.put(r0, r6)     // Catch:{ all -> 0x0052 }
        L_0x004b:
            r1.put(r3)     // Catch:{ all -> 0x0052 }
            goto L_0x0052
        L_0x004f:
            r1.put(r3)     // Catch:{ all -> 0x0052 }
        L_0x0052:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x0055:
            r7.f14379g = r1
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.q.q():void");
    }

    private void r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (s() && (context = f14362a) != null && (sharedPreferences = PreferenceWrapper.getDefault(context)) != null && sharedPreferences.getLong(f14363l, 0) == 0) {
                sharedPreferences.edit().putLong(f14363l, System.currentTimeMillis()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = f14362a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong(f14364m, -1) == 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        b(f14362a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f14379g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                k.a(f14362a).a(this.f14379g);
                this.f14379g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f14362a).edit().putLong(f14365n, this.f14383k).putInt(f14368q, this.f14381i).putInt(f14369r, this.f14382j).commit();
        } catch (Throwable unused) {
        }
    }

    private q() {
        this.f14374b = null;
        this.f14375c = null;
        this.f14376d = null;
        this.f14377e = null;
        this.f14378f = 10;
        this.f14379g = new JSONArray();
        this.f14380h = com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT;
        this.f14381i = 0;
        this.f14382j = 0;
        this.f14383k = 0;
        this.f14384s = 28800000;
        this.f14385u = false;
        this.f14386v = false;
        this.f14387w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14362a);
            this.f14383k = sharedPreferences.getLong(f14365n, 0);
            this.f14381i = sharedPreferences.getInt(f14368q, 0);
            this.f14382j = sharedPreferences.getInt(f14369r, 0);
            this.f14374b = new c();
        } catch (Throwable unused) {
        }
    }

    private void b(JSONObject jSONObject) {
        JSONObject f10;
        if (!k.a(UMGlobalContext.getAppContext(f14362a)).c() && (f10 = k.a(UMGlobalContext.getAppContext(f14362a)).f()) != null) {
            String optString = f10.optString("__av");
            String optString2 = f10.optString("__vc");
            try {
                if (TextUtils.isEmpty(optString)) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f14362a));
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
                }
                if (TextUtils.isEmpty(optString2)) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f14362a));
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(f.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (!jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    return;
                }
                if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(f.f14199n)) {
                    k.a(f14362a).i();
                    k.a(f14362a).h();
                    k.a(f14362a).b(true, false);
                    k.a(f14362a).a();
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(f.f14199n)) {
                    k.a(f14362a).b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has(f.Z)) {
                    k.a(f14362a).h();
                }
                if (optJSONObject.has("error")) {
                    k.a(f14362a).i();
                }
            }
            k.a(f14362a).a();
        } catch (Exception unused) {
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private ReportPolicy.ReportStrategy f14415a;

        /* renamed from: b  reason: collision with root package name */
        private int f14416b;

        /* renamed from: c  reason: collision with root package name */
        private int f14417c;

        /* renamed from: d  reason: collision with root package name */
        private int f14418d;

        /* renamed from: e  reason: collision with root package name */
        private int f14419e;

        /* renamed from: f  reason: collision with root package name */
        private ABTest f14420f;

        public c() {
            this.f14415a = null;
            this.f14416b = -1;
            this.f14417c = -1;
            this.f14418d = -1;
            this.f14419e = -1;
            this.f14420f = null;
            this.f14420f = ABTest.getService(q.f14362a);
        }

        public void a() {
            try {
                int[] a10 = a(-1, -1);
                this.f14416b = a10[0];
                this.f14417c = a10[1];
            } catch (Throwable unused) {
            }
        }

        public void b() {
            int i10;
            Defcon service = Defcon.getService(q.f14362a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f14415a;
                this.f14415a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.f14415a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(q.f14362a), service);
            } else {
                boolean z10 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f14362a, "integrated_test", q.f14370t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z10 && !MLog.DEBUG) {
                    UMLog.mutlInfo(l.K, 3, "\\|", (String[]) null, (String[]) null);
                }
                if (MLog.DEBUG && z10) {
                    this.f14415a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(q.f14362a));
                } else if (!this.f14420f.isInTest() || !"RPT".equals(this.f14420f.getTestName())) {
                    int i11 = this.f14418d;
                    int i12 = this.f14419e;
                    int i13 = this.f14416b;
                    if (i13 != -1) {
                        i12 = this.f14417c;
                        i11 = i13;
                    }
                    this.f14415a = b(i11, i12);
                } else {
                    if (this.f14420f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f14362a, "test_report_interval", q.f14370t)).intValue() != -1) {
                            i10 = a(90000);
                        } else {
                            i10 = this.f14417c;
                            if (i10 <= 0) {
                                i10 = this.f14419e;
                            }
                        }
                    } else {
                        i10 = 0;
                    }
                    this.f14415a = b(this.f14420f.getTestPolicy(), i10);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.f14415a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(l.I, 3, "", (String[]) null, (String[]) null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(l.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(l.L, 3, "", (String[]) null, (String[]) null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        UMLog.mutlInfo(l.M, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)});
                    } else {
                        boolean z11 = reportStrategy2 instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f14415a;
        }

        public int[] a(int i10, int i11) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f14362a, "report_policy", q.f14370t)).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f14362a, "report_interval", q.f14370t)).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i10, i11};
            }
            if (6 == intValue) {
                if (intValue2 == -1 || intValue2 < 90 || intValue2 > 86400) {
                    intValue2 = 90;
                }
                return new int[]{intValue, intValue2 * 1000};
            } else if (11 != intValue) {
                return new int[]{i10, i11};
            } else {
                if (intValue2 == -1 || intValue2 < 15 || intValue2 > 3600) {
                    intValue2 = 15;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
        }

        public int a(int i10) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f14362a, "test_report_interval", q.f14370t)).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i10 : intValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i10, int i11) {
            if (i10 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f14415a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            } else if (i10 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f14415a;
                if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                    return reportStrategy2;
                }
                return new ReportPolicy.ReportAtLaunch();
            } else if (i10 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f14415a;
                if (reportStrategy3 instanceof ReportPolicy.ReportDaily) {
                    return reportStrategy3;
                }
                return new ReportPolicy.ReportDaily(StatTracer.getInstance(q.f14362a));
            } else if (i10 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f14415a;
                if (reportStrategy4 instanceof ReportPolicy.ReportWifiOnly) {
                    return reportStrategy4;
                }
                return new ReportPolicy.ReportWifiOnly(q.f14362a);
            } else if (i10 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f14415a;
                if (!(reportStrategy5 instanceof ReportPolicy.ReportByInterval)) {
                    return new ReportPolicy.ReportByInterval(StatTracer.getInstance(q.f14362a), (long) i11);
                }
                ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval((long) i11);
                return reportStrategy5;
            } else if (i10 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f14415a;
                if (reportStrategy6 instanceof ReportPolicy.SmartPolicy) {
                    return reportStrategy6;
                }
                return new ReportPolicy.SmartPolicy(StatTracer.getInstance(q.f14362a));
            } else if (i10 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f14415a;
                if (reportStrategy7 instanceof ReportPolicy.ReportAtLaunch) {
                    return reportStrategy7;
                }
                return new ReportPolicy.ReportAtLaunch();
            } else {
                ReportPolicy.ReportStrategy reportStrategy8 = this.f14415a;
                if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                    ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval((long) i11);
                    return reportStrategy8;
                }
                ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
                reportQuasiRealtime.setReportInterval((long) i11);
                return reportQuasiRealtime;
            }
        }
    }

    private void c(JSONObject jSONObject) {
        if (!k.a(f14362a).e()) {
            JSONObject g10 = k.a(f14362a).g();
            if (g10 != null) {
                String optString = g10.optString("__av");
                String optString2 = g10.optString("__vc");
                try {
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f14362a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f14362a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
                    }
                } catch (Throwable unused) {
                }
            }
        } else {
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f14362a));
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f14362a));
        }
    }

    public void a() {
        if (f14362a != null) {
            synchronized (this.f14387w) {
                if (this.f14385u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    Context context = f14362a;
                    UMWorkDispatch.sendEvent(context, a.f14399l, CoreProtocol.getInstance(context), (Object) null);
                }
            }
            synchronized (this.f14387w) {
                if (this.f14386v) {
                    Context context2 = f14362a;
                    UMWorkDispatch.sendEvent(context2, a.f14400m, CoreProtocol.getInstance(context2), (Object) null);
                }
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Object> f14421a;

        /* renamed from: b  reason: collision with root package name */
        private String f14422b;

        /* renamed from: c  reason: collision with root package name */
        private String f14423c;

        /* renamed from: d  reason: collision with root package name */
        private long f14424d;

        private d() {
            this.f14421a = null;
            this.f14422b = null;
            this.f14423c = null;
            this.f14424d = 0;
        }

        public Map<String, Object> a() {
            return this.f14421a;
        }

        public String b() {
            return this.f14423c;
        }

        public String c() {
            return this.f14422b;
        }

        public long d() {
            return this.f14424d;
        }

        public d(String str, Map<String, Object> map, String str2, long j10) {
            this.f14421a = map;
            this.f14422b = str;
            this.f14424d = j10;
            this.f14423c = str2;
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0 && jSONObject.has("__ii")) {
                String optString = jSONObject.optString("__ii");
                jSONObject.remove("__ii");
                if (!TextUtils.isEmpty(optString)) {
                    k.a(f14362a).a(optString, obj.toString(), 2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject;
        String str = "channel";
        if (jSONObject3 != null) {
            try {
                if (jSONObject.length() > 0) {
                    String str2 = "appkey";
                    JSONObject jSONObject4 = new JSONObject();
                    String str3 = "version_code";
                    if (jSONObject3.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                        JSONObject jSONObject5 = jSONObject3.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                        if (jSONObject5.has("ekv")) {
                            jSONObject4.put("ekv", jSONObject5.getJSONArray("ekv"));
                            if (jSONObject4.length() > 0) {
                                if (AnalyticsConfig.isRealTimeDebugMode()) {
                                    MLog.d("[埋点验证模式]事件:" + jSONObject4.toString());
                                } else {
                                    MLog.d("事件:" + jSONObject4.toString());
                                }
                                jSONObject4 = new JSONObject();
                            }
                        }
                        if (jSONObject5.has(f.Z)) {
                            jSONObject4.put(f.Z, jSONObject5.getJSONArray(f.Z));
                            if (jSONObject4.length() > 0) {
                                if (AnalyticsConfig.isRealTimeDebugMode()) {
                                    MLog.d("[埋点验证模式]游戏事件:" + jSONObject4.toString());
                                } else {
                                    MLog.d("游戏事件:" + jSONObject4.toString());
                                }
                                jSONObject4 = new JSONObject();
                            }
                        }
                        if (jSONObject5.has("error")) {
                            jSONObject4.put("error", jSONObject5.getJSONArray("error"));
                            if (jSONObject4.length() > 0) {
                                if (AnalyticsConfig.isRealTimeDebugMode()) {
                                    MLog.d("[埋点验证模式]错误:" + jSONObject4.toString());
                                } else {
                                    MLog.d("错误:" + jSONObject4.toString());
                                }
                                jSONObject4 = new JSONObject();
                            }
                        }
                        if (jSONObject5.has(f.f14199n)) {
                            JSONArray jSONArray = jSONObject5.getJSONArray(f.f14199n);
                            JSONArray jSONArray2 = new JSONArray();
                            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                JSONObject jSONObject6 = jSONArray.getJSONObject(i10);
                                if (jSONObject6 != null && jSONObject6.length() > 0) {
                                    if (jSONObject6.has(f.f14206u)) {
                                        jSONObject6.remove(f.f14206u);
                                    }
                                    jSONArray2.put(jSONObject6);
                                }
                            }
                            jSONObject4.put(f.f14199n, jSONArray2);
                            if (jSONObject4.length() > 0) {
                                if (AnalyticsConfig.isRealTimeDebugMode()) {
                                    MLog.d("[埋点验证模式]会话:" + jSONObject4.toString());
                                } else {
                                    MLog.d("会话:" + jSONObject4.toString());
                                }
                                jSONObject4 = new JSONObject();
                            }
                        }
                        if (jSONObject5.has(f.I)) {
                            jSONObject4.put(f.I, jSONObject5.getJSONObject(f.I));
                        }
                        if (jSONObject5.has(f.L)) {
                            jSONObject4.put(f.L, jSONObject5.getJSONObject(f.L));
                            if (jSONObject4.length() > 0) {
                                if (AnalyticsConfig.isRealTimeDebugMode()) {
                                    MLog.d("[埋点验证模式]账号:" + jSONObject4.toString());
                                } else {
                                    MLog.d("账号:" + jSONObject4.toString());
                                }
                                jSONObject4 = new JSONObject();
                            }
                        }
                    }
                    if (jSONObject3.has("dplus")) {
                        jSONObject4.put("dplus", jSONObject3.getJSONObject("dplus"));
                    }
                    if (jSONObject3.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject3.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                            jSONObject4.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                            jSONObject4.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                            jSONObject4.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a(str3))) {
                            jSONObject4.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a(str3)));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a(str2))) {
                            jSONObject4.put(str2, jSONObject2.getString(com.umeng.commonsdk.statistics.b.a(str2)));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a(str))) {
                            jSONObject4.put(str, jSONObject2.getString(com.umeng.commonsdk.statistics.b.a(str)));
                        }
                        if (jSONObject4.length() > 0) {
                            MLog.d("基础信息:" + jSONObject4.toString());
                            jSONObject4 = new JSONObject();
                        }
                    }
                    jSONObject4.length();
                }
            } catch (Throwable th) {
                MLog.e(th);
            }
        }
    }

    public JSONObject b(long j10) {
        if (TextUtils.isEmpty(aa.a().d(UMGlobalContext.getAppContext(f14362a)))) {
            return null;
        }
        JSONObject b10 = k.a(UMGlobalContext.getAppContext(f14362a)).b(false);
        String[] a10 = com.umeng.analytics.c.a(f14362a);
        if (a10 != null && !TextUtils.isEmpty(a10[0]) && !TextUtils.isEmpty(a10[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f.M, a10[0]);
                jSONObject.put(f.N, a10[1]);
                if (jSONObject.length() > 0) {
                    b10.put(f.L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int a11 = t.a().a(f14362a);
        if (b10.length() == 1 && b10.optJSONObject(f.L) != null && a11 != 3) {
            return null;
        }
        t.a().b(b10, f14362a);
        if (b10.length() <= 0 && a11 != 3) {
            return null;
        }
        JSONObject k10 = k();
        if (k10 != null) {
            b(k10);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (a11 == 3) {
            try {
                jSONObject3.put("analytics", new JSONObject());
            } catch (Throwable unused2) {
                return jSONObject2;
            }
        } else if (b10.length() > 0) {
            jSONObject3.put("analytics", b10);
        }
        if (k10 != null && k10.length() > 0) {
            jSONObject2.put("header", k10);
        }
        if (jSONObject3.length() > 0) {
            jSONObject2.put("content", jSONObject3);
        }
        return b(jSONObject2, j10);
    }

    private boolean c(boolean z10) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.f14374b == null) {
            this.f14374b = new c();
        }
        this.f14374b.a();
        ReportPolicy.ReportStrategy c10 = this.f14374b.c();
        boolean shouldSendMessage = c10.shouldSendMessage(z10);
        if (shouldSendMessage) {
            if (((c10 instanceof ReportPolicy.ReportByInterval) || (c10 instanceof ReportPolicy.DebugPolicy) || (c10 instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((c10 instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + c10.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = f14372y;
        if (cls != null && (method = f14373z) != null) {
            try {
                method.invoke(cls, new Object[]{str, str2});
            } catch (Throwable unused) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
            }
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject;
        if (jSONObject3 != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject3.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                        JSONObject jSONObject5 = jSONObject3.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                        if (jSONObject5.has(f.f14199n)) {
                            JSONArray jSONArray = jSONObject5.getJSONArray(f.f14199n);
                            JSONArray jSONArray2 = new JSONArray();
                            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                JSONObject jSONObject6 = jSONArray.getJSONObject(i10);
                                if (jSONObject6 != null && jSONObject6.length() > 0) {
                                    jSONArray2.put(jSONObject6);
                                }
                            }
                            jSONObject4.put(f.f14199n, jSONArray2);
                            if (jSONObject4.length() > 0) {
                                MLog.d("本次启动会话:" + jSONObject4.toString());
                                jSONObject4 = new JSONObject();
                            }
                        }
                        if (jSONObject5.has(f.L)) {
                            jSONObject4.put(f.L, jSONObject5.getJSONObject(f.L));
                            if (jSONObject4.length() > 0) {
                                MLog.d("本次启动账号:" + jSONObject4.toString());
                                jSONObject4 = new JSONObject();
                            }
                        }
                    }
                    if (jSONObject3.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject3.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject3.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                            jSONObject4.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                            jSONObject4.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                            jSONObject4.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                            jSONObject4.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                            jSONObject4.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                        }
                        if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                            jSONObject4.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                        }
                        if (jSONObject4.length() > 0) {
                            MLog.d("本次启动基础信息:" + jSONObject4.toString());
                            jSONObject4 = new JSONObject();
                        }
                    }
                    jSONObject4.length();
                }
            } catch (Throwable th) {
                MLog.e(th);
            }
        }
    }

    public void a(Object obj, int i10) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i10 == 4357) {
                try {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                    j.a(f14362a);
                    com.umeng.commonsdk.utils.c.c(f14362a);
                } catch (Throwable unused) {
                }
            } else {
                return;
            }
        }
        if (AnalyticsConfig.enable) {
            if (i10 != 4358) {
                switch (i10) {
                    case a.f14388a /*4097*/:
                        if (UMUtils.isMainProgress(f14362a)) {
                            if (obj != null) {
                                e(obj);
                            }
                            if (!f14370t.equals(((JSONObject) obj).optString("__i"))) {
                                a(false);
                                return;
                            }
                            return;
                        }
                        UMProcessDBHelper.getInstance(f14362a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f14362a), new JSONArray().put(obj));
                        return;
                    case a.f14389b /*4098*/:
                        if (obj != null) {
                            e(obj);
                        }
                        if (!f14370t.equals(((JSONObject) obj).optString("__i"))) {
                            a(false);
                            return;
                        }
                        return;
                    case a.f14390c /*4099*/:
                        x.a(f14362a);
                        return;
                    case a.f14391d /*4100*/:
                        n.c(f14362a);
                        return;
                    case a.f14392e /*4101*/:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                        a((Object) null, true);
                        g(obj);
                        return;
                    case a.f14393f /*4102*/:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                        a((Object) null, true);
                        f(obj);
                        return;
                    case a.f14394g /*4103*/:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                        w.a().a(f14362a, obj);
                        synchronized (this.f14387w) {
                            this.f14386v = true;
                        }
                        return;
                    case a.f14395h /*4104*/:
                        w.a().c(f14362a, obj);
                        return;
                    case a.f14396i /*4105*/:
                        d();
                        return;
                    case a.f14397j /*4106*/:
                        h(obj);
                        return;
                    default:
                        switch (i10) {
                            case 4352:
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                w.a().b(f14362a, obj);
                                synchronized (this.f14387w) {
                                    this.f14385u = true;
                                }
                                return;
                            case a.f14399l /*4353*/:
                                a(obj, true);
                                return;
                            case a.f14400m /*4354*/:
                                c();
                                return;
                            case a.f14401n /*4355*/:
                                if (!UMUtils.isMainProgress(f14362a)) {
                                    UMProcessDBHelper.getInstance(f14362a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f14362a), new JSONArray().put(obj));
                                    return;
                                } else if (obj != null) {
                                    e(obj);
                                    d();
                                    return;
                                } else {
                                    return;
                                }
                            case a.f14402o /*4356*/:
                                if (obj != null && f14372y != null && f14373z != null) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                    String str = "";
                                    String str2 = "";
                                    if (obj instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.has(ParamsMap.DeviceParams.KEY_UID) && jSONObject.has(f.M)) {
                                            str = jSONObject.getString(f.M);
                                            str2 = jSONObject.getString(ParamsMap.DeviceParams.KEY_UID);
                                        }
                                        a(str2, str);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                switch (i10) {
                                    case a.f14407t /*8195*/:
                                        com.umeng.analytics.b.a().a(obj);
                                        return;
                                    case a.f14408u /*8196*/:
                                        com.umeng.analytics.b.a().m();
                                        return;
                                    case a.f14409v /*8197*/:
                                        com.umeng.analytics.b.a().k();
                                        return;
                                    default:
                                        switch (i10) {
                                            case a.f14410w /*8199*/:
                                            case a.f14411x /*8200*/:
                                                com.umeng.analytics.b.a().b(obj);
                                                return;
                                            case a.f14412y /*8201*/:
                                                com.umeng.analytics.b.a().b((Object) null);
                                                return;
                                            default:
                                                switch (i10) {
                                                    case a.f14413z /*8208*/:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                        Context context = f14362a;
                                                        UMWorkDispatch.sendEvent(context, a.A, CoreProtocol.getInstance(context), (Object) null);
                                                        Context context2 = f14362a;
                                                        UMWorkDispatch.sendEvent(context2, a.f14400m, CoreProtocol.getInstance(context2), (Object) null);
                                                        return;
                                                    case a.A /*8209*/:
                                                        a(obj, false);
                                                        return;
                                                    case a.B /*8210*/:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                        if (UMUtils.isMainProgress(f14362a) && !(this.f14374b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                            a(true);
                                                            return;
                                                        }
                                                        return;
                                                    default:
                                                        switch (i10) {
                                                            case a.E /*8213*/:
                                                                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                    if (DeviceConfig.getGlobleActivity(f14362a) != null) {
                                                                        w.b(f14362a);
                                                                    }
                                                                    Context context3 = f14362a;
                                                                    UMWorkDispatch.sendEventEx(context3, a.E, CoreProtocol.getInstance(context3), (Object) null, 5000);
                                                                    return;
                                                                }
                                                                return;
                                                            case a.F /*8214*/:
                                                                if (obj != null && (obj instanceof JSONObject)) {
                                                                    try {
                                                                        String optString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                        String optString2 = ((JSONObject) obj).optString("period");
                                                                        String optString3 = ((JSONObject) obj).optString("debugkey");
                                                                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                                                                            Context context4 = f14362a;
                                                                            String str3 = AnalyticsConfig.RTD_SP_FILE;
                                                                            com.umeng.common.b.a(context4, str3, AnalyticsConfig.RTD_START_TIME, optString);
                                                                            com.umeng.common.b.a(f14362a, str3, "period", optString2);
                                                                            com.umeng.common.b.a(f14362a, str3, "debugkey", optString3);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    } catch (Throwable unused2) {
                                                                    }
                                                                } else {
                                                                    return;
                                                                }
                                                            case a.G /*8215*/:
                                                                com.umeng.common.b.a(f14362a, AnalyticsConfig.RTD_SP_FILE);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            } else if (obj != null && (obj instanceof JSONObject)) {
                String optString4 = ((JSONObject) obj).optString(f.S);
                Object opt = ((JSONObject) obj).opt(f.T);
                if (!TextUtils.isEmpty(optString4)) {
                    String[] a10 = com.umeng.analytics.c.a(f14362a);
                    if (a10 == null || TextUtils.isEmpty(a10[0]) || TextUtils.isEmpty(a10[1])) {
                        MLog.e("Please call MobclickAgent.onProfileSignIn() function before set user profile property.");
                    } else if (f.O.equals(optString4)) {
                        com.umeng.analytics.c.a((String) opt);
                    } else if (f.P.equals(optString4)) {
                        com.umeng.analytics.c.b((String) opt);
                    } else {
                        com.umeng.analytics.c.a(optString4, opt);
                    }
                }
            }
        }
    }

    private void g(Object obj) {
        try {
            b(f14362a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.length() > 0) {
                String string = jSONObject.getString(f.M);
                String string2 = jSONObject.getString(ParamsMap.DeviceParams.KEY_UID);
                long j10 = jSONObject.getLong("ts");
                String[] a10 = com.umeng.analytics.c.a(f14362a);
                if (a10 == null || !string.equals(a10[0]) || !string2.equals(a10[1])) {
                    w.a().a(f14362a, j10);
                    String c10 = aa.a().c(f14362a);
                    boolean b10 = w.a().b(f14362a, j10, false);
                    com.umeng.analytics.c.a(f14362a, string, string2);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c10);
                    w.a().a(f14362a, j10, true);
                    if (b10) {
                        w.a().b(f14362a, j10);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long j10 = 0;
        try {
            Context context = f14362a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0;
            }
            long j11 = sharedPreferences.getLong(f14363l, 0);
            if (j11 == 0) {
                try {
                    j10 = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(f14363l, j10).commit();
                    return j10;
                } catch (Throwable unused) {
                }
            }
            return j11;
        } catch (Throwable unused2) {
            return j10;
        }
    }

    public void c(Object obj) {
        b(f14362a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.length() > 0) {
                long j10 = jSONObject.getLong("ts");
                b(f14362a);
                d();
                String[] a10 = com.umeng.analytics.c.a(f14362a);
                if (a10 != null && !TextUtils.isEmpty(a10[0]) && !TextUtils.isEmpty(a10[1])) {
                    w.a().a(f14362a, j10);
                    String c10 = aa.a().c(f14362a);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c10);
                    boolean b10 = w.a().b(f14362a, j10, false);
                    com.umeng.analytics.c.b(f14362a);
                    w.a().a(f14362a, j10, true);
                    if (b10) {
                        w.a().b(f14362a, j10);
                    }
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j10) {
        try {
            if (s.a(jSONObject) <= j10) {
                return jSONObject;
            }
            k.a(f14362a).a(true, false);
            k.a(f14362a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z10) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = k.a(f14362a).a(z10);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else if (jSONObject.has(f.f14199n)) {
                JSONArray jSONArray3 = jSONObject.getJSONArray(f.f14199n);
                JSONArray jSONArray4 = new JSONArray();
                int i10 = 0;
                while (i10 < jSONArray3.length()) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i10);
                    JSONArray optJSONArray = jSONObject2.optJSONArray(f.f14205t);
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray(f.f14206u);
                    if (optJSONArray == null && optJSONArray2 != null) {
                        jSONObject2.put(f.f14205t, optJSONArray2);
                        jSONObject2.remove(f.f14206u);
                    }
                    if (!(optJSONArray == null || optJSONArray2 == null)) {
                        ArrayList<JSONObject> arrayList = new ArrayList<>();
                        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                            arrayList.add((JSONObject) optJSONArray.get(i11));
                        }
                        for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                            arrayList.add((JSONObject) optJSONArray2.get(i12));
                        }
                        JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                        jSONArraySortUtil.setCompareKey(f.f14209x);
                        Collections.sort(arrayList, jSONArraySortUtil);
                        JSONArray jSONArray5 = new JSONArray();
                        for (JSONObject put : arrayList) {
                            jSONArray5.put(put);
                        }
                        jSONObject2.put(f.f14205t, jSONArray5);
                        jSONObject2.remove(f.f14206u);
                    }
                    if (jSONObject2.has(f.f14205t)) {
                        JSONArray optJSONArray3 = jSONObject2.optJSONArray(f.f14205t);
                        int i13 = 0;
                        while (i13 < optJSONArray3.length()) {
                            JSONObject jSONObject3 = optJSONArray3.getJSONObject(i13);
                            if (jSONObject3.has(f.f14209x)) {
                                jSONArray2 = jSONArray3;
                                jSONObject3.put("ts", jSONObject3.getLong(f.f14209x));
                                jSONObject3.remove(f.f14209x);
                            } else {
                                jSONArray2 = jSONArray3;
                            }
                            i13++;
                            jSONArray3 = jSONArray2;
                        }
                        jSONArray = jSONArray3;
                        jSONObject2.put(f.f14205t, optJSONArray3);
                        jSONObject2.put(f.f14211z, optJSONArray3.length());
                    } else {
                        jSONArray = jSONArray3;
                        jSONObject2.put(f.f14211z, 0);
                    }
                    jSONArray4.put(jSONObject2);
                    i10++;
                    jSONArray3 = jSONArray;
                }
                jSONObject.put(f.f14199n, jSONArray4);
            }
        } catch (Exception e10) {
            MLog.e("merge pages error");
            e10.printStackTrace();
        } catch (Throwable unused) {
        }
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14362a);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("userlevel", "");
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("userlevel", string);
            }
        }
        String[] a10 = com.umeng.analytics.c.a(f14362a);
        if (a10 != null && !TextUtils.isEmpty(a10[0]) && !TextUtils.isEmpty(a10[1])) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(f.M, a10[0]);
            jSONObject4.put(f.N, a10[1]);
            if (jSONObject4.length() > 0) {
                JSONObject jSONObject5 = new JSONObject();
                String a11 = com.umeng.analytics.c.a();
                if (a11 != null) {
                    jSONObject5.put(f.O, a11);
                }
                String b10 = com.umeng.analytics.c.b();
                if (b10 != null) {
                    jSONObject5.put(f.P, b10);
                }
                Map<String, Object> c10 = com.umeng.analytics.c.c(f14362a);
                if (c10 != null && c10.size() > 0) {
                    for (String next : c10.keySet()) {
                        jSONObject5.put(next, c10.get(next));
                    }
                }
                if (jSONObject5.length() > 0) {
                    jSONObject4.put(f.R, jSONObject5);
                }
                jSONObject.put(f.L, jSONObject4);
            }
        }
        if (ABTest.getService(f14362a).isInTest()) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(ABTest.getService(f14362a).getTestName(), ABTest.getService(f14362a).getGroupInfo());
            jSONObject.put(f.K, jSONObject6);
        }
        t.a().a(jSONObject, f14362a);
        return jSONObject;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z10) {
        if (this.f14374b == null) {
            this.f14374b = new c();
        }
        ReportPolicy.ReportStrategy c10 = this.f14374b.c();
        if (!(c10 instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z10) {
            return ((ReportPolicy.DefconPolicy) c10).shouldSendMessageByInstant();
        }
        return c10.shouldSendMessage(false);
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() <= 0) {
                    return;
                }
                if (!jSONObject.has("exception")) {
                    f(jSONObject);
                } else if (101 != jSONObject.getInt("exception")) {
                    f(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            k.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z10) {
        if (!c(z10)) {
            return;
        }
        if (this.f14374b.c() instanceof ReportPolicy.ReportQuasiRealtime) {
            if (z10) {
                if (UMEnvelopeBuild.isOnline(f14362a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                }
            } else if (UMEnvelopeBuild.isReadyBuild(f14362a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        } else if (UMEnvelopeBuild.isReadyBuild(f14362a, UMLogDataProtocol.UMBusinessType.U_APP)) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
            j();
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List asList = Arrays.asList(new String[]{"$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError"});
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i10++;
                }
            } catch (Throwable unused) {
            }
        }
        if (i10 >= length) {
            return true;
        }
        return false;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                    if (optJSONArray2 != null && a(optJSONArray2)) {
                        i10++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (i10 >= length) {
            return true;
        }
        return false;
    }

    public JSONObject a(long j10) {
        if (TextUtils.isEmpty(aa.a().d(f14362a))) {
            return null;
        }
        JSONObject b10 = b(false);
        int a10 = t.a().a(f14362a);
        if (b10.length() > 0) {
            if (b10.length() == 1) {
                if (b10.optJSONObject(f.L) != null && a10 != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(b10.optString("userlevel")) && a10 != 3) {
                    return null;
                }
            } else if (b10.length() == 2 && b10.optJSONObject(f.L) != null && !TextUtils.isEmpty(b10.optString("userlevel")) && a10 != 3) {
                return null;
            }
            String optString = b10.optString(f.f14199n);
            String optString2 = b10.optString(f.Z);
            String optString3 = b10.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && a(b10)) {
                return null;
            }
        } else if (a10 != 3) {
            return null;
        }
        JSONObject l10 = l();
        if (l10 != null) {
            c(l10);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a10 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b10.length() > 0) {
                jSONObject2.put("analytics", b10);
            }
            if (l10 != null && l10.length() > 0) {
                jSONObject.put("header", l10);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j10);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j10) {
        try {
            if (s.a(jSONObject) <= j10) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(f.aH, s.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return s.a(f14362a, j10, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j10, int i10) {
        if (j10 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j10 > 28800000) {
            o();
            return true;
        } else if (i10 < 5000) {
            return true;
        } else {
            return false;
        }
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() <= 0) {
                    return;
                }
                if (!jSONObject.has("exception")) {
                    g(jSONObject);
                } else if (101 != jSONObject.getInt("exception")) {
                    g(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z10) {
        if (z10) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(f14362a) && d(true)) {
            i();
        }
    }
}
