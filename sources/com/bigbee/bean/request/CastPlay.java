package com.bigbee.bean.request;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.Device;
import com.taobao.accs.common.Constants;
import t1.a;
import t9.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class CastPlay {
    private String buss;
    private String cast_ver;
    private Device1 device;
    private long duration;
    private String encode;
    private String episode;
    private long err;
    private String err_msg;
    private String format;
    private String host;
    private int httping_err;
    private String lang;
    private String media;
    private long prepare_spent;
    private String program;
    private String quality;
    private String session;
    private String title;

    public CastPlay(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j10, long j11, Device1 device1, long j12, String str12, String str13, int i10) {
        String str14 = str;
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
        Device1 device12 = device1;
        String str25 = str12;
        String str26 = str13;
        i.g(str14, "cast_ver");
        i.g(str15, "program");
        i.g(str16, "title");
        i.g(str17, "episode");
        i.g(str18, "buss");
        i.g(str19, "media");
        i.g(str20, IjkMediaMeta.IJKM_KEY_FORMAT);
        i.g(str21, "encode");
        i.g(str22, "quality");
        i.g(str23, "lang");
        i.g(str24, "session");
        i.g(device12, Device.ELEM_NAME);
        i.g(str25, "err_msg");
        i.g(str26, Constants.KEY_HOST);
        this.cast_ver = str14;
        this.program = str15;
        this.title = str16;
        this.episode = str17;
        this.buss = str18;
        this.media = str19;
        this.format = str20;
        this.encode = str21;
        this.quality = str22;
        this.lang = str23;
        this.session = str24;
        this.duration = j10;
        this.prepare_spent = j11;
        this.device = device12;
        this.err = j12;
        this.err_msg = str25;
        this.host = str26;
        this.httping_err = i10;
    }

    public static /* synthetic */ CastPlay copy$default(CastPlay castPlay, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j10, long j11, Device1 device1, long j12, String str12, String str13, int i10, int i11, Object obj) {
        CastPlay castPlay2 = castPlay;
        int i12 = i11;
        return castPlay.copy((i12 & 1) != 0 ? castPlay2.cast_ver : str, (i12 & 2) != 0 ? castPlay2.program : str2, (i12 & 4) != 0 ? castPlay2.title : str3, (i12 & 8) != 0 ? castPlay2.episode : str4, (i12 & 16) != 0 ? castPlay2.buss : str5, (i12 & 32) != 0 ? castPlay2.media : str6, (i12 & 64) != 0 ? castPlay2.format : str7, (i12 & 128) != 0 ? castPlay2.encode : str8, (i12 & 256) != 0 ? castPlay2.quality : str9, (i12 & 512) != 0 ? castPlay2.lang : str10, (i12 & 1024) != 0 ? castPlay2.session : str11, (i12 & 2048) != 0 ? castPlay2.duration : j10, (i12 & 4096) != 0 ? castPlay2.prepare_spent : j11, (i12 & 8192) != 0 ? castPlay2.device : device1, (i12 & 16384) != 0 ? castPlay2.err : j12, (32768 & i12) != 0 ? castPlay2.err_msg : str12, (i12 & 65536) != 0 ? castPlay2.host : str13, (i12 & 131072) != 0 ? castPlay2.httping_err : i10);
    }

    public final String component1() {
        return this.cast_ver;
    }

    public final String component10() {
        return this.lang;
    }

    public final String component11() {
        return this.session;
    }

    public final long component12() {
        return this.duration;
    }

    public final long component13() {
        return this.prepare_spent;
    }

    public final Device1 component14() {
        return this.device;
    }

    public final long component15() {
        return this.err;
    }

    public final String component16() {
        return this.err_msg;
    }

    public final String component17() {
        return this.host;
    }

    public final int component18() {
        return this.httping_err;
    }

    public final String component2() {
        return this.program;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.episode;
    }

    public final String component5() {
        return this.buss;
    }

    public final String component6() {
        return this.media;
    }

    public final String component7() {
        return this.format;
    }

    public final String component8() {
        return this.encode;
    }

    public final String component9() {
        return this.quality;
    }

    public final CastPlay copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j10, long j11, Device1 device1, long j12, String str12, String str13, int i10) {
        String str14 = str;
        i.g(str14, "cast_ver");
        i.g(str2, "program");
        i.g(str3, "title");
        i.g(str4, "episode");
        i.g(str5, "buss");
        i.g(str6, "media");
        i.g(str7, IjkMediaMeta.IJKM_KEY_FORMAT);
        i.g(str8, "encode");
        i.g(str9, "quality");
        i.g(str10, "lang");
        i.g(str11, "session");
        i.g(device1, Device.ELEM_NAME);
        i.g(str12, "err_msg");
        i.g(str13, Constants.KEY_HOST);
        return new CastPlay(str14, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, j10, j11, device1, j12, str12, str13, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CastPlay)) {
            return false;
        }
        CastPlay castPlay = (CastPlay) obj;
        return i.b(this.cast_ver, castPlay.cast_ver) && i.b(this.program, castPlay.program) && i.b(this.title, castPlay.title) && i.b(this.episode, castPlay.episode) && i.b(this.buss, castPlay.buss) && i.b(this.media, castPlay.media) && i.b(this.format, castPlay.format) && i.b(this.encode, castPlay.encode) && i.b(this.quality, castPlay.quality) && i.b(this.lang, castPlay.lang) && i.b(this.session, castPlay.session) && this.duration == castPlay.duration && this.prepare_spent == castPlay.prepare_spent && i.b(this.device, castPlay.device) && this.err == castPlay.err && i.b(this.err_msg, castPlay.err_msg) && i.b(this.host, castPlay.host) && this.httping_err == castPlay.httping_err;
    }

    public final String getBuss() {
        return this.buss;
    }

    public final String getCast_ver() {
        return this.cast_ver;
    }

    public final Device1 getDevice() {
        return this.device;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getEncode() {
        return this.encode;
    }

    public final String getEpisode() {
        return this.episode;
    }

    public final long getErr() {
        return this.err;
    }

    public final String getErr_msg() {
        return this.err_msg;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getHttping_err() {
        return this.httping_err;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getMedia() {
        return this.media;
    }

    public final long getPrepare_spent() {
        return this.prepare_spent;
    }

    public final String getProgram() {
        return this.program;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getSession() {
        return this.session;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.cast_ver.hashCode() * 31) + this.program.hashCode()) * 31) + this.title.hashCode()) * 31) + this.episode.hashCode()) * 31) + this.buss.hashCode()) * 31) + this.media.hashCode()) * 31) + this.format.hashCode()) * 31) + this.encode.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.session.hashCode()) * 31) + a.a(this.duration)) * 31) + a.a(this.prepare_spent)) * 31) + this.device.hashCode()) * 31) + a.a(this.err)) * 31) + this.err_msg.hashCode()) * 31) + this.host.hashCode()) * 31) + this.httping_err;
    }

    public final void setBuss(String str) {
        i.g(str, "<set-?>");
        this.buss = str;
    }

    public final void setCast_ver(String str) {
        i.g(str, "<set-?>");
        this.cast_ver = str;
    }

    public final void setDevice(Device1 device1) {
        i.g(device1, "<set-?>");
        this.device = device1;
    }

    public final void setDuration(long j10) {
        this.duration = j10;
    }

    public final void setEncode(String str) {
        i.g(str, "<set-?>");
        this.encode = str;
    }

    public final void setEpisode(String str) {
        i.g(str, "<set-?>");
        this.episode = str;
    }

    public final void setErr(long j10) {
        this.err = j10;
    }

    public final void setErr_msg(String str) {
        i.g(str, "<set-?>");
        this.err_msg = str;
    }

    public final void setFormat(String str) {
        i.g(str, "<set-?>");
        this.format = str;
    }

    public final void setHost(String str) {
        i.g(str, "<set-?>");
        this.host = str;
    }

    public final void setHttping_err(int i10) {
        this.httping_err = i10;
    }

    public final void setLang(String str) {
        i.g(str, "<set-?>");
        this.lang = str;
    }

    public final void setMedia(String str) {
        i.g(str, "<set-?>");
        this.media = str;
    }

    public final void setPrepare_spent(long j10) {
        this.prepare_spent = j10;
    }

    public final void setProgram(String str) {
        i.g(str, "<set-?>");
        this.program = str;
    }

    public final void setQuality(String str) {
        i.g(str, "<set-?>");
        this.quality = str;
    }

    public final void setSession(String str) {
        i.g(str, "<set-?>");
        this.session = str;
    }

    public final void setTitle(String str) {
        i.g(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "CastPlay(cast_ver=" + this.cast_ver + ", program=" + this.program + ", title=" + this.title + ", episode=" + this.episode + ", buss=" + this.buss + ", media=" + this.media + ", format=" + this.format + ", encode=" + this.encode + ", quality=" + this.quality + ", lang=" + this.lang + ", session=" + this.session + ", duration=" + this.duration + ", prepare_spent=" + this.prepare_spent + ", device=" + this.device + ", err=" + this.err + ", err_msg=" + this.err_msg + ", host=" + this.host + ", httping_err=" + this.httping_err + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
