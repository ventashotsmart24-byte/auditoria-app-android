package g3;

import c3.h;
import c3.m;
import c3.o;
import c3.p;
import c3.q;
import com.google.common.primitives.UnsignedBytes;
import f3.a;
import f3.c;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class g extends b {
    public static final byte[] A = a.c();
    public static final byte[] B = {110, 117, 108, 108};
    public static final byte[] C = {116, 114, 117, 101};
    public static final byte[] D = {102, 97, 108, 115, 101};

    /* renamed from: r  reason: collision with root package name */
    public final OutputStream f6816r;

    /* renamed from: s  reason: collision with root package name */
    public byte f6817s;

    /* renamed from: t  reason: collision with root package name */
    public byte[] f6818t;

    /* renamed from: u  reason: collision with root package name */
    public int f6819u;

    /* renamed from: v  reason: collision with root package name */
    public final int f6820v;

    /* renamed from: w  reason: collision with root package name */
    public final int f6821w;

    /* renamed from: x  reason: collision with root package name */
    public char[] f6822x;

    /* renamed from: y  reason: collision with root package name */
    public final int f6823y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f6824z;

    public g(c cVar, int i10, o oVar, OutputStream outputStream, char c10) {
        super(cVar, i10, oVar);
        this.f6816r = outputStream;
        this.f6817s = (byte) c10;
        if (c10 != '\"') {
            this.f6771l = a.f(c10);
        }
        this.f6824z = true;
        byte[] h10 = cVar.h();
        this.f6818t = h10;
        int length = h10.length;
        this.f6820v = length;
        this.f6821w = length >> 3;
        char[] e10 = cVar.e();
        this.f6822x = e10;
        this.f6823y = e10.length;
        if (v(h.b.ESCAPE_NON_ASCII)) {
            E(127);
        }
    }

    public void A0(char[] cArr, int i10, int i11) {
        I0("write a string");
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i12 = this.f6819u;
        int i13 = i12 + 1;
        this.f6819u = i13;
        bArr[i12] = this.f6817s;
        if (i11 <= this.f6821w) {
            if (i13 + i11 > this.f6820v) {
                L0();
            }
            g1(cArr, i10, i11);
        } else {
            n1(cArr, i10, i11);
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr2 = this.f6818t;
        int i14 = this.f6819u;
        this.f6819u = i14 + 1;
        bArr2[i14] = this.f6817s;
    }

    public final void I0(String str) {
        byte b10;
        int x10 = this.f6210h.x();
        if (this.f4717a != null) {
            K0(str, x10);
            return;
        }
        if (x10 == 1) {
            b10 = 44;
        } else if (x10 == 2) {
            b10 = 58;
        } else if (x10 == 3) {
            q qVar = this.f6773n;
            if (qVar != null) {
                byte[] g10 = qVar.g();
                if (g10.length > 0) {
                    U0(g10);
                    return;
                }
                return;
            }
            return;
        } else if (x10 == 5) {
            J0(str);
            return;
        } else {
            return;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        this.f6819u = i10 + 1;
        bArr[i10] = b10;
    }

    public final void L0() {
        int i10 = this.f6819u;
        if (i10 > 0) {
            this.f6819u = 0;
            this.f6816r.write(this.f6818t, 0, i10);
        }
    }

    public final int M0(int i10, int i11) {
        byte[] bArr = this.f6818t;
        if (i10 < 55296 || i10 > 57343) {
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((i10 >> 12) | 224);
            int i13 = i12 + 1;
            bArr[i12] = (byte) (((i10 >> 6) & 63) | 128);
            bArr[i13] = (byte) ((i10 & 63) | 128);
            return i13 + 1;
        }
        int i14 = i11 + 1;
        bArr[i11] = 92;
        int i15 = i14 + 1;
        bArr[i14] = 117;
        int i16 = i15 + 1;
        byte[] bArr2 = A;
        bArr[i15] = bArr2[(i10 >> 12) & 15];
        int i17 = i16 + 1;
        bArr[i16] = bArr2[(i10 >> 8) & 15];
        int i18 = i17 + 1;
        bArr[i17] = bArr2[(i10 >> 4) & 15];
        int i19 = i18 + 1;
        bArr[i18] = bArr2[i10 & 15];
        return i19;
    }

    public final int N0(int i10, char[] cArr, int i11, int i12) {
        if (i10 < 55296 || i10 > 57343) {
            byte[] bArr = this.f6818t;
            int i13 = this.f6819u;
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i10 >> 12) | 224);
            int i15 = i14 + 1;
            bArr[i14] = (byte) (((i10 >> 6) & 63) | 128);
            this.f6819u = i15 + 1;
            bArr[i15] = (byte) ((i10 & 63) | 128);
            return i11;
        }
        if (i11 >= i12 || cArr == null) {
            a(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", new Object[]{Integer.valueOf(i10)}));
        } else {
            O0(i10, cArr[i11]);
        }
        return i11 + 1;
    }

    public final void O0(int i10, int i11) {
        int H0 = H0(i10, i11);
        if (this.f6819u + 4 > this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i12 = this.f6819u;
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((H0 >> 18) | 240);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (((H0 >> 12) & 63) | 128);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (((H0 >> 6) & 63) | 128);
        this.f6819u = i15 + 1;
        bArr[i15] = (byte) ((H0 & 63) | 128);
    }

    public int P(c3.a aVar, InputStream inputStream, int i10) {
        I0("write a binary value");
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i11 = this.f6819u;
        this.f6819u = i11 + 1;
        bArr[i11] = this.f6817s;
        byte[] d10 = this.f6770k.d();
        if (i10 < 0) {
            try {
                i10 = R0(aVar, inputStream, d10);
            } catch (Throwable th) {
                this.f6770k.l(d10);
                throw th;
            }
        } else {
            int S0 = S0(aVar, inputStream, d10, i10);
            if (S0 > 0) {
                a("Too few bytes available: missing " + S0 + " bytes (out of " + i10 + ")");
            }
        }
        this.f6770k.l(d10);
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr2 = this.f6818t;
        int i12 = this.f6819u;
        this.f6819u = i12 + 1;
        bArr2[i12] = this.f6817s;
        return i10;
    }

    public final int P0(InputStream inputStream, byte[] bArr, int i10, int i11, int i12) {
        int i13 = 0;
        while (i10 < i11) {
            bArr[i13] = bArr[i10];
            i13++;
            i10++;
        }
        int min = Math.min(i12, bArr.length);
        do {
            int i14 = min - i13;
            if (i14 == 0) {
                break;
            }
            int read = inputStream.read(bArr, i13, i14);
            if (read < 0) {
                return i13;
            }
            i13 += read;
        } while (i13 < 3);
        return i13;
    }

    public void Q0() {
        byte[] bArr = this.f6818t;
        if (bArr != null && this.f6824z) {
            this.f6818t = null;
            this.f6770k.p(bArr);
        }
        char[] cArr = this.f6822x;
        if (cArr != null) {
            this.f6822x = null;
            this.f6770k.m(cArr);
        }
    }

    public void R(c3.a aVar, byte[] bArr, int i10, int i11) {
        I0("write a binary value");
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr2 = this.f6818t;
        int i12 = this.f6819u;
        this.f6819u = i12 + 1;
        bArr2[i12] = this.f6817s;
        T0(aVar, bArr, i10, i11 + i10);
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr3 = this.f6818t;
        int i13 = this.f6819u;
        this.f6819u = i13 + 1;
        bArr3[i13] = this.f6817s;
    }

    public final int R0(c3.a aVar, InputStream inputStream, byte[] bArr) {
        int i10 = this.f6820v - 6;
        int i11 = 2;
        int p10 = aVar.p() >> 2;
        int i12 = -3;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i13 > i12) {
                i14 = P0(inputStream, bArr, i13, i14, bArr.length);
                if (i14 < 3) {
                    break;
                }
                i12 = i14 - 3;
                i13 = 0;
            }
            if (this.f6819u > i10) {
                L0();
            }
            int i16 = i13 + 1;
            int i17 = i16 + 1;
            i13 = i17 + 1;
            i15 += 3;
            int j10 = aVar.j((((bArr[i16] & UnsignedBytes.MAX_VALUE) | (bArr[i13] << 8)) << 8) | (bArr[i17] & UnsignedBytes.MAX_VALUE), this.f6818t, this.f6819u);
            this.f6819u = j10;
            p10--;
            if (p10 <= 0) {
                byte[] bArr2 = this.f6818t;
                int i18 = j10 + 1;
                bArr2[j10] = 92;
                this.f6819u = i18 + 1;
                bArr2[i18] = 110;
                p10 = aVar.p() >> 2;
            }
        }
        if (i14 <= 0) {
            return i15;
        }
        if (this.f6819u > i10) {
            L0();
        }
        int i19 = bArr[0] << 16;
        if (1 < i14) {
            i19 |= (bArr[1] & UnsignedBytes.MAX_VALUE) << 8;
        } else {
            i11 = 1;
        }
        int i20 = i15 + i11;
        this.f6819u = aVar.m(i19, i11, this.f6818t, this.f6819u);
        return i20;
    }

    public final int S0(c3.a aVar, InputStream inputStream, byte[] bArr, int i10) {
        int P0;
        int i11 = this.f6820v - 6;
        int i12 = 2;
        int p10 = aVar.p() >> 2;
        int i13 = -3;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i10 <= 2) {
                break;
            }
            if (i14 > i13) {
                i15 = P0(inputStream, bArr, i14, i15, i10);
                if (i15 < 3) {
                    i14 = 0;
                    break;
                }
                i13 = i15 - 3;
                i14 = 0;
            }
            if (this.f6819u > i11) {
                L0();
            }
            int i16 = i14 + 1;
            int i17 = i16 + 1;
            i14 = i17 + 1;
            i10 -= 3;
            int j10 = aVar.j((((bArr[i16] & UnsignedBytes.MAX_VALUE) | (bArr[i14] << 8)) << 8) | (bArr[i17] & UnsignedBytes.MAX_VALUE), this.f6818t, this.f6819u);
            this.f6819u = j10;
            p10--;
            if (p10 <= 0) {
                byte[] bArr2 = this.f6818t;
                int i18 = j10 + 1;
                bArr2[j10] = 92;
                this.f6819u = i18 + 1;
                bArr2[i18] = 110;
                p10 = aVar.p() >> 2;
            }
        }
        if (i10 <= 0 || (P0 = P0(inputStream, bArr, i14, i15, i10)) <= 0) {
            return i10;
        }
        if (this.f6819u > i11) {
            L0();
        }
        int i19 = bArr[0] << 16;
        if (1 < P0) {
            i19 |= (bArr[1] & UnsignedBytes.MAX_VALUE) << 8;
        } else {
            i12 = 1;
        }
        this.f6819u = aVar.m(i19, i12, this.f6818t, this.f6819u);
        return i10 - i12;
    }

    public final void T0(c3.a aVar, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 3;
        int i13 = this.f6820v - 6;
        int p10 = aVar.p() >> 2;
        while (i10 <= i12) {
            if (this.f6819u > i13) {
                L0();
            }
            int i14 = i10 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int j10 = aVar.j((((bArr[i10] << 8) | (bArr[i14] & UnsignedBytes.MAX_VALUE)) << 8) | (bArr[i15] & UnsignedBytes.MAX_VALUE), this.f6818t, this.f6819u);
            this.f6819u = j10;
            p10--;
            if (p10 <= 0) {
                byte[] bArr2 = this.f6818t;
                int i17 = j10 + 1;
                bArr2[j10] = 92;
                this.f6819u = i17 + 1;
                bArr2[i17] = 110;
                p10 = aVar.p() >> 2;
            }
            i10 = i16;
        }
        int i18 = i11 - i10;
        if (i18 > 0) {
            if (this.f6819u > i13) {
                L0();
            }
            int i19 = i10 + 1;
            int i20 = bArr[i10] << 16;
            if (i18 == 2) {
                i20 |= (bArr[i19] & UnsignedBytes.MAX_VALUE) << 8;
            }
            this.f6819u = aVar.m(i20, i18, this.f6818t, this.f6819u);
        }
    }

    public void U(boolean z10) {
        byte[] bArr;
        I0("write a boolean value");
        if (this.f6819u + 5 >= this.f6820v) {
            L0();
        }
        if (z10) {
            bArr = C;
        } else {
            bArr = D;
        }
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.f6818t, this.f6819u, length);
        this.f6819u += length;
    }

    public final void U0(byte[] bArr) {
        int length = bArr.length;
        if (this.f6819u + length > this.f6820v) {
            L0();
            if (length > 512) {
                this.f6816r.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.f6818t, this.f6819u, length);
        this.f6819u += length;
    }

    public final void V() {
        if (!this.f6210h.f()) {
            a("Current context not Array but " + this.f6210h.j());
        }
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.d(this, this.f6210h.d());
        } else {
            if (this.f6819u >= this.f6820v) {
                L0();
            }
            byte[] bArr = this.f6818t;
            int i10 = this.f6819u;
            this.f6819u = i10 + 1;
            bArr[i10] = 93;
        }
        this.f6210h = this.f6210h.l();
    }

    public final int V0(int i10, int i11) {
        int i12;
        byte[] bArr = this.f6818t;
        int i13 = i11 + 1;
        bArr[i11] = 92;
        int i14 = i13 + 1;
        bArr[i13] = 117;
        if (i10 > 255) {
            int i15 = 255 & (i10 >> 8);
            int i16 = i14 + 1;
            byte[] bArr2 = A;
            bArr[i14] = bArr2[i15 >> 4];
            i12 = i16 + 1;
            bArr[i16] = bArr2[i15 & 15];
            i10 &= 255;
        } else {
            int i17 = i14 + 1;
            bArr[i14] = 48;
            i12 = i17 + 1;
            bArr[i17] = 48;
        }
        int i18 = i12 + 1;
        byte[] bArr3 = A;
        bArr[i12] = bArr3[i10 >> 4];
        int i19 = i18 + 1;
        bArr[i18] = bArr3[i10 & 15];
        return i19;
    }

    public final void W() {
        if (!this.f6210h.g()) {
            a("Current context not Object but " + this.f6210h.j());
        }
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.i(this, this.f6210h.d());
        } else {
            if (this.f6819u >= this.f6820v) {
                L0();
            }
            byte[] bArr = this.f6818t;
            int i10 = this.f6819u;
            this.f6819u = i10 + 1;
            bArr[i10] = 125;
        }
        this.f6210h = this.f6210h.l();
    }

    public final void W0() {
        if (this.f6819u + 4 >= this.f6820v) {
            L0();
        }
        System.arraycopy(B, 0, this.f6818t, this.f6819u, 4);
        this.f6819u += 4;
    }

    public final void X0(q qVar) {
        int w10 = this.f6210h.w(qVar.getValue());
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        if (w10 == 1) {
            this.f4717a.a(this);
        } else {
            this.f4717a.k(this);
        }
        boolean z10 = !this.f6774o;
        if (z10) {
            if (this.f6819u >= this.f6820v) {
                L0();
            }
            byte[] bArr = this.f6818t;
            int i10 = this.f6819u;
            this.f6819u = i10 + 1;
            bArr[i10] = this.f6817s;
        }
        int d10 = qVar.d(this.f6818t, this.f6819u);
        if (d10 < 0) {
            U0(qVar.c());
        } else {
            this.f6819u += d10;
        }
        if (z10) {
            if (this.f6819u >= this.f6820v) {
                L0();
            }
            byte[] bArr2 = this.f6818t;
            int i11 = this.f6819u;
            this.f6819u = i11 + 1;
            bArr2[i11] = this.f6817s;
        }
    }

    public void Y(q qVar) {
        if (this.f4717a != null) {
            X0(qVar);
            return;
        }
        int w10 = this.f6210h.w(qVar.getValue());
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        if (w10 == 1) {
            if (this.f6819u >= this.f6820v) {
                L0();
            }
            byte[] bArr = this.f6818t;
            int i10 = this.f6819u;
            this.f6819u = i10 + 1;
            bArr[i10] = 44;
        }
        if (this.f6774o) {
            o1(qVar);
            return;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr2 = this.f6818t;
        int i11 = this.f6819u;
        int i12 = i11 + 1;
        this.f6819u = i12;
        bArr2[i11] = this.f6817s;
        int d10 = qVar.d(bArr2, i12);
        if (d10 < 0) {
            U0(qVar.c());
        } else {
            this.f6819u += d10;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr3 = this.f6818t;
        int i13 = this.f6819u;
        this.f6819u = i13 + 1;
        bArr3[i13] = this.f6817s;
    }

    public final void Y0(String str) {
        int w10 = this.f6210h.w(str);
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        if (w10 == 1) {
            this.f4717a.a(this);
        } else {
            this.f4717a.k(this);
        }
        if (this.f6774o) {
            m1(str, false);
            return;
        }
        int length = str.length();
        if (length > this.f6823y) {
            m1(str, true);
            return;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        this.f6819u = i10 + 1;
        bArr[i10] = this.f6817s;
        str.getChars(0, length, this.f6822x, 0);
        if (length <= this.f6821w) {
            if (this.f6819u + length > this.f6820v) {
                L0();
            }
            g1(this.f6822x, 0, length);
        } else {
            n1(this.f6822x, 0, length);
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr2 = this.f6818t;
        int i11 = this.f6819u;
        this.f6819u = i11 + 1;
        bArr2[i11] = this.f6817s;
    }

    public void Z(String str) {
        if (this.f4717a != null) {
            Y0(str);
            return;
        }
        int w10 = this.f6210h.w(str);
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        if (w10 == 1) {
            if (this.f6819u >= this.f6820v) {
                L0();
            }
            byte[] bArr = this.f6818t;
            int i10 = this.f6819u;
            this.f6819u = i10 + 1;
            bArr[i10] = 44;
        }
        if (this.f6774o) {
            m1(str, false);
            return;
        }
        int length = str.length();
        if (length > this.f6823y) {
            m1(str, true);
            return;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr2 = this.f6818t;
        int i11 = this.f6819u;
        int i12 = i11 + 1;
        this.f6819u = i12;
        bArr2[i11] = this.f6817s;
        if (length <= this.f6821w) {
            if (i12 + length > this.f6820v) {
                L0();
            }
            f1(str, 0, length);
        } else {
            l1(str, 0, length);
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr3 = this.f6818t;
        int i13 = this.f6819u;
        this.f6819u = i13 + 1;
        bArr3[i13] = this.f6817s;
    }

    public final void Z0(int i10) {
        if (this.f6819u + 13 >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i11 = this.f6819u;
        int i12 = i11 + 1;
        this.f6819u = i12;
        bArr[i11] = this.f6817s;
        int q10 = f3.g.q(i10, bArr, i12);
        byte[] bArr2 = this.f6818t;
        this.f6819u = q10 + 1;
        bArr2[q10] = this.f6817s;
    }

    public void a0() {
        I0("write a null");
        W0();
    }

    public final void a1(long j10) {
        if (this.f6819u + 23 >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        int i11 = i10 + 1;
        this.f6819u = i11;
        bArr[i10] = this.f6817s;
        int s10 = f3.g.s(j10, bArr, i11);
        byte[] bArr2 = this.f6818t;
        this.f6819u = s10 + 1;
        bArr2[s10] = this.f6817s;
    }

    public void b0(double d10) {
        if (this.f6209g || (f3.g.o(d10) && h.b.QUOTE_NON_NUMERIC_NUMBERS.c(this.f6208f))) {
            z0(String.valueOf(d10));
            return;
        }
        I0("write a number");
        o0(String.valueOf(d10));
    }

    public final void b1(String str) {
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        this.f6819u = i10 + 1;
        bArr[i10] = this.f6817s;
        o0(str);
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr2 = this.f6818t;
        int i11 = this.f6819u;
        this.f6819u = i11 + 1;
        bArr2[i11] = this.f6817s;
    }

    public void c0(float f10) {
        if (this.f6209g || (f3.g.p(f10) && h.b.QUOTE_NON_NUMERIC_NUMBERS.c(this.f6208f))) {
            z0(String.valueOf(f10));
            return;
        }
        I0("write a number");
        o0(String.valueOf(f10));
    }

    public final void c1(short s10) {
        if (this.f6819u + 8 >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        int i11 = i10 + 1;
        this.f6819u = i11;
        bArr[i10] = this.f6817s;
        int q10 = f3.g.q(s10, bArr, i11);
        byte[] bArr2 = this.f6818t;
        this.f6819u = q10 + 1;
        bArr2[q10] = this.f6817s;
    }

    public void close() {
        super.close();
        if (this.f6818t != null && v(h.b.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                m s10 = s();
                if (!s10.f()) {
                    if (!s10.g()) {
                        break;
                    }
                    W();
                } else {
                    V();
                }
            }
        }
        L0();
        this.f6819u = 0;
        if (this.f6816r != null) {
            if (this.f6770k.k() || v(h.b.AUTO_CLOSE_TARGET)) {
                this.f6816r.close();
            } else if (v(h.b.FLUSH_PASSED_TO_STREAM)) {
                this.f6816r.flush();
            }
        }
        Q0();
    }

    public void d0(int i10) {
        I0("write a number");
        if (this.f6819u + 11 >= this.f6820v) {
            L0();
        }
        if (this.f6209g) {
            Z0(i10);
        } else {
            this.f6819u = f3.g.q(i10, this.f6818t, this.f6819u);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        if (r0 >= 2048) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r1 = r5.f6818t;
        r2 = r5.f6819u;
        r3 = r2 + 1;
        r1[r2] = (byte) ((r0 >> 6) | 192);
        r5.f6819u = r3 + 1;
        r1[r3] = (byte) ((r0 & '?') | 128);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        r7 = N0(r0, r6, r7, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d1(char[] r6, int r7, int r8) {
        /*
            r5 = this;
        L_0x0000:
            if (r7 >= r8) goto L_0x003b
        L_0x0002:
            char r0 = r6[r7]
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 <= r1) goto L_0x002c
            int r7 = r7 + 1
            r1 = 2048(0x800, float:2.87E-42)
            if (r0 >= r1) goto L_0x0027
            byte[] r1 = r5.f6818t
            int r2 = r5.f6819u
            int r3 = r2 + 1
            int r4 = r0 >> 6
            r4 = r4 | 192(0xc0, float:2.69E-43)
            byte r4 = (byte) r4
            r1[r2] = r4
            int r2 = r3 + 1
            r5.f6819u = r2
            r0 = r0 & 63
            r0 = r0 | 128(0x80, float:1.794E-43)
            byte r0 = (byte) r0
            r1[r3] = r0
            goto L_0x0000
        L_0x0027:
            int r7 = r5.N0(r0, r6, r7, r8)
            goto L_0x0000
        L_0x002c:
            byte[] r1 = r5.f6818t
            int r2 = r5.f6819u
            int r3 = r2 + 1
            r5.f6819u = r3
            byte r0 = (byte) r0
            r1[r2] = r0
            int r7 = r7 + 1
            if (r7 < r8) goto L_0x0002
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.g.d1(char[], int, int):void");
    }

    public void e0(long j10) {
        I0("write a number");
        if (this.f6209g) {
            a1(j10);
            return;
        }
        if (this.f6819u + 21 >= this.f6820v) {
            L0();
        }
        this.f6819u = f3.g.s(j10, this.f6818t, this.f6819u);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r9 = N0(r9, r8, r2, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if ((r7.f6819u + 3) < r7.f6820v) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        L0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r2 = r9 + 1;
        r9 = r8[r9];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r9 >= 2048) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r4 = r7.f6819u;
        r5 = r4 + 1;
        r1[r4] = (byte) ((r9 >> 6) | 192);
        r7.f6819u = r5 + 1;
        r1[r5] = (byte) ((r9 & '?') | 128);
        r9 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e1(char[] r8, int r9, int r10) {
        /*
            r7 = this;
            int r0 = r7.f6820v
            byte[] r1 = r7.f6818t
            int r10 = r10 + r9
        L_0x0005:
            if (r9 >= r10) goto L_0x0050
        L_0x0007:
            char r2 = r8[r9]
            r3 = 128(0x80, float:1.794E-43)
            if (r2 < r3) goto L_0x003c
            int r2 = r7.f6819u
            int r2 = r2 + 3
            int r4 = r7.f6820v
            if (r2 < r4) goto L_0x0018
            r7.L0()
        L_0x0018:
            int r2 = r9 + 1
            char r9 = r8[r9]
            r4 = 2048(0x800, float:2.87E-42)
            if (r9 >= r4) goto L_0x0037
            int r4 = r7.f6819u
            int r5 = r4 + 1
            int r6 = r9 >> 6
            r6 = r6 | 192(0xc0, float:2.69E-43)
            byte r6 = (byte) r6
            r1[r4] = r6
            int r4 = r5 + 1
            r7.f6819u = r4
            r9 = r9 & 63
            r9 = r9 | r3
            byte r9 = (byte) r9
            r1[r5] = r9
            r9 = r2
            goto L_0x0005
        L_0x0037:
            int r9 = r7.N0(r9, r8, r2, r10)
            goto L_0x0005
        L_0x003c:
            int r3 = r7.f6819u
            if (r3 < r0) goto L_0x0043
            r7.L0()
        L_0x0043:
            int r3 = r7.f6819u
            int r4 = r3 + 1
            r7.f6819u = r4
            byte r2 = (byte) r2
            r1[r3] = r2
            int r9 = r9 + 1
            if (r9 < r10) goto L_0x0007
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.g.e1(char[], int, int):void");
    }

    public void f0(String str) {
        I0("write a number");
        if (str == null) {
            W0();
        } else if (this.f6209g) {
            b1(str);
        } else {
            o0(str);
        }
    }

    public final void f1(String str, int i10, int i11) {
        int i12 = i11 + i10;
        int i13 = this.f6819u;
        byte[] bArr = this.f6818t;
        int[] iArr = this.f6771l;
        while (i10 < i12) {
            char charAt = str.charAt(i10);
            if (charAt > 127 || iArr[charAt] != 0) {
                break;
            }
            bArr[i13] = (byte) charAt;
            i10++;
            i13++;
        }
        this.f6819u = i13;
        if (i10 >= i12) {
            return;
        }
        if (this.f6772m == 0) {
            h1(str, i10, i12);
        } else {
            j1(str, i10, i12);
        }
    }

    public void flush() {
        L0();
        if (this.f6816r != null && v(h.b.FLUSH_PASSED_TO_STREAM)) {
            this.f6816r.flush();
        }
    }

    public void g0(BigDecimal bigDecimal) {
        I0("write a number");
        if (bigDecimal == null) {
            W0();
        } else if (this.f6209g) {
            b1(F0(bigDecimal));
        } else {
            o0(F0(bigDecimal));
        }
    }

    public final void g1(char[] cArr, int i10, int i11) {
        int i12 = i11 + i10;
        int i13 = this.f6819u;
        byte[] bArr = this.f6818t;
        int[] iArr = this.f6771l;
        while (i10 < i12) {
            char c10 = cArr[i10];
            if (c10 > 127 || iArr[c10] != 0) {
                break;
            }
            bArr[i13] = (byte) c10;
            i10++;
            i13++;
        }
        this.f6819u = i13;
        if (i10 >= i12) {
            return;
        }
        if (this.f6772m == 0) {
            i1(cArr, i10, i12);
        } else {
            k1(cArr, i10, i12);
        }
    }

    public void h0(BigInteger bigInteger) {
        I0("write a number");
        if (bigInteger == null) {
            W0();
        } else if (this.f6209g) {
            b1(bigInteger.toString());
        } else {
            o0(bigInteger.toString());
        }
    }

    public final void h1(String str, int i10, int i11) {
        if (this.f6819u + ((i11 - i10) * 6) > this.f6820v) {
            L0();
        }
        int i12 = this.f6819u;
        byte[] bArr = this.f6818t;
        int[] iArr = this.f6771l;
        while (i10 < i11) {
            int i13 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt <= 127) {
                int i14 = iArr[charAt];
                if (i14 == 0) {
                    bArr[i12] = (byte) charAt;
                    i10 = i13;
                    i12++;
                } else if (i14 > 0) {
                    int i15 = i12 + 1;
                    bArr[i12] = 92;
                    i12 = i15 + 1;
                    bArr[i15] = (byte) i14;
                } else {
                    i12 = V0(charAt, i12);
                }
            } else if (charAt <= 2047) {
                int i16 = i12 + 1;
                bArr[i12] = (byte) ((charAt >> 6) | 192);
                i12 = i16 + 1;
                bArr[i16] = (byte) ((charAt & '?') | 128);
            } else {
                i12 = M0(charAt, i12);
            }
            i10 = i13;
        }
        this.f6819u = i12;
    }

    public void i0(short s10) {
        I0("write a number");
        if (this.f6819u + 6 >= this.f6820v) {
            L0();
        }
        if (this.f6209g) {
            c1(s10);
        } else {
            this.f6819u = f3.g.q(s10, this.f6818t, this.f6819u);
        }
    }

    public final void i1(char[] cArr, int i10, int i11) {
        if (this.f6819u + ((i11 - i10) * 6) > this.f6820v) {
            L0();
        }
        int i12 = this.f6819u;
        byte[] bArr = this.f6818t;
        int[] iArr = this.f6771l;
        while (i10 < i11) {
            int i13 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 <= 127) {
                int i14 = iArr[c10];
                if (i14 == 0) {
                    bArr[i12] = (byte) c10;
                    i10 = i13;
                    i12++;
                } else if (i14 > 0) {
                    int i15 = i12 + 1;
                    bArr[i12] = 92;
                    i12 = i15 + 1;
                    bArr[i15] = (byte) i14;
                } else {
                    i12 = V0(c10, i12);
                }
            } else if (c10 <= 2047) {
                int i16 = i12 + 1;
                bArr[i12] = (byte) ((c10 >> 6) | 192);
                i12 = i16 + 1;
                bArr[i16] = (byte) ((c10 & '?') | 128);
            } else {
                i12 = M0(c10, i12);
            }
            i10 = i13;
        }
        this.f6819u = i12;
    }

    public final void j1(String str, int i10, int i11) {
        if (this.f6819u + ((i11 - i10) * 6) > this.f6820v) {
            L0();
        }
        int i12 = this.f6819u;
        byte[] bArr = this.f6818t;
        int[] iArr = this.f6771l;
        int i13 = this.f6772m;
        while (i10 < i11) {
            int i14 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt <= 127) {
                int i15 = iArr[charAt];
                if (i15 == 0) {
                    bArr[i12] = (byte) charAt;
                    i10 = i14;
                    i12++;
                } else if (i15 > 0) {
                    int i16 = i12 + 1;
                    bArr[i12] = 92;
                    i12 = i16 + 1;
                    bArr[i16] = (byte) i15;
                } else {
                    i12 = V0(charAt, i12);
                }
            } else if (charAt > i13) {
                i12 = V0(charAt, i12);
            } else if (charAt <= 2047) {
                int i17 = i12 + 1;
                bArr[i12] = (byte) ((charAt >> 6) | 192);
                i12 = i17 + 1;
                bArr[i17] = (byte) ((charAt & '?') | 128);
            } else {
                i12 = M0(charAt, i12);
            }
            i10 = i14;
        }
        this.f6819u = i12;
    }

    public final void k1(char[] cArr, int i10, int i11) {
        if (this.f6819u + ((i11 - i10) * 6) > this.f6820v) {
            L0();
        }
        int i12 = this.f6819u;
        byte[] bArr = this.f6818t;
        int[] iArr = this.f6771l;
        int i13 = this.f6772m;
        while (i10 < i11) {
            int i14 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 <= 127) {
                int i15 = iArr[c10];
                if (i15 == 0) {
                    bArr[i12] = (byte) c10;
                    i10 = i14;
                    i12++;
                } else if (i15 > 0) {
                    int i16 = i12 + 1;
                    bArr[i12] = 92;
                    i12 = i16 + 1;
                    bArr[i16] = (byte) i15;
                } else {
                    i12 = V0(c10, i12);
                }
            } else if (c10 > i13) {
                i12 = V0(c10, i12);
            } else if (c10 <= 2047) {
                int i17 = i12 + 1;
                bArr[i12] = (byte) ((c10 >> 6) | 192);
                i12 = i17 + 1;
                bArr[i17] = (byte) ((c10 & '?') | 128);
            } else {
                i12 = M0(c10, i12);
            }
            i10 = i14;
        }
        this.f6819u = i12;
    }

    public final void l1(String str, int i10, int i11) {
        do {
            int min = Math.min(this.f6821w, i11);
            if (this.f6819u + min > this.f6820v) {
                L0();
            }
            f1(str, i10, min);
            i10 += min;
            i11 -= min;
        } while (i11 > 0);
    }

    public void m0(char c10) {
        if (this.f6819u + 3 >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        if (c10 <= 127) {
            int i10 = this.f6819u;
            this.f6819u = i10 + 1;
            bArr[i10] = (byte) c10;
        } else if (c10 < 2048) {
            int i11 = this.f6819u;
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((c10 >> 6) | 192);
            this.f6819u = i12 + 1;
            bArr[i12] = (byte) ((c10 & '?') | 128);
        } else {
            N0(c10, (char[]) null, 0, 0);
        }
    }

    public final void m1(String str, boolean z10) {
        if (z10) {
            if (this.f6819u >= this.f6820v) {
                L0();
            }
            byte[] bArr = this.f6818t;
            int i10 = this.f6819u;
            this.f6819u = i10 + 1;
            bArr[i10] = this.f6817s;
        }
        int length = str.length();
        int i11 = 0;
        while (length > 0) {
            int min = Math.min(this.f6821w, length);
            if (this.f6819u + min > this.f6820v) {
                L0();
            }
            f1(str, i11, min);
            i11 += min;
            length -= min;
        }
        if (z10) {
            if (this.f6819u >= this.f6820v) {
                L0();
            }
            byte[] bArr2 = this.f6818t;
            int i12 = this.f6819u;
            this.f6819u = i12 + 1;
            bArr2[i12] = this.f6817s;
        }
    }

    public void n0(q qVar) {
        int f10 = qVar.f(this.f6818t, this.f6819u);
        if (f10 < 0) {
            U0(qVar.g());
        } else {
            this.f6819u += f10;
        }
    }

    public final void n1(char[] cArr, int i10, int i11) {
        do {
            int min = Math.min(this.f6821w, i11);
            if (this.f6819u + min > this.f6820v) {
                L0();
            }
            g1(cArr, i10, min);
            i10 += min;
            i11 -= min;
        } while (i11 > 0);
    }

    public void o0(String str) {
        int length = str.length();
        char[] cArr = this.f6822x;
        if (length <= cArr.length) {
            str.getChars(0, length, cArr, 0);
            p0(cArr, 0, length);
            return;
        }
        p1(str, 0, length);
    }

    public final void o1(q qVar) {
        int d10 = qVar.d(this.f6818t, this.f6819u);
        if (d10 < 0) {
            U0(qVar.c());
        } else {
            this.f6819u += d10;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r0 >= 2048) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r1 = r5.f6818t;
        r2 = r5.f6819u;
        r3 = r2 + 1;
        r1[r2] = (byte) ((r0 >> 6) | 192);
        r5.f6819u = r3 + 1;
        r1[r3] = (byte) ((r0 & '?') | 128);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        r7 = N0(r0, r6, r7, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p0(char[] r6, int r7, int r8) {
        /*
            r5 = this;
            int r0 = r8 + r8
            int r0 = r0 + r8
            int r1 = r5.f6819u
            int r1 = r1 + r0
            int r2 = r5.f6820v
            if (r1 <= r2) goto L_0x0013
            if (r2 >= r0) goto L_0x0010
            r5.e1(r6, r7, r8)
            return
        L_0x0010:
            r5.L0()
        L_0x0013:
            int r8 = r8 + r7
        L_0x0014:
            if (r7 >= r8) goto L_0x004f
        L_0x0016:
            char r0 = r6[r7]
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 <= r1) goto L_0x0040
            int r7 = r7 + 1
            r1 = 2048(0x800, float:2.87E-42)
            if (r0 >= r1) goto L_0x003b
            byte[] r1 = r5.f6818t
            int r2 = r5.f6819u
            int r3 = r2 + 1
            int r4 = r0 >> 6
            r4 = r4 | 192(0xc0, float:2.69E-43)
            byte r4 = (byte) r4
            r1[r2] = r4
            int r2 = r3 + 1
            r5.f6819u = r2
            r0 = r0 & 63
            r0 = r0 | 128(0x80, float:1.794E-43)
            byte r0 = (byte) r0
            r1[r3] = r0
            goto L_0x0014
        L_0x003b:
            int r7 = r5.N0(r0, r6, r7, r8)
            goto L_0x0014
        L_0x0040:
            byte[] r1 = r5.f6818t
            int r2 = r5.f6819u
            int r3 = r2 + 1
            r5.f6819u = r3
            byte r0 = (byte) r0
            r1[r2] = r0
            int r7 = r7 + 1
            if (r7 < r8) goto L_0x0016
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.g.p0(char[], int, int):void");
    }

    public void p1(String str, int i10, int i11) {
        char c10;
        char[] cArr = this.f6822x;
        int length = cArr.length;
        if (i11 <= length) {
            str.getChars(i10, i10 + i11, cArr, 0);
            p0(cArr, 0, i11);
            return;
        }
        int i12 = this.f6820v;
        int min = Math.min(length, (i12 >> 2) + (i12 >> 4));
        int i13 = min * 3;
        while (i11 > 0) {
            int min2 = Math.min(min, i11);
            str.getChars(i10, i10 + min2, cArr, 0);
            if (this.f6819u + i13 > this.f6820v) {
                L0();
            }
            if (min2 > 1 && (c10 = cArr[min2 - 1]) >= 55296 && c10 <= 56319) {
                min2--;
            }
            d1(cArr, 0, min2);
            i10 += min2;
            i11 -= min2;
        }
    }

    public void q0(q qVar) {
        I0("write a raw (unencoded) value");
        int f10 = qVar.f(this.f6818t, this.f6819u);
        if (f10 < 0) {
            U0(qVar.g());
        } else {
            this.f6819u += f10;
        }
    }

    public final void s0() {
        I0("start an array");
        this.f6210h = this.f6210h.m();
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        this.f6819u = i10 + 1;
        bArr[i10] = 91;
    }

    public final void t0(Object obj) {
        I0("start an array");
        this.f6210h = this.f6210h.n(obj);
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        this.f6819u = i10 + 1;
        bArr[i10] = 91;
    }

    public void u0(Object obj, int i10) {
        I0("start an array");
        this.f6210h = this.f6210h.n(obj);
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i11 = this.f6819u;
        this.f6819u = i11 + 1;
        bArr[i11] = 91;
    }

    public final void v0() {
        I0("start an object");
        this.f6210h = this.f6210h.o();
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.e(this);
            return;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        this.f6819u = i10 + 1;
        bArr[i10] = 123;
    }

    public void w0(Object obj) {
        I0("start an object");
        this.f6210h = this.f6210h.p(obj);
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.e(this);
            return;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        this.f6819u = i10 + 1;
        bArr[i10] = 123;
    }

    public final void y0(q qVar) {
        I0("write a string");
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        int i11 = i10 + 1;
        this.f6819u = i11;
        bArr[i10] = this.f6817s;
        int d10 = qVar.d(bArr, i11);
        if (d10 < 0) {
            U0(qVar.c());
        } else {
            this.f6819u += d10;
        }
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr2 = this.f6818t;
        int i12 = this.f6819u;
        this.f6819u = i12 + 1;
        bArr2[i12] = this.f6817s;
    }

    public void z0(String str) {
        I0("write a string");
        if (str == null) {
            W0();
            return;
        }
        int length = str.length();
        if (length > this.f6821w) {
            m1(str, true);
            return;
        }
        if (this.f6819u + length >= this.f6820v) {
            L0();
        }
        byte[] bArr = this.f6818t;
        int i10 = this.f6819u;
        this.f6819u = i10 + 1;
        bArr[i10] = this.f6817s;
        f1(str, 0, length);
        if (this.f6819u >= this.f6820v) {
            L0();
        }
        byte[] bArr2 = this.f6818t;
        int i11 = this.f6819u;
        this.f6819u = i11 + 1;
        bArr2[i11] = this.f6817s;
    }
}
