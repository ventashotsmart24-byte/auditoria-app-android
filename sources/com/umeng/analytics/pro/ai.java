package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

public class ai implements ac {

    /* renamed from: a  reason: collision with root package name */
    private int f13722a;

    public ai(int i10) {
        this.f13722a = i10;
    }

    public boolean a() {
        long j10 = 0;
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                j10 = a10.getLong(au.f13780a, 0);
                if (j10 >= ((long) this.f13722a)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j10 + " ; config: " + this.f13722a);
        return false;
    }

    public boolean b() {
        return !a();
    }

    public long c() {
        return 0;
    }
}
