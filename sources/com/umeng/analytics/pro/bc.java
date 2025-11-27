package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

public class bc {

    /* renamed from: a  reason: collision with root package name */
    private static String f13840a;

    public static JSONObject a(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            if (!TextUtils.isEmpty(f13840a)) {
                try {
                    jSONObject = new JSONObject(f13840a);
                } catch (Exception unused) {
                }
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("appkey", UMUtils.getAppkey(context));
                jSONObject3.put("channel", UMUtils.getChannel(context));
                jSONObject3.put(Constants.KEY_BRAND, Build.BRAND);
                jSONObject3.put("osVersion", Build.VERSION.RELEASE);
                jSONObject3.put(bt.f13913g, UMUtils.getUMId(context));
                jSONObject3.put(bt.al, UMUtils.getZid(context));
                jSONObject3.put("deviceModel", Build.MODEL);
                jSONObject3.put(DispatchConstants.PLATFORM, "Android");
                jSONObject3.put("appVersion", DeviceConfig.getAppVersionName(context));
                jSONObject3.put(Constants.KEY_SDK_VERSION, "9.7.9");
                f13840a = jSONObject3.toString();
                jSONObject = new JSONObject(f13840a);
            }
            jSONObject2 = jSONObject;
            jSONObject2.put("sessionid", DeviceConfig.getSid(context));
            jSONObject2.put("ts", System.currentTimeMillis());
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                jSONObject.put("ekverr", jSONObject2);
            } catch (Throwable unused) {
            }
        }
    }
}
