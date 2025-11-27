package e1;

import a1.k;
import a1.o;
import a1.s;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import b1.e;
import b1.j;
import j1.g;
import j1.p;
import j1.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import k1.f;

public class f0 implements e {

    /* renamed from: e  reason: collision with root package name */
    public static final String f6459e = k.f("SystemJobScheduler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f6460a;

    /* renamed from: b  reason: collision with root package name */
    public final JobScheduler f6461b;

    /* renamed from: c  reason: collision with root package name */
    public final j f6462c;

    /* renamed from: d  reason: collision with root package name */
    public final u f6463d;

    public f0(Context context, j jVar) {
        this(context, jVar, v.a(context.getSystemService("jobscheduler")), new u(context));
    }

    public static void b(Context context) {
        List<Object> f10;
        JobScheduler a10 = v.a(context.getSystemService("jobscheduler"));
        if (a10 != null && (f10 = f(context, a10)) != null && !f10.isEmpty()) {
            for (Object a11 : f10) {
                c(a10, w.a(a11).getId());
            }
        }
    }

    public static void c(JobScheduler jobScheduler, int i10) {
        try {
            jobScheduler.cancel(i10);
        } catch (Throwable th) {
            k.c().b(f6459e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i10)}), th);
        }
    }

    public static List d(Context context, JobScheduler jobScheduler, String str) {
        List<Object> f10 = f(context, jobScheduler);
        if (f10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (Object a10 : f10) {
            JobInfo a11 = w.a(a10);
            if (str.equals(g(a11))) {
                arrayList.add(Integer.valueOf(a11.getId()));
            }
        }
        return arrayList;
    }

    public static List f(Context context, JobScheduler jobScheduler) {
        List<Object> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            k.c().b(f6459e, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (Object a10 : list) {
            JobInfo a11 = w.a(a10);
            if (componentName.equals(a11.getService())) {
                arrayList.add(a11);
            }
        }
        return arrayList;
    }

    public static String g(JobInfo jobInfo) {
        PersistableBundle a10 = jobInfo.getExtras();
        if (a10 == null) {
            return null;
        }
        try {
            if (a10.containsKey("EXTRA_WORK_SPEC_ID")) {
                return a10.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean h(Context context, j jVar) {
        int i10;
        JobScheduler a10 = v.a(context.getSystemService("jobscheduler"));
        List<Object> f10 = f(context, a10);
        List<String> c10 = jVar.n().y().c();
        boolean z10 = false;
        if (f10 != null) {
            i10 = f10.size();
        } else {
            i10 = 0;
        }
        HashSet hashSet = new HashSet(i10);
        if (f10 != null && !f10.isEmpty()) {
            for (Object a11 : f10) {
                JobInfo a12 = w.a(a11);
                String g10 = g(a12);
                if (!TextUtils.isEmpty(g10)) {
                    hashSet.add(g10);
                } else {
                    c(a10, a12.getId());
                }
            }
        }
        Iterator it = c10.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains((String) it.next())) {
                    k.c().a(f6459e, "Reconciling jobs", new Throwable[0]);
                    z10 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z10) {
            WorkDatabase n10 = jVar.n();
            n10.c();
            try {
                q B = n10.B();
                for (String l10 : c10) {
                    B.l(l10, -1);
                }
                n10.r();
            } finally {
                n10.g();
            }
        }
        return z10;
    }

    public boolean a() {
        return true;
    }

    public void cancel(String str) {
        List<Integer> d10 = d(this.f6460a, this.f6461b, str);
        if (d10 != null && !d10.isEmpty()) {
            for (Integer intValue : d10) {
                c(this.f6461b, intValue.intValue());
            }
            this.f6462c.n().y().d(str);
        }
    }

    /* JADX INFO: finally extract failed */
    public void e(p... pVarArr) {
        int i10;
        List d10;
        int i11;
        WorkDatabase n10 = this.f6462c.n();
        f fVar = new f(n10);
        int length = pVarArr.length;
        int i12 = 0;
        while (i12 < length) {
            p pVar = pVarArr[i12];
            n10.c();
            try {
                p h10 = n10.B().h(pVar.f7089a);
                if (h10 == null) {
                    k c10 = k.c();
                    String str = f6459e;
                    c10.h(str, "Skipping scheduling " + pVar.f7089a + " because it's no longer in the DB", new Throwable[0]);
                    n10.r();
                } else if (h10.f7090b != s.ENQUEUED) {
                    k c11 = k.c();
                    String str2 = f6459e;
                    c11.h(str2, "Skipping scheduling " + pVar.f7089a + " because it is no longer enqueued", new Throwable[0]);
                    n10.r();
                } else {
                    g b10 = n10.y().b(pVar.f7089a);
                    if (b10 != null) {
                        i10 = b10.f7069b;
                    } else {
                        i10 = fVar.d(this.f6462c.h().i(), this.f6462c.h().g());
                    }
                    if (b10 == null) {
                        this.f6462c.n().y().a(new g(pVar.f7089a, i10));
                    }
                    i(pVar, i10);
                    if (Build.VERSION.SDK_INT == 23 && (d10 = d(this.f6460a, this.f6461b, pVar.f7089a)) != null) {
                        int indexOf = d10.indexOf(Integer.valueOf(i10));
                        if (indexOf >= 0) {
                            d10.remove(indexOf);
                        }
                        if (!d10.isEmpty()) {
                            i11 = ((Integer) d10.get(0)).intValue();
                        } else {
                            i11 = fVar.d(this.f6462c.h().i(), this.f6462c.h().g());
                        }
                        i(pVar, i11);
                    }
                    n10.r();
                }
                n10.g();
                i12++;
            } catch (Throwable th) {
                n10.g();
                throw th;
            }
        }
    }

    public void i(p pVar, int i10) {
        int i11;
        JobInfo a10 = this.f6463d.a(pVar, i10);
        k c10 = k.c();
        String str = f6459e;
        c10.a(str, String.format("Scheduling work ID %s Job ID %s", new Object[]{pVar.f7089a, Integer.valueOf(i10)}), new Throwable[0]);
        try {
            if (this.f6461b.schedule(a10) == 0) {
                k.c().h(str, String.format("Unable to schedule work ID %s", new Object[]{pVar.f7089a}), new Throwable[0]);
                if (pVar.f7105q && pVar.f7106r == o.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    pVar.f7105q = false;
                    k.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{pVar.f7089a}), new Throwable[0]);
                    i(pVar, i10);
                }
            }
        } catch (IllegalStateException e10) {
            List f10 = f(this.f6460a, this.f6461b);
            if (f10 != null) {
                i11 = f10.size();
            } else {
                i11 = 0;
            }
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(i11), Integer.valueOf(this.f6462c.n().B().c().size()), Integer.valueOf(this.f6462c.h().h())});
            k.c().b(f6459e, format, new Throwable[0]);
            throw new IllegalStateException(format, e10);
        } catch (Throwable th) {
            k.c().b(f6459e, String.format("Unable to schedule %s", new Object[]{pVar}), th);
        }
    }

    public f0(Context context, j jVar, JobScheduler jobScheduler, u uVar) {
        this.f6460a = context;
        this.f6462c = jVar;
        this.f6461b = jobScheduler;
        this.f6463d = uVar;
    }
}
