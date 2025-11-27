package a4;

import b3.r;
import b4.k;
import com.fasterxml.jackson.databind.ser.std.d;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import d4.b;
import d4.q;
import f3.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import k3.a0;
import k3.b0;
import k3.c0;
import k3.j;
import k3.m;
import k3.o;
import k3.x;
import r3.g;
import r3.s;
import v3.a;
import w3.h;

public class c extends n {

    /* renamed from: t  reason: collision with root package name */
    public static final Object f184t = r.a.NON_EMPTY;

    /* renamed from: c  reason: collision with root package name */
    public final i f185c;

    /* renamed from: d  reason: collision with root package name */
    public final x f186d;

    /* renamed from: e  reason: collision with root package name */
    public final j f187e;

    /* renamed from: f  reason: collision with root package name */
    public final j f188f;

    /* renamed from: g  reason: collision with root package name */
    public j f189g;

    /* renamed from: h  reason: collision with root package name */
    public final transient b f190h;

    /* renamed from: i  reason: collision with root package name */
    public final r3.i f191i;

    /* renamed from: j  reason: collision with root package name */
    public transient Method f192j;

    /* renamed from: k  reason: collision with root package name */
    public transient Field f193k;

    /* renamed from: l  reason: collision with root package name */
    public o f194l;

    /* renamed from: m  reason: collision with root package name */
    public o f195m;

    /* renamed from: n  reason: collision with root package name */
    public h f196n;

    /* renamed from: o  reason: collision with root package name */
    public transient k f197o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f198p;

    /* renamed from: q  reason: collision with root package name */
    public final Object f199q;

    /* renamed from: r  reason: collision with root package name */
    public final Class[] f200r;

    /* renamed from: s  reason: collision with root package name */
    public transient HashMap f201s;

    public c(s sVar, r3.i iVar, b bVar, j jVar, o oVar, h hVar, j jVar2, boolean z10, Object obj, Class[] clsArr) {
        super(sVar);
        this.f191i = iVar;
        this.f190h = bVar;
        this.f185c = new i(sVar.getName());
        this.f186d = sVar.w();
        this.f187e = jVar;
        this.f194l = oVar;
        this.f197o = oVar == null ? k.c() : null;
        this.f196n = hVar;
        this.f188f = jVar2;
        if (iVar instanceof g) {
            this.f192j = null;
            this.f193k = (Field) iVar.m();
        } else if (iVar instanceof r3.j) {
            this.f192j = (Method) iVar.m();
            this.f193k = null;
        } else {
            this.f192j = null;
            this.f193k = null;
        }
        this.f198p = z10;
        this.f199q = obj;
        this.f195m = null;
        this.f200r = clsArr;
    }

    public void A(Object obj, c3.h hVar, c0 c0Var) {
        o oVar = this.f195m;
        if (oVar != null) {
            oVar.serialize((Object) null, hVar, c0Var);
        } else {
            hVar.a0();
        }
    }

    public void B(j jVar) {
        this.f189g = jVar;
    }

    public c C(q qVar) {
        return new b4.r(this, qVar);
    }

    public boolean D() {
        return this.f198p;
    }

    public boolean E(x xVar) {
        x xVar2 = this.f186d;
        if (xVar2 != null) {
            return xVar2.equals(xVar);
        }
        if (!xVar.f(this.f185c.getValue()) || xVar.d()) {
            return false;
        }
        return true;
    }

    public x c() {
        return new x(this.f185c.getValue());
    }

    public r3.i d() {
        return this.f191i;
    }

    public void g(z3.r rVar, m mVar) {
        rVar.G(getName(), mVar);
    }

    public String getName() {
        return this.f185c.getValue();
    }

    public j getType() {
        return this.f187e;
    }

    public o h(k kVar, Class cls, c0 c0Var) {
        k.d dVar;
        j jVar = this.f189g;
        if (jVar != null) {
            dVar = kVar.f(c0Var.A(jVar, cls), c0Var, this);
        } else {
            dVar = kVar.e(cls, c0Var, this);
        }
        k kVar2 = dVar.f4357b;
        if (kVar != kVar2) {
            this.f197o = kVar2;
        }
        return dVar.f4356a;
    }

