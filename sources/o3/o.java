package o3;

import c3.n;
import d4.b;
import java.lang.reflect.Method;
import k3.f;
import k3.g;
import k3.k;
import k3.x;
import n3.q;
import n3.t;
import r3.i;
import r3.j;
import r3.s;
import w3.e;

public final class o extends t {

    /* renamed from: o  reason: collision with root package name */
    public final j f8524o;

    /* renamed from: p  reason: collision with root package name */
    public final transient Method f8525p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f8526q;

    public o(s sVar, k3.j jVar, e eVar, b bVar, j jVar2) {
        super(sVar, jVar, eVar, bVar);
        this.f8524o = jVar2;
        this.f8525p = jVar2.b();
        this.f8526q = q.b(this.f8298i);
    }

    public final void C(Object obj, Object obj2) {
        try {
            this.f8525p.invoke(obj, new Object[]{obj2});
        } catch (Exception e10) {
            i(e10, obj2);
        }
    }

    public Object D(Object obj, Object obj2) {
        try {
            Object invoke = this.f8525p.invoke(obj, new Object[]{obj2});
            if (invoke == null) {
                return obj;
            }
            return invoke;
        } catch (Exception e10) {
            i(e10, obj2);
            return null;
        }
    }

    public t I(x xVar) {
        return new o(this, xVar);
    }

    public t J(q qVar) {
        return new o(this, this.f8296g, qVar);
    }

    public t L(k kVar) {
        k kVar2 = this.f8296g;
        if (kVar2 == kVar) {
            return this;
        }
        q qVar = this.f8298i;
        if (kVar2 == qVar) {
            qVar = kVar;
        }
        return new o(this, kVar, qVar);
    }

    public i d() {
        return this.f8524o;
    }

    public void l(c3.k kVar, g gVar, Object obj) {
        Object obj2;
        if (!kVar.j0(n.VALUE_NULL)) {
            e eVar = this.f8297h;
            if (eVar == null) {
                Object deserialize = this.f8296g.deserialize(kVar, gVar);
                if (deserialize != null) {
                    obj2 = deserialize;
                } else if (!this.f8526q) {
                    obj2 = this.f8298i.getNullValue(gVar);
                } else {
                    return;
                }
            } else {
                obj2 = this.f8296g.deserializeWithType(kVar, gVar, eVar);
            }
        } else if (!this.f8526q) {
            obj2 = this.f8298i.getNullValue(gVar);
        } else {
            return;
        }
        try {
            this.f8525p.invoke(obj, new Object[]{obj2});
        } catch (Exception e10) {
            h(kVar, e10, obj2);
        }
    }

    public Object m(c3.k kVar, g gVar, Object obj) {
        Object obj2;
        if (!kVar.j0(n.VALUE_NULL)) {
            e eVar = this.f8297h;
            if (eVar == null) {
                Object deserialize = this.f8296g.deserialize(kVar, gVar);
                if (deserialize != null) {
                    obj2 = deserialize;
                } else if (this.f8526q) {
                    return obj;
                } else {
                    obj2 = this.f8298i.getNullValue(gVar);
                }
            } else {
                obj2 = this.f8296g.deserializeWithType(kVar, gVar, eVar);
            }
        } else if (this.f8526q) {
            return obj;
        } else {
            obj2 = this.f8298i.getNullValue(gVar);
        }
        try {
            Object invoke = this.f8525p.invoke(obj, new Object[]{obj2});
            if (invoke == null) {
                return obj;
            }
            return invoke;
        } catch (Exception e10) {
            h(kVar, e10, obj2);
            return null;
        }
    }

    public void o(f fVar) {
        this.f8524o.i(fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public o(o oVar, k kVar, q qVar) {
        super(oVar, kVar, qVar);
        this.f8524o = oVar.f8524o;
        this.f8525p = oVar.f8525p;
        this.f8526q = q.b(qVar);
    }

    public o(o oVar, x xVar) {
        super(oVar, xVar);
        this.f8524o = oVar.f8524o;
        this.f8525p = oVar.f8525p;
        this.f8526q = oVar.f8526q;
    }
}
