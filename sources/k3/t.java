package k3;

import a4.j;
import a4.q;
import a4.r;
import c3.c;
import c3.f;
import c3.k;
import c3.o;
import c3.v;
import com.umeng.analytics.pro.bt;
import java.io.Closeable;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import k3.s;
import m3.h;
import n3.l;
import n3.n;
import r3.e0;
import r3.t;
import r3.w;
import r3.x;
import w3.b;
import w3.d;
import w3.g;

public class t extends o implements Serializable {

    /* renamed from: n  reason: collision with root package name */
    public static final b f7446n;

    /* renamed from: o  reason: collision with root package name */
    public static final m3.a f7447o;

    /* renamed from: a  reason: collision with root package name */
    public final f f7448a;

    /* renamed from: b  reason: collision with root package name */
    public c4.o f7449b;

    /* renamed from: c  reason: collision with root package name */
    public d f7450c;

    /* renamed from: d  reason: collision with root package name */
    public final h f7451d;

    /* renamed from: e  reason: collision with root package name */
    public final m3.d f7452e;

    /* renamed from: f  reason: collision with root package name */
    public e0 f7453f;

    /* renamed from: g  reason: collision with root package name */
    public a0 f7454g;

    /* renamed from: h  reason: collision with root package name */
    public j f7455h;

    /* renamed from: i  reason: collision with root package name */
    public q f7456i;

    /* renamed from: j  reason: collision with root package name */
    public f f7457j;

    /* renamed from: k  reason: collision with root package name */
    public l f7458k;

    /* renamed from: l  reason: collision with root package name */
    public Set f7459l;

    /* renamed from: m  reason: collision with root package name */
    public final ConcurrentHashMap f7460m;

    public class a implements s.a {
        public a() {
        }

        public void a(b... bVarArr) {
            t.this.C(bVarArr);
        }

        public void b(n3.o oVar) {
            n n10 = t.this.f7458k.f7371b.n(oVar);
            t tVar = t.this;
            tVar.f7458k = tVar.f7458k.V0(n10);
        }

        public void c(Class cls, Class cls2) {
            t.this.n(cls, cls2);
        }

        public void d(r rVar) {
            t tVar = t.this;
            tVar.f7456i = tVar.f7456i.e(rVar);
        }

        public void e(r rVar) {
            t tVar = t.this;
            tVar.f7456i = tVar.f7456i.d(rVar);
        }
    }

    static {
        x xVar = new x();
        f7446n = xVar;
        f7447o = new m3.a((r3.t) null, xVar, (y) null, c4.o.I(), (g) null, d4.x.f6321m, (m3.l) null, Locale.getDefault(), (TimeZone) null, c3.b.a(), x3.l.f9691a, new w.b());
    }

    public t() {
        this((f) null, (j) null, (l) null);
    }

    public u A(Class cls) {
        return g(u(), this.f7449b.H(cls), (Object) null, (c) null, (i) null);
    }

    public t B(s sVar) {
        Object c10;
        d(bt.f13911e, sVar);
        if (sVar.b() == null) {
            throw new IllegalArgumentException("Module without defined name");
        } else if (sVar.e() != null) {
            for (s B : sVar.a()) {
                B(B);
            }
            if (y(q.IGNORE_DUPLICATE_MODULE_REGISTRATIONS) && (c10 = sVar.c()) != null) {
                if (this.f7459l == null) {
                    this.f7459l = new LinkedHashSet();
                }
                if (!this.f7459l.add(c10)) {
                    return this;
                }
            }
            sVar.d(new a());
            return this;
        } else {
            throw new IllegalArgumentException("Module without defined version");
        }
    }

    public void C(b... bVarArr) {
        x().e(bVarArr);
    }

    public v D() {
        return h(w());
    }

    public v a(k kVar) {
        d(bt.aD, kVar);
        f u10 = u();
        if (kVar.n() == null && kVar.s0() == null) {
            return null;
        }
        m mVar = (m) j(u10, kVar, r(m.class));
        if (mVar == null) {
            return v().d();
        }
        return mVar;
    }

    public Object b(k kVar, Class cls) {
        d(bt.aD, kVar);
        return j(u(), kVar, this.f7449b.H(cls));
    }

    public void c(c3.h hVar, Object obj) {
        d("g", hVar);
        a0 w10 = w();
        if (w10.c0(b0.INDENT_OUTPUT) && hVar.u() == null) {
            hVar.I(w10.X());
        }
        if (!w10.c0(b0.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            k(w10).C0(hVar, obj);
            if (w10.c0(b0.FLUSH_AFTER_WRITE_VALUE)) {
                hVar.flush();
                return;
            }
            return;
        }
        m(hVar, obj, w10);
    }

    public final void d(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", new Object[]{str}));
        }
    }

    public k e(g gVar, j jVar) {
        k kVar = (k) this.f7460m.get(jVar);
        if (kVar != null) {
            return kVar;
        }
        k I = gVar.I(jVar);
        if (I == null) {
            return (k) gVar.q(jVar, "Cannot find a deserializer for type " + jVar);
        }
        this.f7460m.put(jVar, I);
        return I;
    }

    public c3.n f(k kVar, j jVar) {
        this.f7457j.e0(kVar);
        c3.n n10 = kVar.n();
        if (n10 != null || (n10 = kVar.s0()) != null) {
            return n10;
        }
        throw p3.f.t(kVar, jVar, "No content to map due to end-of-input");
    }

    public u g(f fVar, j jVar, Object obj, c cVar, i iVar) {
        return new u(this, fVar, jVar, obj, cVar, iVar);
    }

