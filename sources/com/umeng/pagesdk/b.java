package com.umeng.pagesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f16141a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Context f16142b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0211b f16143c;

    /* renamed from: d  reason: collision with root package name */
    private BroadcastReceiver f16144d;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f16146a = new b((byte) 0);
    }

    /* renamed from: com.umeng.pagesdk.b$b  reason: collision with other inner class name */
    public interface C0211b {
        void a(a aVar);
    }

    private b() {
        this.f16144d = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
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
                        a aVar = new a();
                        aVar.f16135a = intExtra;
                        aVar.f16136b = intExtra2;
                        aVar.f16138d = i11;
                        aVar.f16137c = intExtra3;
                        aVar.f16139e = i10;
                        aVar.f16140f = System.currentTimeMillis();
                        if (b.this.f16143c != null) {
                            b.this.f16143c.a(aVar);
                        }
                        b.this.b();
                    }
                } catch (Throwable unused) {
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public synchronized void b() {
        try {
            f16142b.unregisterReceiver(this.f16144d);
            f16141a = false;
        } catch (Throwable unused) {
        }
    }

    public final synchronized a a() {
        a aVar;
        a aVar2 = null;
        try {
            Intent registerReceiver = f16142b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i10 = 0;
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
            int intExtra2 = registerReceiver.getIntExtra("voltage", 0);
            int intExtra3 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra4 = registerReceiver.getIntExtra(Constant.KEY_STATUS, 0);
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
            int intExtra5 = registerReceiver.getIntExtra("plugged", 0);
            if (intExtra5 == 1) {
                i10 = 1;
            } else if (intExtra5 == 2) {
                i10 = 2;
            }
            aVar = new a();
            try {
                aVar.f16135a = intExtra;
                aVar.f16136b = intExtra2;
                aVar.f16138d = i11;
                aVar.f16137c = intExtra3;
                aVar.f16139e = i10;
                aVar.f16140f = System.currentTimeMillis();
            } catch (Throwable unused) {
                aVar2 = aVar;
            }
        } catch (Throwable unused2) {
            aVar = aVar2;
            return aVar;
        }
        return aVar;
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b a(Context context) {
        if (f16142b == null && context != null) {
            f16142b = context.getApplicationContext();
        }
        return a.f16146a;
    }

    public final synchronized void a(C0211b bVar) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f16142b.registerReceiver(this.f16144d, intentFilter);
            f16141a = true;
            this.f16143c = bVar;
        } catch (Throwable unused) {
        }
    }
}
