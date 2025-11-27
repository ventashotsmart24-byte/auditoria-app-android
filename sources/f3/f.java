package f3;

import java.math.BigDecimal;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6586a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* renamed from: b  reason: collision with root package name */
    public static final String f6587b = String.valueOf(Long.MAX_VALUE);

    public static NumberFormatException a(String str) {
        return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal");
    }

    public static boolean b(String str, boolean z10) {
        String str2;
        if (z10) {
            str2 = f6586a;
        } else {
            str2 = f6587b;
        }
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        int i10 = 0;
        while (i10 < length) {
            int charAt = str.charAt(i10) - str2.charAt(i10);
            if (charAt == 0) {
                i10++;
            } else if (charAt < 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean c(char[] cArr, int i10, int i11, boolean z10) {
        String str;
        if (z10) {
            str = f6586a;
        } else {
            str = f6587b;
        }
        int length = str.length();
        if (i11 < length) {
            return true;
        }
        if (i11 > length) {
            return false;
        }
        int i12 = 0;
        while (i12 < length) {
            int charAt = cArr[i10 + i12] - str.charAt(i12);
            if (charAt == 0) {
                i12++;
            } else if (charAt < 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r5 = r5.trim();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int d(java.lang.String r5, int r6) {
        /*
            if (r5 != 0) goto L_0x0003
            return r6
        L_0x0003:
            java.lang.String r5 = r5.trim()
            int r0 = r5.length()
            if (r0 != 0) goto L_0x000e
            return r6
        L_0x000e:
            r1 = 0
            char r2 = r5.charAt(r1)
            r3 = 43
            r4 = 1
            if (r2 != r3) goto L_0x0021
            java.lang.String r5 = r5.substring(r4)
            int r0 = r5.length()
            goto L_0x0026
        L_0x0021:
            r3 = 45
            if (r2 != r3) goto L_0x0026
            r1 = 1
        L_0x0026:
            if (r1 >= r0) goto L_0x003f
            char r2 = r5.charAt(r1)
            r3 = 57
            if (r2 > r3) goto L_0x0038
            r3 = 48
            if (r2 >= r3) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            int r1 = r1 + 1
            goto L_0x0026
        L_0x0038:
            double r5 = i(r5)     // Catch:{ NumberFormatException -> 0x003e }
            int r5 = (int) r5
            return r5
        L_0x003e:
            return r6
        L_0x003f:
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x0044 }
            return r5
        L_0x0044:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.f.d(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r5 = r5.trim();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long e(java.lang.String r5, long r6) {
        /*
            if (r5 != 0) goto L_0x0003
            return r6
        L_0x0003:
            java.lang.String r5 = r5.trim()
            int r0 = r5.length()
            if (r0 != 0) goto L_0x000e
            return r6
        L_0x000e:
            r1 = 0
            char r2 = r5.charAt(r1)
            r3 = 43
            r4 = 1
            if (r2 != r3) goto L_0x0021
            java.lang.String r5 = r5.substring(r4)
            int r0 = r5.length()
            goto L_0x0026
        L_0x0021:
            r3 = 45
            if (r2 != r3) goto L_0x0026
            r1 = 1
        L_0x0026:
            if (r1 >= r0) goto L_0x003f
            char r2 = r5.charAt(r1)
            r3 = 57
            if (r2 > r3) goto L_0x0038
            r3 = 48
            if (r2 >= r3) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            int r1 = r1 + 1
            goto L_0x0026
        L_0x0038:
            double r5 = i(r5)     // Catch:{ NumberFormatException -> 0x003e }
            long r5 = (long) r5
            return r5
        L_0x003e:
            return r6
        L_0x003f:
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x0044 }
            return r5
        L_0x0044:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.f.e(java.lang.String, long):long");
    }

    public static BigDecimal f(String str) {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            throw a(str);
        }
    }

    public static BigDecimal g(char[] cArr) {
        return h(cArr, 0, cArr.length);
    }

    public static BigDecimal h(char[] cArr, int i10, int i11) {
        try {
            return new BigDecimal(cArr, i10, i11);
        } catch (NumberFormatException unused) {
            throw a(new String(cArr, i10, i11));
        }
    }

    public static double i(String str) {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0073, code lost:
        return java.lang.Integer.parseInt(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int j(java.lang.String r8) {
        /*
            r0 = 0
            char r1 = r8.charAt(r0)
            int r2 = r8.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto L_0x000f
            r0 = 1
        L_0x000f:
            r3 = 10
            if (r0 == 0) goto L_0x0023
            if (r2 == r4) goto L_0x001e
            if (r2 <= r3) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            char r1 = r8.charAt(r4)
            r4 = 2
            goto L_0x002c
        L_0x001e:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L_0x0023:
            r5 = 9
            if (r2 <= r5) goto L_0x002c
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L_0x002c:
            r5 = 57
            if (r1 > r5) goto L_0x0082
            r6 = 48
            if (r1 >= r6) goto L_0x0035
            goto L_0x0082
        L_0x0035:
            int r1 = r1 - r6
            if (r4 >= r2) goto L_0x007e
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L_0x0079
            if (r4 >= r6) goto L_0x0043
            goto L_0x0079
        L_0x0043:
            int r1 = r1 * 10
            int r4 = r4 - r6
            int r1 = r1 + r4
            if (r7 >= r2) goto L_0x007e
            int r4 = r7 + 1
            char r7 = r8.charAt(r7)
            if (r7 > r5) goto L_0x0074
            if (r7 >= r6) goto L_0x0054
            goto L_0x0074
        L_0x0054:
            int r1 = r1 * 10
            int r7 = r7 - r6
            int r1 = r1 + r7
            if (r4 >= r2) goto L_0x007e
        L_0x005a:
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L_0x006f
            if (r4 >= r6) goto L_0x0065
            goto L_0x006f
        L_0x0065:
            int r1 = r1 * 10
            int r4 = r4 + -48
            int r1 = r1 + r4
            if (r7 < r2) goto L_0x006d
            goto L_0x007e
        L_0x006d:
            r4 = r7
            goto L_0x005a
        L_0x006f:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L_0x0074:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L_0x0079:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L_0x007e:
            if (r0 == 0) goto L_0x0081
            int r1 = -r1
        L_0x0081:
            return r1
        L_0x0082:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.f.j(java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return r0 + ((r2[r3] - '0') * 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        r0 = r0 + ((r2[r3] - '0') * 10000000);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0026, code lost:
        r0 = r0 + ((r2[r3] - '0') * com.uc.crashsdk.export.CrashStatKey.STATS_REPORT_FINISHED);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0033, code lost:
        r0 = r0 + ((r2[r3] - '0') * 100000);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0040, code lost:
        r0 = r0 + ((r2[r3] - '0') * 10000);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004a, code lost:
        r0 = r0 + ((r2[r3] - '0') * 1000);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0054, code lost:
        r0 = r0 + ((r2[r3] - '0') * 100);
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int k(char[] r2, int r3, int r4) {
        /*
            int r0 = r3 + r4
            int r0 = r0 + -1
            char r0 = r2[r0]
            int r0 = r0 + -48
            switch(r4) {
                case 2: goto L_0x005e;
                case 3: goto L_0x0054;
                case 4: goto L_0x004a;
                case 5: goto L_0x0040;
                case 6: goto L_0x0033;
                case 7: goto L_0x0026;
                case 8: goto L_0x0019;
                case 9: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0065
        L_0x000c:
            int r4 = r3 + 1
            char r3 = r2[r3]
            int r3 = r3 + -48
            r1 = 100000000(0x5f5e100, float:2.3122341E-35)
            int r3 = r3 * r1
            int r0 = r0 + r3
            r3 = r4
        L_0x0019:
            int r4 = r3 + 1
            char r3 = r2[r3]
            int r3 = r3 + -48
            r1 = 10000000(0x989680, float:1.4012985E-38)
            int r3 = r3 * r1
            int r0 = r0 + r3
            r3 = r4
        L_0x0026:
            int r4 = r3 + 1
            char r3 = r2[r3]
            int r3 = r3 + -48
            r1 = 1000000(0xf4240, float:1.401298E-39)
            int r3 = r3 * r1
            int r0 = r0 + r3
            r3 = r4
        L_0x0033:
            int r4 = r3 + 1
            char r3 = r2[r3]
            int r3 = r3 + -48
            r1 = 100000(0x186a0, float:1.4013E-40)
            int r3 = r3 * r1
            int r0 = r0 + r3
            r3 = r4
        L_0x0040:
            int r4 = r3 + 1
            char r3 = r2[r3]
            int r3 = r3 + -48
            int r3 = r3 * 10000
            int r0 = r0 + r3
            r3 = r4
        L_0x004a:
            int r4 = r3 + 1
            char r3 = r2[r3]
            int r3 = r3 + -48
            int r3 = r3 * 1000
            int r0 = r0 + r3
            r3 = r4
        L_0x0054:
            int r4 = r3 + 1
            char r3 = r2[r3]
            int r3 = r3 + -48
            int r3 = r3 * 100
            int r0 = r0 + r3
            r3 = r4
        L_0x005e:
            char r2 = r2[r3]
            int r2 = r2 + -48
            int r2 = r2 * 10
            int r0 = r0 + r2
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.f.k(char[], int, int):int");
    }

    public static long l(String str) {
        if (str.length() <= 9) {
            return (long) j(str);
        }
        return Long.parseLong(str);
    }

    public static long m(char[] cArr, int i10, int i11) {
        int i12 = i11 - 9;
        return (((long) k(cArr, i10, i12)) * 1000000000) + ((long) k(cArr, i10 + i12, 9));
    }
}
