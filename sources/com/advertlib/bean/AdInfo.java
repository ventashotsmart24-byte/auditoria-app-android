package com.advertlib.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

public final class AdInfo {
    private String action;
    private String action_type;
    private String ad_id;
    private String ad_name;
    private String is_dealer;
    private String media_type;
    private int show_adsflag;
    private int show_frequency;
    private UserIdentityFrequency show_frequency_v2;
    private String url;

    public AdInfo(String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, UserIdentityFrequency userIdentityFrequency, String str7) {
        i.g(str, "ad_id");
        i.g(str2, "media_type");
        this.ad_id = str;
        this.media_type = str2;
        this.url = str3;
        this.ad_name = str4;
        this.action_type = str5;
        this.action = str6;
        this.show_adsflag = i10;
        this.show_frequency = i11;
        this.show_frequency_v2 = userIdentityFrequency;
        this.is_dealer = str7;
    }

    public static /* synthetic */ AdInfo copy$default(AdInfo adInfo, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, UserIdentityFrequency userIdentityFrequency, String str7, int i12, Object obj) {
        AdInfo adInfo2 = adInfo;
        int i13 = i12;
        return adInfo.copy((i13 & 1) != 0 ? adInfo2.ad_id : str, (i13 & 2) != 0 ? adInfo2.media_type : str2, (i13 & 4) != 0 ? adInfo2.url : str3, (i13 & 8) != 0 ? adInfo2.ad_name : str4, (i13 & 16) != 0 ? adInfo2.action_type : str5, (i13 & 32) != 0 ? adInfo2.action : str6, (i13 & 64) != 0 ? adInfo2.show_adsflag : i10, (i13 & 128) != 0 ? adInfo2.show_frequency : i11, (i13 & 256) != 0 ? adInfo2.show_frequency_v2 : userIdentityFrequency, (i13 & 512) != 0 ? adInfo2.is_dealer : str7);
    }

    public final String component1() {
        return this.ad_id;
    }

    public final String component10() {
        return this.is_dealer;
    }

    public final String component2() {
        return this.media_type;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.ad_name;
    }

    public final String component5() {
        return this.action_type;
    }

    public final String component6() {
        return this.action;
    }

    public final int component7() {
        return this.show_adsflag;
    }

    public final int component8() {
        return this.show_frequency;
    }

    public final UserIdentityFrequency component9() {
        return this.show_frequency_v2;
    }

    public final AdInfo copy(String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, UserIdentityFrequency userIdentityFrequency, String str7) {
        i.g(str, "ad_id");
        i.g(str2, "media_type");
        return new AdInfo(str, str2, str3, str4, str5, str6, i10, i11, userIdentityFrequency, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdInfo)) {
            return false;
        }
        AdInfo adInfo = (AdInfo) obj;
        return i.b(this.ad_id, adInfo.ad_id) && i.b(this.media_type, adInfo.media_type) && i.b(this.url, adInfo.url) && i.b(this.ad_name, adInfo.ad_name) && i.b(this.action_type, adInfo.action_type) && i.b(this.action, adInfo.action) && this.show_adsflag == adInfo.show_adsflag && this.show_frequency == adInfo.show_frequency && i.b(this.show_frequency_v2, adInfo.show_frequency_v2) && i.b(this.is_dealer, adInfo.is_dealer);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getAction_type() {
        return this.action_type;
    }

    public final String getAd_id() {
        return this.ad_id;
    }

    public final String getAd_name() {
        return this.ad_name;
    }

