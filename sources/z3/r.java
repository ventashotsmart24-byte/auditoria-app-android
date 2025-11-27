package z3;

import c3.h;
import c3.n;
import i3.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.b0;
import k3.c0;
import k3.m;

public class r extends f {

    /* renamed from: b  reason: collision with root package name */
    public final Map f9986b = new LinkedHashMap();

    public r(l lVar) {
        super(lVar);
    }

    public boolean A(r rVar) {
        return this.f9986b.equals(rVar.f9986b);
    }

    public r B(String str, m mVar) {
        this.f9986b.put(str, mVar);
        return this;
    }

    public r C(String str, String str2) {
        m mVar;
        if (str2 == null) {
            mVar = x();
        } else {
            mVar = z(str2);
        }
        return B(str, mVar);
    }

    public r D(String str, boolean z10) {
        return B(str, w(z10));
    }

    public a E(String str) {
        a v10 = v();
        B(str, v10);
        return v10;
    }

    public m F(String str, m mVar) {
        if (mVar == null) {
            mVar = x();
        }
        return (m) this.f9986b.put(str, mVar);
    }

    public m G(String str, m mVar) {
        if (mVar == null) {
            mVar = x();
        }
        this.f9986b.put(str, mVar);
        return this;
    }

    public n b() {
        return n.START_OBJECT;
    }

    public void d(h hVar, c0 c0Var) {
        boolean z10;
        if (c0Var == null || c0Var.m0(b0.WRITE_EMPTY_JSON_ARRAYS)) {
            z10 = false;
        } else {
            z10 = true;
        }
        hVar.w0(this);
        for (Map.Entry entry : this.f9986b.entrySet()) {
            b bVar = (b) entry.getValue();
            if (!z10 || !bVar.p() || !bVar.f(c0Var)) {
                hVar.Z((String) entry.getKey());
                bVar.d(hVar, c0Var);
            }
        }
        hVar.W();
    }

    public void e(h hVar, c0 c0Var, w3.h hVar2) {
        boolean z10;
        if (c0Var == null || c0Var.m0(b0.WRITE_EMPTY_JSON_ARRAYS)) {
            z10 = false;
        } else {
            z10 = true;
        }
        b g10 = hVar2.g(hVar, hVar2.d(this, n.START_OBJECT));
        for (Map.Entry entry : this.f9986b.entrySet()) {
            b bVar = (b) entry.getValue();
            if (!z10 || !bVar.p() || !bVar.f(c0Var)) {
                hVar.Z((String) entry.getKey());
                bVar.d(hVar, c0Var);
            }
        }
        hVar2.h(hVar, g10);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof r)) {
            return A((r) obj);
        }
        return false;
    }

    public boolean f(c0 c0Var) {
        return this.f9986b.isEmpty();
    }

    public int hashCode() {
        return this.f9986b.hashCode();
    }

    public Iterator l() {
        return this.f9986b.values().iterator();
    }

    public Iterator m() {
        return this.f9986b.entrySet().iterator();
    }

    public m n(String str) {
        return (m) this.f9986b.get(str);
    }

    public m o() {
        return m.OBJECT;
    }
}
