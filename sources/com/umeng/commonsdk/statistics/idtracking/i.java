package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.d;

public class i extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14965a = bd.b().b(bd.f13852l);

    /* renamed from: b  reason: collision with root package name */
    public static final String f14966b = "key_umeng_sp_oaid";

    /* renamed from: c  reason: collision with root package name */
    public static final String f14967c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d  reason: collision with root package name */
    private static final String f14968d = "oaid";

    /* renamed from: e  reason: collision with root package name */
    private Context f14969e;

    public i(Context context) {
        super(f14968d);
        this.f14969e = context;
    }

    public String f() {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OaidTracking.getId(): oaid开关已关闭。");
            return null;
        } else if (!FieldManager.allow(d.G)) {
            return null;
        } else {
            try {
                SharedPreferences sharedPreferences = this.f14969e.getSharedPreferences(f14965a, 0);
                if (sharedPreferences != null) {
                    return sharedPreferences.getString(f14966b, "");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
