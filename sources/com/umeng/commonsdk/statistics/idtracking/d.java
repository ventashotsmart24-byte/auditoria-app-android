package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14945a = "idfa";

    /* renamed from: b  reason: collision with root package name */
    private Context f14946b;

    public d(Context context) {
        super(f14945a);
        this.f14946b = context;
    }

    public String f() {
        return DeviceConfig.getIdfa(this.f14946b);
    }
}
