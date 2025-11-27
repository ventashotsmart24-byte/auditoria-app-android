package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Intent;
import androidx.lifecycle.i;
import androidx.work.impl.background.systemalarm.d;
import k1.n;

public class SystemAlarmService extends i implements d.c {

    /* renamed from: d  reason: collision with root package name */
    public static final String f3411d = k.f("SystemAlarmService");

    /* renamed from: b  reason: collision with root package name */
    public d f3412b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3413c;

    public void b() {
        this.f3413c = true;
        k.c().a(f3411d, "All commands completed in dispatcher", new Throwable[0]);
        n.a();
        stopSelf();
    }

    public final void e() {
        d dVar = new d(this);
        this.f3412b = dVar;
        dVar.m(this);
    }

    public void onCreate() {
        super.onCreate();
        e();
        this.f3413c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f3413c = true;
        this.f3412b.j();
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f3413c) {
            k.c().d(f3411d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f3412b.j();
            e();
            this.f3413c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f3412b.a(intent, i11);
        return 3;
    }
}
