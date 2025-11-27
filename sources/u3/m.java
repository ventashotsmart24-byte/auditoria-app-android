package u3;

import com.google.android.gms.common.Scopes;
import org.android.agoo.common.AgooConstants;

public enum m {
    COLOR("color"),
    DATE("date"),
    DATE_TIME("date-time"),
    EMAIL(Scopes.EMAIL),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE("phone"),
    REGEX("regex"),
    STYLE("style"),
    TIME(AgooConstants.MESSAGE_TIME),
    URI("uri"),
    UTC_MILLISEC("utc-millisec"),
    UUID("uuid");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f9463a;

    /* access modifiers changed from: public */
    m(String str) {
        this.f9463a = str;
    }

    public String toString() {
        return this.f9463a;
    }
}
