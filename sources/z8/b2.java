package z8;

import com.google.common.base.Preconditions;
import com.umeng.analytics.pro.bt;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class b2 implements Executor, Runnable {

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f20404d = Logger.getLogger(b2.class.getName());

    /* renamed from: e  reason: collision with root package name */
    public static final b f20405e = c();

    /* renamed from: a  reason: collision with root package name */
    public Executor f20406a;

    /* renamed from: b  reason: collision with root package name */
    public final Queue f20407b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    public volatile int f20408c = 0;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(b2 b2Var, int i10, int i11);

        public abstract void b(b2 b2Var, int i10);
    }

    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicIntegerFieldUpdater f20409a;

        public boolean a(b2 b2Var, int i10, int i11) {
            return this.f20409a.compareAndSet(b2Var, i10, i11);
        }

        public void b(b2 b2Var, int i10) {
            this.f20409a.set(b2Var, i10);
        }

        public c(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f20409a = atomicIntegerFieldUpdater;
        }
    }

    public static final class d extends b {
        public d() {
            super();
        }

        public boolean a(b2 b2Var, int i10, int i11) {
            synchronized (b2Var) {
                if (b2Var.f20408c != i10) {
                    return false;
                }
                int unused = b2Var.f20408c = i11;
                return true;
            }
        }

        public void b(b2 b2Var, int i10) {
            synchronized (b2Var) {
                int unused = b2Var.f20408c = i10;
            }
        }
    }

    public b2(Executor executor) {
        Preconditions.checkNotNull(executor, "'executor' must not be null.");
        this.f20406a = executor;
    }

    public static b c() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(b2.class, bt.aL));
        } catch (Throwable th) {
            f20404d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new d();
        }
    }

    public final void d(Runnable runnable) {
        if (f20405e.a(this, 0, -1)) {
            try {
                this.f20406a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f20407b.remove(runnable);
                }
                f20405e.b(this, 0);
                throw th;
            }
        }
    }

    public void execute(Runnable runnable) {
        this.f20407b.add((Runnable) Preconditions.checkNotNull(runnable, "'r' must not be null."));
        d(runnable);
    }

    public void run() {
        Runnable runnable;
        try {
            Executor executor = this.f20406a;
            while (executor == this.f20406a && (runnable = (Runnable) this.f20407b.poll()) != null) {
                runnable.run();
            }
            f20405e.b(this, 0);
            if (!this.f20407b.isEmpty()) {
                d((Runnable) null);
            }
        } catch (RuntimeException e10) {
            Logger logger = f20404d;
            Level level = Level.SEVERE;
            logger.log(level, "Exception while executing runnable " + runnable, e10);
        } catch (Throwable th) {
            f20405e.b(this, 0);
            throw th;
        }
    }
}
