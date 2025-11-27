package k1;

import a1.k;
import a1.s;
import androidx.work.impl.WorkDatabase;
import b1.d;
import b1.j;
import j1.q;

public class m implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    public static final String f7252d = k.f("StopWorkRunnable");

    /* renamed from: a  reason: collision with root package name */
    public final j f7253a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7254b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7255c;

    public m(j jVar, String str, boolean z10) {
        this.f7253a = jVar;
        this.f7254b = str;
        this.f7255c = z10;
    }

    public void run() {
        boolean z10;
        WorkDatabase n10 = this.f7253a.n();
        d l10 = this.f7253a.l();
        q B = n10.B();
        n10.c();
        try {
            boolean h10 = l10.h(this.f7254b);
            if (this.f7255c) {
                z10 = this.f7253a.l().n(this.f7254b);
            } else {
                if (!h10 && B.g(this.f7254b) == s.RUNNING) {
                    B.d(s.ENQUEUED, this.f7254b);
                }
                z10 = this.f7253a.l().o(this.f7254b);
            }
            k.c().a(f7252d, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.f7254b, Boolean.valueOf(z10)}), new Throwable[0]);
            n10.r();
        } finally {
            n10.g();
        }
    }
}
