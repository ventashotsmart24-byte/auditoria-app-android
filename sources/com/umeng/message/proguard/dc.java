package com.umeng.message.proguard;

import android.app.Activity;
import android.os.SystemClock;
import com.umeng.message.proguard.bx;
import java.lang.ref.WeakReference;

public abstract class dc {

    /* renamed from: a  reason: collision with root package name */
    public final cz f15729a;

    /* renamed from: b  reason: collision with root package name */
    protected final bx.c f15730b;

    /* renamed from: c  reason: collision with root package name */
    public bx.b f15731c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Activity> f15732d;

    /* renamed from: e  reason: collision with root package name */
    protected int f15733e = 1500;

    /* renamed from: f  reason: collision with root package name */
    protected long f15734f;

    /* renamed from: g  reason: collision with root package name */
    long f15735g;

    public dc(cz czVar) {
        this.f15729a = czVar;
        this.f15730b = czVar.f15717b;
    }

    public final void a() {
        this.f15734f = SystemClock.elapsedRealtime();
        new Runnable() {
            public final void run() {
                try {
                    ck b10 = dc.this.b();
                    if (b10 != null) {
                        bx.a b11 = dc.this.b(b10);
                        if (b11 == null) {
                            ce.a("Load", "type:", dc.this.f15730b, " consume:", Long.valueOf(SystemClock.elapsedRealtime() - dc.this.f15734f));
                            return;
                        }
                        dc.this.f15735g = SystemClock.elapsedRealtime();
                        b10.f15614j = System.currentTimeMillis();
                        cb.c(new Runnable(b10.f15605a, b11) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ bx.c f15737a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ bx.a f15738b;

                            {
                                this.f15737a = r2;
                                this.f15738b = r3;
                            }

                            public final void run() {
                                bx.b bVar = dc.this.f15731c;
                                if (bVar != null) {
                                    bVar.a(this.f15737a, this.f15738b);
                                }
                            }
                        });
                        ce.a("Load", "type:", dc.this.f15730b, " consume:", Long.valueOf(SystemClock.elapsedRealtime() - dc.this.f15734f));
                    }
                } catch (cd e10) {
                    cb.c(new Runnable(e10.getMessage()) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ String f15740a;

                        {
                            this.f15740a = r2;
                        }

                        public final void run() {
                            dc dcVar = dc.this;
                            bx.b bVar = dcVar.f15731c;
                            if (bVar != null) {
                                bVar.a(dcVar.f15730b, this.f15740a);
                            }
                        }
                    });
                } finally {
                    ce.a("Load", "type:", dc.this.f15730b, " consume:", Long.valueOf(SystemClock.elapsedRealtime() - dc.this.f15734f));
                }
            }
        }.run();
    }

    public abstract bx.a b(ck ckVar);

    public abstract ck b();

    public final boolean a(ck ckVar) {
        return SystemClock.elapsedRealtime() - this.f15735g > ((long) ckVar.h());
    }
}
