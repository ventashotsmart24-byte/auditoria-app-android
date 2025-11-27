package d8;

import java.util.ArrayList;
import java.util.List;
import t9.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public long f16396a;

    /* renamed from: b  reason: collision with root package name */
    public String f16397b;

    /* renamed from: c  reason: collision with root package name */
    public String f16398c;

    /* renamed from: d  reason: collision with root package name */
    public String f16399d;

    /* renamed from: e  reason: collision with root package name */
    public String f16400e;

    /* renamed from: f  reason: collision with root package name */
    public String f16401f;

    /* renamed from: g  reason: collision with root package name */
    public List f16402g;

    /* renamed from: h  reason: collision with root package name */
    public long f16403h;

    /* renamed from: i  reason: collision with root package name */
    public String f16404i;

    /* renamed from: j  reason: collision with root package name */
    public String f16405j;

    /* renamed from: k  reason: collision with root package name */
    public f f16406k;

    /* renamed from: l  reason: collision with root package name */
    public a f16407l;

    /* renamed from: m  reason: collision with root package name */
    public e f16408m;

    /* renamed from: n  reason: collision with root package name */
    public ArrayList f16409n;

    public c(long j10, String str, String str2, String str3, String str4, String str5, List list, long j11, String str6, String str7, f fVar, a aVar, e eVar, ArrayList arrayList) {
        String str8 = str4;
        String str9 = str5;
        String str10 = str6;
        String str11 = str7;
        i.h(str, "program");
        i.h(str2, "title");
        i.h(str3, "buss");
        i.h(str8, "media");
        i.h(str9, "play_url");
        i.h(str10, IjkMediaMeta.IJKM_KEY_FORMAT);
        i.h(str11, "player");
        this.f16396a = j10;
        this.f16397b = str;
        this.f16398c = str2;
        this.f16399d = str3;
        this.f16400e = str8;
        this.f16401f = str9;
        this.f16402g = list;
        this.f16403h = j11;
        this.f16404i = str10;
        this.f16405j = str11;
        this.f16406k = fVar;
        this.f16407l = aVar;
        this.f16408m = eVar;
        this.f16409n = arrayList;
    }

    public final a a() {
        return this.f16407l;
    }

    public final String b() {
        return this.f16399d;
    }

    public final long c() {
        return this.f16396a;
    }

    public final String d() {
        return this.f16400e;
    }

    public final String e() {
        return this.f16401f;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if ((this.f16396a == cVar.f16396a) && i.b(this.f16397b, cVar.f16397b) && i.b(this.f16398c, cVar.f16398c) && i.b(this.f16399d, cVar.f16399d) && i.b(this.f16400e, cVar.f16400e) && i.b(this.f16401f, cVar.f16401f) && i.b(this.f16402g, cVar.f16402g)) {
                    if (!(this.f16403h == cVar.f16403h) || !i.b(this.f16404i, cVar.f16404i) || !i.b(this.f16405j, cVar.f16405j) || !i.b(this.f16406k, cVar.f16406k) || !i.b(this.f16407l, cVar.f16407l) || !i.b(this.f16408m, cVar.f16408m) || !i.b(this.f16409n, cVar.f16409n)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final ArrayList f() {
        return this.f16409n;
    }

    public final f g() {
        return this.f16406k;
    }

    public final void h(a aVar) {
        this.f16407l = aVar;
    }

    public int hashCode() {
        long j10 = this.f16396a;
        int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
        String str = this.f16397b;
        int i11 = 0;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16398c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f16399d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f16400e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f16401f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List list = this.f16402g;
        int hashCode6 = list != null ? list.hashCode() : 0;
        long j11 = this.f16403h;
        int i12 = (((hashCode5 + hashCode6) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        String str6 = this.f16404i;
        int hashCode7 = (i12 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f16405j;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        f fVar = this.f16406k;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 31;
        a aVar = this.f16407l;
        int hashCode10 = (hashCode9 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        e eVar = this.f16408m;
        int hashCode11 = (hashCode10 + (eVar != null ? eVar.hashCode() : 0)) * 31;
        ArrayList arrayList = this.f16409n;
        if (arrayList != null) {
            i11 = arrayList.hashCode();
        }
        return hashCode11 + i11;
    }

    public final void i(String str) {
        i.h(str, "<set-?>");
        this.f16399d = str;
    }

    public final void j(long j10) {
        this.f16396a = j10;
    }

    public final void k(String str) {
        i.h(str, "<set-?>");
        this.f16404i = str;
    }

    public final void l(long j10) {
        this.f16403h = j10;
    }

    public final void m(List list) {
        this.f16402g = list;
    }

    public final void n(String str) {
        i.h(str, "<set-?>");
        this.f16400e = str;
    }

    public final void o(String str) {
        i.h(str, "<set-?>");
        this.f16401f = str;
    }

    public final void p(String str) {
        i.h(str, "<set-?>");
        this.f16405j = str;
    }

    public final void q(String str) {
        i.h(str, "<set-?>");
        this.f16397b = str;
    }

    public final void r(e eVar) {
        this.f16408m = eVar;
    }

    public final void s(String str) {
        i.h(str, "<set-?>");
        this.f16398c = str;
    }

    public final void t(ArrayList arrayList) {
        this.f16409n = arrayList;
    }

    public String toString() {
        return "PlayStatus(duration=" + this.f16396a + ", program=" + this.f16397b + ", title=" + this.f16398c + ", buss=" + this.f16399d + ", media=" + this.f16400e + ", play_url=" + this.f16401f + ", links=" + this.f16402g + ", latency=" + this.f16403h + ", format=" + this.f16404i + ", player=" + this.f16405j + ", video=" + this.f16406k + ", audio=" + this.f16407l + ", subtitle=" + this.f16408m + ", tracks=" + this.f16409n + ")";
    }

    public final void u(f fVar) {
        this.f16406k = fVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ c(long r17, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.util.List r24, long r25, java.lang.String r27, java.lang.String r28, d8.f r29, d8.a r30, d8.e r31, java.util.ArrayList r32, int r33, t9.g r34) {
        /*
            r16 = this;
            r0 = r33
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0013
            r3 = r4
            goto L_0x0015
        L_0x0013:
            r3 = r19
        L_0x0015:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001b
            r5 = r4
            goto L_0x001d
        L_0x001b:
            r5 = r20
        L_0x001d:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0023
            r6 = r4
            goto L_0x0025
        L_0x0023:
            r6 = r21
        L_0x0025:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002b
            r7 = r4
            goto L_0x002d
        L_0x002b:
            r7 = r22
        L_0x002d:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0033
            r8 = r4
            goto L_0x0035
        L_0x0033:
            r8 = r23
        L_0x0035:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003b
            r9 = 0
            goto L_0x003d
        L_0x003b:
            r9 = r24
        L_0x003d:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0044
            r11 = -1
            goto L_0x0046
        L_0x0044:
            r11 = r25
        L_0x0046:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x004c
            r13 = r4
            goto L_0x004e
        L_0x004c:
            r13 = r27
        L_0x004e:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r4 = r28
        L_0x0055:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005b
            r14 = 0
            goto L_0x005d
        L_0x005b:
            r14 = r29
        L_0x005d:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0063
            r15 = 0
            goto L_0x0065
        L_0x0063:
            r15 = r30
        L_0x0065:
            r10 = r0 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x006b
            r10 = 0
            goto L_0x006d
        L_0x006b:
            r10 = r31
        L_0x006d:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0073
            r0 = 0
            goto L_0x0075
        L_0x0073:
            r0 = r32
        L_0x0075:
            r17 = r16
            r18 = r1
            r20 = r3
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r11
            r28 = r13
            r29 = r4
            r30 = r14
            r31 = r15
            r32 = r10
            r33 = r0
            r17.<init>(r18, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31, r32, r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.c.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, long, java.lang.String, java.lang.String, d8.f, d8.a, d8.e, java.util.ArrayList, int, t9.g):void");
    }
}
