package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.lang.Thread;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import y8.a;
import y8.a1;
import y8.c0;
import y8.d0;
import y8.d1;
import y8.e0;
import y8.f;
import y8.g;
import y8.h0;
import y8.i0;
import y8.k;
import y8.k1;
import y8.o0;
import y8.o1;
import y8.r0;
import y8.v;
import y8.v0;
import y8.w0;
import y8.x;
import y8.y;
import y8.y0;
import z8.i1;
import z8.j;
import z8.j1;
import z8.k;
import z8.m;
import z8.p;
import z8.x0;
import z8.x1;

public final class f1 extends r0 implements h0 {

    /* renamed from: n0  reason: collision with root package name */
    public static final Logger f20501n0 = Logger.getLogger(f1.class.getName());

    /* renamed from: o0  reason: collision with root package name */
    public static final Pattern f20502o0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* renamed from: p0  reason: collision with root package name */
    public static final k1 f20503p0;

    /* renamed from: q0  reason: collision with root package name */
    public static final k1 f20504q0;

    /* renamed from: r0  reason: collision with root package name */
    public static final k1 f20505r0;

    /* renamed from: s0  reason: collision with root package name */
    public static final i1 f20506s0 = i1.a();

    /* renamed from: t0  reason: collision with root package name */
    public static final e0 f20507t0 = new a();

    /* renamed from: u0  reason: collision with root package name */
    public static final y8.g f20508u0 = new f();
    public final y8.d A;
    public final String B;
    public y0 C;
    public boolean D;
    public n E;
    public volatile o0.i F;
    public boolean G;
    public final Set H = new HashSet(16, 0.75f);
    public Collection I;
    public final Object J = new Object();
    public final Set K = new HashSet(1, 0.75f);
    public final a0 L;
    public final t M = new t(this, (a) null);
    public final AtomicBoolean N = new AtomicBoolean(false);
    public boolean O;
    public boolean P;
    public volatile boolean Q;
    public final CountDownLatch R = new CountDownLatch(1);
    public final m.b S;
    public final m T;
    public final o U;
    public final y8.f V;
    public final c0 W;
    public final p X;
    public q Y = q.NO_RESOLUTION;
    public i1 Z = f20506s0;

    /* renamed from: a  reason: collision with root package name */
    public final i0 f20509a;

    /* renamed from: a0  reason: collision with root package name */
    public final i1 f20510a0;

    /* renamed from: b  reason: collision with root package name */
    public final String f20511b;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f20512b0 = false;

    /* renamed from: c  reason: collision with root package name */
    public final String f20513c;

    /* renamed from: c0  reason: collision with root package name */
    public final boolean f20514c0;

    /* renamed from: d  reason: collision with root package name */
    public final a1 f20515d;

    /* renamed from: d0  reason: collision with root package name */
    public final x1.t f20516d0 = new x1.t();

    /* renamed from: e  reason: collision with root package name */
    public final y0.c f20517e;

    /* renamed from: e0  reason: collision with root package name */
    public final long f20518e0;

    /* renamed from: f  reason: collision with root package name */
    public final y0.a f20519f;

    /* renamed from: f0  reason: collision with root package name */
    public final long f20520f0;

    /* renamed from: g  reason: collision with root package name */
    public final j f20521g;

    /* renamed from: g0  reason: collision with root package name */
    public final boolean f20522g0;

    /* renamed from: h  reason: collision with root package name */
    public final t f20523h;

    /* renamed from: h0  reason: collision with root package name */
    public final j1.a f20524h0;

    /* renamed from: i  reason: collision with root package name */
    public final t f20525i;

    /* renamed from: i0  reason: collision with root package name */
    public final v0 f20526i0;

    /* renamed from: j  reason: collision with root package name */
    public final t f20527j;

    /* renamed from: j0  reason: collision with root package name */
    public o1.d f20528j0;

    /* renamed from: k  reason: collision with root package name */
    public final r f20529k;

    /* renamed from: k0  reason: collision with root package name */
    public k f20530k0;

    /* renamed from: l  reason: collision with root package name */
    public final Executor f20531l;

    /* renamed from: l0  reason: collision with root package name */
    public final p.e f20532l0;

    /* renamed from: m  reason: collision with root package name */
    public final o1 f20533m;

    /* renamed from: m0  reason: collision with root package name */
    public final w1 f20534m0;

    /* renamed from: n  reason: collision with root package name */
    public final o1 f20535n;

    /* renamed from: o  reason: collision with root package name */
    public final k f20536o;

    /* renamed from: p  reason: collision with root package name */
    public final k f20537p;

    /* renamed from: q  reason: collision with root package name */
    public final j2 f20538q;

    /* renamed from: r  reason: collision with root package name */
    public final int f20539r;

    /* renamed from: s  reason: collision with root package name */
    public final o1 f20540s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f20541t;

    /* renamed from: u  reason: collision with root package name */
    public final v f20542u;

    /* renamed from: v  reason: collision with root package name */
    public final y8.o f20543v;

    /* renamed from: w  reason: collision with root package name */
    public final Supplier f20544w;

    /* renamed from: x  reason: collision with root package name */
    public final long f20545x;

    /* renamed from: y  reason: collision with root package name */
    public final w f20546y = new w();

    /* renamed from: z  reason: collision with root package name */
    public final k.a f20547z;

    public class a extends e0 {
        public e0.b a(o0.f fVar) {
            throw new IllegalStateException("Resolution is pending");
        }
    }

    public final class b implements m.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j2 f20548a;

        public b(j2 j2Var) {
            this.f20548a = j2Var;
        }

