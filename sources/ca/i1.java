package ca;

public class i1 extends m1 implements q {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f11504b = s0();

    public i1(f1 f1Var) {
        super(true);
        R(f1Var);
    }

    public boolean K() {
        return this.f11504b;
    }

    public boolean L() {
        return true;
    }

    public final boolean s0() {
        o oVar;
        m1 r10;
        o oVar2;
        n N = N();
        if (N instanceof o) {
            oVar = (o) N;
        } else {
            oVar = null;
        }
        if (!(oVar == null || (r10 = oVar.r()) == null)) {
            while (!r10.K()) {
                n N2 = r10.N();
                if (N2 instanceof o) {
                    oVar2 = (o) N2;
                } else {
                    oVar2 = null;
                }
                if (oVar2 != null) {
                    r10 = oVar2.r();
                    if (r10 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }
}
