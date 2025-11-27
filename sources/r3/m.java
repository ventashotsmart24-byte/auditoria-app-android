package r3;

import d4.h;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import k3.j;

public final class m extends i {

    /* renamed from: c  reason: collision with root package name */
    public final n f9134c;

    /* renamed from: d  reason: collision with root package name */
    public final j f9135d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9136e;

    public m(n nVar, j jVar, f0 f0Var, p pVar, int i10) {
        super(f0Var, pVar);
        this.f9134c = nVar;
        this.f9135d = jVar;
        this.f9136e = i10;
    }

    public AnnotatedElement b() {
        return null;
    }

    public String d() {
        return "";
    }

    public Class e() {
        return this.f9135d.q();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!h.H(obj, m.class)) {
            return false;
        }
        m mVar = (m) obj;
        if (!mVar.f9134c.equals(this.f9134c) || mVar.f9136e != this.f9136e) {
            return false;
        }
        return true;
    }

    public j f() {
        return this.f9135d;
    }

    public int hashCode() {
        return this.f9134c.hashCode() + this.f9136e;
    }

    public Class k() {
        return this.f9134c.k();
    }

    public Member m() {
        return this.f9134c.m();
    }

    public Object n(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + k().getName());
    }

    public void o(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + k().getName());
    }

    public int q() {
        return this.f9136e;
    }

    public n r() {
        return this.f9134c;
    }

    /* renamed from: s */
    public m p(p pVar) {
        if (pVar == this.f9125b) {
            return this;
        }
        return this.f9134c.y(this.f9136e, pVar);
    }

    public String toString() {
        return "[parameter #" + q() + ", annotations: " + this.f9125b + "]";
    }
}
