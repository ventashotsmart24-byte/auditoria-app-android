package com.mobile.brasiltv.utils;

import android.content.Context;
import com.umeng.analytics.pro.f;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f12585a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static final String f12586b = "check_device";

    public final int a(Context context, String str, int i10) {
        t9.i.g(context, f.X);
        t9.i.g(str, "defaultKey");
        return context.getApplicationContext().getSharedPreferences(f12586b, 0).getInt(str, i10);
    }

    public final void b(Context context, String str, int i10) {
        t9.i.g(context, f.X);
        t9.i.g(str, "defaultKey");
        context.getApplicationContext().getSharedPreferences(f12586b, 0).edit().putInt(str, i10).apply();
    }
}
