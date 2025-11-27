package anet.channel.e;

import anet.channel.entity.ConnType;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;

final class g implements IConnStrategy {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IConnStrategy f3700a;

    public g(IConnStrategy iConnStrategy) {
        this.f3700a = iConnStrategy;
    }

    public int getConnectionTimeout() {
        return this.f3700a.getConnectionTimeout();
    }

    public int getHeartbeat() {
        return this.f3700a.getHeartbeat();
    }

    public String getIp() {
        return this.f3700a.getIp();
    }

    public int getIpSource() {
        return this.f3700a.getIpSource();
    }

    public int getIpType() {
        return this.f3700a.getIpType();
    }

    public int getPort() {
        return this.f3700a.getPort();
    }

    public ConnProtocol getProtocol() {
        this.f3700a.getProtocol();
        return ConnProtocol.valueOf(ConnType.HTTP3_1RTT, (String) null, (String) null);
    }

    public int getReadTimeout() {
        return this.f3700a.getReadTimeout();
    }

    public int getRetryTimes() {
        return this.f3700a.getRetryTimes();
    }
}
