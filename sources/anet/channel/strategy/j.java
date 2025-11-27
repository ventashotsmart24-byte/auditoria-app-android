package anet.channel.strategy;

import anet.channel.strategy.StrategyList;
import anet.channel.strategy.l;

class j implements StrategyList.Predicate<IPConnStrategy> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l.a f3946a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3947b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ConnProtocol f3948c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ StrategyList f3949d;

    public j(StrategyList strategyList, l.a aVar, String str, ConnProtocol connProtocol) {
        this.f3949d = strategyList;
        this.f3946a = aVar;
        this.f3947b = str;
        this.f3948c = connProtocol;
    }

    /* renamed from: a */
    public boolean apply(IPConnStrategy iPConnStrategy) {
        if (iPConnStrategy.getPort() != this.f3946a.f3951a || !iPConnStrategy.getIp().equals(this.f3947b) || !iPConnStrategy.protocol.equals(this.f3948c)) {
            return false;
        }
        return true;
    }
}
