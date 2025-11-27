package ca;

import k9.f;
import kotlin.coroutines.Continuation;
import s9.l;
import s9.p;

public abstract class a extends m1 implements Continuation, c0 {

    /* renamed from: b  reason: collision with root package name */
    public final f f11481b;

    public a(f fVar, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            R((f1) fVar.a(f1.f11497a0));
        }
        this.f11481b = fVar.s(this);
    }

    public final void Q(Throwable th) {
        b0.a(this.f11481b, th);
    }

    public String X() {
        String b10 = x.b(this.f11481b);
        if (b10 == null) {
            return super.X();
        }
        return '\"' + b10 + "\":" + super.X();
    }

    public final void c0(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            t0(sVar.f11549a, sVar.a());
            return;
        }
        u0(obj);
    }

    public f d() {
        return this.f11481b;
    }

    public final f getContext() {
        return this.f11481b;
    }

    public boolean isActive() {
        return super.isActive();
    }

    public final void resumeWith(Object obj) {
        Object V = V(w.c(obj, (l) null, 1, (Object) null));
        if (V != n1.f11528b) {
            s0(V);
        }
    }

    public void s0(Object obj) {
        l(obj);
    }

    public void t0(Throwable th, boolean z10) {
    }

    public void u0(Object obj) {
    }

    public final void v0(e0 e0Var, Object obj, p pVar) {
        e0Var.b(pVar, obj, this);
    }

    public String w() {
        return g0.a(this) + " was cancelled";
    }
}
