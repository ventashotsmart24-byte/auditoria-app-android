package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

public class o implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static o f14354a = new o();

    /* renamed from: b  reason: collision with root package name */
    private final int f14355b = 3000;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f14356c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f14357d = true;

    /* renamed from: e  reason: collision with root package name */
    private Handler f14358e = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<p> f14359f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private a f14360g = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (!o.this.f14356c || !o.this.f14357d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            boolean unused = o.this.f14356c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i10 = 0; i10 < o.this.f14359f.size(); i10++) {
                ((p) o.this.f14359f.get(i10)).n();
            }
        }
    }

    private o() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.f14357d = true;
        a aVar = this.f14360g;
        if (aVar != null) {
            this.f14358e.removeCallbacks(aVar);
            this.f14358e.postDelayed(this.f14360g, 3000);
        }
    }

    public void onActivityResumed(Activity activity) {
        this.f14357d = false;
        this.f14356c = true;
        a aVar = this.f14360g;
        if (aVar != null) {
            this.f14358e.removeCallbacks(aVar);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(p pVar) {
        if (pVar != null) {
            for (int i10 = 0; i10 < this.f14359f.size(); i10++) {
                if (this.f14359f.get(i10) == pVar) {
                    this.f14359f.remove(i10);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f14354a);
        }
    }

    public static o a() {
        return f14354a;
    }

    public synchronized void a(p pVar) {
        if (pVar != null) {
            this.f14359f.add(pVar);
        }
    }
}
