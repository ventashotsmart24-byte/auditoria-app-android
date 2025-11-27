package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.a;
import com.umeng.ut.device.UTDevice;
import java.io.File;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static String f13226a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f13227b = "";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f13228c = true;
    public static final String channelService = "com.taobao.accs.ChannelService";

    /* renamed from: d  reason: collision with root package name */
    private static boolean f13229d = false;
    public static final String msgService = "com.taobao.accs.data.MsgDistributeService";

    public static boolean a(Context context) {
        String str;
        if (f13229d) {
            return f13228c;
        }
        try {
            if (TextUtils.isEmpty(a.f12915c)) {
                if (TextUtils.isEmpty(f13226a)) {
                    f13226a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
                }
                str = f13226a;
            } else {
                str = a.f12915c;
            }
            if (TextUtils.isEmpty(f13227b)) {
                f13227b = a(context, Process.myPid());
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f13227b)) {
                f13228c = str.equalsIgnoreCase(f13227b);
                f13229d = true;
            }
        } catch (Throwable th) {
            ALog.e("AdapterUtilityImpl", "isMainProcess", th, new Object[0]);
        }
        return f13228c;
    }

    public static String b(Context context) {
        return UTDevice.getUtdid(context);
    }

    public static String c(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return String.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } catch (Throwable th) {
                ALog.e("AdapterUtilityImpl", "Android above 7.0 isNotificationEnabled", th, new Object[0]);
                return "unknown";
            }
        } else {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i10 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class cls2 = Integer.TYPE;
                boolean z10 = true;
                if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i10), packageName})).intValue() != 0) {
                    z10 = false;
                }
                return String.valueOf(z10);
            } catch (Throwable th2) {
                ALog.e("AdapterUtilityImpl", "isNotificationEnabled", th2, new Object[0]);
                return "unknown";
            }
        }
    }

    public static String a(Context context, int i10) {
        IProcessName iProcessName = a.f12917e;
        if (iProcessName != null) {
            return iProcessName.getCurrProcessName();
        }
        String str = "";
        for (ActivityManager.RunningAppProcessInfo next : a.a(context).a().getRunningAppProcesses()) {
            try {
                if (next.pid == i10) {
                    str = next.processName;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static long a() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1;
            }
            return dataDirectory.getUsableSpace();
        } catch (Throwable th) {
            ALog.e("AdapterUtilityImpl", "getUsableSpace", th, new Object[0]);
            return -1;
        }
    }

    public static String a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append("\n");
                }
            }
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    public static boolean a(String str, int i10) {
        if (str == null) {
            return false;
        }
        try {
            StatFs statFs = new StatFs(str);
            int blockSize = statFs.getBlockSize();
            long availableBlocks = (long) statFs.getAvailableBlocks();
            StringBuilder sb = new StringBuilder();
            sb.append("st.getAvailableBlocks()=");
            sb.append(statFs.getAvailableBlocks());
            sb.append(",st.getAvailableBlocks() * blockSize=");
            long j10 = (long) blockSize;
            sb.append(((long) statFs.getAvailableBlocks()) * j10);
            ALog.d("FileCheckUtils", sb.toString(), new Object[0]);
            if (statFs.getAvailableBlocks() <= 10 || availableBlocks * j10 <= ((long) i10)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
