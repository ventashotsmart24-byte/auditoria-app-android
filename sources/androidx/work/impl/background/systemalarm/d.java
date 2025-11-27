package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import b1.j;
import java.util.ArrayList;
import java.util.List;
import k1.n;
import k1.r;

public class d implements b1.b {

    /* renamed from: k  reason: collision with root package name */
    public static final String f3433k = k.f("SystemAlarmDispatcher");

    /* renamed from: a  reason: collision with root package name */
    public final Context f3434a;

    /* renamed from: b  reason: collision with root package name */
    public final m1.a f3435b;

    /* renamed from: c  reason: collision with root package name */
    public final r f3436c;

    /* renamed from: d  reason: collision with root package name */
    public final b1.d f3437d;

    /* renamed from: e  reason: collision with root package name */
    public final j f3438e;

    /* renamed from: f  reason: collision with root package name */
    public final a f3439f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f3440g;

    /* renamed from: h  reason: collision with root package name */
    public final List f3441h;

    /* renamed from: i  reason: collision with root package name */
    public Intent f3442i;

    /* renamed from: j  reason: collision with root package name */
    public c f3443j;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            C0058d dVar;
            d dVar2;
            synchronized (d.this.f3441h) {
                d dVar3 = d.this;
                dVar3.f3442i = (Intent) dVar3.f3441h.get(0);
            }
            Intent intent = d.this.f3442i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = d.this.f3442i.getIntExtra("KEY_START_ID", 0);
                k c10 = k.c();
                String str = d.f3433k;
                c10.a(str, String.format("Processing command %s, %s", new Object[]{d.this.f3442i, Integer.valueOf(intExtra)}), new Throwable[0]);
                PowerManager.WakeLock b10 = n.b(d.this.f3434a, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                try {
                    k.c().a(str, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, b10}), new Throwable[0]);
                    b10.acquire();
                    d dVar4 = d.this;
                    dVar4.f3439f.p(dVar4.f3442i, intExtra, dVar4);
                    k.c().a(str, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, b10}), new Throwable[0]);
                    b10.release();
                    dVar2 = d.this;
                    dVar = new C0058d(dVar2);
                } catch (Throwable th) {
                    k.c().a(d.f3433k, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, b10}), new Throwable[0]);
                    b10.release();
                    d dVar5 = d.this;
                    dVar5.k(new C0058d(dVar5));
                    throw th;
                }
                dVar2.k(dVar);
            }
        }
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final d f3445a;

        /* renamed from: b  reason: collision with root package name */
        public final Intent f3446b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3447c;

        public b(d dVar, Intent intent, int i10) {
            this.f3445a = dVar;
            this.f3446b = intent;
            this.f3447c = i10;
        }

        public void run() {
            this.f3445a.a(this.f3446b, this.f3447c);
        }
    }

    public interface c {
        void b();
    }

    /* renamed from: androidx.work.impl.background.systemalarm.d$d  reason: collision with other inner class name */
    public static class C0058d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final d f3448a;

        public C0058d(d dVar) {
            this.f3448a = dVar;
        }

        public void run() {
            this.f3448a.d();
        }
    }

    public d(Context context) {
        this(context, (b1.d) null, (j) null);
    }

    public boolean a(Intent intent, int i10) {
        k c10 = k.c();
        String str = f3433k;
        boolean z10 = false;
        c10.a(str, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i10)}), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            k.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i10);
            synchronized (this.f3441h) {
                if (!this.f3441h.isEmpty()) {
                    z10 = true;
                }
                this.f3441h.add(intent);
                if (!z10) {
                    l();
                }
            }
            return true;
        }
    }

    public final void b() {
        if (this.f3440g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void c(String str, boolean z10) {
        k(new b(this, a.d(this.f3434a, str, z10), 0));
    }

    public void d() {
        k c10 = k.c();
        String str = f3433k;
        c10.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.f3441h) {
            if (this.f3442i != null) {
                k.c().a(str, String.format("Removing command %s", new Object[]{this.f3442i}), new Throwable[0]);
                if (((Intent) this.f3441h.remove(0)).equals(this.f3442i)) {
                    this.f3442i = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            k1.k c11 = this.f3435b.c();
            if (!this.f3439f.o() && this.f3441h.isEmpty() && !c11.a()) {
                k.c().a(str, "No more commands & intents.", new Throwable[0]);
                c cVar = this.f3443j;
                if (cVar != null) {
                    cVar.b();
                }
            } else if (!this.f3441h.isEmpty()) {
                l();
            }
        }
    }

    public b1.d e() {
        return this.f3437d;
    }

    public m1.a f() {
        return this.f3435b;
    }

    public j g() {
        return this.f3438e;
    }

    public r h() {
        return this.f3436c;
    }

    public final boolean i(String str) {
        b();
        synchronized (this.f3441h) {
            for (Intent action : this.f3441h) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void j() {
        k.c().a(f3433k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f3437d.i(this);
        this.f3436c.a();
        this.f3443j = null;
    }

    public void k(Runnable runnable) {
        this.f3440g.post(runnable);
    }

    public final void l() {
        b();
        PowerManager.WakeLock b10 = n.b(this.f3434a, "ProcessCommand");
        try {
            b10.acquire();
            this.f3438e.o().b(new a());
        } finally {
            b10.release();
        }
    }

    public void m(c cVar) {
        if (this.f3443j != null) {
            k.c().b(f3433k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f3443j = cVar;
        }
    }

    public d(Context context, b1.d dVar, j jVar) {
        Context applicationContext = context.getApplicationContext();
        this.f3434a = applicationContext;
        this.f3439f = new a(applicationContext);
        this.f3436c = new r();
        jVar = jVar == null ? j.j(context) : jVar;
        this.f3438e = jVar;
        dVar = dVar == null ? jVar.l() : dVar;
        this.f3437d = dVar;
        this.f3435b = jVar.o();
        dVar.d(this);
        this.f3441h = new ArrayList();
        this.f3442i = null;
        this.f3440g = new Handler(Looper.getMainLooper());
    }
}
