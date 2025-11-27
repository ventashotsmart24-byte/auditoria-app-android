package com.umeng.analytics.pro;

import com.umeng.ccg.a;
import java.util.ArrayList;
import org.json.JSONObject;

public class ad extends ab {

    /* renamed from: a  reason: collision with root package name */
    private String f13712a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f13713b = "";

    public ad(String str, ArrayList<ac> arrayList) {
        super(str, arrayList);
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a10 = super.a(str, jSONObject);
        if (a10 != null) {
            try {
                a10.put(a.f14529v, this.f13712a);
                a10.put("action", this.f13713b);
            } catch (Throwable unused) {
            }
        }
        return a10;
    }

    public void b(String str, JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has("action")) {
            d(jSONObject.optString("action"));
        }
        if (jSONObject.has(a.f14529v)) {
            c(jSONObject.optString(a.f14529v));
        }
    }

    public void c(String str) {
        this.f13712a = str;
    }

    public String d() {
        return this.f13712a;
    }

    public String e() {
        return this.f13713b;
    }

    public void d(String str) {
        this.f13713b = str;
    }
}
