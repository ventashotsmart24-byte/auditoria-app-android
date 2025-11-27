package com.hpplay.sdk.source.browser.b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hpplay.common.log.LeLog;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11613a = "DisplayMetricsUtil";

    /* renamed from: b  reason: collision with root package name */
    public static int f11614b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f11615c = -1;

    public static int a(Context context, double d10) {
        if (f11614b <= 0) {
            a(context);
        }
        int i10 = f11614b;
        if (i10 <= 0) {
            return (int) d10;
        }
        double min = (double) Math.min(f11615c, i10);
        Double.isNaN(min);
        return (int) ((d10 * min) / 750.0d);
    }

    public static int b(Context context, double d10) {
        if (f11614b <= 0) {
            a(context);
        }
        if (f11614b <= 0) {
            return (int) d10;
        }
        LeLog.i(f11613a, "getRelativeWidth SCREEN_WIDTH:" + f11614b + ", SCREEN_HEIGHT:" + f11615c);
        double max = (double) Math.max(f11615c, f11614b);
        Double.isNaN(max);
        return (int) ((d10 * max) / 1624.0d);
    }

    public static int c(Context context) {
        int i10;
        if (context == null) {
            return f11615c;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
            i10 = displayMetrics.heightPixels;
        } catch (Exception e10) {
            LeLog.w(f11613a, (Throwable) e10);
            i10 = a(context);
        }
        if (i10 <= 0) {
            return a(context);
        }
        return i10;
    }

    public static void d(Context context) {
        a(context);
    }

    public static int a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        f11614b = displayMetrics.widthPixels;
        int i10 = displayMetrics.heightPixels;
        f11615c = i10;
        return i10;
    }

    public static int b(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            f11614b = displayMetrics.widthPixels;
            f11615c = c(context);
        } catch (Exception e10) {
            LeLog.w(f11613a, "getScreenWidth failed " + e10);
        }
        return f11614b;
    }
}
