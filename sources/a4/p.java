package a4;

import b4.l;
import d4.a0;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import k3.c0;
import k3.j;
import k3.o;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f223a = new HashMap(64);

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference f224b = new AtomicReference();

    public final synchronized l a() {
        l lVar;
        lVar = (l) this.f224b.get();
        if (lVar == null) {
            lVar = l.b(this.f223a);
            this.f224b.set(lVar);
        }
        return lVar;
    }

    public void b(Class cls, j jVar, o oVar, c0 c0Var) {
        synchronized (this) {
            Object put = this.f223a.put(new a0(cls, false), oVar);
            Object put2 = this.f223a.put(new a0(jVar, false), oVar);
            if (put == null || put2 == null) {
                this.f224b.set((Object) null);
            }
            if (oVar instanceof o) {
                ((o) oVar).a(c0Var);
            }
        }
    }

    public void c(j jVar, o oVar, c0 c0Var) {
        synchronized (this) {
            if (this.f223a.put(new a0(jVar, false), oVar) == null) {
                this.f224b.set((Object) null);
            }
            if (oVar instanceof o) {
                ((o) oVar).a(c0Var);
            }
        }
    }

    public void d(Class cls, o oVar) {
        synchronized (this) {
            if (this.f223a.put(new a0(cls, true), oVar) == null) {
                this.f224b.set((Object) null);
            }
        }
    }

    public void e(j jVar, o oVar) {
        synchronized (this) {
            if (this.f223a.put(new a0(jVar, true), oVar) == null) {
                this.f224b.set((Object) null);
            }
        }
    }

    public l f() {
        l lVar = (l) this.f224b.get();
        if (lVar != null) {
            return lVar;
        }
        return a();
    }

    public o g(Class cls) {
        o oVar;
        synchronized (this) {
            oVar = (o) this.f223a.get(new a0(cls, true));
        }
        return oVar;
    }

    public o h(j jVar) {
        o oVar;
        synchronized (this) {
            oVar = (o) this.f223a.get(new a0(jVar, true));
        }
        return oVar;
    }

    public o i(Class cls) {
        o oVar;
        synchronized (this) {
            oVar = (o) this.f223a.get(new a0(cls, false));
        }
        return oVar;
    }

    public o j(j jVar) {
        o oVar;
        synchronized (this) {
            oVar = (o) this.f223a.get(new a0(jVar, false));
        }
        return oVar;
    }
}
