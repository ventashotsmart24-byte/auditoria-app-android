package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static ScheduledExecutorService f4984a;

    /* renamed from: a  reason: collision with other field name */
    private static final ThreadFactory f22a = new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("httpdns worker");
            thread.setDaemon(false);
            thread.setUncaughtExceptionHandler(new k());
            return thread;
        }
    };

    public static synchronized ScheduledExecutorService a() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (j.class) {
            if (f4984a == null) {
                f4984a = new ScheduledThreadPoolExecutor(1, f22a);
            }
            scheduledExecutorService = f4984a;
        }
        return scheduledExecutorService;
    }
}
