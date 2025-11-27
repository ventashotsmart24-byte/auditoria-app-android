package ca;

import h9.t;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import s9.l;

public final class d1 extends h1 {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f11487f = AtomicIntegerFieldUpdater.newUpdater(d1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: e  reason: collision with root package name */
    public final l f11488e;

    public d1(l lVar) {
        this.f11488e = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return t.f17319a;
    }

    public void q(Throwable th) {
        if (f11487f.compareAndSet(this, 0, 1)) {
            this.f11488e.invoke(th);
        }
    }
}
