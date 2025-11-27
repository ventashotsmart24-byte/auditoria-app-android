package d4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class i implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final i f6272d = new i(1, 0, new Object[4]);

    /* renamed from: a  reason: collision with root package name */
    public final int f6273a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6274b;

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f6275c;

    public i(int i10, int i11, Object[] objArr) {
        this.f6273a = i10;
        this.f6274b = i11;
        this.f6275c = objArr;
    }

    public static i b(Map map) {
        if (map.isEmpty()) {
            return f6272d;
        }
        int e10 = e(map.size());
        int i10 = e10 - 1;
        int i11 = (e10 >> 1) + e10;
        Object[] objArr = new Object[(i11 * 2)];
        int i12 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                int hashCode = str.hashCode() & i10;
                int i13 = hashCode + hashCode;
                if (objArr[i13] != null) {
                    i13 = ((hashCode >> 1) + e10) << 1;
                    if (objArr[i13] != null) {
                        i13 = (i11 << 1) + i12;
                        i12 += 2;
                        if (i13 >= objArr.length) {
                            objArr = Arrays.copyOf(objArr, objArr.length + 4);
                        }
                    }
                }
                objArr[i13] = str;
                objArr[i13 + 1] = entry.getValue();
            }
        }
        return new i(i10, i12, objArr);
    }

    public static final int e(int i10) {
        if (i10 <= 5) {
            return 8;
        }
        if (i10 <= 12) {
            return 16;
        }
        int i11 = 32;
        while (i11 < i10 + (i10 >> 2)) {
            i11 += i11;
        }
        return i11;
    }

    public final Object a(String str, int i10, Object obj) {
        if (obj == null) {
            return null;
        }
        int i11 = this.f6273a + 1;
        int i12 = ((i10 >> 1) + i11) << 1;
        Object obj2 = this.f6275c[i12];
        if (str.equals(obj2)) {
            return this.f6275c[i12 + 1];
        }
        if (obj2 != null) {
            int i13 = (i11 + (i11 >> 1)) << 1;
            int i14 = this.f6274b + i13;
            while (i13 < i14) {
                Object obj3 = this.f6275c[i13];
                if (obj3 == str || str.equals(obj3)) {
                    return this.f6275c[i13 + 1];
                }
                i13 += 2;
            }
        }
        return null;
    }

    public Object c(String str) {
        int hashCode = str.hashCode() & this.f6273a;
        int i10 = hashCode << 1;
        Object obj = this.f6275c[i10];
        if (obj == str || str.equals(obj)) {
            return this.f6275c[i10 + 1];
        }
        return a(str, hashCode, obj);
    }

    public Object d(String str) {
        int length = this.f6275c.length;
        for (int i10 = 0; i10 < length; i10 += 2) {
            Object obj = this.f6275c[i10];
            if (obj != null && ((String) obj).equalsIgnoreCase(str)) {
                return this.f6275c[i10 + 1];
            }
        }
        return null;
    }

    public List f() {
        int length = this.f6275c.length;
        ArrayList arrayList = new ArrayList(length >> 2);
        for (int i10 = 0; i10 < length; i10 += 2) {
            Object obj = this.f6275c[i10];
            if (obj != null) {
                arrayList.add((String) obj);
            }
        }
        return arrayList;
    }
}
