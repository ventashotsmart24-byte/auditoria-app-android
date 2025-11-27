package anet.channel.strategy;

import anet.channel.statist.StrategyStatObject;
import anet.channel.strategy.StrategyInfoHolder;
import java.io.Serializable;
import java.util.Map;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map.Entry f3937a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder.LruStrategyMap f3938b;

    public f(StrategyInfoHolder.LruStrategyMap lruStrategyMap, Map.Entry entry) {
        this.f3938b = lruStrategyMap;
        this.f3937a = entry;
    }

    public void run() {
        StrategyTable strategyTable = (StrategyTable) this.f3937a.getValue();
        if (strategyTable.f3909d) {
            StrategyStatObject strategyStatObject = new StrategyStatObject(1);
            strategyStatObject.writeStrategyFileId = strategyTable.f3906a;
            m.a((Serializable) this.f3937a.getValue(), strategyTable.f3906a, strategyStatObject);
            strategyTable.f3909d = false;
        }
    }
}
