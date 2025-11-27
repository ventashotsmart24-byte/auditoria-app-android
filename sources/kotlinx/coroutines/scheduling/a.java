package kotlinx.coroutines.scheduling;

import ca.g0;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import h9.t;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.y;
import t9.g;
import t9.i;
import y9.e;

public final class a implements Executor, Closeable {

    /* renamed from: h  reason: collision with root package name */
    public static final C0257a f18303h = new C0257a((g) null);

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18304i;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18305j;

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18306k;

    /* renamed from: l  reason: collision with root package name */
    public static final y f18307l = new y("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: a  reason: collision with root package name */
    public final int f18308a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18309b;

    /* renamed from: c  reason: collision with root package name */
    public final long f18310c;
    volatile /* synthetic */ long controlState;

    /* renamed from: d  reason: collision with root package name */
    public final String f18311d;

    /* renamed from: e  reason: collision with root package name */
    public final d f18312e;

    /* renamed from: f  reason: collision with root package name */
    public final d f18313f;

    /* renamed from: g  reason: collision with root package name */
    public final w f18314g;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: kotlinx.coroutines.scheduling.a$a  reason: collision with other inner class name */
    public static final class C0257a {
        public C0257a() {
        }

        public /* synthetic */ C0257a(g gVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18315a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            f18315a = iArr;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    static {
        Class<a> cls = a.class;
        f18304i = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        f18305j = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        f18306k = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public a(int i10, int i11, long j10, String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        this.f18308a = i10;
        this.f18309b = i11;
        this.f18310c = j10;
        this.f18311d = str;
        boolean z13 = true;
        if (i10 >= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= i10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i11 <= 2097150) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (j10 <= 0 ? false : z13) {
                        this.f18312e = new d();
                        this.f18313f = new d();
                        this.parkedWorkersStack = 0;
                        this.f18314g = new w(i10 + 1);
                        this.controlState = ((long) i10) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
    }

    public static /* synthetic */ boolean L(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = aVar.controlState;
        }
        return aVar.I(j10);
    }

    public static /* synthetic */ void m(a aVar, Runnable runnable, i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = l.f18348f;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.f(runnable, iVar, z10);
    }

    public final h E(c cVar, h hVar, boolean z10) {
        if (cVar == null || cVar.f18318b == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f18340b.b() == 0 && cVar.f18318b == d.BLOCKING) {
            return hVar;
        }
        cVar.f18322f = true;
        return cVar.f18317a.a(hVar, z10);
    }

    public final boolean I(long j10) {
        if (e.a(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0) < this.f18308a) {
            int b10 = b();
            if (b10 == 1 && this.f18308a > 1) {
                b();
            }
            if (b10 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean M() {
        c q10;
        do {
            q10 = q();
            if (q10 == null) {
                return false;
            }
        } while (!c.f18316h.compareAndSet(q10, -1, 0));
        LockSupport.unpark(q10);
        return true;
    }

    public final boolean a(h hVar) {
        boolean z10 = true;
        if (hVar.f18340b.b() != 1) {
            z10 = false;
        }
        if (z10) {
            return this.f18313f.a(hVar);
        }
        return this.f18312e.a(hVar);
    }

    public final int b() {
        boolean z10;
        synchronized (this.f18314g) {
            if (isTerminated()) {
                return -1;
            }
            long j10 = this.controlState;
            int i10 = (int) (j10 & 2097151);
            boolean z11 = false;
            int a10 = e.a(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
            if (a10 >= this.f18308a) {
                return 0;
            }
            if (i10 >= this.f18309b) {
                return 0;
            }
            int i11 = ((int) (this.controlState & 2097151)) + 1;
            if (i11 <= 0 || this.f18314g.b(i11) != null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                c cVar = new c(this, i11);
                this.f18314g.c(i11, cVar);
                if (i11 == ((int) (2097151 & f18305j.incrementAndGet(this)))) {
                    z11 = true;
                }
                if (z11) {
                    cVar.start();
                    int i12 = a10 + 1;
                    return i12;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final h c(Runnable runnable, i iVar) {
        long a10 = l.f18347e.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a10, iVar);
        }
        h hVar = (h) runnable;
        hVar.f18339a = a10;
        hVar.f18340b = iVar;
        return hVar;
    }

    public void close() {
        x(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    }

    public final c e() {
        c cVar;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof c) {
            cVar = (c) currentThread;
        } else {
            cVar = null;
        }
        if (cVar == null || !i.b(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public void execute(Runnable runnable) {
        m(this, runnable, (i) null, false, 6, (Object) null);
    }

    public final void f(Runnable runnable, i iVar, boolean z10) {
        boolean z11;
        ca.c.a();
        h c10 = c(runnable, iVar);
        c e10 = e();
        h E = E(e10, c10, z10);
        if (E == null || a(E)) {
            if (!z10 || e10 == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (c10.f18340b.b() != 0) {
                y(z11);
            } else if (!z11) {
                z();
            }
        } else {
            throw new RejectedExecutionException(this.f18311d + " was terminated");
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final int n(c cVar) {
        Object h10 = cVar.h();
        while (h10 != f18307l) {
            if (h10 == null) {
                return 0;
            }
            c cVar2 = (c) h10;
            int g10 = cVar2.g();
            if (g10 != 0) {
                return g10;
            }
            h10 = cVar2.h();
        }
        return -1;
    }

    public final c q() {
        while (true) {
            long j10 = this.parkedWorkersStack;
            c cVar = (c) this.f18314g.b((int) (2097151 & j10));
            if (cVar == null) {
                return null;
            }
            long j11 = (2097152 + j10) & -2097152;
            int n10 = n(cVar);
            if (n10 >= 0) {
                if (f18304i.compareAndSet(this, j10, ((long) n10) | j11)) {
                    cVar.p(f18307l);
                    return cVar;
                }
            }
        }
    }

    public final boolean s(c cVar) {
        long j10;
        int g10;
        if (cVar.h() != f18307l) {
            return false;
        }
        do {
            j10 = this.parkedWorkersStack;
            g10 = cVar.g();
            cVar.p(this.f18314g.b((int) (2097151 & j10)));
        } while (!f18304i.compareAndSet(this, j10, ((2097152 + j10) & -2097152) | ((long) g10)));
        return true;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a10 = this.f18314g.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < a10; i15++) {
            c cVar = (c) this.f18314g.b(i15);
            if (cVar != null) {
                int f10 = cVar.f18317a.f();
                int i16 = b.f18315a[cVar.f18318b.ordinal()];
                if (i16 == 1) {
                    i12++;
                } else if (i16 == 2) {
                    i11++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(f10);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i16 == 3) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(f10);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i16 == 4) {
                    i13++;
                    if (f10 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(f10);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i16 == 5) {
                    i14++;
                }
            }
        }
        long j10 = this.controlState;
        return this.f18311d + '@' + g0.b(this) + "[Pool Size {core = " + this.f18308a + ", max = " + this.f18309b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f18312e.c() + ", global blocking queue size = " + this.f18313f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f18308a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final void u(c cVar, int i10, int i11) {
        while (true) {
            long j10 = this.parkedWorkersStack;
            int i12 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & -2097152;
            if (i12 == i10) {
                if (i11 == 0) {
                    i12 = n(cVar);
                } else {
                    i12 = i11;
                }
            }
            if (i12 >= 0) {
                if (f18304i.compareAndSet(this, j10, j11 | ((long) i12))) {
                    return;
                }
            }
        }
    }

    public final void v(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            ca.c.a();
            throw th;
        }
        ca.c.a();
    }

    public final void x(long j10) {
        int i10;
        h hVar;
        if (f18306k.compareAndSet(this, 0, 1)) {
            c e10 = e();
            synchronized (this.f18314g) {
                i10 = (int) (this.controlState & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    Object b10 = this.f18314g.b(i11);
                    i.d(b10);
                    c cVar = (c) b10;
                    if (cVar != e10) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j10);
                        }
                        cVar.f18317a.g(this.f18313f);
                    }
                    if (i11 == i10) {
                        break;
                    }
                    i11++;
                }
            }
            this.f18313f.b();
            this.f18312e.b();
            while (true) {
                if (e10 != null) {
                    hVar = e10.f(true);
                    if (hVar != null) {
                        continue;
                        v(hVar);
                    }
                }
                hVar = (h) this.f18312e.d();
                if (hVar == null && (hVar = (h) this.f18313f.d()) == null) {
                    break;
                }
                v(hVar);
            }
            if (e10 != null) {
                e10.s(d.TERMINATED);
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }

    public final void y(boolean z10) {
        long addAndGet = f18305j.addAndGet(this, 2097152);
        if (!z10 && !M() && !I(addAndGet)) {
            M();
        }
    }

    public final void z() {
        if (!M() && !L(this, 0, 1, (Object) null)) {
            M();
        }
    }

    public final class c extends Thread {

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f18316h = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a  reason: collision with root package name */
        public final n f18317a;

        /* renamed from: b  reason: collision with root package name */
        public d f18318b;

        /* renamed from: c  reason: collision with root package name */
        public long f18319c;

        /* renamed from: d  reason: collision with root package name */
        public long f18320d;

        /* renamed from: e  reason: collision with root package name */
        public int f18321e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18322f;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        public c() {
            setDaemon(true);
            this.f18317a = new n();
            this.f18318b = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f18307l;
            this.f18321e = w9.c.f19764a.b();
        }

        public final void b(int i10) {
            if (i10 != 0) {
                a.f18305j.addAndGet(a.this, -2097152);
                if (this.f18318b != d.TERMINATED) {
                    this.f18318b = d.DORMANT;
                }
            }
        }

        public final void c(int i10) {
            if (i10 != 0 && s(d.BLOCKING)) {
                a.this.z();
            }
        }

        public final void d(h hVar) {
            int b10 = hVar.f18340b.b();
            i(b10);
            c(b10);
            a.this.v(hVar);
            b(b10);
        }

        public final h e(boolean z10) {
            boolean z11;
            h m10;
            h m11;
            if (z10) {
                if (k(a.this.f18308a * 2) == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (m11 = m()) != null) {
                    return m11;
                }
                h h10 = this.f18317a.h();
                if (h10 != null) {
                    return h10;
                }
                if (!z11 && (m10 = m()) != null) {
                    return m10;
                }
            } else {
                h m12 = m();
                if (m12 != null) {
                    return m12;
                }
            }
            return t(false);
        }

        public final h f(boolean z10) {
            h hVar;
            if (q()) {
                return e(z10);
            }
            if (z10) {
                hVar = this.f18317a.h();
                if (hVar == null) {
                    hVar = (h) a.this.f18313f.d();
                }
            } else {
                hVar = (h) a.this.f18313f.d();
            }
            if (hVar == null) {
                return t(true);
            }
            return hVar;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final void i(int i10) {
            this.f18319c = 0;
            if (this.f18318b == d.PARKING) {
                this.f18318b = d.BLOCKING;
            }
        }

        public final boolean j() {
            if (this.nextParkedWorker != a.f18307l) {
                return true;
            }
            return false;
        }

        public final int k(int i10) {
            int i11 = this.f18321e;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f18321e = i14;
            int i15 = i10 - 1;
            if ((i15 & i10) == 0) {
                return i14 & i15;
            }
            return (i14 & Integer.MAX_VALUE) % i10;
        }

        public final void l() {
            if (this.f18319c == 0) {
                this.f18319c = System.nanoTime() + a.this.f18310c;
            }
            LockSupport.parkNanos(a.this.f18310c);
            if (System.nanoTime() - this.f18319c >= 0) {
                this.f18319c = 0;
                u();
            }
        }

        public final h m() {
            if (k(2) == 0) {
                h hVar = (h) a.this.f18312e.d();
                if (hVar != null) {
                    return hVar;
                }
                return (h) a.this.f18313f.d();
            }
            h hVar2 = (h) a.this.f18313f.d();
            if (hVar2 != null) {
                return hVar2;
            }
            return (h) a.this.f18312e.d();
        }

        public final void n() {
            loop0:
            while (true) {
                boolean z10 = false;
                while (!a.this.isTerminated() && this.f18318b != d.TERMINATED) {
                    h f10 = f(this.f18322f);
                    if (f10 != null) {
                        this.f18320d = 0;
                        d(f10);
                    } else {
                        this.f18322f = false;
                        if (this.f18320d == 0) {
                            r();
                        } else if (!z10) {
                            z10 = true;
                        } else {
                            s(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f18320d);
                            this.f18320d = 0;
                        }
                    }
                }
            }
            s(d.TERMINATED);
        }

        public final void o(int i10) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f18311d);
            sb.append("-worker-");
            if (i10 == 0) {
                str = "TERMINATED";
            } else {
                str = String.valueOf(i10);
            }
            sb.append(str);
            setName(sb.toString());
            this.indexInArray = i10;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean q() {
            boolean z10;
            if (this.f18318b == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            while (true) {
                long j10 = aVar.controlState;
                if (((int) ((9223367638808264704L & j10) >> 42)) != 0) {
                    if (a.f18305j.compareAndSet(aVar, j10, j10 - 4398046511104L)) {
                        z10 = true;
                        break;
                    }
                } else {
                    z10 = false;
                    break;
                }
            }
            if (!z10) {
                return false;
            }
            this.f18318b = d.CPU_ACQUIRED;
            return true;
        }

        public final void r() {
            if (!j()) {
                a.this.s(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !a.this.isTerminated() && this.f18318b != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        public void run() {
            n();
        }

        public final boolean s(d dVar) {
            boolean z10;
            d dVar2 = this.f18318b;
            if (dVar2 == d.CPU_ACQUIRED) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                a.f18305j.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f18318b = dVar;
            }
            return z10;
        }

        public final h t(boolean z10) {
            long j10;
            int i10 = (int) (a.this.controlState & 2097151);
            if (i10 < 2) {
                return null;
            }
            int k10 = k(i10);
            a aVar = a.this;
            long j11 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < i10; i11++) {
                k10++;
                if (k10 > i10) {
                    k10 = 1;
                }
                c cVar = (c) aVar.f18314g.b(k10);
                if (!(cVar == null || cVar == this)) {
                    if (z10) {
                        j10 = this.f18317a.k(cVar.f18317a);
                    } else {
                        j10 = this.f18317a.l(cVar.f18317a);
                    }
                    if (j10 == -1) {
                        return this.f18317a.h();
                    }
                    if (j10 > 0) {
                        j11 = Math.min(j11, j10);
                    }
                }
            }
            if (j11 == Long.MAX_VALUE) {
                j11 = 0;
            }
            this.f18320d = j11;
            return null;
        }

        public final void u() {
            a aVar = a.this;
            synchronized (aVar.f18314g) {
                if (!aVar.isTerminated()) {
                    if (((int) (aVar.controlState & 2097151)) > aVar.f18308a) {
                        if (f18316h.compareAndSet(this, -1, 1)) {
                            int i10 = this.indexInArray;
                            o(0);
                            aVar.u(this, i10, 0);
                            int andDecrement = (int) (2097151 & a.f18305j.getAndDecrement(aVar));
                            if (andDecrement != i10) {
                                Object b10 = aVar.f18314g.b(andDecrement);
                                i.d(b10);
                                c cVar = (c) b10;
                                aVar.f18314g.c(i10, cVar);
                                cVar.o(i10);
                                aVar.u(cVar, andDecrement, i10);
                            }
                            aVar.f18314g.c(andDecrement, (Object) null);
                            t tVar = t.f17319a;
                            this.f18318b = d.TERMINATED;
                        }
                    }
                }
            }
        }

        public c(a aVar, int i10) {
            this();
            o(i10);
        }
    }
}
