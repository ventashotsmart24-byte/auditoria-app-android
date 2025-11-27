package n3;

import b3.e0;
import b3.k;
import b3.k0;
import b3.n0;
import b3.o0;
import b3.p;
import c3.k;
import c3.l;
import c3.n;
import com.fasterxml.jackson.databind.deser.std.b0;
import d4.m;
import d4.q;
import d4.y;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.b;
import k3.d;
import k3.f;
import k3.h;
import k3.j;
import k3.w;
import k3.x;
import o3.a0;
import o3.c;
import o3.d0;
import o3.e0;
import o3.g;
import o3.s;
import o3.t;
import o3.u;
import o3.v;
import o3.w;
import o3.z;
import p3.a;
import r3.i;
import w3.e;

public abstract class d extends b0 implements i, r {

    /* renamed from: u  reason: collision with root package name */
    public static final x f8231u = new x("#temporary-name");

    /* renamed from: a  reason: collision with root package name */
    public final j f8232a;

    /* renamed from: b  reason: collision with root package name */
    public final k.c f8233b;

    /* renamed from: c  reason: collision with root package name */
    public final w f8234c;

    /* renamed from: d  reason: collision with root package name */
    public k3.k f8235d;

    /* renamed from: e  reason: collision with root package name */
    public k3.k f8236e;

    /* renamed from: f  reason: collision with root package name */
    public v f8237f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8238g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8239h;

    /* renamed from: i  reason: collision with root package name */
    public final c f8240i;

    /* renamed from: j  reason: collision with root package name */
    public final e0[] f8241j;

    /* renamed from: k  reason: collision with root package name */
    public s f8242k;

    /* renamed from: l  reason: collision with root package name */
    public final Set f8243l;

    /* renamed from: m  reason: collision with root package name */
    public final Set f8244m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f8245n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f8246o;

    /* renamed from: p  reason: collision with root package name */
    public final Map f8247p;

    /* renamed from: q  reason: collision with root package name */
    public transient HashMap f8248q;

    /* renamed from: r  reason: collision with root package name */
    public d0 f8249r;

    /* renamed from: s  reason: collision with root package name */
    public g f8250s;

    /* renamed from: t  reason: collision with root package name */
    public final s f8251t;

    public d(e eVar, k3.c cVar, c cVar2, Map map, Set set, boolean z10, Set set2, boolean z11) {
        super(cVar.z());
        this.f8232a = cVar.z();
        w t10 = eVar.t();
        this.f8234c = t10;
        this.f8235d = null;
        this.f8236e = null;
        this.f8237f = null;
        this.f8240i = cVar2;
        this.f8247p = map;
        this.f8243l = set;
        this.f8245n = z10;
        this.f8244m = set2;
        this.f8242k = eVar.p();
        List r10 = eVar.r();
        e0[] e0VarArr = (r10 == null || r10.isEmpty()) ? null : (e0[]) r10.toArray(new e0[r10.size()]);
        this.f8241j = e0VarArr;
        s s10 = eVar.s();
        this.f8251t = s10;
        boolean z12 = false;
        this.f8238g = this.f8249r != null || t10.k() || t10.g() || !t10.j();
        this.f8233b = cVar.g((k.d) null).i();
        this.f8246o = z11;
        if (!this.f8238g && e0VarArr == null && !z11 && s10 == null) {
            z12 = true;
        }
        this.f8239h = z12;
    }

    public void A(c3.k kVar, k3.g gVar, Object obj, String str) {
        if (!gVar.n0(h.FAIL_ON_IGNORED_PROPERTIES)) {
            kVar.D0();
            return;
        }
        throw a.v(kVar, obj, str, getKnownPropertyNames());
    }

    public Object B(c3.k kVar, k3.g gVar, Object obj, y yVar) {
        k3.k f10 = f(gVar, obj, yVar);
        if (f10 != null) {
            if (yVar != null) {
                yVar.W();
                c3.k R0 = yVar.R0();
                R0.s0();
                obj = f10.deserialize(R0, gVar, obj);
            }
            if (kVar != null) {
                return f10.deserialize(kVar, gVar, obj);
            }
            return obj;
        }
        if (yVar != null) {
            obj = C(gVar, obj, yVar);
        }
        if (kVar != null) {
            return deserialize(kVar, gVar, obj);
        }
        return obj;
    }

