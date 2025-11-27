package com.umeng.message.proguard;

import com.google.common.base.Ascii;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;

public final class bf extends bg {

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f15497g = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f15498h = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, 63, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f15499i = f15497g;

    /* renamed from: j  reason: collision with root package name */
    private final int f15500j = (4 - 1);

    /* renamed from: k  reason: collision with root package name */
    private final int f15501k = 4;

    /* renamed from: l  reason: collision with root package name */
    private int f15502l;

    private static byte[] f(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        bf bfVar = new bf();
        long c10 = super.c(bArr);
        if (c10 <= TTL.MAX_VALUE) {
            return super.d(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + c10 + ") than the specified maximum size of 2147483647");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(byte[] r9, int r10, int r11) {
        /*
            r8 = this;
            boolean r0 = r8.f15506d
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            if (r11 >= 0) goto L_0x0084
            r8.f15506d = r0
            int r9 = r8.f15508f
            if (r9 != 0) goto L_0x000f
            return
        L_0x000f:
            int r9 = r8.f15501k
            r8.a(r9)
            int r9 = r8.f15505c
            int r10 = r8.f15508f
            r11 = 61
            if (r10 == r0) goto L_0x0051
            r0 = 2
            if (r10 == r0) goto L_0x0020
            goto L_0x007b
        L_0x0020:
            byte[] r10 = r8.f15504b
            int r1 = r9 + 1
            byte[] r2 = r8.f15499i
            int r3 = r8.f15502l
            int r4 = r3 >> 10
            r4 = r4 & 63
            byte r4 = r2[r4]
            r10[r9] = r4
            int r4 = r1 + 1
            int r5 = r3 >> 4
            r5 = r5 & 63
            byte r5 = r2[r5]
            r10[r1] = r5
            int r1 = r4 + 1
            r8.f15505c = r1
            int r0 = r3 << 2
            r0 = r0 & 63
            byte r0 = r2[r0]
            r10[r4] = r0
            byte[] r0 = f15497g
            if (r2 != r0) goto L_0x007b
            int r0 = r1 + 1
            r8.f15505c = r0
            r10[r1] = r11
            goto L_0x007b
        L_0x0051:
            byte[] r10 = r8.f15504b
            int r0 = r9 + 1
            byte[] r1 = r8.f15499i
            int r2 = r8.f15502l
            int r3 = r2 >> 2
            r3 = r3 & 63
            byte r3 = r1[r3]
            r10[r9] = r3
            int r3 = r0 + 1
            r8.f15505c = r3
            int r2 = r2 << 4
            r2 = r2 & 63
            byte r2 = r1[r2]
            r10[r0] = r2
            byte[] r0 = f15497g
            if (r1 != r0) goto L_0x007b
            int r0 = r3 + 1
            r10[r3] = r11
            int r1 = r0 + 1
            r8.f15505c = r1
            r10[r0] = r11
        L_0x007b:
            int r10 = r8.f15507e
            int r11 = r8.f15505c
            int r11 = r11 - r9
            int r10 = r10 + r11
            r8.f15507e = r10
            return
        L_0x0084:
            r1 = 0
        L_0x0085:
            if (r1 >= r11) goto L_0x00dc
            int r2 = r8.f15501k
            r8.a(r2)
            int r2 = r8.f15508f
            int r2 = r2 + r0
            int r2 = r2 % 3
            r8.f15508f = r2
            int r3 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x009b
            int r10 = r10 + 256
        L_0x009b:
            int r4 = r8.f15502l
            int r4 = r4 << 8
            int r4 = r4 + r10
            r8.f15502l = r4
            if (r2 != 0) goto L_0x00d8
            byte[] r10 = r8.f15504b
            int r2 = r8.f15505c
            int r5 = r2 + 1
            byte[] r6 = r8.f15499i
            int r7 = r4 >> 18
            r7 = r7 & 63
            byte r7 = r6[r7]
            r10[r2] = r7
            int r2 = r5 + 1
            int r7 = r4 >> 12
            r7 = r7 & 63
            byte r7 = r6[r7]
            r10[r5] = r7
            int r5 = r2 + 1
            int r7 = r4 >> 6
            r7 = r7 & 63
            byte r7 = r6[r7]
            r10[r2] = r7
            int r2 = r5 + 1
            r8.f15505c = r2
            r2 = r4 & 63
            byte r2 = r6[r2]
            r10[r5] = r2
            int r10 = r8.f15507e
            int r10 = r10 + 4
            r8.f15507e = r10
        L_0x00d8:
            int r1 = r1 + 1
            r10 = r3
            goto L_0x0085
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.bf.a(byte[], int, int):void");
    }

    public final /* bridge */ /* synthetic */ byte[] b(String str) {
        return super.b(str);
    }

    public final /* bridge */ /* synthetic */ long c(byte[] bArr) {
        return super.c(bArr);
    }

    public final /* bridge */ /* synthetic */ byte[] d(byte[] bArr) {
        return super.d(bArr);
    }

    public final /* bridge */ /* synthetic */ byte[] e(byte[] bArr) {
        return super.e(bArr);
    }

    public final void b(byte[] bArr, int i10, int i11) {
        byte b10;
        if (!this.f15506d) {
            if (i11 < 0) {
                this.f15506d = true;
            }
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                }
                a(this.f15500j);
                int i13 = i10 + 1;
                byte b11 = bArr[i10];
                if (b11 == 61) {
                    this.f15506d = true;
                    break;
                }
                if (b11 >= 0) {
                    byte[] bArr2 = f15498h;
                    if (b11 < bArr2.length && (b10 = bArr2[b11]) >= 0) {
                        int i14 = (this.f15508f + 1) % 4;
                        this.f15508f = i14;
                        int i15 = (this.f15502l << 6) + b10;
                        this.f15502l = i15;
                        if (i14 == 0) {
                            byte[] bArr3 = this.f15504b;
                            int i16 = this.f15505c;
                            int i17 = i16 + 1;
                            bArr3[i16] = (byte) ((i15 >> 16) & 255);
                            int i18 = i17 + 1;
                            bArr3[i17] = (byte) ((i15 >> 8) & 255);
                            this.f15505c = i18 + 1;
                            bArr3[i18] = (byte) (i15 & 255);
                        }
                    }
                }
                i12++;
                i10 = i13;
            }
            if (this.f15506d && this.f15508f != 0) {
                a(this.f15500j);
                int i19 = this.f15508f;
                if (i19 == 2) {
                    int i20 = this.f15502l >> 4;
                    this.f15502l = i20;
                    byte[] bArr4 = this.f15504b;
                    int i21 = this.f15505c;
                    this.f15505c = i21 + 1;
                    bArr4[i21] = (byte) (i20 & 255);
                } else if (i19 == 3) {
                    int i22 = this.f15502l >> 2;
                    this.f15502l = i22;
                    byte[] bArr5 = this.f15504b;
                    int i23 = this.f15505c;
                    int i24 = i23 + 1;
                    bArr5[i23] = (byte) ((i22 >> 8) & 255);
                    this.f15505c = i24 + 1;
                    bArr5[i24] = (byte) (i22 & 255);
                }
            }
        }
    }

    public static byte[] b(byte[] bArr) {
        return f(bArr);
    }

    public static String a(byte[] bArr) {
        return new String(f(bArr));
    }

    public static byte[] a(String str) {
        return super.b(str);
    }
}
