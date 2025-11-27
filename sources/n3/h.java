package n3;

import c3.k;
import c3.n;
import d4.m;
import d4.q;
import d4.y;
import java.util.Map;
import java.util.Set;
import k3.c;
import k3.f;
import k3.g;
import m3.b;
import o3.s;
import o3.v;
import r3.j;

public class h extends d {

    /* renamed from: v  reason: collision with root package name */
    public final j f8268v;

    /* renamed from: w  reason: collision with root package name */
    public final k3.j f8269w;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8270a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                m3.b[] r0 = m3.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8270a = r0
                m3.b r1 = m3.b.AsEmpty     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8270a     // Catch:{ NoSuchFieldError -> 0x001d }
                m3.b r1 = m3.b.AsNull     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8270a     // Catch:{ NoSuchFieldError -> 0x0028 }
                m3.b r1 = m3.b.TryConvert     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n3.h.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(e eVar, c cVar, k3.j jVar, o3.c cVar2, Map map, Set set, boolean z10, Set set2, boolean z11) {
        super(eVar, cVar, cVar2, map, set, z10, set2, z11);
        this.f8269w = jVar;
        this.f8268v = eVar.q();
        if (this.f8251t != null) {
            throw new IllegalArgumentException("Cannot use Object Id with Builder-based deserialization (type " + cVar.z() + ")");
        }
    }

    public d G(o3.c cVar) {
        return new h(this, cVar);
    }

    public d H(Set set, Set set2) {
        return new h(this, set, set2);
    }

    public d I(boolean z10) {
        return new h(this, z10);
    }

    public d J(s sVar) {
        return new h(this, sVar);
    }

    public final Object M(k kVar, g gVar, Object obj) {
        Class J;
        if (this.f8241j != null) {
            E(gVar, obj);
        }
        if (this.f8249r != null) {
            if (kVar.j0(n.START_OBJECT)) {
                kVar.s0();
            }
            y yVar = new y(kVar, gVar);
            yVar.v0();
            return S(kVar, gVar, obj, yVar);
        } else if (this.f8250s != null) {
            return Q(kVar, gVar, obj);
        } else {
            if (this.f8246o && (J = gVar.J()) != null) {
                return T(kVar, gVar, obj, J);
            }
            n n10 = kVar.n();
            if (n10 == n.START_OBJECT) {
                n10 = kVar.s0();
            }
            while (n10 == n.FIELD_NAME) {
                String m10 = kVar.m();
                kVar.s0();
                t k10 = this.f8240i.k(m10);
                if (k10 != null) {
                    try {
                        obj = k10.m(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    D(kVar, gVar, obj, m10);
                }
                n10 = kVar.s0();
            }
            return obj;
        }
    }

    public Object N(k kVar, g gVar) {
        k3.j jVar = this.f8269w;
        return gVar.q(jVar, String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", new Object[]{jVar}));
    }

    public Object O(k kVar, g gVar) {
        v vVar = this.f8237f;
        o3.y e10 = vVar.e(kVar, gVar, this.f8251t);
        y yVar = new y(kVar, gVar);
        yVar.v0();
        n n10 = kVar.n();
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 == null) {
                    t k10 = this.f8240i.k(m10);
                    if (k10 != null) {
                        e10.e(k10, k10.k(kVar, gVar));
                    } else if (m.c(m10, this.f8243l, this.f8244m)) {
                        A(kVar, gVar, handledType(), m10);
                    } else {
                        yVar.Z(m10);
                        yVar.V0(kVar);
                        s sVar = this.f8242k;
                        if (sVar != null) {
                            e10.c(sVar, m10, sVar.b(kVar, gVar));
                        }
                    }
                } else if (e10.b(d10, d10.k(kVar, gVar))) {
                    kVar.s0();
                    try {
                        Object a10 = vVar.a(gVar, e10);
                        if (a10.getClass() != this.f8232a.q()) {
                            return B(kVar, gVar, a10, yVar);
                        }
                        return S(kVar, gVar, a10, yVar);
                    } catch (Exception e11) {
                        K(e11, this.f8232a.q(), m10, gVar);
                    }
                } else {
                    continue;
                }
            }
            n10 = kVar.s0();
        }
        yVar.W();
        try {
            return this.f8249r.b(kVar, gVar, vVar.a(gVar, e10), yVar);
        } catch (Exception e12) {
            return L(e12, gVar);
        }
    }

