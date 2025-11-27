package f9;

import com.google.common.base.MoreObjects;
import y8.k1;
import y8.o0;

public abstract class a extends o0 {
    public boolean b() {
        return f().b();
    }

    public void c(k1 k1Var) {
        f().c(k1Var);
    }

    public void d(o0.g gVar) {
        f().d(gVar);
    }

    public abstract o0 f();

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) f()).toString();
    }
}
