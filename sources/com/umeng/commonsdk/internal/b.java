package com.umeng.commonsdk.internal;

import android.content.Context;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f14776b;

    /* renamed from: a  reason: collision with root package name */
    private Context f14777a;

    /* renamed from: c  reason: collision with root package name */
    private c f14778c;

    private b(Context context) {
        this.f14777a = context;
        this.f14778c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f14776b == null) {
                f14776b = new b(context.getApplicationContext());
            }
            bVar = f14776b;
        }
        return bVar;
    }

    public c a() {
        return this.f14778c;
    }
}
