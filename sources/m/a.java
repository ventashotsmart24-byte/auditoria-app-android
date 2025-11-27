package m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.e;
import m.f;

public abstract class a {
    public static void a(g gVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        if ((gVar.R0() & 32) != 32) {
            j(gVar);
            return;
        }
        gVar.O0 = true;
        gVar.I0 = false;
        gVar.J0 = false;
        gVar.K0 = false;
        ArrayList<f> arrayList = gVar.f7803v0;
        List<h> list = gVar.H0;
        f.b s10 = gVar.s();
        f.b bVar = f.b.WRAP_CONTENT;
        if (s10 == bVar) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (gVar.B() == bVar) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 || z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        list.clear();
        for (f fVar : arrayList) {
            fVar.f7734r = null;
            fVar.f7721k0 = false;
            fVar.S();
        }
        for (f fVar2 : arrayList) {
            if (fVar2.f7734r == null && !b(fVar2, list, z12)) {
                j(gVar);
                gVar.O0 = false;
                return;
            }
        }
        int i10 = 0;
        int i11 = 0;
        for (h hVar : list) {
            i10 = Math.max(i10, c(hVar, 0));
            i11 = Math.max(i11, c(hVar, 1));
        }
        if (z10) {
            gVar.g0(f.b.FIXED);
            gVar.y0(i10);
            gVar.I0 = true;
            gVar.J0 = true;
            gVar.L0 = i10;
        }
        if (z11) {
            gVar.u0(f.b.FIXED);
            gVar.b0(i11);
            gVar.I0 = true;
            gVar.K0 = true;
            gVar.M0 = i11;
        }
        i(list, 0, gVar.D());
        i(list, 1, gVar.r());
    }

