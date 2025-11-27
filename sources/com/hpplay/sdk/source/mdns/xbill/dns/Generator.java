package com.hpplay.sdk.source.mdns.xbill.dns;

import com.raizlabs.android.dbflow.sql.language.Operator;

public class Generator {
    private long current;
    public final int dclass;
    public long end;
    public final String namePattern;
    public final Name origin;
    public final String rdataPattern;
    public long start;
    public long step;
    public final long ttl;
    public final int type;

    public Generator(long j10, long j11, long j12, String str, int i10, int i11, long j13, String str2, Name name) {
        long j14 = j10;
        long j15 = j11;
        long j16 = j12;
        if (j14 < 0 || j15 < 0 || j14 > j15 || j16 <= 0) {
            throw new IllegalArgumentException("invalid range specification");
        } else if (supportedType(i10)) {
            DClass.check(i11);
            this.start = j14;
            this.end = j15;
            this.step = j16;
            this.namePattern = str;
            this.type = i10;
            this.dclass = i11;
            this.ttl = j13;
            this.rdataPattern = str2;
            this.origin = name;
            this.current = j14;
        } else {
            throw new IllegalArgumentException("unsupported type");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008f, code lost:
        throw new java.lang.Exception("invalid offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bd, code lost:
        throw new java.lang.Exception("invalid width");
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String substitute(java.lang.String r19, long r20) {
        /*
            r18 = this;
            byte[] r0 = r19.getBytes()
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r3 = 0
            r4 = 0
        L_0x000b:
            int r5 = r0.length
            if (r3 >= r5) goto L_0x016b
            byte r5 = r0[r3]
            r5 = r5 & 255(0xff, float:3.57E-43)
            char r5 = (char) r5
            if (r4 == 0) goto L_0x001c
            r1.append(r5)
            r2 = 1
            r4 = 0
            goto L_0x0168
        L_0x001c:
            r7 = 92
            if (r5 != r7) goto L_0x0031
            int r4 = r3 + 1
            int r5 = r0.length
            if (r4 == r5) goto L_0x0029
            r2 = 1
            r4 = 1
            goto L_0x0168
        L_0x0029:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "invalid escape character"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r7 = 36
            if (r5 != r7) goto L_0x0164
            int r8 = r3 + 1
            int r9 = r0.length
            if (r8 >= r9) goto L_0x0047
            byte r9 = r0[r8]
            if (r9 != r7) goto L_0x0047
            r3 = r9 & 255(0xff, float:3.57E-43)
            char r3 = (char) r3
            r1.append(r3)
        L_0x0044:
            r3 = r8
            goto L_0x0167
        L_0x0047:
            int r7 = r0.length
            r13 = 10
            r2 = 48
            if (r8 >= r7) goto L_0x010b
            byte r7 = r0[r8]
            r11 = 123(0x7b, float:1.72E-43)
            if (r7 != r11) goto L_0x010b
            int r3 = r8 + 1
            int r7 = r0.length
            if (r3 >= r7) goto L_0x0062
            byte r7 = r0[r3]
            r11 = 45
            if (r7 != r11) goto L_0x0062
            r8 = r3
            r3 = 1
            goto L_0x0063
        L_0x0062:
            r3 = 0
        L_0x0063:
            r11 = 0
        L_0x0065:
            int r7 = r8 + 1
            int r9 = r0.length
            r10 = 57
            r15 = 125(0x7d, float:1.75E-43)
            r6 = 44
            if (r7 < r9) goto L_0x0071
            goto L_0x0091
        L_0x0071:
            byte r5 = r0[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            char r5 = (char) r5
            if (r5 == r6) goto L_0x0090
            if (r5 != r15) goto L_0x007b
            goto L_0x0090
        L_0x007b:
            if (r5 < r2) goto L_0x0088
            if (r5 > r10) goto L_0x0088
            int r5 = r5 + -48
            char r5 = (char) r5
            long r11 = r11 * r13
            long r8 = (long) r5
            long r11 = r11 + r8
            r8 = r7
            goto L_0x0065
        L_0x0088:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "invalid offset"
            r0.<init>(r1)
            throw r0
        L_0x0090:
            r8 = r7
        L_0x0091:
            if (r3 == 0) goto L_0x0094
            long r11 = -r11
        L_0x0094:
            r16 = 0
            if (r5 != r6) goto L_0x00bf
        L_0x0098:
            int r3 = r8 + 1
            int r7 = r0.length
            if (r3 < r7) goto L_0x009e
            goto L_0x00bf
        L_0x009e:
            byte r5 = r0[r3]
            r5 = r5 & 255(0xff, float:3.57E-43)
            char r5 = (char) r5
            if (r5 == r6) goto L_0x00be
            if (r5 != r15) goto L_0x00a8
            goto L_0x00be
        L_0x00a8:
            if (r5 < r2) goto L_0x00b6
            if (r5 > r10) goto L_0x00b6
            int r5 = r5 + -48
            char r5 = (char) r5
            long r16 = r16 * r13
            long r7 = (long) r5
            long r16 = r16 + r7
            r8 = r3
            goto L_0x0098
        L_0x00b6:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "invalid width"
            r0.<init>(r1)
            throw r0
        L_0x00be:
            r8 = r3
        L_0x00bf:
            if (r5 != r6) goto L_0x00f6
            int r8 = r8 + 1
            int r3 = r0.length
            java.lang.String r5 = "invalid base"
            if (r8 == r3) goto L_0x00f0
            byte r3 = r0[r8]
            r3 = r3 & 255(0xff, float:3.57E-43)
            char r3 = (char) r3
            r6 = 111(0x6f, float:1.56E-43)
            if (r3 != r6) goto L_0x00d6
            r3 = 0
            r5 = 1
            r13 = 8
            goto L_0x00f8
        L_0x00d6:
            r6 = 120(0x78, float:1.68E-43)
            if (r3 != r6) goto L_0x00df
            r3 = 0
        L_0x00db:
            r5 = 1
            r13 = 16
            goto L_0x00f8
        L_0x00df:
            r6 = 88
            if (r3 != r6) goto L_0x00e5
            r3 = 1
            goto L_0x00db
        L_0x00e5:
            r6 = 100
            if (r3 != r6) goto L_0x00ea
            goto L_0x00f6
        L_0x00ea:
            java.lang.Exception r0 = new java.lang.Exception
            r0.<init>(r5)
            throw r0
        L_0x00f0:
            java.lang.Exception r0 = new java.lang.Exception
            r0.<init>(r5)
            throw r0
        L_0x00f6:
            r3 = 0
            r5 = 1
        L_0x00f8:
            int r8 = r8 + r5
            int r5 = r0.length
            if (r8 == r5) goto L_0x0103
            byte r5 = r0[r8]
            if (r5 != r15) goto L_0x0103
            r5 = r16
            goto L_0x0111
        L_0x0103:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "invalid modifiers"
            r0.<init>(r1)
            throw r0
        L_0x010b:
            r8 = r3
            r3 = 0
            r5 = 0
            r11 = 0
        L_0x0111:
            long r9 = r20 + r11
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x015c
            r11 = 8
            int r7 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0124
            java.lang.String r7 = java.lang.Long.toOctalString(r9)
            goto L_0x0133
        L_0x0124:
            r11 = 16
            int r7 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x012f
            java.lang.String r7 = java.lang.Long.toHexString(r9)
            goto L_0x0133
        L_0x012f:
            java.lang.String r7 = java.lang.Long.toString(r9)
        L_0x0133:
            if (r3 == 0) goto L_0x0139
            java.lang.String r7 = r7.toUpperCase()
        L_0x0139:
            r9 = 0
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x0157
            int r3 = r7.length()
            long r9 = (long) r3
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x0157
            int r3 = (int) r5
            int r5 = r7.length()
            int r3 = r3 - r5
        L_0x014e:
            int r5 = r3 + -1
            if (r3 <= 0) goto L_0x0157
            r1.append(r2)
            r3 = r5
            goto L_0x014e
        L_0x0157:
            r1.append(r7)
            goto L_0x0044
        L_0x015c:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "invalid offset expansion"
            r0.<init>(r1)
            throw r0
        L_0x0164:
            r1.append(r5)
        L_0x0167:
            r2 = 1
        L_0x0168:
            int r3 = r3 + r2
            goto L_0x000b
        L_0x016b:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Generator.substitute(java.lang.String, long):java.lang.String");
    }

    public static boolean supportedType(int i10) {
        Type.check(i10);
        if (i10 == 12 || i10 == 5 || i10 == 39 || i10 == 1 || i10 == 28 || i10 == 2) {
            return true;
        }
        return false;
    }

    public Record nextRecord() {
        long j10 = this.current;
        if (j10 > this.end) {
            return null;
        }
        Name fromString = Name.fromString(substitute(this.namePattern, j10), this.origin);
        String substitute = substitute(this.rdataPattern, this.current);
        this.current += this.step;
        return Record.fromString(fromString, this.type, this.dclass, this.ttl, substitute, this.origin);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("$GENERATE ");
        stringBuffer.append(this.start + Operator.Operation.MINUS + this.end);
        if (this.step > 1) {
            stringBuffer.append(Operator.Operation.DIVISION + this.step);
        }
        stringBuffer.append(" ");
        stringBuffer.append(this.namePattern + " ");
        stringBuffer.append(this.ttl + " ");
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            stringBuffer.append(DClass.string(this.dclass) + " ");
        }
        stringBuffer.append(Type.string(this.type) + " ");
        stringBuffer.append(this.rdataPattern + " ");
        return stringBuffer.toString();
    }
}
