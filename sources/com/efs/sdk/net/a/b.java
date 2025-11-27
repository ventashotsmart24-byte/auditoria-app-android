package com.efs.sdk.net.a;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5464a = "com.efs.sdk.net.a.b";

    /* renamed from: b  reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f5465b;

    /* renamed from: c  reason: collision with root package name */
    private static ThreadFactory f5466c = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f5467a = new AtomicInteger(0);

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("NetThreadPoolExecutor" + this.f5467a.addAndGet(1));
            return thread;
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f5465b == null) {
            synchronized (b.class) {
                if (f5465b == null) {
                    f5465b = new ScheduledThreadPoolExecutor(4, f5466c);
                }
            }
        }
        return f5465b;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
