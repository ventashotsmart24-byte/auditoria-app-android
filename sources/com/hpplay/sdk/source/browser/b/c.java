package com.hpplay.sdk.source.browser.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.View;
import com.hpplay.common.log.LeLog;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11616a = "Util";

    /* renamed from: b  reason: collision with root package name */
    public static String f11617b = "14255,16963";

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicInteger f11618c = new AtomicInteger(1);

    public static Bitmap a(String str) {
        return null;
    }

    public static boolean b(String str) {
        LeLog.i(f11616a, "dongle appids=" + f11617b + " current appid=" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String equals : f11617b.split(",")) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int a() {
        try {
            return View.generateViewId();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Deprecated
    public static Bitmap a(Context context, String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = context.getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (Exception e10) {
            LeLog.w(f11616a, (Throwable) e10);
            return bitmap;
        }
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            LeLog.i(f11616a, "isNetworkAvailable Unavailabel");
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo state : allNetworkInfo) {
                if (state.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
