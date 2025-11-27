package n3;

import b3.k0;
import b3.n0;
import b3.o0;
import c3.n;
import c4.f;
import d4.h;
import java.io.Serializable;
import java.util.Map;
import k3.b;
import k3.c;
import k3.d;
import k3.g;
import k3.j;
import k3.k;
import k3.x;
import n3.w;
import o3.s;
import o3.w;
import o3.z;
import r3.b0;
import r3.i;
import w3.e;

public class a extends k implements i, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final j f8195a;

    /* renamed from: b  reason: collision with root package name */
    public final s f8196b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f8197c;

    /* renamed from: d  reason: collision with root package name */
    public transient Map f8198d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f8199e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f8200f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f8201g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f8202h;

    public a(e eVar, c cVar, Map map, Map map2) {
        j z10 = cVar.z();
        this.f8195a = z10;
        this.f8196b = eVar.s();
        this.f8197c = map;
        this.f8198d = map2;
        Class q10 = z10.q();
        this.f8199e = q10.isAssignableFrom(String.class);
        boolean z11 = false;
        this.f8200f = q10 == Boolean.TYPE || q10.isAssignableFrom(Boolean.class);
        this.f8201g = q10 == Integer.TYPE || q10.isAssignableFrom(Integer.class);
        this.f8202h = (q10 == Double.TYPE || q10.isAssignableFrom(Double.class)) ? true : z11;
    }

    public static a c(c cVar) {
        return new a(cVar);
    }

    public Object a(c3.k kVar, g gVar) {
        Object f10 = this.f8196b.f(kVar, gVar);
        s sVar = this.f8196b;
        k0 k0Var = sVar.f8536c;
        sVar.getClass();
        z H = gVar.H(f10, k0Var, (o0) null);
        Object f11 = H.f();
        if (f11 != null) {
            return f11;
        }
        throw new u(kVar, "Could not resolve Object Id [" + f10 + "] -- unresolved forward-reference?", kVar.z(), H);
    }

    public Object b(c3.k kVar, g gVar) {
        switch (kVar.q()) {
            case 6:
                if (this.f8199e) {
                    return kVar.Y();
                }
                return null;
            case 7:
                if (this.f8201g) {
                    return Integer.valueOf(kVar.P());
                }
                return null;
            case 8:
                if (this.f8202h) {
                    return Double.valueOf(kVar.M());
                }
                return null;
            case 9:
                if (this.f8200f) {
                    return Boolean.TRUE;
                }
                return null;
            case 10:
                if (this.f8200f) {
                    return Boolean.FALSE;
                }
                return null;
            default:
                return null;
        }
    }

    public k createContextual(g gVar, d dVar) {
        i d10;
        b0 B;
        t tVar;
        j jVar;
        k0 k0Var;
        t tVar2;
        b K = gVar.K();
        if (dVar != null && K != null && (d10 = dVar.d()) != null && (B = K.B(d10)) != null) {
            gVar.o(d10, B);
            b0 C = K.C(d10, B);
            Class<n0> c10 = C.c();
            if (c10 == n0.class) {
                x d11 = C.d();
                Map map = this.f8198d;
                if (map == null) {
                    tVar2 = null;
                } else {
                    tVar2 = (t) map.get(d11.c());
                }
                if (tVar2 == null) {
                    gVar.q(this.f8195a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[]{h.X(handledType()), h.V(d11)}));
                }
                j type = tVar2.getType();
                k0Var = new w(C.f());
                jVar = type;
                tVar = tVar2;
            } else {
                gVar.o(d10, C);
                j jVar2 = gVar.l().K(gVar.x(c10), k0.class)[0];
                k0Var = gVar.n(d10, C);
                tVar = null;
                jVar = jVar2;
            }
            return new a(this, s.a(jVar, C.d(), k0Var, gVar.I(jVar), tVar, (o0) null), (Map) null);
        } else if (this.f8198d == null) {
            return this;
        } else {
            return new a(this, this.f8196b, (Map) null);
        }
    }

    public Object deserialize(c3.k kVar, g gVar) {
        return gVar.W(this.f8195a.q(), new w.a(this.f8195a), kVar, "abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information", new Object[0]);
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        n n10;
        if (!(this.f8196b == null || (n10 = kVar.n()) == null)) {
            if (n10.e()) {
                return a(kVar, gVar);
            }
            if (n10 == n.START_OBJECT) {
                n10 = kVar.s0();
            }
            if (n10 == n.FIELD_NAME && this.f8196b.e() && this.f8196b.d(kVar.m(), kVar)) {
                return a(kVar, gVar);
            }
        }
        Object b10 = b(kVar, gVar);
        if (b10 != null) {
            return b10;
        }
        return eVar.e(kVar, gVar);
    }

    public t findBackReference(String str) {
        Map map = this.f8197c;
        if (map == null) {
            return null;
        }
        return (t) map.get(str);
    }

    public s getObjectIdReader() {
        return this.f8196b;
    }

    public Class handledType() {
        return this.f8195a.q();
    }

    public boolean isCachable() {
        return true;
    }

    public f logicalType() {
        return f.POJO;
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return null;
    }

    public a(c cVar) {
        j z10 = cVar.z();
        this.f8195a = z10;
        this.f8196b = null;
        this.f8197c = null;
        Class q10 = z10.q();
        this.f8199e = q10.isAssignableFrom(String.class);
        boolean z11 = false;
        this.f8200f = q10 == Boolean.TYPE || q10.isAssignableFrom(Boolean.class);
        this.f8201g = q10 == Integer.TYPE || q10.isAssignableFrom(Integer.class);
        this.f8202h = (q10 == Double.TYPE || q10.isAssignableFrom(Double.class)) ? true : z11;
    }

    public a(a aVar, s sVar, Map map) {
        this.f8195a = aVar.f8195a;
        this.f8197c = aVar.f8197c;
        this.f8199e = aVar.f8199e;
        this.f8200f = aVar.f8200f;
        this.f8201g = aVar.f8201g;
        this.f8202h = aVar.f8202h;
        this.f8196b = sVar;
        this.f8198d = map;
    }
}
