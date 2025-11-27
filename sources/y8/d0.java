package y8;

import com.google.android.gms.cast.MediaTrack;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f19980a;

    /* renamed from: b  reason: collision with root package name */
    public final b f19981b;

    /* renamed from: c  reason: collision with root package name */
    public final long f19982c;

    /* renamed from: d  reason: collision with root package name */
    public final m0 f19983d;

    /* renamed from: e  reason: collision with root package name */
    public final m0 f19984e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f19985a;

        /* renamed from: b  reason: collision with root package name */
        public b f19986b;

        /* renamed from: c  reason: collision with root package name */
        public Long f19987c;

        /* renamed from: d  reason: collision with root package name */
        public m0 f19988d;

        /* renamed from: e  reason: collision with root package name */
        public m0 f19989e;

        public d0 a() {
            boolean z10;
            Preconditions.checkNotNull(this.f19985a, MediaTrack.ROLE_DESCRIPTION);
            Preconditions.checkNotNull(this.f19986b, "severity");
            Preconditions.checkNotNull(this.f19987c, "timestampNanos");
            if (this.f19988d == null || this.f19989e == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "at least one of channelRef and subchannelRef must be null");
            return new d0(this.f19985a, this.f19986b, this.f19987c.longValue(), this.f19988d, this.f19989e);
        }

        public a b(String str) {
            this.f19985a = str;
            return this;
        }

        public a c(b bVar) {
            this.f19986b = bVar;
            return this;
        }

        public a d(m0 m0Var) {
            this.f19989e = m0Var;
            return this;
        }

        public a e(long j10) {
            this.f19987c = Long.valueOf(j10);
            return this;
        }
    }

    public enum b {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (!Objects.equal(this.f19980a, d0Var.f19980a) || !Objects.equal(this.f19981b, d0Var.f19981b) || this.f19982c != d0Var.f19982c || !Objects.equal(this.f19983d, d0Var.f19983d) || !Objects.equal(this.f19984e, d0Var.f19984e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f19980a, this.f19981b, Long.valueOf(this.f19982c), this.f19983d, this.f19984e);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add(MediaTrack.ROLE_DESCRIPTION, (Object) this.f19980a).add("severity", (Object) this.f19981b).add("timestampNanos", this.f19982c).add("channelRef", (Object) this.f19983d).add("subchannelRef", (Object) this.f19984e).toString();
    }

    public d0(String str, b bVar, long j10, m0 m0Var, m0 m0Var2) {
        this.f19980a = str;
        this.f19981b = (b) Preconditions.checkNotNull(bVar, "severity");
        this.f19982c = j10;
        this.f19983d = m0Var;
        this.f19984e = m0Var2;
    }
}
