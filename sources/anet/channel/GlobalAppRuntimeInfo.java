package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.fulltrace.a;
import anet.channel.fulltrace.b;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import java.util.concurrent.CopyOnWriteArrayList;

public class GlobalAppRuntimeInfo {

    /* renamed from: a  reason: collision with root package name */
    private static Context f3536a;

    /* renamed from: b  reason: collision with root package name */
    private static ENV f3537b = ENV.ONLINE;

    /* renamed from: c  reason: collision with root package name */
    private static String f3538c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f3539d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f3540e;

    /* renamed from: f  reason: collision with root package name */
    private static String f3541f;

    /* renamed from: g  reason: collision with root package name */
    private static String f3542g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f3543h = true;

    /* renamed from: i  reason: collision with root package name */
    private static SharedPreferences f3544i = null;

    /* renamed from: j  reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f3545j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile long f3546k;

    /* renamed from: l  reason: collision with root package name */
    private static String f3547l;

    public static void addBucketInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.length() <= 32 && str2.length() <= 32) {
            synchronized (GlobalAppRuntimeInfo.class) {
                if (f3545j == null) {
                    f3545j = new CopyOnWriteArrayList<>();
                }
                f3545j.add(str);
                f3545j.add(str2);
            }
        }
    }

    public static CopyOnWriteArrayList<String> getBucketInfo() {
        return f3545j;
    }

    public static Context getContext() {
        return f3536a;
    }

    public static String getCurrentProcess() {
        return f3539d;
    }

    public static ENV getEnv() {
        return f3537b;
    }

    @Deprecated
    public static long getInitTime() {
        return f3546k;
    }

    @Deprecated
    public static int getStartType() {
        b sceneInfo = a.a().getSceneInfo();
        if (sceneInfo != null) {
            return sceneInfo.f3718a;
        }
        return -1;
    }

    public static String getTtid() {
        return f3540e;
    }

    public static String getUserId() {
        return f3541f;
    }

    public static String getUtdid() {
        Context context;
        if (f3542g == null && (context = f3536a) != null) {
            f3542g = Utils.getDeviceId(context);
        }
        return f3542g;
    }

    public static boolean isAppBackground() {
        if (f3536a == null) {
            return true;
        }
        return f3543h;
    }

    public static boolean isTargetProcess() {
        if (TextUtils.isEmpty(f3538c) || TextUtils.isEmpty(f3539d)) {
            return true;
        }
        return f3538c.equalsIgnoreCase(f3539d);
    }

    public static void setBackground(boolean z10) {
        f3543h = z10;
    }

    public static void setContext(Context context) {
        f3536a = context;
        if (context != null) {
            if (TextUtils.isEmpty(f3539d)) {
                f3539d = Utils.getProcessName(context, Process.myPid());
            }
            if (TextUtils.isEmpty(f3538c)) {
                f3538c = Utils.getMainProcessName(context);
            }
            if (f3544i == null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                f3544i = defaultSharedPreferences;
                f3541f = defaultSharedPreferences.getString("UserId", (String) null);
            }
            ALog.e("awcn.GlobalAppRuntimeInfo", "", (String) null, "CurrentProcess", f3539d, "TargetProcess", f3538c);
        }
    }

    public static void setCurrentProcess(String str) {
        f3539d = str;
    }

    public static void setEnv(ENV env) {
        f3537b = env;
    }

    @Deprecated
    public static void setInitTime(long j10) {
        f3546k = j10;
    }

    public static void setTargetProcess(String str) {
        f3538c = str;
    }

    public static void setTtid(String str) {
        String str2;
        f3540e = str;
        try {
            if (!TextUtils.isEmpty(str)) {
                int indexOf = str.indexOf("@");
                String str3 = null;
                if (indexOf != -1) {
                    str2 = str.substring(0, indexOf);
                } else {
                    str2 = null;
                }
                String substring = str.substring(indexOf + 1);
                int lastIndexOf = substring.lastIndexOf("_");
                if (lastIndexOf != -1) {
                    String substring2 = substring.substring(0, lastIndexOf);
                    str3 = substring.substring(lastIndexOf + 1);
                    substring = substring2;
                }
                f3547l = str3;
                AmdcRuntimeInfo.setAppInfo(substring, str3, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void setUserId(String str) {
        String str2 = f3541f;
        if (str2 == null || !str2.equals(str)) {
            f3541f = str;
            StrategyCenter.getInstance().forceRefreshStrategy(DispatchConstants.getAmdcServerDomain());
            SharedPreferences sharedPreferences = f3544i;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("UserId", str).apply();
            }
        }
    }

    public static void setUtdid(String str) {
        String str2 = f3542g;
        if (str2 == null || !str2.equals(str)) {
            f3542g = str;
        }
    }

    public static boolean isTargetProcess(String str) {
        if (TextUtils.isEmpty(f3538c) || TextUtils.isEmpty(str)) {
            return true;
        }
        return f3538c.equalsIgnoreCase(str);
    }
}
