package e7;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f16522a = Executors.newSingleThreadScheduledExecutor(new a());

    /* renamed from: b  reason: collision with root package name */
    public final Activity f16523b;

    /* renamed from: c  reason: collision with root package name */
    public ScheduledFuture f16524c = null;

    public static final class a implements ThreadFactory {
        public a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public g(Activity activity) {
        this.f16523b = activity;
        b();
    }

    public final void a() {
        ScheduledFuture scheduledFuture = this.f16524c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f16524c = null;
        }
    }

    public void b() {
        a();
        this.f16524c = this.f16522a.schedule(new e(this.f16523b), 300, TimeUnit.SECONDS);
    }

    public void c() {
        a();
        this.f16522a.shutdown();
    }
}
