package com.hpplay.component.protocol.encrypt;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;

public class Curve25519 {
    private static final long10 BASE_2Y = new long10(39999547, 18689728, 59995525, 1648697, 57546132, 24010086, 19059592, 5425144, 63499247, 16420658);
    private static final long10 BASE_R2Y = new long10(5744, 8160848, 4790893, 13779497, 35730846, 12541209, 49101323, 30047407, 40071253, 6226132);
    public static final int KEY_SIZE = 32;
    public static final byte[] ORDER = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};
    private static final byte[] ORDER_TIMES_8 = {104, -97, -82, -25, -46, Ascii.CAN, -109, -64, -78, -26, -68, Ascii.ETB, -11, -50, -9, -90, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, UnsignedBytes.MAX_POWER_OF_TWO};
    private static final int P25 = 33554431;
    private static final int P26 = 67108863;
    public static final byte[] PRIME = {-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Ascii.DEL};
    public static final byte[] ZERO = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static final class long10 {
        public long _0;
        public long _1;
        public long _2;
        public long _3;
        public long _4;
        public long _5;
        public long _6;
        public long _7;
        public long _8;
        public long _9;

        public long10() {
        }

        public long10(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
            this._0 = j10;
            this._1 = j11;
            this._2 = j12;
            this._3 = j13;
            this._4 = j14;
            this._5 = j15;
            this._6 = j16;
            this._7 = j17;
            this._8 = j18;
            this._9 = j19;
        }
    }

    private static final void add(long10 long102, long10 long103, long10 long104) {
        long102._0 = long103._0 + long104._0;
        long102._1 = long103._1 + long104._1;
        long102._2 = long103._2 + long104._2;
        long102._3 = long103._3 + long104._3;
        long102._4 = long103._4 + long104._4;
        long102._5 = long103._5 + long104._5;
        long102._6 = long103._6 + long104._6;
        long102._7 = long103._7 + long104._7;
        long102._8 = long103._8 + long104._8;
        long102._9 = long103._9 + long104._9;
    }

    public static final void clamp(byte[] bArr) {
        byte b10 = (byte) (bArr[31] & Ascii.DEL);
        bArr[31] = b10;
        bArr[31] = (byte) (b10 | SignedBytes.MAX_POWER_OF_TWO);
        bArr[0] = (byte) (bArr[0] & 248);
    }

    private static final void core(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i10;
        int i11;
        byte[] bArr5 = bArr2;
        byte[] bArr6 = bArr4;
        long10 long102 = new long10();
        long10 long103 = new long10();
        long10 long104 = new long10();
        long10 long105 = new long10();
        long10 long106 = new long10();
        int i12 = 1;
        long10[] long10Arr = {new long10(), new long10()};
        long10[] long10Arr2 = {new long10(), new long10()};
        if (bArr6 != null) {
            unpack(long102, bArr6);
        } else {
            set(long102, 9);
        }
        set(long10Arr[0], 1);
        set(long10Arr2[0], 0);
        cpy(long10Arr[1], long102);
        set(long10Arr2[1], 1);
        int i13 = 32;
        while (true) {
            int i14 = i13 - 1;
            if (i13 == 0) {
                break;
            }
            if (i14 == 0) {
                i11 = 0;
            } else {
                i11 = i14;
            }
            int i15 = 8;
            while (true) {
                int i16 = i15 - 1;
                if (i15 == 0) {
                    break;
                }
                byte b10 = bArr3[i11];
                int i17 = ((b10 & UnsignedBytes.MAX_VALUE) >> i16) & i12;
                int i18 = (((b10 & UnsignedBytes.MAX_VALUE) ^ -1) >> i16) & i12;
                long10 long107 = long10Arr[i18];
                long10 long108 = long10Arr2[i18];
                long10 long109 = long10Arr[i17];
                long10 long1010 = long10Arr2[i17];
                mont_prep(long103, long104, long107, long108);
                mont_prep(long105, long106, long109, long1010);
                long10 long1011 = long103;
                long10 long1012 = long1010;
                long10 long1013 = long104;
                long10 long1014 = long109;
                long10 long1015 = long105;
                long10 long1016 = long108;
                long10 long1017 = long106;
                mont_add(long1011, long1013, long1015, long1017, long107, long1016, long102);
                mont_dbl(long1011, long1013, long1015, long1017, long1014, long1012);
                i15 = i16;
                long10Arr2 = long10Arr2;
                i12 = 1;
            }
            i13 = i11;
        }
        long10[] long10Arr3 = long10Arr2;
        recip(long103, long10Arr3[0], 0);
        mul(long102, long10Arr[0], long103);
        pack(long102, bArr);
        if (bArr5 != null) {
            x_to_y2(long104, long103, long102);
            recip(long105, long10Arr3[1], 0);
            mul(long104, long10Arr[1], long105);
            add(long104, long104, long102);
            long104._0 += 486671;
            long102._0 -= 9;
            sqr(long105, long102);
            mul(long102, long104, long105);
            sub(long102, long102, long103);
            long102._0 -= 39420360;
            mul(long103, long102, BASE_R2Y);
            if (is_negative(long103) != 0) {
                cpy32(bArr2, bArr3);
                i10 = 32;
            } else {
                i10 = 32;
                mula_small(bArr2, ORDER_TIMES_8, 0, bArr3, 32, -1);
            }
            byte[] bArr7 = new byte[i10];
            byte[] bArr8 = ORDER;
            cpy32(bArr7, bArr8);
            cpy32(bArr5, egcd32(new byte[64], new byte[64], bArr5, bArr7));
            if ((bArr5[31] & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                mula_small(bArr2, bArr2, 0, bArr8, 32, 1);
            }
        }
    }

    private static final void cpy(long10 long102, long10 long103) {
        long102._0 = long103._0;
        long102._1 = long103._1;
        long102._2 = long103._2;
        long102._3 = long103._3;
        long102._4 = long103._4;
        long102._5 = long103._5;
        long102._6 = long103._6;
        long102._7 = long103._7;
        long102._8 = long103._8;
        long102._9 = long103._9;
    }

    private static final void cpy32(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < 32; i10++) {
            bArr[i10] = bArr2[i10];
        }
    }

    public static final void curve(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        core(bArr, (byte[]) null, bArr2, bArr3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void divmod(byte[] r15, byte[] r16, int r17, byte[] r18, int r19) {
        /*
            r6 = r19
            int r7 = r6 + -1
            byte r0 = r18[r7]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << 8
            r8 = 0
            r9 = 1
            if (r6 <= r9) goto L_0x0015
            int r1 = r6 + -2
            byte r1 = r18[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0 = r0 | r1
        L_0x0015:
            r10 = r0
            r11 = 0
            r0 = r17
        L_0x0019:
            int r12 = r0 + -1
            if (r0 < r6) goto L_0x0058
            int r0 = r11 << 16
            byte r1 = r16[r12]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 8
            r0 = r0 | r1
            if (r12 <= 0) goto L_0x002f
            int r1 = r12 + -1
            byte r1 = r16[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0 = r0 | r1
        L_0x002f:
            int r13 = r0 / r10
            int r0 = r12 - r6
            int r14 = r0 + 1
            int r5 = -r13
            r0 = r16
            r1 = r16
            r2 = r14
            r3 = r18
            r4 = r19
            int r0 = mula_small(r0, r1, r2, r3, r4, r5)
            int r11 = r11 + r0
            int r13 = r13 + r11
            r0 = r13 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r15[r14] = r0
            int r5 = -r11
            r0 = r16
            mula_small(r0, r1, r2, r3, r4, r5)
            byte r0 = r16[r12]
            r11 = r0 & 255(0xff, float:3.57E-43)
            r16[r12] = r8
            r0 = r12
            goto L_0x0019
        L_0x0058:
            byte r0 = (byte) r11
            r16[r7] = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.encrypt.Curve25519.divmod(byte[], byte[], int, byte[], int):void");
    }

    private static final byte[] egcd32(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i10;
        int i11 = 0;
        while (true) {
            i10 = 32;
            if (i11 >= 32) {
                break;
            }
            bArr2[i11] = 0;
            bArr[i11] = 0;
            i11++;
        }
        bArr[0] = 1;
        int numsize = numsize(bArr3, 32);
        if (numsize == 0) {
            return bArr2;
        }
        byte[] bArr5 = new byte[32];
        while (true) {
            int i12 = (i10 - numsize) + 1;
            divmod(bArr5, bArr4, i10, bArr3, numsize);
            i10 = numsize(bArr4, i10);
            if (i10 == 0) {
                return bArr;
            }
            mula32(bArr2, bArr, bArr5, i12, -1);
            int i13 = (numsize - i10) + 1;
            divmod(bArr5, bArr3, numsize, bArr4, i10);
            numsize = numsize(bArr3, numsize);
            if (numsize == 0) {
                return bArr2;
            }
            mula32(bArr, bArr2, bArr5, i13, -1);
        }
    }

    private static final int is_negative(long10 long102) {
        int i10;
        if (is_overflow(long102) || long102._9 < 0) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        return (int) (((long) i10) ^ (long102._0 & 1));
    }

    private static final boolean is_overflow(long10 long102) {
        if ((long102._0 <= 67108844 || (long102._1 & long102._3 & long102._5 & long102._7 & long102._9) != 33554431 || (long102._2 & long102._4 & long102._6 & long102._8) != 67108863) && long102._9 <= 33554431) {
            return false;
        }
        return true;
    }

    public static final void keygen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        clamp(bArr3);
        core(bArr, bArr2, bArr3, (byte[]) null);
    }

    private static final void mont_add(long10 long102, long10 long103, long10 long104, long10 long105, long10 long106, long10 long107, long10 long108) {
        mul(long106, long103, long104);
        mul(long107, long102, long105);
        add(long102, long106, long107);
        sub(long103, long106, long107);
        sqr(long106, long102);
        sqr(long102, long103);
        mul(long107, long102, long108);
    }

    private static final void mont_dbl(long10 long102, long10 long103, long10 long104, long10 long105, long10 long106, long10 long107) {
        sqr(long102, long104);
        sqr(long103, long105);
        mul(long106, long102, long103);
        sub(long103, long102, long103);
        mul_small(long107, long103, 121665);
        add(long102, long102, long107);
        mul(long107, long102, long103);
    }

    private static final void mont_prep(long10 long102, long10 long103, long10 long104, long10 long105) {
        add(long102, long104, long105);
        sub(long103, long104, long105);
    }

    private static final long10 mul(long10 long102, long10 long103, long10 long104) {
        long10 long105 = long102;
        long10 long106 = long103;
        long10 long107 = long104;
        long j10 = long106._0;
        long j11 = long106._1;
        long j12 = long106._2;
        long j13 = long106._3;
        long j14 = long106._4;
        long j15 = long106._5;
        long j16 = long106._6;
        long j17 = j13;
        long j18 = long106._7;
        long j19 = long106._8;
        long j20 = long106._9;
        long j21 = long107._0;
        long j22 = j11;
        long j23 = long107._1;
        long j24 = long107._2;
        long j25 = j21;
        long j26 = long107._3;
        long j27 = long107._4;
        long j28 = j19;
        long j29 = long107._5;
        long j30 = long107._6;
        long j31 = j24;
        long j32 = long107._7;
        long j33 = long107._8;
        long j34 = j16;
        long j35 = long107._9;
        long j36 = (j10 * j33) + (j12 * j30) + (j14 * j27) + (j34 * j31) + (j28 * j25) + (((j22 * j32) + (j17 * j29) + (j15 * j26) + (j18 * j23)) * 2) + (j20 * j35 * 38);
        long j37 = j36 & 67108863;
        long j38 = (j36 >> 26) + (j10 * j35) + (j22 * j33) + (j12 * j32) + (j17 * j30) + (j14 * j29) + (j15 * j27) + (j34 * j26) + (j18 * j31) + (j28 * j23) + (j20 * j25);
        long j39 = j38 & 33554431;
        long j40 = (j10 * j25) + (((j38 >> 25) + (j12 * j33) + (j14 * j30) + (j34 * j27) + (j28 * j31)) * 19) + (((j22 * j35) + (j17 * j32) + (j15 * j29) + (j18 * j26) + (j20 * j23)) * 38);
        long j41 = j27;
        long j42 = j30;
        long10 long108 = long102;
        long108._0 = j40 & 67108863;
        long j43 = (j40 >> 26) + (j10 * j23) + (j22 * j25) + (((j12 * j35) + (j17 * j33) + (j14 * j32) + (j15 * j42) + (j34 * j29) + (j18 * j41) + (j28 * j26) + (j20 * j31)) * 19);
        long j44 = j10;
        long108._1 = j43 & 33554431;
        long j45 = (j43 >> 25) + (j44 * j31) + (j12 * j25) + (((j14 * j33) + (j34 * j42) + (j28 * j41)) * 19) + (j22 * j23 * 2) + (((j17 * j35) + (j15 * j32) + (j18 * j29) + (j20 * j26)) * 38);
        long108._2 = j45 & 67108863;
        long j46 = (j45 >> 26) + (j44 * j26) + (j22 * j31) + (j12 * j23) + (j17 * j25) + (((j14 * j35) + (j15 * j33) + (j34 * j32) + (j18 * j42) + (j28 * j29) + (j20 * j41)) * 19);
        long108._3 = j46 & 33554431;
        long j47 = (j46 >> 25) + (j44 * j41) + (j12 * j31) + (j14 * j25) + (((j34 * j33) + (j28 * j42)) * 19) + (((j22 * j26) + (j17 * j23)) * 2) + (((j15 * j35) + (j18 * j32) + (j20 * j29)) * 38);
        long108._4 = j47 & 67108863;
        long j48 = (j47 >> 26) + (j44 * j29) + (j22 * j41) + (j12 * j26) + (j17 * j31) + (j14 * j23) + (j15 * j25) + (((j34 * j35) + (j18 * j33) + (j28 * j32) + (j20 * j42)) * 19);
        long108._5 = j48 & 33554431;
        long j49 = (j48 >> 25) + (j44 * j42) + (j12 * j41) + (j14 * j31) + (j34 * j25) + (j28 * j33 * 19) + (((j22 * j29) + (j17 * j26) + (j15 * j23)) * 2) + (((j18 * j35) + (j20 * j32)) * 38);
        long108._6 = j49 & 67108863;
        long j50 = (j49 >> 26) + (j44 * j32) + (j22 * j42) + (j12 * j29) + (j17 * j41) + (j14 * j26) + (j15 * j31) + (j34 * j23) + (j18 * j25) + (((j28 * j35) + (j20 * j33)) * 19);
        long108._7 = j50 & 33554431;
        long j51 = (j50 >> 25) + j37;
        long108._8 = j51 & 67108863;
        long108._9 = j39 + (j51 >> 26);
        return long108;
    }

    private static final long10 mul_small(long10 long102, long10 long103, long j10) {
        long10 long104 = long102;
        long10 long105 = long103;
        long j11 = long105._8 * j10;
        long j12 = j11 & 67108863;
        long j13 = (j11 >> 26) + (long105._9 * j10);
        long j14 = j13 & 33554431;
        long j15 = ((j13 >> 25) * 19) + (long105._0 * j10);
        long104._0 = j15 & 67108863;
        long j16 = (j15 >> 26) + (long105._1 * j10);
        long104._1 = j16 & 33554431;
        long j17 = (j16 >> 25) + (long105._2 * j10);
        long104._2 = j17 & 67108863;
        long j18 = (j17 >> 26) + (long105._3 * j10);
        long104._3 = j18 & 33554431;
        long j19 = (j18 >> 25) + (long105._4 * j10);
        long104._4 = j19 & 67108863;
        long j20 = (j19 >> 26) + (long105._5 * j10);
        long104._5 = j20 & 33554431;
        long j21 = (j20 >> 25) + (long105._6 * j10);
        long104._6 = j21 & 67108863;
        long j22 = (j21 >> 26) + (long105._7 * j10);
        long104._7 = 33554431 & j22;
        long j23 = (j22 >> 25) + j12;
        long104._8 = 67108863 & j23;
        long104._9 = j14 + (j23 >> 26);
        return long104;
    }

    private static final int mula32(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, int i11) {
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = i11 * (bArr3[i12] & UnsignedBytes.MAX_VALUE);
            int i15 = i12 + 31;
            int mula_small = i13 + mula_small(bArr, bArr, i12, bArr2, 31, i14) + (bArr[i15] & UnsignedBytes.MAX_VALUE) + (i14 * (bArr2[31] & UnsignedBytes.MAX_VALUE));
            bArr[i15] = (byte) mula_small;
            i13 = mula_small >> 8;
            i12++;
        }
        int i16 = i12 + 31;
        bArr[i16] = (byte) ((bArr[i16] & UnsignedBytes.MAX_VALUE) + i13);
        return i13 >> 8;
    }

    private static final int mula_small(byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i14 + i10;
            int i16 = i13 + (bArr2[i15] & UnsignedBytes.MAX_VALUE) + ((bArr3[i14] & UnsignedBytes.MAX_VALUE) * i12);
            bArr[i15] = (byte) i16;
            i13 = i16 >> 8;
        }
        return i13;
    }

    private static final int numsize(byte[] bArr, int i10) {
        int i11;
        while (true) {
            i11 = i10 - 1;
            if (i10 != 0 && bArr[i11] == 0) {
                i10 = i11;
            }
        }
        return i11 + 1;
    }

    private static final void pack(long10 long102, byte[] bArr) {
        boolean z10;
        long10 long103 = long102;
        boolean is_overflow = is_overflow(long102);
        long j10 = long103._9;
        if (j10 < 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i10 = (is_overflow ? 1 : 0) - (z10 ? 1 : 0);
        long j11 = ((long) (i10 * 19)) + long103._0 + (long103._1 << 26);
        bArr[0] = (byte) ((int) j11);
        bArr[1] = (byte) ((int) (j11 >> 8));
        bArr[2] = (byte) ((int) (j11 >> 16));
        bArr[3] = (byte) ((int) (j11 >> 24));
        long j12 = (j11 >> 32) + (long103._2 << 19);
        bArr[4] = (byte) ((int) j12);
        bArr[5] = (byte) ((int) (j12 >> 8));
        bArr[6] = (byte) ((int) (j12 >> 16));
        bArr[7] = (byte) ((int) (j12 >> 24));
        long j13 = (j12 >> 32) + (long103._3 << 13);
        bArr[8] = (byte) ((int) j13);
        bArr[9] = (byte) ((int) (j13 >> 8));
        bArr[10] = (byte) ((int) (j13 >> 16));
        bArr[11] = (byte) ((int) (j13 >> 24));
        long j14 = (j13 >> 32) + (long103._4 << 6);
        bArr[12] = (byte) ((int) j14);
        bArr[13] = (byte) ((int) (j14 >> 8));
        bArr[14] = (byte) ((int) (j14 >> 16));
        bArr[15] = (byte) ((int) (j14 >> 24));
        long j15 = (j14 >> 32) + long103._5 + (long103._6 << 25);
        bArr[16] = (byte) ((int) j15);
        bArr[17] = (byte) ((int) (j15 >> 8));
        bArr[18] = (byte) ((int) (j15 >> 16));
        bArr[19] = (byte) ((int) (j15 >> 24));
        long j16 = (j15 >> 32) + (long103._7 << 19);
        bArr[20] = (byte) ((int) j16);
        bArr[21] = (byte) ((int) (j16 >> 8));
        bArr[22] = (byte) ((int) (j16 >> 16));
        bArr[23] = (byte) ((int) (j16 >> 24));
        long j17 = (j16 >> 32) + (long103._8 << 12);
        bArr[24] = (byte) ((int) j17);
        bArr[25] = (byte) ((int) (j17 >> 8));
        bArr[26] = (byte) ((int) (j17 >> 16));
        bArr[27] = (byte) ((int) (j17 >> 24));
        long j18 = (j17 >> 32) + ((j10 + ((long) (-33554432 * i10))) << 6);
        bArr[28] = (byte) ((int) j18);
        bArr[29] = (byte) ((int) (j18 >> 8));
        bArr[30] = (byte) ((int) (j18 >> 16));
        bArr[31] = (byte) ((int) (j18 >> 24));
    }

    private static final void recip(long10 long102, long10 long103, int i10) {
        long10 long104 = new long10();
        long10 long105 = new long10();
        long10 long106 = new long10();
        long10 long107 = new long10();
        long10 long108 = new long10();
        sqr(long105, long103);
        sqr(long106, long105);
        sqr(long104, long106);
        mul(long106, long104, long103);
        mul(long104, long106, long105);
        sqr(long105, long104);
        mul(long107, long105, long106);
        sqr(long105, long107);
        sqr(long106, long105);
        sqr(long105, long106);
        sqr(long106, long105);
        sqr(long105, long106);
        mul(long106, long105, long107);
        sqr(long105, long106);
        sqr(long107, long105);
        for (int i11 = 1; i11 < 5; i11++) {
            sqr(long105, long107);
            sqr(long107, long105);
        }
        mul(long105, long107, long106);
        sqr(long107, long105);
        sqr(long108, long107);
        for (int i12 = 1; i12 < 10; i12++) {
            sqr(long107, long108);
            sqr(long108, long107);
        }
        mul(long107, long108, long105);
        for (int i13 = 0; i13 < 5; i13++) {
            sqr(long105, long107);
            sqr(long107, long105);
        }
        mul(long105, long107, long106);
        sqr(long106, long105);
        sqr(long107, long106);
        for (int i14 = 1; i14 < 25; i14++) {
            sqr(long106, long107);
            sqr(long107, long106);
        }
        mul(long106, long107, long105);
        sqr(long107, long106);
        sqr(long108, long107);
        for (int i15 = 1; i15 < 50; i15++) {
            sqr(long107, long108);
            sqr(long108, long107);
        }
        mul(long107, long108, long106);
        for (int i16 = 0; i16 < 25; i16++) {
            sqr(long108, long107);
            sqr(long107, long108);
        }
        mul(long106, long107, long105);
        sqr(long105, long106);
        sqr(long106, long105);
        if (i10 != 0) {
            mul(long102, long103, long106);
            return;
        }
        sqr(long105, long106);
        sqr(long106, long105);
        sqr(long105, long106);
        mul(long102, long105, long104);
    }

    private static final void set(long10 long102, int i10) {
        long102._0 = (long) i10;
        long102._1 = 0;
        long102._2 = 0;
        long102._3 = 0;
        long102._4 = 0;
        long102._5 = 0;
        long102._6 = 0;
        long102._7 = 0;
        long102._8 = 0;
        long102._9 = 0;
    }

    public static final boolean sign(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[32];
        byte[] bArr6 = new byte[32];
        byte[] bArr7 = new byte[64];
        cpy32(bArr5, bArr2);
        cpy32(bArr6, bArr3);
        byte[] bArr8 = new byte[32];
        byte[] bArr9 = ORDER;
        divmod(bArr8, bArr5, 32, bArr9, 32);
        divmod(bArr8, bArr6, 32, bArr9, 32);
        byte[] bArr10 = bArr;
        mula_small(bArr10, bArr6, 0, bArr5, 32, -1);
        mula_small(bArr10, bArr, 0, bArr9, 32, 1);
        mula32(bArr7, bArr, bArr4, 32, 1);
        divmod(new byte[64], bArr7, 64, bArr9, 32);
        byte b10 = 0;
        for (int i10 = 0; i10 < 32; i10++) {
            byte b11 = bArr7[i10];
            bArr[i10] = b11;
            b10 |= b11;
        }
        if (b10 != 0) {
            return true;
        }
        return false;
    }

    private static final long10 sqr(long10 long102, long10 long103) {
        long10 long104 = long102;
        long10 long105 = long103;
        long j10 = long105._0;
        long j11 = long105._1;
        long j12 = long105._2;
        long j13 = long105._3;
        long j14 = long105._4;
        long j15 = long105._5;
        long j16 = long105._6;
        long j17 = j13;
        long j18 = long105._7;
        long j19 = j15;
        long j20 = long105._8;
        long j21 = long105._9;
        long j22 = (j14 * j14) + (((j10 * j20) + (j12 * j16)) * 2) + (j21 * j21 * 38) + (((j11 * j18) + (j17 * j19)) * 4);
        long j23 = j22 & 67108863;
        long j24 = (j22 >> 26) + (((j10 * j21) + (j11 * j20) + (j12 * j18) + (j17 * j16) + (j14 * j19)) * 2);
        long j25 = j24 & 33554431;
        long j26 = ((j24 >> 25) * 19) + (j10 * j10) + (((j12 * j20) + (j14 * j16) + (j19 * j19)) * 38) + (((j11 * j21) + (j17 * j18)) * 76);
        long j27 = j21;
        long j28 = j16;
        long10 long106 = long102;
        long106._0 = j26 & 67108863;
        long j29 = (j26 >> 26) + (j10 * j11 * 2) + (((j12 * j27) + (j17 * j20) + (j14 * j18) + (j19 * j28)) * 38);
        long j30 = j18;
        long106._1 = j29 & 33554431;
        long j31 = (j29 >> 25) + (j28 * j28 * 19) + (((j10 * j12) + (j11 * j11)) * 2) + (j14 * j20 * 38) + (((j17 * j27) + (j19 * j30)) * 76);
        long106._2 = j31 & 67108863;
        long j32 = (j31 >> 26) + (((j10 * j17) + (j11 * j12)) * 2) + (((j14 * j27) + (j19 * j20) + (j28 * j30)) * 38);
        long106._3 = j32 & 33554431;
        long j33 = (j32 >> 25) + (j12 * j12) + (j10 * j14 * 2) + (((j28 * j20) + (j30 * j30)) * 38) + (j11 * j17 * 4) + (j19 * j27 * 76);
        long106._4 = j33 & 67108863;
        long j34 = (j33 >> 26) + (((j10 * j19) + (j11 * j14) + (j12 * j17)) * 2) + (((j28 * j27) + (j30 * j20)) * 38);
        long106._5 = j34 & 33554431;
        long j35 = (j34 >> 25) + (j20 * j20 * 19) + (((j10 * j28) + (j12 * j14) + (j17 * j17)) * 2) + (j11 * j19 * 4) + (j30 * j27 * 76);
        long106._6 = j35 & 67108863;
        long j36 = (j35 >> 26) + (((j10 * j30) + (j11 * j28) + (j12 * j19) + (j17 * j14)) * 2) + (j20 * j27 * 38);
        long106._7 = j36 & 33554431;
        long j37 = (j36 >> 25) + j23;
        long106._8 = j37 & 67108863;
        long106._9 = j25 + (j37 >> 26);
        return long106;
    }

    private static final void sqrt(long10 long102, long10 long103) {
        long10 long104 = new long10();
        long10 long105 = new long10();
        long10 long106 = new long10();
        add(long105, long103, long103);
        recip(long104, long105, 1);
        sqr(long102, long104);
        mul(long106, long105, long102);
        long106._0--;
        mul(long105, long104, long106);
        mul(long102, long103, long105);
    }

    private static final void sub(long10 long102, long10 long103, long10 long104) {
        long102._0 = long103._0 - long104._0;
        long102._1 = long103._1 - long104._1;
        long102._2 = long103._2 - long104._2;
        long102._3 = long103._3 - long104._3;
        long102._4 = long103._4 - long104._4;
        long102._5 = long103._5 - long104._5;
        long102._6 = long103._6 - long104._6;
        long102._7 = long103._7 - long104._7;
        long102._8 = long103._8 - long104._8;
        long102._9 = long103._9 - long104._9;
    }

    private static final void unpack(long10 long102, byte[] bArr) {
        long10 long103 = long102;
        byte b10 = bArr[3];
        long103._0 = (long) ((bArr[0] & UnsignedBytes.MAX_VALUE) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 16) | (((b10 & UnsignedBytes.MAX_VALUE) & 3) << Ascii.CAN));
        int i10 = (((b10 & UnsignedBytes.MAX_VALUE) & -4) >> 2) | ((bArr[4] & UnsignedBytes.MAX_VALUE) << 6) | ((bArr[5] & UnsignedBytes.MAX_VALUE) << 14);
        byte b11 = bArr[6];
        long103._1 = (long) (i10 | (((b11 & UnsignedBytes.MAX_VALUE) & 7) << Ascii.SYN));
        int i11 = (((b11 & UnsignedBytes.MAX_VALUE) & -8) >> 3) | ((bArr[7] & UnsignedBytes.MAX_VALUE) << 5) | ((bArr[8] & UnsignedBytes.MAX_VALUE) << 13);
        byte b12 = bArr[9];
        long103._2 = (long) (i11 | (((b12 & UnsignedBytes.MAX_VALUE) & Ascii.US) << Ascii.NAK));
        byte b13 = bArr[12];
        long103._3 = (long) ((((b12 & UnsignedBytes.MAX_VALUE) & -32) >> 5) | ((bArr[10] & UnsignedBytes.MAX_VALUE) << 3) | ((bArr[11] & UnsignedBytes.MAX_VALUE) << 11) | (((b13 & UnsignedBytes.MAX_VALUE) & 63) << 19));
        long103._4 = (long) ((((b13 & UnsignedBytes.MAX_VALUE) & -64) >> 6) | ((bArr[13] & UnsignedBytes.MAX_VALUE) << 2) | ((bArr[14] & UnsignedBytes.MAX_VALUE) << 10) | ((bArr[15] & UnsignedBytes.MAX_VALUE) << Ascii.DC2));
        byte b14 = ((bArr[18] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[17] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[16] & UnsignedBytes.MAX_VALUE);
        byte b15 = bArr[19];
        long103._5 = (long) (b14 | (((b15 & UnsignedBytes.MAX_VALUE) & 1) << Ascii.CAN));
        int i12 = (((b15 & UnsignedBytes.MAX_VALUE) & -2) >> 1) | ((bArr[20] & UnsignedBytes.MAX_VALUE) << 7) | ((bArr[21] & UnsignedBytes.MAX_VALUE) << 15);
        byte b16 = bArr[22];
        long103._6 = (long) (i12 | ((7 & (b16 & UnsignedBytes.MAX_VALUE)) << Ascii.ETB));
        int i13 = (((b16 & UnsignedBytes.MAX_VALUE) & -8) >> 3) | ((bArr[23] & UnsignedBytes.MAX_VALUE) << 5) | ((bArr[24] & UnsignedBytes.MAX_VALUE) << 13);
        byte b17 = bArr[25];
        long103._7 = (long) (i13 | (((b17 & UnsignedBytes.MAX_VALUE) & 15) << Ascii.NAK));
        int i14 = (((b17 & UnsignedBytes.MAX_VALUE) & -16) >> 4) | ((bArr[26] & UnsignedBytes.MAX_VALUE) << 4) | ((bArr[27] & UnsignedBytes.MAX_VALUE) << 12);
        byte b18 = bArr[28];
        long103._8 = (long) (i14 | (((b18 & UnsignedBytes.MAX_VALUE) & 63) << Ascii.DC4));
        long103._9 = (long) ((((b18 & UnsignedBytes.MAX_VALUE) & -64) >> 6) | ((bArr[29] & UnsignedBytes.MAX_VALUE) << 2) | ((bArr[30] & UnsignedBytes.MAX_VALUE) << 10) | ((bArr[31] & UnsignedBytes.MAX_VALUE) << Ascii.DC2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void verify(byte[] r25, byte[] r26, byte[] r27, byte[] r28) {
        /*
            r0 = 32
            byte[] r1 = new byte[r0]
            r2 = 2
            com.hpplay.component.protocol.encrypt.Curve25519$long10[] r3 = new com.hpplay.component.protocol.encrypt.Curve25519.long10[r2]
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r4 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r4.<init>()
            r5 = 0
            r3[r5] = r4
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r4 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r4.<init>()
            r6 = 1
            r3[r6] = r4
            com.hpplay.component.protocol.encrypt.Curve25519$long10[] r4 = new com.hpplay.component.protocol.encrypt.Curve25519.long10[r2]
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r7 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r7.<init>()
            r4[r5] = r7
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r7 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r7.<init>()
            r4[r6] = r7
            r7 = 3
            com.hpplay.component.protocol.encrypt.Curve25519$long10[] r8 = new com.hpplay.component.protocol.encrypt.Curve25519.long10[r7]
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r9 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r9.<init>()
            r8[r5] = r9
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r9 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r9.<init>()
            r8[r6] = r9
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r9 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r9.<init>()
            r8[r2] = r9
            com.hpplay.component.protocol.encrypt.Curve25519$long10[] r9 = new com.hpplay.component.protocol.encrypt.Curve25519.long10[r7]
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r10 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r10.<init>()
            r9[r5] = r10
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r10 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r10.<init>()
            r9[r6] = r10
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r10 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r10.<init>()
            r9[r2] = r10
            com.hpplay.component.protocol.encrypt.Curve25519$long10[] r10 = new com.hpplay.component.protocol.encrypt.Curve25519.long10[r7]
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r11 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r11.<init>()
            r10[r5] = r11
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r11 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r11.<init>()
            r10[r6] = r11
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r11 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r11.<init>()
            r10[r2] = r11
            com.hpplay.component.protocol.encrypt.Curve25519$long10[] r7 = new com.hpplay.component.protocol.encrypt.Curve25519.long10[r7]
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r11 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r11.<init>()
            r7[r5] = r11
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r11 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r11.<init>()
            r7[r6] = r11
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r11 = new com.hpplay.component.protocol.encrypt.Curve25519$long10
            r11.<init>()
            r7[r2] = r11
            r11 = r3[r5]
            r12 = 9
            set(r11, r12)
            r11 = r3[r6]
            r12 = r28
            unpack(r11, r12)
            r11 = r10[r5]
            r12 = r7[r5]
            r13 = r3[r6]
            x_to_y2(r11, r12, r13)
            r11 = r10[r5]
            r12 = r7[r5]
            sqrt(r11, r12)
            r11 = r10[r5]
            int r11 = is_negative(r11)
            r12 = r7[r5]
            long r13 = r12._0
            r15 = 39420360(0x25981c8, double:1.94762456E-316)
            long r13 = r13 + r15
            r12._0 = r13
            r12 = r7[r6]
            com.hpplay.component.protocol.encrypt.Curve25519$long10 r13 = BASE_2Y
            r14 = r10[r5]
            mul(r12, r13, r14)
            r12 = r10[r11]
            r13 = r7[r5]
            r14 = r7[r6]
            sub(r12, r13, r14)
            int r11 = 1 - r11
            r11 = r10[r11]
            r12 = r7[r5]
            r13 = r7[r6]
            add(r11, r12, r13)
            r11 = r7[r5]
            r12 = r3[r6]
            cpy(r11, r12)
            r11 = r7[r5]
            long r12 = r11._0
            r14 = 9
            long r12 = r12 - r14
            r11._0 = r12
            r12 = r7[r6]
            sqr(r12, r11)
            r11 = r7[r5]
            r12 = r7[r6]
            recip(r11, r12, r5)
            r11 = r4[r5]
            r12 = r10[r5]
            r13 = r7[r5]
            mul(r11, r12, r13)
            r11 = r4[r5]
            r12 = r3[r6]
            sub(r11, r11, r12)
            r11 = r4[r5]
            long r12 = r11._0
            r14 = 486671(0x76d0f, double:2.404474E-318)
            long r12 = r12 - r14
            r11._0 = r12
            r11 = r4[r6]
            r12 = r10[r6]
            r13 = r7[r5]
            mul(r11, r12, r13)
            r11 = r4[r6]
            r12 = r3[r6]
            sub(r11, r11, r12)
            r11 = r4[r6]
            long r12 = r11._0
            long r12 = r12 - r14
            r11._0 = r12
            r11 = r4[r5]
            r12 = 1
            mul_small(r11, r11, r12)
            r11 = r4[r6]
            mul_small(r11, r11, r12)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x012d:
            r16 = 8
            if (r11 >= r0) goto L_0x017e
            int r12 = r14 >> 8
            byte r14 = r26[r11]
            r0 = r14 & 255(0xff, float:3.57E-43)
            r0 = r0 ^ r12
            r12 = r14 & 255(0xff, float:3.57E-43)
            int r12 = r12 << r6
            r14 = r0 ^ r12
            int r0 = r15 >> 8
            byte r12 = r27[r11]
            r15 = r12 & 255(0xff, float:3.57E-43)
            r0 = r0 ^ r15
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << r6
            r15 = r0 ^ r12
            r0 = r14 ^ r15
            r12 = r0 ^ -1
            r0 = r13 & 128(0x80, float:1.794E-43)
            int r0 = r0 >> 7
            r0 = r0 & r12
            r0 = r0 ^ r14
            r13 = r0 & 1
            int r13 = r13 << r6
            r13 = r13 & r12
            r0 = r0 ^ r13
            r13 = r0 & 2
            int r13 = r13 << r6
            r13 = r13 & r12
            r0 = r0 ^ r13
            r13 = r0 & 4
            int r13 = r13 << r6
            r13 = r13 & r12
            r0 = r0 ^ r13
            r13 = r0 & 8
            int r13 = r13 << r6
            r13 = r13 & r12
            r0 = r0 ^ r13
            r13 = r0 & 16
            int r13 = r13 << r6
            r13 = r13 & r12
            r0 = r0 ^ r13
            r13 = r0 & 32
            int r13 = r13 << r6
            r13 = r13 & r12
            r0 = r0 ^ r13
            r13 = r0 & 64
            int r13 = r13 << r6
            r13 = r13 & r12
            r13 = r13 ^ r0
            byte r0 = (byte) r13
            r1[r11] = r0
            int r11 = r11 + 1
            r0 = 32
            goto L_0x012d
        L_0x017e:
            r0 = r13 & 128(0x80, float:1.794E-43)
            int r0 = r0 << r6
            r0 = r0 & r12
            r0 = r0 ^ r14
            int r0 = r0 >> 8
            r11 = r8[r5]
            set(r11, r6)
            r11 = r8[r6]
            r12 = r3[r0]
            cpy(r11, r12)
            r11 = r8[r2]
            r12 = r4[r5]
            cpy(r11, r12)
            r11 = r9[r5]
            set(r11, r5)
            r11 = r9[r6]
            set(r11, r6)
            r11 = r9[r2]
            set(r11, r6)
            r11 = r0
            r0 = 32
            r12 = 0
            r13 = 0
        L_0x01ac:
            int r14 = r0 + -1
            if (r0 == 0) goto L_0x024a
            int r0 = r12 << 8
            byte r12 = r26[r14]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r12 | r0
            int r0 = r13 << 8
            byte r13 = r27[r14]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r13 = r13 | r0
            int r0 = r11 << 8
            byte r11 = r1[r14]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r11 = r11 | r0
            r0 = 8
        L_0x01c7:
            int r15 = r0 + -1
            if (r0 == 0) goto L_0x0247
            r0 = r10[r5]
            r2 = r7[r5]
            r6 = r8[r5]
            r17 = r1
            r1 = r9[r5]
            mont_prep(r0, r2, r6, r1)
            r0 = 1
            r1 = r10[r0]
            r2 = r7[r0]
            r6 = r8[r0]
            r5 = r9[r0]
            mont_prep(r1, r2, r6, r5)
            r1 = 2
            r2 = r10[r1]
            r5 = r7[r1]
            r6 = r8[r1]
            r0 = r9[r1]
            mont_prep(r2, r5, r6, r0)
            int r0 = r12 >> 1
            r0 = r0 ^ r12
            int r0 = r0 >> r15
            r1 = 1
            r0 = r0 & r1
            int r2 = r13 >> 1
            r2 = r2 ^ r13
            int r2 = r2 >> r15
            r2 = r2 & r1
            int r0 = r0 + r2
            r1 = 2
            r18 = r8[r1]
            r19 = r9[r1]
            r20 = r10[r0]
            r21 = r7[r0]
            r0 = 0
            r22 = r8[r0]
            r23 = r9[r0]
            mont_dbl(r18, r19, r20, r21, r22, r23)
            int r0 = r11 >> r15
            r1 = r0 & 2
            r2 = 1
            r0 = r0 & r2
            int r5 = r0 << 1
            r1 = r1 ^ r5
            r18 = r10[r2]
            r19 = r7[r2]
            r20 = r10[r1]
            r21 = r7[r1]
            r22 = r8[r2]
            r23 = r9[r2]
            r24 = r3[r0]
            mont_add(r18, r19, r20, r21, r22, r23, r24)
            r0 = 2
            r18 = r10[r0]
            r19 = r7[r0]
            r1 = 0
            r20 = r10[r1]
            r21 = r7[r1]
            r22 = r8[r0]
            r23 = r9[r0]
            r1 = r12 ^ r13
            int r1 = r1 >> r15
            r1 = r1 & r0
            r2 = 1
            int r1 = r1 >> r2
            r24 = r4[r1]
            mont_add(r18, r19, r20, r21, r22, r23, r24)
            r0 = r15
            r1 = r17
            r2 = 2
            r5 = 0
            r6 = 1
            goto L_0x01c7
        L_0x0247:
            r0 = r14
            goto L_0x01ac
        L_0x024a:
            r1 = 1
            r0 = r12 & 1
            r2 = r13 & 1
            int r0 = r0 + r2
            r2 = 0
            r3 = r10[r2]
            r4 = r9[r0]
            recip(r3, r4, r2)
            r3 = r10[r1]
            r0 = r8[r0]
            r2 = r10[r2]
            mul(r3, r0, r2)
            r0 = r10[r1]
            r1 = r25
            pack(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.encrypt.Curve25519.verify(byte[], byte[], byte[], byte[]):void");
    }

    private static final void x_to_y2(long10 long102, long10 long103, long10 long104) {
        sqr(long102, long104);
        mul_small(long103, long104, 486662);
        add(long102, long102, long103);
        long102._0++;
        mul(long103, long102, long104);
    }
}
