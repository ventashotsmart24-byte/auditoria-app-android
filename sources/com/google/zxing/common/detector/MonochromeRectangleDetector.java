package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private int[] blackWhiteRange(int i10, int i11, int i12, int i13, boolean z10) {
        int i14 = (i12 + i13) / 2;
        int i15 = i14;
        while (i15 >= i12) {
            BitMatrix bitMatrix = this.image;
            if (!z10 ? !bitMatrix.get(i10, i15) : !bitMatrix.get(i15, i10)) {
                int i16 = i15;
                while (true) {
                    i16--;
                    if (i16 < i12) {
                        break;
                    }
                    BitMatrix bitMatrix2 = this.image;
                    if (z10) {
                        if (bitMatrix2.get(i16, i10)) {
                            break;
                        }
                    } else if (bitMatrix2.get(i10, i16)) {
                        break;
                    }
                }
                int i17 = i15 - i16;
                if (i16 < i12 || i17 > i11) {
                    break;
                }
                i15 = i16;
            } else {
                i15--;
            }
        }
        int i18 = i15 + 1;
        while (i14 < i13) {
            BitMatrix bitMatrix3 = this.image;
            if (!z10 ? !bitMatrix3.get(i10, i14) : !bitMatrix3.get(i14, i10)) {
                int i19 = i14;
                while (true) {
                    i19++;
                    if (i19 >= i13) {
                        break;
                    }
                    BitMatrix bitMatrix4 = this.image;
                    if (z10) {
                        if (bitMatrix4.get(i19, i10)) {
                            break;
                        }
                    } else if (bitMatrix4.get(i10, i19)) {
                        break;
                    }
                }
                int i20 = i19 - i14;
                if (i19 >= i13 || i20 > i11) {
                    break;
                }
                i14 = i19;
            } else {
                i14++;
            }
        }
        int i21 = i14 - 1;
        if (i21 > i18) {
            return new int[]{i18, i21};
        }
        return null;
    }

    private ResultPoint findCornerFromCenter(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int[] iArr;
        int i19 = i10;
        int i20 = i14;
        int[] iArr2 = null;
        int i21 = i17;
        int i22 = i19;
        int i23 = i20;
        while (i23 < i21 && i23 >= i16 && i22 < i13 && i22 >= i12) {
            if (i11 == 0) {
                iArr = blackWhiteRange(i23, i18, i12, i13, true);
            } else {
                iArr = blackWhiteRange(i22, i18, i16, i17, false);
            }
            if (iArr != null) {
                i23 += i15;
                i22 += i11;
                iArr2 = iArr;
            } else if (iArr2 != null) {
                char c10 = 0;
                if (i11 == 0) {
                    int i24 = i23 - i15;
                    int i25 = iArr2[0];
                    if (i25 >= i19) {
                        return new ResultPoint((float) iArr2[1], (float) i24);
                    }
                    if (iArr2[1] <= i19) {
                        return new ResultPoint((float) i25, (float) i24);
                    }
                    if (i15 <= 0) {
                        c10 = 1;
                    }
                    return new ResultPoint((float) iArr2[c10], (float) i24);
                }
                int i26 = i22 - i11;
                int i27 = iArr2[0];
                if (i27 >= i20) {
                    return new ResultPoint((float) i26, (float) iArr2[1]);
                }
                if (iArr2[1] <= i20) {
                    return new ResultPoint((float) i26, (float) i27);
                }
                float f10 = (float) i26;
                if (i11 >= 0) {
                    c10 = 1;
                }
                return new ResultPoint(f10, (float) iArr2[c10]);
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i10 = height / 2;
        int i11 = width / 2;
        int max = Math.max(1, height / 256);
        int i12 = -max;
        int i13 = i11 / 2;
        int i14 = i11;
        int i15 = width;
        int i16 = i10;
        int i17 = i12;
        int i18 = height;
        int i19 = max;
        int max2 = Math.max(1, width / 256);
        int i20 = -max2;
        int y10 = ((int) findCornerFromCenter(i14, 0, 0, i15, i16, i12, 0, i18, i13).getY()) - 1;
        int i21 = max2;
        int i22 = i10 / 2;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i14, i20, 0, i15, i16, 0, y10, i18, i22);
        int x10 = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i14, i21, x10, i15, i16, 0, y10, i18, i22);
        int x11 = ((int) findCornerFromCenter2.getX()) + 1;
        ResultPoint findCornerFromCenter3 = findCornerFromCenter(i14, 0, x10, x11, i16, i19, y10, i18, i13);
        return new ResultPoint[]{findCornerFromCenter(i14, 0, x10, x11, i16, i17, y10, ((int) findCornerFromCenter3.getY()) + 1, i11 / 4), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
    }
}
