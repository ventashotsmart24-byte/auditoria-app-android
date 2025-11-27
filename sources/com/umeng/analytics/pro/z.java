package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.hpplay.sdk.source.common.store.Session;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

class z implements y {

    /* renamed from: a  reason: collision with root package name */
    private long f14462a = AnalyticsConfig.kContinueSessionMillis;

    public void a(long j10) {
        this.f14462a = j10;
    }

    public long a() {
        return this.f14462a;
    }

    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(currentTimeMillis + appkey + Session.DEFAULT_M);
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    public boolean a(long j10, long j11) {
        long currentTimeMillis = System.currentTimeMillis();
        if ((j10 == 0 || currentTimeMillis - j10 >= this.f14462a) && j11 > 0 && currentTimeMillis - j11 > this.f14462a) {
            return true;
        }
        return false;
    }

    public void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(w.f14443b, 0);
            edit.putLong(w.f14446e, currentTimeMillis);
            edit.putLong(w.f14447f, 0);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}
