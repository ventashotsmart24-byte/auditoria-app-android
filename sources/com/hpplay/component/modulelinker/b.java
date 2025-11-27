package com.hpplay.component.modulelinker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LruCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10541a = "LinkerInfosManager";

    /* renamed from: e  reason: collision with root package name */
    private static final String f10542e = "putLinkInfo";

    /* renamed from: f  reason: collision with root package name */
    private static final String f10543f = "ModuleInfos";

    /* renamed from: g  reason: collision with root package name */
    private static final String f10544g = "CLAZZS";

    /* renamed from: h  reason: collision with root package name */
    private static final String f10545h = "METHODS";

    /* renamed from: i  reason: collision with root package name */
    private static final String f10546i = "FIELDS";

    /* renamed from: j  reason: collision with root package name */
    private static volatile b f10547j;

    /* renamed from: b  reason: collision with root package name */
    private JSONArray f10548b = new JSONArray();

    /* renamed from: c  reason: collision with root package name */
    private JSONArray f10549c = new JSONArray();

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f10550d = new JSONArray();

    /* renamed from: k  reason: collision with root package name */
    private LruCache<String, Object> f10551k;

    /* renamed from: l  reason: collision with root package name */
    private Map<String, String> f10552l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    private Context f10553m;

    public static b a() {
        if (f10547j == null) {
            synchronized (b.class) {
                if (f10547j == null) {
                    f10547j = new b();
                }
            }
        }
        return f10547j;
    }

    public LruCache b() {
        return this.f10551k;
    }

    public Context c() {
        return this.f10553m;
    }

    public Map<String, String> d() {
        return this.f10552l;
    }

    public JSONArray e() {
        return this.f10548b;
    }

    public JSONArray f() {
        return this.f10549c;
    }

    public JSONArray g() {
        return this.f10550d;
    }

    public Object b(String str) {
        LruCache<String, Object> lruCache = this.f10551k;
        if (lruCache == null) {
            return null;
        }
        return lruCache.remove(str);
    }

    public String c(String str) {
        return this.f10552l.get(str);
    }

    public void a(Context context, String str, List<String> list, int i10) {
        this.f10553m = context;
        this.f10551k = new LruCache<String, Object>(1000) {
            /* renamed from: a */
            public void entryRemoved(boolean z10, String str, Object obj, Object obj2) {
                super.entryRemoved(z10, str, obj, obj2);
            }
        };
        a(context, list, str);
    }

    private void a(Context context, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (list.size() > 0) {
                for (int i10 = 0; i10 < list.size(); i10++) {
                    String str2 = list.get(i10) + "." + f10543f;
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            } else {
                arrayList.add("com.hpplay.component.common.utils.ModuleInfos");
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                StringBuilder sb = new StringBuilder();
                sb.append(" =================  ");
                sb.append((String) arrayList.get(i11));
                Object a10 = d.a((String) arrayList.get(i11), (Class<?>[]) null, (Object[]) null);
                if (a10 != null) {
                    try {
                        d.a(a10, f10542e, new Object[0]);
                        a((String) d.a(a10, f10544g), this.f10548b);
                        a((String) d.a(a10, f10545h), this.f10549c);
                        a((String) d.a(a10, f10546i), this.f10550d);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    private void a(String str, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str)) {
            for (String decode : str.split("#")) {
                jSONArray.put(new String(Base64.decode(decode, 0)));
            }
        }
    }

    public void a(String str, Object obj) {
        this.f10551k.put(str, obj);
    }

    public Object a(String str) {
        return this.f10551k.get(str);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f10552l.put(str, str2);
        }
    }
}