        public m create() {
            return new m(this.f20548a);
        }
    }

    public final class c extends o0.i {

        /* renamed from: a  reason: collision with root package name */
        public final o0.e f20550a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Throwable f20551b;

        public c(Throwable th) {
            this.f20551b = th;
            this.f20550a = o0.e.e(k1.f20055t.r("Panic! This is a bug!").q(th));
        }

        public o0.e a(o0.f fVar) {
            return this.f20550a;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) c.class).add("panicPickResult", (Object) this.f20550a).toString();
        }
    }

    public class d implements Thread.UncaughtExceptionHandler {
        public d() {
        }

        public void uncaughtException(Thread thread, Throwable th) {
            Logger logger = f1.f20501n0;
            Level level = Level.SEVERE;
            logger.log(level, "[" + f1.this.d() + "] Uncaught exception in the SynchronizationContext. Panic!", th);
            f1.this.A0(th);
        }
    }

    public class e extends m0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20554b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(y0 y0Var, String str) {
            super(y0Var);
            this.f20554b = str;
        }

        public String a() {
            return this.f20554b;
        }
    }

    public class f extends y8.g {
        public void a(String str, Throwable th) {
        }

        public void b() {
        }

        public void c(int i10) {
        }

        public void d(Object obj) {
        }

        public void e(g.a aVar, v0 v0Var) {
        }
    }

    public final class g implements p.e {

        public final class a implements Runnable {
            public a() {
            }

            public void run() {
                f1.this.u0();
            }
        }

        public final class b extends x1 {
            public final /* synthetic */ w0 E;
            public final /* synthetic */ v0 F;
            public final /* synthetic */ y8.c G;
            public final /* synthetic */ y1 H;
            public final /* synthetic */ s0 I;
            public final /* synthetic */ x1.c0 J;
            public final /* synthetic */ y8.r K;
            public final /* synthetic */ g L;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public b(z8.f1.g r16, y8.w0 r17, y8.v0 r18, y8.c r19, z8.y1 r20, z8.s0 r21, z8.x1.c0 r22, y8.r r23) {
                /*
                    r15 = this;
                    r13 = r15
                    r0 = r16
                    r1 = r19
                    r13.L = r0
                    r2 = r17
                    r13.E = r2
                    r3 = r18
                    r13.F = r3
                    r13.G = r1
                    r10 = r20
                    r13.H = r10
                    r11 = r21
                    r13.I = r11
                    r12 = r22
                    r13.J = r12
                    r4 = r23
                    r13.K = r4
                    z8.f1 r4 = z8.f1.this
                    z8.x1$t r4 = r4.f20516d0
                    z8.f1 r5 = z8.f1.this
                    long r5 = r5.f20518e0
                    z8.f1 r7 = z8.f1.this
                    long r7 = r7.f20520f0
                    z8.f1 r9 = z8.f1.this
                    java.util.concurrent.Executor r9 = r9.v0(r1)
                    z8.f1 r0 = z8.f1.this
                    z8.t r0 = r0.f20525i
                    java.util.concurrent.ScheduledExecutorService r14 = r0.p()
                    r0 = r15
                    r1 = r17
                    r2 = r18
                    r3 = r4
                    r4 = r5
                    r6 = r7
                    r8 = r9
                    r9 = r14
                    r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: z8.f1.g.b.<init>(z8.f1$g, y8.w0, y8.v0, y8.c, z8.y1, z8.s0, z8.x1$c0, y8.r):void");
            }

            public q i0(v0 v0Var, k.a aVar, int i10, boolean z10) {
                y8.c t10 = this.G.t(aVar);
                y8.k[] f10 = q0.f(t10, v0Var, i10, z10);
                s b10 = this.L.c(new r1(this.E, v0Var, t10));
                y8.r b11 = this.K.b();
                try {
                    return b10.b(this.E, v0Var, t10, f10);
                } finally {
                    this.K.f(b11);
                }
            }

            public void j0() {
                f1.this.M.c(this);
            }

            public k1 k0() {
                return f1.this.M.a(this);
            }
        }

        public g() {
        }

        public q a(w0 w0Var, y8.c cVar, v0 v0Var, y8.r rVar) {
            y1 y1Var;
            s0 s0Var;
            if (!f1.this.f20522g0) {
                s c10 = c(new r1(w0Var, v0Var, cVar));
                y8.r b10 = rVar.b();
                try {
                    return c10.b(w0Var, v0Var, cVar, q0.f(cVar, v0Var, 0, false));
                } finally {
                    rVar.f(b10);
                }
            } else {
                x1.c0 g10 = f1.this.Z.g();
                i1.b bVar = (i1.b) cVar.h(i1.b.f20690g);
                if (bVar == null) {
                    y1Var = null;
                } else {
                    y1Var = bVar.f20695e;
                }
                if (bVar == null) {
                    s0Var = null;
                } else {
                    s0Var = bVar.f20696f;
                }
                return new b(this, w0Var, v0Var, cVar, y1Var, s0Var, g10, rVar);
            }
        }

        public final s c(o0.f fVar) {
            o0.i m10 = f1.this.F;
            if (f1.this.N.get()) {
                return f1.this.L;
            }
            if (m10 == null) {
                f1.this.f20540s.execute(new a());
                return f1.this.L;
            }
            s j10 = q0.j(m10.a(fVar), fVar.a().j());
            if (j10 != null) {
                return j10;
            }
            return f1.this.L;
        }

        public /* synthetic */ g(f1 f1Var, a aVar) {
            this();
        }
    }

    public static final class h extends y {

        /* renamed from: a  reason: collision with root package name */
        public final e0 f20557a;

        /* renamed from: b  reason: collision with root package name */
        public final y8.d f20558b;

        /* renamed from: c  reason: collision with root package name */
        public final Executor f20559c;

        /* renamed from: d  reason: collision with root package name */
        public final w0 f20560d;

        /* renamed from: e  reason: collision with root package name */
        public final y8.r f20561e;

        /* renamed from: f  reason: collision with root package name */
        public y8.c f20562f;

        /* renamed from: g  reason: collision with root package name */
        public y8.g f20563g;

        public class a extends x {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g.a f20564b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ k1 f20565c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(g.a aVar, k1 k1Var) {
                super(h.this.f20561e);
                this.f20564b = aVar;
                this.f20565c = k1Var;
            }

            public void a() {
                this.f20564b.a(this.f20565c, new v0());
            }
        }

        public h(e0 e0Var, y8.d dVar, Executor executor, w0 w0Var, y8.c cVar) {
            this.f20557a = e0Var;
            this.f20558b = dVar;
            this.f20560d = w0Var;
            executor = cVar.e() != null ? cVar.e() : executor;
            this.f20559c = executor;
            this.f20562f = cVar.p(executor);
            this.f20561e = y8.r.e();
        }

        public void a(String str, Throwable th) {
            y8.g gVar = this.f20563g;
            if (gVar != null) {
                gVar.a(str, th);
            }
        }

        public void e(g.a aVar, v0 v0Var) {
            e0.b a10 = this.f20557a.a(new r1(this.f20560d, v0Var, this.f20562f));
            k1 c10 = a10.c();
            if (!c10.p()) {
                h(aVar, q0.n(c10));
                this.f20563g = f1.f20508u0;
                return;
            }
            y8.h b10 = a10.b();
            i1.b f10 = ((i1) a10.a()).f(this.f20560d);
            if (f10 != null) {
                this.f20562f = this.f20562f.s(i1.b.f20690g, f10);
            }
            if (b10 != null) {
                this.f20563g = b10.a(this.f20560d, this.f20562f, this.f20558b);
            } else {
                this.f20563g = this.f20558b.h(this.f20560d, this.f20562f);
            }
            this.f20563g.e(aVar, v0Var);
        }

        public y8.g f() {
            return this.f20563g;
        }

        public final void h(g.a aVar, k1 k1Var) {
            this.f20559c.execute(new a(aVar, k1Var));
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            o1.d unused = f1.this.f20528j0 = null;
            f1.this.C0();
        }
    }

    public final class j implements j1.a {
        public j() {
        }

        public void a() {
        }

        public void b(boolean z10) {
            f1 f1Var = f1.this;
            f1Var.f20526i0.e(f1Var.L, z10);
        }

        public void c(k1 k1Var) {
            Preconditions.checkState(f1.this.N.get(), "Channel must have been shut down");
        }

        public void d() {
            Preconditions.checkState(f1.this.N.get(), "Channel must have been shut down");
            boolean unused = f1.this.P = true;
            f1.this.E0(false);
            f1.this.y0();
            f1.this.z0();
        }

        public /* synthetic */ j(f1 f1Var, a aVar) {
            this();
        }
    }

    public static final class k implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final o1 f20569a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f20570b;

        public k(o1 o1Var) {
            this.f20569a = (o1) Preconditions.checkNotNull(o1Var, "executorPool");
        }

        public synchronized Executor a() {
            if (this.f20570b == null) {
                this.f20570b = (Executor) Preconditions.checkNotNull((Executor) this.f20569a.a(), "%s.getObject()", (Object) this.f20570b);
            }
            return this.f20570b;
        }

        public synchronized void b() {
            Executor executor = this.f20570b;
            if (executor != null) {
                this.f20570b = (Executor) this.f20569a.b(executor);
            }
        }

        public void execute(Runnable runnable) {
            a().execute(runnable);
        }
    }

    public final class l extends v0 {
        public l() {
        }

        public void b() {
            f1.this.u0();
        }

        public void c() {
            if (!f1.this.N.get()) {
                f1.this.D0();
            }
        }

        public /* synthetic */ l(f1 f1Var, a aVar) {
            this();
        }
    }

    public class m implements Runnable {
        public m() {
        }

        public void run() {
            if (f1.this.E != null) {
                f1.this.t0();
            }
        }

        public /* synthetic */ m(f1 f1Var, a aVar) {
            this();
        }
    }

    public final class n extends o0.d {

        /* renamed from: a  reason: collision with root package name */
        public j.b f20573a;

        public final class a implements Runnable {
            public a() {
            }

            public void run() {
                f1.this.B0();
            }
        }

        public final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ o0.i f20576a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ y8.p f20577b;

            public b(o0.i iVar, y8.p pVar) {
                this.f20576a = iVar;
                this.f20577b = pVar;
            }

            public void run() {
                n nVar = n.this;
                if (nVar == f1.this.E) {
                    f1.this.F0(this.f20576a);
                    if (this.f20577b != y8.p.SHUTDOWN) {
                        f1.this.V.b(f.a.INFO, "Entering {0} state with picker: {1}", this.f20577b, this.f20576a);
                        f1.this.f20546y.a(this.f20577b);
                    }
                }
            }
        }

        public n() {
        }

        public y8.f b() {
            return f1.this.V;
        }

        public ScheduledExecutorService c() {
            return f1.this.f20529k;
        }

        public o1 d() {
            return f1.this.f20540s;
        }

        public void e() {
            f1.this.f20540s.e();
            f1.this.f20540s.execute(new a());
        }

        public void f(y8.p pVar, o0.i iVar) {
            f1.this.f20540s.e();
            Preconditions.checkNotNull(pVar, "newState");
            Preconditions.checkNotNull(iVar, "newPicker");
            f1.this.f20540s.execute(new b(iVar, pVar));
        }

        /* renamed from: g */
        public e a(o0.b bVar) {
            f1.this.f20540s.e();
            Preconditions.checkState(!f1.this.P, "Channel is being terminated");
            return new s(bVar, this);
        }

        public /* synthetic */ n(f1 f1Var, a aVar) {
            this();
        }
    }

    public final class o extends y0.d {

        /* renamed from: a  reason: collision with root package name */
        public final n f20579a;

        /* renamed from: b  reason: collision with root package name */
        public final y0 f20580b;

        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k1 f20582a;

            public a(k1 k1Var) {
                this.f20582a = k1Var;
            }

            public void run() {
                o.this.e(this.f20582a);
            }
        }

        public final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ y0.e f20584a;

            public b(y0.e eVar) {
                this.f20584a = eVar;
            }

            public void run() {
                i1 i1Var;
                k1 k1Var;
                i1 i1Var2;
                String str;
                if (f1.this.C == o.this.f20580b) {
                    List a10 = this.f20584a.a();
                    y8.f z10 = f1.this.V;
                    f.a aVar = f.a.DEBUG;
                    z10.b(aVar, "Resolved address: {0}, config={1}", a10, this.f20584a.b());
                    q d02 = f1.this.Y;
                    q qVar = q.f20603b;
                    if (d02 != qVar) {
                        f1.this.V.b(f.a.INFO, "Address resolved: {0}", a10);
                        q unused = f1.this.Y = qVar;
                    }
                    k unused2 = f1.this.f20530k0 = null;
                    y0.b c10 = this.f20584a.c();
                    e0 e0Var = (e0) this.f20584a.b().b(e0.f19995a);
                    if (c10 == null || c10.c() == null) {
                        i1Var = null;
                    } else {
                        i1Var = (i1) c10.c();
                    }
                    if (c10 != null) {
                        k1Var = c10.d();
                    } else {
                        k1Var = null;
                    }
                    if (!f1.this.f20514c0) {
                        if (i1Var != null) {
                            f1.this.V.a(f.a.INFO, "Service config from name resolver discarded by channel settings");
                        }
                        if (f1.this.f20510a0 == null) {
                            i1Var2 = f1.f20506s0;
                        } else {
                            i1Var2 = f1.this.f20510a0;
                        }
                        if (e0Var != null) {
                            f1.this.V.a(f.a.INFO, "Config selector from name resolver discarded by channel settings");
                        }
                        f1.this.X.n(i1Var2.c());
                    } else {
                        if (i1Var != null) {
                            if (e0Var != null) {
                                f1.this.X.n(e0Var);
                                if (i1Var.c() != null) {
                                    f1.this.V.a(aVar, "Method configs in service config will be discarded due to presence ofconfig-selector");
                                }
                            } else {
                                f1.this.X.n(i1Var.c());
                            }
                        } else if (f1.this.f20510a0 != null) {
                            i1Var = f1.this.f20510a0;
                            f1.this.X.n(i1Var.c());
                            f1.this.V.a(f.a.INFO, "Received no service config, using default service config");
                        } else if (k1Var == null) {
                            i1Var = f1.f20506s0;
                            f1.this.X.n((e0) null);
                        } else if (!f1.this.f20512b0) {
                            f1.this.V.a(f.a.INFO, "Fallback to error due to invalid first service config without default config");
                            o.this.a(c10.d());
                            return;
                        } else {
                            i1Var = f1.this.Z;
                        }
                        if (!i1Var.equals(f1.this.Z)) {
                            y8.f z11 = f1.this.V;
                            f.a aVar2 = f.a.INFO;
                            Object[] objArr = new Object[1];
                            if (i1Var == f1.f20506s0) {
                                str = " to empty";
                            } else {
                                str = "";
                            }
                            objArr[0] = str;
                            z11.b(aVar2, "Service config changed{0}", objArr);
                            i1 unused3 = f1.this.Z = i1Var;
                        }
                        try {
                            boolean unused4 = f1.this.f20512b0 = true;
                        } catch (RuntimeException e10) {
                            f1.f20501n0.log(Level.WARNING, "[" + f1.this.d() + "] Unexpected exception from parsing service config", e10);
                        }
                        i1Var2 = i1Var;
                    }
                    y8.a b10 = this.f20584a.b();
                    o oVar = o.this;
                    if (oVar.f20579a == f1.this.E) {
                        a.b c11 = b10.d().c(e0.f19995a);
                        Map d10 = i1Var2.d();
                        if (d10 != null) {
                            c11.d(o0.f20103b, d10).a();
                        }
                        if (!o.this.f20579a.f20573a.d(o0.g.d().b(a10).c(c11.a()).d(i1Var2.e()).a())) {
                            o.this.f();
                        }
                    }
                }
            }
        }

        public o(n nVar, y0 y0Var) {
            this.f20579a = (n) Preconditions.checkNotNull(nVar, "helperImpl");
            this.f20580b = (y0) Preconditions.checkNotNull(y0Var, "resolver");
        }

        public void a(k1 k1Var) {
            Preconditions.checkArgument(!k1Var.p(), "the error status must not be OK");
            f1.this.f20540s.execute(new a(k1Var));
        }

        public void b(y0.e eVar) {
            f1.this.f20540s.execute(new b(eVar));
        }

        public final void e(k1 k1Var) {
            f1.f20501n0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{f1.this.d(), k1Var});
            f1.this.X.m();
            q d02 = f1.this.Y;
            q qVar = q.f20604c;
            if (d02 != qVar) {
                f1.this.V.b(f.a.WARNING, "Failed to resolve name: {0}", k1Var);
                q unused = f1.this.Y = qVar;
            }
            if (this.f20579a == f1.this.E) {
                this.f20579a.f20573a.b(k1Var);
                f();
            }
        }

        public final void f() {
            if (f1.this.f20528j0 == null || !f1.this.f20528j0.b()) {
                if (f1.this.f20530k0 == null) {
                    f1 f1Var = f1.this;
                    k unused = f1Var.f20530k0 = f1Var.f20547z.get();
                }
                long a10 = f1.this.f20530k0.a();
                f1.this.V.b(f.a.DEBUG, "Scheduling DNS resolution backoff for {0} ns", Long.valueOf(a10));
                f1 f1Var2 = f1.this;
                o1.d unused2 = f1Var2.f20528j0 = f1Var2.f20540s.c(new i(), a10, TimeUnit.NANOSECONDS, f1.this.f20525i.p());
            }
        }
    }

    public class p extends y8.d {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReference f20586a;

        /* renamed from: b  reason: collision with root package name */
        public final String f20587b;

        /* renamed from: c  reason: collision with root package name */
        public final y8.d f20588c;

        public class a extends y8.d {
            public a() {
            }

            public String a() {
                return p.this.f20587b;
            }

            public y8.g h(w0 w0Var, y8.c cVar) {
                ScheduledExecutorService scheduledExecutorService;
                Executor v10 = f1.this.v0(cVar);
                p.e F = f1.this.f20532l0;
                if (f1.this.Q) {
                    scheduledExecutorService = null;
                } else {
                    scheduledExecutorService = f1.this.f20525i.p();
                }
                return new p(w0Var, v10, cVar, F, scheduledExecutorService, f1.this.T, (e0) null).C(f1.this.f20541t).B(f1.this.f20542u).A(f1.this.f20543v);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                f1.this.u0();
            }
        }

        public class c extends y8.g {
            public c() {
            }

            public void a(String str, Throwable th) {
            }

            public void b() {
            }

            public void c(int i10) {
            }

            public void d(Object obj) {
            }

            public void e(g.a aVar, v0 v0Var) {
                aVar.a(f1.f20504q0, new v0());
            }
        }

        public class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f20593a;

            public d(e eVar) {
                this.f20593a = eVar;
            }

            public void run() {
                if (p.this.f20586a.get() == f1.f20507t0) {
                    if (f1.this.I == null) {
                        Collection unused = f1.this.I = new LinkedHashSet();
                        f1 f1Var = f1.this;
                        f1Var.f20526i0.e(f1Var.J, true);
                    }
                    f1.this.I.add(this.f20593a);
                    return;
                }
                this.f20593a.r();
            }
        }

        public final class e extends z {

            /* renamed from: l  reason: collision with root package name */
            public final y8.r f20595l;

            /* renamed from: m  reason: collision with root package name */
            public final w0 f20596m;

            /* renamed from: n  reason: collision with root package name */
            public final y8.c f20597n;

            public class a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Runnable f20599a;

                public a(Runnable runnable) {
                    this.f20599a = runnable;
                }

                public void run() {
                    this.f20599a.run();
                    e eVar = e.this;
                    f1.this.f20540s.execute(new b());
                }
            }

            public final class b implements Runnable {
                public b() {
                }

                public void run() {
                    if (f1.this.I != null) {
                        f1.this.I.remove(e.this);
                        if (f1.this.I.isEmpty()) {
                            f1 f1Var = f1.this;
                            f1Var.f20526i0.e(f1Var.J, false);
                            Collection unused = f1.this.I = null;
                            if (f1.this.N.get()) {
                                f1.this.M.b(f1.f20504q0);
                            }
                        }
                    }
                }
            }

            public e(y8.r rVar, w0 w0Var, y8.c cVar) {
                super(f1.this.v0(cVar), f1.this.f20529k, cVar.d());
                this.f20595l = rVar;
                this.f20596m = w0Var;
                this.f20597n = cVar;
            }

            public void j() {
                super.j();
                f1.this.f20540s.execute(new b());
            }

            /* JADX INFO: finally extract failed */
            public void r() {
                y8.r b10 = this.f20595l.b();
                try {
                    y8.g k10 = p.this.l(this.f20596m, this.f20597n);
                    this.f20595l.f(b10);
                    Runnable p10 = p(k10);
                    if (p10 == null) {
                        f1.this.f20540s.execute(new b());
                    } else {
                        f1.this.v0(this.f20597n).execute(new a(p10));
                    }
                } catch (Throwable th) {
                    this.f20595l.f(b10);
                    throw th;
                }
            }
        }

        public /* synthetic */ p(f1 f1Var, String str, a aVar) {
            this(str);
        }

        public String a() {
            return this.f20587b;
        }

        public y8.g h(w0 w0Var, y8.c cVar) {
            if (this.f20586a.get() != f1.f20507t0) {
                return l(w0Var, cVar);
            }
            f1.this.f20540s.execute(new b());
            if (this.f20586a.get() != f1.f20507t0) {
                return l(w0Var, cVar);
            }
            if (f1.this.N.get()) {
                return new c();
            }
            e eVar = new e(y8.r.e(), w0Var, cVar);
            f1.this.f20540s.execute(new d(eVar));
            return eVar;
        }

        public final y8.g l(w0 w0Var, y8.c cVar) {
            e0 e0Var = (e0) this.f20586a.get();
            if (e0Var == null) {
                return this.f20588c.h(w0Var, cVar);
            }
            if (!(e0Var instanceof i1.c)) {
                return new h(e0Var, this.f20588c, f1.this.f20531l, w0Var, cVar);
            }
            i1.b f10 = ((i1.c) e0Var).f20697b.f(w0Var);
            if (f10 != null) {
                cVar = cVar.s(i1.b.f20690g, f10);
            }
            return this.f20588c.h(w0Var, cVar);
        }

        public void m() {
            if (this.f20586a.get() == f1.f20507t0) {
                n((e0) null);
            }
        }

        public void n(e0 e0Var) {
            e0 e0Var2 = (e0) this.f20586a.get();
            this.f20586a.set(e0Var);
            if (e0Var2 == f1.f20507t0 && f1.this.I != null) {
                for (e r10 : f1.this.I) {
                    r10.r();
                }
            }
        }

        public p(String str) {
            this.f20586a = new AtomicReference(f1.f20507t0);
            this.f20588c = new a();
            this.f20587b = (String) Preconditions.checkNotNull(str, "authority");
        }
    }

    public enum q {
        NO_RESOLUTION,
        f20603b,
        f20604c
    }

    public static final class r implements ScheduledExecutorService {

        /* renamed from: a  reason: collision with root package name */
        public final ScheduledExecutorService f20606a;

        public /* synthetic */ r(ScheduledExecutorService scheduledExecutorService, a aVar) {
            this(scheduledExecutorService);
        }

        public boolean awaitTermination(long j10, TimeUnit timeUnit) {
            return this.f20606a.awaitTermination(j10, timeUnit);
        }

        public void execute(Runnable runnable) {
            this.f20606a.execute(runnable);
        }

        public List invokeAll(Collection collection) {
            return this.f20606a.invokeAll(collection);
        }

        public Object invokeAny(Collection collection) {
            return this.f20606a.invokeAny(collection);
        }

        public boolean isShutdown() {
            return this.f20606a.isShutdown();
        }

        public boolean isTerminated() {
            return this.f20606a.isTerminated();
        }

        public ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit) {
            return this.f20606a.schedule(callable, j10, timeUnit);
        }

        public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f20606a.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
        }

        public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f20606a.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
        }

        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        public List shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        public Future submit(Callable callable) {
            return this.f20606a.submit(callable);
        }

        public r(ScheduledExecutorService scheduledExecutorService) {
            this.f20606a = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "delegate");
        }

        public List invokeAll(Collection collection, long j10, TimeUnit timeUnit) {
            return this.f20606a.invokeAll(collection, j10, timeUnit);
        }

        public Object invokeAny(Collection collection, long j10, TimeUnit timeUnit) {
            return this.f20606a.invokeAny(collection, j10, timeUnit);
        }

        public ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f20606a.schedule(runnable, j10, timeUnit);
        }

        public Future submit(Runnable runnable) {
            return this.f20606a.submit(runnable);
        }

        public Future submit(Runnable runnable, Object obj) {
            return this.f20606a.submit(runnable, obj);
        }
    }

    public final class s extends e {

        /* renamed from: a  reason: collision with root package name */
        public final o0.b f20607a;

        /* renamed from: b  reason: collision with root package name */
        public final n f20608b;

        /* renamed from: c  reason: collision with root package name */
        public final i0 f20609c;

        /* renamed from: d  reason: collision with root package name */
        public final n f20610d;

        /* renamed from: e  reason: collision with root package name */
        public final o f20611e;

        /* renamed from: f  reason: collision with root package name */
        public List f20612f;

        /* renamed from: g  reason: collision with root package name */
        public x0 f20613g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f20614h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f20615i;

        /* renamed from: j  reason: collision with root package name */
        public o1.d f20616j;

        public final class a extends x0.j {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ o0.j f20618a;

            public a(o0.j jVar) {
                this.f20618a = jVar;
            }

            public void a(x0 x0Var) {
                f1.this.f20526i0.e(x0Var, true);
            }

            public void b(x0 x0Var) {
                f1.this.f20526i0.e(x0Var, false);
            }

            public void c(x0 x0Var, y8.q qVar) {
                boolean z10;
                if (this.f20618a != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkState(z10, "listener is null");
                this.f20618a.a(qVar);
            }

            public void d(x0 x0Var) {
                f1.this.H.remove(x0Var);
                f1.this.W.k(x0Var);
                f1.this.z0();
            }
        }

        public final class b implements Runnable {
            public b() {
            }

            public void run() {
                s.this.f20613g.c(f1.f20505r0);
            }
        }

        public s(o0.b bVar, n nVar) {
            Preconditions.checkNotNull(bVar, "args");
            this.f20612f = bVar.a();
            if (f1.this.f20513c != null) {
                bVar = bVar.d().d(i(bVar.a())).b();
            }
            this.f20607a = bVar;
            this.f20608b = (n) Preconditions.checkNotNull(nVar, "helper");
            i0 b10 = i0.b("Subchannel", f1.this.a());
            this.f20609c = b10;
            int U = f1.this.f20539r;
            long a10 = f1.this.f20538q.a();
            o oVar = new o(b10, U, a10, "Subchannel for " + bVar.a());
            this.f20611e = oVar;
            this.f20610d = new n(oVar, f1.this.f20538q);
        }

        public List b() {
            f1.this.f20540s.e();
            Preconditions.checkState(this.f20614h, "not started");
            return this.f20612f;
        }

        public y8.a c() {
            return this.f20607a.b();
        }

        public Object d() {
            Preconditions.checkState(this.f20614h, "Subchannel is not started");
            return this.f20613g;
        }

        public void e() {
            f1.this.f20540s.e();
            Preconditions.checkState(this.f20614h, "not started");
            this.f20613g.a();
        }

        public void f() {
            o1.d dVar;
            f1.this.f20540s.e();
            if (this.f20613g == null) {
                this.f20615i = true;
                return;
            }
            if (!this.f20615i) {
                this.f20615i = true;
            } else if (f1.this.P && (dVar = this.f20616j) != null) {
                dVar.a();
                this.f20616j = null;
            } else {
                return;
            }
            if (!f1.this.P) {
                this.f20616j = f1.this.f20540s.c(new c1(new b()), 5, TimeUnit.SECONDS, f1.this.f20525i.p());
            } else {
                this.f20613g.c(f1.f20504q0);
            }
        }

        public void g(o0.j jVar) {
            f1.this.f20540s.e();
            Preconditions.checkState(!this.f20614h, "already started");
            Preconditions.checkState(!this.f20615i, "already shutdown");
            Preconditions.checkState(!f1.this.P, "Channel is being terminated");
            this.f20614h = true;
            List a10 = this.f20607a.a();
            String a11 = f1.this.a();
            String Y = f1.this.B;
            k.a Z = f1.this.f20547z;
            t w10 = f1.this.f20525i;
            ScheduledExecutorService p10 = f1.this.f20525i.p();
            Supplier a02 = f1.this.f20544w;
            o1 o1Var = f1.this.f20540s;
            a aVar = new a(jVar);
            c0 W = f1.this.W;
            m create = f1.this.S.create();
            o oVar = this.f20611e;
            x0 x0Var = new x0(a10, a11, Y, Z, w10, p10, a02, o1Var, aVar, W, create, oVar, this.f20609c, this.f20610d);
            f1.this.U.e(new d0.a().b("Child Subchannel started").c(d0.b.CT_INFO).e(f1.this.f20538q.a()).d(x0Var).a());
            this.f20613g = x0Var;
            f1.this.W.e(x0Var);
            f1.this.H.add(x0Var);
        }

        public void h(List list) {
            f1.this.f20540s.e();
            this.f20612f = list;
            if (f1.this.f20513c != null) {
                list = i(list);
            }
            this.f20613g.T(list);
        }

        public final List i(List list) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                x xVar = (x) it.next();
                arrayList.add(new x(xVar.a(), xVar.b().d().c(x.f20218d).a()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public String toString() {
            return this.f20609c.toString();
        }
    }

    static {
        k1 k1Var = k1.f20056u;
        f20503p0 = k1Var.r("Channel shutdownNow invoked");
        f20504q0 = k1Var.r("Channel shutdown invoked");
        f20505r0 = k1Var.r("Subchannel shutdown invoked");
    }

    public f1(g1 g1Var, t tVar, k.a aVar, o1 o1Var, Supplier supplier, List list, j2 j2Var) {
        a aVar2;
        boolean z10;
        boolean z11;
        g1 g1Var2 = g1Var;
        t tVar2 = tVar;
        o1 o1Var2 = o1Var;
        j2 j2Var2 = j2Var;
        o1 o1Var3 = new o1(new d());
        this.f20540s = o1Var3;
        j jVar = new j(this, (a) null);
        this.f20524h0 = jVar;
        this.f20526i0 = new l(this, (a) null);
        this.f20532l0 = new g(this, (a) null);
        String str = (String) Preconditions.checkNotNull(g1Var2.f20643f, "target");
        this.f20511b = str;
        i0 b10 = i0.b("Channel", str);
        this.f20509a = b10;
        this.f20538q = (j2) Preconditions.checkNotNull(j2Var2, "timeProvider");
        o1 o1Var4 = (o1) Preconditions.checkNotNull(g1Var2.f20638a, "executorPool");
        this.f20533m = o1Var4;
        Executor executor = (Executor) Preconditions.checkNotNull((Executor) o1Var4.a(), "executor");
        this.f20531l = executor;
        this.f20523h = tVar2;
        k kVar = new k((o1) Preconditions.checkNotNull(g1Var2.f20639b, "offloadExecutorPool"));
        this.f20537p = kVar;
        l lVar = new l(tVar2, g1Var2.f20644g, kVar);
        this.f20525i = lVar;
        this.f20527j = new l(tVar2, (y8.b) null, kVar);
        r rVar = new r(lVar.p(), (a) null);
        this.f20529k = rVar;
        this.f20539r = g1Var2.f20659v;
        int i10 = g1Var2.f20659v;
        long a10 = j2Var.a();
        o oVar = r12;
        l lVar2 = lVar;
        int i11 = i10;
        k kVar2 = kVar;
        o oVar2 = new o(b10, i11, a10, "Channel for '" + str + "'");
        this.U = oVar;
        n nVar = new n(oVar, j2Var2);
        this.V = nVar;
        d1 d1Var = g1Var2.f20662y;
        d1Var = d1Var == null ? q0.f20888q : d1Var;
        boolean z12 = g1Var2.f20657t;
        this.f20522g0 = z12;
        j jVar2 = new j(g1Var2.f20648k);
        this.f20521g = jVar2;
        this.f20515d = g1Var2.f20641d;
        z1 z1Var = new z1(z12, g1Var2.f20653p, g1Var2.f20654q, jVar2);
        String str2 = g1Var2.f20647j;
        this.f20513c = str2;
        y0.a a11 = y0.a.f().c(g1Var.c()).f(d1Var).i(o1Var3).g(rVar).h(z1Var).b(nVar).d(kVar2).e(str2).a();
        this.f20519f = a11;
        y0.c cVar = g1Var2.f20642e;
        this.f20517e = cVar;
        this.C = w0(str, str2, cVar, a11);
        this.f20535n = (o1) Preconditions.checkNotNull(o1Var2, "balancerRpcExecutorPool");
        this.f20536o = new k(o1Var2);
        a0 a0Var = new a0(executor, o1Var3);
        this.L = a0Var;
        a0Var.e(jVar);
        this.f20547z = aVar;
        Map map = g1Var2.f20660w;
        if (map != null) {
            y0.b a12 = z1Var.a(map);
            if (a12.d() == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "Default config is invalid: %s", (Object) a12.d());
            i1 i1Var = (i1) a12.c();
            this.f20510a0 = i1Var;
            this.Z = i1Var;
            aVar2 = null;
        } else {
            aVar2 = null;
            this.f20510a0 = null;
        }
        boolean z13 = g1Var2.f20661x;
        this.f20514c0 = z13;
        p pVar = new p(this, this.C.a(), aVar2);
        this.X = pVar;
        this.A = y8.j.a(pVar, list);
        this.f20544w = (Supplier) Preconditions.checkNotNull(supplier, "stopwatchSupplier");
        long j10 = g1Var2.f20652o;
        if (j10 == -1) {
            this.f20545x = j10;
        } else {
            if (j10 >= g1.J) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "invalid idleTimeoutMillis %s", j10);
            this.f20545x = g1Var2.f20652o;
        }
        this.f20534m0 = new w1(new m(this, (a) null), o1Var3, lVar2.p(), (Stopwatch) supplier.get());
        this.f20541t = g1Var2.f20649l;
        this.f20542u = (v) Preconditions.checkNotNull(g1Var2.f20650m, "decompressorRegistry");
        this.f20543v = (y8.o) Preconditions.checkNotNull(g1Var2.f20651n, "compressorRegistry");
        this.B = g1Var2.f20646i;
        this.f20520f0 = g1Var2.f20655r;
        this.f20518e0 = g1Var2.f20656s;
        b bVar = new b(j2Var);
        this.S = bVar;
        this.T = bVar.create();
        c0 c0Var = (c0) Preconditions.checkNotNull(g1Var2.f20658u);
        this.W = c0Var;
        c0Var.d(this);
        if (!z13) {
            if (this.f20510a0 != null) {
                nVar.a(f.a.INFO, "Service config look-up disabled, using default service config");
            }
            this.f20512b0 = true;
        }
    }

    public static y0 w0(String str, String str2, y0.c cVar, y0.a aVar) {
        y0 x02 = x0(str, cVar, aVar);
        if (str2 == null) {
            return x02;
        }
        return new e(x02, str2);
    }

    public static y0 x0(String str, y0.c cVar, y0.a aVar) {
        URI uri;
        y0 b10;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e10) {
            sb.append(e10.getMessage());
            uri = null;
        }
        if (uri != null && (b10 = cVar.b(uri, aVar)) != null) {
            return b10;
        }
        String str2 = "";
        if (!f20502o0.matcher(str).matches()) {
            try {
                y0 b11 = cVar.b(new URI(cVar.a(), str2, Operator.Operation.DIVISION + str, (String) null), aVar);
                if (b11 != null) {
                    return b11;
                }
            } catch (URISyntaxException e11) {
                throw new IllegalArgumentException(e11);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (sb.length() > 0) {
            str2 = " (" + sb + ")";
        }
        objArr[1] = str2;
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", objArr));
    }

    public void A0(Throwable th) {
        if (!this.G) {
            this.G = true;
            r0(true);
            E0(false);
            F0(new c(th));
            this.X.n((e0) null);
            this.V.a(f.a.f20008d, "PANIC! Entering TRANSIENT_FAILURE");
            this.f20546y.a(y8.p.TRANSIENT_FAILURE);
        }
    }

    public final void B0() {
        this.f20540s.e();
        s0();
        C0();
    }

    public final void C0() {
        this.f20540s.e();
        if (this.D) {
            this.C.b();
        }
    }

    public final void D0() {
        long j10 = this.f20545x;
        if (j10 != -1) {
            this.f20534m0.k(j10, TimeUnit.MILLISECONDS);
        }
    }

    public final void E0(boolean z10) {
        boolean z11;
        this.f20540s.e();
        if (z10) {
            Preconditions.checkState(this.D, "nameResolver is not started");
            if (this.E != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "lbHelper is null");
        }
        if (this.C != null) {
            s0();
            this.C.c();
            this.D = false;
            if (z10) {
                this.C = w0(this.f20511b, this.f20513c, this.f20517e, this.f20519f);
            } else {
                this.C = null;
            }
        }
        n nVar = this.E;
        if (nVar != null) {
            nVar.f20573a.c();
            this.E = null;
        }
        this.F = null;
    }

    public final void F0(o0.i iVar) {
        this.F = iVar;
        this.L.r(iVar);
    }

    public String a() {
        return this.A.a();
    }

    public i0 d() {
        return this.f20509a;
    }

    public y8.g h(w0 w0Var, y8.c cVar) {
        return this.A.h(w0Var, cVar);
    }

    public final void r0(boolean z10) {
        this.f20534m0.i(z10);
    }

    public final void s0() {
        this.f20540s.e();
        o1.d dVar = this.f20528j0;
        if (dVar != null) {
            dVar.a();
            this.f20528j0 = null;
            this.f20530k0 = null;
        }
    }

    public final void t0() {
        E0(true);
        this.L.r((o0.i) null);
        this.V.a(f.a.INFO, "Entering IDLE state");
        this.f20546y.a(y8.p.IDLE);
        if (this.f20526i0.a(this.J, this.L)) {
            u0();
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("logId", this.f20509a.d()).add("target", (Object) this.f20511b).toString();
    }

    public void u0() {
        this.f20540s.e();
        if (!this.N.get() && !this.G) {
            if (this.f20526i0.d()) {
                r0(false);
            } else {
                D0();
            }
            if (this.E == null) {
                this.V.a(f.a.INFO, "Exiting idle mode");
                n nVar = new n(this, (a) null);
                nVar.f20573a = this.f20521g.e(nVar);
                this.E = nVar;
                this.C.d(new o(nVar, this.C));
                this.D = true;
            }
        }
    }

    public final Executor v0(y8.c cVar) {
        Executor e10 = cVar.e();
        if (e10 == null) {
            return this.f20531l;
        }
        return e10;
    }

    public final void y0() {
        if (this.O) {
            for (x0 g10 : this.H) {
                g10.g(f20503p0);
            }
            Iterator it = this.K.iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
    }

    public final void z0() {
        if (!this.Q && this.N.get() && this.H.isEmpty() && this.K.isEmpty()) {
            this.V.a(f.a.INFO, "Terminated");
            this.W.j(this);
            this.f20533m.b(this.f20531l);
            this.f20536o.b();
            this.f20537p.b();
            this.f20525i.close();
            this.Q = true;
            this.R.countDown();
        }
    }

    public final class t {

        /* renamed from: a  reason: collision with root package name */
        public final Object f20621a;

        /* renamed from: b  reason: collision with root package name */
        public Collection f20622b;

        /* renamed from: c  reason: collision with root package name */
        public k1 f20623c;

        public t() {
            this.f20621a = new Object();
            this.f20622b = new HashSet();
        }

        public k1 a(x1 x1Var) {
            synchronized (this.f20621a) {
                k1 k1Var = this.f20623c;
                if (k1Var != null) {
                    return k1Var;
                }
                this.f20622b.add(x1Var);
                return null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
            z8.f1.o(r2.f20624d).c(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            if (r1 == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(y8.k1 r3) {
            /*
                r2 = this;
                java.lang.Object r0 = r2.f20621a
                monitor-enter(r0)
                y8.k1 r1 = r2.f20623c     // Catch:{ all -> 0x001e }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x001e }
                return
            L_0x0009:
                r2.f20623c = r3     // Catch:{ all -> 0x001e }
                java.util.Collection r1 = r2.f20622b     // Catch:{ all -> 0x001e }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x001e }
                monitor-exit(r0)     // Catch:{ all -> 0x001e }
                if (r1 == 0) goto L_0x001d
                z8.f1 r0 = z8.f1.this
                z8.a0 r0 = r0.L
                r0.c(r3)
            L_0x001d:
                return
            L_0x001e:
                r3 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x001e }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.f1.t.b(y8.k1):void");
        }

        public void c(x1 x1Var) {
            k1 k1Var;
            synchronized (this.f20621a) {
                this.f20622b.remove(x1Var);
                if (this.f20622b.isEmpty()) {
                    k1Var = this.f20623c;
                    this.f20622b = new HashSet();
                } else {
                    k1Var = null;
                }
            }
            if (k1Var != null) {
                f1.this.L.c(k1Var);
            }
        }

        public /* synthetic */ t(f1 f1Var, a aVar) {
            this();
        }
    }
}
