package com.umeng.message.proguard;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.ut.device.UTDevice;
import java.io.Closeable;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f15949a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f15950b = true;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f15951c = false;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicInteger f15952d = new AtomicInteger(1);

    /* renamed from: e  reason: collision with root package name */
    private static String f15953e;

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f15954f;

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f15955g;

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b(Context context) {
        Boolean bool = f15954f;
        if (bool != null) {
            return bool.booleanValue();
        }
        String packageName = context.getPackageName();
        Boolean valueOf = Boolean.valueOf(!TextUtils.isEmpty(packageName) && TextUtils.equals(a(context), packageName));
        f15954f = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean c(Context context) {
        Boolean bool = null;
        try {
            bool = (Boolean) bn.a(bn.a(UTDevice.class.getName(), "isNewDid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
        return Boolean.TRUE.equals(bool);
    }

    public static String d(Context context) {
        try {
            return (String) bn.a(bn.a(UTDevice.class.getName(), "getTid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
            return null;
        }
    }

    public static void e(Context context) {
        try {
            bn.a(bn.a(UTDevice.class.getName(), "removeTid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
    }

    public static boolean f(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    public static File g(Context context) {
        File file = new File(context.getCacheDir(), "umeng_push");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return file;
    }

    public static void a(Context context, Class<?> cls) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.getApplicationEnabledSetting(context.getPackageName()) >= 0) {
                ComponentName componentName = new ComponentName(context, cls);
                if (!a(packageManager, componentName)) {
                    packageManager.setComponentEnabledSetting(componentName, 1, 1);
                }
            }
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
    }

    public static boolean b() {
        Boolean bool = f15955g;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z10 = false;
        Boolean bool2 = null;
        try {
            bool2 = (Boolean) bn.a(bn.a(UMConfigure.class.getName(), "isSilentMode", (Class<?>[]) new Class[0]), (Object) null, (Object[]) null);
        } catch (Throwable unused) {
        }
        if (bool2 != null) {
            z10 = bool2.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(z10);
        f15955g = valueOf;
        return valueOf.booleanValue();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|(3:1|2|3)|(2:7|8)|9|10|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c() {
        /*
            r0 = 1
            com.umeng.message.proguard.f$1 r1 = new com.umeng.message.proguard.f$1     // Catch:{ all -> 0x0013 }
            r1.<init>()     // Catch:{ all -> 0x0013 }
            com.umeng.ccg.CcgAgent.getConfigInfo(r1)     // Catch:{ all -> 0x0013 }
            com.umeng.message.proguard.f$2 r1 = new com.umeng.message.proguard.f$2     // Catch:{ all -> 0x0013 }
            r1.<init>()     // Catch:{ all -> 0x0013 }
            com.umeng.ccg.CcgAgent.registerConfigUpdateListener(r1)     // Catch:{ all -> 0x0013 }
            r1 = 1
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            if (r1 != 0) goto L_0x001e
            com.umeng.message.proguard.f$3 r1 = new com.umeng.message.proguard.f$3     // Catch:{ all -> 0x001e }
            r1.<init>()     // Catch:{ all -> 0x001e }
            com.umeng.ccg.CcgAgent.registerConfigListener(r1)     // Catch:{ all -> 0x001e }
        L_0x001e:
            com.umeng.message.proguard.s r1 = new com.umeng.message.proguard.s     // Catch:{ all -> 0x0028 }
            r1.<init>()     // Catch:{ all -> 0x0028 }
            com.umeng.commonsdk.UMConfigure.registerActionInfo(r1)     // Catch:{ all -> 0x0028 }
            f15951c = r0     // Catch:{ all -> 0x0028 }
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.f.c():void");
    }

    private static boolean a(PackageManager packageManager, ComponentName componentName) {
        try {
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
            return componentEnabledSetting == 1 || componentEnabledSetting == 0;
        } catch (Throwable th) {
            UPLog.e("Helper", th);
            return false;
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f15953e)) {
            return f15953e;
        }
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
            }
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
        if (TextUtils.isEmpty(str)) {
            str = UMFrUtils.getCurrentProcessName(context);
        }
        f15953e = str;
        return str;
    }

    public static String a(Context context, String str) {
        String str2 = context.getCacheDir() + "/umeng_push_inapp/";
        if (str == null) {
            return str2;
        }
        return str2 + str + Operator.Operation.DIVISION;
    }

    public static int a() {
        return View.generateViewId();
    }

    public static void a(Context context, String str, long j10) {
        try {
            bn.a(bn.a(UTDevice.class.getName(), "resetDid", (Class<?>[]) new Class[]{Context.class, String.class, Long.TYPE}), (Object) null, new Object[]{context, str, Long.valueOf(j10)});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
    }

    public static Object a(Object obj, String str) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(long j10) {
        Calendar instance = Calendar.getInstance();
        int i10 = instance.get(1);
        int i11 = instance.get(6);
        instance.setTimeInMillis(j10);
        if (i11 == instance.get(6) && i10 == instance.get(1)) {
            return true;
        }
        return false;
    }

    public static Bitmap a(File file, int i10, int i11) {
        if (i11 == 0 || i10 == 0) {
            return BitmapFactory.decodeFile(file.getPath(), (BitmapFactory.Options) null);
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
            float f10 = i10 >= i11 ? ((float) options.outWidth) / ((float) i10) : ((float) options.outHeight) / ((float) i11);
            if (f10 < 1.0f) {
                f10 = 1.0f;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = (int) f10;
            return BitmapFactory.decodeFile(file.getPath(), options);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1753817752:
                if (str.equals("NIOPUSH_TOKEN")) {
                    c10 = 0;
                    break;
                }
                break;
            case -663492951:
                if (str.equals("HW_TOKEN")) {
                    c10 = 1;
                    break;
                }
                break;
            case -79525514:
                if (str.equals("MI_TOKEN")) {
                    c10 = 2;
                    break;
                }
                break;
            case 102161:
                if (str.equals("gcm")) {
                    c10 = 3;
                    break;
                }
                break;
            case 385022372:
                if (str.equals("HONOR_TOKEN")) {
                    c10 = 4;
                    break;
                }
                break;
            case 676859002:
                if (str.equals("OPPO_TOKEN")) {
                    c10 = 5;
                    break;
                }
                break;
            case 935471238:
                if (str.equals("VIVO_TOKEN")) {
                    c10 = 6;
                    break;
                }
                break;
            case 2123135175:
                if (str.equals("MZ_TOKEN")) {
                    c10 = 7;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return UPushThirdTokenCallback.TYPE_NIO;
            case 1:
                return "huawei";
            case 2:
                return "xiaomi";
            case 3:
                return "fcm";
            case 4:
                return UPushThirdTokenCallback.TYPE_HONOR;
            case 5:
                return "oppo";
            case 6:
                return "vivo";
            case 7:
                return "meizu";
            default:
                return str;
        }
    }

    public static void a(boolean z10) {
        f15949a = z10;
        try {
            bn.a(bn.a(UMConfigure.class.getName(), "enableAplCollection", (Class<?>[]) new Class[]{Boolean.TYPE}), (Object) null, new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused) {
        }
    }
}
