package n3;

import b3.b;
import d4.h;
import k3.f;
import k3.g;
import k3.k;
import k3.w;
import k3.x;
import r3.i;
import r3.m;
import w3.e;

public class j extends t {

    /* renamed from: o  reason: collision with root package name */
    public final m f8271o;

    /* renamed from: p  reason: collision with root package name */
    public final b.a f8272p;

    /* renamed from: q  reason: collision with root package name */
    public t f8273q;

    /* renamed from: r  reason: collision with root package name */
    public final int f8274r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f8275s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(x xVar, k3.j jVar, x xVar2, e eVar, d4.b bVar, m mVar, int i10, b.a aVar, w wVar) {
        super(xVar, jVar, xVar2, eVar, bVar, wVar);
        this.f8271o = mVar;
        this.f8274r = i10;
        this.f8272p = aVar;
        this.f8273q = null;
    }

    public static j O(x xVar, k3.j jVar, x xVar2, e eVar, d4.b bVar, m mVar, int i10, b.a aVar, w wVar) {
        return new j(xVar, jVar, xVar2, eVar, bVar, mVar, i10, aVar, wVar);
    }

    public boolean A() {
        b.a aVar = this.f8272p;
        if (aVar == null || aVar.g(true)) {
            return false;
        }
        return true;
    }

    public void B() {
        this.f8275s = true;
    }

    public void C(Object obj, Object obj2) {
        N();
        this.f8273q.C(obj, obj2);
    }

    public Object D(Object obj, Object obj2) {
        N();
        return this.f8273q.D(obj, obj2);
    }

    public t I(x xVar) {
        return new j(this, xVar);
    }

    public t J(q qVar) {
        return new j(this, this.f8296g, qVar);
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
        return new j(this, kVar, qVar);
    }

    public final void M(c3.k kVar, g gVar) {
        String str = "No fallback setter/field defined for creator property " + h.U(getName());
        if (gVar != null) {
            gVar.q(getType(), str);
            return;
        }
        throw p3.b.v(kVar, str, getType());
    }

    public final void N() {
        if (this.f8273q == null) {
            M((c3.k) null, (g) null);
        }
    }

    public void P(t tVar) {
        this.f8273q = tVar;
    }

    public i d() {
        return this.f8271o;
    }

    public w getMetadata() {
        w metadata = super.getMetadata();
        t tVar = this.f8273q;
        if (tVar != null) {
            return metadata.i(tVar.getMetadata().d());
        }
        return metadata;
    }

    public void l(c3.k kVar, g gVar, Object obj) {
        N();
        this.f8273q.C(obj, k(kVar, gVar));
    }

    public Object m(c3.k kVar, g gVar, Object obj) {
        N();
        return this.f8273q.D(obj, k(kVar, gVar));
    }

    public void o(f fVar) {
        t tVar = this.f8273q;
        if (tVar != null) {
            tVar.o(fVar);
        }
    }

    public int p() {
        return this.f8274r;
    }

    public Object q() {
        b.a aVar = this.f8272p;
        if (aVar == null) {
            return null;
        }
        return aVar.e();
    }

    public String toString() {
        return "[creator property, name " + h.U(getName()) + "; inject id '" + q() + "']";
    }

    public boolean z() {
        return this.f8275s;
    }

    public j(j jVar, x xVar) {
        super(jVar, xVar);
        this.f8271o = jVar.f8271o;
        this.f8272p = jVar.f8272p;
        this.f8273q = jVar.f8273q;
        this.f8274r = jVar.f8274r;
        this.f8275s = jVar.f8275s;
    }

    public j(j jVar, k kVar, q qVar) {
        super(jVar, kVar, qVar);
        this.f8271o = jVar.f8271o;
        this.f8272p = jVar.f8272p;
        this.f8273q = jVar.f8273q;
        this.f8274r = jVar.f8274r;
        this.f8275s = jVar.f8275s;
    }
}
