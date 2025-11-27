package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.common.Constants;
import java.util.Map;
import t9.i;

public final class AvailableCouponCodeList {
    private Map<String, Float> couponAmount;
    private String couponCode;
    private String couponCurrency;
    private String couponEffectType;
    private String couponTitle;
    private String invalidTime;
    private String packageCode;
    private String packageLabel;
    private String packageName;

    public AvailableCouponCodeList(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, Float> map, String str8) {
        i.g(str, "couponEffectType");
        i.g(str2, "couponCode");
        i.g(str3, "packageCode");
        i.g(str4, "couponTitle");
        i.g(str5, Constants.KEY_PACKAGE_NAME);
        i.g(str6, "packageLabel");
        i.g(str7, "invalidTime");
        i.g(map, "couponAmount");
        i.g(str8, "couponCurrency");
        this.couponEffectType = str;
        this.couponCode = str2;
        this.packageCode = str3;
        this.couponTitle = str4;
        this.packageName = str5;
        this.packageLabel = str6;
        this.invalidTime = str7;
        this.couponAmount = map;
        this.couponCurrency = str8;
    }

    public static /* synthetic */ AvailableCouponCodeList copy$default(AvailableCouponCodeList availableCouponCodeList, String str, String str2, String str3, String str4, String str5, String str6, String str7, Map map, String str8, int i10, Object obj) {
        AvailableCouponCodeList availableCouponCodeList2 = availableCouponCodeList;
        int i11 = i10;
        return availableCouponCodeList.copy((i11 & 1) != 0 ? availableCouponCodeList2.couponEffectType : str, (i11 & 2) != 0 ? availableCouponCodeList2.couponCode : str2, (i11 & 4) != 0 ? availableCouponCodeList2.packageCode : str3, (i11 & 8) != 0 ? availableCouponCodeList2.couponTitle : str4, (i11 & 16) != 0 ? availableCouponCodeList2.packageName : str5, (i11 & 32) != 0 ? availableCouponCodeList2.packageLabel : str6, (i11 & 64) != 0 ? availableCouponCodeList2.invalidTime : str7, (i11 & 128) != 0 ? availableCouponCodeList2.couponAmount : map, (i11 & 256) != 0 ? availableCouponCodeList2.couponCurrency : str8);
    }

    public final String component1() {
        return this.couponEffectType;
    }

    public final String component2() {
        return this.couponCode;
    }

    public final String component3() {
        return this.packageCode;
    }

    public final String component4() {
        return this.couponTitle;
    }

    public final String component5() {
        return this.packageName;
    }

    public final String component6() {
        return this.packageLabel;
    }

    public final String component7() {
        return this.invalidTime;
    }

    public final Map<String, Float> component8() {
        return this.couponAmount;
    }

    public final String component9() {
        return this.couponCurrency;
    }

    public final AvailableCouponCodeList copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, Float> map, String str8) {
        i.g(str, "couponEffectType");
        i.g(str2, "couponCode");
        i.g(str3, "packageCode");
        i.g(str4, "couponTitle");
        String str9 = str5;
        i.g(str9, Constants.KEY_PACKAGE_NAME);
        String str10 = str6;
        i.g(str10, "packageLabel");
        String str11 = str7;
        i.g(str11, "invalidTime");
        Map<String, Float> map2 = map;
        i.g(map2, "couponAmount");
        String str12 = str8;
        i.g(str12, "couponCurrency");
        return new AvailableCouponCodeList(str, str2, str3, str4, str9, str10, str11, map2, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvailableCouponCodeList)) {
            return false;
        }
        AvailableCouponCodeList availableCouponCodeList = (AvailableCouponCodeList) obj;
        return i.b(this.couponEffectType, availableCouponCodeList.couponEffectType) && i.b(this.couponCode, availableCouponCodeList.couponCode) && i.b(this.packageCode, availableCouponCodeList.packageCode) && i.b(this.couponTitle, availableCouponCodeList.couponTitle) && i.b(this.packageName, availableCouponCodeList.packageName) && i.b(this.packageLabel, availableCouponCodeList.packageLabel) && i.b(this.invalidTime, availableCouponCodeList.invalidTime) && i.b(this.couponAmount, availableCouponCodeList.couponAmount) && i.b(this.couponCurrency, availableCouponCodeList.couponCurrency);
    }

    public final Map<String, Float> getCouponAmount() {
        return this.couponAmount;
    }

    public final String getCouponCode() {
        return this.couponCode;
    }

    public final String getCouponCurrency() {
        return this.couponCurrency;
    }

    public final String getCouponEffectType() {
        return this.couponEffectType;
    }

    public final String getCouponTitle() {
        return this.couponTitle;
    }

    public final String getInvalidTime() {
        return this.invalidTime;
    }

    public final String getPackageCode() {
        return this.packageCode;
    }

    public final String getPackageLabel() {
        return this.packageLabel;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (((((((((((((((this.couponEffectType.hashCode() * 31) + this.couponCode.hashCode()) * 31) + this.packageCode.hashCode()) * 31) + this.couponTitle.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.packageLabel.hashCode()) * 31) + this.invalidTime.hashCode()) * 31) + this.couponAmount.hashCode()) * 31) + this.couponCurrency.hashCode();
    }

    public final void setCouponAmount(Map<String, Float> map) {
        i.g(map, "<set-?>");
        this.couponAmount = map;
    }

    public final void setCouponCode(String str) {
        i.g(str, "<set-?>");
        this.couponCode = str;
    }

    public final void setCouponCurrency(String str) {
        i.g(str, "<set-?>");
        this.couponCurrency = str;
    }

    public final void setCouponEffectType(String str) {
        i.g(str, "<set-?>");
        this.couponEffectType = str;
    }

    public final void setCouponTitle(String str) {
        i.g(str, "<set-?>");
        this.couponTitle = str;
    }

    public final void setInvalidTime(String str) {
        i.g(str, "<set-?>");
        this.invalidTime = str;
    }

    public final void setPackageCode(String str) {
        i.g(str, "<set-?>");
        this.packageCode = str;
    }

    public final void setPackageLabel(String str) {
        i.g(str, "<set-?>");
        this.packageLabel = str;
    }

    public final void setPackageName(String str) {
        i.g(str, "<set-?>");
        this.packageName = str;
    }

    public String toString() {
        return "AvailableCouponCodeList(couponEffectType=" + this.couponEffectType + ", couponCode=" + this.couponCode + ", packageCode=" + this.packageCode + ", couponTitle=" + this.couponTitle + ", packageName=" + this.packageName + ", packageLabel=" + this.packageLabel + ", invalidTime=" + this.invalidTime + ", couponAmount=" + this.couponAmount + ", couponCurrency=" + this.couponCurrency + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
