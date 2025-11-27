package com.fasterxml.jackson.databind.ser.std;

import a4.h;
import a4.i;
import b3.r;
import b4.k;
import c3.n;
import c4.o;
import d4.m;
import i3.b;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import k3.b0;
import k3.c0;
import k3.d;
import k3.j;
import k3.l;
import u3.f;

public class t extends h implements i {

    /* renamed from: p  reason: collision with root package name */
    public static final j f5786p = o.O();

    /* renamed from: q  reason: collision with root package name */
    public static final Object f5787q = r.a.NON_EMPTY;

    /* renamed from: a  reason: collision with root package name */
    public final d f5788a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5789b;

    /* renamed from: c  reason: collision with root package name */
    public final j f5790c;

    /* renamed from: d  reason: collision with root package name */
    public final j f5791d;

    /* renamed from: e  reason: collision with root package name */
    public k3.o f5792e;

    /* renamed from: f  reason: collision with root package name */
    public k3.o f5793f;

    /* renamed from: g  reason: collision with root package name */
    public final w3.h f5794g;

    /* renamed from: h  reason: collision with root package name */
    public k f5795h;

    /* renamed from: i  reason: collision with root package name */
    public final Set f5796i;

    /* renamed from: j  reason: collision with root package name */
    public final Set f5797j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f5798k;

    /* renamed from: l  reason: collision with root package name */
    public final Object f5799l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f5800m;

