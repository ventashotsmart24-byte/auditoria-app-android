package androidx.work.impl.utils;

import a1.k;
import a1.s;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import b1.f;
import b1.h;
import b1.j;
import e1.f0;
import j1.n;
import j1.p;
import j1.q;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k1.d;
import x.a;

public class ForceStopRunnable implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    public static final String f3482d = k.f("ForceStopRunnable");

    /* renamed from: e  reason: collision with root package name */
    public static final long f3483e = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a  reason: collision with root package name */
    public final Context f3484a;

    /* renamed from: b  reason: collision with root package name */
    public final j f3485b;

    /* renamed from: c  reason: collision with root package name */
    public int f3486c = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public static final String f3487a = k.f("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                k.c().g(f3487a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.g(context);
            }
        }
    }

    public ForceStopRunnable(Context context, j jVar) {
        this.f3484a = context.getApplicationContext();
        this.f3485b = jVar;
    }

    public static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    public static PendingIntent d(Context context, int i10) {
        return PendingIntent.getBroadcast(context, -1, c(context), i10);
    }

    public static void g(Context context) {
        int i10;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (a.c()) {
            i10 = 167772160;
        } else {
            i10 = 134217728;
        }
        PendingIntent d10 = d(context, i10);
        long currentTimeMillis = System.currentTimeMillis() + f3483e;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, d10);
        }
    }

    public boolean a() {
        boolean z10;
        boolean z11;
        if (Build.VERSION.SDK_INT >= 23) {
            z10 = f0.h(this.f3484a, this.f3485b);
        } else {
            z10 = false;
        }
        WorkDatabase n10 = this.f3485b.n();
        q B = n10.B();
        n A = n10.A();
        n10.c();
        try {
            List<p> p10 = B.p();
            if (p10 == null || p10.isEmpty()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                for (p pVar : p10) {
                    B.d(s.ENQUEUED, pVar.f7089a);
                    B.l(pVar.f7089a, -1);
                }
            }
            A.b();
            n10.r();
            if (z11 || z10) {
                return true;
            }
            return false;
        } finally {
            n10.g();
        }
    }

    public void b() {
        boolean a10 = a();
        if (h()) {
            k.c().a(f3482d, "Rescheduling Workers.", new Throwable[0]);
            this.f3485b.r();
            this.f3485b.k().c(false);
        } else if (e()) {
            k.c().a(f3482d, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f3485b.r();
        } else if (a10) {
            k.c().a(f3482d, "Found unfinished work, scheduling it.", new Throwable[0]);
            f.b(this.f3485b.h(), this.f3485b.n(), this.f3485b.m());
        }
    }

    public boolean e() {
        int i10;
        try {
            if (a.c()) {
                i10 = 570425344;
            } else {
                i10 = 536870912;
            }
            PendingIntent d10 = d(this.f3484a, i10);
            if (Build.VERSION.SDK_INT >= 30) {
                if (d10 != null) {
                    d10.cancel();
                }
                List a10 = ((ActivityManager) this.f3484a.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
                if (a10 != null && !a10.isEmpty()) {
                    for (int i11 = 0; i11 < a10.size(); i11++) {
                        if (d.a(a10.get(i11)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (d10 == null) {
                g(this.f3484a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e10) {
            k.c().h(f3482d, "Ignoring exception", e10);
            return true;
        }
    }

    public boolean f() {
        androidx.work.a h10 = this.f3485b.h();
        if (TextUtils.isEmpty(h10.c())) {
            k.c().a(f3482d, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean b10 = k1.j.b(this.f3484a, h10);
        k.c().a(f3482d, String.format("Is default app process = %s", new Object[]{Boolean.valueOf(b10)}), new Throwable[0]);
        return b10;
    }

    public boolean h() {
        return this.f3485b.k().a();
    }

    public void i(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException unused) {
        }
    }

    public void run() {
        try {
            if (!f()) {
                this.f3485b.q();
                return;
            }
            while (true) {
                h.e(this.f3484a);
                k.c().a(f3482d, "Performing cleanup operations.", new Throwable[0]);
                b();
                this.f3485b.q();
                return;
            }
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e10) {
            int i10 = this.f3486c + 1;
            this.f3486c = i10;
            if (i10 < 3) {
                k.c().a(f3482d, String.format("Retrying after %s", new Object[]{Long.valueOf(((long) i10) * 300)}), e10);
                i(((long) this.f3486c) * 300);
            } else {
                k.c().b(f3482d, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                this.f3485b.h().d();
                throw illegalStateException;
            }
        } catch (Throwable th) {
            this.f3485b.q();
            throw th;
        }
    }
}
