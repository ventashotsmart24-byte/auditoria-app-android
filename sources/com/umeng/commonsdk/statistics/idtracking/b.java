package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14939a = "android_id";

    /* renamed from: b  reason: collision with root package name */
    private Context f14940b;

    public b(Context context) {
        super(f14939a);
        this.f14940b = context;
    }

    public String f() {
        return DeviceConfig.getAndroidId(this.f14940b);
    }
}
