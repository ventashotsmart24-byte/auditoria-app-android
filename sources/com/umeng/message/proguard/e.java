package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import org.json.JSONObject;

public final class e {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Application a10 = y.a();
            jSONObject.put("appkey", PushAgent.getInstance(a10).getMessageAppkey());
            jSONObject.put("channel", PushAgent.getInstance(a10).getMessageChannel());
            jSONObject.put(bt.f13913g, d.k(a10));
            jSONObject.put("din", d.c(a10));
            jSONObject.put("device_id", d.d(a10));
            jSONObject.put(bt.f13928v, d.f(a10));
            jSONObject.put(bt.A, d.c());
            if (d.e(a10) != null) {
                jSONObject.put("android_id", d.e(a10));
            }
            if (d.b() != null) {
                jSONObject.put("serial_number", d.b());
            }
            String p10 = d.p(a10);
            if ("false".equals(p10)) {
                UMLog.aq(ac.f15318b, 0, "\\|");
            }
            jSONObject.put("push_switch", p10);
            jSONObject.put(bt.f13927u, "Android");
            jSONObject.put("sdk_version", MsgConstant.SDK_VERSION);
            String[] g10 = d.g(a10);
            jSONObject.put(bt.Q, g10[0]);
            jSONObject.put(bt.R, g10[1]);
            jSONObject.put("carrier", d.m(a10));
            jSONObject.put("device_model", d.d());
            jSONObject.put("os", "Android");
            jSONObject.put(bt.f13931y, Build.VERSION.RELEASE);
            jSONObject.put("app_version", d.b(a10));
            jSONObject.put("version_code", d.a((Context) a10));
            jSONObject.put(bt.f13921o, a10.getPackageName());
            jSONObject.put(bt.f13932z, d.l(a10));
            jSONObject.put(bt.f13929w, d.a());
            jSONObject.put(bt.M, d.i(a10));
            String[] j10 = d.j(a10);
            jSONObject.put(bt.O, j10[0]);
            jSONObject.put("language", j10[1]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
