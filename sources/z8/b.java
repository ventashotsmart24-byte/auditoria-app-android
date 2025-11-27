package z8;

import com.google.common.base.MoreObjects;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import y8.r0;
import y8.s0;

public abstract class b extends s0 {

    /* renamed from: a  reason: collision with root package name */
    public int f20334a = AutoStrategy.BITRATE_LOW;

    public r0 a() {
        return c().a();
    }

    public abstract s0 c();

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) c()).toString();
    }
}
