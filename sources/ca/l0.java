package ca;

import h9.a;
import h9.l;
import h9.m;
import h9.t;
import java.util.concurrent.CancellationException;
import k9.f;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.scheduling.h;
import t9.i;

public abstract class l0 extends h {

    /* renamed from: c  reason: collision with root package name */
    public int f11512c;

    public l0(int i10) {
        this.f11512c = i10;
    }

    public abstract void a(Object obj, Throwable th);

    public abstract Continuation b();

    public Throwable c(Object obj) {
        s sVar;
        if (obj instanceof s) {
            sVar = (s) obj;
        } else {
            sVar = null;
        }
        if (sVar != null) {
            return sVar.f11549a;
        }
        return null;
    }

    public Object d(Object obj) {
        return obj;
    }

    public final void e(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                a.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            i.d(th);
            b0.a(b().getContext(), new f0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object f();

    public final void run() {
        Object obj;
        f context;
        Object c10;
        f1 f1Var;
        Object obj2;
        kotlinx.coroutines.scheduling.i iVar = this.f18340b;
        try {
            kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) b();
            Continuation continuation = fVar.f18262e;
            Object obj3 = fVar.f18264g;
            context = continuation.getContext();
            c10 = c0.c(context, obj3);
            if (c10 != c0.f18251a) {
                x.f(continuation, context, c10);
            }
            f context2 = continuation.getContext();
            Object f10 = f();
            Throwable c11 = c(f10);
            if (c11 != null || !m0.b(this.f11512c)) {
                f1Var = null;
            } else {
                f1Var = (f1) context2.a(f1.f11497a0);
            }
            if (f1Var != null && !f1Var.isActive()) {
                CancellationException f11 = f1Var.f();
                a(f10, f11);
                l.a aVar = l.f17317a;
                continuation.resumeWith(l.a(m.a(f11)));
            } else if (c11 != null) {
                l.a aVar2 = l.f17317a;
                continuation.resumeWith(l.a(m.a(c11)));
            } else {
                l.a aVar3 = l.f17317a;
                continuation.resumeWith(l.a(d(f10)));
            }
            t tVar = t.f17319a;
            c0.a(context, c10);
            try {
                iVar.a();
                obj2 = l.a(t.f17319a);
            } catch (Throwable th) {
                l.a aVar4 = l.f17317a;
                obj2 = l.a(m.a(th));
            }
            e((Throwable) null, l.b(obj2));
            return;
        } catch (Throwable th2) {
            l.a aVar5 = l.f17317a;
            obj = l.a(m.a(th2));
        }
        e(th, l.b(obj));
    }
}
