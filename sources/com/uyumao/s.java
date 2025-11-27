package com.uyumao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f16317a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile ExecutorService f16318b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f16319c = new a();

    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f16320a = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.f16320a.incrementAndGet());
        }
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f16321a;

        public b(Runnable runnable) {
            this.f16321a = runnable;
        }

        public final void run() {
            try {
                Runnable runnable = this.f16321a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f16317a == null) {
            synchronized (s.class) {
                if (f16317a == null) {
                    f16317a = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f16319c);
                    f16317a.setKeepAliveTime(3, TimeUnit.SECONDS);
                    f16317a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f16317a;
    }

    public static Future<?> a(Runnable runnable) {
        try {
            if (f16318b == null) {
                synchronized (s.class) {
                    if (f16318b == null) {
                        f16318b = Executors.newSingleThreadExecutor(f16319c);
                    }
                }
            }
            return f16318b.submit(new b(runnable));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static void a(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j10, timeUnit);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