    /* renamed from: n  reason: collision with root package name */
    public final m.a f5801n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f5802o;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5803a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                b3.r$a[] r0 = b3.r.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5803a = r0
                b3.r$a r1 = b3.r.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5803a     // Catch:{ NoSuchFieldError -> 0x001d }
                b3.r$a r1 = b3.r.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5803a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b3.r$a r1 = b3.r.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5803a     // Catch:{ NoSuchFieldError -> 0x0033 }
                b3.r$a r1 = b3.r.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5803a     // Catch:{ NoSuchFieldError -> 0x003e }
                b3.r$a r1 = b3.r.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5803a     // Catch:{ NoSuchFieldError -> 0x0049 }
                b3.r$a r1 = b3.r.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.t.a.<clinit>():void");
        }
    }

    public t(Set set, Set set2, j jVar, j jVar2, boolean z10, w3.h hVar, k3.o oVar, k3.o oVar2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this.f5796i = set;
        this.f5797j = set2;
        this.f5790c = jVar;
        this.f5791d = jVar2;
        this.f5789b = z10;
        this.f5794g = hVar;
        this.f5792e = oVar;
        this.f5793f = oVar2;
        this.f5795h = k.c();
        this.f5788a = null;
        this.f5798k = null;
        this.f5802o = false;
        this.f5799l = null;
        this.f5800m = false;
        this.f5801n = m.a(set, set2);
    }

    public static t m(Set set, Set set2, j jVar, boolean z10, w3.h hVar, k3.o oVar, k3.o oVar2, Object obj) {
        j jVar2;
        j jVar3;
        boolean z11;
        j jVar4;
        Object obj2 = obj;
        if (jVar == null) {
            jVar3 = f5786p;
            jVar2 = jVar3;
        } else {
            j p10 = jVar.p();
            if (jVar.y(Properties.class)) {
                jVar4 = o.O();
            } else {
                jVar4 = jVar.k();
            }
            jVar2 = jVar4;
            jVar3 = p10;
        }
        boolean z12 = false;
        if (!z10) {
            if (jVar2 != null && jVar2.G()) {
                z12 = true;
            }
            z11 = z12;
        } else if (jVar2.q() == Object.class) {
            z11 = false;
        } else {
            z11 = z10;
        }
        t tVar = new t(set, set2, jVar3, jVar2, z11, hVar, oVar, oVar2);
        if (obj2 != null) {
            return tVar.withFilterId(obj2);
        }
        return tVar;
    }

    public static t n(Set set, j jVar, boolean z10, w3.h hVar, k3.o oVar, k3.o oVar2, Object obj) {
        return m(set, (Set) null, jVar, z10, hVar, oVar, oVar2, obj);
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.i(jVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0124, code lost:
        if (r0 != 5) goto L_0x015d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o b(k3.c0 r14, k3.d r15) {
        /*
            r13 = this;
            k3.b r0 = r14.W()
            r1 = 0
            if (r15 != 0) goto L_0x0009
            r2 = r1
            goto L_0x000d
        L_0x0009:
            r3.i r2 = r15.d()
        L_0x000d:
            boolean r3 = com.fasterxml.jackson.databind.ser.std.i0._neitherNull(r2, r0)
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r0.v(r2)
            if (r3 == 0) goto L_0x001e
            k3.o r3 = r14.t0(r2, r3)
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            java.lang.Object r4 = r0.g(r2)
            if (r4 == 0) goto L_0x002a
            k3.o r4 = r14.t0(r2, r4)
            goto L_0x002e
        L_0x002a:
            r4 = r1
            goto L_0x002e
        L_0x002c:
            r3 = r1
            r4 = r3
        L_0x002e:
            if (r4 != 0) goto L_0x0032
            k3.o r4 = r13.f5793f
        L_0x0032:
            k3.o r4 = r13.findContextualConvertingSerializer(r14, r15, r4)
            if (r4 != 0) goto L_0x004a
            boolean r5 = r13.f5789b
            if (r5 == 0) goto L_0x004a
            k3.j r5 = r13.f5791d
            boolean r5 = r5.I()
            if (r5 != 0) goto L_0x004a
            k3.j r4 = r13.f5791d
            k3.o r4 = r14.H(r4, r15)
        L_0x004a:
            r8 = r4
            if (r3 != 0) goto L_0x004f
            k3.o r3 = r13.f5792e
        L_0x004f:
            if (r3 != 0) goto L_0x0058
            k3.j r3 = r13.f5790c
            k3.o r3 = r14.J(r3, r15)
            goto L_0x005c
        L_0x0058:
            k3.o r3 = r14.i0(r3, r15)
        L_0x005c:
            r7 = r3
            java.util.Set r3 = r13.f5796i
            java.util.Set r4 = r13.f5797j
            boolean r5 = com.fasterxml.jackson.databind.ser.std.i0._neitherNull(r2, r0)
            r12 = 0
            if (r5 == 0) goto L_0x00d5
            k3.a0 r5 = r14.k()
            b3.p$a r6 = r0.K(r5, r2)
            java.util.Set r6 = r6.h()
            boolean r9 = com.fasterxml.jackson.databind.ser.std.i0._nonEmpty(r6)
            if (r9 == 0) goto L_0x009c
            if (r3 != 0) goto L_0x0082
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            goto L_0x0088
        L_0x0082:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>(r3)
            r3 = r9
        L_0x0088:
            java.util.Iterator r6 = r6.iterator()
        L_0x008c:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x009c
            java.lang.Object r9 = r6.next()
            java.lang.String r9 = (java.lang.String) r9
            r3.add(r9)
            goto L_0x008c
        L_0x009c:
            b3.s$a r5 = r0.N(r5, r2)
            java.util.Set r5 = r5.e()
            if (r5 == 0) goto L_0x00c8
            if (r4 != 0) goto L_0x00ae
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            goto L_0x00b4
        L_0x00ae:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>(r4)
            r4 = r6
        L_0x00b4:
            java.util.Iterator r5 = r5.iterator()
        L_0x00b8:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00c8
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            r4.add(r6)
            goto L_0x00b8
        L_0x00c8:
            java.lang.Boolean r5 = r0.W(r2)
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r5 = r6.equals(r5)
            r9 = r3
            r10 = r4
            goto L_0x00d8
        L_0x00d5:
            r9 = r3
            r10 = r4
            r5 = 0
        L_0x00d8:
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            b3.k$d r4 = r13.findFormatOverrides(r14, r15, r3)
            if (r4 == 0) goto L_0x00ee
            b3.k$a r6 = b3.k.a.WRITE_SORTED_MAP_ENTRIES
            java.lang.Boolean r4 = r4.e(r6)
            if (r4 == 0) goto L_0x00ee
            boolean r4 = r4.booleanValue()
            r11 = r4
            goto L_0x00ef
        L_0x00ee:
            r11 = r5
        L_0x00ef:
            r5 = r13
            r6 = r15
            com.fasterxml.jackson.databind.ser.std.t r4 = r5.z(r6, r7, r8, r9, r10, r11)
            if (r2 == 0) goto L_0x0101
            java.lang.Object r0 = r0.p(r2)
            if (r0 == 0) goto L_0x0101
            com.fasterxml.jackson.databind.ser.std.t r4 = r4.withFilterId(r0)
        L_0x0101:
            b3.r$b r15 = r13.findIncludeOverrides(r14, r15, r3)
            if (r15 == 0) goto L_0x0161
            b3.r$a r0 = r15.f()
            b3.r$a r2 = b3.r.a.USE_DEFAULTS
            if (r0 == r2) goto L_0x0161
            int[] r2 = com.fasterxml.jackson.databind.ser.std.t.a.f5803a
            int r0 = r0.ordinal()
            r0 = r2[r0]
            r2 = 1
            if (r0 == r2) goto L_0x0146
            r3 = 2
            if (r0 == r3) goto L_0x013a
            r3 = 3
            if (r0 == r3) goto L_0x0137
            r3 = 4
            if (r0 == r3) goto L_0x0127
            r14 = 5
            if (r0 == r14) goto L_0x015c
            goto L_0x015d
        L_0x0127:
            java.lang.Class r15 = r15.e()
            java.lang.Object r1 = r14.j0(r1, r15)
            if (r1 != 0) goto L_0x0132
            goto L_0x015c
        L_0x0132:
            boolean r12 = r14.k0(r1)
            goto L_0x015d
        L_0x0137:
            java.lang.Object r1 = f5787q
            goto L_0x015c
        L_0x013a:
            k3.j r14 = r13.f5791d
            boolean r14 = r14.b()
            if (r14 == 0) goto L_0x015c
            java.lang.Object r14 = f5787q
            r1 = r14
            goto L_0x015c
        L_0x0146:
            k3.j r14 = r13.f5791d
            java.lang.Object r1 = d4.e.b(r14)
            if (r1 == 0) goto L_0x015c
            java.lang.Class r14 = r1.getClass()
            boolean r14 = r14.isArray()
            if (r14 == 0) goto L_0x015c
            java.lang.Object r1 = d4.c.a(r1)
        L_0x015c:
            r12 = 1
        L_0x015d:
            com.fasterxml.jackson.databind.ser.std.t r4 = r4.x(r1, r12)
        L_0x0161:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.t.b(k3.c0, k3.d):k3.o");
    }

    public void e(String str) {
        d4.h.n0(t.class, this, str);
    }

    public final k3.o f(k kVar, Class cls, c0 c0Var) {
        k.d g10 = kVar.g(cls, c0Var, this.f5788a);
        k kVar2 = g10.f4357b;
        if (kVar != kVar2) {
            this.f5795h = kVar2;
        }
        return g10.f4356a;
    }

    public final k3.o g(k kVar, j jVar, c0 c0Var) {
        k.d h10 = kVar.h(jVar, c0Var, this.f5788a);
        k kVar2 = h10.f4357b;
        if (kVar != kVar2) {
            this.f5795h = kVar2;
        }
        return h10.f4356a;
    }

    public k3.m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("object", true);
    }

    public final k3.o h(c0 c0Var, Object obj) {
        Class<?> cls = obj.getClass();
        k3.o j10 = this.f5795h.j(cls);
        if (j10 != null) {
            return j10;
        }
        if (this.f5791d.w()) {
            return g(this.f5795h, c0Var.A(this.f5791d, cls), c0Var);
        }
        return f(this.f5795h, cls, c0Var);
    }

    public boolean i(Map map) {
        if (!(map instanceof HashMap) || !map.containsKey((Object) null)) {
            return false;
        }
        return true;
    }

    public Map j(Map map, c3.h hVar, c0 c0Var) {
        if (map instanceof SortedMap) {
            return map;
        }
        if (!i(map)) {
            return new TreeMap(map);
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                l(hVar, c0Var, entry.getValue());
            } else {
                treeMap.put(key, entry.getValue());
            }
        }
        return treeMap;
    }

    /* renamed from: k */
    public t c(w3.h hVar) {
        if (this.f5794g == hVar) {
            return this;
        }
        e("_withValueTypeSerializer");
        return new t(this, hVar, this.f5799l, this.f5800m);
    }

    public void l(c3.h hVar, c0 c0Var, Object obj) {
        k3.o oVar;
        k3.o K = c0Var.K(this.f5790c, this.f5788a);
        if (obj != null) {
            oVar = this.f5793f;
            if (oVar == null) {
                oVar = h(c0Var, obj);
            }
            Object obj2 = this.f5799l;
            if (obj2 == f5787q) {
                if (oVar.isEmpty(c0Var, obj)) {
                    return;
                }
            } else if (obj2 != null && obj2.equals(obj)) {
                return;
            }
        } else if (!this.f5800m) {
            oVar = c0Var.Z();
        } else {
            return;
        }
        try {
            K.serialize((Object) null, hVar, c0Var);
            oVar.serialize(obj, hVar, c0Var);
        } catch (Exception e10) {
            wrapAndThrow(c0Var, (Throwable) e10, obj, "");
        }
    }

    public j o() {
        return this.f5791d;
    }

    /* renamed from: p */
    public boolean isEmpty(c0 c0Var, Map map) {
        boolean z10;
        if (map.isEmpty()) {
            return true;
        }
        Object obj = this.f5799l;
        if (obj == null && !this.f5800m) {
            return false;
        }
        k3.o oVar = this.f5793f;
        if (f5787q == obj) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (oVar != null) {
            for (Object next : map.values()) {
                if (next == null) {
                    if (!this.f5800m) {
                        return false;
                    }
                } else if (z10) {
                    if (!oVar.isEmpty(c0Var, next)) {
                        return false;
                    }
                } else if (obj == null || !obj.equals(map)) {
                    return false;
                }
            }
            return true;
        }
        for (Object next2 : map.values()) {
            if (next2 != null) {
                try {
                    k3.o h10 = h(c0Var, next2);
                    if (!z10) {
                        if (obj != null && obj.equals(map)) {
                        }
                        return false;
                    } else if (!h10.isEmpty(c0Var, next2)) {
                        return false;
                    }
                } catch (l unused) {
                }
            } else if (!this.f5800m) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: q */
    public void serialize(Map map, c3.h hVar, c0 c0Var) {
        hVar.w0(map);
        w(map, hVar, c0Var);
        hVar.W();
    }

    public void r(Map map, c3.h hVar, c0 c0Var) {
        Object obj = null;
        if (this.f5794g != null) {
            u(map, hVar, c0Var, (Object) null);
            return;
        }
        k3.o oVar = this.f5792e;
        try {
            Object obj2 = null;
            for (Map.Entry entry : map.entrySet()) {
                try {
                    Object value = entry.getValue();
                    obj2 = entry.getKey();
                    if (obj2 == null) {
                        c0Var.K(this.f5790c, this.f5788a).serialize((Object) null, hVar, c0Var);
                    } else {
                        m.a aVar = this.f5801n;
                        if (aVar == null || !aVar.b(obj2)) {
                            oVar.serialize(obj2, hVar, c0Var);
                        }
                    }
                    if (value == null) {
                        c0Var.E(hVar);
                    } else {
                        k3.o oVar2 = this.f5793f;
                        if (oVar2 == null) {
                            oVar2 = h(c0Var, value);
                        }
                        oVar2.serialize(value, hVar, c0Var);
                    }
                } catch (Exception e10) {
                    e = e10;
                    obj = obj2;
                    wrapAndThrow(c0Var, (Throwable) e, (Object) map, String.valueOf(obj));
                }
            }
        } catch (Exception e11) {
            e = e11;
            wrapAndThrow(c0Var, (Throwable) e, (Object) map, String.valueOf(obj));
        }
    }

    public void s(Map map, c3.h hVar, c0 c0Var, k3.o oVar) {
        k3.o oVar2 = this.f5792e;
        w3.h hVar2 = this.f5794g;
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            m.a aVar = this.f5801n;
            if (aVar == null || !aVar.b(key)) {
                if (key == null) {
                    c0Var.K(this.f5790c, this.f5788a).serialize((Object) null, hVar, c0Var);
                } else {
                    oVar2.serialize(key, hVar, c0Var);
                }
                Object value = entry.getValue();
                if (value == null) {
                    c0Var.E(hVar);
                } else if (hVar2 == null) {
                    try {
                        oVar.serialize(value, hVar, c0Var);
                    } catch (Exception e10) {
                        wrapAndThrow(c0Var, (Throwable) e10, (Object) map, String.valueOf(key));
                    }
                } else {
                    oVar.serializeWithType(value, hVar, c0Var, hVar2);
                }
            }
        }
    }

    public void t(Map map, c3.h hVar, c0 c0Var, Object obj) {
        boolean z10;
        k3.o oVar;
        k3.o oVar2;
        if (this.f5794g != null) {
            u(map, hVar, c0Var, obj);
            return;
        }
        if (f5787q == obj) {
            z10 = true;
        } else {
            z10 = false;
        }
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                oVar = c0Var.K(this.f5790c, this.f5788a);
            } else {
                m.a aVar = this.f5801n;
                if (aVar == null || !aVar.b(key)) {
                    oVar = this.f5792e;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                oVar2 = this.f5793f;
                if (oVar2 == null) {
                    oVar2 = h(c0Var, value);
                }
                if (z10) {
                    if (oVar2.isEmpty(c0Var, value)) {
                    }
                } else if (obj != null && obj.equals(value)) {
                }
            } else if (!this.f5800m) {
                oVar2 = c0Var.Z();
            }
            try {
                oVar.serialize(key, hVar, c0Var);
                oVar2.serialize(value, hVar, c0Var);
            } catch (Exception e10) {
                wrapAndThrow(c0Var, (Throwable) e10, (Object) map, String.valueOf(key));
            }
        }
    }

    public void u(Map map, c3.h hVar, c0 c0Var, Object obj) {
        boolean z10;
        k3.o oVar;
        k3.o oVar2;
        if (f5787q == obj) {
            z10 = true;
        } else {
            z10 = false;
        }
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                oVar = c0Var.K(this.f5790c, this.f5788a);
            } else {
                m.a aVar = this.f5801n;
                if (aVar == null || !aVar.b(key)) {
                    oVar = this.f5792e;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                oVar2 = this.f5793f;
                if (oVar2 == null) {
                    oVar2 = h(c0Var, value);
                }
                if (z10) {
                    if (oVar2.isEmpty(c0Var, value)) {
                    }
                } else if (obj != null && obj.equals(value)) {
                }
            } else if (!this.f5800m) {
                oVar2 = c0Var.Z();
            }
            oVar.serialize(key, hVar, c0Var);
            try {
                oVar2.serializeWithType(value, hVar, c0Var, this.f5794g);
            } catch (Exception e10) {
                wrapAndThrow(c0Var, (Throwable) e10, (Object) map, String.valueOf(key));
            }
        }
    }

    /* renamed from: v */
    public void serializeWithType(Map map, c3.h hVar, c0 c0Var, w3.h hVar2) {
        hVar.z(map);
        b g10 = hVar2.g(hVar, hVar2.d(map, n.START_OBJECT));
        w(map, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public void w(Map map, c3.h hVar, c0 c0Var) {
        if (!map.isEmpty()) {
            if (this.f5802o || c0Var.m0(b0.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = j(map, hVar, c0Var);
            }
            Object obj = this.f5798k;
            if (obj != null) {
                findPropertyFilter(c0Var, obj, map);
            }
            Object obj2 = this.f5799l;
            if (obj2 != null || this.f5800m) {
                t(map, hVar, c0Var, obj2);
                return;
            }
            k3.o oVar = this.f5793f;
            if (oVar != null) {
                s(map, hVar, c0Var, oVar);
            } else {
                r(map, hVar, c0Var);
            }
        }
    }

    public t x(Object obj, boolean z10) {
        if (obj == this.f5799l && z10 == this.f5800m) {
            return this;
        }
        e("withContentInclusion");
        return new t(this, this.f5794g, obj, z10);
    }

    /* renamed from: y */
    public t withFilterId(Object obj) {
        if (this.f5798k == obj) {
            return this;
        }
        e("withFilterId");
        return new t(this, obj, this.f5802o);
    }

    public t z(d dVar, k3.o oVar, k3.o oVar2, Set set, Set set2, boolean z10) {
        e("withResolved");
        t tVar = new t(this, dVar, oVar, oVar2, set, set2);
        if (z10 != tVar.f5802o) {
            return new t(tVar, this.f5798k, z10);
        }
        return tVar;
    }

    public t(t tVar, d dVar, k3.o oVar, k3.o oVar2, Set set, Set set2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this.f5796i = set;
        this.f5797j = set2;
        this.f5790c = tVar.f5790c;
        this.f5791d = tVar.f5791d;
        this.f5789b = tVar.f5789b;
        this.f5794g = tVar.f5794g;
        this.f5792e = oVar;
        this.f5793f = oVar2;
        this.f5795h = k.c();
        this.f5788a = dVar;
        this.f5798k = tVar.f5798k;
        this.f5802o = tVar.f5802o;
        this.f5799l = tVar.f5799l;
        this.f5800m = tVar.f5800m;
        this.f5801n = m.a(set, set2);
    }

    public t(t tVar, w3.h hVar, Object obj, boolean z10) {
        super(Map.class, false);
        this.f5796i = tVar.f5796i;
        this.f5797j = tVar.f5797j;
        this.f5790c = tVar.f5790c;
        this.f5791d = tVar.f5791d;
        this.f5789b = tVar.f5789b;
        this.f5794g = hVar;
        this.f5792e = tVar.f5792e;
        this.f5793f = tVar.f5793f;
        this.f5795h = tVar.f5795h;
        this.f5788a = tVar.f5788a;
        this.f5798k = tVar.f5798k;
        this.f5802o = tVar.f5802o;
        this.f5799l = obj;
        this.f5800m = z10;
        this.f5801n = tVar.f5801n;
    }

    public t(t tVar, Object obj, boolean z10) {
        super(Map.class, false);
        this.f5796i = tVar.f5796i;
        this.f5797j = tVar.f5797j;
        this.f5790c = tVar.f5790c;
        this.f5791d = tVar.f5791d;
        this.f5789b = tVar.f5789b;
        this.f5794g = tVar.f5794g;
        this.f5792e = tVar.f5792e;
        this.f5793f = tVar.f5793f;
        this.f5795h = k.c();
        this.f5788a = tVar.f5788a;
        this.f5798k = obj;
        this.f5802o = z10;
        this.f5799l = tVar.f5799l;
        this.f5800m = tVar.f5800m;
        this.f5801n = tVar.f5801n;
    }
}
