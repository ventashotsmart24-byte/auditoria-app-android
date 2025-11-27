package n0;

import android.os.Bundle;

public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f7959a;

    /* renamed from: b  reason: collision with root package name */
    public s0 f7960b;

    public o0(s0 s0Var, boolean z10) {
        if (s0Var != null) {
            Bundle bundle = new Bundle();
            this.f7959a = bundle;
            this.f7960b = s0Var;
            bundle.putBundle("selector", s0Var.a());
            bundle.putBoolean("activeScan", z10);
            return;
        }
        throw new IllegalArgumentException("selector must not be null");
    }

    public Bundle a() {
        return this.f7959a;
    }

    public final void b() {
        if (this.f7960b == null) {
            s0 d10 = s0.d(this.f7959a.getBundle("selector"));
            this.f7960b = d10;
            if (d10 == null) {
                this.f7960b = s0.f8047c;
            }
        }
    }

    public s0 c() {
        b();
        return this.f7960b;
    }

    public boolean d() {
        return this.f7959a.getBoolean("activeScan");
    }

    public boolean e() {
        b();
        return this.f7960b.g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        if (!c().equals(o0Var.c()) || d() != o0Var.d()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return c().hashCode() ^ d() ? 1 : 0;
    }

    public String toString() {
        return "DiscoveryRequest{ selector=" + c() + ", activeScan=" + d() + ", isValid=" + e() + " }";
    }
}
