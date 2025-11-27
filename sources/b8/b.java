package b8;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.umeng.analytics.pro.f;
import t9.i;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f11197a;

    /* renamed from: b  reason: collision with root package name */
    public int f11198b;

    /* renamed from: c  reason: collision with root package name */
    public final AudioManager f11199c;

    /* renamed from: d  reason: collision with root package name */
    public final BroadcastReceiver f11200d = new a(this);

    public static final class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f11201a;

        public a(b bVar) {
            this.f11201a = bVar;
        }

        public void onReceive(Context context, Intent intent) {
            i.g(context, f.X);
            i.g(intent, "intent");
            int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 0);
            int intExtra2 = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
            if (intExtra == 3) {
                this.f11201a.f(intExtra2);
            }
        }
    }

    public b(Activity activity) {
        i.g(activity, "mActivity");
        this.f11197a = activity;
        Object systemService = activity.getSystemService("audio");
        i.e(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.f11199c = (AudioManager) systemService;
    }

    public static /* synthetic */ void b(b bVar, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            bVar.a(z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disable");
    }

    public final void a(boolean z10) {
        if (z10) {
            this.f11199c.setStreamVolume(3, this.f11198b, 0);
        }
        this.f11197a.unregisterReceiver(this.f11200d);
    }

    public final void c() {
        int d10 = d();
        this.f11198b = d10;
        f(d10);
        this.f11197a.registerReceiver(this.f11200d, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
    }

    public final int d() {
        return this.f11199c.getStreamVolume(3);
    }

    public final int e() {
        return this.f11199c.getStreamMaxVolume(3);
    }

    public abstract void f(int i10);

    public final void g(int i10) {
        this.f11199c.setStreamVolume(3, i10, 16);
    }
}
