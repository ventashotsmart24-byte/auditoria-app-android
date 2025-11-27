package d9;

import anet.channel.util.HttpConstant;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import com.taobao.accs.common.Constants;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Locale;
import okio.Buffer;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f16423e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN, 'C', ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN, 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public final String f16424a;

    /* renamed from: b  reason: collision with root package name */
    public final String f16425b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16426c;

    /* renamed from: d  reason: collision with root package name */
    public final String f16427d;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f16428a;

        /* renamed from: b  reason: collision with root package name */
        public String f16429b;

        /* renamed from: c  reason: collision with root package name */
        public int f16430c = -1;

        public static String b(String str, int i10, int i11) {
            String d10 = a.d(str, i10, i11, false);
            if (!d10.startsWith("[") || !d10.endsWith("]")) {
                return f(d10);
            }
            InetAddress e10 = e(d10, 1, d10.length() - 1);
            if (e10 == null) {
                return null;
            }
            byte[] address = e10.getAddress();
            if (address.length == 16) {
                return i(address);
            }
            throw new AssertionError();
        }

        public static boolean c(String str) {
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        public static boolean d(String str, int i10, int i11, byte[] bArr, int i12) {
            int i13 = i12;
            while (i10 < i11) {
                if (i13 == bArr.length) {
                    return false;
                }
                if (i13 != i12) {
                    if (str.charAt(i10) != '.') {
                        return false;
                    }
                    i10++;
                }
                int i14 = i10;
                int i15 = 0;
                while (i14 < i11) {
                    char charAt = str.charAt(i14);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i14++;
                    }
                }
                if (i14 - i10 == 0) {
                    return false;
                }
                bArr[i13] = (byte) i15;
                i13++;
                i10 = i14;
            }
            if (i13 != i12 + 4) {
                return false;
            }
            return true;
        }

        public static InetAddress e(String str, int i10, int i11) {
            byte[] bArr = new byte[16];
            int i12 = 0;
            int i13 = -1;
            int i14 = -1;
            while (true) {
                if (i10 >= i11) {
                    break;
                } else if (i12 == 16) {
                    return null;
                } else {
                    int i15 = i10 + 2;
                    if (i15 > i11 || !str.regionMatches(i10, "::", 0, 2)) {
                        if (i12 != 0) {
                            if (str.regionMatches(i10, SOAP.DELIM, 0, 1)) {
                                i10++;
                            } else if (!str.regionMatches(i10, ".", 0, 1) || !d(str, i14, i11, bArr, i12 - 2)) {
                                return null;
                            } else {
                                i12 += 2;
                            }
                        }
                        i14 = i10;
                    } else if (i13 != -1) {
                        return null;
                    } else {
                        i12 += 2;
                        i13 = i12;
                        if (i15 == i11) {
                            break;
                        }
                        i14 = i15;
                    }
                    i10 = i14;
                    int i16 = 0;
                    while (i10 < i11) {
                        int a10 = a.a(str.charAt(i10));
                        if (a10 == -1) {
                            break;
                        }
                        i16 = (i16 << 4) + a10;
                        i10++;
                    }
                    int i17 = i10 - i14;
                    if (i17 == 0 || i17 > 4) {
                        return null;
                    }
                    int i18 = i12 + 1;
                    bArr[i12] = (byte) ((i16 >>> 8) & 255);
                    i12 = i18 + 1;
                    bArr[i18] = (byte) (i16 & 255);
                }
            }
            if (i12 != 16) {
                if (i13 == -1) {
                    return null;
                }
                int i19 = i12 - i13;
                System.arraycopy(bArr, i13, bArr, 16 - i19, i19);
                Arrays.fill(bArr, i13, (16 - i12) + i13, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }

        public static String f(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (!lowerCase.isEmpty() && !c(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public static String i(byte[] bArr) {
            int i10 = -1;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i12 < bArr.length) {
                int i14 = i12;
                while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                    i14 += 2;
                }
                int i15 = i14 - i12;
                if (i15 > i13) {
                    i10 = i12;
                    i13 = i15;
                }
                i12 = i14 + 2;
            }
            Buffer buffer = new Buffer();
            while (i11 < bArr.length) {
                if (i11 == i10) {
                    buffer.writeByte(58);
                    i11 += i13;
                    if (i11 == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i11 > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong((long) (((bArr[i11] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i11 + 1] & UnsignedBytes.MAX_VALUE)));
                    i11 += 2;
                }
            }
            return buffer.readUtf8();
        }

        public a a() {
            if (this.f16428a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f16429b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public int g() {
            int i10 = this.f16430c;
            if (i10 != -1) {
                return i10;
            }
            return a.b(this.f16428a);
        }

        public b h(String str) {
            if (str != null) {
                String b10 = b(str, 0, str.length());
                if (b10 != null) {
                    this.f16429b = b10;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new IllegalArgumentException("host == null");
        }

        public b j(int i10) {
            if (i10 <= 0 || i10 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i10);
            }
            this.f16430c = i10;
            return this;
        }

        public b k(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase(HttpConstant.HTTP)) {
                    this.f16428a = HttpConstant.HTTP;
                } else if (str.equalsIgnoreCase("https")) {
                    this.f16428a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new IllegalArgumentException("scheme == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f16428a);
            sb.append(HttpConstant.SCHEME_SPLIT);
            if (this.f16429b.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f16429b);
                sb.append(']');
            } else {
                sb.append(this.f16429b);
            }
            int g10 = g();
            if (g10 != a.b(this.f16428a)) {
                sb.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
                sb.append(g10);
            }
            return sb.toString();
        }
    }

    public static int a(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (c10 < 'a' || c10 > 'f') {
            c11 = 'A';
            if (c10 < 'A' || c10 > 'F') {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    public static int b(String str) {
        if (str.equals(HttpConstant.HTTP)) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.PORT;
        }
        return -1;
    }

    public static String d(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '%' || (charAt == '+' && z10)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i10, i12);
                e(buffer, str, i12, i11, z10);
                return buffer.readUtf8();
            }
        }
        return str.substring(i10, i11);
    }

    public static void e(Buffer buffer, String str, int i10, int i11, boolean z10) {
        int i12;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt == 37 && (i12 = i10 + 2) < i11) {
                int a10 = a(str.charAt(i10 + 1));
                int a11 = a(str.charAt(i12));
                if (!(a10 == -1 || a11 == -1)) {
                    buffer.writeByte((a10 << 4) + a11);
                    i10 = i12;
                    i10 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z10) {
                buffer.writeByte(32);
                i10 += Character.charCount(codePointAt);
            }
            buffer.writeUtf8CodePoint(codePointAt);
            i10 += Character.charCount(codePointAt);
        }
    }

    public String c() {
        return this.f16425b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a) || !((a) obj).f16427d.equals(this.f16427d)) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f16426c;
    }

    public int hashCode() {
        return this.f16427d.hashCode();
    }

    public String toString() {
        return this.f16427d;
    }

    public a(b bVar) {
        this.f16424a = bVar.f16428a;
        this.f16425b = bVar.f16429b;
        this.f16426c = bVar.g();
        this.f16427d = bVar.toString();
    }
}
