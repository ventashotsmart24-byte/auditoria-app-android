package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

public class a extends EventList {

    /* renamed from: a  reason: collision with root package name */
    private d f13682a;

    /* renamed from: b  reason: collision with root package name */
    private Object f13683b = new Object();

    public a(String str, String str2) {
        super(str, str2);
    }

    public void eventListChange() {
        if (!TextUtils.isEmpty(this.mEventList)) {
            synchronized (this.f13683b) {
                this.f13682a = null;
                this.f13682a = new d(false, this.mEventList);
            }
        }
    }

    public boolean matchHit(String str) {
        boolean a10;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f13683b) {
            if (this.f13682a == null) {
                this.f13682a = new d(false, this.mEventList);
            }
            a10 = this.f13682a.a(str);
        }
        return a10;
    }

    public void setMD5ClearFlag(boolean z10) {
        AnalyticsConfig.CLEAR_EKV_BL = z10;
    }
}
