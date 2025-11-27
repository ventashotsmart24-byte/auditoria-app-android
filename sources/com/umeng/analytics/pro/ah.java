package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

public class ah implements ac {

    /* renamed from: a  reason: collision with root package name */
    private String f13720a;

    /* renamed from: b  reason: collision with root package name */
    private long f13721b;

    public ah(String str, long j10) {
        this.f13720a = str;
        this.f13721b = j10;
    }

    public boolean a() {
        try {
            String str = au.f13781b + this.f13720a;
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - a10.getLong(str, 0);
            if (currentTimeMillis > this.f13721b * 1000) {
                return true;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.f13721b * 1000));
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b() {
        return !a();
    }

    public long c() {
        return 0;
    }
}
