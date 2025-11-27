package com.alibaba.sdk.android.utils.crashdefend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f5071a = new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "safe_thread");
            thread.setDaemon(false);
            return thread;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f5072b;

    public synchronized ExecutorService a() {
        if (this.f5072b == null) {
            this.f5072b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), this.f5071a);
        }
        return this.f5072b;
    }
}
