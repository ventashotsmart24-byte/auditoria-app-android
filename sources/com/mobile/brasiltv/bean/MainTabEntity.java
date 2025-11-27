package com.mobile.brasiltv.bean;

import android.graphics.drawable.Drawable;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.utils.b0;
import t9.g;
import t9.i;

public final class MainTabEntity implements CustomTabEntity {
    private final String enTitle;
    private boolean isNet;
    private Drawable selectedDrawable;
    private final int selectedIcon;
    private final String selectedIconUrl;
    private int seriesNumber;
    private final String title;
    private Drawable unSelectDrawable;
    private final int unSelectedIcon;
    private final String unSelectedIconUrl;
    private final String zhTitle;

    public MainTabEntity() {
        this((String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, false, 0, 511, (g) null);
    }

    public final Drawable getSelectedDrawable() {
        return this.selectedDrawable;
    }

    public final String getSelectedIconUrl() {
        return this.selectedIconUrl;
    }

    public final int getSeriesNumber() {
        return this.seriesNumber;
    }

    public int getTabSelectedIcon() {
        return this.selectedIcon;
    }

    public String getTabTitle() {
        boolean z10;
        if (this.title.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return b0.c(this.enTitle, this.zhTitle);
        }
        return this.title;
    }

    public int getTabUnselectedIcon() {
        return this.unSelectedIcon;
    }

    public final Drawable getUnSelectDrawable() {
        return this.unSelectDrawable;
    }

    public final String getUnSelectedIconUrl() {
        return this.unSelectedIconUrl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isUseNetIcon() {
        /*
            r3 = this;
            java.lang.String r0 = r3.selectedIconUrl
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0013
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 != r1) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r3.unSelectedIconUrl
            if (r0 == 0) goto L_0x0027
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0022
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            if (r0 != r1) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x002f
            boolean r0 = r3.isNet
            if (r0 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r1 = 0
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.bean.MainTabEntity.isUseNetIcon():boolean");
    }

    public final void setSelectedDrawable(Drawable drawable) {
        this.selectedDrawable = drawable;
    }

    public final void setSeriesNumber(int i10) {
        this.seriesNumber = i10;
    }

    public final void setUnSelectDrawable(Drawable drawable) {
        this.unSelectDrawable = drawable;
    }

    public String toString() {
        return "MainTabEntity(title='" + this.title + "', selectedIcon=" + this.selectedIcon + ", unSelectedIcon=" + this.unSelectedIcon + ", selectedIconUrl=" + this.selectedIconUrl + ", unSelectedIconUrl=" + this.unSelectedIconUrl + ", zhTitle=" + this.zhTitle + ", enTitle=" + this.enTitle + ", isNet=" + this.isNet + ", seriesNumber=" + this.seriesNumber + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public MainTabEntity(String str, int i10, int i11, String str2, String str3, String str4, String str5, boolean z10, int i12) {
        i.g(str, "title");
        this.title = str;
        this.selectedIcon = i10;
        this.unSelectedIcon = i11;
        this.selectedIconUrl = str2;
        this.unSelectedIconUrl = str3;
        this.zhTitle = str4;
        this.enTitle = str5;
        this.isNet = z10;
        this.seriesNumber = i12;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MainTabEntity(java.lang.String r11, int r12, int r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, boolean r18, int r19, int r20, t9.g r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r11
        L_0x000b:
            r3 = r0 & 2
            r4 = -1
            if (r3 == 0) goto L_0x0012
            r3 = -1
            goto L_0x0013
        L_0x0012:
            r3 = r12
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r4 = r13
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0020
        L_0x001f:
            r5 = r14
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0027
        L_0x0026:
            r6 = r15
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r16
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r2 = r17
        L_0x0036:
            r8 = r0 & 128(0x80, float:1.794E-43)
            r9 = 0
            if (r8 == 0) goto L_0x003d
            r8 = 0
            goto L_0x003f
        L_0x003d:
            r8 = r18
        L_0x003f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r9 = r19
        L_0x0046:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r2
            r19 = r8
            r20 = r9
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.bean.MainTabEntity.<init>(java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, int, t9.g):void");
    }
}
