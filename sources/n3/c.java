package n3;

import c3.k;
import c3.n;
import d4.m;
import d4.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import k3.g;
import k3.h;
import k3.j;
import o3.s;
import o3.v;
import o3.y;
import o3.z;

public class c extends d {

    /* renamed from: v  reason: collision with root package name */
    public transient Exception f8224v;

    /* renamed from: w  reason: collision with root package name */
    public volatile transient q f8225w;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8226a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f8227b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0091 */
        static {
            /*
                m3.b[] r0 = m3.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8227b = r0
                r1 = 1
                m3.b r2 = m3.b.AsEmpty     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8227b     // Catch:{ NoSuchFieldError -> 0x001d }
                m3.b r3 = m3.b.AsNull     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8227b     // Catch:{ NoSuchFieldError -> 0x0028 }
                m3.b r4 = m3.b.TryConvert     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                c3.n[] r3 = c3.n.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f8226a = r3
                c3.n r4 = c3.n.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f8226a     // Catch:{ NoSuchFieldError -> 0x0043 }
                c3.n r3 = c3.n.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f8226a     // Catch:{ NoSuchFieldError -> 0x004d }
                c3.n r1 = c3.n.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f8226a     // Catch:{ NoSuchFieldError -> 0x0058 }
                c3.n r1 = c3.n.VALUE_EMBEDDED_OBJECT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f8226a     // Catch:{ NoSuchFieldError -> 0x0063 }
                c3.n r1 = c3.n.VALUE_TRUE     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f8226a     // Catch:{ NoSuchFieldError -> 0x006e }
                c3.n r1 = c3.n.VALUE_FALSE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f8226a     // Catch:{ NoSuchFieldError -> 0x0079 }
                c3.n r1 = c3.n.VALUE_NULL     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = f8226a     // Catch:{ NoSuchFieldError -> 0x0085 }
                c3.n r1 = c3.n.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = f8226a     // Catch:{ NoSuchFieldError -> 0x0091 }
                c3.n r1 = c3.n.FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                int[] r0 = f8226a     // Catch:{ NoSuchFieldError -> 0x009d }
                c3.n r1 = c3.n.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x009d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009d }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n3.c.a.<clinit>():void");
        }
    }

    public static class b extends z.a {

        /* renamed from: c  reason: collision with root package name */
        public final g f8228c;

        /* renamed from: d  reason: collision with root package name */
        public final t f8229d;

        /* renamed from: e  reason: collision with root package name */
        public Object f8230e;

        public b(g gVar, u uVar, j jVar, y yVar, t tVar) {
            super(uVar, jVar);
            this.f8228c = gVar;
            this.f8229d = tVar;
        }

        public void c(Object obj) {
            this.f8230e = obj;
        }
    }

    public c(e eVar, k3.c cVar, o3.c cVar2, Map map, HashSet hashSet, boolean z10, Set set, boolean z11) {
        super(eVar, cVar, cVar2, map, hashSet, z10, set, z11);
    }

    public d G(o3.c cVar) {
        return new c((d) this, cVar);
    }

    public d I(boolean z10) {
        return new c((d) this, z10);
    }

    public Exception M() {
        if (this.f8224v == null) {
            this.f8224v = new NullPointerException("JSON Creator returned null");
        }
        return this.f8224v;
    }

    public final Object N(k kVar, g gVar, n nVar) {
        if (nVar != null) {
            switch (a.f8226a[nVar.ordinal()]) {
                case 1:
                    return v(kVar, gVar);
                case 2:
                    return r(kVar, gVar);
                case 3:
                    return p(kVar, gVar);
                case 4:
                    return q(kVar, gVar);
                case 5:
                case 6:
                    return o(kVar, gVar);
                case 7:
                    return Q(kVar, gVar);
                case 8:
                    return _deserializeFromArray(kVar, gVar);
                case 9:
                case 10:
                    if (this.f8239h) {
                        return Z(kVar, gVar, nVar);
                    }
                    if (this.f8251t != null) {
                        return w(kVar, gVar);
                    }
                    return s(kVar, gVar);
            }
        }
        return gVar.c0(getValueType(gVar), kVar);
    }

