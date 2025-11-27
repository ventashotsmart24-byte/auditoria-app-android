package z8;

import com.google.common.base.Preconditions;
import com.taobao.accs.common.Constants;
import g9.b;
import g9.c;
import java.io.InputStream;
import y8.l;
import y8.n;
import y8.u;
import z8.f;
import z8.i2;
import z8.k1;

public abstract class d implements h2 {

    public static abstract class a implements f.h, k1.b {

        /* renamed from: a  reason: collision with root package name */
        public y f20452a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f20453b = new Object();

        /* renamed from: c  reason: collision with root package name */
        public final g2 f20454c;

        /* renamed from: d  reason: collision with root package name */
        public final m2 f20455d;

        /* renamed from: e  reason: collision with root package name */
        public final k1 f20456e;

        /* renamed from: f  reason: collision with root package name */
        public int f20457f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f20458g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f20459h;

        /* renamed from: z8.d$a$a  reason: collision with other inner class name */
        public class C0302a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f20460a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f20461b;

            public C0302a(b bVar, int i10) {
                this.f20460a = bVar;
                this.f20461b = i10;
            }

            public void run() {
                c.f("AbstractStream.request");
                c.d(this.f20460a);
                try {
                    a.this.f20452a.b(this.f20461b);
                } catch (Throwable th) {
                    c.h("AbstractStream.request");
                    throw th;
                }
                c.h("AbstractStream.request");
            }
        }

        public a(int i10, g2 g2Var, m2 m2Var) {
            this.f20454c = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
            this.f20455d = (m2) Preconditions.checkNotNull(m2Var, "transportTracer");
            k1 k1Var = new k1(this, l.b.f20085a, i10, g2Var, m2Var);
            this.f20456e = k1Var;
            this.f20452a = k1Var;
        }

        public void a(i2.a aVar) {
            o().a(aVar);
        }

        public final void b(int i10) {
            boolean z10;
            boolean z11;
            boolean z12;
            synchronized (this.f20453b) {
                Preconditions.checkState(this.f20458g, "onStreamAllocated was not called, but it seems the stream is active");
                int i11 = this.f20457f;
                z10 = true;
                if (i11 < 32768) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int i12 = i11 - i10;
                this.f20457f = i12;
                if (i12 < 32768) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z11 || !z12) {
                    z10 = false;
                }
            }
            if (z10) {
                p();
            }
        }

        public final void k(boolean z10) {
            if (z10) {
                this.f20452a.close();
            } else {
                this.f20452a.m();
            }
        }

        public final void l(t1 t1Var) {
            try {
                this.f20452a.f(t1Var);
            } catch (Throwable th) {
                d(th);
            }
        }

        public m2 m() {
            return this.f20455d;
        }

        public final boolean n() {
            boolean z10;
            synchronized (this.f20453b) {
                if (!this.f20458g || this.f20457f >= 32768 || this.f20459h) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            }
            return z10;
        }

        public abstract i2 o();

        public final void p() {
            boolean n10;
            synchronized (this.f20453b) {
                n10 = n();
            }
            if (n10) {
                o().d();
            }
        }

        public final void q(int i10) {
            synchronized (this.f20453b) {
                this.f20457f += i10;
            }
        }

        public void r() {
            boolean z10;
            boolean z11 = false;
            if (o() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10);
            synchronized (this.f20453b) {
                if (!this.f20458g) {
                    z11 = true;
                }
                Preconditions.checkState(z11, "Already allocated");
                this.f20458g = true;
            }
            p();
        }

        public final void s() {
            synchronized (this.f20453b) {
                this.f20459h = true;
            }
        }

        public final void t() {
            this.f20456e.E(this);
            this.f20452a = this.f20456e;
        }

        public final void u(int i10) {
            f(new C0302a(c.e(), i10));
        }

        public final void v(u uVar) {
            this.f20452a.e(uVar);
        }

        public void w(r0 r0Var) {
            this.f20456e.z(r0Var);
            this.f20452a = new f(this, this, this.f20456e);
        }

        public final void x(int i10) {
            this.f20452a.c(i10);
        }
    }

    public final void a(n nVar) {
        r().a((n) Preconditions.checkNotNull(nVar, "compressor"));
    }

    public final void b(int i10) {
        t().u(i10);
    }

    public final void flush() {
        if (!r().isClosed()) {
            r().flush();
        }
    }

    public final void h(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream, Constants.SHARED_MESSAGE_ID_FILE);
        try {
            if (!r().isClosed()) {
                r().b(inputStream);
            }
        } finally {
            q0.d(inputStream);
        }
    }

    public void i() {
        t().t();
    }

    public boolean m() {
        return t().n();
    }

    public final void q() {
        r().close();
    }

    public abstract o0 r();

    public final void s(int i10) {
        t().q(i10);
    }

    public abstract a t();
}
