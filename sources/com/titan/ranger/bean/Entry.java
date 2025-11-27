package com.titan.ranger.bean;

import com.taobao.accs.common.Constants;
import java.util.List;
import t9.i;

public final class Entry {
    private List<String> auths;
    private String buss;
    private int enable;
    private String gslb_params;
    private String main_addr;
    private String main_addr_code;
    private String name;
    private int priority;
    private String redirect;
    private String sign_type;
    private String spare_addr;
    private String spare_addr_code;
    private String strategy;
    private String tag;

    public Entry(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, int i11, List<String> list, String str11) {
        i.h(str, "name");
        i.h(str2, "buss");
        i.h(str3, Constants.KEY_STRATEGY);
        i.h(str4, "main_addr");
        i.h(str5, "main_addr_code");
        i.h(str6, "spare_addr");
        i.h(str7, "spare_addr_code");
        i.h(str8, "redirect");
        i.h(str9, "tag");
        i.h(str10, "sign_type");
        i.h(list, "auths");
        i.h(str11, "gslb_params");
        this.name = str;
        this.buss = str2;
        this.strategy = str3;
        this.main_addr = str4;
        this.main_addr_code = str5;
        this.spare_addr = str6;
        this.spare_addr_code = str7;
        this.redirect = str8;
        this.tag = str9;
        this.sign_type = str10;
        this.priority = i10;
        this.enable = i11;
        this.auths = list;
        this.gslb_params = str11;
    }

    public static /* synthetic */ Entry copy$default(Entry entry, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, int i11, List list, String str11, int i12, Object obj) {
        Entry entry2 = entry;
        int i13 = i12;
        return entry.copy((i13 & 1) != 0 ? entry2.name : str, (i13 & 2) != 0 ? entry2.buss : str2, (i13 & 4) != 0 ? entry2.strategy : str3, (i13 & 8) != 0 ? entry2.main_addr : str4, (i13 & 16) != 0 ? entry2.main_addr_code : str5, (i13 & 32) != 0 ? entry2.spare_addr : str6, (i13 & 64) != 0 ? entry2.spare_addr_code : str7, (i13 & 128) != 0 ? entry2.redirect : str8, (i13 & 256) != 0 ? entry2.tag : str9, (i13 & 512) != 0 ? entry2.sign_type : str10, (i13 & 1024) != 0 ? entry2.priority : i10, (i13 & 2048) != 0 ? entry2.enable : i11, (i13 & 4096) != 0 ? entry2.auths : list, (i13 & 8192) != 0 ? entry2.gslb_params : str11);
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.sign_type;
    }

    public final int component11() {
        return this.priority;
    }

    public final int component12() {
        return this.enable;
    }

    public final List<String> component13() {
        return this.auths;
    }

    public final String component14() {
        return this.gslb_params;
    }

    public final String component2() {
        return this.buss;
    }

    public final String component3() {
        return this.strategy;
    }

    public final String component4() {
        return this.main_addr;
    }

    public final String component5() {
        return this.main_addr_code;
    }

    public final String component6() {
        return this.spare_addr;
    }

    public final String component7() {
        return this.spare_addr_code;
    }

    public final String component8() {
        return this.redirect;
    }

    public final String component9() {
        return this.tag;
    }

