package anet.channel.e;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;

final class b implements IStrategyFilter {
    public boolean accept(IConnStrategy iConnStrategy) {
        String str = iConnStrategy.getProtocol().protocol;
        if (ConnType.HTTP3.equals(str) || ConnType.HTTP3_PLAIN.equals(str)) {
            return true;
        }
        return false;
    }
}
