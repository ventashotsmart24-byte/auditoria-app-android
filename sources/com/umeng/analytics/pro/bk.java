package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId;

public class bk implements be {

    /* renamed from: a  reason: collision with root package name */
    private static final int f13891a = 1;

    /* renamed from: b  reason: collision with root package name */
    private OpenDeviceId f13892b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13893c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13894d = false;

    public String a(Context context) {
        boolean z10;
        if (context == null) {
            return null;
        }
        if (!this.f13893c) {
            OpenDeviceId openDeviceId = new OpenDeviceId();
            this.f13892b = openDeviceId;
            if (openDeviceId.a(context, (OpenDeviceId.CallBack<String>) null) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f13894d = z10;
            this.f13893c = true;
        }
        bs.a("getOAID", "isSupported", Boolean.valueOf(this.f13894d));
        if (!this.f13894d || !this.f13892b.c()) {
            return null;
        }
        return this.f13892b.a();
    }
}
