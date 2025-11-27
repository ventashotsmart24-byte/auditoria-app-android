package com.umeng.ut.b.a.a;

import java.io.UnsupportedEncodingException;

public class a {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f16232d = true;

    /* renamed from: com.umeng.ut.b.a.a.a$a  reason: collision with other inner class name */
    public static abstract class C0212a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f16233a;

        /* renamed from: b  reason: collision with root package name */
        public int f16234b;
    }

    public static class b extends C0212a {

        /* renamed from: b  reason: collision with root package name */
        private static final byte[] f16235b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: c  reason: collision with root package name */
        private static final byte[] f16236c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ boolean f16237d = true;

        /* renamed from: c  reason: collision with other field name */
        int f61c;
        private int count;

        /* renamed from: d  reason: collision with other field name */
        private final byte[] f62d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f16238e;

        /* renamed from: e  reason: collision with other field name */
        private final byte[] f63e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f16239f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f16240g;

        public b(int i10, byte[] bArr) {
            boolean z10;
            boolean z11;
            byte[] bArr2;
            int i11;
            this.f16233a = bArr;
            boolean z12 = true;
            if ((i10 & 1) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f16238e = z10;
            if ((i10 & 2) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f16239f = z11;
            this.f16240g = (i10 & 4) == 0 ? false : z12;
            if ((i10 & 8) == 0) {
                bArr2 = f16235b;
            } else {
                bArr2 = f16236c;
            }
            this.f63e = bArr2;
            this.f62d = new byte[2];
            this.f61c = 0;
            if (z11) {
                i11 = 19;
            } else {
                i11 = -1;
            }
            this.count = i11;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01d4  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x00e6 A[SYNTHETIC] */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.f63e
                byte[] r2 = r0.f16233a
                int r3 = r0.count
                int r4 = r20 + r19
                int r5 = r0.f61c
                r6 = 2
                r7 = 1
                r8 = 0
                r9 = -1
                if (r5 == r7) goto L_0x0031
                if (r5 == r6) goto L_0x0015
                goto L_0x0050
            L_0x0015:
                int r5 = r19 + 1
                if (r5 > r4) goto L_0x0050
                byte[] r10 = r0.f62d
                byte r11 = r10[r8]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                byte r10 = r10[r7]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.f61c = r8
                r11 = r5
                goto L_0x0053
            L_0x0031:
                int r5 = r19 + 2
                if (r5 > r4) goto L_0x0050
                byte[] r5 = r0.f62d
                byte r5 = r5[r8]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r19 + 1
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r10 + 1
                byte r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r5
                r0.f61c = r8
                goto L_0x0053
            L_0x0050:
                r11 = r19
                r10 = -1
            L_0x0053:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r10 == r9) goto L_0x008f
                int r9 = r10 >> 18
                r9 = r9 & 63
                byte r9 = r1[r9]
                r2[r8] = r9
                int r9 = r10 >> 12
                r9 = r9 & 63
                byte r9 = r1[r9]
                r2[r7] = r9
                int r9 = r10 >> 6
                r9 = r9 & 63
                byte r9 = r1[r9]
                r2[r6] = r9
                r9 = r10 & 63
                byte r9 = r1[r9]
                r10 = 3
                r2[r10] = r9
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x008d
                boolean r3 = r0.f16240g
                if (r3 == 0) goto L_0x0085
                r2[r12] = r13
                r3 = 5
                goto L_0x0086
            L_0x0085:
                r3 = 4
            L_0x0086:
                int r9 = r3 + 1
                r2[r3] = r14
            L_0x008a:
                r3 = 19
                goto L_0x0090
            L_0x008d:
                r9 = 4
                goto L_0x0090
            L_0x008f:
                r9 = 0
            L_0x0090:
                int r10 = r11 + 3
                if (r10 > r4) goto L_0x00e6
                byte r15 = r18[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                byte r5 = r18[r16]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 8
                r5 = r5 | r15
                int r11 = r11 + 2
                byte r11 = r18[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r5 = r5 | r11
                int r11 = r5 >> 18
                r11 = r11 & 63
                byte r11 = r1[r11]
                r2[r9] = r11
                int r11 = r9 + 1
                int r15 = r5 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r9 + 2
                int r15 = r5 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r9 + 3
                r5 = r5 & 63
                byte r5 = r1[r5]
                r2[r11] = r5
                int r9 = r9 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x00e4
                boolean r3 = r0.f16240g
                if (r3 == 0) goto L_0x00dd
                int r3 = r9 + 1
                r2[r9] = r13
                r9 = r3
            L_0x00dd:
                int r3 = r9 + 1
                r2[r9] = r14
                r9 = r3
                r11 = r10
                goto L_0x008a
            L_0x00e4:
                r11 = r10
                goto L_0x0090
            L_0x00e6:
                if (r21 == 0) goto L_0x01d4
                int r5 = r0.f61c
                int r10 = r11 - r5
                int r15 = r4 + -1
                r16 = 61
                if (r10 != r15) goto L_0x0139
                if (r5 <= 0) goto L_0x00fa
                byte[] r6 = r0.f62d
                byte r6 = r6[r8]
                r8 = 1
                goto L_0x0100
            L_0x00fa:
                int r6 = r11 + 1
                byte r10 = r18[r11]
                r11 = r6
                r6 = r10
            L_0x0100:
                r6 = r6 & 255(0xff, float:3.57E-43)
                int r6 = r6 << r12
                int r5 = r5 - r8
                r0.f61c = r5
                int r5 = r9 + 1
                int r8 = r6 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r9] = r8
                int r8 = r5 + 1
                r6 = r6 & 63
                byte r1 = r1[r6]
                r2[r5] = r1
                boolean r1 = r0.f16238e
                if (r1 == 0) goto L_0x0124
                int r1 = r8 + 1
                r2[r8] = r16
                int r8 = r1 + 1
                r2[r1] = r16
            L_0x0124:
                boolean r1 = r0.f16239f
                if (r1 == 0) goto L_0x0136
                boolean r1 = r0.f16240g
                if (r1 == 0) goto L_0x0131
                int r1 = r8 + 1
                r2[r8] = r13
                r8 = r1
            L_0x0131:
                int r1 = r8 + 1
                r2[r8] = r14
                r8 = r1
            L_0x0136:
                r9 = r8
                goto L_0x01ba
            L_0x0139:
                int r10 = r11 - r5
                int r12 = r4 + -2
                if (r10 != r12) goto L_0x01a2
                if (r5 <= r7) goto L_0x0147
                byte[] r10 = r0.f62d
                byte r8 = r10[r8]
                r10 = 1
                goto L_0x014e
            L_0x0147:
                int r10 = r11 + 1
                byte r11 = r18[r11]
                r8 = r11
                r11 = r10
                r10 = 0
            L_0x014e:
                r8 = r8 & 255(0xff, float:3.57E-43)
                int r8 = r8 << r14
                if (r5 <= 0) goto L_0x015a
                byte[] r12 = r0.f62d
                int r15 = r10 + 1
                byte r10 = r12[r10]
                goto L_0x0161
            L_0x015a:
                int r12 = r11 + 1
                byte r11 = r18[r11]
                r15 = r10
                r10 = r11
                r11 = r12
            L_0x0161:
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r6 = r10 << 2
                r6 = r6 | r8
                int r5 = r5 - r15
                r0.f61c = r5
                int r5 = r9 + 1
                int r8 = r6 >> 12
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r9] = r8
                int r8 = r5 + 1
                int r9 = r6 >> 6
                r9 = r9 & 63
                byte r9 = r1[r9]
                r2[r5] = r9
                int r5 = r8 + 1
                r6 = r6 & 63
                byte r1 = r1[r6]
                r2[r8] = r1
                boolean r1 = r0.f16238e
                if (r1 == 0) goto L_0x018e
                int r1 = r5 + 1
                r2[r5] = r16
                r5 = r1
            L_0x018e:
                boolean r1 = r0.f16239f
                if (r1 == 0) goto L_0x01a0
                boolean r1 = r0.f16240g
                if (r1 == 0) goto L_0x019b
                int r1 = r5 + 1
                r2[r5] = r13
                r5 = r1
            L_0x019b:
                int r1 = r5 + 1
                r2[r5] = r14
                r5 = r1
            L_0x01a0:
                r9 = r5
                goto L_0x01ba
            L_0x01a2:
                boolean r1 = r0.f16239f
                if (r1 == 0) goto L_0x01ba
                if (r9 <= 0) goto L_0x01ba
                r1 = 19
                if (r3 == r1) goto L_0x01ba
                boolean r1 = r0.f16240g
                if (r1 == 0) goto L_0x01b5
                int r1 = r9 + 1
                r2[r9] = r13
                r9 = r1
            L_0x01b5:
                int r1 = r9 + 1
                r2[r9] = r14
                r9 = r1
            L_0x01ba:
                boolean r1 = f16237d
                if (r1 != 0) goto L_0x01c9
                int r2 = r0.f61c
                if (r2 != 0) goto L_0x01c3
                goto L_0x01c9
            L_0x01c3:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01c9:
                if (r1 != 0) goto L_0x01fb
                if (r11 != r4) goto L_0x01ce
                goto L_0x01fb
            L_0x01ce:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01d4:
                int r1 = r4 + -1
                if (r11 != r1) goto L_0x01e5
                byte[] r1 = r0.f62d
                int r2 = r0.f61c
                int r4 = r2 + 1
                r0.f61c = r4
                byte r4 = r18[r11]
                r1[r2] = r4
                goto L_0x01fb
            L_0x01e5:
                int r4 = r4 - r6
                if (r11 != r4) goto L_0x01fb
                byte[] r1 = r0.f62d
                int r2 = r0.f61c
                int r4 = r2 + 1
                byte r5 = r18[r11]
                r1[r2] = r5
                int r2 = r4 + 1
                r0.f61c = r2
                int r11 = r11 + r7
                byte r2 = r18[r11]
                r1[r4] = r2
            L_0x01fb:
                r0.f16234b = r9
                r0.count = r3
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.b.a.a.a.b.a(byte[], int, int, boolean):boolean");
        }
    }

    private a() {
    }

    public static String a(byte[] bArr, int i10) {
        try {
            return new String(a(bArr, i10), "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m32a(byte[] bArr, int i10) {
        return a(bArr, 0, bArr.length, i10);
    }

    public static byte[] a(byte[] bArr, int i10, int i11, int i12) {
        b bVar = new b(i12, (byte[]) null);
        int i13 = (i11 / 3) * 4;
        int i14 = 2;
        if (!bVar.f16238e) {
            int i15 = i11 % 3;
            if (i15 == 1) {
                i13 += 2;
            } else if (i15 == 2) {
                i13 += 3;
            }
        } else if (i11 % 3 > 0) {
            i13 += 4;
        }
        if (bVar.f16239f && i11 > 0) {
            int i16 = ((i11 - 1) / 57) + 1;
            if (!bVar.f16240g) {
                i14 = 1;
            }
            i13 += i16 * i14;
        }
        bVar.f16233a = new byte[i13];
        bVar.a(bArr, i10, i11, true);
        if (f16232d || bVar.f16234b == i13) {
            return bVar.f16233a;
        }
        throw new AssertionError();
    }
}
