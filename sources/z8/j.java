package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Map;
import y8.f;
import y8.k1;
import y8.o0;
import y8.p;
import y8.p0;
import y8.q0;
import y8.y0;
import z8.c2;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final q0 f20698a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20699b;

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public final o0.d f20700a;

        /* renamed from: b  reason: collision with root package name */
        public o0 f20701b;

        /* renamed from: c  reason: collision with root package name */
        public p0 f20702c;

        public b(o0.d dVar) {
            this.f20700a = dVar;
            p0 d10 = j.this.f20698a.d(j.this.f20699b);
            this.f20702c = d10;
            if (d10 != null) {
                this.f20701b = d10.a(dVar);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + j.this.f20699b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public o0 a() {
            return this.f20701b;
        }

        public void b(k1 k1Var) {
            a().c(k1Var);
        }

        public void c() {
            this.f20701b.e();
            this.f20701b = null;
        }

        public boolean d(o0.g gVar) {
            c2.b bVar = (c2.b) gVar.c();
            if (bVar == null) {
                try {
                    j jVar = j.this;
                    bVar = new c2.b(jVar.d(jVar.f20699b, "using default policy"), (Object) null);
                } catch (f e10) {
                    this.f20700a.f(p.TRANSIENT_FAILURE, new d(k1.f20055t.r(e10.getMessage())));
                    this.f20701b.e();
                    this.f20702c = null;
                    this.f20701b = new e();
                    return true;
                }
            }
            if (this.f20702c == null || !bVar.f20450a.b().equals(this.f20702c.b())) {
                this.f20700a.f(p.CONNECTING, new c());
                this.f20701b.e();
                p0 p0Var = bVar.f20450a;
                this.f20702c = p0Var;
                o0 o0Var = this.f20701b;
                this.f20701b = p0Var.a(this.f20700a);
                this.f20700a.b().b(f.a.INFO, "Load balancer changed from {0} to {1}", o0Var.getClass().getSimpleName(), this.f20701b.getClass().getSimpleName());
            }
            Object obj = bVar.f20451b;
            if (obj != null) {
                this.f20700a.b().b(f.a.DEBUG, "Load-balancing config: {0}", bVar.f20451b);
            }
            return a().a(o0.g.d().b(gVar.a()).c(gVar.b()).d(obj).a());
        }
    }

    public static final class c extends o0.i {
        public c() {
        }

        public o0.e a(o0.f fVar) {
            return o0.e.g();
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) c.class).toString();
        }
    }

    public static final class d extends o0.i {

        /* renamed from: a  reason: collision with root package name */
        public final k1 f20704a;

        public d(k1 k1Var) {
            this.f20704a = k1Var;
        }

        public o0.e a(o0.f fVar) {
            return o0.e.f(this.f20704a);
        }
    }

    public static final class e extends o0 {
        public e() {
        }

        public boolean a(o0.g gVar) {
            return true;
        }

        public void c(k1 k1Var) {
        }

        public void d(o0.g gVar) {
        }

        public void e() {
        }
    }

    public static final class f extends Exception {
        public f(String str) {
            super(str);
        }
    }

    public j(String str) {
        this(q0.b(), str);
    }

    public final p0 d(String str, String str2) {
        p0 d10 = this.f20698a.d(str);
        if (d10 != null) {
            return d10;
        }
        throw new f("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    public b e(o0.d dVar) {
        return new b(dVar);
    }

    public y0.b f(Map map) {
        List list;
        if (map != null) {
            try {
                list = c2.A(c2.g(map));
            } catch (RuntimeException e10) {
                return y0.b.b(k1.f20043h.r("can't parse load balancer configuration").q(e10));
            }
        } else {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return c2.y(list, this.f20698a);
    }

    public j(q0 q0Var, String str) {
        this.f20698a = (q0) Preconditions.checkNotNull(q0Var, "registry");
        this.f20699b = (String) Preconditions.checkNotNull(str, "defaultPolicy");
    }
}
