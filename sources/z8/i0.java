package z8;

import com.google.common.base.MoreObjects;
import y8.k1;
import y8.v0;
import z8.i2;
import z8.r;

public abstract class i0 implements r {
    public void a(i2.a aVar) {
        e().a(aVar);
    }

    public void b(v0 v0Var) {
        e().b(v0Var);
    }

    public void c(k1 k1Var, r.a aVar, v0 v0Var) {
        e().c(k1Var, aVar, v0Var);
    }

    public void d() {
        e().d();
    }

    public abstract r e();

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) e()).toString();
    }
}
