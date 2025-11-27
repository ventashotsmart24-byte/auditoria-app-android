package com.umeng.ut.b.b;

import com.taobao.accs.common.Constants;
import com.umeng.ut.a.a;
import com.umeng.ut.a.c.e;
import org.json.JSONObject;

class b {

    /* renamed from: d  reason: collision with root package name */
    int f16244d = -1;

    public static boolean a(int i10) {
        return i10 >= 0 && i10 != 10012;
    }

    public static b a(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has(Constants.KEY_HTTP_CODE)) {
                bVar.f16244d = jSONObject2.getInt(Constants.KEY_HTTP_CODE);
            }
            if (jSONObject2.has("data") && (jSONObject = jSONObject2.getJSONObject("data")) != null && jSONObject.has("id") && jSONObject.has("d_ts")) {
                d.a(a.a().a()).a(jSONObject.getString("id"), jSONObject.getLong("d_ts"));
            }
            e.a("BizResponse", "content", str);
        } catch (Throwable th) {
            e.a("", th.toString());
        }
        return bVar;
    }
}
