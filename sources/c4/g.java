package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import k3.j;

public abstract class g extends m {

    /* renamed from: l  reason: collision with root package name */
    public final j f4832l;

    /* renamed from: m  reason: collision with root package name */
    public final j f4833m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, j jVar3, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2.hashCode() ^ jVar3.hashCode(), obj, obj2, z10);
        this.f4832l = jVar2;
        this.f4833m = jVar3;
    }

    public boolean D() {
        return true;
    }

    public boolean J() {
        return true;
    }

    public j U(j jVar) {
        j U;
        j U2;
        j U3 = super.U(jVar);
        j p10 = jVar.p();
        if (!(!(U3 instanceof g) || p10 == null || (U2 = this.f4832l.U(p10)) == this.f4832l)) {
            U3 = ((g) U3).b0(U2);
        }
        j k10 = jVar.k();
        if (k10 == null || (U = this.f4833m.U(k10)) == this.f4833m) {
            return U3;
        }
        return U3.R(U);
    }

    public String a0() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7409a.getName());
        if (this.f4832l != null && Z(2)) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            sb.append(this.f4832l.c());
            sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            sb.append(this.f4833m.c());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        return sb.toString();
    }

    public abstract g b0(j jVar);

    public abstract g c0(Object obj);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f7409a != gVar.f7409a || !this.f4832l.equals(gVar.f4832l) || !this.f4833m.equals(gVar.f4833m)) {
            return false;
        }
        return true;
    }

    public j k() {
        return this.f4833m;
    }

    public StringBuilder l(StringBuilder sb) {
        return m.Y(this.f7409a, sb, true);
    }

    public StringBuilder n(StringBuilder sb) {
        m.Y(this.f7409a, sb, false);
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        this.f4832l.n(sb);
        this.f4833m.n(sb);
        sb.append(">;");
        return sb;
    }

    public j p() {
        return this.f4832l;
    }

    public boolean x() {
        if (super.x() || this.f4833m.x() || this.f4832l.x()) {
            return true;
        }
        return false;
    }
}
