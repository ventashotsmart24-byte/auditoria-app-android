package org.android.agoo.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.utl.ALog;

public class Config {
    public static final String AGOO_CLEAR_TIME = "agoo_clear_time";
    public static final String AGOO_UNREPORT_TIMES = "agoo_UnReport_times";
    public static final String KEY_DEVICE_TOKEN = "deviceId";
    public static final String PREFERENCES = "Agoo_AppStore";
    public static final String PROPERTY_APP_KEY = "agoo_app_key";
    public static final String PROPERTY_APP_VERSION = "app_version";
    public static final String PROPERTY_DEVICE_TOKEN = "app_device_token";
    public static final String PROPERTY_PUSH_USER_TOKEN = "app_push_user_token";
    public static final String PROPERTY_SECRET_KEY = "agoo_secret";
    public static final String PROPERTY_TT_ID = "app_tt_id";
    public static final String TAG = "Config";

    /* renamed from: a  reason: collision with root package name */
    public static String f8577a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f8578b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8579c = false;

    /* renamed from: d  reason: collision with root package name */
    private static String f8580d;

    /* renamed from: e  reason: collision with root package name */
    private static String f8581e;

    public static String a(Context context) {
        String str = f8578b;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            str = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_APP_KEY, (String) null);
        } catch (Throwable th) {
            ALog.e(TAG, "getAgooAppKey", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "getAgooAppKey null!!", new Object[0]);
        } else {
            ALog.d(TAG, "getAgooAppKey", "appkey", str);
        }
        return str;
    }

    public static String b(Context context) {
        String str = f8580d;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            str = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_SECRET_KEY, "");
        } catch (Throwable th) {
            ALog.e(TAG, "getAgooMessageSecret", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "getAgooMessageSecret null!!", new Object[0]);
        } else {
            ALog.d(TAG, "getAgooMessageSecret", "secret", str);
        }
        return str;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f8577a)) {
            return ACCSManager.getDefaultConfig(context);
        }
        return f8577a;
    }

    public static boolean d(Context context) {
        try {
            if (context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0) > 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void e(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putInt(AGOO_UNREPORT_TIMES, 0);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static int f(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String g(Context context) {
        String str;
        try {
            str = context.getSharedPreferences(PREFERENCES, 4).getString("deviceId", f8581e);
        } catch (Throwable th) {
            ALog.e(TAG, "getDeviceToken", th, new Object[0]);
            str = null;
        }
        ALog.i(TAG, "getDeviceToken", ParamsMap.DeviceParams.KEY_AUTH_TOKEN, str);
        return str;
    }

    public static String h(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_PUSH_USER_TOKEN, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void setAgooAppKey(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                ALog.e(TAG, "setAgooAppKey appkey null", new Object[0]);
            } else if (TextUtils.isEmpty(f8578b)) {
                String a10 = a(context);
                f8578b = str;
                if (!TextUtils.equals(a10, str)) {
                    f8579c = true;
                    SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
                    edit.putString(PROPERTY_APP_KEY, str);
                    edit.apply();
                    ALog.d(TAG, "setAgooAppKey", "appkey", str);
                }
            } else if (!TextUtils.equals(str, f8578b)) {
                ALog.e(TAG, "setAgooAppKey error!", "new", str, "old", f8578b);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "setAgooAppKey", th, new Object[0]);
        }
    }

    public static void c(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            if (!TextUtils.isEmpty(str)) {
                edit.putString(PROPERTY_PUSH_USER_TOKEN, str);
            }
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                ALog.e(TAG, "setAgooMessageSecret secret null", new Object[0]);
            } else if (TextUtils.isEmpty(f8580d)) {
                f8580d = str;
                SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
                edit.putString(PROPERTY_SECRET_KEY, f8580d);
                edit.apply();
                ALog.d(TAG, "setAgooMessageSecret", "secret", str);
            } else if (!TextUtils.equals(str, f8580d)) {
                ALog.e(TAG, "setAgooMessageSecret error!", "new", str, "old", f8580d);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "setAgooMessageSecret", th, new Object[0]);
        }
    }

    public static void b(Context context, String str) {
        ALog.i(TAG, "setDeviceToken", ParamsMap.DeviceParams.KEY_AUTH_TOKEN, str);
        if (!TextUtils.isEmpty(str)) {
            f8581e = str;
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
                edit.putString("deviceId", str);
                edit.apply();
            } catch (Throwable th) {
                ALog.e(TAG, "setDeviceToken", th, new Object[0]);
            }
        }
    }

    public static boolean b(Context context, long j10) {
        try {
            long j11 = context.getSharedPreferences(PREFERENCES, 4).getLong(AGOO_CLEAR_TIME, 0);
            StringBuilder sb = new StringBuilder();
            sb.append("now=");
            sb.append(j10);
            sb.append(",now - lastTime=");
            long j12 = j10 - j11;
            sb.append(j12);
            sb.append(",istrue=");
            sb.append(j12 > 86400000);
            ALog.d("isClearTime", sb.toString(), new Object[0]);
            if (j10 == 0 || j12 <= 86400000) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a() {
        return f8579c;
    }

    public static void a(Context context, int i10) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES, 4);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(AGOO_UNREPORT_TIMES, sharedPreferences.getInt(AGOO_UNREPORT_TIMES, 0) + i10);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, long j10) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putLong(AGOO_CLEAR_TIME, j10);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
