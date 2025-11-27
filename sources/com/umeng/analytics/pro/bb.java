package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class bb {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f13821a = {"um_plus_game_level", "um_plus_game_pay", "um_plus_game_buy", "um_plus_game_use", "um_plus_game_bonus"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f13822b = {"id", "ts", f.ac, "__ct__", "pn", "ds"};

    /* renamed from: c  reason: collision with root package name */
    public static final String f13823c = "^(?!\\d)[a-zA-Z0-9_\\-\\+\\.]{1,}$";

    /* renamed from: d  reason: collision with root package name */
    public static final int f13824d = 128;

    /* renamed from: e  reason: collision with root package name */
    public static final int f13825e = 256;

    /* renamed from: f  reason: collision with root package name */
    public static final int f13826f = 100;

    /* renamed from: g  reason: collision with root package name */
    JSONObject f13827g = null;

    /* renamed from: h  reason: collision with root package name */
    private a f13828h;

    /* renamed from: i  reason: collision with root package name */
    private String f13829i;

    /* renamed from: j  reason: collision with root package name */
    private String f13830j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13831k;

    /* renamed from: l  reason: collision with root package name */
    private Map<String, String> f13832l = null;

    /* renamed from: m  reason: collision with root package name */
    private Map<String, Object> f13833m = null;

    /* renamed from: com.umeng.analytics.pro.bb$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13834a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.umeng.analytics.pro.bb$a[] r0 = com.umeng.analytics.pro.bb.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13834a = r0
                com.umeng.analytics.pro.bb$a r1 = com.umeng.analytics.pro.bb.a.ID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13834a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umeng.analytics.pro.bb$a r1 = com.umeng.analytics.pro.bb.a.LABEL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f13834a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umeng.analytics.pro.bb$a r1 = com.umeng.analytics.pro.bb.a.STRING_MAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f13834a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umeng.analytics.pro.bb$a r1 = com.umeng.analytics.pro.bb.a.OBJECT_MAP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.bb.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        ID,
        LABEL,
        STRING_MAP,
        OBJECT_MAP
    }

    private void h() {
        boolean z10;
        String str;
        try {
            JSONArray jSONArray = new JSONArray();
            String str2 = this.f13829i;
            String str3 = "";
            if (str2 == null) {
                jSONArray.put(ay.f13793a);
            } else if (TextUtils.isEmpty(str2.trim())) {
                jSONArray.put(ay.f13794b);
            } else {
                if (this.f13829i.trim().getBytes().length > 128) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (Arrays.asList(f13821a).contains(this.f13829i)) {
                    jSONArray.put(ay.f13795c);
                    str = this.f13829i;
                } else {
                    str = null;
                }
                if (!Pattern.matches(f13823c, this.f13829i)) {
                    jSONArray.put(ay.f13797e);
                    str = this.f13829i;
                }
                if (z10) {
                    jSONArray.put(ay.f13796d);
                    str3 = this.f13829i.length() > 128 ? this.f13829i.substring(0, 128) : this.f13829i;
                } else {
                    str3 = str;
                }
            }
            if (str3 != null) {
                this.f13827g.put("eID", str3);
                if (jSONArray.length() > 0) {
                    this.f13827g.put(Constants.KEY_HTTP_CODE, jSONArray);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            h();
            JSONObject a10 = a(this.f13829i, this.f13830j, true);
            if (a10.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(a10);
                if (this.f13827g == null) {
                    this.f13827g = new JSONObject();
                }
                if (!this.f13827g.has("eID")) {
                    this.f13827g.put("eID", this.f13829i);
                }
                this.f13827g.put("epps", jSONArray);
            }
        } catch (Throwable unused) {
        }
    }

    private void j() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            if (this.f13832l == null) {
                this.f13833m = null;
            } else {
                this.f13833m = new HashMap(this.f13832l);
            }
            a(this.f13833m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            a(this.f13833m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    public a a() {
        return this.f13828h;
    }

    public String b() {
        return this.f13829i;
    }

    public String c() {
        return this.f13830j;
    }

    public boolean d() {
        return this.f13831k;
    }

    public Map<String, String> e() {
        return this.f13832l;
    }

    public Map<String, Object> f() {
        return this.f13833m;
    }

    public JSONObject g() {
        this.f13827g = new JSONObject();
        int i10 = AnonymousClass1.f13834a[this.f13828h.ordinal()];
        if (i10 == 1) {
            h();
            JSONObject jSONObject = this.f13827g;
            if (jSONObject == null || jSONObject.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f13827g);
            }
        } else if (i10 == 2) {
            i();
            JSONObject jSONObject2 = this.f13827g;
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f13827g);
            }
        } else if (i10 == 3) {
            j();
            JSONObject jSONObject3 = this.f13827g;
            if (jSONObject3 == null || jSONObject3.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f13827g);
            }
        } else if (i10 != 4) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "unknown CkItem type!");
        } else {
            k();
            JSONObject jSONObject4 = this.f13827g;
            if (jSONObject4 == null || jSONObject4.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f13827g);
            }
        }
        return this.f13827g;
    }

    private JSONObject c(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (obj instanceof String) {
                return a(str, (String) obj, false);
            }
            if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Float)) {
                return jSONObject;
            }
            if (obj instanceof Double) {
                return jSONObject;
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(ay.f13809q);
            jSONObject.put(Constants.KEY_HTTP_CODE, jSONArray);
            jSONObject.put("pid", obj.getClass().getName());
            jSONObject.put(Constant.KEY_MSG, str);
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public bb a(a aVar) {
        this.f13828h = aVar;
        return this;
    }

    public bb b(String str) {
        this.f13830j = str;
        return this;
    }

    public bb a(String str) {
        this.f13829i = str;
        return this;
    }

    public bb b(Map<String, Object> map) {
        this.f13833m = map;
        return this;
    }

    private void b(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            for (String next : map.keySet()) {
                Object obj = map.get(next);
                JSONArray a10 = a(next, obj);
                if (a10 == null || a10.length() <= 0) {
                    jSONObject.put(next, obj);
                } else {
                    for (int i10 = 0; i10 < a10.length(); i10++) {
                        jSONArray.put(a10.get(i10));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public bb a(boolean z10) {
        this.f13831k = z10;
        return this;
    }

    public bb a(Map<String, String> map) {
        this.f13832l = map;
        return this;
    }

    private void a(JSONObject jSONObject, JSONArray jSONArray) {
        if (this.f13827g == null) {
            this.f13827g = new JSONObject();
        }
        if (jSONArray.length() > 0) {
            this.f13827g.put("epps", jSONArray);
            if (jSONObject.length() > 0) {
                this.f13827g.put("pps", jSONObject);
            }
        }
        if (this.f13827g.has("epps") && !this.f13827g.has(Constants.KEY_HTTP_CODE)) {
            this.f13827g.put("eID", this.f13829i);
        }
    }

    private JSONObject b(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (str == null) {
            try {
                jSONArray.put(ay.f13807o);
                jSONObject.put("pid", "");
            } catch (Throwable unused) {
            }
        } else if (TextUtils.isEmpty(str.trim())) {
            jSONArray.put(ay.f13804l);
            jSONObject.put("pid", "");
        } else {
            boolean z10 = str.trim().getBytes().length > 128;
            if (Arrays.asList(f13822b).contains(str)) {
                jSONArray.put(ay.f13799g);
                jSONObject.put("pid", str);
            }
            if (!Pattern.matches(f13823c, str)) {
                jSONArray.put(ay.f13808p);
                jSONObject.put("pid", str);
            }
            if (z10) {
                jSONArray.put(ay.f13800h);
                if (str.length() > 128) {
                    str = str.substring(0, 128);
                }
                jSONObject.put("pid", str);
            }
        }
        if (jSONArray.length() > 0) {
            jSONObject.put(Constants.KEY_HTTP_CODE, jSONArray);
            jSONObject.put(Constant.KEY_MSG, obj);
        }
        return jSONObject;
    }

    private void a(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            if (map == null) {
                jSONArray2.put(ay.f13806n);
            } else if (map.isEmpty()) {
                jSONArray2.put(ay.f13803k);
            } else if (map.size() > 100) {
                jSONArray2.put(ay.f13798f);
            }
            if (jSONArray2.length() > 0) {
                jSONObject2.put(Constants.KEY_HTTP_CODE, jSONArray2);
                jSONArray.put(jSONObject2);
                return;
            }
            b(map, jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    private JSONArray a(String str, Object obj) {
        JSONArray jSONArray = null;
        try {
            JSONObject b10 = b(str, obj);
            if (b10.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONArray2.put(b10);
                    jSONArray = jSONArray2;
                } catch (Throwable unused) {
                    return jSONArray2;
                }
            }
            JSONObject c10 = c(str, obj);
            if (c10.length() <= 0) {
                return jSONArray;
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.put(c10);
            return jSONArray;
        } catch (Throwable unused2) {
            return jSONArray;
        }
    }

    private JSONObject a(String str, String str2, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (str2 == null) {
                jSONArray.put(ay.f13801i);
                jSONObject.put(Constants.KEY_HTTP_CODE, jSONArray);
                jSONObject.put("pid", "");
                jSONObject.put(Constant.KEY_MSG, str);
            } else if (str2.getBytes().length > 256) {
                if (z10) {
                    jSONArray.put(ay.f13805m);
                } else {
                    jSONArray.put(ay.f13802j);
                }
                jSONObject.put(Constants.KEY_HTTP_CODE, jSONArray);
                if (str2.length() > 256) {
                    str2 = str2.substring(0, 256);
                }
                jSONObject.put("pid", str2);
                jSONObject.put(Constant.KEY_MSG, str);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
