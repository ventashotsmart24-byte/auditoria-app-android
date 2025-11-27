package androidx.collection;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b implements Collection, Set {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f1530e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    public static final Object[] f1531f = new Object[0];

    /* renamed from: g  reason: collision with root package name */
    public static Object[] f1532g;

    /* renamed from: h  reason: collision with root package name */
    public static int f1533h;

    /* renamed from: i  reason: collision with root package name */
    public static Object[] f1534i;

    /* renamed from: j  reason: collision with root package name */
    public static int f1535j;

    /* renamed from: a  reason: collision with root package name */
    public int[] f1536a;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f1537b;

    /* renamed from: c  reason: collision with root package name */
    public int f1538c;

    /* renamed from: d  reason: collision with root package name */
    public f f1539d;

    public class a extends f {
        public a() {
        }

        public void a() {
            b.this.clear();
        }

        public Object b(int i10, int i11) {
            return b.this.f1537b[i10];
        }

        public Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        public int d() {
            return b.this.f1538c;
        }

        public int e(Object obj) {
            return b.this.indexOf(obj);
        }

        public int f(Object obj) {
            return b.this.indexOf(obj);
        }

        public void g(Object obj, Object obj2) {
            b.this.add(obj);
        }

        public void h(int i10) {
            b.this.g(i10);
        }

        public Object i(int i10, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public static void c(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f1535j < 10) {
                    objArr[0] = f1534i;
                    objArr[1] = iArr;
                    for (int i11 = i10 - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f1534i = objArr;
                    f1535j++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f1533h < 10) {
                    objArr[0] = f1532g;
                    objArr[1] = iArr;
                    for (int i12 = i10 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f1532g = objArr;
                    f1533h++;
                }
            }
        }
    }

    public final void a(int i10) {
        if (i10 == 8) {
            synchronized (b.class) {
                Object[] objArr = f1534i;
                if (objArr != null) {
                    this.f1537b = objArr;
                    f1534i = (Object[]) objArr[0];
                    this.f1536a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1535j--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f1532g;
                if (objArr2 != null) {
                    this.f1537b = objArr2;
                    f1532g = (Object[]) objArr2[0];
                    this.f1536a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1533h--;
                    return;
                }
            }
        }
        this.f1536a = new int[i10];
        this.f1537b = new Object[i10];
    }

    public boolean add(Object obj) {
        int i10;
        int i11;
        if (obj == null) {
            i11 = f();
            i10 = 0;
        } else {
            int hashCode = obj.hashCode();
            i10 = hashCode;
            i11 = e(obj, hashCode);
        }
        if (i11 >= 0) {
            return false;
        }
        int i12 = i11 ^ -1;
        int i13 = this.f1538c;
        int[] iArr = this.f1536a;
        if (i13 >= iArr.length) {
            int i14 = 8;
            if (i13 >= 8) {
                i14 = (i13 >> 1) + i13;
            } else if (i13 < 4) {
                i14 = 4;
            }
            Object[] objArr = this.f1537b;
            a(i14);
            int[] iArr2 = this.f1536a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1537b, 0, objArr.length);
            }
            c(iArr, objArr, this.f1538c);
        }
        int i15 = this.f1538c;
        if (i12 < i15) {
            int[] iArr3 = this.f1536a;
            int i16 = i12 + 1;
            System.arraycopy(iArr3, i12, iArr3, i16, i15 - i12);
            Object[] objArr2 = this.f1537b;
            System.arraycopy(objArr2, i12, objArr2, i16, this.f1538c - i12);
        }
        this.f1536a[i12] = i10;
        this.f1537b[i12] = obj;
        this.f1538c++;
        return true;
    }

    public boolean addAll(Collection collection) {
        b(this.f1538c + collection.size());
        boolean z10 = false;
        for (Object add : collection) {
            z10 |= add(add);
        }
        return z10;
    }

    public void b(int i10) {
        int[] iArr = this.f1536a;
        if (iArr.length < i10) {
            Object[] objArr = this.f1537b;
            a(i10);
            int i11 = this.f1538c;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f1536a, 0, i11);
                System.arraycopy(objArr, 0, this.f1537b, 0, this.f1538c);
            }
            c(iArr, objArr, this.f1538c);
        }
    }

    public void clear() {
        int i10 = this.f1538c;
        if (i10 != 0) {
            c(this.f1536a, this.f1537b, i10);
            this.f1536a = f1530e;
            this.f1537b = f1531f;
            this.f1538c = 0;
        }
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final f d() {
        if (this.f1539d == null) {
            this.f1539d = new a();
        }
        return this.f1539d;
    }

    public final int e(Object obj, int i10) {
        int i11 = this.f1538c;
        if (i11 == 0) {
            return -1;
        }
        int a10 = c.a(this.f1536a, i11, i10);
        if (a10 < 0 || obj.equals(this.f1537b[a10])) {
            return a10;
        }
        int i12 = a10 + 1;
        while (i12 < i11 && this.f1536a[i12] == i10) {
            if (obj.equals(this.f1537b[i12])) {
                return i12;
            }
            i12++;
        }
        int i13 = a10 - 1;
        while (i13 >= 0 && this.f1536a[i13] == i10) {
            if (obj.equals(this.f1537b[i13])) {
                return i13;
            }
            i13--;
        }
        return i12 ^ -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i10 = 0;
            while (i10 < this.f1538c) {
                try {
                    if (!set.contains(h(i10))) {
                        return false;
                    }
                    i10++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i10 = this.f1538c;
        if (i10 == 0) {
            return -1;
        }
        int a10 = c.a(this.f1536a, i10, 0);
        if (a10 < 0 || this.f1537b[a10] == null) {
            return a10;
        }
        int i11 = a10 + 1;
        while (i11 < i10 && this.f1536a[i11] == 0) {
            if (this.f1537b[i11] == null) {
                return i11;
            }
            i11++;
        }
        int i12 = a10 - 1;
        while (i12 >= 0 && this.f1536a[i12] == 0) {
            if (this.f1537b[i12] == null) {
                return i12;
            }
            i12--;
        }
        return i11 ^ -1;
    }

    public Object g(int i10) {
        Object[] objArr = this.f1537b;
        Object obj = objArr[i10];
        int i11 = this.f1538c;
        if (i11 <= 1) {
            c(this.f1536a, objArr, i11);
            this.f1536a = f1530e;
            this.f1537b = f1531f;
            this.f1538c = 0;
        } else {
            int[] iArr = this.f1536a;
            int i12 = 8;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                int i13 = i11 - 1;
                this.f1538c = i13;
                if (i10 < i13) {
                    int i14 = i10 + 1;
                    System.arraycopy(iArr, i14, iArr, i10, i13 - i10);
                    Object[] objArr2 = this.f1537b;
                    System.arraycopy(objArr2, i14, objArr2, i10, this.f1538c - i10);
                }
                this.f1537b[this.f1538c] = null;
            } else {
                if (i11 > 8) {
                    i12 = i11 + (i11 >> 1);
                }
                a(i12);
                this.f1538c--;
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f1536a, 0, i10);
                    System.arraycopy(objArr, 0, this.f1537b, 0, i10);
                }
                int i15 = this.f1538c;
                if (i10 < i15) {
                    int i16 = i10 + 1;
                    System.arraycopy(iArr, i16, this.f1536a, i10, i15 - i10);
                    System.arraycopy(objArr, i16, this.f1537b, i10, this.f1538c - i10);
                }
            }
        }
        return obj;
    }

    public Object h(int i10) {
        return this.f1537b[i10];
    }

    public int hashCode() {
        int[] iArr = this.f1536a;
        int i10 = this.f1538c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return f();
        }
        return e(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        if (this.f1538c <= 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return d().m().iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        g(indexOf);
        return true;
    }

    public boolean removeAll(Collection collection) {
        boolean z10 = false;
        for (Object remove : collection) {
            z10 |= remove(remove);
        }
        return z10;
    }

    public boolean retainAll(Collection collection) {
        boolean z10 = false;
        for (int i10 = this.f1538c - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f1537b[i10])) {
                g(i10);
                z10 = true;
            }
        }
        return z10;
    }

    public int size() {
        return this.f1538c;
    }

    public Object[] toArray() {
        int i10 = this.f1538c;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f1537b, 0, objArr, 0, i10);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1538c * 14);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        for (int i10 = 0; i10 < this.f1538c; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object h10 = h(i10);
            if (h10 != this) {
                sb.append(h10);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb.toString();
    }

    public b(int i10) {
        if (i10 == 0) {
            this.f1536a = f1530e;
            this.f1537b = f1531f;
        } else {
            a(i10);
        }
        this.f1538c = 0;
    }

    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f1538c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f1538c);
        }
        System.arraycopy(this.f1537b, 0, objArr, 0, this.f1538c);
        int length = objArr.length;
        int i10 = this.f1538c;
        if (length > i10) {
            objArr[i10] = null;
        }
        return objArr;
    }
}
