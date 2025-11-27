package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Booleans {

    @GwtCompatible
    public static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final boolean[] array;
        final int end;
        final int start;

        public BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Boolean) || Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end) == -1) {
                return false;
            }
            return true;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BooleanArrayAsList)) {
                return super.equals(obj);
            }
            BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
            int size = size();
            if (booleanArrayAsList.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != booleanArrayAsList.array[booleanArrayAsList.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i10 = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                i10 = (i10 * 31) + Booleans.hashCode(this.array[i11]);
            }
            return i10;
        }

        public int indexOf(@CheckForNull Object obj) {
            int access$000;
            if (!(obj instanceof Boolean) || (access$000 = Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int access$100;
            if (!(obj instanceof Boolean) || (access$100 = Booleans.lastIndexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Boolean> subList(int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.array;
            int i12 = this.start;
            return new BooleanArrayAsList(zArr, i10 + i12, i12 + i11);
        }

        public boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder(size() * 7);
            if (this.array[this.start]) {
                str = "[true";
            } else {
                str = "[false";
            }
            sb.append(str);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 < this.end) {
                    if (this.array[i10]) {
                        str2 = ", true";
                    } else {
                        str2 = ", false";
                    }
                    sb.append(str2);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public BooleanArrayAsList(boolean[] zArr, int i10, int i11) {
            this.array = zArr;
            this.start = i10;
            this.end = i11;
        }

        public Boolean get(int i10) {
            Preconditions.checkElementIndex(i10, size());
            return Boolean.valueOf(this.array[this.start + i10]);
        }

        public Boolean set(int i10, Boolean bool) {
            Preconditions.checkElementIndex(i10, size());
            boolean[] zArr = this.array;
            int i11 = this.start;
            boolean z10 = zArr[i11 + i10];
            zArr[i11 + i10] = ((Boolean) Preconditions.checkNotNull(bool)).booleanValue();
            return Boolean.valueOf(z10);
        }
    }

    public enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");
        
        private final String toString;
        private final int trueValue;

        private BooleanComparator(int i10, String str) {
            this.trueValue = i10;
            this.toString = str;
        }

        public String toString() {
            return this.toString;
        }

        public int compare(Boolean bool, Boolean bool2) {
            int i10 = 0;
            int i11 = bool.booleanValue() ? this.trueValue : 0;
            if (bool2.booleanValue()) {
                i10 = this.trueValue;
            }
            return i10 - i11;
        }
    }

    public enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }

        public int compare(boolean[] zArr, boolean[] zArr2) {
            int min = Math.min(zArr.length, zArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                int compare = Booleans.compare(zArr[i10], zArr2[i10]);
                if (compare != 0) {
                    return compare;
                }
            }
            return zArr.length - zArr2.length;
        }
    }

    private Booleans() {
    }

    public static List<Boolean> asList(boolean... zArr) {
        if (zArr.length == 0) {
            return Collections.emptyList();
        }
        return new BooleanArrayAsList(zArr);
    }

    public static int compare(boolean z10, boolean z11) {
        if (z10 == z11) {
            return 0;
        }
        return z10 ? 1 : -1;
    }

    public static boolean[] concat(boolean[]... zArr) {
        int i10 = 0;
        for (boolean[] length : zArr) {
            i10 += length.length;
        }
        boolean[] zArr2 = new boolean[i10];
        int i11 = 0;
        for (boolean[] zArr3 : zArr) {
            System.arraycopy(zArr3, 0, zArr2, i11, zArr3.length);
            i11 += zArr3.length;
        }
        return zArr2;
    }

    public static boolean contains(boolean[] zArr, boolean z10) {
        for (boolean z11 : zArr) {
            if (z11 == z10) {
                return true;
            }
        }
        return false;
    }

    @Beta
    public static int countTrue(boolean... zArr) {
        int i10 = 0;
        for (boolean z10 : zArr) {
            if (z10) {
                i10++;
            }
        }
        return i10;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i10, int i11) {
        boolean z10;
        boolean z11 = true;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "Invalid minLength: %s", i10);
        if (i11 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid padding: %s", i11);
        if (zArr.length < i10) {
            return Arrays.copyOf(zArr, i10 + i11);
        }
        return zArr;
    }

    @Beta
    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int hashCode(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int indexOf(boolean[] zArr, boolean z10) {
        return indexOf(zArr, z10, 0, zArr.length);
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i10 = 1; i10 < zArr.length; i10++) {
            sb.append(str);
            sb.append(zArr[i10]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(boolean[] zArr, boolean z10) {
        return lastIndexOf(zArr, z10, 0, zArr.length);
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList) collection).toBooleanArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            zArr[i10] = ((Boolean) Preconditions.checkNotNull(array[i10])).booleanValue();
        }
        return zArr;
    }

    @Beta
    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }

    /* access modifiers changed from: private */
    public static int indexOf(boolean[] zArr, boolean z10, int i10, int i11) {
        while (i10 < i11) {
            if (zArr[i10] == z10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(boolean[] zArr, boolean z10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (zArr[i12] == z10) {
                return i12;
            }
        }
        return -1;
    }

    public static int indexOf(boolean[] zArr, boolean[] zArr2) {
        Preconditions.checkNotNull(zArr, "array");
        Preconditions.checkNotNull(zArr2, "target");
        if (zArr2.length == 0) {
            return 0;
        }
        int i10 = 0;
        while (i10 < (zArr.length - zArr2.length) + 1) {
            int i11 = 0;
            while (i11 < zArr2.length) {
                if (zArr[i10 + i11] != zArr2[i11]) {
                    i10++;
                } else {
                    i11++;
                }
            }
            return i10;
        }
        return -1;
    }

    public static void reverse(boolean[] zArr, int i10, int i11) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i10, i11, zArr.length);
        for (int i12 = i11 - 1; i10 < i12; i12--) {
            boolean z10 = zArr[i10];
            zArr[i10] = zArr[i12];
            zArr[i12] = z10;
            i10++;
        }
    }
}
