package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.umcrash.UMCrash;
import java.util.HashMap;
import java.util.Map;

public class bd {
    public static final String A = "rtd";
    public static final String B = "lepd";
    public static final String C = "ccfg";
    private static Map<String, String> D = null;
    private static String E = "";

    /* renamed from: a  reason: collision with root package name */
    public static final String f13841a = "env";

    /* renamed from: b  reason: collision with root package name */
    public static final String f13842b = "exp";

    /* renamed from: c  reason: collision with root package name */
    public static final String f13843c = "imp";

    /* renamed from: d  reason: collision with root package name */
    public static final String f13844d = "ua";

    /* renamed from: e  reason: collision with root package name */
    public static final String f13845e = "zc";

    /* renamed from: f  reason: collision with root package name */
    public static final String f13846f = "id";

    /* renamed from: g  reason: collision with root package name */
    public static final String f13847g = "zf";

    /* renamed from: h  reason: collision with root package name */
    public static final String f13848h = "exid";

    /* renamed from: i  reason: collision with root package name */
    public static final String f13849i = "ucc";

    /* renamed from: j  reason: collision with root package name */
    public static final String f13850j = "ugc";

    /* renamed from: k  reason: collision with root package name */
    public static final String f13851k = "usi";

    /* renamed from: l  reason: collision with root package name */
    public static final String f13852l = "uso";

    /* renamed from: m  reason: collision with root package name */
    public static final String f13853m = "user";

    /* renamed from: n  reason: collision with root package name */
    public static final String f13854n = "uspi";

    /* renamed from: o  reason: collision with root package name */
    public static final String f13855o = "dtfn";

    /* renamed from: p  reason: collision with root package name */
    public static final String f13856p = "pr";

    /* renamed from: q  reason: collision with root package name */
    public static final String f13857q = "upg";

    /* renamed from: r  reason: collision with root package name */
    public static final String f13858r = "pri";

    /* renamed from: s  reason: collision with root package name */
    public static final String f13859s = "probe";

    /* renamed from: t  reason: collision with root package name */
    public static final String f13860t = "bl";

    /* renamed from: u  reason: collision with root package name */
    public static final String f13861u = "wl";

    /* renamed from: v  reason: collision with root package name */
    public static final String f13862v = "subp";

    /* renamed from: w  reason: collision with root package name */
    public static final String f13863w = "subua";

    /* renamed from: x  reason: collision with root package name */
    public static final String f13864x = "sta";

    /* renamed from: y  reason: collision with root package name */
    public static final String f13865y = "emi";

    /* renamed from: z  reason: collision with root package name */
    public static final String f13866z = "sli";

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final bd f13867a = new bd();

        private a() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        D = hashMap;
        hashMap.put(f13841a, "envelope");
        D.put("exp", ".umeng");
        D.put(f13843c, ".imprint");
        D.put(f13844d, "ua.db");
        D.put(f13845e, "umeng_zero_cache.db");
        D.put("id", "umeng_it.cache");
        D.put(f13847g, "umeng_zcfg_flag");
        D.put(f13848h, "exid.dat");
        D.put(f13849i, "umeng_common_config");
        D.put(f13850j, "umeng_general_config");
        D.put(f13851k, UMCrash.KEY_CALLBACK_SESSION_ID);
        D.put(f13852l, "umeng_sp_oaid");
        D.put(f13853m, "mobclick_agent_user_");
        D.put(f13854n, "umeng_subprocess_info");
        D.put(f13855o, "delayed_transmission_flag_new");
        D.put("pr", "umeng_policy_result_flag");
        D.put(f13857q, "um_policy_grant");
        D.put(f13858r, "um_pri");
        D.put(f13859s, "UM_PROBE_DATA");
        D.put(f13860t, "ekv_bl");
        D.put(f13861u, "ekv_wl");
        D.put(f13862v, g.f14212a);
        D.put(f13863w, "ua_");
        D.put(f13864x, "stateless");
        D.put(f13865y, ".emitter");
        D.put(f13866z, "um_slmode_sp");
        D.put(A, "um_rtd_conf");
        D.put(B, "");
        D.put(C, ".dmpvedpogjhejs.cfg");
    }

    private bd() {
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(E)) {
            return;
        }
        if (str.length() > 3) {
            E = str.substring(0, 3) + "_";
            return;
        }
        E = str + "_";
    }

    public String b(String str) {
        if (!D.containsKey(str)) {
            return "";
        }
        String str2 = D.get(str);
        if ("exp".equalsIgnoreCase(str) || f13843c.equalsIgnoreCase(str) || f13865y.equalsIgnoreCase(str)) {
            return "." + E + str2.substring(1);
        }
        return E + str2;
    }

    public void a() {
        E = "";
    }

    public static bd b() {
        return a.f13867a;
    }
}
