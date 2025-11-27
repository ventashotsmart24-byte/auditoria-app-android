package r3;

import k3.j;

public abstract class n extends i {

    /* renamed from: c  reason: collision with root package name */
    public final p[] f9137c;

    public n(f0 f0Var, p pVar, p[] pVarArr) {
        super(f0Var, pVar);
        this.f9137c = pVarArr;
    }

    public abstract Object q();

    public abstract Object r(Object[] objArr);

    public abstract Object s(Object obj);

    public final m t(int i10) {
        return new m(this, w(i10), this.f9124a, u(i10), i10);
    }

    public final p u(int i10) {
        p[] pVarArr = this.f9137c;
        if (pVarArr == null || i10 < 0 || i10 >= pVarArr.length) {
            return null;
        }
        return pVarArr[i10];
    }

    public abstract int v();

    public abstract j w(int i10);

    public abstract Class x(int i10);

    public m y(int i10, p pVar) {
        this.f9137c[i10] = pVar;
        return t(i10);
    }
}
