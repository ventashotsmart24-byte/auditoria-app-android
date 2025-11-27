package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import org.json.JSONObject;

public class cc implements cb {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14030a = "cache_domain";

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f14031b = "";

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final cc f14032a = new cc();

        private a() {
        }
    }

    public static cc b() {
        return a.f14032a;
    }

    private void d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
        if (sharedPreferences != null) {
            f14031b = sharedPreferences.getString(f14030a, "");
        }
    }

    private void e() {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(f14030a, f14031b).commit();
            }
        } catch (Throwable unused) {
        }
    }

    public void a() {
    }

    public String c() {
        return f14031b;
    }

    private cc() {
        d();
    }

    public void a(Throwable th) {
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("Status") && jSONObject.getInt("Status") == 0 && jSONObject.has("Answer")) {
                    String optString = jSONObject.optString("Answer");
                    String str2 = "";
                    if (!TextUtils.isEmpty(optString)) {
                        if (jSONObject.has("ip")) {
                            str2 = jSONObject.optString("ip");
                        }
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> domain下发结果：" + optString);
                        if (!TextUtils.isEmpty(str2)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 对应domain下发请求ip：" + str2);
                        }
                        f14031b = optString;
                        e();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
