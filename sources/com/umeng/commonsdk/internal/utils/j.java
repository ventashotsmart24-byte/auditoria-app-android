package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14831a = bd.b().b(bd.f13858r);

    /* renamed from: b  reason: collision with root package name */
    private static final String f14832b = "um_common_strength";

    /* renamed from: c  reason: collision with root package name */
    private static final String f14833c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f14831a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f14833c, (String) null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context != null && !TextUtils.isEmpty(str) && (sharedPreferences = context.getApplicationContext().getSharedPreferences(f14831a, 0)) != null) {
            sharedPreferences.edit().putString(f14833c, str).commit();
        }
    }
}
