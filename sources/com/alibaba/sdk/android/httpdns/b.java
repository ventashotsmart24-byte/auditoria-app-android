package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f4917a = null;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f4a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f4918b = true;

    public static void a(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("httpdns_config_enable", 0);
            f4917a = sharedPreferences;
            if (sharedPreferences != null) {
                f4a = sharedPreferences.getBoolean("key_enable", true);
            }
        }
    }

    public static void b(boolean z10) {
        f4918b = z10;
    }

    public static void a(boolean z10) {
        f4a = z10;
        SharedPreferences sharedPreferences = f4917a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("key_enable", z10);
            edit.apply();
        }
    }

    public static boolean a() {
        return f4a && f4918b;
    }
}
