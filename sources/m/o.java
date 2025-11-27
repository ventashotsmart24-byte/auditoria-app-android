package m;

import java.util.HashSet;
import java.util.Iterator;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public HashSet f7791a = new HashSet(2);

    /* renamed from: b  reason: collision with root package name */
    public int f7792b = 0;

    public void a(o oVar) {
        this.f7791a.add(oVar);
    }

    public void b() {
        this.f7792b = 1;
        Iterator it = this.f7791a.iterator();
        while (it.hasNext()) {
            ((o) it.next()).f();
        }
    }

    public void c() {
        this.f7792b = 0;
        Iterator it = this.f7791a.iterator();
        while (it.hasNext()) {
            ((o) it.next()).c();
        }
    }

    public boolean d() {
        if (this.f7792b == 1) {
            return true;
        }
        return false;
    }

    public void e() {
        this.f7792b = 0;
        this.f7791a.clear();
    }

    public void f() {
    }
}
