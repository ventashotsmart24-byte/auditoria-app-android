package anet.channel.thread;

import anet.channel.util.ALog;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorFactory {

    /* renamed from: a  reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f3990a = new ScheduledThreadPoolExecutor(1, new b("AWCN Scheduler"));

    /* renamed from: b  reason: collision with root package name */
    private static ThreadPoolExecutor f3991b;

    /* renamed from: c  reason: collision with root package name */
    private static ThreadPoolExecutor f3992c;

    /* renamed from: d  reason: collision with root package name */
    private static ThreadPoolExecutor f3993d;

    /* renamed from: e  reason: collision with root package name */
    private static ThreadPoolExecutor f3994e;

    /* renamed from: f  reason: collision with root package name */
    private static ThreadPoolExecutor f3995f;

    /* renamed from: g  reason: collision with root package name */
    private static ThreadPoolExecutor f3996g;

    /* renamed from: h  reason: collision with root package name */
    private static ThreadPoolExecutor f3997h;

    public static class Priority {
        public static int HIGH = 0;
        public static int LOW = 9;
        public static int NORMAL = 1;
    }

    public static class a implements Comparable<a>, Runnable {

        /* renamed from: a  reason: collision with root package name */
        Runnable f3998a = null;

        /* renamed from: b  reason: collision with root package name */
        int f3999b = 0;

        /* renamed from: c  reason: collision with root package name */
        long f4000c = System.currentTimeMillis();

        public a(Runnable runnable, int i10) {
            this.f3998a = runnable;
            this.f3999b = i10;
            this.f4000c = System.currentTimeMillis();
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            int i10 = this.f3999b;
            int i11 = aVar.f3999b;
            if (i10 != i11) {
                return i10 - i11;
            }
            return (int) (aVar.f4000c - this.f4000c);
        }

        public void run() {
            this.f3998a.run();
        }
    }

    public static class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        AtomicInteger f4001a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        String f4002b;

        public b(String str) {
            this.f4002b = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f4002b + this.f4001a.incrementAndGet());
            ALog.i("awcn.ThreadPoolExecutorFactory", "thread created!", (String) null, "name", thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f3991b = new ThreadPoolExecutor(2, 2, 60, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(H)"));
        TimeUnit timeUnit2 = timeUnit;
        f3992c = new a(16, 16, 60, timeUnit2, new PriorityBlockingQueue(), new b("AWCN Worker(M)"));
        f3993d = new ThreadPoolExecutor(2, 2, 60, timeUnit2, new LinkedBlockingDeque(), new b("AWCN Worker(L)"));
        f3994e = new ThreadPoolExecutor(32, 32, 60, timeUnit2, new LinkedBlockingDeque(), new b("AWCN Worker(Backup)"));
        f3995f = new ThreadPoolExecutor(1, 1, 30, timeUnit2, new LinkedBlockingDeque(), new b("AWCN Detector"));
        f3996g = new ThreadPoolExecutor(1, 1, 30, timeUnit2, new LinkedBlockingDeque(), new b("AWCN HR"));
        f3997h = new ThreadPoolExecutor(1, 1, 30, timeUnit2, new LinkedBlockingDeque(), new b("AWCN Cookie"));
        f3991b.allowCoreThreadTimeOut(true);
        f3992c.allowCoreThreadTimeOut(true);
        f3993d.allowCoreThreadTimeOut(true);
        f3994e.allowCoreThreadTimeOut(true);
        f3995f.allowCoreThreadTimeOut(true);
        f3996g.allowCoreThreadTimeOut(true);
        f3997h.allowCoreThreadTimeOut(true);
    }

    public static void removeScheduleTask(Runnable runnable) {
        f3990a.remove(runnable);
    }

    public static synchronized void setNormalExecutorPoolSize(int i10) {
        synchronized (ThreadPoolExecutorFactory.class) {
            if (i10 < 6) {
                i10 = 6;
            }
            f3992c.setCorePoolSize(i10);
            f3992c.setMaximumPoolSize(i10);
        }
    }

    public static Future<?> submitBackupTask(Runnable runnable) {
        return f3994e.submit(runnable);
    }

    public static Future<?> submitCookieMonitor(Runnable runnable) {
        return f3997h.submit(runnable);
    }

    public static Future<?> submitDetectTask(Runnable runnable) {
        return f3995f.submit(runnable);
    }

    public static Future<?> submitHRTask(Runnable runnable) {
        return f3996g.submit(runnable);
    }

    public static Future<?> submitPriorityTask(Runnable runnable, int i10) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.ThreadPoolExecutorFactory", "submit priority task", (String) null, "priority", Integer.valueOf(i10));
        }
        if (i10 < Priority.HIGH || i10 > Priority.LOW) {
            i10 = Priority.LOW;
        }
        if (i10 == Priority.HIGH) {
            return f3991b.submit(runnable);
        }
        if (i10 == Priority.LOW) {
            return f3993d.submit(runnable);
        }
        return f3992c.submit(new a(runnable, i10));
    }

    public static Future<?> submitScheduledTask(Runnable runnable) {
        return f3990a.submit(runnable);
    }

    public static Future<?> submitScheduledTask(Runnable runnable, long j10, TimeUnit timeUnit) {
        return f3990a.schedule(runnable, j10, timeUnit);
    }
}
