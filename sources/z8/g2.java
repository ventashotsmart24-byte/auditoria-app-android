package z8;

import java.util.concurrent.atomic.AtomicBoolean;
import y8.a;
import y8.k;
import y8.k1;
import y8.n1;
import y8.v0;

public final class g2 {

    /* renamed from: c  reason: collision with root package name */
    public static final g2 f20664c = new g2(new n1[0]);

    /* renamed from: a  reason: collision with root package name */
    public final n1[] f20665a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f20666b = new AtomicBoolean(false);

    public g2(n1[] n1VarArr) {
        this.f20665a = n1VarArr;
    }

    public static g2 h(k[] kVarArr, a aVar, v0 v0Var) {
        g2 g2Var = new g2(kVarArr);
        for (k m10 : kVarArr) {
            m10.m(aVar, v0Var);
        }
        return g2Var;
    }

    public void a() {
        for (n1 n1Var : this.f20665a) {
            ((k) n1Var).j();
        }
    }

    public void b(v0 v0Var) {
        for (n1 n1Var : this.f20665a) {
            ((k) n1Var).k(v0Var);
        }
    }

    public void c() {
        for (n1 n1Var : this.f20665a) {
            ((k) n1Var).l();
        }
    }

    public void d(int i10) {
        for (n1 a10 : this.f20665a) {
            a10.a(i10);
        }
    }

    public void e(int i10, long j10, long j11) {
        for (n1 b10 : this.f20665a) {
            b10.b(i10, j10, j11);
        }
    }

    public void f(long j10) {
        for (n1 c10 : this.f20665a) {
            c10.c(j10);
        }
    }

    public void g(long j10) {
        for (n1 d10 : this.f20665a) {
            d10.d(j10);
        }
    }

    public void i(int i10) {
        for (n1 e10 : this.f20665a) {
            e10.e(i10);
        }
    }

    public void j(int i10, long j10, long j11) {
        for (n1 f10 : this.f20665a) {
            f10.f(i10, j10, j11);
        }
    }

    public void k(long j10) {
        for (n1 g10 : this.f20665a) {
            g10.g(j10);
        }
    }

    public void l(long j10) {
        for (n1 h10 : this.f20665a) {
            h10.h(j10);
        }
    }

    public void m(k1 k1Var) {
        if (this.f20666b.compareAndSet(false, true)) {
            for (n1 i10 : this.f20665a) {
                i10.i(k1Var);
            }
        }
    }
}
