package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;
import com.umeng.message.common.UPLog;

public final class as {

    /* renamed from: a  reason: collision with root package name */
    public aq f15415a;

    public final boolean a() {
        aq aqVar = this.f15415a;
        if (aqVar == null) {
            return false;
        }
        return aqVar.f15405b.isShown();
    }

    public final void a(Activity activity) {
        if (activity != null && !activity.isFinishing() && a()) {
            final at atVar = this.f15415a.f15405b;
            final WindowManager a10 = a((Context) activity);
            activity.runOnUiThread(new Runnable() {
                public final void run() {
                    try {
                        a10.removeViewImmediate(atVar);
                    } catch (Throwable th) {
                        UPLog.e("Pop", "dismiss", th);
                    }
                }
            });
            this.f15415a = null;
        }
    }

    public static WindowManager a(Context context) {
        return (WindowManager) context.getSystemService("window");
    }
}
