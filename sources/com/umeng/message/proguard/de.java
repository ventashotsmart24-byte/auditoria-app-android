package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;

public final class de {

    /* renamed from: a  reason: collision with root package name */
    private static Application f15743a;

    public static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        } else if (f15743a == null) {
            f15743a = (Application) context.getApplicationContext();
            dy.a("u", "2.0.0");
            bz.a(context);
        }
    }

    public static Context a() {
        Application application = f15743a;
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("context is null! make sure UMUnionSdk.init(...) be called");
    }
}
