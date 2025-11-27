package c3;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import j3.c;
import java.io.Serializable;
import java.util.Arrays;

public final class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final transient int[] f4669a;

    /* renamed from: b  reason: collision with root package name */
    public final transient char[] f4670b;

    /* renamed from: c  reason: collision with root package name */
    public final transient byte[] f4671c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4672d;

    /* renamed from: e  reason: collision with root package name */
    public final char f4673e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4674f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4675g;

    /* renamed from: h  reason: collision with root package name */
    public final C0070a f4676h;

    /* renamed from: c3.a$a  reason: collision with other inner class name */
    public enum C0070a {
        PADDING_FORBIDDEN,
        PADDING_REQUIRED,
        PADDING_ALLOWED
    }

    public a(String str, String str2, boolean z10, char c10, int i10) {
        int[] iArr = new int[128];
        this.f4669a = iArr;
        char[] cArr = new char[64];
        this.f4670b = cArr;
        this.f4671c = new byte[64];
        this.f4672d = str;
        this.f4675g = z10;
        this.f4673e = c10;
        this.f4674f = i10;
        int length = str2.length();
        if (length == 64) {
            str2.getChars(0, length, cArr, 0);
            Arrays.fill(iArr, -1);
            for (int i11 = 0; i11 < length; i11++) {
                char c11 = this.f4670b[i11];
                this.f4671c[i11] = (byte) c11;
                this.f4669a[c11] = i11;
            }
            if (z10) {
                this.f4669a[c10] = -2;
            }
            this.f4676h = z10 ? C0070a.PADDING_REQUIRED : C0070a.PADDING_FORBIDDEN;
            return;
        }
        throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
    }

    public void a() {
        throw new IllegalArgumentException(s());
    }

    public void b() {
        throw new IllegalArgumentException(u());
    }

    public void c(char c10, int i10, String str) {
        String str2;
        if (c10 <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c10) + ") as character #" + (i10 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (w(c10)) {
            str2 = "Unexpected padding character ('" + r() + "') as character #" + (i10 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c10) || Character.isISOControl(c10)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c10) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c10 + "' (code 0x" + Integer.toHexString(c10) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    public boolean d() {
        if (this.f4676h != C0070a.PADDING_FORBIDDEN) {
            return true;
        }
        return false;
    }

    public void e(String str, c cVar) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt > ' ') {
                int g10 = g(charAt);
                if (g10 < 0) {
                    c(charAt, 0, (String) null);
                }
                if (i11 >= length) {
                    a();
                }
                int i12 = i11 + 1;
                char charAt2 = str.charAt(i11);
                int g11 = g(charAt2);
                if (g11 < 0) {
                    c(charAt2, 1, (String) null);
                }
                int i13 = (g10 << 6) | g11;
                if (i12 >= length) {
                    if (!t()) {
                        cVar.b(i13 >> 4);
                        return;
                    }
                    a();
                }
                int i14 = i12 + 1;
                char charAt3 = str.charAt(i12);
                int g12 = g(charAt3);
                if (g12 < 0) {
                    if (g12 != -2) {
                        c(charAt3, 2, (String) null);
                    }
                    if (!d()) {
                        b();
                    }
                    if (i14 >= length) {
                        a();
                    }
                    i10 = i14 + 1;
                    char charAt4 = str.charAt(i14);
                    if (!w(charAt4)) {
                        c(charAt4, 3, "expected padding character '" + r() + "'");
                    }
                    cVar.b(i13 >> 4);
                } else {
                    int i15 = (i13 << 6) | g12;
                    if (i14 >= length) {
                        if (!t()) {
                            cVar.e(i15 >> 2);
                            return;
                        }
                        a();
                    }
                    i11 = i14 + 1;
                    char charAt5 = str.charAt(i14);
                    int g13 = g(charAt5);
                    if (g13 < 0) {
                        if (g13 != -2) {
                            c(charAt5, 3, (String) null);
                        }
                        if (!d()) {
                            b();
                        }
                        cVar.e(i15 >> 2);
                    } else {
                        cVar.c((i15 << 6) | g13);
                    }
                }
            }
            i10 = i11;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != a.class) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.f4673e == this.f4673e && aVar.f4674f == this.f4674f && aVar.f4675g == this.f4675g && aVar.f4676h == this.f4676h && this.f4672d.equals(aVar.f4672d)) {
            return true;
        }
        return false;
    }

    public byte[] f(String str) {
        c cVar = new c();
        e(str, cVar);
        return cVar.v();
    }

    public int g(char c10) {
        if (c10 <= 127) {
            return this.f4669a[c10];
        }
        return -1;
    }

    public String h(byte[] bArr) {
        return i(bArr, false);
    }

    public int hashCode() {
        return this.f4672d.hashCode();
    }

    public String i(byte[] bArr, boolean z10) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z10) {
            sb.append('\"');
        }
        int p10 = p() >> 2;
        int i10 = length - 3;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            l(sb, (((bArr[i11] << 8) | (bArr[i12] & UnsignedBytes.MAX_VALUE)) << 8) | (bArr[i13] & UnsignedBytes.MAX_VALUE));
            p10--;
            if (p10 <= 0) {
                sb.append(ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN);
                sb.append('n');
                p10 = p() >> 2;
            }
            i11 = i14;
        }
        int i15 = length - i11;
        if (i15 > 0) {
            int i16 = i11 + 1;
            int i17 = bArr[i11] << 16;
            if (i15 == 2) {
                i17 |= (bArr[i16] & UnsignedBytes.MAX_VALUE) << 8;
            }
            o(sb, i17, i15);
        }
        if (z10) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public int j(int i10, byte[] bArr, int i11) {
        int i12 = i11 + 1;
        byte[] bArr2 = this.f4671c;
        bArr[i11] = bArr2[(i10 >> 18) & 63];
        int i13 = i12 + 1;
        bArr[i12] = bArr2[(i10 >> 12) & 63];
        int i14 = i13 + 1;
        bArr[i13] = bArr2[(i10 >> 6) & 63];
        int i15 = i14 + 1;
        bArr[i14] = bArr2[i10 & 63];
        return i15;
    }

    public int k(int i10, char[] cArr, int i11) {
        int i12 = i11 + 1;
        char[] cArr2 = this.f4670b;
        cArr[i11] = cArr2[(i10 >> 18) & 63];
        int i13 = i12 + 1;
        cArr[i12] = cArr2[(i10 >> 12) & 63];
        int i14 = i13 + 1;
        cArr[i13] = cArr2[(i10 >> 6) & 63];
        int i15 = i14 + 1;
        cArr[i14] = cArr2[i10 & 63];
        return i15;
    }

    public void l(StringBuilder sb, int i10) {
        sb.append(this.f4670b[(i10 >> 18) & 63]);
        sb.append(this.f4670b[(i10 >> 12) & 63]);
        sb.append(this.f4670b[(i10 >> 6) & 63]);
        sb.append(this.f4670b[i10 & 63]);
    }

    public int m(int i10, int i11, byte[] bArr, int i12) {
        byte b10;
        int i13 = i12 + 1;
        byte[] bArr2 = this.f4671c;
        bArr[i12] = bArr2[(i10 >> 18) & 63];
        int i14 = i13 + 1;
        bArr[i13] = bArr2[(i10 >> 12) & 63];
        if (v()) {
            byte b11 = (byte) this.f4673e;
            int i15 = i14 + 1;
            if (i11 == 2) {
                b10 = this.f4671c[(i10 >> 6) & 63];
            } else {
                b10 = b11;
            }
            bArr[i14] = b10;
            int i16 = i15 + 1;
            bArr[i15] = b11;
            return i16;
        } else if (i11 != 2) {
            return i14;
        } else {
            bArr[i14] = this.f4671c[(i10 >> 6) & 63];
            return i14 + 1;
        }
    }

    public int n(int i10, int i11, char[] cArr, int i12) {
        char c10;
        int i13 = i12 + 1;
        char[] cArr2 = this.f4670b;
        cArr[i12] = cArr2[(i10 >> 18) & 63];
        int i14 = i13 + 1;
        cArr[i13] = cArr2[(i10 >> 12) & 63];
        if (v()) {
            int i15 = i14 + 1;
            if (i11 == 2) {
                c10 = this.f4670b[(i10 >> 6) & 63];
            } else {
                c10 = this.f4673e;
            }
            cArr[i14] = c10;
            int i16 = i15 + 1;
            cArr[i15] = this.f4673e;
            return i16;
        } else if (i11 != 2) {
            return i14;
        } else {
            cArr[i14] = this.f4670b[(i10 >> 6) & 63];
            return i14 + 1;
        }
    }

    public void o(StringBuilder sb, int i10, int i11) {
        char c10;
        sb.append(this.f4670b[(i10 >> 18) & 63]);
        sb.append(this.f4670b[(i10 >> 12) & 63]);
        if (v()) {
            if (i11 == 2) {
                c10 = this.f4670b[(i10 >> 6) & 63];
            } else {
                c10 = this.f4673e;
            }
            sb.append(c10);
            sb.append(this.f4673e);
        } else if (i11 == 2) {
            sb.append(this.f4670b[(i10 >> 6) & 63]);
        }
    }

    public int p() {
        return this.f4674f;
    }

    public String q() {
        return this.f4672d;
    }

    public char r() {
        return this.f4673e;
    }

    public String s() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", new Object[]{q(), Character.valueOf(r())});
    }

    public boolean t() {
        if (this.f4676h == C0070a.PADDING_REQUIRED) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f4672d;
    }

    public String u() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured", new Object[]{q()});
    }

    public boolean v() {
        return this.f4675g;
    }

    public boolean w(char c10) {
        if (c10 == this.f4673e) {
            return true;
        }
        return false;
    }

    public boolean x(int i10) {
        if (i10 == this.f4673e) {
            return true;
        }
        return false;
    }

    public a(a aVar, String str, int i10) {
        this(aVar, str, aVar.f4675g, aVar.f4673e, i10);
    }

    public a(a aVar, String str, boolean z10, char c10, int i10) {
        this(aVar, str, z10, c10, aVar.f4676h, i10);
    }

    public a(a aVar, String str, boolean z10, char c10, C0070a aVar2, int i10) {
        int[] iArr = new int[128];
        this.f4669a = iArr;
        char[] cArr = new char[64];
        this.f4670b = cArr;
        byte[] bArr = new byte[64];
        this.f4671c = bArr;
        this.f4672d = str;
        byte[] bArr2 = aVar.f4671c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = aVar.f4670b;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = aVar.f4669a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f4675g = z10;
        this.f4673e = c10;
        this.f4674f = i10;
        this.f4676h = aVar2;
    }
}
