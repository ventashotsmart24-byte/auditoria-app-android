package d8;

import com.umeng.analytics.pro.bt;
import t9.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f16386a;

    /* renamed from: b  reason: collision with root package name */
    public String f16387b;

    /* renamed from: c  reason: collision with root package name */
    public String f16388c;

    /* renamed from: d  reason: collision with root package name */
    public String f16389d;

    /* renamed from: e  reason: collision with root package name */
    public String f16390e;

    /* renamed from: f  reason: collision with root package name */
    public String f16391f;

    /* renamed from: g  reason: collision with root package name */
    public String f16392g;

    /* renamed from: h  reason: collision with root package name */
    public String f16393h;

    /* renamed from: i  reason: collision with root package name */
    public String f16394i;

    /* renamed from: j  reason: collision with root package name */
    public String f16395j;

    public b(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.h(str, "type");
        i.h(str2, "codec");
        i.h(str3, "frame_rate");
        i.h(str4, "pixel_format");
        i.h(str5, bt.f13932z);
        i.h(str6, "lang");
        i.h(str7, IjkMediaMeta.IJKM_KEY_CHANNELS);
        i.h(str8, IjkMediaMeta.IJKM_KEY_SAMPLE_RATE);
        i.h(str9, "bit_depth");
        this.f16386a = i10;
        this.f16387b = str;
        this.f16388c = str2;
        this.f16389d = str3;
        this.f16390e = str4;
        this.f16391f = str5;
        this.f16392g = str6;
        this.f16393h = str7;
        this.f16394i = str8;
        this.f16395j = str9;
    }

    public final String a() {
        return this.f16388c;
    }

    public final int b() {
        return this.f16386a;
    }

    public final String c() {
        return this.f16392g;
    }

    public final String d() {
        return this.f16387b;
    }

    public final void e(String str) {
        i.h(str, "<set-?>");
        this.f16393h = str;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (!(this.f16386a == bVar.f16386a) || !i.b(this.f16387b, bVar.f16387b) || !i.b(this.f16388c, bVar.f16388c) || !i.b(this.f16389d, bVar.f16389d) || !i.b(this.f16390e, bVar.f16390e) || !i.b(this.f16391f, bVar.f16391f) || !i.b(this.f16392g, bVar.f16392g) || !i.b(this.f16393h, bVar.f16393h) || !i.b(this.f16394i, bVar.f16394i) || !i.b(this.f16395j, bVar.f16395j)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final void f(String str) {
        i.h(str, "<set-?>");
        this.f16388c = str;
    }

    public final void g(String str) {
        i.h(str, "<set-?>");
        this.f16389d = str;
    }

    public final void h(int i10) {
        this.f16386a = i10;
    }

    public int hashCode() {
        int i10 = this.f16386a * 31;
        String str = this.f16387b;
        int i11 = 0;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16388c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f16389d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f16390e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f16391f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f16392g;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f16393h;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f16394i;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f16395j;
        if (str9 != null) {
            i11 = str9.hashCode();
        }
        return hashCode8 + i11;
    }

    public final void i(String str) {
        i.h(str, "<set-?>");
        this.f16392g = str;
    }

    public final void j(String str) {
        i.h(str, "<set-?>");
        this.f16390e = str;
    }

    public final void k(String str) {
        i.h(str, "<set-?>");
        this.f16391f = str;
    }

    public final void l(String str) {
        i.h(str, "<set-?>");
        this.f16394i = str;
    }

    public final void m(String str) {
        i.h(str, "<set-?>");
        this.f16387b = str;
    }

    public String toString() {
        return "MultiTrackInfo(id=" + this.f16386a + ", type=" + this.f16387b + ", codec=" + this.f16388c + ", frame_rate=" + this.f16389d + ", pixel_format=" + this.f16390e + ", resolution=" + this.f16391f + ", lang=" + this.f16392g + ", channels=" + this.f16393h + ", sample_rate=" + this.f16394i + ", bit_depth=" + this.f16395j + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(int r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, t9.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = -1
            goto L_0x0009
        L_0x0008:
            r1 = r12
        L_0x0009:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0011
            r2 = r3
            goto L_0x0012
        L_0x0011:
            r2 = r13
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r3
            goto L_0x0019
        L_0x0018:
            r4 = r14
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r3
            goto L_0x0020
        L_0x001f:
            r5 = r15
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r3
            goto L_0x0028
        L_0x0026:
            r6 = r16
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r3
            goto L_0x0030
        L_0x002e:
            r7 = r17
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r3
            goto L_0x0038
        L_0x0036:
            r8 = r18
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            r9 = r3
            goto L_0x0040
        L_0x003e:
            r9 = r19
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r3
            goto L_0x0048
        L_0x0046:
            r10 = r20
        L_0x0048:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r3 = r21
        L_0x004f:
            r12 = r11
            r13 = r1
            r14 = r2
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.b.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, t9.g):void");
    }
}
