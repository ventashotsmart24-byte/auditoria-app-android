package z3;

import c3.h;
import c3.n;
import i3.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.c0;
import k3.m;

public class a extends f {

    /* renamed from: b  reason: collision with root package name */
    public final List f9934b = new ArrayList();

    public a(l lVar) {
        super(lVar);
    }

    public a A(m mVar) {
        this.f9934b.add(mVar);
        return this;
    }

    public a B(String str) {
        if (str == null) {
            return D();
        }
        return A(z(str));
    }

    public a C(m mVar) {
        if (mVar == null) {
            mVar = x();
        }
        A(mVar);
        return this;
    }

    public a D() {
        A(x());
        return this;
    }

    public n b() {
        return n.START_ARRAY;
    }

    public void d(h hVar, c0 c0Var) {
        List list = this.f9934b;
        int size = list.size();
        hVar.u0(this, size);
        for (int i10 = 0; i10 < size; i10++) {
            ((b) ((m) list.get(i10))).d(hVar, c0Var);
        }
        hVar.V();
    }

    public void e(h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.d(this, n.START_ARRAY));
        for (m mVar : this.f9934b) {
            ((b) mVar).d(hVar, c0Var);
        }
        hVar2.h(hVar, g10);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            return this.f9934b.equals(((a) obj).f9934b);
        }
        return false;
    }

    public boolean f(c0 c0Var) {
        return this.f9934b.isEmpty();
    }

    public int hashCode() {
        return this.f9934b.hashCode();
    }

    public Iterator l() {
        return this.f9934b.iterator();
    }

    public m n(String str) {
        return null;
    }

    public m o() {
        return m.ARRAY;
    }

    public boolean p() {
        return true;
    }
}
