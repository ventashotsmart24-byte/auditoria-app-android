package mobile.com.requestframe.utils.bean;

import com.google.firebase.messaging.Constants;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.uc.crashsdk.export.LogType;
import t9.i;

public final class SnTokenBean {
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
    private String se;
    private String serialNumber;
    private String tags;
    private String verId;
    private String wifiMac;

    public SnTokenBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        String str22 = str;
        String str23 = str2;
        String str24 = str3;
        String str25 = str4;
        String str26 = str5;
        String str27 = str6;
        String str28 = str7;
        String str29 = str8;
        String str30 = str9;
        String str31 = str10;
        String str32 = str11;
        String str33 = str12;
        String str34 = str13;
        String str35 = str14;
        String str36 = str16;
        i.g(str22, "androidId");
        i.g(str23, "wifiMac");
        i.g(str24, "etheMac");
        i.g(str25, "serialNumber");
        i.g(str26, "diskInfo");
        i.g(str27, "ramSize");
        i.g(str28, "romSize");
        i.g(str29, "gatewayMac");
        i.g(str30, "cpuId");
        i.g(str31, "se");
        i.g(str32, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        i.g(str33, com.taobao.accs.common.Constants.KEY_BRAND);
        i.g(str34, "verId");
        i.g(str35, "cpuAbi");
        i.g(str15, "hardware");
        i.g(str16, BrowserInfo.KEY_MANUFACTURER);
        i.g(str17, "fingerprint");
        i.g(str18, com.taobao.accs.common.Constants.KEY_HOST);
        i.g(str19, Device.ELEM_NAME);
        i.g(str20, "board");
        i.g(str21, "tags");
        this.androidId = str22;
        this.wifiMac = str23;
        this.etheMac = str24;
        this.serialNumber = str25;
        this.diskInfo = str26;
        this.ramSize = str27;
        this.romSize = str28;
        this.gatewayMac = str29;
        this.cpuId = str30;
        this.se = str31;
        this.display = str32;
        this.brand = str33;
        this.verId = str34;
        this.cpuAbi = str35;
        this.hardware = str15;
        this.manufacturer = str16;
        this.fingerprint = str17;
        this.host = str18;
        this.device = str19;
        this.board = str20;
        this.tags = str21;
    }

    public static /* synthetic */ SnTokenBean copy$default(SnTokenBean snTokenBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, int i10, Object obj) {
        SnTokenBean snTokenBean2 = snTokenBean;
        int i11 = i10;
        return snTokenBean.copy((i11 & 1) != 0 ? snTokenBean2.androidId : str, (i11 & 2) != 0 ? snTokenBean2.wifiMac : str2, (i11 & 4) != 0 ? snTokenBean2.etheMac : str3, (i11 & 8) != 0 ? snTokenBean2.serialNumber : str4, (i11 & 16) != 0 ? snTokenBean2.diskInfo : str5, (i11 & 32) != 0 ? snTokenBean2.ramSize : str6, (i11 & 64) != 0 ? snTokenBean2.romSize : str7, (i11 & 128) != 0 ? snTokenBean2.gatewayMac : str8, (i11 & 256) != 0 ? snTokenBean2.cpuId : str9, (i11 & 512) != 0 ? snTokenBean2.se : str10, (i11 & 1024) != 0 ? snTokenBean2.display : str11, (i11 & 2048) != 0 ? snTokenBean2.brand : str12, (i11 & 4096) != 0 ? snTokenBean2.verId : str13, (i11 & 8192) != 0 ? snTokenBean2.cpuAbi : str14, (i11 & 16384) != 0 ? snTokenBean2.hardware : str15, (i11 & 32768) != 0 ? snTokenBean2.manufacturer : str16, (i11 & 65536) != 0 ? snTokenBean2.fingerprint : str17, (i11 & 131072) != 0 ? snTokenBean2.host : str18, (i11 & 262144) != 0 ? snTokenBean2.device : str19, (i11 & 524288) != 0 ? snTokenBean2.board : str20, (i11 & LogType.ANR) != 0 ? snTokenBean2.tags : str21);
    }

