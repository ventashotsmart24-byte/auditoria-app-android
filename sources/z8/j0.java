package z8;

import com.google.common.base.MoreObjects;
import java.util.concurrent.Executor;
import y8.c;
import y8.i0;
import y8.k;
import y8.k1;
import y8.v0;
import y8.w0;
import z8.j1;
import z8.s;

public abstract class j0 implements v {
    public abstract v a();

    public q b(w0 w0Var, v0 v0Var, c cVar, k[] kVarArr) {
        return a().b(w0Var, v0Var, cVar, kVarArr);
    }

    public void c(k1 k1Var) {
        a().c(k1Var);
    }

    public i0 d() {
        return a().d();
    }

    public Runnable e(j1.a aVar) {
        return a().e(aVar);
    }

    public void f(s.a aVar, Executor executor) {
        a().f(aVar, executor);
    }

    public void g(k1 k1Var) {
        a().g(k1Var);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) a()).toString();
    }
}
