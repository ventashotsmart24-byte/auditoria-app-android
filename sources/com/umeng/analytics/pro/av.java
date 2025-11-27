package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class av {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13789a = "UMExecutor";

    /* renamed from: b  reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f13790b;

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadFactory f13791c = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f13792a = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f13792a.incrementAndGet());
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f13790b == null) {
            synchronized (av.class) {
                if (f13790b == null) {
                    f13790b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f13791c);
                    f13790b.setKeepAliveTime(3, TimeUnit.SECONDS);
                    f13790b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f13790b;
    }

    public static void a(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j10, timeUnit);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
