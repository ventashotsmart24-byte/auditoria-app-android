package h1;

import a1.k;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

public class j extends d {

    /* renamed from: j  reason: collision with root package name */
    public static final String f6868j = k.f("NetworkStateTracker");

    /* renamed from: g  reason: collision with root package name */
    public final ConnectivityManager f6869g = ((ConnectivityManager) this.f6862b.getSystemService("connectivity"));

    /* renamed from: h  reason: collision with root package name */
    public b f6870h;

    /* renamed from: i  reason: collision with root package name */
    public a f6871i;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                k.c().a(j.f6868j, "Network broadcast received", new Throwable[0]);
                j jVar = j.this;
                jVar.d(jVar.g());
            }
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            k.c().a(j.f6868j, String.format("Network capabilities changed: %s", new Object[]{networkCapabilities}), new Throwable[0]);
            j jVar = j.this;
            jVar.d(jVar.g());
        }

        public void onLost(Network network) {
            k.c().a(j.f6868j, "Network connection lost", new Throwable[0]);
            j jVar = j.this;
            jVar.d(jVar.g());
        }
    }

    public j(Context context, m1.a aVar) {
        super(context, aVar);
        if (j()) {
            this.f6870h = new b();
        } else {
            this.f6871i = new a();
        }
    }

    public static boolean j() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public void e() {
        if (j()) {
            try {
                k.c().a(f6868j, "Registering network callback", new Throwable[0]);
                this.f6869g.registerDefaultNetworkCallback(this.f6870h);
            } catch (IllegalArgumentException | SecurityException e10) {
                k.c().b(f6868j, "Received exception while registering network callback", e10);
            }
        } else {
            k.c().a(f6868j, "Registering broadcast receiver", new Throwable[0]);
            this.f6862b.registerReceiver(this.f6871i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public void f() {
        if (j()) {
            try {
                k.c().a(f6868j, "Unregistering network callback", new Throwable[0]);
                this.f6869g.unregisterNetworkCallback(this.f6870h);
            } catch (IllegalArgumentException | SecurityException e10) {
                k.c().b(f6868j, "Received exception while unregistering network callback", e10);
            }
        } else {
            k.c().a(f6868j, "Unregistering broadcast receiver", new Throwable[0]);
            this.f6862b.unregisterReceiver(this.f6871i);
        }
    }

    public f1.b g() {
        boolean z10;
        NetworkInfo activeNetworkInfo = this.f6869g.getActiveNetworkInfo();
        boolean z11 = true;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean i10 = i();
        boolean a10 = w.a.a(this.f6869g);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            z11 = false;
        }
        return new f1.b(z10, i10, a10, z11);
    }

    /* renamed from: h */
    public f1.b b() {
        return g();
    }

    public boolean i() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities a10 = this.f6869g.getNetworkCapabilities(this.f6869g.getActiveNetwork());
            if (a10 == null || !a10.hasCapability(16)) {
                return false;
            }
            return true;
        } catch (SecurityException e10) {
            k.c().b(f6868j, "Unable to validate active network", e10);
            return false;
        }
    }
}
