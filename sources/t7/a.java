package t7;

import u7.c;

public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f19553b = new byte[256];

    /* renamed from: a  reason: collision with root package name */
    public byte[] f19554a = new byte[4];

    static {
        for (int i10 = 0; i10 < 255; i10++) {
            f19553b[i10] = -1;
        }
    }

    public int a() {
        return 4;
    }

    public int b() {
        return 72;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.io.PushbackInputStream r10, java.io.OutputStream r11, int r12) {
        /*
            r9 = this;
            r0 = 64
            char[] r1 = new char[r0]
            r1 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47} // fill-array
            r2 = 0
            r3 = 0
        L_0x0009:
            if (r3 >= r0) goto L_0x0015
            byte[] r4 = f19553b
            char r5 = r1[r3]
            byte r6 = (byte) r3
            r4[r5] = r6
            int r3 = r3 + 1
            goto L_0x0009
        L_0x0015:
            r0 = 2
            if (r12 < r0) goto L_0x00e0
        L_0x0018:
            int r1 = r10.read()
            r3 = -1
            if (r1 == r3) goto L_0x00da
            r4 = 10
            if (r1 == r4) goto L_0x0018
            r4 = 13
            if (r1 == r4) goto L_0x0018
            byte[] r4 = r9.f19554a
            byte r1 = (byte) r1
            r4[r2] = r1
            int r1 = r12 + -1
            r5 = 1
            int r10 = r9.j(r10, r4, r5, r1)
            if (r10 == r3) goto L_0x00d4
            r10 = 61
            r1 = 3
            if (r12 <= r1) goto L_0x0041
            byte[] r4 = r9.f19554a
            byte r4 = r4[r1]
            if (r4 != r10) goto L_0x0041
            r12 = 3
        L_0x0041:
            if (r12 <= r0) goto L_0x004a
            byte[] r4 = r9.f19554a
            byte r4 = r4[r0]
            if (r4 != r10) goto L_0x004a
            r12 = 2
        L_0x004a:
            r10 = 4
            if (r12 == r0) goto L_0x006d
            if (r12 == r1) goto L_0x005f
            if (r12 == r10) goto L_0x0055
            r2 = -1
            r4 = -1
            r5 = -1
            goto L_0x0081
        L_0x0055:
            byte[] r3 = f19553b
            byte[] r4 = r9.f19554a
            byte r4 = r4[r1]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r3 = r3[r4]
        L_0x005f:
            byte[] r4 = f19553b
            byte[] r6 = r9.f19554a
            byte r6 = r6[r0]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r4 = r4[r6]
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x006e
        L_0x006d:
            r4 = -1
        L_0x006e:
            byte[] r6 = f19553b
            byte[] r7 = r9.f19554a
            byte r5 = r7[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = r6[r5]
            byte r2 = r7[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = r6[r2]
            r8 = r3
            r3 = r2
            r2 = r8
        L_0x0081:
            if (r12 == r0) goto L_0x00c7
            if (r12 == r1) goto L_0x00ad
            if (r12 == r10) goto L_0x0088
            goto L_0x00d3
        L_0x0088:
            int r12 = r3 << 2
            r12 = r12 & 252(0xfc, float:3.53E-43)
            int r0 = r5 >>> 4
            r0 = r0 & r1
            r12 = r12 | r0
            byte r12 = (byte) r12
            r11.write(r12)
            int r10 = r5 << 4
            r10 = r10 & 240(0xf0, float:3.36E-43)
            int r12 = r2 >>> 2
            r12 = r12 & 15
            r10 = r10 | r12
            byte r10 = (byte) r10
            r11.write(r10)
            int r10 = r2 << 6
            r10 = r10 & 192(0xc0, float:2.69E-43)
            r12 = r4 & 63
            r10 = r10 | r12
            byte r10 = (byte) r10
            r11.write(r10)
            goto L_0x00d3
        L_0x00ad:
            int r12 = r3 << 2
            r12 = r12 & 252(0xfc, float:3.53E-43)
            int r3 = r5 >>> 4
            r1 = r1 & r3
            r12 = r12 | r1
            byte r12 = (byte) r12
            r11.write(r12)
            int r10 = r5 << 4
            r10 = r10 & 240(0xf0, float:3.36E-43)
            int r12 = r2 >>> 2
            r12 = r12 & 15
            r10 = r10 | r12
            byte r10 = (byte) r10
            r11.write(r10)
            goto L_0x00d3
        L_0x00c7:
            int r12 = r3 << 2
            r12 = r12 & 252(0xfc, float:3.53E-43)
            int r10 = r5 >>> 4
            r10 = r10 & r1
            r10 = r10 | r12
            byte r10 = (byte) r10
            r11.write(r10)
        L_0x00d3:
            return
        L_0x00d4:
            u7.b r10 = new u7.b
            r10.<init>()
            throw r10
        L_0x00da:
            u7.b r10 = new u7.b
            r10.<init>()
            throw r10
        L_0x00e0:
            u7.a r10 = new u7.a
            java.lang.String r11 = "BASE64Decoder: Not enough bytes for an atom."
            r10.<init>(r11)
            goto L_0x00e9
        L_0x00e8:
            throw r10
        L_0x00e9:
            goto L_0x00e8
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.a.c(java.io.PushbackInputStream, java.io.OutputStream, int):void");
    }
}
