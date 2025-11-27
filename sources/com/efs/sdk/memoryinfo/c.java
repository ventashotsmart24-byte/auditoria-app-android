package com.efs.sdk.memoryinfo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;

final class c {
    final String activity;
    final String bg;

    /* renamed from: n  reason: collision with root package name */
    final long f5391n;

    /* renamed from: o  reason: collision with root package name */
    final long f5392o;

    /* renamed from: p  reason: collision with root package name */
    final long f5393p;

    /* renamed from: q  reason: collision with root package name */
    final long f5394q;

    /* renamed from: r  reason: collision with root package name */
    final float f5395r;

    /* renamed from: s  reason: collision with root package name */
    final long f5396s;

    /* renamed from: t  reason: collision with root package name */
    final long f5397t;

    public c(Context context) {
        String str;
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo = null;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (!(activityManager == null || (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) == null || processMemoryInfo.length <= 0)) {
                memoryInfo = processMemoryInfo[0];
            }
        } catch (Throwable unused) {
        }
        if (memoryInfo == null) {
            memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
        }
        if (UMMemoryMonitor.get().isForeground()) {
            str = "fg";
        } else {
            str = "bg";
        }
        this.bg = str;
        this.f5391n = ((long) memoryInfo.getTotalPss()) * 1024;
        this.f5392o = ((long) memoryInfo.dalvikPss) * 1024;
        this.f5393p = ((long) memoryInfo.nativePss) * 1024;
        this.f5396s = f.a(memoryInfo) * 1024;
        long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.f5394q = freeMemory;
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory != 0) {
            this.f5395r = (((float) freeMemory) * 1.0f) / ((float) maxMemory);
        } else {
            this.f5395r = 1.0f;
        }
        this.f5397t = f.a() * 1024;
        this.activity = UMMemoryMonitor.get().getCurrentActivity();
    }
}
