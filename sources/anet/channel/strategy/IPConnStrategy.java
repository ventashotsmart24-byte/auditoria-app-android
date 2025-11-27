package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

class IPConnStrategy implements IConnStrategy, Serializable {
    public static final int SOURCE_AMDC = 0;
    public static final int SOURCE_CUSTOMIZED = 2;
    public static final int SOURCE_LOCAL_DNS = 1;
    public static final int TYPE_IP_TO_HOST = -1;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_STATIC_BANDWITDH = 0;

    /* renamed from: a  reason: collision with root package name */
    volatile int f3881a = 1;

    /* renamed from: b  reason: collision with root package name */
    volatile int f3882b = 1;

    /* renamed from: c  reason: collision with root package name */
    transient boolean f3883c;
    public volatile int cto;
    public volatile int heartbeat;
    public final String ip;
    public final int port;
    public final ConnProtocol protocol;
    public volatile int retry;
    public volatile int rto;

    private IPConnStrategy(String str, int i10, ConnProtocol connProtocol, int i11, int i12, int i13, int i14) {
        this.ip = str;
        this.port = i10;
        this.protocol = connProtocol;
        this.cto = i11;
        this.rto = i12;
        this.retry = i13;
        this.heartbeat = i14;
    }

    public static IPConnStrategy a(String str, l.a aVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(aVar);
        if (valueOf == null) {
            return null;
        }
        return a(str, aVar.f3951a, valueOf, aVar.f3953c, aVar.f3954d, aVar.f3955e, aVar.f3956f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IPConnStrategy)) {
            return false;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) obj;
        if (this.port != iPConnStrategy.port || !this.ip.equals(iPConnStrategy.ip) || !this.protocol.equals(iPConnStrategy.protocol)) {
            return false;
        }
        return true;
    }

    public int getConnectionTimeout() {
        return this.cto;
    }

    public int getHeartbeat() {
        return this.heartbeat;
    }

    public String getIp() {
        return this.ip;
    }

    public int getIpSource() {
        return this.f3882b;
    }

    public int getIpType() {
        return this.f3881a;
    }

    public int getPort() {
        return this.port;
    }

    public ConnProtocol getProtocol() {
        return this.protocol;
    }

    public int getReadTimeout() {
        return this.rto;
    }

    public int getRetryTimes() {
        return this.retry;
    }

    public int getUniqueId() {
        return hashCode();
    }

    public int hashCode() {
        return ((((527 + this.ip.hashCode()) * 31) + this.port) * 31) + this.protocol.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        sb.append(this.ip);
        if (this.f3881a == 0) {
            sb.append("(*)");
        }
        sb.append(' ');
        sb.append(this.port);
        sb.append(' ');
        sb.append(this.protocol);
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb.toString();
    }

    public static IPConnStrategy a(String str, int i10, ConnProtocol connProtocol, int i11, int i12, int i13, int i14) {
        if (TextUtils.isEmpty(str) || connProtocol == null || i10 <= 0) {
            return null;
        }
        return new IPConnStrategy(str, i10, connProtocol, i11, i12, i13, i14);
    }
}
