package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import java.util.Map;

public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays)) {
            return sizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2)) {
            return sizeOfBlackWhiteBlackRunBothWays / 7.0f;
        }
        return (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f10) {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f10) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f10)) / 2) + 7;
        int i10 = round & 3;
        if (i10 == 0) {
            return round + 1;
        }
        if (i10 == 2) {
            return round - 1;
        }
        if (i10 != 3) {
            return round;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i10) {
        float f10;
        float f11;
        float f12;
        float f13 = ((float) i10) - 3.5f;
        if (resultPoint4 != null) {
            f11 = resultPoint4.getX();
            f10 = resultPoint4.getY();
            f12 = f13 - 3.0f;
        } else {
            f11 = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            f10 = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f12 = f13;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f13, 3.5f, f12, f12, 3.5f, f13, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), f11, f10, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i10) {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i10, i10, perspectiveTransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i10, int i11, int i12, int i13) {
        boolean z10;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z11;
        Detector detector;
        boolean z12;
        int i22 = 1;
        if (Math.abs(i13 - i11) > Math.abs(i12 - i10)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i16 = i10;
            i17 = i11;
            i14 = i12;
            i15 = i13;
        } else {
            i17 = i10;
            i16 = i11;
            i15 = i12;
            i14 = i13;
        }
        int abs = Math.abs(i15 - i17);
        int abs2 = Math.abs(i14 - i16);
        int i23 = (-abs) / 2;
        int i24 = -1;
        if (i17 < i15) {
            i18 = 1;
        } else {
            i18 = -1;
        }
        if (i16 < i14) {
            i24 = 1;
        }
        int i25 = i15 + i18;
        int i26 = i17;
        int i27 = i16;
        int i28 = 0;
        while (true) {
            if (i26 == i25) {
                i19 = i25;
                break;
            }
            if (z10) {
                i20 = i27;
            } else {
                i20 = i26;
            }
            if (z10) {
                i21 = i26;
            } else {
                i21 = i27;
            }
            if (i28 == i22) {
                detector = this;
                z11 = z10;
                i19 = i25;
                z12 = true;
            } else {
                detector = this;
                z11 = z10;
                i19 = i25;
                z12 = false;
            }
            if (z12 == detector.image.get(i20, i21)) {
                if (i28 == 2) {
                    return MathUtils.distance(i26, i27, i17, i16);
                }
                i28++;
            }
            i23 += abs2;
            if (i23 > 0) {
                if (i27 == i14) {
                    break;
                }
                i27 += i24;
                i23 -= abs;
            }
            i26 += i18;
            i25 = i19;
            z10 = z11;
            i22 = 1;
        }
        if (i28 == 2) {
            return MathUtils.distance(i19, i14, i17, i16);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i10, i11, i12, i13);
        int i14 = i10 - (i12 - i10);
        int i15 = 0;
        if (i14 < 0) {
            f10 = ((float) i10) / ((float) (i10 - i14));
            i14 = 0;
        } else if (i14 >= this.image.getWidth()) {
            f10 = ((float) ((this.image.getWidth() - 1) - i10)) / ((float) (i14 - i10));
            i14 = this.image.getWidth() - 1;
        } else {
            f10 = 1.0f;
        }
        float f12 = (float) i11;
        int i16 = (int) (f12 - (((float) (i13 - i11)) * f10));
        if (i16 < 0) {
            f11 = f12 / ((float) (i11 - i16));
        } else if (i16 >= this.image.getHeight()) {
            f11 = ((float) ((this.image.getHeight() - 1) - i11)) / ((float) (i16 - i11));
            i15 = this.image.getHeight() - 1;
        } else {
            i15 = i16;
            f11 = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i10, i11, (int) (((float) i10) + (((float) (i14 - i10)) * f11)), i15)) - 1.0f;
    }

    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() {
        return detect((Map<DecodeHintType, ?>) null);
    }

    public final AlignmentPattern findAlignmentInRegion(float f10, int i10, int i11, float f11) {
        int i12 = (int) (f11 * f10);
        int max = Math.max(0, i10 - i12);
        int min = Math.min(this.image.getWidth() - 1, i10 + i12) - max;
        float f12 = 3.0f * f10;
        if (((float) min) >= f12) {
            int max2 = Math.max(0, i11 - i12);
            int min2 = Math.min(this.image.getHeight() - 1, i11 + i12) - max2;
            if (((float) min2) >= f12) {
                return new AlignmentPatternFinder(this.image, max, max2, min, min2, f10, this.resultPointCallback).find();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.common.DetectorResult processFinderPatternInfo(com.google.zxing.qrcode.detector.FinderPatternInfo r11) {
        /*
            r10 = this;
            com.google.zxing.qrcode.detector.FinderPattern r0 = r11.getTopLeft()
            com.google.zxing.qrcode.detector.FinderPattern r1 = r11.getTopRight()
            com.google.zxing.qrcode.detector.FinderPattern r11 = r11.getBottomLeft()
            float r2 = r10.calculateModuleSize(r0, r1, r11)
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 < 0) goto L_0x00a0
            int r4 = computeDimension(r0, r1, r11, r2)
            com.google.zxing.qrcode.decoder.Version r5 = com.google.zxing.qrcode.decoder.Version.getProvisionalVersionForDimension(r4)
            int r6 = r5.getDimensionForVersion()
            int r6 = r6 + -7
            int[] r5 = r5.getAlignmentPatternCenters()
            int r5 = r5.length
            r7 = 4
            if (r5 <= 0) goto L_0x0075
            float r5 = r1.getX()
            float r8 = r0.getX()
            float r5 = r5 - r8
            float r8 = r11.getX()
            float r5 = r5 + r8
            float r8 = r1.getY()
            float r9 = r0.getY()
            float r8 = r8 - r9
            float r9 = r11.getY()
            float r8 = r8 + r9
            r9 = 1077936128(0x40400000, float:3.0)
            float r6 = (float) r6
            float r9 = r9 / r6
            float r3 = r3 - r9
            float r6 = r0.getX()
            float r9 = r0.getX()
            float r5 = r5 - r9
            float r5 = r5 * r3
            float r6 = r6 + r5
            int r5 = (int) r6
            float r6 = r0.getY()
            float r9 = r0.getY()
            float r8 = r8 - r9
            float r3 = r3 * r8
            float r6 = r6 + r3
            int r3 = (int) r6
            r6 = 4
        L_0x0068:
            r8 = 16
            if (r6 > r8) goto L_0x0075
            float r8 = (float) r6
            com.google.zxing.qrcode.detector.AlignmentPattern r2 = r10.findAlignmentInRegion(r2, r5, r3, r8)     // Catch:{ NotFoundException -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            int r6 = r6 << 1
            goto L_0x0068
        L_0x0075:
            r2 = 0
        L_0x0076:
            com.google.zxing.common.PerspectiveTransform r3 = createTransform(r0, r1, r11, r2, r4)
            com.google.zxing.common.BitMatrix r5 = r10.image
            com.google.zxing.common.BitMatrix r3 = sampleGrid(r5, r3, r4)
            r4 = 3
            r5 = 2
            r6 = 0
            r8 = 1
            if (r2 != 0) goto L_0x008f
            com.google.zxing.ResultPoint[] r2 = new com.google.zxing.ResultPoint[r4]
            r2[r6] = r11
            r2[r8] = r0
            r2[r5] = r1
            goto L_0x009a
        L_0x008f:
            com.google.zxing.ResultPoint[] r7 = new com.google.zxing.ResultPoint[r7]
            r7[r6] = r11
            r7[r8] = r0
            r7[r5] = r1
            r7[r4] = r2
            r2 = r7
        L_0x009a:
            com.google.zxing.common.DetectorResult r11 = new com.google.zxing.common.DetectorResult
            r11.<init>(r3, r2)
            return r11
        L_0x00a0:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            goto L_0x00a6
        L_0x00a5:
            throw r11
        L_0x00a6:
            goto L_0x00a5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.Detector.processFinderPatternInfo(com.google.zxing.qrcode.detector.FinderPatternInfo):com.google.zxing.common.DetectorResult");
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) {
        ResultPointCallback resultPointCallback2;
        if (map == null) {
            resultPointCallback2 = null;
        } else {
            resultPointCallback2 = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        this.resultPointCallback = resultPointCallback2;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback2).find(map));
    }
}
