package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f14499a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, a> f14500b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f14501c;

    private c() {
    }

    public static c a(Context context) {
        if (f14499a == null) {
            synchronized (c.class) {
                if (f14499a == null) {
                    f14499a = new c();
                }
            }
        }
        c cVar = f14499a;
        cVar.f14501c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f14500b.get(str) != null) {
            return this.f14500b.get(str);
        }
        a a10 = a.a(this.f14501c, str);
        this.f14500b.put(str, a10);
        return a10;
    }

    public synchronized void b(String str) {
        c(str).b();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f14502a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        private SQLiteOpenHelper f14503b;

        /* renamed from: c  reason: collision with root package name */
        private SQLiteDatabase f14504c;

        private a() {
        }

        public static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f14503b = b.a(appContext, str);
            return aVar;
        }

        public synchronized void b() {
            try {
                if (this.f14502a.decrementAndGet() == 0) {
                    this.f14504c.close();
                }
            } catch (Throwable unused) {
            }
        }

        public synchronized SQLiteDatabase a() {
            if (this.f14502a.incrementAndGet() == 1) {
                this.f14504c = this.f14503b.getWritableDatabase();
            }
            return this.f14504c;
        }
    }

    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
