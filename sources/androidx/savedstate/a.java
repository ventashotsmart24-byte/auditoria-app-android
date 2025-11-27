package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f3085a;

    /* renamed from: b  reason: collision with root package name */
    public final SavedStateRegistry f3086b = new SavedStateRegistry();

    public a(b bVar) {
        this.f3085a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public SavedStateRegistry b() {
        return this.f3086b;
    }

    public void c(Bundle bundle) {
        d lifecycle = this.f3085a.getLifecycle();
        if (lifecycle.b() == d.c.INITIALIZED) {
            lifecycle.a(new Recreator(this.f3085a));
            this.f3086b.b(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void d(Bundle bundle) {
        this.f3086b.c(bundle);
    }
}
