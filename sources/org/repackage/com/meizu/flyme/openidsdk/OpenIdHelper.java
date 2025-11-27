package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

public class OpenIdHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8642a = "OpenIdHelper";

    /* renamed from: b  reason: collision with root package name */
    private static Method f8643b;

    public static String a(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f8651a);
    }

    public static String b(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f8652b);
    }

    public static String c(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f8654d);
    }

    public static String d(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f8653c);
    }

    public static void a(boolean z10) {
        b.a();
        b.a(z10);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f8643b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f8643b = method;
                method.setAccessible(true);
            }
            context = (Context) f8643b.invoke((Object) null, new Object[0]);
        } catch (Exception e10) {
            Log.e(f8642a, "ActivityThread:currentApplication --> " + e10.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }
}
