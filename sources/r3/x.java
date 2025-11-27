package r3;

import a4.s;
import b3.a0;
import b3.b;
import b3.b0;
import b3.c0;
import b3.d;
import b3.d0;
import b3.e0;
import b3.f0;
import b3.g;
import b3.g0;
import b3.h;
import b3.h0;
import b3.i0;
import b3.k;
import b3.m;
import b3.m0;
import b3.p;
import b3.r;
import b3.s;
import b3.t;
import b3.u;
import b3.v;
import b3.w;
import b3.y;
import b3.z;
import d4.h;
import d4.j;
import d4.n;
import d4.q;
import java.io.Closeable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import k3.b;
import k3.j;
import k3.k;
import k3.l;
import k3.o;
import k3.p;
import k3.w;
import l3.b;
import l3.c;
import l3.e;
import l3.f;
import l3.i;

public class x extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final Class[] f9185c;

    /* renamed from: d  reason: collision with root package name */
    public static final Class[] f9186d;

    /* renamed from: a  reason: collision with root package name */
    public transient n f9187a = new n(48, 48);

    /* renamed from: b  reason: collision with root package name */
    public boolean f9188b = true;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9189a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                l3.f$a[] r0 = l3.f.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9189a = r0
                l3.f$a r1 = l3.f.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9189a     // Catch:{ NoSuchFieldError -> 0x001d }
                l3.f$a r1 = l3.f.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9189a     // Catch:{ NoSuchFieldError -> 0x0028 }
                l3.f$a r1 = l3.f.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9189a     // Catch:{ NoSuchFieldError -> 0x0033 }
                l3.f$a r1 = l3.f.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9189a     // Catch:{ NoSuchFieldError -> 0x003e }
                l3.f$a r1 = l3.f.a.DEFAULT_INCLUSION     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.x.a.<clinit>():void");
        }
    }

    static {
        Class<i0> cls = i0.class;
        Class<k> cls2 = k.class;
        Class<e0> cls3 = e0.class;
        Class<g0> cls4 = g0.class;
        Class<g> cls5 = g.class;
        Class<u> cls6 = u.class;
        f9185c = new Class[]{f.class, cls, cls2, cls3, z.class, cls4, cls5, cls6};
        f9186d = new Class[]{c.class, cls, cls2, cls3, cls4, cls5, cls6, v.class};
        try {
            q3.c.a();
        } catch (Throwable unused) {
        }
    }

    public Object A(b bVar) {
        Class<o.a> nullsUsing;
        f fVar = (f) a(bVar, f.class);
        if (fVar == null || (nullsUsing = fVar.nullsUsing()) == o.a.class) {
            return null;
        }
        return nullsUsing;
    }

    public x3.o A0() {
        return new x3.o();
    }

    public b0 B(b bVar) {
        m mVar = (m) a(bVar, m.class);
        if (mVar == null || mVar.generator() == m0.class) {
            return null;
        }
        return new b0(k3.x.a(mVar.property()), mVar.scope(), mVar.generator(), mVar.resolver());
    }

    public a4.c B0(b.a aVar, m3.m mVar, c cVar, j jVar) {
        w wVar;
        if (aVar.required()) {
            wVar = w.f7485h;
        } else {
            wVar = w.f7486i;
        }
        String value = aVar.value();
        k3.x J0 = J0(aVar.propName(), aVar.propNamespace());
        if (!J0.e()) {
            J0 = k3.x.a(value);
        }
        return b4.a.J(value, d4.w.F(mVar, new g0(cVar, cVar.e(), value, jVar), J0, wVar, aVar.include()), cVar.o(), jVar);
    }

    public b0 C(b bVar, b0 b0Var) {
        b3.n nVar = (b3.n) a(bVar, b3.n.class);
        if (nVar == null) {
            return b0Var;
        }
        if (b0Var == null) {
            b0Var = b0.a();
        }
        return b0Var.g(nVar.alwaysAsId());
    }

    public a4.c C0(b.C0099b bVar, m3.m mVar, c cVar) {
        w wVar;
        if (bVar.required()) {
            wVar = w.f7485h;
        } else {
            wVar = w.f7486i;
        }
        k3.x J0 = J0(bVar.name(), bVar.namespace());
        j e10 = mVar.e(bVar.type());
        d4.w F = d4.w.F(mVar, new g0(cVar, cVar.e(), J0.c(), e10), J0, wVar, bVar.include());
        Class value = bVar.value();
        mVar.u();
        return ((s) h.l(value, mVar.b())).I(mVar, cVar, F, e10);
    }

    public Class D(c cVar) {
        c cVar2 = (c) a(cVar, c.class);
        if (cVar2 == null) {
            return null;
        }
        return x0(cVar2.builder());
    }

    public k3.x D0(b bVar) {
        if (!(bVar instanceof m)) {
            return null;
        }
        ((m) bVar).r();
        return null;
    }

    public e.a E(c cVar) {
        e eVar = (e) a(cVar, e.class);
        if (eVar == null) {
            return null;
        }
        return new e.a(eVar);
    }

    public final Boolean E0(b bVar) {
        y yVar = (y) a(bVar, y.class);
        if (yVar == null || !yVar.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    public w.a F(b bVar) {
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        if (wVar != null) {
            return wVar.access();
        }
        return null;
    }

    public w3.g F0(m3.m mVar, b bVar, j jVar) {
        w3.g gVar;
        e0 e0Var = (e0) a(bVar, e0.class);
        l3.h hVar = (l3.h) a(bVar, l3.h.class);
        w3.f fVar = null;
        if (hVar != null) {
            if (e0Var == null) {
                return null;
            }
            gVar = mVar.G(bVar, hVar.value());
        } else if (e0Var == null) {
            return null;
        } else {
            if (e0Var.use() == e0.b.NONE) {
                return z0();
            }
            gVar = A0();
        }
        l3.g gVar2 = (l3.g) a(bVar, l3.g.class);
        if (gVar2 != null) {
            fVar = mVar.F(bVar, gVar2.value());
        }
        if (fVar != null) {
            fVar.c(jVar);
        }
        w3.g h10 = gVar.h(e0Var.use(), fVar);
        e0.a include = e0Var.include();
        if (include == e0.a.EXTERNAL_PROPERTY && (bVar instanceof c)) {
            include = e0.a.PROPERTY;
        }
        w3.g c10 = h10.f(include).c(e0Var.property());
        Class<e0.c> defaultImpl = e0Var.defaultImpl();
        if (defaultImpl != e0.c.class && !defaultImpl.isAnnotation()) {
            c10 = c10.d(defaultImpl);
        }
        return c10.a(e0Var.visible());
    }

    public List G(b bVar) {
        b3.c cVar = (b3.c) a(bVar, b3.c.class);
        if (cVar == null) {
            return null;
        }
        if (r0 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(r0);
        for (String a10 : cVar.value()) {
            arrayList.add(k3.x.a(a10));
        }
        return arrayList;
    }

    public boolean G0(b bVar) {
        b3.o oVar = (b3.o) a(bVar, b3.o.class);
        if (oVar != null) {
            return oVar.value();
        }
        return false;
    }

    public w3.g H(m3.m mVar, i iVar, j jVar) {
        if (jVar.k() != null) {
            return F0(mVar, iVar, jVar);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + jVar + ")");
    }

    public final boolean H0(Class cls, Class cls2) {
        if (cls.isPrimitive()) {
            if (cls == h.b0(cls2)) {
                return true;
            }
            return false;
        } else if (!cls2.isPrimitive() || cls2 != h.b0(cls)) {
            return false;
        } else {
            return true;
        }
    }

    public String I(b bVar) {
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        if (wVar == null) {
            return null;
        }
        String defaultValue = wVar.defaultValue();
        if (defaultValue.isEmpty()) {
            return null;
        }
        return defaultValue;
    }

    public final boolean I0(j jVar, Class cls) {
        if (jVar.K()) {
            return jVar.y(h.b0(cls));
        }
        if (!cls.isPrimitive() || cls != h.b0(jVar.q())) {
            return false;
        }
        return true;
    }

    public String J(b bVar) {
        b3.x xVar = (b3.x) a(bVar, b3.x.class);
        if (xVar == null) {
            return null;
        }
        return xVar.value();
    }

    public k3.x J0(String str, String str2) {
        if (str.isEmpty()) {
            return k3.x.f7497d;
        }
        if (str2 == null || str2.isEmpty()) {
            return k3.x.a(str);
        }
        return k3.x.b(str, str2);
    }

    public p.a K(m3.m mVar, b bVar) {
        p pVar = (p) a(bVar, p.class);
        if (pVar == null) {
            return p.a.f();
        }
        return p.a.i(pVar);
    }

    public final r.b K0(b bVar, r.b bVar2) {
        f fVar = (f) a(bVar, f.class);
        if (fVar != null) {
            int i10 = a.f9189a[fVar.include().ordinal()];
            if (i10 == 1) {
                return bVar2.n(r.a.ALWAYS);
            }
            if (i10 == 2) {
                return bVar2.n(r.a.NON_NULL);
            }
            if (i10 == 3) {
                return bVar2.n(r.a.NON_DEFAULT);
            }
            if (i10 == 4) {
                return bVar2.n(r.a.NON_EMPTY);
            }
        }
        return bVar2;
    }

    public p.a L(b bVar) {
        return K((m3.m) null, bVar);
    }

    public r.b M(b bVar) {
        r.b bVar2;
        r rVar = (r) a(bVar, r.class);
        if (rVar == null) {
            bVar2 = r.b.c();
        } else {
            bVar2 = r.b.d(rVar);
        }
        if (bVar2.h() == r.a.USE_DEFAULTS) {
            return K0(bVar, bVar2);
        }
        return bVar2;
    }

    public s.a N(m3.m mVar, b bVar) {
        b3.s sVar = (b3.s) a(bVar, b3.s.class);
        if (sVar == null) {
            return s.a.c();
        }
        return s.a.d(sVar);
    }

    public Integer O(b bVar) {
        int index;
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        if (wVar == null || (index = wVar.index()) == -1) {
            return null;
        }
        return Integer.valueOf(index);
    }

    public w3.g P(m3.m mVar, i iVar, j jVar) {
        if (jVar.D() || jVar.b()) {
            return null;
        }
        return F0(mVar, iVar, jVar);
    }

    public b.a Q(i iVar) {
        u uVar = (u) a(iVar, u.class);
        if (uVar != null) {
            return b.a.e(uVar.value());
        }
        g gVar = (g) a(iVar, g.class);
        if (gVar != null) {
            return b.a.a(gVar.value());
        }
        return null;
    }

    public k3.x R(m3.m mVar, g gVar, k3.x xVar) {
        return null;
    }

    public k3.x S(c cVar) {
        a0 a0Var = (a0) a(cVar, a0.class);
        String str = null;
        if (a0Var == null) {
            return null;
        }
        String namespace = a0Var.namespace();
        if (namespace == null || !namespace.isEmpty()) {
            str = namespace;
        }
        return k3.x.b(a0Var.value(), str);
    }

    public Object T(i iVar) {
        f fVar = (f) a(iVar, f.class);
        if (fVar == null) {
            return null;
        }
        return y0(fVar.contentConverter(), j.a.class);
    }

    public Object U(b bVar) {
        f fVar = (f) a(bVar, f.class);
        if (fVar == null) {
            return null;
        }
        return y0(fVar.converter(), j.a.class);
    }

    public String[] V(c cVar) {
        y yVar = (y) a(cVar, y.class);
        if (yVar == null) {
            return null;
        }
        return yVar.value();
    }

    public Boolean W(b bVar) {
        return E0(bVar);
    }

    public f.b X(b bVar) {
        f fVar = (f) a(bVar, f.class);
        if (fVar == null) {
            return null;
        }
        return fVar.typing();
    }

    public Object Y(b bVar) {
        Class<o.a> using;
        f fVar = (f) a(bVar, f.class);
        if (fVar != null && (using = fVar.using()) != o.a.class) {
            return using;
        }
        z zVar = (z) a(bVar, z.class);
        if (zVar == null || !zVar.value()) {
            return null;
        }
        return new com.fasterxml.jackson.databind.ser.std.y(bVar.e());
    }

    public b0.a Z(b bVar) {
        return b0.a.d((b0) a(bVar, b0.class));
    }

    public List a0(b bVar) {
        c0 c0Var = (c0) a(bVar, c0.class);
        if (c0Var == null) {
            return null;
        }
        c0.a[] value = c0Var.value();
        ArrayList arrayList = new ArrayList(value.length);
        for (c0.a aVar : value) {
            arrayList.add(new w3.b(aVar.value(), aVar.name()));
            for (String bVar2 : aVar.names()) {
                arrayList.add(new w3.b(aVar.value(), bVar2));
            }
        }
        return arrayList;
    }

    public String b0(c cVar) {
        f0 f0Var = (f0) a(cVar, f0.class);
        if (f0Var == null) {
            return null;
        }
        return f0Var.value();
    }

    public w3.g c0(m3.m mVar, c cVar, k3.j jVar) {
        return F0(mVar, cVar, jVar);
    }

    public void d(m3.m mVar, c cVar, List list) {
        l3.b bVar = (l3.b) a(cVar, l3.b.class);
        if (bVar != null) {
            boolean prepend = bVar.prepend();
            b.a[] attrs = bVar.attrs();
            int length = attrs.length;
            k3.j jVar = null;
            for (int i10 = 0; i10 < length; i10++) {
                if (jVar == null) {
                    jVar = mVar.e(Object.class);
                }
                a4.c B0 = B0(attrs[i10], mVar, cVar, jVar);
                if (prepend) {
                    list.add(i10, B0);
                } else {
                    list.add(B0);
                }
            }
            b.C0099b[] props = bVar.props();
            int length2 = props.length;
            for (int i11 = 0; i11 < length2; i11++) {
                a4.c C0 = C0(props[i11], mVar, cVar);
                if (prepend) {
                    list.add(i11, C0);
                } else {
                    list.add(C0);
                }
            }
        }
    }

    public q d0(i iVar) {
        g0 g0Var = (g0) a(iVar, g0.class);
        if (g0Var == null || !g0Var.enabled()) {
            return null;
        }
        return q.b(g0Var.prefix(), g0Var.suffix());
    }

    public h0 e(c cVar, h0 h0Var) {
        b3.f fVar = (b3.f) a(cVar, b3.f.class);
        if (fVar == null) {
            return h0Var;
        }
        return h0Var.a(fVar);
    }

    public Object e0(c cVar) {
        i iVar = (i) a(cVar, i.class);
        if (iVar == null) {
            return null;
        }
        return iVar.value();
    }

    public Object f(b bVar) {
        Class<k.a> contentUsing;
        c cVar = (c) a(bVar, c.class);
        if (cVar == null || (contentUsing = cVar.contentUsing()) == k.a.class) {
            return null;
        }
        return contentUsing;
    }

    public Class[] f0(b bVar) {
        i0 i0Var = (i0) a(bVar, i0.class);
        if (i0Var == null) {
            return null;
        }
        return i0Var.value();
    }

    public Object g(b bVar) {
        Class<o.a> contentUsing;
        f fVar = (f) a(bVar, f.class);
        if (fVar == null || (contentUsing = fVar.contentUsing()) == o.a.class) {
            return null;
        }
        return contentUsing;
    }

    public h.a h(m3.m mVar, b bVar) {
        b3.h hVar = (b3.h) a(bVar, b3.h.class);
        if (hVar != null) {
            return hVar.mode();
        }
        if (!this.f9188b || !mVar.D(k3.q.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES)) {
            return null;
        }
        boolean z10 = bVar instanceof e;
        return null;
    }

    public Boolean h0(b bVar) {
        d dVar = (d) a(bVar, d.class);
        if (dVar == null) {
            return null;
        }
        return Boolean.valueOf(dVar.enabled());
    }

    public h.a i(b bVar) {
        b3.h hVar = (b3.h) a(bVar, b3.h.class);
        if (hVar == null) {
            return null;
        }
        return hVar.mode();
    }

    public boolean i0(j jVar) {
        return b(jVar, d.class);
    }

    public Enum j(Class cls) {
        return d4.h.v(cls, b3.i.class);
    }

    public Boolean j0(b bVar) {
        b3.e eVar = (b3.e) a(bVar, b3.e.class);
        if (eVar == null) {
            return null;
        }
        return Boolean.valueOf(eVar.enabled());
    }

    public Object k(i iVar) {
        c cVar = (c) a(iVar, c.class);
        if (cVar == null) {
            return null;
        }
        return y0(cVar.contentConverter(), j.a.class);
    }

    public Boolean k0(m3.m mVar, b bVar) {
        t tVar = (t) a(bVar, t.class);
        if (tVar == null) {
            return null;
        }
        return Boolean.valueOf(tVar.value());
    }

    public Object l(b bVar) {
        c cVar = (c) a(bVar, c.class);
        if (cVar == null) {
            return null;
        }
        return y0(cVar.converter(), j.a.class);
    }

    public Boolean l0(b bVar) {
        h0 h0Var = (h0) a(bVar, h0.class);
        if (h0Var == null) {
            return null;
        }
        return Boolean.valueOf(h0Var.value());
    }

    public Object m(b bVar) {
        Class<k.a> using;
        c cVar = (c) a(bVar, c.class);
        if (cVar == null || (using = cVar.using()) == k.a.class) {
            return null;
        }
        return using;
    }

    public boolean m0(j jVar) {
        h0 h0Var = (h0) a(jVar, h0.class);
        if (h0Var == null || !h0Var.value()) {
            return false;
        }
        return true;
    }

    public void n(Class cls, Enum[] enumArr, String[][] strArr) {
        b3.c cVar;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (cVar = (b3.c) field.getAnnotation(b3.c.class)) != null) {
                String[] value = cVar.value();
                if (value.length != 0) {
                    String name = field.getName();
                    int length = enumArr.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        if (name.equals(enumArr[i10].name())) {
                            strArr[i10] = value;
                        }
                    }
                }
            }
        }
    }

    public boolean n0(b bVar) {
        b3.h hVar = (b3.h) a(bVar, b3.h.class);
        if (hVar == null) {
            if (this.f9188b) {
                boolean z10 = bVar instanceof e;
            }
            return false;
        } else if (hVar.mode() != h.a.DISABLED) {
            return true;
        } else {
            return false;
        }
    }

    public String[] o(Class cls, Enum[] enumArr, String[] strArr) {
        b3.w wVar;
        HashMap hashMap = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (wVar = (b3.w) field.getAnnotation(b3.w.class)) != null) {
                String value = wVar.value();
                if (!value.isEmpty()) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(field.getName(), value);
                }
            }
        }
        if (hashMap != null) {
            int length = enumArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                String str = (String) hashMap.get(enumArr[i10].name());
                if (str != null) {
                    strArr[i10] = str;
                }
            }
        }
        return strArr;
    }

    public boolean o0(i iVar) {
        return G0(iVar);
    }

    public Object p(b bVar) {
        b3.j jVar = (b3.j) a(bVar, b3.j.class);
        if (jVar == null) {
            return null;
        }
        String value = jVar.value();
        if (!value.isEmpty()) {
            return value;
        }
        return null;
    }

    public Boolean p0(i iVar) {
        b3.w wVar = (b3.w) a(iVar, b3.w.class);
        if (wVar != null) {
            return Boolean.valueOf(wVar.required());
        }
        return null;
    }

    public k.d q(b bVar) {
        b3.k kVar = (b3.k) a(bVar, b3.k.class);
        if (kVar == null) {
            return null;
        }
        return k.d.d(kVar);
    }

    public boolean q0(Annotation annotation) {
        boolean z10;
        Class<? extends Annotation> annotationType = annotation.annotationType();
        Boolean bool = (Boolean) this.f9187a.get(annotationType);
        if (bool == null) {
            if (annotationType.getAnnotation(b3.a.class) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            bool = Boolean.valueOf(z10);
            this.f9187a.putIfAbsent(annotationType, bool);
        }
        return bool.booleanValue();
    }

    public String r(i iVar) {
        k3.x D0 = D0(iVar);
        if (D0 == null) {
            return null;
        }
        return D0.c();
    }

    public Boolean r0(c cVar) {
        b3.q qVar = (b3.q) a(cVar, b3.q.class);
        if (qVar == null) {
            return null;
        }
        return Boolean.valueOf(qVar.value());
    }

    public b.a s(i iVar) {
        String str;
        b3.b bVar = (b3.b) a(iVar, b3.b.class);
        if (bVar == null) {
            return null;
        }
        b.a d10 = b.a.d(bVar);
        if (d10.f()) {
            return d10;
        }
        if (!(iVar instanceof j)) {
            str = iVar.e().getName();
        } else {
            j jVar = (j) iVar;
            if (jVar.v() == 0) {
                str = iVar.e().getName();
            } else {
                str = jVar.x(0).getName();
            }
        }
        return d10.h(str);
    }

    public Boolean s0(i iVar) {
        return Boolean.valueOf(b(iVar, d0.class));
    }

    public Object t(i iVar) {
        b.a s10 = s(iVar);
        if (s10 == null) {
            return null;
        }
        return s10.e();
    }

    public Object u(b bVar) {
        Class<p.a> keyUsing;
        c cVar = (c) a(bVar, c.class);
        if (cVar == null || (keyUsing = cVar.keyUsing()) == p.a.class) {
            return null;
        }
        return keyUsing;
    }

    public k3.j u0(m3.m mVar, b bVar, k3.j jVar) {
        Class cls;
        Class cls2;
        Class cls3;
        c4.o z10 = mVar.z();
        c cVar = (c) a(bVar, c.class);
        if (cVar == null) {
            cls = null;
        } else {
            cls = x0(cVar.as());
        }
        if (cls != null && !jVar.y(cls) && !I0(jVar, cls)) {
            try {
                jVar = z10.F(jVar, cls);
            } catch (IllegalArgumentException e10) {
                throw new l((Closeable) null, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", new Object[]{jVar, cls.getName(), bVar.d(), e10.getMessage()}), (Throwable) e10);
            }
        }
        if (jVar.J()) {
            k3.j p10 = jVar.p();
            if (cVar == null) {
                cls3 = null;
            } else {
                cls3 = x0(cVar.keyAs());
            }
            if (cls3 != null && !I0(p10, cls3)) {
                try {
                    jVar = ((c4.g) jVar).b0(z10.F(p10, cls3));
                } catch (IllegalArgumentException e11) {
                    throw new l((Closeable) null, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{jVar, cls3.getName(), bVar.d(), e11.getMessage()}), (Throwable) e11);
                }
            }
        }
        k3.j k10 = jVar.k();
        if (k10 == null) {
            return jVar;
        }
        if (cVar == null) {
            cls2 = null;
        } else {
            cls2 = x0(cVar.contentAs());
        }
        if (cls2 == null || I0(k10, cls2)) {
            return jVar;
        }
        try {
            return jVar.R(z10.F(k10, cls2));
        } catch (IllegalArgumentException e12) {
            throw new l((Closeable) null, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{jVar, cls2.getName(), bVar.d(), e12.getMessage()}), (Throwable) e12);
        }
    }

    public Object v(b bVar) {
        Class<o.a> keyUsing;
        f fVar = (f) a(bVar, f.class);
        if (fVar == null || (keyUsing = fVar.keyUsing()) == o.a.class) {
            return null;
        }
        return keyUsing;
    }

    public k3.j v0(m3.m mVar, b bVar, k3.j jVar) {
        Class cls;
        Class cls2;
        k3.j jVar2;
        Class cls3;
        k3.j jVar3;
        c4.o z10 = mVar.z();
        f fVar = (f) a(bVar, f.class);
        if (fVar == null) {
            cls = null;
        } else {
            cls = x0(fVar.as());
        }
        if (cls != null) {
            if (jVar.y(cls)) {
                jVar = jVar.V();
            } else {
                Class q10 = jVar.q();
                try {
                    if (cls.isAssignableFrom(q10)) {
                        jVar = z10.B(jVar, cls);
                    } else if (q10.isAssignableFrom(cls)) {
                        jVar = z10.F(jVar, cls);
                    } else if (H0(q10, cls)) {
                        jVar = jVar.V();
                    } else {
                        throw new l((Closeable) null, String.format("Cannot refine serialization type %s into %s; types not related", new Object[]{jVar, cls.getName()}));
                    }
                } catch (IllegalArgumentException e10) {
                    throw new l((Closeable) null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", new Object[]{jVar, cls.getName(), bVar.d(), e10.getMessage()}), (Throwable) e10);
                }
            }
        }
        if (jVar.J()) {
            k3.j p10 = jVar.p();
            if (fVar == null) {
                cls3 = null;
            } else {
                cls3 = x0(fVar.keyAs());
            }
            if (cls3 != null) {
                if (p10.y(cls3)) {
                    jVar3 = p10.V();
                } else {
                    Class q11 = p10.q();
                    try {
                        if (cls3.isAssignableFrom(q11)) {
                            jVar3 = z10.B(p10, cls3);
                        } else if (q11.isAssignableFrom(cls3)) {
                            jVar3 = z10.F(p10, cls3);
                        } else if (H0(q11, cls3)) {
                            jVar3 = p10.V();
                        } else {
                            throw new l((Closeable) null, String.format("Cannot refine serialization key type %s into %s; types not related", new Object[]{p10, cls3.getName()}));
                        }
                    } catch (IllegalArgumentException e11) {
                        throw new l((Closeable) null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{jVar, cls3.getName(), bVar.d(), e11.getMessage()}), (Throwable) e11);
                    }
                }
                jVar = ((c4.g) jVar).b0(jVar3);
            }
        }
        k3.j k10 = jVar.k();
        if (k10 == null) {
            return jVar;
        }
        if (fVar == null) {
            cls2 = null;
        } else {
            cls2 = x0(fVar.contentAs());
        }
        if (cls2 == null) {
            return jVar;
        }
        if (k10.y(cls2)) {
            jVar2 = k10.V();
        } else {
            Class q12 = k10.q();
            try {
                if (cls2.isAssignableFrom(q12)) {
                    jVar2 = z10.B(k10, cls2);
                } else if (q12.isAssignableFrom(cls2)) {
                    jVar2 = z10.F(k10, cls2);
                } else if (H0(q12, cls2)) {
                    jVar2 = k10.V();
                } else {
                    throw new l((Closeable) null, String.format("Cannot refine serialization content type %s into %s; types not related", new Object[]{k10, cls2.getName()}));
                }
            } catch (IllegalArgumentException e12) {
                throw new l((Closeable) null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{jVar, cls2.getName(), bVar.d(), e12.getMessage()}), (Throwable) e12);
            }
        }
        return jVar.R(jVar2);
    }

    public Boolean w(b bVar) {
        v vVar = (v) a(bVar, v.class);
        if (vVar == null) {
            return null;
        }
        return vVar.value().a();
    }

    public j w0(m3.m mVar, j jVar, j jVar2) {
        Class<String> x10 = jVar.x(0);
        Class<String> x11 = jVar2.x(0);
        if (x10.isPrimitive()) {
            if (!x11.isPrimitive()) {
                return jVar;
            }
        } else if (x11.isPrimitive()) {
            return jVar2;
        }
        Class<String> cls = String.class;
        if (x10 == cls) {
            if (x11 != cls) {
                return jVar;
            }
            return null;
        } else if (x11 == cls) {
            return jVar2;
        } else {
            return null;
        }
    }

    public k3.x x(b bVar) {
        boolean z10;
        b0 b0Var = (b0) a(bVar, b0.class);
        if (b0Var != null) {
            String value = b0Var.value();
            if (!value.isEmpty()) {
                return k3.x.a(value);
            }
            z10 = true;
        } else {
            z10 = false;
        }
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        String str = null;
        if (wVar != null) {
            String namespace = wVar.namespace();
            if (namespace == null || !namespace.isEmpty()) {
                str = namespace;
            }
            return k3.x.b(wVar.value(), str);
        } else if (z10 || c(bVar, f9186d)) {
            return k3.x.f7497d;
        } else {
            return null;
        }
    }

    public Class x0(Class cls) {
        if (cls == null || d4.h.J(cls)) {
            return null;
        }
        return cls;
    }

    public k3.x y(b bVar) {
        boolean z10;
        b3.l lVar = (b3.l) a(bVar, b3.l.class);
        if (lVar != null) {
            String value = lVar.value();
            if (!value.isEmpty()) {
                return k3.x.a(value);
            }
            z10 = true;
        } else {
            z10 = false;
        }
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        String str = null;
        if (wVar != null) {
            String namespace = wVar.namespace();
            if (namespace == null || !namespace.isEmpty()) {
                str = namespace;
            }
            return k3.x.b(wVar.value(), str);
        } else if (z10 || c(bVar, f9185c)) {
            return k3.x.f7497d;
        } else {
            return null;
        }
    }

    public Class y0(Class cls, Class cls2) {
        Class x02 = x0(cls);
        if (x02 == null || x02 == cls2) {
            return null;
        }
        return x02;
    }

    public Object z(c cVar) {
        l3.d dVar = (l3.d) a(cVar, l3.d.class);
        if (dVar == null) {
            return null;
        }
        return dVar.value();
    }

    public x3.o z0() {
        return x3.o.o();
    }
}