    public final Integer getIdentityFrequency(String str, String str2) {
        UserIdentityFrequency userIdentityFrequency;
        UserIdentityFrequency userIdentityFrequency2;
        UserIdentityFrequency userIdentityFrequency3;
        i.g(str, "userIdentity");
        i.g(str2, "hasPay");
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1") && (userIdentityFrequency = this.show_frequency_v2) != null) {
                    return userIdentityFrequency.getIdentity_1();
                }
                return null;
            case 50:
                if (str.equals("2") && (userIdentityFrequency2 = this.show_frequency_v2) != null) {
                    return userIdentityFrequency2.getIdentity_2();
                }
                return null;
            case 51:
                if (str.equals("3") && (userIdentityFrequency3 = this.show_frequency_v2) != null) {
                    return userIdentityFrequency3.getIdentity_3();
                }
                return null;
            case 52:
                if (!str.equals("4")) {
                    return null;
                }
                if (i.b(str2, "0")) {
                    UserIdentityFrequency userIdentityFrequency4 = this.show_frequency_v2;
                    if (userIdentityFrequency4 != null) {
                        return userIdentityFrequency4.getIdentity_5();
                    }
                    return null;
                }
                UserIdentityFrequency userIdentityFrequency5 = this.show_frequency_v2;
                if (userIdentityFrequency5 != null) {
                    return userIdentityFrequency5.getIdentity_4();
                }
                return null;
            default:
                return null;
        }
    }

    public final String getMedia_type() {
        return this.media_type;
    }

    public final int getShow_adsflag() {
        return this.show_adsflag;
    }

    public final int getShow_frequency() {
        return this.show_frequency;
    }

    public final UserIdentityFrequency getShow_frequency_v2() {
        return this.show_frequency_v2;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = ((this.ad_id.hashCode() * 31) + this.media_type.hashCode()) * 31;
        String str = this.url;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ad_name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.action_type;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.action;
        int hashCode5 = (((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.show_adsflag) * 31) + this.show_frequency) * 31;
        UserIdentityFrequency userIdentityFrequency = this.show_frequency_v2;
        int hashCode6 = (hashCode5 + (userIdentityFrequency == null ? 0 : userIdentityFrequency.hashCode())) * 31;
        String str5 = this.is_dealer;
        if (str5 != null) {
            i10 = str5.hashCode();
        }
        return hashCode6 + i10;
    }

    public final boolean isShowFlag() {
        if (this.show_adsflag == 0) {
            return true;
        }
        return false;
    }

    public final String is_dealer() {
        return this.is_dealer;
    }

    public final void setAction(String str) {
        this.action = str;
    }

    public final void setAction_type(String str) {
        this.action_type = str;
    }

    public final void setAd_id(String str) {
        i.g(str, "<set-?>");
        this.ad_id = str;
    }

    public final void setAd_name(String str) {
        this.ad_name = str;
    }

    public final void setMedia_type(String str) {
        i.g(str, "<set-?>");
        this.media_type = str;
    }

    public final void setShow_adsflag(int i10) {
        this.show_adsflag = i10;
    }

    public final void setShow_frequency(int i10) {
        this.show_frequency = i10;
    }

    public final void setShow_frequency_v2(UserIdentityFrequency userIdentityFrequency) {
        this.show_frequency_v2 = userIdentityFrequency;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void set_dealer(String str) {
        this.is_dealer = str;
    }

    public String toString() {
        return "AdInfo(ad_id=" + this.ad_id + ", media_type=" + this.media_type + ", url=" + this.url + ", ad_name=" + this.ad_name + ", action_type=" + this.action_type + ", action=" + this.action + ", show_adsflag=" + this.show_adsflag + ", show_frequency=" + this.show_frequency + ", show_frequency_v2=" + this.show_frequency_v2 + ", is_dealer=" + this.is_dealer + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdInfo(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, int r21, com.advertlib.bean.UserIdentityFrequency r22, java.lang.String r23, int r24, t9.g r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r10 = 0
            goto L_0x000b
        L_0x0009:
            r10 = r21
        L_0x000b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0012
            r0 = 0
            r11 = r0
            goto L_0x0014
        L_0x0012:
            r11 = r22
        L_0x0014:
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r12 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.advertlib.bean.AdInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, com.advertlib.bean.UserIdentityFrequency, java.lang.String, int, t9.g):void");
    }
}
