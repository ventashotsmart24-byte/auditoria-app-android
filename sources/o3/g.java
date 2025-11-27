package o3;

import c3.k;
import c3.n;
import d4.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import k3.h;
import k3.j;
import n3.t;
import w3.e;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final j f8489a;

    /* renamed from: b  reason: collision with root package name */
    public final b[] f8490b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f8491c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f8492d;

    /* renamed from: e  reason: collision with root package name */
    public final y[] f8493e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final j f8494a;

        /* renamed from: b  reason: collision with root package name */
        public final List f8495b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public final Map f8496c = new HashMap();

        public a(j jVar) {
            this.f8494a = jVar;
        }

        public final void a(String str, Integer num) {
            Object obj = this.f8496c.get(str);
            if (obj == null) {
                this.f8496c.put(str, num);
            } else if (obj instanceof List) {
                ((List) obj).add(num);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(obj);
                linkedList.add(num);
                this.f8496c.put(str, linkedList);
            }
        }

        public void b(t tVar, e eVar) {
            Integer valueOf = Integer.valueOf(this.f8495b.size());
            this.f8495b.add(new b(tVar, eVar));
            a(tVar.getName(), valueOf);
            a(eVar.i(), valueOf);
        }

        public g c(c cVar) {
            int size = this.f8495b.size();
            b[] bVarArr = new b[size];
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = (b) this.f8495b.get(i10);
                t k10 = cVar.k(bVar.d());
                if (k10 != null) {
                    bVar.g(k10);
                }
                bVarArr[i10] = bVar;
            }
            return new g(this.f8494a, bVarArr, this.f8496c, (String[]) null, (y[]) null);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final t f8497a;

        /* renamed from: b  reason: collision with root package name */
        public final e f8498b;

        /* renamed from: c  reason: collision with root package name */
        public final String f8499c;

        /* renamed from: d  reason: collision with root package name */
        public t f8500d;

        public b(t tVar, e eVar) {
            this.f8497a = tVar;
            this.f8498b = eVar;
            this.f8499c = eVar.i();
        }

        public String a() {
            Class h10 = this.f8498b.h();
            if (h10 == null) {
                return null;
            }
            return this.f8498b.j().d((Object) null, h10);
        }

        public t b() {
            return this.f8497a;
        }

        public t c() {
            return this.f8500d;
        }

        public String d() {
            return this.f8499c;
        }

        public boolean e() {
            return this.f8498b.l();
        }

        public boolean f(String str) {
            return str.equals(this.f8499c);
        }

        public void g(t tVar) {
            this.f8500d = tVar;
        }
    }

    public g(j jVar, b[] bVarArr, Map map, String[] strArr, y[] yVarArr) {
        this.f8489a = jVar;
        this.f8490b = bVarArr;
        this.f8491c = map;
        this.f8492d = strArr;
        this.f8493e = yVarArr;
    }

    public static a d(j jVar) {
        return new a(jVar);
    }

    public final Object a(k kVar, k3.g gVar, int i10, String str) {
        k S0 = this.f8493e[i10].S0(kVar);
        if (S0.s0() == n.VALUE_NULL) {
            return null;
        }
        y yVar = new y(kVar, gVar);
        yVar.s0();
        yVar.z0(str);
        yVar.V0(S0);
        yVar.V();
        k S02 = yVar.S0(kVar);
        S02.s0();
        return this.f8490b[i10].b().k(S02, gVar);
    }

    public final void b(k kVar, k3.g gVar, Object obj, int i10, String str) {
        if (str == null) {
            gVar.y0(this.f8489a, "Internal error in external Type Id handling: `null` type id passed", new Object[0]);
        }
        k S0 = this.f8493e[i10].S0(kVar);
        if (S0.s0() == n.VALUE_NULL) {
            this.f8490b[i10].b().C(obj, (Object) null);
            return;
        }
        y yVar = new y(kVar, gVar);
        yVar.s0();
        yVar.z0(str);
        yVar.V0(S0);
        yVar.V();
        k S02 = yVar.S0(kVar);
        S02.s0();
        this.f8490b[i10].b().l(S02, gVar, obj);
    }

    public final boolean c(k kVar, k3.g gVar, String str, Object obj, String str2, int i10) {
        boolean z10 = false;
        if (!this.f8490b[i10].f(str)) {
            return false;
        }
        if (!(obj == null || this.f8493e[i10] == null)) {
            z10 = true;
        }
        if (z10) {
            b(kVar, gVar, obj, i10, str2);
            this.f8493e[i10] = null;
        } else {
            this.f8492d[i10] = str2;
        }
        return true;
    }

    public Object e(k kVar, k3.g gVar, Object obj) {
        int length = this.f8490b.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = this.f8492d[i10];
            b bVar = this.f8490b[i10];
            if (str == null) {
                y yVar = this.f8493e[i10];
                if (yVar != null) {
                    if (yVar.X0().e()) {
                        k S0 = yVar.S0(kVar);
                        S0.s0();
                        t b10 = bVar.b();
                        Object b11 = e.b(S0, gVar, b10.getType());
                        if (b11 != null) {
                            b10.C(obj, b11);
                        }
                    }
                    if (!bVar.e()) {
                        gVar.B0(this.f8489a, bVar.b().getName(), "Missing external type id property '%s' (and no 'defaultImpl' specified)", bVar.d());
                    } else {
                        str = bVar.a();
                        if (str == null) {
                            gVar.B0(this.f8489a, bVar.b().getName(), "Invalid default type id for property '%s': `null` returned by TypeIdResolver", bVar.d());
                        }
                    }
                }
            } else if (this.f8493e[i10] == null) {
                t b12 = bVar.b();
                if (b12.f() || gVar.n0(h.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                    gVar.A0(obj.getClass(), b12.getName(), "Missing property '%s' for external type id '%s'", b12.getName(), bVar.d());
                }
                return obj;
            }
            b(kVar, gVar, obj, i10, str);
        }
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (r13.n0(k3.h.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY) != false) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object f(c3.k r12, k3.g r13, o3.y r14, o3.v r15) {
        /*
            r11 = this;
            o3.g$b[] r0 = r11.f8490b
            int r0 = r0.length
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r3 = 0
        L_0x0007:
            if (r3 >= r0) goto L_0x00cf
            java.lang.String[] r4 = r11.f8492d
            r4 = r4[r3]
            o3.g$b[] r5 = r11.f8490b
            r5 = r5[r3]
            r6 = 1
            if (r4 != 0) goto L_0x0047
            d4.y[] r7 = r11.f8493e
            r7 = r7[r3]
            if (r7 == 0) goto L_0x00cb
            c3.n r7 = r7.X0()
            c3.n r8 = c3.n.VALUE_NULL
            if (r7 != r8) goto L_0x0024
            goto L_0x00cb
        L_0x0024:
            boolean r7 = r5.e()
            if (r7 != 0) goto L_0x0042
            k3.j r7 = r11.f8489a
            n3.t r8 = r5.b()
            java.lang.String r8 = r8.getName()
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r9 = r5.d()
            r6[r2] = r9
            java.lang.String r9 = "Missing external type id property '%s'"
            r13.B0(r7, r8, r9, r6)
            goto L_0x007d
        L_0x0042:
            java.lang.String r4 = r5.a()
            goto L_0x007d
        L_0x0047:
            d4.y[] r7 = r11.f8493e
            r7 = r7[r3]
            if (r7 != 0) goto L_0x007d
            n3.t r7 = r5.b()
            boolean r8 = r7.f()
            if (r8 != 0) goto L_0x005f
            k3.h r8 = k3.h.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY
            boolean r8 = r13.n0(r8)
            if (r8 == 0) goto L_0x007d
        L_0x005f:
            k3.j r8 = r11.f8489a
            java.lang.String r9 = r7.getName()
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.String r7 = r7.getName()
            r10[r2] = r7
            o3.g$b[] r7 = r11.f8490b
            r7 = r7[r3]
            java.lang.String r7 = r7.d()
            r10[r6] = r7
            java.lang.String r6 = "Missing property '%s' for external type id '%s'"
            r13.B0(r8, r9, r6, r10)
        L_0x007d:
            d4.y[] r6 = r11.f8493e
            r6 = r6[r3]
            if (r6 == 0) goto L_0x0089
            java.lang.Object r6 = r11.a(r12, r13, r3, r4)
            r1[r3] = r6
        L_0x0089:
            n3.t r6 = r5.b()
            int r7 = r6.p()
            if (r7 < 0) goto L_0x00cb
            r7 = r1[r3]
            r14.b(r6, r7)
            n3.t r5 = r5.c()
            if (r5 == 0) goto L_0x00cb
            int r6 = r5.p()
            if (r6 < 0) goto L_0x00cb
            k3.j r6 = r5.getType()
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            boolean r6 = r6.y(r7)
            if (r6 == 0) goto L_0x00b1
            goto L_0x00c8
        L_0x00b1:
            d4.y r6 = new d4.y
            r6.<init>((c3.k) r12, (k3.g) r13)
            r6.z0(r4)
            k3.k r4 = r5.u()
            c3.k r7 = r6.U0()
            java.lang.Object r4 = r4.deserialize(r7, r13)
            r6.close()
        L_0x00c8:
            r14.b(r5, r4)
        L_0x00cb:
            int r3 = r3 + 1
            goto L_0x0007
        L_0x00cf:
            java.lang.Object r12 = r15.a(r13, r14)
        L_0x00d3:
            if (r2 >= r0) goto L_0x00eb
            o3.g$b[] r13 = r11.f8490b
            r13 = r13[r2]
            n3.t r13 = r13.b()
            int r14 = r13.p()
            if (r14 >= 0) goto L_0x00e8
            r14 = r1[r2]
            r13.C(r12, r14)
        L_0x00e8:
            int r2 = r2 + 1
            goto L_0x00d3
        L_0x00eb:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.g.f(c3.k, k3.g, o3.y, o3.v):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0094, code lost:
        if (r10.f8493e[r0] != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00aa, code lost:
        if (r10.f8492d[r0] != null) goto L_0x0096;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(c3.k r11, k3.g r12, java.lang.String r13, java.lang.Object r14) {
        /*
            r10 = this;
            java.util.Map r0 = r10.f8491c
            java.lang.Object r0 = r0.get(r13)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            boolean r2 = r0 instanceof java.util.List
            r3 = 1
            if (r2 == 0) goto L_0x0073
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r14 = r0.iterator()
            java.lang.Object r0 = r14.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            o3.g$b[] r1 = r10.f8490b
            int r2 = r0.intValue()
            r1 = r1[r2]
            boolean r13 = r1.f(r13)
            if (r13 == 0) goto L_0x004d
            java.lang.String r12 = r11.Y()
            r11.D0()
            java.lang.String[] r11 = r10.f8492d
            int r13 = r0.intValue()
            r11[r13] = r12
        L_0x0038:
            boolean r11 = r14.hasNext()
            if (r11 == 0) goto L_0x0072
            java.lang.String[] r11 = r10.f8492d
            java.lang.Object r13 = r14.next()
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            r11[r13] = r12
            goto L_0x0038
        L_0x004d:
            d4.y r13 = new d4.y
            r13.<init>((c3.k) r11, (k3.g) r12)
            r13.V0(r11)
            d4.y[] r11 = r10.f8493e
            int r12 = r0.intValue()
            r11[r12] = r13
        L_0x005d:
            boolean r11 = r14.hasNext()
            if (r11 == 0) goto L_0x0072
            d4.y[] r11 = r10.f8493e
            java.lang.Object r12 = r14.next()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r11[r12] = r13
            goto L_0x005d
        L_0x0072:
            return r3
        L_0x0073:
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            o3.g$b[] r2 = r10.f8490b
            r2 = r2[r0]
            boolean r13 = r2.f(r13)
            if (r13 == 0) goto L_0x0098
            java.lang.String[] r13 = r10.f8492d
            java.lang.String r2 = r11.g0()
            r13[r0] = r2
            r11.D0()
            if (r14 == 0) goto L_0x00ad
            d4.y[] r13 = r10.f8493e
            r13 = r13[r0]
            if (r13 == 0) goto L_0x00ad
        L_0x0096:
            r1 = 1
            goto L_0x00ad
        L_0x0098:
            d4.y r13 = new d4.y
            r13.<init>((c3.k) r11, (k3.g) r12)
            r13.V0(r11)
            d4.y[] r2 = r10.f8493e
            r2[r0] = r13
            if (r14 == 0) goto L_0x00ad
            java.lang.String[] r13 = r10.f8492d
            r13 = r13[r0]
            if (r13 == 0) goto L_0x00ad
            goto L_0x0096
        L_0x00ad:
            if (r1 == 0) goto L_0x00c2
            java.lang.String[] r13 = r10.f8492d
            r9 = r13[r0]
            r1 = 0
            r13[r0] = r1
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r14
            r8 = r0
            r4.b(r5, r6, r7, r8, r9)
            d4.y[] r11 = r10.f8493e
            r11[r0] = r1
        L_0x00c2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.g.g(c3.k, k3.g, java.lang.String, java.lang.Object):boolean");
    }

    public boolean h(k kVar, k3.g gVar, String str, Object obj) {
        Object obj2 = this.f8491c.get(str);
        boolean z10 = false;
        if (obj2 == null) {
            return false;
        }
        String Y = kVar.Y();
        if (obj2 instanceof List) {
            for (Integer intValue : (List) obj2) {
                if (c(kVar, gVar, str, obj, Y, intValue.intValue())) {
                    z10 = true;
                }
            }
            return z10;
        }
        return c(kVar, gVar, str, obj, Y, ((Integer) obj2).intValue());
    }

    public g i() {
        return new g(this);
    }

    public g(g gVar) {
        this.f8489a = gVar.f8489a;
        b[] bVarArr = gVar.f8490b;
        this.f8490b = bVarArr;
        this.f8491c = gVar.f8491c;
        int length = bVarArr.length;
        this.f8492d = new String[length];
        this.f8493e = new y[length];
    }
}
