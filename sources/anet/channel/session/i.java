package anet.channel.session;

import anet.channel.IAuth;
import anet.channel.entity.b;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.statist.SessionStatistic;
import anet.channel.util.ALog;

class i implements IAuth.AuthCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f3853a;

    public i(TnetSpdySession tnetSpdySession) {
        this.f3853a = tnetSpdySession;
    }

    public void onAuthFail(int i10, String str) {
        this.f3853a.notifyStatus(5, (b) null);
        SessionStatistic sessionStatistic = this.f3853a.f3565q;
        if (sessionStatistic != null) {
            sessionStatistic.closeReason = "Accs_Auth_Fail:" + i10;
            this.f3853a.f3565q.errorCode = (long) i10;
        }
        this.f3853a.close();
    }

    public void onAuthSuccess() {
        this.f3853a.notifyStatus(4, (b) null);
        this.f3853a.f3832z = System.currentTimeMillis();
        TnetSpdySession tnetSpdySession = this.f3853a;
        IHeartbeat iHeartbeat = tnetSpdySession.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(tnetSpdySession);
        }
        TnetSpdySession tnetSpdySession2 = this.f3853a;
        SessionStatistic sessionStatistic = tnetSpdySession2.f3565q;
        sessionStatistic.ret = 1;
        ALog.d("awcn.TnetSpdySession", "spdyOnStreamResponse", tnetSpdySession2.f3564p, "authTime", Long.valueOf(sessionStatistic.authTime));
        TnetSpdySession tnetSpdySession3 = this.f3853a;
        if (tnetSpdySession3.A > 0) {
            tnetSpdySession3.f3565q.authTime = System.currentTimeMillis() - this.f3853a.A;
        }
    }
}
