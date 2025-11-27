package aa;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import t9.i;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f10899a;

    public a(b bVar) {
        i.g(bVar, "sequence");
        this.f10899a = new AtomicReference(bVar);
    }

    public Iterator iterator() {
        b bVar = (b) this.f10899a.getAndSet((Object) null);
        if (bVar != null) {
            return bVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
