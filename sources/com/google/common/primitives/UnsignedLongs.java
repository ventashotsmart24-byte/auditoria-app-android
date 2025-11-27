package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@Beta
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                long j10 = jArr[i10];
                long j11 = jArr2[i10];
                if (j10 != j11) {
                    return UnsignedLongs.compare(j10, j11);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    public static final class ParseOverflowDetection {
        static final int[] maxSafeDigits = new int[37];
        static final long[] maxValueDivs = new long[37];
        static final int[] maxValueMods = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i10 = 2; i10 <= 36; i10++) {
                long j10 = (long) i10;
                maxValueDivs[i10] = UnsignedLongs.divide(-1, j10);
                maxValueMods[i10] = (int) UnsignedLongs.remainder(-1, j10);
                maxSafeDigits[i10] = bigInteger.toString(i10).length() - 1;
            }
        }

        private ParseOverflowDetection() {
        }

        public static boolean overflowInParse(long j10, int i10, int i11) {
            if (j10 < 0) {
                return true;
            }
            long j11 = maxValueDivs[i11];
            if (j10 < j11) {
                return false;
            }
            if (j10 <= j11 && i10 <= maxValueMods[i11]) {
                return false;
            }
            return true;
        }
    }

    private UnsignedLongs() {
    }

    public static int compare(long j10, long j11) {
        return Longs.compare(flip(j10), flip(j11));
    }

    @CanIgnoreReturnValue
    public static long decode(String str) {
        String str2;
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedLong(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e10) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Error parsing value: ".concat(valueOf);
            } else {
                str2 = new String("Error parsing value: ");
            }
            NumberFormatException numberFormatException = new NumberFormatException(str2);
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }

    public static long divide(long j10, long j11) {
        if (j11 < 0) {
            if (compare(j10, j11) < 0) {
                return 0;
            }
            return 1;
        } else if (j10 >= 0) {
            return j10 / j11;
        } else {
            int i10 = 1;
            long j12 = ((j10 >>> 1) / j11) << 1;
            if (compare(j10 - (j12 * j11), j11) < 0) {
                i10 = 0;
            }
            return j12 + ((long) i10);
        }
    }

    private static long flip(long j10) {
        return j10 ^ Long.MIN_VALUE;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        for (int i10 = 1; i10 < jArr.length; i10++) {
            sb.append(str);
            sb.append(toString(jArr[i10]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        boolean z10;
        if (jArr.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        long flip = flip(jArr[0]);
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long flip2 = flip(jArr[i10]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static long min(long... jArr) {
        boolean z10;
        if (jArr.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        long flip = flip(jArr[0]);
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long flip2 = flip(jArr[i10]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long remainder(long j10, long j11) {
        if (j11 < 0) {
            if (compare(j10, j11) < 0) {
                return j10;
            }
            return j10 - j11;
        } else if (j10 >= 0) {
            return j10 % j11;
        } else {
            long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
            if (compare(j12, j11) < 0) {
                j11 = 0;
            }
            return j12 - j11;
        }
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static String toString(long j10) {
        return toString(j10, 10);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str, int i10) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        } else if (i10 < 2 || i10 > 36) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("illegal radix: ");
            sb.append(i10);
            throw new NumberFormatException(sb.toString());
        } else {
            int i11 = ParseOverflowDetection.maxSafeDigits[i10] - 1;
            long j10 = 0;
            int i12 = 0;
            while (i12 < str.length()) {
                int digit = Character.digit(str.charAt(i12), i10);
                if (digit == -1) {
                    throw new NumberFormatException(str);
                } else if (i12 <= i11 || !ParseOverflowDetection.overflowInParse(j10, digit, i10)) {
                    j10 = (j10 * ((long) i10)) + ((long) digit);
                    i12++;
                } else {
                    throw new NumberFormatException(str.length() != 0 ? "Too large for unsigned long: ".concat(str) : new String("Too large for unsigned long: "));
                }
            }
            return j10;
        }
    }

    public static String toString(long j10, int i10) {
        long j11;
        Preconditions.checkArgument(i10 >= 2 && i10 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i10);
        if (j10 == 0) {
            return "0";
        }
        if (j10 > 0) {
            return Long.toString(j10, i10);
        }
        int i11 = 64;
        char[] cArr = new char[64];
        int i12 = i10 - 1;
        if ((i10 & i12) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i10);
            do {
                i11--;
                cArr[i11] = Character.forDigit(((int) j10) & i12, i10);
                j10 >>>= numberOfTrailingZeros;
            } while (j10 != 0);
        } else {
            if ((i10 & 1) == 0) {
                j11 = (j10 >>> 1) / ((long) (i10 >>> 1));
            } else {
                j11 = divide(j10, (long) i10);
            }
            long j12 = (long) i10;
            int i13 = 63;
            cArr[63] = Character.forDigit((int) (j10 - (j11 * j12)), i10);
            while (j11 > 0) {
                i13--;
                cArr[i13] = Character.forDigit((int) (j11 % j12), i10);
                j11 /= j12;
            }
            i11 = i13;
        }
        return new String(cArr, i11, 64 - i11);
    }

    public static void sort(long[] jArr, int i10, int i11) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i10, i11, jArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            jArr[i12] = flip(jArr[i12]);
        }
        Arrays.sort(jArr, i10, i11);
        while (i10 < i11) {
            jArr[i10] = flip(jArr[i10]);
            i10++;
        }
    }

    public static void sortDescending(long[] jArr, int i10, int i11) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i10, i11, jArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            jArr[i12] = Long.MAX_VALUE ^ jArr[i12];
        }
        Arrays.sort(jArr, i10, i11);
        while (i10 < i11) {
            jArr[i10] = jArr[i10] ^ Long.MAX_VALUE;
            i10++;
        }
    }
}
