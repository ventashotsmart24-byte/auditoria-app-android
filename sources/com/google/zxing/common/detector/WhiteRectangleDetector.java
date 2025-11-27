package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x10 = resultPoint.getX();
        float y10 = resultPoint.getY();
        float x11 = resultPoint2.getX();
        float y11 = resultPoint2.getY();
        float x12 = resultPoint3.getX();
        float y12 = resultPoint3.getY();
        float x13 = resultPoint4.getX();
        float y13 = resultPoint4.getY();
        if (x10 < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x13 - 1.0f, y13 + 1.0f), new ResultPoint(x11 + 1.0f, y11 + 1.0f), new ResultPoint(x12 - 1.0f, y12 - 1.0f), new ResultPoint(x10 + 1.0f, y10 - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x13 + 1.0f, y13 + 1.0f), new ResultPoint(x11 + 1.0f, y11 - 1.0f), new ResultPoint(x12 - 1.0f, y12 + 1.0f), new ResultPoint(x10 - 1.0f, y10 - 1.0f)};
    }

    private boolean containsBlackPoint(int i10, int i11, int i12, boolean z10) {
        if (z10) {
            while (i10 <= i11) {
                if (this.image.get(i10, i12)) {
                    return true;
                }
                i10++;
            }
            return false;
        }
        while (i10 <= i11) {
            if (this.image.get(i12, i10)) {
                return true;
            }
            i10++;
        }
        return false;
    }

    private ResultPoint getBlackPointOnSegment(float f10, float f11, float f12, float f13) {
        int round = MathUtils.round(MathUtils.distance(f10, f11, f12, f13));
        float f14 = (float) round;
        float f15 = (f12 - f10) / f14;
        float f16 = (f13 - f11) / f14;
        for (int i10 = 0; i10 < round; i10++) {
            float f17 = (float) i10;
            int round2 = MathUtils.round((f17 * f15) + f10);
            int round3 = MathUtils.round((f17 * f16) + f11);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    public ResultPoint[] detect() {
        int i10 = this.leftInit;
        int i11 = this.rightInit;
        int i12 = this.upInit;
        int i13 = this.downInit;
        boolean z10 = false;
        int i14 = 1;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        while (true) {
            if (!z11) {
                break;
            }
            boolean z17 = true;
            boolean z18 = false;
            while (true) {
                if ((z17 || !z12) && i11 < this.width) {
                    z17 = containsBlackPoint(i12, i13, i11, false);
                    if (z17) {
                        i11++;
                        z12 = true;
                        z18 = true;
                    } else if (!z12) {
                        i11++;
                    }
                }
            }
            if (i11 >= this.width) {
                break;
            }
            boolean z19 = true;
            while (true) {
                if ((z19 || !z13) && i13 < this.height) {
                    z19 = containsBlackPoint(i10, i11, i13, true);
                    if (z19) {
                        i13++;
                        z13 = true;
                        z18 = true;
                    } else if (!z13) {
                        i13++;
                    }
                }
            }
            if (i13 >= this.height) {
                break;
            }
            boolean z20 = true;
            while (true) {
                if ((z20 || !z14) && i10 >= 0) {
                    z20 = containsBlackPoint(i12, i13, i10, false);
                    if (z20) {
                        i10--;
                        z14 = true;
                        z18 = true;
                    } else if (!z14) {
                        i10--;
                    }
                }
            }
            if (i10 < 0) {
                break;
            }
            z11 = z18;
            boolean z21 = true;
            while (true) {
                if ((z21 || !z16) && i12 >= 0) {
                    z21 = containsBlackPoint(i10, i11, i12, true);
                    if (z21) {
                        i12--;
                        z11 = true;
                        z16 = true;
                    } else if (!z16) {
                        i12--;
                    }
                }
            }
            if (i12 < 0) {
                break;
            } else if (z11) {
                z15 = true;
            }
        }
        z10 = true;
        if (z10 || !z15) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = i11 - i10;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        int i16 = 1;
        while (resultPoint2 == null && i16 < i15) {
            resultPoint2 = getBlackPointOnSegment((float) i10, (float) (i13 - i16), (float) (i10 + i16), (float) i13);
            i16++;
        }
        if (resultPoint2 != null) {
            ResultPoint resultPoint3 = null;
            int i17 = 1;
            while (resultPoint3 == null && i17 < i15) {
                resultPoint3 = getBlackPointOnSegment((float) i10, (float) (i12 + i17), (float) (i10 + i17), (float) i12);
                i17++;
            }
            if (resultPoint3 != null) {
                ResultPoint resultPoint4 = null;
                int i18 = 1;
                while (resultPoint4 == null && i18 < i15) {
                    resultPoint4 = getBlackPointOnSegment((float) i11, (float) (i12 + i18), (float) (i11 - i18), (float) i12);
                    i18++;
                }
                if (resultPoint4 != null) {
                    while (resultPoint == null && i14 < i15) {
                        resultPoint = getBlackPointOnSegment((float) i11, (float) (i13 - i14), (float) (i11 - i14), (float) i13);
                        i14++;
                    }
                    if (resultPoint != null) {
                        return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i10, int i11, int i12) {
        this.image = bitMatrix;
        int height2 = bitMatrix.getHeight();
        this.height = height2;
        int width2 = bitMatrix.getWidth();
        this.width = width2;
        int i13 = i10 / 2;
        int i14 = i11 - i13;
        this.leftInit = i14;
        int i15 = i11 + i13;
        this.rightInit = i15;
        int i16 = i12 - i13;
        this.upInit = i16;
        int i17 = i12 + i13;
        this.downInit = i17;
        if (i16 < 0 || i14 < 0 || i17 >= height2 || i15 >= width2) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
