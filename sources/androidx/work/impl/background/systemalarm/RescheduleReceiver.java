package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import b1.j;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3410a = k.f("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        k.c().a(f3410a, String.format("Received intent %s", new Object[]{intent}), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                j.j(context).s(goAsync());
            } catch (IllegalStateException e10) {
                k.c().b(f3410a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e10);
            }
        } else {
            context.startService(a.e(context));
        }
    }
}
