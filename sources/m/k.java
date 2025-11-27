package m;

import l.e;
import m.f;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static boolean[] f7776a = new boolean[3];

    public static void a(int i10, f fVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        f fVar2 = fVar;
        fVar.H0();
        m f10 = fVar2.f7740u.f();
        m f11 = fVar2.f7741v.f();
        m f12 = fVar2.f7742w.f();
        m f13 = fVar2.f7743x.f();
        if ((i10 & 8) == 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        f.b bVar = fVar2.E[0];
        f.b bVar2 = f.b.MATCH_CONSTRAINT;
        if (bVar != bVar2 || !d(fVar2, 0)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!(f10.f7783i == 4 || f12.f7783i == 4)) {
            if (fVar2.E[0] == f.b.FIXED || (z11 && fVar.C() == 8)) {
                e eVar = fVar2.f7740u.f7674d;
                if (eVar == null && fVar2.f7742w.f7674d == null) {
                    f10.p(1);
                    f12.p(1);
                    if (z10) {
                        f12.j(f10, 1, fVar.x());
                    } else {
                        f12.i(f10, fVar.D());
                    }
                } else if (eVar != null && fVar2.f7742w.f7674d == null) {
                    f10.p(1);
                    f12.p(1);
                    if (z10) {
                        f12.j(f10, 1, fVar.x());
                    } else {
                        f12.i(f10, fVar.D());
                    }
                } else if (eVar == null && fVar2.f7742w.f7674d != null) {
                    f10.p(1);
                    f12.p(1);
                    f10.i(f12, -fVar.D());
                    if (z10) {
                        f10.j(f12, -1, fVar.x());
                    } else {
                        f10.i(f12, -fVar.D());
                    }
                } else if (!(eVar == null || fVar2.f7742w.f7674d == null)) {
                    f10.p(2);
                    f12.p(2);
                    if (z10) {
                        fVar.x().a(f10);
                        fVar.x().a(f12);
                        f10.o(f12, -1, fVar.x());
                        f12.o(f10, 1, fVar.x());
                    } else {
                        f10.n(f12, (float) (-fVar.D()));
                        f12.n(f10, (float) fVar.D());
                    }
                }
            } else if (z11) {
                int D = fVar.D();
                f10.p(1);
                f12.p(1);
                e eVar2 = fVar2.f7740u.f7674d;
                if (eVar2 == null && fVar2.f7742w.f7674d == null) {
                    if (z10) {
                        f12.j(f10, 1, fVar.x());
                    } else {
                        f12.i(f10, D);
                    }
                } else if (eVar2 == null || fVar2.f7742w.f7674d != null) {
                    if (eVar2 != null || fVar2.f7742w.f7674d == null) {
                        if (!(eVar2 == null || fVar2.f7742w.f7674d == null)) {
                            if (z10) {
                                fVar.x().a(f10);
                                fVar.x().a(f12);
                            }
                            if (fVar2.I == 0.0f) {
                                f10.p(3);
                                f12.p(3);
                                f10.n(f12, 0.0f);
                                f12.n(f10, 0.0f);
                            } else {
                                f10.p(2);
                                f12.p(2);
                                f10.n(f12, (float) (-D));
                                f12.n(f10, (float) D);
                                fVar2.y0(D);
                            }
                        }
                    } else if (z10) {
                        f10.j(f12, -1, fVar.x());
                    } else {
                        f10.i(f12, -D);
                    }
                } else if (z10) {
                    f12.j(f10, 1, fVar.x());
                } else {
                    f12.i(f10, D);
                }
            }
        }
        if (fVar2.E[1] != bVar2 || !d(fVar2, 1)) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (f11.f7783i != 4 && f13.f7783i != 4) {
            if (fVar2.E[1] == f.b.FIXED || (z12 && fVar.C() == 8)) {
                e eVar3 = fVar2.f7741v.f7674d;
                if (eVar3 == null && fVar2.f7743x.f7674d == null) {
                    f11.p(1);
                    f13.p(1);
                    if (z10) {
                        f13.j(f11, 1, fVar.w());
                    } else {
                        f13.i(f11, fVar.r());
                    }
                    e eVar4 = fVar2.f7744y;
                    if (eVar4.f7674d != null) {
                        eVar4.f().p(1);
                        f11.h(1, fVar2.f7744y.f(), -fVar2.U);
                    }
                } else if (eVar3 != null && fVar2.f7743x.f7674d == null) {
                    f11.p(1);
                    f13.p(1);
                    if (z10) {
                        f13.j(f11, 1, fVar.w());
                    } else {
                        f13.i(f11, fVar.r());
                    }
                    if (fVar2.U > 0) {
                        fVar2.f7744y.f().h(1, f11, fVar2.U);
                    }
                } else if (eVar3 == null && fVar2.f7743x.f7674d != null) {
                    f11.p(1);
                    f13.p(1);
                    if (z10) {
                        f11.j(f13, -1, fVar.w());
                    } else {
                        f11.i(f13, -fVar.r());
                    }
                    if (fVar2.U > 0) {
                        fVar2.f7744y.f().h(1, f11, fVar2.U);
                    }
                } else if (eVar3 != null && fVar2.f7743x.f7674d != null) {
                    f11.p(2);
                    f13.p(2);
                    if (z10) {
                        f11.o(f13, -1, fVar.w());
                        f13.o(f11, 1, fVar.w());
                        fVar.w().a(f11);
                        fVar.x().a(f13);
                    } else {
                        f11.n(f13, (float) (-fVar.r()));
                        f13.n(f11, (float) fVar.r());
                    }
                    if (fVar2.U > 0) {
                        fVar2.f7744y.f().h(1, f11, fVar2.U);
                    }
                }
            } else if (z12) {
                int r10 = fVar.r();
                f11.p(1);
                f13.p(1);
                e eVar5 = fVar2.f7741v.f7674d;
                if (eVar5 == null && fVar2.f7743x.f7674d == null) {
                    if (z10) {
                        f13.j(f11, 1, fVar.w());
                    } else {
                        f13.i(f11, r10);
                    }
                } else if (eVar5 == null || fVar2.f7743x.f7674d != null) {
                    if (eVar5 != null || fVar2.f7743x.f7674d == null) {
                        if (eVar5 != null && fVar2.f7743x.f7674d != null) {
                            if (z10) {
                                fVar.w().a(f11);
                                fVar.x().a(f13);
                            }
                            if (fVar2.I == 0.0f) {
                                f11.p(3);
                                f13.p(3);
                                f11.n(f13, 0.0f);
                                f13.n(f11, 0.0f);
                                return;
                            }
                            f11.p(2);
                            f13.p(2);
                            f11.n(f13, (float) (-r10));
                            f13.n(f11, (float) r10);
                            fVar2.b0(r10);
                            if (fVar2.U > 0) {
                                fVar2.f7744y.f().h(1, f11, fVar2.U);
                            }
                        }
                    } else if (z10) {
                        f11.j(f13, -1, fVar.w());
                    } else {
                        f11.i(f13, -r10);
                    }
                } else if (z10) {
                    f13.j(f11, 1, fVar.w());
                } else {
                    f13.i(f11, r10);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if (r7 == 2) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (r7 == 2) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(m.g r21, l.e r22, int r23, int r24, m.d r25) {
        /*
            r0 = r22
            r1 = r23
            r2 = r25
            m.f r3 = r2.f7654a
            m.f r4 = r2.f7656c
            m.f r5 = r2.f7655b
            m.f r6 = r2.f7657d
            m.f r7 = r2.f7658e
            float r2 = r2.f7664k
            r8 = r21
            m.f$b[] r8 = r8.E
            r8 = r8[r1]
            m.f$b r8 = m.f.b.FIXED
            r8 = 2
            r9 = 1
            if (r1 != 0) goto L_0x0030
            int r7 = r7.f7723l0
            if (r7 != 0) goto L_0x0024
            r11 = 1
            goto L_0x0025
        L_0x0024:
            r11 = 0
        L_0x0025:
            if (r7 != r9) goto L_0x0029
            r12 = 1
            goto L_0x002a
        L_0x0029:
            r12 = 0
        L_0x002a:
            if (r7 != r8) goto L_0x002e
        L_0x002c:
            r7 = 1
            goto L_0x003f
        L_0x002e:
            r7 = 0
            goto L_0x003f
        L_0x0030:
            int r7 = r7.f7725m0
            if (r7 != 0) goto L_0x0036
            r11 = 1
            goto L_0x0037
        L_0x0036:
            r11 = 0
        L_0x0037:
            if (r7 != r9) goto L_0x003b
            r12 = 1
            goto L_0x003c
        L_0x003b:
            r12 = 0
        L_0x003c:
            if (r7 != r8) goto L_0x002e
            goto L_0x002c
        L_0x003f:
            r14 = r3
            r9 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0047:
            r8 = 8
            if (r13 != 0) goto L_0x00f7
            int r10 = r14.C()
            if (r10 == r8) goto L_0x0095
            int r15 = r15 + 1
            if (r1 != 0) goto L_0x005a
            int r10 = r14.D()
            goto L_0x005e
        L_0x005a:
            int r10 = r14.r()
        L_0x005e:
            float r10 = (float) r10
            float r16 = r16 + r10
            if (r14 == r5) goto L_0x006e
            m.e[] r10 = r14.C
            r10 = r10[r24]
            int r10 = r10.d()
            float r10 = (float) r10
            float r16 = r16 + r10
        L_0x006e:
            if (r14 == r6) goto L_0x007d
            m.e[] r10 = r14.C
            int r19 = r24 + 1
            r10 = r10[r19]
            int r10 = r10.d()
            float r10 = (float) r10
            float r16 = r16 + r10
        L_0x007d:
            m.e[] r10 = r14.C
            r10 = r10[r24]
            int r10 = r10.d()
            float r10 = (float) r10
            float r17 = r17 + r10
            m.e[] r10 = r14.C
            int r19 = r24 + 1
            r10 = r10[r19]
            int r10 = r10.d()
            float r10 = (float) r10
            float r17 = r17 + r10
        L_0x0095:
            m.e[] r10 = r14.C
            r10 = r10[r24]
            int r10 = r14.C()
            if (r10 == r8) goto L_0x00d3
            m.f$b[] r8 = r14.E
            r8 = r8[r1]
            m.f$b r10 = m.f.b.MATCH_CONSTRAINT
            if (r8 != r10) goto L_0x00d3
            int r9 = r9 + 1
            if (r1 != 0) goto L_0x00bb
            int r8 = r14.f7708e
            if (r8 == 0) goto L_0x00b1
            r8 = 0
            return r8
        L_0x00b1:
            r8 = 0
            int r10 = r14.f7714h
            if (r10 != 0) goto L_0x00ba
            int r10 = r14.f7716i
            if (r10 == 0) goto L_0x00ca
        L_0x00ba:
            return r8
        L_0x00bb:
            r8 = 0
            int r10 = r14.f7710f
            if (r10 == 0) goto L_0x00c1
            return r8
        L_0x00c1:
            int r10 = r14.f7720k
            if (r10 != 0) goto L_0x00d2
            int r10 = r14.f7722l
            if (r10 == 0) goto L_0x00ca
            goto L_0x00d2
        L_0x00ca:
            float r10 = r14.I
            r18 = 0
            int r10 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r10 == 0) goto L_0x00d3
        L_0x00d2:
            return r8
        L_0x00d3:
            m.e[] r8 = r14.C
            int r10 = r24 + 1
            r8 = r8[r10]
            m.e r8 = r8.f7674d
            if (r8 == 0) goto L_0x00ee
            m.f r8 = r8.f7672b
            m.e[] r10 = r8.C
            r10 = r10[r24]
            m.e r10 = r10.f7674d
            if (r10 == 0) goto L_0x00ee
            m.f r10 = r10.f7672b
            if (r10 == r14) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r10 = r8
            goto L_0x00ef
        L_0x00ee:
            r10 = 0
        L_0x00ef:
            if (r10 == 0) goto L_0x00f4
            r14 = r10
            goto L_0x0047
        L_0x00f4:
            r13 = 1
            goto L_0x0047
        L_0x00f7:
            m.e[] r10 = r3.C
            r10 = r10[r24]
            m.m r10 = r10.f()
            m.e[] r13 = r4.C
            int r19 = r24 + 1
            r13 = r13[r19]
            m.m r13 = r13.f()
            m.m r8 = r10.f7779e
            if (r8 == 0) goto L_0x0330
            r20 = r3
            m.m r3 = r13.f7779e
            if (r3 != 0) goto L_0x0115
            goto L_0x0330
        L_0x0115:
            int r8 = r8.f7792b
            r0 = 1
            if (r8 != r0) goto L_0x032e
            int r3 = r3.f7792b
            if (r3 == r0) goto L_0x0120
            goto L_0x032e
        L_0x0120:
            if (r9 <= 0) goto L_0x0126
            if (r9 == r15) goto L_0x0126
            r0 = 0
            return r0
        L_0x0126:
            if (r7 != 0) goto L_0x012f
            if (r11 != 0) goto L_0x012f
            if (r12 == 0) goto L_0x012d
            goto L_0x012f
        L_0x012d:
            r0 = 0
            goto L_0x0148
        L_0x012f:
            if (r5 == 0) goto L_0x013b
            m.e[] r0 = r5.C
            r0 = r0[r24]
            int r0 = r0.d()
            float r0 = (float) r0
            goto L_0x013c
        L_0x013b:
            r0 = 0
        L_0x013c:
            if (r6 == 0) goto L_0x0148
            m.e[] r3 = r6.C
            r3 = r3[r19]
            int r3 = r3.d()
            float r3 = (float) r3
            float r0 = r0 + r3
        L_0x0148:
            m.m r3 = r10.f7779e
            float r3 = r3.f7782h
            m.m r6 = r13.f7779e
            float r6 = r6.f7782h
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0156
            float r6 = r6 - r3
            goto L_0x0158
        L_0x0156:
            float r6 = r3 - r6
        L_0x0158:
            float r6 = r6 - r16
            if (r9 <= 0) goto L_0x01f9
            if (r9 != r15) goto L_0x01f9
            m.f r0 = r14.u()
            if (r0 == 0) goto L_0x0172
            m.f r0 = r14.u()
            m.f$b[] r0 = r0.E
            r0 = r0[r1]
            m.f$b r5 = m.f.b.WRAP_CONTENT
            if (r0 != r5) goto L_0x0172
            r0 = 0
            return r0
        L_0x0172:
            float r6 = r6 + r16
            float r6 = r6 - r17
            r0 = r3
            r3 = r20
        L_0x0179:
            if (r3 == 0) goto L_0x01f7
            int r5 = l.e.f7550q
            m.f[] r5 = r3.f7735r0
            r5 = r5[r1]
            if (r5 != 0) goto L_0x0189
            if (r3 != r4) goto L_0x0186
            goto L_0x0189
        L_0x0186:
            r8 = r22
            goto L_0x01f5
        L_0x0189:
            float r7 = (float) r9
            float r7 = r6 / r7
            r8 = 0
            int r11 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r11 <= 0) goto L_0x01a1
            float[] r7 = r3.f7731p0
            r7 = r7[r1]
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x019e
            r18 = 0
            goto L_0x01a3
        L_0x019e:
            float r7 = r7 * r6
            float r7 = r7 / r2
        L_0x01a1:
            r18 = r7
        L_0x01a3:
            int r7 = r3.C()
            r8 = 8
            if (r7 != r8) goto L_0x01ad
            r18 = 0
        L_0x01ad:
            m.e[] r7 = r3.C
            r7 = r7[r24]
            int r7 = r7.d()
            float r7 = (float) r7
            float r0 = r0 + r7
            m.e[] r7 = r3.C
            r7 = r7[r24]
            m.m r7 = r7.f()
            m.m r8 = r10.f7781g
            r7.l(r8, r0)
            m.e[] r7 = r3.C
            r7 = r7[r19]
            m.m r7 = r7.f()
            m.m r8 = r10.f7781g
            float r0 = r0 + r18
            r7.l(r8, r0)
            m.e[] r7 = r3.C
            r7 = r7[r24]
            m.m r7 = r7.f()
            r8 = r22
            r7.g(r8)
            m.e[] r7 = r3.C
            r7 = r7[r19]
            m.m r7 = r7.f()
            r7.g(r8)
            m.e[] r3 = r3.C
            r3 = r3[r19]
            int r3 = r3.d()
            float r3 = (float) r3
            float r0 = r0 + r3
        L_0x01f5:
            r3 = r5
            goto L_0x0179
        L_0x01f7:
            r0 = 1
            return r0
        L_0x01f9:
            r8 = r22
            r2 = 0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0203
            r7 = 1
            r11 = 0
            r12 = 0
        L_0x0203:
            if (r7 == 0) goto L_0x026f
            float r6 = r6 - r0
            r2 = r20
            float r0 = r2.k(r1)
            float r6 = r6 * r0
            float r3 = r3 + r6
            r0 = r3
        L_0x0210:
            r3 = r2
            if (r3 == 0) goto L_0x0276
            int r2 = l.e.f7550q
            m.f[] r2 = r3.f7735r0
            r2 = r2[r1]
            if (r2 != 0) goto L_0x021d
            if (r3 != r4) goto L_0x0210
        L_0x021d:
            if (r1 != 0) goto L_0x0224
            int r5 = r3.D()
            goto L_0x0228
        L_0x0224:
            int r5 = r3.r()
        L_0x0228:
            float r5 = (float) r5
            m.e[] r6 = r3.C
            r6 = r6[r24]
            int r6 = r6.d()
            float r6 = (float) r6
            float r0 = r0 + r6
            m.e[] r6 = r3.C
            r6 = r6[r24]
            m.m r6 = r6.f()
            m.m r7 = r10.f7781g
            r6.l(r7, r0)
            m.e[] r6 = r3.C
            r6 = r6[r19]
            m.m r6 = r6.f()
            m.m r7 = r10.f7781g
            float r0 = r0 + r5
            r6.l(r7, r0)
            m.e[] r5 = r3.C
            r5 = r5[r24]
            m.m r5 = r5.f()
            r5.g(r8)
            m.e[] r5 = r3.C
            r5 = r5[r19]
            m.m r5 = r5.f()
            r5.g(r8)
            m.e[] r3 = r3.C
            r3 = r3[r19]
            int r3 = r3.d()
            float r3 = (float) r3
            float r0 = r0 + r3
            goto L_0x0210
        L_0x026f:
            r2 = r20
            if (r11 != 0) goto L_0x0279
            if (r12 == 0) goto L_0x0276
            goto L_0x0279
        L_0x0276:
            r0 = 1
            goto L_0x032d
        L_0x0279:
            if (r11 == 0) goto L_0x027d
        L_0x027b:
            float r6 = r6 - r0
            goto L_0x0280
        L_0x027d:
            if (r12 == 0) goto L_0x0280
            goto L_0x027b
        L_0x0280:
            int r0 = r15 + 1
            float r0 = (float) r0
            float r0 = r6 / r0
            if (r12 == 0) goto L_0x0292
            r7 = 1
            if (r15 <= r7) goto L_0x028e
            int r0 = r15 + -1
            float r0 = (float) r0
            goto L_0x0290
        L_0x028e:
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x0290:
            float r0 = r6 / r0
        L_0x0292:
            int r6 = r2.C()
            r7 = 8
            if (r6 == r7) goto L_0x029d
            float r6 = r3 + r0
            goto L_0x029e
        L_0x029d:
            r6 = r3
        L_0x029e:
            if (r12 == 0) goto L_0x02ad
            r7 = 1
            if (r15 <= r7) goto L_0x02ad
            m.e[] r6 = r5.C
            r6 = r6[r24]
            int r6 = r6.d()
            float r6 = (float) r6
            float r6 = r6 + r3
        L_0x02ad:
            if (r11 == 0) goto L_0x02bb
            if (r5 == 0) goto L_0x02bb
            m.e[] r3 = r5.C
            r3 = r3[r24]
            int r3 = r3.d()
            float r3 = (float) r3
            float r6 = r6 + r3
        L_0x02bb:
            r3 = r2
            if (r3 == 0) goto L_0x0276
            int r2 = l.e.f7550q
            m.f[] r2 = r3.f7735r0
            r2 = r2[r1]
            if (r2 != 0) goto L_0x02cc
            if (r3 != r4) goto L_0x02c9
            goto L_0x02cc
        L_0x02c9:
            r7 = 8
            goto L_0x02bb
        L_0x02cc:
            if (r1 != 0) goto L_0x02d3
            int r7 = r3.D()
            goto L_0x02d7
        L_0x02d3:
            int r7 = r3.r()
        L_0x02d7:
            float r7 = (float) r7
            if (r3 == r5) goto L_0x02e4
            m.e[] r9 = r3.C
            r9 = r9[r24]
            int r9 = r9.d()
            float r9 = (float) r9
            float r6 = r6 + r9
        L_0x02e4:
            m.e[] r9 = r3.C
            r9 = r9[r24]
            m.m r9 = r9.f()
            m.m r11 = r10.f7781g
            r9.l(r11, r6)
            m.e[] r9 = r3.C
            r9 = r9[r19]
            m.m r9 = r9.f()
            m.m r11 = r10.f7781g
            float r12 = r6 + r7
            r9.l(r11, r12)
            m.e[] r9 = r3.C
            r9 = r9[r24]
            m.m r9 = r9.f()
            r9.g(r8)
            m.e[] r9 = r3.C
            r9 = r9[r19]
            m.m r9 = r9.f()
            r9.g(r8)
            m.e[] r3 = r3.C
            r3 = r3[r19]
            int r3 = r3.d()
            float r3 = (float) r3
            float r7 = r7 + r3
            float r6 = r6 + r7
            if (r2 == 0) goto L_0x02c9
            int r3 = r2.C()
            r7 = 8
            if (r3 == r7) goto L_0x02bb
            float r6 = r6 + r0
            goto L_0x02bb
        L_0x032d:
            return r0
        L_0x032e:
            r0 = 0
            return r0
        L_0x0330:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.k.b(m.g, l.e, int, int, m.d):boolean");
    }

    public static void c(g gVar, e eVar, f fVar) {
        f.b bVar = gVar.E[0];
        f.b bVar2 = f.b.WRAP_CONTENT;
        if (bVar != bVar2 && fVar.E[0] == f.b.MATCH_PARENT) {
            int i10 = fVar.f7740u.f7675e;
            int D = gVar.D() - fVar.f7742w.f7675e;
            e eVar2 = fVar.f7740u;
            eVar2.f7680j = eVar.r(eVar2);
            e eVar3 = fVar.f7742w;
            eVar3.f7680j = eVar.r(eVar3);
            eVar.f(fVar.f7740u.f7680j, i10);
            eVar.f(fVar.f7742w.f7680j, D);
            fVar.f7700a = 2;
            fVar.f0(i10, D);
        }
        if (gVar.E[1] != bVar2 && fVar.E[1] == f.b.MATCH_PARENT) {
            int i11 = fVar.f7741v.f7675e;
            int r10 = gVar.r() - fVar.f7743x.f7675e;
            e eVar4 = fVar.f7741v;
            eVar4.f7680j = eVar.r(eVar4);
            e eVar5 = fVar.f7743x;
            eVar5.f7680j = eVar.r(eVar5);
            eVar.f(fVar.f7741v.f7680j, i11);
            eVar.f(fVar.f7743x.f7680j, r10);
            if (fVar.U > 0 || fVar.C() == 8) {
                e eVar6 = fVar.f7744y;
                eVar6.f7680j = eVar.r(eVar6);
                eVar.f(fVar.f7744y.f7680j, fVar.U + i11);
            }
            fVar.f7702b = 2;
            fVar.t0(i11, r10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0037 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(m.f r5, int r6) {
        /*
            m.f$b[] r0 = r5.E
            r1 = r0[r6]
            m.f$b r2 = m.f.b.MATCH_CONSTRAINT
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            float r1 = r5.I
            r2 = 0
            r4 = 1
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0019
            if (r6 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            r5 = r0[r4]
            return r3
        L_0x0019:
            if (r6 != 0) goto L_0x0029
            int r6 = r5.f7708e
            if (r6 == 0) goto L_0x0020
            return r3
        L_0x0020:
            int r6 = r5.f7714h
            if (r6 != 0) goto L_0x0028
            int r5 = r5.f7716i
            if (r5 == 0) goto L_0x0037
        L_0x0028:
            return r3
        L_0x0029:
            int r6 = r5.f7710f
            if (r6 == 0) goto L_0x002e
            return r3
        L_0x002e:
            int r6 = r5.f7720k
            if (r6 != 0) goto L_0x0038
            int r5 = r5.f7722l
            if (r5 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            return r4
        L_0x0038:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: m.k.d(m.f, int):boolean");
    }

    public static void e(f fVar, int i10, int i11) {
        int i12 = i10 * 2;
        int i13 = i12 + 1;
        fVar.C[i12].f().f7781g = fVar.u().f7740u.f();
        fVar.C[i12].f().f7782h = (float) i11;
        fVar.C[i12].f().f7792b = 1;
        fVar.C[i13].f().f7781g = fVar.C[i12].f();
        fVar.C[i13].f().f7782h = (float) fVar.t(i10);
        fVar.C[i13].f().f7792b = 1;
    }
}
