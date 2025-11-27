package com.umeng.message.proguard;

import android.content.SharedPreferences;
import android.text.TextUtils;

public class bc {

    /* renamed from: b  reason: collision with root package name */
    private static volatile bc f15494b;

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f15495a = y.a().getSharedPreferences("umeng_push", 0);

    private bc() {
    }

    public static bc a() {
        if (f15494b == null) {
            synchronized (bc.class) {
                if (f15494b == null) {
                    f15494b = new bc();
                }
            }
        }
        return f15494b;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f15495a.edit().putString(str, str2).apply();
        }
    }

    public final void a(String str) {
        if (this.f15495a.contains(str)) {
            this.f15495a.edit().remove(str).apply();
        }
    }
}
