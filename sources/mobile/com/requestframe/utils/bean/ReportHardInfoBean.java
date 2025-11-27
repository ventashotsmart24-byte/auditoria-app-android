package mobile.com.requestframe.utils.bean;

import com.google.firebase.messaging.Constants;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import t9.i;

public final class ReportHardInfoBean {
    private String androidId;
    private String board;
    private String brand;
    private String cpuAbi;
    private String cpuId;
    private String device;
    private String diskInfo;
    private String display;
    private String etheMac;
    private String fingerprint;
    private String gatewayMac;
    private String hardware;
    private String host;
    private String manufacturer;
    private String ramSize;
    private String romSize;
    private String serialNumber;
    private String tags;
    private String verId;
    private String wifiMac;

    public ReportHardInfoBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        String str21 = str;
        String str22 = str2;
        String str23 = str3;
        String str24 = str4;
        String str25 = str5;
        String str26 = str6;
        String str27 = str7;
        String str28 = str8;
        String str29 = str9;
        String str30 = str10;
        String str31 = str11;
        String str32 = str12;
        String str33 = str13;
        String str34 = str14;
        String str35 = str16;
        i.g(str21, "androidId");
        i.g(str22, "wifiMac");
        i.g(str23, "etheMac");
        i.g(str24, "serialNumber");
        i.g(str25, "diskInfo");
        i.g(str26, "ramSize");
        i.g(str27, "romSize");
        i.g(str28, "gatewayMac");
        i.g(str29, "cpuId");
        i.g(str30, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        i.g(str31, com.taobao.accs.common.Constants.KEY_BRAND);
        i.g(str32, "verId");
        i.g(str33, "cpuAbi");
        i.g(str34, "hardware");
        i.g(str15, BrowserInfo.KEY_MANUFACTURER);
        i.g(str16, "fingerprint");
        i.g(str17, com.taobao.accs.common.Constants.KEY_HOST);
        i.g(str18, Device.ELEM_NAME);
        i.g(str19, "board");
        i.g(str20, "tags");
        this.androidId = str21;
        this.wifiMac = str22;
        this.etheMac = str23;
        this.serialNumber = str24;
        this.diskInfo = str25;
        this.ramSize = str26;
        this.romSize = str27;
        this.gatewayMac = str28;
        this.cpuId = str29;
        this.display = str30;
        this.brand = str31;
        this.verId = str32;
        this.cpuAbi = str33;
        this.hardware = str34;
        this.manufacturer = str15;
        this.fingerprint = str16;
        this.host = str17;
        this.device = str18;
        this.board = str19;
        this.tags = str20;
    }

    public static /* synthetic */ ReportHardInfoBean copy$default(ReportHardInfoBean reportHardInfoBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, int i10, Object obj) {
        ReportHardInfoBean reportHardInfoBean2 = reportHardInfoBean;
        int i11 = i10;
        return reportHardInfoBean.copy((i11 & 1) != 0 ? reportHardInfoBean2.androidId : str, (i11 & 2) != 0 ? reportHardInfoBean2.wifiMac : str2, (i11 & 4) != 0 ? reportHardInfoBean2.etheMac : str3, (i11 & 8) != 0 ? reportHardInfoBean2.serialNumber : str4, (i11 & 16) != 0 ? reportHardInfoBean2.diskInfo : str5, (i11 & 32) != 0 ? reportHardInfoBean2.ramSize : str6, (i11 & 64) != 0 ? reportHardInfoBean2.romSize : str7, (i11 & 128) != 0 ? reportHardInfoBean2.gatewayMac : str8, (i11 & 256) != 0 ? reportHardInfoBean2.cpuId : str9, (i11 & 512) != 0 ? reportHardInfoBean2.display : str10, (i11 & 1024) != 0 ? reportHardInfoBean2.brand : str11, (i11 & 2048) != 0 ? reportHardInfoBean2.verId : str12, (i11 & 4096) != 0 ? reportHardInfoBean2.cpuAbi : str13, (i11 & 8192) != 0 ? reportHardInfoBean2.hardware : str14, (i11 & 16384) != 0 ? reportHardInfoBean2.manufacturer : str15, (i11 & 32768) != 0 ? reportHardInfoBean2.fingerprint : str16, (i11 & 65536) != 0 ? reportHardInfoBean2.host : str17, (i11 & 131072) != 0 ? reportHardInfoBean2.device : str18, (i11 & 262144) != 0 ? reportHardInfoBean2.board : str19, (i11 & 524288) != 0 ? reportHardInfoBean2.tags : str20);
    }

