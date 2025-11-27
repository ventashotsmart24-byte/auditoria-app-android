package z8;

import anet.channel.entity.ConnType;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.taobao.accs.flowcontrol.FlowControl;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import y8.k;
import y8.k1;
import y8.o1;
import y8.v0;
import y8.w0;
import z8.i2;
import z8.r;

public abstract class x1 implements q {
    public static final v0.g A;
    public static final v0.g B;
    public static final k1 C = k1.f20042g.r("Stream thrown away because RetriableStream committed");
    public static Random D = new Random();

    /* renamed from: a  reason: collision with root package name */
    public final w0 f21075a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f21076b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f21077c = new o1(new a());

    /* renamed from: d  reason: collision with root package name */
    public final ScheduledExecutorService f21078d;

    /* renamed from: e  reason: collision with root package name */
    public final v0 f21079e;

    /* renamed from: f  reason: collision with root package name */
    public final y1 f21080f;

    /* renamed from: g  reason: collision with root package name */
    public final s0 f21081g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f21082h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f21083i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public final t f21084j;

    /* renamed from: k  reason: collision with root package name */
    public final long f21085k;

    /* renamed from: l  reason: collision with root package name */
    public final long f21086l;

    /* renamed from: m  reason: collision with root package name */
    public final c0 f21087m;

    /* renamed from: n  reason: collision with root package name */
    public final w0 f21088n = new w0();

    /* renamed from: o  reason: collision with root package name */
    public volatile z f21089o = new z(new ArrayList(8), Collections.emptyList(), (Collection) null, (b0) null, false, false, false, 0);

    /* renamed from: p  reason: collision with root package name */
    public final AtomicBoolean f21090p = new AtomicBoolean();

    /* renamed from: q  reason: collision with root package name */
    public final AtomicInteger f21091q = new AtomicInteger();

    /* renamed from: r  reason: collision with root package name */
    public final AtomicInteger f21092r = new AtomicInteger();

    /* renamed from: s  reason: collision with root package name */
    public k1 f21093s;

    /* renamed from: t  reason: collision with root package name */
    public long f21094t;

    /* renamed from: u  reason: collision with root package name */
    public r f21095u;

    /* renamed from: v  reason: collision with root package name */
    public u f21096v;

    /* renamed from: w  reason: collision with root package name */
    public u f21097w;

    /* renamed from: x  reason: collision with root package name */
    public long f21098x;

    /* renamed from: y  reason: collision with root package name */
    public k1 f21099y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f21100z;

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        public void uncaughtException(Thread thread, Throwable th) {
            throw k1.l(th).r("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    public final class a0 implements r {

        /* renamed from: a  reason: collision with root package name */
        public final b0 f21102a;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ v0 f21104a;

            public a(v0 v0Var) {
                this.f21104a = v0Var;
            }

            public void run() {
                x1.this.f21095u.b(this.f21104a);
            }
        }

        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b0 f21106a;

            public class a implements Runnable {
                public a() {
                }

                public void run() {
                    b bVar = b.this;
                    x1.this.f0(bVar.f21106a);
                }
            }

            public b(b0 b0Var) {
                this.f21106a = b0Var;
            }

            public void run() {
                x1.this.f21076b.execute(new a());
            }
        }

        public class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b0 f21109a;

            public c(b0 b0Var) {
                this.f21109a = b0Var;
            }

