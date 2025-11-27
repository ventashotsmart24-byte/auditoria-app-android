package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f10) {
            this.average = f10;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() != finderPattern.getCount()) {
                return finderPattern2.getCount() - finderPattern.getCount();
            }
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    public static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f10) {
            this.average = f10;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, (ResultPointCallback) null);
    }

    private static float centerFromEnd(int[] iArr, int i10) {
        return ((float) ((i10 - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b4 A[LOOP:4: B:41:0x009f->B:49:0x00b4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bb A[ADDED_TO_REGION, EDGE_INSN: B:87:0x00bb->B:50:0x00bb ?: BREAK  
    EDGE_INSN: B:88:0x00bb->B:50:0x00bb ?: BREAK  
    EDGE_INSN: B:89:0x00bb->B:50:0x00bb ?: BREAK  
    EDGE_INSN: B:90:0x00bb->B:50:0x00bb ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00db A[LOOP:5: B:55:0x00c6->B:63:0x00db, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e2 A[EDGE_INSN: B:91:0x00e2->B:64:0x00e2 ?: BREAK  
    EDGE_INSN: B:92:0x00e2->B:64:0x00e2 ?: BREAK  
    EDGE_INSN: B:93:0x00e2->B:64:0x00e2 ?: BREAK  
    EDGE_INSN: B:94:0x00e2->B:64:0x00e2 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0103 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean crossCheckDiagonal(int r17, int r18, int r19, int r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            int[] r4 = r16.getCrossCheckStateCount()
            r5 = 0
            r6 = 0
        L_0x000e:
            r7 = 2
            r8 = 1
            if (r1 < r6) goto L_0x0028
            if (r2 < r6) goto L_0x0028
            com.google.zxing.common.BitMatrix r9 = r0.image
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.get(r10, r11)
            if (r9 == 0) goto L_0x0028
            r9 = r4[r7]
            int r9 = r9 + r8
            r4[r7] = r9
            int r6 = r6 + 1
            goto L_0x000e
        L_0x0028:
            if (r1 < r6) goto L_0x0104
            if (r2 >= r6) goto L_0x002e
            goto L_0x0104
        L_0x002e:
            if (r1 < r6) goto L_0x0049
            if (r2 < r6) goto L_0x0049
            com.google.zxing.common.BitMatrix r9 = r0.image
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.get(r10, r11)
            if (r9 != 0) goto L_0x0049
            r9 = r4[r8]
            if (r9 > r3) goto L_0x0049
            int r9 = r9 + 1
            r4[r8] = r9
            int r6 = r6 + 1
            goto L_0x002e
        L_0x0049:
            if (r1 < r6) goto L_0x0104
            if (r2 < r6) goto L_0x0104
            r9 = r4[r8]
            if (r9 <= r3) goto L_0x0053
            goto L_0x0104
        L_0x0053:
            if (r1 < r6) goto L_0x006e
            if (r2 < r6) goto L_0x006e
            com.google.zxing.common.BitMatrix r9 = r0.image
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.get(r10, r11)
            if (r9 == 0) goto L_0x006e
            r9 = r4[r5]
            if (r9 > r3) goto L_0x006e
            int r9 = r9 + 1
            r4[r5] = r9
            int r6 = r6 + 1
            goto L_0x0053
        L_0x006e:
            r6 = r4[r5]
            if (r6 <= r3) goto L_0x0073
            return r5
        L_0x0073:
            com.google.zxing.common.BitMatrix r6 = r0.image
            int r6 = r6.getHeight()
            com.google.zxing.common.BitMatrix r9 = r0.image
            int r9 = r9.getWidth()
            r10 = 1
        L_0x0080:
            int r11 = r1 + r10
            if (r11 >= r6) goto L_0x0098
            int r12 = r2 + r10
            if (r12 >= r9) goto L_0x0098
            com.google.zxing.common.BitMatrix r13 = r0.image
            boolean r12 = r13.get(r12, r11)
            if (r12 == 0) goto L_0x0098
            r11 = r4[r7]
            int r11 = r11 + r8
            r4[r7] = r11
            int r10 = r10 + 1
            goto L_0x0080
        L_0x0098:
            if (r11 >= r6) goto L_0x0104
            int r11 = r2 + r10
            if (r11 < r9) goto L_0x009f
            goto L_0x0104
        L_0x009f:
            int r11 = r1 + r10
            r12 = 3
            if (r11 >= r6) goto L_0x00bb
            int r13 = r2 + r10
            if (r13 >= r9) goto L_0x00bb
            com.google.zxing.common.BitMatrix r14 = r0.image
            boolean r13 = r14.get(r13, r11)
            if (r13 != 0) goto L_0x00bb
            r13 = r4[r12]
            if (r13 >= r3) goto L_0x00bb
            int r13 = r13 + 1
            r4[r12] = r13
            int r10 = r10 + 1
            goto L_0x009f
        L_0x00bb:
            if (r11 >= r6) goto L_0x0104
            int r11 = r2 + r10
            if (r11 >= r9) goto L_0x0104
            r11 = r4[r12]
            if (r11 < r3) goto L_0x00c6
            goto L_0x0104
        L_0x00c6:
            int r11 = r1 + r10
            r13 = 4
            if (r11 >= r6) goto L_0x00e2
            int r14 = r2 + r10
            if (r14 >= r9) goto L_0x00e2
            com.google.zxing.common.BitMatrix r15 = r0.image
            boolean r11 = r15.get(r14, r11)
            if (r11 == 0) goto L_0x00e2
            r11 = r4[r13]
            if (r11 >= r3) goto L_0x00e2
            int r11 = r11 + 1
            r4[r13] = r11
            int r10 = r10 + 1
            goto L_0x00c6
        L_0x00e2:
            r1 = r4[r13]
            if (r1 < r3) goto L_0x00e7
            return r5
        L_0x00e7:
            r2 = r4[r5]
            r3 = r4[r8]
            int r2 = r2 + r3
            r3 = r4[r7]
            int r2 = r2 + r3
            r3 = r4[r12]
            int r2 = r2 + r3
            int r2 = r2 + r1
            int r2 = r2 - r20
            int r1 = java.lang.Math.abs(r2)
            int r2 = r20 * 2
            if (r1 >= r2) goto L_0x0104
            boolean r1 = foundPatternCross(r4)
            if (r1 == 0) goto L_0x0104
            return r8
        L_0x0104:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.crossCheckDiagonal(int, int, int, int):boolean");
    }

    private float crossCheckHorizontal(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i17 = i10;
        while (i17 >= 0 && bitMatrix.get(i17, i11)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i17--;
        }
        if (i17 < 0) {
            return Float.NaN;
        }
        while (i17 >= 0 && !bitMatrix.get(i17, i11)) {
            int i18 = crossCheckStateCount2[1];
            if (i18 > i12) {
                break;
            }
            crossCheckStateCount2[1] = i18 + 1;
            i17--;
        }
        if (i17 >= 0 && crossCheckStateCount2[1] <= i12) {
            while (i17 >= 0 && bitMatrix.get(i17, i11) && (i16 = crossCheckStateCount2[0]) <= i12) {
                crossCheckStateCount2[0] = i16 + 1;
                i17--;
            }
            if (crossCheckStateCount2[0] > i12) {
                return Float.NaN;
            }
            int i19 = i10 + 1;
            while (i19 < width && bitMatrix.get(i19, i11)) {
                crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
                i19++;
            }
            if (i19 == width) {
                return Float.NaN;
            }
            while (i19 < width && !bitMatrix.get(i19, i11) && (i15 = crossCheckStateCount2[3]) < i12) {
                crossCheckStateCount2[3] = i15 + 1;
                i19++;
            }
            if (i19 != width && crossCheckStateCount2[3] < i12) {
                while (i19 < width && bitMatrix.get(i19, i11) && (i14 = crossCheckStateCount2[4]) < i12) {
                    crossCheckStateCount2[4] = i14 + 1;
                    i19++;
                }
                int i20 = crossCheckStateCount2[4];
                if (i20 < i12 && Math.abs(((((crossCheckStateCount2[0] + crossCheckStateCount2[1]) + crossCheckStateCount2[2]) + crossCheckStateCount2[3]) + i20) - i13) * 5 < i13 && foundPatternCross(crossCheckStateCount2)) {
                    return centerFromEnd(crossCheckStateCount2, i19);
                }
            }
        }
        return Float.NaN;
    }

    private float crossCheckVertical(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i17 = i10;
        while (i17 >= 0 && bitMatrix.get(i11, i17)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i17--;
        }
        if (i17 < 0) {
            return Float.NaN;
        }
        while (i17 >= 0 && !bitMatrix.get(i11, i17)) {
            int i18 = crossCheckStateCount2[1];
            if (i18 > i12) {
                break;
            }
            crossCheckStateCount2[1] = i18 + 1;
            i17--;
        }
        if (i17 >= 0 && crossCheckStateCount2[1] <= i12) {
            while (i17 >= 0 && bitMatrix.get(i11, i17) && (i16 = crossCheckStateCount2[0]) <= i12) {
                crossCheckStateCount2[0] = i16 + 1;
                i17--;
            }
            if (crossCheckStateCount2[0] > i12) {
                return Float.NaN;
            }
            int i19 = i10 + 1;
            while (i19 < height && bitMatrix.get(i11, i19)) {
                crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
                i19++;
            }
            if (i19 == height) {
                return Float.NaN;
            }
            while (i19 < height && !bitMatrix.get(i11, i19) && (i15 = crossCheckStateCount2[3]) < i12) {
                crossCheckStateCount2[3] = i15 + 1;
                i19++;
            }
            if (i19 != height && crossCheckStateCount2[3] < i12) {
                while (i19 < height && bitMatrix.get(i11, i19) && (i14 = crossCheckStateCount2[4]) < i12) {
                    crossCheckStateCount2[4] = i14 + 1;
                    i19++;
                }
                int i20 = crossCheckStateCount2[4];
                if (i20 < i12 && Math.abs(((((crossCheckStateCount2[0] + crossCheckStateCount2[1]) + crossCheckStateCount2[2]) + crossCheckStateCount2[3]) + i20) - i13) * 5 < i13 * 2 && foundPatternCross(crossCheckStateCount2)) {
                    return centerFromEnd(crossCheckStateCount2, i19);
                }
            }
        }
        return Float.NaN;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern next : this.possibleCenters) {
            if (next.getCount() >= 2) {
                if (finderPattern == null) {
                    finderPattern = next;
                } else {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - next.getX()) - Math.abs(finderPattern.getY() - next.getY()))) / 2;
                }
            }
        }
        return 0;
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = ((float) i10) / 7.0f;
        float f11 = f10 / 2.0f;
        if (Math.abs(f10 - ((float) iArr[0])) >= f11 || Math.abs(f10 - ((float) iArr[1])) >= f11 || Math.abs((f10 * 3.0f) - ((float) iArr[2])) >= 3.0f * f11 || Math.abs(f10 - ((float) iArr[3])) >= f11 || Math.abs(f10 - ((float) iArr[4])) >= f11) {
            return false;
        }
        return true;
    }

    private int[] getCrossCheckStateCount() {
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float f10 = 0.0f;
        int i10 = 0;
        float f11 = 0.0f;
        for (FinderPattern next : this.possibleCenters) {
            if (next.getCount() >= 2) {
                i10++;
                f11 += next.getEstimatedModuleSize();
            }
        }
        if (i10 < 3) {
            return false;
        }
        float f12 = f11 / ((float) size);
        for (FinderPattern estimatedModuleSize : this.possibleCenters) {
            f10 += Math.abs(estimatedModuleSize.getEstimatedModuleSize() - f12);
        }
        if (f10 <= f11 * 0.05f) {
            return true;
        }
        return false;
    }

    private FinderPattern[] selectBestPatterns() {
        int size = this.possibleCenters.size();
        if (size >= 3) {
            float f10 = 0.0f;
            if (size > 3) {
                float f11 = 0.0f;
                float f12 = 0.0f;
                for (FinderPattern estimatedModuleSize : this.possibleCenters) {
                    float estimatedModuleSize2 = estimatedModuleSize.getEstimatedModuleSize();
                    f11 += estimatedModuleSize2;
                    f12 += estimatedModuleSize2 * estimatedModuleSize2;
                }
                float f13 = (float) size;
                float f14 = f11 / f13;
                float sqrt = (float) Math.sqrt((double) ((f12 / f13) - (f14 * f14)));
                Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f14));
                float max = Math.max(0.2f * f14, sqrt);
                int i10 = 0;
                while (i10 < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                    if (Math.abs(this.possibleCenters.get(i10).getEstimatedModuleSize() - f14) > max) {
                        this.possibleCenters.remove(i10);
                        i10--;
                    }
                    i10++;
                }
            }
            if (this.possibleCenters.size() > 3) {
                for (FinderPattern estimatedModuleSize3 : this.possibleCenters) {
                    f10 += estimatedModuleSize3.getEstimatedModuleSize();
                }
                Collections.sort(this.possibleCenters, new CenterComparator(f10 / ((float) this.possibleCenters.size())));
                List<FinderPattern> list = this.possibleCenters;
                list.subList(3, list.size()).clear();
            }
            return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) {
        boolean z10;
        boolean z11;
        if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            z11 = false;
        } else {
            z11 = true;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i10 = (height * 3) / 228;
        if (i10 < 3 || z10) {
            i10 = 3;
        }
        int[] iArr = new int[5];
        int i11 = i10 - 1;
        boolean z12 = false;
        while (i11 < height && !z12) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i12 = 0;
            int i13 = 0;
            while (i12 < width) {
                if (this.image.get(i12, i11)) {
                    if ((i13 & 1) == 1) {
                        i13++;
                    }
                    iArr[i13] = iArr[i13] + 1;
                } else if ((i13 & 1) != 0) {
                    iArr[i13] = iArr[i13] + 1;
                } else if (i13 == 4) {
                    if (!foundPatternCross(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (handlePossibleCenter(iArr, i11, i12, z11)) {
                        if (this.hasSkipped) {
                            z12 = haveMultiplyConfirmedCenters();
                        } else {
                            int findRowSkip = findRowSkip();
                            int i14 = iArr[2];
                            if (findRowSkip > i14) {
                                i11 += (findRowSkip - i14) - 2;
                                i12 = width - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i10 = 2;
                        i13 = 0;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i13 = 3;
                } else {
                    i13++;
                    iArr[i13] = iArr[i13] + 1;
                }
                i12++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i11, width, z11)) {
                i10 = iArr[0];
                if (this.hasSkipped) {
                    z12 = haveMultiplyConfirmedCenters();
                }
            }
            i11 += i10;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    public final boolean handlePossibleCenter(int[] iArr, int i10, int i11, boolean z10) {
        boolean z11 = false;
        int i12 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int centerFromEnd = (int) centerFromEnd(iArr, i11);
        float crossCheckVertical = crossCheckVertical(i10, centerFromEnd, iArr[2], i12);
        if (!Float.isNaN(crossCheckVertical)) {
            int i13 = (int) crossCheckVertical;
            float crossCheckHorizontal = crossCheckHorizontal(centerFromEnd, i13, iArr[2], i12);
            if (!Float.isNaN(crossCheckHorizontal) && (!z10 || crossCheckDiagonal(i13, (int) crossCheckHorizontal, iArr[2], i12))) {
                float f10 = ((float) i12) / 7.0f;
                int i14 = 0;
                while (true) {
                    if (i14 >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(i14);
                    if (finderPattern.aboutEquals(f10, crossCheckVertical, crossCheckHorizontal)) {
                        this.possibleCenters.set(i14, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f10));
                        z11 = true;
                        break;
                    }
                    i14++;
                }
                if (!z11) {
                    FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f10);
                    this.possibleCenters.add(finderPattern2);
                    ResultPointCallback resultPointCallback2 = this.resultPointCallback;
                    if (resultPointCallback2 != null) {
                        resultPointCallback2.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback2) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback2;
    }
}
