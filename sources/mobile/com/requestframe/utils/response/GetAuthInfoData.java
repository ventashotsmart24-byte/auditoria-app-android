package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

public final class GetAuthInfoData {
    private String activeTime;
    private List<AuthInfo> authInfoList;
    private String bindMail;
    private String childLockPwd;
    private Integer expRemainingDays;
    private String hasPay;
    private String hasPwd;
    private String nowTime;
    private String payCoreAddress;
    private String playlistUrl;
    private String qrcodeDisplay;
    private String qrcodeMessage;
    private Integer remainingDays;
    private String renewFlag;
    private String restrictedStatus;
    private String showFlag;
    private String tips;
    private String type;
    private String userIdentity;
    private String userType;

    public GetAuthInfoData(List<AuthInfo> list, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        String str18 = str9;
        String str19 = str10;
        String str20 = str11;
        String str21 = str13;
        String str22 = str14;
        i.g(str, "showFlag");
        i.g(str18, "bindMail");
        i.g(str19, "hasPay");
        i.g(str20, "restrictedStatus");
        i.g(str21, "userIdentity");
        i.g(str22, "hasPwd");
        this.authInfoList = list;
        this.showFlag = str;
        this.nowTime = str2;
        this.tips = str3;
        this.type = str4;
        this.remainingDays = num;
        this.expRemainingDays = num2;
        this.qrcodeMessage = str5;
        this.qrcodeDisplay = str6;
        this.payCoreAddress = str7;
        this.userType = str8;
        this.bindMail = str18;
        this.hasPay = str19;
        this.restrictedStatus = str20;
        this.childLockPwd = str12;
        this.userIdentity = str21;
        this.hasPwd = str22;
        this.playlistUrl = str15;
        this.activeTime = str16;
        this.renewFlag = str17;
    }

    public static /* synthetic */ GetAuthInfoData copy$default(GetAuthInfoData getAuthInfoData, List list, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i10, Object obj) {
        GetAuthInfoData getAuthInfoData2 = getAuthInfoData;
        int i11 = i10;
        return getAuthInfoData.copy((i11 & 1) != 0 ? getAuthInfoData2.authInfoList : list, (i11 & 2) != 0 ? getAuthInfoData2.showFlag : str, (i11 & 4) != 0 ? getAuthInfoData2.nowTime : str2, (i11 & 8) != 0 ? getAuthInfoData2.tips : str3, (i11 & 16) != 0 ? getAuthInfoData2.type : str4, (i11 & 32) != 0 ? getAuthInfoData2.remainingDays : num, (i11 & 64) != 0 ? getAuthInfoData2.expRemainingDays : num2, (i11 & 128) != 0 ? getAuthInfoData2.qrcodeMessage : str5, (i11 & 256) != 0 ? getAuthInfoData2.qrcodeDisplay : str6, (i11 & 512) != 0 ? getAuthInfoData2.payCoreAddress : str7, (i11 & 1024) != 0 ? getAuthInfoData2.userType : str8, (i11 & 2048) != 0 ? getAuthInfoData2.bindMail : str9, (i11 & 4096) != 0 ? getAuthInfoData2.hasPay : str10, (i11 & 8192) != 0 ? getAuthInfoData2.restrictedStatus : str11, (i11 & 16384) != 0 ? getAuthInfoData2.childLockPwd : str12, (i11 & 32768) != 0 ? getAuthInfoData2.userIdentity : str13, (i11 & 65536) != 0 ? getAuthInfoData2.hasPwd : str14, (i11 & 131072) != 0 ? getAuthInfoData2.playlistUrl : str15, (i11 & 262144) != 0 ? getAuthInfoData2.activeTime : str16, (i11 & 524288) != 0 ? getAuthInfoData2.renewFlag : str17);
    }

    public final List<AuthInfo> component1() {
        return this.authInfoList;
    }

    public final String component10() {
        return this.payCoreAddress;
    }

    public final String component11() {
        return this.userType;
    }

