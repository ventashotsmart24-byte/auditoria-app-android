package com.mobile.brasiltv.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.TypedValue;
import java.util.regex.Pattern;
import ma.i;
import ma.j;

public abstract class j1 {

    /* renamed from: a  reason: collision with root package name */
    public static String f12593a = "";

    public static int a(Context context, int i10) {
        return (int) TypedValue.applyDimension(1, (float) i10, context.getResources().getDisplayMetrics());
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f12593a)) {
            return f12593a;
        }
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            f12593a = string;
        } else {
            f12593a = i.e("4b4d354a69546a7636736d2f73776a2b705834316d3874536576774470327448", "combrasiltvaslgklxckbcombrasiltv");
        }
        return f12593a;
    }

    public static Long c(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        long j10 = memoryInfo.availMem / 1000000;
        return Long.valueOf(memoryInfo.totalMem / 1000000);
    }

    public static boolean d(String str) {
        return Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(str).matches();
    }

    public static boolean e(String str) {
        return Pattern.compile("^[0-9]{4,}$").matcher(str).matches();
    }

    public static boolean f(String str) {
        return Pattern.compile("[0-9A-Za-z]{6,12}").matcher(str).matches();
    }

    public static boolean g(String str) {
        return Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$").matcher(str).matches();
    }

    public static void h(Context context, String str) {
        f1.f12517a.u(j.a(context, str));
    }

    public static boolean i(String str) {
        return Pattern.compile("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$").matcher(str).matches();
    }
}
