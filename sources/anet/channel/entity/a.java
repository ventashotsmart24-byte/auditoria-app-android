package anet.channel.entity;

import anet.channel.strategy.IConnStrategy;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final IConnStrategy f3701a;

    /* renamed from: b  reason: collision with root package name */
    public int f3702b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f3703c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f3704d;

    /* renamed from: e  reason: collision with root package name */
    private String f3705e;

    public a(String str, String str2, IConnStrategy iConnStrategy) {
        this.f3701a = iConnStrategy;
        this.f3704d = str;
        this.f3705e = str2;
    }

    public String a() {
        IConnStrategy iConnStrategy = this.f3701a;
        if (iConnStrategy != null) {
            return iConnStrategy.getIp();
        }
        return null;
    }

    public int b() {
        IConnStrategy iConnStrategy = this.f3701a;
        if (iConnStrategy != null) {
            return iConnStrategy.getPort();
        }
        return 0;
    }

    public ConnType c() {
        IConnStrategy iConnStrategy = this.f3701a;
        if (iConnStrategy != null) {
            return ConnType.valueOf(iConnStrategy.getProtocol());
        }
        return ConnType.HTTP;
    }

    public int d() {
        IConnStrategy iConnStrategy = this.f3701a;
        if (iConnStrategy == null || iConnStrategy.getConnectionTimeout() == 0) {
            return 20000;
        }
        return this.f3701a.getConnectionTimeout();
    }

    public int e() {
        IConnStrategy iConnStrategy = this.f3701a;
        if (iConnStrategy == null || iConnStrategy.getReadTimeout() == 0) {
            return 20000;
        }
        return this.f3701a.getReadTimeout();
    }

    public String f() {
        return this.f3704d;
    }

    public int g() {
        IConnStrategy iConnStrategy = this.f3701a;
        if (iConnStrategy != null) {
            return iConnStrategy.getHeartbeat();
        }
        return 45000;
    }

    public String h() {
        return this.f3705e;
    }

    public String toString() {
        return "ConnInfo [ip=" + a() + ",port=" + b() + ",type=" + c() + ",hb" + g() + "]";
    }
}
