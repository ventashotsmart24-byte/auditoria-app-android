package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

class i {

    /* renamed from: b  reason: collision with root package name */
    private static SQLiteOpenHelper f14282b;

    /* renamed from: d  reason: collision with root package name */
    private static Context f14283d;

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f14284a;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f14285c;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final i f14286a = new i();

        private a() {
        }
    }

    public static i a(Context context) {
        if (f14283d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            f14283d = applicationContext;
            f14282b = h.a(applicationContext);
        }
        return a.f14286a;
    }

    public synchronized void b() {
        try {
            if (this.f14284a.decrementAndGet() == 0) {
                this.f14285c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private i() {
        this.f14284a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.f14284a.incrementAndGet() == 1) {
            this.f14285c = f14282b.getWritableDatabase();
        }
        return this.f14285c;
    }
}
