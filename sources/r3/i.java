package r3;

import d4.h;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

public abstract class i extends b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final transient f0 f9124a;

    /* renamed from: b  reason: collision with root package name */
    public final transient p f9125b;

    public i(f0 f0Var, p pVar) {
        this.f9124a = f0Var;
        this.f9125b = pVar;
    }

    public final Annotation c(Class cls) {
        p pVar = this.f9125b;
        if (pVar == null) {
            return null;
        }
        return pVar.get(cls);
    }

    public final boolean g(Class cls) {
        p pVar = this.f9125b;
        if (pVar == null) {
            return false;
        }
        return pVar.a(cls);
    }

    public boolean h(Class[] clsArr) {
        p pVar = this.f9125b;
        if (pVar == null) {
            return false;
        }
        return pVar.b(clsArr);
    }

    public final void i(boolean z10) {
        Member m10 = m();
        if (m10 != null) {
            h.g(m10, z10);
        }
    }

    public p j() {
        return this.f9125b;
    }

    public abstract Class k();

    public String l() {
        return k().getName() + "#" + d();
    }

    public abstract Member m();

    public abstract Object n(Object obj);

    public abstract void o(Object obj, Object obj2);

    public abstract b p(p pVar);
}
