package com.taobao.accs.utl;

import org.json.JSONException;
import org.json.JSONObject;

public class p {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        JSONObject f13245a = new JSONObject();

        public a a(String str, String str2) {
            if (!(str2 == null || str == null)) {
                try {
                    this.f13245a.put(str, str2);
                } catch (JSONException unused) {
                }
            }
            return this;
        }

        public a a(String str, Integer num) {
            if (num == null) {
                return this;
            }
            try {
                this.f13245a.put(str, num);
            } catch (JSONException unused) {
            }
            return this;
        }

        public a a(String str, Long l10) {
            if (l10 == null) {
                return this;
            }
            try {
                this.f13245a.put(str, l10);
            } catch (JSONException unused) {
            }
            return this;
        }

        public JSONObject a() {
            return this.f13245a;
        }
    }

    public static String a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return str2;
    }
}
