package z8;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public abstract class v0 {

    /* renamed from: a  reason: collision with root package name */
    public final Set f20997a = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean a(Object... objArr) {
        for (Object contains : objArr) {
            if (this.f20997a.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public abstract void b();

    public abstract void c();

    public final boolean d() {
        return !this.f20997a.isEmpty();
    }

    public final void e(Object obj, boolean z10) {
        int size = this.f20997a.size();
        if (z10) {
            this.f20997a.add(obj);
            if (size == 0) {
                b();
            }
        } else if (this.f20997a.remove(obj) && size == 1) {
            c();
        }
    }
}
