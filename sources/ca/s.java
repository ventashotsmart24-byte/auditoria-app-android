package ca;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import t9.g;

public class s {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f11548b = AtomicIntegerFieldUpdater.newUpdater(s.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f11549a;

    public s(Throwable th, boolean z10) {
        this.f11549a = th;
        this._handled = z10 ? 1 : 0;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f11548b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return g0.a(this) + '[' + this.f11549a + ']';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(Throwable th, boolean z10, int i10, g gVar) {
        this(th, (i10 & 2) != 0 ? false : z10);
    }
}
