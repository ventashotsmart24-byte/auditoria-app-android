package n3;

import c3.n;
import d4.b;
import java.io.IOException;
import k3.f;
import k3.g;
import k3.j;
import k3.k;
import k3.l;
import k3.w;
import k3.x;
import o3.h;
import o3.q;
import r3.b0;
import r3.i;
import r3.s;
import r3.v;
import w3.e;

public abstract class t extends v {

    /* renamed from: n  reason: collision with root package name */
    public static final k f8291n = new h("No _valueDeserializer assigned");

    /* renamed from: c  reason: collision with root package name */
    public final x f8292c;

    /* renamed from: d  reason: collision with root package name */
    public final j f8293d;

    /* renamed from: e  reason: collision with root package name */
    public final x f8294e;

    /* renamed from: f  reason: collision with root package name */
    public final transient b f8295f;

    /* renamed from: g  reason: collision with root package name */
    public final k f8296g;

    /* renamed from: h  reason: collision with root package name */
    public final e f8297h;

    /* renamed from: i  reason: collision with root package name */
    public final q f8298i;

    /* renamed from: j  reason: collision with root package name */
    public String f8299j;

    /* renamed from: k  reason: collision with root package name */
    public b0 f8300k;

    /* renamed from: l  reason: collision with root package name */
    public d4.b0 f8301l;

    /* renamed from: m  reason: collision with root package name */
    public int f8302m;

    public static abstract class a extends t {

        /* renamed from: o  reason: collision with root package name */
        public final t f8303o;

        public a(t tVar) {
            super(tVar);
            this.f8303o = tVar;
        }

        public boolean A() {
            return this.f8303o.A();
        }

        public void C(Object obj, Object obj2) {
            this.f8303o.C(obj, obj2);
        }

        public Object D(Object obj, Object obj2) {
            return this.f8303o.D(obj, obj2);
        }

        public boolean H(Class cls) {
            return this.f8303o.H(cls);
        }

        public t I(x xVar) {
            return M(this.f8303o.I(xVar));
        }

        public t J(q qVar) {
            return M(this.f8303o.J(qVar));
        }

        public t L(k kVar) {
            return M(this.f8303o.L(kVar));
        }

        public t M(t tVar) {
            if (tVar == this.f8303o) {
                return this;
            }
            return N(tVar);
        }

        public abstract t N(t tVar);

        public i d() {
            return this.f8303o.d();
        }

        public void j(int i10) {
            this.f8303o.j(i10);
        }

        public void o(f fVar) {
            this.f8303o.o(fVar);
        }

        public int p() {
            return this.f8303o.p();
        }

        public Object q() {
            return this.f8303o.q();
        }

        public String r() {
            return this.f8303o.r();
        }

        public b0 t() {
            return this.f8303o.t();
        }

        public k u() {
            return this.f8303o.u();
        }

        public e v() {
            return this.f8303o.v();
        }

        public boolean w() {
            return this.f8303o.w();
        }

        public boolean x() {
            return this.f8303o.x();
        }

        public boolean y() {
            return this.f8303o.y();
        }
    }

    public t(s sVar, j jVar, e eVar, b bVar) {
        this(sVar.c(), jVar, sVar.w(), eVar, bVar, sVar.getMetadata());
    }

    public boolean A() {
        return false;
    }

    public void B() {
    }

    public abstract void C(Object obj, Object obj2);

    public abstract Object D(Object obj, Object obj2);

    public void E(String str) {
        this.f8299j = str;
    }

    public void F(b0 b0Var) {
        this.f8300k = b0Var;
    }

    public void G(Class[] clsArr) {
        if (clsArr == null) {
            this.f8301l = null;
        } else {
            this.f8301l = d4.b0.a(clsArr);
        }
    }

    public boolean H(Class cls) {
        d4.b0 b0Var = this.f8301l;
        if (b0Var == null || b0Var.b(cls)) {
            return true;
        }
        return false;
    }

    public abstract t I(x xVar);

    public abstract t J(q qVar);

    public t K(String str) {
        x xVar;
        x xVar2 = this.f8292c;
        if (xVar2 == null) {
            xVar = new x(str);
        } else {
            xVar = xVar2.j(str);
        }
        if (xVar == this.f8292c) {
            return this;
        }
        return I(xVar);
    }

    public abstract t L(k kVar);

    public x c() {
        return this.f8292c;
    }

    public abstract i d();

    public IOException g(c3.k kVar, Exception exc) {
        d4.h.i0(exc);
        d4.h.j0(exc);
        Throwable F = d4.h.F(exc);
        throw l.i(kVar, d4.h.o(F), F);
    }

    public final String getName() {
        return this.f8292c.c();
    }

    public j getType() {
        return this.f8293d;
    }

    public void h(c3.k kVar, Exception exc, Object obj) {
        if (exc instanceof IllegalArgumentException) {
            String h10 = d4.h.h(obj);
            StringBuilder sb = new StringBuilder("Problem deserializing property '");
            sb.append(getName());
            sb.append("' (expected type: ");
            sb.append(getType());
            sb.append("; actual type: ");
            sb.append(h10);
            sb.append(")");
            String o10 = d4.h.o(exc);
            if (o10 != null) {
                sb.append(", problem: ");
                sb.append(o10);
            } else {
                sb.append(" (no error message provided)");
            }
            throw l.i(kVar, sb.toString(), exc);
        }
        g(kVar, exc);
    }

