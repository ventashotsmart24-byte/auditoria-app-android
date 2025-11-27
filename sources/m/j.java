package m;

import java.util.Arrays;

public abstract class j extends f {

    /* renamed from: v0  reason: collision with root package name */
    public f[] f7774v0 = new f[4];

    /* renamed from: w0  reason: collision with root package name */
    public int f7775w0 = 0;

    public void I0(f fVar) {
        int i10 = this.f7775w0 + 1;
        f[] fVarArr = this.f7774v0;
        if (i10 > fVarArr.length) {
            this.f7774v0 = (f[]) Arrays.copyOf(fVarArr, fVarArr.length * 2);
        }
        f[] fVarArr2 = this.f7774v0;
        int i11 = this.f7775w0;
        fVarArr2[i11] = fVar;
        this.f7775w0 = i11 + 1;
    }

    public void J0() {
        this.f7775w0 = 0;
    }
}
