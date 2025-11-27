package com.umeng.message.proguard;

import com.umeng.message.proguard.cq;

public class cr extends cq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile cr f15646a;

    private cr() {
    }

    public static cq a() {
        if (f15646a == null) {
            synchronized (cr.class) {
                if (f15646a == null) {
                    f15646a = new cr();
                }
            }
        }
        return f15646a;
    }

    public final void b(final ck ckVar, final int i10) {
        cb.b(new Runnable() {
            public final void run() {
                cs.a().a(ckVar, i10);
            }
        });
    }

    public final void c(final ck ckVar, final int i10) {
        cb.b(new Runnable() {
            public final void run() {
                cs.a().c(ckVar, i10);
            }
        });
    }

    public final boolean b(ck ckVar) {
        return cs.a().a(ckVar);
    }

    public final void a(final ck ckVar, final cq.a aVar) {
        cb.b(new Runnable() {
            public final void run() {
                cs.a().a(ckVar, aVar);
            }
        });
    }

    public final void a(final ck ckVar, final int i10) {
        cb.b(new Runnable() {
            public final void run() {
                cs.a().b(ckVar, i10);
            }
        });
    }

    public final void a(final ck ckVar) {
        cb.b(new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f15660b = 3011;

            public final void run() {
                cs.a().a(ckVar, 9, this.f15660b);
            }
        });
    }

    public final void a(ck ckVar, int i10, int i11, String str) {
        cs.a().a(ckVar, i10, i11, str);
    }

    public final void a(boolean z10, ck ckVar, boolean z11, int i10, int i11, long j10) {
        final boolean z12 = z10;
        final ck ckVar2 = ckVar;
        final boolean z13 = z11;
        final int i12 = i10;
        final int i13 = i11;
        final long j11 = j10;
        cb.b(new Runnable() {
            public final void run() {
                cs.a().a(z12, ckVar2, z13, i12, i13, j11);
            }
        });
    }

    public final void a(final ck ckVar, final boolean z10, final cq.a aVar) {
        cb.b(new Runnable() {
            public final void run() {
                cs.a().a(ckVar, z10, aVar);
            }
        });
    }

    public final void a(final String str, final ck ckVar) {
        cb.b(new Runnable() {
            public final void run() {
                cs.a().a(str, ckVar);
            }
        });
    }
}
