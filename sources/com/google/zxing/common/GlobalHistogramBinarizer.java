package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets = new int[32];
    private byte[] luminances = EMPTY;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int estimateBlackPoint(int[] iArr) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = iArr[i13];
            if (i14 > i10) {
                i12 = i13;
                i10 = i14;
            }
            if (i14 > i11) {
                i11 = i14;
            }
        }
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            int i18 = i17 - i12;
            int i19 = iArr[i17] * i18 * i18;
            if (i19 > i16) {
                i15 = i17;
                i16 = i19;
            }
        }
        if (i12 <= i15) {
            int i20 = i12;
            i12 = i15;
            i15 = i20;
        }
        if (i12 - i15 > length / 16) {
            int i21 = i12 - 1;
            int i22 = i21;
            int i23 = -1;
            while (i21 > i15) {
                int i24 = i21 - i15;
                int i25 = i24 * i24 * (i12 - i21) * (i11 - iArr[i21]);
                if (i25 > i23) {
                    i22 = i21;
                    i23 = i25;
                }
                i21--;
            }
            return i22 << 3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void initArrays(int i10) {
        if (this.luminances.length < i10) {
            this.luminances = new byte[i10];
        }
        for (int i11 = 0; i11 < 32; i11++) {
            this.buckets[i11] = 0;
        }
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    public BitMatrix getBlackMatrix() {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (int i10 = 1; i10 < 5; i10++) {
            byte[] row = luminanceSource.getRow((height * i10) / 5, this.luminances);
            int i11 = (width << 2) / 5;
            for (int i12 = width / 5; i12 < i11; i12++) {
                int i13 = (row[i12] & UnsignedBytes.MAX_VALUE) >> 3;
                iArr[i13] = iArr[i13] + 1;
            }
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i14 = 0; i14 < height; i14++) {
            int i15 = i14 * width;
            for (int i16 = 0; i16 < width; i16++) {
                if ((matrix[i15 + i16] & UnsignedBytes.MAX_VALUE) < estimateBlackPoint) {
                    bitMatrix.set(i16, i14);
                }
            }
        }
        return bitMatrix;
    }

    public BitArray getBlackRow(int i10, BitArray bitArray) {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i10, this.luminances);
        int[] iArr = this.buckets;
        for (int i11 = 0; i11 < width; i11++) {
            int i12 = (row[i11] & UnsignedBytes.MAX_VALUE) >> 3;
            iArr[i12] = iArr[i12] + 1;
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        if (width < 3) {
            for (int i13 = 0; i13 < width; i13++) {
                if ((row[i13] & UnsignedBytes.MAX_VALUE) < estimateBlackPoint) {
                    bitArray.set(i13);
                }
            }
        } else {
            byte b10 = row[0] & UnsignedBytes.MAX_VALUE;
            int i14 = 1;
            byte b11 = b10;
            byte b12 = row[1] & UnsignedBytes.MAX_VALUE;
            while (i14 < width - 1) {
                int i15 = i14 + 1;
                byte b13 = row[i15] & UnsignedBytes.MAX_VALUE;
                if ((((b12 << 2) - b11) - b13) / 2 < estimateBlackPoint) {
                    bitArray.set(i14);
                }
                b11 = b12;
                i14 = i15;
                b12 = b13;
            }
        }
        return bitArray;
    }
}
