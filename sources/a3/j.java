package a3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import i9.r;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import t2.a;
import t9.i;
import w9.c;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f171a = new j();

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f172b;

    /* renamed from: c  reason: collision with root package name */
    public static final List f173c = i9.j.g("googleadservices", "googleapis", "googleanalysis", "googleadmob", "googleMessaging", "umengacs", CdnType.TYPE_AWS);

    /* renamed from: d  reason: collision with root package name */
    public static final List f174d = i9.j.g("log?s=", "rpc?alt=json", "vpkg?asfast=true", "zip?g=true", "log_event");

    public final int a() {
        try {
            a aVar = a.f9350a;
            return aVar.a().getPackageManager().getPackageInfo(aVar.a().getPackageName(), 64).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public final List b() {
        return f173c;
    }

    public final List c() {
        return f174d;
    }

    public final synchronized ExecutorService d() {
        ExecutorService executorService;
        if (f172b == null) {
            f172b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("Net OkHttp Dispatcher", false));
        }
        executorService = f172b;
        i.d(executorService);
        return executorService;
    }

    public final String e(List list) {
        i.g(list, "strings");
        return (String) r.z(list, c.f19764a);
    }

    public final boolean f(Context context) {
        i.g(context, f.X);
        if (!i(context) && !j(context) && !g(context) && !h(context)) {
            return false;
        }
        return true;
    }

    public final boolean g(Context context) {
        NetworkCapabilities a10;
        i.g(context, f.X);
        try {
            Object systemService = context.getSystemService("connectivity");
            i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT >= 23) {
                Network a11 = connectivityManager.getActiveNetwork();
                if (a11 == null || (a10 = connectivityManager.getNetworkCapabilities(a11)) == null) {
                    return false;
                }
                return a10.hasTransport(1);
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public final boolean h(Context context) {
        NetworkCapabilities a10;
        i.g(context, f.X);
        try {
            Object systemService = context.getSystemService("connectivity");
            i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT >= 23) {
                Network a11 = connectivityManager.getActiveNetwork();
                if (a11 == null || (a10 = connectivityManager.getNetworkCapabilities(a11)) == null) {
                    return false;
                }
                if (a10.hasTransport(1)) {
                    return true;
                }
                if (a10.hasTransport(0)) {
                    return true;
                }
                if (a10.hasTransport(3)) {
                    return true;
                }
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public final boolean i(Context context) {
        i.g(context, f.X);
        Object systemService = context.getSystemService("connectivity");
        i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }

    public final boolean j(Context context) {
        NetworkCapabilities a10;
        i.g(context, f.X);
        try {
            Object systemService = context.getSystemService("connectivity");
            i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT >= 23) {
                Network a11 = connectivityManager.getActiveNetwork();
                if (a11 == null || (a10 = connectivityManager.getNetworkCapabilities(a11)) == null) {
                    return false;
                }
                return a10.hasTransport(1);
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
