package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.h;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.a;
import androidx.savedstate.b;

public class h0 implements b, y {

    /* renamed from: a  reason: collision with root package name */
    public final Fragment f2024a;

    /* renamed from: b  reason: collision with root package name */
    public final x f2025b;

    /* renamed from: c  reason: collision with root package name */
    public h f2026c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f2027d = null;

    public h0(Fragment fragment, x xVar) {
        this.f2024a = fragment;
        this.f2025b = xVar;
    }

    public void a(d.b bVar) {
        this.f2026c.h(bVar);
    }

    public void b() {
        if (this.f2026c == null) {
            this.f2026c = new h(this);
            this.f2027d = a.a(this);
        }
    }

    public boolean c() {
        if (this.f2026c != null) {
            return true;
        }
        return false;
    }

    public void d(Bundle bundle) {
        this.f2027d.c(bundle);
    }

    public void e(Bundle bundle) {
        this.f2027d.d(bundle);
    }

    public void f(d.c cVar) {
        this.f2026c.o(cVar);
    }

    public d getLifecycle() {
        b();
        return this.f2026c;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f2027d.b();
    }

    public x getViewModelStore() {
        b();
        return this.f2025b;
    }
}
