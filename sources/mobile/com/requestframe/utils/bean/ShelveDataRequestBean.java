package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

public final class ShelveDataRequestBean {
    private int columnId;
    private String columnType;
    private Integer encryptVersion;
    private Integer numDisplay;
    private int pageNum;
    private int pageSize;
    private String portalCode;
    private String userId;
    private String userToken;

    public ShelveDataRequestBean(String str, String str2, String str3, int i10, String str4, int i11, int i12, Integer num, Integer num2) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "columnType");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.columnId = i10;
        this.columnType = str4;
        this.pageSize = i11;
        this.pageNum = i12;
        this.numDisplay = num;
        this.encryptVersion = num2;
    }

    public static /* synthetic */ ShelveDataRequestBean copy$default(ShelveDataRequestBean shelveDataRequestBean, String str, String str2, String str3, int i10, String str4, int i11, int i12, Integer num, Integer num2, int i13, Object obj) {
        ShelveDataRequestBean shelveDataRequestBean2 = shelveDataRequestBean;
        int i14 = i13;
        return shelveDataRequestBean.copy((i14 & 1) != 0 ? shelveDataRequestBean2.userToken : str, (i14 & 2) != 0 ? shelveDataRequestBean2.userId : str2, (i14 & 4) != 0 ? shelveDataRequestBean2.portalCode : str3, (i14 & 8) != 0 ? shelveDataRequestBean2.columnId : i10, (i14 & 16) != 0 ? shelveDataRequestBean2.columnType : str4, (i14 & 32) != 0 ? shelveDataRequestBean2.pageSize : i11, (i14 & 64) != 0 ? shelveDataRequestBean2.pageNum : i12, (i14 & 128) != 0 ? shelveDataRequestBean2.numDisplay : num, (i14 & 256) != 0 ? shelveDataRequestBean2.encryptVersion : num2);
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

    public final int component4() {
        return this.columnId;
    }

    public final String component5() {
        return this.columnType;
    }

    public final int component6() {
        return this.pageSize;
    }

    public final int component7() {
        return this.pageNum;
    }

    public final Integer component8() {
        return this.numDisplay;
    }

    public final Integer component9() {
        return this.encryptVersion;
    }

    public final ShelveDataRequestBean copy(String str, String str2, String str3, int i10, String str4, int i11, int i12, Integer num, Integer num2) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        String str5 = str4;
        i.g(str5, "columnType");
        return new ShelveDataRequestBean(str, str2, str3, i10, str5, i11, i12, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelveDataRequestBean)) {
            return false;
        }
        ShelveDataRequestBean shelveDataRequestBean = (ShelveDataRequestBean) obj;
        return i.b(this.userToken, shelveDataRequestBean.userToken) && i.b(this.userId, shelveDataRequestBean.userId) && i.b(this.portalCode, shelveDataRequestBean.portalCode) && this.columnId == shelveDataRequestBean.columnId && i.b(this.columnType, shelveDataRequestBean.columnType) && this.pageSize == shelveDataRequestBean.pageSize && this.pageNum == shelveDataRequestBean.pageNum && i.b(this.numDisplay, shelveDataRequestBean.numDisplay) && i.b(this.encryptVersion, shelveDataRequestBean.encryptVersion);
    }

    public final int getColumnId() {
        return this.columnId;
    }

    public final String getColumnType() {
        return this.columnType;
    }

    public final Integer getEncryptVersion() {
        return this.encryptVersion;
    }

    public final Integer getNumDisplay() {
        return this.numDisplay;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.columnId) * 31) + this.columnType.hashCode()) * 31) + this.pageSize) * 31) + this.pageNum) * 31;
        Integer num = this.numDisplay;
        int i10 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.encryptVersion;
        if (num2 != null) {
            i10 = num2.hashCode();
        }
        return hashCode2 + i10;
    }

    public final void setColumnId(int i10) {
        this.columnId = i10;
    }

    public final void setColumnType(String str) {
        i.g(str, "<set-?>");
        this.columnType = str;
    }

    public final void setEncryptVersion(Integer num) {
        this.encryptVersion = num;
    }

    public final void setNumDisplay(Integer num) {
        this.numDisplay = num;
    }

    public final void setPageNum(int i10) {
        this.pageNum = i10;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
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
        return "ShelveDataRequestBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", columnId=" + this.columnId + ", columnType=" + this.columnType + ", pageSize=" + this.pageSize + ", pageNum=" + this.pageNum + ", numDisplay=" + this.numDisplay + ", encryptVersion=" + this.encryptVersion + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
