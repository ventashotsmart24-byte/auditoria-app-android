package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14947a = "idmd5";

    /* renamed from: b  reason: collision with root package name */
    private Context f14948b;

    public e(Context context) {
        super("idmd5");
        this.f14948b = context;
    }

    public String f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f14948b);
    }
}
