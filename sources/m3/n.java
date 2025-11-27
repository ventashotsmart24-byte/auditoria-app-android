package m3;

import b3.b0;
import b3.f;
import b3.k;
import b3.p;
import b3.r;
import b3.s;
import d4.v;
import k3.b;
import k3.j;
import k3.q;
import k3.x;
import r3.c;
import r3.e0;
import r3.h0;
import w3.d;

public abstract class n extends m {

    /* renamed from: l  reason: collision with root package name */
    public static final g f7888l = g.a();

    /* renamed from: m  reason: collision with root package name */
    public static final int f7889m = m.c(q.class);

    /* renamed from: n  reason: collision with root package name */
    public static final int f7890n = ((((q.AUTO_DETECT_FIELDS.b() | q.AUTO_DETECT_GETTERS.b()) | q.AUTO_DETECT_IS_GETTERS.b()) | q.AUTO_DETECT_SETTERS.b()) | q.AUTO_DETECT_CREATORS.b());

    /* renamed from: e  reason: collision with root package name */
    public final e0 f7891e;

    /* renamed from: f  reason: collision with root package name */
    public final d f7892f;

    /* renamed from: g  reason: collision with root package name */
    public final x f7893g;

    /* renamed from: h  reason: collision with root package name */
    public final Class f7894h;

    /* renamed from: i  reason: collision with root package name */
    public final j f7895i;

    /* renamed from: j  reason: collision with root package name */
    public final v f7896j;

    /* renamed from: k  reason: collision with root package name */
    public final h f7897k;

    public n(a aVar, d dVar, e0 e0Var, v vVar, h hVar) {
        super(aVar, f7889m);
        this.f7891e = e0Var;
        this.f7892f = dVar;
        this.f7896j = vVar;
        this.f7893g = null;
        this.f7894h = null;
        this.f7895i = j.b();
        this.f7897k = hVar;
    }

    public abstract n H(int i10);

    public x I(Class cls) {
        x xVar = this.f7893g;
        if (xVar != null) {
            return xVar;
        }
        return this.f7896j.a(cls, this);
    }

    public x J(j jVar) {
        x xVar = this.f7893g;
        if (xVar != null) {
            return xVar;
        }
        return this.f7896j.b(jVar, this);
    }

    public final Class K() {
        return this.f7894h;
    }

    public final j L() {
        return this.f7895i;
    }

    public Boolean M(Class cls) {
        Boolean g10;
        g b10 = this.f7897k.b(cls);
        if (b10 == null || (g10 = b10.g()) == null) {
            return this.f7897k.d();
        }
        return g10;
    }

    public final p.a N(Class cls) {
        p.a c10;
        g b10 = this.f7897k.b(cls);
        if (b10 == null || (c10 = b10.c()) == null) {
            return null;
        }
        return c10;
    }

    public final p.a O(Class cls, c cVar) {
        p.a aVar;
        b g10 = g();
        if (g10 == null) {
            aVar = null;
        } else {
            aVar = g10.K(this, cVar);
        }
        return p.a.k(aVar, N(cls));
    }

    public final r.b P() {
        return this.f7897k.c();
    }

    public final s.a Q(Class cls, c cVar) {
        b g10 = g();
        if (g10 == null) {
            return null;
        }
        return g10.N(this, cVar);
    }

    public final h0 R() {
        h0 f10 = this.f7897k.f();
        int i10 = this.f7886a;
        int i11 = f7890n;
        if ((i10 & i11) == i11) {
            return f10;
        }
        if (!D(q.AUTO_DETECT_FIELDS)) {
            f10 = f10.c(f.c.NONE);
        }
        if (!D(q.AUTO_DETECT_GETTERS)) {
            f10 = f10.b(f.c.NONE);
        }
        if (!D(q.AUTO_DETECT_IS_GETTERS)) {
            f10 = f10.k(f.c.NONE);
        }
        if (!D(q.AUTO_DETECT_SETTERS)) {
            f10 = f10.h(f.c.NONE);
        }
        if (!D(q.AUTO_DETECT_CREATORS)) {
            return f10.l(f.c.NONE);
        }
        return f10;
    }

    public final x S() {
        return this.f7893g;
    }

    public final d T() {
        return this.f7892f;
    }

    public final n U(q... qVarArr) {
        int i10 = this.f7886a;
        for (q b10 : qVarArr) {
            i10 |= b10.b();
        }
        if (i10 == this.f7886a) {
            return this;
        }
        return H(i10);
    }

    public final n V(q... qVarArr) {
        int i10 = this.f7886a;
        for (q b10 : qVarArr) {
            i10 &= b10.b() ^ -1;
        }
        if (i10 == this.f7886a) {
            return this;
        }
        return H(i10);
    }

    public final Class a(Class cls) {
        return this.f7891e.a(cls);
    }

    public final g j(Class cls) {
        g b10 = this.f7897k.b(cls);
        if (b10 == null) {
            return f7888l;
        }
        return b10;
    }

    public final r.b l(Class cls, Class cls2) {
        r.b e10 = j(cls2).e();
        r.b p10 = p(cls);
        if (p10 == null) {
            return e10;
        }
        return p10.m(e10);
    }

    public Boolean n() {
        return this.f7897k.d();
    }

    public final k.d o(Class cls) {
        return this.f7897k.a(cls);
    }

    public final r.b p(Class cls) {
        r.b d10 = j(cls).d();
        r.b P = P();
        if (P == null) {
            return d10;
        }
        return P.m(d10);
    }

    public final b0.a r() {
        return this.f7897k.e();
    }

    public final h0 t(Class cls, c cVar) {
        h0 R = R();
        b g10 = g();
        if (g10 != null) {
            R = g10.e(cVar, R);
        }
        g b10 = this.f7897k.b(cls);
        if (b10 == null) {
            return R;
        }
        b10.i();
        return R.i((f.b) null);
    }

    public n(n nVar, int i10) {
        super((m) nVar, i10);
        this.f7891e = nVar.f7891e;
        this.f7892f = nVar.f7892f;
        this.f7896j = nVar.f7896j;
        this.f7893g = nVar.f7893g;
        this.f7894h = nVar.f7894h;
        this.f7895i = nVar.f7895i;
        this.f7897k = nVar.f7897k;
    }
}
