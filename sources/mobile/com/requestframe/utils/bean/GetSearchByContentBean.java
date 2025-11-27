package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

public final class GetSearchByContentBean {
    private String contentId;
    private String end;
    private String portalCode;
    private String rows;
    private String start;
    private String type;
    private String userId;
    private String userToken;

    public GetSearchByContentBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "type");
        i.g(str5, "contentId");
        i.g(str6, "start");
        i.g(str7, "end");
        i.g(str8, "rows");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.type = str4;
        this.contentId = str5;
        this.start = str6;
        this.end = str7;
        this.rows = str8;
    }

    public static /* synthetic */ GetSearchByContentBean copy$default(GetSearchByContentBean getSearchByContentBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, Object obj) {
        GetSearchByContentBean getSearchByContentBean2 = getSearchByContentBean;
        int i11 = i10;
        return getSearchByContentBean.copy((i11 & 1) != 0 ? getSearchByContentBean2.userToken : str, (i11 & 2) != 0 ? getSearchByContentBean2.userId : str2, (i11 & 4) != 0 ? getSearchByContentBean2.portalCode : str3, (i11 & 8) != 0 ? getSearchByContentBean2.type : str4, (i11 & 16) != 0 ? getSearchByContentBean2.contentId : str5, (i11 & 32) != 0 ? getSearchByContentBean2.start : str6, (i11 & 64) != 0 ? getSearchByContentBean2.end : str7, (i11 & 128) != 0 ? getSearchByContentBean2.rows : str8);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.portalCode;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.contentId;
    }

    public final String component6() {
        return this.start;
    }

    public final String component7() {
        return this.end;
    }

    public final String component8() {
        return this.rows;
    }

    public final GetSearchByContentBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "type");
        i.g(str5, "contentId");
        String str9 = str6;
        i.g(str9, "start");
        String str10 = str7;
        i.g(str10, "end");
        String str11 = str8;
        i.g(str11, "rows");
        return new GetSearchByContentBean(str, str2, str3, str4, str5, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSearchByContentBean)) {
            return false;
        }
        GetSearchByContentBean getSearchByContentBean = (GetSearchByContentBean) obj;
        return i.b(this.userToken, getSearchByContentBean.userToken) && i.b(this.userId, getSearchByContentBean.userId) && i.b(this.portalCode, getSearchByContentBean.portalCode) && i.b(this.type, getSearchByContentBean.type) && i.b(this.contentId, getSearchByContentBean.contentId) && i.b(this.start, getSearchByContentBean.start) && i.b(this.end, getSearchByContentBean.end) && i.b(this.rows, getSearchByContentBean.rows);
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getEnd() {
        return this.end;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getRows() {
        return this.rows;
    }

    public final String getStart() {
        return this.start;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((((((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.type.hashCode()) * 31) + this.contentId.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.rows.hashCode();
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setEnd(String str) {
        i.g(str, "<set-?>");
        this.end = str;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setRows(String str) {
        i.g(str, "<set-?>");
        this.rows = str;
    }

    public final void setStart(String str) {
        i.g(str, "<set-?>");
        this.start = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "GetSearchByContentBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", type=" + this.type + ", contentId=" + this.contentId + ", start=" + this.start + ", end=" + this.end + ", rows=" + this.rows + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
