package y8;

import com.google.common.base.Preconditions;
import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class o1 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f20122a;

    /* renamed from: b  reason: collision with root package name */
    public final Queue f20123b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference f20124c = new AtomicReference();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f20126b;

        public a(c cVar, Runnable runnable) {
            this.f20125a = cVar;
            this.f20126b = runnable;
        }

        public void run() {
            o1.this.execute(this.f20125a);
        }

        public String toString() {
            return this.f20126b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20128a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f20129b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20130c;

        public b(c cVar, Runnable runnable, long j10) {
            this.f20128a = cVar;
            this.f20129b = runnable;
            this.f20130c = j10;
        }

        public void run() {
            o1.this.execute(this.f20128a);
        }

        public String toString() {
            return this.f20129b.toString() + "(scheduled in SynchronizationContext with delay of " + this.f20130c + ")";
        }
    }

    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f20132a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20133b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f20134c;

        public c(Runnable runnable) {
            this.f20132a = (Runnable) Preconditions.checkNotNull(runnable, "task");
        }

        public void run() {
            if (!this.f20133b) {
                this.f20134c = true;
                this.f20132a.run();
            }
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final c f20135a;

        /* renamed from: b  reason: collision with root package name */
        public final ScheduledFuture f20136b;

        public /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }

        public void a() {
            this.f20135a.f20133b = true;
            this.f20136b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f20135a;
            if (cVar.f20134c || cVar.f20133b) {
                return false;
            }
            return true;
        }

        public d(c cVar, ScheduledFuture scheduledFuture) {
            this.f20135a = (c) Preconditions.checkNotNull(cVar, "runnable");
            this.f20136b = (ScheduledFuture) Preconditions.checkNotNull(scheduledFuture, "future");
        }
    }

    public o1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f20122a = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (h3.b.a(this.f20124c, (Object) null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnable = (Runnable) this.f20123b.poll();
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        this.f20124c.set((Object) null);
                        if (this.f20123b.isEmpty()) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    this.f20124c.set((Object) null);
                    throw th;
                }
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f20123b.add((Runnable) Preconditions.checkNotNull(runnable, "runnable is null"));
    }

    public final d c(Runnable runnable, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j10, timeUnit), (a) null);
    }

    public final d d(Runnable runnable, long j10, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j11), j10, j11, timeUnit), (a) null);
    }

    public void e() {
        boolean z10;
        if (Thread.currentThread() == this.f20124c.get()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Not called from the SynchronizationContext");
    }

    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
