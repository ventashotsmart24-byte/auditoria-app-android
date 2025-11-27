package ca;

import t9.i;

public abstract class l1 extends u implements o0, a1 {

    /* renamed from: d  reason: collision with root package name */
    public m1 f11513d;

    public q1 c() {
        return null;
    }

    public void dispose() {
        r().g0(this);
    }

    public boolean isActive() {
        return true;
    }

    public final m1 r() {
        m1 m1Var = this.f11513d;
        if (m1Var != null) {
            return m1Var;
        }
        i.w("job");
        return null;
    }

    public final void s(m1 m1Var) {
        this.f11513d = m1Var;
    }

    public String toString() {
        return g0.a(this) + '@' + g0.b(this) + "[job@" + g0.b(r()) + ']';
    }
}
