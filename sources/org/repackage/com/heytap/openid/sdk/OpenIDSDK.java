package org.repackage.com.heytap.openid.sdk;

import android.content.Context;
import org.repackage.a.a.a.a.a;
import org.repackage.a.a.a.a.c;

public class OpenIDSDK {
    public static void a(Context context) {
        a.f8629b = c.a.f8637a.a(context.getApplicationContext());
        a.f8628a = true;
    }

    public static String b(Context context) {
        if (a.f8628a) {
            return c.a.f8637a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (a.f8628a) {
            return c.a.f8637a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (a.f8628a) {
            return c.a.f8637a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (a.f8628a) {
            return c.a.f8637a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (a.f8628a) {
            return a.f8629b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
