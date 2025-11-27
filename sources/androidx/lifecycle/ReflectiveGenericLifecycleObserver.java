package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.d;

class ReflectiveGenericLifecycleObserver implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2283a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f2284b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2283a = obj;
        this.f2284b = b.f2290c.c(obj.getClass());
    }

    public void a(g gVar, d.b bVar) {
        this.f2284b.a(gVar, bVar, this.f2283a);
    }
}