    public final String component12() {
        return this.bindMail;
    }

    public final String component13() {
        return this.hasPay;
    }

    public final String component14() {
        return this.restrictedStatus;
    }

    public final String component15() {
        return this.childLockPwd;
    }

    public final String component16() {
        return this.userIdentity;
    }

    public final String component17() {
        return this.hasPwd;
    }

    public final String component18() {
        return this.playlistUrl;
    }

    public final String component19() {
        return this.activeTime;
    }

    public final String component2() {
        return this.showFlag;
    }

    public final String component20() {
        return this.renewFlag;
    }

    public final String component3() {
        return this.nowTime;
    }

    public final String component4() {
        return this.tips;
    }

    public final String component5() {
        return this.type;
    }

    public final Integer component6() {
        return this.remainingDays;
    }

    public final Integer component7() {
        return this.expRemainingDays;
    }

    public final String component8() {
        return this.qrcodeMessage;
    }

    public final String component9() {
        return this.qrcodeDisplay;
    }

    public final GetAuthInfoData copy(List<AuthInfo> list, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        List<AuthInfo> list2 = list;
        i.g(str, "showFlag");
        i.g(str9, "bindMail");
        i.g(str10, "hasPay");
        i.g(str11, "restrictedStatus");
        i.g(str13, "userIdentity");
        i.g(str14, "hasPwd");
        return new GetAuthInfoData(list, str, str2, str3, str4, num, num2, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAuthInfoData)) {
            return false;
        }
        GetAuthInfoData getAuthInfoData = (GetAuthInfoData) obj;
        return i.b(this.authInfoList, getAuthInfoData.authInfoList) && i.b(this.showFlag, getAuthInfoData.showFlag) && i.b(this.nowTime, getAuthInfoData.nowTime) && i.b(this.tips, getAuthInfoData.tips) && i.b(this.type, getAuthInfoData.type) && i.b(this.remainingDays, getAuthInfoData.remainingDays) && i.b(this.expRemainingDays, getAuthInfoData.expRemainingDays) && i.b(this.qrcodeMessage, getAuthInfoData.qrcodeMessage) && i.b(this.qrcodeDisplay, getAuthInfoData.qrcodeDisplay) && i.b(this.payCoreAddress, getAuthInfoData.payCoreAddress) && i.b(this.userType, getAuthInfoData.userType) && i.b(this.bindMail, getAuthInfoData.bindMail) && i.b(this.hasPay, getAuthInfoData.hasPay) && i.b(this.restrictedStatus, getAuthInfoData.restrictedStatus) && i.b(this.childLockPwd, getAuthInfoData.childLockPwd) && i.b(this.userIdentity, getAuthInfoData.userIdentity) && i.b(this.hasPwd, getAuthInfoData.hasPwd) && i.b(this.playlistUrl, getAuthInfoData.playlistUrl) && i.b(this.activeTime, getAuthInfoData.activeTime) && i.b(this.renewFlag, getAuthInfoData.renewFlag);
    }

    public final String getActiveTime() {
        return this.activeTime;
    }

    public final List<AuthInfo> getAuthInfoList() {
        return this.authInfoList;
    }

    public final String getBindMail() {
        return this.bindMail;
    }

    public final String getChildLockPwd() {
        return this.childLockPwd;
    }

    public final Integer getExpRemainingDays() {
        return this.expRemainingDays;
    }

    public final String getHasPay() {
        return this.hasPay;
    }

    public final String getHasPwd() {
        return this.hasPwd;
    }

    public final String getNowTime() {
        return this.nowTime;
    }

    public final String getPayCoreAddress() {
        return this.payCoreAddress;
    }

    public final String getPlaylistUrl() {
        return this.playlistUrl;
    }

    public final String getQrcodeDisplay() {
        return this.qrcodeDisplay;
    }

    public final String getQrcodeMessage() {
        return this.qrcodeMessage;
    }

    public final Integer getRemainingDays() {
        return this.remainingDays;
    }

    public final String getRenewFlag() {
        return this.renewFlag;
    }

    public final String getRestrictedStatus() {
        return this.restrictedStatus;
    }

    public final String getShowFlag() {
        return this.showFlag;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserIdentity() {
        return this.userIdentity;
    }

    public final String getUserType() {
        return this.userType;
    }

    public int hashCode() {
        List<AuthInfo> list = this.authInfoList;
        int i10 = 0;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.showFlag.hashCode()) * 31;
        String str = this.nowTime;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tips;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.remainingDays;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.expRemainingDays;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.qrcodeMessage;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.qrcodeDisplay;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.payCoreAddress;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.userType;
        int hashCode10 = (((((((hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.bindMail.hashCode()) * 31) + this.hasPay.hashCode()) * 31) + this.restrictedStatus.hashCode()) * 31;
        String str8 = this.childLockPwd;
        int hashCode11 = (((((hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31) + this.userIdentity.hashCode()) * 31) + this.hasPwd.hashCode()) * 31;
        String str9 = this.playlistUrl;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.activeTime;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.renewFlag;
        if (str11 != null) {
            i10 = str11.hashCode();
        }
        return hashCode13 + i10;
    }

    public final void setActiveTime(String str) {
        this.activeTime = str;
    }

    public final void setAuthInfoList(List<AuthInfo> list) {
        this.authInfoList = list;
    }

    public final void setBindMail(String str) {
        i.g(str, "<set-?>");
        this.bindMail = str;
    }

    public final void setChildLockPwd(String str) {
        this.childLockPwd = str;
    }

    public final void setExpRemainingDays(Integer num) {
        this.expRemainingDays = num;
    }

    public final void setHasPay(String str) {
        i.g(str, "<set-?>");
        this.hasPay = str;
    }

    public final void setHasPwd(String str) {
        i.g(str, "<set-?>");
        this.hasPwd = str;
    }

    public final void setNowTime(String str) {
        this.nowTime = str;
    }

    public final void setPayCoreAddress(String str) {
        this.payCoreAddress = str;
    }

    public final void setPlaylistUrl(String str) {
        this.playlistUrl = str;
    }

    public final void setQrcodeDisplay(String str) {
        this.qrcodeDisplay = str;
    }

    public final void setQrcodeMessage(String str) {
        this.qrcodeMessage = str;
    }

    public final void setRemainingDays(Integer num) {
        this.remainingDays = num;
    }

    public final void setRenewFlag(String str) {
        this.renewFlag = str;
    }

    public final void setRestrictedStatus(String str) {
        i.g(str, "<set-?>");
        this.restrictedStatus = str;
    }

    public final void setShowFlag(String str) {
        i.g(str, "<set-?>");
        this.showFlag = str;
    }

    public final void setTips(String str) {
        this.tips = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUserIdentity(String str) {
        i.g(str, "<set-?>");
        this.userIdentity = str;
    }

    public final void setUserType(String str) {
        this.userType = str;
    }

    public String toString() {
        return "GetAuthInfoData(authInfoList=" + this.authInfoList + ", showFlag=" + this.showFlag + ", nowTime=" + this.nowTime + ", tips=" + this.tips + ", type=" + this.type + ", remainingDays=" + this.remainingDays + ", expRemainingDays=" + this.expRemainingDays + ", qrcodeMessage=" + this.qrcodeMessage + ", qrcodeDisplay=" + this.qrcodeDisplay + ", payCoreAddress=" + this.payCoreAddress + ", userType=" + this.userType + ", bindMail=" + this.bindMail + ", hasPay=" + this.hasPay + ", restrictedStatus=" + this.restrictedStatus + ", childLockPwd=" + this.childLockPwd + ", userIdentity=" + this.userIdentity + ", hasPwd=" + this.hasPwd + ", playlistUrl=" + this.playlistUrl + ", activeTime=" + this.activeTime + ", renewFlag=" + this.renewFlag + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
