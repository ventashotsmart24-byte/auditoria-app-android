package anet.channel.strategy;

import java.util.Comparator;

class k implements Comparator<IPConnStrategy> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StrategyList f3950a;

    public k(StrategyList strategyList) {
        this.f3950a = strategyList;
    }

    /* renamed from: a */
    public int compare(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
        int i10;
        int i11;
        int a10 = ((ConnHistoryItem) this.f3950a.f3902b.get(Integer.valueOf(iPConnStrategy.getUniqueId()))).a();
        int a11 = ((ConnHistoryItem) this.f3950a.f3902b.get(Integer.valueOf(iPConnStrategy2.getUniqueId()))).a();
        if (a10 != a11) {
            return a10 - a11;
        }
        if (iPConnStrategy.f3881a != iPConnStrategy2.f3881a) {
            i10 = iPConnStrategy.f3881a;
            i11 = iPConnStrategy2.f3881a;
        } else {
            i10 = iPConnStrategy.protocol.isHttp;
            i11 = iPConnStrategy2.protocol.isHttp;
        }
        return i10 - i11;
    }
}
