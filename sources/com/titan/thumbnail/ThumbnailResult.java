package com.titan.thumbnail;

import java.util.List;
import t9.i;

public final class ThumbnailResult {
    private int combine_hn;
    private int combine_wn;
    private List<CombineData> combines;
    private int height;
    private String name;
    private int nb_snapshots;
    private String source_url;
    private int width;

    public ThumbnailResult(String str, int i10, int i11, int i12, int i13, int i14, String str2, List<CombineData> list) {
        i.h(str, "name");
        this.name = str;
        this.width = i10;
        this.height = i11;
        this.combine_wn = i12;
        this.combine_hn = i13;
        this.nb_snapshots = i14;
        this.source_url = str2;
        this.combines = list;
    }

    public static /* synthetic */ ThumbnailResult copy$default(ThumbnailResult thumbnailResult, String str, int i10, int i11, int i12, int i13, int i14, String str2, List list, int i15, Object obj) {
        ThumbnailResult thumbnailResult2 = thumbnailResult;
        int i16 = i15;
        return thumbnailResult.copy((i16 & 1) != 0 ? thumbnailResult2.name : str, (i16 & 2) != 0 ? thumbnailResult2.width : i10, (i16 & 4) != 0 ? thumbnailResult2.height : i11, (i16 & 8) != 0 ? thumbnailResult2.combine_wn : i12, (i16 & 16) != 0 ? thumbnailResult2.combine_hn : i13, (i16 & 32) != 0 ? thumbnailResult2.nb_snapshots : i14, (i16 & 64) != 0 ? thumbnailResult2.source_url : str2, (i16 & 128) != 0 ? thumbnailResult2.combines : list);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final int component4() {
        return this.combine_wn;
    }

    public final int component5() {
        return this.combine_hn;
    }

    public final int component6() {
        return this.nb_snapshots;
    }

    public final String component7() {
        return this.source_url;
    }

    public final List<CombineData> component8() {
        return this.combines;
    }

    public final ThumbnailResult copy(String str, int i10, int i11, int i12, int i13, int i14, String str2, List<CombineData> list) {
        i.h(str, "name");
        return new ThumbnailResult(str, i10, i11, i12, i13, i14, str2, list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ThumbnailResult) {
                ThumbnailResult thumbnailResult = (ThumbnailResult) obj;
                if (i.b(this.name, thumbnailResult.name)) {
                    if (this.width == thumbnailResult.width) {
                        if (this.height == thumbnailResult.height) {
                            if (this.combine_wn == thumbnailResult.combine_wn) {
                                if (this.combine_hn == thumbnailResult.combine_hn) {
                                    if (!(this.nb_snapshots == thumbnailResult.nb_snapshots) || !i.b(this.source_url, thumbnailResult.source_url) || !i.b(this.combines, thumbnailResult.combines)) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getCombine_hn() {
        return this.combine_hn;
    }

    public final int getCombine_wn() {
        return this.combine_wn;
    }

    public final List<CombineData> getCombines() {
        return this.combines;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNb_snapshots() {
        return this.nb_snapshots;
    }

    public final String getSource_url() {
        return this.source_url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.name;
        int i10 = 0;
        int hashCode = (((((((((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height) * 31) + this.combine_wn) * 31) + this.combine_hn) * 31) + this.nb_snapshots) * 31;
        String str2 = this.source_url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<CombineData> list = this.combines;
        if (list != null) {
            i10 = list.hashCode();
        }
        return hashCode2 + i10;
    }

    public final void setCombine_hn(int i10) {
        this.combine_hn = i10;
    }

    public final void setCombine_wn(int i10) {
        this.combine_wn = i10;
    }

    public final void setCombines(List<CombineData> list) {
        this.combines = list;
    }

    public final void setHeight(int i10) {
        this.height = i10;
    }

    public final void setName(String str) {
        i.h(str, "<set-?>");
        this.name = str;
    }

    public final void setNb_snapshots(int i10) {
        this.nb_snapshots = i10;
    }

    public final void setSource_url(String str) {
        this.source_url = str;
    }

    public final void setWidth(int i10) {
        this.width = i10;
    }

    public String toString() {
        return "ThumbnailResult(name=" + this.name + ", width=" + this.width + ", height=" + this.height + ", combine_wn=" + this.combine_wn + ", combine_hn=" + this.combine_hn + ", nb_snapshots=" + this.nb_snapshots + ", source_url=" + this.source_url + ", combines=" + this.combines + ")";
    }
}
