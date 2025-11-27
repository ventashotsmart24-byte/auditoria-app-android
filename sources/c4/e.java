package c4;

import k3.j;

public final class e extends d {
    public e(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2, obj, obj2, z10);
    }

    public static e b0(Class cls, n nVar, j jVar, j[] jVarArr, j jVar2) {
        return new e(cls, nVar, jVar, jVarArr, jVar2, (Object) null, (Object) null, false);
    }

    public j P(Class cls, n nVar, j jVar, j[] jVarArr) {
        return new e(cls, nVar, jVar, jVarArr, this.f4817l, this.f7411c, this.f7412d, this.f7413e);
    }

    public j R(j jVar) {
        if (this.f4817l == jVar) {
            return this;
        }
        return new e(this.f7409a, this.f4843h, this.f4841f, this.f4842g, jVar, this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: c0 */
    public e S(Object obj) {
        return new e(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4817l.W(obj), this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: d0 */
    public e T(Object obj) {
        return new e(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4817l.X(obj), this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: e0 */
    public e V() {
        if (this.f7413e) {
            return this;
        }
        return new e(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4817l.V(), this.f7411c, this.f7412d, true);
    }

    /* renamed from: f0 */
    public e W(Object obj) {
        return new e(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4817l, this.f7411c, obj, this.f7413e);
    }

    /* renamed from: g0 */
    public e X(Object obj) {
        return new e(this.f7409a, this.f4843h, this.f4841f, this.f4842g, this.f4817l, obj, this.f7412d, this.f7413e);
    }

    public String toString() {
        return "[collection type; class " + this.f7409a.getName() + ", contains " + this.f4817l + "]";
    }
}
