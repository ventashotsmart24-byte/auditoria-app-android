package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14963a = "mac";

    /* renamed from: b  reason: collision with root package name */
    private Context f14964b;

    public h(Context context) {
        super("mac");
        this.f14964b = context;
    }

    public String f() {
        try {
            return DeviceConfig.getMac(this.f14964b);
        } catch (Exception e10) {
            if (AnalyticsConstants.UM_DEBUG) {
                e10.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f14964b, e10);
            return null;
        }
    }
}
