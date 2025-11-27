package androidx.collection;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public class h implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f1564e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f1565a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f1566b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f1567c;

    /* renamed from: d  reason: collision with root package name */
    public int f1568d;

    public h() {
        this(10);
    }

    public void a(int i10, Object obj) {
        int i11 = this.f1568d;
        if (i11 == 0 || i10 > this.f1566b[i11 - 1]) {
            if (this.f1565a && i11 >= this.f1566b.length) {
                d();
            }
            int i12 = this.f1568d;
            if (i12 >= this.f1566b.length) {
                int e10 = c.e(i12 + 1);
                int[] iArr = new int[e10];
                Object[] objArr = new Object[e10];
                int[] iArr2 = this.f1566b;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f1567c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1566b = iArr;
                this.f1567c = objArr;
            }
            this.f1566b[i12] = i10;
            this.f1567c[i12] = obj;
            this.f1568d = i12 + 1;
            return;
        }
        i(i10, obj);
    }

    public void b() {
        int i10 = this.f1568d;
        Object[] objArr = this.f1567c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f1568d = 0;
        this.f1565a = false;
    }

    /* renamed from: c */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.f1566b = (int[]) this.f1566b.clone();
            hVar.f1567c = (Object[]) this.f1567c.clone();
            return hVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public final void d() {
        int i10 = this.f1568d;
        int[] iArr = this.f1566b;
        Object[] objArr = this.f1567c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f1564e) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f1565a = false;
        this.f1568d = i11;
    }

    public Object e(int i10) {
        return f(i10, (Object) null);
    }

    public Object f(int i10, Object obj) {
        Object obj2;
        int a10 = c.a(this.f1566b, this.f1568d, i10);
        if (a10 < 0 || (obj2 = this.f1567c[a10]) == f1564e) {
            return obj;
        }
        return obj2;
    }

    public int g(Object obj) {
        if (this.f1565a) {
            d();
        }
        for (int i10 = 0; i10 < this.f1568d; i10++) {
            if (this.f1567c[i10] == obj) {
                return i10;
            }
        }
        return -1;
    }

    public int h(int i10) {
        if (this.f1565a) {
            d();
        }
        return this.f1566b[i10];
    }

    public void i(int i10, Object obj) {
        int a10 = c.a(this.f1566b, this.f1568d, i10);
        if (a10 >= 0) {
            this.f1567c[a10] = obj;
            return;
        }
        int i11 = a10 ^ -1;
        int i12 = this.f1568d;
        if (i11 < i12) {
            Object[] objArr = this.f1567c;
            if (objArr[i11] == f1564e) {
                this.f1566b[i11] = i10;
                objArr[i11] = obj;
                return;
            }
        }
        if (this.f1565a && i12 >= this.f1566b.length) {
            d();
            i11 = c.a(this.f1566b, this.f1568d, i10) ^ -1;
        }
        int i13 = this.f1568d;
        if (i13 >= this.f1566b.length) {
            int e10 = c.e(i13 + 1);
            int[] iArr = new int[e10];
            Object[] objArr2 = new Object[e10];
            int[] iArr2 = this.f1566b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1567c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1566b = iArr;
            this.f1567c = objArr2;
        }
        int i14 = this.f1568d;
        if (i14 - i11 != 0) {
            int[] iArr3 = this.f1566b;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr4 = this.f1567c;
            System.arraycopy(objArr4, i11, objArr4, i15, this.f1568d - i11);
        }
        this.f1566b[i11] = i10;
        this.f1567c[i11] = obj;
        this.f1568d++;
    }

    public int j() {
        if (this.f1565a) {
            d();
        }
        return this.f1568d;
    }

    public Object k(int i10) {
        if (this.f1565a) {
            d();
        }
        return this.f1567c[i10];
    }

    public String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1568d * 28);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        for (int i10 = 0; i10 < this.f1568d; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(h(i10));
            sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
            Object k10 = k(i10);
            if (k10 != this) {
                sb.append(k10);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb.toString();
    }

    public h(int i10) {
        this.f1565a = false;
        if (i10 == 0) {
            this.f1566b = c.f1541a;
            this.f1567c = c.f1543c;
            return;
        }
        int e10 = c.e(i10);
        this.f1566b = new int[e10];
        this.f1567c = new Object[e10];
    }
}
