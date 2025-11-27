package r3;

import c4.n;
import d4.b;
import d4.h;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k3.j;
import m3.m;
import r3.t;

public class d {

    /* renamed from: i  reason: collision with root package name */
    public static final b f9062i = o.d();

    /* renamed from: j  reason: collision with root package name */
    public static final Class f9063j = Object.class;

    /* renamed from: k  reason: collision with root package name */
    public static final Class f9064k = Enum.class;

    /* renamed from: l  reason: collision with root package name */
    public static final Class f9065l = List.class;

    /* renamed from: m  reason: collision with root package name */
    public static final Class f9066m = Map.class;

    /* renamed from: a  reason: collision with root package name */
    public final m f9067a;

    /* renamed from: b  reason: collision with root package name */
    public final k3.b f9068b;

    /* renamed from: c  reason: collision with root package name */
    public final t.a f9069c;

    /* renamed from: d  reason: collision with root package name */
    public final n f9070d;

    /* renamed from: e  reason: collision with root package name */
    public final j f9071e;

    /* renamed from: f  reason: collision with root package name */
    public final Class f9072f;

    /* renamed from: g  reason: collision with root package name */
    public final Class f9073g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f9074h;

    public d(m mVar, j jVar, t.a aVar) {
        this.f9067a = mVar;
        this.f9071e = jVar;
        Class q10 = jVar.q();
        this.f9072f = q10;
        this.f9069c = aVar;
        this.f9070d = jVar.j();
        Class cls = null;
        k3.b g10 = mVar.C() ? mVar.g() : null;
        this.f9068b = g10;
        this.f9073g = aVar != null ? aVar.a(q10) : cls;
        this.f9074h = g10 != null && (!h.M(q10) || !jVar.D());
    }

    public static void d(j jVar, List list, boolean z10) {
        Class q10 = jVar.q();
        if (z10) {
            if (!f(list, q10)) {
                list.add(jVar);
                if (q10 == f9065l || q10 == f9066m) {
                    return;
                }
            } else {
                return;
            }
        }
        for (j d10 : jVar.o()) {
            d(d10, list, true);
        }
    }

    public static void e(j jVar, List list, boolean z10) {
        Class q10 = jVar.q();
        if (q10 != f9063j && q10 != f9064k) {
            if (z10) {
                if (!f(list, q10)) {
                    list.add(jVar);
                } else {
                    return;
                }
            }
            for (j d10 : jVar.o()) {
                d(d10, list, true);
            }
            j s10 = jVar.s();
            if (s10 != null) {
                e(s10, list, true);
            }
        }
    }

    public static boolean f(List list, Class cls) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((j) list.get(i10)).q() == cls) {
                return true;
            }
        }
        return false;
    }

    public static c g(m mVar, Class cls) {
        return new c(cls);
    }

    public static c h(Class cls) {
        return new c(cls);
    }

    public static c i(m mVar, j jVar, t.a aVar) {
        if (!jVar.A() || !o(mVar, jVar.q())) {
            return new d(mVar, jVar, aVar).k();
        }
        return g(mVar, jVar.q());
    }

    public static c m(m mVar, Class cls) {
        return n(mVar, cls, mVar);
    }

    public static c n(m mVar, Class cls, t.a aVar) {
        if (!cls.isArray() || !o(mVar, cls)) {
            return new d(mVar, cls, aVar).l();
        }
        return g(mVar, cls);
    }

    public static boolean o(m mVar, Class cls) {
        if (mVar == null || mVar.a(cls) == null) {
            return true;
        }
        return false;
    }

    public final o a(o oVar, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!oVar.f(annotation)) {
                    oVar = oVar.a(annotation);
                    if (this.f9068b.q0(annotation)) {
                        oVar = c(oVar, annotation);
                    }
                }
            }
        }
        return oVar;
    }

    public final o b(o oVar, Class cls, Class cls2) {
        if (cls2 != null) {
            oVar = a(oVar, h.p(cls2));
            for (Class p10 : h.x(cls2, cls, false)) {
                oVar = a(oVar, h.p(p10));
            }
        }
        return oVar;
    }

    public final o c(o oVar, Annotation annotation) {
        for (Annotation annotation2 : h.p(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !oVar.f(annotation2)) {
                oVar = oVar.a(annotation2);
                if (this.f9068b.q0(annotation2)) {
                    oVar = c(oVar, annotation2);
                }
            }
        }
        return oVar;
    }

    public final b j(List list) {
        boolean z10;
        if (this.f9068b == null) {
            return f9062i;
        }
        t.a aVar = this.f9069c;
        if (aVar == null || ((aVar instanceof e0) && !((e0) aVar).c())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10 && !this.f9074h) {
            return f9062i;
        }
        o e10 = o.e();
        Class cls = this.f9073g;
        if (cls != null) {
            e10 = b(e10, this.f9072f, cls);
        }
        if (this.f9074h) {
            e10 = a(e10, h.p(this.f9072f));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (z10) {
                Class q10 = jVar.q();
                e10 = b(e10, q10, this.f9069c.a(q10));
            }
            if (this.f9074h) {
                e10 = a(e10, h.p(jVar.q()));
            }
        }
        if (z10) {
            Class<Object> cls2 = Object.class;
            e10 = b(e10, cls2, this.f9069c.a(cls2));
        }
        return e10.c();
    }

    public c k() {
        ArrayList arrayList = new ArrayList(8);
        if (!this.f9071e.y(Object.class)) {
            if (this.f9071e.H()) {
                d(this.f9071e, arrayList, false);
            } else {
                e(this.f9071e, arrayList, false);
            }
        }
        return new c(this.f9071e, this.f9072f, arrayList, this.f9073g, j(arrayList), this.f9070d, this.f9068b, this.f9069c, this.f9067a.z(), this.f9074h);
    }

    public c l() {
        List emptyList = Collections.emptyList();
        return new c((j) null, this.f9072f, emptyList, this.f9073g, j(emptyList), this.f9070d, this.f9068b, this.f9069c, this.f9067a.z(), this.f9074h);
    }

    public d(m mVar, Class cls, t.a aVar) {
        this.f9067a = mVar;
        Class cls2 = null;
        this.f9071e = null;
        this.f9072f = cls;
        this.f9069c = aVar;
        this.f9070d = n.i();
        if (mVar == null) {
            this.f9068b = null;
            this.f9073g = null;
        } else {
            this.f9068b = mVar.C() ? mVar.g() : null;
            this.f9073g = aVar != null ? aVar.a(cls) : cls2;
        }
        this.f9074h = this.f9068b != null;
    }
}
