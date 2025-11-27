package com.umeng.message.proguard;

import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;

public final class dx {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f15886a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f15887b;

    /* renamed from: c  reason: collision with root package name */
    private static long f15888c;

    /* renamed from: d  reason: collision with root package name */
    private static final cw f15889d;

    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        f15886a = atomicBoolean;
        f15889d = new cw(atomicBoolean);
    }

    public static boolean a() {
        AtomicBoolean atomicBoolean = f15886a;
        if (!atomicBoolean.get() && SystemClock.elapsedRealtime() - f15888c >= 12000) {
            f15888c = SystemClock.elapsedRealtime();
            c();
        }
        return atomicBoolean.get();
    }

    public static synchronized void b() {
        synchronized (dx.class) {
            if (!f15887b) {
                try {
                    c();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    de.a().registerReceiver(f15889d, intentFilter);
                    f15887b = true;
                } catch (Throwable th) {
                    ce.a("Screen", "screen state error:" + th.getMessage());
                }
            }
        }
    }

    private static void c() {
        try {
            PowerManager powerManager = (PowerManager) de.a().getSystemService("power");
            if (powerManager == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 20) {
                f15886a.set(powerManager.isInteractive());
            } else {
                f15886a.set(powerManager.isScreenOn());
            }
        } catch (Throwable th) {
            ce.a("Screen", "screen on state error:", th.getMessage());
        }
    }
}
