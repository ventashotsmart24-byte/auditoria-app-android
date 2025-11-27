package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

public class b extends EventList {

    /* renamed from: a  reason: collision with root package name */
    private d f13684a;

    /* renamed from: b  reason: collision with root package name */
    private Object f13685b = new Object();

    public b(String str, String str2) {
        super(str, str2);
    }

    public void eventListChange() {
        if (!TextUtils.isEmpty(this.mEventList)) {
            synchronized (this.f13685b) {
                this.f13684a = null;
                this.f13684a = new d(true, this.mEventList);
            }
        }
    }

    public boolean matchHit(String str) {
        boolean a10;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f13685b) {
            if (this.f13684a == null) {
                this.f13684a = new d(true, this.mEventList);
            }
            a10 = this.f13684a.a(str);
        }
        return a10;
    }

    public void setMD5ClearFlag(boolean z10) {
        AnalyticsConfig.CLEAR_EKV_WL = z10;
    }
}
