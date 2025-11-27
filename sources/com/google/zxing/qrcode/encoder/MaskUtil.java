package com.google.zxing.qrcode.encoder;

final class MaskUtil {
    private static final int N1 = 3;
    private static final int N2 = 3;
    private static final int N3 = 40;
    private static final int N4 = 10;

    private MaskUtil() {
    }

    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z10) {
        int i10;
        int i11;
        byte b10;
        if (z10) {
            i10 = byteMatrix.getHeight();
        } else {
            i10 = byteMatrix.getWidth();
        }
        if (z10) {
            i11 = byteMatrix.getWidth();
        } else {
            i11 = byteMatrix.getHeight();
        }
        byte[][] array = byteMatrix.getArray();
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            byte b11 = -1;
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                if (z10) {
                    b10 = array[i13][i15];
                } else {
                    b10 = array[i15][i13];
                }
                if (b10 == b11) {
                    i14++;
                } else {
                    if (i14 >= 5) {
                        i12 += (i14 - 5) + 3;
                    }
                    b11 = b10;
                    i14 = 1;
                }
            }
            if (i14 >= 5) {
                i12 += (i14 - 5) + 3;
            }
        }
        return i12;
    }

    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i10 = 0;
        for (int i11 = 0; i11 < height - 1; i11++) {
            int i12 = 0;
            while (i12 < width - 1) {
                byte[] bArr = array[i11];
                byte b10 = bArr[i12];
                int i13 = i12 + 1;
                if (b10 == bArr[i13]) {
                    byte[] bArr2 = array[i11 + 1];
                    if (b10 == bArr2[i12] && b10 == bArr2[i13]) {
                        i10++;
                    }
                }
                i12 = i13;
            }
        }
        return i10 * 3;
    }

    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i10 = 0;
        for (int i11 = 0; i11 < height; i11++) {
            for (int i12 = 0; i12 < width; i12++) {
                byte[] bArr = array[i11];
                int i13 = i12 + 6;
                if (i13 < width && bArr[i12] == 1 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 1 && bArr[i12 + 3] == 1 && bArr[i12 + 4] == 1 && bArr[i12 + 5] == 0 && bArr[i13] == 1 && (isWhiteHorizontal(bArr, i12 - 4, i12) || isWhiteHorizontal(bArr, i12 + 7, i12 + 11))) {
                    i10++;
                }
                int i14 = i11 + 6;
                if (i14 < height && array[i11][i12] == 1 && array[i11 + 1][i12] == 0 && array[i11 + 2][i12] == 1 && array[i11 + 3][i12] == 1 && array[i11 + 4][i12] == 1 && array[i11 + 5][i12] == 0 && array[i14][i12] == 1 && (isWhiteVertical(array, i12, i11 - 4, i11) || isWhiteVertical(array, i12, i11 + 7, i11 + 11))) {
                    i10++;
                }
            }
        }
        return i10 * 40;
    }

    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i10 = 0;
        for (int i11 = 0; i11 < height; i11++) {
            byte[] bArr = array[i11];
            for (int i12 = 0; i12 < width; i12++) {
                if (bArr[i12] == 1) {
                    i10++;
                }
            }
        }
        int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
        return ((Math.abs((i10 << 1) - height2) * 10) / height2) * 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        r3 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r1 = r3 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r1 != 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        r1 = r1 & 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getDataMaskBit(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L_0x003e;
                case 1: goto L_0x003f;
                case 2: goto L_0x003b;
                case 3: goto L_0x0037;
                case 4: goto L_0x0032;
                case 5: goto L_0x002a;
                case 6: goto L_0x0021;
                case 7: goto L_0x0018;
                default: goto L_0x0004;
            }
        L_0x0004:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid mask pattern: "
            r3.<init>(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0018:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L_0x0028
        L_0x0021:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L_0x0028:
            r1 = r1 & r0
            goto L_0x0041
        L_0x002a:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x0041
        L_0x0032:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L_0x003e
        L_0x0037:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L_0x0041
        L_0x003b:
            int r1 = r2 % 3
            goto L_0x0041
        L_0x003e:
            int r3 = r3 + r2
        L_0x003f:
            r1 = r3 & 1
        L_0x0041:
            if (r1 != 0) goto L_0x0044
            return r0
        L_0x0044:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MaskUtil.getDataMaskBit(int, int, int):boolean");
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i10, int i11) {
        int min = Math.min(i11, bArr.length);
        for (int max = Math.max(i10, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i10, int i11, int i12) {
        int min = Math.min(i12, bArr.length);
        for (int max = Math.max(i11, 0); max < min; max++) {
            if (bArr[max][i10] == 1) {
                return false;
            }
        }
        return true;
    }
}
