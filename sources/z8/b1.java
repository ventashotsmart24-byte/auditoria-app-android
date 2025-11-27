package z8;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import y8.k1;
import z8.s;

public class b1 {

    /* renamed from: l  reason: collision with root package name */
    public static final long f20380l = TimeUnit.SECONDS.toNanos(10);

    /* renamed from: m  reason: collision with root package name */
    public static final long f20381m = TimeUnit.MILLISECONDS.toNanos(10);

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f20382a;

    /* renamed from: b  reason: collision with root package name */
    public final Stopwatch f20383b;

    /* renamed from: c  reason: collision with root package name */
    public final d f20384c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f20385d;

    /* renamed from: e  reason: collision with root package name */
    public e f20386e;

    /* renamed from: f  reason: collision with root package name */
    public ScheduledFuture f20387f;

    /* renamed from: g  reason: collision with root package name */
    public ScheduledFuture f20388g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f20389h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f20390i;

    /* renamed from: j  reason: collision with root package name */
    public final long f20391j;

    /* renamed from: k  reason: collision with root package name */
    public final long f20392k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            boolean z10;
            synchronized (b1.this) {
                e a10 = b1.this.f20386e;
                e eVar = e.DISCONNECTED;
                if (a10 != eVar) {
                    e unused = b1.this.f20386e = eVar;
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                b1.this.f20384c.a();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            boolean z10;
            synchronized (b1.this) {
                ScheduledFuture unused = b1.this.f20388g = null;
                e a10 = b1.this.f20386e;
                e eVar = e.PING_SCHEDULED;
                if (a10 == eVar) {
                    e unused2 = b1.this.f20386e = e.PING_SENT;
                    b1 b1Var = b1.this;
                    ScheduledFuture unused3 = b1Var.f20387f = b1Var.f20382a.schedule(b1.this.f20389h, b1.this.f20392k, TimeUnit.NANOSECONDS);
                    z10 = true;
                } else {
                    if (b1.this.f20386e == e.PING_DELAYED) {
                        b1 b1Var2 = b1.this;
                        ScheduledExecutorService h10 = b1Var2.f20382a;
                        Runnable i10 = b1.this.f20390i;
                        long j10 = b1.this.f20391j;
                        Stopwatch k10 = b1.this.f20383b;
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        ScheduledFuture unused4 = b1Var2.f20388g = h10.schedule(i10, j10 - k10.elapsed(timeUnit), timeUnit);
                        e unused5 = b1.this.f20386e = eVar;
                    }
                    z10 = false;
                }
            }
            if (z10) {
                b1.this.f20384c.ping();
            }
        }
    }

    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final v f20395a;

        public class a implements s.a {
            public a() {
            }

            public void a(long j10) {
            }

            public void onFailure(Throwable th) {
                c.this.f20395a.g(k1.f20056u.r("Keepalive failed. The connection is likely gone"));
            }
        }

        public c(v vVar) {
            this.f20395a = vVar;
        }

        public void a() {
            this.f20395a.g(k1.f20056u.r("Keepalive failed. The connection is likely gone"));
        }