    public Object C(k3.g gVar, Object obj, y yVar) {
        yVar.W();
        c3.k R0 = yVar.R0();
        while (R0.s0() != n.END_OBJECT) {
            String m10 = R0.m();
            R0.s0();
            handleUnknownProperty(R0, gVar, obj, m10);
        }
        return obj;
    }

    public void D(c3.k kVar, k3.g gVar, Object obj, String str) {
        if (m.c(str, this.f8243l, this.f8244m)) {
            A(kVar, gVar, obj, str);
            return;
        }
        s sVar = this.f8242k;
        if (sVar != null) {
            try {
                sVar.c(kVar, gVar, obj, str);
            } catch (Exception e10) {
                K(e10, obj, str, gVar);
            }
        } else {
            handleUnknownProperty(kVar, gVar, obj, str);
        }
    }

    public void E(k3.g gVar, Object obj) {
        for (e0 g10 : this.f8241j) {
            g10.g(gVar, obj);
        }
    }

    public final Throwable F(Throwable th, k3.g gVar) {
        boolean z10;
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        d4.h.h0(th);
        if (gVar == null || gVar.n0(h.WRAP_EXCEPTIONS)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (th instanceof IOException) {
            if (!z10 || !(th instanceof l)) {
                throw ((IOException) th);
            }
        } else if (!z10) {
            d4.h.j0(th);
        }
        return th;
    }

    public abstract d G(c cVar);

    public abstract d H(Set set, Set set2);

    public abstract d I(boolean z10);

    public abstract d J(s sVar);

    public void K(Throwable th, Object obj, String str, k3.g gVar) {
        throw k3.l.q(F(th, gVar), obj, str);
    }

    public Object L(Throwable th, k3.g gVar) {
        boolean z10;
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        d4.h.h0(th);
        if (!(th instanceof IOException)) {
            if (gVar == null || gVar.n0(h.WRAP_EXCEPTIONS)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                d4.h.j0(th);
            }
            return gVar.V(this.f8232a.q(), (Object) null, th);
        }
        throw ((IOException) th);
    }

    public Object a(c3.k kVar, k3.g gVar, Object obj, k3.k kVar2) {
        y yVar = new y(kVar, gVar);
        if (obj instanceof String) {
            yVar.z0((String) obj);
        } else if (obj instanceof Long) {
            yVar.e0(((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            yVar.d0(((Integer) obj).intValue());
        } else {
            yVar.a1(obj);
        }
        c3.k R0 = yVar.R0();
        R0.s0();
        return kVar2.deserialize(R0, gVar);
    }

    public final k3.k b() {
        k3.k kVar = this.f8235d;
        if (kVar == null) {
            return this.f8236e;
        }
        return kVar;
    }

    public abstract Object c(c3.k kVar, k3.g gVar);

    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        i iVar;
        d dVar2;
        c cVar;
        c t10;
        r3.b0 B;
        t tVar;
        w wVar;
        j jVar;
        s sVar = this.f8251t;
        b K = gVar.K();
        k.c cVar2 = null;
        if (b0._neitherNull(dVar, K)) {
            iVar = dVar.d();
        } else {
            iVar = null;
        }
        if (!(iVar == null || (B = K.B(iVar)) == null)) {
            r3.b0 C = K.C(iVar, B);
            Class<n0> c10 = C.c();
            gVar.o(iVar, C);
            if (c10 == n0.class) {
                x d10 = C.d();
                t z10 = z(d10);
                if (z10 == null) {
                    gVar.q(this.f8232a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[]{d4.h.X(handledType()), d4.h.V(d10)}));
                }
                jVar = z10.getType();
                tVar = z10;
                wVar = new w(C.f());
            } else {
                jVar = gVar.l().K(gVar.x(c10), k0.class)[0];
                tVar = null;
                wVar = gVar.n(iVar, C);
            }
            j jVar2 = jVar;
            sVar = s.a(jVar2, C.d(), wVar, gVar.I(jVar2), tVar, (o0) null);
        }
        if (sVar == null || sVar == this.f8251t) {
            dVar2 = this;
        } else {
            dVar2 = J(sVar);
        }
        if (iVar != null) {
            dVar2 = g(gVar, K, dVar2, iVar);
        }
        k.d findFormatOverrides = findFormatOverrides(gVar, dVar, handledType());
        if (findFormatOverrides != null) {
            if (findFormatOverrides.n()) {
                cVar2 = findFormatOverrides.i();
            }
            Boolean e10 = findFormatOverrides.e(k.a.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
            if (!(e10 == null || (t10 = cVar.t(e10.booleanValue())) == (cVar = this.f8240i))) {
                dVar2 = dVar2.G(t10);
            }
        }
        if (cVar2 == null) {
            cVar2 = this.f8233b;
        }
        if (cVar2 == k.c.ARRAY) {
            return dVar2.n();
        }
        return dVar2;
    }

    public final k3.k d(k3.g gVar, j jVar, r3.n nVar) {
        k3.k kVar;
        d.a aVar = new d.a(f8231u, jVar, (x) null, nVar, k3.w.f7486i);
        e eVar = (e) jVar.t();
        if (eVar == null) {
            eVar = gVar.k().Z(jVar);
        }
        k3.k kVar2 = (k3.k) jVar.u();
        if (kVar2 == null) {
            kVar = findDeserializer(gVar, jVar, aVar);
        } else {
            kVar = gVar.Z(kVar2, aVar, jVar);
        }
        if (eVar != null) {
            return new o3.b0(eVar.g(aVar), kVar);
        }
        return kVar;
    }

    public Object deserializeWithType(c3.k kVar, k3.g gVar, e eVar) {
        Object U;
        if (this.f8251t != null) {
            if (kVar.c() && (U = kVar.U()) != null) {
                return h(kVar, gVar, eVar.e(kVar, gVar), U);
            }
            n n10 = kVar.n();
            if (n10 != null) {
                if (n10.e()) {
                    return t(kVar, gVar);
                }
                if (n10 == n.START_OBJECT) {
                    n10 = kVar.s0();
                }
                if (n10 == n.FIELD_NAME && this.f8251t.e() && this.f8251t.d(kVar.m(), kVar)) {
                    return t(kVar, gVar);
                }
            }
        }
        return eVar.e(kVar, gVar);
    }

    public q e(k3.g gVar, t tVar) {
        q d02;
        i d10 = tVar.d();
        if (d10 == null || (d02 = gVar.K().d0(d10)) == null) {
            return null;
        }
        if (tVar instanceof j) {
            gVar.q(getValueType(), String.format("Cannot define Creator property \"%s\" as `@JsonUnwrapped`: combination not yet supported", new Object[]{tVar.getName()}));
        }
        return d02;
    }

    public k3.k f(k3.g gVar, Object obj, y yVar) {
        k3.k kVar;
        synchronized (this) {
            HashMap hashMap = this.f8248q;
            if (hashMap == null) {
                kVar = null;
            } else {
                kVar = (k3.k) hashMap.get(new c4.b(obj.getClass()));
            }
        }
        if (kVar != null) {
            return kVar;
        }
        k3.k I = gVar.I(gVar.x(obj.getClass()));
        if (I != null) {
            synchronized (this) {
                if (this.f8248q == null) {
                    this.f8248q = new HashMap();
                }
                this.f8248q.put(new c4.b(obj.getClass()), I);
            }
        }
        return I;
    }

    public t findBackReference(String str) {
        Map map = this.f8247p;
        if (map == null) {
            return null;
        }
        return (t) map.get(str);
    }

    public d g(k3.g gVar, b bVar, d dVar, i iVar) {
        f N = gVar.k();
        p.a K = bVar.K(N, iVar);
        if (K.j() && !this.f8245n) {
            dVar = dVar.I(true);
        }
        Set g10 = K.g();
        Set set = dVar.f8243l;
        if (g10.isEmpty()) {
            g10 = set;
        } else if (set != null && !set.isEmpty()) {
            HashSet hashSet = new HashSet(set);
            hashSet.addAll(g10);
            g10 = hashSet;
        }
        Set set2 = dVar.f8244m;
        Set b10 = m.b(set2, bVar.N(N, iVar).e());
        if (g10 == set && b10 == set2) {
            return dVar;
        }
        return dVar.H(g10, b10);
    }

    public d4.a getEmptyAccessPattern() {
        return d4.a.DYNAMIC;
    }

    public Object getEmptyValue(k3.g gVar) {
        try {
            return this.f8234c.x(gVar);
        } catch (IOException e10) {
            return d4.h.g0(gVar, e10);
        }
    }

    public Collection getKnownPropertyNames() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f8240i.iterator();
        while (it.hasNext()) {
            arrayList.add(((t) it.next()).getName());
        }
        return arrayList;
    }

    public d4.a getNullAccessPattern() {
        return d4.a.ALWAYS_NULL;
    }

    public s getObjectIdReader() {
        return this.f8251t;
    }

    public w getValueInstantiator() {
        return this.f8234c;
    }

    public j getValueType() {
        return this.f8232a;
    }

    public Object h(c3.k kVar, k3.g gVar, Object obj, Object obj2) {
        k3.k b10 = this.f8251t.b();
        if (b10.handledType() != obj2.getClass()) {
            obj2 = a(kVar, gVar, obj2, b10);
        }
        s sVar = this.f8251t;
        k0 k0Var = sVar.f8536c;
        sVar.getClass();
        gVar.H(obj2, k0Var, (o0) null).b(obj);
        t tVar = this.f8251t.f8538e;
        if (tVar != null) {
            return tVar.D(obj, obj2);
        }
        return obj;
    }

    public void handleUnknownProperty(c3.k kVar, k3.g gVar, Object obj, String str) {
        if (this.f8245n) {
            kVar.D0();
            return;
        }
        if (m.c(str, this.f8243l, this.f8244m)) {
            A(kVar, gVar, obj, str);
        }
        super.handleUnknownProperty(kVar, gVar, obj, str);
    }

    public Class handledType() {
        return this.f8232a.q();
    }

    public void i(c cVar, t[] tVarArr, t tVar, t tVar2) {
        cVar.s(tVar, tVar2);
        if (tVarArr != null) {
            int length = tVarArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (tVarArr[i10] == tVar) {
                    tVarArr[i10] = tVar2;
                    return;
                }
            }
        }
    }

    public boolean isCachable() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = r11.getType().q();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n3.t j(k3.g r10, n3.t r11) {
        /*
            r9 = this;
            k3.k r0 = r11.u()
            boolean r1 = r0 instanceof n3.d
            if (r1 == 0) goto L_0x005d
            n3.d r0 = (n3.d) r0
            n3.w r0 = r0.getValueInstantiator()
            boolean r0 = r0.j()
            if (r0 != 0) goto L_0x005d
            k3.j r0 = r11.getType()
            java.lang.Class r0 = r0.q()
            java.lang.Class r1 = d4.h.E(r0)
            if (r1 == 0) goto L_0x005d
            k3.j r2 = r9.f8232a
            java.lang.Class r2 = r2.q()
            if (r1 != r2) goto L_0x005d
            java.lang.reflect.Constructor[] r0 = r0.getConstructors()
            int r2 = r0.length
            r3 = 0
            r4 = 0
        L_0x0031:
            if (r4 >= r2) goto L_0x005d
            r5 = r0[r4]
            java.lang.Class[] r6 = r5.getParameterTypes()
            int r7 = r6.length
            r8 = 1
            if (r7 != r8) goto L_0x005a
            r6 = r6[r3]
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x005a
            boolean r0 = r10.u()
            if (r0 == 0) goto L_0x0054
            k3.q r0 = k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS
            boolean r10 = r10.o0(r0)
            d4.h.g(r5, r10)
        L_0x0054:
            o3.j r10 = new o3.j
            r10.<init>(r11, r5)
            return r10
        L_0x005a:
            int r4 = r4 + 1
            goto L_0x0031
        L_0x005d:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.d.j(k3.g, n3.t):n3.t");
    }

    public t k(k3.g gVar, t tVar) {
        String r10 = tVar.r();
        if (r10 == null) {
            return tVar;
        }
        t findBackReference = tVar.u().findBackReference(r10);
        if (findBackReference == null) {
            gVar.q(this.f8232a, String.format("Cannot handle managed/back reference %s: no back reference property found from type %s", new Object[]{d4.h.U(r10), d4.h.G(tVar.getType())}));
        }
        j jVar = this.f8232a;
        j type = findBackReference.getType();
        boolean D = tVar.getType().D();
        if (!type.q().isAssignableFrom(jVar.q())) {
            gVar.q(this.f8232a, String.format("Cannot handle managed/back reference %s: back reference type (%s) not compatible with managed type (%s)", new Object[]{d4.h.U(r10), d4.h.G(type), jVar.q().getName()}));
        }
        return new o3.m(tVar, r10, findBackReference, D);
    }

    public t l(k3.g gVar, t tVar, k3.w wVar) {
        w.a d10 = wVar.d();
        if (d10 != null) {
            k3.k u10 = tVar.u();
            Boolean supportsUpdate = u10.supportsUpdate(gVar.k());
            if (supportsUpdate == null) {
                if (d10.f7496b) {
                    return tVar;
                }
            } else if (!supportsUpdate.booleanValue()) {
                if (!d10.f7496b) {
                    gVar.U(u10);
                }
                return tVar;
            }
            i iVar = d10.f7495a;
            iVar.i(gVar.o0(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            if (!(tVar instanceof a0)) {
                tVar = o3.n.O(tVar, iVar);
            }
        }
        q findValueNullProvider = findValueNullProvider(gVar, tVar, wVar);
        if (findValueNullProvider != null) {
            return tVar.J(findValueNullProvider);
        }
        return tVar;
    }

    public c4.f logicalType() {
        return c4.f.POJO;
    }

    public t m(k3.g gVar, t tVar) {
        s sVar;
        r3.b0 t10 = tVar.t();
        k3.k u10 = tVar.u();
        if (u10 == null) {
            sVar = null;
        } else {
            sVar = u10.getObjectIdReader();
        }
        if (t10 == null && sVar == null) {
            return tVar;
        }
        return new t(tVar, t10);
    }

    public abstract d n();

    public Object o(c3.k kVar, k3.g gVar) {
        boolean z10;
        k3.k b10 = b();
        if (b10 == null || this.f8234c.c()) {
            if (kVar.n() == n.VALUE_TRUE) {
                z10 = true;
            } else {
                z10 = false;
            }
            return this.f8234c.p(gVar, z10);
        }
        Object y10 = this.f8234c.y(gVar, b10.deserialize(kVar, gVar));
        if (this.f8241j != null) {
            E(gVar, y10);
        }
        return y10;
    }

    public Object p(c3.k kVar, k3.g gVar) {
        k.b R = kVar.R();
        if (R == k.b.DOUBLE || R == k.b.FLOAT) {
            k3.k b10 = b();
            if (b10 == null || this.f8234c.d()) {
                return this.f8234c.q(gVar, kVar.M());
            }
            Object y10 = this.f8234c.y(gVar, b10.deserialize(kVar, gVar));
            if (this.f8241j != null) {
                E(gVar, y10);
            }
            return y10;
        } else if (R == k.b.BIG_DECIMAL) {
            k3.k b11 = b();
            if (b11 == null || this.f8234c.a()) {
                return this.f8234c.n(gVar, kVar.L());
            }
            Object y11 = this.f8234c.y(gVar, b11.deserialize(kVar, gVar));
            if (this.f8241j != null) {
                E(gVar, y11);
            }
            return y11;
        } else {
            return gVar.W(handledType(), getValueInstantiator(), kVar, "no suitable creator method found to deserialize from Number value (%s)", kVar.S());
        }
    }

    public Object q(c3.k kVar, k3.g gVar) {
        if (this.f8251t != null) {
            return t(kVar, gVar);
        }
        k3.k b10 = b();
        if (b10 == null || this.f8234c.h()) {
            Object N = kVar.N();
            if (N == null || this.f8232a.O(N.getClass())) {
                return N;
            }
            return gVar.h0(this.f8232a, N, kVar);
        }
        Object y10 = this.f8234c.y(gVar, b10.deserialize(kVar, gVar));
        if (this.f8241j != null) {
            E(gVar, y10);
        }
        return y10;
    }

    public Object r(c3.k kVar, k3.g gVar) {
        if (this.f8251t != null) {
            return t(kVar, gVar);
        }
        k3.k b10 = b();
        k.b R = kVar.R();
        if (R == k.b.INT) {
            if (b10 == null || this.f8234c.e()) {
                return this.f8234c.r(gVar, kVar.P());
            }
            Object y10 = this.f8234c.y(gVar, b10.deserialize(kVar, gVar));
            if (this.f8241j != null) {
                E(gVar, y10);
            }
            return y10;
        } else if (R == k.b.LONG) {
            if (b10 == null || this.f8234c.e()) {
                return this.f8234c.s(gVar, kVar.Q());
            }
            Object y11 = this.f8234c.y(gVar, b10.deserialize(kVar, gVar));
            if (this.f8241j != null) {
                E(gVar, y11);
            }
            return y11;
        } else if (R != k.b.BIG_INTEGER) {
            return gVar.W(handledType(), getValueInstantiator(), kVar, "no suitable creator method found to deserialize from Number value (%s)", kVar.S());
        } else if (b10 == null || this.f8234c.b()) {
            return this.f8234c.o(gVar, kVar.s());
        } else {
            Object y12 = this.f8234c.y(gVar, b10.deserialize(kVar, gVar));
            if (this.f8241j != null) {
                E(gVar, y12);
            }
            return y12;
        }
    }

    public void resolve(k3.g gVar) {
        t[] tVarArr;
        k3.k u10;
        k3.k unwrappingDeserializer;
        boolean z10 = false;
        g.a aVar = null;
        if (this.f8234c.g()) {
            tVarArr = this.f8234c.E(gVar.k());
            if (!(this.f8243l == null && this.f8244m == null)) {
                int length = tVarArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    if (m.c(tVarArr[i10].getName(), this.f8243l, this.f8244m)) {
                        tVarArr[i10].B();
                    }
                }
            }
        } else {
            tVarArr = null;
        }
        Iterator it = this.f8240i.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (!tVar.w()) {
                k3.k x10 = x(gVar, tVar);
                if (x10 == null) {
                    x10 = gVar.G(tVar.getType());
                }
                i(this.f8240i, tVarArr, tVar, tVar.L(x10));
            }
        }
        Iterator it2 = this.f8240i.iterator();
        d0 d0Var = null;
        while (it2.hasNext()) {
            t tVar2 = (t) it2.next();
            t k10 = k(gVar, tVar2.L(gVar.Y(tVar2.u(), tVar2, tVar2.getType())));
            if (!(k10 instanceof o3.m)) {
                k10 = m(gVar, k10);
            }
            q e10 = e(gVar, k10);
            if (e10 == null || (unwrappingDeserializer = u10.unwrappingDeserializer(e10)) == (u10 = k10.u()) || unwrappingDeserializer == null) {
                t j10 = j(gVar, l(gVar, k10, k10.getMetadata()));
                if (j10 != tVar2) {
                    i(this.f8240i, tVarArr, tVar2, j10);
                }
                if (j10.x()) {
                    e v10 = j10.v();
                    if (v10.k() == e0.a.EXTERNAL_PROPERTY) {
                        if (aVar == null) {
                            aVar = g.d(this.f8232a);
                        }
                        aVar.b(j10, v10);
                        this.f8240i.q(j10);
                    }
                }
            } else {
                t L = k10.L(unwrappingDeserializer);
                if (d0Var == null) {
                    d0Var = new d0();
                }
                d0Var.a(L);
                this.f8240i.q(L);
            }
        }
        s sVar = this.f8242k;
        if (sVar != null && !sVar.h()) {
            s sVar2 = this.f8242k;
            this.f8242k = sVar2.j(findDeserializer(gVar, sVar2.g(), this.f8242k.f()));
        }
        if (this.f8234c.k()) {
            j D = this.f8234c.D(gVar.k());
            if (D == null) {
                j jVar = this.f8232a;
                gVar.q(jVar, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{d4.h.G(jVar), d4.h.h(this.f8234c)}));
            }
            this.f8235d = d(gVar, D, this.f8234c.C());
        }
        if (this.f8234c.i()) {
            j A = this.f8234c.A(gVar.k());
            if (A == null) {
                j jVar2 = this.f8232a;
                gVar.q(jVar2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{d4.h.G(jVar2), d4.h.h(this.f8234c)}));
            }
            this.f8236e = d(gVar, A, this.f8234c.z());
        }
        if (tVarArr != null) {
            this.f8237f = v.b(gVar, this.f8234c, tVarArr, this.f8240i);
        }
        if (aVar != null) {
            this.f8250s = aVar.c(this.f8240i);
            this.f8238g = true;
        }
        this.f8249r = d0Var;
        if (d0Var != null) {
            this.f8238g = true;
        }
        if (this.f8239h && !this.f8238g) {
            z10 = true;
        }
        this.f8239h = z10;
    }

    public abstract Object s(c3.k kVar, k3.g gVar);

    public Boolean supportsUpdate(f fVar) {
        return Boolean.TRUE;
    }

    public Object t(c3.k kVar, k3.g gVar) {
        Object f10 = this.f8251t.f(kVar, gVar);
        s sVar = this.f8251t;
        k0 k0Var = sVar.f8536c;
        sVar.getClass();
        z H = gVar.H(f10, k0Var, (o0) null);
        Object f11 = H.f();
        if (f11 != null) {
            return f11;
        }
        throw new u(kVar, "Could not resolve Object Id [" + f10 + "] (for " + this.f8232a + ").", kVar.z(), H);
    }

    public Object u(c3.k kVar, k3.g gVar) {
        k3.k b10 = b();
        if (b10 != null) {
            Object y10 = this.f8234c.y(gVar, b10.deserialize(kVar, gVar));
            if (this.f8241j != null) {
                E(gVar, y10);
            }
            return y10;
        } else if (this.f8237f != null) {
            return c(kVar, gVar);
        } else {
            Class q10 = this.f8232a.q();
            if (d4.h.Q(q10)) {
                return gVar.W(q10, (w) null, kVar, "non-static inner classes like this can only by instantiated using default, no-argument constructor", new Object[0]);
            }
            return gVar.W(q10, getValueInstantiator(), kVar, "cannot deserialize from Object value (no delegate- or property-based Creator)", new Object[0]);
        }
    }

    public abstract k3.k unwrappingDeserializer(q qVar);

    public Object v(c3.k kVar, k3.g gVar) {
        if (this.f8251t != null) {
            return t(kVar, gVar);
        }
        k3.k b10 = b();
        if (b10 == null || this.f8234c.h()) {
            return _deserializeFromString(kVar, gVar);
        }
        Object y10 = this.f8234c.y(gVar, b10.deserialize(kVar, gVar));
        if (this.f8241j != null) {
            E(gVar, y10);
        }
        return y10;
    }

    public Object w(c3.k kVar, k3.g gVar) {
        return s(kVar, gVar);
    }

    public k3.k x(k3.g gVar, t tVar) {
        Object l10;
        b K = gVar.K();
        if (K == null || (l10 = K.l(tVar.d())) == null) {
            return null;
        }
        d4.j j10 = gVar.j(tVar.d(), l10);
        j b10 = j10.b(gVar.l());
        return new com.fasterxml.jackson.databind.deser.std.a0(j10, b10, gVar.G(b10));
    }

    public t y(String str) {
        t tVar;
        v vVar;
        c cVar = this.f8240i;
        if (cVar == null) {
            tVar = null;
        } else {
            tVar = cVar.k(str);
        }
        if (tVar != null || (vVar = this.f8237f) == null) {
            return tVar;
        }
        return vVar.d(str);
    }

    public t z(x xVar) {
        return y(xVar.c());
    }

    public d(d dVar) {
        this(dVar, dVar.f8245n);
    }

    public d(d dVar, boolean z10) {
        super(dVar.f8232a);
        this.f8232a = dVar.f8232a;
        this.f8234c = dVar.f8234c;
        this.f8235d = dVar.f8235d;
        this.f8236e = dVar.f8236e;
        this.f8237f = dVar.f8237f;
        this.f8240i = dVar.f8240i;
        this.f8247p = dVar.f8247p;
        this.f8243l = dVar.f8243l;
        this.f8245n = z10;
        this.f8244m = dVar.f8244m;
        this.f8242k = dVar.f8242k;
        this.f8241j = dVar.f8241j;
        this.f8251t = dVar.f8251t;
        this.f8238g = dVar.f8238g;
        this.f8249r = dVar.f8249r;
        this.f8246o = dVar.f8246o;
        this.f8233b = dVar.f8233b;
        this.f8239h = dVar.f8239h;
    }

    public d(d dVar, q qVar) {
        super(dVar.f8232a);
        this.f8232a = dVar.f8232a;
        this.f8234c = dVar.f8234c;
        this.f8235d = dVar.f8235d;
        this.f8236e = dVar.f8236e;
        this.f8237f = dVar.f8237f;
        this.f8247p = dVar.f8247p;
        this.f8243l = dVar.f8243l;
        this.f8245n = qVar != null || dVar.f8245n;
        this.f8244m = dVar.f8244m;
        this.f8242k = dVar.f8242k;
        this.f8241j = dVar.f8241j;
        this.f8251t = dVar.f8251t;
        this.f8238g = dVar.f8238g;
        d0 d0Var = dVar.f8249r;
        if (qVar != null) {
            d0Var = d0Var != null ? d0Var.c(qVar) : d0Var;
            this.f8240i = dVar.f8240i.r(qVar);
        } else {
            this.f8240i = dVar.f8240i;
        }
        this.f8249r = d0Var;
        this.f8246o = dVar.f8246o;
        this.f8233b = dVar.f8233b;
        this.f8239h = false;
    }

    public d(d dVar, s sVar) {
        super(dVar.f8232a);
        this.f8232a = dVar.f8232a;
        this.f8234c = dVar.f8234c;
        this.f8235d = dVar.f8235d;
        this.f8236e = dVar.f8236e;
        this.f8237f = dVar.f8237f;
        this.f8247p = dVar.f8247p;
        this.f8243l = dVar.f8243l;
        this.f8245n = dVar.f8245n;
        this.f8244m = dVar.f8244m;
        this.f8242k = dVar.f8242k;
        this.f8241j = dVar.f8241j;
        this.f8238g = dVar.f8238g;
        this.f8249r = dVar.f8249r;
        this.f8246o = dVar.f8246o;
        this.f8233b = dVar.f8233b;
        this.f8251t = sVar;
        if (sVar == null) {
            this.f8240i = dVar.f8240i;
            this.f8239h = dVar.f8239h;
            return;
        }
        this.f8240i = dVar.f8240i.u(new u(sVar, k3.w.f7485h));
        this.f8239h = false;
    }

    public d(d dVar, Set set, Set set2) {
        super(dVar.f8232a);
        this.f8232a = dVar.f8232a;
        this.f8234c = dVar.f8234c;
        this.f8235d = dVar.f8235d;
        this.f8236e = dVar.f8236e;
        this.f8237f = dVar.f8237f;
        this.f8247p = dVar.f8247p;
        this.f8243l = set;
        this.f8245n = dVar.f8245n;
        this.f8244m = set2;
        this.f8242k = dVar.f8242k;
        this.f8241j = dVar.f8241j;
        this.f8238g = dVar.f8238g;
        this.f8249r = dVar.f8249r;
        this.f8246o = dVar.f8246o;
        this.f8233b = dVar.f8233b;
        this.f8239h = dVar.f8239h;
        this.f8251t = dVar.f8251t;
        this.f8240i = dVar.f8240i.v(set, set2);
    }

    public d(d dVar, c cVar) {
        super(dVar.f8232a);
        this.f8232a = dVar.f8232a;
        this.f8234c = dVar.f8234c;
        this.f8235d = dVar.f8235d;
        this.f8236e = dVar.f8236e;
        this.f8237f = dVar.f8237f;
        this.f8240i = cVar;
        this.f8247p = dVar.f8247p;
        this.f8243l = dVar.f8243l;
        this.f8245n = dVar.f8245n;
        this.f8244m = dVar.f8244m;
        this.f8242k = dVar.f8242k;
        this.f8241j = dVar.f8241j;
        this.f8251t = dVar.f8251t;
        this.f8238g = dVar.f8238g;
        this.f8249r = dVar.f8249r;
        this.f8246o = dVar.f8246o;
        this.f8233b = dVar.f8233b;
        this.f8239h = dVar.f8239h;
    }
}
