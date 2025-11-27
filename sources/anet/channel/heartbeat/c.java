package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

public class c implements IHeartbeat, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Session f3736a = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f3737b = false;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f3738c = System.currentTimeMillis();

    public void reSchedule() {
        this.f3738c = System.currentTimeMillis() + 45000;
    }

    public void run() {
        if (!this.f3737b) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.f3738c - 1000) {
                ThreadPoolExecutorFactory.submitScheduledTask(this, this.f3738c - currentTimeMillis, TimeUnit.MILLISECONDS);
            } else {
                this.f3736a.close(false);
            }
        }
    }

    public void start(Session session) {
        if (session != null) {
            this.f3736a = session;
            this.f3738c = System.currentTimeMillis() + 45000;
            ThreadPoolExecutorFactory.submitScheduledTask(this, 45000, TimeUnit.MILLISECONDS);
            return;
        }
        throw new NullPointerException("session is null");
    }

    public void stop() {
        this.f3737b = true;
    }
}
