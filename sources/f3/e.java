package f3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import j3.c;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f6583a = a.d();

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f6584b = a.c();

    /* renamed from: c  reason: collision with root package name */
    public static final e f6585c = new e();

    public static int d(int i10, int i11) {
        if (i11 >= 56320 && i11 <= 57343) {
            return ((i10 - 55296) << 10) + 65536 + (i11 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i10) + ", second 0x" + Integer.toHexString(i11) + "; illegal combination");
    }

    public static void e(int i10) {
        throw new IllegalArgumentException(j.c(i10));
    }

    public static e h() {
        return f6585c;
    }

    public final int a(int i10, int i11, c cVar, int i12) {
        cVar.u(i12);
        cVar.b(92);
        if (i11 < 0) {
            cVar.b(117);
            if (i10 > 255) {
                int i13 = i10 >> 8;
                byte[] bArr = f6584b;
                cVar.b(bArr[i13 >> 4]);
                cVar.b(bArr[i13 & 15]);
                i10 &= 255;
            } else {
                cVar.b(48);
                cVar.b(48);
            }
            byte[] bArr2 = f6584b;
            cVar.b(bArr2[i10 >> 4]);
            cVar.b(bArr2[i10 & 15]);
        } else {
            cVar.b((byte) i11);
        }
        return cVar.s();
    }

    public final int b(int i10, char[] cArr) {
        cArr[1] = (char) i10;
        return 2;
    }

    public final int c(int i10, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = f6583a;
        cArr[4] = cArr2[i10 >> 4];
        cArr[5] = cArr2[i10 & 15];
        return 6;
    }

    public final char[] f() {
        char[] cArr = new char[6];
        cArr[0] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
        cArr[2] = '0';
        cArr[3] = '0';
        return cArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] g(java.lang.String r12) {
        /*
            r11 = this;
            int r0 = r12.length()
            r1 = 60
            byte[] r2 = new byte[r1]
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x000c:
            if (r5 >= r0) goto L_0x00f5
            int r7 = r5 + 1
            char r5 = r12.charAt(r5)
        L_0x0014:
            r8 = 127(0x7f, float:1.78E-43)
            if (r5 > r8) goto L_0x003d
            if (r6 < r1) goto L_0x0029
            if (r4 != 0) goto L_0x0020
            j3.c r4 = j3.c.n(r2, r6)
        L_0x0020:
            byte[] r1 = r4.m()
            int r2 = r1.length
            r6 = 0
            r10 = r2
            r2 = r1
            r1 = r10
        L_0x0029:
            int r8 = r6 + 1
            byte r5 = (byte) r5
            r2[r6] = r5
            if (r7 < r0) goto L_0x0033
            r6 = r8
            goto L_0x00f5
        L_0x0033:
            int r5 = r7 + 1
            char r6 = r12.charAt(r7)
            r7 = r5
            r5 = r6
            r6 = r8
            goto L_0x0014
        L_0x003d:
            if (r4 != 0) goto L_0x0043
            j3.c r4 = j3.c.n(r2, r6)
        L_0x0043:
            if (r6 < r1) goto L_0x004b
            byte[] r2 = r4.m()
            int r1 = r2.length
            r6 = 0
        L_0x004b:
            r8 = 2048(0x800, float:2.87E-42)
            if (r5 >= r8) goto L_0x005c
            int r8 = r6 + 1
            int r9 = r5 >> 6
            r9 = r9 | 192(0xc0, float:2.69E-43)
            byte r9 = (byte) r9
            r2[r6] = r9
        L_0x0058:
            r6 = r5
            r5 = r7
            goto L_0x00de
        L_0x005c:
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r8) goto L_0x00bc
            r8 = 57343(0xdfff, float:8.0355E-41)
            if (r5 <= r8) goto L_0x0067
            goto L_0x00bc
        L_0x0067:
            r8 = 56319(0xdbff, float:7.892E-41)
            if (r5 <= r8) goto L_0x006f
            e(r5)
        L_0x006f:
            if (r7 < r0) goto L_0x0074
            e(r5)
        L_0x0074:
            int r8 = r7 + 1
            char r7 = r12.charAt(r7)
            int r5 = d(r5, r7)
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r5 <= r7) goto L_0x0086
            e(r5)
        L_0x0086:
            int r7 = r6 + 1
            int r9 = r5 >> 18
            r9 = r9 | 240(0xf0, float:3.36E-43)
            byte r9 = (byte) r9
            r2[r6] = r9
            if (r7 < r1) goto L_0x0097
            byte[] r2 = r4.m()
            int r1 = r2.length
            r7 = 0
        L_0x0097:
            int r6 = r7 + 1
            int r9 = r5 >> 12
            r9 = r9 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r2[r7] = r9
            if (r6 < r1) goto L_0x00ad
            byte[] r1 = r4.m()
            int r2 = r1.length
            r6 = 0
            r10 = r2
            r2 = r1
            r1 = r10
        L_0x00ad:
            int r7 = r6 + 1
            int r9 = r5 >> 6
            r9 = r9 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r2[r6] = r9
            r6 = r5
            r5 = r8
            r8 = r7
            goto L_0x00de
        L_0x00bc:
            int r8 = r6 + 1
            int r9 = r5 >> 12
            r9 = r9 | 224(0xe0, float:3.14E-43)
            byte r9 = (byte) r9
            r2[r6] = r9
            if (r8 < r1) goto L_0x00d0
            byte[] r1 = r4.m()
            int r2 = r1.length
            r8 = 0
            r10 = r2
            r2 = r1
            r1 = r10
        L_0x00d0:
            int r6 = r8 + 1
            int r9 = r5 >> 6
            r9 = r9 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r2[r8] = r9
            r8 = r6
            goto L_0x0058
        L_0x00de:
            if (r8 < r1) goto L_0x00e9
            byte[] r1 = r4.m()
            int r2 = r1.length
            r8 = 0
            r10 = r2
            r2 = r1
            r1 = r10
        L_0x00e9:
            int r7 = r8 + 1
            r6 = r6 & 63
            r6 = r6 | 128(0x80, float:1.794E-43)
            byte r6 = (byte) r6
            r2[r8] = r6
            r6 = r7
            goto L_0x000c
        L_0x00f5:
            if (r4 != 0) goto L_0x00fc
            byte[] r12 = java.util.Arrays.copyOfRange(r2, r3, r6)
            return r12
        L_0x00fc:
            byte[] r12 = r4.f(r6)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.g(java.lang.String):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        r7 = c(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r7 = b(r10, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r10 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r10 <= r0.length) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r10 = r0.length - r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        if (r10 <= 0) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        java.lang.System.arraycopy(r6, 0, r0, r8, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r5 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        r5 = j3.o.p(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        r0 = r5.o();
        r7 = r7 - r10;
        java.lang.System.arraycopy(r6, r10, r0, 0, r7);
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        java.lang.System.arraycopy(r6, 0, r0, r8, r7);
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r6 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r6 = f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        r9 = r7 + 1;
        r7 = r13.charAt(r7);
        r10 = r1[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (r10 >= 0) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char[] i(java.lang.String r13) {
        /*
            r12 = this;
            r0 = 30
            char[] r0 = new char[r0]
            int[] r1 = f3.a.e()
            int r2 = r1.length
            int r3 = r13.length()
            r4 = 0
            r5 = 0
            r6 = r5
            r7 = 0
            r8 = 0
        L_0x0012:
            if (r7 >= r3) goto L_0x0073
        L_0x0014:
            char r9 = r13.charAt(r7)
            if (r9 >= r2) goto L_0x0059
            r10 = r1[r9]
            if (r10 == 0) goto L_0x0059
            if (r6 != 0) goto L_0x0024
            char[] r6 = r12.f()
        L_0x0024:
            int r9 = r7 + 1
            char r7 = r13.charAt(r7)
            r10 = r1[r7]
            if (r10 >= 0) goto L_0x0033
            int r7 = r12.c(r7, r6)
            goto L_0x0037
        L_0x0033:
            int r7 = r12.b(r10, r6)
        L_0x0037:
            int r10 = r8 + r7
            int r11 = r0.length
            if (r10 <= r11) goto L_0x0053
            int r10 = r0.length
            int r10 = r10 - r8
            if (r10 <= 0) goto L_0x0043
            java.lang.System.arraycopy(r6, r4, r0, r8, r10)
        L_0x0043:
            if (r5 != 0) goto L_0x0049
            j3.o r5 = j3.o.p(r0)
        L_0x0049:
            char[] r0 = r5.o()
            int r7 = r7 - r10
            java.lang.System.arraycopy(r6, r10, r0, r4, r7)
            r8 = r7
            goto L_0x0057
        L_0x0053:
            java.lang.System.arraycopy(r6, r4, r0, r8, r7)
            r8 = r10
        L_0x0057:
            r7 = r9
            goto L_0x0012
        L_0x0059:
            int r10 = r0.length
            if (r8 < r10) goto L_0x0067
            if (r5 != 0) goto L_0x0062
            j3.o r5 = j3.o.p(r0)
        L_0x0062:
            char[] r0 = r5.o()
            r8 = 0
        L_0x0067:
            int r10 = r8 + 1
            r0[r8] = r9
            int r7 = r7 + 1
            if (r7 < r3) goto L_0x0071
            r8 = r10
            goto L_0x0073
        L_0x0071:
            r8 = r10
            goto L_0x0014
        L_0x0073:
            if (r5 != 0) goto L_0x007a
            char[] r13 = java.util.Arrays.copyOfRange(r0, r4, r8)
            return r13
        L_0x007a:
            r5.z(r8)
            char[] r13 = r5.g()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.i(java.lang.String):char[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] j(java.lang.String r11) {
        /*
            r10 = this;
            int r0 = r11.length()
            r1 = 60
            byte[] r1 = new byte[r1]
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000c:
            if (r4 >= r0) goto L_0x0106
            int[] r6 = f3.a.e()
        L_0x0012:
            char r7 = r11.charAt(r4)
            r8 = 127(0x7f, float:1.78E-43)
            if (r7 > r8) goto L_0x003b
            r9 = r6[r7]
            if (r9 == 0) goto L_0x001f
            goto L_0x003b
        L_0x001f:
            int r8 = r1.length
            if (r5 < r8) goto L_0x002d
            if (r3 != 0) goto L_0x0028
            j3.c r3 = j3.c.n(r1, r5)
        L_0x0028:
            byte[] r1 = r3.m()
            r5 = 0
        L_0x002d:
            int r8 = r5 + 1
            byte r7 = (byte) r7
            r1[r5] = r7
            int r4 = r4 + 1
            if (r4 < r0) goto L_0x0039
            r5 = r8
            goto L_0x0106
        L_0x0039:
            r5 = r8
            goto L_0x0012
        L_0x003b:
            if (r3 != 0) goto L_0x0041
            j3.c r3 = j3.c.n(r1, r5)
        L_0x0041:
            int r7 = r1.length
            if (r5 < r7) goto L_0x0049
            byte[] r1 = r3.m()
            r5 = 0
        L_0x0049:
            int r7 = r4 + 1
            char r4 = r11.charAt(r4)
            if (r4 > r8) goto L_0x005d
            r1 = r6[r4]
            int r5 = r10.a(r4, r1, r3, r5)
            byte[] r1 = r3.q()
            r4 = r7
            goto L_0x000c
        L_0x005d:
            r6 = 2047(0x7ff, float:2.868E-42)
            if (r4 > r6) goto L_0x0072
            int r6 = r5 + 1
            int r8 = r4 >> 6
            r8 = r8 | 192(0xc0, float:2.69E-43)
            byte r8 = (byte) r8
            r1[r5] = r8
            r4 = r4 & 63
            r4 = r4 | 128(0x80, float:1.794E-43)
        L_0x006e:
            r5 = r4
            r4 = r7
            goto L_0x00f6
        L_0x0072:
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r6) goto L_0x00d3
            r6 = 57343(0xdfff, float:8.0355E-41)
            if (r4 <= r6) goto L_0x007d
            goto L_0x00d3
        L_0x007d:
            r6 = 56319(0xdbff, float:7.892E-41)
            if (r4 <= r6) goto L_0x0085
            e(r4)
        L_0x0085:
            if (r7 < r0) goto L_0x008a
            e(r4)
        L_0x008a:
            int r6 = r7 + 1
            char r7 = r11.charAt(r7)
            int r4 = d(r4, r7)
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r7) goto L_0x009c
            e(r4)
        L_0x009c:
            int r7 = r5 + 1
            int r8 = r4 >> 18
            r8 = r8 | 240(0xf0, float:3.36E-43)
            byte r8 = (byte) r8
            r1[r5] = r8
            int r5 = r1.length
            if (r7 < r5) goto L_0x00ad
            byte[] r1 = r3.m()
            r7 = 0
        L_0x00ad:
            int r5 = r7 + 1
            int r8 = r4 >> 12
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.794E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            int r7 = r1.length
            if (r5 < r7) goto L_0x00c0
            byte[] r1 = r3.m()
            r5 = 0
        L_0x00c0:
            int r7 = r5 + 1
            int r8 = r4 >> 6
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.794E-43)
            byte r8 = (byte) r8
            r1[r5] = r8
            r4 = r4 & 63
            r4 = r4 | 128(0x80, float:1.794E-43)
            r5 = r4
            r4 = r6
            r6 = r7
            goto L_0x00f6
        L_0x00d3:
            int r6 = r5 + 1
            int r8 = r4 >> 12
            r8 = r8 | 224(0xe0, float:3.14E-43)
            byte r8 = (byte) r8
            r1[r5] = r8
            int r5 = r1.length
            if (r6 < r5) goto L_0x00e4
            byte[] r1 = r3.m()
            r6 = 0
        L_0x00e4:
            int r5 = r6 + 1
            int r8 = r4 >> 6
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.794E-43)
            byte r8 = (byte) r8
            r1[r6] = r8
            r4 = r4 & 63
            r4 = r4 | 128(0x80, float:1.794E-43)
            r6 = r5
            goto L_0x006e
        L_0x00f6:
            int r7 = r1.length
            if (r6 < r7) goto L_0x00fe
            byte[] r1 = r3.m()
            r6 = 0
        L_0x00fe:
            int r7 = r6 + 1
            byte r5 = (byte) r5
            r1[r6] = r5
            r5 = r7
            goto L_0x000c
        L_0x0106:
            if (r3 != 0) goto L_0x010d
            byte[] r11 = java.util.Arrays.copyOfRange(r1, r2, r5)
            return r11
        L_0x010d:
            byte[] r11 = r3.f(r5)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.j(java.lang.String):byte[]");
    }
}
