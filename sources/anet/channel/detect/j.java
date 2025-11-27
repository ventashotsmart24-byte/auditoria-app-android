package anet.channel.detect;

import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.l;

final class j implements IConnStrategy {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l.e f3669a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConnProtocol f3670b;

    public j(l.e eVar, ConnProtocol connProtocol) {
        this.f3669a = eVar;
        this.f3670b = connProtocol;
    }

    public int getConnectionTimeout() {
        return this.f3669a.f3982b.f3953c;
    }

    public int getHeartbeat() {
        return 0;
    }

    public String getIp() {
        return this.f3669a.f3981a;
    }

    public int getIpSource() {
        return 2;
    }

    public int getIpType() {
        return 1;
    }

    public int getPort() {
        return this.f3669a.f3982b.f3951a;
    }

    public ConnProtocol getProtocol() {
        return this.f3670b;
    }

    public int getReadTimeout() {
        return this.f3669a.f3982b.f3954d;
    }

    public int getRetryTimes() {
        return 0;
    }
}
