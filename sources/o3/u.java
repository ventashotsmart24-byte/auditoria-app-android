package o3;

import b3.k0;
import b3.o0;
import c3.n;
import k3.g;
import k3.k;
import k3.w;
import k3.x;
import n3.q;
import n3.t;
import r3.i;

public final class u extends t {

    /* renamed from: o  reason: collision with root package name */
    public final s f8542o;

    public u(s sVar, w wVar) {
        super(sVar.f8535b, sVar.c(), wVar, sVar.b());
        this.f8542o = sVar;
    }

    public void C(Object obj, Object obj2) {
        D(obj, obj2);
    }

    public Object D(Object obj, Object obj2) {
        t tVar = this.f8542o.f8538e;
        if (tVar != null) {
            return tVar.D(obj, obj2);
        }
        throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
    }

    public t I(x xVar) {
        return new u(this, xVar);
    }

    public t J(q qVar) {
        return new u(this, this.f8296g, qVar);
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
        return new u(this, kVar, qVar);
    }

    public i d() {
        return null;
    }

    public void l(c3.k kVar, g gVar, Object obj) {
        m(kVar, gVar, obj);
    }

    public Object m(c3.k kVar, g gVar, Object obj) {
        if (kVar.j0(n.VALUE_NULL)) {
            return null;
        }
        Object deserialize = this.f8296g.deserialize(kVar, gVar);
        s sVar = this.f8542o;
        k0 k0Var = sVar.f8536c;
        sVar.getClass();
        gVar.H(deserialize, k0Var, (o0) null).b(obj);
        t tVar = this.f8542o.f8538e;
        if (tVar != null) {
            return tVar.D(obj, deserialize);
        }
        return obj;
    }

    public u(u uVar, k kVar, q qVar) {
        super(uVar, kVar, qVar);
        this.f8542o = uVar.f8542o;
    }

    public u(u uVar, x xVar) {
        super(uVar, xVar);
        this.f8542o = uVar.f8542o;
    }
}
