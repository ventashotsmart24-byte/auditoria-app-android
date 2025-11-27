package r3;

import d4.h;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import k3.j;

public class g0 extends i {

    /* renamed from: c  reason: collision with root package name */
    public final Class f9109c;

    /* renamed from: d  reason: collision with root package name */
    public final j f9110d;

    /* renamed from: e  reason: collision with root package name */
    public final String f9111e;

    public g0(f0 f0Var, Class cls, String str, j jVar) {
        super(f0Var, (p) null);
        this.f9109c = cls;
        this.f9110d = jVar;
        this.f9111e = str;
    }

    public String d() {
        return this.f9111e;
    }

    public Class e() {
        return this.f9110d.q();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!h.H(obj, getClass())) {
            return false;
        }
        g0 g0Var = (g0) obj;
        if (g0Var.f9109c != this.f9109c || !g0Var.f9111e.equals(this.f9111e)) {
            return false;
        }
        return true;
    }

    public j f() {
        return this.f9110d;
    }

    public int hashCode() {
        return this.f9111e.hashCode();
    }

    public Class k() {
        return this.f9109c;
    }

    public Member m() {
        return null;
    }

    public Object n(Object obj) {
        throw new IllegalArgumentException("Cannot get virtual property '" + this.f9111e + "'");
    }

    public void o(Object obj, Object obj2) {
        throw new IllegalArgumentException("Cannot set virtual property '" + this.f9111e + "'");
    }

    public b p(p pVar) {
        return this;
    }

    /* renamed from: q */
    public Field b() {
        return null;
    }

    public String toString() {
        return "[virtual " + l() + "]";
    }
}
