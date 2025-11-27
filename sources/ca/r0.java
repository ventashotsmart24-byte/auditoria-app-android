package ca;

import androidx.appcompat.app.m;
import androidx.concurrent.futures.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k9.f;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.p;

public abstract class r0 extends s0 implements j0 {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11545f;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11546g;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;
    private volatile /* synthetic */ Object _queue = null;

    public static final class a extends d0 {
    }

    static {
        Class<r0> cls = r0.class;
        Class<Object> cls2 = Object.class;
        f11545f = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue");
        f11546g = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    private final boolean d0() {
        return this._isCompleted;
    }

    public final void L(f fVar, Runnable runnable) {
        b0(runnable);
    }

    public long R() {
        if (super.R() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof p) {
                if (!((p) obj).g()) {
                    return 0;
                }
            } else if (obj == u0.f11553b) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        a aVar = (a) this._delayed;
        if (aVar != null) {
            aVar.c();
        }
        return Long.MAX_VALUE;
    }

    public final void Z() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (b.a(f11545f, this, (Object) null, u0.f11553b)) {
                    return;
                }
            } else if (obj instanceof p) {
                ((p) obj).d();
                return;
            } else if (obj != u0.f11553b) {
                p pVar = new p(8, true);
                pVar.a((Runnable) obj);
                if (b.a(f11545f, this, obj, pVar)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final Runnable a0() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof p) {
                p pVar = (p) obj;
                Object j10 = pVar.j();
                if (j10 != p.f18289h) {
                    return (Runnable) j10;
                }
                b.a(f11545f, this, obj, pVar.i());
            } else if (obj == u0.f11553b) {
                return null;
            } else {
                if (b.a(f11545f, this, obj, (Object) null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    public void b0(Runnable runnable) {
        if (c0(runnable)) {
            Y();
        } else {
            h0.f11500h.b0(runnable);
        }
    }

    public final boolean c0(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (d0()) {
                return false;
            }
            if (obj == null) {
                if (b.a(f11545f, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof p) {
                p pVar = (p) obj;
                int a10 = pVar.a(runnable);
                if (a10 == 0) {
                    return true;
                }
                if (a10 == 1) {
                    b.a(f11545f, this, obj, pVar.i());
                } else if (a10 == 2) {
                    return false;
                }
            } else if (obj == u0.f11553b) {
                return false;
            } else {
                p pVar2 = new p(8, true);
                pVar2.a((Runnable) obj);
                pVar2.a(runnable);
                if (b.a(f11545f, this, obj, pVar2)) {
                    return true;
                }
            }
        }
    }

    public boolean e0() {
        if (!V()) {
            return false;
        }
        a aVar = (a) this._delayed;
        if (aVar != null && !aVar.b()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof p) {
                return ((p) obj).g();
            }
            if (obj == u0.f11553b) {
                return true;
            }
            return false;
        }
        return true;
    }

    public long f0() {
        if (W()) {
            return 0;
        }
        a aVar = (a) this._delayed;
        if (aVar != null && !aVar.b()) {
            c.a();
            System.nanoTime();
            synchronized (aVar) {
                aVar.a();
            }
            m.a((Object) null);
        }
        Runnable a02 = a0();
        if (a02 == null) {
            return R();
        }
        a02.run();
        return 0;
    }

    public final void g0() {
        c.a();
        System.nanoTime();
        a aVar = (a) this._delayed;
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void h0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void i0(boolean z10) {
        this._isCompleted = z10 ? 1 : 0;
    }

    public void shutdown() {
        w1.f11556a.b();
        i0(true);
        Z();
        do {
        } while (f0() <= 0);
        g0();
    }
}
