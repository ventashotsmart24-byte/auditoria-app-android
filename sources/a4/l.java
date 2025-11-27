package a4;

import b3.r;
import k3.a0;
import k3.b;
import k3.c;
import k3.j;
import k3.o;
import l3.f;
import r3.i;
import r3.s;
import w3.h;

public class l {

    /* renamed from: g  reason: collision with root package name */
    public static final Object f215g = Boolean.FALSE;

    /* renamed from: a  reason: collision with root package name */
    public final a0 f216a;

    /* renamed from: b  reason: collision with root package name */
    public final c f217b;

    /* renamed from: c  reason: collision with root package name */
    public final b f218c;

    /* renamed from: d  reason: collision with root package name */
    public Object f219d;

    /* renamed from: e  reason: collision with root package name */
    public final r.b f220e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f221f;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f222a;

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
                f222a = r0
                b3.r$a r1 = b3.r.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f222a     // Catch:{ NoSuchFieldError -> 0x001d }
                b3.r$a r1 = b3.r.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f222a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b3.r$a r1 = b3.r.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f222a     // Catch:{ NoSuchFieldError -> 0x0033 }
                b3.r$a r1 = b3.r.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f222a     // Catch:{ NoSuchFieldError -> 0x003e }
                b3.r$a r1 = b3.r.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f222a     // Catch:{ NoSuchFieldError -> 0x0049 }
                b3.r$a r1 = b3.r.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a4.l.a.<clinit>():void");
        }
    }

    public l(a0 a0Var, c cVar) {
        boolean z10;
        this.f216a = a0Var;
        this.f217b = cVar;
        r.b i10 = r.b.i(cVar.p(r.b.c()), a0Var.q(cVar.s(), r.b.c()));
        this.f220e = r.b.i(a0Var.P(), i10);
        if (i10.h() == r.a.NON_DEFAULT) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f221f = z10;
        this.f218c = a0Var.g();
    }

    public c a(s sVar, i iVar, d4.b bVar, j jVar, o oVar, h hVar, j jVar2, boolean z10, Object obj, Class[] clsArr) {
        return new c(sVar, iVar, bVar, jVar, oVar, hVar, jVar2, z10, obj, clsArr);
    }

    public Object b(Exception exc, String str, Object obj) {
        while (true) {
            Throwable cause = r3.getCause();
            Throwable th = exc;
            if (cause != null) {
                th = th.getCause();
            } else {
                d4.h.h0(th);
                d4.h.j0(th);
                throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + obj.getClass().getName() + " instance");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a4.c c(k3.c0 r16, r3.s r17, k3.j r18, k3.o r19, w3.h r20, w3.h r21, r3.i r22, boolean r23) {
        /*
            r15 = this;
            r12 = r15
            r13 = r16
            r2 = r17
            r5 = r18
            r0 = r21
            r14 = r22
            r1 = 0
            r3 = r23
            k3.j r3 = r15.d(r14, r3, r5)     // Catch:{ l -> 0x0152 }
            if (r0 == 0) goto L_0x0043
            if (r3 != 0) goto L_0x0017
            r3 = r5
        L_0x0017:
            k3.j r4 = r3.k()
            if (r4 != 0) goto L_0x003a
            k3.c r4 = r12.f217b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "serialization type "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r7 = " has no content"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r13.p0(r4, r2, r6, r7)
        L_0x003a:
            k3.j r0 = r3.S(r0)
            r0.k()
            r8 = r0
            goto L_0x0044
        L_0x0043:
            r8 = r3
        L_0x0044:
            if (r8 != 0) goto L_0x0048
            r0 = r5
            goto L_0x0049
        L_0x0048:
            r0 = r8
        L_0x0049:
            r3.i r3 = r17.l()
            if (r3 != 0) goto L_0x005c
            k3.c r0 = r12.f217b
            java.lang.String r3 = "could not determine property type"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object r0 = r13.p0(r0, r2, r3, r1)
            a4.c r0 = (a4.c) r0
            return r0
        L_0x005c:
            java.lang.Class r3 = r3.e()
            k3.a0 r4 = r12.f216a
            java.lang.Class r6 = r0.q()
            b3.r$b r7 = r12.f220e
            b3.r$b r3 = r4.m(r6, r3, r7)
            b3.r$b r4 = r17.g()
            b3.r$b r3 = r3.m(r4)
            b3.r$a r4 = r3.h()
            b3.r$a r6 = b3.r.a.USE_DEFAULTS
            if (r4 != r6) goto L_0x007e
            b3.r$a r4 = b3.r.a.ALWAYS
        L_0x007e:
            int[] r6 = a4.l.a.f222a
            int r4 = r4.ordinal()
            r4 = r6[r4]
            r6 = 1
            r7 = 0
            if (r4 == r6) goto L_0x00d1
            r9 = 2
            if (r4 == r9) goto L_0x00c5
            r9 = 3
            if (r4 == r9) goto L_0x00c1
            r9 = 4
            if (r4 == r9) goto L_0x00af
            r3 = 5
            if (r4 == r3) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r1 = 1
        L_0x0098:
            k3.b0 r3 = k3.b0.WRITE_EMPTY_JSON_ARRAYS
            boolean r0 = r0.D()
            if (r0 == 0) goto L_0x00ab
            k3.a0 r0 = r12.f216a
            boolean r0 = r0.c0(r3)
            if (r0 != 0) goto L_0x00ab
            java.lang.Object r0 = a4.c.f184t
            goto L_0x00be
        L_0x00ab:
            r9 = r1
            r10 = r7
            goto L_0x0114
        L_0x00af:
            java.lang.Class r0 = r3.g()
            java.lang.Object r0 = r13.j0(r2, r0)
            if (r0 != 0) goto L_0x00ba
            goto L_0x00c3
        L_0x00ba:
            boolean r1 = r13.k0(r0)
        L_0x00be:
            r10 = r0
            r9 = r1
            goto L_0x0114
        L_0x00c1:
            java.lang.Object r0 = a4.c.f184t
        L_0x00c3:
            r10 = r0
            goto L_0x00cf
        L_0x00c5:
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x00ce
            java.lang.Object r0 = a4.c.f184t
            goto L_0x00c3
        L_0x00ce:
            r10 = r7
        L_0x00cf:
            r9 = 1
            goto L_0x0114
        L_0x00d1:
            boolean r3 = r12.f221f
            if (r3 == 0) goto L_0x00fd
            java.lang.Object r3 = r15.e()
            if (r3 == 0) goto L_0x00fd
            k3.q r0 = k3.q.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r0 = r13.l0(r0)
            if (r0 == 0) goto L_0x00ee
            k3.a0 r0 = r12.f216a
            k3.q r4 = k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS
            boolean r0 = r0.D(r4)
            r14.i(r0)
        L_0x00ee:
            java.lang.Object r7 = r14.n(r3)     // Catch:{ Exception -> 0x00f3 }
            goto L_0x0102
        L_0x00f3:
            r0 = move-exception
            r4 = r0
            java.lang.String r0 = r17.getName()
            r15.b(r4, r0, r3)
            goto L_0x0102
        L_0x00fd:
            java.lang.Object r7 = d4.e.b(r0)
            r1 = 1
        L_0x0102:
            if (r7 != 0) goto L_0x0105
            goto L_0x00ce
        L_0x0105:
            java.lang.Class r0 = r7.getClass()
            boolean r0 = r0.isArray()
            if (r0 == 0) goto L_0x00ab
            java.lang.Object r0 = d4.c.a(r7)
            goto L_0x00be
        L_0x0114:
            java.lang.Class[] r0 = r17.k()
            if (r0 != 0) goto L_0x0120
            k3.c r0 = r12.f217b
            java.lang.Class[] r0 = r0.e()
        L_0x0120:
            r11 = r0
            k3.c r0 = r12.f217b
            d4.b r4 = r0.t()
            r1 = r15
            r2 = r17
            r3 = r22
            r5 = r18
            r6 = r19
            r7 = r20
            a4.c r0 = r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            k3.b r1 = r12.f218c
            java.lang.Object r1 = r1.A(r14)
            if (r1 == 0) goto L_0x0145
            k3.o r1 = r13.t0(r14, r1)
            r0.k(r1)
        L_0x0145:
            k3.b r1 = r12.f218c
            d4.q r1 = r1.d0(r14)
            if (r1 == 0) goto L_0x0151
            a4.c r0 = r0.C(r1)
        L_0x0151:
            return r0
        L_0x0152:
            r0 = move-exception
            r3 = r0
            if (r2 != 0) goto L_0x0161
            java.lang.String r0 = d4.h.o(r3)
            java.lang.Object r0 = r13.q(r5, r0)
            a4.c r0 = (a4.c) r0
            return r0
        L_0x0161:
            k3.c r0 = r12.f217b
            java.lang.String r3 = d4.h.o(r3)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object r0 = r13.p0(r0, r2, r3, r1)
            a4.c r0 = (a4.c) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.l.c(k3.c0, r3.s, k3.j, k3.o, w3.h, w3.h, r3.i, boolean):a4.c");
    }

    public j d(r3.b bVar, boolean z10, j jVar) {
        j v02 = this.f218c.v0(this.f216a, bVar, jVar);
        boolean z11 = true;
        if (v02 != jVar) {
            Class q10 = v02.q();
            Class q11 = jVar.q();
            if (!q10.isAssignableFrom(q11) && !q11.isAssignableFrom(q10)) {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + bVar.d() + "': class " + q10.getName() + " not a super-type of (declared) class " + q11.getName());
            }
            jVar = v02;
            z10 = true;
        }
        f.b X = this.f218c.X(bVar);
        if (!(X == null || X == f.b.DEFAULT_TYPING)) {
            if (X != f.b.STATIC) {
                z11 = false;
            }
            z10 = z11;
        }
        if (z10) {
            return jVar.V();
        }
        return null;
    }

    public Object e() {
        Object obj = this.f219d;
        if (obj == null) {
            obj = this.f217b.B(this.f216a.b());
            if (obj == null) {
                obj = f215g;
            }
            this.f219d = obj;
        }
        if (obj == f215g) {
            return null;
        }
        return this.f219d;
    }
}
