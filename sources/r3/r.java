package r3;

import c4.l;
import d4.h;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import k3.a0;
import k3.c;
import k3.f;
import k3.j;
import k3.m;
import r3.t;

public class r extends t implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f9160a;

    /* renamed from: b  reason: collision with root package name */
    public static final Class f9161b;

    /* renamed from: c  reason: collision with root package name */
    public static final Class f9162c = m.class;

    /* renamed from: d  reason: collision with root package name */
    public static final q f9163d;

    /* renamed from: e  reason: collision with root package name */
    public static final q f9164e;

    /* renamed from: f  reason: collision with root package name */
    public static final q f9165f;

    /* renamed from: g  reason: collision with root package name */
    public static final q f9166g;

    /* renamed from: h  reason: collision with root package name */
    public static final q f9167h;

    static {
        Class<Object> cls = Object.class;
        f9160a = cls;
        Class<String> cls2 = String.class;
        f9161b = cls2;
        f9163d = q.I((m3.m) null, l.b0(cls2), d.h(cls2));
        Class cls3 = Boolean.TYPE;
        f9164e = q.I((m3.m) null, l.b0(cls3), d.h(cls3));
        Class cls4 = Integer.TYPE;
        f9165f = q.I((m3.m) null, l.b0(cls4), d.h(cls4));
        Class cls5 = Long.TYPE;
        f9166g = q.I((m3.m) null, l.b0(cls5), d.h(cls5));
        f9167h = q.I((m3.m) null, l.b0(cls), d.h(cls));
    }

    public q f(m3.m mVar, j jVar) {
        if (h(jVar)) {
            return q.I(mVar, jVar, i(mVar, jVar, mVar));
        }
        return null;
    }

    public q g(m3.m mVar, j jVar) {
        Class<Boolean> q10 = jVar.q();
        if (q10.isPrimitive()) {
            if (q10 == Integer.TYPE) {
                return f9165f;
            }
            if (q10 == Long.TYPE) {
                return f9166g;
            }
            if (q10 == Boolean.TYPE) {
                return f9164e;
            }
            return null;
        } else if (h.M(q10)) {
            if (q10 == f9160a) {
                return f9167h;
            }
            if (q10 == f9161b) {
                return f9163d;
            }
            if (q10 == Integer.class) {
                return f9165f;
            }
            if (q10 == Long.class) {
                return f9166g;
            }
            if (q10 == Boolean.class) {
                return f9164e;
            }
            return null;
        } else if (f9162c.isAssignableFrom(q10)) {
            return q.I(mVar, jVar, d.h(q10));
        } else {
            return null;
        }
    }

    public boolean h(j jVar) {
        if (jVar.D() && !jVar.A()) {
            Class q10 = jVar.q();
            if (!h.M(q10) || (!Collection.class.isAssignableFrom(q10) && !Map.class.isAssignableFrom(q10))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public c i(m3.m mVar, j jVar, t.a aVar) {
        return d.i(mVar, jVar, aVar);
    }

    public c0 j(m3.m mVar, j jVar, t.a aVar, boolean z10) {
        a aVar2;
        c i10 = i(mVar, jVar, aVar);
        if (jVar.L()) {
            aVar2 = mVar.f().c(mVar, i10);
        } else {
            aVar2 = mVar.f().b(mVar, i10);
        }
        return l(mVar, i10, jVar, z10, aVar2);
    }

    public c0 k(m3.m mVar, j jVar, t.a aVar, c cVar, boolean z10) {
        c i10 = i(mVar, jVar, aVar);
        return l(mVar, i10, jVar, z10, mVar.f().a(mVar, i10, cVar));
    }

    public c0 l(m3.m mVar, c cVar, j jVar, boolean z10, a aVar) {
        return new c0(mVar, z10, jVar, cVar, aVar);
    }

    /* renamed from: m */
    public q a(m3.m mVar, j jVar, t.a aVar) {
        q g10 = g(mVar, jVar);
        if (g10 == null) {
            return q.I(mVar, jVar, i(mVar, jVar, aVar));
        }
        return g10;
    }

    /* renamed from: n */
    public q b(f fVar, j jVar, t.a aVar) {
        q g10 = g(fVar, jVar);
        if (g10 != null) {
            return g10;
        }
        q f10 = f(fVar, jVar);
        if (f10 == null) {
            return q.H(j(fVar, jVar, aVar, false));
        }
        return f10;
    }

    /* renamed from: o */
    public q c(f fVar, j jVar, t.a aVar) {
        q g10 = g(fVar, jVar);
        if (g10 != null) {
            return g10;
        }
        q f10 = f(fVar, jVar);
        if (f10 == null) {
            return q.H(j(fVar, jVar, aVar, false));
        }
        return f10;
    }

    /* renamed from: p */
    public q d(f fVar, j jVar, t.a aVar, c cVar) {
        return q.H(k(fVar, jVar, aVar, cVar, false));
    }

    /* renamed from: q */
    public q e(a0 a0Var, j jVar, t.a aVar) {
        q g10 = g(a0Var, jVar);
        if (g10 != null) {
            return g10;
        }
        q f10 = f(a0Var, jVar);
        if (f10 == null) {
            return q.J(j(a0Var, jVar, aVar, true));
        }
        return f10;
    }
}
