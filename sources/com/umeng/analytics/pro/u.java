package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14433a = "fs_lc_tl_uapp";

    /* renamed from: f  reason: collision with root package name */
    private static final String f14434f = "-1";

    /* renamed from: g  reason: collision with root package name */
    private static Context f14435g;

    /* renamed from: b  reason: collision with root package name */
    private final int f14436b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14437c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14438d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14439e;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f14440h;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final u f14441a = new u();

        private a() {
        }
    }

    public static u a(Context context) {
        if (f14435g == null && context != null) {
            f14435g = context.getApplicationContext();
        }
        return a.f14441a;
    }

    private void b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(f14433a, (String) null);
            if (!TextUtils.isEmpty(string)) {
                this.f14440h = new JSONObject(string);
            }
            a();
        } catch (Exception unused) {
        }
    }

    private void c(Context context) {
        try {
            if (this.f14440h != null) {
                PreferenceWrapper.getDefault(f14435g).edit().putString(f14433a, this.f14440h.toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private u() {
        this.f14436b = 128;
        this.f14437c = 256;
        this.f14438d = 1024;
        this.f14439e = 10;
        this.f14440h = null;
        try {
            b(f14435g);
        } catch (Throwable unused) {
        }
    }

    private boolean c(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(String str, String str2, long j10, int i10, String str3) {
        String str4;
        try {
            if (a(str)) {
                if (b(str2)) {
                    if (Arrays.asList(f.aM).contains(str)) {
                        MLog.e("key is " + str + ", please check key, illegal");
                        UMLog.aq(l.f14321m, 0, "\\|");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", str);
                    jSONObject.put("ts", currentTimeMillis);
                    if (j10 > 0) {
                        jSONObject.put(f.ac, j10);
                    }
                    jSONObject.put("__t", k.f14287a);
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put(str, str2);
                    }
                    if (UMUtils.isMainProgress(f14435g)) {
                        str4 = aa.a().d(UMGlobalContext.getAppContext(f14435g));
                    } else {
                        str4 = aa.a().a(UMGlobalContext.getAppContext(f14435g), currentTimeMillis);
                    }
                    if (TextUtils.isEmpty(str4)) {
                        str4 = f14434f;
                    }
                    jSONObject.put("__i", str4);
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str3);
                            if (jSONObject2.length() > 0) {
                                jSONObject.put(f.aA, jSONObject2);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    jSONObject.put("ds", 0);
                    jSONObject.put("pn", UMGlobalContext.getInstance(f14435g).getProcessName(f14435g));
                    a();
                    JSONObject jSONObject3 = this.f14440h;
                    if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f14440h.get(str)).booleanValue()) {
                        jSONObject.put(f.ae, 1);
                        this.f14440h.put(str, true);
                        c(f14435g);
                    }
                    Context context = f14435g;
                    UMWorkDispatch.sendEvent(context, q.a.f14388a, CoreProtocol.getInstance(context), jSONObject);
                    return;
                }
            }
            UMLog.aq(l.f14320l, 0, "\\|");
        } catch (Throwable unused2) {
        }
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (Exception unused) {
        }
        MLog.e("value is " + str + ", please check value, illegal");
        return false;
    }

    private boolean b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry next : map.entrySet()) {
                        if (!a((String) next.getKey())) {
                            UMLog.aq(l.f14316h, 0, "\\|");
                            return false;
                        } else if (next.getValue() == null) {
                            UMLog.aq(l.f14317i, 0, "\\|");
                            return false;
                        } else if (next.getValue() instanceof String) {
                            if (f.aK.equals(next.getKey())) {
                                if (!c(next.getValue().toString())) {
                                    UMLog.aq(l.P, 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(next.getKey())) {
                                if (!c(next.getValue().toString())) {
                                    UMLog.aq("url参数长度超过限制。|参数url长度不能超过1024字符。", 0, "\\|");
                                    return false;
                                }
                            } else if (!b(next.getValue().toString())) {
                                UMLog.aq(l.f14318j, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        UMLog.aq(l.f14315g, 0, "\\|");
        return false;
    }

    public void a(String str, Map<String, Object> map, long j10, String str2, boolean z10) {
        String str3;
        try {
            if (!a(str)) {
                UMLog.aq(l.f14314f, 0, "\\|");
            } else if (b(map)) {
                if (map.size() > 100) {
                    MLog.e("map size is " + map.size() + ", please check");
                } else if (Arrays.asList(f.aM).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(l.f14310b, 0, "\\|");
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", str);
                    jSONObject.put("ts", System.currentTimeMillis());
                    if (j10 > 0) {
                        jSONObject.put(f.ac, j10);
                    }
                    jSONObject.put("__t", k.f14287a);
                    ULog.i("befort ekv map, event is " + jSONObject.toString());
                    for (Map.Entry next : map.entrySet()) {
                        if (!Arrays.asList(f.aM).contains(next.getKey())) {
                            Object value = next.getValue();
                            if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Float)) {
                                if (!(value instanceof Double)) {
                                    if (!value.getClass().isArray()) {
                                        MLog.e("please check key or value, illegal type!");
                                        return;
                                    } else if (value instanceof int[]) {
                                        int[] iArr = (int[]) value;
                                        if (iArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray = new JSONArray();
                                        for (int put : iArr) {
                                            jSONArray.put(put);
                                        }
                                        jSONObject.put((String) next.getKey(), jSONArray);
                                    } else if (value instanceof double[]) {
                                        double[] dArr = (double[]) value;
                                        if (dArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray2 = new JSONArray();
                                        for (double put2 : dArr) {
                                            jSONArray2.put(put2);
                                        }
                                        jSONObject.put((String) next.getKey(), jSONArray2);
                                    } else if (value instanceof long[]) {
                                        long[] jArr = (long[]) value;
                                        if (jArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray3 = new JSONArray();
                                        for (long put3 : jArr) {
                                            jSONArray3.put(put3);
                                        }
                                        jSONObject.put((String) next.getKey(), jSONArray3);
                                    } else if (value instanceof float[]) {
                                        float[] fArr = (float[]) value;
                                        if (fArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray4 = new JSONArray();
                                        for (float f10 : fArr) {
                                            jSONArray4.put((double) f10);
                                        }
                                        jSONObject.put((String) next.getKey(), jSONArray4);
                                    } else if (value instanceof short[]) {
                                        short[] sArr = (short[]) value;
                                        if (sArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray5 = new JSONArray();
                                        for (short put4 : sArr) {
                                            jSONArray5.put(put4);
                                        }
                                        jSONObject.put((String) next.getKey(), jSONArray5);
                                    } else if (value instanceof String[]) {
                                        String[] strArr = (String[]) value;
                                        if (strArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray6 = new JSONArray();
                                        int i10 = 0;
                                        while (i10 < strArr.length) {
                                            String str4 = strArr[i10];
                                            if (str4 == null) {
                                                MLog.e("please check array, null item!");
                                                return;
                                            } else if (b(str4)) {
                                                jSONArray6.put(strArr[i10]);
                                                i10++;
                                            } else {
                                                return;
                                            }
                                        }
                                        jSONObject.put((String) next.getKey(), jSONArray6);
                                    } else {
                                        MLog.e("please check key or value, illegal type!");
                                        return;
                                    }
                                }
                            }
                            jSONObject.put((String) next.getKey(), value);
                        } else {
                            UMLog.aq(l.f14313e, 0, "\\|");
                            return;
                        }
                    }
                    if (UMUtils.isMainProgress(f14435g)) {
                        str3 = aa.a().d(UMGlobalContext.getAppContext(f14435g));
                    } else {
                        str3 = aa.a().a(UMGlobalContext.getAppContext(f14435g), jSONObject.getLong("ts"));
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = f14434f;
                    }
                    jSONObject.put("__i", str3);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str2);
                            if (jSONObject2.length() > 0) {
                                jSONObject.put(f.aA, jSONObject2);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    jSONObject.put("ds", 0);
                    jSONObject.put("pn", UMGlobalContext.getInstance(f14435g).getProcessName(f14435g));
                    a();
                    JSONObject jSONObject3 = this.f14440h;
                    if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f14440h.get(str)).booleanValue()) {
                        jSONObject.put(f.ae, 1);
                        this.f14440h.put(str, true);
                        c(f14435g);
                    }
                    ULog.i("----->>>>>ekv event json is " + jSONObject.toString());
                    if (!z10) {
                        Context context = f14435g;
                        UMWorkDispatch.sendEvent(context, q.a.f14388a, CoreProtocol.getInstance(context), jSONObject);
                        return;
                    }
                    Context context2 = f14435g;
                    UMWorkDispatch.sendEvent(context2, q.a.f14401n, CoreProtocol.getInstance(context2), jSONObject);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, Map<String, Object> map, String str2) {
        try {
            if (a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(f.ac, 0);
                jSONObject.put("__t", k.f14288b);
                ULog.i("befort gkv map, event is " + jSONObject.toString());
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i10 = 0; i10 < 10 && it.hasNext(); i10++) {
                    Map.Entry next = it.next();
                    if (!f.ae.equals(next.getKey()) && !f.ac.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put((String) next.getKey(), value);
                        }
                    }
                }
                String d10 = aa.a().d(UMGlobalContext.getAppContext(f14435g));
                if (TextUtils.isEmpty(d10)) {
                    d10 = f14434f;
                }
                jSONObject.put("__i", d10);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(f.aA, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f14435g).getProcessName(f14435g));
                ULog.i("----->>>>>gkv event json is " + jSONObject.toString());
                Context context = f14435g;
                UMWorkDispatch.sendEvent(context, q.a.f14389b, CoreProtocol.getInstance(context), jSONObject);
            }
        } catch (Throwable unused2) {
        }
    }

    private void a() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f14435g, "track_list", "");
            if (!TextUtils.isEmpty(imprintProperty)) {
                String[] split = imprintProperty.split("!");
                JSONObject jSONObject = new JSONObject();
                int i10 = 0;
                if (this.f14440h != null) {
                    for (String subStr : split) {
                        String subStr2 = HelperUtils.subStr(subStr, 128);
                        if (this.f14440h.has(subStr2)) {
                            jSONObject.put(subStr2, this.f14440h.get(subStr2));
                        }
                    }
                }
                this.f14440h = new JSONObject();
                if (split.length >= 10) {
                    while (i10 < 10) {
                        a(split[i10], jSONObject);
                        i10++;
                    }
                } else {
                    while (i10 < split.length) {
                        a(split[i10], jSONObject);
                        i10++;
                    }
                }
                c(f14435g);
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str, JSONObject jSONObject) {
        String subStr = HelperUtils.subStr(str, 128);
        if (jSONObject.has(subStr)) {
            a(subStr, ((Boolean) jSONObject.get(subStr)).booleanValue());
        } else {
            a(subStr, false);
        }
    }

    private void a(String str, boolean z10) {
        try {
            if (!f.ae.equals(str) && !f.ac.equals(str) && !"id".equals(str) && !"ts".equals(str) && !this.f14440h.has(str)) {
                this.f14440h.put(str, z10);
            }
        } catch (Exception unused) {
        }
    }

    public void a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    a();
                    JSONObject jSONObject = this.f14440h;
                    if (jSONObject == null) {
                        this.f14440h = new JSONObject();
                        int size = list.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size) {
                                break;
                            }
                            JSONObject jSONObject2 = this.f14440h;
                            if (jSONObject2 != null) {
                                if (jSONObject2.length() >= 5) {
                                    break;
                                }
                            } else {
                                this.f14440h = new JSONObject();
                            }
                            String str = list.get(i10);
                            if (!TextUtils.isEmpty(str)) {
                                a(HelperUtils.subStr(str, 128), false);
                            }
                            i10++;
                        }
                        c(f14435g);
                        return;
                    } else if (jSONObject.length() >= 5) {
                        MLog.d("already setFistLaunchEvent, igone.");
                        return;
                    } else {
                        int i11 = 0;
                        while (i11 < list.size()) {
                            if (this.f14440h.length() >= 5) {
                                MLog.d(" add setFistLaunchEvent over.");
                                return;
                            } else {
                                a(HelperUtils.subStr(list.get(i11), 128), false);
                                i11++;
                            }
                        }
                        c(f14435g);
                        return;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
        UMLog.aq(l.ak, 0, "\\|");
    }

    private JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : map.entrySet()) {
                try {
                    String str = (String) next.getKey();
                    if (str != null) {
                        String subStr = HelperUtils.subStr(str, 128);
                        Object value = next.getValue();
                        if (value != null) {
                            int i10 = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    JSONArray jSONArray = new JSONArray();
                                    while (i10 < iArr.length) {
                                        jSONArray.put(iArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    JSONArray jSONArray2 = new JSONArray();
                                    while (i10 < dArr.length) {
                                        jSONArray2.put(dArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    JSONArray jSONArray3 = new JSONArray();
                                    while (i10 < jArr.length) {
                                        jSONArray3.put(jArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    JSONArray jSONArray4 = new JSONArray();
                                    while (i10 < fArr.length) {
                                        jSONArray4.put((double) fArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    JSONArray jSONArray5 = new JSONArray();
                                    while (i10 < sArr.length) {
                                        jSONArray5.put(sArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray5);
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                JSONArray jSONArray6 = new JSONArray();
                                while (i10 < list.size()) {
                                    Object obj = list.get(i10);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray6.put(list.get(i10));
                                    }
                                    i10++;
                                }
                                if (jSONArray6.length() > 0) {
                                    jSONObject.put(subStr, jSONArray6);
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(subStr, HelperUtils.subStr(value.toString(), 256));
                            } else {
                                if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double)) {
                                    if (!(value instanceof Short)) {
                                        MLog.e("The param has not support type. please check !");
                                    }
                                }
                                jSONObject.put(subStr, value);
                            }
                        }
                    }
                } catch (Exception e10) {
                    MLog.e((Throwable) e10);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private boolean a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        MLog.e("key is " + str + ", please check key, illegal");
        return false;
    }
}
