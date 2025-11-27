package ca;

import h9.t;
import s9.l;

public final class c1 extends h {

    /* renamed from: a  reason: collision with root package name */
    public final l f11485a;

    public c1(l lVar) {
        this.f11485a = lVar;
    }

    public void b(Throwable th) {
        this.f11485a.invoke(th);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        b((Throwable) obj);
        return t.f17319a;
    }

    public String toString() {
        return "InvokeOnCancel[" + g0.a(this.f11485a) + '@' + g0.b(this) + ']';
    }
}