    public final String component1() {
        return this.androidId;
    }

    public final String component10() {
        return this.se;
    }

    public final String component11() {
        return this.display;
    }

    public final String component12() {
        return this.brand;
    }

    public final String component13() {
        return this.verId;
    }

    public final String component14() {
        return this.cpuAbi;
    }

    public final String component15() {
        return this.hardware;
    }

    public final String component16() {
        return this.manufacturer;
    }

    public final String component17() {
        return this.fingerprint;
    }

    public final String component18() {
        return this.host;
    }

    public final String component19() {
        return this.device;
    }

    public final String component2() {
        return this.wifiMac;
    }

    public final String component20() {
        return this.board;
    }

    public final String component21() {
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

    public final SnTokenBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        String str22 = str;
        i.g(str22, "androidId");
        i.g(str2, "wifiMac");
        i.g(str3, "etheMac");
        i.g(str4, "serialNumber");
        i.g(str5, "diskInfo");
        i.g(str6, "ramSize");
        i.g(str7, "romSize");
        i.g(str8, "gatewayMac");
        i.g(str9, "cpuId");
        i.g(str10, "se");
        i.g(str11, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        i.g(str12, com.taobao.accs.common.Constants.KEY_BRAND);
        i.g(str13, "verId");
        i.g(str14, "cpuAbi");
        i.g(str15, "hardware");
        i.g(str16, BrowserInfo.KEY_MANUFACTURER);
        i.g(str17, "fingerprint");
        i.g(str18, com.taobao.accs.common.Constants.KEY_HOST);
        i.g(str19, Device.ELEM_NAME);
        i.g(str20, "board");
        i.g(str21, "tags");
        return new SnTokenBean(str22, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnTokenBean)) {
            return false;
        }
        SnTokenBean snTokenBean = (SnTokenBean) obj;
        return i.b(this.androidId, snTokenBean.androidId) && i.b(this.wifiMac, snTokenBean.wifiMac) && i.b(this.etheMac, snTokenBean.etheMac) && i.b(this.serialNumber, snTokenBean.serialNumber) && i.b(this.diskInfo, snTokenBean.diskInfo) && i.b(this.ramSize, snTokenBean.ramSize) && i.b(this.romSize, snTokenBean.romSize) && i.b(this.gatewayMac, snTokenBean.gatewayMac) && i.b(this.cpuId, snTokenBean.cpuId) && i.b(this.se, snTokenBean.se) && i.b(this.display, snTokenBean.display) && i.b(this.brand, snTokenBean.brand) && i.b(this.verId, snTokenBean.verId) && i.b(this.cpuAbi, snTokenBean.cpuAbi) && i.b(this.hardware, snTokenBean.hardware) && i.b(this.manufacturer, snTokenBean.manufacturer) && i.b(this.fingerprint, snTokenBean.fingerprint) && i.b(this.host, snTokenBean.host) && i.b(this.device, snTokenBean.device) && i.b(this.board, snTokenBean.board) && i.b(this.tags, snTokenBean.tags);
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

    public final String getSe() {
        return this.se;
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
        return (((((((((((((((((((((((((((((((((((((((this.androidId.hashCode() * 31) + this.wifiMac.hashCode()) * 31) + this.etheMac.hashCode()) * 31) + this.serialNumber.hashCode()) * 31) + this.diskInfo.hashCode()) * 31) + this.ramSize.hashCode()) * 31) + this.romSize.hashCode()) * 31) + this.gatewayMac.hashCode()) * 31) + this.cpuId.hashCode()) * 31) + this.se.hashCode()) * 31) + this.display.hashCode()) * 31) + this.brand.hashCode()) * 31) + this.verId.hashCode()) * 31) + this.cpuAbi.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.manufacturer.hashCode()) * 31) + this.fingerprint.hashCode()) * 31) + this.host.hashCode()) * 31) + this.device.hashCode()) * 31) + this.board.hashCode()) * 31) + this.tags.hashCode();
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

    public final void setSe(String str) {
        i.g(str, "<set-?>");
        this.se = str;
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
        return "SnTokenBean(androidId=" + this.androidId + ", wifiMac=" + this.wifiMac + ", etheMac=" + this.etheMac + ", serialNumber=" + this.serialNumber + ", diskInfo=" + this.diskInfo + ", ramSize=" + this.ramSize + ", romSize=" + this.romSize + ", gatewayMac=" + this.gatewayMac + ", cpuId=" + this.cpuId + ", se=" + this.se + ", display=" + this.display + ", brand=" + this.brand + ", verId=" + this.verId + ", cpuAbi=" + this.cpuAbi + ", hardware=" + this.hardware + ", manufacturer=" + this.manufacturer + ", fingerprint=" + this.fingerprint + ", host=" + this.host + ", device=" + this.device + ", board=" + this.board + ", tags=" + this.tags + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SnTokenBean(java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, int r47, t9.g r48) {
        /*
            r25 = this;
            r0 = r47
            r1 = r0 & 1024(0x400, float:1.435E-42)
            java.lang.String r2 = "unknown"
            if (r1 == 0) goto L_0x000f
            java.lang.String r1 = android.os.Build.DISPLAY
            if (r1 != 0) goto L_0x000d
            r1 = r2
        L_0x000d:
            r14 = r1
            goto L_0x0011
        L_0x000f:
            r14 = r36
        L_0x0011:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = android.os.Build.BRAND
            if (r1 != 0) goto L_0x001a
            r1 = r2
        L_0x001a:
            r15 = r1
            goto L_0x001e
        L_0x001c:
            r15 = r37
        L_0x001e:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x002a
            java.lang.String r1 = android.os.Build.ID
            if (r1 != 0) goto L_0x0027
            r1 = r2
        L_0x0027:
            r16 = r1
            goto L_0x002c
        L_0x002a:
            r16 = r38
        L_0x002c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = android.os.Build.CPU_ABI
            if (r1 != 0) goto L_0x0035
            r1 = r2
        L_0x0035:
            r17 = r1
            goto L_0x003a
        L_0x0038:
            r17 = r39
        L_0x003a:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0046
            java.lang.String r1 = android.os.Build.HARDWARE
            if (r1 != 0) goto L_0x0043
            r1 = r2
        L_0x0043:
            r18 = r1
            goto L_0x0048
        L_0x0046:
            r18 = r40
        L_0x0048:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = android.os.Build.MANUFACTURER
            if (r1 != 0) goto L_0x0053
            r1 = r2
        L_0x0053:
            r19 = r1
            goto L_0x0058
        L_0x0056:
            r19 = r41
        L_0x0058:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0065
            java.lang.String r1 = android.os.Build.FINGERPRINT
            if (r1 != 0) goto L_0x0062
            r1 = r2
        L_0x0062:
            r20 = r1
            goto L_0x0067
        L_0x0065:
            r20 = r42
        L_0x0067:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0074
            java.lang.String r1 = android.os.Build.HOST
            if (r1 != 0) goto L_0x0071
            r1 = r2
        L_0x0071:
            r21 = r1
            goto L_0x0076
        L_0x0074:
            r21 = r43
        L_0x0076:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0083
            java.lang.String r1 = android.os.Build.DEVICE
            if (r1 != 0) goto L_0x0080
            r1 = r2
        L_0x0080:
            r22 = r1
            goto L_0x0085
        L_0x0083:
            r22 = r44
        L_0x0085:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0092
            java.lang.String r1 = android.os.Build.BOARD
            if (r1 != 0) goto L_0x008f
            r1 = r2
        L_0x008f:
            r23 = r1
            goto L_0x0094
        L_0x0092:
            r23 = r45
        L_0x0094:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00a1
            java.lang.String r0 = android.os.Build.TAGS
            if (r0 != 0) goto L_0x009e
            r0 = r2
        L_0x009e:
            r24 = r0
            goto L_0x00a3
        L_0x00a1:
            r24 = r46
        L_0x00a3:
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r32
            r11 = r33
            r12 = r34
            r13 = r35
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mobile.com.requestframe.utils.bean.SnTokenBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, t9.g):void");
    }
}
