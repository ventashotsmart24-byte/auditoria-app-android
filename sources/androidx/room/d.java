package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.room.a;
import androidx.room.b;
import androidx.room.c;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3056a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3057b;

    /* renamed from: c  reason: collision with root package name */
    public int f3058c;

    /* renamed from: d  reason: collision with root package name */
    public final c f3059d;

    /* renamed from: e  reason: collision with root package name */
    public final c.C0048c f3060e;

    /* renamed from: f  reason: collision with root package name */
    public b f3061f;

    /* renamed from: g  reason: collision with root package name */
    public final Executor f3062g;

    /* renamed from: h  reason: collision with root package name */
    public final a f3063h = new a();

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f3064i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    public final ServiceConnection f3065j;

    /* renamed from: k  reason: collision with root package name */
    public final Runnable f3066k;

    /* renamed from: l  reason: collision with root package name */
    public final Runnable f3067l;

    /* renamed from: m  reason: collision with root package name */
    public final Runnable f3068m;

    public class a extends a.C0045a {

        /* renamed from: androidx.room.d$a$a  reason: collision with other inner class name */
        public class C0049a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String[] f3070a;

            public C0049a(String[] strArr) {
                this.f3070a = strArr;
            }

            public void run() {
                d.this.f3059d.e(this.f3070a);
            }
        }

        public a() {
        }

        public void a(String[] strArr) {
            d.this.f3062g.execute(new C0049a(strArr));
        }
    }

    public class b implements ServiceConnection {
        public b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f3061f = b.a.i0(iBinder);
            d dVar = d.this;
            dVar.f3062g.execute(dVar.f3066k);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            d dVar = d.this;
            dVar.f3062g.execute(dVar.f3067l);
            d.this.f3061f = null;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                d dVar = d.this;
                b bVar = dVar.f3061f;
                if (bVar != null) {
                    dVar.f3058c = bVar.d(dVar.f3063h, dVar.f3057b);
                    d dVar2 = d.this;
                    dVar2.f3059d.a(dVar2.f3060e);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    /* renamed from: androidx.room.d$d  reason: collision with other inner class name */
    public class C0050d implements Runnable {
        public C0050d() {
        }

        public void run() {
            d dVar = d.this;
            dVar.f3059d.g(dVar.f3060e);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            d dVar = d.this;
            dVar.f3059d.g(dVar.f3060e);
            try {
                d dVar2 = d.this;
                b bVar = dVar2.f3061f;
                if (bVar != null) {
                    bVar.g0(dVar2.f3063h, dVar2.f3058c);
                }
            } catch (RemoteException unused) {
            }
            d dVar3 = d.this;
            dVar3.f3056a.unbindService(dVar3.f3065j);
        }
    }

    public class f extends c.C0048c {
        public f(String[] strArr) {
            super(strArr);
        }

        public boolean a() {
            return true;
        }

        public void b(Set set) {
            if (!d.this.f3064i.get()) {
                try {
                    d dVar = d.this;
                    b bVar = dVar.f3061f;
                    if (bVar != null) {
                        bVar.b(dVar.f3058c, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public d(Context context, String str, c cVar, Executor executor) {
        b bVar = new b();
        this.f3065j = bVar;
        this.f3066k = new c();
        this.f3067l = new C0050d();
        this.f3068m = new e();
        Context applicationContext = context.getApplicationContext();
        this.f3056a = applicationContext;
        this.f3057b = str;
        this.f3059d = cVar;
        this.f3062g = executor;
        this.f3060e = new f((String[]) cVar.f3033a.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), bVar, 1);
    }
}
