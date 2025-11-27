package kotlinx.coroutines.internal;

import androidx.concurrent.futures.b;
import ca.g0;
import ca.j;
import ca.k;
import ca.l0;
import ca.q0;
import ca.t;
import ca.w;
import ca.w1;
import ca.y;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import m9.d;
import s9.l;
import t9.i;

public final class f extends l0 implements d, Continuation {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18260h = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation = null;

    /* renamed from: d  reason: collision with root package name */
    public final y f18261d;

    /* renamed from: e  reason: collision with root package name */
    public final Continuation f18262e;

    /* renamed from: f  reason: collision with root package name */
    public Object f18263f = g.f18269a;

    /* renamed from: g  reason: collision with root package name */
    public final Object f18264g = c0.b(getContext());

    public f(y yVar, Continuation continuation) {
        super(-1);
        this.f18261d = yVar;
        this.f18262e = continuation;
    }

    public void a(Object obj, Throwable th) {
        if (obj instanceof t) {
            ((t) obj).f11551b.invoke(th);
        }
    }

    public Continuation b() {
        return this;
    }

    public Object f() {
        Object obj = this.f18263f;
        this.f18263f = g.f18269a;
        return obj;
    }

    public d getCallerFrame() {
        Continuation continuation = this.f18262e;
        if (continuation instanceof d) {
            return (d) continuation;
        }
        return null;
    }

    public k9.f getContext() {
        return this.f18262e.getContext();
    }

    public final void h() {
        do {
        } while (this._reusableCancellableContinuation == g.f18270b);
    }

    public final k i() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof k) {
            return (k) obj;
        }
        return null;
    }

    public final boolean j() {
        if (this._reusableCancellableContinuation != null) {
            return true;
        }
        return false;
    }

    public final boolean k(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            y yVar = g.f18270b;
            if (i.b(obj, yVar)) {
                if (b.a(f18260h, this, yVar, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (b.a(f18260h, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final void l() {
        h();
        k i10 = i();
        if (i10 != null) {
            i10.n();
        }
    }

    public final Throwable m(j jVar) {
        y yVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            yVar = g.f18270b;
            if (obj != yVar) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (b.a(f18260h, this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!b.a(f18260h, this, yVar, jVar));
        return null;
    }

    public void resumeWith(Object obj) {
        k9.f context;
        Object c10;
        k9.f context2 = this.f18262e.getContext();
        Object c11 = w.c(obj, (l) null, 1, (Object) null);
        if (this.f18261d.M(context2)) {
            this.f18263f = c11;
            this.f11512c = 0;
            this.f18261d.L(context2, this);
            return;
        }
        q0 a10 = w1.f11556a.a();
        if (a10.U()) {
            this.f18263f = c11;
            this.f11512c = 0;
            a10.Q(this);
            return;
        }
        a10.S(true);
        try {
            context = getContext();
            c10 = c0.c(context, this.f18264g);
            this.f18262e.resumeWith(obj);
            h9.t tVar = h9.t.f17319a;
            c0.a(context, c10);
            do {
            } while (a10.W());
        } catch (Throwable th) {
            try {
                e(th, (Throwable) null);
            } catch (Throwable th2) {
                a10.O(true);
                throw th2;
            }
        }
        a10.O(true);
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f18261d + ", " + g0.c(this.f18262e) + ']';
    }
}
