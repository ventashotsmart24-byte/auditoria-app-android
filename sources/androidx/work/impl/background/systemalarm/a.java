package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.d;
import b1.b;
import j1.p;
import java.util.HashMap;
import java.util.Map;

public class a implements b {

    /* renamed from: d  reason: collision with root package name */
    public static final String f3414d = k.f("CommandHandler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f3415a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f3416b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Object f3417c = new Object();

    public a(Context context) {
        this.f3415a = context;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, boolean z10) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z10);
        return intent;
    }

    public static Intent e(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    public static Intent f(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent g(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    public void c(String str, boolean z10) {
        synchronized (this.f3417c) {
            b bVar = (b) this.f3416b.remove(str);
            if (bVar != null) {
                bVar.c(str, z10);
            }
        }
    }

    public final void h(Intent intent, int i10, d dVar) {
        k.c().a(f3414d, String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
        new b(this.f3415a, i10, dVar).a();
    }

    public final void i(Intent intent, int i10, d dVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f3417c) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            k c10 = k.c();
            String str = f3414d;
            c10.a(str, String.format("Handing delay met for %s", new Object[]{string}), new Throwable[0]);
            if (!this.f3416b.containsKey(string)) {
                c cVar = new c(this.f3415a, i10, string, dVar);
                this.f3416b.put(string, cVar);
                cVar.f();
            } else {
                k.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string}), new Throwable[0]);
            }
        }
    }

    public final void j(Intent intent, int i10) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z10 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        k.c().a(f3414d, String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i10)}), new Throwable[0]);
        c(string, z10);
    }

    public final void k(Intent intent, int i10, d dVar) {
        k.c().a(f3414d, String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i10)}), new Throwable[0]);
        dVar.g().r();
    }

    public final void l(Intent intent, int i10, d dVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        k c10 = k.c();
        String str = f3414d;
        c10.a(str, String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
        WorkDatabase n10 = dVar.g().n();
        n10.c();
        try {
            p h10 = n10.B().h(string);
            if (h10 == null) {
                k c11 = k.c();
                c11.h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (h10.f7090b.a()) {
                k c12 = k.c();
                c12.h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                n10.g();
            } else {
                long a10 = h10.a();
                if (!h10.b()) {
                    k.c().a(str, String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(a10)}), new Throwable[0]);
                    d1.a.c(this.f3415a, dVar.g(), string, a10);
                } else {
                    k.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(a10)}), new Throwable[0]);
                    d1.a.c(this.f3415a, dVar.g(), string, a10);
                    dVar.k(new d.b(dVar, a(this.f3415a), i10));
                }
                n10.r();
                n10.g();
            }
        } finally {
            n10.g();
        }
    }

    public final void m(Intent intent, d dVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        k.c().a(f3414d, String.format("Handing stopWork work for %s", new Object[]{string}), new Throwable[0]);
        dVar.g().w(string);
        d1.a.a(this.f3415a, dVar.g(), string);
        dVar.c(string, false);
    }

    public boolean o() {
        boolean z10;
        synchronized (this.f3417c) {
            if (!this.f3416b.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void p(Intent intent, int i10, d dVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i10, dVar);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i10, dVar);
        } else if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            k.c().b(f3414d, String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"}), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i10, dVar);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i10, dVar);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, dVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i10);
        } else {
            k.c().h(f3414d, String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
        }
    }
}
