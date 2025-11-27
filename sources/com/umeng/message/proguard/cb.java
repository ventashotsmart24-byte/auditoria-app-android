package com.umeng.message.proguard;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class cb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f15566a;

    /* renamed from: b  reason: collision with root package name */
    private static final Handler f15567b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadFactory f15568c = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f15569a = new AtomicInteger(0);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "union-" + this.f15569a.incrementAndGet());
        }
    };

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f15570a;

        public a(Runnable runnable) {
            this.f15570a = runnable;
        }

        public final void run() {
            try {
                Runnable runnable = this.f15570a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f15566a == null) {
            synchronized (cb.class) {
                if (f15566a == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f15568c);
                    f15566a = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(3, TimeUnit.SECONDS);
                    f15566a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f15566a;
    }

    public static void b(Runnable runnable) {
        a aVar = new a(runnable);
        if (Looper.myLooper() == f15567b.getLooper()) {
            a(aVar);
        } else {
            aVar.run();
        }
    }

    public static void c(Runnable runnable) {
        a aVar = new a(runnable);
        Looper myLooper = Looper.myLooper();
        Handler handler = f15567b;
        if (myLooper == handler.getLooper()) {
            aVar.run();
        } else {
            handler.post(aVar);
        }
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            ce.d("Executor", "execute", th.getMessage());
        }
    }

    public static <V> Future<V> a(Callable<V> callable, long j10, TimeUnit timeUnit) {
        try {
            return a().schedule(callable, j10, timeUnit);
        } catch (Throwable unused) {
            ce.d("Executor", "schedule exception");
            return null;
        }
    }
}
