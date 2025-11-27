package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f4931a;

    /* renamed from: a  reason: collision with other field name */
    private static final ThreadFactory f9a;

    /* renamed from: a  reason: collision with other field name */
    private static final TimeUnit f10a;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f10a = timeUnit;
        AnonymousClass1 r72 = new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("httpdns worker");
                thread.setDaemon(false);
                thread.setUncaughtExceptionHandler(new k());
                return thread;
            }
        };
        f9a = r72;
        f4931a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, timeUnit, new SynchronousQueue(), r72);
    }

    public static ExecutorService a() {
        return f4931a;
    }
}