    public static boolean b(f fVar, List list, boolean z10) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return k(fVar, hVar, list, z10);
    }

    public static int c(h hVar, int i10) {
        boolean z10;
        int i11 = i10 * 2;
        List b10 = hVar.b(i10);
        int size = b10.size();
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            f fVar = (f) b10.get(i13);
            e[] eVarArr = fVar.C;
            e eVar = eVarArr[i11 + 1].f7674d;
            if (eVar == null || !(eVarArr[i11].f7674d == null || eVar == null)) {
                z10 = true;
            } else {
                z10 = false;
            }
            i12 = Math.max(i12, d(fVar, i10, z10, 0));
        }
        hVar.f7761e[i10] = i12;
        return i12;
    }

    public static int d(f fVar, int i10, boolean z10, int i11) {
        boolean z11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        f fVar2 = fVar;
        int i24 = i10;
        boolean z12 = z10;
        int i25 = 0;
        if (!fVar2.f7717i0) {
            return 0;
        }
        if (fVar2.f7744y.f7674d == null || i24 != 1) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z12) {
            i15 = fVar.j();
            i14 = fVar.r() - fVar.j();
            i13 = i24 * 2;
            i12 = i13 + 1;
        } else {
            i15 = fVar.r() - fVar.j();
            i14 = fVar.j();
            i12 = i24 * 2;
            i13 = i12 + 1;
        }
        e[] eVarArr = fVar2.C;
        if (eVarArr[i12].f7674d == null || eVarArr[i13].f7674d != null) {
            i16 = 1;
        } else {
            i16 = -1;
            int i26 = i12;
            i12 = i13;
            i13 = i26;
        }
        if (z11) {
            i17 = i11 - i15;
        } else {
            i17 = i11;
        }
        int d10 = (eVarArr[i13].d() * i16) + e(fVar, i10);
        int i27 = i17 + d10;
        if (i24 == 0) {
            i18 = fVar.D();
        } else {
            i18 = fVar.r();
        }
        int i28 = i18 * i16;
        Iterator it = fVar2.C[i13].f().f7791a.iterator();
        while (it.hasNext()) {
            i25 = Math.max(i25, d(((m) ((o) it.next())).f7777c.f7672b, i24, z12, i27));
        }
        int i29 = 0;
        for (Iterator it2 = fVar2.C[i12].f().f7791a.iterator(); it2.hasNext(); it2 = it2) {
            i29 = Math.max(i29, d(((m) ((o) it2.next())).f7777c.f7672b, i24, z12, i28 + i27));
        }
        if (z11) {
            i25 -= i15;
            i20 = i29 + i14;
        } else {
            if (i24 == 0) {
                i19 = fVar.D();
            } else {
                i19 = fVar.r();
            }
            i20 = i29 + (i19 * i16);
        }
        int i30 = 1;
        if (i24 == 1) {
            Iterator it3 = fVar2.f7744y.f().f7791a.iterator();
            int i31 = 0;
            while (it3.hasNext()) {
                Iterator it4 = it3;
                m mVar = (m) ((o) it3.next());
                if (i16 == i30) {
                    i31 = Math.max(i31, d(mVar.f7777c.f7672b, i24, z12, i15 + i27));
                    i23 = i12;
                } else {
                    i23 = i12;
                    i31 = Math.max(i31, d(mVar.f7777c.f7672b, i24, z12, (i14 * i16) + i27));
                }
                it3 = it4;
                i12 = i23;
                i30 = 1;
            }
            i21 = i12;
            int i32 = i31;
            if (fVar2.f7744y.f().f7791a.size() <= 0 || z11) {
                i22 = i32;
            } else if (i16 == 1) {
                i22 = i32 + i15;
            } else {
                i22 = i32 - i14;
            }
        } else {
            i21 = i12;
            i22 = 0;
        }
        int max = d10 + Math.max(i25, Math.max(i20, i22));
        int i33 = i28 + i27;
        if (i16 == -1) {
            int i34 = i33;
            i33 = i27;
            i27 = i34;
        }
        if (z12) {
            k.e(fVar2, i24, i27);
            fVar2.Z(i27, i33, i24);
        } else {
            fVar2.f7734r.a(fVar2, i24);
            fVar2.q0(i27, i24);
        }
        if (fVar.o(i10) == f.b.MATCH_CONSTRAINT && fVar2.I != 0.0f) {
            fVar2.f7734r.a(fVar2, i24);
        }
        e[] eVarArr2 = fVar2.C;
        if (!(eVarArr2[i13].f7674d == null || eVarArr2[i21].f7674d == null)) {
            f u10 = fVar.u();
            e[] eVarArr3 = fVar2.C;
            if (eVarArr3[i13].f7674d.f7672b == u10 && eVarArr3[i21].f7674d.f7672b == u10) {
                fVar2.f7734r.a(fVar2, i24);
            }
        }
        return max;
    }

    public static int e(f fVar, int i10) {
        f fVar2;
        e eVar;
        float f10;
        int i11 = i10 * 2;
        e[] eVarArr = fVar.C;
        e eVar2 = eVarArr[i11];
        e eVar3 = eVarArr[i11 + 1];
        e eVar4 = eVar2.f7674d;
        if (eVar4 == null || eVar4.f7672b != (fVar2 = fVar.F) || (eVar = eVar3.f7674d) == null || eVar.f7672b != fVar2) {
            return 0;
        }
        int t10 = fVar2.t(i10);
        if (i10 == 0) {
            f10 = fVar.Z;
        } else {
            f10 = fVar.f7701a0;
        }
        return (int) (((float) (((t10 - eVar2.d()) - eVar3.d()) - fVar.t(i10))) * f10);
    }

    public static void f(g gVar, f fVar, h hVar) {
        hVar.f7760d = false;
        gVar.O0 = false;
        fVar.f7717i0 = false;
    }

    public static int g(f fVar) {
        float f10;
        float f11;
        f.b s10 = fVar.s();
        f.b bVar = f.b.MATCH_CONSTRAINT;
        if (s10 == bVar) {
            if (fVar.J == 0) {
                f11 = ((float) fVar.r()) * fVar.I;
            } else {
                f11 = ((float) fVar.r()) / fVar.I;
            }
            int i10 = (int) f11;
            fVar.y0(i10);
            return i10;
        } else if (fVar.B() != bVar) {
            return -1;
        } else {
            if (fVar.J == 1) {
                f10 = ((float) fVar.D()) * fVar.I;
            } else {
                f10 = ((float) fVar.D()) / fVar.I;
            }
            int i11 = (int) f10;
            fVar.b0(i11);
            return i11;
        }
    }

    public static void h(e eVar) {
        m f10 = eVar.f();
        e eVar2 = eVar.f7674d;
        if (eVar2 != null && eVar2.f7674d != eVar) {
            eVar2.f().a(f10);
        }
    }

    public static void i(List list, int i10, int i11) {
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            for (f fVar : ((h) list.get(i12)).c(i10)) {
                if (fVar.f7717i0) {
                    l(fVar, i10, i11);
                }
            }
        }
    }

    public static void j(g gVar) {
        gVar.H0.clear();
        gVar.H0.add(0, new h(gVar.f7803v0));
    }

    public static boolean k(f fVar, h hVar, List list, boolean z10) {
        boolean z11;
        boolean z12;
        e eVar;
        f fVar2;
        e eVar2;
        f fVar3;
        if (fVar == null) {
            return true;
        }
        fVar.f7719j0 = false;
        g gVar = (g) fVar.u();
        h hVar2 = fVar.f7734r;
        if (hVar2 == null) {
            fVar.f7717i0 = true;
            hVar.f7757a.add(fVar);
            fVar.f7734r = hVar;
            if (fVar.f7740u.f7674d == null && fVar.f7742w.f7674d == null && fVar.f7741v.f7674d == null && fVar.f7743x.f7674d == null && fVar.f7744y.f7674d == null && fVar.B.f7674d == null) {
                f(gVar, fVar, hVar);
                if (z10) {
                    return false;
                }
            }
            if (!(fVar.f7741v.f7674d == null || fVar.f7743x.f7674d == null)) {
                gVar.B();
                f.b bVar = f.b.FIXED;
                if (z10) {
                    f(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.f7741v.f7674d.f7672b == fVar.u() && fVar.f7743x.f7674d.f7672b == fVar.u())) {
                    f(gVar, fVar, hVar);
                }
            }
            if (!(fVar.f7740u.f7674d == null || fVar.f7742w.f7674d == null)) {
                gVar.s();
                f.b bVar2 = f.b.FIXED;
                if (z10) {
                    f(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.f7740u.f7674d.f7672b == fVar.u() && fVar.f7742w.f7674d.f7672b == fVar.u())) {
                    f(gVar, fVar, hVar);
                }
            }
            f.b s10 = fVar.s();
            f.b bVar3 = f.b.MATCH_CONSTRAINT;
            if (s10 == bVar3) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (fVar.B() == bVar3) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ((z11 ^ z12) && fVar.I != 0.0f) {
                g(fVar);
            } else if (fVar.s() == bVar3 || fVar.B() == bVar3) {
                f(gVar, fVar, hVar);
                if (z10) {
                    return false;
                }
            }
            e eVar3 = fVar.f7740u.f7674d;
            if (((eVar3 == null && fVar.f7742w.f7674d == null) || ((eVar3 != null && eVar3.f7672b == fVar.F && fVar.f7742w.f7674d == null) || (((eVar2 = fVar.f7742w.f7674d) != null && eVar2.f7672b == fVar.F && eVar3 == null) || (eVar3 != null && eVar3.f7672b == (fVar3 = fVar.F) && eVar2 != null && eVar2.f7672b == fVar3)))) && fVar.B.f7674d == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.f7762f.add(fVar);
            }
            e eVar4 = fVar.f7741v.f7674d;
            if (((eVar4 == null && fVar.f7743x.f7674d == null) || ((eVar4 != null && eVar4.f7672b == fVar.F && fVar.f7743x.f7674d == null) || (((eVar = fVar.f7743x.f7674d) != null && eVar.f7672b == fVar.F && eVar4 == null) || (eVar4 != null && eVar4.f7672b == (fVar2 = fVar.F) && eVar != null && eVar.f7672b == fVar2)))) && fVar.B.f7674d == null && fVar.f7744y.f7674d == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.f7763g.add(fVar);
            }
            if (fVar instanceof j) {
                f(gVar, fVar, hVar);
                if (z10) {
                    return false;
                }
                j jVar = (j) fVar;
                for (int i10 = 0; i10 < jVar.f7775w0; i10++) {
                    if (!k(jVar.f7774v0[i10], hVar, list, z10)) {
                        return false;
                    }
                }
            }
            for (e eVar5 : fVar.C) {
                e eVar6 = eVar5.f7674d;
                if (!(eVar6 == null || eVar6.f7672b == fVar.u())) {
                    if (eVar5.f7673c == e.d.CENTER) {
                        f(gVar, fVar, hVar);
                        if (z10) {
                            return false;
                        }
                    } else {
                        h(eVar5);
                    }
                    if (!k(eVar5.f7674d.f7672b, hVar, list, z10)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (hVar2 != hVar) {
            hVar.f7757a.addAll(hVar2.f7757a);
            hVar.f7762f.addAll(fVar.f7734r.f7762f);
            hVar.f7763g.addAll(fVar.f7734r.f7763g);
            h hVar3 = fVar.f7734r;
            if (!hVar3.f7760d) {
                hVar.f7760d = false;
            }
            list.remove(hVar3);
            for (f fVar4 : fVar.f7734r.f7757a) {
                fVar4.f7734r = hVar;
            }
        }
        return true;
    }

    public static void l(f fVar, int i10, int i11) {
        boolean z10;
        int i12 = i10 * 2;
        e[] eVarArr = fVar.C;
        e eVar = eVarArr[i12];
        e eVar2 = eVarArr[i12 + 1];
        if (eVar.f7674d == null || eVar2.f7674d == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            k.e(fVar, i10, e(fVar, i10) + eVar.d());
        } else if (fVar.I == 0.0f || fVar.o(i10) != f.b.MATCH_CONSTRAINT) {
            int v10 = i11 - fVar.v(i10);
            int t10 = v10 - fVar.t(i10);
            fVar.Z(t10, v10, i10);
            k.e(fVar, i10, t10);
        } else {
            int g10 = g(fVar);
            int i13 = (int) fVar.C[i12].f().f7782h;
            int i14 = i13 + g10;
            eVar2.f().f7781g = eVar.f();
            eVar2.f().f7782h = (float) g10;
            eVar2.f().f7792b = 1;
            fVar.Z(i13, i14, i10);
        }
    }
}
