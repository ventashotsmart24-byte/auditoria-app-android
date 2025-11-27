package c4;

import com.raizlabs.android.dbflow.sql.language.Operator;
import k3.j;

public class k extends m {

    /* renamed from: l  reason: collision with root package name */
    public j f4838l;

    public k(Class cls, n nVar) {
        super(cls, nVar, (j) null, (j[]) null, 0, (Object) null, (Object) null, false);
    }

    public boolean D() {
        return false;
    }

    public j P(Class cls, n nVar, j jVar, j[] jVarArr) {
        return null;
    }

    public j R(j jVar) {
        return this;
    }

    public j S(Object obj) {
        return this;
    }

    public j T(Object obj) {
        return this;
    }

    public j V() {
        return this;
    }

    public j W(Object obj) {
        return this;
    }

    public j X(Object obj) {
        return this;
    }

    public j b0() {
        return this.f4838l;
    }

    public void c0(j jVar) {
        if (this.f4838l == null) {
            this.f4838l = jVar;
            return;
        }
        throw new IllegalStateException("Trying to re-set self reference; old value = " + this.f4838l + ", new = " + jVar);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public n j() {
        j jVar = this.f4838l;
        if (jVar != null) {
            return jVar.j();
        }
        return super.j();
    }

    public StringBuilder l(StringBuilder sb) {
        j jVar = this.f4838l;
        if (jVar != null) {
            return jVar.l(sb);
        }
        return sb;
    }

    public StringBuilder n(StringBuilder sb) {
        j jVar = this.f4838l;
        if (jVar != null) {
            return jVar.l(sb);
        }
        sb.append(Operator.Operation.EMPTY_PARAM);
        return sb;
    }

    public j s() {
        j jVar = this.f4838l;
        if (jVar != null) {
            return jVar.s();
        }
        return super.s();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[recursive type; ");
        j jVar = this.f4838l;
        if (jVar == null) {
            sb.append("UNRESOLVED");
        } else {
            sb.append(jVar.q().getName());
        }
        return sb.toString();
    }
}
