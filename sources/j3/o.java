package j3;

import f3.f;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public final class o {

    /* renamed from: l  reason: collision with root package name */
    public static final char[] f7177l = new char[0];

    /* renamed from: a  reason: collision with root package name */
    public final a f7178a;

    /* renamed from: b  reason: collision with root package name */
    public char[] f7179b;

    /* renamed from: c  reason: collision with root package name */
    public int f7180c;

    /* renamed from: d  reason: collision with root package name */
    public int f7181d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f7182e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7183f;

    /* renamed from: g  reason: collision with root package name */
    public int f7184g;

    /* renamed from: h  reason: collision with root package name */
    public char[] f7185h;

    /* renamed from: i  reason: collision with root package name */
    public int f7186i;

    /* renamed from: j  reason: collision with root package name */
    public String f7187j;

    /* renamed from: k  reason: collision with root package name */
    public char[] f7188k;

    public o(a aVar) {
        this.f7178a = aVar;
    }

    public static o p(char[] cArr) {
        return new o((a) null, cArr);
    }

    public int A() {
        if (this.f7180c >= 0) {
            return this.f7181d;
        }
        char[] cArr = this.f7188k;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.f7187j;
        if (str != null) {
            return str.length();
        }
        return this.f7184g + this.f7186i;
    }

    public final void B(int i10) {
        int i11 = this.f7181d;
        this.f7181d = 0;
        char[] cArr = this.f7179b;
        this.f7179b = null;
        int i12 = this.f7180c;
        this.f7180c = -1;
        int i13 = i10 + i11;
        char[] cArr2 = this.f7185h;
        if (cArr2 == null || i13 > cArr2.length) {
            this.f7185h = d(i13);
        }
        if (i11 > 0) {
            System.arraycopy(cArr, i12, this.f7185h, 0, i11);
        }
        this.f7184g = 0;
        this.f7186i = i11;
    }

    public void a(char c10) {
        if (this.f7180c >= 0) {
            B(16);
        }
        this.f7187j = null;
        this.f7188k = null;
        char[] cArr = this.f7185h;
        if (this.f7186i >= cArr.length) {
            n(1);
            cArr = this.f7185h;
        }
        int i10 = this.f7186i;
        this.f7186i = i10 + 1;
        cArr[i10] = c10;
    }

    public void b(String str, int i10, int i11) {
        if (this.f7180c >= 0) {
            B(i11);
        }
        this.f7187j = null;
        this.f7188k = null;
        char[] cArr = this.f7185h;
        int length = cArr.length;
        int i12 = this.f7186i;
        int i13 = length - i12;
        if (i13 >= i11) {
            str.getChars(i10, i10 + i11, cArr, i12);
            this.f7186i += i11;
            return;
        }
        if (i13 > 0) {
            int i14 = i10 + i13;
            str.getChars(i10, i14, cArr, i12);
            i11 -= i13;
            i10 = i14;
        }
        while (true) {
            n(i11);
            int min = Math.min(this.f7185h.length, i11);
            int i15 = i10 + min;
            str.getChars(i10, i15, this.f7185h, 0);
            this.f7186i += min;
            i11 -= min;
            if (i11 > 0) {
                i10 = i15;
            } else {
                return;
            }
        }
    }

    public void c(char[] cArr, int i10, int i11) {
        if (this.f7180c >= 0) {
            B(i11);
        }
        this.f7187j = null;
        this.f7188k = null;
        char[] cArr2 = this.f7185h;
        int length = cArr2.length;
        int i12 = this.f7186i;
        int i13 = length - i12;
        if (i13 >= i11) {
            System.arraycopy(cArr, i10, cArr2, i12, i11);
            this.f7186i += i11;
            return;
        }
        if (i13 > 0) {
            System.arraycopy(cArr, i10, cArr2, i12, i13);
            i10 += i13;
            i11 -= i13;
        }
        do {
            n(i11);
            int min = Math.min(this.f7185h.length, i11);
            System.arraycopy(cArr, i10, this.f7185h, 0, min);
            this.f7186i += min;
            i10 += min;
            i11 -= min;
        } while (i11 > 0);
    }

    public final char[] d(int i10) {
        a aVar = this.f7178a;
        if (aVar != null) {
            return aVar.d(2, i10);
        }
        return new char[Math.max(i10, 500)];
    }

    public final char[] e(int i10) {
        return new char[i10];
    }

    public final void f() {
        this.f7183f = false;
        this.f7182e.clear();
        this.f7184g = 0;
        this.f7186i = 0;
    }

    public char[] g() {
        char[] cArr = this.f7188k;
        if (cArr != null) {
            return cArr;
        }
        char[] y10 = y();
        this.f7188k = y10;
        return y10;
    }

    public BigDecimal h() {
        char[] cArr;
        char[] cArr2;
        char[] cArr3 = this.f7188k;
        if (cArr3 != null) {
            return f.g(cArr3);
        }
        int i10 = this.f7180c;
        if (i10 >= 0 && (cArr2 = this.f7179b) != null) {
            return f.h(cArr2, i10, this.f7181d);
        }
        if (this.f7184g != 0 || (cArr = this.f7185h) == null) {
            return f.g(g());
        }
        return f.h(cArr, 0, this.f7186i);
    }

    public double i() {
        return f.i(l());
    }

    public int j(boolean z10) {
        char[] cArr;
        int i10 = this.f7180c;
        if (i10 < 0 || (cArr = this.f7179b) == null) {
            if (z10) {
                return -f.k(this.f7185h, 1, this.f7186i - 1);
            }
            return f.k(this.f7185h, 0, this.f7186i);
        } else if (z10) {
            return -f.k(cArr, i10 + 1, this.f7181d - 1);
        } else {
            return f.k(cArr, i10, this.f7181d);
        }
    }

    public long k(boolean z10) {
        char[] cArr;
        int i10 = this.f7180c;
        if (i10 < 0 || (cArr = this.f7179b) == null) {
            if (z10) {
                return -f.m(this.f7185h, 1, this.f7186i - 1);
            }
            return f.m(this.f7185h, 0, this.f7186i);
        } else if (z10) {
            return -f.m(cArr, i10 + 1, this.f7181d - 1);
        } else {
            return f.m(cArr, i10, this.f7181d);
        }
    }

    public String l() {
        if (this.f7187j == null) {
            char[] cArr = this.f7188k;
            if (cArr != null) {
                this.f7187j = new String(cArr);
            } else {
                int i10 = this.f7180c;
                String str = "";
                if (i10 >= 0) {
                    int i11 = this.f7181d;
                    if (i11 < 1) {
                        this.f7187j = str;
                        return str;
                    }
                    this.f7187j = new String(this.f7179b, i10, i11);
                } else {
                    int i12 = this.f7184g;
                    int i13 = this.f7186i;
                    if (i12 == 0) {
                        if (i13 != 0) {
                            str = new String(this.f7185h, 0, i13);
                        }
                        this.f7187j = str;
                    } else {
                        StringBuilder sb = new StringBuilder(i12 + i13);
                        ArrayList arrayList = this.f7182e;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i14 = 0; i14 < size; i14++) {
                                char[] cArr2 = (char[]) this.f7182e.get(i14);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this.f7185h, 0, this.f7186i);
                        this.f7187j = sb.toString();
                    }
                }
            }
        }
        return this.f7187j;
    }

    public char[] m() {
        this.f7180c = -1;
        this.f7186i = 0;
        this.f7181d = 0;
        this.f7179b = null;
        this.f7187j = null;
        this.f7188k = null;
        if (this.f7183f) {
            f();
        }
        char[] cArr = this.f7185h;
        if (cArr != null) {
            return cArr;
        }
        char[] d10 = d(0);
        this.f7185h = d10;
        return d10;
    }

    public final void n(int i10) {
        if (this.f7182e == null) {
            this.f7182e = new ArrayList();
        }
        char[] cArr = this.f7185h;
        this.f7183f = true;
        this.f7182e.add(cArr);
        this.f7184g += cArr.length;
        this.f7186i = 0;
        int length = cArr.length;
        int i11 = length + (length >> 1);
        if (i11 < 500) {
            i11 = 500;
        } else if (i11 > 65536) {
            i11 = 65536;
        }
        this.f7185h = e(i11);
    }

    public char[] o() {
        if (this.f7182e == null) {
            this.f7182e = new ArrayList();
        }
        this.f7183f = true;
        this.f7182e.add(this.f7185h);
        int length = this.f7185h.length;
        this.f7184g += length;
        this.f7186i = 0;
        int i10 = length + (length >> 1);
        if (i10 < 500) {
            i10 = 500;
        } else if (i10 > 65536) {
            i10 = 65536;
        }
        char[] e10 = e(i10);
        this.f7185h = e10;
        return e10;
    }

    public char[] q() {
        if (this.f7180c >= 0) {
            B(1);
        } else {
            char[] cArr = this.f7185h;
            if (cArr == null) {
                this.f7185h = d(0);
            } else if (this.f7186i >= cArr.length) {
                n(1);
            }
        }
        return this.f7185h;
    }

    public int r() {
        return this.f7186i;
    }

    public char[] s() {
        if (this.f7180c >= 0) {
            return this.f7179b;
        }
        char[] cArr = this.f7188k;
        if (cArr != null) {
            return cArr;
        }
        String str = this.f7187j;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.f7188k = charArray;
            return charArray;
        } else if (this.f7183f) {
            return g();
        } else {
            char[] cArr2 = this.f7185h;
            if (cArr2 == null) {
                return f7177l;
            }
            return cArr2;
        }
    }

    public int t() {
        int i10 = this.f7180c;
        if (i10 >= 0) {
            return i10;
        }
        return 0;
    }

    public String toString() {
        return l();
    }

    public void u() {
        char[] cArr;
        this.f7180c = -1;
        this.f7186i = 0;
        this.f7181d = 0;
        this.f7179b = null;
        this.f7188k = null;
        if (this.f7183f) {
            f();
        }
        a aVar = this.f7178a;
        if (aVar != null && (cArr = this.f7185h) != null) {
            this.f7185h = null;
            aVar.j(2, cArr);
        }
    }

    public void v(char[] cArr, int i10, int i11) {
        this.f7179b = null;
        this.f7180c = -1;
        this.f7181d = 0;
        this.f7187j = null;
        this.f7188k = null;
        if (this.f7183f) {
            f();
        } else if (this.f7185h == null) {
            this.f7185h = d(i11);
        }
        this.f7184g = 0;
        this.f7186i = 0;
        c(cArr, i10, i11);
    }

    public void w(char[] cArr, int i10, int i11) {
        this.f7187j = null;
        this.f7188k = null;
        this.f7179b = cArr;
        this.f7180c = i10;
        this.f7181d = i11;
        if (this.f7183f) {
            f();
        }
    }

    public void x(String str) {
        this.f7179b = null;
        this.f7180c = -1;
        this.f7181d = 0;
        this.f7187j = str;
        this.f7188k = null;
        if (this.f7183f) {
            f();
        }
        this.f7186i = 0;
    }

    public final char[] y() {
        int i10;
        String str = this.f7187j;
        if (str != null) {
            return str.toCharArray();
        }
        int i11 = this.f7180c;
        if (i11 >= 0) {
            int i12 = this.f7181d;
            if (i12 < 1) {
                return f7177l;
            }
            if (i11 == 0) {
                return Arrays.copyOf(this.f7179b, i12);
            }
            return Arrays.copyOfRange(this.f7179b, i11, i12 + i11);
        }
        int A = A();
        if (A < 1) {
            return f7177l;
        }
        char[] e10 = e(A);
        ArrayList arrayList = this.f7182e;
        if (arrayList != null) {
            int size = arrayList.size();
            i10 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                char[] cArr = (char[]) this.f7182e.get(i13);
                int length = cArr.length;
                System.arraycopy(cArr, 0, e10, i10, length);
                i10 += length;
            }
        } else {
            i10 = 0;
        }
        System.arraycopy(this.f7185h, 0, e10, i10, this.f7186i);
        return e10;
    }

    public void z(int i10) {
        this.f7186i = i10;
    }

    public o(a aVar, char[] cArr) {
        this.f7178a = aVar;
        this.f7185h = cArr;
        this.f7186i = cArr.length;
        this.f7180c = -1;
    }
}
