package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Chars {
    public static final int BYTES = 2;

    @GwtCompatible
    public static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        public CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Character) || Chars.indexOf(this.array, ((Character) obj).charValue(), this.start, this.end) == -1) {
                return false;
            }
            return true;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharArrayAsList)) {
                return super.equals(obj);
            }
            CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != charArrayAsList.array[charArrayAsList.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i10 = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                i10 = (i10 * 31) + Chars.hashCode(this.array[i11]);
            }
            return i10;
        }

        public int indexOf(@CheckForNull Object obj) {
            int access$000;
            if (!(obj instanceof Character) || (access$000 = Chars.indexOf(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int access$100;
            if (!(obj instanceof Character) || (access$100 = Chars.lastIndexOf(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Character> subList(int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i12 = this.start;
            return new CharArrayAsList(cArr, i10 + i12, i12 + i11);
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 < this.end) {
                    sb.append(", ");
                    sb.append(this.array[i10]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public CharArrayAsList(char[] cArr, int i10, int i11) {
            this.array = cArr;
            this.start = i10;
            this.end = i11;
        }

        public Character get(int i10) {
            Preconditions.checkElementIndex(i10, size());
            return Character.valueOf(this.array[this.start + i10]);
        }

        public Character set(int i10, Character ch) {
            Preconditions.checkElementIndex(i10, size());
            char[] cArr = this.array;
            int i11 = this.start;
            char c10 = cArr[i11 + i10];
            cArr[i11 + i10] = ((Character) Preconditions.checkNotNull(ch)).charValue();
            return Character.valueOf(c10);
        }
    }

    public enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                int compare = Chars.compare(cArr[i10], cArr2[i10]);
                if (compare != 0) {
                    return compare;
                }
            }
            return cArr.length - cArr2.length;
        }
    }

    private Chars() {
    }

    public static List<Character> asList(char... cArr) {
        if (cArr.length == 0) {
            return Collections.emptyList();
        }
        return new CharArrayAsList(cArr);
    }

    public static char checkedCast(long j10) {
        boolean z10;
        char c10 = (char) ((int) j10);
        if (((long) c10) == j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "Out of range: %s", j10);
        return c10;
    }

    public static int compare(char c10, char c11) {
        return c10 - c11;
    }

    public static char[] concat(char[]... cArr) {
        int i10 = 0;
        for (char[] length : cArr) {
            i10 += length.length;
        }
        char[] cArr2 = new char[i10];
        int i11 = 0;
        for (char[] cArr3 : cArr) {
            System.arraycopy(cArr3, 0, cArr2, i11, cArr3.length);
            i11 += cArr3.length;
        }
        return cArr2;
    }

    @Beta
    public static char constrainToRange(char c10, char c11, char c12) {
        boolean z10;
        if (c11 <= c12) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "min (%s) must be less than or equal to max (%s)", c11, c12);
        if (c10 < c11) {
            return c11;
        }
        if (c10 < c12) {
            return c10;
        }
        return c12;
    }

    public static boolean contains(char[] cArr, char c10) {
        for (char c11 : cArr) {
            if (c11 == c10) {
                return true;
            }
        }
        return false;
    }

    public static char[] ensureCapacity(char[] cArr, int i10, int i11) {
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
        if (cArr.length < i10) {
            return Arrays.copyOf(cArr, i10 + i11);
        }
        return cArr;
    }

    @GwtIncompatible
    public static char fromByteArray(byte[] bArr) {
        boolean z10;
        if (bArr.length >= 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static char fromBytes(byte b10, byte b11) {
        return (char) ((b10 << 8) | (b11 & UnsignedBytes.MAX_VALUE));
    }

    public static int hashCode(char c10) {
        return c10;
    }

    public static int indexOf(char[] cArr, char c10) {
        return indexOf(cArr, c10, 0, cArr.length);
    }

    public static String join(String str, char... cArr) {
        Preconditions.checkNotNull(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((str.length() * (length - 1)) + length);
        sb.append(cArr[0]);
        for (int i10 = 1; i10 < length; i10++) {
            sb.append(str);
            sb.append(cArr[i10]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(char[] cArr, char c10) {
        return lastIndexOf(cArr, c10, 0, cArr.length);
    }

    public static Comparator<char[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static char max(char... cArr) {
        boolean z10;
        if (cArr.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        char c10 = cArr[0];
        for (int i10 = 1; i10 < cArr.length; i10++) {
            char c11 = cArr[i10];
            if (c11 > c10) {
                c10 = c11;
            }
        }
        return c10;
    }

    public static char min(char... cArr) {
        boolean z10;
        if (cArr.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        char c10 = cArr[0];
        for (int i10 = 1; i10 < cArr.length; i10++) {
            char c11 = cArr[i10];
            if (c11 < c10) {
                c10 = c11;
            }
        }
        return c10;
    }

    public static void reverse(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        reverse(cArr, 0, cArr.length);
    }

    public static char saturatedCast(long j10) {
        if (j10 > 65535) {
            return 65535;
        }
        if (j10 < 0) {
            return 0;
        }
        return (char) ((int) j10);
    }

    public static void sortDescending(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        sortDescending(cArr, 0, cArr.length);
    }

    public static char[] toArray(Collection<Character> collection) {
        if (collection instanceof CharArrayAsList) {
            return ((CharArrayAsList) collection).toCharArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = ((Character) Preconditions.checkNotNull(array[i10])).charValue();
        }
        return cArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(char c10) {
        return new byte[]{(byte) (c10 >> 8), (byte) c10};
    }

    /* access modifiers changed from: private */
    public static int indexOf(char[] cArr, char c10, int i10, int i11) {
        while (i10 < i11) {
            if (cArr[i10] == c10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(char[] cArr, char c10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (cArr[i12] == c10) {
                return i12;
            }
        }
        return -1;
    }

    public static int indexOf(char[] cArr, char[] cArr2) {
        Preconditions.checkNotNull(cArr, "array");
        Preconditions.checkNotNull(cArr2, "target");
        if (cArr2.length == 0) {
            return 0;
        }
        int i10 = 0;
        while (i10 < (cArr.length - cArr2.length) + 1) {
            int i11 = 0;
            while (i11 < cArr2.length) {
                if (cArr[i10 + i11] != cArr2[i11]) {
                    i10++;
                } else {
                    i11++;
                }
            }
            return i10;
        }
        return -1;
    }

    public static void reverse(char[] cArr, int i10, int i11) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i10, i11, cArr.length);
        for (int i12 = i11 - 1; i10 < i12; i12--) {
            char c10 = cArr[i10];
            cArr[i10] = cArr[i12];
            cArr[i12] = c10;
            i10++;
        }
    }

    public static void sortDescending(char[] cArr, int i10, int i11) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i10, i11, cArr.length);
        Arrays.sort(cArr, i10, i11);
        reverse(cArr, i10, i11);
    }
}
