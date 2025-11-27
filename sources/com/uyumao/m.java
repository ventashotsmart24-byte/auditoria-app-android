package com.uyumao;

import android.content.SharedPreferences;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f16290a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f16291b = e.a().getSharedPreferences("um_social_azx", 0);

    public static m a() {
        if (f16290a == null) {
            synchronized (m.class) {
                if (f16290a == null) {
                    f16290a = new m();
                }
            }
        }
        return f16290a;
    }
}
