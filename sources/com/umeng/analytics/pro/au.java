package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

public class au {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13780a = "cl_count";

    /* renamed from: b  reason: collision with root package name */
    public static final String f13781b = "interval_";

    /* renamed from: c  reason: collision with root package name */
    public static final String f13782c = "config_ts";

    /* renamed from: d  reason: collision with root package name */
    public static final String f13783d = "iucc_s1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f13784e = "iucc_s2";

    /* renamed from: f  reason: collision with root package name */
    public static final String f13785f = "sdk_type_ver";

    /* renamed from: g  reason: collision with root package name */
    public static final String f13786g = "should_fetch";

    /* renamed from: h  reason: collision with root package name */
    public static final String f13787h = "last_type_index";

    /* renamed from: i  reason: collision with root package name */
    private static final String f13788i = "ccg_sp_config_file";

    private au() {
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(f13788i, 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
