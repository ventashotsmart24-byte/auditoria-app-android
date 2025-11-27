package o;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f8340a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f8341b = b();

    /* renamed from: c  reason: collision with root package name */
    public static final Field f8342c = f();

    /* renamed from: d  reason: collision with root package name */
    public static final Method f8343d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f8344e;

    /* renamed from: f  reason: collision with root package name */
    public static final Method f8345f;

    /* renamed from: g  reason: collision with root package name */
    public static final Handler f8346g = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f8347a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f8348b;

        public a(d dVar, Object obj) {
            this.f8347a = dVar;
            this.f8348b = obj;
        }

        public void run() {
            this.f8347a.f8353a = this.f8348b;
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Application f8349a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f8350b;

        public b(Application application, d dVar) {
            this.f8349a = application;
            this.f8350b = dVar;
        }

        public void run() {
            this.f8349a.unregisterActivityLifecycleCallbacks(this.f8350b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f8351a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f8352b;

        public c(Object obj, Object obj2) {
            this.f8351a = obj;
            this.f8352b = obj2;
        }

        public void run() {
            try {
                Method method = k.f8343d;
                if (method != null) {
                    method.invoke(this.f8351a, new Object[]{this.f8352b, Boolean.FALSE, "AppCompat recreation"});
                    return;
                }
                k.f8344e.invoke(this.f8351a, new Object[]{this.f8352b, Boolean.FALSE});
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        public Object f8353a;

        /* renamed from: b  reason: collision with root package name */
        public Activity f8354b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8355c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8356d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8357e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8358f = false;

        public d(Activity activity) {
            this.f8354b = activity;
            this.f8355c = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f8354b == activity) {
                this.f8354b = null;
                this.f8357e = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f8357e && !this.f8358f && !this.f8356d && k.h(this.f8353a, this.f8355c, activity)) {
                this.f8358f = true;
                this.f8353a = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f8354b == activity) {
                this.f8356d = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class a10 = a();
        f8340a = a10;
        f8343d = d(a10);
        f8344e = c(a10);
        f8345f = e(a10);
    }

    public static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method e(Class cls) {
        Class<Configuration> cls2 = Configuration.class;
        Class<List> cls3 = List.class;
        if (g() && cls != null) {
            try {
                Class cls4 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, cls3, cls3, Integer.TYPE, cls4, cls2, cls2, cls4, cls4});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 26 || i10 == 27) {
            return true;
        }
        return false;
    }

    public static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f8342c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i10) {
                    f8346g.postAtFrontOfQueue(new c(f8341b.get(activity), obj2));
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    public static boolean i(Activity activity) {
        Object obj;
        Application application;
        d dVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f8345f == null) {
            return false;
        } else {
            if (f8344e == null && f8343d == null) {
                return false;
            }
            try {
                Object obj2 = f8342c.get(activity);
                if (obj2 == null || (obj = f8341b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f8346g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f8345f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, new Object[]{obj2, null, null, 0, bool, null, null, bool, bool});
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
