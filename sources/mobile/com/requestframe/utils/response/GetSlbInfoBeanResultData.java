package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import t9.i;

public final class GetSlbInfoBeanResultData implements Serializable, Cloneable {
    private List<CdnListBeanResult> cdn_list;
    private String error_code;
    private String invalidTime;
    private String nowTime;
    private String play_params;
    private int switchLiveSourceTime;
    private String switchLiveSourceTimeV2;
    private int switchVodSourceTime;
    private String switchVodSourceTimeV2;

    public GetSlbInfoBeanResultData(String str, String str2, String str3, int i10, int i11, String str4, String str5, String str6, List<CdnListBeanResult> list) {
        i.g(str4, "switchLiveSourceTimeV2");
        i.g(str5, "switchVodSourceTimeV2");
        this.error_code = str;
        this.invalidTime = str2;
        this.nowTime = str3;
        this.switchLiveSourceTime = i10;
        this.switchVodSourceTime = i11;
        this.switchLiveSourceTimeV2 = str4;
        this.switchVodSourceTimeV2 = str5;
        this.play_params = str6;
        this.cdn_list = list;
    }

    public static /* synthetic */ GetSlbInfoBeanResultData copy$default(GetSlbInfoBeanResultData getSlbInfoBeanResultData, String str, String str2, String str3, int i10, int i11, String str4, String str5, String str6, List list, int i12, Object obj) {
        GetSlbInfoBeanResultData getSlbInfoBeanResultData2 = getSlbInfoBeanResultData;
        int i13 = i12;
        return getSlbInfoBeanResultData.copy((i13 & 1) != 0 ? getSlbInfoBeanResultData2.error_code : str, (i13 & 2) != 0 ? getSlbInfoBeanResultData2.invalidTime : str2, (i13 & 4) != 0 ? getSlbInfoBeanResultData2.nowTime : str3, (i13 & 8) != 0 ? getSlbInfoBeanResultData2.switchLiveSourceTime : i10, (i13 & 16) != 0 ? getSlbInfoBeanResultData2.switchVodSourceTime : i11, (i13 & 32) != 0 ? getSlbInfoBeanResultData2.switchLiveSourceTimeV2 : str4, (i13 & 64) != 0 ? getSlbInfoBeanResultData2.switchVodSourceTimeV2 : str5, (i13 & 128) != 0 ? getSlbInfoBeanResultData2.play_params : str6, (i13 & 256) != 0 ? getSlbInfoBeanResultData2.cdn_list : list);
    }

    public final String component1() {
        return this.error_code;
    }

    public final String component2() {
        return this.invalidTime;
    }

    public final String component3() {
        return this.nowTime;
    }

    public final int component4() {
        return this.switchLiveSourceTime;
    }

    public final int component5() {
        return this.switchVodSourceTime;
    }

    public final String component6() {
        return this.switchLiveSourceTimeV2;
    }

    public final String component7() {
        return this.switchVodSourceTimeV2;
    }

    public final String component8() {
        return this.play_params;
    }

    public final List<CdnListBeanResult> component9() {
        return this.cdn_list;
    }

