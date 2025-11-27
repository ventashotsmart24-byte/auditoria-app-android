package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

public final class UserFeedBean {
    private final String appVersion;
    private String customer;
    private final String definition;
    private final String email;

    /* renamed from: mobile  reason: collision with root package name */
    private final String f19009mobile;
    private final String pkg;
    private final String programName;
    private final String questionsId;
    private final String screenType;
    private final String tvModel;
    private final String type;
    private final String typeId;
    private final String userId;
    private final String userName;
    private final String userOperateSys;
    private final String userSug;

    public UserFeedBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        String str17 = str8;
        i.g(str, "type");
        i.g(str4, "pkg");
        i.g(str5, "userName");
        i.g(str6, "userId");
        i.g(str7, "programName");
        i.g(str17, "userOperateSys");
        this.type = str;
        this.typeId = str2;
        this.questionsId = str3;
        this.pkg = str4;
        this.userName = str5;
        this.userId = str6;
        this.programName = str7;
        this.userOperateSys = str17;
        this.tvModel = str9;
        this.screenType = str10;
        this.definition = str11;
        this.customer = str12;
        this.userSug = str13;
        this.email = str14;
        this.f19009mobile = str15;
        this.appVersion = str16;
    }

    public static /* synthetic */ UserFeedBean copy$default(UserFeedBean userFeedBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i10, Object obj) {
        UserFeedBean userFeedBean2 = userFeedBean;
        int i11 = i10;
        return userFeedBean.copy((i11 & 1) != 0 ? userFeedBean2.type : str, (i11 & 2) != 0 ? userFeedBean2.typeId : str2, (i11 & 4) != 0 ? userFeedBean2.questionsId : str3, (i11 & 8) != 0 ? userFeedBean2.pkg : str4, (i11 & 16) != 0 ? userFeedBean2.userName : str5, (i11 & 32) != 0 ? userFeedBean2.userId : str6, (i11 & 64) != 0 ? userFeedBean2.programName : str7, (i11 & 128) != 0 ? userFeedBean2.userOperateSys : str8, (i11 & 256) != 0 ? userFeedBean2.tvModel : str9, (i11 & 512) != 0 ? userFeedBean2.screenType : str10, (i11 & 1024) != 0 ? userFeedBean2.definition : str11, (i11 & 2048) != 0 ? userFeedBean2.customer : str12, (i11 & 4096) != 0 ? userFeedBean2.userSug : str13, (i11 & 8192) != 0 ? userFeedBean2.email : str14, (i11 & 16384) != 0 ? userFeedBean2.f19009mobile : str15, (i11 & 32768) != 0 ? userFeedBean2.appVersion : str16);
    }

    public final String component1() {
        return this.type;
    }

    public final String component10() {
        return this.screenType;
    }

    public final String component11() {
        return this.definition;
    }

    public final String component12() {
        return this.customer;
    }

    public final String component13() {
        return this.userSug;
    }

    public final String component14() {
        return this.email;
    }

    public final String component15() {
        return this.f19009mobile;
    }

    public final String component16() {
        return this.appVersion;
    }

    public final String component2() {
        return this.typeId;
    }

    public final String component3() {
        return this.questionsId;
    }

    public final String component4() {
        return this.pkg;
    }

    public final String component5() {
        return this.userName;
    }

    public final String component6() {
        return this.userId;
    }

    public final String component7() {
        return this.programName;
    }

    public final String component8() {
        return this.userOperateSys;
    }

    public final String component9() {
        return this.tvModel;
    }

    public final UserFeedBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        String str17 = str;
        i.g(str17, "type");
        i.g(str4, "pkg");
        i.g(str5, "userName");
        i.g(str6, "userId");
        i.g(str7, "programName");
        i.g(str8, "userOperateSys");
        return new UserFeedBean(str17, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserFeedBean)) {
            return false;
        }
        UserFeedBean userFeedBean = (UserFeedBean) obj;
        return i.b(this.type, userFeedBean.type) && i.b(this.typeId, userFeedBean.typeId) && i.b(this.questionsId, userFeedBean.questionsId) && i.b(this.pkg, userFeedBean.pkg) && i.b(this.userName, userFeedBean.userName) && i.b(this.userId, userFeedBean.userId) && i.b(this.programName, userFeedBean.programName) && i.b(this.userOperateSys, userFeedBean.userOperateSys) && i.b(this.tvModel, userFeedBean.tvModel) && i.b(this.screenType, userFeedBean.screenType) && i.b(this.definition, userFeedBean.definition) && i.b(this.customer, userFeedBean.customer) && i.b(this.userSug, userFeedBean.userSug) && i.b(this.email, userFeedBean.email) && i.b(this.f19009mobile, userFeedBean.f19009mobile) && i.b(this.appVersion, userFeedBean.appVersion);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCustomer() {
        return this.customer;
    }

    public final String getDefinition() {
        return this.definition;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getMobile() {
        return this.f19009mobile;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final String getQuestionsId() {
        return this.questionsId;
    }

    public final String getScreenType() {
        return this.screenType;
    }

    public final String getTvModel() {
        return this.tvModel;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTypeId() {
        return this.typeId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserOperateSys() {
        return this.userOperateSys;
    }

    public final String getUserSug() {
        return this.userSug;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        String str = this.typeId;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.questionsId;
        int hashCode3 = (((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.pkg.hashCode()) * 31) + this.userName.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.programName.hashCode()) * 31) + this.userOperateSys.hashCode()) * 31;
        String str3 = this.tvModel;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.screenType;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.definition;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.customer;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.userSug;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.email;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f19009mobile;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.appVersion;
        if (str10 != null) {
            i10 = str10.hashCode();
        }
        return hashCode10 + i10;
    }

    public final void setCustomer(String str) {
        this.customer = str;
    }

    public String toString() {
        return "UserFeedBean(type=" + this.type + ", typeId=" + this.typeId + ", questionsId=" + this.questionsId + ", pkg=" + this.pkg + ", userName=" + this.userName + ", userId=" + this.userId + ", programName=" + this.programName + ", userOperateSys=" + this.userOperateSys + ", tvModel=" + this.tvModel + ", screenType=" + this.screenType + ", definition=" + this.definition + ", customer=" + this.customer + ", userSug=" + this.userSug + ", email=" + this.email + ", mobile=" + this.f19009mobile + ", appVersion=" + this.appVersion + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserFeedBean(java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, t9.g r38) {
        /*
            r20 = this;
            r0 = r37
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r22
        L_0x000b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0011
            r6 = r2
            goto L_0x0013
        L_0x0011:
            r6 = r23
        L_0x0013:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x001b
            java.lang.String r1 = "phone"
            r11 = r1
            goto L_0x001d
        L_0x001b:
            r11 = r28
        L_0x001d:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0023
            r12 = r2
            goto L_0x0025
        L_0x0023:
            r12 = r29
        L_0x0025:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x002b
            r13 = r2
            goto L_0x002d
        L_0x002b:
            r13 = r30
        L_0x002d:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0033
            r14 = r2
            goto L_0x0035
        L_0x0033:
            r14 = r31
        L_0x0035:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x003b
            r15 = r2
            goto L_0x003d
        L_0x003b:
            r15 = r32
        L_0x003d:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0044
            r16 = r2
            goto L_0x0046
        L_0x0044:
            r16 = r33
        L_0x0046:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x004d
            r17 = r2
            goto L_0x004f
        L_0x004d:
            r17 = r34
        L_0x004f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0056
            r18 = r2
            goto L_0x0058
        L_0x0056:
            r18 = r35
        L_0x0058:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0061
            r19 = r2
            goto L_0x0063
        L_0x0061:
            r19 = r36
        L_0x0063:
            r3 = r20
            r4 = r21
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mobile.com.requestframe.utils.bean.UserFeedBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, t9.g):void");
    }
}
