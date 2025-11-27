package com.efs.sdk.launch;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f5374a = "";

    public static String a(Context context) {
        Method method;
        if (context == null) {
            return null;
        }
        Class<UMConfigure> cls = UMConfigure.class;
        try {
            UMLog uMLog = UMConfigure.umDebugLog;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getUMIDString", new Class[]{Context.class});
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke((Object) null, new Object[]{context});
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString("first_launch_cache", (String) null);
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null && (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString("first_launch_cache", (String) null);
            edit.commit();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = r4.getApplicationContext().getSharedPreferences("efs_launch", 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(android.content.Context r4) {
        /*
            java.lang.String r0 = "is_install"
            java.lang.String r1 = "efs_launch"
            r2 = 0
            if (r4 == 0) goto L_0x0016
            android.content.Context r3 = r4.getApplicationContext()
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r1, r2)
            if (r3 == 0) goto L_0x0016
            boolean r3 = r3.getBoolean(r0, r2)
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            if (r3 == 0) goto L_0x001a
            return r2
        L_0x001a:
            r3 = 1
            if (r4 == 0) goto L_0x0033
            android.content.Context r4 = r4.getApplicationContext()
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r1, r2)
            if (r4 == 0) goto L_0x0033
            android.content.SharedPreferences$Editor r4 = r4.edit()
            if (r4 == 0) goto L_0x0033
            r4.putBoolean(r0, r3)
            r4.commit()
        L_0x0033:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.launch.c.d(android.content.Context):boolean");
    }

    public static boolean e(Context context) {
        try {
            String currentProcessName = ProcessUtil.getCurrentProcessName();
            String packageName = context.getApplicationContext().getPackageName();
            return !TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName);
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null && str != null && !TextUtils.isEmpty(str) && (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString("first_launch_cache", str);
            edit.commit();
        }
    }
}
