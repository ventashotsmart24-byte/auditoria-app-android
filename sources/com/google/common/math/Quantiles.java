package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
public final class Quantiles {

    public static final class Scale {
        private final int scale;

        public ScaleAndIndex index(int i10) {
            return new ScaleAndIndex(this.scale, i10);
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.scale, (int[]) iArr.clone());
        }

        private Scale(int i10) {
            Preconditions.checkArgument(i10 > 0, "Quantile scale must be positive");
            this.scale = i10;
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(collection));
        }
    }

    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double computeInPlace(double... dArr) {
            boolean z10;
            if (dArr.length > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.index) * ((long) (dArr.length - 1));
            int divide = (int) LongMath.divide(length, (long) this.scale, RoundingMode.DOWN);
            int i10 = (int) (length - (((long) divide) * ((long) this.scale)));
            Quantiles.selectInPlace(divide, dArr, 0, dArr.length - 1);
            if (i10 == 0) {
                return dArr[divide];
            }
            int i11 = divide + 1;
            Quantiles.selectInPlace(i11, dArr, i11, dArr.length - 1);
            return Quantiles.interpolate(dArr[divide], dArr[i11], (double) i10, (double) this.scale);
        }

        private ScaleAndIndex(int i10, int i11) {
            Quantiles.checkIndex(i11, i10);
            this.scale = i10;
            this.index = i11;
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public double compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            boolean z10;
            double[] dArr2 = dArr;
            int i10 = 0;
            int i11 = 1;
            if (dArr2.length > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int[] iArr = this.indexes;
                int length = iArr.length;
                while (i10 < length) {
                    linkedHashMap.put(Integer.valueOf(iArr[i10]), Double.valueOf(Double.NaN));
                    i10++;
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.indexes;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[(iArr2.length * 2)];
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int[] iArr6 = this.indexes;
                if (i12 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i12]) * ((long) (dArr2.length - i11));
                int divide = (int) LongMath.divide(length2, (long) this.scale, RoundingMode.DOWN);
                int i14 = i12;
                int i15 = (int) (length2 - (((long) divide) * ((long) this.scale)));
                iArr3[i14] = divide;
                iArr4[i14] = i15;
                iArr5[i13] = divide;
                i13++;
                if (i15 != 0) {
                    iArr5[i13] = divide + 1;
                    i13++;
                }
                i12 = i14 + 1;
                i11 = 1;
            }
            Arrays.sort(iArr5, 0, i13);
            Quantiles.selectAllInPlace(iArr5, 0, i13 - 1, dArr, 0, dArr2.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (true) {
                int[] iArr7 = this.indexes;
                if (i10 >= iArr7.length) {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
                int i16 = iArr3[i10];
                int i17 = iArr4[i10];
                if (i17 == 0) {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i10]), Double.valueOf(dArr2[i16]));
                } else {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i10]), Double.valueOf(Quantiles.interpolate(dArr2[i16], dArr2[i16 + 1], (double) i17, (double) this.scale)));
                }
                i10++;
            }
        }

        private ScaleAndIndexes(int i10, int[] iArr) {
            boolean z10 = false;
            for (int access$300 : iArr) {
                Quantiles.checkIndex(access$300, i10);
            }
            Preconditions.checkArgument(iArr.length > 0 ? true : z10, "Indexes must be a non empty array");
            this.scale = i10;
            this.indexes = iArr;
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    /* access modifiers changed from: private */
    public static void checkIndex(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            StringBuilder sb = new StringBuilder(70);
            sb.append("Quantile indexes must be between 0 and the scale, which is ");
            sb.append(i11);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static int chooseNextSelection(int[] iArr, int i10, int i11, int i12, int i13) {
        if (i10 == i11) {
            return i10;
        }
        int i14 = i12 + i13;
        int i15 = i14 >>> 1;
        while (i11 > i10 + 1) {
            int i16 = (i10 + i11) >>> 1;
            int i17 = iArr[i16];
            if (i17 > i15) {
                i11 = i16;
            } else if (i17 >= i15) {
                return i16;
            } else {
                i10 = i16;
            }
        }
        if ((i14 - iArr[i10]) - iArr[i11] > 0) {
            return i11;
        }
        return i10;
    }

    /* access modifiers changed from: private */
    public static boolean containsNaN(double... dArr) {
        for (double isNaN : dArr) {
            if (Double.isNaN(isNaN)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static double interpolate(double d10, double d11, double d12, double d13) {
        if (d10 == Double.NEGATIVE_INFINITY) {
            return d11 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d11 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d10 + (((d11 - d10) * d12) / d13);
    }

    /* access modifiers changed from: private */
    public static double[] intsToDoubles(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = (double) iArr[i10];
        }
        return dArr;
    }

    /* access modifiers changed from: private */
    public static double[] longsToDoubles(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = (double) jArr[i10];
        }
        return dArr;
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    private static void movePivotToStartOfSlice(double[] dArr, int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12 = true;
        int i12 = (i10 + i11) >>> 1;
        double d10 = dArr[i11];
        double d11 = dArr[i12];
        if (d10 < d11) {
            z10 = true;
        } else {
            z10 = false;
        }
        double d12 = dArr[i10];
        if (d11 < d12) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (d10 >= d12) {
            z12 = false;
        }
        if (z10 == z11) {
            swap(dArr, i12, i10);
        } else if (z10 != z12) {
            swap(dArr, i10, i11);
        }
    }

    private static int partition(double[] dArr, int i10, int i11) {
        movePivotToStartOfSlice(dArr, i10, i11);
        double d10 = dArr[i10];
        int i12 = i11;
        while (i11 > i10) {
            if (dArr[i11] > d10) {
                swap(dArr, i12, i11);
                i12--;
            }
            i11--;
        }
        swap(dArr, i10, i12);
        return i12;
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int i10) {
        return new Scale(i10);
    }

    /* access modifiers changed from: private */
    public static void selectAllInPlace(int[] iArr, int i10, int i11, double[] dArr, int i12, int i13) {
        int chooseNextSelection = chooseNextSelection(iArr, i10, i11, i12, i13);
        int i14 = iArr[chooseNextSelection];
        selectInPlace(i14, dArr, i12, i13);
        int i15 = chooseNextSelection - 1;
        while (i15 >= i10 && iArr[i15] == i14) {
            i15--;
        }
        if (i15 >= i10) {
            selectAllInPlace(iArr, i10, i15, dArr, i12, i14 - 1);
        }
        int i16 = chooseNextSelection + 1;
        while (i16 <= i11 && iArr[i16] == i14) {
            i16++;
        }
        if (i16 <= i11) {
            selectAllInPlace(iArr, i16, i11, dArr, i14 + 1, i13);
        }
    }

    /* access modifiers changed from: private */
    public static void selectInPlace(int i10, double[] dArr, int i11, int i12) {
        if (i10 == i11) {
            int i13 = i11;
            for (int i14 = i11 + 1; i14 <= i12; i14++) {
                if (dArr[i13] > dArr[i14]) {
                    i13 = i14;
                }
            }
            if (i13 != i11) {
                swap(dArr, i13, i11);
                return;
            }
            return;
        }
        while (i12 > i11) {
            int partition = partition(dArr, i11, i12);
            if (partition >= i10) {
                i12 = partition - 1;
            }
            if (partition <= i10) {
                i11 = partition + 1;
            }
        }
    }

    private static void swap(double[] dArr, int i10, int i11) {
        double d10 = dArr[i10];
        dArr[i10] = dArr[i11];
        dArr[i11] = d10;
    }
}
