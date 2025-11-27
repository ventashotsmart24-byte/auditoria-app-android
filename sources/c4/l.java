package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import k3.j;

public class l extends m {
    public l(Class cls) {
        this(cls, n.i(), (j) null, (j[]) null);
    }

    public static l b0(Class cls) {
        return new l(cls, (n) null, (j) null, (j[]) null, (Object) null, (Object) null, false);
    }

    public boolean D() {
        return false;
    }

    public j P(Class cls, n nVar, j jVar, j[] jVarArr) {
        return null;
    }

    public j R(j jVar) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    public j S(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    public String a0() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7409a.getName());
        int o10 = this.f4843h.o();
        if (o10 > 0 && Z(o10)) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            for (int i10 = 0; i10 < o10; i10++) {
                j f10 = f(i10);
                if (i10 > 0) {
                    sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                }
                sb.append(f10.c());
            }
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        return sb.toString();
    }

    /* renamed from: c0 */
    public l T(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenValueHandler()");
    }

    /* renamed from: d0 */
    public l V() {
        if (this.f7413e) {
            return this;
        }
        return new l(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f7411c, this.f7412d, true);
    }

    /* renamed from: e0 */
    public l W(Object obj) {
        if (this.f7412d == obj) {
            return this;
        }
        return new l(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f7411c, obj, this.f7413e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (lVar.f7409a != this.f7409a) {
            return false;
        }
        return this.f4843h.equals(lVar.f4843h);
    }

    /* renamed from: f0 */
    public l X(Object obj) {
        if (obj == this.f7411c) {
            return this;
        }
        return new l(this.f7409a, this.f4843h, this.f4841f, this.f4842g, obj, this.f7412d, this.f7413e);
    }

    public StringBuilder l(StringBuilder sb) {
        return m.Y(this.f7409a, sb, true);
    }

    public StringBuilder n(StringBuilder sb) {
        m.Y(this.f7409a, sb, false);
        int o10 = this.f4843h.o();
        if (o10 > 0) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            for (int i10 = 0; i10 < o10; i10++) {
                sb = f(i10).n(sb);
            }
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        sb.append(ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN);
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ");
        sb.append(a0());
        sb.append(']');
        return sb.toString();
    }

    public boolean v() {
        return false;
    }

    public l(Class cls, n nVar, j jVar, j[] jVarArr) {
        this(cls, nVar, jVar, jVarArr, (Object) null, (Object) null, false);
    }

    public l(Class cls, n nVar, j jVar, j[] jVarArr, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, 0, obj, obj2, z10);
    }

    public l(Class cls, n nVar, j jVar, j[] jVarArr, int i10, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, i10, obj, obj2, z10);
    }
}
