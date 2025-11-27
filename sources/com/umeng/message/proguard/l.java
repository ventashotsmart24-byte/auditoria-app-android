package com.umeng.message.proguard;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

final class l {

    /* renamed from: a  reason: collision with root package name */
    final String f15974a;

    /* renamed from: b  reason: collision with root package name */
    final String f15975b;

    /* renamed from: c  reason: collision with root package name */
    final String f15976c;

    /* renamed from: d  reason: collision with root package name */
    final long f15977d;

    /* renamed from: e  reason: collision with root package name */
    final int f15978e;

    public l(Object obj, Object obj2) {
        int i10;
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f15974a = packageInfo.packageName;
        this.f15976c = packageInfo.versionName;
        this.f15977d = packageInfo.lastUpdateTime;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            i10 = -1;
        } else {
            int i11 = applicationInfo.flags;
            if ((i11 & 1) == 0 && (i11 & 128) == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
        }
        this.f15978e = i10;
        try {
            str = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f15975b = str;
    }
}
