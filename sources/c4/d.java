package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import k3.j;

public abstract class d extends m {

    /* renamed from: l  reason: collision with root package name */
    public final j f4817l;

    public d(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2.hashCode(), obj, obj2, z10);
        this.f4817l = jVar2;
    }

    public boolean B() {
        return true;
    }

    public boolean D() {
        return true;
    }

    public j U(j jVar) {
        j U;
        j U2 = super.U(jVar);
        j k10 = jVar.k();
        if (k10 == null || (U = this.f4817l.U(k10)) == this.f4817l) {
            return U2;
        }
        return U2.R(U);
    }

    public String a0() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7409a.getName());
        if (this.f4817l != null && Z(1)) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            sb.append(this.f4817l.c());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f7409a != dVar.f7409a || !this.f4817l.equals(dVar.f4817l)) {
            return false;
        }
        return true;
    }

    public j k() {
        return this.f4817l;
    }

    public StringBuilder l(StringBuilder sb) {
        return m.Y(this.f7409a, sb, true);
    }

    public StringBuilder n(StringBuilder sb) {
        m.Y(this.f7409a, sb, false);
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        this.f4817l.n(sb);
        sb.append(">;");
        return sb;
    }

    public boolean x() {
        if (super.x() || this.f4817l.x()) {
            return true;
        }
        return false;
    }
}
