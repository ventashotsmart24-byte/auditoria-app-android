package f9;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import y8.k1;
import y8.o0;
import y8.p;

public final class d extends a {

    /* renamed from: l  reason: collision with root package name */
    public static final o0.i f16751l = new c();

    /* renamed from: c  reason: collision with root package name */
    public final o0 f16752c;

    /* renamed from: d  reason: collision with root package name */
    public final o0.d f16753d;

    /* renamed from: e  reason: collision with root package name */
    public o0.c f16754e;

    /* renamed from: f  reason: collision with root package name */
    public o0 f16755f;

    /* renamed from: g  reason: collision with root package name */
    public o0.c f16756g;

    /* renamed from: h  reason: collision with root package name */
    public o0 f16757h;

    /* renamed from: i  reason: collision with root package name */
    public p f16758i;

    /* renamed from: j  reason: collision with root package name */
    public o0.i f16759j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16760k;

    public class a extends o0 {

        /* renamed from: f9.d$a$a  reason: collision with other inner class name */
        public class C0221a extends o0.i {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k1 f16762a;

            public C0221a(k1 k1Var) {
                this.f16762a = k1Var;
            }

            public o0.e a(o0.f fVar) {
                return o0.e.f(this.f16762a);
            }

            public String toString() {
                return MoreObjects.toStringHelper((Class<?>) C0221a.class).add("error", (Object) this.f16762a).toString();
            }
        }

        public a() {
        }

        public void c(k1 k1Var) {
            d.this.f16753d.f(p.TRANSIENT_FAILURE, new C0221a(k1Var));
        }

        public void d(o0.g gVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        public void e() {
        }
    }

    public class b extends b {

        /* renamed from: a  reason: collision with root package name */
        public o0 f16764a;

        public b() {
        }

        public void f(p pVar, o0.i iVar) {
            boolean z10;
            if (this.f16764a == d.this.f16757h) {
                Preconditions.checkState(d.this.f16760k, "there's pending lb while current lb has been out of READY");
                p unused = d.this.f16758i = pVar;
                o0.i unused2 = d.this.f16759j = iVar;
                if (pVar == p.READY) {
                    d.this.p();
                }
            } else if (this.f16764a == d.this.f16755f) {
                d dVar = d.this;
                if (pVar == p.READY) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean unused3 = dVar.f16760k = z10;
                if (d.this.f16760k || d.this.f16757h == d.this.f16752c) {
                    d.this.f16753d.f(pVar, iVar);
                } else {
                    d.this.p();
                }
            }
        }

        public o0.d g() {
            return d.this.f16753d;
        }
    }

    public class c extends o0.i {
        public o0.e a(o0.f fVar) {
            return o0.e.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public d(o0.d dVar) {
        a aVar = new a();
        this.f16752c = aVar;
        this.f16755f = aVar;
        this.f16757h = aVar;
        this.f16753d = (o0.d) Preconditions.checkNotNull(dVar, "helper");
    }

    public void e() {
        this.f16757h.e();
        this.f16755f.e();
    }

    public o0 f() {
        o0 o0Var = this.f16757h;
        if (o0Var == this.f16752c) {
            return this.f16755f;
        }
        return o0Var;
    }

    public final void p() {
        this.f16753d.f(this.f16758i, this.f16759j);
        this.f16755f.e();
        this.f16755f = this.f16757h;
        this.f16754e = this.f16756g;
        this.f16757h = this.f16752c;
        this.f16756g = null;
    }

    public void q(o0.c cVar) {
        Preconditions.checkNotNull(cVar, "newBalancerFactory");
        if (!cVar.equals(this.f16756g)) {
            this.f16757h.e();
            this.f16757h = this.f16752c;
            this.f16756g = null;
            this.f16758i = p.CONNECTING;
            this.f16759j = f16751l;
            if (!cVar.equals(this.f16754e)) {
                b bVar = new b();
                o0 a10 = cVar.a(bVar);
                bVar.f16764a = a10;
                this.f16757h = a10;
                this.f16756g = cVar;
                if (!this.f16760k) {
                    p();
                }
            }
        }
    }
}