    public final Object O(k kVar, g gVar, t tVar) {
        try {
            return tVar.k(kVar, gVar);
        } catch (Exception e10) {
            K(e10, this.f8232a.q(), tVar.getName(), gVar);
            return null;
        }
    }

    public Object P(k kVar, g gVar, Object obj, o3.g gVar2) {
        Class cls;
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        n n10 = kVar.n();
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            n s02 = kVar.s0();
            t k10 = this.f8240i.k(m10);
            if (k10 != null) {
                if (s02.e()) {
                    gVar2.h(kVar, gVar, m10, obj);
                }
                if (cls == null || k10.H(cls)) {
                    try {
                        k10.l(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (m.c(m10, this.f8243l, this.f8244m)) {
                A(kVar, gVar, obj, m10);
            } else if (!gVar2.g(kVar, gVar, m10, obj)) {
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
        return gVar2.e(kVar, gVar, obj);
    }

    public Object Q(k kVar, g gVar) {
        Object obj;
        if (!kVar.z0()) {
            return gVar.c0(getValueType(gVar), kVar);
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.W();
        k S0 = yVar.S0(kVar);
        S0.s0();
        if (this.f8239h) {
            obj = Z(S0, gVar, n.END_OBJECT);
        } else {
            obj = s(S0, gVar);
        }
        S0.close();
        return obj;
    }

    public Object R(k kVar, g gVar) {
        Class cls;
        o3.g i10 = this.f8250s.i();
        v vVar = this.f8237f;
        y e10 = vVar.e(kVar, gVar, this.f8251t);
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        n n10 = kVar.n();
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            n s02 = kVar.s0();
            t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 == null) {
                    t k10 = this.f8240i.k(m10);
                    if (k10 != null) {
                        if (s02.e()) {
                            i10.h(kVar, gVar, m10, (Object) null);
                        }
                        if (cls == null || k10.H(cls)) {
                            e10.e(k10, k10.k(kVar, gVar));
                        } else {
                            kVar.D0();
                        }
                    } else if (!i10.g(kVar, gVar, m10, (Object) null)) {
                        if (m.c(m10, this.f8243l, this.f8244m)) {
                            A(kVar, gVar, handledType(), m10);
                        } else {
                            s sVar = this.f8242k;
                            if (sVar != null) {
                                e10.c(sVar, m10, sVar.b(kVar, gVar));
                            } else {
                                handleUnknownProperty(kVar, gVar, this._valueClass, m10);
                            }
                        }
                    }
                } else if (!i10.g(kVar, gVar, m10, (Object) null) && e10.b(d10, O(kVar, gVar, d10))) {
                    kVar.s0();
                    try {
                        Object a10 = vVar.a(gVar, e10);
                        if (a10.getClass() == this.f8232a.q()) {
                            return P(kVar, gVar, a10, i10);
                        }
                        j jVar = this.f8232a;
                        return gVar.q(jVar, String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", new Object[]{jVar, a10.getClass()}));
                    } catch (Exception e11) {
                        K(e11, this.f8232a.q(), m10, gVar);
                    }
                }
            }
            n10 = kVar.s0();
        }
        try {
            return i10.f(kVar, gVar, e10, vVar);
        } catch (Exception e12) {
            return L(e12, gVar);
        }
    }

    public Object S(k kVar, g gVar) {
        Object obj;
        v vVar = this.f8237f;
        y e10 = vVar.e(kVar, gVar, this.f8251t);
        d4.y yVar = new d4.y(kVar, gVar);
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
                        e10.e(k10, O(kVar, gVar, k10));
                    } else if (m.c(m10, this.f8243l, this.f8244m)) {
                        A(kVar, gVar, handledType(), m10);
                    } else if (this.f8242k == null) {
                        yVar.Z(m10);
                        yVar.V0(kVar);
                    } else {
                        d4.y Q0 = d4.y.Q0(kVar);
                        yVar.Z(m10);
                        yVar.P0(Q0);
                        try {
                            s sVar = this.f8242k;
                            e10.c(sVar, m10, sVar.b(Q0.U0(), gVar));
                        } catch (Exception e11) {
                            K(e11, this.f8232a.q(), m10, gVar);
                        }
                    }
                } else if (e10.b(d10, O(kVar, gVar, d10))) {
                    n s02 = kVar.s0();
                    try {
                        obj = vVar.a(gVar, e10);
                    } catch (Exception e12) {
                        obj = L(e12, gVar);
                    }
                    kVar.A0(obj);
                    while (s02 == n.FIELD_NAME) {
                        yVar.V0(kVar);
                        s02 = kVar.s0();
                    }
                    n nVar = n.END_OBJECT;
                    if (s02 != nVar) {
                        gVar.G0(this, nVar, "Attempted to unwrap '%s' value", handledType().getName());
                    }
                    yVar.W();
                    if (obj.getClass() == this.f8232a.q()) {
                        return this.f8249r.b(kVar, gVar, obj, yVar);
                    }
                    gVar.x0(d10, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
                    return null;
                }
            }
            n10 = kVar.s0();
        }
        try {
            return this.f8249r.b(kVar, gVar, vVar.a(gVar, e10), yVar);
        } catch (Exception e13) {
            L(e13, gVar);
            return null;
        }
    }

    public Object T(k kVar, g gVar) {
        if (this.f8237f != null) {
            return R(kVar, gVar);
        }
        k3.k kVar2 = this.f8235d;
        if (kVar2 != null) {
            return this.f8234c.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        return U(kVar, gVar, this.f8234c.x(gVar));
    }

    public Object U(k kVar, g gVar, Object obj) {
        return P(kVar, gVar, obj, this.f8250s.i());
    }

    public Object V(k kVar, g gVar) {
        Class cls;
        k3.k kVar2 = this.f8235d;
        if (kVar2 != null) {
            return this.f8234c.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        if (this.f8237f != null) {
            return S(kVar, gVar);
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.v0();
        Object x10 = this.f8234c.x(gVar);
        kVar.A0(x10);
        if (this.f8241j != null) {
            E(gVar, x10);
        }
        String str = null;
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        if (kVar.k0(5)) {
            str = kVar.m();
        }
        while (str != null) {
            kVar.s0();
            t k10 = this.f8240i.k(str);
            if (k10 != null) {
                if (cls == null || k10.H(cls)) {
                    try {
                        k10.l(kVar, gVar, x10);
                    } catch (Exception e10) {
                        K(e10, x10, str, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (m.c(str, this.f8243l, this.f8244m)) {
                A(kVar, gVar, x10, str);
            } else if (this.f8242k == null) {
                yVar.Z(str);
                yVar.V0(kVar);
            } else {
                d4.y Q0 = d4.y.Q0(kVar);
                yVar.Z(str);
                yVar.P0(Q0);
                try {
                    this.f8242k.c(Q0.U0(), gVar, x10, str);
                } catch (Exception e11) {
                    K(e11, x10, str, gVar);
                }
            }
            str = kVar.q0();
        }
        yVar.W();
        this.f8249r.b(kVar, gVar, x10, yVar);
        return x10;
    }

    public Object W(k kVar, g gVar, Object obj) {
        Class cls;
        n n10 = kVar.n();
        if (n10 == n.START_OBJECT) {
            n10 = kVar.s0();
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.v0();
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            t k10 = this.f8240i.k(m10);
            kVar.s0();
            if (k10 != null) {
                if (cls == null || k10.H(cls)) {
                    try {
                        k10.l(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (m.c(m10, this.f8243l, this.f8244m)) {
                A(kVar, gVar, obj, m10);
            } else if (this.f8242k == null) {
                yVar.Z(m10);
                yVar.V0(kVar);
            } else {
                d4.y Q0 = d4.y.Q0(kVar);
                yVar.Z(m10);
                yVar.P0(Q0);
                try {
                    this.f8242k.c(Q0.U0(), gVar, obj, m10);
                } catch (Exception e11) {
                    K(e11, obj, m10, gVar);
                }
            }
            n10 = kVar.s0();
        }
        yVar.W();
        this.f8249r.b(kVar, gVar, obj, yVar);
        return obj;
    }

    public final Object X(k kVar, g gVar, Object obj, Class cls) {
        if (kVar.k0(5)) {
            String m10 = kVar.m();
            do {
                kVar.s0();
                t k10 = this.f8240i.k(m10);
                if (k10 == null) {
                    D(kVar, gVar, obj, m10);
                } else if (!k10.H(cls)) {
                    kVar.D0();
                } else {
                    try {
                        k10.l(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                }
                m10 = kVar.q0();
            } while (m10 != null);
        }
        return obj;
    }

    public final b Y(g gVar, t tVar, y yVar, u uVar) {
        b bVar = new b(gVar, uVar, tVar.getType(), yVar, tVar);
        uVar.t().a(bVar);
        return bVar;
    }

    public final Object Z(k kVar, g gVar, n nVar) {
        Object x10 = this.f8234c.x(gVar);
        kVar.A0(x10);
        if (kVar.k0(5)) {
            String m10 = kVar.m();
            do {
                kVar.s0();
                t k10 = this.f8240i.k(m10);
                if (k10 != null) {
                    try {
                        k10.l(kVar, gVar, x10);
                    } catch (Exception e10) {
                        K(e10, x10, m10, gVar);
                    }
                } else {
                    D(kVar, gVar, x10, m10);
                }
                m10 = kVar.q0();
            } while (m10 != null);
        }
        return x10;
    }

    public Object _deserializeFromArray(k kVar, g gVar) {
        k3.k kVar2 = this.f8236e;
        if (kVar2 == null && (kVar2 = this.f8235d) == null) {
            m3.b _findCoercionFromEmptyArray = _findCoercionFromEmptyArray(gVar);
            boolean n02 = gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS);
            if (n02 || _findCoercionFromEmptyArray != m3.b.Fail) {
                n s02 = kVar.s0();
                n nVar = n.END_ARRAY;
                if (s02 == nVar) {
                    int i10 = a.f8227b[_findCoercionFromEmptyArray.ordinal()];
                    if (i10 == 1) {
                        return getEmptyValue(gVar);
                    }
                    if (i10 == 2 || i10 == 3) {
                        return getNullValue(gVar);
                    }
                    return gVar.d0(getValueType(gVar), n.START_ARRAY, kVar, (String) null, new Object[0]);
                } else if (n02) {
                    n s03 = kVar.s0();
                    n nVar2 = n.START_ARRAY;
                    if (s03 == nVar2) {
                        j valueType = getValueType(gVar);
                        return gVar.d0(valueType, nVar2, kVar, "Cannot deserialize value of type %s from deeply-nested JSON Array: only single wrapper allowed with `%s`", d4.h.G(valueType), "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS");
                    }
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
        return w10;
    }

    /* renamed from: a0 */
    public c H(Set set, Set set2) {
        return new c(this, set, set2);
    }

    /* renamed from: b0 */
    public c J(s sVar) {
        return new c((d) this, sVar);
    }

    public Object c(k kVar, g gVar) {
        Class cls;
        Object obj;
        Object obj2;
        v vVar = this.f8237f;
        y e10 = vVar.e(kVar, gVar, this.f8251t);
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        n n10 = kVar.n();
        ArrayList<b> arrayList = null;
        d4.y yVar = null;
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 == null) {
                    t k10 = this.f8240i.k(m10);
                    if (k10 != null) {
                        try {
                            e10.e(k10, O(kVar, gVar, k10));
                        } catch (u e11) {
                            b Y = Y(gVar, k10, e10, e11);
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(Y);
                        }
                    } else if (m.c(m10, this.f8243l, this.f8244m)) {
                        A(kVar, gVar, handledType(), m10);
                    } else {
                        s sVar = this.f8242k;
                        if (sVar != null) {
                            try {
                                e10.c(sVar, m10, sVar.b(kVar, gVar));
                            } catch (Exception e12) {
                                K(e12, this.f8232a.q(), m10, gVar);
                            }
                        } else {
                            if (yVar == null) {
                                yVar = new d4.y(kVar, gVar);
                            }
                            yVar.Z(m10);
                            yVar.V0(kVar);
                        }
                    }
                } else if (cls != null && !d10.H(cls)) {
                    kVar.D0();
                } else if (e10.b(d10, O(kVar, gVar, d10))) {
                    kVar.s0();
                    try {
                        obj2 = vVar.a(gVar, e10);
                    } catch (Exception e13) {
                        obj2 = L(e13, gVar);
                    }
                    if (obj2 == null) {
                        return gVar.V(handledType(), (Object) null, M());
                    }
                    kVar.A0(obj2);
                    if (obj2.getClass() != this.f8232a.q()) {
                        return B(kVar, gVar, obj2, yVar);
                    }
                    if (yVar != null) {
                        obj2 = C(gVar, obj2, yVar);
                    }
                    return deserialize(kVar, gVar, obj2);
                }
            }
            n10 = kVar.s0();
        }
        try {
            obj = vVar.a(gVar, e10);
        } catch (Exception e14) {
            L(e14, gVar);
            obj = null;
        }
        if (this.f8241j != null) {
            E(gVar, obj);
        }
        if (arrayList != null) {
            for (b c10 : arrayList) {
                c10.c(obj);
            }
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
        if (!kVar.o0()) {
            return N(kVar, gVar, kVar.n());
        }
        if (this.f8239h) {
            return Z(kVar, gVar, kVar.s0());
        }
        kVar.s0();
        if (this.f8251t != null) {
            return w(kVar, gVar);
        }
        return s(kVar, gVar);
    }

    public d n() {
        return new o3.b(this, this.f8240i.m());
    }

    public Object s(k kVar, g gVar) {
        Class J;
        Object U;
        s sVar = this.f8251t;
        if (sVar != null && sVar.e() && kVar.k0(5) && this.f8251t.d(kVar.m(), kVar)) {
            return t(kVar, gVar);
        }
        if (!this.f8238g) {
            Object x10 = this.f8234c.x(gVar);
            kVar.A0(x10);
            if (kVar.c() && (U = kVar.U()) != null) {
                h(kVar, gVar, x10, U);
            }
            if (this.f8241j != null) {
                E(gVar, x10);
            }
            if (this.f8246o && (J = gVar.J()) != null) {
                return X(kVar, gVar, x10, J);
            }
            if (kVar.k0(5)) {
                String m10 = kVar.m();
                do {
                    kVar.s0();
                    t k10 = this.f8240i.k(m10);
                    if (k10 != null) {
                        try {
                            k10.l(kVar, gVar, x10);
                        } catch (Exception e10) {
                            K(e10, x10, m10, gVar);
                        }
                    } else {
                        D(kVar, gVar, x10, m10);
                    }
                    m10 = kVar.q0();
                } while (m10 != null);
            }
            return x10;
        } else if (this.f8249r != null) {
            return V(kVar, gVar);
        } else {
            if (this.f8250s != null) {
                return T(kVar, gVar);
            }
            return u(kVar, gVar);
        }
    }

    public k3.k unwrappingDeserializer(q qVar) {
        if (getClass() != c.class || this.f8225w == qVar) {
            return this;
        }
        this.f8225w = qVar;
        try {
            return new c((d) this, qVar);
        } finally {
            this.f8225w = null;
        }
    }

    public c(d dVar) {
        super(dVar, dVar.f8245n);
    }

    public c(d dVar, boolean z10) {
        super(dVar, z10);
    }

    public c(d dVar, q qVar) {
        super(dVar, qVar);
    }

    public c(d dVar, s sVar) {
        super(dVar, sVar);
    }

    public c(d dVar, Set set, Set set2) {
        super(dVar, set, set2);
    }

    public c(d dVar, o3.c cVar) {
        super(dVar, cVar);
    }

    public Object deserialize(k kVar, g gVar, Object obj) {
        String str;
        Class J;
        kVar.A0(obj);
        if (this.f8241j != null) {
            E(gVar, obj);
        }
        if (this.f8249r != null) {
            return W(kVar, gVar, obj);
        }
        if (this.f8250s != null) {
            return U(kVar, gVar, obj);
        }
        if (kVar.o0()) {
            str = kVar.q0();
            if (str == null) {
                return obj;
            }
        } else if (!kVar.k0(5)) {
            return obj;
        } else {
            str = kVar.m();
        }
        if (this.f8246o && (J = gVar.J()) != null) {
            return X(kVar, gVar, obj, J);
        }
        do {
            kVar.s0();
            t k10 = this.f8240i.k(str);
            if (k10 != null) {
                try {
                    k10.l(kVar, gVar, obj);
                } catch (Exception e10) {
                    K(e10, obj, str, gVar);
                }
            } else {
                D(kVar, gVar, obj, str);
            }
            str = kVar.q0();
        } while (str != null);
        return obj;
    }
}
