package a4;

import b3.k;
import b3.r;
import c4.j;
import com.fasterxml.jackson.databind.ser.std.d0;
import com.fasterxml.jackson.databind.ser.std.e;
import com.fasterxml.jackson.databind.ser.std.e0;
import com.fasterxml.jackson.databind.ser.std.g;
import com.fasterxml.jackson.databind.ser.std.h;
import com.fasterxml.jackson.databind.ser.std.j0;
import com.fasterxml.jackson.databind.ser.std.k;
import com.fasterxml.jackson.databind.ser.std.k0;
import com.fasterxml.jackson.databind.ser.std.l0;
import com.fasterxml.jackson.databind.ser.std.m;
import com.fasterxml.jackson.databind.ser.std.n0;
import com.fasterxml.jackson.databind.ser.std.s;
import com.fasterxml.jackson.databind.ser.std.t;
import com.fasterxml.jackson.databind.ser.std.v;
import com.fasterxml.jackson.databind.ser.std.w;
import d4.y;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import k3.a0;
import k3.b0;
import k3.c;
import k3.c0;
import k3.d;
import k3.n;
import k3.o;
import k3.q;
import l3.f;
import m3.p;
import r3.i;

public abstract class b extends q implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap f179b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap f180c;

    /* renamed from: a  reason: collision with root package name */
    public final p f181a;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f182a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f183b;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        static {
            /*
                b3.r$a[] r0 = b3.r.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f183b = r0
                r1 = 1
                b3.r$a r2 = b3.r.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f183b     // Catch:{ NoSuchFieldError -> 0x001d }
                b3.r$a r3 = b3.r.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f183b     // Catch:{ NoSuchFieldError -> 0x0028 }
                b3.r$a r4 = b3.r.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f183b     // Catch:{ NoSuchFieldError -> 0x0033 }
                b3.r$a r4 = b3.r.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f183b     // Catch:{ NoSuchFieldError -> 0x003e }
                b3.r$a r4 = b3.r.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f183b     // Catch:{ NoSuchFieldError -> 0x0049 }
                b3.r$a r4 = b3.r.a.USE_DEFAULTS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                b3.k$c[] r3 = b3.k.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f182a = r3
                b3.k$c r4 = b3.k.c.STRING     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f182a     // Catch:{ NoSuchFieldError -> 0x0064 }
                b3.k$c r3 = b3.k.c.OBJECT     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f182a     // Catch:{ NoSuchFieldError -> 0x006e }
                b3.k$c r1 = b3.k.c.ARRAY     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a4.b.a.<clinit>():void");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(String.class.getName(), new j0());
        l0 l0Var = l0.f5771a;
        hashMap2.put(StringBuffer.class.getName(), l0Var);
        hashMap2.put(StringBuilder.class.getName(), l0Var);
        hashMap2.put(Character.class.getName(), l0Var);
        hashMap2.put(Character.TYPE.getName(), l0Var);
        w.a(hashMap2);
        hashMap2.put(Boolean.TYPE.getName(), new e(true));
        hashMap2.put(Boolean.class.getName(), new e(false));
        Class<BigInteger> cls = BigInteger.class;
        hashMap2.put(cls.getName(), new v(cls));
        Class<BigDecimal> cls2 = BigDecimal.class;
        hashMap2.put(cls2.getName(), new v(cls2));
        hashMap2.put(Calendar.class.getName(), h.f5766d);
        hashMap2.put(Date.class.getName(), k.f5767d);
        for (Map.Entry entry : e0.a()) {
            Object value = entry.getValue();
            if (value instanceof o) {
                hashMap2.put(((Class) entry.getKey()).getName(), (o) value);
            } else {
                hashMap.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        hashMap.put(y.class.getName(), n0.class);
        f179b = hashMap2;
        f180c = hashMap;
    }

    public b(p pVar) {
        this.f181a = pVar == null ? new p() : pVar;
    }

    public o A(c0 c0Var, j jVar, c cVar, boolean z10) {
        k3.j k10 = jVar.k();
        w3.h hVar = (w3.h) k10.t();
        a0 Y = c0Var.k();
        if (hVar == null) {
            hVar = c(Y, k10);
        }
        w3.h hVar2 = hVar;
        o oVar = (o) k10.u();
        for (r d10 : v()) {
            o d11 = d10.d(Y, jVar, cVar, hVar2, oVar);
            if (d11 != null) {
                return d11;
            }
        }
        if (jVar.N(AtomicReference.class)) {
            return k(c0Var, jVar, cVar, z10, hVar2, oVar);
        }
        return null;
    }

    public final o B(a0 a0Var, k3.j jVar, c cVar, boolean z10) {
        k3.j jVar2;
        k3.j jVar3;
        Class q10 = jVar.q();
        Class<Iterator> cls = Iterator.class;
        if (cls.isAssignableFrom(q10)) {
            k3.j[] K = a0Var.z().K(jVar, cls);
            if (K == null || K.length != 1) {
                jVar3 = c4.o.O();
            } else {
                jVar3 = K[0];
            }
            return s(a0Var, jVar, cVar, z10, jVar3);
        }
        Class<Iterable> cls2 = Iterable.class;
        if (cls2.isAssignableFrom(q10)) {
            k3.j[] K2 = a0Var.z().K(jVar, cls2);
            if (K2 == null || K2.length != 1) {
                jVar2 = c4.o.O();
            } else {
                jVar2 = K2[0];
            }
            return r(a0Var, jVar, cVar, z10, jVar2);
        } else if (CharSequence.class.isAssignableFrom(q10)) {
            return l0.f5771a;
        } else {
            return null;
        }
    }

    public final o C(c0 c0Var, k3.j jVar, c cVar) {
        if (n.class.isAssignableFrom(jVar.q())) {
            return com.fasterxml.jackson.databind.ser.std.a0.f5729a;
        }
        i k10 = cVar.k();
        if (k10 == null) {
            return null;
        }
        if (c0Var.z()) {
            d4.h.g(k10.m(), c0Var.l0(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        k3.j f10 = k10.f();
        o F = F(c0Var, k10);
        if (F == null) {
            F = (o) f10.u();
        }
        w3.h hVar = (w3.h) f10.t();
        if (hVar == null) {
            hVar = c(c0Var.k(), f10);
        }
        return new s(k10, hVar, F);
    }

    public final o D(k3.j jVar, a0 a0Var, c cVar, boolean z10) {
        Class cls;
        String name = jVar.q().getName();
        o oVar = (o) f179b.get(name);
        if (oVar != null || (cls = (Class) f180c.get(name)) == null) {
            return oVar;
        }
        return (o) d4.h.l(cls, false);
    }

    public final o E(c0 c0Var, k3.j jVar, c cVar, boolean z10) {
        if (jVar.F()) {
            return o(c0Var.k(), jVar, cVar);
        }
        Class q10 = jVar.q();
        o z11 = z(c0Var, jVar, cVar, z10);
        if (z11 != null) {
            return z11;
        }
        if (Calendar.class.isAssignableFrom(q10)) {
            return h.f5766d;
        }
        if (Date.class.isAssignableFrom(q10)) {
            return k.f5767d;
        }
        Class<Map.Entry> cls = Map.Entry.class;
        if (cls.isAssignableFrom(q10)) {
            k3.j i10 = jVar.i(cls);
            return t(c0Var, jVar, cVar, z10, i10.h(0), i10.h(1));
        } else if (ByteBuffer.class.isAssignableFrom(q10)) {
            return new g();
        } else {
            if (InetAddress.class.isAssignableFrom(q10)) {
                return new com.fasterxml.jackson.databind.ser.std.p();
            }
            if (InetSocketAddress.class.isAssignableFrom(q10)) {
                return new com.fasterxml.jackson.databind.ser.std.q();
            }
            if (TimeZone.class.isAssignableFrom(q10)) {
                return new k0();
            }
            if (Charset.class.isAssignableFrom(q10)) {
                return l0.f5771a;
            }
            if (!Number.class.isAssignableFrom(q10)) {
                return null;
            }
            int i11 = a.f182a[cVar.g((k.d) null).i().ordinal()];
            if (i11 == 1) {
                return l0.f5771a;
            }
            if (i11 == 2 || i11 == 3) {
                return null;
            }
            return v.f5805b;
        }
    }

    public o F(c0 c0Var, r3.b bVar) {
        Object Y = c0Var.W().Y(bVar);
        if (Y == null) {
            return null;
        }
        return x(c0Var, bVar, c0Var.t0(bVar, Y));
    }

    public boolean G(Class cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    public boolean H(a0 a0Var, c cVar, w3.h hVar) {
        if (hVar != null) {
            return false;
        }
        f.b X = a0Var.g().X(cVar.u());
        if (X == null || X == f.b.DEFAULT_TYPING) {
            return a0Var.D(q.USE_STATIC_TYPING);
        }
        if (X == f.b.STATIC) {
            return true;
        }
        return false;
    }

    public abstract q I(p pVar);

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001c A[LOOP:0: B:3:0x001c->B:6:0x002c, LOOP_START, PHI: r4 
      PHI: (r4v4 k3.o) = (r4v3 k3.o), (r4v7 k3.o) binds: [B:2:0x0011, B:6:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o a(k3.c0 r7, k3.j r8, k3.o r9) {
        /*
            r6 = this;
            k3.a0 r0 = r7.k()
            k3.c r1 = r0.b0(r8)
            m3.p r2 = r6.f181a
            boolean r2 = r2.a()
            r3 = 0
            if (r2 == 0) goto L_0x002f
            m3.p r2 = r6.f181a
            java.lang.Iterable r2 = r2.c()
            java.util.Iterator r2 = r2.iterator()
            r4 = r3
        L_0x001c:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0030
            java.lang.Object r4 = r2.next()
            a4.r r4 = (a4.r) r4
            k3.o r4 = r4.c(r0, r8, r1)
            if (r4 == 0) goto L_0x001c
            goto L_0x0030
        L_0x002f:
            r4 = r3
        L_0x0030:
            if (r4 != 0) goto L_0x0081
            r3.c r2 = r1.u()
            k3.o r2 = r6.i(r7, r2)
            if (r2 != 0) goto L_0x007f
            if (r9 != 0) goto L_0x0082
            java.lang.Class r2 = r8.q()
            r4 = 0
            k3.o r2 = com.fasterxml.jackson.databind.ser.std.g0.b(r0, r2, r4)
            if (r2 != 0) goto L_0x007f
            r3.i r2 = r1.j()
            if (r2 != 0) goto L_0x0053
            r3.i r2 = r1.k()
        L_0x0053:
            if (r2 == 0) goto L_0x0076
            k3.j r8 = r2.f()
            k3.o r7 = r6.a(r7, r8, r9)
            boolean r8 = r0.b()
            if (r8 == 0) goto L_0x0070
            java.lang.reflect.Member r8 = r2.m()
            k3.q r9 = k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS
            boolean r9 = r0.D(r9)
            d4.h.g(r8, r9)
        L_0x0070:
            com.fasterxml.jackson.databind.ser.std.s r9 = new com.fasterxml.jackson.databind.ser.std.s
            r9.<init>(r2, r3, r7)
            goto L_0x0082
        L_0x0076:
            java.lang.Class r7 = r8.q()
            k3.o r9 = com.fasterxml.jackson.databind.ser.std.g0.a(r0, r7)
            goto L_0x0082
        L_0x007f:
            r9 = r2
            goto L_0x0082
        L_0x0081:
            r9 = r4
        L_0x0082:
            m3.p r7 = r6.f181a
            boolean r7 = r7.b()
            if (r7 == 0) goto L_0x00a3
            m3.p r7 = r6.f181a
            java.lang.Iterable r7 = r7.d()
            java.util.Iterator r7 = r7.iterator()
            boolean r8 = r7.hasNext()
            if (r8 != 0) goto L_0x009b
            goto L_0x00a3
        L_0x009b:
            java.lang.Object r7 = r7.next()
            androidx.appcompat.app.m.a(r7)
            throw r3
        L_0x00a3:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.b.a(k3.c0, k3.j, k3.o):k3.o");
    }

    public w3.h c(a0 a0Var, k3.j jVar) {
        Collection collection;
        r3.c u10 = a0Var.A(jVar.q()).u();
        w3.g c02 = a0Var.g().c0(a0Var, u10, jVar);
        if (c02 == null) {
            c02 = a0Var.s(jVar);
            collection = null;
        } else {
            collection = a0Var.T().a(a0Var, u10);
        }
        if (c02 == null) {
            return null;
        }
        return c02.b(a0Var, jVar, collection);
    }

    public final q d(r rVar) {
        return I(this.f181a.f(rVar));
    }

    public final q e(r rVar) {
        return I(this.f181a.g(rVar));
    }

    public t f(c0 c0Var, c cVar, t tVar) {
        r.a aVar;
        k3.j o10 = tVar.o();
        r.b h10 = h(c0Var, cVar, o10, Map.class);
        if (h10 == null) {
            aVar = r.a.USE_DEFAULTS;
        } else {
            aVar = h10.f();
        }
        boolean z10 = true;
        Object obj = null;
        if (aVar != r.a.USE_DEFAULTS && aVar != r.a.ALWAYS) {
            int i10 = a.f183b[aVar.ordinal()];
            if (i10 == 1) {
                obj = d4.e.b(o10);
                if (obj != null && obj.getClass().isArray()) {
                    obj = d4.c.a(obj);
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    obj = t.f5787q;
                } else if (i10 == 4 && (obj = c0Var.j0((r3.s) null, h10.e())) != null) {
                    z10 = c0Var.k0(obj);
                }
            } else if (o10.b()) {
                obj = t.f5787q;
            }
            return tVar.x(obj, z10);
        } else if (!c0Var.m0(b0.WRITE_NULL_MAP_VALUES)) {
            return tVar.x((Object) null, true);
        } else {
            return tVar;
        }
    }

    public o g(c0 c0Var, r3.b bVar) {
        Object g10 = c0Var.W().g(bVar);
        if (g10 != null) {
            return c0Var.t0(bVar, g10);
        }
        return null;
    }

    public r.b h(c0 c0Var, c cVar, k3.j jVar, Class cls) {
        a0 Y = c0Var.k();
        r.b q10 = Y.q(cls, cVar.p(Y.P()));
        r.b q11 = Y.q(jVar.q(), (r.b) null);
        if (q11 == null) {
            return q10;
        }
        int i10 = a.f183b[q11.h().ordinal()];
        if (i10 == 4) {
            return q10.k(q11.e());
        }
        if (i10 != 6) {
            return q10.l(q11.h());
        }
        return q10;
    }

    public o i(c0 c0Var, r3.b bVar) {
        Object v10 = c0Var.W().v(bVar);
        if (v10 != null) {
            return c0Var.t0(bVar, v10);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x000e A[LOOP:0: B:1:0x000e->B:4:0x0023, LOOP_START, PHI: r0 
      PHI: (r0v2 k3.o) = (r0v1 k3.o), (r0v11 k3.o) binds: [B:0:0x0000, B:4:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o j(k3.c0 r9, c4.a r10, k3.c r11, boolean r12, w3.h r13, k3.o r14) {
        /*
            r8 = this;
            k3.a0 r9 = r9.k()
            java.lang.Iterable r0 = r8.v()
            java.util.Iterator r6 = r0.iterator()
            r7 = 0
            r0 = r7
        L_0x000e:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0025
            java.lang.Object r0 = r6.next()
            a4.r r0 = (a4.r) r0
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r13
            r5 = r14
            k3.o r0 = r0.b(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x000e
        L_0x0025:
            if (r0 != 0) goto L_0x0049
            java.lang.Class r9 = r10.q()
            if (r14 == 0) goto L_0x0033
            boolean r11 = d4.h.O(r14)
            if (r11 == 0) goto L_0x003e
        L_0x0033:
            java.lang.Class<java.lang.String[]> r11 = java.lang.String[].class
            if (r11 != r9) goto L_0x003a
            b4.m r0 = b4.m.f4371e
            goto L_0x003e
        L_0x003a:
            k3.o r0 = com.fasterxml.jackson.databind.ser.std.c0.a(r9)
        L_0x003e:
            if (r0 != 0) goto L_0x0049
            com.fasterxml.jackson.databind.ser.std.x r0 = new com.fasterxml.jackson.databind.ser.std.x
            k3.j r9 = r10.k()
            r0.<init>(r9, r12, r13, r14)
        L_0x0049:
            m3.p r9 = r8.f181a
            boolean r9 = r9.b()
            if (r9 == 0) goto L_0x006a
            m3.p r9 = r8.f181a
            java.lang.Iterable r9 = r9.d()
            java.util.Iterator r9 = r9.iterator()
            boolean r10 = r9.hasNext()
            if (r10 != 0) goto L_0x0062
            goto L_0x006a
        L_0x0062:
            java.lang.Object r9 = r9.next()
            androidx.appcompat.app.m.a(r9)
            throw r7
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.b.j(k3.c0, c4.a, k3.c, boolean, w3.h, k3.o):k3.o");
    }

    public o k(c0 c0Var, j jVar, c cVar, boolean z10, w3.h hVar, o oVar) {
        r.a aVar;
        boolean z11;
        k3.j r10 = jVar.a();
        r.b h10 = h(c0Var, cVar, r10, AtomicReference.class);
        if (h10 == null) {
            aVar = r.a.USE_DEFAULTS;
        } else {
            aVar = h10.f();
        }
        Object obj = null;
        if (aVar == r.a.USE_DEFAULTS || aVar == r.a.ALWAYS) {
            z11 = false;
        } else {
            int i10 = a.f183b[aVar.ordinal()];
            z11 = true;
            if (i10 == 1) {
                obj = d4.e.b(r10);
                if (obj != null && obj.getClass().isArray()) {
                    obj = d4.c.a(obj);
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    obj = t.f5787q;
                } else if (i10 == 4 && (obj = c0Var.j0((r3.s) null, h10.e())) != null) {
                    z11 = c0Var.k0(obj);
                }
            } else if (r10.b()) {
                obj = t.f5787q;
            }
        }
        return new com.fasterxml.jackson.databind.ser.std.c(jVar, z10, hVar, oVar).i(obj, z11);
    }

    public h l(k3.j jVar, boolean z10, w3.h hVar, o oVar) {
        return new com.fasterxml.jackson.databind.ser.std.j(jVar, z10, hVar, oVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x000e A[LOOP:0: B:1:0x000e->B:4:0x0023, LOOP_START, PHI: r0 
      PHI: (r0v2 k3.o) = (r0v1 k3.o), (r0v12 k3.o) binds: [B:0:0x0000, B:4:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o m(k3.c0 r10, c4.e r11, k3.c r12, boolean r13, w3.h r14, k3.o r15) {
        /*
            r9 = this;
            k3.a0 r6 = r10.k()
            java.lang.Iterable r0 = r9.v()
            java.util.Iterator r7 = r0.iterator()
            r8 = 0
            r0 = r8
        L_0x000e:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0025
            java.lang.Object r0 = r7.next()
            a4.r r0 = (a4.r) r0
            r1 = r6
            r2 = r11
            r3 = r12
            r4 = r14
            r5 = r15
            k3.o r0 = r0.a(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x000e
        L_0x0025:
            if (r0 != 0) goto L_0x0090
            k3.o r0 = r9.C(r10, r11, r12)
            if (r0 != 0) goto L_0x0090
            b3.k$d r10 = r12.g(r8)
            b3.k$c r10 = r10.i()
            b3.k$c r12 = b3.k.c.OBJECT
            if (r10 != r12) goto L_0x003a
            return r8
        L_0x003a:
            java.lang.Class r10 = r11.q()
            java.lang.Class<java.util.EnumSet> r12 = java.util.EnumSet.class
            boolean r12 = r12.isAssignableFrom(r10)
            if (r12 == 0) goto L_0x0056
            k3.j r10 = r11.k()
            boolean r11 = r10.E()
            if (r11 != 0) goto L_0x0051
            r10 = r8
        L_0x0051:
            k3.o r0 = r9.p(r10)
            goto L_0x0090
        L_0x0056:
            k3.j r12 = r11.k()
            java.lang.Class r12 = r12.q()
            boolean r10 = r9.G(r10)
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r10 == 0) goto L_0x007b
            if (r12 != r1) goto L_0x0071
            boolean r10 = d4.h.O(r15)
            if (r10 == 0) goto L_0x0086
            b4.f r10 = b4.f.f4328b
            goto L_0x0079
        L_0x0071:
            k3.j r10 = r11.k()
            a4.h r10 = r9.q(r10, r13, r14, r15)
        L_0x0079:
            r0 = r10
            goto L_0x0086
        L_0x007b:
            if (r12 != r1) goto L_0x0086
            boolean r10 = d4.h.O(r15)
            if (r10 == 0) goto L_0x0086
            b4.n r10 = b4.n.f4373b
            goto L_0x0079
        L_0x0086:
            if (r0 != 0) goto L_0x0090
            k3.j r10 = r11.k()
            a4.h r0 = r9.l(r10, r13, r14, r15)
        L_0x0090:
            m3.p r10 = r9.f181a
            boolean r10 = r10.b()
            if (r10 == 0) goto L_0x00b1
            m3.p r10 = r9.f181a
            java.lang.Iterable r10 = r10.d()
            java.util.Iterator r10 = r10.iterator()
            boolean r11 = r10.hasNext()
            if (r11 != 0) goto L_0x00a9
            goto L_0x00b1
        L_0x00a9:
            java.lang.Object r10 = r10.next()
            androidx.appcompat.app.m.a(r10)
            throw r8
        L_0x00b1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.b.m(k3.c0, c4.e, k3.c, boolean, w3.h, k3.o):k3.o");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[LOOP:0: B:21:0x006d->B:24:0x0087, LOOP_START, PHI: r4 
      PHI: (r4v3 k3.o) = (r4v2 k3.o), (r4v8 k3.o) binds: [B:20:0x0063, B:24:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd A[LOOP:1: B:42:0x00dd->B:45:0x00f5, LOOP_START, PHI: r2 
      PHI: (r2v9 k3.o) = (r2v8 k3.o), (r2v15 k3.o) binds: [B:41:0x00d3, B:45:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o n(k3.c0 r20, k3.j r21, k3.c r22, boolean r23) {
        /*
            r19 = this;
            r8 = r19
            r1 = r20
            k3.a0 r0 = r20.k()
            if (r23 != 0) goto L_0x0022
            boolean r2 = r21.Q()
            if (r2 == 0) goto L_0x0022
            boolean r2 = r21.D()
            if (r2 == 0) goto L_0x0020
            k3.j r2 = r21.k()
            boolean r2 = r2.I()
            if (r2 != 0) goto L_0x0022
        L_0x0020:
            r2 = 1
            goto L_0x0024
        L_0x0022:
            r2 = r23
        L_0x0024:
            k3.j r3 = r21.k()
            w3.h r16 = r8.c(r0, r3)
            if (r16 == 0) goto L_0x0031
            r2 = 0
            r4 = 0
            goto L_0x0032
        L_0x0031:
            r4 = r2
        L_0x0032:
            r3.c r2 = r22.u()
            k3.o r17 = r8.g(r1, r2)
            boolean r2 = r21.J()
            r18 = 0
            if (r2 == 0) goto L_0x00b3
            r2 = r21
            c4.g r2 = (c4.g) r2
            r3.c r3 = r22.u()
            k3.o r5 = r8.i(r1, r3)
            boolean r3 = r2 instanceof c4.h
            if (r3 == 0) goto L_0x0063
            c4.h r2 = (c4.h) r2
            r0 = r19
            r1 = r20
            r3 = r22
            r6 = r16
            r7 = r17
            k3.o r0 = r0.u(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x0063:
            java.lang.Iterable r3 = r19.v()
            java.util.Iterator r3 = r3.iterator()
            r4 = r18
        L_0x006d:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0089
            java.lang.Object r4 = r3.next()
            r9 = r4
            a4.r r9 = (a4.r) r9
            r10 = r0
            r11 = r2
            r12 = r22
            r13 = r5
            r14 = r16
            r15 = r17
            k3.o r4 = r9.g(r10, r11, r12, r13, r14, r15)
            if (r4 == 0) goto L_0x006d
        L_0x0089:
            if (r4 != 0) goto L_0x008f
            k3.o r4 = r19.C(r20, r21, r22)
        L_0x008f:
            if (r4 == 0) goto L_0x00b2
            m3.p r0 = r8.f181a
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x00b2
            m3.p r0 = r8.f181a
            java.lang.Iterable r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x00aa
            goto L_0x00b2
        L_0x00aa:
            java.lang.Object r0 = r0.next()
            androidx.appcompat.app.m.a(r0)
            throw r18
        L_0x00b2:
            return r4
        L_0x00b3:
            boolean r2 = r21.B()
            if (r2 == 0) goto L_0x0121
            r9 = r21
            c4.d r9 = (c4.d) r9
            boolean r2 = r9 instanceof c4.e
            if (r2 == 0) goto L_0x00d3
            r2 = r9
            c4.e r2 = (c4.e) r2
            r0 = r19
            r1 = r20
            r3 = r22
            r5 = r16
            r6 = r17
            k3.o r0 = r0.m(r1, r2, r3, r4, r5, r6)
            return r0
        L_0x00d3:
            java.lang.Iterable r2 = r19.v()
            java.util.Iterator r10 = r2.iterator()
            r2 = r18
        L_0x00dd:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x00f7
            java.lang.Object r2 = r10.next()
            a4.r r2 = (a4.r) r2
            r3 = r0
            r4 = r9
            r5 = r22
            r6 = r16
            r7 = r17
            k3.o r2 = r2.f(r3, r4, r5, r6, r7)
            if (r2 == 0) goto L_0x00dd
        L_0x00f7:
            if (r2 != 0) goto L_0x00fd
            k3.o r2 = r19.C(r20, r21, r22)
        L_0x00fd:
            if (r2 == 0) goto L_0x0120
            m3.p r0 = r8.f181a
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0120
            m3.p r0 = r8.f181a
            java.lang.Iterable r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x0118
            goto L_0x0120
        L_0x0118:
            java.lang.Object r0 = r0.next()
            androidx.appcompat.app.m.a(r0)
            throw r18
        L_0x0120:
            return r2
        L_0x0121:
            boolean r0 = r21.A()
            if (r0 == 0) goto L_0x013a
            r2 = r21
            c4.a r2 = (c4.a) r2
            r0 = r19
            r1 = r20
            r3 = r22
            r5 = r16
            r6 = r17
            k3.o r0 = r0.j(r1, r2, r3, r4, r5, r6)
            return r0
        L_0x013a:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.b.n(k3.c0, k3.j, k3.c, boolean):k3.o");
    }

    public o o(a0 a0Var, k3.j jVar, c cVar) {
        k.d g10 = cVar.g((k.d) null);
        if (g10.i() == k.c.OBJECT) {
            ((r3.q) cVar).M("declaringClass");
            return null;
        }
        m e10 = m.e(jVar.q(), a0Var, cVar, g10);
        if (this.f181a.b()) {
            Iterator it = this.f181a.d().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return e10;
    }

    public o p(k3.j jVar) {
        return new com.fasterxml.jackson.databind.ser.std.n(jVar);
    }

    public h q(k3.j jVar, boolean z10, w3.h hVar, o oVar) {
        return new b4.e(jVar, z10, hVar, oVar);
    }

    public o r(a0 a0Var, k3.j jVar, c cVar, boolean z10, k3.j jVar2) {
        return new com.fasterxml.jackson.databind.ser.std.r(jVar2, z10, c(a0Var, jVar2));
    }

    public o s(a0 a0Var, k3.j jVar, c cVar, boolean z10, k3.j jVar2) {
        return new b4.g(jVar2, z10, c(a0Var, jVar2));
    }

    public o t(c0 c0Var, k3.j jVar, c cVar, boolean z10, k3.j jVar2, k3.j jVar3) {
        r.a aVar;
        c0 c0Var2 = c0Var;
        c cVar2 = cVar;
        Class<Map.Entry> cls = Map.Entry.class;
        Object obj = null;
        if (k.d.p(cVar2.g((k.d) null), c0Var.a0(cls)).i() == k.c.OBJECT) {
            return null;
        }
        k3.j jVar4 = jVar3;
        b4.h hVar = new b4.h(jVar3, jVar2, jVar4, z10, c(c0Var.k(), jVar4), (d) null);
        k3.j g10 = hVar.g();
        r.b h10 = h(c0Var, cVar2, g10, cls);
        if (h10 == null) {
            aVar = r.a.USE_DEFAULTS;
        } else {
            aVar = h10.f();
        }
        if (aVar == r.a.USE_DEFAULTS || aVar == r.a.ALWAYS) {
            return hVar;
        }
        int i10 = a.f183b[aVar.ordinal()];
        boolean z11 = true;
        if (i10 == 1) {
            obj = d4.e.b(g10);
            if (obj != null && obj.getClass().isArray()) {
                obj = d4.c.a(obj);
            }
        } else if (i10 != 2) {
            if (i10 == 3) {
                obj = t.f5787q;
            } else if (i10 == 4 && (obj = c0Var.j0((r3.s) null, h10.e())) != null) {
                z11 = c0Var.k0(obj);
            }
        } else if (g10.b()) {
            obj = t.f5787q;
        }
        return hVar.l(obj, z11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001f A[LOOP:0: B:4:0x001f->B:7:0x003a, LOOP_START, PHI: r1 
      PHI: (r1v4 k3.o) = (r1v3 k3.o), (r1v19 k3.o) binds: [B:3:0x0012, B:7:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o u(k3.c0 r20, c4.h r21, k3.c r22, boolean r23, k3.o r24, w3.h r25, k3.o r26) {
        /*
            r19 = this;
            r0 = r19
            r8 = r22
            r9 = 0
            b3.k$d r1 = r8.g(r9)
            b3.k$c r1 = r1.i()
            b3.k$c r2 = b3.k.c.OBJECT
            if (r1 != r2) goto L_0x0012
            return r9
        L_0x0012:
            k3.a0 r10 = r20.k()
            java.lang.Iterable r1 = r19.v()
            java.util.Iterator r11 = r1.iterator()
            r1 = r9
        L_0x001f:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x003c
            java.lang.Object r1 = r11.next()
            a4.r r1 = (a4.r) r1
            r2 = r10
            r3 = r21
            r4 = r22
            r5 = r24
            r6 = r25
            r7 = r26
            k3.o r1 = r1.e(r2, r3, r4, r5, r6, r7)
            if (r1 == 0) goto L_0x001f
        L_0x003c:
            if (r1 != 0) goto L_0x0080
            k3.o r1 = r19.C(r20, r21, r22)
            if (r1 != 0) goto L_0x0080
            java.lang.Object r18 = r0.y(r10, r8)
            r3.c r1 = r22.u()
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            b3.p$a r1 = r10.O(r2, r1)
            if (r1 != 0) goto L_0x0056
            r11 = r9
            goto L_0x005b
        L_0x0056:
            java.util.Set r1 = r1.h()
            r11 = r1
        L_0x005b:
            r3.c r1 = r22.u()
            b3.s$a r1 = r10.Q(r2, r1)
            if (r1 != 0) goto L_0x0067
            r12 = r9
            goto L_0x006c
        L_0x0067:
            java.util.Set r1 = r1.e()
            r12 = r1
        L_0x006c:
            r13 = r21
            r14 = r23
            r15 = r25
            r16 = r24
            r17 = r26
            com.fasterxml.jackson.databind.ser.std.t r1 = com.fasterxml.jackson.databind.ser.std.t.m(r11, r12, r13, r14, r15, r16, r17, r18)
            r2 = r20
            com.fasterxml.jackson.databind.ser.std.t r1 = r0.f(r2, r8, r1)
        L_0x0080:
            m3.p r2 = r0.f181a
            boolean r2 = r2.b()
            if (r2 == 0) goto L_0x00a1
            m3.p r2 = r0.f181a
            java.lang.Iterable r2 = r2.d()
            java.util.Iterator r2 = r2.iterator()
            boolean r3 = r2.hasNext()
            if (r3 != 0) goto L_0x0099
            goto L_0x00a1
        L_0x0099:
            java.lang.Object r1 = r2.next()
            androidx.appcompat.app.m.a(r1)
            throw r9
        L_0x00a1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.b.u(k3.c0, c4.h, k3.c, boolean, k3.o, w3.h, k3.o):k3.o");
    }

    public abstract Iterable v();

    public d4.j w(c0 c0Var, r3.b bVar) {
        Object U = c0Var.W().U(bVar);
        if (U == null) {
            return null;
        }
        return c0Var.j(bVar, U);
    }

    public o x(c0 c0Var, r3.b bVar, o oVar) {
        d4.j w10 = w(c0Var, bVar);
        if (w10 == null) {
            return oVar;
        }
        return new d0(w10, w10.a(c0Var.l()), oVar);
    }

    public Object y(a0 a0Var, c cVar) {
        return a0Var.g().p(cVar.u());
    }

    public o z(c0 c0Var, k3.j jVar, c cVar, boolean z10) {
        return q3.e.f8937e.c(c0Var.k(), jVar, cVar);
    }
}
