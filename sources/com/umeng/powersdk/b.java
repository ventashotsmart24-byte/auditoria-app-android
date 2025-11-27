package com.umeng.powersdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f16181a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f16182a = new b((byte) 0);
    }

    private b() {
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public final synchronized a a() {
        a aVar;
        a aVar2 = null;
        try {
            Intent registerReceiver = f16181a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i10 = 0;
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
            int intExtra2 = registerReceiver.getIntExtra("voltage", 0);
            int intExtra3 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra4 = registerReceiver.getIntExtra(Constant.KEY_STATUS, 0);
            int i11 = -1;
            if (intExtra4 != 1) {
                if (intExtra4 == 2) {
                    i11 = 1;
                } else if (intExtra4 == 3 || intExtra4 == 4) {
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
                aVar.f16175a = intExtra;
                aVar.f16176b = intExtra2;
                aVar.f16178d = i11;
                aVar.f16177c = intExtra3;
                aVar.f16179e = i10;
                aVar.f16180f = System.currentTimeMillis();
            } catch (Throwable unused) {
                aVar2 = aVar;
            }
        } catch (Throwable unused2) {
            aVar = aVar2;
            return aVar;
        }
        return aVar;
    }

    public static b a(Context context) {
        if (f16181a == null && context != null) {
            f16181a = context.getApplicationContext();
        }
        return a.f16182a;
    }
}
