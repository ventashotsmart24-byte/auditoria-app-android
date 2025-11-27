package r3;

import b3.r;
import b3.w;
import c4.o;
import com.umeng.analytics.pro.bt;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import k3.b;
import k3.j;
import k3.w;
import k3.x;
import m3.m;

public class d0 extends s implements Comparable {

    /* renamed from: m  reason: collision with root package name */
    public static final b.a f9075m = b.a.e("");

    /* renamed from: b  reason: collision with root package name */
    public final boolean f9076b;

    /* renamed from: c  reason: collision with root package name */
    public final m f9077c;

    /* renamed from: d  reason: collision with root package name */
    public final k3.b f9078d;

    /* renamed from: e  reason: collision with root package name */
    public final x f9079e;

    /* renamed from: f  reason: collision with root package name */
    public final x f9080f;

    /* renamed from: g  reason: collision with root package name */
    public g f9081g;

    /* renamed from: h  reason: collision with root package name */
    public g f9082h;

    /* renamed from: i  reason: collision with root package name */
    public g f9083i;

    /* renamed from: j  reason: collision with root package name */
    public g f9084j;

    /* renamed from: k  reason: collision with root package name */
    public transient w f9085k;

    /* renamed from: l  reason: collision with root package name */
    public transient b.a f9086l;

    public class a implements i {
        public a() {
        }

        /* renamed from: b */
        public Class[] a(i iVar) {
            return d0.this.f9078d.f0(iVar);
        }
    }

    public class b implements i {
        public b() {
        }

        /* renamed from: b */
        public b.a a(i iVar) {
            return d0.this.f9078d.Q(iVar);
        }
    }

    public class c implements i {
        public c() {
        }

        /* renamed from: b */
        public Boolean a(i iVar) {
            return d0.this.f9078d.s0(iVar);
        }
    }

    public class d implements i {
        public d() {
        }

        /* renamed from: b */
        public b0 a(i iVar) {
            b0 B = d0.this.f9078d.B(iVar);
            if (B != null) {
                return d0.this.f9078d.C(iVar, B);
            }
            return B;
        }
    }

    public class e implements i {
        public e() {
        }

        /* renamed from: b */
        public w.a a(i iVar) {
            return d0.this.f9078d.F(iVar);
        }
    }

    public static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9092a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                b3.w$a[] r0 = b3.w.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9092a = r0
                b3.w$a r1 = b3.w.a.READ_ONLY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9092a     // Catch:{ NoSuchFieldError -> 0x001d }
                b3.w$a r1 = b3.w.a.READ_WRITE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9092a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b3.w$a r1 = b3.w.a.WRITE_ONLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9092a     // Catch:{ NoSuchFieldError -> 0x0033 }
                b3.w$a r1 = b3.w.a.AUTO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.d0.f.<clinit>():void");
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final Object f9093a;

        /* renamed from: b  reason: collision with root package name */
        public final g f9094b;

        /* renamed from: c  reason: collision with root package name */
        public final x f9095c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f9096d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f9097e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f9098f;

        public g(Object obj, g gVar, x xVar, boolean z10, boolean z11, boolean z12) {
            x xVar2;
            this.f9093a = obj;
            this.f9094b = gVar;
            if (xVar == null || xVar.h()) {
                xVar2 = null;
            } else {
                xVar2 = xVar;
            }
            this.f9095c = xVar2;
            if (z10) {
                if (xVar2 == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                } else if (!xVar.e()) {
                    z10 = false;
                }
            }
            this.f9096d = z10;
            this.f9097e = z11;
            this.f9098f = z12;
        }

        public g a(g gVar) {
            g gVar2 = this.f9094b;
            if (gVar2 == null) {
                return c(gVar);
            }
            return c(gVar2.a(gVar));
        }

