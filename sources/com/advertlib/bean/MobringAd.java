package com.advertlib.bean;

import com.google.android.gms.cast.MediaTrack;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.Icon;
import java.util.List;
import t9.i;

public final class MobringAd {
    private int adid;
    private int bid_type;
    private String click_url;

    /* renamed from: cn  reason: collision with root package name */
    private String f4906cn;
    private List<CreativeData> creative;
    private int daily_cap;
    private String description;
    private String icon;
    private String kpi;
    private String name;
    private float payout;
    private String pkg;
    private int platform;
    private String preview_url;
    private int status;
    private String title;

    public MobringAd(float f10, int i10, String str, int i11, String str2, int i12, String str3, String str4, int i13, String str5, String str6, String str7, int i14, String str8, String str9, List<CreativeData> list) {
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        String str16 = str8;
        String str17 = str9;
        i.g(str, "click_url");
        i.g(str10, Icon.ELEM_NAME);
        i.g(str11, "name");
        i.g(str12, "pkg");
        i.g(str13, "cn");
        i.g(str14, "kpi");
        i.g(str15, "preview_url");
        i.g(str16, "title");
        i.g(str17, MediaTrack.ROLE_DESCRIPTION);
        this.payout = f10;
        this.bid_type = i10;
        this.click_url = str;
        this.daily_cap = i11;
        this.icon = str10;
        this.adid = i12;
        this.name = str11;
        this.pkg = str12;
        this.platform = i13;
        this.f4906cn = str13;
        this.kpi = str14;
        this.preview_url = str15;
        this.status = i14;
        this.title = str16;
        this.description = str17;
        this.creative = list;
    }

    public static /* synthetic */ MobringAd copy$default(MobringAd mobringAd, float f10, int i10, String str, int i11, String str2, int i12, String str3, String str4, int i13, String str5, String str6, String str7, int i14, String str8, String str9, List list, int i15, Object obj) {
        MobringAd mobringAd2 = mobringAd;
        int i16 = i15;
        return mobringAd.copy((i16 & 1) != 0 ? mobringAd2.payout : f10, (i16 & 2) != 0 ? mobringAd2.bid_type : i10, (i16 & 4) != 0 ? mobringAd2.click_url : str, (i16 & 8) != 0 ? mobringAd2.daily_cap : i11, (i16 & 16) != 0 ? mobringAd2.icon : str2, (i16 & 32) != 0 ? mobringAd2.adid : i12, (i16 & 64) != 0 ? mobringAd2.name : str3, (i16 & 128) != 0 ? mobringAd2.pkg : str4, (i16 & 256) != 0 ? mobringAd2.platform : i13, (i16 & 512) != 0 ? mobringAd2.f4906cn : str5, (i16 & 1024) != 0 ? mobringAd2.kpi : str6, (i16 & 2048) != 0 ? mobringAd2.preview_url : str7, (i16 & 4096) != 0 ? mobringAd2.status : i14, (i16 & 8192) != 0 ? mobringAd2.title : str8, (i16 & 16384) != 0 ? mobringAd2.description : str9, (i16 & 32768) != 0 ? mobringAd2.creative : list);
    }

    public final float component1() {
        return this.payout;
    }

    public final String component10() {
        return this.f4906cn;
    }

    public final String component11() {
        return this.kpi;
    }

    public final String component12() {
        return this.preview_url;
    }

    public final int component13() {
        return this.status;
    }

    public final String component14() {
        return this.title;
    }

    public final String component15() {
        return this.description;
    }

    public final List<CreativeData> component16() {
        return this.creative;
    }

    public final int component2() {
        return this.bid_type;
    }

    public final String component3() {
        return this.click_url;
    }

    public final int component4() {
        return this.daily_cap;
    }

    public final String component5() {
        return this.icon;
    }

    public final int component6() {
        return this.adid;
    }

    public final String component7() {
        return this.name;
    }

    public final String component8() {
        return this.pkg;
    }

    public final int component9() {
        return this.platform;
    }

