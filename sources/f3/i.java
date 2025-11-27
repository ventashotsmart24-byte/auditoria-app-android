package f3;

import c3.q;
import java.io.Serializable;

public class i implements q, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final e f6599e = e.h();

    /* renamed from: a  reason: collision with root package name */
    public final String f6600a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f6601b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f6602c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f6603d;

    public i(String str) {
        if (str != null) {
            this.f6600a = str;
            return;
        }
        throw new IllegalStateException("Null String illegal for SerializedString");
    }

    public int a(char[] cArr, int i10) {
        char[] cArr2 = this.f6603d;
        if (cArr2 == null) {
            cArr2 = f6599e.i(this.f6600a);
            this.f6603d = cArr2;
        }
        int length = cArr2.length;
        if (i10 + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArr2, 0, cArr, i10, length);
        return length;
    }

    public final char[] b() {
        char[] cArr = this.f6603d;
        if (cArr != null) {
            return cArr;
        }
        char[] i10 = f6599e.i(this.f6600a);
        this.f6603d = i10;
        return i10;
    }

    public final byte[] c() {
        byte[] bArr = this.f6601b;
        if (bArr != null) {
            return bArr;
        }
        byte[] j10 = f6599e.j(this.f6600a);
        this.f6601b = j10;
        return j10;
    }

    public int d(byte[] bArr, int i10) {
        byte[] bArr2 = this.f6601b;
        if (bArr2 == null) {
            bArr2 = f6599e.j(this.f6600a);
            this.f6601b = bArr2;
        }
        int length = bArr2.length;
        if (i10 + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArr2, 0, bArr, i10, length);
        return length;
    }

    public int e(char[] cArr, int i10) {
        String str = this.f6600a;
        int length = str.length();
        if (i10 + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i10);
        return length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.f6600a.equals(((i) obj).f6600a);
    }

    public int f(byte[] bArr, int i10) {
        byte[] bArr2 = this.f6602c;
        if (bArr2 == null) {
            bArr2 = f6599e.g(this.f6600a);
            this.f6602c = bArr2;
        }
        int length = bArr2.length;
        if (i10 + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArr2, 0, bArr, i10, length);
        return length;
    }

    public final byte[] g() {
        byte[] bArr = this.f6602c;
        if (bArr != null) {
            return bArr;
        }
        byte[] g10 = f6599e.g(this.f6600a);
        this.f6602c = g10;
        return g10;
    }

    public final String getValue() {
        return this.f6600a;
    }

    public final int hashCode() {
        return this.f6600a.hashCode();
    }

    public final String toString() {
        return this.f6600a;
    }
}
