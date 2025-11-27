package com.umeng.powersdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.powersdk.c;
import java.lang.ref.WeakReference;

public class PowerManager {
    public static final String TAG = "PowerManager";

    /* renamed from: a  reason: collision with root package name */
    private static Context f16171a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f16172b = false;

    /* renamed from: c  reason: collision with root package name */
    private static EfsReporter f16173c = null;

    /* renamed from: d  reason: collision with root package name */
    private static PowerConfigManager f16174d = null;
    public static boolean isDebug = true;

    public static Context getApplicationContext() {
        return f16171a;
    }

    public static PowerConfigManager getPowerConfigManager() {
        return f16174d;
    }

    public static EfsReporter getReporter() {
        return f16173c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    Log.e(TAG, "init power manager error! parameter is null!");
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (!isInit()) {
            f16171a = context.getApplicationContext();
            f16173c = efsReporter;
            f16174d = new PowerConfigManager(context, efsReporter);
            f16172b = true;
            c a10 = c.a.f16199a;
            try {
                if (getPowerConfigManager() != null && getPowerConfigManager().enableTracer()) {
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("efs_power", 0);
                    if (sharedPreferences != null) {
                        a10.f16184b = sharedPreferences.getInt("apm_powerperf_collect_interval", 5);
                        a10.f16185c = sharedPreferences.getInt("apm_powerperf_collect_max_period_sec", 100);
                    }
                    HandlerThread handlerThread = new HandlerThread("power-info");
                    handlerThread.start();
                    c.AnonymousClass1 r02 = new Handler(handlerThread.getLooper(), handlerThread) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ HandlerThread f16190a;

                        {
                            this.f16190a = r3;
                        }

                        public final void handleMessage(Message message) {
                            super.handleMessage(message);
                            if (message.what == c.this.f16183a) {
                                try {
                                    this.f16190a.quit();
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    };
                    r02.post(new Runnable(r02) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ Handler f16192a;

                        {
                            this.f16192a = r2;
                        }

                        public final void run() {
                            try {
                                c cVar = c.this;
                                Handler handler = this.f16192a;
                                int i10 = cVar.f16184b;
                                handler.post(new Runnable(SystemClock.elapsedRealtime(), cVar.f16185c, handler, i10) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ long f16194a;

                                    /* renamed from: b  reason: collision with root package name */
                                    final /* synthetic */ int f16195b;

                                    /* renamed from: c  reason: collision with root package name */
                                    final /* synthetic */ Handler f16196c;

                                    /* renamed from: d  reason: collision with root package name */
                                    final /* synthetic */ int f16197d;

                                    {
                                        this.f16194a = r2;
                                        this.f16195b = r4;
                                        this.f16196c = r5;
                                        this.f16197d = r6;
                                    }

                                    public final void run() {
                                        if (c.this.f16187e) {
                                            if (SystemClock.elapsedRealtime() - this.f16194a > ((long) (this.f16195b * 1000))) {
                                                this.f16196c.sendEmptyMessage(c.this.f16183a);
                                                return;
                                            }
                                            try {
                                                EfsJSONLog efsJSONLog = new EfsJSONLog("powerperf");
                                                efsJSONLog.put("power", c.this.a());
                                                EfsReporter reporter = PowerManager.getReporter();
                                                if (reporter != null) {
                                                    reporter.send(efsJSONLog);
                                                }
                                            } catch (Throwable unused) {
                                            }
                                        }
                                        this.f16196c.postDelayed(this, (long) (this.f16197d * 1000));
                                    }
                                });
                            } catch (Throwable unused) {
                                this.f16192a.sendEmptyMessage(c.this.f16183a);
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        } else if (isDebug) {
            Log.e(TAG, "invalid init ！");
        }
    }

    public static boolean isInit() {
        return f16172b;
    }

    public static void onActivityResumed(Activity activity) {
        c a10 = c.a.f16199a;
        try {
            if (getPowerConfigManager() == null) {
                return;
            }
            if (getPowerConfigManager().enableTracer()) {
                a10.f16186d = new WeakReference<>(activity);
            }
        } catch (Throwable unused) {
        }
    }

    public static void onActivityStarted(Activity activity) {
        c a10 = c.a.f16199a;
        try {
            if (getPowerConfigManager() == null) {
                return;
            }
            if (getPowerConfigManager().enableTracer()) {
                if (activity != null) {
                    if (a10.f16189g) {
                        a10.f16189g = false;
                        return;
                    }
                    int i10 = a10.f16188f + 1;
                    a10.f16188f = i10;
                    if (i10 == 1) {
                        a10.f16187e = true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void onActivityStopped(Activity activity) {
        c a10 = c.a.f16199a;
        try {
            if (getPowerConfigManager() == null) {
                return;
            }
            if (getPowerConfigManager().enableTracer()) {
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        a10.f16189g = true;
                        return;
                    }
                    int i10 = a10.f16188f - 1;
                    a10.f16188f = i10;
                    if (i10 == 0) {
                        a10.f16187e = false;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
