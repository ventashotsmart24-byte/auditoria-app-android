package anet.channel.session;

import anet.channel.entity.b;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f3852a;

    public h(TnetSpdySession tnetSpdySession) {
        this.f3852a = tnetSpdySession;
    }

    public void run() {
        if (this.f3852a.f3831y) {
            TnetSpdySession tnetSpdySession = this.f3852a;
            ALog.e("awcn.TnetSpdySession", "send msg time out!", tnetSpdySession.f3564p, "pingUnRcv:", Boolean.valueOf(tnetSpdySession.f3831y));
            try {
                this.f3852a.handleCallbacks(2048, (b) null);
                SessionStatistic sessionStatistic = this.f3852a.f3565q;
                if (sessionStatistic != null) {
                    sessionStatistic.closeReason = "ping time out";
                }
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = false;
                connEvent.isAccs = this.f3852a.I;
                StrategyCenter.getInstance().notifyConnEvent(this.f3852a.f3552d, this.f3852a.f3559k, connEvent);
                this.f3852a.close(true);
            } catch (Exception unused) {
            }
        }
    }
}
