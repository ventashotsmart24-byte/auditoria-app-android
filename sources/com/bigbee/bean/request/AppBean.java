package com.bigbee.bean.request;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t1.a;
import t9.i;

public final class AppBean implements Serializable {
    private String appVer;
    private long et;
    private long st;
    private String sysVer;
    private String tag;
    private String uid;
    private String uname;

    public AppBean(String str, String str2, String str3, String str4, long j10, long j11, String str5) {
        i.g(str, "appVer");
        i.g(str5, "tag");
        this.appVer = str;
        this.sysVer = str2;
        this.uid = str3;
        this.uname = str4;
        this.st = j10;
        this.et = j11;
        this.tag = str5;
    }

    public static /* synthetic */ AppBean copy$default(AppBean appBean, String str, String str2, String str3, String str4, long j10, long j11, String str5, int i10, Object obj) {
        AppBean appBean2 = appBean;
        return appBean.copy((i10 & 1) != 0 ? appBean2.appVer : str, (i10 & 2) != 0 ? appBean2.sysVer : str2, (i10 & 4) != 0 ? appBean2.uid : str3, (i10 & 8) != 0 ? appBean2.uname : str4, (i10 & 16) != 0 ? appBean2.st : j10, (i10 & 32) != 0 ? appBean2.et : j11, (i10 & 64) != 0 ? appBean2.tag : str5);
    }

    public final String component1() {
        return this.appVer;
    }

    public final String component2() {
        return this.sysVer;
    }

    public final String component3() {
        return this.uid;
    }

    public final String component4() {
        return this.uname;
    }

    public final long component5() {
        return this.st;
    }

    public final long component6() {
        return this.et;
    }

    public final String component7() {
        return this.tag;
    }

    public final AppBean copy(String str, String str2, String str3, String str4, long j10, long j11, String str5) {
        i.g(str, "appVer");
        String str6 = str5;
        i.g(str6, "tag");
        return new AppBean(str, str2, str3, str4, j10, j11, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppBean)) {
            return false;
        }
        AppBean appBean = (AppBean) obj;
        return i.b(this.appVer, appBean.appVer) && i.b(this.sysVer, appBean.sysVer) && i.b(this.uid, appBean.uid) && i.b(this.uname, appBean.uname) && this.st == appBean.st && this.et == appBean.et && i.b(this.tag, appBean.tag);
    }

    public final String getAppVer() {
        return this.appVer;
    }

    public final long getEt() {
        return this.et;
    }

    public final long getSt() {
        return this.st;
    }

    public final String getSysVer() {
        return this.sysVer;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUname() {
        return this.uname;
    }

    public int hashCode() {
        int hashCode = this.appVer.hashCode() * 31;
        String str = this.sysVer;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uid;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.uname;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return ((((((hashCode3 + i10) * 31) + a.a(this.st)) * 31) + a.a(this.et)) * 31) + this.tag.hashCode();
    }

    public final void setAppVer(String str) {
        i.g(str, "<set-?>");
        this.appVer = str;
    }

    public final void setEt(long j10) {
        this.et = j10;
    }

    public final void setSt(long j10) {
        this.st = j10;
    }

    public final void setSysVer(String str) {
        this.sysVer = str;
    }

    public final void setTag(String str) {
        i.g(str, "<set-?>");
        this.tag = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final void setUname(String str) {
        this.uname = str;
    }

    public String toString() {
        return "AppBean(appVer=" + this.appVer + ", sysVer=" + this.sysVer + ", uid=" + this.uid + ", uname=" + this.uname + ", st=" + this.st + ", et=" + this.et + ", tag=" + this.tag + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
