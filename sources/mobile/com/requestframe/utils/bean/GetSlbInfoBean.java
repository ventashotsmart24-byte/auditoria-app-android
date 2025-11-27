package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

public final class GetSlbInfoBean {
    private String appParams;
    private String appVer;
    private int encMediaSupported;
    private String hasPay;
    private String lang;
    private List<String> liveCodeList;
    private String pipFlag;
    private String portalCode;
    private String reserve1;
    private String type;
    private String userId;
    private String userIdentity;
    private String userToken;

    public GetSlbInfoBean(int i10, String str, List<String> list, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        i.g(list, "liveCodeList");
        i.g(str2, "userToken");
        i.g(str3, "userId");
        i.g(str4, "portalCode");
        i.g(str5, "type");
        i.g(str6, "appVer");
        i.g(str7, "lang");
        i.g(str8, "reserve1");
        i.g(str9, "pipFlag");
        i.g(str10, "hasPay");
        i.g(str11, "userIdentity");
        this.encMediaSupported = i10;
        this.appParams = str;
        this.liveCodeList = list;
        this.userToken = str2;
        this.userId = str3;
        this.portalCode = str4;
        this.type = str5;
        this.appVer = str6;
        this.lang = str7;
        this.reserve1 = str8;
        this.pipFlag = str9;
        this.hasPay = str10;
        this.userIdentity = str11;
    }

    public static /* synthetic */ GetSlbInfoBean copy$default(GetSlbInfoBean getSlbInfoBean, int i10, String str, List list, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i11, Object obj) {
        GetSlbInfoBean getSlbInfoBean2 = getSlbInfoBean;
        int i12 = i11;
        return getSlbInfoBean.copy((i12 & 1) != 0 ? getSlbInfoBean2.encMediaSupported : i10, (i12 & 2) != 0 ? getSlbInfoBean2.appParams : str, (i12 & 4) != 0 ? getSlbInfoBean2.liveCodeList : list, (i12 & 8) != 0 ? getSlbInfoBean2.userToken : str2, (i12 & 16) != 0 ? getSlbInfoBean2.userId : str3, (i12 & 32) != 0 ? getSlbInfoBean2.portalCode : str4, (i12 & 64) != 0 ? getSlbInfoBean2.type : str5, (i12 & 128) != 0 ? getSlbInfoBean2.appVer : str6, (i12 & 256) != 0 ? getSlbInfoBean2.lang : str7, (i12 & 512) != 0 ? getSlbInfoBean2.reserve1 : str8, (i12 & 1024) != 0 ? getSlbInfoBean2.pipFlag : str9, (i12 & 2048) != 0 ? getSlbInfoBean2.hasPay : str10, (i12 & 4096) != 0 ? getSlbInfoBean2.userIdentity : str11);
    }

    public final int component1() {
        return this.encMediaSupported;
    }

    public final String component10() {
        return this.reserve1;
    }

    public final String component11() {
        return this.pipFlag;
    }

    public final String component12() {
        return this.hasPay;
    }

    public final String component13() {
        return this.userIdentity;
    }

    public final String component2() {
        return this.appParams;
    }

    public final List<String> component3() {
        return this.liveCodeList;
    }

    public final String component4() {
        return this.userToken;
    }

    public final String component5() {
        return this.userId;
    }

    public final String component6() {
        return this.portalCode;
    }

    public final String component7() {
        return this.type;
    }

    public final String component8() {
        return this.appVer;
    }

    public final String component9() {
        return this.lang;
    }

    public final GetSlbInfoBean copy(int i10, String str, List<String> list, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        List<String> list2 = list;
        i.g(list2, "liveCodeList");
        String str12 = str2;
        i.g(str12, "userToken");
        String str13 = str3;
        i.g(str13, "userId");
        String str14 = str4;
        i.g(str14, "portalCode");
        String str15 = str5;
        i.g(str15, "type");
        String str16 = str6;
        i.g(str16, "appVer");
        String str17 = str7;
        i.g(str17, "lang");
        String str18 = str8;
        i.g(str18, "reserve1");
        String str19 = str9;
        i.g(str19, "pipFlag");
        String str20 = str10;
        i.g(str20, "hasPay");
        String str21 = str11;
        i.g(str21, "userIdentity");
        return new GetSlbInfoBean(i10, str, list2, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSlbInfoBean)) {
            return false;
        }
        GetSlbInfoBean getSlbInfoBean = (GetSlbInfoBean) obj;
        return this.encMediaSupported == getSlbInfoBean.encMediaSupported && i.b(this.appParams, getSlbInfoBean.appParams) && i.b(this.liveCodeList, getSlbInfoBean.liveCodeList) && i.b(this.userToken, getSlbInfoBean.userToken) && i.b(this.userId, getSlbInfoBean.userId) && i.b(this.portalCode, getSlbInfoBean.portalCode) && i.b(this.type, getSlbInfoBean.type) && i.b(this.appVer, getSlbInfoBean.appVer) && i.b(this.lang, getSlbInfoBean.lang) && i.b(this.reserve1, getSlbInfoBean.reserve1) && i.b(this.pipFlag, getSlbInfoBean.pipFlag) && i.b(this.hasPay, getSlbInfoBean.hasPay) && i.b(this.userIdentity, getSlbInfoBean.userIdentity);
    }

    public final String getAppParams() {
        return this.appParams;
    }

    public final String getAppVer() {
        return this.appVer;
    }

    public final int getEncMediaSupported() {
        return this.encMediaSupported;
    }

    public final String getHasPay() {
        return this.hasPay;
    }

    public final String getLang() {
        return this.lang;
    }

    public final List<String> getLiveCodeList() {
        return this.liveCodeList;
    }

    public final String getPipFlag() {
        return this.pipFlag;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getReserve1() {
        return this.reserve1;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserIdentity() {
        return this.userIdentity;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        int i10 = this.encMediaSupported * 31;
        String str = this.appParams;
        return ((((((((((((((((((((((i10 + (str == null ? 0 : str.hashCode())) * 31) + this.liveCodeList.hashCode()) * 31) + this.userToken.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.type.hashCode()) * 31) + this.appVer.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.reserve1.hashCode()) * 31) + this.pipFlag.hashCode()) * 31) + this.hasPay.hashCode()) * 31) + this.userIdentity.hashCode();
    }

    public final void setAppParams(String str) {
        this.appParams = str;
    }

    public final void setAppVer(String str) {
        i.g(str, "<set-?>");
        this.appVer = str;
    }

    public final void setEncMediaSupported(int i10) {
        this.encMediaSupported = i10;
    }

    public final void setHasPay(String str) {
        i.g(str, "<set-?>");
        this.hasPay = str;
    }

    public final void setLang(String str) {
        i.g(str, "<set-?>");
        this.lang = str;
    }

    public final void setLiveCodeList(List<String> list) {
        i.g(list, "<set-?>");
        this.liveCodeList = list;
    }

    public final void setPipFlag(String str) {
        i.g(str, "<set-?>");
        this.pipFlag = str;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setReserve1(String str) {
        i.g(str, "<set-?>");
        this.reserve1 = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserIdentity(String str) {
        i.g(str, "<set-?>");
        this.userIdentity = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "GetSlbInfoBean(encMediaSupported=" + this.encMediaSupported + ", appParams=" + this.appParams + ", liveCodeList=" + this.liveCodeList + ", userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", type=" + this.type + ", appVer=" + this.appVer + ", lang=" + this.lang + ", reserve1=" + this.reserve1 + ", pipFlag=" + this.pipFlag + ", hasPay=" + this.hasPay + ", userIdentity=" + this.userIdentity + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
