package com.titans.entity;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.utl.BaseMonitor;
import t9.i;

public final class Sources {
    private String auth;
    private String format;
    private String id;
    private String id_code;
    private String lang;
    private String license;
    private String main_addr;
    private String main_addr_code;
    private String media_code;
    private int priority;
    private String quality;
    private String rule_id_code;
    private String spared_addr;
    private String spared_addr_code;
    private String tag;
    private int weight;

    public Sources(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i11, String str14) {
        String str15 = str2;
        String str16 = str3;
        String str17 = str4;
        String str18 = str5;
        String str19 = str6;
        String str20 = str7;
        String str21 = str8;
        String str22 = str9;
        String str23 = str10;
        String str24 = str11;
        i.g(str, "media_code");
        i.g(str15, "main_addr");
        i.g(str16, "spared_addr");
        i.g(str17, BaseMonitor.ALARM_POINT_AUTH);
        i.g(str18, "license");
        i.g(str19, "tag");
        i.g(str20, "quality");
        i.g(str21, "main_addr_code");
        i.g(str22, "spared_addr_code");
        i.g(str23, "lang");
        i.g(str24, "id");
        this.priority = i10;
        this.media_code = str;
        this.main_addr = str15;
        this.spared_addr = str16;
        this.auth = str17;
        this.license = str18;
        this.tag = str19;
        this.quality = str20;
        this.main_addr_code = str21;
        this.spared_addr_code = str22;
        this.lang = str23;
        this.id = str24;
        this.id_code = str12;
        this.rule_id_code = str13;
        this.weight = i11;
        this.format = str14;
    }

    public static /* synthetic */ Sources copy$default(Sources sources, int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i11, String str14, int i12, Object obj) {
        Sources sources2 = sources;
        int i13 = i12;
        return sources.copy((i13 & 1) != 0 ? sources2.priority : i10, (i13 & 2) != 0 ? sources2.media_code : str, (i13 & 4) != 0 ? sources2.main_addr : str2, (i13 & 8) != 0 ? sources2.spared_addr : str3, (i13 & 16) != 0 ? sources2.auth : str4, (i13 & 32) != 0 ? sources2.license : str5, (i13 & 64) != 0 ? sources2.tag : str6, (i13 & 128) != 0 ? sources2.quality : str7, (i13 & 256) != 0 ? sources2.main_addr_code : str8, (i13 & 512) != 0 ? sources2.spared_addr_code : str9, (i13 & 1024) != 0 ? sources2.lang : str10, (i13 & 2048) != 0 ? sources2.id : str11, (i13 & 4096) != 0 ? sources2.id_code : str12, (i13 & 8192) != 0 ? sources2.rule_id_code : str13, (i13 & 16384) != 0 ? sources2.weight : i11, (i13 & 32768) != 0 ? sources2.format : str14);
    }

    public final int component1() {
        return this.priority;
    }

    public final String component10() {
        return this.spared_addr_code;
    }

    public final String component11() {
        return this.lang;
    }

    public final String component12() {
        return this.id;
    }

    public final String component13() {
        return this.id_code;
    }

    public final String component14() {
        return this.rule_id_code;
    }

    public final int component15() {
        return this.weight;
    }

    public final String component16() {
        return this.format;
    }

    public final String component2() {
        return this.media_code;
    }

    public final String component3() {
        return this.main_addr;
    }

    public final String component4() {
        return this.spared_addr;
    }

    public final String component5() {
        return this.auth;
    }

    public final String component6() {
        return this.license;
    }

    public final String component7() {
        return this.tag;
    }

    public final String component8() {
        return this.quality;
    }

    public final String component9() {
        return this.main_addr_code;
    }

