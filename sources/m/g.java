package m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l.e;
import m.e;
import m.f;

public class g extends q {
    public int A0;
    public int B0;
    public int C0;
    public int D0 = 0;
    public int E0 = 0;
    public d[] F0 = new d[4];
    public d[] G0 = new d[4];
    public List H0 = new ArrayList();
    public boolean I0 = false;
    public boolean J0 = false;
    public boolean K0 = false;
    public int L0 = 0;
    public int M0 = 0;
    public int N0 = 7;
    public boolean O0 = false;
    public boolean P0 = false;
    public boolean Q0 = false;
    public int R0 = 0;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f7753w0 = false;

    /* renamed from: x0  reason: collision with root package name */
    public e f7754x0 = new e();

    /* renamed from: y0  reason: collision with root package name */
    public p f7755y0;

    /* renamed from: z0  reason: collision with root package name */
    public int f7756z0;

    /* JADX WARNING: type inference failed for: r8v17, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K0() {
        /*
            r21 = this;
            r1 = r21
            int r2 = r1.K
            int r3 = r1.L
            int r0 = r21.D()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r21.r()
            int r6 = java.lang.Math.max(r4, r0)
            r1.P0 = r4
            r1.Q0 = r4
            m.f r0 = r1.F
            if (r0 == 0) goto L_0x0046
            m.p r0 = r1.f7755y0
            if (r0 != 0) goto L_0x002a
            m.p r0 = new m.p
            r0.<init>(r1)
            r1.f7755y0 = r0
        L_0x002a:
            m.p r0 = r1.f7755y0
            r0.b(r1)
            int r0 = r1.f7756z0
            r1.C0(r0)
            int r0 = r1.A0
            r1.D0(r0)
            r21.R()
            l.e r0 = r1.f7754x0
            l.c r0 = r0.w()
            r1.T(r0)
            goto L_0x004a
        L_0x0046:
            r1.K = r4
            r1.L = r4
        L_0x004a:
            int r0 = r1.N0
            r7 = 32
            r8 = 8
            r9 = 1
            if (r0 == 0) goto L_0x006a
            boolean r0 = r1.X0(r8)
            if (r0 != 0) goto L_0x005c
            r21.Z0()
        L_0x005c:
            boolean r0 = r1.X0(r7)
            if (r0 != 0) goto L_0x0065
            r21.W0()
        L_0x0065:
            l.e r0 = r1.f7754x0
            r0.f7557g = r9
            goto L_0x006e
        L_0x006a:
            l.e r0 = r1.f7754x0
            r0.f7557g = r4
        L_0x006e:
            m.f$b[] r0 = r1.E
            r10 = r0[r9]
            r11 = r0[r4]
            r21.b1()
            java.util.List r0 = r1.H0
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0090
            java.util.List r0 = r1.H0
            r0.clear()
            java.util.List r0 = r1.H0
            m.h r12 = new m.h
            java.util.ArrayList r13 = r1.f7803v0
            r12.<init>(r13)
            r0.add(r4, r12)
        L_0x0090:
            java.util.List r0 = r1.H0
            int r12 = r0.size()
            java.util.ArrayList r13 = r1.f7803v0
            m.f$b r0 = r21.s()
            m.f$b r14 = m.f.b.WRAP_CONTENT
            if (r0 == r14) goto L_0x00a9
            m.f$b r0 = r21.B()
            if (r0 != r14) goto L_0x00a7
            goto L_0x00a9
        L_0x00a7:
            r14 = 0
            goto L_0x00aa
        L_0x00a9:
            r14 = 1
        L_0x00aa:
            r0 = 0
            r15 = 0
        L_0x00ac:
            if (r15 >= r12) goto L_0x02ec
            boolean r8 = r1.O0
            if (r8 != 0) goto L_0x02ec
            java.util.List r8 = r1.H0
            java.lang.Object r8 = r8.get(r15)
            m.h r8 = (m.h) r8
            boolean r8 = r8.f7760d
            if (r8 == 0) goto L_0x00c4
            r20 = r3
            r19 = r12
            goto L_0x02de
        L_0x00c4:
            boolean r8 = r1.X0(r7)
            if (r8 == 0) goto L_0x00f7
            m.f$b r8 = r21.s()
            m.f$b r7 = m.f.b.FIXED
            if (r8 != r7) goto L_0x00e9
            m.f$b r8 = r21.B()
            if (r8 != r7) goto L_0x00e9
            java.util.List r7 = r1.H0
            java.lang.Object r7 = r7.get(r15)
            m.h r7 = (m.h) r7
            java.util.List r7 = r7.d()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.f7803v0 = r7
            goto L_0x00f7
        L_0x00e9:
            java.util.List r7 = r1.H0
            java.lang.Object r7 = r7.get(r15)
            m.h r7 = (m.h) r7
            java.util.List r7 = r7.f7757a
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.f7803v0 = r7
        L_0x00f7:
            r21.b1()
            java.util.ArrayList r7 = r1.f7803v0
            int r7 = r7.size()
            r8 = 0
        L_0x0101:
            if (r8 >= r7) goto L_0x0119
            java.util.ArrayList r4 = r1.f7803v0
            java.lang.Object r4 = r4.get(r8)
            m.f r4 = (m.f) r4
            boolean r9 = r4 instanceof m.q
            if (r9 == 0) goto L_0x0114
            m.q r4 = (m.q) r4
            r4.K0()
        L_0x0114:
            int r8 = r8 + 1
            r4 = 0
            r9 = 1
            goto L_0x0101
        L_0x0119:
            r4 = r0
            r0 = 0
            r8 = 1
        L_0x011c:
            if (r8 == 0) goto L_0x02cb
            r17 = r4
            r9 = 1
            int r4 = r0 + 1
            l.e r0 = r1.f7754x0     // Catch:{ Exception -> 0x0160 }
            r0.E()     // Catch:{ Exception -> 0x0160 }
            r21.b1()     // Catch:{ Exception -> 0x0160 }
            l.e r0 = r1.f7754x0     // Catch:{ Exception -> 0x0160 }
            r1.g(r0)     // Catch:{ Exception -> 0x0160 }
            r0 = 0
        L_0x0131:
            if (r0 >= r7) goto L_0x0147
            java.util.ArrayList r9 = r1.f7803v0     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r9 = r9.get(r0)     // Catch:{ Exception -> 0x0160 }
            m.f r9 = (m.f) r9     // Catch:{ Exception -> 0x0160 }
            r18 = r8
            l.e r8 = r1.f7754x0     // Catch:{ Exception -> 0x015c }
            r9.g(r8)     // Catch:{ Exception -> 0x015c }
            int r0 = r0 + 1
            r8 = r18
            goto L_0x0131
        L_0x0147:
            r18 = r8
            l.e r0 = r1.f7754x0     // Catch:{ Exception -> 0x015c }
            boolean r8 = r1.O0(r0)     // Catch:{ Exception -> 0x015c }
            if (r8 == 0) goto L_0x0159
            l.e r0 = r1.f7754x0     // Catch:{ Exception -> 0x0157 }
            r0.A()     // Catch:{ Exception -> 0x0157 }
            goto L_0x0159
        L_0x0157:
            r0 = move-exception
            goto L_0x0163
        L_0x0159:
            r19 = r12
            goto L_0x0182
        L_0x015c:
            r0 = move-exception
            r8 = r18
            goto L_0x0163
        L_0x0160:
            r0 = move-exception
            r18 = r8
        L_0x0163:
            r0.printStackTrace()
            java.io.PrintStream r9 = java.lang.System.out
            r18 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r19 = r12
            java.lang.String r12 = "EXCEPTION : "
            r8.append(r12)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r9.println(r0)
            r8 = r18
        L_0x0182:
            if (r8 == 0) goto L_0x018f
            l.e r8 = r1.f7754x0
            boolean[] r9 = m.k.f7776a
            r1.f1(r8, r9)
        L_0x018b:
            r20 = r3
            r3 = 2
            goto L_0x01db
        L_0x018f:
            l.e r8 = r1.f7754x0
            r1.G0(r8)
            r8 = 0
        L_0x0195:
            if (r8 >= r7) goto L_0x018b
            java.util.ArrayList r9 = r1.f7803v0
            java.lang.Object r9 = r9.get(r8)
            m.f r9 = (m.f) r9
            m.f$b[] r12 = r9.E
            r16 = 0
            r12 = r12[r16]
            m.f$b r0 = m.f.b.MATCH_CONSTRAINT
            if (r12 != r0) goto L_0x01bc
            int r12 = r9.D()
            r20 = r3
            int r3 = r9.F()
            if (r12 >= r3) goto L_0x01be
            boolean[] r0 = m.k.f7776a
            r3 = 2
            r12 = 1
            r0[r3] = r12
            goto L_0x01db
        L_0x01bc:
            r20 = r3
        L_0x01be:
            r12 = 1
            m.f$b[] r3 = r9.E
            r3 = r3[r12]
            if (r3 != r0) goto L_0x01d5
            int r0 = r9.r()
            int r3 = r9.E()
            if (r0 >= r3) goto L_0x01d5
            boolean[] r0 = m.k.f7776a
            r3 = 2
            r0[r3] = r12
            goto L_0x01db
        L_0x01d5:
            r3 = 2
            int r8 = r8 + 1
            r3 = r20
            goto L_0x0195
        L_0x01db:
            if (r14 == 0) goto L_0x0247
            r8 = 8
            if (r4 >= r8) goto L_0x0247
            boolean[] r0 = m.k.f7776a
            boolean r0 = r0[r3]
            if (r0 == 0) goto L_0x0247
            r0 = 0
            r3 = 0
            r9 = 0
        L_0x01ea:
            if (r0 >= r7) goto L_0x0210
            java.util.ArrayList r12 = r1.f7803v0
            java.lang.Object r12 = r12.get(r0)
            m.f r12 = (m.f) r12
            int r8 = r12.K
            int r18 = r12.D()
            int r8 = r8 + r18
            int r3 = java.lang.Math.max(r3, r8)
            int r8 = r12.L
            int r12 = r12.r()
            int r8 = r8 + r12
            int r9 = java.lang.Math.max(r9, r8)
            int r0 = r0 + 1
            r8 = 8
            goto L_0x01ea
        L_0x0210:
            int r0 = r1.V
            int r0 = java.lang.Math.max(r0, r3)
            int r3 = r1.W
            int r3 = java.lang.Math.max(r3, r9)
            m.f$b r8 = m.f.b.WRAP_CONTENT
            if (r11 != r8) goto L_0x0232
            int r9 = r21.D()
            if (r9 >= r0) goto L_0x0232
            r1.y0(r0)
            m.f$b[] r0 = r1.E
            r9 = 0
            r0[r9] = r8
            r0 = 1
            r17 = 1
            goto L_0x0233
        L_0x0232:
            r0 = 0
        L_0x0233:
            if (r10 != r8) goto L_0x0248
            int r9 = r21.r()
            if (r9 >= r3) goto L_0x0248
            r1.b0(r3)
            m.f$b[] r0 = r1.E
            r3 = 1
            r0[r3] = r8
            r0 = 1
            r17 = 1
            goto L_0x0248
        L_0x0247:
            r0 = 0
        L_0x0248:
            int r3 = r1.V
            int r8 = r21.D()
            int r3 = java.lang.Math.max(r3, r8)
            int r8 = r21.D()
            if (r3 <= r8) goto L_0x0265
            r1.y0(r3)
            m.f$b[] r0 = r1.E
            m.f$b r3 = m.f.b.FIXED
            r8 = 0
            r0[r8] = r3
            r0 = 1
            r17 = 1
        L_0x0265:
            int r3 = r1.W
            int r8 = r21.r()
            int r3 = java.lang.Math.max(r3, r8)
            int r8 = r21.r()
            if (r3 <= r8) goto L_0x0282
            r1.b0(r3)
            m.f$b[] r0 = r1.E
            m.f$b r3 = m.f.b.FIXED
            r8 = 1
            r0[r8] = r3
            r0 = 1
            r9 = 1
            goto L_0x0285
        L_0x0282:
            r8 = 1
            r9 = r17
        L_0x0285:
            if (r9 != 0) goto L_0x02c2
            m.f$b[] r3 = r1.E
            r12 = 0
            r3 = r3[r12]
            m.f$b r12 = m.f.b.WRAP_CONTENT
            if (r3 != r12) goto L_0x02a6
            if (r5 <= 0) goto L_0x02a6
            int r3 = r21.D()
            if (r3 <= r5) goto L_0x02a6
            r1.P0 = r8
            m.f$b[] r0 = r1.E
            m.f$b r3 = m.f.b.FIXED
            r9 = 0
            r0[r9] = r3
            r1.y0(r5)
            r0 = 1
            r9 = 1
        L_0x02a6:
            m.f$b[] r3 = r1.E
            r3 = r3[r8]
            if (r3 != r12) goto L_0x02c2
            if (r6 <= 0) goto L_0x02c2
            int r3 = r21.r()
            if (r3 <= r6) goto L_0x02c2
            r1.Q0 = r8
            m.f$b[] r0 = r1.E
            m.f$b r3 = m.f.b.FIXED
            r0[r8] = r3
            r1.b0(r6)
            r8 = 1
            r9 = 1
            goto L_0x02c3
        L_0x02c2:
            r8 = r0
        L_0x02c3:
            r0 = r4
            r4 = r9
            r12 = r19
            r3 = r20
            goto L_0x011c
        L_0x02cb:
            r20 = r3
            r17 = r4
            r19 = r12
            java.util.List r0 = r1.H0
            java.lang.Object r0 = r0.get(r15)
            m.h r0 = (m.h) r0
            r0.g()
            r0 = r17
        L_0x02de:
            int r15 = r15 + 1
            r12 = r19
            r3 = r20
            r4 = 0
            r7 = 32
            r8 = 8
            r9 = 1
            goto L_0x00ac
        L_0x02ec:
            r20 = r3
            r1.f7803v0 = r13
            m.f r3 = r1.F
            if (r3 == 0) goto L_0x0320
            int r2 = r1.V
            int r3 = r21.D()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.W
            int r4 = r21.r()
            int r3 = java.lang.Math.max(r3, r4)
            m.p r4 = r1.f7755y0
            r4.a(r1)
            int r4 = r1.f7756z0
            int r2 = r2 + r4
            int r4 = r1.B0
            int r2 = r2 + r4
            r1.y0(r2)
            int r2 = r1.A0
            int r3 = r3 + r2
            int r2 = r1.C0
            int r3 = r3 + r2
            r1.b0(r3)
            goto L_0x0326
        L_0x0320:
            r1.K = r2
            r2 = r20
            r1.L = r2
        L_0x0326:
            if (r0 == 0) goto L_0x0330
            m.f$b[] r0 = r1.E
            r2 = 0
            r0[r2] = r11
            r2 = 1
            r0[r2] = r10
        L_0x0330:
            l.e r0 = r1.f7754x0
            l.c r0 = r0.w()
            r1.T(r0)
            m.g r0 = r21.J0()
            if (r1 != r0) goto L_0x0342
            r21.F0()
        L_0x0342:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.g.K0():void");
    }

    public void N0(f fVar, int i10) {
        if (i10 == 0) {
            P0(fVar);
        } else if (i10 == 1) {
            Q0(fVar);
        }
    }

    public boolean O0(e eVar) {
        b(eVar);
        int size = this.f7803v0.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = (f) this.f7803v0.get(i10);
            if (fVar instanceof g) {
                f.b[] bVarArr = fVar.E;
                f.b bVar = bVarArr[0];
                f.b bVar2 = bVarArr[1];
                f.b bVar3 = f.b.WRAP_CONTENT;
                if (bVar == bVar3) {
                    fVar.g0(f.b.FIXED);
                }
                if (bVar2 == bVar3) {
                    fVar.u0(f.b.FIXED);
                }
                fVar.b(eVar);
                if (bVar == bVar3) {
                    fVar.g0(bVar);
                }
                if (bVar2 == bVar3) {
                    fVar.u0(bVar2);
                }
            } else {
                k.c(this, eVar, fVar);
                fVar.b(eVar);
            }
        }
        if (this.D0 > 0) {
            c.a(this, eVar, 0);
        }
        if (this.E0 > 0) {
            c.a(this, eVar, 1);
        }
        return true;
    }

    public final void P0(f fVar) {
        int i10 = this.D0 + 1;
        d[] dVarArr = this.G0;
        if (i10 >= dVarArr.length) {
            this.G0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.G0[this.D0] = new d(fVar, 0, U0());
        this.D0++;
    }

    public void Q() {
        this.f7754x0.E();
        this.f7756z0 = 0;
        this.B0 = 0;
        this.A0 = 0;
        this.C0 = 0;
        this.H0.clear();
        this.O0 = false;
        super.Q();
    }

    public final void Q0(f fVar) {
        int i10 = this.E0 + 1;
        d[] dVarArr = this.F0;
        if (i10 >= dVarArr.length) {
            this.F0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.F0[this.E0] = new d(fVar, 1, U0());
        this.E0++;
    }

    public int R0() {
        return this.N0;
    }

    public boolean S0() {
        return false;
    }

    public boolean T0() {
        return this.Q0;
    }

    public boolean U0() {
        return this.f7753w0;
    }

    public boolean V0() {
        return this.P0;
    }

    public void W0() {
        if (!X0(8)) {
            d(this.N0);
        }
        e1();
    }

    public boolean X0(int i10) {
        if ((this.N0 & i10) == i10) {
            return true;
        }
        return false;
    }

    public void Y0(int i10, int i11) {
        n nVar;
        n nVar2;
        f.b bVar = this.E[0];
        f.b bVar2 = f.b.WRAP_CONTENT;
        if (!(bVar == bVar2 || (nVar2 = this.f7704c) == null)) {
            nVar2.h(i10);
        }
        if (this.E[1] != bVar2 && (nVar = this.f7706d) != null) {
            nVar.h(i11);
        }
    }

    public void Z0() {
        int size = this.f7803v0.size();
        S();
        for (int i10 = 0; i10 < size; i10++) {
            ((f) this.f7803v0.get(i10)).S();
        }
    }

    public void a1() {
        Z0();
        d(this.N0);
    }

    public final void b1() {
        this.D0 = 0;
        this.E0 = 0;
    }

    public void c1(int i10) {
        this.N0 = i10;
    }

    public void d(int i10) {
        super.d(i10);
        int size = this.f7803v0.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((f) this.f7803v0.get(i11)).d(i10);
        }
    }

    public void d1(boolean z10) {
        this.f7753w0 = z10;
    }

    public void e1() {
        m f10 = h(e.d.LEFT).f();
        m f11 = h(e.d.TOP).f();
        f10.l((m) null, 0.0f);
        f11.l((m) null, 0.0f);
    }

    public void f1(l.e eVar, boolean[] zArr) {
        zArr[2] = false;
        G0(eVar);
        int size = this.f7803v0.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = (f) this.f7803v0.get(i10);
            fVar.G0(eVar);
            f.b bVar = fVar.E[0];
            f.b bVar2 = f.b.MATCH_CONSTRAINT;
            if (bVar == bVar2 && fVar.D() < fVar.F()) {
                zArr[2] = true;
            }
            if (fVar.E[1] == bVar2 && fVar.r() < fVar.E()) {
                zArr[2] = true;
            }
        }
    }
}