        public g b() {
            g gVar = this.f9094b;
            if (gVar == null) {
                return this;
            }
            g b10 = gVar.b();
            if (this.f9095c != null) {
                if (b10.f9095c == null) {
                    return c((g) null);
                }
                return c(b10);
            } else if (b10.f9095c != null) {
                return b10;
            } else {
                boolean z10 = this.f9097e;
                if (z10 == b10.f9097e) {
                    return c(b10);
                }
                if (z10) {
                    return c((g) null);
                }
                return b10;
            }
        }

        public g c(g gVar) {
            if (gVar == this.f9094b) {
                return this;
            }
            return new g(this.f9093a, gVar, this.f9095c, this.f9096d, this.f9097e, this.f9098f);
        }

        public g d(Object obj) {
            if (obj == this.f9093a) {
                return this;
            }
            return new g(obj, this.f9094b, this.f9095c, this.f9096d, this.f9097e, this.f9098f);
        }

        public g e() {
            g e10;
            if (this.f9098f) {
                g gVar = this.f9094b;
                if (gVar == null) {
                    return null;
                }
                return gVar.e();
            }
            g gVar2 = this.f9094b;
            if (gVar2 == null || (e10 = gVar2.e()) == this.f9094b) {
                return this;
            }
            return c(e10);
        }

        public g f() {
            if (this.f9094b == null) {
                return this;
            }
            return new g(this.f9093a, (g) null, this.f9095c, this.f9096d, this.f9097e, this.f9098f);
        }

        public g g() {
            g gVar;
            g gVar2 = this.f9094b;
            if (gVar2 == null) {
                gVar = null;
            } else {
                gVar = gVar2.g();
            }
            if (this.f9097e) {
                return c(gVar);
            }
            return gVar;
        }

