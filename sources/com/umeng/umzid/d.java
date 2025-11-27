package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.hpplay.component.common.ParamsMap;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f16215a = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.excelliance.multiaccounts", "com.lody.virtual", "com.qihoo.magic"};

    public static String a(Context context) {
        Class<DeviceConfig> cls = DeviceConfig.class;
        try {
            String str = DeviceConfig.UNKNOW;
            Method declaredMethod = cls.getDeclaredMethod("getAndroidId", new Class[]{Context.class});
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, new Object[]{context});
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String b(Context context) {
        SharedPreferences a10;
        if (context == null || (a10 = a.a(context)) == null) {
            return "";
        }
        String string = a10.getString("inputDomain", "");
        return c(string) ? a(string) : string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = com.umeng.umzid.a.a(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x0011
            android.content.SharedPreferences r2 = com.umeng.umzid.a.a(r2)
            if (r2 == 0) goto L_0x0011
            java.lang.String r1 = "uabc"
            java.lang.String r2 = r2.getString(r1, r0)
            return r2
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.d.c(android.content.Context):java.lang.String");
    }

    public static String d(Context context) {
        SharedPreferences a10;
        if (context == null || (a10 = a.a(context)) == null) {
            return null;
        }
        return a10.getString("aaid", (String) null);
    }

    public static String e(Context context) {
        Class<DeviceConfig> cls = DeviceConfig.class;
        try {
            String str = DeviceConfig.UNKNOW;
            Method declaredMethod = cls.getDeclaredMethod("getMac", new Class[]{Context.class});
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, new Object[]{context});
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String f(Context context) {
        Class<DeviceConfig> cls = DeviceConfig.class;
        try {
            String str = DeviceConfig.UNKNOW;
            Method declaredMethod = cls.getDeclaredMethod("getOaid", new Class[]{Context.class});
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, new Object[]{context});
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static boolean g(Context context) {
        boolean z10;
        try {
            String path = context.getFilesDir().getPath();
            String[] strArr = f16215a;
            int length = strArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                } else if (path.contains(strArr[i10])) {
                    z10 = true;
                    break;
                } else {
                    i10++;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
        z10 = false;
        if (z10) {
            return true;
        }
        return false;
    }

    public static boolean h(Context context) {
        Class<UMUtils> cls = UMUtils.class;
        try {
            String str = UMUtils.UNKNOW;
            Method declaredMethod = cls.getDeclaredMethod("isMainProgress", new Class[]{Context.class});
            if (declaredMethod == null) {
                return true;
            }
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(cls, new Object[]{context})).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean i(Context context) {
        NetworkInfo networkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (!(connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(17)) == null)) {
                    return networkInfo.isConnected();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean j(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return !TextUtils.isEmpty(property) && Integer.parseInt(property2) != -1;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void c(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        if (context != null && !TextUtils.isEmpty(str) && (a10 = a.a(context)) != null && (edit = a10.edit()) != null) {
            edit.putString("resetToken", str).commit();
        }
    }

    public static void d(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        if (context != null && !TextUtils.isEmpty(str) && (a10 = a.a(context)) != null && (edit = a10.edit()) != null) {
            edit.putString("uabc", str).commit();
        }
    }

    public static void e(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        if (context != null && str != null && !TextUtils.isEmpty(str) && (a10 = a.a(context)) != null && (edit = a10.edit()) != null) {
            edit.putString("aaid", str).commit();
        }
    }

    public static void f(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        if (context != null && str != null && !TextUtils.isEmpty(str) && (a10 = a.a(context)) != null && (edit = a10.edit()) != null) {
            edit.putString("zdata", str).commit();
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        String b10 = b(str);
        if (context != null && b10 != null && !TextUtils.isEmpty(b10) && (a10 = a.a(context)) != null && (edit = a10.edit()) != null) {
            edit.putString(ParamsMap.DeviceParams.KEY_MAC, b10).commit();
        }
    }

    public static void b(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        String b10 = b(str);
        if (context != null && b10 != null && !TextUtils.isEmpty(b10) && (a10 = a.a(context)) != null && (edit = a10.edit()) != null) {
            edit.putString("oaid", b10).commit();
        }
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(b(a(str)));
    }
}