            public void run() {
                x1.this.f0(this.f21109a);
            }
        }

        public class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ i2.a f21111a;

            public d(i2.a aVar) {
                this.f21111a = aVar;
            }

            public void run() {
                x1.this.f21095u.a(this.f21111a);
            }
        }

        public class e implements Runnable {
            public e() {
            }

            public void run() {
                if (!x1.this.f21100z) {
                    x1.this.f21095u.d();
                }
            }
        }

        public a0(b0 b0Var) {
            this.f21102a = b0Var;
        }

        public void a(i2.a aVar) {
            boolean z10;
            z P = x1.this.f21089o;
            if (P.f21176f != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Headers should be received prior to messages.");
            if (P.f21176f == this.f21102a) {
                x1.this.f21077c.execute(new d(aVar));
            }
        }

        public void b(v0 v0Var) {
            x1.this.c0(this.f21102a);
            if (x1.this.f21089o.f21176f == this.f21102a) {
                if (x1.this.f21087m != null) {
                    x1.this.f21087m.c();
                }
                x1.this.f21077c.execute(new a(v0Var));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0123, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(y8.k1 r6, z8.r.a r7, y8.v0 r8) {
            /*
                r5 = this;
                z8.x1 r0 = z8.x1.this
                java.lang.Object r0 = r0.f21083i
                monitor-enter(r0)
                z8.x1 r1 = z8.x1.this     // Catch:{ all -> 0x0201 }
                z8.x1$z r2 = r1.f21089o     // Catch:{ all -> 0x0201 }
                z8.x1$b0 r3 = r5.f21102a     // Catch:{ all -> 0x0201 }
                z8.x1$z r2 = r2.g(r3)     // Catch:{ all -> 0x0201 }
                z8.x1.z unused = r1.f21089o = r2     // Catch:{ all -> 0x0201 }
                z8.x1 r1 = z8.x1.this     // Catch:{ all -> 0x0201 }
                z8.w0 r1 = r1.f21088n     // Catch:{ all -> 0x0201 }
                y8.k1$b r2 = r6.n()     // Catch:{ all -> 0x0201 }
                r1.a(r2)     // Catch:{ all -> 0x0201 }
                monitor-exit(r0)     // Catch:{ all -> 0x0201 }
                z8.x1 r0 = z8.x1.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.f21092r
                int r0 = r0.decrementAndGet()
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r0 != r1) goto L_0x0043
                z8.x1 r6 = z8.x1.this
                y8.k1 r7 = r6.f21093s
                z8.r$a r8 = z8.r.a.PROCESSED
                y8.v0 r0 = new y8.v0
                r0.<init>()
                r6.m0(r7, r8, r0)
                return
            L_0x0043:
                z8.x1$b0 r0 = r5.f21102a
                boolean r1 = r0.f21118c
                if (r1 == 0) goto L_0x0060
                z8.x1 r1 = z8.x1.this
                r1.c0(r0)
                z8.x1 r0 = z8.x1.this
                z8.x1$z r0 = r0.f21089o
                z8.x1$b0 r0 = r0.f21176f
                z8.x1$b0 r1 = r5.f21102a
                if (r0 != r1) goto L_0x005f
                z8.x1 r0 = z8.x1.this
                r0.m0(r6, r7, r8)
            L_0x005f:
                return
            L_0x0060:
                z8.r$a r0 = z8.r.a.MISCARRIED
                if (r7 != r0) goto L_0x009b
                z8.x1 r1 = z8.x1.this
                java.util.concurrent.atomic.AtomicInteger r1 = r1.f21091q
                int r1 = r1.incrementAndGet()
                r2 = 1000(0x3e8, float:1.401E-42)
                if (r1 <= r2) goto L_0x009b
                z8.x1 r0 = z8.x1.this
                z8.x1$b0 r1 = r5.f21102a
                r0.c0(r1)
                z8.x1 r0 = z8.x1.this
                z8.x1$z r0 = r0.f21089o
                z8.x1$b0 r0 = r0.f21176f
                z8.x1$b0 r1 = r5.f21102a
                if (r0 != r1) goto L_0x009a
                y8.k1 r0 = y8.k1.f20055t
                java.lang.String r1 = "Too many transparent retries. Might be a bug in gRPC"
                y8.k1 r0 = r0.r(r1)
                y8.m1 r6 = r6.d()
                y8.k1 r6 = r0.q(r6)
                z8.x1 r0 = z8.x1.this
                r0.m0(r6, r7, r8)
            L_0x009a:
                return
            L_0x009b:
                z8.x1 r1 = z8.x1.this
                z8.x1$z r1 = r1.f21089o
                z8.x1$b0 r1 = r1.f21176f
                if (r1 != 0) goto L_0x01e8
                r1 = 0
                r2 = 1
                if (r7 == r0) goto L_0x0170
                z8.r$a r0 = z8.r.a.REFUSED
                if (r7 != r0) goto L_0x00bb
                z8.x1 r0 = z8.x1.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f21090p
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L_0x00bb
                goto L_0x0170
            L_0x00bb:
                z8.r$a r0 = z8.r.a.DROPPED
                if (r7 != r0) goto L_0x00ce
                z8.x1 r0 = z8.x1.this
                boolean r0 = r0.f21082h
                if (r0 == 0) goto L_0x01e8
                z8.x1 r0 = z8.x1.this
                r0.g0()
                goto L_0x01e8
            L_0x00ce:
                z8.x1 r0 = z8.x1.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f21090p
                r0.set(r2)
                z8.x1 r0 = z8.x1.this
                boolean r0 = r0.f21082h
                if (r0 == 0) goto L_0x012a
                z8.x1$v r0 = r5.f(r6, r8)
                boolean r1 = r0.f21162a
                if (r1 == 0) goto L_0x00ee
                z8.x1 r1 = z8.x1.this
                java.lang.Integer r2 = r0.f21163b
                r1.l0(r2)
            L_0x00ee:
                z8.x1 r1 = z8.x1.this
                java.lang.Object r3 = r1.f21083i
                monitor-enter(r3)
                z8.x1 r1 = z8.x1.this     // Catch:{ all -> 0x0127 }
                z8.x1$z r2 = r1.f21089o     // Catch:{ all -> 0x0127 }
                z8.x1$b0 r4 = r5.f21102a     // Catch:{ all -> 0x0127 }
                z8.x1$z r2 = r2.e(r4)     // Catch:{ all -> 0x0127 }
                z8.x1.z unused = r1.f21089o = r2     // Catch:{ all -> 0x0127 }
                boolean r0 = r0.f21162a     // Catch:{ all -> 0x0127 }
                if (r0 == 0) goto L_0x0124
                z8.x1 r0 = z8.x1.this     // Catch:{ all -> 0x0127 }
                z8.x1$z r1 = r0.f21089o     // Catch:{ all -> 0x0127 }
                boolean r0 = r0.h0(r1)     // Catch:{ all -> 0x0127 }
                if (r0 != 0) goto L_0x0122
                z8.x1 r0 = z8.x1.this     // Catch:{ all -> 0x0127 }
                z8.x1$z r0 = r0.f21089o     // Catch:{ all -> 0x0127 }
                java.util.Collection r0 = r0.f21174d     // Catch:{ all -> 0x0127 }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0127 }
                if (r0 != 0) goto L_0x0124
            L_0x0122:
                monitor-exit(r3)     // Catch:{ all -> 0x0127 }
                return
            L_0x0124:
                monitor-exit(r3)     // Catch:{ all -> 0x0127 }
                goto L_0x01e8
            L_0x0127:
                r6 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0127 }
                throw r6
            L_0x012a:
                z8.x1$x r0 = r5.g(r6, r8)
                boolean r3 = r0.f21168a
                if (r3 == 0) goto L_0x01e8
                z8.x1 r6 = z8.x1.this
                z8.x1$b0 r7 = r5.f21102a
                int r7 = r7.f21119d
                int r7 = r7 + r2
                z8.x1$b0 r6 = r6.d0(r7, r1)
                if (r6 != 0) goto L_0x0140
                return
            L_0x0140:
                z8.x1 r7 = z8.x1.this
                java.lang.Object r1 = r7.f21083i
                monitor-enter(r1)
                z8.x1 r7 = z8.x1.this     // Catch:{ all -> 0x016d }
                z8.x1$u r8 = new z8.x1$u     // Catch:{ all -> 0x016d }
                java.lang.Object r2 = r7.f21083i     // Catch:{ all -> 0x016d }
                r8.<init>(r2)     // Catch:{ all -> 0x016d }
                z8.x1.u unused = r7.f21096v = r8     // Catch:{ all -> 0x016d }
                monitor-exit(r1)     // Catch:{ all -> 0x016d }
                z8.x1 r7 = z8.x1.this
                java.util.concurrent.ScheduledExecutorService r7 = r7.f21078d
                z8.x1$a0$b r1 = new z8.x1$a0$b
                r1.<init>(r6)
                long r2 = r0.f21169b
                java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS
                java.util.concurrent.ScheduledFuture r6 = r7.schedule(r1, r2, r6)
                r8.c(r6)
                return
            L_0x016d:
                r6 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x016d }
                throw r6
            L_0x0170:
                z8.x1 r6 = z8.x1.this
                z8.x1$b0 r7 = r5.f21102a
                int r7 = r7.f21119d
                z8.x1$b0 r6 = r6.d0(r7, r2)
                if (r6 != 0) goto L_0x017d
                return
            L_0x017d:
                z8.x1 r7 = z8.x1.this
                boolean r7 = r7.f21082h
                if (r7 == 0) goto L_0x01c2
                z8.x1 r7 = z8.x1.this
                java.lang.Object r7 = r7.f21083i
                monitor-enter(r7)
                z8.x1 r8 = z8.x1.this     // Catch:{ all -> 0x01bf }
                z8.x1$z r0 = r8.f21089o     // Catch:{ all -> 0x01bf }
                z8.x1$b0 r3 = r5.f21102a     // Catch:{ all -> 0x01bf }
                z8.x1$z r0 = r0.f(r3, r6)     // Catch:{ all -> 0x01bf }
                z8.x1.z unused = r8.f21089o = r0     // Catch:{ all -> 0x01bf }
                z8.x1 r8 = z8.x1.this     // Catch:{ all -> 0x01bf }
                z8.x1$z r0 = r8.f21089o     // Catch:{ all -> 0x01bf }
                boolean r8 = r8.h0(r0)     // Catch:{ all -> 0x01bf }
                if (r8 != 0) goto L_0x01b6
                z8.x1 r8 = z8.x1.this     // Catch:{ all -> 0x01bf }
                z8.x1$z r8 = r8.f21089o     // Catch:{ all -> 0x01bf }
                java.util.Collection r8 = r8.f21174d     // Catch:{ all -> 0x01bf }
                int r8 = r8.size()     // Catch:{ all -> 0x01bf }
                if (r8 != r2) goto L_0x01b6
                r1 = 1
            L_0x01b6:
                monitor-exit(r7)     // Catch:{ all -> 0x01bf }
                if (r1 == 0) goto L_0x01d9
                z8.x1 r7 = z8.x1.this
                r7.c0(r6)
                goto L_0x01d9
            L_0x01bf:
                r6 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x01bf }
                throw r6
            L_0x01c2:
                z8.x1 r7 = z8.x1.this
                z8.y1 r7 = r7.f21080f
                if (r7 == 0) goto L_0x01d4
                z8.x1 r7 = z8.x1.this
                z8.y1 r7 = r7.f21080f
                int r7 = r7.f21180a
                if (r7 != r2) goto L_0x01d9
            L_0x01d4:
                z8.x1 r7 = z8.x1.this
                r7.c0(r6)
            L_0x01d9:
                z8.x1 r7 = z8.x1.this
                java.util.concurrent.Executor r7 = r7.f21076b
                z8.x1$a0$c r8 = new z8.x1$a0$c
                r8.<init>(r6)
                r7.execute(r8)
                return
            L_0x01e8:
                z8.x1 r0 = z8.x1.this
                z8.x1$b0 r1 = r5.f21102a
                r0.c0(r1)
                z8.x1 r0 = z8.x1.this
                z8.x1$z r0 = r0.f21089o
                z8.x1$b0 r0 = r0.f21176f
                z8.x1$b0 r1 = r5.f21102a
                if (r0 != r1) goto L_0x0200
                z8.x1 r0 = z8.x1.this
                r0.m0(r6, r7, r8)
            L_0x0200:
                return
            L_0x0201:
                r6 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0201 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.x1.a0.c(y8.k1, z8.r$a, y8.v0):void");
        }

        public void d() {
            if (x1.this.m()) {
                x1.this.f21077c.execute(new e());
            }
        }

        public final Integer e(v0 v0Var) {
            String str = (String) v0Var.g(x1.B);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public final v f(k1 k1Var, v0 v0Var) {
            boolean z10;
            Integer e10 = e(v0Var);
            boolean z11 = true;
            boolean z12 = !x1.this.f21081g.f20954c.contains(k1Var.n());
            if (x1.this.f21087m == null || (z12 && (e10 == null || e10.intValue() >= 0))) {
                z10 = false;
            } else {
                z10 = !x1.this.f21087m.b();
            }
            if (z12 || z10) {
                z11 = false;
            }
            return new v(z11, e10);
        }

        public final x g(k1 k1Var, v0 v0Var) {
            boolean z10;
            long j10 = 0;
            boolean z11 = false;
            if (x1.this.f21080f == null) {
                return new x(false, 0);
            }
            boolean contains = x1.this.f21080f.f21185f.contains(k1Var.n());
            Integer e10 = e(v0Var);
            if (x1.this.f21087m == null || (!contains && (e10 == null || e10.intValue() >= 0))) {
                z10 = false;
            } else {
                z10 = !x1.this.f21087m.b();
            }
            if (x1.this.f21080f.f21180a > this.f21102a.f21119d + 1 && !z10) {
                if (e10 == null) {
                    if (contains) {
                        double K = (double) x1.this.f21098x;
                        double nextDouble = x1.D.nextDouble();
                        Double.isNaN(K);
                        j10 = (long) (K * nextDouble);
                        x1 x1Var = x1.this;
                        double K2 = (double) x1Var.f21098x;
                        double d10 = x1.this.f21080f.f21183d;
                        Double.isNaN(K2);
                        long unused = x1Var.f21098x = Math.min((long) (K2 * d10), x1.this.f21080f.f21182c);
                    }
                } else if (e10.intValue() >= 0) {
                    j10 = TimeUnit.MILLISECONDS.toNanos((long) e10.intValue());
                    x1 x1Var2 = x1.this;
                    long unused2 = x1Var2.f21098x = x1Var2.f21080f.f21181b;
                }
                z11 = true;
            }
            return new x(z11, j10);
        }
    }

    public class b implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21114a;

        public b(String str) {
            this.f21114a = str;
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.n(this.f21114a);
        }
    }

    public static final class b0 {

        /* renamed from: a  reason: collision with root package name */
        public q f21116a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f21117b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f21118c;

        /* renamed from: d  reason: collision with root package name */
        public final int f21119d;

        public b0(int i10) {
            this.f21119d = i10;
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Collection f21120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b0 f21121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Future f21122c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Future f21123d;

        public c(Collection collection, b0 b0Var, Future future, Future future2) {
            this.f21120a = collection;
            this.f21121b = b0Var;
            this.f21122c = future;
            this.f21123d = future2;
        }

        public void run() {
            for (b0 b0Var : this.f21120a) {
                if (b0Var != this.f21121b) {
                    b0Var.f21116a.e(x1.C);
                }
            }
            Future future = this.f21122c;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f21123d;
            if (future2 != null) {
                future2.cancel(false);
            }
            x1.this.j0();
        }
    }

    public static final class c0 {

        /* renamed from: a  reason: collision with root package name */
        public final int f21125a;

        /* renamed from: b  reason: collision with root package name */
        public final int f21126b;

        /* renamed from: c  reason: collision with root package name */
        public final int f21127c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f21128d;

        public c0(float f10, float f11) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f21128d = atomicInteger;
            this.f21127c = (int) (f11 * 1000.0f);
            int i10 = (int) (f10 * 1000.0f);
            this.f21125a = i10;
            this.f21126b = i10 / 2;
            atomicInteger.set(i10);
        }

        public boolean a() {
            if (this.f21128d.get() > this.f21126b) {
                return true;
            }
            return false;
        }

        public boolean b() {
            int i10;
            int i11;
            do {
                i10 = this.f21128d.get();
                if (i10 == 0) {
                    return false;
                }
                i11 = i10 + FlowControl.DELAY_MAX_BRUSH;
            } while (!this.f21128d.compareAndSet(i10, Math.max(i11, 0)));
            if (i11 > this.f21126b) {
                return true;
            }
            return false;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void c() {
            /*
                r4 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicInteger r0 = r4.f21128d
                int r0 = r0.get()
                int r1 = r4.f21125a
                if (r0 != r1) goto L_0x000b
                goto L_0x001a
            L_0x000b:
                int r2 = r4.f21127c
                int r2 = r2 + r0
                java.util.concurrent.atomic.AtomicInteger r3 = r4.f21128d
                int r1 = java.lang.Math.min(r2, r1)
                boolean r0 = r3.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0000
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.x1.c0.c():void");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c0)) {
                return false;
            }
            c0 c0Var = (c0) obj;
            if (this.f21125a == c0Var.f21125a && this.f21127c == c0Var.f21127c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.f21125a), Integer.valueOf(this.f21127c));
        }
    }

    public class d implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y8.n f21129a;

        public d(y8.n nVar) {
            this.f21129a = nVar;
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.a(this.f21129a);
        }
    }

    public class e implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y8.t f21131a;

        public e(y8.t tVar) {
            this.f21131a = tVar;
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.k(this.f21131a);
        }
    }

    public class f implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y8.v f21133a;

        public f(y8.v vVar) {
            this.f21133a = vVar;
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.l(this.f21133a);
        }
    }

    public class g implements r {
        public g() {
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.flush();
        }
    }

    public class h implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f21136a;

        public h(boolean z10) {
            this.f21136a = z10;
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.j(this.f21136a);
        }
    }

    public class i implements r {
        public i() {
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.o();
        }
    }

    public class j implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f21139a;

        public j(int i10) {
            this.f21139a = i10;
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.c(this.f21139a);
        }
    }

    public class k implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f21141a;

        public k(int i10) {
            this.f21141a = i10;
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.d(this.f21141a);
        }
    }

    public class l implements r {
        public l() {
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.i();
        }
    }

    public class m implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f21144a;

        public m(int i10) {
            this.f21144a = i10;
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.b(this.f21144a);
        }
    }

    public class n implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f21146a;

        public n(Object obj) {
            this.f21146a = obj;
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.h(x1.this.f21075a.j(this.f21146a));
            b0Var.f21116a.flush();
        }
    }

    public class o extends k.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y8.k f21148a;

        public o(y8.k kVar) {
            this.f21148a = kVar;
        }

        public y8.k a(k.b bVar, v0 v0Var) {
            return this.f21148a;
        }
    }

    public class p implements Runnable {
        public p() {
        }

        public void run() {
            if (!x1.this.f21100z) {
                x1.this.f21095u.d();
            }
        }
    }

    public class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k1 f21151a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r.a f21152b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v0 f21153c;

        public q(k1 k1Var, r.a aVar, v0 v0Var) {
            this.f21151a = k1Var;
            this.f21152b = aVar;
            this.f21153c = v0Var;
        }

        public void run() {
            boolean unused = x1.this.f21100z = true;
            x1.this.f21095u.c(this.f21151a, this.f21152b, this.f21153c);
        }
    }

    public interface r {
        void a(b0 b0Var);
    }

    public class s extends y8.k {

        /* renamed from: a  reason: collision with root package name */
        public final b0 f21155a;

        /* renamed from: b  reason: collision with root package name */
        public long f21156b;

        public s(b0 b0Var) {
            this.f21155a = b0Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
            if (r7 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
            r7.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h(long r7) {
            /*
                r6 = this;
                z8.x1 r0 = z8.x1.this
                z8.x1$z r0 = r0.f21089o
                z8.x1$b0 r0 = r0.f21176f
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                z8.x1 r0 = z8.x1.this
                java.lang.Object r0 = r0.f21083i
                monitor-enter(r0)
                z8.x1 r1 = z8.x1.this     // Catch:{ all -> 0x0085 }
                z8.x1$z r1 = r1.f21089o     // Catch:{ all -> 0x0085 }
                z8.x1$b0 r1 = r1.f21176f     // Catch:{ all -> 0x0085 }
                if (r1 != 0) goto L_0x0083
                z8.x1$b0 r1 = r6.f21155a     // Catch:{ all -> 0x0085 }
                boolean r1 = r1.f21117b     // Catch:{ all -> 0x0085 }
                if (r1 == 0) goto L_0x0023
                goto L_0x0083
            L_0x0023:
                long r1 = r6.f21156b     // Catch:{ all -> 0x0085 }
                long r1 = r1 + r7
                r6.f21156b = r1     // Catch:{ all -> 0x0085 }
                z8.x1 r7 = z8.x1.this     // Catch:{ all -> 0x0085 }
                long r7 = r7.f21094t     // Catch:{ all -> 0x0085 }
                int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
                if (r3 > 0) goto L_0x0034
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                return
            L_0x0034:
                long r7 = r6.f21156b     // Catch:{ all -> 0x0085 }
                z8.x1 r1 = z8.x1.this     // Catch:{ all -> 0x0085 }
                long r1 = r1.f21085k     // Catch:{ all -> 0x0085 }
                r3 = 1
                int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r4 <= 0) goto L_0x0046
                z8.x1$b0 r7 = r6.f21155a     // Catch:{ all -> 0x0085 }
                r7.f21118c = r3     // Catch:{ all -> 0x0085 }
                goto L_0x006e
            L_0x0046:
                z8.x1 r7 = z8.x1.this     // Catch:{ all -> 0x0085 }
                z8.x1$t r7 = r7.f21084j     // Catch:{ all -> 0x0085 }
                long r1 = r6.f21156b     // Catch:{ all -> 0x0085 }
                z8.x1 r8 = z8.x1.this     // Catch:{ all -> 0x0085 }
                long r4 = r8.f21094t     // Catch:{ all -> 0x0085 }
                long r1 = r1 - r4
                long r7 = r7.a(r1)     // Catch:{ all -> 0x0085 }
                z8.x1 r1 = z8.x1.this     // Catch:{ all -> 0x0085 }
                long r4 = r6.f21156b     // Catch:{ all -> 0x0085 }
                long unused = r1.f21094t = r4     // Catch:{ all -> 0x0085 }
                z8.x1 r1 = z8.x1.this     // Catch:{ all -> 0x0085 }
                long r1 = r1.f21086l     // Catch:{ all -> 0x0085 }
                int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r4 <= 0) goto L_0x006e
                z8.x1$b0 r7 = r6.f21155a     // Catch:{ all -> 0x0085 }
                r7.f21118c = r3     // Catch:{ all -> 0x0085 }
            L_0x006e:
                z8.x1$b0 r7 = r6.f21155a     // Catch:{ all -> 0x0085 }
                boolean r8 = r7.f21118c     // Catch:{ all -> 0x0085 }
                if (r8 == 0) goto L_0x007b
                z8.x1 r8 = z8.x1.this     // Catch:{ all -> 0x0085 }
                java.lang.Runnable r7 = r8.b0(r7)     // Catch:{ all -> 0x0085 }
                goto L_0x007c
            L_0x007b:
                r7 = 0
            L_0x007c:
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                if (r7 == 0) goto L_0x0082
                r7.run()
            L_0x0082:
                return
            L_0x0083:
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                return
            L_0x0085:
                r7 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.x1.s.h(long):void");
        }
    }

    public static final class t {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicLong f21158a = new AtomicLong();

        public long a(long j10) {
            return this.f21158a.addAndGet(j10);
        }
    }

    public static final class u {

        /* renamed from: a  reason: collision with root package name */
        public final Object f21159a;

        /* renamed from: b  reason: collision with root package name */
        public Future f21160b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f21161c;

        public u(Object obj) {
            this.f21159a = obj;
        }

        public boolean a() {
            return this.f21161c;
        }

        public Future b() {
            this.f21161c = true;
            return this.f21160b;
        }

        public void c(Future future) {
            synchronized (this.f21159a) {
                if (!this.f21161c) {
                    this.f21160b = future;
                }
            }
        }
    }

    public static final class v {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f21162a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f21163b;

        public v(boolean z10, Integer num) {
            this.f21162a = z10;
            this.f21163b = num;
        }
    }

    public final class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final u f21164a;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b0 f21166a;

            public a(b0 b0Var) {
                this.f21166a = b0Var;
            }

            public void run() {
                u uVar;
                boolean z10;
                synchronized (x1.this.f21083i) {
                    uVar = null;
                    if (w.this.f21164a.a()) {
                        z10 = true;
                    } else {
                        x1 x1Var = x1.this;
                        z unused = x1Var.f21089o = x1Var.f21089o.a(this.f21166a);
                        x1 x1Var2 = x1.this;
                        if (!x1Var2.h0(x1Var2.f21089o) || (x1.this.f21087m != null && !x1.this.f21087m.a())) {
                            x1 x1Var3 = x1.this;
                            z unused2 = x1Var3.f21089o = x1Var3.f21089o.d();
                            u unused3 = x1.this.f21097w = null;
                        } else {
                            x1 x1Var4 = x1.this;
                            uVar = new u(x1Var4.f21083i);
                            u unused4 = x1Var4.f21097w = uVar;
                        }
                        z10 = false;
                    }
                }
                if (z10) {
                    this.f21166a.f21116a.e(k1.f20042g.r("Unneeded hedging"));
                    return;
                }
                if (uVar != null) {
                    uVar.c(x1.this.f21078d.schedule(new w(uVar), x1.this.f21081g.f20953b, TimeUnit.NANOSECONDS));
                }
                x1.this.f0(this.f21166a);
            }
        }

        public w(u uVar) {
            this.f21164a = uVar;
        }

        public void run() {
            x1 x1Var = x1.this;
            b0 V = x1Var.d0(x1Var.f21089o.f21175e, false);
            if (V != null) {
                x1.this.f21076b.execute(new a(V));
            }
        }
    }

    public static final class x {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f21168a;

        /* renamed from: b  reason: collision with root package name */
        public final long f21169b;

        public x(boolean z10, long j10) {
            this.f21168a = z10;
            this.f21169b = j10;
        }
    }

    public class y implements r {
        public y() {
        }

        public void a(b0 b0Var) {
            b0Var.f21116a.g(new a0(b0Var));
        }
    }

    public static final class z {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f21171a;

        /* renamed from: b  reason: collision with root package name */
        public final List f21172b;

        /* renamed from: c  reason: collision with root package name */
        public final Collection f21173c;

        /* renamed from: d  reason: collision with root package name */
        public final Collection f21174d;

        /* renamed from: e  reason: collision with root package name */
        public final int f21175e;

        /* renamed from: f  reason: collision with root package name */
        public final b0 f21176f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f21177g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f21178h;

        public z(List list, Collection collection, Collection collection2, b0 b0Var, boolean z10, boolean z11, boolean z12, int i10) {
            boolean z13;
            boolean z14;
            boolean z15;
            this.f21172b = list;
            this.f21173c = (Collection) Preconditions.checkNotNull(collection, "drainedSubstreams");
            this.f21176f = b0Var;
            this.f21174d = collection2;
            this.f21177g = z10;
            this.f21171a = z11;
            this.f21178h = z12;
            this.f21175e = i10;
            boolean z16 = false;
            if (!z11 || list == null) {
                z13 = true;
            } else {
                z13 = false;
            }
            Preconditions.checkState(z13, "passThrough should imply buffer is null");
            if (!z11 || b0Var != null) {
                z14 = true;
            } else {
                z14 = false;
            }
            Preconditions.checkState(z14, "passThrough should imply winningSubstream != null");
            if (!z11 || ((collection.size() == 1 && collection.contains(b0Var)) || (collection.size() == 0 && b0Var.f21117b))) {
                z15 = true;
            } else {
                z15 = false;
            }
            Preconditions.checkState(z15, "passThrough should imply winningSubstream is drained");
            Preconditions.checkState((!z10 || b0Var != null) ? true : z16, "cancelled should imply committed");
        }

        public z a(b0 b0Var) {
            boolean z10;
            Collection collection;
            Preconditions.checkState(!this.f21178h, "hedging frozen");
            if (this.f21176f == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "already committed");
            if (this.f21174d == null) {
                collection = Collections.singleton(b0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f21174d);
                arrayList.add(b0Var);
                collection = Collections.unmodifiableCollection(arrayList);
            }
            return new z(this.f21172b, this.f21173c, collection, this.f21176f, this.f21177g, this.f21171a, this.f21178h, this.f21175e + 1);
        }

        public z b() {
            return new z(this.f21172b, this.f21173c, this.f21174d, this.f21176f, true, this.f21171a, this.f21178h, this.f21175e);
        }

        public z c(b0 b0Var) {
            boolean z10;
            boolean z11;
            Set set;
            List list;
            if (this.f21176f == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Already committed");
            List list2 = this.f21172b;
            if (this.f21173c.contains(b0Var)) {
                set = Collections.singleton(b0Var);
                list = null;
                z11 = true;
            } else {
                list = list2;
                set = Collections.emptyList();
                z11 = false;
            }
            return new z(list, set, this.f21174d, b0Var, this.f21177g, z11, this.f21178h, this.f21175e);
        }

        public z d() {
            if (this.f21178h) {
                return this;
            }
            return new z(this.f21172b, this.f21173c, this.f21174d, this.f21176f, this.f21177g, this.f21171a, true, this.f21175e);
        }

        public z e(b0 b0Var) {
            ArrayList arrayList = new ArrayList(this.f21174d);
            arrayList.remove(b0Var);
            return new z(this.f21172b, this.f21173c, Collections.unmodifiableCollection(arrayList), this.f21176f, this.f21177g, this.f21171a, this.f21178h, this.f21175e);
        }

        public z f(b0 b0Var, b0 b0Var2) {
            ArrayList arrayList = new ArrayList(this.f21174d);
            arrayList.remove(b0Var);
            arrayList.add(b0Var2);
            return new z(this.f21172b, this.f21173c, Collections.unmodifiableCollection(arrayList), this.f21176f, this.f21177g, this.f21171a, this.f21178h, this.f21175e);
        }

        public z g(b0 b0Var) {
            b0Var.f21117b = true;
            if (!this.f21173c.contains(b0Var)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.f21173c);
            arrayList.remove(b0Var);
            return new z(this.f21172b, Collections.unmodifiableCollection(arrayList), this.f21174d, this.f21176f, this.f21177g, this.f21171a, this.f21178h, this.f21175e);
        }

        public z h(b0 b0Var) {
            Collection unmodifiableCollection;
            boolean z10;
            boolean z11 = true;
            Preconditions.checkState(!this.f21171a, "Already passThrough");
            if (b0Var.f21117b) {
                unmodifiableCollection = this.f21173c;
            } else if (this.f21173c.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(b0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f21173c);
                arrayList.add(b0Var);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = unmodifiableCollection;
            b0 b0Var2 = this.f21176f;
            if (b0Var2 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            List list = this.f21172b;
            if (z10) {
                if (b0Var2 != b0Var) {
                    z11 = false;
                }
                Preconditions.checkState(z11, "Another RPC attempt has already committed");
                list = null;
            }
            return new z(list, collection, this.f21174d, this.f21176f, this.f21177g, z10, this.f21178h, this.f21175e);
        }
    }

    static {
        v0.d dVar = v0.f20181e;
        A = v0.g.e("grpc-previous-rpc-attempts", dVar);
        B = v0.g.e("grpc-retry-pushback-ms", dVar);
    }

    public x1(w0 w0Var, v0 v0Var, t tVar, long j10, long j11, Executor executor, ScheduledExecutorService scheduledExecutorService, y1 y1Var, s0 s0Var, c0 c0Var) {
        boolean z10;
        y1 y1Var2 = y1Var;
        s0 s0Var2 = s0Var;
        this.f21075a = w0Var;
        this.f21084j = tVar;
        this.f21085k = j10;
        this.f21086l = j11;
        this.f21076b = executor;
        this.f21078d = scheduledExecutorService;
        this.f21079e = v0Var;
        this.f21080f = y1Var2;
        if (y1Var2 != null) {
            this.f21098x = y1Var2.f21181b;
        }
        this.f21081g = s0Var2;
        boolean z11 = false;
        if (y1Var2 == null || s0Var2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "Should not provide both retryPolicy and hedgingPolicy");
        this.f21082h = s0Var2 != null ? true : z11;
        this.f21087m = c0Var;
    }

    public final void a(y8.n nVar) {
        e0(new d(nVar));
    }

    public final void b(int i10) {
        z zVar = this.f21089o;
        if (zVar.f21171a) {
            zVar.f21176f.f21116a.b(i10);
        } else {
            e0(new m(i10));
        }
    }

    public final Runnable b0(b0 b0Var) {
        Future future;
        Future future2;
        synchronized (this.f21083i) {
            if (this.f21089o.f21176f != null) {
                return null;
            }
            Collection collection = this.f21089o.f21173c;
            this.f21089o = this.f21089o.c(b0Var);
            this.f21084j.a(-this.f21094t);
            u uVar = this.f21096v;
            if (uVar != null) {
                Future b10 = uVar.b();
                this.f21096v = null;
                future = b10;
            } else {
                future = null;
            }
            u uVar2 = this.f21097w;
            if (uVar2 != null) {
                Future b11 = uVar2.b();
                this.f21097w = null;
                future2 = b11;
            } else {
                future2 = null;
            }
            c cVar = new c(collection, b0Var, future, future2);
            return cVar;
        }
    }

    public final void c(int i10) {
        e0(new j(i10));
    }

    public final void c0(b0 b0Var) {
        Runnable b02 = b0(b0Var);
        if (b02 != null) {
            b02.run();
        }
    }

    public final void d(int i10) {
        e0(new k(i10));
    }

    public final b0 d0(int i10, boolean z10) {
        int i11;
        do {
            i11 = this.f21092r.get();
            if (i11 < 0) {
                return null;
            }
        } while (!this.f21092r.compareAndSet(i11, i11 + 1));
        b0 b0Var = new b0(i10);
        b0Var.f21116a = i0(o0(this.f21079e, i10), new o(new s(b0Var)), i10, z10);
        return b0Var;
    }

    public final void e(k1 k1Var) {
        b0 b0Var;
        b0 b0Var2 = new b0(0);
        b0Var2.f21116a = new n1();
        Runnable b02 = b0(b0Var2);
        if (b02 != null) {
            this.f21093s = k1Var;
            b02.run();
            if (this.f21092r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                m0(k1Var, r.a.PROCESSED, new v0());
                return;
            }
            return;
        }
        synchronized (this.f21083i) {
            if (this.f21089o.f21173c.contains(this.f21089o.f21176f)) {
                b0Var = this.f21089o.f21176f;
            } else {
                this.f21099y = k1Var;
                b0Var = null;
            }
            this.f21089o = this.f21089o.b();
        }
        if (b0Var != null) {
            b0Var.f21116a.e(k1Var);
        }
    }

    public final void e0(r rVar) {
        Collection<b0> collection;
        synchronized (this.f21083i) {
            if (!this.f21089o.f21171a) {
                this.f21089o.f21172b.add(rVar);
            }
            collection = this.f21089o.f21173c;
        }
        for (b0 a10 : collection) {
            rVar.a(a10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007b, code lost:
        r2 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0083, code lost:
        if (r2.hasNext() == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0085, code lost:
        r4 = (z8.x1.r) r2.next();
        r4.a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0090, code lost:
        if ((r4 instanceof z8.x1.y) == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0092, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0093, code lost:
        if (r0 == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0095, code lost:
        r4 = r8.f21089o;
        r5 = r4.f21176f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0099, code lost:
        if (r5 == null) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x009b, code lost:
        if (r5 == r9) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a0, code lost:
        if (r4.f21177g == false) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f0(z8.x1.b0 r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r3 = r1
            r2 = 0
        L_0x0004:
            java.lang.Object r4 = r8.f21083i
            monitor-enter(r4)
            z8.x1$z r5 = r8.f21089o     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0019
            z8.x1$b0 r6 = r5.f21176f     // Catch:{ all -> 0x00a5 }
            if (r6 == 0) goto L_0x0013
            if (r6 == r9) goto L_0x0013
            monitor-exit(r4)     // Catch:{ all -> 0x00a5 }
            goto L_0x0035
        L_0x0013:
            boolean r6 = r5.f21177g     // Catch:{ all -> 0x00a5 }
            if (r6 == 0) goto L_0x0019
            monitor-exit(r4)     // Catch:{ all -> 0x00a5 }
            goto L_0x0035
        L_0x0019:
            java.util.List r6 = r5.f21172b     // Catch:{ all -> 0x00a5 }
            int r6 = r6.size()     // Catch:{ all -> 0x00a5 }
            if (r2 != r6) goto L_0x004e
            z8.x1$z r0 = r5.h(r9)     // Catch:{ all -> 0x00a5 }
            r8.f21089o = r0     // Catch:{ all -> 0x00a5 }
            boolean r0 = r8.m()     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x002f
            monitor-exit(r4)     // Catch:{ all -> 0x00a5 }
            return
        L_0x002f:
            z8.x1$p r1 = new z8.x1$p     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            monitor-exit(r4)     // Catch:{ all -> 0x00a5 }
        L_0x0035:
            if (r1 == 0) goto L_0x003d
            java.util.concurrent.Executor r9 = r8.f21077c
            r9.execute(r1)
            return
        L_0x003d:
            z8.q r0 = r9.f21116a
            z8.x1$z r1 = r8.f21089o
            z8.x1$b0 r1 = r1.f21176f
            if (r1 != r9) goto L_0x0048
            y8.k1 r9 = r8.f21099y
            goto L_0x004a
        L_0x0048:
            y8.k1 r9 = C
        L_0x004a:
            r0.e(r9)
            return
        L_0x004e:
            boolean r6 = r9.f21117b     // Catch:{ all -> 0x00a5 }
            if (r6 == 0) goto L_0x0054
            monitor-exit(r4)     // Catch:{ all -> 0x00a5 }
            return
        L_0x0054:
            int r6 = r2 + 128
            java.util.List r7 = r5.f21172b     // Catch:{ all -> 0x00a5 }
            int r7 = r7.size()     // Catch:{ all -> 0x00a5 }
            int r6 = java.lang.Math.min(r6, r7)     // Catch:{ all -> 0x00a5 }
            if (r3 != 0) goto L_0x006e
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00a5 }
            java.util.List r5 = r5.f21172b     // Catch:{ all -> 0x00a5 }
            java.util.List r2 = r5.subList(r2, r6)     // Catch:{ all -> 0x00a5 }
            r3.<init>(r2)     // Catch:{ all -> 0x00a5 }
            goto L_0x007a
        L_0x006e:
            r3.clear()     // Catch:{ all -> 0x00a5 }
            java.util.List r5 = r5.f21172b     // Catch:{ all -> 0x00a5 }
            java.util.List r2 = r5.subList(r2, r6)     // Catch:{ all -> 0x00a5 }
            r3.addAll(r2)     // Catch:{ all -> 0x00a5 }
        L_0x007a:
            monitor-exit(r4)     // Catch:{ all -> 0x00a5 }
            java.util.Iterator r2 = r3.iterator()
        L_0x007f:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00a2
            java.lang.Object r4 = r2.next()
            z8.x1$r r4 = (z8.x1.r) r4
            r4.a(r9)
            boolean r4 = r4 instanceof z8.x1.y
            if (r4 == 0) goto L_0x0093
            r0 = 1
        L_0x0093:
            if (r0 == 0) goto L_0x007f
            z8.x1$z r4 = r8.f21089o
            z8.x1$b0 r5 = r4.f21176f
            if (r5 == 0) goto L_0x009e
            if (r5 == r9) goto L_0x009e
            goto L_0x00a2
        L_0x009e:
            boolean r4 = r4.f21177g
            if (r4 == 0) goto L_0x007f
        L_0x00a2:
            r2 = r6
            goto L_0x0004
        L_0x00a5:
            r9 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00a5 }
            goto L_0x00a9
        L_0x00a8:
            throw r9
        L_0x00a9:
            goto L_0x00a8
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.x1.f0(z8.x1$b0):void");
    }

    public final void flush() {
        z zVar = this.f21089o;
        if (zVar.f21171a) {
            zVar.f21176f.f21116a.flush();
        } else {
            e0(new g());
        }
    }

    public final void g(r rVar) {
        u uVar;
        c0 c0Var;
        this.f21095u = rVar;
        k1 k02 = k0();
        if (k02 != null) {
            e(k02);
            return;
        }
        synchronized (this.f21083i) {
            this.f21089o.f21172b.add(new y());
        }
        b0 d02 = d0(0, false);
        if (d02 != null) {
            if (this.f21082h) {
                synchronized (this.f21083i) {
                    this.f21089o = this.f21089o.a(d02);
                    if (!h0(this.f21089o) || ((c0Var = this.f21087m) != null && !c0Var.a())) {
                        uVar = null;
                    } else {
                        uVar = new u(this.f21083i);
                        this.f21097w = uVar;
                    }
                }
                if (uVar != null) {
                    uVar.c(this.f21078d.schedule(new w(uVar), this.f21081g.f20953b, TimeUnit.NANOSECONDS));
                }
            }
            f0(d02);
        }
    }

    public final void g0() {
        Future future;
        synchronized (this.f21083i) {
            u uVar = this.f21097w;
            future = null;
            if (uVar != null) {
                Future b10 = uVar.b();
                this.f21097w = null;
                future = b10;
            }
            this.f21089o = this.f21089o.d();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    public final void h(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    public final boolean h0(z zVar) {
        if (zVar.f21176f != null || zVar.f21175e >= this.f21081g.f20952a || zVar.f21178h) {
            return false;
        }
        return true;
    }

    public void i() {
        e0(new l());
    }

    public abstract q i0(v0 v0Var, k.a aVar, int i10, boolean z10);

    public final void j(boolean z10) {
        e0(new h(z10));
    }

    public abstract void j0();

    public final void k(y8.t tVar) {
        e0(new e(tVar));
    }

    public abstract k1 k0();

    public final void l(y8.v vVar) {
        e0(new f(vVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r1 == null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r1.cancel(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        r2.c(r5.f21078d.schedule(new z8.x1.w(r5, r2), (long) r6.intValue(), java.util.concurrent.TimeUnit.MILLISECONDS));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l0(java.lang.Integer r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r6.intValue()
            if (r0 >= 0) goto L_0x000d
            r5.g0()
            return
        L_0x000d:
            java.lang.Object r0 = r5.f21083i
            monitor-enter(r0)
            z8.x1$u r1 = r5.f21097w     // Catch:{ all -> 0x0040 }
            if (r1 != 0) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            return
        L_0x0016:
            java.util.concurrent.Future r1 = r1.b()     // Catch:{ all -> 0x0040 }
            z8.x1$u r2 = new z8.x1$u     // Catch:{ all -> 0x0040 }
            java.lang.Object r3 = r5.f21083i     // Catch:{ all -> 0x0040 }
            r2.<init>(r3)     // Catch:{ all -> 0x0040 }
            r5.f21097w = r2     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x002a
            r0 = 0
            r1.cancel(r0)
        L_0x002a:
            java.util.concurrent.ScheduledExecutorService r0 = r5.f21078d
            z8.x1$w r1 = new z8.x1$w
            r1.<init>(r2)
            int r6 = r6.intValue()
            long r3 = (long) r6
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r6 = r0.schedule(r1, r3, r6)
            r2.c(r6)
            return
        L_0x0040:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.x1.l0(java.lang.Integer):void");
    }

    public final boolean m() {
        for (b0 b0Var : this.f21089o.f21173c) {
            if (b0Var.f21116a.m()) {
                return true;
            }
        }
        return false;
    }

    public final void m0(k1 k1Var, r.a aVar, v0 v0Var) {
        this.f21077c.execute(new q(k1Var, aVar, v0Var));
    }

    public final void n(String str) {
        e0(new b(str));
    }

    public final void n0(Object obj) {
        z zVar = this.f21089o;
        if (zVar.f21171a) {
            zVar.f21176f.f21116a.h(this.f21075a.j(obj));
        } else {
            e0(new n(obj));
        }
    }

    public final void o() {
        e0(new i());
    }

    public final v0 o0(v0 v0Var, int i10) {
        v0 v0Var2 = new v0();
        v0Var2.l(v0Var);
        if (i10 > 0) {
            v0Var2.o(A, String.valueOf(i10));
        }
        return v0Var2;
    }

    public void p(w0 w0Var) {
        z zVar;
        synchronized (this.f21083i) {
            w0Var.b("closed", this.f21088n);
            zVar = this.f21089o;
        }
        if (zVar.f21176f != null) {
            w0 w0Var2 = new w0();
            zVar.f21176f.f21116a.p(w0Var2);
            w0Var.b("committed", w0Var2);
            return;
        }
        w0 w0Var3 = new w0();
        for (b0 b0Var : zVar.f21173c) {
            w0 w0Var4 = new w0();
            b0Var.f21116a.p(w0Var4);
            w0Var3.a(w0Var4);
        }
        w0Var.b(ConnType.PK_OPEN, w0Var3);
    }
}