    public boolean i(Object obj, c3.h hVar, c0 c0Var, o oVar) {
        if (oVar.usesObjectId()) {
            return false;
        }
        if (c0Var.m0(b0.FAIL_ON_SELF_REFERENCES)) {
            if (!(oVar instanceof d)) {
                return false;
            }
            c0Var.q(getType(), "Direct self-reference leading to cycle");
            return false;
        } else if (!c0Var.m0(b0.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        } else {
            if (this.f195m == null) {
                return true;
            }
            if (!hVar.s().f()) {
                hVar.Y(this.f185c);
            }
            this.f195m.serialize((Object) null, hVar, c0Var);
            return true;
        }
    }

    public c j(x xVar) {
        return new c(this, xVar);
    }

    public void k(o oVar) {
        o oVar2 = this.f195m;
        if (oVar2 == null || oVar2 == oVar) {
            this.f195m = oVar;
        } else {
            throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", new Object[]{d4.h.h(this.f195m), d4.h.h(oVar)}));
        }
    }

    public void l(o oVar) {
        o oVar2 = this.f194l;
        if (oVar2 == null || oVar2 == oVar) {
            this.f194l = oVar;
        } else {
            throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", new Object[]{d4.h.h(this.f194l), d4.h.h(oVar)}));
        }
    }

    public void m(h hVar) {
        this.f196n = hVar;
    }

    public void n(z3.r rVar, c0 c0Var) {
        Type type;
        m mVar;
        j q10 = q();
        if (q10 == null) {
            type = getType();
        } else {
            type = q10.q();
        }
        o r10 = r();
        if (r10 == null) {
            r10 = c0Var.U(getType(), this);
        }
        boolean z10 = !f();
        if (r10 instanceof v3.c) {
            mVar = ((v3.c) r10).getSchema(c0Var, type, z10);
        } else {
            mVar = a.a();
        }
        g(rVar, mVar);
    }

    public void o(a0 a0Var) {
        this.f191i.i(a0Var.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public final Object p(Object obj) {
        Method method = this.f192j;
        if (method == null) {
            return this.f193k.get(obj);
        }
        return method.invoke(obj, (Object[]) null);
    }

    public j q() {
        return this.f188f;
    }

    public o r() {
        return this.f194l;
    }

    public h s() {
        return this.f196n;
    }

    public Class[] t() {
        return this.f200r;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(getName());
        sb.append("' (");
        if (this.f192j != null) {
            sb.append("via method ");
            sb.append(this.f192j.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f192j.getName());
        } else if (this.f193k != null) {
            sb.append("field \"");
            sb.append(this.f193k.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f193k.getName());
        } else {
            sb.append("virtual");
        }
        if (this.f194l == null) {
            sb.append(", no static serializer");
        } else {
            sb.append(", static serializer of type " + this.f194l.getClass().getName());
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        return sb.toString();
    }

    public boolean u() {
        if (this.f195m != null) {
            return true;
        }
        return false;
    }

    public boolean v() {
        if (this.f194l != null) {
            return true;
        }
        return false;
    }

    public c w(q qVar) {
        String c10 = qVar.c(this.f185c.getValue());
        if (c10.equals(this.f185c.toString())) {
            return this;
        }
        return j(x.a(c10));
    }

    public void x(Object obj, c3.h hVar, c0 c0Var) {
        Object obj2;
        Method method = this.f192j;
        if (method == null) {
            obj2 = this.f193k.get(obj);
        } else {
            obj2 = method.invoke(obj, (Object[]) null);
        }
        if (obj2 == null) {
            o oVar = this.f195m;
            if (oVar != null) {
                oVar.serialize((Object) null, hVar, c0Var);
            } else {
                hVar.a0();
            }
        } else {
            o oVar2 = this.f194l;
            if (oVar2 == null) {
                Class<?> cls = obj2.getClass();
                k kVar = this.f197o;
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    oVar2 = h(kVar, cls, c0Var);
                } else {
                    oVar2 = j10;
                }
            }
            Object obj3 = this.f199q;
            if (obj3 != null) {
                if (f184t == obj3) {
                    if (oVar2.isEmpty(c0Var, obj2)) {
                        A(obj, hVar, c0Var);
                        return;
                    }
                } else if (obj3.equals(obj2)) {
                    A(obj, hVar, c0Var);
                    return;
                }
            }
            if (obj2 != obj || !i(obj, hVar, c0Var, oVar2)) {
                h hVar2 = this.f196n;
                if (hVar2 == null) {
                    oVar2.serialize(obj2, hVar, c0Var);
                } else {
                    oVar2.serializeWithType(obj2, hVar, c0Var, hVar2);
                }
            }
        }
    }

    public void y(Object obj, c3.h hVar, c0 c0Var) {
        Object obj2;
        Method method = this.f192j;
        if (method == null) {
            obj2 = this.f193k.get(obj);
        } else {
            obj2 = method.invoke(obj, (Object[]) null);
        }
        if (obj2 != null) {
            o oVar = this.f194l;
            if (oVar == null) {
                Class<?> cls = obj2.getClass();
                k kVar = this.f197o;
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    oVar = h(kVar, cls, c0Var);
                } else {
                    oVar = j10;
                }
            }
            Object obj3 = this.f199q;
            if (obj3 != null) {
                if (f184t == obj3) {
                    if (oVar.isEmpty(c0Var, obj2)) {
                        return;
                    }
                } else if (obj3.equals(obj2)) {
                    return;
                }
            }
            if (obj2 != obj || !i(obj, hVar, c0Var, oVar)) {
                hVar.Y(this.f185c);
                h hVar2 = this.f196n;
                if (hVar2 == null) {
                    oVar.serialize(obj2, hVar, c0Var);
                } else {
                    oVar.serializeWithType(obj2, hVar, c0Var, hVar2);
                }
            }
        } else if (this.f195m != null) {
            hVar.Y(this.f185c);
            this.f195m.serialize((Object) null, hVar, c0Var);
        }
    }

    public void z(Object obj, c3.h hVar, c0 c0Var) {
        if (!hVar.e()) {
            hVar.l0(this.f185c.getValue());
        }
    }

    public c(c cVar) {
        this(cVar, cVar.f185c);
    }

    public c(c cVar, x xVar) {
        super((n) cVar);
        this.f185c = new i(xVar.c());
        this.f186d = cVar.f186d;
        this.f190h = cVar.f190h;
        this.f187e = cVar.f187e;
        this.f191i = cVar.f191i;
        this.f192j = cVar.f192j;
        this.f193k = cVar.f193k;
        this.f194l = cVar.f194l;
        this.f195m = cVar.f195m;
        if (cVar.f201s != null) {
            this.f201s = new HashMap(cVar.f201s);
        }
        this.f188f = cVar.f188f;
        this.f197o = cVar.f197o;
        this.f198p = cVar.f198p;
        this.f199q = cVar.f199q;
        this.f200r = cVar.f200r;
        this.f196n = cVar.f196n;
        this.f189g = cVar.f189g;
    }

    public c(c cVar, i iVar) {
        super((n) cVar);
        this.f185c = iVar;
        this.f186d = cVar.f186d;
        this.f191i = cVar.f191i;
        this.f190h = cVar.f190h;
        this.f187e = cVar.f187e;
        this.f192j = cVar.f192j;
        this.f193k = cVar.f193k;
        this.f194l = cVar.f194l;
        this.f195m = cVar.f195m;
        if (cVar.f201s != null) {
            this.f201s = new HashMap(cVar.f201s);
        }
        this.f188f = cVar.f188f;
        this.f197o = cVar.f197o;
        this.f198p = cVar.f198p;
        this.f199q = cVar.f199q;
        this.f200r = cVar.f200r;
        this.f196n = cVar.f196n;
        this.f189g = cVar.f189g;
    }
}
