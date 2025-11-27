package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

public class a implements IHeartbeat, Runnable {

    /* renamed from: a  reason: collision with root package name */
    Session f3730a = null;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f3731b = false;

    public void reSchedule() {
    }

    public void run() {
        if (!this.f3731b) {
            this.f3730a.ping(true);
            ThreadPoolExecutorFactory.submitScheduledTask(this, 45000, TimeUnit.MILLISECONDS);
        }
    }

    public void start(Session session) {
        if (session != null) {
            this.f3730a = session;
            run();
            return;
        }
        throw new NullPointerException("session is null");
    }

    public void stop() {
        this.f3731b = true;
    }
}
