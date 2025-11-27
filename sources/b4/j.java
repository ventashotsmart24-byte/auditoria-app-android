package b4;

import a4.c;
import b3.k0;
import b3.n0;
import r3.b0;

public class j extends n0 {

    /* renamed from: b  reason: collision with root package name */
    public final c f4347b;

    public j(b0 b0Var, c cVar) {
        this(b0Var.f(), cVar);
    }

    public boolean a(k0 k0Var) {
        if (k0Var.getClass() != getClass()) {
            return false;
        }
        j jVar = (j) k0Var;
        if (jVar.d() == this.f4282a && jVar.f4347b == this.f4347b) {
            return true;
        }
        return false;
    }

    public k0 b(Class cls) {
        if (cls == this.f4282a) {
            return this;
        }
        return new j(cls, this.f4347b);
    }

    public Object c(Object obj) {
        try {
            return this.f4347b.p(obj);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new IllegalStateException("Problem accessing property '" + this.f4347b.getName() + "': " + e11.getMessage(), e11);
        }
    }

    public k0.a f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new k0.a(getClass(), this.f4282a, obj);
    }

    public k0 h(Object obj) {
        return this;
    }

    public j(Class cls, c cVar) {
        super(cls);
        this.f4347b = cVar;
    }
}
