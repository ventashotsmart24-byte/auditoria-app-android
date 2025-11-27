package androidx.work.impl.background.systemalarm;

import a1.b;
import a1.k;
import a1.l;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import j1.p;
import java.util.Iterator;
import java.util.List;

public abstract class ConstraintProxy extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3404a = k.f("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static void a(Context context, List list) {
        boolean z10;
        Iterator it = list.iterator();
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        while (it.hasNext()) {
            b bVar = ((p) it.next()).f7098j;
            z11 |= bVar.f();
            z12 |= bVar.g();
            z13 |= bVar.i();
            if (bVar.b() != l.NOT_REQUIRED) {
                z10 = true;
            } else {
                z10 = false;
            }
            z14 |= z10;
            if (z11 && z12 && z13 && z14) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.a(context, z11, z12, z13, z14));
    }

    public void onReceive(Context context, Intent intent) {
        k.c().a(f3404a, String.format("onReceive : %s", new Object[]{intent}), new Throwable[0]);
        context.startService(a.a(context));
    }
}
