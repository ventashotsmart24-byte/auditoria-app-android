package f9;

import com.google.common.base.MoreObjects;
import java.util.concurrent.ScheduledExecutorService;
import y8.f;
import y8.o0;
import y8.o1;

public abstract class b extends o0.d {
    public o0.h a(o0.b bVar) {
        return g().a(bVar);
    }

    public f b() {
        return g().b();
    }

    public ScheduledExecutorService c() {
        return g().c();
    }

    public o1 d() {
        return g().d();
    }

    public void e() {
        g().e();
    }

    public abstract o0.d g();

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) g()).toString();
    }
}
