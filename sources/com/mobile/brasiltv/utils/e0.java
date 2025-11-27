package com.mobile.brasiltv.utils;

import android.content.Context;
import com.umeng.analytics.pro.f;
import t9.i;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public static final e0 f12514a = new e0();

    /* renamed from: b  reason: collision with root package name */
    public static final String f12515b = "show_gesture";

    public static /* synthetic */ String c(e0 e0Var, Context context, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        return e0Var.b(context, str, str2);
    }

    public final boolean a(Context context, String str, boolean z10) {
        i.g(context, f.X);
        i.g(str, "defaultKey");
        return context.getApplicationContext().getSharedPreferences(f12515b, 0).getBoolean(str, z10);
    }

    public final String b(Context context, String str, String str2) {
        i.g(context, f.X);
        i.g(str, "defaultKey");
        i.g(str2, "defaultValue");
        String string = context.getApplicationContext().getSharedPreferences(f12515b, 0).getString(str, str2);
        if (string == null) {
            return "";
        }
        return string;
    }

    public final void d(Context context, String str, String str2) {
        i.g(context, f.X);
        i.g(str, "defaultKey");
        i.g(str2, "values");
        context.getApplicationContext().getSharedPreferences(f12515b, 0).edit().putString(str, str2).apply();
    }

    public final void e(Context context, String str, boolean z10) {
        i.g(context, f.X);
        i.g(str, "defaultKey");
        context.getApplicationContext().getSharedPreferences(f12515b, 0).edit().putBoolean(str, z10).apply();
    }
}
