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

public final class a0 extends t {

    /* renamed from: o  reason: collision with root package name */
    public final j f8452o;

    /* renamed from: p  reason: collision with root package name */
    public final Method f8453p;

    public a0(s sVar, k3.j jVar, e eVar, b bVar, j jVar2) {
        super(sVar, jVar, eVar, bVar);
        this.f8452o = jVar2;
        this.f8453p = jVar2.b();
    }

    public final void C(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should never call `set()` on setterless property ('" + getName() + "')");
    }

    public Object D(Object obj, Object obj2) {
        C(obj, obj2);
        return obj;
    }

    public t I(x xVar) {
        return new a0(this, xVar);
    }

    public t J(q qVar) {
        return new a0(this, this.f8296g, qVar);
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
        return new a0(this, kVar, qVar);
    }

    public i d() {
        return this.f8452o;
    }

    public final void l(c3.k kVar, g gVar, Object obj) {
        if (!kVar.j0(n.VALUE_NULL)) {
            if (this.f8297h != null) {
                gVar.q(getType(), String.format("Problem deserializing 'setterless' property (\"%s\"): no way to handle typed deser with setterless yet", new Object[]{getName()}));
            }
            try {
                Object invoke = this.f8453p.invoke(obj, (Object[]) null);
                if (invoke == null) {
                    gVar.q(getType(), String.format("Problem deserializing 'setterless' property '%s': get method returned null", new Object[]{getName()}));
                }
                this.f8296g.deserialize(kVar, gVar, invoke);
            } catch (Exception e10) {
                g(kVar, e10);
            }
        }
    }

    public Object m(c3.k kVar, g gVar, Object obj) {
        l(kVar, gVar, obj);
        return obj;
    }

    public void o(f fVar) {
        this.f8452o.i(fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public a0(a0 a0Var, k kVar, q qVar) {
        super(a0Var, kVar, qVar);
        this.f8452o = a0Var.f8452o;
        this.f8453p = a0Var.f8453p;
    }

    public a0(a0 a0Var, x xVar) {
        super(a0Var, xVar);
        this.f8452o = a0Var.f8452o;
        this.f8453p = a0Var.f8453p;
    }
}
