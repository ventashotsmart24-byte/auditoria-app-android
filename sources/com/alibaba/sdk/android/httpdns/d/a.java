package com.alibaba.sdk.android.httpdns.d;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class a {

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f4937b;

    /* renamed from: b  reason: collision with other field name */
    private final ThreadFactory f14b = new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "report_thread");
            thread.setDaemon(false);
            return thread;
        }
    };

    public synchronized ExecutorService b() {
        if (this.f4937b == null) {
            this.f4937b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), this.f14b);
        }
        return this.f4937b;
    }
}