    public final GetSlbInfoBeanResultData copy(String str, String str2, String str3, int i10, int i11, String str4, String str5, String str6, List<CdnListBeanResult> list) {
        String str7 = str4;
        i.g(str7, "switchLiveSourceTimeV2");
        String str8 = str5;
        i.g(str8, "switchVodSourceTimeV2");
        return new GetSlbInfoBeanResultData(str, str2, str3, i10, i11, str7, str8, str6, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSlbInfoBeanResultData)) {
            return false;
        }
        GetSlbInfoBeanResultData getSlbInfoBeanResultData = (GetSlbInfoBeanResultData) obj;
        return i.b(this.error_code, getSlbInfoBeanResultData.error_code) && i.b(this.invalidTime, getSlbInfoBeanResultData.invalidTime) && i.b(this.nowTime, getSlbInfoBeanResultData.nowTime) && this.switchLiveSourceTime == getSlbInfoBeanResultData.switchLiveSourceTime && this.switchVodSourceTime == getSlbInfoBeanResultData.switchVodSourceTime && i.b(this.switchLiveSourceTimeV2, getSlbInfoBeanResultData.switchLiveSourceTimeV2) && i.b(this.switchVodSourceTimeV2, getSlbInfoBeanResultData.switchVodSourceTimeV2) && i.b(this.play_params, getSlbInfoBeanResultData.play_params) && i.b(this.cdn_list, getSlbInfoBeanResultData.cdn_list);
    }

    public final List<CdnListBeanResult> getCdn_list() {
        return this.cdn_list;
    }

    public final String getError_code() {
        return this.error_code;
    }

    public final String getInvalidTime() {
        return this.invalidTime;
    }

    public final String getNowTime() {
        return this.nowTime;
    }

    public final String getPlay_params() {
        return this.play_params;
    }

    public final int getSwitchLiveSourceTime() {
        return this.switchLiveSourceTime;
    }

    public final String getSwitchLiveSourceTimeV2() {
        return this.switchLiveSourceTimeV2;
    }

    public final int getSwitchVodSourceTime() {
        return this.switchVodSourceTime;
    }

    public final String getSwitchVodSourceTimeV2() {
        return this.switchVodSourceTimeV2;
    }

    public int hashCode() {
        String str = this.error_code;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.invalidTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nowTime;
        int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.switchLiveSourceTime) * 31) + this.switchVodSourceTime) * 31) + this.switchLiveSourceTimeV2.hashCode()) * 31) + this.switchVodSourceTimeV2.hashCode()) * 31;
        String str4 = this.play_params;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<CdnListBeanResult> list = this.cdn_list;
        if (list != null) {
            i10 = list.hashCode();
        }
        return hashCode4 + i10;
    }

    public final void setCdn_list(List<CdnListBeanResult> list) {
        this.cdn_list = list;
    }

    public final void setError_code(String str) {
        this.error_code = str;
    }

    public final void setInvalidTime(String str) {
        this.invalidTime = str;
    }

    public final void setNowTime(String str) {
        this.nowTime = str;
    }

    public final void setPlay_params(String str) {
        this.play_params = str;
    }

    public final void setSwitchLiveSourceTime(int i10) {
        this.switchLiveSourceTime = i10;
    }

    public final void setSwitchLiveSourceTimeV2(String str) {
        i.g(str, "<set-?>");
        this.switchLiveSourceTimeV2 = str;
    }

    public final void setSwitchVodSourceTime(int i10) {
        this.switchVodSourceTime = i10;
    }

    public final void setSwitchVodSourceTimeV2(String str) {
        i.g(str, "<set-?>");
        this.switchVodSourceTimeV2 = str;
    }

    public String toString() {
        return "GetSlbInfoBeanResultData(error_code=" + this.error_code + ", invalidTime=" + this.invalidTime + ", nowTime=" + this.nowTime + ", switchLiveSourceTime=" + this.switchLiveSourceTime + ", switchVodSourceTime=" + this.switchVodSourceTime + ", switchLiveSourceTimeV2=" + this.switchLiveSourceTimeV2 + ", switchVodSourceTimeV2=" + this.switchVodSourceTimeV2 + ", play_params=" + this.play_params + ", cdn_list=" + this.cdn_list + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public GetSlbInfoBeanResultData clone() {
        Object clone = super.clone();
        i.e(clone, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.GetSlbInfoBeanResultData");
        GetSlbInfoBeanResultData getSlbInfoBeanResultData = (GetSlbInfoBeanResultData) clone;
        getSlbInfoBeanResultData.cdn_list = new ArrayList();
        return getSlbInfoBeanResultData;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GetSlbInfoBeanResultData(java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, int r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.util.List r22, int r23, t9.g r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = 0
            goto L_0x000b
        L_0x0009:
            r7 = r17
        L_0x000b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0011
            r8 = 0
            goto L_0x0013
        L_0x0011:
            r8 = r18
        L_0x0013:
            r1 = r0 & 32
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x001b
            r9 = r2
            goto L_0x001d
        L_0x001b:
            r9 = r19
        L_0x001d:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0023
            r10 = r2
            goto L_0x0025
        L_0x0023:
            r10 = r20
        L_0x0025:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x002c
            r0 = 0
            r12 = r0
            goto L_0x002e
        L_0x002c:
            r12 = r22
        L_0x002e:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r11 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mobile.com.requestframe.utils.response.GetSlbInfoBeanResultData.<init>(java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, t9.g):void");
    }
}
