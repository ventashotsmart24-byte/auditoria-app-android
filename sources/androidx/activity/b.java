package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f504a;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList f505b = new CopyOnWriteArrayList();

    public b(boolean z10) {
        this.f504a = z10;
    }

    public void a(a aVar) {
        this.f505b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f504a;
    }

    public final void d() {
        Iterator it = this.f505b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).cancel();
        }
    }

    public void e(a aVar) {
        this.f505b.remove(aVar);
    }

    public final void f(boolean z10) {
        this.f504a = z10;
    }
}
