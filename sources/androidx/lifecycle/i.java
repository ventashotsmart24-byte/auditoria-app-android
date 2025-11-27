package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public abstract class i extends Service implements g {

    /* renamed from: a  reason: collision with root package name */
    public final u f2316a = new u(this);

    public d getLifecycle() {
        return this.f2316a.a();
    }

    public IBinder onBind(Intent intent) {
        this.f2316a.b();
        return null;
    }

    public void onCreate() {
        this.f2316a.c();
        super.onCreate();
    }

    public void onDestroy() {
        this.f2316a.d();
        super.onDestroy();
    }

    public void onStart(Intent intent, int i10) {
        this.f2316a.e();
        super.onStart(intent, i10);
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }
}