    public Object P(k kVar, g gVar) {
        if (this.f8237f != null) {
            return N(kVar, gVar);
        }
        return Q(kVar, gVar, this.f8234c.x(gVar));
    }

    public Object Q(k kVar, g gVar, Object obj) {
        Class cls;
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        o3.g i10 = this.f8250s.i();
        n n10 = kVar.n();
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            n s02 = kVar.s0();
            t k10 = this.f8240i.k(m10);
            if (k10 != null) {
                if (s02.e()) {
                    i10.h(kVar, gVar, m10, obj);
                }
                if (cls == null || k10.H(cls)) {
                    try {
                        obj = k10.m(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (m.c(m10, this.f8243l, this.f8244m)) {
                A(kVar, gVar, obj, m10);
            } else if (!i10.g(kVar, gVar, m10, obj)) {
                s sVar = this.f8242k;
                if (sVar != null) {
                    try {
                        sVar.c(kVar, gVar, obj, m10);
                    } catch (Exception e11) {
                        K(e11, obj, m10, gVar);
                    }
                } else {
                    handleUnknownProperty(kVar, gVar, obj, m10);
                }
            }
            n10 = kVar.s0();
        }
        return i10.e(kVar, gVar, obj);
    }

    public Object R(k kVar, g gVar) {
        Class cls;
        k3.k kVar2 = this.f8235d;
        if (kVar2 != null) {
            return this.f8234c.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        if (this.f8237f != null) {
            return O(kVar, gVar);
        }
        y yVar = new y(kVar, gVar);
        yVar.v0();
        Object x10 = this.f8234c.x(gVar);
        if (this.f8241j != null) {
            E(gVar, x10);
        }
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        while (kVar.n() == n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t k10 = this.f8240i.k(m10);
            if (k10 != null) {
                if (cls == null || k10.H(cls)) {
                    try {
                        x10 = k10.m(kVar, gVar, x10);
                    } catch (Exception e10) {
                        K(e10, x10, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (m.c(m10, this.f8243l, this.f8244m)) {
                A(kVar, gVar, x10, m10);
            } else {
                yVar.Z(m10);
                yVar.V0(kVar);
                s sVar = this.f8242k;
                if (sVar != null) {
                    try {
                        sVar.c(kVar, gVar, x10, m10);
                    } catch (Exception e11) {
                        K(e11, x10, m10, gVar);
                    }
                }
            }
            kVar.s0();
        }
        yVar.W();
        return this.f8249r.b(kVar, gVar, x10, yVar);
    }

    public Object S(k kVar, g gVar, Object obj, y yVar) {
        Class cls;
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        n n10 = kVar.n();
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            t k10 = this.f8240i.k(m10);
            kVar.s0();
            if (k10 != null) {
                if (cls == null || k10.H(cls)) {
                    try {
                        obj = k10.m(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (m.c(m10, this.f8243l, this.f8244m)) {
                A(kVar, gVar, obj, m10);
            } else {
                yVar.Z(m10);
                yVar.V0(kVar);
                s sVar = this.f8242k;
                if (sVar != null) {
                    sVar.c(kVar, gVar, obj, m10);
                }
            }
            n10 = kVar.s0();
        }
        yVar.W();
        return this.f8249r.b(kVar, gVar, obj, yVar);
    }

    public final Object T(k kVar, g gVar, Object obj, Class cls) {
        n n10 = kVar.n();
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t k10 = this.f8240i.k(m10);
            if (k10 == null) {
                D(kVar, gVar, obj, m10);
            } else if (!k10.H(cls)) {
                kVar.D0();
            } else {
                try {
                    obj = k10.m(kVar, gVar, obj);
                } catch (Exception e10) {
                    K(e10, obj, m10, gVar);
                }
            }
            n10 = kVar.s0();
        }
        return obj;
    }

    public Object U(g gVar, Object obj) {
        j jVar = this.f8268v;
        if (jVar == null) {
            return obj;
        }
        try {
            return jVar.m().invoke(obj, (Object[]) null);
        } catch (Exception e10) {
            return L(e10, gVar);
        }
    }

    public final Object V(k kVar, g gVar, n nVar) {
        Object x10 = this.f8234c.x(gVar);
        while (kVar.n() == n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t k10 = this.f8240i.k(m10);
            if (k10 != null) {
                try {
                    x10 = k10.m(kVar, gVar, x10);
                } catch (Exception e10) {
                    K(e10, x10, m10, gVar);
                }
            } else {
                D(kVar, gVar, x10, m10);
            }
            kVar.s0();
        }
        return x10;
    }

    public Object _deserializeFromArray(k kVar, g gVar) {
        k3.k kVar2 = this.f8236e;
        if (kVar2 == null && (kVar2 = this.f8235d) == null) {
            b _findCoercionFromEmptyArray = _findCoercionFromEmptyArray(gVar);
            boolean n02 = gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS);
            if (n02 || _findCoercionFromEmptyArray != b.Fail) {
                n s02 = kVar.s0();
                n nVar = n.END_ARRAY;
                if (s02 == nVar) {
                    int i10 = a.f8270a[_findCoercionFromEmptyArray.ordinal()];
                    if (i10 == 1) {
                        return getEmptyValue(gVar);
                    }
                    if (i10 == 2 || i10 == 3) {
                        return getNullValue(gVar);
                    }
                    return gVar.d0(getValueType(gVar), n.START_ARRAY, kVar, (String) null, new Object[0]);
                } else if (n02) {
                    Object deserialize = deserialize(kVar, gVar);
                    if (kVar.s0() != nVar) {
                        handleMissingEndArrayForSingle(kVar, gVar);
                    }
                    return deserialize;
                }
            }
            return gVar.c0(getValueType(gVar), kVar);
        }
        Object w10 = this.f8234c.w(gVar, kVar2.deserialize(kVar, gVar));
        if (this.f8241j != null) {
            E(gVar, w10);
        }
        return U(gVar, w10);
    }

    public Object c(k kVar, g gVar) {
        Class cls;
        Object obj;
        v vVar = this.f8237f;
        o3.y e10 = vVar.e(kVar, gVar, this.f8251t);
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        n n10 = kVar.n();
        y yVar = null;
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 == null) {
                    t k10 = this.f8240i.k(m10);
                    if (k10 != null) {
                        e10.e(k10, k10.k(kVar, gVar));
                    } else if (m.c(m10, this.f8243l, this.f8244m)) {
                        A(kVar, gVar, handledType(), m10);
                    } else {
                        s sVar = this.f8242k;
                        if (sVar != null) {
                            e10.c(sVar, m10, sVar.b(kVar, gVar));
                        } else {
                            if (yVar == null) {
                                yVar = new y(kVar, gVar);
                            }
                            yVar.Z(m10);
                            yVar.V0(kVar);
                        }
                    }
                } else if (cls != null && !d10.H(cls)) {
                    kVar.D0();
                } else if (e10.b(d10, d10.k(kVar, gVar))) {
                    kVar.s0();
                    try {
                        Object a10 = vVar.a(gVar, e10);
                        if (a10.getClass() != this.f8232a.q()) {
                            return B(kVar, gVar, a10, yVar);
                        }
                        if (yVar != null) {
                            a10 = C(gVar, a10, yVar);
                        }
                        return M(kVar, gVar, a10);
                    } catch (Exception e11) {
                        K(e11, this.f8232a.q(), m10, gVar);
                    }
                } else {
                    continue;
                }
            }
            n10 = kVar.s0();
        }
        try {
            obj = vVar.a(gVar, e10);
        } catch (Exception e12) {
            obj = L(e12, gVar);
        }
        if (yVar == null) {
            return obj;
        }
        if (obj.getClass() != this.f8232a.q()) {
            return B((k) null, gVar, obj, yVar);
        }
        return C(gVar, obj, yVar);
    }

    public Object deserialize(k kVar, g gVar) {
        if (kVar.o0()) {
            n s02 = kVar.s0();
            if (this.f8239h) {
                return U(gVar, V(kVar, gVar, s02));
            }
            return U(gVar, s(kVar, gVar));
        }
        switch (kVar.q()) {
            case 2:
            case 5:
                return U(gVar, s(kVar, gVar));
            case 3:
                return _deserializeFromArray(kVar, gVar);
            case 6:
                return U(gVar, v(kVar, gVar));
            case 7:
                return U(gVar, r(kVar, gVar));
            case 8:
                return U(gVar, p(kVar, gVar));
            case 9:
            case 10:
                return U(gVar, o(kVar, gVar));
            case 12:
                return kVar.N();
            default:
                return gVar.c0(getValueType(gVar), kVar);
        }
    }

    public d n() {
        return new o3.a(this, this.f8269w, this.f8240i.m(), this.f8268v);
    }

    public Object s(k kVar, g gVar) {
        Class J;
        if (!this.f8238g) {
            Object x10 = this.f8234c.x(gVar);
            if (this.f8241j != null) {
                E(gVar, x10);
            }
            if (this.f8246o && (J = gVar.J()) != null) {
                return T(kVar, gVar, x10, J);
            }
            while (kVar.n() == n.FIELD_NAME) {
                String m10 = kVar.m();
                kVar.s0();
                t k10 = this.f8240i.k(m10);
                if (k10 != null) {
                    try {
                        x10 = k10.m(kVar, gVar, x10);
                    } catch (Exception e10) {
                        K(e10, x10, m10, gVar);
                    }
                } else {
                    D(kVar, gVar, x10, m10);
                }
                kVar.s0();
            }
            return x10;
        } else if (this.f8249r != null) {
            return R(kVar, gVar);
        } else {
            if (this.f8250s != null) {
                return P(kVar, gVar);
            }
            return u(kVar, gVar);
        }
    }

    public Boolean supportsUpdate(f fVar) {
        return Boolean.FALSE;
    }

    public k3.k unwrappingDeserializer(q qVar) {
        return new h(this, qVar);
    }

    public h(h hVar, boolean z10) {
        super((d) hVar, z10);
        this.f8268v = hVar.f8268v;
        this.f8269w = hVar.f8269w;
    }

    public h(h hVar, q qVar) {
        super((d) hVar, qVar);
        this.f8268v = hVar.f8268v;
        this.f8269w = hVar.f8269w;
    }

    public h(h hVar, s sVar) {
        super((d) hVar, sVar);
        this.f8268v = hVar.f8268v;
        this.f8269w = hVar.f8269w;
    }

    public Object deserialize(k kVar, g gVar, Object obj) {
        k3.j jVar = this.f8269w;
        Class handledType = handledType();
        Class<?> cls = obj.getClass();
        if (handledType.isAssignableFrom(cls)) {
            return gVar.q(jVar, String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", new Object[]{jVar, handledType.getName()}));
        }
        return gVar.q(jVar, String.format("Deserialization of %s by passing existing instance (of %s) not supported", new Object[]{jVar, cls.getName()}));
    }

    public h(h hVar, Set set, Set set2) {
        super(hVar, set, set2);
        this.f8268v = hVar.f8268v;
        this.f8269w = hVar.f8269w;
    }

    public h(h hVar, o3.c cVar) {
        super((d) hVar, cVar);
        this.f8268v = hVar.f8268v;
        this.f8269w = hVar.f8269w;
    }
}