        public void ping() {
            this.f20395a.f(new a(), MoreExecutors.directExecutor());
        }
    }

    public interface d {
        void a();

        void ping();
    }

    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public b1(d dVar, ScheduledExecutorService scheduledExecutorService, long j10, long j11, boolean z10) {
        this(dVar, scheduledExecutorService, Stopwatch.createUnstarted(), j10, j11, z10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void l() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.common.base.Stopwatch r0 = r5.f20383b     // Catch:{ all -> 0x004d }
            com.google.common.base.Stopwatch r0 = r0.reset()     // Catch:{ all -> 0x004d }
            r0.start()     // Catch:{ all -> 0x004d }
            z8.b1$e r0 = r5.f20386e     // Catch:{ all -> 0x004d }
            z8.b1$e r1 = z8.b1.e.PING_SCHEDULED     // Catch:{ all -> 0x004d }
            if (r0 != r1) goto L_0x0015
            z8.b1$e r0 = z8.b1.e.PING_DELAYED     // Catch:{ all -> 0x004d }
            r5.f20386e = r0     // Catch:{ all -> 0x004d }
            goto L_0x004b
        L_0x0015:
            z8.b1$e r2 = z8.b1.e.PING_SENT     // Catch:{ all -> 0x004d }
            if (r0 == r2) goto L_0x001d
            z8.b1$e r2 = z8.b1.e.IDLE_AND_PING_SENT     // Catch:{ all -> 0x004d }
            if (r0 != r2) goto L_0x004b
        L_0x001d:
            java.util.concurrent.ScheduledFuture r0 = r5.f20387f     // Catch:{ all -> 0x004d }
            r2 = 0
            if (r0 == 0) goto L_0x0025
            r0.cancel(r2)     // Catch:{ all -> 0x004d }
        L_0x0025:
            z8.b1$e r0 = r5.f20386e     // Catch:{ all -> 0x004d }
            z8.b1$e r3 = z8.b1.e.IDLE_AND_PING_SENT     // Catch:{ all -> 0x004d }
            if (r0 != r3) goto L_0x0031
            z8.b1$e r0 = z8.b1.e.IDLE     // Catch:{ all -> 0x004d }
            r5.f20386e = r0     // Catch:{ all -> 0x004d }
            monitor-exit(r5)
            return
        L_0x0031:
            r5.f20386e = r1     // Catch:{ all -> 0x004d }
            java.util.concurrent.ScheduledFuture r0 = r5.f20388g     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0038
            r2 = 1
        L_0x0038:
            java.lang.String r0 = "There should be no outstanding pingFuture"
            com.google.common.base.Preconditions.checkState(r2, r0)     // Catch:{ all -> 0x004d }
            java.util.concurrent.ScheduledExecutorService r0 = r5.f20382a     // Catch:{ all -> 0x004d }
            java.lang.Runnable r1 = r5.f20390i     // Catch:{ all -> 0x004d }
            long r2 = r5.f20391j     // Catch:{ all -> 0x004d }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x004d }
            java.util.concurrent.ScheduledFuture r0 = r0.schedule(r1, r2, r4)     // Catch:{ all -> 0x004d }
            r5.f20388g = r0     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r5)
            return
        L_0x004d:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.b1.l():void");
    }

    public synchronized void m() {
        e eVar = this.f20386e;
        if (eVar == e.IDLE) {
            this.f20386e = e.PING_SCHEDULED;
            if (this.f20388g == null) {
                ScheduledExecutorService scheduledExecutorService = this.f20382a;
                Runnable runnable = this.f20390i;
                long j10 = this.f20391j;
                Stopwatch stopwatch = this.f20383b;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                this.f20388g = scheduledExecutorService.schedule(runnable, j10 - stopwatch.elapsed(timeUnit), timeUnit);
            }
        } else if (eVar == e.IDLE_AND_PING_SENT) {
            this.f20386e = e.PING_SENT;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void n() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f20385d     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            z8.b1$e r0 = r2.f20386e     // Catch:{ all -> 0x0021 }
            z8.b1$e r1 = z8.b1.e.PING_SCHEDULED     // Catch:{ all -> 0x0021 }
            if (r0 == r1) goto L_0x0011
            z8.b1$e r1 = z8.b1.e.PING_DELAYED     // Catch:{ all -> 0x0021 }
            if (r0 != r1) goto L_0x0015
        L_0x0011:
            z8.b1$e r0 = z8.b1.e.IDLE     // Catch:{ all -> 0x0021 }
            r2.f20386e = r0     // Catch:{ all -> 0x0021 }
        L_0x0015:
            z8.b1$e r0 = r2.f20386e     // Catch:{ all -> 0x0021 }
            z8.b1$e r1 = z8.b1.e.PING_SENT     // Catch:{ all -> 0x0021 }
            if (r0 != r1) goto L_0x001f
            z8.b1$e r0 = z8.b1.e.IDLE_AND_PING_SENT     // Catch:{ all -> 0x0021 }
            r2.f20386e = r0     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r2)
            return
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.b1.n():void");
    }

    public synchronized void o() {
        if (this.f20385d) {
            m();
        }
    }

    public synchronized void p() {
        e eVar = this.f20386e;
        e eVar2 = e.DISCONNECTED;
        if (eVar != eVar2) {
            this.f20386e = eVar2;
            ScheduledFuture scheduledFuture = this.f20387f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledFuture scheduledFuture2 = this.f20388g;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(false);
                this.f20388g = null;
            }
        }
    }

    public b1(d dVar, ScheduledExecutorService scheduledExecutorService, Stopwatch stopwatch, long j10, long j11, boolean z10) {
        this.f20386e = e.IDLE;
        this.f20389h = new c1(new a());
        this.f20390i = new c1(new b());
        this.f20384c = (d) Preconditions.checkNotNull(dVar, "keepAlivePinger");
        this.f20382a = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "scheduler");
        this.f20383b = (Stopwatch) Preconditions.checkNotNull(stopwatch, "stopwatch");
        this.f20391j = j10;
        this.f20392k = j11;
        this.f20385d = z10;
        stopwatch.reset().start();
    }
}
