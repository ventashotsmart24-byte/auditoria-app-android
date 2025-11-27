package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.c;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.a;
import com.umeng.commonsdk.stateless.d;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f14876a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f14877b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final String f14878c = "EnvelopeManager";

    /* renamed from: d  reason: collision with root package name */
    private static final String f14879d = "debug.umeng.umTaskId";

    /* renamed from: e  reason: collision with root package name */
    private static final String f14880e = "debug.umeng.umCaseId";

    /* renamed from: f  reason: collision with root package name */
    private static final String f14881f = "empty";

    /* renamed from: g  reason: collision with root package name */
    private static String f14882g = "";

    /* renamed from: h  reason: collision with root package name */
    private static String f14883h = "";

    /* renamed from: i  reason: collision with root package name */
    private static String f14884i;

    /* renamed from: j  reason: collision with root package name */
    private static Map<String, String> f14885j;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f14886l;

    /* renamed from: k  reason: collision with root package name */
    private int f14887k = 0;

    static {
        HashMap hashMap = new HashMap();
        f14885j = hashMap;
        hashMap.put("header", "#h");
        f14885j.put(bt.f13927u, "#sdt");
        f14885j.put(bt.Q, "#ac");
        f14885j.put("device_model", "#dm");
        f14885j.put(bt.f13913g, "#umid");
        f14885j.put("os", "os");
        f14885j.put("language", "#lang");
        f14885j.put(bt.ai, "#dt");
        f14885j.put(bt.f13932z, "#rl");
        f14885j.put(bt.H, "#dmf");
        f14885j.put(bt.J, "#dn");
        f14885j.put("platform_version", "#pv");
        f14885j.put("font_size_setting", "#fss");
        f14885j.put(bt.f13931y, "#ov");
        f14885j.put(bt.I, "#did");
        f14885j.put("platform_sdk_version", "#psv");
        f14885j.put(bt.F, "#db");
        f14885j.put("appkey", "#ak");
        f14885j.put(bt.Y, "#itr");
        f14885j.put("id_type", "#it");
        f14885j.put("uuid", "#ud");
        f14885j.put("device_id", "#dd");
        f14885j.put(bt.X, "#imp");
        f14885j.put("sdk_version", "#sv");
        f14885j.put("st", "#st");
        f14885j.put("analytics", "#a");
        f14885j.put(bt.f13921o, "#pkg");
        f14885j.put(bt.f13922p, "#sig");
        f14885j.put(bt.f13923q, "#sis1");
        f14885j.put(bt.f13924r, "#sis");
        f14885j.put("app_version", "#av");
        f14885j.put("version_code", "#vc");
        f14885j.put(bt.f13928v, "#imd");
        f14885j.put(bt.B, "#mnc");
        f14885j.put(bt.E, "#boa");
        f14885j.put(bt.G, "#mant");
        f14885j.put(bt.M, "#tz");
        f14885j.put(bt.O, "#ct");
        f14885j.put("carrier", "#car");
        f14885j.put(bt.f13925s, "#disn");
        f14885j.put(bt.T, "#nt");
        f14885j.put(bt.f13906b, "#cv");
        f14885j.put(bt.f13910d, "#mv");
        f14885j.put(bt.f13909c, "#cot");
        f14885j.put(bt.f13911e, "#mod");
        f14885j.put(bt.aj, "#al");
        f14885j.put("session_id", "#sid");
        f14885j.put(bt.S, "#ip");
        f14885j.put(bt.U, "#sre");
        f14885j.put(bt.V, "#fre");
        f14885j.put(bt.W, "#ret");
        f14885j.put("channel", "#chn");
        f14885j.put("wrapper_type", "#wt");
        f14885j.put("wrapper_version", "#wv");
        f14885j.put(bt.f13908bb, "#tsv");
        f14885j.put(bt.bc, "#rps");
        f14885j.put(bt.bh, "#mov");
        f14885j.put(f.f14194i, "#vt");
        f14885j.put("secret", "#sec");
        f14885j.put(f.an, "#prv");
        f14885j.put(f.f14197l, "#$prv");
        f14885j.put(f.f14198m, "#uda");
        f14885j.put(bt.f13903a, "#tok");
        f14885j.put(bt.aT, "#iv");
        f14885j.put(bt.R, "#ast");
        f14885j.put("backstate", "#bst");
        f14885j.put("zdata_ver", "#zv");
        f14885j.put("zdata_req_ts", "#zrt");
        f14885j.put("app_b_v", "#bv");
        f14885j.put("zdata", "#zta");
        f14885j.put(bt.ap, "#mt");
        f14885j.put(bt.am, "#zsv");
        f14885j.put("others_OS", "#oos");
    }

    public static String a(String str) {
        return f14885j.containsKey(str) ? f14885j.get(str) : str;
    }

    private static boolean b() {
        f14882g = UMUtils.getSystemProperty(f14879d, "");
        f14883h = UMUtils.getSystemProperty(f14880e, "");
        return (!TextUtils.isEmpty(f14882g) && !f14881f.equals(f14882g)) && (!TextUtils.isEmpty(f14883h) && !f14881f.equals(f14883h));
    }

    public static void a() {
        if (f14884i != null) {
            f14884i = null;
            com.umeng.commonsdk.statistics.idtracking.f.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f14882g);
                    jSONObject.put("umCaseId", f14883h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (!(jSONObject3 == null || jSONObject2 == null)) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null) {
                if (DataHelper.largeThanMaxSize((long) jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject3);
                }
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize((long) envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a10 = a(context, envelope2, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (a10 != 0) {
                return a(a10, jSONObject3);
            }
            if (ULog.DEBUG) {
                StringBuilder sb = new StringBuilder();
                sb.append("constructHeader size is ");
                sb.append(jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public static long a(Context context) {
        long j10 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("free size is ");
            sb.append(j10);
        }
        return j10;
    }

    private JSONObject a(int i10, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i10);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i10);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        boolean z10;
        String str4;
        String str5;
        Envelope envelope;
        JSONObject optJSONObject;
        Context context2 = context;
        JSONObject jSONObject4 = jSONObject;
        JSONObject jSONObject5 = jSONObject2;
        if (!(!ULog.DEBUG || jSONObject4 == null || jSONObject5 == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("headerJSONObject size is ");
            sb.append(jSONObject.toString().getBytes().length);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bodyJSONObject size is ");
            sb2.append(jSONObject2.toString().getBytes().length);
        }
        JSONObject jSONObject6 = null;
        if (context2 == null || jSONObject5 == null) {
            return a(110, (JSONObject) null);
        }
        try {
            if (!jSONObject5.has("analytics") || (optJSONObject = jSONObject5.optJSONObject("analytics")) == null || !optJSONObject.has(f.f14199n)) {
                str4 = str2;
                z10 = false;
            } else {
                str4 = str2;
                z10 = true;
            }
            JSONObject a10 = a(context2, str4, z10);
            if (!(a10 == null || jSONObject4 == null)) {
                a10 = a(a10, jSONObject4);
            }
            JSONObject jSONObject7 = a10;
            if (jSONObject7 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str6 = next;
                        if (jSONObject5.opt(str6) != null) {
                            try {
                                jSONObject7.put(a(str6), jSONObject5.opt(str6));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            String str7 = "1.0.0";
            if (TextUtils.isEmpty(str2)) {
                str4 = "u";
            }
            if (!TextUtils.isEmpty(str3)) {
                str7 = str3;
            }
            if (jSONObject7 != null) {
                String str8 = str4 + "==" + str7 + "&=";
                if (TextUtils.isEmpty(str8)) {
                    return a(101, jSONObject7);
                }
                if (str8.endsWith("&=")) {
                    str8 = str8.substring(0, str8.length() - 2);
                }
                str5 = str8;
            } else {
                str5 = null;
            }
            if (jSONObject7 != null) {
                try {
                    com.umeng.commonsdk.statistics.idtracking.f a11 = com.umeng.commonsdk.statistics.idtracking.f.a(context);
                    if (a11 != null) {
                        a11.b();
                        String encodeToString = Base64.encodeToString(new cq().a(a11.c()), 0);
                        if (!TextUtils.isEmpty(encodeToString)) {
                            JSONObject jSONObject8 = jSONObject7.getJSONObject(a("header"));
                            jSONObject8.put(a(bt.Y), encodeToString);
                            jSONObject7.put(a("header"), jSONObject8);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (jSONObject7 != null) {
                if (DataHelper.largeThanMaxSize((long) jSONObject7.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject7);
                }
            }
            if (jSONObject7 != null) {
                Envelope a12 = a(context2, jSONObject7.toString().getBytes());
                if (a12 == null) {
                    return a(111, jSONObject7);
                }
                envelope = a12;
            } else {
                envelope = null;
            }
            if (envelope != null && DataHelper.largeThanMaxSize((long) envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject7);
            }
            int a13 = a(context, envelope, str5, jSONObject7 != null ? jSONObject7.optJSONObject(a("header")).optString(a("app_version")) : null, str);
            if (a13 != 0) {
                return a(a13, jSONObject7);
            }
            if (ULog.DEBUG) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("constructHeader size is ");
                sb3.append(jSONObject7.toString().getBytes().length);
            }
            if (!str5.startsWith(bt.aJ) && !str5.startsWith(bt.aI) && !str5.startsWith("t")) {
                if (!str5.startsWith("a")) {
                    if (!com.umeng.commonsdk.stateless.b.a()) {
                        new com.umeng.commonsdk.stateless.b(context2);
                        com.umeng.commonsdk.stateless.b.b();
                    }
                }
            }
            return jSONObject7;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context2, th);
            if (jSONObject4 != null) {
                try {
                    jSONObject3 = new JSONObject();
                    jSONObject6 = jSONObject3;
                } catch (Exception e10) {
                    e = e10;
                    UMCrashManager.reportCrash(context2, e);
                    return a(110, jSONObject6);
                }
                try {
                    jSONObject3.put("header", jSONObject4);
                } catch (JSONException unused3) {
                } catch (Exception e11) {
                    e = e11;
                    jSONObject6 = jSONObject3;
                    UMCrashManager.reportCrash(context2, e);
                    return a(110, jSONObject6);
                }
            }
            if (jSONObject6 == null) {
                jSONObject6 = new JSONObject();
            }
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 != null && (next2 instanceof String)) {
                    String str9 = next2;
                    if (jSONObject5.opt(str9) != null) {
                        try {
                            jSONObject6.put(str9, jSONObject5.opt(str9));
                        } catch (Exception unused4) {
                        }
                    }
                }
            }
            return a(110, jSONObject6);
        }
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(c.f14779a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(c.f14780b, 0);
                iArr[1] = sharedPreferences.getInt(c.f14781c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (!(jSONObject3 == null || jSONObject2 == null)) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null) {
                if (DataHelper.largeThanMaxSize((long) jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject3);
                }
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize((long) envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a10 = a(context, envelope2, "h==1.2.0", "", str);
            if (a10 != 0) {
                return a(a10, jSONObject3);
            }
            if (ULog.DEBUG) {
                StringBuilder sb = new StringBuilder();
                sb.append("constructHeader size is ");
                sb.append(jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(43:96|(2:97|98)|99|(5:101|102|(1:104)|105|(1:107))|108|110|111|112|113|(1:115)|119|(3:120|121|(1:123))|127|128|129|130|131|132|(2:134|135)(1:136)|(3:137|138|(1:140))|141|143|144|(2:149|150)|151|152|(4:156|(2:159|157)|192|160)|161|162|(1:164)|165|166|(1:168)|169|170|(1:172)|173|174|175|176|(3:180|181|182)|186|(2:188|189)(1:194)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(49:96|(2:97|98)|99|101|102|(1:104)|105|(1:107)|108|110|111|112|113|(1:115)|119|120|121|(1:123)|127|128|129|130|131|132|(2:134|135)(1:136)|(3:137|138|(1:140))|141|143|144|(2:149|150)|151|152|(4:156|(2:159|157)|192|160)|161|162|(1:164)|165|166|(1:168)|169|170|(1:172)|173|174|175|176|(3:180|181|182)|186|(2:188|189)(1:194)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(52:96|97|98|99|101|102|(1:104)|105|(1:107)|108|110|111|112|113|(1:115)|119|120|121|(1:123)|127|128|129|130|131|132|(2:134|135)(1:136)|137|138|(1:140)|141|143|144|(2:149|150)|151|152|(4:156|(2:159|157)|192|160)|161|162|(1:164)|165|166|(1:168)|169|170|(1:172)|173|174|175|176|(3:180|181|182)|186|(2:188|189)(1:194)) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:130:0x03fb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:137:0x0425 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:151:0x047c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:161:0x04ba */
    /* JADX WARNING: Missing exception handler attribute for start block: B:165:0x04cd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:169:0x04e0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:173:0x04f3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:175:0x0507 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0306 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0333 */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0412 A[SYNTHETIC, Splitter:B:134:0x0412] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x041c A[Catch:{ all -> 0x0425 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x042b A[Catch:{ all -> 0x0439 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x049b A[Catch:{ all -> 0x04ba }, LOOP:0: B:157:0x0495->B:159:0x049b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04c4 A[Catch:{ all -> 0x04cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04d7 A[Catch:{ all -> 0x04e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x04ea A[Catch:{ all -> 0x04f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x052c A[Catch:{ Exception -> 0x03ca, all -> 0x053c }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x030c A[SYNTHETIC, Splitter:B:74:0x030c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.json.JSONObject a(android.content.Context r17, java.lang.String r18, boolean r19) {
        /*
            r1 = r17
            r2 = r18
            java.lang.String r0 = "2G/3G"
            java.lang.String r3 = "umid"
            java.lang.String r4 = "failed_requests"
            java.lang.String r5 = "Android"
            java.lang.String r6 = "1"
            android.content.SharedPreferences r8 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(r17)     // Catch:{ all -> 0x053c }
            java.lang.String r9 = f14884i     // Catch:{ all -> 0x053c }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x053c }
            r10 = 2
            r11 = 1
            r12 = 0
            if (r9 != 0) goto L_0x002f
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0029 }
            java.lang.String r5 = f14884i     // Catch:{ Exception -> 0x0029 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0029 }
            r7 = r0
            r16 = r8
            goto L_0x033a
        L_0x0029:
            r16 = r8
            r7 = 0
            goto L_0x033a
        L_0x002f:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x053c }
            r9.<init>()     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "app_signature"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppMD5Signature(r17)     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "app_sig_sha1"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppSHA1Key(r17)     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "app_sig_sha"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppHashKey(r17)     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "app_version"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(r17)     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "version_code"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionCode(r17)     // Catch:{ all -> 0x053c }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "idmd5"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceIdUmengMD5(r17)     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "cpu"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = com.umeng.commonsdk.statistics.common.DeviceConfig.getCPU()     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = com.umeng.commonsdk.statistics.common.DeviceConfig.getMCCMNC(r17)     // Catch:{ all -> 0x053c }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x053c }
            java.lang.String r15 = ""
            java.lang.String r16 = "mccmnc"
            if (r14 != 0) goto L_0x00ab
            java.lang.String r14 = a((java.lang.String) r16)     // Catch:{ all -> 0x053c }
            r9.put(r14, r13)     // Catch:{ all -> 0x053c }
            f14877b = r13     // Catch:{ all -> 0x053c }
            goto L_0x00b2
        L_0x00ab:
            java.lang.String r13 = a((java.lang.String) r16)     // Catch:{ all -> 0x053c }
            r9.put(r13, r15)     // Catch:{ all -> 0x053c }
        L_0x00b2:
            java.lang.String r13 = "header_sub_os_info"
            boolean r13 = com.umeng.commonsdk.config.FieldManager.allow(r13)     // Catch:{ all -> 0x053c }
            if (r13 == 0) goto L_0x00e0
            java.lang.String r13 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSName(r17)     // Catch:{ all -> 0x053c }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x053c }
            if (r14 != 0) goto L_0x00cd
            java.lang.String r14 = "sub_os_name"
            java.lang.String r14 = a((java.lang.String) r14)     // Catch:{ all -> 0x053c }
            r9.put(r14, r13)     // Catch:{ all -> 0x053c }
        L_0x00cd:
            java.lang.String r13 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSVersion(r17)     // Catch:{ all -> 0x053c }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x053c }
            if (r14 != 0) goto L_0x00e0
            java.lang.String r14 = "sub_os_version"
            java.lang.String r14 = a((java.lang.String) r14)     // Catch:{ all -> 0x053c }
            r9.put(r14, r13)     // Catch:{ all -> 0x053c }
        L_0x00e0:
            java.lang.String r13 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceType(r17)     // Catch:{ all -> 0x053c }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x053c }
            if (r14 != 0) goto L_0x00f3
            java.lang.String r14 = "device_type"
            java.lang.String r14 = a((java.lang.String) r14)     // Catch:{ all -> 0x053c }
            r9.put(r14, r13)     // Catch:{ all -> 0x053c }
        L_0x00f3:
            java.lang.String r13 = "package_name"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = com.umeng.commonsdk.statistics.common.DeviceConfig.getPackageName(r17)     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "sdk_type"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            r9.put(r13, r5)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "device_id"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceId(r17)     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "device_model"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = android.os.Build.MODEL     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "device_board"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = android.os.Build.BOARD     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "device_brand"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = android.os.Build.BRAND     // Catch:{ all -> 0x053c }
            r9.put(r13, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "device_manutime"
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            r16 = r8
            long r7 = android.os.Build.TIME     // Catch:{ all -> 0x053c }
            r9.put(r13, r7)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = "device_manufacturer"
            java.lang.String r7 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x053c }
            r9.put(r7, r8)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = "device_manuid"
            java.lang.String r7 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = android.os.Build.ID     // Catch:{ all -> 0x053c }
            r9.put(r7, r8)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = "device_name"
            java.lang.String r7 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = android.os.Build.DEVICE     // Catch:{ all -> 0x053c }
            r9.put(r7, r8)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = "os_version"
            java.lang.String r7 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x053c }
            r9.put(r7, r8)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = "os"
            java.lang.String r7 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            r9.put(r7, r5)     // Catch:{ all -> 0x053c }
            int[] r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.getResolutionArray(r17)     // Catch:{ all -> 0x053c }
            if (r7 == 0) goto L_0x01a0
            java.lang.String r8 = "resolution"
            java.lang.String r8 = a((java.lang.String) r8)     // Catch:{ all -> 0x053c }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x053c }
            r13.<init>()     // Catch:{ all -> 0x053c }
            r14 = r7[r11]     // Catch:{ all -> 0x053c }
            r13.append(r14)     // Catch:{ all -> 0x053c }
            java.lang.String r14 = "*"
            r13.append(r14)     // Catch:{ all -> 0x053c }
            r7 = r7[r12]     // Catch:{ all -> 0x053c }
            r13.append(r7)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = r13.toString()     // Catch:{ all -> 0x053c }
            r9.put(r8, r7)     // Catch:{ all -> 0x053c }
        L_0x01a0:
            java.lang.String r7 = "mc"
            java.lang.String r7 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = com.umeng.commonsdk.statistics.common.DeviceConfig.getMac(r17)     // Catch:{ all -> 0x053c }
            r9.put(r7, r8)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = "timezone"
            java.lang.String r7 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            int r8 = com.umeng.commonsdk.statistics.common.DeviceConfig.getTimeZone(r17)     // Catch:{ all -> 0x053c }
            r9.put(r7, r8)     // Catch:{ all -> 0x053c }
            java.lang.String[] r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.getLocaleInfo(r17)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = "country"
            java.lang.String r8 = a((java.lang.String) r8)     // Catch:{ all -> 0x053c }
            r13 = r7[r12]     // Catch:{ all -> 0x053c }
            r9.put(r8, r13)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = "language"
            java.lang.String r8 = a((java.lang.String) r8)     // Catch:{ all -> 0x053c }
            r7 = r7[r11]     // Catch:{ all -> 0x053c }
            r9.put(r8, r7)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = "carrier"
            java.lang.String r7 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkOperatorName(r17)     // Catch:{ all -> 0x053c }
            r9.put(r7, r8)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = "display_name"
            java.lang.String r7 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(r17)     // Catch:{ all -> 0x053c }
            r9.put(r7, r8)     // Catch:{ all -> 0x053c }
            java.lang.String[] r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(r17)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = "Wi-Fi"
            r13 = r7[r12]     // Catch:{ all -> 0x053c }
            boolean r8 = r8.equals(r13)     // Catch:{ all -> 0x053c }
            java.lang.String r13 = "access"
            if (r8 == 0) goto L_0x0208
            java.lang.String r0 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = "wifi"
            r9.put(r0, r8)     // Catch:{ all -> 0x053c }
            goto L_0x0221
        L_0x0208:
            r8 = r7[r12]     // Catch:{ all -> 0x053c }
            boolean r8 = r0.equals(r8)     // Catch:{ all -> 0x053c }
            if (r8 == 0) goto L_0x0218
            java.lang.String r8 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            r9.put(r8, r0)     // Catch:{ all -> 0x053c }
            goto L_0x0221
        L_0x0218:
            java.lang.String r0 = a((java.lang.String) r13)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = "unknow"
            r9.put(r0, r8)     // Catch:{ all -> 0x053c }
        L_0x0221:
            r0 = r7[r11]     // Catch:{ all -> 0x053c }
            boolean r0 = r15.equals(r0)     // Catch:{ all -> 0x053c }
            if (r0 != 0) goto L_0x0234
            java.lang.String r0 = "access_subtype"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            r7 = r7[r11]     // Catch:{ all -> 0x053c }
            r9.put(r0, r7)     // Catch:{ all -> 0x053c }
        L_0x0234:
            boolean r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.isHarmony(r17)     // Catch:{ all -> 0x053c }
            java.lang.String r7 = "others_OS"
            if (r0 == 0) goto L_0x0246
            java.lang.String r0 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            java.lang.String r5 = "harmony"
            r9.put(r0, r5)     // Catch:{ all -> 0x053c }
            goto L_0x024d
        L_0x0246:
            java.lang.String r0 = a((java.lang.String) r7)     // Catch:{ all -> 0x053c }
            r9.put(r0, r5)     // Catch:{ all -> 0x053c }
        L_0x024d:
            java.lang.String r0 = "network_type"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            int r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkType(r17)     // Catch:{ all -> 0x053c }
            r9.put(r0, r5)     // Catch:{ all -> 0x053c }
            java.lang.String r0 = "com_ver"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            java.lang.String r5 = "9.7.9"
            r9.put(r0, r5)     // Catch:{ all -> 0x053c }
            java.lang.String r0 = "com_type"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            int r5 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE     // Catch:{ all -> 0x053c }
            r9.put(r0, r5)     // Catch:{ all -> 0x053c }
            java.lang.String r0 = "mini_ver"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            r9.put(r0, r6)     // Catch:{ all -> 0x053c }
            java.lang.String r0 = f14876a     // Catch:{ all -> 0x053c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x053c }
            if (r0 != 0) goto L_0x028c
            java.lang.String r0 = "module"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            java.lang.String r5 = f14876a     // Catch:{ all -> 0x053c }
            r9.put(r0, r5)     // Catch:{ all -> 0x053c }
        L_0x028c:
            java.lang.String r0 = "api_level"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x053c }
            r9.put(r0, r5)     // Catch:{ all -> 0x053c }
            java.lang.String r0 = com.umeng.commonsdk.utils.UMUtils.VALUE_REC_VERSION_NAME     // Catch:{ all -> 0x053c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x053c }
            if (r0 != 0) goto L_0x02aa
            java.lang.String r0 = "urec_ver"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.VALUE_REC_VERSION_NAME     // Catch:{ all -> 0x053c }
            r9.put(r0, r5)     // Catch:{ all -> 0x053c }
        L_0x02aa:
            java.lang.String r0 = com.umeng.commonsdk.utils.UMUtils.getUUIDForZid(r17)     // Catch:{ all -> 0x02c4 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02c4 }
            if (r5 == 0) goto L_0x02bb
            com.umeng.commonsdk.utils.UMUtils.setUUIDForZid(r17)     // Catch:{ all -> 0x02c4 }
            java.lang.String r0 = com.umeng.commonsdk.utils.UMUtils.getUUIDForZid(r17)     // Catch:{ all -> 0x02c4 }
        L_0x02bb:
            java.lang.String r5 = "session_id"
            java.lang.String r5 = a((java.lang.String) r5)     // Catch:{ all -> 0x02c4 }
            r9.put(r5, r0)     // Catch:{ all -> 0x02c4 }
        L_0x02c4:
            java.lang.String r0 = "android.per"
            java.lang.String r5 = "mission.PACK"
            java.lang.String r7 = "AGE_USAGE_"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0306 }
            r8.<init>()     // Catch:{ all -> 0x0306 }
            r8.append(r0)     // Catch:{ all -> 0x0306 }
            r8.append(r5)     // Catch:{ all -> 0x0306 }
            r8.append(r7)     // Catch:{ all -> 0x0306 }
            java.lang.String r0 = "STATS"
            r8.append(r0)     // Catch:{ all -> 0x0306 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0306 }
            boolean r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.hasRequestPermission(r1, r0)     // Catch:{ all -> 0x0306 }
            if (r0 == 0) goto L_0x02fb
            java.lang.String r0 = "xpus"
            r9.put(r0, r6)     // Catch:{ all -> 0x0306 }
            android.content.Context r0 = r17.getApplicationContext()     // Catch:{ all -> 0x0306 }
            boolean r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.hasOpsPermission(r0)     // Catch:{ all -> 0x0306 }
            if (r0 == 0) goto L_0x02fb
            java.lang.String r0 = "rpus"
            r9.put(r0, r6)     // Catch:{ all -> 0x0306 }
        L_0x02fb:
            boolean r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.isSystemApp(r17)     // Catch:{ all -> 0x0306 }
            if (r0 == 0) goto L_0x0306
            java.lang.String r0 = "issys"
            r9.put(r0, r6)     // Catch:{ all -> 0x0306 }
        L_0x0306:
            boolean r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.isHonorDevice()     // Catch:{ all -> 0x053c }
            if (r0 == 0) goto L_0x0321
            boolean r0 = com.umeng.analytics.pro.br.c()     // Catch:{ all -> 0x0321 }
            java.lang.String r5 = "honor_stage"
            if (r0 == 0) goto L_0x0317
            r9.put(r5, r10)     // Catch:{ all -> 0x0321 }
        L_0x0317:
            boolean r0 = com.umeng.analytics.pro.br.b()     // Catch:{ all -> 0x0321 }
            if (r0 == 0) goto L_0x0321
            r0 = 3
            r9.put(r5, r0)     // Catch:{ all -> 0x0321 }
        L_0x0321:
            java.lang.String r0 = "ntf_switch"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNotificationStatus(r17)     // Catch:{ all -> 0x032a }
            r9.put(r0, r5)     // Catch:{ all -> 0x032a }
        L_0x032a:
            java.lang.String r0 = "ringer_mode"
            int r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getRingerMode(r17)     // Catch:{ all -> 0x0333 }
            r9.put(r0, r5)     // Catch:{ all -> 0x0333 }
        L_0x0333:
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x053c }
            f14884i = r0     // Catch:{ all -> 0x053c }
            r7 = r9
        L_0x033a:
            if (r7 != 0) goto L_0x033e
            r5 = 0
            return r5
        L_0x033e:
            java.lang.String r0 = "oaid_required_time"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ Exception -> 0x034b }
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.getOaidRequiredTime(r17)     // Catch:{ Exception -> 0x034b }
            r7.put(r0, r5)     // Catch:{ Exception -> 0x034b }
        L_0x034b:
            java.lang.String r0 = "successful_requests"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ Exception -> 0x039c }
            java.lang.String r5 = "successful_request"
            r6 = r16
            int r5 = r6.getInt(r5, r12)     // Catch:{ Exception -> 0x039c }
            r7.put(r0, r5)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = a((java.lang.String) r4)     // Catch:{ Exception -> 0x039c }
            int r4 = r6.getInt(r4, r12)     // Catch:{ Exception -> 0x039c }
            r7.put(r0, r4)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = "req_time"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ Exception -> 0x039c }
            java.lang.String r4 = "last_request_spent_ms"
            int r4 = r6.getInt(r4, r12)     // Catch:{ Exception -> 0x039c }
            r7.put(r0, r4)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = com.umeng.commonsdk.utils.UMUtils.getZid(r17)     // Catch:{ Exception -> 0x039c }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x039c }
            if (r4 != 0) goto L_0x0389
            java.lang.String r4 = "zid"
            java.lang.String r4 = a((java.lang.String) r4)     // Catch:{ Exception -> 0x039c }
            r7.put(r4, r0)     // Catch:{ Exception -> 0x039c }
        L_0x0389:
            java.lang.String r0 = com.umeng.commonsdk.utils.UMUtils.VALUE_ASMS_VERSION     // Catch:{ Exception -> 0x039c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x039c }
            if (r0 != 0) goto L_0x039c
            java.lang.String r0 = "zid_sdk_version"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ Exception -> 0x039c }
            java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.VALUE_ASMS_VERSION     // Catch:{ Exception -> 0x039c }
            r7.put(r0, r4)     // Catch:{ Exception -> 0x039c }
        L_0x039c:
            java.lang.String r0 = "channel"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getChannel(r17)     // Catch:{ all -> 0x053c }
            r7.put(r0, r4)     // Catch:{ all -> 0x053c }
            java.lang.String r0 = "appkey"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x053c }
            java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r17)     // Catch:{ all -> 0x053c }
            r7.put(r0, r4)     // Catch:{ all -> 0x053c }
            java.lang.String r0 = com.umeng.commonsdk.utils.UMUtils.getDeviceToken(r17)     // Catch:{ Exception -> 0x03ca }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03ca }
            if (r4 != 0) goto L_0x03ce
            java.lang.String r4 = "devicetoken"
            java.lang.String r4 = a((java.lang.String) r4)     // Catch:{ Exception -> 0x03ca }
            r7.put(r4, r0)     // Catch:{ Exception -> 0x03ca }
            goto L_0x03ce
        L_0x03ca:
            r0 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r1, r0)     // Catch:{ all -> 0x053c }
        L_0x03ce:
            r4 = 0
            java.lang.String r0 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r1, r3, r4)     // Catch:{ Exception -> 0x03e1 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03e1 }
            if (r4 != 0) goto L_0x03e5
            java.lang.String r3 = a((java.lang.String) r3)     // Catch:{ Exception -> 0x03e1 }
            r7.put(r3, r0)     // Catch:{ Exception -> 0x03e1 }
            goto L_0x03e5
        L_0x03e1:
            r0 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r1, r0)     // Catch:{ all -> 0x053c }
        L_0x03e5:
            java.lang.String r0 = "wrapper_type"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ Exception -> 0x03fb }
            java.lang.String r3 = com.umeng.commonsdk.statistics.a.f14873a     // Catch:{ Exception -> 0x03fb }
            r7.put(r0, r3)     // Catch:{ Exception -> 0x03fb }
            java.lang.String r0 = "wrapper_version"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ Exception -> 0x03fb }
            java.lang.String r3 = com.umeng.commonsdk.statistics.a.f14874b     // Catch:{ Exception -> 0x03fb }
            r7.put(r0, r3)     // Catch:{ Exception -> 0x03fb }
        L_0x03fb:
            int r0 = com.umeng.commonsdk.utils.UMUtils.getTargetSdkVersion(r17)     // Catch:{ all -> 0x0425 }
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r3 = com.umeng.commonsdk.utils.UMUtils.checkPermission(r1, r3)     // Catch:{ all -> 0x0425 }
            java.lang.String r4 = "targetSdkVer"
            java.lang.String r4 = a((java.lang.String) r4)     // Catch:{ all -> 0x0425 }
            r7.put(r4, r0)     // Catch:{ all -> 0x0425 }
            java.lang.String r0 = "rps_pr"
            if (r3 == 0) goto L_0x041c
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x0425 }
            java.lang.String r3 = "yes"
            r7.put(r0, r3)     // Catch:{ all -> 0x0425 }
            goto L_0x0425
        L_0x041c:
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x0425 }
            java.lang.String r3 = "no"
            r7.put(r0, r3)     // Catch:{ all -> 0x0425 }
        L_0x0425:
            boolean r0 = b()     // Catch:{ all -> 0x0439 }
            if (r0 == 0) goto L_0x0439
            java.lang.String r0 = "umTaskId"
            java.lang.String r3 = f14882g     // Catch:{ all -> 0x0439 }
            r7.put(r0, r3)     // Catch:{ all -> 0x0439 }
            java.lang.String r0 = "umCaseId"
            java.lang.String r3 = f14883h     // Catch:{ all -> 0x0439 }
            r7.put(r0, r3)     // Catch:{ all -> 0x0439 }
        L_0x0439:
            java.lang.String r0 = "t"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x053c }
            if (r0 != 0) goto L_0x0449
            java.lang.String r0 = "a"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x053c }
            if (r0 == 0) goto L_0x047c
        L_0x0449:
            if (r19 == 0) goto L_0x047c
            int[] r0 = b(r17)     // Catch:{ all -> 0x047c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x047c }
            r2.<init>()     // Catch:{ all -> 0x047c }
            r3 = r0[r12]     // Catch:{ all -> 0x047c }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x047c }
            r2.append(r3)     // Catch:{ all -> 0x047c }
            r3 = r0[r11]     // Catch:{ all -> 0x047c }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x047c }
            r2.append(r3)     // Catch:{ all -> 0x047c }
            r0 = r0[r10]     // Catch:{ all -> 0x047c }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x047c }
            r2.append(r0)     // Catch:{ all -> 0x047c }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x047c }
            java.lang.String r2 = "policy"
            java.lang.String r2 = a((java.lang.String) r2)     // Catch:{ all -> 0x047c }
            r7.put(r2, r0)     // Catch:{ all -> 0x047c }
        L_0x047c:
            java.util.Map r0 = com.umeng.commonsdk.statistics.TagHelper.getModuleTags()     // Catch:{ all -> 0x04ba }
            if (r0 == 0) goto L_0x04ba
            int r2 = r0.size()     // Catch:{ all -> 0x04ba }
            if (r2 <= 0) goto L_0x04ba
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x04ba }
            r2.<init>()     // Catch:{ all -> 0x04ba }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x04ba }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x04ba }
        L_0x0495:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x04ba }
            if (r3 == 0) goto L_0x04b1
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x04ba }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x04ba }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x04ba }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x04ba }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x04ba }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04ba }
            r2.put(r4, r3)     // Catch:{ all -> 0x04ba }
            goto L_0x0495
        L_0x04b1:
            java.lang.String r0 = "module_tag"
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x04ba }
            r7.put(r0, r2)     // Catch:{ all -> 0x04ba }
        L_0x04ba:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.getRealTimeDebugKey()     // Catch:{ all -> 0x04cd }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04cd }
            if (r2 != 0) goto L_0x04cd
            java.lang.String r2 = "dk"
            java.lang.String r2 = a((java.lang.String) r2)     // Catch:{ all -> 0x04cd }
            r7.put(r2, r0)     // Catch:{ all -> 0x04cd }
        L_0x04cd:
            org.json.JSONObject r0 = com.umeng.commonsdk.utils.UMUtils.getModuleVer()     // Catch:{ all -> 0x04e0 }
            int r2 = r0.length()     // Catch:{ all -> 0x04e0 }
            if (r2 <= 0) goto L_0x04e0
            java.lang.String r2 = "module_ver"
            java.lang.String r2 = a((java.lang.String) r2)     // Catch:{ all -> 0x04e0 }
            r7.put(r2, r0)     // Catch:{ all -> 0x04e0 }
        L_0x04e0:
            java.lang.String r0 = com.umeng.commonsdk.utils.UMUtils.getApmFlag()     // Catch:{ all -> 0x04f3 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04f3 }
            if (r2 != 0) goto L_0x04f3
            java.lang.String r2 = "_$apmflag"
            java.lang.String r2 = a((java.lang.String) r2)     // Catch:{ all -> 0x04f3 }
            r7.put(r2, r0)     // Catch:{ all -> 0x04f3 }
        L_0x04f3:
            java.lang.String r0 = android.os.Build.BRAND     // Catch:{ all -> 0x0507 }
            java.lang.String r2 = com.umeng.analytics.pro.at.a(r0)     // Catch:{ all -> 0x0507 }
            java.lang.String r0 = com.umeng.analytics.pro.at.b(r0)     // Catch:{ all -> 0x0507 }
            java.lang.String r3 = "crn"
            r7.put(r3, r2)     // Catch:{ all -> 0x0507 }
            java.lang.String r2 = "crv"
            r7.put(r2, r0)     // Catch:{ all -> 0x0507 }
        L_0x0507:
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler r0 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(r17)     // Catch:{ all -> 0x053c }
            byte[] r0 = r0.a()     // Catch:{ all -> 0x053c }
            if (r0 == 0) goto L_0x0526
            int r2 = r0.length     // Catch:{ all -> 0x053c }
            if (r2 <= 0) goto L_0x0526
            java.lang.String r2 = "imprint"
            java.lang.String r2 = a((java.lang.String) r2)     // Catch:{ JSONException -> 0x0522 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r12)     // Catch:{ JSONException -> 0x0522 }
            r7.put(r2, r0)     // Catch:{ JSONException -> 0x0522 }
            goto L_0x0526
        L_0x0522:
            r0 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r1, r0)     // Catch:{ all -> 0x053c }
        L_0x0526:
            int r0 = r7.length()     // Catch:{ all -> 0x053c }
            if (r0 <= 0) goto L_0x0540
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x053c }
            r0.<init>()     // Catch:{ all -> 0x053c }
            java.lang.String r2 = "header"
            java.lang.String r2 = a((java.lang.String) r2)     // Catch:{ all -> 0x053c }
            org.json.JSONObject r0 = r0.put(r2, r7)     // Catch:{ all -> 0x053c }
            return r0
        L_0x053c:
            r0 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r1, r0)
        L_0x0540:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.b.a(android.content.Context, java.lang.String, boolean):org.json.JSONObject");
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (!(jSONObject == null || jSONObject2 == null || jSONObject.opt(a("header")) == null || !(jSONObject.opt(a("header")) instanceof JSONObject))) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String)) {
                    String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(a(f.f14194i)) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.f14887k = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", (String) null);
        int i10 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i10 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e10) {
            UMCrashManager.reportCrash(context, e10);
        }
        if (i10 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i10 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f14886l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String b10 = d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(b10);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        } else if (str.startsWith("h")) {
            return 122;
        } else {
            if (str.startsWith(bt.aJ) || str.startsWith(bt.aI) || str.startsWith("a") || str.startsWith("t")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return d.a(context, a.f14849f, sb.toString(), binary);
        }
    }

    public static void a(boolean z10) {
        f14886l = z10;
    }
}
