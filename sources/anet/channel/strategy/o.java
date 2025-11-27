package anet.channel.strategy;

import java.util.Comparator;

final class o implements Comparator<StrategyCollection> {
    /* renamed from: a */
    public int compare(StrategyCollection strategyCollection, StrategyCollection strategyCollection2) {
        if (strategyCollection.f3885b != strategyCollection2.f3885b) {
            return (int) (strategyCollection.f3885b - strategyCollection2.f3885b);
        }
        return strategyCollection.f3884a.compareTo(strategyCollection2.f3884a);
    }
}
