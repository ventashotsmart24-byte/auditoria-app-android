package androidx.work.impl.foreground;

import a1.k;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.i;
import androidx.work.impl.foreground.a;

public class SystemForegroundService extends i implements a.b {

    /* renamed from: f  reason: collision with root package name */
    public static final String f3453f = k.f("SystemFgService");

    /* renamed from: g  reason: collision with root package name */
    public static SystemForegroundService f3454g = null;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3455b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3456c;

    /* renamed from: d  reason: collision with root package name */
    public a f3457d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationManager f3458e;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3459a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Notification f3460b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3461c;

        public a(int i10, Notification notification, int i11) {
            this.f3459a = i10;
            this.f3460b = notification;
            this.f3461c = i11;
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f3459a, this.f3460b, this.f3461c);
            } else {
                SystemForegroundService.this.startForeground(this.f3459a, this.f3460b);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Notification f3464b;

        public b(int i10, Notification notification) {
            this.f3463a = i10;
            this.f3464b = notification;
        }

        public void run() {
            SystemForegroundService.this.f3458e.notify(this.f3463a, this.f3464b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3466a;

        public c(int i10) {
            this.f3466a = i10;
        }

        public void run() {
            SystemForegroundService.this.f3458e.cancel(this.f3466a);
        }
    }

    public void a(int i10, Notification notification) {
        this.f3455b.post(new b(i10, notification));
    }

    public void c(int i10, int i11, Notification notification) {
        this.f3455b.post(new a(i10, notification, i11));
    }

    public void d(int i10) {
        this.f3455b.post(new c(i10));
    }

    public final void e() {
        this.f3455b = new Handler(Looper.getMainLooper());
        this.f3458e = (NotificationManager) getApplicationContext().getSystemService("notification");
        a aVar = new a(getApplicationContext());
        this.f3457d = aVar;
        aVar.m(this);
    }

    public void onCreate() {
        super.onCreate();
        f3454g = this;
        e();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f3457d.k();
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f3456c) {
            k.c().d(f3453f, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f3457d.k();
            e();
            this.f3456c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f3457d.l(intent);
        return 3;
    }

    public void stop() {
        this.f3456c = true;
        k.c().a(f3453f, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f3454g = null;
        stopSelf();
    }
}
