package c4;

import k3.j;

public final class h extends g {
    public h(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, j jVar3, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2, jVar3, obj, obj2, z10);
    }

    public static h d0(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, j jVar3) {
        return new h(cls, nVar, jVar, jVarArr, jVar2, jVar3, (Object) null, (Object) null, false);
    }

    public j P(Class cls, n nVar, j jVar, j[] jVarArr) {
        return new h(cls, nVar, jVar, jVarArr, this.f4832l, this.f4833m, this.f7411c, this.f7412d, this.f7413e);
    }

    public j R(j jVar) {
        if (this.f4833m == jVar) {
            return this;
        }
        return new h(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4832l, jVar, this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: e0 */
    public h S(Object obj) {
        return new h(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4832l, this.f4833m.W(obj), this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: f0 */
    public h T(Object obj) {
        return new h(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4832l, this.f4833m.X(obj), this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: g0 */
    public h b0(j jVar) {
        if (jVar == this.f4832l) {
            return this;
        }
        return new h(this.f7409a, this.f4843h, this.f4841f, this.f4842g, jVar, this.f4833m, this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: h0 */
    public h c0(Object obj) {
        return new h(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4832l.X(obj), this.f4833m, this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: i0 */
    public h V() {
        if (this.f7413e) {
            return this;
        }
        return new h(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4832l.V(), this.f4833m.V(), this.f7411c, this.f7412d, true);
    }

    /* renamed from: j0 */
    public h W(Object obj) {
        return new h(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4832l, this.f4833m, this.f7411c, obj, this.f7413e);
    }

    /* renamed from: k0 */
    public h X(Object obj) {
        return new h(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4832l, this.f4833m, obj, this.f7412d, this.f7413e);
    }

    public String toString() {
        return "[map type; class " + this.f7409a.getName() + ", " + this.f4832l + " -> " + this.f4833m + "]";
    }
}