    public final String component1() {
        return this.androidId;
    }

    public final String component10() {
        return this.display;
    }

    public final String component11() {
        return this.brand;
    }

    public final String component12() {
        return this.verId;
    }

    public final String component13() {
        return this.cpuAbi;
    }

    public final String component14() {
        return this.hardware;
    }

    public final String component15() {
        return this.manufacturer;
    }

    public final String component16() {
        return this.fingerprint;
    }

    public final String component17() {
        return this.host;
    }

    public final String component18() {
        return this.device;
    }

    public final String component19() {
        return this.board;
    }

    public final String component2() {
        return this.wifiMac;
    }

    public final String component20() {
        return this.tags;
    }

    public final String component3() {
        return this.etheMac;
    }

    public final String component4() {
        return this.serialNumber;
    }

    public final String component5() {
        return this.diskInfo;
    }

    public final String component6() {
        return this.ramSize;
    }

    public final String component7() {
        return this.romSize;
    }

    public final String component8() {
        return this.gatewayMac;
    }

    public final String component9() {
        return this.cpuId;
    }

    public final ReportHardInfoBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        String str21 = str;
        i.g(str21, "androidId");
        i.g(str2, "wifiMac");
        i.g(str3, "etheMac");
        i.g(str4, "serialNumber");
        i.g(str5, "diskInfo");
        i.g(str6, "ramSize");
        i.g(str7, "romSize");
        i.g(str8, "gatewayMac");
        i.g(str9, "cpuId");
        i.g(str10, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        i.g(str11, com.taobao.accs.common.Constants.KEY_BRAND);
        i.g(str12, "verId");
        i.g(str13, "cpuAbi");
        i.g(str14, "hardware");
        i.g(str15, BrowserInfo.KEY_MANUFACTURER);
        i.g(str16, "fingerprint");
        i.g(str17, com.taobao.accs.common.Constants.KEY_HOST);
        i.g(str18, Device.ELEM_NAME);
        i.g(str19, "board");
        i.g(str20, "tags");
        return new ReportHardInfoBean(str21, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportHardInfoBean)) {
            return false;
        }
        ReportHardInfoBean reportHardInfoBean = (ReportHardInfoBean) obj;
        return i.b(this.androidId, reportHardInfoBean.androidId) && i.b(this.wifiMac, reportHardInfoBean.wifiMac) && i.b(this.etheMac, reportHardInfoBean.etheMac) && i.b(this.serialNumber, reportHardInfoBean.serialNumber) && i.b(this.diskInfo, reportHardInfoBean.diskInfo) && i.b(this.ramSize, reportHardInfoBean.ramSize) && i.b(this.romSize, reportHardInfoBean.romSize) && i.b(this.gatewayMac, reportHardInfoBean.gatewayMac) && i.b(this.cpuId, reportHardInfoBean.cpuId) && i.b(this.display, reportHardInfoBean.display) && i.b(this.brand, reportHardInfoBean.brand) && i.b(this.verId, reportHardInfoBean.verId) && i.b(this.cpuAbi, reportHardInfoBean.cpuAbi) && i.b(this.hardware, reportHardInfoBean.hardware) && i.b(this.manufacturer, reportHardInfoBean.manufacturer) && i.b(this.fingerprint, reportHardInfoBean.fingerprint) && i.b(this.host, reportHardInfoBean.host) && i.b(this.device, reportHardInfoBean.device) && i.b(this.board, reportHardInfoBean.board) && i.b(this.tags, reportHardInfoBean.tags);
    }

    public final String getAndroidId() {
        return this.androidId;
    }

    public final String getBoard() {
        return this.board;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getCpuAbi() {
        return this.cpuAbi;
    }

    public final String getCpuId() {
        return this.cpuId;
    }

    public final String getDevice() {
        return this.device;
    }

    public final String getDiskInfo() {
        return this.diskInfo;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final String getEtheMac() {
        return this.etheMac;
    }

    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final String getGatewayMac() {
        return this.gatewayMac;
    }

    public final String getHardware() {
        return this.hardware;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getRamSize() {
        return this.ramSize;
    }

    public final String getRomSize() {
        return this.romSize;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getVerId() {
        return this.verId;
    }

    public final String getWifiMac() {
        return this.wifiMac;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.androidId.hashCode() * 31) + this.wifiMac.hashCode()) * 31) + this.etheMac.hashCode()) * 31) + this.serialNumber.hashCode()) * 31) + this.diskInfo.hashCode()) * 31) + this.ramSize.hashCode()) * 31) + this.romSize.hashCode()) * 31) + this.gatewayMac.hashCode()) * 31) + this.cpuId.hashCode()) * 31) + this.display.hashCode()) * 31) + this.brand.hashCode()) * 31) + this.verId.hashCode()) * 31) + this.cpuAbi.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.manufacturer.hashCode()) * 31) + this.fingerprint.hashCode()) * 31) + this.host.hashCode()) * 31) + this.device.hashCode()) * 31) + this.board.hashCode()) * 31) + this.tags.hashCode();
    }

    public final void setAndroidId(String str) {
        i.g(str, "<set-?>");
        this.androidId = str;
    }

    public final void setBoard(String str) {
        i.g(str, "<set-?>");
        this.board = str;
    }

    public final void setBrand(String str) {
        i.g(str, "<set-?>");
        this.brand = str;
    }

    public final void setCpuAbi(String str) {
        i.g(str, "<set-?>");
        this.cpuAbi = str;
    }

    public final void setCpuId(String str) {
        i.g(str, "<set-?>");
        this.cpuId = str;
    }

    public final void setDevice(String str) {
        i.g(str, "<set-?>");
        this.device = str;
    }

    public final void setDiskInfo(String str) {
        i.g(str, "<set-?>");
        this.diskInfo = str;
    }

    public final void setDisplay(String str) {
        i.g(str, "<set-?>");
        this.display = str;
    }

    public final void setEtheMac(String str) {
        i.g(str, "<set-?>");
        this.etheMac = str;
    }

    public final void setFingerprint(String str) {
        i.g(str, "<set-?>");
        this.fingerprint = str;
    }

    public final void setGatewayMac(String str) {
        i.g(str, "<set-?>");
        this.gatewayMac = str;
    }

    public final void setHardware(String str) {
        i.g(str, "<set-?>");
        this.hardware = str;
    }

    public final void setHost(String str) {
        i.g(str, "<set-?>");
        this.host = str;
    }

    public final void setManufacturer(String str) {
        i.g(str, "<set-?>");
        this.manufacturer = str;
    }

    public final void setRamSize(String str) {
        i.g(str, "<set-?>");
        this.ramSize = str;
    }

    public final void setRomSize(String str) {
        i.g(str, "<set-?>");
        this.romSize = str;
    }

    public final void setSerialNumber(String str) {
        i.g(str, "<set-?>");
        this.serialNumber = str;
    }

    public final void setTags(String str) {
        i.g(str, "<set-?>");
        this.tags = str;
    }

    public final void setVerId(String str) {
        i.g(str, "<set-?>");
        this.verId = str;
    }

    public final void setWifiMac(String str) {
        i.g(str, "<set-?>");
        this.wifiMac = str;
    }

    public String toString() {
        return "ReportHardInfoBean(androidId=" + this.androidId + ", wifiMac=" + this.wifiMac + ", etheMac=" + this.etheMac + ", serialNumber=" + this.serialNumber + ", diskInfo=" + this.diskInfo + ", ramSize=" + this.ramSize + ", romSize=" + this.romSize + ", gatewayMac=" + this.gatewayMac + ", cpuId=" + this.cpuId + ", display=" + this.display + ", brand=" + this.brand + ", verId=" + this.verId + ", cpuAbi=" + this.cpuAbi + ", hardware=" + this.hardware + ", manufacturer=" + this.manufacturer + ", fingerprint=" + this.fingerprint + ", host=" + this.host + ", device=" + this.device + ", board=" + this.board + ", tags=" + this.tags + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ReportHardInfoBean(java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, int r45, t9.g r46) {
        /*
            r24 = this;
            r0 = r45
            r1 = r0 & 512(0x200, float:7.175E-43)
            java.lang.String r2 = "unknown"
            if (r1 == 0) goto L_0x000f
            java.lang.String r1 = android.os.Build.DISPLAY
            if (r1 != 0) goto L_0x000d
            r1 = r2
        L_0x000d:
            r13 = r1
            goto L_0x0011
        L_0x000f:
            r13 = r34
        L_0x0011:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = android.os.Build.BRAND
            if (r1 != 0) goto L_0x001a
            r1 = r2
        L_0x001a:
            r14 = r1
            goto L_0x001e
        L_0x001c:
            r14 = r35
        L_0x001e:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0029
            java.lang.String r1 = android.os.Build.ID
            if (r1 != 0) goto L_0x0027
            r1 = r2
        L_0x0027:
            r15 = r1
            goto L_0x002b
        L_0x0029:
            r15 = r36
        L_0x002b:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0037
            java.lang.String r1 = android.os.Build.CPU_ABI
            if (r1 != 0) goto L_0x0034
            r1 = r2
        L_0x0034:
            r16 = r1
            goto L_0x0039
        L_0x0037:
            r16 = r37
        L_0x0039:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0045
            java.lang.String r1 = android.os.Build.HARDWARE
            if (r1 != 0) goto L_0x0042
            r1 = r2
        L_0x0042:
            r17 = r1
            goto L_0x0047
        L_0x0045:
            r17 = r38
        L_0x0047:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0053
            java.lang.String r1 = android.os.Build.MANUFACTURER
            if (r1 != 0) goto L_0x0050
            r1 = r2
        L_0x0050:
            r18 = r1
            goto L_0x0055
        L_0x0053:
            r18 = r39
        L_0x0055:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0063
            java.lang.String r1 = android.os.Build.FINGERPRINT
            if (r1 != 0) goto L_0x0060
            r1 = r2
        L_0x0060:
            r19 = r1
            goto L_0x0065
        L_0x0063:
            r19 = r40
        L_0x0065:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0072
            java.lang.String r1 = android.os.Build.HOST
            if (r1 != 0) goto L_0x006f
            r1 = r2
        L_0x006f:
            r20 = r1
            goto L_0x0074
        L_0x0072:
            r20 = r41
        L_0x0074:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0081
            java.lang.String r1 = android.os.Build.DEVICE
            if (r1 != 0) goto L_0x007e
            r1 = r2
        L_0x007e:
            r21 = r1
            goto L_0x0083
        L_0x0081:
            r21 = r42
        L_0x0083:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0090
            java.lang.String r1 = android.os.Build.BOARD
            if (r1 != 0) goto L_0x008d
            r1 = r2
        L_0x008d:
            r22 = r1
            goto L_0x0092
        L_0x0090:
            r22 = r43
        L_0x0092:
            r1 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x009f
            java.lang.String r0 = android.os.Build.TAGS
            if (r0 != 0) goto L_0x009c
            r0 = r2
        L_0x009c:
            r23 = r0
            goto L_0x00a1
        L_0x009f:
            r23 = r44
        L_0x00a1:
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = r33
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mobile.com.requestframe.utils.bean.ReportHardInfoBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, t9.g):void");
    }
}
