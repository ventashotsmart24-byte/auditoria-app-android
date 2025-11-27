package k1;

import a1.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class r {

    /* renamed from: f  reason: collision with root package name */
    public static final String f7281f = k.f("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f7282a;

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f7283b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f7284c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map f7285d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Object f7286e = new Object();

    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public int f7287a = 0;

        public a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.f7287a);
            this.f7287a = this.f7287a + 1;
            return newThread;
        }
    }

    public interface b {
        void a(String str);
    }

    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final r f7289a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7290b;

        public c(r rVar, String str) {
            this.f7289a = rVar;
            this.f7290b = str;
        }

        public void run() {
            synchronized (this.f7289a.f7286e) {
                if (((c) this.f7289a.f7284c.remove(this.f7290b)) != null) {
                    b bVar = (b) this.f7289a.f7285d.remove(this.f7290b);
                    if (bVar != null) {
                        bVar.a(this.f7290b);
                    }
                } else {
                    k.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.f7290b}), new Throwable[0]);
                }
            }
        }
    }

    public r() {
        a aVar = new a();
        this.f7282a = aVar;
        this.f7283b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public void a() {
        if (!this.f7283b.isShutdown()) {
            this.f7283b.shutdownNow();
        }
    }

    public void b(String str, long j10, b bVar) {
        synchronized (this.f7286e) {
            k.c().a(f7281f, String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            c(str);
            c cVar = new c(this, str);
            this.f7284c.put(str, cVar);
            this.f7285d.put(str, bVar);
            this.f7283b.schedule(cVar, j10, TimeUnit.MILLISECONDS);
        }
    }

    public void c(String str) {
        synchronized (this.f7286e) {
            if (((c) this.f7284c.remove(str)) != null) {
                k.c().a(f7281f, String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                this.f7285d.remove(str);
            }
        }
    }
}
