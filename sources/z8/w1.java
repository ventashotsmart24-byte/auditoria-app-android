package z8;

import com.google.common.base.Stopwatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class w1 {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f21008a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f21009b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f21010c;

    /* renamed from: d  reason: collision with root package name */
    public final Stopwatch f21011d;

    /* renamed from: e  reason: collision with root package name */
    public long f21012e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21013f;

    /* renamed from: g  reason: collision with root package name */
    public ScheduledFuture f21014g;

    public final class b implements Runnable {
        public b() {
        }

        public void run() {
            if (!w1.this.f21013f) {
                ScheduledFuture unused = w1.this.f21014g = null;
                return;
            }
            long e10 = w1.this.j();
            if (w1.this.f21012e - e10 > 0) {
                w1 w1Var = w1.this;
                ScheduledFuture unused2 = w1Var.f21014g = w1Var.f21008a.schedule(new c(), w1.this.f21012e - e10, TimeUnit.NANOSECONDS);
                return;
            }
            boolean unused3 = w1.this.f21013f = false;
            ScheduledFuture unused4 = w1.this.f21014g = null;
            w1.this.f21010c.run();
        }
    }

    public final class c implements Runnable {
        public c() {
        }

        public void run() {
            w1.this.f21009b.execute(new b());
        }
    }

    public w1(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, Stopwatch stopwatch) {
        this.f21010c = runnable;
        this.f21009b = executor;
        this.f21008a = scheduledExecutorService;
        this.f21011d = stopwatch;
        stopwatch.start();
    }

    public void i(boolean z10) {
        ScheduledFuture scheduledFuture;
        this.f21013f = false;
        if (z10 && (scheduledFuture = this.f21014g) != null) {
            scheduledFuture.cancel(false);
            this.f21014g = null;
        }
    }

    public final long j() {
        return this.f21011d.elapsed(TimeUnit.NANOSECONDS);
    }

    public void k(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        long j11 = j() + nanos;
        this.f21013f = true;
        if (j11 - this.f21012e < 0 || this.f21014g == null) {
            ScheduledFuture scheduledFuture = this.f21014g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f21014g = this.f21008a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f21012e = j11;
    }
}
