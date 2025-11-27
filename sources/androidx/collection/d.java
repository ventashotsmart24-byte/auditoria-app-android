package androidx.collection;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public class d implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f1544e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f1545a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f1546b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f1547c;

    /* renamed from: d  reason: collision with root package name */
    public int f1548d;

    public d() {
        this(10);
    }

    public void a(long j10, Object obj) {
        int i10 = this.f1548d;
        if (i10 == 0 || j10 > this.f1546b[i10 - 1]) {
            if (this.f1545a && i10 >= this.f1546b.length) {
                e();
            }
            int i11 = this.f1548d;
            if (i11 >= this.f1546b.length) {
                int f10 = c.f(i11 + 1);
                long[] jArr = new long[f10];
                Object[] objArr = new Object[f10];
                long[] jArr2 = this.f1546b;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f1547c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1546b = jArr;
                this.f1547c = objArr;
            }
            this.f1546b[i11] = j10;
            this.f1547c[i11] = obj;
            this.f1548d = i11 + 1;
            return;
        }
        j(j10, obj);
    }

    public void b() {
        int i10 = this.f1548d;
        Object[] objArr = this.f1547c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f1548d = 0;
        this.f1545a = false;
    }

    /* renamed from: c */
    public d clone() {
        try {
            d dVar = (d) super.clone();
            dVar.f1546b = (long[]) this.f1546b.clone();
            dVar.f1547c = (Object[]) this.f1547c.clone();
            return dVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public void d(long j10) {
        k(j10);
    }

    public final void e() {
        int i10 = this.f1548d;
        long[] jArr = this.f1546b;
        Object[] objArr = this.f1547c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f1544e) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f1545a = false;
        this.f1548d = i11;
    }

    public Object f(long j10) {
        return g(j10, (Object) null);
    }

    public Object g(long j10, Object obj) {
        Object obj2;
        int b10 = c.b(this.f1546b, this.f1548d, j10);
        if (b10 < 0 || (obj2 = this.f1547c[b10]) == f1544e) {
            return obj;
        }
        return obj2;
    }

    public int h(long j10) {
        if (this.f1545a) {
            e();
        }
        return c.b(this.f1546b, this.f1548d, j10);
    }

    public long i(int i10) {
        if (this.f1545a) {
            e();
        }
        return this.f1546b[i10];
    }

    public void j(long j10, Object obj) {
        int b10 = c.b(this.f1546b, this.f1548d, j10);
        if (b10 >= 0) {
            this.f1547c[b10] = obj;
            return;
        }
        int i10 = b10 ^ -1;
        int i11 = this.f1548d;
        if (i10 < i11) {
            Object[] objArr = this.f1547c;
            if (objArr[i10] == f1544e) {
                this.f1546b[i10] = j10;
                objArr[i10] = obj;
                return;
            }
        }
        if (this.f1545a && i11 >= this.f1546b.length) {
            e();
            i10 = c.b(this.f1546b, this.f1548d, j10) ^ -1;
        }
        int i12 = this.f1548d;
        if (i12 >= this.f1546b.length) {
            int f10 = c.f(i12 + 1);
            long[] jArr = new long[f10];
            Object[] objArr2 = new Object[f10];
            long[] jArr2 = this.f1546b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1547c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1546b = jArr;
            this.f1547c = objArr2;
        }
        int i13 = this.f1548d;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.f1546b;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.f1547c;
            System.arraycopy(objArr4, i10, objArr4, i14, this.f1548d - i10);
        }
        this.f1546b[i10] = j10;
        this.f1547c[i10] = obj;
        this.f1548d++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f1547c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f1546b
            int r1 = r2.f1548d
            int r3 = androidx.collection.c.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f1547c
            r0 = r4[r3]
            java.lang.Object r1 = f1544e
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f1545a = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.d.k(long):void");
    }

    public void l(int i10) {
        Object[] objArr = this.f1547c;
        Object obj = objArr[i10];
        Object obj2 = f1544e;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f1545a = true;
        }
    }

    public int m() {
        if (this.f1545a) {
            e();
        }
        return this.f1548d;
    }

    public Object n(int i10) {
        if (this.f1545a) {
            e();
        }
        return this.f1547c[i10];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1548d * 28);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        for (int i10 = 0; i10 < this.f1548d; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(i(i10));
            sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
            Object n10 = n(i10);
            if (n10 != this) {
                sb.append(n10);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb.toString();
    }

    public d(int i10) {
        this.f1545a = false;
        if (i10 == 0) {
            this.f1546b = c.f1542b;
            this.f1547c = c.f1543c;
            return;
        }
        int f10 = c.f(i10);
        this.f1546b = new long[f10];
        this.f1547c = new Object[f10];
    }
}
