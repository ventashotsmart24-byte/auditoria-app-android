package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

public final class SimpleProgramList implements Serializable {
    private String contentId;
    private String duration;
    private float fraction;
    private String hasPositive;
    private String hasTidbits;
    private String hasTrailer;
    private boolean isDownloaded;
    private boolean isDownloading;
    private boolean isPlayed;
    private boolean isSelected;
    private String name;
    private List<? extends PosterList> posterList;
    private String quality;
    private int seriesNumber;

    public SimpleProgramList(String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10, String str7, List<? extends PosterList> list, float f10, boolean z11, boolean z12, boolean z13) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "duration");
        i.g(str4, "hasPositive");
        i.g(str5, "hasTidbits");
        i.g(str6, "hasTrailer");
        this.contentId = str;
        this.name = str2;
        this.duration = str3;
        this.hasPositive = str4;
        this.hasTidbits = str5;
        this.hasTrailer = str6;
        this.seriesNumber = i10;
        this.isPlayed = z10;
        this.quality = str7;
        this.posterList = list;
        this.fraction = f10;
        this.isDownloading = z11;
        this.isDownloaded = z12;
        this.isSelected = z13;
    }

    public static /* synthetic */ SimpleProgramList copy$default(SimpleProgramList simpleProgramList, String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10, String str7, List list, float f10, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        SimpleProgramList simpleProgramList2 = simpleProgramList;
        int i12 = i11;
        return simpleProgramList.copy((i12 & 1) != 0 ? simpleProgramList2.contentId : str, (i12 & 2) != 0 ? simpleProgramList2.name : str2, (i12 & 4) != 0 ? simpleProgramList2.duration : str3, (i12 & 8) != 0 ? simpleProgramList2.hasPositive : str4, (i12 & 16) != 0 ? simpleProgramList2.hasTidbits : str5, (i12 & 32) != 0 ? simpleProgramList2.hasTrailer : str6, (i12 & 64) != 0 ? simpleProgramList2.seriesNumber : i10, (i12 & 128) != 0 ? simpleProgramList2.isPlayed : z10, (i12 & 256) != 0 ? simpleProgramList2.quality : str7, (i12 & 512) != 0 ? simpleProgramList2.posterList : list, (i12 & 1024) != 0 ? simpleProgramList2.fraction : f10, (i12 & 2048) != 0 ? simpleProgramList2.isDownloading : z11, (i12 & 4096) != 0 ? simpleProgramList2.isDownloaded : z12, (i12 & 8192) != 0 ? simpleProgramList2.isSelected : z13);
    }

    public final String component1() {
        return this.contentId;
    }

    public final List<PosterList> component10() {
        return this.posterList;
    }

    public final float component11() {
        return this.fraction;
    }

    public final boolean component12() {
        return this.isDownloading;
    }

    public final boolean component13() {
        return this.isDownloaded;
    }

    public final boolean component14() {
        return this.isSelected;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.duration;
    }

    public final String component4() {
        return this.hasPositive;
    }

    public final String component5() {
        return this.hasTidbits;
    }

    public final String component6() {
        return this.hasTrailer;
    }

    public final int component7() {
        return this.seriesNumber;
    }

    public final boolean component8() {
        return this.isPlayed;
    }

    public final String component9() {
        return this.quality;
    }

    public final SimpleProgramList copy(String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10, String str7, List<? extends PosterList> list, float f10, boolean z11, boolean z12, boolean z13) {
        String str8 = str;
        i.g(str8, "contentId");
        String str9 = str2;
        i.g(str9, "name");
        String str10 = str3;
        i.g(str10, "duration");
        String str11 = str4;
        i.g(str11, "hasPositive");
        String str12 = str5;
        i.g(str12, "hasTidbits");
        String str13 = str6;
        i.g(str13, "hasTrailer");
        return new SimpleProgramList(str8, str9, str10, str11, str12, str13, i10, z10, str7, list, f10, z11, z12, z13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleProgramList)) {
            return false;
        }
        SimpleProgramList simpleProgramList = (SimpleProgramList) obj;
        return i.b(this.contentId, simpleProgramList.contentId) && i.b(this.name, simpleProgramList.name) && i.b(this.duration, simpleProgramList.duration) && i.b(this.hasPositive, simpleProgramList.hasPositive) && i.b(this.hasTidbits, simpleProgramList.hasTidbits) && i.b(this.hasTrailer, simpleProgramList.hasTrailer) && this.seriesNumber == simpleProgramList.seriesNumber && this.isPlayed == simpleProgramList.isPlayed && i.b(this.quality, simpleProgramList.quality) && i.b(this.posterList, simpleProgramList.posterList) && Float.compare(this.fraction, simpleProgramList.fraction) == 0 && this.isDownloading == simpleProgramList.isDownloading && this.isDownloaded == simpleProgramList.isDownloaded && this.isSelected == simpleProgramList.isSelected;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final String getHasPositive() {
        return this.hasPositive;
    }

    public final String getHasTidbits() {
        return this.hasTidbits;
    }

    public final String getHasTrailer() {
        return this.hasTrailer;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PosterList> getPosterList() {
        return this.posterList;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final int getSeriesNumber() {
        return this.seriesNumber;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.contentId.hashCode() * 31) + this.name.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.hasPositive.hashCode()) * 31) + this.hasTidbits.hashCode()) * 31) + this.hasTrailer.hashCode()) * 31) + this.seriesNumber) * 31;
        boolean z10 = this.isPlayed;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i10 = (hashCode + (z10 ? 1 : 0)) * 31;
        String str = this.quality;
        int i11 = 0;
        int hashCode2 = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        List<? extends PosterList> list = this.posterList;
        if (list != null) {
            i11 = list.hashCode();
        }
        int floatToIntBits = (((hashCode2 + i11) * 31) + Float.floatToIntBits(this.fraction)) * 31;
        boolean z12 = this.isDownloading;
        if (z12) {
            z12 = true;
        }
        int i12 = (floatToIntBits + (z12 ? 1 : 0)) * 31;
        boolean z13 = this.isDownloaded;
        if (z13) {
            z13 = true;
        }
        int i13 = (i12 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isSelected;
        if (!z14) {
            z11 = z14;
        }
        return i13 + (z11 ? 1 : 0);
    }

    public final boolean isDownloaded() {
        return this.isDownloaded;
    }

    public final boolean isDownloading() {
        return this.isDownloading;
    }

    public final boolean isPlayed() {
        return this.isPlayed;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setDownloaded(boolean z10) {
        this.isDownloaded = z10;
    }

    public final void setDownloading(boolean z10) {
        this.isDownloading = z10;
    }

    public final void setDuration(String str) {
        i.g(str, "<set-?>");
        this.duration = str;
    }

    public final void setFraction(float f10) {
        this.fraction = f10;
    }

    public final void setHasPositive(String str) {
        i.g(str, "<set-?>");
        this.hasPositive = str;
    }

    public final void setHasTidbits(String str) {
        i.g(str, "<set-?>");
        this.hasTidbits = str;
    }

    public final void setHasTrailer(String str) {
        i.g(str, "<set-?>");
        this.hasTrailer = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setPlayed(boolean z10) {
        this.isPlayed = z10;
    }

    public final void setPosterList(List<? extends PosterList> list) {
        this.posterList = list;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public final void setSeriesNumber(int i10) {
        this.seriesNumber = i10;
    }

    public String toString() {
        return "SimpleProgramList(contentId=" + this.contentId + ", name=" + this.name + ", duration=" + this.duration + ", hasPositive=" + this.hasPositive + ", hasTidbits=" + this.hasTidbits + ", hasTrailer=" + this.hasTrailer + ", seriesNumber=" + this.seriesNumber + ", isPlayed=" + this.isPlayed + ", quality=" + this.quality + ", posterList=" + this.posterList + ", fraction=" + this.fraction + ", isDownloading=" + this.isDownloading + ", isDownloaded=" + this.isDownloaded + ", isSelected=" + this.isSelected + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SimpleProgramList(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, int r25, boolean r26, java.lang.String r27, java.util.List r28, float r29, boolean r30, boolean r31, boolean r32, int r33, t9.g r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r11 = 0
            goto L_0x000b
        L_0x0009:
            r11 = r26
        L_0x000b:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0011
            r15 = 0
            goto L_0x0013
        L_0x0011:
            r15 = r30
        L_0x0013:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x001a
            r16 = 0
            goto L_0x001c
        L_0x001a:
            r16 = r31
        L_0x001c:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0023
            r17 = 0
            goto L_0x0025
        L_0x0023:
            r17 = r32
        L_0x0025:
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r12 = r27
            r13 = r28
            r14 = r29
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mobile.com.requestframe.utils.response.SimpleProgramList.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, java.lang.String, java.util.List, float, boolean, boolean, boolean, int, t9.g):void");
    }
}
