package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import b1.j;
import k1.g;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3405a = k.f("ConstrntProxyUpdtRecvr");

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Intent f3406a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f3407b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f3408c;

        public a(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f3406a = intent;
            this.f3407b = context;
            this.f3408c = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.f3406a.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.f3406a.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.f3406a.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.f3406a.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                k.c().a(ConstraintProxyUpdateReceiver.f3405a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[]{Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)}), new Throwable[0]);
                g.a(this.f3407b, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                g.a(this.f3407b, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                g.a(this.f3407b, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                g.a(this.f3407b, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f3408c.finish();
            }
        }
    }

    public static Intent a(Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z10).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z11).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z12).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z13);
        return intent;
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(str)) {
            k.c().a(f3405a, String.format("Ignoring unknown action %s", new Object[]{str}), new Throwable[0]);
            return;
        }
        j.j(context).o().b(new a(intent, context, goAsync()));
    }
}
