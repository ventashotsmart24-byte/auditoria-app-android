package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.entity.b;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

class g implements EventCb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Session f3725a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SessionRequest f3726b;

    public g(SessionRequest sessionRequest, Session session) {
        this.f3726b = sessionRequest;
        this.f3725a = session;
    }

    public void onEvent(Session session, int i10, b bVar) {
        ALog.d("awcn.SessionRequest", "Receive session event", (String) null, "eventType", Integer.valueOf(i10));
        ConnEvent connEvent = new ConnEvent();
        if (i10 == 512) {
            connEvent.isSuccess = true;
        }
        SessionInfo sessionInfo = this.f3726b.f3589c;
        if (sessionInfo != null) {
            connEvent.isAccs = sessionInfo.isAccs;
        }
        StrategyCenter.getInstance().notifyConnEvent(this.f3725a.getRealHost(), this.f3725a.getConnStrategy(), connEvent);
    }
}
