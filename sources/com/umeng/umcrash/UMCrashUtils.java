package com.umeng.umcrash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.uc.crashsdk.export.CrashApi;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

public class UMCrashUtils {
    private static final int DEF_CLOSE_RATE = 0;
    private static final int MAX_TRACE_RATE = 100;
    public static final String UNKNOW = "";

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkPermission(android.content.Context r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            r3 = 1
            if (r1 < r2) goto L_0x002e
            java.lang.String r1 = "android.content.Context"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "checkSelfPermission"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x003d }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ all -> 0x003d }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ all -> 0x003d }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x003d }
            r2[r0] = r7     // Catch:{ all -> 0x003d }
            java.lang.Object r6 = r1.invoke(r6, r2)     // Catch:{ all -> 0x003d }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x003d }
            int r6 = r6.intValue()     // Catch:{ all -> 0x003d }
            if (r6 != 0) goto L_0x003d
            goto L_0x003c
        L_0x002e:
            android.content.pm.PackageManager r1 = r6.getPackageManager()
            java.lang.String r6 = r6.getPackageName()
            int r6 = r1.checkPermission(r7, r6)
            if (r6 != 0) goto L_0x003d
        L_0x003c:
            r0 = 1
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umcrash.UMCrashUtils.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    public static String[] getActiveUser(Context context) {
        Method method;
        if (context == null) {
            return null;
        }
        Class<UMUtils> cls = UMUtils.class;
        try {
            String str = UMUtils.UNKNOW;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getActiveUser", new Class[]{Context.class});
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke((Object) null, new Object[]{context});
            if (invoke != null) {
                return (String[]) invoke;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static int getInnerConfig(Context context, String str, int i10) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return i10;
        }
        try {
            if (TextUtils.isEmpty(str) || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null) {
                return i10;
            }
            return sharedPreferences.getInt(str, i10);
        } catch (Throwable th) {
            th.printStackTrace();
            return i10;
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return DeviceConfig.getNetworkOperatorName(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean isHarmony(final Context context) {
        try {
            final SharedPreferences sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0);
            if (sharedPreferences.contains("um_apm_harmony")) {
                return sharedPreferences.getBoolean("um_apm_harmony", false);
            }
            WorkThreadUtil.submit(new Runnable() {
                public void run() {
                    try {
                        sharedPreferences.edit().putBoolean("um_apm_harmony", context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony")).apply();
                    } catch (Throwable unused) {
                    }
                }
            });
            return false;
        } catch (Throwable unused) {
        }
    }

    public static boolean random(int i10) {
        if (i10 == 0) {
            return false;
        }
        if (i10 != 100 && new Random().nextInt(100) > i10) {
            return false;
        }
        return true;
    }

    public static void saveInnerConfig(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && obj != null && (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) != null && (edit = sharedPreferences.edit()) != null) {
                    edit.putInt(str, Integer.parseInt(obj.toString()));
                    edit.commit();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setCommonTag(String str, String str2) {
        Class<String> cls = String.class;
        Class<UMConfigure> cls2 = UMConfigure.class;
        try {
            UMLog uMLog = UMConfigure.umDebugLog;
            Class<UMConfigure.BS_TYPE> cls3 = UMConfigure.BS_TYPE.class;
            UMConfigure.BS_TYPE bs_type = UMConfigure.BS_TYPE.APM;
            Method declaredMethod = cls2.getDeclaredMethod("setModuleTag", new Class[]{cls3, cls, cls});
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                for (Enum enumR : (Enum[]) cls3.getEnumConstants()) {
                    if (enumR != null && enumR.name().equals("APM")) {
                        declaredMethod.invoke(cls2, new Object[]{enumR, str, str2});
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setIntegrationTesingParams(String str) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_dk", str);
        }
        if (UMCrash.getReporter() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("um_dk", str);
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static void setPuidAndProvider(String str, String str2) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PUID, str);
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PROVIDER, str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(UMCrash.KEY_HEADER_PUID, str);
        hashMap.put(UMCrash.KEY_HEADER_PROVIDER, str2);
        if (UMCrash.getReporter() != null) {
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static String splitByByte(String str, int i10) {
        StringBuffer stringBuffer = new StringBuffer(i10);
        try {
            int length = str.length();
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                String valueOf = String.valueOf(str.charAt(i12));
                i11 += valueOf.getBytes().length;
                if (i10 < i11) {
                    break;
                }
                stringBuffer.append(valueOf);
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
