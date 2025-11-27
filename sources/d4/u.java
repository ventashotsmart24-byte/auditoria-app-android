package d4;

import c3.h;
import c3.q;
import k3.c0;
import k3.n;

public class u implements n {

    /* renamed from: a  reason: collision with root package name */
    public Object f6308a;

    public u(String str) {
        this.f6308a = str;
    }

    public void a(h hVar) {
        Object obj = this.f6308a;
        if (obj instanceof q) {
            hVar.q0((q) obj);
        } else {
            hVar.r0(String.valueOf(obj));
        }
    }

    public void d(h hVar, c0 c0Var) {
        Object obj = this.f6308a;
        if (obj instanceof n) {
            ((n) obj).d(hVar, c0Var);
        } else {
            a(hVar);
        }
    }

    public void e(h hVar, c0 c0Var, w3.h hVar2) {
        Object obj = this.f6308a;
        if (obj instanceof n) {
            ((n) obj).e(hVar, c0Var, hVar2);
        } else if (obj instanceof q) {
            d(hVar, c0Var);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        Object obj2 = this.f6308a;
        Object obj3 = ((u) obj).f6308a;
        if (obj2 == obj3) {
            return true;
        }
        if (obj2 == null || !obj2.equals(obj3)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.f6308a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return String.format("[RawValue of type %s]", new Object[]{h.h(this.f6308a)});
    }
}
