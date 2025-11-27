package com.titans.entity;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t1.a;
import t9.i;

public final class ProgramInfo implements Serializable {
    private String app_ctx;
    private String buss;
    private long delay;
    private String desc;
    private String lang;
    private String program_code;
    private String quality;
    private List<Sources> sources;
    private long start;
    private long timeout;

    public ProgramInfo(String str, String str2, String str3, String str4, long j10, long j11, List<Sources> list, long j12, String str5, String str6) {
        i.g(str, "program_code");
        i.g(str2, "buss");
        i.g(str3, "desc");
        i.g(str4, "quality");
        i.g(list, "sources");
        i.g(str5, "lang");
        i.g(str6, "app_ctx");
        this.program_code = str;
        this.buss = str2;
        this.desc = str3;
        this.quality = str4;
        this.delay = j10;
        this.timeout = j11;
        this.sources = list;
        this.start = j12;
        this.lang = str5;
        this.app_ctx = str6;
    }

    public static /* synthetic */ ProgramInfo copy$default(ProgramInfo programInfo, String str, String str2, String str3, String str4, long j10, long j11, List list, long j12, String str5, String str6, int i10, Object obj) {
        ProgramInfo programInfo2 = programInfo;
        int i11 = i10;
        return programInfo.copy((i11 & 1) != 0 ? programInfo2.program_code : str, (i11 & 2) != 0 ? programInfo2.buss : str2, (i11 & 4) != 0 ? programInfo2.desc : str3, (i11 & 8) != 0 ? programInfo2.quality : str4, (i11 & 16) != 0 ? programInfo2.delay : j10, (i11 & 32) != 0 ? programInfo2.timeout : j11, (i11 & 64) != 0 ? programInfo2.sources : list, (i11 & 128) != 0 ? programInfo2.start : j12, (i11 & 256) != 0 ? programInfo2.lang : str5, (i11 & 512) != 0 ? programInfo2.app_ctx : str6);
    }

    public final String component1() {
        return this.program_code;
    }

    public final String component10() {
        return this.app_ctx;
    }

    public final String component2() {
        return this.buss;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.quality;
    }

    public final long component5() {
        return this.delay;
    }

    public final long component6() {
        return this.timeout;
    }

    public final List<Sources> component7() {
        return this.sources;
    }

    public final long component8() {
        return this.start;
    }

    public final String component9() {
        return this.lang;
    }

    public final ProgramInfo copy(String str, String str2, String str3, String str4, long j10, long j11, List<Sources> list, long j12, String str5, String str6) {
        String str7 = str;
        i.g(str7, "program_code");
        String str8 = str2;
        i.g(str8, "buss");
        String str9 = str3;
        i.g(str9, "desc");
        String str10 = str4;
        i.g(str10, "quality");
        List<Sources> list2 = list;
        i.g(list2, "sources");
        String str11 = str5;
        i.g(str11, "lang");
        String str12 = str6;
        i.g(str12, "app_ctx");
        return new ProgramInfo(str7, str8, str9, str10, j10, j11, list2, j12, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgramInfo)) {
            return false;
        }
        ProgramInfo programInfo = (ProgramInfo) obj;
        return i.b(this.program_code, programInfo.program_code) && i.b(this.buss, programInfo.buss) && i.b(this.desc, programInfo.desc) && i.b(this.quality, programInfo.quality) && this.delay == programInfo.delay && this.timeout == programInfo.timeout && i.b(this.sources, programInfo.sources) && this.start == programInfo.start && i.b(this.lang, programInfo.lang) && i.b(this.app_ctx, programInfo.app_ctx);
    }

    public final String getApp_ctx() {
        return this.app_ctx;
    }

    public final String getBuss() {
        return this.buss;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getProgram_code() {
        return this.program_code;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final List<Sources> getSources() {
        return this.sources;
    }

    public final long getStart() {
        return this.start;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public int hashCode() {
        return (((((((((((((((((this.program_code.hashCode() * 31) + this.buss.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.quality.hashCode()) * 31) + a.a(this.delay)) * 31) + a.a(this.timeout)) * 31) + this.sources.hashCode()) * 31) + a.a(this.start)) * 31) + this.lang.hashCode()) * 31) + this.app_ctx.hashCode();
    }

    public final void setApp_ctx(String str) {
        i.g(str, "<set-?>");
        this.app_ctx = str;
    }

    public final void setBuss(String str) {
        i.g(str, "<set-?>");
        this.buss = str;
    }

    public final void setDelay(long j10) {
        this.delay = j10;
    }

    public final void setDesc(String str) {
        i.g(str, "<set-?>");
        this.desc = str;
    }

    public final void setLang(String str) {
        i.g(str, "<set-?>");
        this.lang = str;
    }

    public final void setProgram_code(String str) {
        i.g(str, "<set-?>");
        this.program_code = str;
    }

    public final void setQuality(String str) {
        i.g(str, "<set-?>");
        this.quality = str;
    }

    public final void setSources(List<Sources> list) {
        i.g(list, "<set-?>");
        this.sources = list;
    }

    public final void setStart(long j10) {
        this.start = j10;
    }

    public final void setTimeout(long j10) {
        this.timeout = j10;
    }

    public String toString() {
        return "ProgramInfo(program_code=" + this.program_code + ", buss=" + this.buss + ", desc=" + this.desc + ", quality=" + this.quality + ", delay=" + this.delay + ", timeout=" + this.timeout + ", sources=" + this.sources + ", start=" + this.start + ", lang=" + this.lang + ", app_ctx=" + this.app_ctx + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ProgramInfo(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, long r22, long r24, java.util.List r26, long r27, java.lang.String r29, java.lang.String r30, int r31, t9.g r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x000a
            r1 = 0
            r13 = r1
            goto L_0x000c
        L_0x000a:
            r13 = r27
        L_0x000c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0014
            java.lang.String r0 = ""
            r15 = r0
            goto L_0x0016
        L_0x0014:
            r15 = r29
        L_0x0016:
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r10 = r24
            r12 = r26
            r16 = r30
            r3.<init>(r4, r5, r6, r7, r8, r10, r12, r13, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.titans.entity.ProgramInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.util.List, long, java.lang.String, java.lang.String, int, t9.g):void");
    }
}
