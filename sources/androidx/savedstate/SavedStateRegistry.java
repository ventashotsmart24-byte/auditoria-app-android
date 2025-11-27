package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.savedstate.Recreator;
import i.b;
import java.util.Map;

public final class SavedStateRegistry {

    /* renamed from: a  reason: collision with root package name */
    public i.b f3079a = new i.b();

    /* renamed from: b  reason: collision with root package name */
    public Bundle f3080b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3081c;

    /* renamed from: d  reason: collision with root package name */
    public Recreator.a f3082d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3083e = true;

    public interface a {
        void a(b bVar);
    }

    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.f3081c) {
            Bundle bundle = this.f3080b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f3080b.remove(str);
            if (this.f3080b.isEmpty()) {
                this.f3080b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void b(d dVar, Bundle bundle) {
        if (!this.f3081c) {
            if (bundle != null) {
                this.f3080b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            dVar.a(new e() {
                public void a(g gVar, d.b bVar) {
                    if (bVar == d.b.ON_START) {
                        SavedStateRegistry.this.f3083e = true;
                    } else if (bVar == d.b.ON_STOP) {
                        SavedStateRegistry.this.f3083e = false;
                    }
                }
            });
            this.f3081c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f3080b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b.d c10 = this.f3079a.c();
        while (c10.hasNext()) {
            Map.Entry entry = (Map.Entry) c10.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (((b) this.f3079a.f(str, bVar)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class cls) {
        if (this.f3083e) {
            if (this.f3082d == null) {
                this.f3082d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f3082d.b(cls.getName());
            } catch (NoSuchMethodException e10) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
