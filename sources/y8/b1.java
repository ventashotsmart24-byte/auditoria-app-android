package y8;

import com.google.common.base.MoreObjects;

public abstract class b1 extends g {
    public void a(String str, Throwable th) {
        f().a(str, th);
    }

    public void b() {
        f().b();
    }

    public void c(int i10) {
        f().c(i10);
    }

    public abstract g f();

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) f()).toString();
    }
}
