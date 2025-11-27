package d8;

import t9.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f16379a;

    /* renamed from: b  reason: collision with root package name */
    public String f16380b;

    /* renamed from: c  reason: collision with root package name */
    public String f16381c;

    /* renamed from: d  reason: collision with root package name */
    public String f16382d;

    /* renamed from: e  reason: collision with root package name */
    public float f16383e;

    /* renamed from: f  reason: collision with root package name */
    public long f16384f;

    /* renamed from: g  reason: collision with root package name */
    public long f16385g;

    public a(int i10, String str, String str2, String str3, float f10, long j10, long j11) {
        i.h(str, "codec");
        i.h(str2, "decoder");
        i.h(str3, "lang");
        this.f16379a = i10;
        this.f16380b = str;
        this.f16381c = str2;
        this.f16382d = str3;
        this.f16383e = f10;
        this.f16384f = j10;
        this.f16385g = j11;
    }

    public final int a() {
        return this.f16379a;
    }

    public final void b(long j10) {
        this.f16385g = j10;
    }

    public final void c(long j10) {
        this.f16384f = j10;
    }

    public final void d(String str) {
        i.h(str, "<set-?>");
        this.f16380b = str;
    }

    public final void e(String str) {
        i.h(str, "<set-?>");
        this.f16381c = str;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if ((this.f16379a == aVar.f16379a) && i.b(this.f16380b, aVar.f16380b) && i.b(this.f16381c, aVar.f16381c) && i.b(this.f16382d, aVar.f16382d) && Float.compare(this.f16383e, aVar.f16383e) == 0) {
                    if (this.f16384f == aVar.f16384f) {
                        if (this.f16385g == aVar.f16385g) {
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
        this.f16383e = f10;
    }

    public final void g(int i10) {
        this.f16379a = i10;
    }

    public final void h(String str) {
        i.h(str, "<set-?>");
        this.f16382d = str;
    }

    public int hashCode() {
        int i10 = this.f16379a * 31;
        String str = this.f16380b;
        int i11 = 0;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16381c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f16382d;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        long j10 = this.f16384f;
        long j11 = this.f16385g;
        return ((((((hashCode2 + i11) * 31) + Float.floatToIntBits(this.f16383e)) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "AudioTrackInfo(id=" + this.f16379a + ", codec=" + this.f16380b + ", decoder=" + this.f16381c + ", lang=" + this.f16382d + ", delay=" + this.f16383e + ", bufferTime=" + this.f16384f + ", bufferLength=" + this.f16385g + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(int r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, float r15, long r16, long r18, int r20, t9.g r21) {
        /*
            r10 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L_0x0006
            r0 = -1
            goto L_0x0007
        L_0x0006:
            r0 = r11
        L_0x0007:
            r1 = r20 & 2
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000f
            r1 = r2
            goto L_0x0010
        L_0x000f:
            r1 = r12
        L_0x0010:
            r3 = r20 & 4
            if (r3 == 0) goto L_0x0016
            r3 = r2
            goto L_0x0017
        L_0x0016:
            r3 = r13
        L_0x0017:
            r4 = r20 & 8
            if (r4 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r2 = r14
        L_0x001d:
            r4 = r20 & 16
            if (r4 == 0) goto L_0x0023
            r4 = 0
            goto L_0x0024
        L_0x0023:
            r4 = r15
        L_0x0024:
            r5 = r20 & 32
            r6 = 0
            if (r5 == 0) goto L_0x002c
            r8 = r6
            goto L_0x002e
        L_0x002c:
            r8 = r16
        L_0x002e:
            r5 = r20 & 64
            if (r5 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r6 = r18
        L_0x0035:
            r11 = r10
            r12 = r0
            r13 = r1
            r14 = r3
            r15 = r2
            r16 = r4
            r17 = r8
            r19 = r6
            r11.<init>(r12, r13, r14, r15, r16, r17, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.a.<init>(int, java.lang.String, java.lang.String, java.lang.String, float, long, long, int, t9.g):void");
    }
}
