package com.google.common.math;

import c8.b;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import com.taobao.accs.antibrush.AntiBrush;
import java.math.RoundingMode;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class LongMath {
    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, AntiBrush.STATUS_BRUSH, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    @GwtIncompatible
    @VisibleForTesting
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};
    @GwtIncompatible
    @VisibleForTesting
    static final long[] powersOf10 = {1, 10, 100, 1000, NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$math$RoundingMode = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.AnonymousClass1.<clinit>():void");
        }
    }

    public enum MillerRabinTester {
        SMALL {
            public long mulMod(long j10, long j11, long j12) {
                return (j10 * j11) % j12;
            }

            public long squareMod(long j10, long j11) {
                return (j10 * j10) % j11;
            }
        },
        LARGE {
            private long plusMod(long j10, long j11, long j12) {
                int i10 = (j10 > (j12 - j11) ? 1 : (j10 == (j12 - j11) ? 0 : -1));
                long j13 = j10 + j11;
                return i10 >= 0 ? j13 - j12 : j13;
            }

            private long times2ToThe32Mod(long j10, long j11) {
                int i10 = 32;
                do {
                    int min = Math.min(i10, Long.numberOfLeadingZeros(j10));
                    j10 = UnsignedLongs.remainder(j10 << min, j11);
                    i10 -= min;
                } while (i10 > 0);
                return j10;
            }

            public long mulMod(long j10, long j11, long j12) {
                long j13 = j12;
                long j14 = j10 >>> 32;
                long j15 = j11 >>> 32;
                long j16 = j10 & 4294967295L;
                long j17 = j11 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j14 * j15, j13) + (j14 * j17);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, j13);
                }
                Long.signum(j16);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j15 * j16), j13), UnsignedLongs.remainder(j16 * j17, j13), j12);
            }

            public long squareMod(long j10, long j11) {
                long j12 = j10 >>> 32;
                long j13 = j10 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j12 * j12, j11);
                long j14 = j12 * j13 * 2;
                if (j14 < 0) {
                    j14 = UnsignedLongs.remainder(j14, j11);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j14, j11), UnsignedLongs.remainder(j13 * j13, j11), j11);
            }
        };

        private long powMod(long j10, long j11, long j12) {
            long j13 = 1;
            while (j11 != 0) {
                if ((j11 & 1) != 0) {
                    j13 = mulMod(j13, j10, j12);
                }
                j10 = squareMod(j10, j12);
                j11 >>= 1;
            }
            return j13;
        }

        public static boolean test(long j10, long j11) {
            MillerRabinTester millerRabinTester;
            if (j11 <= LongMath.FLOOR_SQRT_MAX_LONG) {
                millerRabinTester = SMALL;
            } else {
                millerRabinTester = LARGE;
            }
            return millerRabinTester.testWitness(j10, j11);
        }

        private boolean testWitness(long j10, long j11) {
            long j12 = j11;
            long j13 = j12 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j13);
            long j14 = j13 >> numberOfTrailingZeros;
            long j15 = j10 % j12;
            if (j15 == 0) {
                return true;
            }
            long powMod = powMod(j15, j14, j11);
            if (powMod == 1) {
                return true;
            }
            int i10 = 0;
            while (powMod != j13) {
                i10++;
                if (i10 == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j12);
            }
            return true;
        }

        public abstract long mulMod(long j10, long j11, long j12);

        public abstract long squareMod(long j10, long j11);
    }

    private LongMath() {
    }

    public static long binomial(int i10, int i11) {
        boolean z10;
        MathPreconditions.checkNonNegative("n", i10);
        MathPreconditions.checkNonNegative("k", i11);
        if (i11 <= i10) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "k (%s) > n (%s)", i11, i10);
        if (i11 > (i10 >> 1)) {
            i11 = i10 - i11;
        }
        long j10 = 1;
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return (long) i10;
        }
        long[] jArr = factorials;
        if (i10 < jArr.length) {
            return jArr[i10] / (jArr[i11] * jArr[i10 - i11]);
        }
        int[] iArr = biggestBinomials;
        if (i11 >= iArr.length || i10 > iArr[i11]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i11 >= iArr2.length || i10 > iArr2[i11]) {
            long j11 = (long) i10;
            int log2 = log2(j11, RoundingMode.CEILING);
            int i12 = i10 - 1;
            int i13 = log2;
            long j12 = j11;
            int i14 = 2;
            long j13 = 1;
            while (i14 <= i11) {
                i13 += log2;
                if (i13 < 63) {
                    j12 *= (long) i12;
                    j13 *= (long) i14;
                } else {
                    j10 = multiplyFraction(j10, j12, j13);
                    j12 = (long) i12;
                    j13 = (long) i14;
                    i13 = log2;
                }
                i14++;
                i12--;
            }
            return multiplyFraction(j10, j12, j13);
        }
        int i15 = i10 - 1;
        long j14 = (long) i10;
        for (int i16 = 2; i16 <= i11; i16++) {
            j14 = (j14 * ((long) i15)) / ((long) i16);
            i15--;
        }
        return j14;
    }

    @Beta
    public static long ceilingPowerOfTwo(long j10) {
        MathPreconditions.checkPositive("x", j10);
        if (j10 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j10 - 1));
        }
        StringBuilder sb = new StringBuilder(70);
        sb.append("ceilingPowerOfTwo(");
        sb.append(j10);
        sb.append(") is not representable as a long");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static long checkedAdd(long j10, long j11) {
        boolean z10;
        long j12 = j10 + j11;
        boolean z11 = true;
        if ((j10 ^ j11) < 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((j10 ^ j12) < 0) {
            z11 = false;
        }
        MathPreconditions.checkNoOverflow(z10 | z11, "checkedAdd", j10, j11);
        return j12;
    }

    public static long checkedMultiply(long j10, long j11) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10) + Long.numberOfLeadingZeros(j10 ^ -1) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(-1 ^ j11);
        if (numberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        if (numberOfLeadingZeros >= 64) {
            z10 = true;
        } else {
            z10 = false;
        }
        MathPreconditions.checkNoOverflow(z10, "checkedMultiply", j10, j11);
        if (j10 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (j11 != Long.MIN_VALUE) {
            z12 = true;
        } else {
            z12 = false;
        }
        MathPreconditions.checkNoOverflow(z11 | z12, "checkedMultiply", j10, j11);
        long j12 = j10 * j11;
        if (j10 == 0 || j12 / j10 == j11) {
            z13 = true;
        } else {
            z13 = false;
        }
        MathPreconditions.checkNoOverflow(z13, "checkedMultiply", j10, j11);
        return j12;
    }

    @GwtIncompatible
    public static long checkedPow(long j10, int i10) {
        boolean z10;
        boolean z11;
        long j11;
        boolean z12;
        boolean z13;
        boolean z14;
        MathPreconditions.checkNonNegative("exponent", i10);
        if (j10 >= -2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 <= 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        long j12 = 1;
        if (z10 && z11) {
            int i11 = (int) j10;
            if (i11 == -2) {
                if (i10 < 64) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                MathPreconditions.checkNoOverflow(z13, "checkedPow", j10, (long) i10);
                if ((i10 & 1) == 0) {
                    return 1 << i10;
                }
                return -1 << i10;
            } else if (i11 != -1) {
                if (i11 != 0) {
                    if (i11 == 1) {
                        return 1;
                    }
                    if (i11 == 2) {
                        if (i10 < 63) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        MathPreconditions.checkNoOverflow(z14, "checkedPow", j10, (long) i10);
                        return 1 << i10;
                    }
                    throw new AssertionError();
                } else if (i10 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i10 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            long j13 = j10;
            int i12 = i10;
            while (i12 != 0) {
                if (i12 == 1) {
                    return checkedMultiply(j12, j13);
                }
                if ((i12 & 1) != 0) {
                    j11 = checkedMultiply(j12, j13);
                } else {
                    j11 = j12;
                }
                int i13 = i12 >> 1;
                if (i13 > 0) {
                    if (-3037000499L > j13 || j13 > FLOOR_SQRT_MAX_LONG) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    MathPreconditions.checkNoOverflow(z12, "checkedPow", j13, (long) i13);
                    j13 *= j13;
                }
                j12 = j11;
                i12 = i13;
            }
            return j12;
        }
    }

    @GwtIncompatible
    public static long checkedSubtract(long j10, long j11) {
        boolean z10;
        long j12 = j10 - j11;
        boolean z11 = true;
        if ((j10 ^ j11) >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((j10 ^ j12) < 0) {
            z11 = false;
        }
        MathPreconditions.checkNoOverflow(z10 | z11, "checkedSubtract", j10, j11);
        return j12;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r9 > 0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r9 < 0) goto L_0x005c;
     */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long divide(long r8, long r10, java.math.RoundingMode r12) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r12)
            long r0 = r8 / r10
            long r2 = r10 * r0
            long r2 = r8 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            return r0
        L_0x0010:
            long r8 = r8 ^ r10
            r6 = 63
            long r8 = r8 >> r6
            int r9 = (int) r8
            r8 = 1
            r9 = r9 | r8
            int[] r6 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r7 = r12.ordinal()
            r6 = r6[r7]
            r7 = 0
            switch(r6) {
                case 1: goto L_0x0052;
                case 2: goto L_0x005b;
                case 3: goto L_0x004f;
                case 4: goto L_0x005c;
                case 5: goto L_0x004c;
                case 6: goto L_0x0029;
                case 7: goto L_0x0029;
                case 8: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L_0x0029:
            long r2 = java.lang.Math.abs(r2)
            long r10 = java.lang.Math.abs(r10)
            long r10 = r10 - r2
            long r2 = r2 - r10
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0047
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_UP
            if (r12 == r10) goto L_0x005c
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r10) goto L_0x005b
            r10 = 1
            long r10 = r10 & r0
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x005b
            goto L_0x005c
        L_0x0047:
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x005b
            goto L_0x005c
        L_0x004c:
            if (r9 <= 0) goto L_0x005b
            goto L_0x005c
        L_0x004f:
            if (r9 >= 0) goto L_0x005b
            goto L_0x005c
        L_0x0052:
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r8)
        L_0x005b:
            r8 = 0
        L_0x005c:
            if (r8 == 0) goto L_0x0060
            long r8 = (long) r9
            long r0 = r0 + r8
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.divide(long, long, java.math.RoundingMode):long");
    }

    @GwtIncompatible
    public static long factorial(int i10) {
        MathPreconditions.checkNonNegative("n", i10);
        long[] jArr = factorials;
        if (i10 < jArr.length) {
            return jArr[i10];
        }
        return Long.MAX_VALUE;
    }

    public static boolean fitsInInt(long j10) {
        return ((long) ((int) j10)) == j10;
    }

    @Beta
    public static long floorPowerOfTwo(long j10) {
        MathPreconditions.checkPositive("x", j10);
        return 1 << (63 - Long.numberOfLeadingZeros(j10));
    }

    public static long gcd(long j10, long j11) {
        MathPreconditions.checkNonNegative("a", j10);
        MathPreconditions.checkNonNegative(b.f11376b, j11);
        if (j10 == 0) {
            return j11;
        }
        if (j11 == 0) {
            return j10;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j10);
        long j12 = j10 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j11);
        long j13 = j11 >> numberOfTrailingZeros2;
        while (j12 != j13) {
            long j14 = j12 - j13;
            long j15 = (j14 >> 63) & j14;
            long j16 = (j14 - j15) - j15;
            j13 += j15;
            j12 = j16 >> Long.numberOfTrailingZeros(j16);
        }
        return j12 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j10) {
        boolean z10 = true;
        boolean z11 = j10 > 0;
        if ((j10 & (j10 - 1)) != 0) {
            z10 = false;
        }
        return z11 & z10;
    }

    @GwtIncompatible
    @Beta
    public static boolean isPrime(long j10) {
        if (j10 < 2) {
            MathPreconditions.checkNonNegative("n", j10);
            return false;
        } else if (j10 < 66) {
            if (((722865708377213483 >> (((int) j10) - 2)) & 1) != 0) {
                return true;
            }
            return false;
        } else if (((1 << ((int) (j10 % 30))) & SIEVE_30) != 0 || j10 % 7 == 0 || j10 % 11 == 0 || j10 % 13 == 0) {
            return false;
        } else {
            if (j10 < 289) {
                return true;
            }
            for (long[] jArr : millerRabinBaseSets) {
                if (j10 <= jArr[0]) {
                    for (int i10 = 1; i10 < jArr.length; i10++) {
                        if (!MillerRabinTester.test(jArr[i10], j10)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            throw new AssertionError();
        }
    }

    @VisibleForTesting
    public static int lessThanBranchFree(long j10, long j11) {
        return (int) ((((j10 - j11) ^ -1) ^ -1) >>> 63);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        return r0 + r4;
     */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int log10(long r4, java.math.RoundingMode r6) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.checkPositive((java.lang.String) r0, (long) r4)
            int r0 = log10Floor(r4)
            long[] r1 = powersOf10
            r2 = r1[r0]
            int[] r1 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r6 = r6.ordinal()
            r6 = r1[r6]
            switch(r6) {
                case 1: goto L_0x002d;
                case 2: goto L_0x0037;
                case 3: goto L_0x0037;
                case 4: goto L_0x0028;
                case 5: goto L_0x0028;
                case 6: goto L_0x001e;
                case 7: goto L_0x001e;
                case 8: goto L_0x001e;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x001e:
            long[] r6 = halfPowersOf10
            r1 = r6[r0]
            int r4 = lessThanBranchFree(r1, r4)
        L_0x0026:
            int r0 = r0 + r4
            return r0
        L_0x0028:
            int r4 = lessThanBranchFree(r2, r4)
            goto L_0x0026
        L_0x002d:
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r4)
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.log10(long, java.math.RoundingMode):int");
    }

    @GwtIncompatible
    public static int log10Floor(long j10) {
        byte b10 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j10)];
        return b10 - lessThanBranchFree(j10, powersOf10[b10]);
    }

    public static int log2(long j10, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j10);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j10));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j10 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10);
                return (63 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, j10);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j10);
    }

    public static long mean(long j10, long j11) {
        return (j10 & j11) + ((j10 ^ j11) >> 1);
    }

    @GwtIncompatible
    public static int mod(long j10, int i10) {
        return (int) mod(j10, (long) i10);
    }

    public static long multiplyFraction(long j10, long j11, long j12) {
        if (j10 == 1) {
            return j11 / j12;
        }
        long gcd = gcd(j10, j12);
        return (j10 / gcd) * (j11 / (j12 / gcd));
    }

    @GwtIncompatible
    public static long pow(long j10, int i10) {
        long j11;
        MathPreconditions.checkNonNegative("exponent", i10);
        if (-2 > j10 || j10 > 2) {
            long j12 = 1;
            while (i10 != 0) {
                if (i10 == 1) {
                    return j12 * j10;
                }
                if ((i10 & 1) == 0) {
                    j11 = 1;
                } else {
                    j11 = j10;
                }
                j12 *= j11;
                j10 *= j10;
                i10 >>= 1;
            }
            return j12;
        }
        int i11 = (int) j10;
        if (i11 != -2) {
            if (i11 != -1) {
                if (i11 != 0) {
                    if (i11 == 1) {
                        return 1;
                    }
                    if (i11 != 2) {
                        throw new AssertionError();
                    } else if (i10 < 64) {
                        return 1 << i10;
                    } else {
                        return 0;
                    }
                } else if (i10 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i10 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (i10 >= 64) {
            return 0;
        } else {
            if ((i10 & 1) == 0) {
                return 1 << i10;
            }
            return -(1 << i10);
        }
    }

    @GwtIncompatible
    public static double roundToDouble(long j10, RoundingMode roundingMode) {
        int i10;
        boolean z10;
        double d10;
        long j11;
        long j12 = j10;
        double d11 = (double) j12;
        long j13 = (long) d11;
        if (j13 == Long.MAX_VALUE) {
            i10 = -1;
        } else {
            i10 = Longs.compare(j12, j13);
        }
        int[] iArr = AnonymousClass1.$SwitchMap$java$math$RoundingMode;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                if (i10 == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z10);
                return d11;
            case 2:
                if (j12 >= 0) {
                    if (i10 >= 0) {
                        return d11;
                    }
                    return DoubleUtils.nextDown(d11);
                } else if (i10 <= 0) {
                    return d11;
                } else {
                    return Math.nextUp(d11);
                }
            case 3:
                if (i10 >= 0) {
                    return d11;
                }
                return DoubleUtils.nextDown(d11);
            case 4:
                if (j12 >= 0) {
                    if (i10 <= 0) {
                        return d11;
                    }
                    return Math.nextUp(d11);
                } else if (i10 >= 0) {
                    return d11;
                } else {
                    return DoubleUtils.nextDown(d11);
                }
            case 5:
                if (i10 <= 0) {
                    return d11;
                }
                return Math.nextUp(d11);
            case 6:
            case 7:
            case 8:
                if (i10 >= 0) {
                    d10 = Math.nextUp(d11);
                    j11 = (long) Math.ceil(d10);
                } else {
                    double nextDown = DoubleUtils.nextDown(d11);
                    long j14 = j13;
                    j13 = (long) Math.floor(nextDown);
                    d10 = d11;
                    d11 = nextDown;
                    j11 = j14;
                }
                long j15 = j12 - j13;
                long j16 = j11 - j12;
                if (j11 == Long.MAX_VALUE) {
                    j16++;
                }
                int compare = Longs.compare(j15, j16);
                if (compare < 0) {
                    return d11;
                }
                if (compare > 0) {
                    return d10;
                }
                int i11 = iArr[roundingMode.ordinal()];
                if (i11 != 6) {
                    if (i11 != 7) {
                        if (i11 != 8) {
                            throw new AssertionError("impossible");
                        } else if ((DoubleUtils.getSignificand(d11) & 1) == 0) {
                            return d11;
                        } else {
                            return d10;
                        }
                    } else if (j12 >= 0) {
                        return d10;
                    } else {
                        return d11;
                    }
                } else if (j12 >= 0) {
                    return d11;
                } else {
                    return d10;
                }
            default:
                throw new AssertionError("impossible");
        }
    }

    @Beta
    public static long saturatedAdd(long j10, long j11) {
        long j12 = j10 + j11;
        boolean z10 = true;
        boolean z11 = (j11 ^ j10) < 0;
        if ((j10 ^ j12) < 0) {
            z10 = false;
        }
        return z11 | z10 ? j12 : ((j12 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @Beta
    public static long saturatedMultiply(long j10, long j11) {
        boolean z10;
        boolean z11;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10) + Long.numberOfLeadingZeros(j10 ^ -1) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(-1 ^ j11);
        if (numberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        long j12 = ((j10 ^ j11) >>> 63) + Long.MAX_VALUE;
        boolean z12 = true;
        if (numberOfLeadingZeros < 64) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 < 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (j11 != Long.MIN_VALUE) {
            z12 = false;
        }
        if (z10 || (z11 & z12)) {
            return j12;
        }
        long j13 = j10 * j11;
        if (j10 == 0 || j13 / j10 == j11) {
            return j13;
        }
        return j12;
    }

    @Beta
    public static long saturatedPow(long j10, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        MathPreconditions.checkNonNegative("exponent", i10);
        if (j10 >= -2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 <= 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        long j11 = 1;
        if (z10 && z11) {
            int i11 = (int) j10;
            if (i11 != -2) {
                if (i11 != -1) {
                    if (i11 != 0) {
                        if (i11 == 1) {
                            return 1;
                        }
                        if (i11 != 2) {
                            throw new AssertionError();
                        } else if (i10 >= 63) {
                            return Long.MAX_VALUE;
                        } else {
                            return 1 << i10;
                        }
                    } else if (i10 == 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else if ((i10 & 1) == 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (i10 >= 64) {
                return ((long) (i10 & 1)) + Long.MAX_VALUE;
            } else {
                if ((i10 & 1) == 0) {
                    return 1 << i10;
                }
                return -1 << i10;
            }
        } else {
            long j12 = ((j10 >>> 63) & ((long) (i10 & 1))) + Long.MAX_VALUE;
            while (i10 != 0) {
                if (i10 == 1) {
                    return saturatedMultiply(j11, j10);
                }
                if ((i10 & 1) != 0) {
                    j11 = saturatedMultiply(j11, j10);
                }
                i10 >>= 1;
                if (i10 > 0) {
                    if (-3037000499L > j10) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (j10 > FLOOR_SQRT_MAX_LONG) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z12 || z13) {
                        return j12;
                    }
                    j10 *= j10;
                }
            }
            return j11;
        }
    }

    @Beta
    public static long saturatedSubtract(long j10, long j11) {
        long j12 = j10 - j11;
        boolean z10 = true;
        boolean z11 = (j11 ^ j10) >= 0;
        if ((j10 ^ j12) < 0) {
            z10 = false;
        }
        return z11 | z10 ? j12 : ((j12 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @GwtIncompatible
    public static long sqrt(long j10, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j10);
        if (fitsInInt(j10)) {
            return (long) IntMath.sqrt((int) j10, roundingMode);
        }
        long sqrt = (long) Math.sqrt((double) j10);
        long j11 = sqrt * sqrt;
        boolean z10 = true;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (j11 != j10) {
                    z10 = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z10);
                return sqrt;
            case 2:
            case 3:
                if (j10 < j11) {
                    return sqrt - 1;
                }
                return sqrt;
            case 4:
            case 5:
                if (j10 > j11) {
                    return sqrt + 1;
                }
                return sqrt;
            case 6:
            case 7:
            case 8:
                if (j10 >= j11) {
                    z10 = false;
                }
                long j12 = sqrt - (z10 ? 1 : 0);
                return j12 + ((long) lessThanBranchFree((j12 * j12) + j12, j10));
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long mod(long j10, long j11) {
        if (j11 > 0) {
            long j12 = j10 % j11;
            return j12 >= 0 ? j12 : j12 + j11;
        }
        throw new ArithmeticException("Modulus must be positive");
    }
}
