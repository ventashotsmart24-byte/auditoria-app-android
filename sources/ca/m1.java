package ca;

import ca.f1;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import h9.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k9.f;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.u;
import s9.l;
import s9.p;
import t9.g;
import t9.i;

public class m1 implements f1, p, t1 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11515a = AtomicReferenceFieldUpdater.newUpdater(m1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    public static final class a extends l1 {

        /* renamed from: e  reason: collision with root package name */
        public final m1 f11516e;

        /* renamed from: f  reason: collision with root package name */
        public final b f11517f;

        /* renamed from: g  reason: collision with root package name */
        public final o f11518g;

        /* renamed from: h  reason: collision with root package name */
        public final Object f11519h;

        public a(m1 m1Var, b bVar, o oVar, Object obj) {
            this.f11516e = m1Var;
            this.f11517f = bVar;
            this.f11518g = oVar;
            this.f11519h = obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return t.f17319a;
        }

        public void q(Throwable th) {
            this.f11516e.C(this.f11517f, this.f11518g, this.f11519h);
        }
    }

    public static final class b implements a1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: a  reason: collision with root package name */
        public final q1 f11520a;

        public b(q1 q1Var, boolean z10, Throwable th) {
            this.f11520a = q1Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th;
        }

        public final void a(Throwable th) {
            Throwable e10 = e();
            if (e10 == null) {
                l(th);
            } else if (th != e10) {
                Object d10 = d();
                if (d10 == null) {
                    k(th);
                } else if (d10 instanceof Throwable) {
                    if (th != d10) {
                        ArrayList b10 = b();
                        b10.add(d10);
                        b10.add(th);
                        k(b10);
                    }
                } else if (d10 instanceof ArrayList) {
                    ((ArrayList) d10).add(th);
                } else {
                    throw new IllegalStateException(("State is " + d10).toString());
                }
            }
        }

        public final ArrayList b() {
            return new ArrayList(4);
        }

        public q1 c() {
            return this.f11520a;
        }

        public final Object d() {
            return this._exceptionsHolder;
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            if (e() != null) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            if (d() == n1.f11531e) {
                return true;
            }
            return false;
        }

        public final List i(Throwable th) {
            ArrayList arrayList;
            Object d10 = d();
            if (d10 == null) {
                arrayList = b();
            } else if (d10 instanceof Throwable) {
                ArrayList b10 = b();
                b10.add(d10);
                arrayList = b10;
            } else if (d10 instanceof ArrayList) {
                arrayList = (ArrayList) d10;
            } else {
                throw new IllegalStateException(("State is " + d10).toString());
            }
            Throwable e10 = e();
            if (e10 != null) {
                arrayList.add(0, e10);
            }
            if (th != null && !i.b(th, e10)) {
                arrayList.add(th);
            }
            k(n1.f11531e);
            return arrayList;
        }

        public boolean isActive() {
            if (e() == null) {
                return true;
            }
            return false;
        }

        public final void j(boolean z10) {
            this._isCompleting = z10 ? 1 : 0;
        }

        public final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void l(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + c() + ']';
        }
    }

    public static final class c extends n.a {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ m1 f11521d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f11522e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(n nVar, m1 m1Var, Object obj) {
            super(nVar);
            this.f11521d = m1Var;
            this.f11522e = obj;
        }

        /* renamed from: i */
        public Object g(n nVar) {
            boolean z10;
            if (this.f11521d.O() == this.f11522e) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return null;
            }
            return m.a();
        }
    }

    public m1(boolean z10) {
        p0 p0Var;
        if (z10) {
            p0Var = n1.f11533g;
        } else {
            p0Var = n1.f11532f;
        }
        this._state = p0Var;
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException l0(m1 m1Var, Throwable th, String str, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                str = null;
            }
            return m1Var.k0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    public boolean A(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!o(th) || !K()) {
            return false;
        }
        return true;
    }

    public final void B(a1 a1Var, Object obj) {
        s sVar;
        n N = N();
        if (N != null) {
            N.dispose();
            h0(r1.f11547a);
        }
        Throwable th = null;
        if (obj instanceof s) {
            sVar = (s) obj;
        } else {
            sVar = null;
        }
        if (sVar != null) {
            th = sVar.f11549a;
        }
        if (a1Var instanceof l1) {
            try {
                ((l1) a1Var).q(th);
            } catch (Throwable th2) {
                Q(new v("Exception in completion handler " + a1Var + " for " + this, th2));
            }
        } else {
            q1 c10 = a1Var.c();
            if (c10 != null) {
                a0(c10, th);
            }
        }
    }

    public final void C(b bVar, o oVar, Object obj) {
        o Y = Y(oVar);
        if (Y == null || !r0(bVar, Y, obj)) {
            l(F(bVar, obj));
        }
    }

    public final Throwable D(Object obj) {
        boolean z10;
        if (obj == null) {
            z10 = true;
        } else {
            z10 = obj instanceof Throwable;
        }
        if (z10) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new g1(w(), (Throwable) null, this);
            }
            return th;
        } else if (obj != null) {
            return ((t1) obj).n();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    public f E(f.c cVar) {
        return f1.a.e(this, cVar);
    }

    public final Object F(b bVar, Object obj) {
        s sVar;
        Throwable th;
        boolean f10;
        Throwable J;
        if (obj instanceof s) {
            sVar = (s) obj;
        } else {
            sVar = null;
        }
        if (sVar != null) {
            th = sVar.f11549a;
        } else {
            th = null;
        }
        synchronized (bVar) {
            f10 = bVar.f();
            List i10 = bVar.i(th);
            J = J(bVar, i10);
            if (J != null) {
                k(J, i10);
            }
        }
        boolean z10 = false;
        if (!(J == null || J == th)) {
            obj = new s(J, false, 2, (g) null);
        }
        if (J != null) {
            if (t(J) || P(J)) {
                z10 = true;
            }
            if (z10) {
                if (obj != null) {
                    ((s) obj).b();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
            }
        }
        if (!f10) {
            b0(J);
        }
        c0(obj);
        androidx.concurrent.futures.b.a(f11515a, this, bVar, n1.g(obj));
        B(bVar, obj);
        return obj;
    }

    public final o G(a1 a1Var) {
        o oVar;
        if (a1Var instanceof o) {
            oVar = (o) a1Var;
        } else {
            oVar = null;
        }
        if (oVar != null) {
            return oVar;
        }
        q1 c10 = a1Var.c();
        if (c10 != null) {
            return Y(c10);
        }
        return null;
    }

    public final Throwable H(Object obj) {
        s sVar;
        if (obj instanceof s) {
            sVar = (s) obj;
        } else {
            sVar = null;
        }
        if (sVar != null) {
            return sVar.f11549a;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Throwable J(ca.m1.b r4, java.util.List r5) {
        /*
            r3 = this;
            boolean r0 = r5.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            boolean r4 = r4.f()
            if (r4 == 0) goto L_0x0017
            ca.g1 r4 = new ca.g1
            java.lang.String r5 = r3.w()
            r4.<init>(r5, r1, r3)
            return r4
        L_0x0017:
            return r1
        L_0x0018:
            java.util.Iterator r4 = r5.iterator()
        L_0x001c:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0030
            java.lang.Object r0 = r4.next()
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            boolean r2 = r2 instanceof java.util.concurrent.CancellationException
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x001c
            r1 = r0
        L_0x0030:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x0035
            return r1
        L_0x0035:
            r4 = 0
            java.lang.Object r4 = r5.get(r4)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.m1.J(ca.m1$b, java.util.List):java.lang.Throwable");
    }

    public boolean K() {
        return true;
    }

    public boolean L() {
        return false;
    }

    public final q1 M(a1 a1Var) {
        q1 c10 = a1Var.c();
        if (c10 != null) {
            return c10;
        }
        if (a1Var instanceof p0) {
            return new q1();
        }
        if (a1Var instanceof l1) {
            f0((l1) a1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + a1Var).toString());
    }

    public final n N() {
        return (n) this._parentHandle;
    }

    public final Object O() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof u)) {
                return obj;
            }
            ((u) obj).c(this);
        }
    }

    public boolean P(Throwable th) {
        return false;
    }

    public final void R(f1 f1Var) {
        if (f1Var == null) {
            h0(r1.f11547a);
            return;
        }
        f1Var.start();
        n x10 = f1Var.x(this);
        h0(x10);
        if (S()) {
            x10.dispose();
            h0(r1.f11547a);
        }
    }

    public final boolean S() {
        return !(O() instanceof a1);
    }

    public boolean T() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        Z(((ca.m1.b) r2).c(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        return ca.n1.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object U(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.O()
            boolean r3 = r2 instanceof ca.m1.b
            if (r3 == 0) goto L_0x0051
            monitor-enter(r2)
            r3 = r2
            ca.m1$b r3 = (ca.m1.b) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.h()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x001a
            kotlinx.coroutines.internal.y r7 = ca.n1.f11530d     // Catch:{ all -> 0x004e }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r3 = r2
            ca.m1$b r3 = (ca.m1.b) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.f()     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x0025
            if (r3 != 0) goto L_0x0031
        L_0x0025:
            if (r1 != 0) goto L_0x002b
            java.lang.Throwable r1 = r6.D(r7)     // Catch:{ all -> 0x004e }
        L_0x002b:
            r7 = r2
            ca.m1$b r7 = (ca.m1.b) r7     // Catch:{ all -> 0x004e }
            r7.a(r1)     // Catch:{ all -> 0x004e }
        L_0x0031:
            r7 = r2
            ca.m1$b r7 = (ca.m1.b) r7     // Catch:{ all -> 0x004e }
            java.lang.Throwable r7 = r7.e()     // Catch:{ all -> 0x004e }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003d
            r0 = r7
        L_0x003d:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0049
            ca.m1$b r2 = (ca.m1.b) r2
            ca.q1 r7 = r2.c()
            r6.Z(r7, r0)
        L_0x0049:
            kotlinx.coroutines.internal.y r7 = ca.n1.f11527a
            return r7
        L_0x004e:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0051:
            boolean r3 = r2 instanceof ca.a1
            if (r3 == 0) goto L_0x00a2
            if (r1 != 0) goto L_0x005b
            java.lang.Throwable r1 = r6.D(r7)
        L_0x005b:
            r3 = r2
            ca.a1 r3 = (ca.a1) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x006f
            boolean r2 = r6.o0(r3, r1)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.internal.y r7 = ca.n1.f11527a
            return r7
        L_0x006f:
            ca.s r3 = new ca.s
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.p0(r2, r3)
            kotlinx.coroutines.internal.y r4 = ca.n1.f11527a
            if (r3 == r4) goto L_0x0087
            kotlinx.coroutines.internal.y r2 = ca.n1.f11529c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0087:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a2:
            kotlinx.coroutines.internal.y r7 = ca.n1.f11530d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.m1.U(java.lang.Object):java.lang.Object");
    }

    public final Object V(Object obj) {
        Object p02;
        do {
            p02 = p0(O(), obj);
            if (p02 == n1.f11527a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, H(obj));
            }
        } while (p02 == n1.f11529c);
        return p02;
    }

    public final l1 W(l lVar, boolean z10) {
        l1 l1Var = null;
        if (z10) {
            if (lVar instanceof h1) {
                l1Var = (h1) lVar;
            }
            if (l1Var == null) {
                l1Var = new d1(lVar);
            }
        } else {
            if (lVar instanceof l1) {
                l1Var = (l1) lVar;
            }
            if (l1Var == null) {
                l1Var = new e1(lVar);
            }
        }
        l1Var.s(this);
        return l1Var;
    }

    public String X() {
        return g0.a(this);
    }

    public final o Y(n nVar) {
        while (nVar.l()) {
            nVar = nVar.k();
        }
        while (true) {
            nVar = nVar.j();
            if (!nVar.l()) {
                if (nVar instanceof o) {
                    return (o) nVar;
                }
                if (nVar instanceof q1) {
                    return null;
                }
            }
        }
    }

    public final void Z(q1 q1Var, Throwable th) {
        b0(th);
        v vVar = null;
        for (n nVar = (n) q1Var.i(); !i.b(nVar, q1Var); nVar = nVar.j()) {
            if (nVar instanceof h1) {
                l1 l1Var = (l1) nVar;
                try {
                    l1Var.q(th);
                } catch (Throwable th2) {
                    if (vVar != null) {
                        h9.a.a(vVar, th2);
                    } else {
                        vVar = new v("Exception in completion handler " + l1Var + " for " + this, th2);
                        t tVar = t.f17319a;
                    }
                }
            }
        }
        if (vVar != null) {
            Q(vVar);
        }
        t(th);
    }

    public f.b a(f.c cVar) {
        return f1.a.c(this, cVar);
    }

    public final void a0(q1 q1Var, Throwable th) {
        v vVar = null;
        for (n nVar = (n) q1Var.i(); !i.b(nVar, q1Var); nVar = nVar.j()) {
            if (nVar instanceof l1) {
                l1 l1Var = (l1) nVar;
                try {
                    l1Var.q(th);
                } catch (Throwable th2) {
                    if (vVar != null) {
                        h9.a.a(vVar, th2);
                    } else {
                        vVar = new v("Exception in completion handler " + l1Var + " for " + this, th2);
                        t tVar = t.f17319a;
                    }
                }
            }
        }
        if (vVar != null) {
            Q(vVar);
        }
    }

    public void b0(Throwable th) {
    }

    public void c0(Object obj) {
    }

    public void d0() {
    }

    public final o0 e(l lVar) {
        return u(false, true, lVar);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [ca.z0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e0(ca.p0 r3) {
        /*
            r2 = this;
            ca.q1 r0 = new ca.q1
            r0.<init>()
            boolean r1 = r3.isActive()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            ca.z0 r1 = new ca.z0
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f11515a
            androidx.concurrent.futures.b.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.m1.e0(ca.p0):void");
    }

    public final CancellationException f() {
        Object O = O();
        if (O instanceof b) {
            Throwable e10 = ((b) O).e();
            if (e10 != null) {
                CancellationException k02 = k0(e10, g0.a(this) + " is cancelling");
                if (k02 != null) {
                    return k02;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (O instanceof a1) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (O instanceof s) {
            return l0(this, ((s) O).f11549a, (String) null, 1, (Object) null);
        } else {
            return new g1(g0.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public final void f0(l1 l1Var) {
        l1Var.e(new q1());
        androidx.concurrent.futures.b.a(f11515a, this, l1Var, l1Var.j());
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g0(ca.l1 r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.O()
            boolean r1 = r0 instanceof ca.l1
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f11515a
            ca.p0 r2 = ca.n1.f11533g
            boolean r0 = androidx.concurrent.futures.b.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof ca.a1
            if (r1 == 0) goto L_0x0027
            ca.a1 r0 = (ca.a1) r0
            ca.q1 r0 = r0.c()
            if (r0 == 0) goto L_0x0027
            r4.m()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.m1.g0(ca.l1):void");
    }

    public final f.c getKey() {
        return f1.f11497a0;
    }

    public final void h0(n nVar) {
        this._parentHandle = nVar;
    }

    public final int i0(Object obj) {
        if (obj instanceof p0) {
            if (((p0) obj).isActive()) {
                return 0;
            }
            if (!androidx.concurrent.futures.b.a(f11515a, this, obj, n1.f11533g)) {
                return -1;
            }
            d0();
            return 1;
        } else if (!(obj instanceof z0)) {
            return 0;
        } else {
            if (!androidx.concurrent.futures.b.a(f11515a, this, obj, ((z0) obj).c())) {
                return -1;
            }
            d0();
            return 1;
        }
    }

    public boolean isActive() {
        Object O = O();
        if (!(O instanceof a1) || !((a1) O).isActive()) {
            return false;
        }
        return true;
    }

    public final boolean j(Object obj, q1 q1Var, l1 l1Var) {
        int p10;
        c cVar = new c(l1Var, this, obj);
        do {
            p10 = q1Var.k().p(l1Var, q1Var, cVar);
            if (p10 == 1) {
                return true;
            }
        } while (p10 != 2);
        return false;
    }

    public final String j0(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.f()) {
                return "Cancelling";
            }
            if (bVar.g()) {
                return "Completing";
            }
            return "Active";
        } else if (obj instanceof a1) {
            if (((a1) obj).isActive()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof s) {
            return "Cancelled";
        } else {
            return "Completed";
        }
    }

    public final void k(Throwable th, List list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Throwable th2 = (Throwable) it.next();
                if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    h9.a.a(th, th2);
                }
            }
        }
    }

    public final CancellationException k0(Throwable th, String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = w();
            }
            cancellationException = new g1(str, th, this);
        }
        return cancellationException;
    }

    public void l(Object obj) {
    }

    public Object m(Object obj, p pVar) {
        return f1.a.b(this, obj, pVar);
    }

    public final String m0() {
        return X() + ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN + j0(O()) + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public CancellationException n() {
        Throwable th;
        Object O = O();
        CancellationException cancellationException = null;
        if (O instanceof b) {
            th = ((b) O).e();
        } else if (O instanceof s) {
            th = ((s) O).f11549a;
        } else if (!(O instanceof a1)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + O).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new g1("Parent job is " + j0(O), th, this);
    }

    public final boolean n0(a1 a1Var, Object obj) {
        if (!androidx.concurrent.futures.b.a(f11515a, this, a1Var, n1.g(obj))) {
            return false;
        }
        b0((Throwable) null);
        c0(obj);
        B(a1Var, obj);
        return true;
    }

    public final boolean o(Object obj) {
        Object a10 = n1.f11527a;
        if (L() && (a10 = r(obj)) == n1.f11528b) {
            return true;
        }
        if (a10 == n1.f11527a) {
            a10 = U(obj);
        }
        if (a10 == n1.f11527a || a10 == n1.f11528b) {
            return true;
        }
        if (a10 == n1.f11530d) {
            return false;
        }
        l(a10);
        return true;
    }

    public final boolean o0(a1 a1Var, Throwable th) {
        q1 M = M(a1Var);
        if (M == null) {
            return false;
        }
        if (!androidx.concurrent.futures.b.a(f11515a, this, a1Var, new b(M, false, th))) {
            return false;
        }
        Z(M, th);
        return true;
    }

    public void p(Throwable th) {
        o(th);
    }

    public final Object p0(Object obj, Object obj2) {
        if (!(obj instanceof a1)) {
            return n1.f11527a;
        }
        if ((!(obj instanceof p0) && !(obj instanceof l1)) || (obj instanceof o) || (obj2 instanceof s)) {
            return q0((a1) obj, obj2);
        }
        if (n0((a1) obj, obj2)) {
            return obj2;
        }
        return n1.f11529c;
    }

    public void q(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new g1(w(), (Throwable) null, this);
        }
        p(cancellationException);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        if (r2 == null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0070, code lost:
        Z(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0073, code lost:
        r9 = G(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0077, code lost:
        if (r9 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007d, code lost:
        if (r0(r1, r9, r10) == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0081, code lost:
        return ca.n1.f11528b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0086, code lost:
        return F(r1, r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object q0(ca.a1 r9, java.lang.Object r10) {
        /*
            r8 = this;
            ca.q1 r0 = r8.M(r9)
            if (r0 != 0) goto L_0x000b
            kotlinx.coroutines.internal.y r9 = ca.n1.f11529c
            return r9
        L_0x000b:
            boolean r1 = r9 instanceof ca.m1.b
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r9
            ca.m1$b r1 = (ca.m1.b) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            ca.m1$b r1 = new ca.m1$b
            r1.<init>(r0, r3, r2)
        L_0x001d:
            t9.w r4 = new t9.w
            r4.<init>()
            monitor-enter(r1)
            boolean r5 = r1.g()     // Catch:{ all -> 0x0087 }
            if (r5 == 0) goto L_0x002f
            kotlinx.coroutines.internal.y r9 = ca.n1.f11527a     // Catch:{ all -> 0x0087 }
            monitor-exit(r1)
            return r9
        L_0x002f:
            r5 = 1
            r1.j(r5)     // Catch:{ all -> 0x0087 }
            if (r1 == r9) goto L_0x0043
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = f11515a     // Catch:{ all -> 0x0087 }
            boolean r6 = androidx.concurrent.futures.b.a(r6, r8, r9, r1)     // Catch:{ all -> 0x0087 }
            if (r6 != 0) goto L_0x0043
            kotlinx.coroutines.internal.y r9 = ca.n1.f11529c     // Catch:{ all -> 0x0087 }
            monitor-exit(r1)
            return r9
        L_0x0043:
            boolean r6 = r1.f()     // Catch:{ all -> 0x0087 }
            boolean r7 = r10 instanceof ca.s     // Catch:{ all -> 0x0087 }
            if (r7 == 0) goto L_0x004f
            r7 = r10
            ca.s r7 = (ca.s) r7     // Catch:{ all -> 0x0087 }
            goto L_0x0050
        L_0x004f:
            r7 = r2
        L_0x0050:
            if (r7 == 0) goto L_0x0057
            java.lang.Throwable r7 = r7.f11549a     // Catch:{ all -> 0x0087 }
            r1.a(r7)     // Catch:{ all -> 0x0087 }
        L_0x0057:
            java.lang.Throwable r7 = r1.e()     // Catch:{ all -> 0x0087 }
            if (r6 != 0) goto L_0x005e
            r3 = 1
        L_0x005e:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0087 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x0069
            r2 = r7
        L_0x0069:
            r4.f19600a = r2     // Catch:{ all -> 0x0087 }
            h9.t r3 = h9.t.f17319a     // Catch:{ all -> 0x0087 }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0073
            r8.Z(r0, r2)
        L_0x0073:
            ca.o r9 = r8.G(r9)
            if (r9 == 0) goto L_0x0082
            boolean r9 = r8.r0(r1, r9, r10)
            if (r9 == 0) goto L_0x0082
            kotlinx.coroutines.internal.y r9 = ca.n1.f11528b
            return r9
        L_0x0082:
            java.lang.Object r9 = r8.F(r1, r10)
            return r9
        L_0x0087:
            r9 = move-exception
            monitor-exit(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.m1.q0(ca.a1, java.lang.Object):java.lang.Object");
    }

    public final Object r(Object obj) {
        Object p02;
        do {
            Object O = O();
            if (!(O instanceof a1) || ((O instanceof b) && ((b) O).g())) {
                return n1.f11527a;
            }
            p02 = p0(O, new s(D(obj), false, 2, (g) null));
        } while (p02 == n1.f11529c);
        return p02;
    }

    public final boolean r0(b bVar, o oVar, Object obj) {
        while (f1.a.d(oVar.f11534e, false, false, new a(this, bVar, oVar, obj), 1, (Object) null) == r1.f11547a) {
            oVar = Y(oVar);
            if (oVar == null) {
                return false;
            }
        }
        return true;
    }

    public f s(f fVar) {
        return f1.a.f(this, fVar);
    }

    public final boolean start() {
        int i02;
        do {
            i02 = i0(O());
            if (i02 == 0) {
                return false;
            }
        } while (i02 != 1);
        return true;
    }

    public final boolean t(Throwable th) {
        if (T()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        n N = N();
        if (N == null || N == r1.f11547a) {
            return z10;
        }
        if (N.b(th) || z10) {
            return true;
        }
        return false;
    }

    public String toString() {
        return m0() + '@' + g0.b(this);
    }

    public final o0 u(boolean z10, boolean z11, l lVar) {
        s sVar;
        l1 W = W(lVar, z10);
        while (true) {
            Object O = O();
            if (O instanceof p0) {
                p0 p0Var = (p0) O;
                if (!p0Var.isActive()) {
                    e0(p0Var);
                } else if (androidx.concurrent.futures.b.a(f11515a, this, O, W)) {
                    return W;
                }
            } else {
                Throwable th = null;
                if (O instanceof a1) {
                    q1 c10 = ((a1) O).c();
                    if (c10 != null) {
                        o0 o0Var = r1.f11547a;
                        if (z10 && (O instanceof b)) {
                            synchronized (O) {
                                th = ((b) O).e();
                                if (th == null || ((lVar instanceof o) && !((b) O).g())) {
                                    if (j(O, c10, W)) {
                                        if (th == null) {
                                            return W;
                                        }
                                        o0Var = W;
                                    }
                                }
                                t tVar = t.f17319a;
                            }
                        }
                        if (th != null) {
                            if (z11) {
                                lVar.invoke(th);
                            }
                            return o0Var;
                        } else if (j(O, c10, W)) {
                            return W;
                        }
                    } else if (O != null) {
                        f0((l1) O);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                } else {
                    if (z11) {
                        if (O instanceof s) {
                            sVar = (s) O;
                        } else {
                            sVar = null;
                        }
                        if (sVar != null) {
                            th = sVar.f11549a;
                        }
                        lVar.invoke(th);
                    }
                    return r1.f11547a;
                }
            }
        }
    }

    public final void v(t1 t1Var) {
        o(t1Var);
    }

    public String w() {
        return "Job was cancelled";
    }

    public final n x(p pVar) {
        return (n) f1.a.d(this, true, false, new o(pVar), 2, (Object) null);
    }

    public void Q(Throwable th) {
        throw th;
    }
}
