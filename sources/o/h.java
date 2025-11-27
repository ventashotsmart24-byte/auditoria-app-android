package o;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;

public abstract class h extends p.a {

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f8331a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f8332b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f8333c;

        public a(String[] strArr, Activity activity, int i10) {
            this.f8331a = strArr;
            this.f8332b = activity;
            this.f8333c = i10;
        }

        public void run() {
            int[] iArr = new int[this.f8331a.length];
            PackageManager packageManager = this.f8332b.getPackageManager();
            String packageName = this.f8332b.getPackageName();
            int length = this.f8331a.length;
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = packageManager.checkPermission(this.f8331a[i10], packageName);
            }
            ((c) this.f8332b).onRequestPermissionsResult(this.f8333c, this.f8331a, iArr);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f8334a;

        public b(Activity activity) {
            this.f8334a = activity;
        }

        public void run() {
            if (!this.f8334a.isFinishing() && !k.i(this.f8334a)) {
                this.f8334a.recreate();
            }
        }
    }

    public interface c {
        void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);
    }

    public interface d {
        void validateRequestPermissionsRequestCode(int i10);
    }

    public static void b(Activity activity) {
        activity.finishAffinity();
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void e(Activity activity) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            activity.recreate();
        } else if (i10 <= 23) {
            new Handler(activity.getMainLooper()).post(new b(activity));
        } else if (!k.i(activity)) {
            activity.recreate();
        }
    }

    public static void f(Activity activity, String[] strArr, int i10) {
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            if (!TextUtils.isEmpty(strArr[i11])) {
                i11++;
            } else {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof d) {
                ((d) activity).validateRequestPermissionsRequestCode(i10);
            }
            activity.requestPermissions(strArr, i10);
        } else if (activity instanceof c) {
            new Handler(Looper.getMainLooper()).post(new a(strArr, activity, i10));
        }
    }

    public static void g(Activity activity, k1 k1Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback((SharedElementCallback) null);
        }
    }

    public static void h(Activity activity, k1 k1Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback((SharedElementCallback) null);
        }
    }

    public static boolean i(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void j(Activity activity, Intent intent, int i10, Bundle bundle) {
        activity.startActivityForResult(intent, i10, bundle);
    }

    public static void k(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public static void l(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }
}
