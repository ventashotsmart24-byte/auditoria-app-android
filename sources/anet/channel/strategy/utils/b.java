package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ThreadFactory;

final class b implements ThreadFactory {
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AMDC" + a.f3988a.incrementAndGet());
        ALog.i(a.TAG, "thread created!", (String) null, "name", thread.getName());
        thread.setPriority(5);
        return thread;
    }
}
