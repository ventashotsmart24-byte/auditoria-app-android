package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

public class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13759a = "https://aspect-upush.umeng.com/occa/v1/event/report";

    /* renamed from: b  reason: collision with root package name */
    public static final String f13760b = "https://cnlogs.umeng.com/ext_event";

    /* renamed from: c  reason: collision with root package name */
    public static final String f13761c = "https://cnlogs.umeng.com/uapp_ekverr_logs";

    /* renamed from: d  reason: collision with root package name */
    private String f13762d;

    /* renamed from: e  reason: collision with root package name */
    private String f13763e;

    /* renamed from: f  reason: collision with root package name */
    private String f13764f = null;

    public aq(String str, JSONObject jSONObject) {
        this.f13762d = str;
        this.f13763e = jSONObject.toString();
    }

    public void run() {
        try {
            if (!TextUtils.isEmpty(this.f13763e)) {
                ap.a(this.f13762d, this.f13763e.getBytes(), this.f13764f);
            }
        } catch (Throwable unused) {
        }
    }

    public aq(String str, JSONObject jSONObject, String str2) {
        this.f13762d = str;
        this.f13763e = jSONObject.toString();
        this.f13764f = str2;
    }
}