    public final Sources copy(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i11, String str14) {
        int i12 = i10;
        i.g(str, "media_code");
        i.g(str2, "main_addr");
        i.g(str3, "spared_addr");
        i.g(str4, BaseMonitor.ALARM_POINT_AUTH);
        i.g(str5, "license");
        i.g(str6, "tag");
        i.g(str7, "quality");
        i.g(str8, "main_addr_code");
        i.g(str9, "spared_addr_code");
        i.g(str10, "lang");
        i.g(str11, "id");
        return new Sources(i10, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, i11, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sources)) {
            return false;
        }
        Sources sources = (Sources) obj;
        return this.priority == sources.priority && i.b(this.media_code, sources.media_code) && i.b(this.main_addr, sources.main_addr) && i.b(this.spared_addr, sources.spared_addr) && i.b(this.auth, sources.auth) && i.b(this.license, sources.license) && i.b(this.tag, sources.tag) && i.b(this.quality, sources.quality) && i.b(this.main_addr_code, sources.main_addr_code) && i.b(this.spared_addr_code, sources.spared_addr_code) && i.b(this.lang, sources.lang) && i.b(this.id, sources.id) && i.b(this.id_code, sources.id_code) && i.b(this.rule_id_code, sources.rule_id_code) && this.weight == sources.weight && i.b(this.format, sources.format);
    }

    public final String getAuth() {
        return this.auth;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getId() {
        return this.id;
    }

    public final String getId_code() {
        return this.id_code;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getMain_addr() {
        return this.main_addr;
    }

    public final String getMain_addr_code() {
        return this.main_addr_code;
    }

    public final String getMedia_code() {
        return this.media_code;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getRule_id_code() {
        return this.rule_id_code;
    }

    public final String getSpared_addr() {
        return this.spared_addr;
    }

    public final String getSpared_addr_code() {
        return this.spared_addr_code;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.priority * 31) + this.media_code.hashCode()) * 31) + this.main_addr.hashCode()) * 31) + this.spared_addr.hashCode()) * 31) + this.auth.hashCode()) * 31) + this.license.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.main_addr_code.hashCode()) * 31) + this.spared_addr_code.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.id.hashCode()) * 31;
        String str = this.id_code;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.rule_id_code;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.weight) * 31;
        String str3 = this.format;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode3 + i10;
    }

    public final void setAuth(String str) {
        i.g(str, "<set-?>");
        this.auth = str;
    }

    public final void setFormat(String str) {
        this.format = str;
    }

    public final void setId(String str) {
        i.g(str, "<set-?>");
        this.id = str;
    }

    public final void setId_code(String str) {
        this.id_code = str;
    }

    public final void setLang(String str) {
        i.g(str, "<set-?>");
        this.lang = str;
    }

    public final void setLicense(String str) {
        i.g(str, "<set-?>");
        this.license = str;
    }

    public final void setMain_addr(String str) {
        i.g(str, "<set-?>");
        this.main_addr = str;
    }

    public final void setMain_addr_code(String str) {
        i.g(str, "<set-?>");
        this.main_addr_code = str;
    }

    public final void setMedia_code(String str) {
        i.g(str, "<set-?>");
        this.media_code = str;
    }

    public final void setPriority(int i10) {
        this.priority = i10;
    }

    public final void setQuality(String str) {
        i.g(str, "<set-?>");
        this.quality = str;
    }

    public final void setRule_id_code(String str) {
        this.rule_id_code = str;
    }

    public final void setSpared_addr(String str) {
        i.g(str, "<set-?>");
        this.spared_addr = str;
    }

    public final void setSpared_addr_code(String str) {
        i.g(str, "<set-?>");
        this.spared_addr_code = str;
    }

    public final void setTag(String str) {
        i.g(str, "<set-?>");
        this.tag = str;
    }

    public final void setWeight(int i10) {
        this.weight = i10;
    }

    public String toString() {
        return "Sources(priority=" + this.priority + ", media_code=" + this.media_code + ", main_addr=" + this.main_addr + ", spared_addr=" + this.spared_addr + ", auth=" + this.auth + ", license=" + this.license + ", tag=" + this.tag + ", quality=" + this.quality + ", main_addr_code=" + this.main_addr_code + ", spared_addr_code=" + this.spared_addr_code + ", lang=" + this.lang + ", id=" + this.id + ", id_code=" + this.id_code + ", rule_id_code=" + this.rule_id_code + ", weight=" + this.weight + ", format=" + this.format + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Sources(int r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, int r35, java.lang.String r36, int r37, t9.g r38) {
        /*
            r20 = this;
            r0 = r37
            r1 = r0 & 1024(0x400, float:1.435E-42)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r14 = r2
            goto L_0x000c
        L_0x000a:
            r14 = r31
        L_0x000c:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0012
            r15 = r2
            goto L_0x0014
        L_0x0012:
            r15 = r32
        L_0x0014:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x001d
            r19 = r2
            goto L_0x001f
        L_0x001d:
            r19 = r36
        L_0x001f:
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r16 = r33
            r17 = r34
            r18 = r35
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.titans.entity.Sources.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, t9.g):void");
    }
}