    public void i(Exception exc, Object obj) {
        h((c3.k) null, exc, obj);
    }

    public void j(int i10) {
        if (this.f8302m == -1) {
            this.f8302m = i10;
            return;
        }
        throw new IllegalStateException("Property '" + getName() + "' already had index (" + this.f8302m + "), trying to assign " + i10);
    }

    public final Object k(c3.k kVar, g gVar) {
        if (kVar.j0(n.VALUE_NULL)) {
            return this.f8298i.getNullValue(gVar);
        }
        e eVar = this.f8297h;
        if (eVar != null) {
            return this.f8296g.deserializeWithType(kVar, gVar, eVar);
        }
        Object deserialize = this.f8296g.deserialize(kVar, gVar);
        if (deserialize == null) {
            return this.f8298i.getNullValue(gVar);
        }
        return deserialize;
    }

    public abstract void l(c3.k kVar, g gVar, Object obj);

    public abstract Object m(c3.k kVar, g gVar, Object obj);

    public final Object n(c3.k kVar, g gVar, Object obj) {
        if (!kVar.j0(n.VALUE_NULL)) {
            if (this.f8297h != null) {
                gVar.q(getType(), String.format("Cannot merge polymorphic property '%s'", new Object[]{getName()}));
            }
            Object deserialize = this.f8296g.deserialize(kVar, gVar, obj);
            if (deserialize != null) {
                return deserialize;
            }
            if (q.b(this.f8298i)) {
                return obj;
            }
            return this.f8298i.getNullValue(gVar);
        } else if (q.b(this.f8298i)) {
            return obj;
        } else {
            return this.f8298i.getNullValue(gVar);
        }
    }

    public void o(f fVar) {
    }

    public int p() {
        throw new IllegalStateException(String.format("Internal error: no creator index for property '%s' (of type %s)", new Object[]{getName(), getClass().getName()}));
    }

    public Object q() {
        return null;
    }

    public String r() {
        return this.f8299j;
    }

    public q s() {
        return this.f8298i;
    }

    public b0 t() {
        return this.f8300k;
    }

    public String toString() {
        return "[property '" + getName() + "']";
    }

    public k u() {
        k kVar = this.f8296g;
        if (kVar == f8291n) {
            return null;
        }
        return kVar;
    }

    public e v() {
        return this.f8297h;
    }

    public boolean w() {
        k kVar = this.f8296g;
        if (kVar == null || kVar == f8291n) {
            return false;
        }
        return true;
    }

    public boolean x() {
        if (this.f8297h != null) {
            return true;
        }
        return false;
    }

    public boolean y() {
        if (this.f8301l != null) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return false;
    }

    public t(x xVar, j jVar, x xVar2, e eVar, b bVar, w wVar) {
        super(wVar);
        this.f8302m = -1;
        if (xVar == null) {
            this.f8292c = x.f7498e;
        } else {
            this.f8292c = xVar.g();
        }
        this.f8293d = jVar;
        this.f8294e = xVar2;
        this.f8295f = bVar;
        this.f8301l = null;
        this.f8297h = eVar != null ? eVar.g(this) : eVar;
        k kVar = f8291n;
        this.f8296g = kVar;
        this.f8298i = kVar;
    }

    public t(x xVar, j jVar, w wVar, k kVar) {
        super(wVar);
        this.f8302m = -1;
        if (xVar == null) {
            this.f8292c = x.f7498e;
        } else {
            this.f8292c = xVar.g();
        }
        this.f8293d = jVar;
        this.f8294e = null;
        this.f8295f = null;
        this.f8301l = null;
        this.f8297h = null;
        this.f8296g = kVar;
        this.f8298i = kVar;
    }

    public t(t tVar) {
        super((v) tVar);
        this.f8302m = -1;
        this.f8292c = tVar.f8292c;
        this.f8293d = tVar.f8293d;
        this.f8294e = tVar.f8294e;
        this.f8295f = tVar.f8295f;
        this.f8296g = tVar.f8296g;
        this.f8297h = tVar.f8297h;
        this.f8299j = tVar.f8299j;
        this.f8302m = tVar.f8302m;
        this.f8301l = tVar.f8301l;
        this.f8298i = tVar.f8298i;
    }

    public t(t tVar, k kVar, q qVar) {
        super((v) tVar);
        this.f8302m = -1;
        this.f8292c = tVar.f8292c;
        this.f8293d = tVar.f8293d;
        this.f8294e = tVar.f8294e;
        this.f8295f = tVar.f8295f;
        this.f8297h = tVar.f8297h;
        this.f8299j = tVar.f8299j;
        this.f8302m = tVar.f8302m;
        if (kVar == null) {
            this.f8296g = f8291n;
        } else {
            this.f8296g = kVar;
        }
        this.f8301l = tVar.f8301l;
        this.f8298i = qVar == f8291n ? this.f8296g : qVar;
    }

    public t(t tVar, x xVar) {
        super((v) tVar);
        this.f8302m = -1;
        this.f8292c = xVar;
        this.f8293d = tVar.f8293d;
        this.f8294e = tVar.f8294e;
        this.f8295f = tVar.f8295f;
        this.f8296g = tVar.f8296g;
        this.f8297h = tVar.f8297h;
        this.f8299j = tVar.f8299j;
        this.f8302m = tVar.f8302m;
        this.f8301l = tVar.f8301l;
        this.f8298i = tVar.f8298i;
    }
}
