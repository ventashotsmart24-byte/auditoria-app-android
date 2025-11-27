package kotlinx.coroutines.internal;

import ca.v1;
import k9.f;
import t9.i;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final f f18265a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f18266b;

    /* renamed from: c  reason: collision with root package name */
    public final v1[] f18267c;

    /* renamed from: d  reason: collision with root package name */
    public int f18268d;

    public f0(f fVar, int i10) {
        this.f18265a = fVar;
        this.f18266b = new Object[i10];
        this.f18267c = new v1[i10];
    }

    public final void a(v1 v1Var, Object obj) {
        Object[] objArr = this.f18266b;
        int i10 = this.f18268d;
        objArr[i10] = obj;
        v1[] v1VarArr = this.f18267c;
        this.f18268d = i10 + 1;
        v1VarArr[i10] = v1Var;
    }

    public final void b(f fVar) {
        int length = this.f18267c.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                v1 v1Var = this.f18267c[length];
                i.d(v1Var);
                v1Var.I(fVar, this.f18266b[length]);
                if (i10 >= 0) {
                    length = i10;
                } else {
                    return;
                }
            }
        }
    }
}
