package b1;

import a1.k;
import android.content.Context;
import android.os.Build;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import d1.b;
import e1.f0;
import j1.p;
import j1.q;
import java.util.Iterator;
import java.util.List;
import k1.g;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4138a = k.f("Schedulers");

    public static e a(Context context, j jVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            f0 f0Var = new f0(context, jVar);
            g.a(context, SystemJobService.class, true);
            k.c().a(f4138a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return f0Var;
        }
        e c10 = c(context);
        if (c10 != null) {
            return c10;
        }
        b bVar = new b(context);
        g.a(context, SystemAlarmService.class, true);
        k.c().a(f4138a, "Created SystemAlarmScheduler", new Throwable[0]);
        return bVar;
    }

    public static void b(a aVar, WorkDatabase workDatabase, List list) {
        if (list != null && list.size() != 0) {
            q B = workDatabase.B();
            workDatabase.c();
            try {
                List<p> n10 = B.n(aVar.h());
                List j10 = B.j(200);
                if (n10 != null && n10.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (p pVar : n10) {
                        B.l(pVar.f7089a, currentTimeMillis);
                    }
                }
                workDatabase.r();
                if (n10 != null && n10.size() > 0) {
                    p[] pVarArr = (p[]) n10.toArray(new p[n10.size()]);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        if (eVar.a()) {
                            eVar.e(pVarArr);
                        }
                    }
                }
                if (j10 != null && j10.size() > 0) {
                    p[] pVarArr2 = (p[]) j10.toArray(new p[j10.size()]);
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        e eVar2 = (e) it2.next();
                        if (!eVar2.a()) {
                            eVar2.e(pVarArr2);
                        }
                    }
                }
            } finally {
                workDatabase.g();
            }
        }
    }

    public static e c(Context context) {
        try {
            e eVar = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            k.c().a(f4138a, String.format("Created %s", new Object[]{"androidx.work.impl.background.gcm.GcmScheduler"}), new Throwable[0]);
            return eVar;
        } catch (Throwable th) {
            k.c().a(f4138a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
