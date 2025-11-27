package z8;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import y8.c;
import y8.o0;
import y8.v0;
import y8.w0;

public final class r1 extends o0.f {

    /* renamed from: a  reason: collision with root package name */
    public final c f20949a;

    /* renamed from: b  reason: collision with root package name */
    public final v0 f20950b;

    /* renamed from: c  reason: collision with root package name */
    public final w0 f20951c;

    public r1(w0 w0Var, v0 v0Var, c cVar) {
        this.f20951c = (w0) Preconditions.checkNotNull(w0Var, FirebaseAnalytics.Param.METHOD);
        this.f20950b = (v0) Preconditions.checkNotNull(v0Var, "headers");
        this.f20949a = (c) Preconditions.checkNotNull(cVar, "callOptions");
    }

    public c a() {
        return this.f20949a;
    }

    public v0 b() {
        return this.f20950b;
    }

    public w0 c() {
        return this.f20951c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r1.class != obj.getClass()) {
            return false;
        }
        r1 r1Var = (r1) obj;
        if (!Objects.equal(this.f20949a, r1Var.f20949a) || !Objects.equal(this.f20950b, r1Var.f20950b) || !Objects.equal(this.f20951c, r1Var.f20951c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f20949a, this.f20950b, this.f20951c);
    }

    public final String toString() {
        return "[method=" + this.f20951c + " headers=" + this.f20950b + " callOptions=" + this.f20949a + "]";
    }
}
