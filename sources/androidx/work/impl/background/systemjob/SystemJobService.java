package androidx.work.impl.background.systemjob;

import a1.k;
import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import b1.b;
import b1.j;
import e1.g0;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f3449c = k.f("SystemJobService");

    /* renamed from: a  reason: collision with root package name */
    public j f3450a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f3451b = new HashMap();

    public static String a(JobParameters jobParameters) {
        try {
            PersistableBundle a10 = jobParameters.getExtras();
            if (a10 == null || !a10.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return a10.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void c(String str, boolean z10) {
        JobParameters a10;
        k.c().a(f3449c, String.format("%s executed on JobScheduler", new Object[]{str}), new Throwable[0]);
        synchronized (this.f3451b) {
            a10 = g0.a(this.f3451b.remove(str));
        }
        if (a10 != null) {
            jobFinished(a10, z10);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            j j10 = j.j(getApplicationContext());
            this.f3450a = j10;
            j10.l().d(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                k.c().h(f3449c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        j jVar = this.f3450a;
        if (jVar != null) {
            jVar.l().i(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        if (r2 < 24) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r3 = new androidx.work.WorkerParameters.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        if (e1.i0.a(r9) == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        r3.f3355b = java.util.Arrays.asList(e1.i0.a(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        if (e1.j0.a(r9) == null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        r3.f3354a = java.util.Arrays.asList(e1.j0.a(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0099, code lost:
        if (r2 < 28) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        r3.f3356c = e1.k0.a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a3, code lost:
        r8.f3450a.u(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r9) {
        /*
            r8 = this;
            b1.j r0 = r8.f3450a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0017
            a1.k r0 = a1.k.c()
            java.lang.String r3 = f3449c
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r5 = new java.lang.Throwable[r2]
            r0.a(r3, r4, r5)
            r8.jobFinished(r9, r1)
            return r2
        L_0x0017:
            java.lang.String r0 = a(r9)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x002f
            a1.k r9 = a1.k.c()
            java.lang.String r0 = f3449c
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r9.b(r0, r1, r3)
            return r2
        L_0x002f:
            java.util.Map r3 = r8.f3451b
            monitor-enter(r3)
            java.util.Map r4 = r8.f3451b     // Catch:{ all -> 0x00a9 }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x00a9 }
            if (r4 == 0) goto L_0x0051
            a1.k r9 = a1.k.c()     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = f3449c     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a9 }
            r1[r2] = r0     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = java.lang.String.format(r5, r1)     // Catch:{ all -> 0x00a9 }
            java.lang.Throwable[] r1 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00a9 }
            r9.a(r4, r0, r1)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a9 }
            return r2
        L_0x0051:
            a1.k r4 = a1.k.c()     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = f3449c     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = "onStartJob for %s"
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a9 }
            r7[r2] = r0     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x00a9 }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00a9 }
            r4.a(r5, r6, r2)     // Catch:{ all -> 0x00a9 }
            java.util.Map r2 = r8.f3451b     // Catch:{ all -> 0x00a9 }
            r2.put(r0, r9)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a9 }
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x00a2
            androidx.work.WorkerParameters$a r3 = new androidx.work.WorkerParameters$a
            r3.<init>()
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            if (r4 == 0) goto L_0x0087
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.f3355b = r4
        L_0x0087:
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            if (r4 == 0) goto L_0x0097
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.f3354a = r4
        L_0x0097:
            r4 = 28
            if (r2 < r4) goto L_0x00a3
            android.net.Network r9 = r9.getNetwork()
            r3.f3356c = r9
            goto L_0x00a3
        L_0x00a2:
            r3 = 0
        L_0x00a3:
            b1.j r9 = r8.f3450a
            r9.u(r0, r3)
            return r1
        L_0x00a9:
            r9 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00a9 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f3450a == null) {
            k.c().a(f3449c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String a10 = a(jobParameters);
        if (TextUtils.isEmpty(a10)) {
            k.c().b(f3449c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        k.c().a(f3449c, String.format("onStopJob for %s", new Object[]{a10}), new Throwable[0]);
        synchronized (this.f3451b) {
            this.f3451b.remove(a10);
        }
        this.f3450a.w(a10);
        return !this.f3450a.l().f(a10);
    }
}
