package com.umeng.analytics.pro;

import com.umeng.ccg.c;
import com.umeng.ccg.d;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

public class ar implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13765a = "https://ucc.umeng.com/v2/inn/fetch";

    /* renamed from: b  reason: collision with root package name */
    private String f13766b;

    /* renamed from: c  reason: collision with root package name */
    private String f13767c;

    /* renamed from: d  reason: collision with root package name */
    private String f13768d;

    public ar(String str, JSONObject jSONObject, String str2) {
        this.f13766b = str;
        this.f13767c = jSONObject.toString();
        this.f13768d = str2;
    }

    public void run() {
        JSONObject jSONObject = null;
        try {
            byte[] a10 = ap.a(this.f13766b, this.f13767c);
            if (a10 != null) {
                JSONObject jSONObject2 = new JSONObject(new String(a10));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.f13768d);
                    jSONObject3.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused2) {
        }
        c.a(UMGlobalContext.getAppContext(), 102, d.a(), jSONObject);
    }
}
