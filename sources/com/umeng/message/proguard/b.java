package com.umeng.message.proguard;

import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.message.common.UPLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f15480a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f15481b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile ScheduledExecutorService f15482c;

    public static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f15483a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        private final String f15484b;

        public a(String str) {
            this.f15484b = str;
        }

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f15484b + " " + this.f15483a.incrementAndGet());
        }
    }

    /* renamed from: com.umeng.message.proguard.b$b  reason: collision with other inner class name */
    public static class C0210b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f15485a;

        public C0210b(Runnable runnable) {
            this.f15485a = runnable;
        }

        public final void run() {
            try {
                Runnable runnable = this.f15485a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                UPLog.e("Executors", th);
            }
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f15480a == null) {
            synchronized (b.class) {
                if (f15480a == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new a("pool"));
                    f15480a = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
                    f15480a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f15480a;
    }

    private static ScheduledExecutorService b() {
        if (f15482c == null) {
            synchronized (b.class) {
                if (f15482c == null) {
                    f15482c = Executors.newSingleThreadScheduledExecutor(new a("single"));
                }
            }
        }
        return f15482c;
    }

    private static ExecutorService c() {
        if (f15481b == null) {
            synchronized (b.class) {
                if (f15481b == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a(Constant.KEY_MSG));
                    f15481b = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(30, TimeUnit.SECONDS);
                    f15481b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f15481b;
    }

    private static Runnable d(Runnable runnable) {
        return new C0210b(runnable);
    }

    public static Future<?> b(Runnable runnable) {
        try {
            return b().submit(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }

    public static ScheduledFuture<?> a(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            return b().schedule(d(runnable), j10, timeUnit);
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }

    public static ScheduledFuture<?> b(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            return a().schedule(d(runnable), j10, timeUnit);
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }

    public static void c(Runnable runnable) {
        try {
            a().execute(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
        }
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            try {
                c().execute(d(runnable));
            } catch (Throwable th) {
                UPLog.e("Executors", th);
            }
        }
    }
}
