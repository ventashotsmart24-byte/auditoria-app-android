package com.efs.sdk.fluttersdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import java.util.Map;

public class FlutterManager {
    public static final String TAG = "FlutterManager";

    /* renamed from: a  reason: collision with root package name */
    private static EfsReporter f5328a = null;

    /* renamed from: b  reason: collision with root package name */
    private static FlutterConfigManager f5329b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Context f5330c = null;
    public static boolean isDebug = true;

    public static Map<String, Object> getCloudConfig() {
        FlutterConfigManager flutterConfigManager = f5329b;
        if (flutterConfigManager != null) {
            return flutterConfigManager.getCloudConfig();
        }
        return null;
    }

    public static FlutterConfigManager getFlutterConfigManager() {
        return f5329b;
    }

    public static long getLongValue(String str) {
        Context context = f5330c;
        if (context == null) {
            Log.e(TAG, "Flutter Manager not init!");
            return 0;
        }
        try {
            return context.getSharedPreferences("efs_flutter_bridge", 0).getLong(str, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static Map<String, Object> getNativeParams() {
        FlutterConfigManager flutterConfigManager = f5329b;
        if (flutterConfigManager != null) {
            return flutterConfigManager.getNativeParams();
        }
        return null;
    }

    public static EfsReporter getReporter() {
        return f5328a;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            Log.e(TAG, "init Flutter manager error! parameter is null!");
            return;
        }
        f5330c = context;
        f5328a = efsReporter;
        f5329b = new FlutterConfigManager(context, efsReporter);
    }

    public static boolean putLongValue(String str, long j10) {
        Context context = f5330c;
        if (context == null) {
            Log.e(TAG, "Flutter Manager not init!");
            return false;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("efs_flutter_bridge", 0).edit();
            edit.putLong(str, j10);
            edit.apply();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
