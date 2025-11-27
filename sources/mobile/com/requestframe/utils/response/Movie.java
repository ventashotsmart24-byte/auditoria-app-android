package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

public final class Movie implements Serializable {
    private String audioInfo;
    private String audioType;
    private String bitRateType;
    private String contentId;
    private String encodeFormat;
    private List<License> licenseList;
    private String originalContentId;
    private String quality;
    private String screenFormat;
    private String terminalType;
    private String type;
    private String videoFormat;
    private String videoType;

    public Movie(String str, String str2, List<License> list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.contentId = str;
        this.type = str2;
        this.licenseList = list;
        this.audioType = str3;
        this.videoType = str4;
        this.screenFormat = str5;
        this.encodeFormat = str6;
        this.videoFormat = str7;
        this.quality = str8;
        this.bitRateType = str9;
        this.audioInfo = str10;
        this.terminalType = str11;
        this.originalContentId = str12;
    }

    public static /* synthetic */ Movie copy$default(Movie movie, String str, String str2, List list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i10, Object obj) {
        Movie movie2 = movie;
        int i11 = i10;
        return movie.copy((i11 & 1) != 0 ? movie2.contentId : str, (i11 & 2) != 0 ? movie2.type : str2, (i11 & 4) != 0 ? movie2.licenseList : list, (i11 & 8) != 0 ? movie2.audioType : str3, (i11 & 16) != 0 ? movie2.videoType : str4, (i11 & 32) != 0 ? movie2.screenFormat : str5, (i11 & 64) != 0 ? movie2.encodeFormat : str6, (i11 & 128) != 0 ? movie2.videoFormat : str7, (i11 & 256) != 0 ? movie2.quality : str8, (i11 & 512) != 0 ? movie2.bitRateType : str9, (i11 & 1024) != 0 ? movie2.audioInfo : str10, (i11 & 2048) != 0 ? movie2.terminalType : str11, (i11 & 4096) != 0 ? movie2.originalContentId : str12);
    }

    public final String component1() {
        return this.contentId;
    }

    public final String component10() {
        return this.bitRateType;
    }

    public final String component11() {
        return this.audioInfo;
    }

    public final String component12() {
        return this.terminalType;
    }

    public final String component13() {
        return this.originalContentId;
    }

    public final String component2() {
        return this.type;
    }

    public final List<License> component3() {
        return this.licenseList;
    }

    public final String component4() {
        return this.audioType;
    }

    public final String component5() {
        return this.videoType;
    }

    public final String component6() {
        return this.screenFormat;
    }

    public final String component7() {
        return this.encodeFormat;
    }

    public final String component8() {
        return this.videoFormat;
    }

    public final String component9() {
        return this.quality;
    }

    public final Movie copy(String str, String str2, List<License> list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return new Movie(str, str2, list, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) obj;
        return i.b(this.contentId, movie.contentId) && i.b(this.type, movie.type) && i.b(this.licenseList, movie.licenseList) && i.b(this.audioType, movie.audioType) && i.b(this.videoType, movie.videoType) && i.b(this.screenFormat, movie.screenFormat) && i.b(this.encodeFormat, movie.encodeFormat) && i.b(this.videoFormat, movie.videoFormat) && i.b(this.quality, movie.quality) && i.b(this.bitRateType, movie.bitRateType) && i.b(this.audioInfo, movie.audioInfo) && i.b(this.terminalType, movie.terminalType) && i.b(this.originalContentId, movie.originalContentId);
    }

    public final String getAudioInfo() {
        return this.audioInfo;
    }

    public final String getAudioType() {
        return this.audioType;
    }

    public final String getBitRateType() {
        return this.bitRateType;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getEncodeFormat() {
        return this.encodeFormat;
    }

    public final List<License> getLicenseList() {
        return this.licenseList;
    }

    public final String getOriginalContentId() {
        return this.originalContentId;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getScreenFormat() {
        return this.screenFormat;
    }

    public final String getTerminalType() {
        return this.terminalType;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVideoFormat() {
        return this.videoFormat;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public int hashCode() {
        String str = this.contentId;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<License> list = this.licenseList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.audioType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.videoType;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.screenFormat;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.encodeFormat;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.videoFormat;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.quality;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.bitRateType;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.audioInfo;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.terminalType;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.originalContentId;
        if (str12 != null) {
            i10 = str12.hashCode();
        }
        return hashCode12 + i10;
    }

    public final void setAudioInfo(String str) {
        this.audioInfo = str;
    }

    public final void setAudioType(String str) {
        this.audioType = str;
    }

    public final void setBitRateType(String str) {
        this.bitRateType = str;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setEncodeFormat(String str) {
        this.encodeFormat = str;
    }

    public final void setLicenseList(List<License> list) {
        this.licenseList = list;
    }

    public final void setOriginalContentId(String str) {
        this.originalContentId = str;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public final void setScreenFormat(String str) {
        this.screenFormat = str;
    }

    public final void setTerminalType(String str) {
        this.terminalType = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setVideoFormat(String str) {
        this.videoFormat = str;
    }

    public final void setVideoType(String str) {
        this.videoType = str;
    }

    public String toString() {
        return "Movie(contentId=" + this.contentId + ", type=" + this.type + ", licenseList=" + this.licenseList + ", audioType=" + this.audioType + ", videoType=" + this.videoType + ", screenFormat=" + this.screenFormat + ", encodeFormat=" + this.encodeFormat + ", videoFormat=" + this.videoFormat + ", quality=" + this.quality + ", bitRateType=" + this.bitRateType + ", audioInfo=" + this.audioInfo + ", terminalType=" + this.terminalType + ", originalContentId=" + this.originalContentId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
