package q0;

import java.util.concurrent.atomic.AtomicBoolean;
import t0.f;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f8922a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final e f8923b;

    /* renamed from: c  reason: collision with root package name */
    public volatile f f8924c;

    public k(e eVar) {
        this.f8923b = eVar;
    }

    public f a() {
        b();
        return e(this.f8922a.compareAndSet(false, true));
    }

    public void b() {
        this.f8923b.a();
    }

    public final f c() {
        return this.f8923b.d(d());
    }

    public abstract String d();

    public final f e(boolean z10) {
        if (!z10) {
            return c();
        }
        if (this.f8924c == null) {
            this.f8924c = c();
        }
        return this.f8924c;
    }

    public void f(f fVar) {
        if (fVar == this.f8924c) {
            this.f8922a.set(false);
        }
    }
}
