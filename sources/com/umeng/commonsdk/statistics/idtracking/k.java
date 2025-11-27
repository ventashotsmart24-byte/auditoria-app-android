package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.utils.d;

public class k extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14971a = "utdid";

    /* renamed from: b  reason: collision with root package name */
    private Context f14972b;

    public k(Context context) {
        super("utdid");
        this.f14972b = context;
    }

    private String g() {
        try {
            return this.f14972b.getSharedPreferences("Alvin2", 0).getString("UTDID2", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String h() {
        try {
            return this.f14972b.getSharedPreferences("um_push_ut", 0).getString("d_id", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String f() {
        try {
            if (FieldManager.allow(d.f15140u)) {
                String h10 = h();
                if (TextUtils.isEmpty(h10)) {
                    return g();
                }
                return h10;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