    public v h(a0 a0Var) {
        return new v(this, a0Var);
    }

    public Object i(k kVar, j jVar) {
        Object obj;
        try {
            f u10 = u();
            l s10 = s(kVar, u10);
            c3.n f10 = f(kVar, jVar);
            if (f10 == c3.n.VALUE_NULL) {
                obj = e(s10, jVar).getNullValue(s10);
            } else {
                if (f10 != c3.n.END_ARRAY) {
                    if (f10 != c3.n.END_OBJECT) {
                        obj = s10.T0(kVar, jVar, e(s10, jVar), (Object) null);
                        s10.P0();
                    }
                }
                obj = null;
            }
            if (u10.j0(h.FAIL_ON_TRAILING_TOKENS)) {
                l(kVar, s10, jVar);
            }
            if (kVar != null) {
                kVar.close();
            }
            return obj;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public Object j(f fVar, k kVar, j jVar) {
        Object obj;
        c3.n f10 = f(kVar, jVar);
        l s10 = s(kVar, fVar);
        if (f10 == c3.n.VALUE_NULL) {
            obj = e(s10, jVar).getNullValue(s10);
        } else if (f10 == c3.n.END_ARRAY || f10 == c3.n.END_OBJECT) {
            obj = null;
        } else {
            obj = s10.T0(kVar, jVar, e(s10, jVar), (Object) null);
        }
        kVar.f();
        if (fVar.j0(h.FAIL_ON_TRAILING_TOKENS)) {
            l(kVar, s10, jVar);
        }
        return obj;
    }

    public j k(a0 a0Var) {
        return this.f7455h.A0(a0Var, this.f7456i);
    }

    public final void l(k kVar, g gVar, j jVar) {
        c3.n s02 = kVar.s0();
        if (s02 != null) {
            gVar.C0(d4.h.d0(jVar), kVar, s02);
        }
    }

    public final void m(c3.h hVar, Object obj, a0 a0Var) {
        Closeable closeable = (Closeable) obj;
        try {
            k(a0Var).C0(hVar, obj);
            if (a0Var.c0(b0.FLUSH_AFTER_WRITE_VALUE)) {
                hVar.flush();
            }
            closeable.close();
        } catch (Exception e10) {
            d4.h.j((c3.h) null, closeable, e10);
        }
    }

    public t n(Class cls, Class cls2) {
        this.f7453f.b(cls, cls2);
        return this;
    }

    public t o(k.a aVar, boolean z10) {
        this.f7448a.j(aVar, z10);
        return this;
    }

    public t p(h hVar, boolean z10) {
        f fVar;
        if (z10) {
            fVar = this.f7457j.l0(hVar);
        } else {
            fVar = this.f7457j.m0(hVar);
        }
        this.f7457j = fVar;
        return this;
    }

    public t q(q qVar, boolean z10) {
        m3.n nVar;
        m3.n nVar2;
        if (z10) {
            nVar = this.f7454g.U(qVar);
        } else {
            nVar = this.f7454g.V(qVar);
        }
        this.f7454g = (a0) nVar;
        if (z10) {
            nVar2 = this.f7457j.U(qVar);
        } else {
            nVar2 = this.f7457j.V(qVar);
        }
        this.f7457j = (f) nVar2;
        return this;
    }

    public j r(Type type) {
        d("t", type);
        return this.f7449b.H(type);
    }

    public l s(k kVar, f fVar) {
        return this.f7458k.R0(fVar, kVar, (i) null);
    }

    public r3.t t() {
        return new r3.r();
    }

    public f u() {
        return this.f7457j;
    }

    public z3.l v() {
        return this.f7457j.c0();
    }

    public a0 w() {
        return this.f7454g;
    }

    public d x() {
        return this.f7450c;
    }

    public boolean y(q qVar) {
        return this.f7454g.D(qVar);
    }

    public Object z(Reader reader, Class cls) {
        d("src", reader);
        return i(this.f7448a.m(reader), this.f7449b.H(cls));
    }

    public t(f fVar) {
        this(fVar, (j) null, (l) null);
    }

    public t(f fVar, j jVar, l lVar) {
        this.f7460m = new ConcurrentHashMap(64, 0.6f, 2);
        if (fVar == null) {
            this.f7448a = new r(this);
        } else {
            this.f7448a = fVar;
            if (fVar.p() == null) {
                fVar.r(this);
            }
        }
        this.f7450c = new x3.n();
        d4.v vVar = new d4.v();
        this.f7449b = c4.o.I();
        e0 e0Var = new e0((t.a) null);
        this.f7453f = e0Var;
        m3.a m10 = f7447o.m(t());
        h hVar = new h();
        this.f7451d = hVar;
        m3.d dVar = new m3.d();
        this.f7452e = dVar;
        m3.a aVar = m10;
        e0 e0Var2 = e0Var;
        d4.v vVar2 = vVar;
        h hVar2 = hVar;
        this.f7454g = new a0(aVar, this.f7450c, e0Var2, vVar2, hVar2);
        this.f7457j = new f(aVar, this.f7450c, e0Var2, vVar2, hVar2, dVar);
        boolean q10 = this.f7448a.q();
        a0 a0Var = this.f7454g;
        q qVar = q.SORT_PROPERTIES_ALPHABETICALLY;
        if (a0Var.D(qVar) ^ q10) {
            q(qVar, q10);
        }
        this.f7455h = jVar == null ? new j.a() : jVar;
        this.f7458k = lVar == null ? new l.a(n3.f.f8267k) : lVar;
        this.f7456i = a4.f.f211d;
    }
}
