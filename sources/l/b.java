package l;

import l.e;
import l.i;

public class b implements e.a {

    /* renamed from: a  reason: collision with root package name */
    public i f7542a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f7543b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7544c = false;

    /* renamed from: d  reason: collision with root package name */
    public final a f7545d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7546e = false;

    public b(c cVar) {
        this.f7545d = new a(this, cVar);
    }

    public i a(e eVar, boolean[] zArr) {
        return this.f7545d.g(zArr, (i) null);
    }

    public void b(e.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f7542a = null;
            this.f7545d.c();
            int i10 = 0;
            while (true) {
                a aVar2 = bVar.f7545d;
                if (i10 < aVar2.f7531a) {
                    this.f7545d.a(aVar2.h(i10), bVar.f7545d.i(i10), true);
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void c(i iVar) {
        int i10 = iVar.f7573d;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f7545d.l(iVar, f10);
    }

    public void clear() {
        this.f7545d.c();
        this.f7542a = null;
        this.f7543b = 0.0f;
    }

    public b d(e eVar, int i10) {
        this.f7545d.l(eVar.p(i10, "ep"), 1.0f);
        this.f7545d.l(eVar.p(i10, "em"), -1.0f);
        return this;
    }

    public b e(i iVar, int i10) {
        this.f7545d.l(iVar, (float) i10);
        return this;
    }

    public boolean f(e eVar) {
        boolean z10;
        i b10 = this.f7545d.b(eVar);
        if (b10 == null) {
            z10 = true;
        } else {
            v(b10);
            z10 = false;
        }
        if (this.f7545d.f7531a == 0) {
            this.f7546e = true;
        }
        return z10;
    }

    public b g(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11) {
        if (iVar2 == iVar3) {
            this.f7545d.l(iVar, 1.0f);
            this.f7545d.l(iVar4, 1.0f);
            this.f7545d.l(iVar2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f7545d.l(iVar, 1.0f);
            this.f7545d.l(iVar2, -1.0f);
            this.f7545d.l(iVar3, -1.0f);
            this.f7545d.l(iVar4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f7543b = (float) ((-i10) + i11);
            }
        } else if (f10 <= 0.0f) {
            this.f7545d.l(iVar, -1.0f);
            this.f7545d.l(iVar2, 1.0f);
            this.f7543b = (float) i10;
        } else if (f10 >= 1.0f) {
            this.f7545d.l(iVar3, -1.0f);
            this.f7545d.l(iVar4, 1.0f);
            this.f7543b = (float) i11;
        } else {
            float f11 = 1.0f - f10;
            this.f7545d.l(iVar, f11 * 1.0f);
            this.f7545d.l(iVar2, f11 * -1.0f);
            this.f7545d.l(iVar3, -1.0f * f10);
            this.f7545d.l(iVar4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f7543b = (((float) (-i10)) * f11) + (((float) i11) * f10);
            }
        }
        return this;
    }

    public i getKey() {
        return this.f7542a;
    }

    public b h(i iVar, int i10) {
        this.f7542a = iVar;
        float f10 = (float) i10;
        iVar.f7574e = f10;
        this.f7543b = f10;
        this.f7546e = true;
        return this;
    }

    public b i(i iVar, i iVar2, i iVar3, float f10) {
        this.f7545d.l(iVar, -1.0f);
        this.f7545d.l(iVar2, 1.0f - f10);
        this.f7545d.l(iVar3, f10);
        return this;
    }

    public b j(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f7545d.l(iVar, -1.0f);
        this.f7545d.l(iVar2, 1.0f);
        this.f7545d.l(iVar3, f10);
        this.f7545d.l(iVar4, -f10);
        return this;
    }

    public b k(float f10, float f11, float f12, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f7543b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f7545d.l(iVar, 1.0f);
            this.f7545d.l(iVar2, -1.0f);
            this.f7545d.l(iVar4, 1.0f);
            this.f7545d.l(iVar3, -1.0f);
        } else if (f10 == 0.0f) {
            this.f7545d.l(iVar, 1.0f);
            this.f7545d.l(iVar2, -1.0f);
        } else if (f12 == 0.0f) {
            this.f7545d.l(iVar3, 1.0f);
            this.f7545d.l(iVar4, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f7545d.l(iVar, 1.0f);
            this.f7545d.l(iVar2, -1.0f);
            this.f7545d.l(iVar4, f13);
            this.f7545d.l(iVar3, -f13);
        }
        return this;
    }

    public b l(i iVar, int i10) {
        if (i10 < 0) {
            this.f7543b = (float) (i10 * -1);
            this.f7545d.l(iVar, 1.0f);
        } else {
            this.f7543b = (float) i10;
            this.f7545d.l(iVar, -1.0f);
        }
        return this;
    }

    public b m(i iVar, i iVar2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f7543b = (float) i10;
        }
        if (!z10) {
            this.f7545d.l(iVar, -1.0f);
            this.f7545d.l(iVar2, 1.0f);
        } else {
            this.f7545d.l(iVar, 1.0f);
            this.f7545d.l(iVar2, -1.0f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f7543b = (float) i10;
        }
        if (!z10) {
            this.f7545d.l(iVar, -1.0f);
            this.f7545d.l(iVar2, 1.0f);
            this.f7545d.l(iVar3, 1.0f);
        } else {
            this.f7545d.l(iVar, 1.0f);
            this.f7545d.l(iVar2, -1.0f);
            this.f7545d.l(iVar3, -1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f7543b = (float) i10;
        }
        if (!z10) {
            this.f7545d.l(iVar, -1.0f);
            this.f7545d.l(iVar2, 1.0f);
            this.f7545d.l(iVar3, -1.0f);
        } else {
            this.f7545d.l(iVar, 1.0f);
            this.f7545d.l(iVar2, -1.0f);
            this.f7545d.l(iVar3, 1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f7545d.l(iVar3, 0.5f);
        this.f7545d.l(iVar4, 0.5f);
        this.f7545d.l(iVar, -0.5f);
        this.f7545d.l(iVar2, -0.5f);
        this.f7543b = -f10;
        return this;
    }

    public void q() {
        float f10 = this.f7543b;
        if (f10 < 0.0f) {
            this.f7543b = f10 * -1.0f;
            this.f7545d.j();
        }
    }

    public boolean r() {
        i iVar = this.f7542a;
        if (iVar == null || (iVar.f7576g != i.a.UNRESTRICTED && this.f7543b < 0.0f)) {
            return false;
        }
        return true;
    }

    public boolean s(i iVar) {
        return this.f7545d.d(iVar);
    }

    public boolean t() {
        if (this.f7542a == null && this.f7543b == 0.0f && this.f7545d.f7531a == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return x();
    }

    public i u(i iVar) {
        return this.f7545d.g((boolean[]) null, iVar);
    }

    public void v(i iVar) {
        i iVar2 = this.f7542a;
        if (iVar2 != null) {
            this.f7545d.l(iVar2, -1.0f);
            this.f7542a = null;
        }
        float m10 = this.f7545d.m(iVar, true) * -1.0f;
        this.f7542a = iVar;
        if (m10 != 1.0f) {
            this.f7543b /= m10;
            this.f7545d.e(m10);
        }
    }

    public void w() {
        this.f7542a = null;
        this.f7545d.c();
        this.f7543b = 0.0f;
        this.f7546e = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String x() {
        /*
            r9 = this;
            l.i r0 = r9.f7542a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            l.i r1 = r9.f7542a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r9.f7543b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r9.f7543b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            l.a r5 = r9.f7545d
            int r5 = r5.f7531a
        L_0x005b:
            if (r2 >= r5) goto L_0x00ec
            l.a r6 = r9.f7545d
            l.i r6 = r6.h(r2)
            if (r6 != 0) goto L_0x0067
            goto L_0x00e8
        L_0x0067:
            l.a r7 = r9.f7545d
            float r7 = r7.i(r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x0073
            goto L_0x00e8
        L_0x0073:
            java.lang.String r6 = r6.toString()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0091
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ba
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b8
        L_0x0091:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00a7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00ba
        L_0x00a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00b8:
            float r7 = r7 * r8
        L_0x00ba:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00d0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e7
        L_0x00d0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e7:
            r1 = 1
        L_0x00e8:
            int r2 = r2 + 1
            goto L_0x005b
        L_0x00ec:
            if (r1 != 0) goto L_0x00ff
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00ff:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.b.x():java.lang.String");
    }
}
