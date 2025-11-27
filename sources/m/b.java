package m;

import java.util.ArrayList;
import l.e;
import l.i;
import m.f;

public class b extends j {

    /* renamed from: x0  reason: collision with root package name */
    public int f7651x0 = 0;

    /* renamed from: y0  reason: collision with root package name */
    public ArrayList f7652y0 = new ArrayList(4);

    /* renamed from: z0  reason: collision with root package name */
    public boolean f7653z0 = true;

    public void K0(boolean z10) {
        this.f7653z0 = z10;
    }

    public void L0(int i10) {
        this.f7651x0 = i10;
    }

    public void S() {
        super.S();
        this.f7652y0.clear();
    }

    public void U() {
        m mVar;
        float f10;
        m mVar2;
        int i10 = this.f7651x0;
        float f11 = Float.MAX_VALUE;
        if (i10 != 0) {
            if (i10 == 1) {
                mVar = this.f7742w.f();
            } else if (i10 == 2) {
                mVar = this.f7741v.f();
            } else if (i10 == 3) {
                mVar = this.f7743x.f();
            } else {
                return;
            }
            f11 = 0.0f;
        } else {
            mVar = this.f7740u.f();
        }
        int size = this.f7652y0.size();
        m mVar3 = null;
        int i11 = 0;
        while (i11 < size) {
            m mVar4 = (m) this.f7652y0.get(i11);
            if (mVar4.f7792b == 1) {
                int i12 = this.f7651x0;
                if (i12 == 0 || i12 == 2) {
                    f10 = mVar4.f7782h;
                    if (f10 < f11) {
                        mVar2 = mVar4.f7781g;
                    } else {
                        i11++;
                    }
                } else {
                    f10 = mVar4.f7782h;
                    if (f10 > f11) {
                        mVar2 = mVar4.f7781g;
                    } else {
                        i11++;
                    }
                }
                mVar3 = mVar2;
                f11 = f10;
                i11++;
            } else {
                return;
            }
        }
        e.x();
        mVar.f7781g = mVar3;
        mVar.f7782h = f11;
        mVar.b();
        int i13 = this.f7651x0;
        if (i13 == 0) {
            this.f7742w.f().l(mVar3, f11);
        } else if (i13 == 1) {
            this.f7740u.f().l(mVar3, f11);
        } else if (i13 == 2) {
            this.f7743x.f().l(mVar3, f11);
        } else if (i13 == 3) {
            this.f7741v.f().l(mVar3, f11);
        }
    }

    public void b(e eVar) {
        e[] eVarArr;
        boolean z10;
        int i10;
        int i11;
        e[] eVarArr2 = this.C;
        eVarArr2[0] = this.f7740u;
        eVarArr2[2] = this.f7741v;
        eVarArr2[1] = this.f7742w;
        eVarArr2[3] = this.f7743x;
        int i12 = 0;
        while (true) {
            eVarArr = this.C;
            if (i12 >= eVarArr.length) {
                break;
            }
            e eVar2 = eVarArr[i12];
            eVar2.f7680j = eVar.r(eVar2);
            i12++;
        }
        int i13 = this.f7651x0;
        if (i13 >= 0 && i13 < 4) {
            e eVar3 = eVarArr[i13];
            int i14 = 0;
            while (true) {
                if (i14 >= this.f7775w0) {
                    z10 = false;
                    break;
                }
                f fVar = this.f7774v0[i14];
                if ((this.f7653z0 || fVar.c()) && ((((i10 = this.f7651x0) == 0 || i10 == 1) && fVar.s() == f.b.MATCH_CONSTRAINT) || (((i11 = this.f7651x0) == 2 || i11 == 3) && fVar.B() == f.b.MATCH_CONSTRAINT))) {
                    z10 = true;
                } else {
                    i14++;
                }
            }
            int i15 = this.f7651x0;
            if (i15 == 0 || i15 == 1 ? u().s() == f.b.WRAP_CONTENT : u().B() == f.b.WRAP_CONTENT) {
                z10 = false;
            }
            for (int i16 = 0; i16 < this.f7775w0; i16++) {
                f fVar2 = this.f7774v0[i16];
                if (this.f7653z0 || fVar2.c()) {
                    i r10 = eVar.r(fVar2.C[this.f7651x0]);
                    e[] eVarArr3 = fVar2.C;
                    int i17 = this.f7651x0;
                    eVarArr3[i17].f7680j = r10;
                    if (i17 == 0 || i17 == 2) {
                        eVar.j(eVar3.f7680j, r10, z10);
                    } else {
                        eVar.h(eVar3.f7680j, r10, z10);
                    }
                }
            }
            int i18 = this.f7651x0;
            if (i18 == 0) {
                eVar.e(this.f7742w.f7680j, this.f7740u.f7680j, 0, 6);
                if (!z10) {
                    eVar.e(this.f7740u.f7680j, this.F.f7742w.f7680j, 0, 5);
                }
            } else if (i18 == 1) {
                eVar.e(this.f7740u.f7680j, this.f7742w.f7680j, 0, 6);
                if (!z10) {
                    eVar.e(this.f7740u.f7680j, this.F.f7740u.f7680j, 0, 5);
                }
            } else if (i18 == 2) {
                eVar.e(this.f7743x.f7680j, this.f7741v.f7680j, 0, 6);
                if (!z10) {
                    eVar.e(this.f7741v.f7680j, this.F.f7743x.f7680j, 0, 5);
                }
            } else if (i18 == 3) {
                eVar.e(this.f7741v.f7680j, this.f7743x.f7680j, 0, 6);
                if (!z10) {
                    eVar.e(this.f7741v.f7680j, this.F.f7741v.f7680j, 0, 5);
                }
            }
        }
    }

    public boolean c() {
        return true;
    }

    public void d(int i10) {
        m mVar;
        m mVar2;
        f fVar = this.F;
        if (fVar != null && ((g) fVar).X0(2)) {
            int i11 = this.f7651x0;
            if (i11 == 0) {
                mVar = this.f7740u.f();
            } else if (i11 == 1) {
                mVar = this.f7742w.f();
            } else if (i11 == 2) {
                mVar = this.f7741v.f();
            } else if (i11 == 3) {
                mVar = this.f7743x.f();
            } else {
                return;
            }
            mVar.p(5);
            int i12 = this.f7651x0;
            if (i12 == 0 || i12 == 1) {
                this.f7741v.f().l((m) null, 0.0f);
                this.f7743x.f().l((m) null, 0.0f);
            } else {
                this.f7740u.f().l((m) null, 0.0f);
                this.f7742w.f().l((m) null, 0.0f);
            }
            this.f7652y0.clear();
            for (int i13 = 0; i13 < this.f7775w0; i13++) {
                f fVar2 = this.f7774v0[i13];
                if (this.f7653z0 || fVar2.c()) {
                    int i14 = this.f7651x0;
                    if (i14 == 0) {
                        mVar2 = fVar2.f7740u.f();
                    } else if (i14 == 1) {
                        mVar2 = fVar2.f7742w.f();
                    } else if (i14 == 2) {
                        mVar2 = fVar2.f7741v.f();
                    } else if (i14 != 3) {
                        mVar2 = null;
                    } else {
                        mVar2 = fVar2.f7743x.f();
                    }
                    if (mVar2 != null) {
                        this.f7652y0.add(mVar2);
                        mVar2.a(mVar);
                    }
                }
            }
        }
    }
}
