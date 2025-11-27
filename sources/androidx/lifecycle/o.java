package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.d;

public class o extends Fragment {

    public interface a {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static class b implements Application.ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new b());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            o.a(activity, d.b.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            o.a(activity, d.b.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            o.a(activity, d.b.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            o.a(activity, d.b.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            o.a(activity, d.b.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            o.a(activity, d.b.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static void a(Activity activity, d.b bVar) {
        if (activity instanceof g) {
            d lifecycle = ((g) activity).getLifecycle();
            if (lifecycle instanceof h) {
                ((h) lifecycle).h(bVar);
            }
        }
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new o(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void b(d.b bVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), bVar);
        }
    }

    public final void c(a aVar) {
        if (aVar != null) {
            aVar.onCreate();
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    public final void e(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c((a) null);
        b(d.b.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        b(d.b.ON_DESTROY);
    }

    public void onPause() {
        super.onPause();
        b(d.b.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        d((a) null);
        b(d.b.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        e((a) null);
        b(d.b.ON_START);
    }

    public void onStop() {
        super.onStop();
        b(d.b.ON_STOP);
    }
}
