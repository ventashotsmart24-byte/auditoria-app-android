package anet.channel.heartbeat;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.umeng.analytics.pro.bt;
import java.util.concurrent.TimeUnit;

class b implements IHeartbeat, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Session f3732a;

    /* renamed from: b  reason: collision with root package name */
    private volatile long f3733b = 0;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f3734c = false;

    /* renamed from: d  reason: collision with root package name */
    private long f3735d = 0;

    private void a(long j10) {
        try {
            this.f3733b = System.currentTimeMillis() + j10;
            ThreadPoolExecutorFactory.submitScheduledTask(this, j10 + 50, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            ALog.e("awcn.DefaultHeartbeatImpl", "Submit heartbeat task failed.", this.f3732a.f3564p, e10, new Object[0]);
        }
    }

    public void reSchedule() {
        this.f3733b = System.currentTimeMillis() + this.f3735d;
    }

    public void run() {
        if (!this.f3734c) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.f3733b - 1000) {
                a(this.f3733b - currentTimeMillis);
            } else if (!GlobalAppRuntimeInfo.isAppBackground()) {
                if (ALog.isPrintLog(1)) {
                    Session session = this.f3732a;
                    ALog.d("awcn.DefaultHeartbeatImpl", "heartbeat", session.f3564p, "session", session);
                }
                this.f3732a.ping(true);
                a(this.f3735d);
            } else {
                Session session2 = this.f3732a;
                ALog.e("awcn.DefaultHeartbeatImpl", "close session in background", session2.f3564p, "session", session2);
                this.f3732a.close(false);
            }
        }
    }

    public void start(Session session) {
        if (session != null) {
            this.f3732a = session;
            long heartbeat = (long) session.getConnStrategy().getHeartbeat();
            this.f3735d = heartbeat;
            if (heartbeat <= 0) {
                this.f3735d = 45000;
            }
            ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat start", session.f3564p, "session", session, bt.f13907ba, Long.valueOf(this.f3735d));
            a(this.f3735d);
            return;
        }
        throw new NullPointerException("session is null");
    }

    public void stop() {
        Session session = this.f3732a;
        if (session != null) {
            ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat stop", session.f3564p, "session", session);
            this.f3734c = true;
        }
    }
}
