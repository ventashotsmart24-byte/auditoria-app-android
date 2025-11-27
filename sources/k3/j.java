package k3;

import c4.n;
import c4.o;
import d4.h;
import i3.a;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

public abstract class j extends a implements Serializable, Type {

    /* renamed from: a  reason: collision with root package name */
    public final Class f7409a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7410b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f7411c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f7412d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f7413e;

    public j(Class cls, int i10, Object obj, Object obj2, boolean z10) {
        this.f7409a = cls;
        this.f7410b = cls.getName().hashCode() + i10;
        this.f7411c = obj;
        this.f7412d = obj2;
        this.f7413e = z10;
    }

    public boolean A() {
        return false;
    }

    public boolean B() {
        return false;
    }

    public boolean C() {
        if ((this.f7409a.getModifiers() & 1536) == 0) {
            return true;
        }
        return this.f7409a.isPrimitive();
    }

    public abstract boolean D();

    public final boolean E() {
        if (!h.L(this.f7409a) || this.f7409a == Enum.class) {
            return false;
        }
        return true;
    }

    public final boolean F() {
        return h.L(this.f7409a);
    }

    public final boolean G() {
        return Modifier.isFinal(this.f7409a.getModifiers());
    }

    public final boolean H() {
        return this.f7409a.isInterface();
    }

    public final boolean I() {
        if (this.f7409a == Object.class) {
            return true;
        }
        return false;
    }

    public boolean J() {
        return false;
    }

    public final boolean K() {
        return this.f7409a.isPrimitive();
    }

    public final boolean L() {
        return h.T(this.f7409a);
    }

    public boolean M() {
        return Throwable.class.isAssignableFrom(this.f7409a);
    }

    public final boolean N(Class cls) {
        Class cls2 = this.f7409a;
        if (cls2 == cls || cls.isAssignableFrom(cls2)) {
            return true;
        }
        return false;
    }

    public final boolean O(Class cls) {
        Class cls2 = this.f7409a;
        if (cls2 == cls || cls2.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public abstract j P(Class cls, n nVar, j jVar, j[] jVarArr);

    public final boolean Q() {
        return this.f7413e;
    }

    public abstract j R(j jVar);

    public abstract j S(Object obj);

    public abstract j T(Object obj);

    public j U(j jVar) {
        j jVar2;
        Object t10 = jVar.t();
        if (t10 != this.f7412d) {
            jVar2 = W(t10);
        } else {
            jVar2 = this;
        }
        Object u10 = jVar.u();
        if (u10 != this.f7411c) {
            return jVar2.X(u10);
        }
        return jVar2;
    }

    public abstract j V();

    public abstract j W(Object obj);

    public abstract j X(Object obj);

    public abstract boolean equals(Object obj);

    public abstract j f(int i10);

    public abstract int g();

    public j h(int i10) {
        j f10 = f(i10);
        if (f10 == null) {
            return o.O();
        }
        return f10;
    }

    public final int hashCode() {
        return this.f7410b;
    }

    public abstract j i(Class cls);

    public abstract n j();

    public j k() {
        return null;
    }

    public abstract StringBuilder l(StringBuilder sb);

    public String m() {
        StringBuilder sb = new StringBuilder(40);
        n(sb);
        return sb.toString();
    }

    public abstract StringBuilder n(StringBuilder sb);

    public abstract List o();

    public j p() {
        return null;
    }

    public final Class q() {
        return this.f7409a;
    }

    /* renamed from: r */
    public j a() {
        return null;
    }

    public abstract j s();

    public Object t() {
        return this.f7412d;
    }

    public abstract String toString();

    public Object u() {
        return this.f7411c;
    }

    public boolean v() {
        return true;
    }

    public boolean w() {
        if (g() > 0) {
            return true;
        }
        return false;
    }

    public boolean x() {
        if (this.f7412d == null && this.f7411c == null) {
            return false;
        }
        return true;
    }

    public final boolean y(Class cls) {
        if (this.f7409a == cls) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return Modifier.isAbstract(this.f7409a.getModifiers());
    }
}
