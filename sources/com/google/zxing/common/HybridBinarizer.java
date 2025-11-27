package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i10, int i11, int i12, int i13) {
        int i14 = i10;
        int i15 = i11;
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i15, i14});
        for (int i16 = 0; i16 < i15; i16++) {
            int i17 = i16 << 3;
            int i18 = i13 - 8;
            if (i17 > i18) {
                i17 = i18;
            }
            for (int i19 = 0; i19 < i14; i19++) {
                int i20 = i19 << 3;
                int i21 = i12 - 8;
                if (i20 > i21) {
                    i20 = i21;
                }
                int i22 = (i17 * i12) + i20;
                int i23 = 0;
                int i24 = 0;
                byte b10 = 0;
                byte b11 = UnsignedBytes.MAX_VALUE;
                while (i23 < 8) {
                    for (int i25 = 0; i25 < 8; i25++) {
                        byte b12 = bArr[i22 + i25] & UnsignedBytes.MAX_VALUE;
                        i24 += b12;
                        if (b12 < b11) {
                            b11 = b12;
                        }
                        if (b12 > b10) {
                            b10 = b12;
                        }
                    }
                    if (b10 - b11 <= 24) {
                        i23++;
                        i22 += i12;
                    }
                    while (true) {
                        i23++;
                        i22 += i12;
                        if (i23 >= 8) {
                            break;
                        }
                        for (int i26 = 0; i26 < 8; i26++) {
                            i24 += bArr[i22 + i26] & UnsignedBytes.MAX_VALUE;
                        }
                    }
                    i23++;
                    i22 += i12;
                }
                int i27 = i24 >> 6;
                if (b10 - b11 <= 24) {
                    i27 = b11 / 2;
                    if (i16 > 0 && i19 > 0) {
                        int[] iArr2 = iArr[i16 - 1];
                        int i28 = i19 - 1;
                        int i29 = ((iArr2[i19] + (iArr[i16][i28] * 2)) + iArr2[i28]) / 4;
                        if (b11 < i29) {
                            i27 = i29;
                        }
                    }
                }
                iArr[i16][i19] = i27;
            }
        }
        return iArr;
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i10, int i11, int i12, int i13, int[][] iArr, BitMatrix bitMatrix) {
        int i14 = i10;
        int i15 = i11;
        for (int i16 = 0; i16 < i15; i16++) {
            int i17 = i16 << 3;
            int i18 = i13 - 8;
            if (i17 > i18) {
                i17 = i18;
            }
            for (int i19 = 0; i19 < i14; i19++) {
                int i20 = i19 << 3;
                int i21 = i12 - 8;
                if (i20 <= i21) {
                    i21 = i20;
                }
                int cap = cap(i19, 2, i14 - 3);
                int cap2 = cap(i16, 2, i15 - 3);
                int i22 = 0;
                for (int i23 = -2; i23 <= 2; i23++) {
                    int[] iArr2 = iArr[cap2 + i23];
                    i22 += iArr2[cap - 2] + iArr2[cap - 1] + iArr2[cap] + iArr2[cap + 1] + iArr2[cap + 2];
                }
                thresholdBlock(bArr, i21, i17, i22 / 25, i12, bitMatrix);
            }
        }
    }

    private static int cap(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    private static void thresholdBlock(byte[] bArr, int i10, int i11, int i12, int i13, BitMatrix bitMatrix) {
        int i14 = (i11 * i13) + i10;
        int i15 = 0;
        while (i15 < 8) {
            for (int i16 = 0; i16 < 8; i16++) {
                if ((bArr[i14 + i16] & UnsignedBytes.MAX_VALUE) <= i12) {
                    bitMatrix.set(i10 + i16, i11 + i15);
                }
            }
            i15++;
            i14 += i13;
        }
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    public BitMatrix getBlackMatrix() {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix2 = luminanceSource.getMatrix();
            int i10 = width >> 3;
            if ((width & 7) != 0) {
                i10++;
            }
            int i11 = i10;
            int i12 = height >> 3;
            if ((height & 7) != 0) {
                i12++;
            }
            int i13 = i12;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix2, i11, i13, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix2, i11, i13, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }
}
