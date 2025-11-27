package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class bz {

    /* renamed from: b  reason: collision with root package name */
    private static final bz f15551b = new bz();

    /* renamed from: a  reason: collision with root package name */
    public boolean f15552a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f15553c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15554d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile a f15555e;

    /* renamed from: f  reason: collision with root package name */
    private final ComponentCallbacks2 f15556f = new ComponentCallbacks2() {
        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
        }

        public final void onTrimMemory(int i10) {
            if (i10 == 20) {
                bz.a(bz.this);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f15557g = new Application.ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
            try {
                a b10 = bz.this.f15555e;
                if (b10 != null) {
                    b10.d(activity);
                }
            } catch (Throwable unused) {
            }
        }

        public final void onActivityPaused(Activity activity) {
            try {
                a b10 = bz.this.f15555e;
                if (b10 != null && !b10.f15560a.isEmpty()) {
                    Iterator<b> it = b10.f15560a.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        public final void onActivityResumed(Activity activity) {
            try {
                WeakReference unused = bz.this.f15553c = new WeakReference(activity);
                bz.c(bz.this);
                a b10 = bz.this.f15555e;
                if (b10 != null) {
                    b10.c(activity);
                }
            } catch (Throwable unused2) {
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            try {
                a b10 = bz.this.f15555e;
                if (b10 != null) {
                    b10.a(activity);
                }
            } catch (Throwable unused) {
            }
        }

        public final void onActivityStopped(Activity activity) {
            try {
                a b10 = bz.this.f15555e;
                if (b10 != null) {
                    b10.b(activity);
                }
            } catch (Throwable unused) {
            }
        }
    };

    public static abstract class b {
        public abstract String a();

        public void a(Activity activity) {
        }

        public void b(Activity activity) {
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof b) && a().equals(((b) obj).a())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return a().hashCode();
        }
    }

    private bz() {
    }

    private a c() {
        if (this.f15555e == null) {
            synchronized (a.class) {
                if (this.f15555e == null) {
                    this.f15555e = new a((byte) 0);
                }
            }
        }
        return this.f15555e;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final CopyOnWriteArraySet<b> f15560a;

        private a() {
            this.f15560a = new CopyOnWriteArraySet<>();
        }

        public final void a(Activity activity) {
            if (!this.f15560a.isEmpty()) {
                Iterator<b> it = this.f15560a.iterator();
                while (it.hasNext()) {
                    it.next().a(activity);
                }
            }
        }

        public final void b(Activity activity) {
            if (!this.f15560a.isEmpty()) {
                Iterator<b> it = this.f15560a.iterator();
                while (it.hasNext()) {
                    it.next().b(activity);
                }
            }
        }

        public final void c(Activity activity) {
            if (!this.f15560a.isEmpty()) {
                Iterator<b> it = this.f15560a.iterator();
                while (it.hasNext()) {
                    it.next().c(activity);
                }
            }
        }

        public final void d(Activity activity) {
            if (!this.f15560a.isEmpty()) {
                Iterator<b> it = this.f15560a.iterator();
                while (it.hasNext()) {
                    it.next().d(activity);
                }
            }
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static void a(Context context) {
        if (context != null) {
            bz bzVar = f15551b;
            Application application = (Application) context.getApplicationContext();
            synchronized (bzVar) {
                if (application != null) {
                    if (!bzVar.f15554d) {
                        application.registerActivityLifecycleCallbacks(bzVar.f15557g);
                        application.registerComponentCallbacks(bzVar.f15556f);
                        bzVar.f15554d = true;
                    }
                }
            }
        }
    }

    public final Activity b() {
        WeakReference<Activity> weakReference = this.f15553c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void b(b bVar) {
        a c10 = c();
        if (bVar != null) {
            c10.f15560a.remove(bVar);
        }
    }

    public static /* synthetic */ void c(bz bzVar) {
        if (!bzVar.f15552a) {
            bzVar.f15552a = true;
        }
    }

    public static bz a() {
        return f15551b;
    }

    public final void a(b bVar) {
        a c10 = c();
        if (bVar != null) {
            c10.f15560a.add(bVar);
        }
    }

    public static /* synthetic */ void a(bz bzVar) {
        if (bzVar.f15552a) {
            bzVar.f15552a = false;
        }
    }
}
