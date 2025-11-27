package d1;

import a1.k;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import b1.j;
import j1.g;
import j1.h;
import k1.f;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6195a = k.f("Alarms");

    public static void a(Context context, j jVar, String str) {
        h y10 = jVar.n().y();
        g b10 = y10.b(str);
        if (b10 != null) {
            b(context, str, b10.f7069b);
            k.c().a(f6195a, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str}), new Throwable[0]);
            y10.d(str);
        }
    }

    public static void b(Context context, String str, int i10) {
        int i11;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent b10 = androidx.work.impl.background.systemalarm.a.b(context, str);
        if (Build.VERSION.SDK_INT >= 23) {
            i11 = 603979776;
        } else {
            i11 = 536870912;
        }
        PendingIntent service = PendingIntent.getService(context, i10, b10, i11);
        if (service != null && alarmManager != null) {
            k.c().a(f6195a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i10)}), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void c(Context context, j jVar, String str, long j10) {
        WorkDatabase n10 = jVar.n();
        h y10 = n10.y();
        g b10 = y10.b(str);
        if (b10 != null) {
            b(context, str, b10.f7069b);
            d(context, str, b10.f7069b, j10);
            return;
        }
        int b11 = new f(n10).b();
        y10.a(new g(str, b11));
        d(context, str, b11, j10);
    }

    public static void d(Context context, String str, int i10, long j10) {
        int i11;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 23) {
            i11 = 201326592;
        } else {
            i11 = 134217728;
        }
        PendingIntent service = PendingIntent.getService(context, i10, androidx.work.impl.background.systemalarm.a.b(context, str), i11);
        if (alarmManager != null) {
            alarmManager.setExact(0, j10, service);
        }
    }
}
