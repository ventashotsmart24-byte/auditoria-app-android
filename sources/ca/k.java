package ca;

import androidx.concurrent.futures.b;
import ca.f1;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import h9.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k9.f;
import kotlin.coroutines.Continuation;
import m9.d;
import s9.l;
import t9.g;

public class k extends l0 implements j, d {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f11505g;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11506h;
    private volatile /* synthetic */ int _decision = 0;
    private volatile /* synthetic */ Object _state = d.f11486a;

    /* renamed from: d  reason: collision with root package name */
    public final Continuation f11507d;

    /* renamed from: e  reason: collision with root package name */
    public final f f11508e;

    /* renamed from: f  reason: collision with root package name */
    public o0 f11509f;

    static {
        Class<k> cls = k.class;
        f11505g = AtomicIntegerFieldUpdater.newUpdater(cls, "_decision");
        f11506h = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_state");
    }

    public k(Continuation continuation, int i10) {
        super(i10);
        this.f11507d = continuation;
        this.f11508e = continuation.getContext();
    }

    public static /* synthetic */ void C(k kVar, Object obj, int i10, l lVar, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 4) != 0) {
                lVar = null;
            }
            kVar.B(obj, i10, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    public final void A() {
        kotlinx.coroutines.internal.f fVar;
        Throwable m10;
        Continuation continuation = this.f11507d;
        if (continuation instanceof kotlinx.coroutines.internal.f) {
            fVar = (kotlinx.coroutines.internal.f) continuation;
        } else {
            fVar = null;
        }
        if (fVar != null && (m10 = fVar.m(this)) != null) {
            n();
            l(m10);
        }
    }

    public final void B(Object obj, int i10, l lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof s1) {
            } else {
                if (obj2 instanceof l) {
                    l lVar2 = (l) obj2;
                    if (lVar2.c()) {
                        if (lVar != null) {
                            k(lVar, lVar2.f11549a);
                            return;
                        }
                        return;
                    }
                }
                h(obj);
                throw new c();
            }
        } while (!b.a(f11506h, this, obj2, D((s1) obj2, obj, i10, lVar, (Object) null)));
        o();
        p(i10);
    }

    public final Object D(s1 s1Var, Object obj, int i10, l lVar, Object obj2) {
        h hVar;
        if (obj instanceof s) {
            return obj;
        }
        if (!m0.b(i10) && obj2 == null) {
            return obj;
        }
        if (lVar == null && !(s1Var instanceof h) && obj2 == null) {
            return obj;
        }
        if (s1Var instanceof h) {
            hVar = (h) s1Var;
        } else {
            hVar = null;
        }
        return new r(obj, hVar, lVar, obj2, (Throwable) null, 16, (g) null);
    }

    public final boolean E() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f11505g.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean F() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f11505g.compareAndSet(this, 0, 1));
        return true;
    }

    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof s1) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof s)) {
                if (obj2 instanceof r) {
                    r rVar = (r) obj2;
                    if (!rVar.c()) {
                        if (b.a(f11506h, this, obj2, r.b(rVar, (Object) null, (h) null, (l) null, (Object) null, th, 15, (Object) null))) {
                            rVar.d(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (b.a(f11506h, this, obj2, new r(obj2, (h) null, (l) null, (Object) null, th, 14, (g) null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final Continuation b() {
        return this.f11507d;
    }

    public Throwable c(Object obj) {
        Throwable c10 = super.c(obj);
        if (c10 != null) {
            return c10;
        }
        return null;
    }

    public Object d(Object obj) {
        if (obj instanceof r) {
            return ((r) obj).f11540a;
        }
        return obj;
    }

    public Object f() {
        return s();
    }

    public void g(l lVar) {
        h w10 = w(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (b.a(f11506h, this, obj, w10)) {
                    return;
                }
            } else if (obj instanceof h) {
                x(lVar, obj);
            } else {
                boolean z10 = obj instanceof s;
                if (z10) {
                    s sVar = (s) obj;
                    if (!sVar.b()) {
                        x(lVar, obj);
                    }
                    if (obj instanceof l) {
                        Throwable th = null;
                        if (!z10) {
                            sVar = null;
                        }
                        if (sVar != null) {
                            th = sVar.f11549a;
                        }
                        j(lVar, th);
                        return;
                    }
                    return;
                } else if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (rVar.f11541b != null) {
                        x(lVar, obj);
                    }
                    if (rVar.c()) {
                        j(lVar, rVar.f11544e);
                        return;
                    }
                    if (b.a(f11506h, this, obj, r.b(rVar, (Object) null, w10, (l) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                        return;
                    }
                } else {
                    if (b.a(f11506h, this, obj, new r(obj, w10, (l) null, (Object) null, (Throwable) null, 28, (g) null))) {
                        return;
                    }
                }
            }
        }
    }

    public d getCallerFrame() {
        Continuation continuation = this.f11507d;
        if (continuation instanceof d) {
            return (d) continuation;
        }
        return null;
    }

    public f getContext() {
        return this.f11508e;
    }

    public final Void h(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void i(h hVar, Throwable th) {
        try {
            hVar.b(th);
        } catch (Throwable th2) {
            f context = getContext();
            b0.a(context, new v("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void j(l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            f context = getContext();
            b0.a(context, new v("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            f context = getContext();
            b0.a(context, new v("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean l(Throwable th) {
        Object obj;
        boolean z10;
        h hVar;
        do {
            obj = this._state;
            if (!(obj instanceof s1)) {
                return false;
            }
            z10 = obj instanceof h;
        } while (!b.a(f11506h, this, obj, new l(this, th, z10)));
        if (z10) {
            hVar = (h) obj;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            i(hVar, th);
        }
        o();
        p(this.f11512c);
        return true;
    }

    public final boolean m(Throwable th) {
        if (!v()) {
            return false;
        }
        return ((kotlinx.coroutines.internal.f) this.f11507d).k(th);
    }

    public final void n() {
        o0 o0Var = this.f11509f;
        if (o0Var != null) {
            o0Var.dispose();
            this.f11509f = r1.f11547a;
        }
    }

    public final void o() {
        if (!v()) {
            n();
        }
    }

    public final void p(int i10) {
        if (!E()) {
            m0.a(this, i10);
        }
    }

    public Throwable q(f1 f1Var) {
        return f1Var.f();
    }

    public final Object r() {
        f1 f1Var;
        boolean v10 = v();
        if (F()) {
            if (this.f11509f == null) {
                u();
            }
            if (v10) {
                A();
            }
            return l9.c.c();
        }
        if (v10) {
            A();
        }
        Object s10 = s();
        if (s10 instanceof s) {
            throw ((s) s10).f11549a;
        } else if (!m0.b(this.f11512c) || (f1Var = (f1) getContext().a(f1.f11497a0)) == null || f1Var.isActive()) {
            return d(s10);
        } else {
            CancellationException f10 = f1Var.f();
            a(s10, f10);
            throw f10;
        }
    }

    public void resumeWith(Object obj) {
        C(this, w.a(obj, this), this.f11512c, (l) null, 4, (Object) null);
    }

    public final Object s() {
        return this._state;
    }

    public final String t() {
        Object s10 = s();
        if (s10 instanceof s1) {
            return "Active";
        }
        if (s10 instanceof l) {
            return "Cancelled";
        }
        return "Completed";
    }

    public String toString() {
        return y() + ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + g0.c(this.f11507d) + "){" + t() + "}@" + g0.b(this);
    }

    public final o0 u() {
        f1 f1Var = (f1) getContext().a(f1.f11497a0);
        if (f1Var == null) {
            return null;
        }
        o0 d10 = f1.a.d(f1Var, true, false, new m(this), 2, (Object) null);
        this.f11509f = d10;
        return d10;
    }

    public final boolean v() {
        if (!m0.c(this.f11512c) || !((kotlinx.coroutines.internal.f) this.f11507d).j()) {
            return false;
        }
        return true;
    }

    public final h w(l lVar) {
        if (lVar instanceof h) {
            return (h) lVar;
        }
        return new c1(lVar);
    }

    public final void x(l lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final void z(Throwable th) {
        if (!m(th)) {
            l(th);
            o();
        }
    }
}
