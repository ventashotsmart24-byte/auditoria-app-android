package na;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f8315a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f8316b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f8317c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f8318d = "";

    /* renamed from: e  reason: collision with root package name */
    public static ExecutorService f8319e;

    public static String a() {
        if (TextUtils.isEmpty(f8318d)) {
            return Locale.getDefault().getLanguage();
        }
        return f8318d;
    }

    public static int b() {
        try {
            return f8315a.getPackageManager().getPackageInfo(g(), 64).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static String c() {
        String packageName = f8315a.getPackageName();
        try {
            return (f8315a.getPackageManager().getPackageInfo(packageName, 64).versionName + "").trim();
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String d() {
        return f.f(f8315a, "SP_DRMID", "");
    }

    public static String e() {
        return f8316b;
    }

    public static synchronized ExecutorService f() {
        ExecutorService executorService;
        synchronized (a.class) {
            if (f8319e == null) {
                f8319e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("Net OkHttp Dispatcher", false));
            }
            executorService = f8319e;
        }
        return executorService;
    }

    public static String g() {
        return f8315a.getPackageName();
    }

    public static String h() {
        if (f8317c.isEmpty()) {
            f8317c = f.f(f8315a, "key_sn", "");
        }
        return f8317c;
    }

    public static void i(String str) {
        if (!TextUtils.isEmpty(str)) {
            f8316b = str;
        }
    }
}
