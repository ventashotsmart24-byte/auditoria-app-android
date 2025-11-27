package org.repackage.com.miui.deviceid;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

public class IdentifierManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8663a = "IdentifierManager";

    /* renamed from: b  reason: collision with root package name */
    private static Object f8664b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f8665c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f8666d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f8667e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f8668f;

    /* renamed from: g  reason: collision with root package name */
    private static Method f8669g;

    static {
        Class<Context> cls = Context.class;
        try {
            Class<?> cls2 = Class.forName("com.android.id.impl.IdProviderImpl");
            f8665c = cls2;
            f8664b = cls2.newInstance();
            f8666d = f8665c.getMethod("getUDID", new Class[]{cls});
            f8667e = f8665c.getMethod("getOAID", new Class[]{cls});
            f8668f = f8665c.getMethod("getVAID", new Class[]{cls});
            f8669g = f8665c.getMethod("getAAID", new Class[]{cls});
        } catch (Exception e10) {
            Log.e(f8663a, "reflect exception!", e10);
        }
    }

    public static boolean a() {
        return (f8665c == null || f8664b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f8667e);
    }

    public static String c(Context context) {
        return a(context, f8668f);
    }

    public static String d(Context context) {
        return a(context, f8669g);
    }

    public static String a(Context context) {
        return a(context, f8666d);
    }

    private static String a(Context context, Method method) {
        Object obj = f8664b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, new Object[]{context});
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e10) {
            Log.e(f8663a, "invoke exception!", e10);
            return null;
        }
    }
}
