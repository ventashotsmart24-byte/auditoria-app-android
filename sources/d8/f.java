package d8;

import t9.i;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public int f16417a;

    /* renamed from: b  reason: collision with root package name */
    public String f16418b;

    /* renamed from: c  reason: collision with root package name */
    public String f16419c;

    /* renamed from: d  reason: collision with root package name */
    public float f16420d;

    /* renamed from: e  reason: collision with root package name */
    public long f16421e;

    /* renamed from: f  reason: collision with root package name */
    public long f16422f;

    public f(int i10, String str, String str2, float f10, long j10, long j11) {
        i.h(str, "codec");
        i.h(str2, "decoder");
        this.f16417a = i10;
        this.f16418b = str;
        this.f16419c = str2;
        this.f16420d = f10;
        this.f16421e = j10;
        this.f16422f = j11;
    }

    public final String a() {
        return this.f16419c;
    }

    public final void b(long j10) {
        this.f16422f = j10;
    }

    public final void c(long j10) {
        this.f16421e = j10;
    }

    public final void d(String str) {
        i.h(str, "<set-?>");
        this.f16418b = str;
    }

    public final void e(String str) {
        i.h(str, "<set-?>");
        this.f16419c = str;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if ((this.f16417a == fVar.f16417a) && i.b(this.f16418b, fVar.f16418b) && i.b(this.f16419c, fVar.f16419c) && Float.compare(this.f16420d, fVar.f16420d) == 0) {
                    if (this.f16421e == fVar.f16421e) {
                        if (this.f16422f == fVar.f16422f) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void f(float f10) {
        this.f16420d = f10;
    }

    public final void g(int i10) {
        this.f16417a = i10;
    }

    public int hashCode() {
        int i10 = this.f16417a * 31;
        String str = this.f16418b;
        int i11 = 0;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16419c;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        long j10 = this.f16421e;
        long j11 = this.f16422f;
        return ((((((hashCode + i11) * 31) + Float.floatToIntBits(this.f16420d)) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "VideoTrackInfo(id=" + this.f16417a + ", codec=" + this.f16418b + ", decoder=" + this.f16419c + ", frame_rate=" + this.f16420d + ", buffer_time=" + this.f16421e + ", buffer_length=" + this.f16422f + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(int r10, java.lang.String r11, java.lang.String r12, float r13, long r14, long r16, int r18, t9.g r19) {
        /*
            r9 = this;
            r0 = r18 & 1
            if (r0 == 0) goto L_0x0006
            r0 = -1
            goto L_0x0007
        L_0x0006:
            r0 = r10
        L_0x0007:
            r1 = r18 & 2
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000f
            r1 = r2
            goto L_0x0010
        L_0x000f:
            r1 = r11
        L_0x0010:
            r3 = r18 & 4
            if (r3 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r2 = r12
        L_0x0016:
            r3 = r18 & 8
            if (r3 == 0) goto L_0x001c
            r3 = 0
            goto L_0x001d
        L_0x001c:
            r3 = r13
        L_0x001d:
            r4 = r18 & 16
            r5 = 0
            if (r4 == 0) goto L_0x0025
            r7 = r5
            goto L_0x0026
        L_0x0025:
            r7 = r14
        L_0x0026:
            r4 = r18 & 32
            if (r4 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r5 = r16
        L_0x002d:
            r10 = r9
            r11 = r0
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r7
            r17 = r5
            r10.<init>(r11, r12, r13, r14, r15, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.f.<init>(int, java.lang.String, java.lang.String, float, long, long, int, t9.g):void");
    }
}
