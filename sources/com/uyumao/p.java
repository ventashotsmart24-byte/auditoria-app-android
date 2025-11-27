package com.uyumao;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final String f16300a;

    /* renamed from: b  reason: collision with root package name */
    public final String f16301b;

    /* renamed from: c  reason: collision with root package name */
    public final String f16302c;

    /* renamed from: d  reason: collision with root package name */
    public final long f16303d;

    /* renamed from: e  reason: collision with root package name */
    public final long f16304e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16305f;

    public p(Object obj, Object obj2) {
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f16300a = packageInfo.packageName;
        this.f16302c = packageInfo.versionName;
        this.f16303d = packageInfo.firstInstallTime;
        this.f16304e = packageInfo.lastUpdateTime;
        this.f16305f = a(packageInfo);
        try {
            str = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f16301b = str;
    }

    public final int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i10 = applicationInfo.flags;
        if ((i10 & 1) == 0 && (i10 & 128) == 0) {
            return 1;
        }
        return 0;
    }
}
