package com.taobao.accs.a;

import android.content.Context;
import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;
import com.taobao.accs.utl.v;

public class a {
    public static final String TAG = "a";

    public static void a(Context context, Intent intent) {
        String str;
        String str2;
        if (context == null || intent == null) {
            ALog.e(TAG, "dispatchIntent context or intent is null", new Object[0]);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            if (intent.getComponent() == null) {
                str = intent.toString();
                str2 = "";
            } else {
                str = intent.getComponent().getClassName();
                str2 = intent.getComponent().getPackageName();
            }
            if (v.a(applicationContext)) {
                ALog.i(TAG, "dispatchIntent bind service start", "intent", intent.toString());
                if (!applicationContext.bindService(intent, new b(intent, applicationContext, context, 0), 1) && context.getPackageName().equals(str2)) {
                    k.a("accs", BaseMonitor.ALARM_POINT_BIND, intent.toString(), UtilityImpl.a(-2), "dispatchIntent bindService return false");
                    return;
                }
                return;
            }
            ALog.i(TAG, "dispatchIntent start service ", new Object[0]);
            applicationContext.startService(intent);
            if (context.getPackageName().equals(str2)) {
                k.a("accs", BaseMonitor.ALARM_POINT_BIND, str);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "dispatchIntent method call with exception ", th, new Object[0]);
            if (context.getPackageName().equals((Object) null)) {
                k.a("accs", BaseMonitor.ALARM_POINT_BIND, intent.toString(), UtilityImpl.a(-1), "dispatchIntent method call with exception");
            }
        }
    }
}
