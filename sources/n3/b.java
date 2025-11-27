package n3;

import b3.b;
import b3.b0;
import b3.h;
import b3.j0;
import c4.h;
import c4.o;
import com.fasterxml.jackson.databind.deser.std.g0;
import com.fasterxml.jackson.databind.deser.std.i0;
import com.fasterxml.jackson.databind.deser.std.k0;
import com.fasterxml.jackson.databind.deser.std.m0;
import com.fasterxml.jackson.databind.deser.std.r;
import com.fasterxml.jackson.databind.deser.std.t;
import com.fasterxml.jackson.databind.deser.std.v;
import d4.y;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;
import k3.d;
import k3.f;
import k3.g;
import k3.j;
import k3.p;
import k3.q;
import k3.w;
import k3.x;
import m3.k;
import o3.d;
import o3.e;
import o3.l;
import r3.d0;
import r3.h0;
import r3.i;
import r3.m;
import r3.n;
import r3.s;

public abstract class b extends n implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Class f8203c = Object.class;

    /* renamed from: d  reason: collision with root package name */
    public static final Class f8204d = String.class;

    /* renamed from: e  reason: collision with root package name */
    public static final Class f8205e = CharSequence.class;

    /* renamed from: f  reason: collision with root package name */
    public static final Class f8206f = Iterable.class;

    /* renamed from: g  reason: collision with root package name */
    public static final Class f8207g = Map.Entry.class;

    /* renamed from: h  reason: collision with root package name */
    public static final Class f8208h = Serializable.class;

    /* renamed from: i  reason: collision with root package name */
    public static final x f8209i = new x("@JsonUnwrapped");

    /* renamed from: b  reason: collision with root package name */
    public final k f8210b;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8211a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f8212b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        static {
            /*
                m3.i$a[] r0 = m3.i.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8212b = r0
                r1 = 1
                m3.i$a r2 = m3.i.a.DELEGATING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8212b     // Catch:{ NoSuchFieldError -> 0x001d }
                m3.i$a r3 = m3.i.a.PROPERTIES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8212b     // Catch:{ NoSuchFieldError -> 0x0028 }
                m3.i$a r4 = m3.i.a.REQUIRE_MODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f8212b     // Catch:{ NoSuchFieldError -> 0x0033 }
                m3.i$a r4 = m3.i.a.HEURISTIC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                b3.h$a[] r3 = b3.h.a.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f8211a = r3
                b3.h$a r4 = b3.h.a.DELEGATING     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f8211a     // Catch:{ NoSuchFieldError -> 0x004e }
                b3.h$a r3 = b3.h.a.PROPERTIES     // Catch:{ NoSuchFieldError -> 0x004e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f8211a     // Catch:{ NoSuchFieldError -> 0x0058 }
                b3.h$a r1 = b3.h.a.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n3.b.a.<clinit>():void");
        }
    }

    /* renamed from: n3.b$b  reason: collision with other inner class name */
    public static class C0107b {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap f8213a;

        /* renamed from: b  reason: collision with root package name */
        public static final HashMap f8214b;

        static {
            HashMap hashMap = new HashMap();
            Class<ArrayList> cls = ArrayList.class;
            hashMap.put(Collection.class.getName(), cls);
            hashMap.put(List.class.getName(), cls);
            Class<HashSet> cls2 = HashSet.class;
            hashMap.put(Set.class.getName(), cls2);
            Class<TreeSet> cls3 = TreeSet.class;
            hashMap.put(SortedSet.class.getName(), cls3);
            Class<LinkedList> cls4 = LinkedList.class;
            hashMap.put(Queue.class.getName(), cls4);
            hashMap.put(AbstractList.class.getName(), cls);
            hashMap.put(AbstractSet.class.getName(), cls2);
            hashMap.put(Deque.class.getName(), cls4);
            hashMap.put(NavigableSet.class.getName(), cls3);
            f8213a = hashMap;
            HashMap hashMap2 = new HashMap();
            Class<LinkedHashMap> cls5 = LinkedHashMap.class;
            hashMap2.put(Map.class.getName(), cls5);
            hashMap2.put(AbstractMap.class.getName(), cls5);
            hashMap2.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            Class<TreeMap> cls6 = TreeMap.class;
            hashMap2.put(SortedMap.class.getName(), cls6);
            hashMap2.put(NavigableMap.class.getName(), cls6);
            hashMap2.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            f8214b = hashMap2;
        }

        public static Class a(j jVar) {
            return (Class) f8213a.get(jVar.q().getName());
        }

        public static Class b(j jVar) {
            return (Class) f8214b.get(jVar.q().getName());
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final g f8215a;

        /* renamed from: b  reason: collision with root package name */
        public final k3.c f8216b;

        /* renamed from: c  reason: collision with root package name */
        public final h0 f8217c;

        /* renamed from: d  reason: collision with root package name */
        public final e f8218d;

        /* renamed from: e  reason: collision with root package name */
        public final Map f8219e;

        /* renamed from: f  reason: collision with root package name */
        public List f8220f;

        /* renamed from: g  reason: collision with root package name */
        public int f8221g;

        /* renamed from: h  reason: collision with root package name */
        public List f8222h;

        /* renamed from: i  reason: collision with root package name */
        public int f8223i;

        public c(g gVar, k3.c cVar, h0 h0Var, e eVar, Map map) {
            this.f8215a = gVar;
            this.f8216b = cVar;
            this.f8217c = h0Var;
            this.f8218d = eVar;
            this.f8219e = map;
        }

        public void a(d dVar) {
            if (this.f8222h == null) {
                this.f8222h = new LinkedList();
            }
            this.f8222h.add(dVar);
        }

        public void b(d dVar) {
            if (this.f8220f == null) {
                this.f8220f = new LinkedList();
            }
            this.f8220f.add(dVar);
        }

        public k3.b c() {
            return this.f8215a.K();
        }

        public boolean d() {
            if (this.f8223i > 0) {
                return true;
            }
            return false;
        }

        public boolean e() {
            if (this.f8221g > 0) {
                return true;
            }
            return false;
        }

        public boolean f() {
            if (this.f8222h != null) {
                return true;
            }
            return false;
        }

        public boolean g() {
            if (this.f8220f != null) {
                return true;
            }
            return false;
        }

        public List h() {
            return this.f8222h;
        }

        public List i() {
            return this.f8220f;
        }

        public void j() {
            this.f8223i++;
        }

        public void k() {
            this.f8221g++;
        }
    }

    public b(k kVar) {
        this.f8210b = kVar;
    }

    public Map A(g gVar, k3.c cVar) {
        Map emptyMap = Collections.emptyMap();
        for (s sVar : cVar.o()) {
            Iterator n10 = sVar.n();
            while (n10.hasNext()) {
                m mVar = (m) n10.next();
                n r10 = mVar.r();
                s[] sVarArr = (s[]) emptyMap.get(r10);
                int q10 = mVar.q();
                if (sVarArr == null) {
                    if (emptyMap.isEmpty()) {
                        emptyMap = new LinkedHashMap();
                    }
                    sVarArr = new s[r10.v()];
                    emptyMap.put(r10, sVarArr);
                } else if (sVarArr[q10] != null) {
                    gVar.v0(cVar, "Conflict: parameter #%d of %s bound to more than one property; %s vs %s", Integer.valueOf(q10), r10, sVarArr[q10], sVar);
                }
                sVarArr[q10] = sVar;
            }
        }
        return emptyMap;
    }

    public k3.k B(c4.a aVar, f fVar, k3.c cVar, w3.e eVar, k3.k kVar) {
        for (o g10 : this.f8210b.c()) {
            k3.k g11 = g10.g(aVar, fVar, cVar, eVar, kVar);
            if (g11 != null) {
                return g11;
            }
        }
        return null;
    }

    public k3.k C(j jVar, f fVar, k3.c cVar) {
        for (o a10 : this.f8210b.c()) {
            k3.k a11 = a10.a(jVar, fVar, cVar);
            if (a11 != null) {
                return a11;
            }
        }
        return null;
    }

    public k3.k D(c4.e eVar, f fVar, k3.c cVar, w3.e eVar2, k3.k kVar) {
        for (o h10 : this.f8210b.c()) {
            k3.k h11 = h10.h(eVar, fVar, cVar, eVar2, kVar);
            if (h11 != null) {
                return h11;
            }
        }
        return null;
    }

    public k3.k E(c4.d dVar, f fVar, k3.c cVar, w3.e eVar, k3.k kVar) {
        for (o e10 : this.f8210b.c()) {
            k3.k e11 = e10.e(dVar, fVar, cVar, eVar, kVar);
            if (e11 != null) {
                return e11;
            }
        }
        return null;
    }

    public k3.k F(Class cls, f fVar, k3.c cVar) {
        for (o d10 : this.f8210b.c()) {
            k3.k d11 = d10.d(cls, fVar, cVar);
            if (d11 != null) {
                return d11;
            }
        }
        return null;
    }

    public k3.k G(h hVar, f fVar, k3.c cVar, p pVar, w3.e eVar, k3.k kVar) {
        for (o c10 : this.f8210b.c()) {
            k3.k c11 = c10.c(hVar, fVar, cVar, pVar, eVar, kVar);
            if (c11 != null) {
                return c11;
            }
        }
        return null;
    }

    public k3.k H(c4.g gVar, f fVar, k3.c cVar, p pVar, w3.e eVar, k3.k kVar) {
        for (o i10 : this.f8210b.c()) {
            k3.k i11 = i10.i(gVar, fVar, cVar, pVar, eVar, kVar);
            if (i11 != null) {
                return i11;
            }
        }
        return null;
    }

    public k3.k I(c4.j jVar, f fVar, k3.c cVar, w3.e eVar, k3.k kVar) {
        for (o b10 : this.f8210b.c()) {
            k3.k b11 = b10.b(jVar, fVar, cVar, eVar, kVar);
            if (b11 != null) {
                return b11;
            }
        }
        return null;
    }

    public k3.k J(Class cls, f fVar, k3.c cVar) {
        for (o f10 : this.f8210b.c()) {
            k3.k f11 = f10.f(cls, fVar, cVar);
            if (f11 != null) {
                return f11;
            }
        }
        return null;
    }

    public final x K(m mVar, k3.b bVar) {
        if (bVar == null) {
            return null;
        }
        x x10 = bVar.x(mVar);
        if (x10 != null && !x10.h()) {
            return x10;
        }
        String r10 = bVar.r(mVar);
        if (r10 == null || r10.isEmpty()) {
            return null;
        }
        return x.a(r10);
    }

    public j L(f fVar, Class cls) {
        j m10 = m(fVar, fVar.e(cls));
        if (m10 == null || m10.y(cls)) {
            return null;
        }
        return m10;
    }

    public w M(g gVar, k3.d dVar, w wVar) {
        j0 j0Var;
        b0.a Z;
        k3.b K = gVar.K();
        f N = gVar.k();
        i d10 = dVar.d();
        j0 j0Var2 = null;
        if (d10 != null) {
            if (K == null || (Z = K.Z(d10)) == null) {
                j0Var = null;
            } else {
                j0Var2 = Z.f();
                j0Var = Z.e();
            }
            b0.a h10 = N.j(dVar.getType().q()).h();
            if (h10 != null) {
                if (j0Var2 == null) {
                    j0Var2 = h10.f();
                }
                if (j0Var == null) {
                    j0Var = h10.e();
                }
            }
        } else {
            j0Var = null;
        }
        b0.a r10 = N.r();
        if (j0Var2 == null) {
            j0Var2 = r10.f();
        }
        if (j0Var == null) {
            j0Var = r10.e();
        }
        if (j0Var2 == null && j0Var == null) {
            return wVar;
        }
        return wVar.j(j0Var2, j0Var);
    }

    public boolean N(e eVar, n nVar, boolean z10, boolean z11) {
        Class<BigDecimal> x10 = nVar.x(0);
        if (x10 == String.class || x10 == f8205e) {
            if (z10 || z11) {
                eVar.m(nVar, z10);
            }
            return true;
        } else if (x10 == Integer.TYPE || x10 == Integer.class) {
            if (z10 || z11) {
                eVar.j(nVar, z10);
            }
            return true;
        } else if (x10 == Long.TYPE || x10 == Long.class) {
            if (z10 || z11) {
                eVar.k(nVar, z10);
            }
            return true;
        } else if (x10 == Double.TYPE || x10 == Double.class) {
            if (z10 || z11) {
                eVar.i(nVar, z10);
            }
            return true;
        } else if (x10 == Boolean.TYPE || x10 == Boolean.class) {
            if (z10 || z11) {
                eVar.g(nVar, z10);
            }
            return true;
        } else {
            if (x10 == BigInteger.class && (z10 || z11)) {
                eVar.f(nVar, z10);
            }
            if (x10 == BigDecimal.class && (z10 || z11)) {
                eVar.e(nVar, z10);
            }
            if (!z10) {
                return false;
            }
            eVar.h(nVar, z10, (t[]) null, 0);
            return true;
        }
    }

    public boolean O(g gVar, r3.b bVar) {
        h.a h10;
        k3.b K = gVar.K();
        if (K == null || (h10 = K.h(gVar.k(), bVar)) == null || h10 == h.a.DISABLED) {
            return false;
        }
        return true;
    }

    public c4.e P(j jVar, f fVar) {
        Class a10 = C0107b.a(jVar);
        if (a10 != null) {
            return (c4.e) fVar.z().G(jVar, a10, true);
        }
        return null;
    }

    public c4.h Q(j jVar, f fVar) {
        Class b10 = C0107b.b(jVar);
        if (b10 != null) {
            return (c4.h) fVar.z().G(jVar, b10, true);
        }
        return null;
    }

    public final j R(f fVar, j jVar) {
        jVar.q();
        if (this.f8210b.d()) {
            Iterator it = this.f8210b.a().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return null;
    }

    public void S(g gVar, k3.c cVar, m mVar) {
        gVar.v0(cVar, "Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", Integer.valueOf(mVar.q()));
    }

    public void T(g gVar, k3.c cVar, d dVar, int i10, x xVar, b.a aVar) {
        if (xVar == null && aVar == null) {
            gVar.v0(cVar, "Argument #%d of constructor %s has no property name (and is not Injectable): can not use as property-based Creator", Integer.valueOf(i10), dVar);
        }
    }

    public w U(f fVar, r3.b bVar, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof w) {
            return (w) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (d4.h.J(cls)) {
                return null;
            }
            if (w.class.isAssignableFrom(cls)) {
                fVar.u();
                return (w) d4.h.l(cls, fVar.b());
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<ValueInstantiator>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
    }

    public t V(g gVar, k3.c cVar, x xVar, int i10, m mVar, b.a aVar) {
        w wVar;
        g gVar2 = gVar;
        m mVar2 = mVar;
        f N = gVar.k();
        k3.b K = gVar.K();
        if (K == null) {
            wVar = w.f7487j;
        } else {
            wVar = w.a(K.p0(mVar2), K.J(mVar2), K.O(mVar2), K.I(mVar2));
        }
        w wVar2 = wVar;
        j f02 = f0(gVar, mVar2, mVar.f());
        d.a aVar2 = new d.a(xVar, f02, K.g0(mVar2), mVar, wVar2);
        w3.e eVar = (w3.e) f02.t();
        if (eVar == null) {
            eVar = l(N, f02);
        }
        w M = M(gVar, aVar2, wVar2);
        x e10 = aVar2.e();
        j O = j.O(xVar, f02, e10, eVar, cVar.t(), mVar, i10, aVar, M);
        k3.k Z = Z(gVar, mVar2);
        if (Z == null) {
            Z = (k3.k) f02.u();
        }
        if (Z != null) {
            return O.L(gVar.Y(Z, O, f02));
        }
        return O;
    }

    public d4.k W(Class cls, f fVar, i iVar) {
        if (iVar == null) {
            return d4.k.h(fVar, cls);
        }
        if (fVar.b()) {
            d4.h.g(iVar.m(), fVar.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return d4.k.j(fVar, cls, iVar);
    }

    public k3.k X(g gVar, r3.b bVar) {
        Object f10;
        k3.b K = gVar.K();
        if (K == null || (f10 = K.f(bVar)) == null) {
            return null;
        }
        return gVar.y(bVar, f10);
    }

    public k3.k Y(g gVar, j jVar, k3.c cVar) {
        j jVar2;
        j jVar3;
        j jVar4;
        Class<y> q10 = jVar.q();
        if (q10 == f8203c || q10 == f8208h) {
            f N = gVar.k();
            if (this.f8210b.d()) {
                jVar2 = L(N, List.class);
                jVar3 = L(N, Map.class);
            } else {
                jVar2 = null;
                jVar3 = null;
            }
            return new m0(jVar2, jVar3);
        } else if (q10 == f8204d || q10 == f8205e) {
            return i0.f5627a;
        } else {
            Class<y> cls = f8206f;
            if (q10 == cls) {
                o l10 = gVar.l();
                j[] K = l10.K(jVar, cls);
                if (K == null || K.length != 1) {
                    jVar4 = o.O();
                } else {
                    jVar4 = K[0];
                }
                return d(gVar, l10.z(Collection.class, jVar4), cVar);
            } else if (q10 == f8207g) {
                j h10 = jVar.h(0);
                j h11 = jVar.h(1);
                w3.e eVar = (w3.e) h11.t();
                if (eVar == null) {
                    eVar = l(gVar.k(), h11);
                }
                return new t(jVar, (p) h10.u(), (k3.k) h11.u(), eVar);
            } else {
                String name = q10.getName();
                if (q10.isPrimitive() || name.startsWith("java.")) {
                    k3.k a10 = v.a(q10, name);
                    if (a10 == null) {
                        a10 = com.fasterxml.jackson.databind.deser.std.j.a(q10, name);
                    }
                    if (a10 != null) {
                        return a10;
                    }
                }
                if (q10 == y.class) {
                    return new k0();
                }
                k3.k b02 = b0(gVar, jVar, cVar);
                if (b02 != null) {
                    return b02;
                }
                return com.fasterxml.jackson.databind.deser.std.p.a(q10, name);
            }
        }
    }

    public k3.k Z(g gVar, r3.b bVar) {
        Object m10;
        k3.b K = gVar.K();
        if (K == null || (m10 = K.m(bVar)) == null) {
            return null;
        }
        return gVar.y(bVar, m10);
    }

    public k3.k a(g gVar, c4.a aVar, k3.c cVar) {
        f N = gVar.k();
        j k10 = aVar.k();
        k3.k kVar = (k3.k) k10.u();
        w3.e eVar = (w3.e) k10.t();
        if (eVar == null) {
            eVar = l(N, k10);
        }
        w3.e eVar2 = eVar;
        k3.k B = B(aVar, N, cVar, eVar2, kVar);
        if (B == null) {
            if (kVar == null) {
                Class<String> q10 = k10.q();
                if (k10.K()) {
                    return com.fasterxml.jackson.databind.deser.std.x.c(q10);
                }
                if (q10 == String.class) {
                    return g0.f5606f;
                }
            }
            B = new com.fasterxml.jackson.databind.deser.std.w(aVar, kVar, eVar2);
        }
        if (this.f8210b.e()) {
            Iterator it = this.f8210b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return B;
    }

    public p a0(g gVar, r3.b bVar) {
        Object u10;
        k3.b K = gVar.K();
        if (K == null || (u10 = K.u(bVar)) == null) {
            return null;
        }
        return gVar.p0(bVar, u10);
    }

    public k3.k b0(g gVar, j jVar, k3.c cVar) {
        return q3.e.f8937e.b(jVar, gVar.k(), cVar);
    }

    public w3.e c0(f fVar, j jVar, i iVar) {
        w3.g H = fVar.g().H(fVar, iVar, jVar);
        j k10 = jVar.k();
        if (H == null) {
            return l(fVar, k10);
        }
        return H.e(fVar, k10, fVar.T().d(fVar, iVar, k10));
    }

    public k3.k d(g gVar, c4.e eVar, k3.c cVar) {
        j k10 = eVar.k();
        k3.k kVar = (k3.k) k10.u();
        f N = gVar.k();
        w3.e eVar2 = (w3.e) k10.t();
        if (eVar2 == null) {
            eVar2 = l(N, k10);
        }
        w3.e eVar3 = eVar2;
        k3.k D = D(eVar, N, cVar, eVar3, kVar);
        if (D == null) {
            Class q10 = eVar.q();
            if (kVar == null && EnumSet.class.isAssignableFrom(q10)) {
                D = new com.fasterxml.jackson.databind.deser.std.m(k10, (k3.k) null);
            }
        }
        if (D == null) {
            if (eVar.H() || eVar.z()) {
                c4.e P = P(eVar, N);
                if (P != null) {
                    cVar = N.i0(P);
                    eVar = P;
                } else if (eVar.t() != null) {
                    D = a.c(cVar);
                } else {
                    throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Collection type " + eVar);
                }
            }
            if (D == null) {
                w e02 = e0(gVar, cVar);
                if (!e02.j()) {
                    if (eVar.y(ArrayBlockingQueue.class)) {
                        return new com.fasterxml.jackson.databind.deser.std.a(eVar, kVar, eVar3, e02);
                    }
                    k3.k d10 = l.d(gVar, eVar);
                    if (d10 != null) {
                        return d10;
                    }
                }
                if (k10.y(String.class)) {
                    D = new com.fasterxml.jackson.databind.deser.std.h0(eVar, kVar, e02);
                } else {
                    D = new com.fasterxml.jackson.databind.deser.std.h(eVar, kVar, eVar3, e02);
                }
            }
        }
        if (this.f8210b.e()) {
            Iterator it = this.f8210b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return D;
    }

    public w3.e d0(f fVar, j jVar, i iVar) {
        w3.g P = fVar.g().P(fVar, iVar, jVar);
        if (P == null) {
            return l(fVar, jVar);
        }
        try {
            return P.e(fVar, jVar, fVar.T().d(fVar, iVar, jVar));
        } catch (IllegalArgumentException | IllegalStateException e10) {
            p3.b v10 = p3.b.v((c3.k) null, d4.h.o(e10), jVar);
            v10.initCause(e10);
            throw v10;
        }
    }

    public k3.k e(g gVar, c4.d dVar, k3.c cVar) {
        j k10 = dVar.k();
        k3.k kVar = (k3.k) k10.u();
        f N = gVar.k();
        w3.e eVar = (w3.e) k10.t();
        if (eVar == null) {
            eVar = l(N, k10);
        }
        k3.k E = E(dVar, N, cVar, eVar, kVar);
        if (E != null && this.f8210b.e()) {
            Iterator it = this.f8210b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return E;
    }

    public w e0(g gVar, k3.c cVar) {
        w wVar;
        f N = gVar.k();
        r3.c u10 = cVar.u();
        Object e02 = gVar.K().e0(u10);
        if (e02 != null) {
            wVar = U(N, u10, e02);
        } else {
            wVar = null;
        }
        if (wVar == null && (wVar = o3.k.a(N, cVar.s())) == null) {
            wVar = y(gVar, cVar);
        }
        if (this.f8210b.g()) {
            Iterator it = this.f8210b.i().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        if (wVar != null) {
            return wVar.m(gVar, cVar);
        }
        return wVar;
    }

    public k3.k f(g gVar, j jVar, k3.c cVar) {
        t[] tVarArr;
        f N = gVar.k();
        Class<Enum> q10 = jVar.q();
        k3.k F = F(q10, N, cVar);
        if (F == null) {
            if (q10 == Enum.class) {
                return a.c(cVar);
            }
            w y10 = y(gVar, cVar);
            if (y10 == null) {
                tVarArr = null;
            } else {
                tVarArr = y10.E(gVar.k());
            }
            Iterator it = cVar.w().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                r3.j jVar2 = (r3.j) it.next();
                if (O(gVar, jVar2)) {
                    if (jVar2.v() == 0) {
                        F = com.fasterxml.jackson.databind.deser.std.k.h(N, q10, jVar2);
                    } else {
                        if (!jVar2.D().isAssignableFrom(q10)) {
                            gVar.q(jVar, String.format("Invalid `@JsonCreator` annotated Enum factory method [%s]: needs to return compatible type", new Object[]{jVar2.toString()}));
                        }
                        F = com.fasterxml.jackson.databind.deser.std.k.g(N, q10, jVar2, y10, tVarArr);
                    }
                }
            }
            if (F == null) {
                F = new com.fasterxml.jackson.databind.deser.std.k(W(q10, N, cVar.k()), Boolean.valueOf(N.D(q.ACCEPT_CASE_INSENSITIVE_ENUMS)));
            }
        }
        if (this.f8210b.e()) {
            Iterator it2 = this.f8210b.b().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        return F;
    }

    public j f0(g gVar, i iVar, j jVar) {
        p p02;
        k3.b K = gVar.K();
        if (K == null) {
            return jVar;
        }
        if (!(!jVar.J() || jVar.p() == null || (p02 = gVar.p0(iVar, K.u(iVar))) == null)) {
            jVar = ((c4.g) jVar).c0(p02);
            jVar.p();
        }
        if (jVar.v()) {
            k3.k y10 = gVar.y(iVar, K.f(iVar));
            if (y10 != null) {
                jVar = jVar.T(y10);
            }
            w3.e c02 = c0(gVar.k(), jVar, iVar);
            if (c02 != null) {
                jVar = jVar.S(c02);
            }
        }
        w3.e d02 = d0(gVar.k(), jVar, iVar);
        if (d02 != null) {
            jVar = jVar.W(d02);
        }
        return K.u0(gVar.k(), iVar, jVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001c A[LOOP:0: B:3:0x001c->B:6:0x002c, LOOP_START, PHI: r4 
      PHI: (r4v7 k3.p) = (r4v6 k3.p), (r4v10 k3.p) binds: [B:2:0x000d, B:6:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.p g(k3.g r7, k3.j r8) {
        /*
            r6 = this;
            k3.f r0 = r7.k()
            m3.k r1 = r6.f8210b
            boolean r1 = r1.f()
            r2 = 0
            if (r1 == 0) goto L_0x002f
            k3.c r1 = r0.B(r8)
            m3.k r3 = r6.f8210b
            java.lang.Iterable r3 = r3.h()
            java.util.Iterator r3 = r3.iterator()
            r4 = r2
        L_0x001c:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0031
            java.lang.Object r4 = r3.next()
            n3.p r4 = (n3.p) r4
            k3.p r4 = r4.a(r8, r0, r1)
            if (r4 == 0) goto L_0x001c
            goto L_0x0031
        L_0x002f:
            r1 = r2
            r4 = r1
        L_0x0031:
            if (r4 != 0) goto L_0x0056
            if (r1 != 0) goto L_0x003d
            java.lang.Class r1 = r8.q()
            k3.c r1 = r0.A(r1)
        L_0x003d:
            r3.c r1 = r1.u()
            k3.p r4 = r6.a0(r7, r1)
            if (r4 != 0) goto L_0x0056
            boolean r1 = r8.F()
            if (r1 == 0) goto L_0x0052
            k3.p r4 = r6.z(r7, r8)
            goto L_0x0056
        L_0x0052:
            k3.p r4 = com.fasterxml.jackson.databind.deser.std.d0.e(r0, r8)
        L_0x0056:
            if (r4 == 0) goto L_0x0079
            m3.k r7 = r6.f8210b
            boolean r7 = r7.e()
            if (r7 == 0) goto L_0x0079
            m3.k r7 = r6.f8210b
            java.lang.Iterable r7 = r7.b()
            java.util.Iterator r7 = r7.iterator()
            boolean r8 = r7.hasNext()
            if (r8 != 0) goto L_0x0071
            goto L_0x0079
        L_0x0071:
            java.lang.Object r7 = r7.next()
            androidx.appcompat.app.m.a(r7)
            throw r2
        L_0x0079:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.b.g(k3.g, k3.j):k3.p");
    }

    public abstract n g0(k kVar);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: k3.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: k3.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: k3.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: com.fasterxml.jackson.databind.deser.std.s} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: com.fasterxml.jackson.databind.deser.std.s} */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.k h(k3.g r20, c4.h r21, k3.c r22) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            k3.f r10 = r20.k()
            k3.j r11 = r21.p()
            k3.j r0 = r21.k()
            java.lang.Object r1 = r0.u()
            r16 = r1
            k3.k r16 = (k3.k) r16
            java.lang.Object r1 = r11.u()
            r15 = r1
            k3.p r15 = (k3.p) r15
            java.lang.Object r1 = r0.t()
            w3.e r1 = (w3.e) r1
            if (r1 != 0) goto L_0x0030
            w3.e r0 = r7.l(r10, r0)
            r17 = r0
            goto L_0x0032
        L_0x0030:
            r17 = r1
        L_0x0032:
            r0 = r19
            r1 = r21
            r2 = r10
            r3 = r22
            r4 = r15
            r5 = r17
            r6 = r16
            k3.k r0 = r0.G(r1, r2, r3, r4, r5, r6)
            r18 = 0
            if (r0 != 0) goto L_0x0105
            java.lang.Class r1 = r21.q()
            java.lang.Class<java.util.EnumMap> r2 = java.util.EnumMap.class
            boolean r3 = r2.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x007d
            if (r1 != r2) goto L_0x0059
            r12 = r22
            r2 = r18
            goto L_0x0060
        L_0x0059:
            r12 = r22
            n3.w r0 = r7.e0(r8, r12)
            r2 = r0
        L_0x0060:
            boolean r0 = r11.E()
            if (r0 == 0) goto L_0x0075
            com.fasterxml.jackson.databind.deser.std.l r11 = new com.fasterxml.jackson.databind.deser.std.l
            r3 = 0
            r6 = 0
            r0 = r11
            r1 = r21
            r4 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x007f
        L_0x0075:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot construct EnumMap; generic (key) type not available"
            r0.<init>(r1)
            throw r0
        L_0x007d:
            r12 = r22
        L_0x007f:
            if (r0 != 0) goto L_0x0105
            boolean r1 = r21.H()
            if (r1 != 0) goto L_0x0099
            boolean r1 = r21.z()
            if (r1 == 0) goto L_0x008e
            goto L_0x0099
        L_0x008e:
            k3.k r0 = o3.l.e(r20, r21)
            if (r0 == 0) goto L_0x0095
            return r0
        L_0x0095:
            r1 = r0
            r13 = r9
        L_0x0097:
            r0 = r12
            goto L_0x00b6
        L_0x0099:
            c4.h r1 = r7.Q(r9, r10)
            if (r1 == 0) goto L_0x00a8
            r1.q()
            k3.c r2 = r10.i0(r1)
            r12 = r2
            goto L_0x00b3
        L_0x00a8:
            java.lang.Object r0 = r21.t()
            if (r0 == 0) goto L_0x00ee
            n3.a r0 = n3.a.c(r22)
            r1 = r9
        L_0x00b3:
            r13 = r1
            r1 = r0
            goto L_0x0097
        L_0x00b6:
            if (r1 != 0) goto L_0x00ec
            n3.w r14 = r7.e0(r8, r0)
            com.fasterxml.jackson.databind.deser.std.s r1 = new com.fasterxml.jackson.databind.deser.std.s
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r3.c r2 = r0.u()
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            b3.p$a r2 = r10.O(r3, r2)
            if (r2 != 0) goto L_0x00d1
            r2 = r18
            goto L_0x00d5
        L_0x00d1:
            java.util.Set r2 = r2.g()
        L_0x00d5:
            r1.m(r2)
            r3.c r0 = r0.u()
            b3.s$a r0 = r10.Q(r3, r0)
            if (r0 != 0) goto L_0x00e5
            r0 = r18
            goto L_0x00e9
        L_0x00e5:
            java.util.Set r0 = r0.e()
        L_0x00e9:
            r1.n(r0)
        L_0x00ec:
            r0 = r1
            goto L_0x0105
        L_0x00ee:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot find a deserializer for non-concrete Map type "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0105:
            m3.k r1 = r7.f8210b
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0126
            m3.k r1 = r7.f8210b
            java.lang.Iterable r1 = r1.b()
            java.util.Iterator r1 = r1.iterator()
            boolean r2 = r1.hasNext()
            if (r2 != 0) goto L_0x011e
            goto L_0x0126
        L_0x011e:
            java.lang.Object r0 = r1.next()
            androidx.appcompat.app.m.a(r0)
            throw r18
        L_0x0126:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.b.h(k3.g, c4.h, k3.c):k3.k");
    }

    public k3.k i(g gVar, c4.g gVar2, k3.c cVar) {
        j p10 = gVar2.p();
        j k10 = gVar2.k();
        f N = gVar.k();
        k3.k kVar = (k3.k) k10.u();
        p pVar = (p) p10.u();
        w3.e eVar = (w3.e) k10.t();
        if (eVar == null) {
            eVar = l(N, k10);
        }
        k3.k H = H(gVar2, N, cVar, pVar, eVar, kVar);
        if (H != null && this.f8210b.e()) {
            Iterator it = this.f8210b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return H;
    }

    public k3.k j(g gVar, c4.j jVar, k3.c cVar) {
        j k10 = jVar.k();
        k3.k kVar = (k3.k) k10.u();
        f N = gVar.k();
        w3.e eVar = (w3.e) k10.t();
        if (eVar == null) {
            eVar = l(N, k10);
        }
        w3.e eVar2 = eVar;
        k3.k I = I(jVar, N, cVar, eVar2, kVar);
        w wVar = null;
        if (I == null) {
            Class<AtomicReference> cls = AtomicReference.class;
            if (jVar.N(cls)) {
                if (jVar.q() != cls) {
                    wVar = e0(gVar, cVar);
                }
                return new com.fasterxml.jackson.databind.deser.std.e(jVar, wVar, eVar2, kVar);
            }
        }
        if (I != null && this.f8210b.e()) {
            Iterator it = this.f8210b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return I;
    }

    public k3.k k(f fVar, j jVar, k3.c cVar) {
        Class q10 = jVar.q();
        k3.k J = J(q10, fVar, cVar);
        if (J != null) {
            return J;
        }
        return r.l(q10);
    }

    public w3.e l(f fVar, j jVar) {
        Collection collection;
        j m10;
        r3.c u10 = fVar.A(jVar.q()).u();
        w3.g c02 = fVar.g().c0(fVar, u10, jVar);
        if (c02 == null) {
            c02 = fVar.s(jVar);
            if (c02 == null) {
                return null;
            }
            collection = null;
        } else {
            collection = fVar.T().c(fVar, u10);
        }
        if (c02.g() == null && jVar.z() && (m10 = m(fVar, jVar)) != null && !m10.y(jVar.q())) {
            c02 = c02.d(m10.q());
        }
        try {
            return c02.e(fVar, jVar, collection);
        } catch (IllegalArgumentException | IllegalStateException e10) {
            p3.b v10 = p3.b.v((c3.k) null, d4.h.o(e10), jVar);
            v10.initCause(e10);
            throw v10;
        }
    }

    public j m(f fVar, j jVar) {
        j R;
        while (true) {
            R = R(fVar, jVar);
            if (R == null) {
                return jVar;
            }
            Class q10 = jVar.q();
            Class q11 = R.q();
            if (q10 == q11 || !q10.isAssignableFrom(q11)) {
            } else {
                jVar = R;
            }
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + jVar + " to " + R + ": latter is not a subtype of former");
    }

    public final n n(o oVar) {
        return g0(this.f8210b.j(oVar));
    }

    public void o(g gVar, k3.c cVar, e eVar, o3.d dVar, m3.i iVar) {
        x xVar;
        boolean z10;
        int e10;
        e eVar2 = eVar;
        o3.d dVar2 = dVar;
        if (1 == dVar.g()) {
            m i10 = dVar2.i(0);
            b.a f10 = dVar2.f(0);
            int i11 = a.f8212b[iVar.e().ordinal()];
            if (i11 == 1) {
                g gVar2 = gVar;
                k3.c cVar2 = cVar;
                xVar = null;
                z10 = false;
            } else if (i11 == 2) {
                g gVar3 = gVar;
                k3.c cVar3 = cVar;
                x h10 = dVar2.h(0);
                if (h10 == null) {
                    T(gVar, cVar, dVar, 0, h10, f10);
                }
                xVar = h10;
                z10 = true;
            } else if (i11 != 3) {
                s j10 = dVar2.j(0);
                x c10 = dVar2.c(0);
                if (c10 == null && f10 == null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!z10 && j10 != null) {
                    c10 = dVar2.h(0);
                    if (c10 == null || !j10.f()) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                }
                g gVar4 = gVar;
                k3.c cVar4 = cVar;
                xVar = c10;
            } else {
                gVar.v0(cVar, "Single-argument constructor (%s) is annotated but no 'mode' defined; `CreatorDetector`configured with `SingleArgConstructor.REQUIRE_MODE`", dVar.b());
                return;
            }
            if (z10) {
                eVar2.l(dVar.b(), true, new t[]{V(gVar, cVar, xVar, 0, i10, f10)});
                return;
            }
            N(eVar2, dVar.b(), true, true);
            s j11 = dVar2.j(0);
            if (j11 != null) {
                ((d0) j11).l0();
            }
        } else if (iVar.d() || (e10 = dVar.e()) < 0 || (!iVar.c() && dVar2.h(e10) != null)) {
            s(gVar, cVar, eVar, dVar);
        } else {
            q(gVar, cVar, eVar, dVar);
        }
    }

    public void p(g gVar, c cVar, boolean z10) {
        k3.c cVar2 = cVar.f8216b;
        e eVar = cVar.f8218d;
        k3.b c10 = cVar.c();
        h0 h0Var = cVar.f8217c;
        Map map = cVar.f8219e;
        r3.e d10 = cVar2.d();
        if (d10 != null && (!eVar.o() || O(gVar, d10))) {
            eVar.r(d10);
        }
        for (r3.e eVar2 : cVar2.v()) {
            h.a h10 = c10.h(gVar.k(), eVar2);
            if (h.a.DISABLED != h10) {
                if (h10 != null) {
                    int i10 = a.f8211a[h10.ordinal()];
                    if (i10 == 1) {
                        q(gVar, cVar2, eVar, o3.d.a(c10, eVar2, (s[]) null));
                    } else if (i10 != 2) {
                        o(gVar, cVar2, eVar, o3.d.a(c10, eVar2, (s[]) map.get(eVar2)), gVar.k().a0());
                    } else {
                        s(gVar, cVar2, eVar, o3.d.a(c10, eVar2, (s[]) map.get(eVar2)));
                    }
                    cVar.j();
                } else if (z10 && h0Var.j(eVar2)) {
                    cVar.a(o3.d.a(c10, eVar2, (s[]) map.get(eVar2)));
                }
            }
        }
    }

    public void q(g gVar, k3.c cVar, e eVar, o3.d dVar) {
        g gVar2 = gVar;
        k3.c cVar2 = cVar;
        e eVar2 = eVar;
        o3.d dVar2 = dVar;
        int g10 = dVar.g();
        t[] tVarArr = new t[g10];
        int i10 = -1;
        for (int i11 = 0; i11 < g10; i11++) {
            m i12 = dVar2.i(i11);
            b.a f10 = dVar2.f(i11);
            if (f10 != null) {
                tVarArr[i11] = V(gVar, cVar, (x) null, i11, i12, f10);
            } else if (i10 < 0) {
                i10 = i11;
            } else {
                gVar2.v0(cVar2, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", Integer.valueOf(i10), Integer.valueOf(i11), dVar2);
            }
        }
        if (i10 < 0) {
            gVar2.v0(cVar2, "No argument left as delegating for Creator %s: exactly one required", dVar2);
        }
        if (g10 == 1) {
            N(eVar2, dVar.b(), true, true);
            s j10 = dVar2.j(0);
            if (j10 != null) {
                ((d0) j10).l0();
                return;
            }
            return;
        }
        eVar2.h(dVar.b(), true, tVarArr, i10);
    }

    public void r(g gVar, c cVar, boolean z10) {
        k3.c cVar2 = cVar.f8216b;
        e eVar = cVar.f8218d;
        k3.b c10 = cVar.c();
        h0 h0Var = cVar.f8217c;
        Map map = cVar.f8219e;
        for (r3.j jVar : cVar2.w()) {
            h.a h10 = c10.h(gVar.k(), jVar);
            int v10 = jVar.v();
            if (h10 == null) {
                if (z10 && v10 == 1 && h0Var.j(jVar)) {
                    cVar.b(o3.d.a(c10, jVar, (s[]) null));
                }
            } else if (h10 != h.a.DISABLED) {
                if (v10 == 0) {
                    eVar.r(jVar);
                } else {
                    int i10 = a.f8211a[h10.ordinal()];
                    if (i10 == 1) {
                        q(gVar, cVar2, eVar, o3.d.a(c10, jVar, (s[]) null));
                    } else if (i10 != 2) {
                        o(gVar, cVar2, eVar, o3.d.a(c10, jVar, (s[]) map.get(jVar)), m3.i.f7858d);
                    } else {
                        s(gVar, cVar2, eVar, o3.d.a(c10, jVar, (s[]) map.get(jVar)));
                    }
                    cVar.k();
                }
            }
        }
    }

    public void s(g gVar, k3.c cVar, e eVar, o3.d dVar) {
        o3.d dVar2 = dVar;
        int g10 = dVar.g();
        t[] tVarArr = new t[g10];
        int i10 = 0;
        while (i10 < g10) {
            b.a f10 = dVar2.f(i10);
            m i11 = dVar2.i(i10);
            x h10 = dVar2.h(i10);
            if (h10 == null) {
                g gVar2 = gVar;
                k3.c cVar2 = cVar;
                if (gVar.K().d0(i11) != null) {
                    S(gVar2, cVar2, i11);
                }
                x d10 = dVar2.d(i10);
                T(gVar, cVar, dVar, i10, d10, f10);
                h10 = d10;
            } else {
                g gVar3 = gVar;
                k3.c cVar3 = cVar;
            }
            int i12 = i10;
            tVarArr[i12] = V(gVar, cVar, h10, i10, i11, f10);
            i10 = i12 + 1;
        }
        eVar.l(dVar.b(), true, tVarArr);
    }

    public void t(g gVar, c cVar, List list) {
        h0 h0Var;
        Iterator it;
        boolean z10;
        e eVar;
        LinkedList linkedList;
        x xVar;
        e eVar2;
        h0 h0Var2;
        Iterator it2;
        boolean z11;
        int i10;
        t[] tVarArr;
        n nVar;
        int i11;
        o3.d dVar;
        o3.d dVar2;
        int i12;
        boolean z12;
        g gVar2 = gVar;
        c cVar2 = cVar;
        f N = gVar.k();
        k3.c cVar3 = cVar2.f8216b;
        e eVar3 = cVar2.f8218d;
        k3.b c10 = cVar.c();
        h0 h0Var3 = cVar2.f8217c;
        boolean d10 = N.a0().d();
        Iterator it3 = list.iterator();
        LinkedList linkedList2 = null;
        while (it3.hasNext()) {
            o3.d dVar3 = (o3.d) it3.next();
            int g10 = dVar3.g();
            n b10 = dVar3.b();
            if (g10 == 1) {
                s j10 = dVar3.j(0);
                if (d10 || w(c10, b10, j10)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    t[] tVarArr2 = new t[1];
                    b.a f10 = dVar3.f(0);
                    x h10 = dVar3.h(0);
                    if (!(h10 == null && (h10 = dVar3.d(0)) == null && f10 == null)) {
                        t[] tVarArr3 = tVarArr2;
                        tVarArr3[0] = V(gVar, cVar3, h10, 0, dVar3.i(0), f10);
                        eVar3.l(b10, false, tVarArr3);
                    }
                } else {
                    N(eVar3, b10, false, h0Var3.j(b10));
                    if (j10 != null) {
                        ((d0) j10).l0();
                    }
                }
                eVar = eVar3;
                h0Var = h0Var3;
                z10 = d10;
                it = it3;
            } else {
                t[] tVarArr4 = new t[g10];
                int i13 = 0;
                int i14 = -1;
                int i15 = 0;
                int i16 = 0;
                while (i13 < g10) {
                    m t10 = b10.t(i13);
                    s j11 = dVar3.j(i13);
                    b.a s10 = c10.s(t10);
                    if (j11 == null) {
                        xVar = null;
                    } else {
                        xVar = j11.c();
                    }
                    if (j11 == null || !j11.C()) {
                        i10 = i13;
                        eVar2 = eVar3;
                        h0Var2 = h0Var3;
                        z11 = d10;
                        it2 = it3;
                        i12 = i14;
                        tVarArr = tVarArr4;
                        nVar = b10;
                        i11 = g10;
                        if (s10 != null) {
                            i16++;
                            m mVar = t10;
                            dVar2 = dVar3;
                            tVarArr[i10] = V(gVar, cVar3, xVar, i10, mVar, s10);
                        } else {
                            dVar = dVar3;
                            if (c10.d0(t10) != null) {
                                S(gVar2, cVar3, t10);
                            } else if (i12 < 0) {
                                i14 = i10;
                                dVar3 = dVar;
                                i13 = i10 + 1;
                                g10 = i11;
                                b10 = nVar;
                                tVarArr4 = tVarArr;
                                d10 = z11;
                                it3 = it2;
                                h0Var3 = h0Var2;
                                eVar3 = eVar2;
                            }
                            i14 = i12;
                            dVar3 = dVar;
                            i13 = i10 + 1;
                            g10 = i11;
                            b10 = nVar;
                            tVarArr4 = tVarArr;
                            d10 = z11;
                            it3 = it2;
                            h0Var3 = h0Var2;
                            eVar3 = eVar2;
                        }
                    } else {
                        i15++;
                        i10 = i13;
                        z11 = d10;
                        i12 = i14;
                        it2 = it3;
                        tVarArr = tVarArr4;
                        h0Var2 = h0Var3;
                        nVar = b10;
                        eVar2 = eVar3;
                        i11 = g10;
                        m mVar2 = t10;
                        dVar2 = dVar3;
                        tVarArr[i10] = V(gVar, cVar3, xVar, i10, mVar2, s10);
                    }
                    i14 = i12;
                    dVar = dVar2;
                    dVar3 = dVar;
                    i13 = i10 + 1;
                    g10 = i11;
                    b10 = nVar;
                    tVarArr4 = tVarArr;
                    d10 = z11;
                    it3 = it2;
                    h0Var3 = h0Var2;
                    eVar3 = eVar2;
                }
                o3.d dVar4 = dVar3;
                e eVar4 = eVar3;
                h0Var = h0Var3;
                z10 = d10;
                it = it3;
                int i17 = i14;
                t[] tVarArr5 = tVarArr4;
                n nVar2 = b10;
                int i18 = g10;
                int i19 = i15 + 0;
                if (i15 <= 0 && i16 <= 0) {
                    eVar = eVar4;
                } else if (i19 + i16 == i18) {
                    eVar = eVar4;
                    eVar.l(nVar2, false, tVarArr5);
                } else {
                    eVar = eVar4;
                    if (i15 == 0 && i16 + 1 == i18) {
                        eVar.h(nVar2, false, tVarArr5, 0);
                    } else {
                        x d11 = dVar4.d(i17);
                        if (d11 == null || d11.h()) {
                            gVar2.v0(cVar3, "Argument #%d of constructor %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", Integer.valueOf(i17), nVar2);
                        }
                    }
                }
                if (!eVar.o()) {
                    if (linkedList2 == null) {
                        linkedList = new LinkedList();
                    } else {
                        linkedList = linkedList2;
                    }
                    linkedList.add(nVar2);
                    linkedList2 = linkedList;
                }
            }
            eVar3 = eVar;
            d10 = z10;
            it3 = it;
            h0Var3 = h0Var;
        }
        e eVar5 = eVar3;
        h0 h0Var4 = h0Var3;
        if (linkedList2 != null && !eVar5.p() && !eVar5.q()) {
            x(gVar, cVar3, h0Var4, c10, eVar5, linkedList2);
        }
    }

    public void u(g gVar, c cVar, List list) {
        s sVar;
        x xVar;
        Iterator it;
        Map map;
        h0 h0Var;
        int i10;
        n nVar;
        t[] tVarArr;
        g gVar2 = gVar;
        c cVar2 = cVar;
        k3.c cVar3 = cVar2.f8216b;
        e eVar = cVar2.f8218d;
        k3.b c10 = cVar.c();
        h0 h0Var2 = cVar2.f8217c;
        Map map2 = cVar2.f8219e;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            o3.d dVar = (o3.d) it2.next();
            int g10 = dVar.g();
            n b10 = dVar.b();
            s[] sVarArr = (s[]) map2.get(b10);
            if (g10 == 1) {
                s j10 = dVar.j(0);
                if (!w(c10, b10, j10)) {
                    N(eVar, b10, false, h0Var2.j(b10));
                    if (j10 != null) {
                        ((d0) j10).l0();
                    }
                } else {
                    t[] tVarArr2 = new t[g10];
                    m mVar = null;
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    while (i11 < g10) {
                        m t10 = b10.t(i11);
                        if (sVarArr == null) {
                            sVar = null;
                        } else {
                            sVar = sVarArr[i11];
                        }
                        b.a s10 = c10.s(t10);
                        if (sVar == null) {
                            xVar = null;
                        } else {
                            xVar = sVar.c();
                        }
                        if (sVar == null || !sVar.C()) {
                            m mVar2 = t10;
                            i10 = i11;
                            h0Var = h0Var2;
                            map = map2;
                            it = it2;
                            tVarArr = tVarArr2;
                            nVar = b10;
                            if (s10 != null) {
                                i13++;
                                tVarArr[i10] = V(gVar, cVar3, xVar, i10, mVar2, s10);
                            } else {
                                m mVar3 = mVar2;
                                if (c10.d0(mVar3) != null) {
                                    S(gVar2, cVar3, mVar3);
                                } else if (mVar == null) {
                                    mVar = mVar3;
                                }
                            }
                        } else {
                            i12++;
                            i10 = i11;
                            h0Var = h0Var2;
                            tVarArr = tVarArr2;
                            map = map2;
                            it = it2;
                            nVar = b10;
                            tVarArr[i10] = V(gVar, cVar3, xVar, i10, t10, s10);
                        }
                        i11 = i10 + 1;
                        tVarArr2 = tVarArr;
                        b10 = nVar;
                        h0Var2 = h0Var;
                        map2 = map;
                        it2 = it;
                    }
                    h0 h0Var3 = h0Var2;
                    Map map3 = map2;
                    Iterator it3 = it2;
                    t[] tVarArr3 = tVarArr2;
                    n nVar2 = b10;
                    int i14 = i12 + 0;
                    if (i12 > 0 || i13 > 0) {
                        if (i14 + i13 == g10) {
                            eVar.l(nVar2, false, tVarArr3);
                        } else if (i12 == 0 && i13 + 1 == g10) {
                            eVar.h(nVar2, false, tVarArr3, 0);
                        } else {
                            gVar2.v0(cVar3, "Argument #%d of factory method %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", Integer.valueOf(mVar.q()), nVar2);
                        }
                    }
                    it2 = it3;
                    h0Var2 = h0Var3;
                    map2 = map3;
                }
            }
        }
    }

    public void v(g gVar, c cVar, r3.e eVar, List list) {
        c cVar2 = cVar;
        r3.e eVar2 = eVar;
        int v10 = eVar.v();
        k3.b K = gVar.K();
        t[] tVarArr = new t[v10];
        for (int i10 = 0; i10 < v10; i10++) {
            m t10 = eVar2.t(i10);
            b.a s10 = K.s(t10);
            x x10 = K.x(t10);
            if (x10 == null || x10.h()) {
                x10 = x.a((String) list.get(i10));
            } else {
                List list2 = list;
            }
            x xVar = x10;
            tVarArr[i10] = V(gVar, cVar2.f8216b, xVar, i10, t10, s10);
        }
        cVar2.f8218d.l(eVar2, false, tVarArr);
    }

    public final boolean w(k3.b bVar, n nVar, s sVar) {
        String name;
        if ((sVar != null && sVar.C()) || bVar.s(nVar.t(0)) != null) {
            return true;
        }
        if (sVar == null || (name = sVar.getName()) == null || name.isEmpty() || !sVar.f()) {
            return false;
        }
        return true;
    }

    public final void x(g gVar, k3.c cVar, h0 h0Var, k3.b bVar, e eVar, List list) {
        int i10;
        Iterator it = list.iterator();
        n nVar = null;
        n nVar2 = null;
        t[] tVarArr = null;
        while (true) {
            if (!it.hasNext()) {
                nVar = nVar2;
                break;
            }
            n nVar3 = (n) it.next();
            if (h0Var.j(nVar3)) {
                int v10 = nVar3.v();
                t[] tVarArr2 = new t[v10];
                int i11 = 0;
                while (true) {
                    if (i11 < v10) {
                        m t10 = nVar3.t(i11);
                        x K = K(t10, bVar);
                        if (K == null || K.h()) {
                            break;
                        }
                        tVarArr2[i11] = V(gVar, cVar, K, t10.q(), t10, (b.a) null);
                        i11++;
                    } else if (nVar2 != null) {
                        break;
                    } else {
                        nVar2 = nVar3;
                        tVarArr = tVarArr2;
                    }
                }
            }
        }
        if (nVar != null) {
            eVar.l(nVar, false, tVarArr);
            r3.q qVar = (r3.q) cVar;
            for (t tVar : tVarArr) {
                x c10 = tVar.c();
                if (!qVar.K(c10)) {
                    qVar.F(d4.w.E(gVar.k(), tVar.d(), c10));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0042, code lost:
        r2 = new java.util.ArrayList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n3.w y(k3.g r10, k3.c r11) {
        /*
            r9 = this;
            k3.f r0 = r10.k()
            java.lang.Class r1 = r11.s()
            r3.c r2 = r11.u()
            r3.h0 r6 = r0.t(r1, r2)
            m3.i r1 = r0.a0()
            o3.e r7 = new o3.e
            r7.<init>(r11, r0)
            java.util.Map r8 = r9.A(r10, r11)
            n3.b$c r0 = new n3.b$c
            r3 = r0
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            boolean r2 = r1.a()
            r2 = r2 ^ 1
            r9.r(r10, r0, r2)
            k3.j r2 = r11.z()
            boolean r2 = r2.C()
            if (r2 == 0) goto L_0x007c
            k3.j r2 = r11.z()
            boolean r2 = r2.L()
            if (r2 == 0) goto L_0x0057
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.e r3 = s3.a.a(r10, r11, r2)
            if (r3 == 0) goto L_0x0057
            r9.v(r10, r0, r3, r2)
            o3.e r11 = r0.f8218d
            n3.w r10 = r11.n(r10)
            return r10
        L_0x0057:
            boolean r2 = r11.C()
            if (r2 == 0) goto L_0x005e
            goto L_0x007c
        L_0x005e:
            java.lang.Class r11 = r11.s()
            boolean r11 = r1.b(r11)
            r9.p(r10, r0, r11)
            boolean r11 = r0.f()
            if (r11 == 0) goto L_0x007c
            boolean r11 = r0.d()
            if (r11 != 0) goto L_0x007c
            java.util.List r11 = r0.h()
            r9.t(r10, r0, r11)
        L_0x007c:
            boolean r11 = r0.g()
            if (r11 == 0) goto L_0x0095
            boolean r11 = r0.e()
            if (r11 != 0) goto L_0x0095
            boolean r11 = r0.d()
            if (r11 != 0) goto L_0x0095
            java.util.List r11 = r0.i()
            r9.u(r10, r0, r11)
        L_0x0095:
            o3.e r11 = r0.f8218d
            n3.w r10 = r11.n(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.b.y(k3.g, k3.c):n3.w");
    }

    public final p z(g gVar, j jVar) {
        f N = gVar.k();
        Class q10 = jVar.q();
        k3.c g02 = N.g0(jVar);
        p a02 = a0(gVar, g02.u());
        if (a02 != null) {
            return a02;
        }
        k3.k F = F(q10, N, g02);
        if (F != null) {
            return com.fasterxml.jackson.databind.deser.std.d0.b(N, jVar, F);
        }
        k3.k Z = Z(gVar, g02.u());
        if (Z != null) {
            return com.fasterxml.jackson.databind.deser.std.d0.b(N, jVar, Z);
        }
        d4.k W = W(q10, N, g02.k());
        for (r3.j jVar2 : g02.w()) {
            if (O(gVar, jVar2)) {
                if (jVar2.v() != 1 || !jVar2.D().isAssignableFrom(q10)) {
                    throw new IllegalArgumentException("Unsuitable method (" + jVar2 + ") decorated with @JsonCreator (for Enum type " + q10.getName() + ")");
                } else if (jVar2.x(0) == String.class) {
                    if (N.b()) {
                        d4.h.g(jVar2.m(), gVar.o0(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return com.fasterxml.jackson.databind.deser.std.d0.d(W, jVar2);
                }
            }
        }
        return com.fasterxml.jackson.databind.deser.std.d0.c(W);
    }
}
