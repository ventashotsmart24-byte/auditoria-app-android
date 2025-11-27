package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public final class y1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f21180a;

    /* renamed from: b  reason: collision with root package name */
    public final long f21181b;

    /* renamed from: c  reason: collision with root package name */
    public final long f21182c;

    /* renamed from: d  reason: collision with root package name */
    public final double f21183d;

    /* renamed from: e  reason: collision with root package name */
    public final Long f21184e;

    /* renamed from: f  reason: collision with root package name */
    public final Set f21185f;

    public y1(int i10, long j10, long j11, double d10, Long l10, Set set) {
        this.f21180a = i10;
        this.f21181b = j10;
        this.f21182c = j11;
        this.f21183d = d10;
        this.f21184e = l10;
        this.f21185f = ImmutableSet.copyOf(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y1)) {
            return false;
        }
        y1 y1Var = (y1) obj;
        if (this.f21180a == y1Var.f21180a && this.f21181b == y1Var.f21181b && this.f21182c == y1Var.f21182c && Double.compare(this.f21183d, y1Var.f21183d) == 0 && Objects.equal(this.f21184e, y1Var.f21184e) && Objects.equal(this.f21185f, y1Var.f21185f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f21180a), Long.valueOf(this.f21181b), Long.valueOf(this.f21182c), Double.valueOf(this.f21183d), this.f21184e, this.f21185f);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("maxAttempts", this.f21180a).add("initialBackoffNanos", this.f21181b).add("maxBackoffNanos", this.f21182c).add("backoffMultiplier", this.f21183d).add("perAttemptRecvTimeoutNanos", (Object) this.f21184e).add("retryableStatusCodes", (Object) this.f21185f).toString();
    }
}
