package g3;

import c3.h;
import c3.m;
import c3.o;
import c3.p;
import c3.q;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import f3.a;
import f3.c;
import f3.g;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public class h extends b {
    public static final char[] A = a.d();

    /* renamed from: r  reason: collision with root package name */
    public final Writer f6825r;

    /* renamed from: s  reason: collision with root package name */
    public char f6826s;

    /* renamed from: t  reason: collision with root package name */
    public char[] f6827t;

    /* renamed from: u  reason: collision with root package name */
    public int f6828u;

    /* renamed from: v  reason: collision with root package name */
    public int f6829v;

    /* renamed from: w  reason: collision with root package name */
    public int f6830w;

    /* renamed from: x  reason: collision with root package name */
    public char[] f6831x;

    /* renamed from: y  reason: collision with root package name */
    public q f6832y;

    /* renamed from: z  reason: collision with root package name */
    public char[] f6833z;

    public h(c cVar, int i10, o oVar, Writer writer, char c10) {
        super(cVar, i10, oVar);
        this.f6825r = writer;
        char[] e10 = cVar.e();
        this.f6827t = e10;
        this.f6830w = e10.length;
        this.f6826s = c10;
        if (c10 != '\"') {
            this.f6771l = a.f(c10);
        }
    }

    public void A0(char[] cArr, int i10, int i11) {
        I0("write a string");
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr2 = this.f6827t;
        int i12 = this.f6829v;
        this.f6829v = i12 + 1;
        cArr2[i12] = this.f6826s;
        j1(cArr, i10, i11);
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr3 = this.f6827t;
        int i13 = this.f6829v;
        this.f6829v = i13 + 1;
        cArr3[i13] = this.f6826s;
    }

    public final void I0(String str) {
        char c10;
        int x10 = this.f6210h.x();
        if (this.f4717a != null) {
            K0(str, x10);
            return;
        }
        if (x10 == 1) {
            c10 = ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN;
        } else if (x10 == 2) {
            c10 = ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER;
        } else if (x10 == 3) {
            q qVar = this.f6773n;
            if (qVar != null) {
                o0(qVar.getValue());
                return;
            }
            return;
        } else if (x10 == 5) {
            J0(str);
            return;
        } else {
            return;
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = c10;
    }

    public final char[] L0() {
        char[] cArr = new char[14];
        cArr[0] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
        cArr[2] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
        cArr[3] = 'u';
        cArr[4] = '0';
        cArr[5] = '0';
        cArr[8] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
        cArr[9] = 'u';
        this.f6831x = cArr;
        return cArr;
    }

    public final void M0(char c10, int i10) {
        int i11;
        if (i10 >= 0) {
            if (this.f6829v + 2 > this.f6830w) {
                N0();
            }
            char[] cArr = this.f6827t;
            int i12 = this.f6829v;
            int i13 = i12 + 1;
            cArr[i12] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
            this.f6829v = i13 + 1;
            cArr[i13] = (char) i10;
        } else if (i10 != -2) {
            if (this.f6829v + 5 >= this.f6830w) {
                N0();
            }
            int i14 = this.f6829v;
            char[] cArr2 = this.f6827t;
            int i15 = i14 + 1;
            cArr2[i14] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
            int i16 = i15 + 1;
            cArr2[i15] = 'u';
            if (c10 > 255) {
                int i17 = 255 & (c10 >> 8);
                int i18 = i16 + 1;
                char[] cArr3 = A;
                cArr2[i16] = cArr3[i17 >> 4];
                i11 = i18 + 1;
                cArr2[i18] = cArr3[i17 & 15];
                c10 = (char) (c10 & 255);
            } else {
                int i19 = i16 + 1;
                cArr2[i16] = '0';
                i11 = i19 + 1;
                cArr2[i19] = '0';
            }
            int i20 = i11 + 1;
            char[] cArr4 = A;
            cArr2[i11] = cArr4[c10 >> 4];
            cArr2[i20] = cArr4[c10 & 15];
            this.f6829v = i20 + 1;
        } else {
            q qVar = this.f6832y;
            qVar.getClass();
            String value = qVar.getValue();
            this.f6832y = null;
            int length = value.length();
            if (this.f6829v + length > this.f6830w) {
                N0();
                if (length > this.f6830w) {
                    this.f6825r.write(value);
                    return;
                }
            }
            value.getChars(0, length, this.f6827t, this.f6829v);
            this.f6829v += length;
        }
    }

    public void N0() {
        int i10 = this.f6829v;
        int i11 = this.f6828u;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.f6828u = 0;
            this.f6829v = 0;
            this.f6825r.write(this.f6827t, i11, i12);
        }
    }

    public final int O0(char[] cArr, int i10, int i11, char c10, int i12) {
        int i13;
        if (i12 >= 0) {
            if (i10 <= 1 || i10 >= i11) {
                char[] cArr2 = this.f6831x;
                if (cArr2 == null) {
                    cArr2 = L0();
                }
                cArr2[1] = (char) i12;
                this.f6825r.write(cArr2, 0, 2);
                return i10;
            }
            int i14 = i10 - 2;
            cArr[i14] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
            cArr[i14 + 1] = (char) i12;
            return i14;
        } else if (i12 == -2) {
            q qVar = this.f6832y;
            qVar.getClass();
            String value = qVar.getValue();
            this.f6832y = null;
            int length = value.length();
            if (i10 < length || i10 >= i11) {
                this.f6825r.write(value);
                return i10;
            }
            int i15 = i10 - length;
            value.getChars(0, length, cArr, i15);
            return i15;
        } else if (i10 <= 5 || i10 >= i11) {
            char[] cArr3 = this.f6831x;
            if (cArr3 == null) {
                cArr3 = L0();
            }
            this.f6828u = this.f6829v;
            if (c10 > 255) {
                int i16 = (c10 >> 8) & 255;
                char c11 = c10 & 255;
                char[] cArr4 = A;
                cArr3[10] = cArr4[i16 >> 4];
                cArr3[11] = cArr4[i16 & 15];
                cArr3[12] = cArr4[c11 >> 4];
                cArr3[13] = cArr4[c11 & 15];
                this.f6825r.write(cArr3, 8, 6);
                return i10;
            }
            char[] cArr5 = A;
            cArr3[6] = cArr5[c10 >> 4];
            cArr3[7] = cArr5[c10 & 15];
            this.f6825r.write(cArr3, 2, 6);
            return i10;
        } else {
            int i17 = i10 - 6;
            int i18 = i17 + 1;
            cArr[i17] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
            int i19 = i18 + 1;
            cArr[i18] = 'u';
            if (c10 > 255) {
                int i20 = (c10 >> 8) & 255;
                int i21 = i19 + 1;
                char[] cArr6 = A;
                cArr[i19] = cArr6[i20 >> 4];
                i13 = i21 + 1;
                cArr[i21] = cArr6[i20 & 15];
                c10 = (char) (c10 & 255);
            } else {
                int i22 = i19 + 1;
                cArr[i19] = '0';
                i13 = i22 + 1;
                cArr[i22] = '0';
            }
            int i23 = i13 + 1;
            char[] cArr7 = A;
            cArr[i13] = cArr7[c10 >> 4];
            cArr[i23] = cArr7[c10 & 15];
            return i23 - 5;
        }
    }

    public int P(c3.a aVar, InputStream inputStream, int i10) {
        I0("write a binary value");
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i11 = this.f6829v;
        this.f6829v = i11 + 1;
        cArr[i11] = this.f6826s;
        byte[] d10 = this.f6770k.d();
        if (i10 < 0) {
            try {
                i10 = S0(aVar, inputStream, d10);
            } catch (Throwable th) {
                this.f6770k.l(d10);
                throw th;
            }
        } else {
            int T0 = T0(aVar, inputStream, d10, i10);
            if (T0 > 0) {
                a("Too few bytes available: missing " + T0 + " bytes (out of " + i10 + ")");
            }
        }
        this.f6770k.l(d10);
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr2 = this.f6827t;
        int i12 = this.f6829v;
        this.f6829v = i12 + 1;
        cArr2[i12] = this.f6826s;
        return i10;
    }

    public final void P0(char c10, int i10) {
        int i11;
        if (i10 >= 0) {
            int i12 = this.f6829v;
            if (i12 >= 2) {
                int i13 = i12 - 2;
                this.f6828u = i13;
                char[] cArr = this.f6827t;
                cArr[i13] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                cArr[i13 + 1] = (char) i10;
                return;
            }
            char[] cArr2 = this.f6831x;
            if (cArr2 == null) {
                cArr2 = L0();
            }
            this.f6828u = this.f6829v;
            cArr2[1] = (char) i10;
            this.f6825r.write(cArr2, 0, 2);
        } else if (i10 != -2) {
            int i14 = this.f6829v;
            if (i14 >= 6) {
                char[] cArr3 = this.f6827t;
                int i15 = i14 - 6;
                this.f6828u = i15;
                cArr3[i15] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                int i16 = i15 + 1;
                cArr3[i16] = 'u';
                if (c10 > 255) {
                    int i17 = (c10 >> 8) & 255;
                    int i18 = i16 + 1;
                    char[] cArr4 = A;
                    cArr3[i18] = cArr4[i17 >> 4];
                    i11 = i18 + 1;
                    cArr3[i11] = cArr4[i17 & 15];
                    c10 = (char) (c10 & 255);
                } else {
                    int i19 = i16 + 1;
                    cArr3[i19] = '0';
                    i11 = i19 + 1;
                    cArr3[i11] = '0';
                }
                int i20 = i11 + 1;
                char[] cArr5 = A;
                cArr3[i20] = cArr5[c10 >> 4];
                cArr3[i20 + 1] = cArr5[c10 & 15];
                return;
            }
            char[] cArr6 = this.f6831x;
            if (cArr6 == null) {
                cArr6 = L0();
            }
            this.f6828u = this.f6829v;
            if (c10 > 255) {
                int i21 = (c10 >> 8) & 255;
                char c11 = c10 & 255;
                char[] cArr7 = A;
                cArr6[10] = cArr7[i21 >> 4];
                cArr6[11] = cArr7[i21 & 15];
                cArr6[12] = cArr7[c11 >> 4];
                cArr6[13] = cArr7[c11 & 15];
                this.f6825r.write(cArr6, 8, 6);
                return;
            }
            char[] cArr8 = A;
            cArr6[6] = cArr8[c10 >> 4];
            cArr6[7] = cArr8[c10 & 15];
            this.f6825r.write(cArr6, 2, 6);
        } else {
            q qVar = this.f6832y;
            qVar.getClass();
            String value = qVar.getValue();
            this.f6832y = null;
            int length = value.length();
            int i22 = this.f6829v;
            if (i22 >= length) {
                int i23 = i22 - length;
                this.f6828u = i23;
                value.getChars(0, length, this.f6827t, i23);
                return;
            }
            this.f6828u = i22;
            this.f6825r.write(value);
        }
    }

    public final int Q0(InputStream inputStream, byte[] bArr, int i10, int i11, int i12) {
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

    public void R(c3.a aVar, byte[] bArr, int i10, int i11) {
        I0("write a binary value");
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i12 = this.f6829v;
        this.f6829v = i12 + 1;
        cArr[i12] = this.f6826s;
        U0(aVar, bArr, i10, i11 + i10);
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr2 = this.f6827t;
        int i13 = this.f6829v;
        this.f6829v = i13 + 1;
        cArr2[i13] = this.f6826s;
    }

    public void R0() {
        char[] cArr = this.f6827t;
        if (cArr != null) {
            this.f6827t = null;
            this.f6770k.m(cArr);
        }
        char[] cArr2 = this.f6833z;
        if (cArr2 != null) {
            this.f6833z = null;
            this.f6770k.n(cArr2);
        }
    }

    public final int S0(c3.a aVar, InputStream inputStream, byte[] bArr) {
        int i10 = this.f6830w - 6;
        int i11 = 2;
        int p10 = aVar.p() >> 2;
        int i12 = -3;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i13 > i12) {
                i14 = Q0(inputStream, bArr, i13, i14, bArr.length);
                if (i14 < 3) {
                    break;
                }
                i12 = i14 - 3;
                i13 = 0;
            }
            if (this.f6829v > i10) {
                N0();
            }
            int i16 = i13 + 1;
            int i17 = i16 + 1;
            i13 = i17 + 1;
            i15 += 3;
            int k10 = aVar.k((((bArr[i16] & UnsignedBytes.MAX_VALUE) | (bArr[i13] << 8)) << 8) | (bArr[i17] & UnsignedBytes.MAX_VALUE), this.f6827t, this.f6829v);
            this.f6829v = k10;
            p10--;
            if (p10 <= 0) {
                char[] cArr = this.f6827t;
                int i18 = k10 + 1;
                cArr[k10] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                this.f6829v = i18 + 1;
                cArr[i18] = 'n';
                p10 = aVar.p() >> 2;
            }
        }
        if (i14 <= 0) {
            return i15;
        }
        if (this.f6829v > i10) {
            N0();
        }
        int i19 = bArr[0] << 16;
        if (1 < i14) {
            i19 |= (bArr[1] & UnsignedBytes.MAX_VALUE) << 8;
        } else {
            i11 = 1;
        }
        int i20 = i15 + i11;
        this.f6829v = aVar.n(i19, i11, this.f6827t, this.f6829v);
        return i20;
    }

    public final int T0(c3.a aVar, InputStream inputStream, byte[] bArr, int i10) {
        int Q0;
        int i11 = this.f6830w - 6;
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
                i15 = Q0(inputStream, bArr, i14, i15, i10);
                if (i15 < 3) {
                    i14 = 0;
                    break;
                }
                i13 = i15 - 3;
                i14 = 0;
            }
            if (this.f6829v > i11) {
                N0();
            }
            int i16 = i14 + 1;
            int i17 = i16 + 1;
            i14 = i17 + 1;
            i10 -= 3;
            int k10 = aVar.k((((bArr[i16] & UnsignedBytes.MAX_VALUE) | (bArr[i14] << 8)) << 8) | (bArr[i17] & UnsignedBytes.MAX_VALUE), this.f6827t, this.f6829v);
            this.f6829v = k10;
            p10--;
            if (p10 <= 0) {
                char[] cArr = this.f6827t;
                int i18 = k10 + 1;
                cArr[k10] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                this.f6829v = i18 + 1;
                cArr[i18] = 'n';
                p10 = aVar.p() >> 2;
            }
        }
        if (i10 <= 0 || (Q0 = Q0(inputStream, bArr, i14, i15, i10)) <= 0) {
            return i10;
        }
        if (this.f6829v > i11) {
            N0();
        }
        int i19 = bArr[0] << 16;
        if (1 < Q0) {
            i19 |= (bArr[1] & UnsignedBytes.MAX_VALUE) << 8;
        } else {
            i12 = 1;
        }
        this.f6829v = aVar.n(i19, i12, this.f6827t, this.f6829v);
        return i10 - i12;
    }

    public void U(boolean z10) {
        int i10;
        I0("write a boolean value");
        if (this.f6829v + 5 >= this.f6830w) {
            N0();
        }
        int i11 = this.f6829v;
        char[] cArr = this.f6827t;
        if (z10) {
            cArr[i11] = 't';
            int i12 = i11 + 1;
            cArr[i12] = 'r';
            int i13 = i12 + 1;
            cArr[i13] = 'u';
            i10 = i13 + 1;
            cArr[i10] = 'e';
        } else {
            cArr[i11] = 'f';
            int i14 = i11 + 1;
            cArr[i14] = 'a';
            int i15 = i14 + 1;
            cArr[i15] = 'l';
            int i16 = i15 + 1;
            cArr[i16] = 's';
            i10 = i16 + 1;
            cArr[i10] = 'e';
        }
        this.f6829v = i10 + 1;
    }

    public final void U0(c3.a aVar, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 3;
        int i13 = this.f6830w - 6;
        int p10 = aVar.p() >> 2;
        while (i10 <= i12) {
            if (this.f6829v > i13) {
                N0();
            }
            int i14 = i10 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int k10 = aVar.k((((bArr[i10] << 8) | (bArr[i14] & UnsignedBytes.MAX_VALUE)) << 8) | (bArr[i15] & UnsignedBytes.MAX_VALUE), this.f6827t, this.f6829v);
            this.f6829v = k10;
            p10--;
            if (p10 <= 0) {
                char[] cArr = this.f6827t;
                int i17 = k10 + 1;
                cArr[k10] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                this.f6829v = i17 + 1;
                cArr[i17] = 'n';
                p10 = aVar.p() >> 2;
            }
            i10 = i16;
        }
        int i18 = i11 - i10;
        if (i18 > 0) {
            if (this.f6829v > i13) {
                N0();
            }
            int i19 = i10 + 1;
            int i20 = bArr[i10] << 16;
            if (i18 == 2) {
                i20 |= (bArr[i19] & UnsignedBytes.MAX_VALUE) << 8;
            }
            this.f6829v = aVar.n(i20, i18, this.f6827t, this.f6829v);
        }
    }

    public void V() {
        if (!this.f6210h.f()) {
            a("Current context not Array but " + this.f6210h.j());
        }
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.d(this, this.f6210h.d());
        } else {
            if (this.f6829v >= this.f6830w) {
                N0();
            }
            char[] cArr = this.f6827t;
            int i10 = this.f6829v;
            this.f6829v = i10 + 1;
            cArr[i10] = ']';
        }
        this.f6210h = this.f6210h.l();
    }

    public final void V0(q qVar, boolean z10) {
        if (this.f4717a != null) {
            a1(qVar, z10);
            return;
        }
        if (this.f6829v + 1 >= this.f6830w) {
            N0();
        }
        if (z10) {
            char[] cArr = this.f6827t;
            int i10 = this.f6829v;
            this.f6829v = i10 + 1;
            cArr[i10] = ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN;
        }
        if (this.f6774o) {
            char[] b10 = qVar.b();
            p0(b10, 0, b10.length);
            return;
        }
        char[] cArr2 = this.f6827t;
        int i11 = this.f6829v;
        int i12 = i11 + 1;
        this.f6829v = i12;
        cArr2[i11] = this.f6826s;
        int a10 = qVar.a(cArr2, i12);
        if (a10 < 0) {
            X0(qVar);
            return;
        }
        int i13 = this.f6829v + a10;
        this.f6829v = i13;
        if (i13 >= this.f6830w) {
            N0();
        }
        char[] cArr3 = this.f6827t;
        int i14 = this.f6829v;
        this.f6829v = i14 + 1;
        cArr3[i14] = this.f6826s;
    }

    public void W() {
        if (!this.f6210h.g()) {
            a("Current context not Object but " + this.f6210h.j());
        }
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.i(this, this.f6210h.d());
        } else {
            if (this.f6829v >= this.f6830w) {
                N0();
            }
            char[] cArr = this.f6827t;
            int i10 = this.f6829v;
            this.f6829v = i10 + 1;
            cArr[i10] = ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
        this.f6210h = this.f6210h.l();
    }

    public final void W0(String str, boolean z10) {
        if (this.f4717a != null) {
            b1(str, z10);
            return;
        }
        if (this.f6829v + 1 >= this.f6830w) {
            N0();
        }
        if (z10) {
            char[] cArr = this.f6827t;
            int i10 = this.f6829v;
            this.f6829v = i10 + 1;
            cArr[i10] = ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN;
        }
        if (this.f6774o) {
            i1(str);
            return;
        }
        char[] cArr2 = this.f6827t;
        int i11 = this.f6829v;
        this.f6829v = i11 + 1;
        cArr2[i11] = this.f6826s;
        i1(str);
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr3 = this.f6827t;
        int i12 = this.f6829v;
        this.f6829v = i12 + 1;
        cArr3[i12] = this.f6826s;
    }

    public final void X0(q qVar) {
        char[] b10 = qVar.b();
        p0(b10, 0, b10.length);
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = this.f6826s;
    }

    public void Y(q qVar) {
        int w10 = this.f6210h.w(qVar.getValue());
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        boolean z10 = true;
        if (w10 != 1) {
            z10 = false;
        }
        V0(qVar, z10);
    }

    public final void Y0(String str) {
        N0();
        int length = str.length();
        int i10 = 0;
        while (true) {
            int i11 = this.f6830w;
            if (i10 + i11 > length) {
                i11 = length - i10;
            }
            int i12 = i10 + i11;
            str.getChars(i10, i12, this.f6827t, 0);
            int i13 = this.f6772m;
            if (i13 != 0) {
                h1(i11, i13);
            } else {
                g1(i11);
            }
            if (i12 < length) {
                i10 = i12;
            } else {
                return;
            }
        }
    }

    public void Z(String str) {
        int w10 = this.f6210h.w(str);
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        boolean z10 = true;
        if (w10 != 1) {
            z10 = false;
        }
        W0(str, z10);
    }

    public final void Z0() {
        if (this.f6829v + 4 >= this.f6830w) {
            N0();
        }
        int i10 = this.f6829v;
        char[] cArr = this.f6827t;
        cArr[i10] = 'n';
        int i11 = i10 + 1;
        cArr[i11] = 'u';
        int i12 = i11 + 1;
        cArr[i12] = 'l';
        int i13 = i12 + 1;
        cArr[i13] = 'l';
        this.f6829v = i13 + 1;
    }

    public void a0() {
        I0("write a null");
        Z0();
    }

    public final void a1(q qVar, boolean z10) {
        if (z10) {
            this.f4717a.a(this);
        } else {
            this.f4717a.k(this);
        }
        char[] b10 = qVar.b();
        if (this.f6774o) {
            p0(b10, 0, b10.length);
            return;
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = this.f6826s;
        p0(b10, 0, b10.length);
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr2 = this.f6827t;
        int i11 = this.f6829v;
        this.f6829v = i11 + 1;
        cArr2[i11] = this.f6826s;
    }

    public void b0(double d10) {
        if (this.f6209g || (g.o(d10) && v(h.b.QUOTE_NON_NUMERIC_NUMBERS))) {
            z0(String.valueOf(d10));
            return;
        }
        I0("write a number");
        o0(String.valueOf(d10));
    }

    public final void b1(String str, boolean z10) {
        if (z10) {
            this.f4717a.a(this);
        } else {
            this.f4717a.k(this);
        }
        if (this.f6774o) {
            i1(str);
            return;
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = this.f6826s;
        i1(str);
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr2 = this.f6827t;
        int i11 = this.f6829v;
        this.f6829v = i11 + 1;
        cArr2[i11] = this.f6826s;
    }

    public void c0(float f10) {
        if (this.f6209g || (g.p(f10) && v(h.b.QUOTE_NON_NUMERIC_NUMBERS))) {
            z0(String.valueOf(f10));
            return;
        }
        I0("write a number");
        o0(String.valueOf(f10));
    }

    public final void c1(int i10) {
        if (this.f6829v + 13 >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i11 = this.f6829v;
        int i12 = i11 + 1;
        this.f6829v = i12;
        cArr[i11] = this.f6826s;
        int r10 = g.r(i10, cArr, i12);
        char[] cArr2 = this.f6827t;
        this.f6829v = r10 + 1;
        cArr2[r10] = this.f6826s;
    }

    public void close() {
        super.close();
        if (this.f6827t != null && v(h.b.AUTO_CLOSE_JSON_CONTENT)) {
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
        N0();
        this.f6828u = 0;
        this.f6829v = 0;
        if (this.f6825r != null) {
            if (this.f6770k.k() || v(h.b.AUTO_CLOSE_TARGET)) {
                this.f6825r.close();
            } else if (v(h.b.FLUSH_PASSED_TO_STREAM)) {
                this.f6825r.flush();
            }
        }
        R0();
    }

    public void d0(int i10) {
        I0("write a number");
        if (this.f6209g) {
            c1(i10);
            return;
        }
        if (this.f6829v + 11 >= this.f6830w) {
            N0();
        }
        this.f6829v = g.r(i10, this.f6827t, this.f6829v);
    }

    public final void d1(long j10) {
        if (this.f6829v + 23 >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        int i11 = i10 + 1;
        this.f6829v = i11;
        cArr[i10] = this.f6826s;
        int t10 = g.t(j10, cArr, i11);
        char[] cArr2 = this.f6827t;
        this.f6829v = t10 + 1;
        cArr2[t10] = this.f6826s;
    }

    public void e0(long j10) {
        I0("write a number");
        if (this.f6209g) {
            d1(j10);
            return;
        }
        if (this.f6829v + 21 >= this.f6830w) {
            N0();
        }
        this.f6829v = g.t(j10, this.f6827t, this.f6829v);
    }

    public final void e1(String str) {
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = this.f6826s;
        o0(str);
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr2 = this.f6827t;
        int i11 = this.f6829v;
        this.f6829v = i11 + 1;
        cArr2[i11] = this.f6826s;
    }

    public void f0(String str) {
        I0("write a number");
        if (str == null) {
            Z0();
        } else if (this.f6209g) {
            e1(str);
        } else {
            o0(str);
        }
    }

    public final void f1(short s10) {
        if (this.f6829v + 8 >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        int i11 = i10 + 1;
        this.f6829v = i11;
        cArr[i10] = this.f6826s;
        int r10 = g.r(s10, cArr, i11);
        char[] cArr2 = this.f6827t;
        this.f6829v = r10 + 1;
        cArr2[r10] = this.f6826s;
    }

    public void flush() {
        N0();
        if (this.f6825r != null && v(h.b.FLUSH_PASSED_TO_STREAM)) {
            this.f6825r.flush();
        }
    }

    public void g0(BigDecimal bigDecimal) {
        I0("write a number");
        if (bigDecimal == null) {
            Z0();
        } else if (this.f6209g) {
            e1(F0(bigDecimal));
        } else {
            o0(F0(bigDecimal));
        }
    }

    public final void g1(int i10) {
        char[] cArr;
        char c10;
        int[] iArr = this.f6771l;
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            do {
                cArr = this.f6827t;
                c10 = cArr[i11];
                if ((c10 < length && iArr[c10] != 0) || (i11 = i11 + 1) >= i10) {
                    int i13 = i11 - i12;
                }
                cArr = this.f6827t;
                c10 = cArr[i11];
                break;
            } while ((i11 = i11 + 1) >= i10);
            int i132 = i11 - i12;
            if (i132 > 0) {
                this.f6825r.write(cArr, i12, i132);
                if (i11 >= i10) {
                    return;
                }
            }
            i11++;
            i12 = O0(this.f6827t, i11, i10, c10, iArr[c10]);
        }
    }

    public void h0(BigInteger bigInteger) {
        I0("write a number");
        if (bigInteger == null) {
            Z0();
        } else if (this.f6209g) {
            e1(bigInteger.toString());
        } else {
            o0(bigInteger.toString());
        }
    }

    public final void h1(int i10, int i11) {
        char[] cArr;
        char c10;
        int[] iArr = this.f6771l;
        int min = Math.min(iArr.length, i11 + 1);
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i10) {
            while (true) {
                cArr = this.f6827t;
                c10 = cArr[i12];
                if (c10 >= min) {
                    if (c10 > i11) {
                        i14 = -1;
                        break;
                    }
                } else {
                    i14 = iArr[c10];
                    if (i14 != 0) {
                        break;
                    }
                }
                i12++;
                if (i12 >= i10) {
                    break;
                }
            }
            int i15 = i12 - i13;
            if (i15 > 0) {
                this.f6825r.write(cArr, i13, i15);
                if (i12 >= i10) {
                    return;
                }
            }
            i12++;
            i13 = O0(this.f6827t, i12, i10, c10, i14);
        }
    }

    public void i0(short s10) {
        I0("write a number");
        if (this.f6209g) {
            f1(s10);
            return;
        }
        if (this.f6829v + 6 >= this.f6830w) {
            N0();
        }
        this.f6829v = g.r(s10, this.f6827t, this.f6829v);
    }

    public final void i1(String str) {
        int length = str.length();
        int i10 = this.f6830w;
        if (length > i10) {
            Y0(str);
            return;
        }
        if (this.f6829v + length > i10) {
            N0();
        }
        str.getChars(0, length, this.f6827t, this.f6829v);
        int i11 = this.f6772m;
        if (i11 != 0) {
            m1(length, i11);
        } else {
            k1(length);
        }
    }

    public final void j1(char[] cArr, int i10, int i11) {
        int i12 = this.f6772m;
        if (i12 != 0) {
            n1(cArr, i10, i11, i12);
            return;
        }
        int i13 = i11 + i10;
        int[] iArr = this.f6771l;
        int length = iArr.length;
        while (i10 < i13) {
            int i14 = i10;
            do {
                char c10 = cArr[i14];
                if ((c10 < length && iArr[c10] != 0) || (i14 = i14 + 1) >= i13) {
                    int i15 = i14 - i10;
                }
                char c102 = cArr[i14];
                break;
            } while ((i14 = i14 + 1) >= i13);
            int i152 = i14 - i10;
            if (i152 < 32) {
                if (this.f6829v + i152 > this.f6830w) {
                    N0();
                }
                if (i152 > 0) {
                    System.arraycopy(cArr, i10, this.f6827t, this.f6829v, i152);
                    this.f6829v += i152;
                }
            } else {
                N0();
                this.f6825r.write(cArr, i10, i152);
            }
            if (i14 < i13) {
                i10 = i14 + 1;
                char c11 = cArr[i14];
                M0(c11, iArr[c11]);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r2 = r6.f6827t;
        r3 = r6.f6829v;
        r6.f6829v = r3 + 1;
        r2 = r2[r3];
        P0(r2, r7[r2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r4 = r6.f6828u;
        r3 = r3 - r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r3 <= 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r6.f6825r.write(r2, r4, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k1(int r7) {
        /*
            r6 = this;
            int r0 = r6.f6829v
            int r0 = r0 + r7
            int[] r7 = r6.f6771l
            int r1 = r7.length
        L_0x0006:
            int r2 = r6.f6829v
            if (r2 >= r0) goto L_0x0036
        L_0x000a:
            char[] r2 = r6.f6827t
            int r3 = r6.f6829v
            char r4 = r2[r3]
            if (r4 >= r1) goto L_0x0030
            r4 = r7[r4]
            if (r4 == 0) goto L_0x0030
            int r4 = r6.f6828u
            int r3 = r3 - r4
            if (r3 <= 0) goto L_0x0020
            java.io.Writer r5 = r6.f6825r
            r5.write(r2, r4, r3)
        L_0x0020:
            char[] r2 = r6.f6827t
            int r3 = r6.f6829v
            int r4 = r3 + 1
            r6.f6829v = r4
            char r2 = r2[r3]
            r3 = r7[r2]
            r6.P0(r2, r3)
            goto L_0x0006
        L_0x0030:
            int r3 = r3 + 1
            r6.f6829v = r3
            if (r3 < r0) goto L_0x000a
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.h.k1(int):void");
    }

    public final void l1(q qVar) {
        char[] b10 = qVar.b();
        int length = b10.length;
        if (length < 32) {
            if (length > this.f6830w - this.f6829v) {
                N0();
            }
            System.arraycopy(b10, 0, this.f6827t, this.f6829v, length);
            this.f6829v += length;
        } else {
            N0();
            this.f6825r.write(b10, 0, length);
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = this.f6826s;
    }

    public void m0(char c10) {
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = c10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1(int r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.f6829v
            int r0 = r0 + r9
            int[] r9 = r8.f6771l
            int r1 = r9.length
            int r2 = r10 + 1
            int r1 = java.lang.Math.min(r1, r2)
        L_0x000c:
            int r2 = r8.f6829v
            if (r2 >= r0) goto L_0x003a
        L_0x0010:
            char[] r2 = r8.f6827t
            int r3 = r8.f6829v
            char r4 = r2[r3]
            if (r4 >= r1) goto L_0x001d
            r5 = r9[r4]
            if (r5 == 0) goto L_0x0034
            goto L_0x0020
        L_0x001d:
            if (r4 <= r10) goto L_0x0034
            r5 = -1
        L_0x0020:
            int r6 = r8.f6828u
            int r3 = r3 - r6
            if (r3 <= 0) goto L_0x002a
            java.io.Writer r7 = r8.f6825r
            r7.write(r2, r6, r3)
        L_0x002a:
            int r2 = r8.f6829v
            int r2 = r2 + 1
            r8.f6829v = r2
            r8.P0(r4, r5)
            goto L_0x000c
        L_0x0034:
            int r3 = r3 + 1
            r8.f6829v = r3
            if (r3 < r0) goto L_0x0010
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.h.m1(int, int):void");
    }

    public void n0(q qVar) {
        int e10 = qVar.e(this.f6827t, this.f6829v);
        if (e10 < 0) {
            o0(qVar.getValue());
        } else {
            this.f6829v += e10;
        }
    }

    public final void n1(char[] cArr, int i10, int i11, int i12) {
        char c10;
        int i13 = i11 + i10;
        int[] iArr = this.f6771l;
        int min = Math.min(iArr.length, i12 + 1);
        int i14 = 0;
        while (i10 < i13) {
            int i15 = i10;
            while (true) {
                c10 = cArr[i15];
                if (c10 >= min) {
                    if (c10 > i12) {
                        i14 = -1;
                        break;
                    }
                } else {
                    i14 = iArr[c10];
                    if (i14 != 0) {
                        break;
                    }
                }
                i15++;
                if (i15 >= i13) {
                    break;
                }
            }
            int i16 = i15 - i10;
            if (i16 < 32) {
                if (this.f6829v + i16 > this.f6830w) {
                    N0();
                }
                if (i16 > 0) {
                    System.arraycopy(cArr, i10, this.f6827t, this.f6829v, i16);
                    this.f6829v += i16;
                }
            } else {
                N0();
                this.f6825r.write(cArr, i10, i16);
            }
            if (i15 < i13) {
                i10 = i15 + 1;
                M0(c10, i14);
            } else {
                return;
            }
        }
    }

    public void o0(String str) {
        int length = str.length();
        int i10 = this.f6830w - this.f6829v;
        if (i10 == 0) {
            N0();
            i10 = this.f6830w - this.f6829v;
        }
        if (i10 >= length) {
            str.getChars(0, length, this.f6827t, this.f6829v);
            this.f6829v += length;
            return;
        }
        o1(str);
    }

    public final void o1(String str) {
        int i10 = this.f6830w;
        int i11 = this.f6829v;
        int i12 = i10 - i11;
        str.getChars(0, i12, this.f6827t, i11);
        this.f6829v += i12;
        N0();
        int length = str.length() - i12;
        while (true) {
            int i13 = this.f6830w;
            if (length > i13) {
                int i14 = i12 + i13;
                str.getChars(i12, i14, this.f6827t, 0);
                this.f6828u = 0;
                this.f6829v = i13;
                N0();
                length -= i13;
                i12 = i14;
            } else {
                str.getChars(i12, i12 + length, this.f6827t, 0);
                this.f6828u = 0;
                this.f6829v = length;
                return;
            }
        }
    }

    public void p0(char[] cArr, int i10, int i11) {
        if (i11 < 32) {
            if (i11 > this.f6830w - this.f6829v) {
                N0();
            }
            System.arraycopy(cArr, i10, this.f6827t, this.f6829v, i11);
            this.f6829v += i11;
            return;
        }
        N0();
        this.f6825r.write(cArr, i10, i11);
    }

    public void s0() {
        I0("start an array");
        this.f6210h = this.f6210h.m();
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = '[';
    }

    public void t0(Object obj) {
        I0("start an array");
        this.f6210h = this.f6210h.n(obj);
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = '[';
    }

    public void u0(Object obj, int i10) {
        I0("start an array");
        this.f6210h = this.f6210h.n(obj);
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i11 = this.f6829v;
        this.f6829v = i11 + 1;
        cArr[i11] = '[';
    }

    public void v0() {
        I0("start an object");
        this.f6210h = this.f6210h.o();
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.e(this);
            return;
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN;
    }

    public void w0(Object obj) {
        I0("start an object");
        this.f6210h = this.f6210h.p(obj);
        p pVar = this.f4717a;
        if (pVar != null) {
            pVar.e(this);
            return;
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN;
    }

    public void y0(q qVar) {
        I0("write a string");
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        int i11 = i10 + 1;
        this.f6829v = i11;
        cArr[i10] = this.f6826s;
        int a10 = qVar.a(cArr, i11);
        if (a10 < 0) {
            l1(qVar);
            return;
        }
        int i12 = this.f6829v + a10;
        this.f6829v = i12;
        if (i12 >= this.f6830w) {
            N0();
        }
        char[] cArr2 = this.f6827t;
        int i13 = this.f6829v;
        this.f6829v = i13 + 1;
        cArr2[i13] = this.f6826s;
    }

    public void z0(String str) {
        I0("write a string");
        if (str == null) {
            Z0();
            return;
        }
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr = this.f6827t;
        int i10 = this.f6829v;
        this.f6829v = i10 + 1;
        cArr[i10] = this.f6826s;
        i1(str);
        if (this.f6829v >= this.f6830w) {
            N0();
        }
        char[] cArr2 = this.f6827t;
        int i11 = this.f6829v;
        this.f6829v = i11 + 1;
        cArr2[i11] = this.f6826s;
    }
}
