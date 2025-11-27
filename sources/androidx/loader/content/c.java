package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadFactory f2355f;

    /* renamed from: g  reason: collision with root package name */
    public static final BlockingQueue f2356g;

    /* renamed from: h  reason: collision with root package name */
    public static final Executor f2357h;

    /* renamed from: i  reason: collision with root package name */
    public static f f2358i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile Executor f2359j;

    /* renamed from: a  reason: collision with root package name */
    public final h f2360a;

    /* renamed from: b  reason: collision with root package name */
    public final FutureTask f2361b;

    /* renamed from: c  reason: collision with root package name */
    public volatile g f2362c = g.PENDING;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f2363d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f2364e = new AtomicBoolean();

    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f2365a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f2365a.getAndIncrement());
        }
    }

    public class b extends h {
        public b() {
        }

        public Object call() {
            c.this.f2364e.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = c.this.b(this.f2375a);
                Binder.flushPendingCommands();
                c.this.k(obj);
                return obj;
            } catch (Throwable th) {
                c.this.k(obj);
                throw th;
            }
        }
    }

    /* renamed from: androidx.loader.content.c$c  reason: collision with other inner class name */
    public class C0034c extends FutureTask {
        public C0034c(Callable callable) {
            super(callable);
        }

        public void done() {
            try {
                c.this.l(get());
            } catch (InterruptedException unused) {
            } catch (ExecutionException e10) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e10.getCause());
            } catch (CancellationException unused2) {
                c.this.l((Object) null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2368a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.content.c$g[] r0 = androidx.loader.content.c.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2368a = r0
                androidx.loader.content.c$g r1 = androidx.loader.content.c.g.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2368a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.content.c$g r1 = androidx.loader.content.c.g.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.content.c.d.<clinit>():void");
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final c f2369a;

        /* renamed from: b  reason: collision with root package name */
        public final Object[] f2370b;

        public e(c cVar, Object... objArr) {
            this.f2369a = cVar;
            this.f2370b = objArr;
        }
    }

    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i10 = message.what;
            if (i10 == 1) {
                eVar.f2369a.d(eVar.f2370b[0]);
            } else if (i10 == 2) {
                eVar.f2369a.j(eVar.f2370b);
            }
        }
    }

    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class h implements Callable {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f2375a;
    }

    static {
        a aVar = new a();
        f2355f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f2356g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f2357h = threadPoolExecutor;
        f2359j = threadPoolExecutor;
    }

    public c() {
        b bVar = new b();
        this.f2360a = bVar;
        this.f2361b = new C0034c(bVar);
    }

    public static Handler e() {
        f fVar;
        synchronized (c.class) {
            if (f2358i == null) {
                f2358i = new f();
            }
            fVar = f2358i;
        }
        return fVar;
    }

    public final boolean a(boolean z10) {
        this.f2363d.set(true);
        return this.f2361b.cancel(z10);
    }

    public abstract Object b(Object... objArr);

    public final c c(Executor executor, Object... objArr) {
        if (this.f2362c != g.PENDING) {
            int i10 = d.f2368a[this.f2362c.ordinal()];
            if (i10 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i10 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.f2362c = g.RUNNING;
            i();
            this.f2360a.f2375a = objArr;
            executor.execute(this.f2361b);
            return this;
        }
    }

    public void d(Object obj) {
        if (f()) {
            g(obj);
        } else {
            h(obj);
        }
        this.f2362c = g.FINISHED;
    }

    public final boolean f() {
        return this.f2363d.get();
    }

    public abstract void g(Object obj);

    public abstract void h(Object obj);

    public void i() {
    }

    public void j(Object... objArr) {
    }

    public Object k(Object obj) {
        e().obtainMessage(1, new e(this, obj)).sendToTarget();
        return obj;
    }

    public void l(Object obj) {
        if (!this.f2364e.get()) {
            k(obj);
        }
    }
}
