package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14970a = "serial";

    public j() {
        super(f14970a);
    }

    public String f() {
        return DeviceConfig.getSerial();
    }
}
