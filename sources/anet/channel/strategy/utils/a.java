package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static AtomicInteger f3988a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f3989b = null;

    public static ScheduledThreadPoolExecutor a() {
        if (f3989b == null) {
            synchronized (a.class) {
                if (f3989b == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new b());
                    f3989b = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
                    f3989b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f3989b;
    }

    public static void a(Runnable runnable) {
        try {
            a().submit(runnable);
        } catch (Exception e10) {
            ALog.e(a.TAG, "submit task failed", (String) null, e10, new Object[0]);
        }
    }

    public static void a(Runnable runnable, long j10) {
        try {
            a().schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            ALog.e(a.TAG, "schedule task failed", (String) null, e10, new Object[0]);
        }
    }
}
