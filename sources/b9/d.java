package b9;

import javax.security.auth.x500.X500Principal;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f11273a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11274b;

    /* renamed from: c  reason: collision with root package name */
    public int f11275c;

    /* renamed from: d  reason: collision with root package name */
    public int f11276d;

    /* renamed from: e  reason: collision with root package name */
    public int f11277e;

    /* renamed from: f  reason: collision with root package name */
    public int f11278f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f11279g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f11273a = name;
        this.f11274b = name.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        return new java.lang.String(r1, r2, r8.f11278f - r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f11275c
            r8.f11276d = r0
            r8.f11277e = r0
        L_0x0006:
            int r0 = r8.f11275c
            int r1 = r8.f11274b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f11279g
            int r2 = r8.f11276d
            int r3 = r8.f11277e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.f11279g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x005c
            if (r2 == r5) goto L_0x0051
            r5 = 92
            if (r2 == r5) goto L_0x003e
            if (r2 == r4) goto L_0x0051
            if (r2 == r3) goto L_0x0051
            int r3 = r8.f11277e
            int r4 = r3 + 1
            r8.f11277e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f11275c = r0
            goto L_0x0006
        L_0x003e:
            int r0 = r8.f11277e
            int r2 = r0 + 1
            r8.f11277e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f11275c
            int r0 = r0 + 1
            r8.f11275c = r0
            goto L_0x0006
        L_0x0051:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f11276d
            int r3 = r8.f11277e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x005c:
            int r2 = r8.f11277e
            r8.f11278f = r2
            int r0 = r0 + 1
            r8.f11275c = r0
            int r0 = r2 + 1
            r8.f11277e = r0
            r1[r2] = r6
        L_0x006a:
            int r0 = r8.f11275c
            int r1 = r8.f11274b
            if (r0 >= r1) goto L_0x0083
            char[] r2 = r8.f11279g
            char r7 = r2[r0]
            if (r7 != r6) goto L_0x0083
            int r1 = r8.f11277e
            int r7 = r1 + 1
            r8.f11277e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f11275c = r0
            goto L_0x006a
        L_0x0083:
            if (r0 == r1) goto L_0x008f
            char[] r1 = r8.f11279g
            char r0 = r1[r0]
            if (r0 == r3) goto L_0x008f
            if (r0 == r4) goto L_0x008f
            if (r0 != r5) goto L_0x0006
        L_0x008f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f11279g
            int r2 = r8.f11276d
            int r3 = r8.f11278f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.d.a():java.lang.String");
    }

    public String b(String str) {
        String str2;
        this.f11275c = 0;
        this.f11276d = 0;
        this.f11277e = 0;
        this.f11278f = 0;
        this.f11279g = this.f11273a.toCharArray();
        String g10 = g();
        if (g10 == null) {
            return null;
        }
        do {
            int i10 = this.f11275c;
            if (i10 == this.f11274b) {
                return null;
            }
            char c10 = this.f11279g[i10];
            if (c10 == '\"') {
                str2 = h();
            } else if (c10 == '#') {
                str2 = f();
            } else if (c10 == '+' || c10 == ',' || c10 == ';') {
                str2 = "";
            } else {
                str2 = a();
            }
            if (str.equalsIgnoreCase(g10)) {
                return str2;
            }
            int i11 = this.f11275c;
            if (i11 >= this.f11274b) {
                return null;
            }
            char c11 = this.f11279g[i11];
            if (c11 == ',' || c11 == ';' || c11 == '+') {
                this.f11275c = i11 + 1;
                g10 = g();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f11273a);
            }
        } while (g10 != null);
        throw new IllegalStateException("Malformed DN: " + this.f11273a);
    }

    public final int c(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 < this.f11274b) {
            char[] cArr = this.f11279g;
            char c10 = cArr[i10];
            if (c10 >= '0' && c10 <= '9') {
                i11 = c10 - '0';
            } else if (c10 >= 'a' && c10 <= 'f') {
                i11 = c10 - 'W';
            } else if (c10 < 'A' || c10 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f11273a);
            } else {
                i11 = c10 - '7';
            }
            char c11 = cArr[i13];
            if (c11 >= '0' && c11 <= '9') {
                i12 = c11 - '0';
            } else if (c11 >= 'a' && c11 <= 'f') {
                i12 = c11 - 'W';
            } else if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f11273a);
            } else {
                i12 = c11 - '7';
            }
            return (i11 << 4) + i12;
        }
        throw new IllegalStateException("Malformed DN: " + this.f11273a);
    }

    public final char d() {
        int i10 = this.f11275c + 1;
        this.f11275c = i10;
        if (i10 != this.f11274b) {
            char c10 = this.f11279g[i10];
            if (c10 == ' ' || c10 == '%' || c10 == '\\' || c10 == '_' || c10 == '\"' || c10 == '#') {
                return c10;
            }
            switch (c10) {
                case '*':
                case '+':
                case ',':
                    return c10;
                default:
                    switch (c10) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            return c10;
                        default:
                            return e();
                    }
            }
        } else {
            throw new IllegalStateException("Unexpected end of DN: " + this.f11273a);
        }
    }

    public final char e() {
        int i10;
        int i11;
        int c10 = c(this.f11275c);
        this.f11275c++;
        if (c10 < 128) {
            return (char) c10;
        }
        if (c10 < 192 || c10 > 247) {
            return '?';
        }
        if (c10 <= 223) {
            i11 = c10 & 31;
            i10 = 1;
        } else if (c10 <= 239) {
            i11 = c10 & 15;
            i10 = 2;
        } else {
            i11 = c10 & 7;
            i10 = 3;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = this.f11275c + 1;
            this.f11275c = i13;
            if (i13 == this.f11274b || this.f11279g[i13] != '\\') {
                return '?';
            }
            int i14 = i13 + 1;
            this.f11275c = i14;
            int c11 = c(i14);
            this.f11275c++;
            if ((c11 & 192) != 128) {
                return '?';
            }
            i11 = (i11 << 6) + (c11 & 63);
        }
        return (char) i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r1 = r6.f11279g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f() {
        /*
            r6 = this;
            int r0 = r6.f11275c
            int r1 = r0 + 4
            int r2 = r6.f11274b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L_0x0098
            r6.f11276d = r0
            int r0 = r0 + 1
            r6.f11275c = r0
        L_0x0010:
            int r0 = r6.f11275c
            int r1 = r6.f11274b
            if (r0 == r1) goto L_0x0054
            char[] r1 = r6.f11279g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L_0x0054
            r4 = 44
            if (r2 == r4) goto L_0x0054
            r4 = 59
            if (r2 != r4) goto L_0x0027
            goto L_0x0054
        L_0x0027:
            r4 = 32
            if (r2 != r4) goto L_0x0042
            r6.f11277e = r0
            int r0 = r0 + 1
            r6.f11275c = r0
        L_0x0031:
            int r0 = r6.f11275c
            int r1 = r6.f11274b
            if (r0 >= r1) goto L_0x0056
            char[] r1 = r6.f11279g
            char r1 = r1[r0]
            if (r1 != r4) goto L_0x0056
            int r0 = r0 + 1
            r6.f11275c = r0
            goto L_0x0031
        L_0x0042:
            r4 = 65
            if (r2 < r4) goto L_0x004f
            r4 = 70
            if (r2 > r4) goto L_0x004f
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
        L_0x004f:
            int r0 = r0 + 1
            r6.f11275c = r0
            goto L_0x0010
        L_0x0054:
            r6.f11277e = r0
        L_0x0056:
            int r0 = r6.f11277e
            int r1 = r6.f11276d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L_0x0081
            r2 = r0 & 1
            if (r2 == 0) goto L_0x0081
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L_0x0069:
            if (r4 >= r2) goto L_0x0077
            int r5 = r6.c(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L_0x0069
        L_0x0077:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f11279g
            int r3 = r6.f11276d
            r1.<init>(r2, r3, r0)
            return r1
        L_0x0081:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f11273a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0098:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f11273a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto L_0x00b0
        L_0x00af:
            throw r0
        L_0x00b0:
            goto L_0x00af
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.d.f():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String g() {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r6.f11275c
            int r1 = r6.f11274b
            r2 = 32
            if (r0 >= r1) goto L_0x0013
            char[] r3 = r6.f11279g
            char r3 = r3[r0]
            if (r3 != r2) goto L_0x0013
            int r0 = r0 + 1
            r6.f11275c = r0
            goto L_0x0000
        L_0x0013:
            if (r0 != r1) goto L_0x0017
            r0 = 0
            return r0
        L_0x0017:
            r6.f11276d = r0
            int r0 = r0 + 1
            r6.f11275c = r0
        L_0x001d:
            int r0 = r6.f11275c
            int r1 = r6.f11274b
            r3 = 61
            if (r0 >= r1) goto L_0x0032
            char[] r4 = r6.f11279g
            char r4 = r4[r0]
            if (r4 == r3) goto L_0x0032
            if (r4 == r2) goto L_0x0032
            int r0 = r0 + 1
            r6.f11275c = r0
            goto L_0x001d
        L_0x0032:
            java.lang.String r4 = "Unexpected end of DN: "
            if (r0 >= r1) goto L_0x00d3
            r6.f11277e = r0
            char[] r1 = r6.f11279g
            char r0 = r1[r0]
            if (r0 != r2) goto L_0x0071
        L_0x003e:
            int r0 = r6.f11275c
            int r1 = r6.f11274b
            if (r0 >= r1) goto L_0x0051
            char[] r5 = r6.f11279g
            char r5 = r5[r0]
            if (r5 == r3) goto L_0x0051
            if (r5 != r2) goto L_0x0051
            int r0 = r0 + 1
            r6.f11275c = r0
            goto L_0x003e
        L_0x0051:
            char[] r5 = r6.f11279g
            char r5 = r5[r0]
            if (r5 != r3) goto L_0x005a
            if (r0 == r1) goto L_0x005a
            goto L_0x0071
        L_0x005a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r6.f11273a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0071:
            int r0 = r6.f11275c
            int r0 = r0 + 1
            r6.f11275c = r0
        L_0x0077:
            int r0 = r6.f11275c
            int r1 = r6.f11274b
            if (r0 >= r1) goto L_0x0088
            char[] r1 = r6.f11279g
            char r1 = r1[r0]
            if (r1 != r2) goto L_0x0088
            int r0 = r0 + 1
            r6.f11275c = r0
            goto L_0x0077
        L_0x0088:
            int r0 = r6.f11277e
            int r1 = r6.f11276d
            int r2 = r0 - r1
            r3 = 4
            if (r2 <= r3) goto L_0x00c8
            char[] r2 = r6.f11279g
            int r4 = r1 + 3
            char r4 = r2[r4]
            r5 = 46
            if (r4 != r5) goto L_0x00c8
            char r4 = r2[r1]
            r5 = 79
            if (r4 == r5) goto L_0x00a5
            r5 = 111(0x6f, float:1.56E-43)
            if (r4 != r5) goto L_0x00c8
        L_0x00a5:
            int r4 = r1 + 1
            char r4 = r2[r4]
            r5 = 73
            if (r4 == r5) goto L_0x00b5
            int r4 = r1 + 1
            char r4 = r2[r4]
            r5 = 105(0x69, float:1.47E-43)
            if (r4 != r5) goto L_0x00c8
        L_0x00b5:
            int r4 = r1 + 2
            char r4 = r2[r4]
            r5 = 68
            if (r4 == r5) goto L_0x00c5
            int r4 = r1 + 2
            char r2 = r2[r4]
            r4 = 100
            if (r2 != r4) goto L_0x00c8
        L_0x00c5:
            int r1 = r1 + r3
            r6.f11276d = r1
        L_0x00c8:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f11279g
            int r3 = r6.f11276d
            int r0 = r0 - r3
            r1.<init>(r2, r3, r0)
            return r1
        L_0x00d3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r6.f11273a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto L_0x00eb
        L_0x00ea:
            throw r0
        L_0x00eb:
            goto L_0x00ea
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.d.g():java.lang.String");
    }

    public final String h() {
        int i10 = this.f11275c + 1;
        this.f11275c = i10;
        this.f11276d = i10;
        this.f11277e = i10;
        while (true) {
            int i11 = this.f11275c;
            if (i11 != this.f11274b) {
                char[] cArr = this.f11279g;
                char c10 = cArr[i11];
                if (c10 == '\"') {
                    this.f11275c = i11 + 1;
                    while (true) {
                        int i12 = this.f11275c;
                        if (i12 >= this.f11274b || this.f11279g[i12] != ' ') {
                            char[] cArr2 = this.f11279g;
                            int i13 = this.f11276d;
                        } else {
                            this.f11275c = i12 + 1;
                        }
                    }
                    char[] cArr22 = this.f11279g;
                    int i132 = this.f11276d;
                    return new String(cArr22, i132, this.f11277e - i132);
                }
                if (c10 == '\\') {
                    cArr[this.f11277e] = d();
                } else {
                    cArr[this.f11277e] = c10;
                }
                this.f11275c++;
                this.f11277e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f11273a);
            }
        }
    }
}