    public final Entry copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, int i11, List<String> list, String str11) {
        String str12 = str;
        i.h(str12, "name");
        String str13 = str2;
        i.h(str13, "buss");
        String str14 = str3;
        i.h(str14, Constants.KEY_STRATEGY);
        String str15 = str4;
        i.h(str15, "main_addr");
        String str16 = str5;
        i.h(str16, "main_addr_code");
        String str17 = str6;
        i.h(str17, "spare_addr");
        String str18 = str7;
        i.h(str18, "spare_addr_code");
        String str19 = str8;
        i.h(str19, "redirect");
        String str20 = str9;
        i.h(str20, "tag");
        String str21 = str10;
        i.h(str21, "sign_type");
        List<String> list2 = list;
        i.h(list2, "auths");
        String str22 = str11;
        i.h(str22, "gslb_params");
        return new Entry(str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, i10, i11, list2, str22);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                if (i.b(this.name, entry.name) && i.b(this.buss, entry.buss) && i.b(this.strategy, entry.strategy) && i.b(this.main_addr, entry.main_addr) && i.b(this.main_addr_code, entry.main_addr_code) && i.b(this.spare_addr, entry.spare_addr) && i.b(this.spare_addr_code, entry.spare_addr_code) && i.b(this.redirect, entry.redirect) && i.b(this.tag, entry.tag) && i.b(this.sign_type, entry.sign_type)) {
                    if (this.priority == entry.priority) {
                        if (!(this.enable == entry.enable) || !i.b(this.auths, entry.auths) || !i.b(this.gslb_params, entry.gslb_params)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final List<String> getAuths() {
        return this.auths;
    }

    public final String getBuss() {
        return this.buss;
    }

    public final int getEnable() {
        return this.enable;
    }

    public final String getGslb_params() {
        return this.gslb_params;
    }

    public final String getMain_addr() {
        return this.main_addr;
    }

    public final String getMain_addr_code() {
        return this.main_addr_code;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getRedirect() {
        return this.redirect;
    }

    public final String getSign_type() {
        return this.sign_type;
    }

    public final String getSpare_addr() {
        return this.spare_addr;
    }

    public final String getSpare_addr_code() {
        return this.spare_addr_code;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        String str = this.name;
        int i10 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.buss;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.strategy;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.main_addr;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.main_addr_code;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.spare_addr;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.spare_addr_code;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.redirect;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.tag;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.sign_type;
        int hashCode10 = (((((hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31) + this.priority) * 31) + this.enable) * 31;
        List<String> list = this.auths;
        int hashCode11 = (hashCode10 + (list != null ? list.hashCode() : 0)) * 31;
        String str11 = this.gslb_params;
        if (str11 != null) {
            i10 = str11.hashCode();
        }
        return hashCode11 + i10;
    }

    public final void setAuths(List<String> list) {
        i.h(list, "<set-?>");
        this.auths = list;
    }

    public final void setBuss(String str) {
        i.h(str, "<set-?>");
        this.buss = str;
    }

    public final void setEnable(int i10) {
        this.enable = i10;
    }

    public final void setGslb_params(String str) {
        i.h(str, "<set-?>");
        this.gslb_params = str;
    }

    public final void setMain_addr(String str) {
        i.h(str, "<set-?>");
        this.main_addr = str;
    }

    public final void setMain_addr_code(String str) {
        i.h(str, "<set-?>");
        this.main_addr_code = str;
    }

    public final void setName(String str) {
        i.h(str, "<set-?>");
        this.name = str;
    }

    public final void setPriority(int i10) {
        this.priority = i10;
    }

    public final void setRedirect(String str) {
        i.h(str, "<set-?>");
        this.redirect = str;
    }

    public final void setSign_type(String str) {
        i.h(str, "<set-?>");
        this.sign_type = str;
    }

    public final void setSpare_addr(String str) {
        i.h(str, "<set-?>");
        this.spare_addr = str;
    }

    public final void setSpare_addr_code(String str) {
        i.h(str, "<set-?>");
        this.spare_addr_code = str;
    }

    public final void setStrategy(String str) {
        i.h(str, "<set-?>");
        this.strategy = str;
    }

    public final void setTag(String str) {
        i.h(str, "<set-?>");
        this.tag = str;
    }

    public String toString() {
        return "Entry(name=" + this.name + ", buss=" + this.buss + ", strategy=" + this.strategy + ", main_addr=" + this.main_addr + ", main_addr_code=" + this.main_addr_code + ", spare_addr=" + this.spare_addr + ", spare_addr_code=" + this.spare_addr_code + ", redirect=" + this.redirect + ", tag=" + this.tag + ", sign_type=" + this.sign_type + ", priority=" + this.priority + ", enable=" + this.enable + ", auths=" + this.auths + ", gslb_params=" + this.gslb_params + ")";
    }
}
