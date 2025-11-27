package com.efs.sdk.h5pagesdk;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    private static final String TAG = "com.efs.sdk.h5pagesdk.a";

    /* renamed from: i  reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f5340i;

    /* renamed from: j  reason: collision with root package name */
    private static ThreadFactory f5341j = new ThreadFactory() {

        /* renamed from: k  reason: collision with root package name */
        private AtomicInteger f5342k = new AtomicInteger(0);

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("H5ThreadPoolExecutor" + this.f5342k.addAndGet(1));
            return thread;
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f5340i == null) {
            synchronized (a.class) {
                if (f5340i == null) {
                    f5340i = new ScheduledThreadPoolExecutor(4, f5341j);
                }
            }
        }
        return f5340i;
    }

    public static void execute(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
