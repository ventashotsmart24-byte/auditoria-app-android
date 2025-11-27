package r3;

import d4.h;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import k3.j;

public final class g extends i {

    /* renamed from: c  reason: collision with root package name */
    public final transient Field f9108c;

    public g(f0 f0Var, Field field, p pVar) {
        super(f0Var, pVar);
        this.f9108c = field;
    }

    public String d() {
        return this.f9108c.getName();
    }

    public Class e() {
        return this.f9108c.getType();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!h.H(obj, g.class) || ((g) obj).f9108c != this.f9108c) {
            return false;
        }
        return true;
    }

    public j f() {
        return this.f9124a.a(this.f9108c.getGenericType());
    }

    public int hashCode() {
        return this.f9108c.getName().hashCode();
    }

    public Class k() {
        return this.f9108c.getDeclaringClass();
    }

    public Member m() {
        return this.f9108c;
    }

    public Object n(Object obj) {
        try {
            return this.f9108c.get(obj);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Failed to getValue() for field " + l() + ": " + e10.getMessage(), e10);
        }
    }

    public void o(Object obj, Object obj2) {
        try {
            this.f9108c.set(obj, obj2);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Failed to setValue() for field " + l() + ": " + e10.getMessage(), e10);
        }
    }

    /* renamed from: q */
    public Field b() {
        return this.f9108c;
    }

    public int r() {
        return this.f9108c.getModifiers();
    }

    public boolean s() {
        return Modifier.isTransient(r());
    }

    /* renamed from: t */
    public g p(p pVar) {
        return new g(this.f9124a, this.f9108c, pVar);
    }

    public String toString() {
        return "[field " + l() + "]";
    }
}
