package z3;

import c3.h;
import c3.n;
import k3.c0;

public class e extends v {

    /* renamed from: b  reason: collision with root package name */
    public static final e f9942b = new e(true);

    /* renamed from: c  reason: collision with root package name */
    public static final e f9943c = new e(false);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f9944a;

    public e(boolean z10) {
        this.f9944a = z10;
    }

    public static e v() {
        return f9943c;
    }

    public static e w() {
        return f9942b;
    }

    public n b() {
        if (this.f9944a) {
            return n.VALUE_TRUE;
        }
        return n.VALUE_FALSE;
    }

    public final void d(h hVar, c0 c0Var) {
        hVar.U(this.f9944a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof e) && this.f9944a == ((e) obj).f9944a) {
            return true;
        }
        return false;
    }

    public String g() {
        if (this.f9944a) {
            return "true";
        }
        return "false";
    }

    public int hashCode() {
        if (this.f9944a) {
            return 3;
        }
        return 1;
    }

    public m o() {
        return m.BOOLEAN;
    }
}
