package y8;

import com.google.common.base.Preconditions;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final p f20146a;

    /* renamed from: b  reason: collision with root package name */
    public final k1 f20147b;

    public q(p pVar, k1 k1Var) {
        this.f20146a = (p) Preconditions.checkNotNull(pVar, "state is null");
        this.f20147b = (k1) Preconditions.checkNotNull(k1Var, "status is null");
    }

    public static q a(p pVar) {
        boolean z10;
        if (pVar != p.TRANSIENT_FAILURE) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "state is TRANSIENT_ERROR. Use forError() instead");
        return new q(pVar, k1.f20041f);
    }

    public static q b(k1 k1Var) {
        Preconditions.checkArgument(!k1Var.p(), "The error status must not be OK");
        return new q(p.TRANSIENT_FAILURE, k1Var);
    }

    public p c() {
        return this.f20146a;
    }

    public k1 d() {
        return this.f20147b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (!this.f20146a.equals(qVar.f20146a) || !this.f20147b.equals(qVar.f20147b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f20146a.hashCode() ^ this.f20147b.hashCode();
    }

    public String toString() {
        if (this.f20147b.p()) {
            return this.f20146a.toString();
        }
        return this.f20146a + "(" + this.f20147b + ")";
    }
}
