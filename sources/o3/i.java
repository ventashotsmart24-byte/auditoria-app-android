package o3;

import c3.n;
import d4.b;
import d4.h;
import java.lang.reflect.Field;
import k3.f;
import k3.j;
import k3.k;
import k3.x;
import n3.q;
import n3.t;
import r3.g;
import r3.s;
import w3.e;

public final class i extends t {

    /* renamed from: o  reason: collision with root package name */
    public final g f8502o;

    /* renamed from: p  reason: collision with root package name */
    public final transient Field f8503p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f8504q;

    public i(s sVar, j jVar, e eVar, b bVar, g gVar) {
        super(sVar, jVar, eVar, bVar);
        this.f8502o = gVar;
        this.f8503p = gVar.b();
        this.f8504q = q.b(this.f8298i);
    }

    public void C(Object obj, Object obj2) {
        try {
            this.f8503p.set(obj, obj2);
        } catch (Exception e10) {
            i(e10, obj2);
        }
    }

    public Object D(Object obj, Object obj2) {
        try {
            this.f8503p.set(obj, obj2);
        } catch (Exception e10) {
            i(e10, obj2);
        }
        return obj;
    }

    public t I(x xVar) {
        return new i(this, xVar);
    }

    public t J(q qVar) {
        return new i(this, this.f8296g, qVar);
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
        return new i(this, kVar, qVar);
    }

    public r3.i d() {
        return this.f8502o;
    }

    public void l(c3.k kVar, k3.g gVar, Object obj) {
        Object obj2;
        if (!kVar.j0(n.VALUE_NULL)) {
            e eVar = this.f8297h;
            if (eVar == null) {
                Object deserialize = this.f8296g.deserialize(kVar, gVar);
                if (deserialize != null) {
                    obj2 = deserialize;
                } else if (!this.f8504q) {
                    obj2 = this.f8298i.getNullValue(gVar);
                } else {
                    return;
                }
            } else {
                obj2 = this.f8296g.deserializeWithType(kVar, gVar, eVar);
            }
        } else if (!this.f8504q) {
            obj2 = this.f8298i.getNullValue(gVar);
        } else {
            return;
        }
        try {
            this.f8503p.set(obj, obj2);
        } catch (Exception e10) {
            h(kVar, e10, obj2);
        }
    }

    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        Object obj2;
        if (!kVar.j0(n.VALUE_NULL)) {
            e eVar = this.f8297h;
            if (eVar == null) {
                Object deserialize = this.f8296g.deserialize(kVar, gVar);
                if (deserialize != null) {
                    obj2 = deserialize;
                } else if (this.f8504q) {
                    return obj;
                } else {
                    obj2 = this.f8298i.getNullValue(gVar);
                }
            } else {
                obj2 = this.f8296g.deserializeWithType(kVar, gVar, eVar);
            }
        } else if (this.f8504q) {
            return obj;
        } else {
            obj2 = this.f8298i.getNullValue(gVar);
        }
        try {
            this.f8503p.set(obj, obj2);
        } catch (Exception e10) {
            h(kVar, e10, obj2);
        }
        return obj;
    }

    public void o(f fVar) {
        h.g(this.f8503p, fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public i(i iVar, k kVar, q qVar) {
        super(iVar, kVar, qVar);
        this.f8502o = iVar.f8502o;
        this.f8503p = iVar.f8503p;
        this.f8504q = q.b(qVar);
    }

    public i(i iVar, x xVar) {
        super(iVar, xVar);
        this.f8502o = iVar.f8502o;
        this.f8503p = iVar.f8503p;
        this.f8504q = iVar.f8504q;
    }
}
