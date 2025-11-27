package m;

import l.e;

public abstract class c {
    public static void a(g gVar, e eVar, int i10) {
        int i11;
        d[] dVarArr;
        int i12;
        if (i10 == 0) {
            i12 = gVar.D0;
            dVarArr = gVar.G0;
            i11 = 0;
        } else {
            i12 = gVar.E0;
            dVarArr = gVar.F0;
            i11 = 2;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            d dVar = dVarArr[i13];
            dVar.a();
            if (!gVar.X0(4)) {
                b(gVar, eVar, i10, i11, dVar);
            } else if (!k.b(gVar, eVar, i10, i11, dVar)) {
                b(gVar, eVar, i10, i11, dVar);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: m.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: l.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: l.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: m.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: l.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: m.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: l.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: m.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: m.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: l.i} */
    /* JADX WARNING: type inference failed for: r5v10, types: [l.i] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r7 == 2) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r7 == 2) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        r5 = false;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0451  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0477  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x047a  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0480  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0497  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0340 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(m.g r34, l.e r35, int r36, int r37, m.d r38) {
        /*
            r0 = r34
            r9 = r35
            r1 = r38
            m.f r10 = r1.f7654a
            m.f r11 = r1.f7656c
            m.f r12 = r1.f7655b
            m.f r13 = r1.f7657d
            m.f r2 = r1.f7658e
            float r3 = r1.f7664k
            m.f$b[] r4 = r0.E
            r4 = r4[r36]
            m.f$b r5 = m.f.b.WRAP_CONTENT
            r14 = 1
            if (r4 != r5) goto L_0x001d
            r4 = 1
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            r5 = 2
            if (r36 != 0) goto L_0x0030
            int r7 = r2.f7723l0
            if (r7 != 0) goto L_0x0027
            r8 = 1
            goto L_0x0028
        L_0x0027:
            r8 = 0
        L_0x0028:
            if (r7 != r14) goto L_0x002c
            r15 = 1
            goto L_0x002d
        L_0x002c:
            r15 = 0
        L_0x002d:
            if (r7 != r5) goto L_0x0040
            goto L_0x003e
        L_0x0030:
            int r7 = r2.f7725m0
            if (r7 != 0) goto L_0x0036
            r8 = 1
            goto L_0x0037
        L_0x0036:
            r8 = 0
        L_0x0037:
            if (r7 != r14) goto L_0x003b
            r15 = 1
            goto L_0x003c
        L_0x003b:
            r15 = 0
        L_0x003c:
            if (r7 != r5) goto L_0x0040
        L_0x003e:
            r5 = 1
            goto L_0x0041
        L_0x0040:
            r5 = 0
        L_0x0041:
            r16 = r15
            r7 = 0
            r15 = r8
            r8 = r10
        L_0x0046:
            r19 = 0
            if (r7 != 0) goto L_0x0113
            m.e[] r14 = r8.C
            r14 = r14[r37]
            if (r4 != 0) goto L_0x0056
            if (r5 == 0) goto L_0x0053
            goto L_0x0056
        L_0x0053:
            r21 = 4
            goto L_0x0058
        L_0x0056:
            r21 = 1
        L_0x0058:
            int r22 = r14.d()
            m.e r6 = r14.f7674d
            if (r6 == 0) goto L_0x0068
            if (r8 == r10) goto L_0x0068
            int r6 = r6.d()
            int r22 = r22 + r6
        L_0x0068:
            r6 = r22
            if (r5 == 0) goto L_0x0076
            if (r8 == r10) goto L_0x0076
            if (r8 == r12) goto L_0x0076
            r22 = r3
            r21 = r7
            r3 = 6
            goto L_0x0086
        L_0x0076:
            if (r15 == 0) goto L_0x0080
            if (r4 == 0) goto L_0x0080
            r22 = r3
            r21 = r7
            r3 = 4
            goto L_0x0086
        L_0x0080:
            r22 = r3
            r3 = r21
            r21 = r7
        L_0x0086:
            m.e r7 = r14.f7674d
            if (r7 == 0) goto L_0x00af
            if (r8 != r12) goto L_0x0099
            r23 = r15
            l.i r15 = r14.f7680j
            l.i r7 = r7.f7680j
            r24 = r2
            r2 = 5
            r9.i(r15, r7, r6, r2)
            goto L_0x00a5
        L_0x0099:
            r24 = r2
            r23 = r15
            l.i r2 = r14.f7680j
            l.i r7 = r7.f7680j
            r15 = 6
            r9.i(r2, r7, r6, r15)
        L_0x00a5:
            l.i r2 = r14.f7680j
            m.e r7 = r14.f7674d
            l.i r7 = r7.f7680j
            r9.e(r2, r7, r6, r3)
            goto L_0x00b3
        L_0x00af:
            r24 = r2
            r23 = r15
        L_0x00b3:
            if (r4 == 0) goto L_0x00e8
            int r2 = r8.C()
            r3 = 8
            if (r2 == r3) goto L_0x00d7
            m.f$b[] r2 = r8.E
            r2 = r2[r36]
            m.f$b r3 = m.f.b.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00d7
            m.e[] r2 = r8.C
            int r3 = r37 + 1
            r3 = r2[r3]
            l.i r3 = r3.f7680j
            r2 = r2[r37]
            l.i r2 = r2.f7680j
            r6 = 5
            r7 = 0
            r9.i(r3, r2, r7, r6)
            goto L_0x00d8
        L_0x00d7:
            r7 = 0
        L_0x00d8:
            m.e[] r2 = r8.C
            r2 = r2[r37]
            l.i r2 = r2.f7680j
            m.e[] r3 = r0.C
            r3 = r3[r37]
            l.i r3 = r3.f7680j
            r6 = 6
            r9.i(r2, r3, r7, r6)
        L_0x00e8:
            m.e[] r2 = r8.C
            int r3 = r37 + 1
            r2 = r2[r3]
            m.e r2 = r2.f7674d
            if (r2 == 0) goto L_0x0103
            m.f r2 = r2.f7672b
            m.e[] r3 = r2.C
            r3 = r3[r37]
            m.e r3 = r3.f7674d
            if (r3 == 0) goto L_0x0103
            m.f r3 = r3.f7672b
            if (r3 == r8) goto L_0x0101
            goto L_0x0103
        L_0x0101:
            r19 = r2
        L_0x0103:
            if (r19 == 0) goto L_0x010a
            r8 = r19
            r7 = r21
            goto L_0x010b
        L_0x010a:
            r7 = 1
        L_0x010b:
            r3 = r22
            r15 = r23
            r2 = r24
            goto L_0x0046
        L_0x0113:
            r24 = r2
            r22 = r3
            r23 = r15
            if (r13 == 0) goto L_0x0137
            m.e[] r2 = r11.C
            int r3 = r37 + 1
            r2 = r2[r3]
            m.e r2 = r2.f7674d
            if (r2 == 0) goto L_0x0137
            m.e[] r6 = r13.C
            r3 = r6[r3]
            l.i r6 = r3.f7680j
            l.i r2 = r2.f7680j
            int r3 = r3.d()
            int r3 = -r3
            r7 = 5
            r9.k(r6, r2, r3, r7)
            goto L_0x0138
        L_0x0137:
            r7 = 5
        L_0x0138:
            if (r4 == 0) goto L_0x0150
            m.e[] r0 = r0.C
            int r2 = r37 + 1
            r0 = r0[r2]
            l.i r0 = r0.f7680j
            m.e[] r3 = r11.C
            r2 = r3[r2]
            l.i r3 = r2.f7680j
            int r2 = r2.d()
            r4 = 6
            r9.i(r0, r3, r2, r4)
        L_0x0150:
            java.util.ArrayList r0 = r1.f7661h
            if (r0 == 0) goto L_0x01fe
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x01fe
            boolean r3 = r1.f7667n
            if (r3 == 0) goto L_0x0167
            boolean r3 = r1.f7669p
            if (r3 != 0) goto L_0x0167
            int r3 = r1.f7663j
            float r3 = (float) r3
            goto L_0x0169
        L_0x0167:
            r3 = r22
        L_0x0169:
            r4 = 0
            r8 = r19
            r6 = 0
            r26 = 0
        L_0x016f:
            if (r6 >= r2) goto L_0x01fe
            java.lang.Object r14 = r0.get(r6)
            m.f r14 = (m.f) r14
            float[] r15 = r14.f7731p0
            r15 = r15[r36]
            int r21 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r21 >= 0) goto L_0x019a
            boolean r15 = r1.f7669p
            if (r15 == 0) goto L_0x0196
            m.e[] r14 = r14.C
            int r15 = r37 + 1
            r15 = r14[r15]
            l.i r15 = r15.f7680j
            r14 = r14[r37]
            l.i r14 = r14.f7680j
            r4 = 4
            r7 = 0
            r9.e(r15, r14, r7, r4)
            r4 = 6
            goto L_0x01b1
        L_0x0196:
            r4 = 4
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L_0x019b
        L_0x019a:
            r4 = 4
        L_0x019b:
            r7 = 0
            int r18 = (r15 > r7 ? 1 : (r15 == r7 ? 0 : -1))
            if (r18 != 0) goto L_0x01b6
            m.e[] r14 = r14.C
            int r15 = r37 + 1
            r15 = r14[r15]
            l.i r15 = r15.f7680j
            r14 = r14[r37]
            l.i r14 = r14.f7680j
            r4 = 6
            r7 = 0
            r9.e(r15, r14, r7, r4)
        L_0x01b1:
            r22 = r0
            r17 = r2
            goto L_0x01f4
        L_0x01b6:
            r4 = 6
            r7 = 0
            if (r8 == 0) goto L_0x01ed
            m.e[] r8 = r8.C
            r4 = r8[r37]
            l.i r4 = r4.f7680j
            int r17 = r37 + 1
            r8 = r8[r17]
            l.i r8 = r8.f7680j
            m.e[] r7 = r14.C
            r22 = r0
            r0 = r7[r37]
            l.i r0 = r0.f7680j
            r7 = r7[r17]
            l.i r7 = r7.f7680j
            r17 = r2
            l.b r2 = r35.s()
            r25 = r2
            r27 = r3
            r28 = r15
            r29 = r4
            r30 = r8
            r31 = r0
            r32 = r7
            r25.k(r26, r27, r28, r29, r30, r31, r32)
            r9.d(r2)
            goto L_0x01f1
        L_0x01ed:
            r22 = r0
            r17 = r2
        L_0x01f1:
            r8 = r14
            r26 = r15
        L_0x01f4:
            int r6 = r6 + 1
            r2 = r17
            r0 = r22
            r4 = 0
            r7 = 5
            goto L_0x016f
        L_0x01fe:
            if (r12 == 0) goto L_0x0257
            if (r12 == r13) goto L_0x0204
            if (r5 == 0) goto L_0x0257
        L_0x0204:
            m.e[] r0 = r10.C
            r0 = r0[r37]
            m.e[] r1 = r11.C
            int r2 = r37 + 1
            r1 = r1[r2]
            m.e r3 = r0.f7674d
            if (r3 == 0) goto L_0x0215
            l.i r3 = r3.f7680j
            goto L_0x0217
        L_0x0215:
            r3 = r19
        L_0x0217:
            m.e r4 = r1.f7674d
            if (r4 == 0) goto L_0x021f
            l.i r4 = r4.f7680j
            r5 = r4
            goto L_0x0221
        L_0x021f:
            r5 = r19
        L_0x0221:
            if (r12 != r13) goto L_0x022e
            m.e[] r0 = r12.C
            r1 = r0[r37]
            r0 = r0[r2]
            r33 = r1
            r1 = r0
            r0 = r33
        L_0x022e:
            if (r3 == 0) goto L_0x0462
            if (r5 == 0) goto L_0x0462
            if (r36 != 0) goto L_0x0239
            r2 = r24
            float r2 = r2.Z
            goto L_0x023d
        L_0x0239:
            r2 = r24
            float r2 = r2.f7701a0
        L_0x023d:
            r4 = r2
            int r6 = r0.d()
            int r7 = r1.d()
            l.i r2 = r0.f7680j
            l.i r8 = r1.f7680j
            r10 = 5
            r0 = r35
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0462
        L_0x0257:
            if (r23 == 0) goto L_0x0344
            if (r12 == 0) goto L_0x0344
            int r0 = r1.f7663j
            if (r0 <= 0) goto L_0x0266
            int r1 = r1.f7662i
            if (r1 != r0) goto L_0x0266
            r21 = 1
            goto L_0x0268
        L_0x0266:
            r21 = 0
        L_0x0268:
            r14 = r12
            r15 = r14
        L_0x026a:
            if (r14 == 0) goto L_0x0462
            m.f[] r0 = r14.f7735r0
            r0 = r0[r36]
            r8 = r0
        L_0x0271:
            if (r8 == 0) goto L_0x0280
            int r0 = r8.C()
            r1 = 8
            if (r0 != r1) goto L_0x0280
            m.f[] r0 = r8.f7735r0
            r8 = r0[r36]
            goto L_0x0271
        L_0x0280:
            if (r8 != 0) goto L_0x028d
            if (r14 != r13) goto L_0x0285
            goto L_0x028d
        L_0x0285:
            r17 = r8
            r18 = 4
            r20 = 6
            goto L_0x0337
        L_0x028d:
            m.e[] r0 = r14.C
            r0 = r0[r37]
            l.i r1 = r0.f7680j
            m.e r2 = r0.f7674d
            if (r2 == 0) goto L_0x029a
            l.i r2 = r2.f7680j
            goto L_0x029c
        L_0x029a:
            r2 = r19
        L_0x029c:
            if (r15 == r14) goto L_0x02a7
            m.e[] r2 = r15.C
            int r3 = r37 + 1
            r2 = r2[r3]
            l.i r2 = r2.f7680j
            goto L_0x02b8
        L_0x02a7:
            if (r14 != r12) goto L_0x02b8
            if (r15 != r14) goto L_0x02b8
            m.e[] r2 = r10.C
            r2 = r2[r37]
            m.e r2 = r2.f7674d
            if (r2 == 0) goto L_0x02b6
            l.i r2 = r2.f7680j
            goto L_0x02b8
        L_0x02b6:
            r2 = r19
        L_0x02b8:
            int r0 = r0.d()
            m.e[] r3 = r14.C
            int r4 = r37 + 1
            r3 = r3[r4]
            int r3 = r3.d()
            if (r8 == 0) goto L_0x02d5
            m.e[] r5 = r8.C
            r5 = r5[r37]
            l.i r6 = r5.f7680j
            m.e[] r7 = r14.C
            r7 = r7[r4]
            l.i r7 = r7.f7680j
            goto L_0x02e8
        L_0x02d5:
            m.e[] r5 = r11.C
            r5 = r5[r4]
            m.e r5 = r5.f7674d
            if (r5 == 0) goto L_0x02e0
            l.i r6 = r5.f7680j
            goto L_0x02e2
        L_0x02e0:
            r6 = r19
        L_0x02e2:
            m.e[] r7 = r14.C
            r7 = r7[r4]
            l.i r7 = r7.f7680j
        L_0x02e8:
            if (r5 == 0) goto L_0x02ef
            int r5 = r5.d()
            int r3 = r3 + r5
        L_0x02ef:
            if (r15 == 0) goto L_0x02fa
            m.e[] r5 = r15.C
            r5 = r5[r4]
            int r5 = r5.d()
            int r0 = r0 + r5
        L_0x02fa:
            if (r1 == 0) goto L_0x0285
            if (r2 == 0) goto L_0x0285
            if (r6 == 0) goto L_0x0285
            if (r7 == 0) goto L_0x0285
            if (r14 != r12) goto L_0x030c
            m.e[] r0 = r12.C
            r0 = r0[r37]
            int r0 = r0.d()
        L_0x030c:
            r5 = r0
            if (r14 != r13) goto L_0x031a
            m.e[] r0 = r13.C
            r0 = r0[r4]
            int r0 = r0.d()
            r17 = r0
            goto L_0x031c
        L_0x031a:
            r17 = r3
        L_0x031c:
            if (r21 == 0) goto L_0x0321
            r22 = 6
            goto L_0x0323
        L_0x0321:
            r22 = 4
        L_0x0323:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r35
            r3 = r5
            r18 = 4
            r20 = 6
            r5 = r6
            r6 = r7
            r7 = r17
            r17 = r8
            r8 = r22
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0337:
            int r0 = r14.C()
            r1 = 8
            if (r0 == r1) goto L_0x0340
            r15 = r14
        L_0x0340:
            r14 = r17
            goto L_0x026a
        L_0x0344:
            r18 = 4
            r20 = 6
            if (r16 == 0) goto L_0x0462
            if (r12 == 0) goto L_0x0462
            int r0 = r1.f7663j
            if (r0 <= 0) goto L_0x0357
            int r1 = r1.f7662i
            if (r1 != r0) goto L_0x0357
            r21 = 1
            goto L_0x0359
        L_0x0357:
            r21 = 0
        L_0x0359:
            r14 = r12
            r15 = r14
        L_0x035b:
            if (r14 == 0) goto L_0x0404
            m.f[] r0 = r14.f7735r0
            r0 = r0[r36]
        L_0x0361:
            if (r0 == 0) goto L_0x0370
            int r1 = r0.C()
            r2 = 8
            if (r1 != r2) goto L_0x0370
            m.f[] r0 = r0.f7735r0
            r0 = r0[r36]
            goto L_0x0361
        L_0x0370:
            if (r14 == r12) goto L_0x03f8
            if (r14 == r13) goto L_0x03f8
            if (r0 == 0) goto L_0x03f8
            if (r0 != r13) goto L_0x037b
            r8 = r19
            goto L_0x037c
        L_0x037b:
            r8 = r0
        L_0x037c:
            m.e[] r0 = r14.C
            r0 = r0[r37]
            l.i r1 = r0.f7680j
            m.e r2 = r0.f7674d
            if (r2 == 0) goto L_0x0388
            l.i r2 = r2.f7680j
        L_0x0388:
            m.e[] r2 = r15.C
            int r3 = r37 + 1
            r2 = r2[r3]
            l.i r2 = r2.f7680j
            int r0 = r0.d()
            m.e[] r4 = r14.C
            r4 = r4[r3]
            int r4 = r4.d()
            if (r8 == 0) goto L_0x03ae
            m.e[] r5 = r8.C
            r5 = r5[r37]
            l.i r6 = r5.f7680j
            m.e r7 = r5.f7674d
            if (r7 == 0) goto L_0x03ab
            l.i r7 = r7.f7680j
            goto L_0x03c3
        L_0x03ab:
            r7 = r19
            goto L_0x03c3
        L_0x03ae:
            m.e[] r5 = r14.C
            r5 = r5[r3]
            m.e r6 = r5.f7674d
            if (r6 == 0) goto L_0x03b9
            l.i r7 = r6.f7680j
            goto L_0x03bb
        L_0x03b9:
            r7 = r19
        L_0x03bb:
            l.i r5 = r5.f7680j
            r33 = r7
            r7 = r5
            r5 = r6
            r6 = r33
        L_0x03c3:
            if (r5 == 0) goto L_0x03ca
            int r5 = r5.d()
            int r4 = r4 + r5
        L_0x03ca:
            r17 = r4
            m.e[] r4 = r15.C
            r3 = r4[r3]
            int r3 = r3.d()
            int r3 = r3 + r0
            if (r21 == 0) goto L_0x03da
            r22 = 6
            goto L_0x03dc
        L_0x03da:
            r22 = 4
        L_0x03dc:
            if (r1 == 0) goto L_0x03f4
            if (r2 == 0) goto L_0x03f4
            if (r6 == 0) goto L_0x03f4
            if (r7 == 0) goto L_0x03f4
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r35
            r5 = r6
            r6 = r7
            r7 = r17
            r17 = r8
            r8 = r22
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x03f6
        L_0x03f4:
            r17 = r8
        L_0x03f6:
            r0 = r17
        L_0x03f8:
            int r1 = r14.C()
            r2 = 8
            if (r1 == r2) goto L_0x0401
            r15 = r14
        L_0x0401:
            r14 = r0
            goto L_0x035b
        L_0x0404:
            m.e[] r0 = r12.C
            r0 = r0[r37]
            m.e[] r1 = r10.C
            r1 = r1[r37]
            m.e r1 = r1.f7674d
            m.e[] r2 = r13.C
            int r3 = r37 + 1
            r10 = r2[r3]
            m.e[] r2 = r11.C
            r2 = r2[r3]
            m.e r14 = r2.f7674d
            if (r1 == 0) goto L_0x0451
            if (r12 == r13) goto L_0x042b
            l.i r2 = r0.f7680j
            l.i r1 = r1.f7680j
            int r0 = r0.d()
            r15 = 5
            r9.e(r2, r1, r0, r15)
            goto L_0x0452
        L_0x042b:
            r15 = 5
            if (r14 == 0) goto L_0x0452
            l.i r2 = r0.f7680j
            l.i r3 = r1.f7680j
            int r4 = r0.d()
            r5 = 1056964608(0x3f000000, float:0.5)
            l.i r6 = r10.f7680j
            l.i r7 = r14.f7680j
            int r8 = r10.d()
            r17 = 5
            r0 = r35
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r17
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0452
        L_0x0451:
            r15 = 5
        L_0x0452:
            if (r14 == 0) goto L_0x0462
            if (r12 == r13) goto L_0x0462
            l.i r0 = r10.f7680j
            l.i r1 = r14.f7680j
            int r2 = r10.d()
            int r2 = -r2
            r9.e(r0, r1, r2, r15)
        L_0x0462:
            if (r23 != 0) goto L_0x0466
            if (r16 == 0) goto L_0x04bb
        L_0x0466:
            if (r12 == 0) goto L_0x04bb
            m.e[] r0 = r12.C
            r1 = r0[r37]
            m.e[] r2 = r13.C
            r3 = 1
            int r3 = r37 + 1
            r2 = r2[r3]
            m.e r4 = r1.f7674d
            if (r4 == 0) goto L_0x047a
            l.i r4 = r4.f7680j
            goto L_0x047c
        L_0x047a:
            r4 = r19
        L_0x047c:
            m.e r5 = r2.f7674d
            if (r5 == 0) goto L_0x0483
            l.i r5 = r5.f7680j
            goto L_0x0485
        L_0x0483:
            r5 = r19
        L_0x0485:
            if (r11 == r13) goto L_0x0495
            m.e[] r5 = r11.C
            r5 = r5[r3]
            m.e r5 = r5.f7674d
            if (r5 == 0) goto L_0x0493
            l.i r5 = r5.f7680j
            r19 = r5
        L_0x0493:
            r5 = r19
        L_0x0495:
            if (r12 != r13) goto L_0x0499
            r2 = r0[r3]
        L_0x0499:
            if (r4 == 0) goto L_0x04bb
            if (r5 == 0) goto L_0x04bb
            r6 = 1056964608(0x3f000000, float:0.5)
            int r7 = r1.d()
            m.e[] r0 = r13.C
            r0 = r0[r3]
            int r8 = r0.d()
            l.i r1 = r1.f7680j
            l.i r10 = r2.f7680j
            r11 = 5
            r0 = r35
            r2 = r4
            r3 = r7
            r4 = r6
            r6 = r10
            r7 = r8
            r8 = r11
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x04bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.c.b(m.g, l.e, int, int, m.d):void");
    }
}
