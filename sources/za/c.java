package za;

import ab.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public a f10020a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10021b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10022c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10023d;

    /* renamed from: e  reason: collision with root package name */
    public byte f10024e;

    /* renamed from: f  reason: collision with root package name */
    public String f10025f;

    /* renamed from: g  reason: collision with root package name */
    public b[] f10026g = new b[3];

    /* renamed from: h  reason: collision with root package name */
    public b f10027h = null;

    public enum a {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public c(a aVar) {
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f10026g;
            if (i10 < bVarArr.length) {
                bVarArr[i10] = null;
                i10++;
            } else {
                e();
                return;
            }
        }
    }

    public void a() {
        b[] bVarArr;
        if (this.f10023d) {
            if (this.f10025f != null) {
                this.f10021b = true;
            } else if (this.f10020a == a.HIGHBYTE) {
                int i10 = 0;
                int i11 = 0;
                float f10 = 0.0f;
                while (true) {
                    bVarArr = this.f10026g;
                    if (i10 >= bVarArr.length) {
                        break;
                    }
                    float d10 = bVarArr[i10].d();
                    if (d10 > f10) {
                        i11 = i10;
                        f10 = d10;
                    }
                    i10++;
                }
                if (f10 > 0.2f) {
                    this.f10025f = bVarArr[i11].c();
                }
            }
        }
    }

    public String b() {
        return this.f10025f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(byte[] r10, int r11, int r12) {
        /*
            r9 = this;
            boolean r0 = r9.f10021b
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            if (r12 <= 0) goto L_0x000a
            r9.f10023d = r0
        L_0x000a:
            boolean r1 = r9.f10022c
            r2 = 0
            if (r1 == 0) goto L_0x0077
            r9.f10022c = r2
            r1 = 3
            if (r12 <= r1) goto L_0x0077
            byte r1 = r10[r11]
            r3 = 255(0xff, float:3.57E-43)
            r1 = r1 & r3
            int r4 = r11 + 1
            byte r4 = r10[r4]
            r4 = r4 & r3
            int r5 = r11 + 2
            byte r5 = r10[r5]
            r5 = r5 & r3
            int r6 = r11 + 3
            byte r6 = r10[r6]
            r6 = r6 & r3
            r7 = 254(0xfe, float:3.56E-43)
            if (r1 == 0) goto L_0x005e
            r8 = 239(0xef, float:3.35E-43)
            if (r1 == r8) goto L_0x0051
            if (r1 == r7) goto L_0x0043
            if (r1 == r3) goto L_0x0035
            goto L_0x0070
        L_0x0035:
            if (r4 != r7) goto L_0x003e
            if (r5 != 0) goto L_0x003e
            if (r6 != 0) goto L_0x003e
            java.lang.String r1 = za.b.f10018y
            goto L_0x005b
        L_0x003e:
            if (r4 != r7) goto L_0x0070
            java.lang.String r1 = za.b.f10016w
            goto L_0x005b
        L_0x0043:
            if (r4 != r3) goto L_0x004c
            if (r5 != 0) goto L_0x004c
            if (r6 != 0) goto L_0x004c
            java.lang.String r1 = za.b.A
            goto L_0x005b
        L_0x004c:
            if (r4 != r3) goto L_0x0070
            java.lang.String r1 = za.b.f10015v
            goto L_0x005b
        L_0x0051:
            r1 = 187(0xbb, float:2.62E-43)
            if (r4 != r1) goto L_0x0070
            r1 = 191(0xbf, float:2.68E-43)
            if (r5 != r1) goto L_0x0070
            java.lang.String r1 = za.b.f10014u
        L_0x005b:
            r9.f10025f = r1
            goto L_0x0070
        L_0x005e:
            if (r4 != 0) goto L_0x0067
            if (r5 != r7) goto L_0x0067
            if (r6 != r3) goto L_0x0067
            java.lang.String r1 = za.b.f10017x
            goto L_0x005b
        L_0x0067:
            if (r4 != 0) goto L_0x0070
            if (r5 != r3) goto L_0x0070
            if (r6 != r7) goto L_0x0070
            java.lang.String r1 = za.b.B
            goto L_0x005b
        L_0x0070:
            java.lang.String r1 = r9.f10025f
            if (r1 == 0) goto L_0x0077
            r9.f10021b = r0
            return
        L_0x0077:
            int r1 = r11 + r12
            r3 = r11
        L_0x007a:
            if (r3 >= r1) goto L_0x00dd
            byte r4 = r10[r3]
            r5 = r4 & 255(0xff, float:3.57E-43)
            r6 = r5 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00c0
            r6 = 160(0xa0, float:2.24E-43)
            if (r5 == r6) goto L_0x00c0
            za.c$a r4 = r9.f10020a
            za.c$a r5 = za.c.a.HIGHBYTE
            if (r4 == r5) goto L_0x00da
            r9.f10020a = r5
            ab.b r4 = r9.f10027h
            if (r4 == 0) goto L_0x0097
            r4 = 0
            r9.f10027h = r4
        L_0x0097:
            ab.b[] r4 = r9.f10026g
            r5 = r4[r2]
            if (r5 != 0) goto L_0x00a4
            ab.j r5 = new ab.j
            r5.<init>()
            r4[r2] = r5
        L_0x00a4:
            ab.b[] r4 = r9.f10026g
            r5 = r4[r0]
            if (r5 != 0) goto L_0x00b1
            ab.k r5 = new ab.k
            r5.<init>()
            r4[r0] = r5
        L_0x00b1:
            ab.b[] r4 = r9.f10026g
            r5 = 2
            r6 = r4[r5]
            if (r6 != 0) goto L_0x00da
            ab.i r6 = new ab.i
            r6.<init>()
            r4[r5] = r6
            goto L_0x00da
        L_0x00c0:
            za.c$a r6 = r9.f10020a
            za.c$a r7 = za.c.a.PURE_ASCII
            if (r6 != r7) goto L_0x00d8
            r6 = 27
            if (r5 == r6) goto L_0x00d4
            r6 = 123(0x7b, float:1.72E-43)
            if (r5 != r6) goto L_0x00d8
            byte r5 = r9.f10024e
            r6 = 126(0x7e, float:1.77E-43)
            if (r5 != r6) goto L_0x00d8
        L_0x00d4:
            za.c$a r5 = za.c.a.ESC_ASCII
            r9.f10020a = r5
        L_0x00d8:
            r9.f10024e = r4
        L_0x00da:
            int r3 = r3 + 1
            goto L_0x007a
        L_0x00dd:
            za.c$a r1 = r9.f10020a
            za.c$a r3 = za.c.a.ESC_ASCII
            if (r1 != r3) goto L_0x0103
            ab.b r1 = r9.f10027h
            if (r1 != 0) goto L_0x00ee
            ab.f r1 = new ab.f
            r1.<init>()
            r9.f10027h = r1
        L_0x00ee:
            ab.b r1 = r9.f10027h
            ab.b$a r10 = r1.f(r10, r11, r12)
            ab.b$a r11 = ab.b.a.FOUND_IT
            if (r10 != r11) goto L_0x0126
            r9.f10021b = r0
            ab.b r10 = r9.f10027h
            java.lang.String r10 = r10.c()
            r9.f10025f = r10
            goto L_0x0126
        L_0x0103:
            za.c$a r3 = za.c.a.HIGHBYTE
            if (r1 != r3) goto L_0x0126
        L_0x0107:
            ab.b[] r1 = r9.f10026g
            int r3 = r1.length
            if (r2 >= r3) goto L_0x0126
            r1 = r1[r2]
            ab.b$a r1 = r1.f(r10, r11, r12)
            ab.b$a r3 = ab.b.a.FOUND_IT
            if (r1 != r3) goto L_0x0123
            r9.f10021b = r0
            ab.b[] r10 = r9.f10026g
            r10 = r10[r2]
            java.lang.String r10 = r10.c()
            r9.f10025f = r10
            return
        L_0x0123:
            int r2 = r2 + 1
            goto L_0x0107
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: za.c.c(byte[], int, int):void");
    }

    public boolean d() {
        return this.f10021b;
    }

    public void e() {
        int i10 = 0;
        this.f10021b = false;
        this.f10022c = true;
        this.f10025f = null;
        this.f10023d = false;
        this.f10020a = a.PURE_ASCII;
        this.f10024e = 0;
        b bVar = this.f10027h;
        if (bVar != null) {
            bVar.i();
        }
        while (true) {
            b[] bVarArr = this.f10026g;
            if (i10 < bVarArr.length) {
                b bVar2 = bVarArr[i10];
                if (bVar2 != null) {
                    bVar2.i();
                }
                i10++;
            } else {
                return;
            }
        }
    }
}
