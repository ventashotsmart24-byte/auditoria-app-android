package z3;

import c3.h;
import c3.n;
import k3.c0;

public class s extends v {

    /* renamed from: a  reason: collision with root package name */
    public final Object f9987a;

    public s(Object obj) {
        this.f9987a = obj;
    }

    public n b() {
        return n.VALUE_EMBEDDED_OBJECT;
    }

    public final void d(h hVar, c0 c0Var) {
        Object obj = this.f9987a;
        if (obj == null) {
            c0Var.E(hVar);
        } else if (obj instanceof k3.n) {
            ((k3.n) obj).d(hVar, c0Var);
        } else {
            c0Var.F(obj, hVar);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof s)) {
            return v((s) obj);
        }
        return false;
    }

    public String g() {
        Object obj = this.f9987a;
        if (obj == null) {
            return "null";
        }
        return obj.toString();
    }

    public int hashCode() {
        return this.f9987a.hashCode();
    }

    public byte[] i() {
        Object obj = this.f9987a;
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        return super.i();
    }

    public m o() {
        return m.POJO;
    }

    public boolean v(s sVar) {
        Object obj = this.f9987a;
        if (obj != null) {
            return obj.equals(sVar.f9987a);
        }
        if (sVar.f9987a == null) {
            return true;
        }
        return false;
    }

    public Object w() {
        return this.f9987a;
    }
}
