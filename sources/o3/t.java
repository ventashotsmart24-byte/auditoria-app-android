package o3;

import k3.f;
import k3.g;
import k3.k;
import k3.l;
import k3.x;
import n3.q;
import n3.u;
import o3.z;
import r3.b0;
import r3.i;

public class t extends n3.t {

    /* renamed from: o  reason: collision with root package name */
    public final n3.t f8539o;

    public static final class a extends z.a {

        /* renamed from: c  reason: collision with root package name */
        public final t f8540c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f8541d;

        public a(t tVar, u uVar, Class cls, Object obj) {
            super(uVar, cls);
            this.f8540c = tVar;
            this.f8541d = obj;
        }
    }

    public t(n3.t tVar, b0 b0Var) {
        super(tVar);
        this.f8539o = tVar;
        this.f8300k = b0Var;
    }

    public void C(Object obj, Object obj2) {
        this.f8539o.C(obj, obj2);
    }

    public Object D(Object obj, Object obj2) {
        return this.f8539o.D(obj, obj2);
    }

    public n3.t I(x xVar) {
        return new t(this, xVar);
    }

    public n3.t J(q qVar) {
        return new t(this, this.f8296g, qVar);
    }

    public n3.t L(k kVar) {
        k kVar2 = this.f8296g;
        if (kVar2 == kVar) {
            return this;
        }
        q qVar = this.f8298i;
        if (kVar2 == qVar) {
            qVar = kVar;
        }
        return new t(this, kVar, qVar);
    }

    public i d() {
        return this.f8539o.d();
    }

    public void l(c3.k kVar, g gVar, Object obj) {
        m(kVar, gVar, obj);
    }

    public Object m(c3.k kVar, g gVar, Object obj) {
        boolean z10;
        try {
            return D(obj, k(kVar, gVar));
        } catch (u e10) {
            if (this.f8300k == null && this.f8296g.getObjectIdReader() == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                e10.t().a(new a(this, e10, this.f8293d.q(), obj));
                return null;
            }
            throw l.i(kVar, "Unresolved forward reference but no identity info", e10);
        }
    }

    public void o(f fVar) {
        n3.t tVar = this.f8539o;
        if (tVar != null) {
            tVar.o(fVar);
        }
    }

    public int p() {
        return this.f8539o.p();
    }

    public t(t tVar, k kVar, q qVar) {
        super(tVar, kVar, qVar);
        this.f8539o = tVar.f8539o;
        this.f8300k = tVar.f8300k;
    }

    public t(t tVar, x xVar) {
        super(tVar, xVar);
        this.f8539o = tVar.f8539o;
        this.f8300k = tVar.f8300k;
    }
}
