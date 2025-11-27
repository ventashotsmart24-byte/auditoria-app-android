package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14808a = "BatteryUtils";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f14809b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Context f14810c;

    /* renamed from: d  reason: collision with root package name */
    private BroadcastReceiver f14811d;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f14813a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (f14810c == null && context != null) {
            f14810c = context.getApplicationContext();
        }
        return a.f14813a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f14810c.registerReceiver(this.f14811d, intentFilter);
            f14809b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f14810c, th);
        }
        return;
    }

    public synchronized void c() {
        try {
            f14810c.unregisterReceiver(this.f14811d);
            f14809b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f14810c, th);
        }
        return;
    }

    private c() {
        this.f14811d = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i10 = 0;
                        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra(Constant.KEY_STATUS, 0);
                        int i11 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i11 = 1;
                            } else if (intExtra4 == 4) {
                                i11 = 0;
                            } else if (intExtra4 == 5) {
                                i11 = 2;
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i10 = 1;
                        } else if (intExtra5 == 2) {
                            i10 = 2;
                        }
                        b bVar = new b();
                        bVar.f14802a = intExtra;
                        bVar.f14803b = intExtra2;
                        bVar.f14805d = i11;
                        bVar.f14804c = intExtra3;
                        bVar.f14806e = i10;
                        bVar.f14807f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f14757h, b.a(c.f14810c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f14810c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f14809b;
    }
}
