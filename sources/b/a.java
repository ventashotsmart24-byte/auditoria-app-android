package b;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Set f4028a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f4029b;

    public void a(b bVar) {
        if (this.f4029b != null) {
            bVar.a(this.f4029b);
        }
        this.f4028a.add(bVar);
    }

    public void b() {
        this.f4029b = null;
    }

    public void c(Context context) {
        this.f4029b = context;
        for (b a10 : this.f4028a) {
            a10.a(context);
        }
    }

    public Context d() {
        return this.f4029b;
    }

    public void e(b bVar) {
        this.f4028a.remove(bVar);
    }
}