    public final MobringAd copy(float f10, int i10, String str, int i11, String str2, int i12, String str3, String str4, int i13, String str5, String str6, String str7, int i14, String str8, String str9, List<CreativeData> list) {
        float f11 = f10;
        i.g(str, "click_url");
        i.g(str2, Icon.ELEM_NAME);
        i.g(str3, "name");
        i.g(str4, "pkg");
        i.g(str5, "cn");
        i.g(str6, "kpi");
        i.g(str7, "preview_url");
        i.g(str8, "title");
        i.g(str9, MediaTrack.ROLE_DESCRIPTION);
        return new MobringAd(f10, i10, str, i11, str2, i12, str3, str4, i13, str5, str6, str7, i14, str8, str9, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MobringAd)) {
            return false;
        }
        MobringAd mobringAd = (MobringAd) obj;
        return Float.compare(this.payout, mobringAd.payout) == 0 && this.bid_type == mobringAd.bid_type && i.b(this.click_url, mobringAd.click_url) && this.daily_cap == mobringAd.daily_cap && i.b(this.icon, mobringAd.icon) && this.adid == mobringAd.adid && i.b(this.name, mobringAd.name) && i.b(this.pkg, mobringAd.pkg) && this.platform == mobringAd.platform && i.b(this.f4906cn, mobringAd.f4906cn) && i.b(this.kpi, mobringAd.kpi) && i.b(this.preview_url, mobringAd.preview_url) && this.status == mobringAd.status && i.b(this.title, mobringAd.title) && i.b(this.description, mobringAd.description) && i.b(this.creative, mobringAd.creative);
    }

    public final int getAdid() {
        return this.adid;
    }

    public final int getBid_type() {
        return this.bid_type;
    }

    public final String getClick_url() {
        return this.click_url;
    }

    public final String getCn() {
        return this.f4906cn;
    }

    public final List<CreativeData> getCreative() {
        return this.creative;
    }

    public final int getDaily_cap() {
        return this.daily_cap;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getKpi() {
        return this.kpi;
    }

    public final String getName() {
        return this.name;
    }

    public final float getPayout() {
        return this.payout;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final int getPlatform() {
        return this.platform;
    }

    public final String getPreview_url() {
        return this.preview_url;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int floatToIntBits = ((((((((((((((((((((((((((((Float.floatToIntBits(this.payout) * 31) + this.bid_type) * 31) + this.click_url.hashCode()) * 31) + this.daily_cap) * 31) + this.icon.hashCode()) * 31) + this.adid) * 31) + this.name.hashCode()) * 31) + this.pkg.hashCode()) * 31) + this.platform) * 31) + this.f4906cn.hashCode()) * 31) + this.kpi.hashCode()) * 31) + this.preview_url.hashCode()) * 31) + this.status) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        List<CreativeData> list = this.creative;
        return floatToIntBits + (list == null ? 0 : list.hashCode());
    }

    public final void setAdid(int i10) {
        this.adid = i10;
    }

    public final void setBid_type(int i10) {
        this.bid_type = i10;
    }

    public final void setClick_url(String str) {
        i.g(str, "<set-?>");
        this.click_url = str;
    }

    public final void setCn(String str) {
        i.g(str, "<set-?>");
        this.f4906cn = str;
    }

    public final void setCreative(List<CreativeData> list) {
        this.creative = list;
    }

    public final void setDaily_cap(int i10) {
        this.daily_cap = i10;
    }

    public final void setDescription(String str) {
        i.g(str, "<set-?>");
        this.description = str;
    }

    public final void setIcon(String str) {
        i.g(str, "<set-?>");
        this.icon = str;
    }

    public final void setKpi(String str) {
        i.g(str, "<set-?>");
        this.kpi = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setPayout(float f10) {
        this.payout = f10;
    }

    public final void setPkg(String str) {
        i.g(str, "<set-?>");
        this.pkg = str;
    }

    public final void setPlatform(int i10) {
        this.platform = i10;
    }

    public final void setPreview_url(String str) {
        i.g(str, "<set-?>");
        this.preview_url = str;
    }

    public final void setStatus(int i10) {
        this.status = i10;
    }

    public final void setTitle(String str) {
        i.g(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "MobringAd(payout=" + this.payout + ", bid_type=" + this.bid_type + ", click_url=" + this.click_url + ", daily_cap=" + this.daily_cap + ", icon=" + this.icon + ", adid=" + this.adid + ", name=" + this.name + ", pkg=" + this.pkg + ", platform=" + this.platform + ", cn=" + this.f4906cn + ", kpi=" + this.kpi + ", preview_url=" + this.preview_url + ", status=" + this.status + ", title=" + this.title + ", description=" + this.description + ", creative=" + this.creative + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
