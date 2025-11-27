package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.c;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.d;

public class UMInnerImpl {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f14616a = 0;
    private static boolean isInternal = false;

    public static synchronized void initAndSendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                                        if (FieldManager.allow(d.aq) && !c.a(context).a()) {
                                            c.a(context).b();
                                        }
                                        try {
                                            k.b(context);
                                        } catch (Throwable th) {
                                            ULog.e(UMModuleRegister.INNER, "e is " + th);
                                        }
                                    }
                                } catch (Throwable th2) {
                                    UMCrashManager.reportCrash(context, th2);
                                }
                            }
                        }).start();
                        isInternal = true;
                        sendInternal(context);
                    }
                } catch (Throwable th) {
                    ULog.e(UMModuleRegister.INNER, "e is " + th.getMessage());
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
        return;
    }

    private static synchronized void sendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                String packageName = context.getPackageName();
                                if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                                    com.umeng.commonsdk.internal.d.b(context);
                                }
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                        }
                    }).start();
                    isInternal = true;
                } catch (Throwable th) {
                    ULog.e(UMModuleRegister.INNER, "e is " + th.getMessage());
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
        return;
    }
}
