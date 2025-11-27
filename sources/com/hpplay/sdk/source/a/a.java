package com.hpplay.sdk.source.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static Application.ActivityLifecycleCallbacks f11569a = new Application.ActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            SourceLog.i(a.f11570b, "onActivityDestroyed");
        }

        public void onActivityPaused(Activity activity) {
            SourceLog.i(a.f11570b, "onActivityPaused");
        }

        public void onActivityResumed(Activity activity) {
            int unused = a.f11573f = activity.hashCode();
            SourceLog.i(a.f11570b, "onActivityResumed   " + a.f11571c.get());
            if (a.f11571c.get() && a.f11572e != null) {
                a.f11572e.onAppResume();
            }
            a.f11571c.set(false);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            SourceLog.i(a.f11570b, "onActivitySaveInstanceState  " + a.f11571c.get());
            if (!a.f11571c.get() && a.f11572e != null && a.f11573f == activity.hashCode()) {
                SourceLog.i(a.f11570b, "app exited Background ");
                a.f11572e.onAppPause();
                a.f11571c.set(true);
            }
        }

        public void onActivityStarted(Activity activity) {
            SourceLog.i(a.f11570b, "onActivityStarted");
        }

        public void onActivityStopped(Activity activity) {
            SourceLog.i(a.f11570b, "onActivityStopped");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final String f11570b = "AppLifecycleListen";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static AtomicBoolean f11571c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static C0157a f11572e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static int f11573f;

    /* renamed from: d  reason: collision with root package name */
    private Application f11574d;

    /* renamed from: com.hpplay.sdk.source.a.a$a  reason: collision with other inner class name */
    public interface C0157a {
        void onAppPause();

        void onAppResume();
    }

    public a() {
        try {
            Application application = HapplayUtils.getApplication();
            this.f11574d = application;
            application.registerActivityLifecycleCallbacks(f11569a);
        } catch (Exception e10) {
            SourceLog.w(f11570b, (Throwable) e10);
        }
    }

    public void a(C0157a aVar) {
        f11572e = aVar;
    }

    public void a() {
        Application application = this.f11574d;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(f11569a);
        }
    }
}
