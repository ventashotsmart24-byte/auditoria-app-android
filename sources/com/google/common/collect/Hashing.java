package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class Hashing {
    private static final long C1 = -862048943;
    private static final long C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    public static int closedTableSize(int i10, double d10) {
        int max = Math.max(i10, 2);
        int highestOneBit = Integer.highestOneBit(max);
        double d11 = (double) highestOneBit;
        Double.isNaN(d11);
        if (max <= ((int) (d10 * d11))) {
            return highestOneBit;
        }
        int i11 = highestOneBit << 1;
        if (i11 > 0) {
            return i11;
        }
        return 1073741824;
    }

    public static boolean needsResizing(int i10, int i11, double d10) {
        double d11 = (double) i11;
        Double.isNaN(d11);
        if (((double) i10) <= d10 * d11 || i11 >= 1073741824) {
            return false;
        }
        return true;
    }

    public static int smear(int i10) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i10) * C1), 15)) * C2);
    }

    public static int smearedHash(@CheckForNull Object obj) {
        int i10;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = obj.hashCode();
        }
        return smear(i10);
    }
}
