package com.umeng.message.proguard;

import android.content.SharedPreferences;
import android.text.TextUtils;

public class ds {

    /* renamed from: b  reason: collision with root package name */
    private static volatile ds f15879b;

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f15880a = de.a().getSharedPreferences("um_push_union", 0);

    private ds() {
    }

    public static ds a() {
        if (f15879b == null) {
            synchronized (ds.class) {
                if (f15879b == null) {
                    f15879b = new ds();
                }
            }
        }
        return f15879b;
    }

    public final String b(String str, String str2) {
        return this.f15880a.getString(str, str2);
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f15880a.edit().putString(str, str2).apply();
        }
    }
}
