package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class g extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14961a = "imei";

    /* renamed from: b  reason: collision with root package name */
    private Context f14962b;

    public g(Context context) {
        super("imei");
        this.f14962b = context;
    }

    public String f() {
        return DeviceConfig.getImeiNew(this.f14962b);
    }
}
