package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.d;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14941a = bd.b().b(bd.f13852l);

    /* renamed from: b  reason: collision with root package name */
    public static final String f14942b = "key_umeng_sp_honor_oaid";

    /* renamed from: c  reason: collision with root package name */
    private static final String f14943c = "honor_oaid";

    /* renamed from: d  reason: collision with root package name */
    private Context f14944d;

    public c(Context context) {
        super(f14943c);
        this.f14944d = context;
    }

    public String f() {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** HonorOaidTracker.getId(): oaid开关已关闭。");
            return null;
        } else if (!FieldManager.allow(d.G)) {
            return null;
        } else {
            try {
                SharedPreferences sharedPreferences = this.f14944d.getSharedPreferences(f14941a, 0);
                if (sharedPreferences != null) {
                    return sharedPreferences.getString(f14942b, "");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