        public String toString() {
            String format = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", new Object[]{this.f9093a.toString(), Boolean.valueOf(this.f9097e), Boolean.valueOf(this.f9098f), Boolean.valueOf(this.f9096d)});
            if (this.f9094b == null) {
                return format;
            }
            return format + ", " + this.f9094b.toString();
        }
    }

    public static class h implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        public g f9099a;

        public h(g gVar) {
            this.f9099a = gVar;
        }

        /* renamed from: a */
        public i next() {
            g gVar = this.f9099a;
            if (gVar != null) {
                i iVar = (i) gVar.f9093a;
                this.f9099a = gVar.f9094b;
                return iVar;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f9099a != null) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public interface i {
        Object a(i iVar);
    }

    public d0(m mVar, k3.b bVar, boolean z10, x xVar) {
        this(mVar, bVar, z10, xVar, xVar);
    }

    public static g j0(g gVar, g gVar2) {
        if (gVar == null) {
            return gVar2;
        }
        if (gVar2 == null) {
            return gVar;
        }
        return gVar.a(gVar2);
    }

    public boolean A() {
        if (this.f9084j != null) {
            return true;
        }
        return false;
    }

    public boolean B() {
        if (F(this.f9081g) || F(this.f9083i) || F(this.f9084j) || E(this.f9082h)) {
            return true;
        }
        return false;
    }

    public boolean C() {
        if (E(this.f9081g) || E(this.f9083i) || E(this.f9084j) || E(this.f9082h)) {
            return true;
        }
        return false;
    }

    public boolean D() {
        Boolean bool = (Boolean) f0(new c());
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean E(g gVar) {
        while (gVar != null) {
            if (gVar.f9095c != null && gVar.f9096d) {
                return true;
            }
            gVar = gVar.f9094b;
        }
        return false;
    }

    public final boolean F(g gVar) {
        while (gVar != null) {
            x xVar = gVar.f9095c;
            if (xVar != null && xVar.e()) {
                return true;
            }
            gVar = gVar.f9094b;
        }
        return false;
    }

    public final boolean G(g gVar) {
        while (gVar != null) {
            if (gVar.f9098f) {
                return true;
            }
            gVar = gVar.f9094b;
        }
        return false;
    }

    public final boolean H(g gVar) {
        while (gVar != null) {
            if (gVar.f9097e) {
                return true;
            }
            gVar = gVar.f9094b;
        }
        return false;
    }

    public final g I(g gVar, p pVar) {
        i iVar = (i) ((i) gVar.f9093a).p(pVar);
        g gVar2 = gVar.f9094b;
        if (gVar2 != null) {
            gVar = gVar.c(I(gVar2, pVar));
        }
        return gVar.d(iVar);
    }

    public final void J(Collection collection, Map map, g gVar) {
        for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.f9094b) {
            x xVar = gVar2.f9095c;
            if (gVar2.f9096d && xVar != null) {
                d0 d0Var = (d0) map.get(xVar);
                if (d0Var == null) {
                    d0Var = new d0(this.f9077c, this.f9078d, this.f9076b, this.f9080f, xVar);
                    map.put(xVar, d0Var);
                }
                if (gVar == this.f9081g) {
                    d0Var.f9081g = gVar2.c(d0Var.f9081g);
                } else if (gVar == this.f9083i) {
                    d0Var.f9083i = gVar2.c(d0Var.f9083i);
                } else if (gVar == this.f9084j) {
                    d0Var.f9084j = gVar2.c(d0Var.f9084j);
                } else if (gVar == this.f9082h) {
                    d0Var.f9082h = gVar2.c(d0Var.f9082h);
                } else {
                    throw new IllegalStateException("Internal error: mismatched accessors, property: " + this);
                }
            } else if (gVar2.f9097e) {
                throw new IllegalStateException("Conflicting/ambiguous property name definitions (implicit name " + d4.h.V(this.f9079e) + "): found multiple explicit names: " + collection + ", but also implicit accessor: " + gVar2);
            }
        }
    }

    public final Set K(g gVar, Set set) {
        while (gVar != null) {
            if (gVar.f9096d && gVar.f9095c != null) {
                if (set == null) {
                    set = new HashSet();
                }
                set.add(gVar.f9095c);
            }
            gVar = gVar.f9094b;
        }
        return set;
    }

    public final p L(g gVar) {
        p j10 = ((i) gVar.f9093a).j();
        g gVar2 = gVar.f9094b;
        if (gVar2 != null) {
            return p.e(j10, L(gVar2));
        }
        return j10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.w M(k3.w r7, r3.i r8) {
        /*
            r6 = this;
            r3.i r0 = r6.l()
            r1 = 1
            r2 = 0
            if (r8 == 0) goto L_0x0072
            k3.b r3 = r6.f9078d
            r4 = 0
            if (r3 == 0) goto L_0x0035
            if (r0 == 0) goto L_0x0024
            java.lang.Boolean r3 = r3.w(r8)
            if (r3 == 0) goto L_0x0024
            boolean r1 = r3.booleanValue()
            if (r1 == 0) goto L_0x0023
            k3.w$a r1 = k3.w.a.b(r0)
            k3.w r7 = r7.i(r1)
        L_0x0023:
            r1 = 0
        L_0x0024:
            k3.b r3 = r6.f9078d
            b3.b0$a r3 = r3.Z(r8)
            if (r3 == 0) goto L_0x0035
            b3.j0 r2 = r3.f()
            b3.j0 r3 = r3.e()
            goto L_0x0036
        L_0x0035:
            r3 = r2
        L_0x0036:
            if (r1 != 0) goto L_0x003c
            if (r2 == 0) goto L_0x003c
            if (r3 != 0) goto L_0x0073
        L_0x003c:
            java.lang.Class r8 = r6.P(r8)
            m3.m r5 = r6.f9077c
            m3.g r8 = r5.j(r8)
            b3.b0$a r5 = r8.h()
            if (r5 == 0) goto L_0x0058
            if (r2 != 0) goto L_0x0052
            b3.j0 r2 = r5.f()
        L_0x0052:
            if (r3 != 0) goto L_0x0058
            b3.j0 r3 = r5.e()
        L_0x0058:
            if (r1 == 0) goto L_0x0073
            if (r0 == 0) goto L_0x0073
            java.lang.Boolean r8 = r8.g()
            if (r8 == 0) goto L_0x0073
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0070
            k3.w$a r8 = k3.w.a.c(r0)
            k3.w r7 = r7.i(r8)
        L_0x0070:
            r1 = 0
            goto L_0x0073
        L_0x0072:
            r3 = r2
        L_0x0073:
            if (r1 != 0) goto L_0x0079
            if (r2 == 0) goto L_0x0079
            if (r3 != 0) goto L_0x00a5
        L_0x0079:
            m3.m r8 = r6.f9077c
            b3.b0$a r8 = r8.r()
            if (r2 != 0) goto L_0x0085
            b3.j0 r2 = r8.f()
        L_0x0085:
            if (r3 != 0) goto L_0x008b
            b3.j0 r3 = r8.e()
        L_0x008b:
            if (r1 == 0) goto L_0x00a5
            m3.m r8 = r6.f9077c
            java.lang.Boolean r8 = r8.n()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x00a5
            if (r0 == 0) goto L_0x00a5
            k3.w$a r8 = k3.w.a.a(r0)
            k3.w r7 = r7.i(r8)
        L_0x00a5:
            if (r2 != 0) goto L_0x00a9
            if (r3 == 0) goto L_0x00ad
        L_0x00a9:
            k3.w r7 = r7.j(r2, r3)
        L_0x00ad:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.d0.M(k3.w, r3.i):k3.w");
    }

    public int N(j jVar) {
        String d10 = jVar.d();
        if (d10.startsWith("get") && d10.length() > 3) {
            return 1;
        }
        if (!d10.startsWith(bt.ae) || d10.length() <= 2) {
            return 3;
        }
        return 2;
    }

    public final p O(int i10, g... gVarArr) {
        p L = L(gVarArr[i10]);
        do {
            i10++;
            if (i10 >= gVarArr.length) {
                return L;
            }
        } while (gVarArr[i10] == null);
        return p.e(L, O(i10, gVarArr));
    }

    public Class P(i iVar) {
        if (iVar instanceof j) {
            j jVar = (j) iVar;
            if (jVar.v() > 0) {
                return jVar.w(0).q();
            }
        }
        return iVar.f().q();
    }

    public final g Q(g gVar) {
        if (gVar == null) {
            return gVar;
        }
        return gVar.e();
    }

    public final g R(g gVar) {
        if (gVar == null) {
            return gVar;
        }
        return gVar.g();
    }

    public int S(j jVar) {
        String d10 = jVar.d();
        if (!d10.startsWith("set") || d10.length() <= 3) {
            return 2;
        }
        return 1;
    }

    public final g T(g gVar) {
        if (gVar == null) {
            return gVar;
        }
        return gVar.b();
    }

    public void U(d0 d0Var) {
        this.f9081g = j0(this.f9081g, d0Var.f9081g);
        this.f9082h = j0(this.f9082h, d0Var.f9082h);
        this.f9083i = j0(this.f9083i, d0Var.f9083i);
        this.f9084j = j0(this.f9084j, d0Var.f9084j);
    }

    public void V(m mVar, x xVar, boolean z10, boolean z11, boolean z12) {
        this.f9082h = new g(mVar, this.f9082h, xVar, z10, z11, z12);
    }

    public void W(g gVar, x xVar, boolean z10, boolean z11, boolean z12) {
        this.f9081g = new g(gVar, this.f9081g, xVar, z10, z11, z12);
    }

    public void X(j jVar, x xVar, boolean z10, boolean z11, boolean z12) {
        this.f9083i = new g(jVar, this.f9083i, xVar, z10, z11, z12);
    }

    public void Y(j jVar, x xVar, boolean z10, boolean z11, boolean z12) {
        this.f9084j = new g(jVar, this.f9084j, xVar, z10, z11, z12);
    }

    public boolean Z() {
        if (G(this.f9081g) || G(this.f9083i) || G(this.f9084j) || G(this.f9082h)) {
            return true;
        }
        return false;
    }

    public boolean a0() {
        if (H(this.f9081g) || H(this.f9083i) || H(this.f9084j) || H(this.f9082h)) {
            return true;
        }
        return false;
    }

    /* renamed from: b0 */
    public int compareTo(d0 d0Var) {
        if (this.f9082h != null) {
            if (d0Var.f9082h == null) {
                return -1;
            }
        } else if (d0Var.f9082h != null) {
            return 1;
        }
        return getName().compareTo(d0Var.getName());
    }

    public x c() {
        return this.f9079e;
    }

    public Collection c0(Collection collection) {
        HashMap hashMap = new HashMap();
        J(collection, hashMap, this.f9081g);
        J(collection, hashMap, this.f9083i);
        J(collection, hashMap, this.f9084j);
        J(collection, hashMap, this.f9082h);
        return hashMap.values();
    }

    public w.a d0() {
        return (w.a) g0(new e(), w.a.AUTO);
    }

    public boolean e() {
        if (this.f9082h == null && this.f9084j == null && this.f9081g == null) {
            return false;
        }
        return true;
    }

    public Set e0() {
        Set K = K(this.f9082h, K(this.f9084j, K(this.f9083i, K(this.f9081g, (Set) null))));
        if (K == null) {
            return Collections.emptySet();
        }
        return K;
    }

    public boolean f() {
        if (this.f9083i == null && this.f9081g == null) {
            return false;
        }
        return true;
    }

    public Object f0(i iVar) {
        g gVar;
        g gVar2;
        Object obj = null;
        if (this.f9078d == null) {
            return null;
        }
        if (this.f9076b) {
            g gVar3 = this.f9083i;
            if (gVar3 != null) {
                obj = iVar.a((i) gVar3.f9093a);
            }
        } else {
            g gVar4 = this.f9082h;
            if (gVar4 != null) {
                obj = iVar.a((i) gVar4.f9093a);
            }
            if (obj == null && (gVar2 = this.f9084j) != null) {
                obj = iVar.a((i) gVar2.f9093a);
            }
        }
        if (obj != null || (gVar = this.f9081g) == null) {
            return obj;
        }
        return iVar.a((i) gVar.f9093a);
    }

    public r.b g() {
        r.b bVar;
        i l10 = l();
        k3.b bVar2 = this.f9078d;
        if (bVar2 == null) {
            bVar = null;
        } else {
            bVar = bVar2.M(l10);
        }
        if (bVar == null) {
            return r.b.c();
        }
        return bVar;
    }

    public Object g0(i iVar, Object obj) {
        Object a10;
        Object a11;
        Object a12;
        Object a13;
        Object a14;
        Object a15;
        Object a16;
        Object a17;
        if (this.f9078d == null) {
            return null;
        }
        if (this.f9076b) {
            g gVar = this.f9083i;
            if (gVar != null && (a17 = iVar.a((i) gVar.f9093a)) != null && a17 != obj) {
                return a17;
            }
            g gVar2 = this.f9081g;
            if (gVar2 != null && (a16 = iVar.a((i) gVar2.f9093a)) != null && a16 != obj) {
                return a16;
            }
            g gVar3 = this.f9082h;
            if (gVar3 != null && (a15 = iVar.a((i) gVar3.f9093a)) != null && a15 != obj) {
                return a15;
            }
            g gVar4 = this.f9084j;
            if (gVar4 == null || (a14 = iVar.a((i) gVar4.f9093a)) == null || a14 == obj) {
                return null;
            }
            return a14;
        }
        g gVar5 = this.f9082h;
        if (gVar5 != null && (a13 = iVar.a((i) gVar5.f9093a)) != null && a13 != obj) {
            return a13;
        }
        g gVar6 = this.f9084j;
        if (gVar6 != null && (a12 = iVar.a((i) gVar6.f9093a)) != null && a12 != obj) {
            return a12;
        }
        g gVar7 = this.f9081g;
        if (gVar7 != null && (a11 = iVar.a((i) gVar7.f9093a)) != null && a11 != obj) {
            return a11;
        }
        g gVar8 = this.f9083i;
        if (gVar8 == null || (a10 = iVar.a((i) gVar8.f9093a)) == null || a10 == obj) {
            return null;
        }
        return a10;
    }

    public k3.w getMetadata() {
        k3.w wVar;
        if (this.f9085k == null) {
            i i02 = i0();
            if (i02 == null) {
                this.f9085k = k3.w.f7487j;
            } else {
                Boolean p02 = this.f9078d.p0(i02);
                String J = this.f9078d.J(i02);
                Integer O = this.f9078d.O(i02);
                String I = this.f9078d.I(i02);
                if (p02 == null && O == null && I == null) {
                    if (J == null) {
                        wVar = k3.w.f7487j;
                    } else {
                        wVar = k3.w.f7487j.h(J);
                    }
                    this.f9085k = wVar;
                } else {
                    this.f9085k = k3.w.a(p02, J, O, I);
                }
                if (!this.f9076b) {
                    this.f9085k = M(this.f9085k, i02);
                }
            }
        }
        return this.f9085k;
    }

    public String getName() {
        x xVar = this.f9079e;
        if (xVar == null) {
            return null;
        }
        return xVar.c();
    }

    public b0 h() {
        return (b0) f0(new d());
    }

    public String h0() {
        return this.f9080f.c();
    }

    public i i0() {
        if (this.f9076b) {
            g gVar = this.f9083i;
            if (gVar != null) {
                return (i) gVar.f9093a;
            }
            g gVar2 = this.f9081g;
            if (gVar2 != null) {
                return (i) gVar2.f9093a;
            }
            return null;
        }
        g gVar3 = this.f9082h;
        if (gVar3 != null) {
            return (i) gVar3.f9093a;
        }
        g gVar4 = this.f9084j;
        if (gVar4 != null) {
            return (i) gVar4.f9093a;
        }
        g gVar5 = this.f9081g;
        if (gVar5 != null) {
            return (i) gVar5.f9093a;
        }
        g gVar6 = this.f9083i;
        if (gVar6 != null) {
            return (i) gVar6.f9093a;
        }
        return null;
    }

    public b.a j() {
        b.a aVar;
        b.a aVar2 = this.f9086l;
        if (aVar2 == null) {
            b.a aVar3 = (b.a) f0(new b());
            if (aVar3 == null) {
                aVar = f9075m;
            } else {
                aVar = aVar3;
            }
            this.f9086l = aVar;
            return aVar3;
        } else if (aVar2 == f9075m) {
            return null;
        } else {
            return aVar2;
        }
    }

    public Class[] k() {
        return (Class[]) f0(new a());
    }

    public void k0(boolean z10) {
        if (z10) {
            g gVar = this.f9083i;
            if (gVar != null) {
                this.f9083i = I(this.f9083i, O(0, gVar, this.f9081g, this.f9082h, this.f9084j));
                return;
            }
            g gVar2 = this.f9081g;
            if (gVar2 != null) {
                this.f9081g = I(this.f9081g, O(0, gVar2, this.f9082h, this.f9084j));
                return;
            }
            return;
        }
        g gVar3 = this.f9082h;
        if (gVar3 != null) {
            this.f9082h = I(this.f9082h, O(0, gVar3, this.f9084j, this.f9081g, this.f9083i));
            return;
        }
        g gVar4 = this.f9084j;
        if (gVar4 != null) {
            this.f9084j = I(this.f9084j, O(0, gVar4, this.f9081g, this.f9083i));
            return;
        }
        g gVar5 = this.f9081g;
        if (gVar5 != null) {
            this.f9081g = I(this.f9081g, O(0, gVar5, this.f9083i));
        }
    }

    public void l0() {
        this.f9082h = null;
    }

    public m m() {
        g gVar = this.f9082h;
        if (gVar == null) {
            return null;
        }
        while (!(((m) gVar.f9093a).r() instanceof e)) {
            gVar = gVar.f9094b;
            if (gVar == null) {
                return (m) this.f9082h.f9093a;
            }
        }
        return (m) gVar.f9093a;
    }

    public void m0() {
        this.f9081g = Q(this.f9081g);
        this.f9083i = Q(this.f9083i);
        this.f9084j = Q(this.f9084j);
        this.f9082h = Q(this.f9082h);
    }

    public Iterator n() {
        g gVar = this.f9082h;
        if (gVar == null) {
            return d4.h.n();
        }
        return new h(gVar);
    }

    public w.a n0(boolean z10, c0 c0Var) {
        w.a d02 = d0();
        if (d02 == null) {
            d02 = w.a.AUTO;
        }
        int i10 = f.f9092a[d02.ordinal()];
        if (i10 == 1) {
            if (c0Var != null) {
                c0Var.j(getName());
                for (x c10 : e0()) {
                    c0Var.j(c10.c());
                }
            }
            this.f9084j = null;
            this.f9082h = null;
            if (!this.f9076b) {
                this.f9081g = null;
            }
        } else if (i10 != 2) {
            if (i10 != 3) {
                this.f9083i = R(this.f9083i);
                this.f9082h = R(this.f9082h);
                if (!z10 || this.f9083i == null) {
                    this.f9081g = R(this.f9081g);
                    this.f9084j = R(this.f9084j);
                }
            } else {
                this.f9083i = null;
                if (this.f9076b) {
                    this.f9081g = null;
                }
            }
        }
        return d02;
    }

    public g o() {
        g gVar = this.f9081g;
        if (gVar == null) {
            return null;
        }
        g gVar2 = (g) gVar.f9093a;
        g gVar3 = gVar.f9094b;
        while (gVar3 != null) {
            g gVar4 = (g) gVar3.f9093a;
            Class k10 = gVar2.k();
            Class k11 = gVar4.k();
            if (k10 != k11) {
                if (k10.isAssignableFrom(k11)) {
                    gVar2 = gVar4;
                } else if (k11.isAssignableFrom(k10)) {
                }
                gVar3 = gVar3.f9094b;
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + gVar2.l() + " vs " + gVar4.l());
        }
        return gVar2;
    }

    public void o0() {
        this.f9081g = T(this.f9081g);
        this.f9083i = T(this.f9083i);
        this.f9084j = T(this.f9084j);
        this.f9082h = T(this.f9082h);
    }

    public j p() {
        g gVar = this.f9083i;
        if (gVar == null) {
            return null;
        }
        g gVar2 = gVar.f9094b;
        if (gVar2 == null) {
            return (j) gVar.f9093a;
        }
        while (gVar2 != null) {
            Class k10 = ((j) gVar.f9093a).k();
            Class k11 = ((j) gVar2.f9093a).k();
            if (k10 != k11) {
                if (!k10.isAssignableFrom(k11)) {
                    if (k11.isAssignableFrom(k10)) {
                        continue;
                        gVar2 = gVar2.f9094b;
                    }
                }
                gVar = gVar2;
                gVar2 = gVar2.f9094b;
            }
            int N = N((j) gVar2.f9093a);
            int N2 = N((j) gVar.f9093a);
            if (N != N2) {
                if (N >= N2) {
                    gVar2 = gVar2.f9094b;
                }
                gVar = gVar2;
                gVar2 = gVar2.f9094b;
            } else {
                throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((j) gVar.f9093a).l() + " vs " + ((j) gVar2.f9093a).l());
            }
        }
        this.f9083i = gVar.f();
        return (j) gVar.f9093a;
    }

    public d0 p0(x xVar) {
        return new d0(this, xVar);
    }

    public i s() {
        if (this.f9076b) {
            return l();
        }
        i q10 = q();
        if (q10 == null) {
            return l();
        }
        return q10;
    }

    public j t() {
        if (this.f9076b) {
            b p10 = p();
            if (p10 == null && (p10 = o()) == null) {
                return o.O();
            }
            return p10.f();
        }
        b m10 = m();
        if (m10 == null) {
            j v10 = v();
            if (v10 != null) {
                return v10.w(0);
            }
            m10 = o();
        }
        if (m10 == null && (m10 = p()) == null) {
            return o.O();
        }
        return m10.f();
    }

    public String toString() {
        return "[Property '" + this.f9079e + "'; ctors: " + this.f9082h + ", field(s): " + this.f9081g + ", getter(s): " + this.f9083i + ", setter(s): " + this.f9084j + "]";
    }

    public Class u() {
        return t().q();
    }

    public j v() {
        g gVar = this.f9084j;
        if (gVar == null) {
            return null;
        }
        g gVar2 = gVar.f9094b;
        if (gVar2 == null) {
            return (j) gVar.f9093a;
        }
        while (gVar2 != null) {
            Class k10 = ((j) gVar.f9093a).k();
            Class k11 = ((j) gVar2.f9093a).k();
            if (k10 != k11) {
                if (!k10.isAssignableFrom(k11)) {
                    if (k11.isAssignableFrom(k10)) {
                        continue;
                        gVar2 = gVar2.f9094b;
                    }
                }
                gVar = gVar2;
                gVar2 = gVar2.f9094b;
            }
            j jVar = (j) gVar2.f9093a;
            j jVar2 = (j) gVar.f9093a;
            int S = S(jVar);
            int S2 = S(jVar2);
            if (S != S2) {
                if (S >= S2) {
                    gVar2 = gVar2.f9094b;
                }
                gVar = gVar2;
                gVar2 = gVar2.f9094b;
            } else {
                k3.b bVar = this.f9078d;
                if (bVar != null) {
                    j w02 = bVar.w0(this.f9077c, jVar2, jVar);
                    if (w02 != jVar2) {
                        if (w02 != jVar) {
                        }
                        gVar = gVar2;
                        gVar2 = gVar2.f9094b;
                    } else {
                        continue;
                        gVar2 = gVar2.f9094b;
                    }
                }
                throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", new Object[]{getName(), ((j) gVar.f9093a).l(), ((j) gVar2.f9093a).l()}));
            }
        }
        this.f9084j = gVar.f();
        return (j) gVar.f9093a;
    }

    public x w() {
        k3.b bVar;
        i s10 = s();
        if (s10 == null || (bVar = this.f9078d) == null) {
            return null;
        }
        return bVar.g0(s10);
    }

    public boolean x() {
        if (this.f9082h != null) {
            return true;
        }
        return false;
    }

    public boolean y() {
        if (this.f9081g != null) {
            return true;
        }
        return false;
    }

    public boolean z(x xVar) {
        return this.f9079e.equals(xVar);
    }

    public d0(m mVar, k3.b bVar, boolean z10, x xVar, x xVar2) {
        this.f9077c = mVar;
        this.f9078d = bVar;
        this.f9080f = xVar;
        this.f9079e = xVar2;
        this.f9076b = z10;
    }

    public d0(d0 d0Var, x xVar) {
        this.f9077c = d0Var.f9077c;
        this.f9078d = d0Var.f9078d;
        this.f9080f = d0Var.f9080f;
        this.f9079e = xVar;
        this.f9081g = d0Var.f9081g;
        this.f9082h = d0Var.f9082h;
        this.f9083i = d0Var.f9083i;
        this.f9084j = d0Var.f9084j;
        this.f9076b = d0Var.f9076b;
    }
}
