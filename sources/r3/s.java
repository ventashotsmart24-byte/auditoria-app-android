package r3;

import b3.r;
import d4.r;
import java.util.Iterator;
import k3.b;
import k3.j;
import k3.w;
import k3.x;

public abstract class s implements r {

    /* renamed from: a  reason: collision with root package name */
    public static final r.b f9168a = r.b.c();

    public abstract boolean A();

    public abstract boolean B();

    public abstract boolean C();

    public boolean D() {
        return false;
    }

    public abstract x c();

    public boolean e() {
        if (q() != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (l() != null) {
            return true;
        }
        return false;
    }

    public abstract r.b g();

    public abstract w getMetadata();

    public abstract String getName();

    public b0 h() {
        return null;
    }

    public String i() {
        b.a j10 = j();
        if (j10 == null) {
            return null;
        }
        return j10.b();
    }

    public b.a j() {
        return null;
    }

    public Class[] k() {
        return null;
    }

    public i l() {
        j p10 = p();
        if (p10 == null) {
            return o();
        }
        return p10;
    }

    public abstract m m();

    public abstract Iterator n();

    public abstract g o();

    public abstract j p();

    public i q() {
        m m10 = m();
        if (m10 != null) {
            return m10;
        }
        j v10 = v();
        if (v10 == null) {
            return o();
        }
        return v10;
    }

    public i r() {
        j v10 = v();
        if (v10 == null) {
            return o();
        }
        return v10;
    }

    public abstract i s();

    public abstract j t();

    public abstract Class u();

    public abstract j v();

    public abstract x w();

    public abstract boolean x();

    public abstract boolean y();

    public abstract boolean z(x xVar);
}
