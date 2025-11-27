package f9;

import com.google.common.base.MoreObjects;
import java.util.List;
import y8.o0;

public abstract class c extends o0.h {
    public List b() {
        return i().b();
    }

    public Object d() {
        return i().d();
    }

    public void e() {
        i().e();
    }

    public void f() {
        i().f();
    }

    public void g(o0.j jVar) {
        i().g(jVar);
    }

    public abstract o0.h i();

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) i()).toString();
    }
}
