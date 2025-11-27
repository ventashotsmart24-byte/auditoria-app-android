package r3;

import b3.k;
import b3.r;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import k3.b;
import k3.d;
import k3.w;
import m3.m;

public abstract class v implements d, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final w f9172a;

    /* renamed from: b  reason: collision with root package name */
    public transient List f9173b;

    public v(w wVar) {
        this.f9172a = wVar == null ? w.f7487j : wVar;
    }

    public k.d a(m mVar, Class cls) {
        k.d dVar;
        i d10;
        k.d o10 = mVar.o(cls);
        b g10 = mVar.g();
        if (g10 == null || (d10 = d()) == null) {
            dVar = null;
        } else {
            dVar = g10.q(d10);
        }
        if (o10 == null) {
            if (dVar == null) {
                return d.f7353c0;
            }
            return dVar;
        } else if (dVar == null) {
            return o10;
        } else {
            return o10.r(dVar);
        }
    }

    public r.b b(m mVar, Class cls) {
        b g10 = mVar.g();
        i d10 = d();
        if (d10 == null) {
            return mVar.p(cls);
        }
        r.b l10 = mVar.l(cls, d10.e());
        if (g10 == null) {
            return l10;
        }
        r.b M = g10.M(d10);
        if (l10 == null) {
            return M;
        }
        return l10.m(M);
    }

    public List e(m mVar) {
        i d10;
        List list = this.f9173b;
        if (list == null) {
            b g10 = mVar.g();
            if (!(g10 == null || (d10 = d()) == null)) {
                list = g10.G(d10);
            }
            if (list == null) {
                list = Collections.emptyList();
            }
            this.f9173b = list;
        }
        return list;
    }

    public boolean f() {
        return this.f9172a.g();
    }

    public w getMetadata() {
        return this.f9172a;
    }

    public v(v vVar) {
        this.f9172a = vVar.f9172a;
    }
}
