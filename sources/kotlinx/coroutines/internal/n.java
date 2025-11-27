package kotlinx.coroutines.internal;

import ca.g0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t9.i;
import t9.p;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18280a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18281b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18282c;
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    public static abstract class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public final n f18283b;

        /* renamed from: c  reason: collision with root package name */
        public n f18284c;

        public a(n nVar) {
            this.f18283b = nVar;
        }

        /* renamed from: h */
        public void d(n nVar, Object obj) {
            boolean z10;
            n nVar2;
            if (obj == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                nVar2 = this.f18283b;
            } else {
                nVar2 = this.f18284c;
            }
            if (nVar2 != null && androidx.concurrent.futures.b.a(n.f18280a, nVar, this, nVar2) && z10) {
                n nVar3 = this.f18283b;
                n nVar4 = this.f18284c;
                i.d(nVar4);
                nVar3.h(nVar4);
            }
        }
    }

    public /* synthetic */ class b extends p {
        public b(Object obj) {
            super(obj, g0.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
        }

        public Object get() {
            return g0.a(this.f19581b);
        }
    }

    static {
        Class<n> cls = n.class;
        Class<Object> cls2 = Object.class;
        f18280a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f18281b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
        f18282c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef");
    }

    public final boolean e(n nVar) {
        f18281b.lazySet(nVar, this);
        f18280a.lazySet(nVar, this);
        while (i() == this) {
            if (androidx.concurrent.futures.b.a(f18280a, this, this, nVar)) {
                nVar.h(this);
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: kotlinx.coroutines.internal.u} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlinx.coroutines.internal.n} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (androidx.concurrent.futures.b.a(f18280a, r3, r2, ((kotlinx.coroutines.internal.v) r4).f18301a) != false) goto L_0x004b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.n f(kotlinx.coroutines.internal.u r8) {
        /*
            r7 = this;
        L_0x0000:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.n r0 = (kotlinx.coroutines.internal.n) r0
            r1 = 0
            r2 = r0
        L_0x0006:
            r3 = r1
        L_0x0007:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L_0x0018
            if (r0 != r2) goto L_0x000e
            return r2
        L_0x000e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f18281b
            boolean r0 = androidx.concurrent.futures.b.a(r1, r7, r0, r2)
            if (r0 != 0) goto L_0x0017
            goto L_0x0000
        L_0x0017:
            return r2
        L_0x0018:
            boolean r5 = r7.l()
            if (r5 == 0) goto L_0x001f
            return r1
        L_0x001f:
            if (r4 != r8) goto L_0x0022
            return r2
        L_0x0022:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.u
            if (r5 == 0) goto L_0x0038
            if (r8 == 0) goto L_0x0032
            r0 = r4
            kotlinx.coroutines.internal.u r0 = (kotlinx.coroutines.internal.u) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L_0x0032
            return r1
        L_0x0032:
            kotlinx.coroutines.internal.u r4 = (kotlinx.coroutines.internal.u) r4
            r4.c(r2)
            goto L_0x0000
        L_0x0038:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.v
            if (r5 == 0) goto L_0x0052
            if (r3 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f18280a
            kotlinx.coroutines.internal.v r4 = (kotlinx.coroutines.internal.v) r4
            kotlinx.coroutines.internal.n r4 = r4.f18301a
            boolean r2 = androidx.concurrent.futures.b.a(r5, r3, r2, r4)
            if (r2 != 0) goto L_0x004b
            goto L_0x0000
        L_0x004b:
            r2 = r3
            goto L_0x0006
        L_0x004d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.n r2 = (kotlinx.coroutines.internal.n) r2
            goto L_0x0007
        L_0x0052:
            r3 = r4
            kotlinx.coroutines.internal.n r3 = (kotlinx.coroutines.internal.n) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.n.f(kotlinx.coroutines.internal.u):kotlinx.coroutines.internal.n");
    }

    public final n g(n nVar) {
        while (nVar.l()) {
            nVar = (n) nVar._prev;
        }
        return nVar;
    }

    public final void h(n nVar) {
        n nVar2;
        do {
            nVar2 = (n) nVar._prev;
            if (i() != nVar) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(f18281b, nVar, nVar2, this));
        if (l()) {
            nVar.f((u) null);
        }
    }

    public final Object i() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof u)) {
                return obj;
            }
            ((u) obj).c(this);
        }
    }

    public final n j() {
        return m.b(i());
    }

    public final n k() {
        n f10 = f((u) null);
        if (f10 == null) {
            return g((n) this._prev);
        }
        return f10;
    }

    public boolean l() {
        return i() instanceof v;
    }

    public boolean m() {
        if (n() == null) {
            return true;
        }
        return false;
    }

    public final n n() {
        Object i10;
        n nVar;
        do {
            i10 = i();
            if (i10 instanceof v) {
                return ((v) i10).f18301a;
            }
            if (i10 == this) {
                return (n) i10;
            }
            nVar = (n) i10;
        } while (!androidx.concurrent.futures.b.a(f18280a, this, i10, nVar.o()));
        nVar.f((u) null);
        return null;
    }

    public final v o() {
        v vVar = (v) this._removedRef;
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(this);
        f18282c.lazySet(this, vVar2);
        return vVar2;
    }

    public final int p(n nVar, n nVar2, a aVar) {
        f18281b.lazySet(nVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18280a;
        atomicReferenceFieldUpdater.lazySet(nVar, nVar2);
        aVar.f18284c = nVar2;
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, nVar2, aVar)) {
            return 0;
        }
        if (aVar.c(this) == null) {
            return 1;
        }
        return 2;
    }

    public String toString() {
        return new b(this) + '@' + g0.b(this);
    }
}
