package i9;

import java.util.NoSuchElementException;
import t9.i;

public abstract class g extends f {
    public static final boolean e(Object[] objArr, Object obj) {
        i.g(objArr, "<this>");
        if (f(objArr, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static final int f(Object[] objArr, Object obj) {
        i.g(objArr, "<this>");
        int i10 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i10 < length) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i10 < length2) {
            if (i.b(obj, objArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final char g(char[] cArr) {
        i.g(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final Object h(Object[] objArr) {
        i.g(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }
}
