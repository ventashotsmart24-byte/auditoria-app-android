package e1;

import a1.b;
import a1.c;
import a1.k;
import a1.l;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.background.systemjob.SystemJobService;
import j1.p;

public class u {

    /* renamed from: b  reason: collision with root package name */
    public static final String f6464b = k.f("SystemJobInfoConverter");

    /* renamed from: a  reason: collision with root package name */
    public final ComponentName f6465a;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6466a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                a1.l[] r0 = a1.l.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6466a = r0
                a1.l r1 = a1.l.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6466a     // Catch:{ NoSuchFieldError -> 0x001d }
                a1.l r1 = a1.l.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6466a     // Catch:{ NoSuchFieldError -> 0x0028 }
                a1.l r1 = a1.l.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6466a     // Catch:{ NoSuchFieldError -> 0x0033 }
                a1.l r1 = a1.l.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6466a     // Catch:{ NoSuchFieldError -> 0x003e }
                a1.l r1 = a1.l.METERED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e1.u.a.<clinit>():void");
        }
    }

    public u(Context context) {
        this.f6465a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    public static JobInfo.TriggerContentUri b(c.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    public static int c(l lVar) {
        int i10 = a.f6466a[lVar.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 != 4) {
            if (i10 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        k.c().a(f6464b, String.format("API version too low. Cannot convert network type value %s", new Object[]{lVar}), new Throwable[0]);
        return 1;
    }

    public static void d(JobInfo.Builder builder, l lVar) {
        if (Build.VERSION.SDK_INT < 30 || lVar != l.TEMPORARILY_UNMETERED) {
            JobInfo.Builder unused = builder.setRequiredNetworkType(c(lVar));
        } else {
            JobInfo.Builder unused2 = builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    public JobInfo a(p pVar, int i10) {
        int i11;
        b bVar = pVar.f7098j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", pVar.f7089a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", pVar.d());
        JobInfo.Builder a10 = new JobInfo.Builder(i10, this.f6465a).setRequiresCharging(bVar.g()).setRequiresDeviceIdle(bVar.h()).setExtras(persistableBundle);
        d(a10, bVar.b());
        boolean z10 = false;
        if (!bVar.h()) {
            if (pVar.f7100l == a1.a.LINEAR) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            JobInfo.Builder unused = a10.setBackoffCriteria(pVar.f7101m, i11);
        }
        long max = Math.max(pVar.a() - System.currentTimeMillis(), 0);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 <= 28) {
            JobInfo.Builder unused2 = a10.setMinimumLatency(max);
        } else if (max > 0) {
            JobInfo.Builder unused3 = a10.setMinimumLatency(max);
        } else if (!pVar.f7105q) {
            JobInfo.Builder unused4 = a10.setImportantWhileForeground(true);
        }
        if (i12 >= 24 && bVar.e()) {
            for (c.a b10 : bVar.a().b()) {
                JobInfo.Builder unused5 = a10.addTriggerContentUri(b(b10));
            }
            JobInfo.Builder unused6 = a10.setTriggerContentUpdateDelay(bVar.c());
            JobInfo.Builder unused7 = a10.setTriggerContentMaxDelay(bVar.d());
        }
        JobInfo.Builder unused8 = a10.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            JobInfo.Builder unused9 = a10.setRequiresBatteryNotLow(bVar.f());
            JobInfo.Builder unused10 = a10.setRequiresStorageNotLow(bVar.i());
        }
        if (pVar.f7099k > 0) {
            z10 = true;
        }
        if (x.a.c() && pVar.f7105q && !z10) {
            JobInfo.Builder unused11 = a10.setExpedited(true);
        }
        return a10.build();
    }
}
