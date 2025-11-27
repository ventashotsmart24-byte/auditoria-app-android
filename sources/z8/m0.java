package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import y8.y0;

public abstract class m0 extends y0 {

    /* renamed from: a  reason: collision with root package name */
    public final y0 f20776a;

    public m0(y0 y0Var) {
        Preconditions.checkNotNull(y0Var, "delegate can not be null");
        this.f20776a = y0Var;
    }

    public void b() {
        this.f20776a.b();
    }

    public void c() {
        this.f20776a.c();
    }

    public void d(y0.d dVar) {
        this.f20776a.d(dVar);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) this.f20776a).toString();
    }
}
