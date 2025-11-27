package d4;

import k3.j;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public int f6240a;

    /* renamed from: b  reason: collision with root package name */
    public Class f6241b;

    /* renamed from: c  reason: collision with root package name */
    public j f6242c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6243d;

    public a0(Class cls, boolean z10) {
        this.f6241b = cls;
        this.f6242c = null;
        this.f6243d = z10;
        this.f6240a = z10 ? d(cls) : f(cls);
    }

    public static final int d(Class cls) {
        return cls.getName().hashCode() + 1;
    }

    public static final int e(j jVar) {
        return jVar.hashCode() - 2;
    }

    public static final int f(Class cls) {
        return cls.getName().hashCode();
    }

    public static final int g(j jVar) {
        return jVar.hashCode() - 1;
    }

    public Class a() {
        return this.f6241b;
    }

    public j b() {
        return this.f6242c;
    }

    public boolean c() {
        return this.f6243d;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        if (a0Var.f6243d != this.f6243d) {
            return false;
        }
        Class cls = this.f6241b;
        if (cls == null) {
            return this.f6242c.equals(a0Var.f6242c);
        }
        if (a0Var.f6241b == cls) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6240a;
    }

    public final String toString() {
        if (this.f6241b != null) {
            return "{class: " + this.f6241b.getName() + ", typed? " + this.f6243d + "}";
        }
        return "{type: " + this.f6242c + ", typed? " + this.f6243d + "}";
    }

    public a0(j jVar, boolean z10) {
        this.f6242c = jVar;
        this.f6241b = null;
        this.f6243d = z10;
        this.f6240a = z10 ? e(jVar) : g(jVar);
    }
}
