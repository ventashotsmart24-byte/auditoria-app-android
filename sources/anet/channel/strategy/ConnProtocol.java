package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ConnProtocol implements Serializable {
    public static final ConnProtocol HTTP = valueOf(HttpConstant.HTTP, (String) null, (String) null);
    public static final ConnProtocol HTTPS = valueOf("https", (String) null, (String) null);
    private static Map<String, ConnProtocol> protocolMap = new HashMap();
    private static final long serialVersionUID = -3523201990674557001L;
    final int isHttp;
    public final String name;
    public final String protocol;
    public final String publicKey;
    public final String rtt;

    private ConnProtocol(String str, String str2, String str3, String str4) {
        int i10;
        this.name = str;
        this.protocol = str2;
        this.rtt = str3;
        this.publicKey = str4;
        if (HttpConstant.HTTP.equalsIgnoreCase(str2) || "https".equalsIgnoreCase(str2)) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        this.isHttp = i10;
    }

    private static String buildName(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(18);
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append("_");
            sb.append(str2);
        } else {
            sb.append("_0rtt");
        }
        sb.append("_");
        sb.append(str3);
        return sb.toString();
    }

    public static ConnProtocol valueOf(l.a aVar) {
        if (aVar == null) {
            return null;
        }
        return valueOf(aVar.f3952b, aVar.f3957g, aVar.f3958h);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConnProtocol)) {
            return false;
        }
        return this.name.equals(((ConnProtocol) obj).name);
    }

    public int hashCode() {
        int hashCode = 527 + this.protocol.hashCode();
        String str = this.rtt;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        String str2 = this.publicKey;
        if (str2 != null) {
            return (hashCode * 31) + str2.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        return this.name;
    }

    @Deprecated
    public static ConnProtocol valueOf(String str, String str2, String str3, @Deprecated boolean z10) {
        return valueOf(str, str2, str3);
    }

    public static ConnProtocol valueOf(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String buildName = buildName(str, str2, str3);
        synchronized (protocolMap) {
            if (protocolMap.containsKey(buildName)) {
                ConnProtocol connProtocol = protocolMap.get(buildName);
                return connProtocol;
            }
            ConnProtocol connProtocol2 = new ConnProtocol(buildName, str, str2, str3);
            protocolMap.put(buildName, connProtocol2);
            return connProtocol2;
        }
    }
}
