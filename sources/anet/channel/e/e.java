package anet.channel.e;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.a;
import anet.channel.session.TnetSpdySession;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import java.util.List;

final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f3696a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f3697b;

    public e(List list, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f3696a = list;
        this.f3697b = networkStatus;
    }

    public void run() {
        IConnStrategy iConnStrategy = (IConnStrategy) this.f3696a.get(0);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(GlobalAppRuntimeInfo.getContext(), new a("https://" + a.f3684b, "Http3Detect" + a.f3690h.getAndIncrement(), a.b(iConnStrategy)));
        tnetSpdySession.registerEventcb(257, new f(this, iConnStrategy));
        tnetSpdySession.f3565q.isCommitted = true;
        tnetSpdySession.connect();
    }
}
