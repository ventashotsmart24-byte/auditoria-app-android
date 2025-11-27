package anet.channel.e;

import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.EventCb;
import anet.channel.entity.b;
import anet.channel.statist.Http3DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;

class f implements EventCb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IConnStrategy f3698a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f3699b;

    public f(e eVar, IConnStrategy iConnStrategy) {
        this.f3699b = eVar;
        this.f3698a = iConnStrategy;
    }

    public void onEvent(Session session, int i10, b bVar) {
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        a.f3683a.a(NetworkStatusHelper.getUniqueId(this.f3699b.f3697b), z10);
        session.close(false);
        Http3DetectStat http3DetectStat = new Http3DetectStat(a.f3684b, this.f3698a);
        http3DetectStat.ret = z10 ? 1 : 0;
        AppMonitor.getInstance().commitStat(http3DetectStat);
    }
}
