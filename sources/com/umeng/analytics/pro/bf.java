package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;

public class bf {

    /* renamed from: a  reason: collision with root package name */
    private static be f13868a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f13869b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f13870c = false;

    public static synchronized String a(Context context) {
        synchronized (bf.class) {
            if (!UMConfigure.shouldCollectOaid()) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAID(): oaid开关已关闭。");
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
            if (context == null) {
                return null;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return null;
            }
            if (f13868a == null) {
                f13868a = bh.a();
            }
            be beVar = f13868a;
            if (beVar != null) {
                try {
                    String a10 = beVar.a(context);
                    if (!TextUtils.isEmpty(a10)) {
                        f13869b = a10;
                    }
                    f13870c = true;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "OpenDeviceId:getOAID() result: " + f13869b);
                    String str = f13869b;
                    return str;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }
    }

    public static String b(Context context) {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAIDFromCache(): oaid开关已关闭。");
            return null;
        } else if (f13870c) {
            return f13869b;
        } else {
            return a(context);
        }
    }

    @Deprecated
    public static synchronized String c(Context context) {
        synchronized (bf.class) {
            if (UMConfigure.shouldCollectOaid()) {
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaid(): oaid开关已关闭。");
            return null;
        }
    }

    @Deprecated
    public static synchronized String d(Context context) {
        synchronized (bf.class) {
            if (UMConfigure.shouldCollectOaid()) {
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaidFromCache(): oaid开关已关闭。");
            return null;
        }
    }
}
