package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15107a = bd.b().b(bd.f13866z);

    /* renamed from: b  reason: collision with root package name */
    private static final String f15108b = "lastReqTime";

    /* renamed from: c  reason: collision with root package name */
    private static final int f15109c = 48;

    /* renamed from: d  reason: collision with root package name */
    private static final int f15110d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final int f15111e = 720;

    /* renamed from: f  reason: collision with root package name */
    private static final String f15112f = "iss";

    /* renamed from: g  reason: collision with root package name */
    private static final String f15113g = "sinr";

    /* renamed from: h  reason: collision with root package name */
    private static final String f15114h = "clean";

    /* renamed from: i  reason: collision with root package name */
    private static boolean f15115i;

    /* renamed from: j  reason: collision with root package name */
    private static int f15116j;

    /* renamed from: k  reason: collision with root package name */
    private static Object f15117k = new Object();

    static {
        f15115i = false;
        f15116j = f15111e;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, "iss", "");
            if (!TextUtils.isEmpty(imprintProperty) && "1".equals(imprintProperty)) {
                synchronized (f15117k) {
                    f15115i = true;
                }
                String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f15113g, "");
                if (!TextUtils.isEmpty(imprintProperty)) {
                    try {
                        f15116j = a(Integer.parseInt(imprintProperty2));
                    } catch (Throwable unused) {
                        f15116j = 48;
                    }
                } else {
                    f15116j = 48;
                }
            }
        }
    }

    private static int a(int i10) {
        if (i10 > f15111e) {
            return f15111e;
        }
        if (i10 < 1) {
            return 1;
        }
        return i10;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f15107a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(f15108b, 0);
        }
        return 0;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f15107a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f15114h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f15107a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f15114h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f15107a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f15114h, false);
        }
        return false;
    }

    public static boolean a() {
        boolean z10;
        synchronized (f15117k) {
            z10 = f15115i;
        }
        return z10;
    }

    public static int a(Context context) {
        int i10;
        synchronized (f15117k) {
            i10 = f15116j;
        }
        return i10;
    }

    public static boolean a(long j10, long j11, int i10) {
        Date date = new Date(j11);
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j10));
        instance.add(10, i10);
        return date.after(instance.getTime());
    }

    public static void a(Context context, long j10) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f15107a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f15108b, j10).commit();
        }
    }
}
