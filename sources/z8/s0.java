package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f20952a;

    /* renamed from: b  reason: collision with root package name */
    public final long f20953b;

    /* renamed from: c  reason: collision with root package name */
    public final Set f20954c;

    public s0(int i10, long j10, Set set) {
        this.f20952a = i10;
        this.f20953b = j10;
        this.f20954c = ImmutableSet.copyOf(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s0.class != obj.getClass()) {
            return false;
        }
        s0 s0Var = (s0) obj;
        if (this.f20952a == s0Var.f20952a && this.f20953b == s0Var.f20953b && Objects.equal(this.f20954c, s0Var.f20954c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20952a), Long.valueOf(this.f20953b), this.f20954c);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("maxAttempts", this.f20952a).add("hedgingDelayNanos", this.f20953b).add("nonFatalStatusCodes", (Object) this.f20954c).toString();
    }
}
