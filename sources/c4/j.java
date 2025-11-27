package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public class j extends l {

    /* renamed from: l  reason: collision with root package name */
    public final k3.j f4836l;

    /* renamed from: m  reason: collision with root package name */
    public final k3.j f4837m;

    /* JADX WARNING: type inference failed for: r16v0, types: [k3.j] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(java.lang.Class r11, c4.n r12, k3.j r13, k3.j[] r14, k3.j r15, k3.j r16, java.lang.Object r17, java.lang.Object r18, boolean r19) {
        /*
            r10 = this;
            r9 = r10
            int r5 = r15.hashCode()
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r17
            r7 = r18
            r8 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r15
            r9.f4836l = r0
            if (r16 != 0) goto L_0x001a
            r0 = r9
            goto L_0x001c
        L_0x001a:
            r0 = r16
        L_0x001c:
            r9.f4837m = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.j.<init>(java.lang.Class, c4.n, k3.j, k3.j[], k3.j, k3.j, java.lang.Object, java.lang.Object, boolean):void");
    }

    public static j g0(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, k3.j jVar2) {
        return new j(cls, nVar, jVar, jVarArr, jVar2, (k3.j) null, (Object) null, (Object) null, false);
    }

    public k3.j P(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        return new j(cls, this.f4843h, jVar, jVarArr, this.f4836l, this.f4837m, this.f7411c, this.f7412d, this.f7413e);
    }

    public k3.j R(k3.j jVar) {
        if (this.f4836l == jVar) {
            return this;
        }
        return new j(this.f7409a, this.f4843h, this.f4841f, this.f4842g, jVar, this.f4837m, this.f7411c, this.f7412d, this.f7413e);
    }

    public String a0() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7409a.getName());
        if (this.f4836l != null && Z(1)) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            sb.append(this.f4836l.c());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        return sb.toString();
    }

    public boolean b() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.f7409a != this.f7409a) {
            return false;
        }
        return this.f4836l.equals(jVar.f4836l);
    }

    /* renamed from: h0 */
    public j S(Object obj) {
        if (obj == this.f4836l.t()) {
            return this;
        }
        return new j(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4836l.W(obj), this.f4837m, this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: i0 */
    public j c0(Object obj) {
        if (obj == this.f4836l.u()) {
            return this;
        }
        return new j(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4836l.X(obj), this.f4837m, this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: j0 */
    public j d0() {
        if (this.f7413e) {
            return this;
        }
        return new j(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4836l.V(), this.f4837m, this.f7411c, this.f7412d, true);
    }

    public k3.j k() {
        return this.f4836l;
    }

    /* renamed from: k0 */
    public j e0(Object obj) {
        if (obj == this.f7412d) {
            return this;
        }
        return new j(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4836l, this.f4837m, this.f7411c, obj, this.f7413e);
    }

    public StringBuilder l(StringBuilder sb) {
        return m.Y(this.f7409a, sb, true);
    }

    /* renamed from: l0 */
    public j f0(Object obj) {
        if (obj == this.f7411c) {
            return this;
        }
        return new j(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4836l, this.f4837m, obj, this.f7412d, this.f7413e);
    }

    public StringBuilder n(StringBuilder sb) {
        m.Y(this.f7409a, sb, false);
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        StringBuilder n10 = this.f4836l.n(sb);
        n10.append(">;");
        return n10;
    }

    /* renamed from: r */
    public k3.j a() {
        return this.f4836l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[reference type, class ");
        sb.append(a0());
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        sb.append(this.f4836l);
        sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        sb.append(']');
        return sb.toString();
    }

    public boolean v() {
        return true;
    }
}
