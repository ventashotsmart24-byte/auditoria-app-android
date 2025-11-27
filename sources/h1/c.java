package h1;

import a1.k;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public abstract class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final String f6857h = k.f("BrdcstRcvrCnstrntTrckr");

    /* renamed from: g  reason: collision with root package name */
    public final BroadcastReceiver f6858g = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.h(context, intent);
            }
        }
    }

    public c(Context context, m1.a aVar) {
        super(context, aVar);
    }

    public void e() {
        k.c().a(f6857h, String.format("%s: registering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.f6862b.registerReceiver(this.f6858g, g());
    }

    public void f() {
        k.c().a(f6857h, String.format("%s: unregistering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.f6862b.unregisterReceiver(this.f6858g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, Intent intent);
}
