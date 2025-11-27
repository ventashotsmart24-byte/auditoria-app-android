package com.efs.sdk.launch;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5357a = "com.efs.sdk.launch.a";

    /* renamed from: b  reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f5358b;

    /* renamed from: c  reason: collision with root package name */
    private static ThreadFactory f5359c = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f5360a = new AtomicInteger(0);

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("LaunchThreadPoolExecutor" + this.f5360a.addAndGet(1));
            return thread;
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f5358b == null) {
            synchronized (a.class) {
                if (f5358b == null) {
                    f5358b = new ScheduledThreadPoolExecutor(4, f5359c);
                }
            }
        }
        return f5358b;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
