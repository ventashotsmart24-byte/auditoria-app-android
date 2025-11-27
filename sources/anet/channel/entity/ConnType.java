package anet.channel.entity;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.strategy.ConnProtocol;
import anet.channel.util.HttpConstant;
import com.uc.crashsdk.export.LogType;
import java.util.HashMap;
import java.util.Map;

public class ConnType {
    public static final String H2S = "h2s";
    public static ConnType HTTP = new ConnType(HttpConstant.HTTP);
    public static final String HTTP2 = "http2";
    public static final String HTTP3 = "http3";
    public static final String HTTP3_1RTT = "http3_1rtt";
    public static final String HTTP3_PLAIN = "http3plain";
    public static ConnType HTTPS = new ConnType("https");
    public static final String PK_ACS = "acs";
    public static final String PK_AUTO = "auto";
    public static final String PK_CDN = "cdn";
    public static final String PK_OPEN = "open";
    public static final String QUIC = "quic";
    public static final String QUIC_PLAIN = "quicplain";
    public static final String RTT_0 = "0rtt";
    public static final String RTT_1 = "1rtt";
    public static final String SPDY = "spdy";
    private static Map<ConnProtocol, ConnType> connTypeMap = new HashMap();
    private String name;
    private String publicKey;
    private int spdyProtocol;

    @Deprecated
    public enum TypeLevel {
        SPDY,
        HTTP
    }

    private ConnType(String str) {
        this.name = str;
    }

    public static int compare(ConnType connType, ConnType connType2) {
        return connType.getPriority() - connType2.getPriority();
    }

    private int getPriority() {
        int i10 = this.spdyProtocol;
        if ((i10 & 8) != 0) {
            return 0;
        }
        if ((i10 & 2) != 0) {
            return 1;
        }
        return 2;
    }

    public static ConnType valueOf(ConnProtocol connProtocol) {
        if (connProtocol == null) {
            return null;
        }
        if (HttpConstant.HTTP.equalsIgnoreCase(connProtocol.protocol)) {
            return HTTP;
        }
        if ("https".equalsIgnoreCase(connProtocol.protocol)) {
            return HTTPS;
        }
        synchronized (connTypeMap) {
            if (connTypeMap.containsKey(connProtocol)) {
                ConnType connType = connTypeMap.get(connProtocol);
                return connType;
            }
            ConnType connType2 = new ConnType(connProtocol.toString());
            connType2.publicKey = connProtocol.publicKey;
            if (HTTP2.equalsIgnoreCase(connProtocol.protocol)) {
                connType2.spdyProtocol |= 8;
            } else if (SPDY.equalsIgnoreCase(connProtocol.protocol)) {
                connType2.spdyProtocol |= 2;
            } else if (H2S.equals(connProtocol.protocol)) {
                connType2.spdyProtocol = 40;
            } else if (QUIC.equalsIgnoreCase(connProtocol.protocol)) {
                connType2.spdyProtocol = 12;
            } else if (QUIC_PLAIN.equalsIgnoreCase(connProtocol.protocol)) {
                connType2.spdyProtocol = 32780;
            } else if (HTTP3.equalsIgnoreCase(connProtocol.protocol)) {
                connType2.spdyProtocol = 256;
            } else if (HTTP3_1RTT.equalsIgnoreCase(connProtocol.protocol)) {
                connType2.spdyProtocol = LogType.UNEXP_EXIT;
            } else if (HTTP3_PLAIN.equalsIgnoreCase(connProtocol.protocol)) {
                connType2.spdyProtocol = 33024;
            }
            if (connType2.spdyProtocol == 0) {
                return null;
            }
            if (!TextUtils.isEmpty(connProtocol.publicKey)) {
                connType2.spdyProtocol |= 128;
                if (RTT_1.equalsIgnoreCase(connProtocol.rtt)) {
                    connType2.spdyProtocol |= 8192;
                } else if (!RTT_0.equalsIgnoreCase(connProtocol.rtt)) {
                    return null;
                } else {
                    connType2.spdyProtocol |= 4096;
                }
            }
            connTypeMap.put(connProtocol, connType2);
            return connType2;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ConnType)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.name.equals(((ConnType) obj).name);
    }

    public int getTnetConType() {
        return this.spdyProtocol;
    }

    public int getTnetPublicKey(boolean z10) {
        if (PK_CDN.equals(this.publicKey)) {
            return 1;
        }
        if (GlobalAppRuntimeInfo.getEnv() == ENV.TEST) {
            return 0;
        }
        if (PK_OPEN.equals(this.publicKey)) {
            if (z10) {
                return 11;
            }
            return 10;
        } else if (!PK_ACS.equals(this.publicKey)) {
            return -1;
        } else {
            if (z10) {
                return 4;
            }
            return 3;
        }
    }

    public int getType() {
        if (equals(HTTP) || equals(HTTPS)) {
            return c.f3710b;
        }
        return c.f3709a;
    }

    @Deprecated
    public TypeLevel getTypeLevel() {
        if (isHttpType()) {
            return TypeLevel.HTTP;
        }
        return TypeLevel.SPDY;
    }

    public boolean isH2S() {
        if (this.spdyProtocol == 40) {
            return true;
        }
        return false;
    }

    public boolean isHTTP3() {
        int i10 = this.spdyProtocol;
        if (i10 == 256 || i10 == 8448 || i10 == 33024) {
            return true;
        }
        return false;
    }

    public boolean isHttpType() {
        if (equals(HTTP) || equals(HTTPS)) {
            return true;
        }
        return false;
    }

    public boolean isPublicKeyAuto() {
        return PK_AUTO.equals(this.publicKey);
    }

    public boolean isQuic() {
        if ((this.spdyProtocol & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean isSSL() {
        int i10 = this.spdyProtocol;
        if ((i10 & 128) != 0 || (i10 & 32) != 0 || i10 == 12 || i10 == 256 || i10 == 8448 || equals(HTTPS)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.name;
    }
}
