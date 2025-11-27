package com.umeng.message.proguard;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import com.umeng.message.common.UPLog;
import e1.v;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class r extends Service {
    private static final String TAG = "BaseService";
    private static final Object mRealTimeModeLock = new Object();
    static final HashMap<ComponentName, h> sClassWorkEnqueuer = new HashMap<>();
    private static final int sJobIndex = 21000;
    private static final HashMap<Class<?>, Integer> sJobMap = new HashMap<>();
    static final Object sLock = new Object();
    final ArrayList<d> mCompatQueue;
    h mCompatWorkEnqueuer;
    a mCurProcessor;
    boolean mDestroyed = false;
    boolean mInterruptIfStopped = false;
    b mJobImpl;
    boolean mStopped = false;

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private r f16021a;

        public a(r rVar) {
            this.f16021a = rVar;
        }

        public final void run() {
            while (true) {
                try {
                    e dequeueWork = this.f16021a.dequeueWork();
                    if (dequeueWork != null) {
                        UPLog.i(r.TAG, this.f16021a.getClass().getSimpleName(), "onHandleWork");
                        this.f16021a.onHandleWork(dequeueWork.a());
                        dequeueWork.b();
                    }
                } catch (Throwable th) {
                    UPLog.e(r.TAG, th);
                }
                try {
                    break;
                } catch (Throwable th2) {
                    UPLog.e(r.TAG, th2);
                }
            }
            this.f16021a.processorFinished();
            this.f16021a = null;
        }
    }

    public interface b {
        IBinder a();

        e b();
    }

    public final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final Intent f16027a;

        /* renamed from: b  reason: collision with root package name */
        final int f16028b;

        public d(Intent intent, int i10) {
            this.f16027a = intent;
            this.f16028b = i10;
        }

        public final Intent a() {
            return this.f16027a;
        }

        public final void b() {
            try {
                r.this.stopSelf(this.f16028b);
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }
    }

    public interface e {
        Intent a();

        void b();
    }

    public static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        final r f16030a;

        /* renamed from: b  reason: collision with root package name */
        final Object f16031b = new Object();

        /* renamed from: c  reason: collision with root package name */
        JobParameters f16032c;

        public final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f16033a;

            public a(JobWorkItem jobWorkItem) {
                this.f16033a = jobWorkItem;
            }

            public final Intent a() {
                return this.f16033a.getIntent();
            }

            public final void b() {
                try {
                    synchronized (f.this.f16031b) {
                        JobParameters jobParameters = f.this.f16032c;
                        if (jobParameters != null) {
                            try {
                                jobParameters.completeWork(this.f16033a);
                            } catch (Throwable th) {
                                UPLog.e(r.TAG, th);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    UPLog.e(r.TAG, th2);
                }
            }
        }

        public f(r rVar) {
            super(rVar);
            this.f16030a = rVar;
        }

        public final IBinder a() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x000f, code lost:
            if (r2 == null) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            com.umeng.message.proguard.k0.a(r2).setExtrasClassLoader(r4.f16030a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            return new com.umeng.message.proguard.r.f.a(r4, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.umeng.message.proguard.r.e b() {
            /*
                r4 = this;
                r0 = 0
                java.lang.Object r1 = r4.f16031b     // Catch:{ all -> 0x0028 }
                monitor-enter(r1)     // Catch:{ all -> 0x0028 }
                android.app.job.JobParameters r2 = r4.f16032c     // Catch:{ all -> 0x0025 }
                if (r2 != 0) goto L_0x000a
                monitor-exit(r1)     // Catch:{ all -> 0x0025 }
                return r0
            L_0x000a:
                android.app.job.JobWorkItem r2 = r2.dequeueWork()     // Catch:{ all -> 0x0025 }
                monitor-exit(r1)     // Catch:{ all -> 0x0025 }
                if (r2 == 0) goto L_0x0024
                android.content.Intent r1 = r2.getIntent()     // Catch:{ all -> 0x0028 }
                com.umeng.message.proguard.r r3 = r4.f16030a     // Catch:{ all -> 0x0028 }
                java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ all -> 0x0028 }
                r1.setExtrasClassLoader(r3)     // Catch:{ all -> 0x0028 }
                com.umeng.message.proguard.r$f$a r1 = new com.umeng.message.proguard.r$f$a     // Catch:{ all -> 0x0028 }
                r1.<init>(r2)     // Catch:{ all -> 0x0028 }
                return r1
            L_0x0024:
                return r0
            L_0x0025:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0025 }
                throw r2     // Catch:{ all -> 0x0028 }
            L_0x0028:
                r1 = move-exception
                java.lang.String r2 = "BaseService"
                com.umeng.message.common.UPLog.e((java.lang.String) r2, (java.lang.Throwable) r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.r.f.b():com.umeng.message.proguard.r$e");
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            this.f16032c = jobParameters;
            this.f16030a.ensureProcessorRunningLocked(false);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            boolean doStopCurrentWork = this.f16030a.doStopCurrentWork();
            synchronized (this.f16031b) {
                this.f16032c = null;
            }
            return doStopCurrentWork;
        }
    }

    public static final class g extends h {

        /* renamed from: a  reason: collision with root package name */
        private final JobInfo f16035a;

        /* renamed from: b  reason: collision with root package name */
        private JobScheduler f16036b;

        public g(Context context, ComponentName componentName, int i10) {
            super(componentName);
            a(i10);
            this.f16035a = new JobInfo.Builder(i10, this.f16037c).setOverrideDeadline(0).build();
            try {
                this.f16036b = v.a(context.getApplicationContext().getSystemService("jobscheduler"));
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }

        public final void a(Intent intent) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    int unused = this.f16036b.enqueue(this.f16035a, new JobWorkItem(intent));
                }
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }
    }

    public static abstract class h {

        /* renamed from: c  reason: collision with root package name */
        final ComponentName f16037c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16038d;

        /* renamed from: e  reason: collision with root package name */
        int f16039e;

        public h(ComponentName componentName) {
            this.f16037c = componentName;
        }

        public void a() {
        }

        public abstract void a(Intent intent);

        public void b() {
        }

        public void c() {
        }

        public final void a(int i10) {
            if (!this.f16038d) {
                this.f16038d = true;
                this.f16039e = i10;
            } else if (this.f16039e != i10) {
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f16039e);
            }
        }
    }

    public r() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new ArrayList<>();
        }
    }

    private static void enqueueWork(Context context, Class<?> cls, int i10, Intent intent) {
        if (context != null && cls != null && intent != null) {
            try {
                enqueueWork(context, new ComponentName(context, cls), i10, intent);
            } catch (Throwable th) {
                UPLog.e(TAG, "jobId:", Integer.valueOf(i10), "failed:", th.getMessage());
            }
        }
    }

    public static h getWorkEnqueuer(Context context, ComponentName componentName, boolean z10, int i10) {
        h hVar;
        HashMap<ComponentName, h> hashMap = sClassWorkEnqueuer;
        h hVar2 = hashMap.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new c(context, componentName);
        } else if (z10) {
            hVar = new g(context, componentName, i10);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        h hVar3 = hVar;
        hashMap.put(componentName, hVar3);
        return hVar3;
    }

    private void init() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJobImpl = new f(this);
                this.mCompatWorkEnqueuer = null;
                return;
            }
            this.mJobImpl = null;
            this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public e dequeueWork() {
        b bVar = this.mJobImpl;
        if (bVar != null) {
            return bVar.b();
        }
        ArrayList<d> arrayList = this.mCompatQueue;
        d dVar = null;
        if (arrayList == null) {
            return null;
        }
        synchronized (arrayList) {
            if (this.mCompatQueue.size() > 0) {
                dVar = this.mCompatQueue.remove(0);
            }
        }
        return dVar;
    }

    public boolean doStopCurrentWork() {
        this.mStopped = true;
        return onStopCurrentWork();
    }

    public void ensureProcessorRunningLocked(boolean z10) {
        try {
            if (this.mCurProcessor == null) {
                this.mCurProcessor = new a(this);
                h hVar = this.mCompatWorkEnqueuer;
                if (hVar != null && z10) {
                    hVar.b();
                }
                b.a(this.mCurProcessor);
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    public IBinder onBind(Intent intent) {
        try {
            b bVar = this.mJobImpl;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        } catch (Throwable th) {
            UPLog.e(TAG, th);
            return null;
        }
    }

    public void onCreate() {
        super.onCreate();
        init();
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            ArrayList<d> arrayList = this.mCompatQueue;
            if (arrayList != null) {
                synchronized (arrayList) {
                    this.mDestroyed = true;
                    this.mCompatWorkEnqueuer.c();
                }
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public void onHandleWork(Intent intent) {
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent != null) {
            try {
                if (this.mCompatQueue == null) {
                    return 2;
                }
                if (this.mCompatWorkEnqueuer == null) {
                    init();
                }
                this.mCompatWorkEnqueuer.a();
                synchronized (this.mCompatQueue) {
                    this.mCompatQueue.add(new d(intent, i11));
                    ensureProcessorRunningLocked(true);
                }
                return 3;
            } catch (Throwable th) {
                UPLog.e(TAG, th);
            }
        }
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void processorFinished() {
        try {
            ArrayList<d> arrayList = this.mCompatQueue;
            if (arrayList != null) {
                synchronized (arrayList) {
                    this.mCurProcessor = null;
                    if (this.mCompatQueue.size() > 0) {
                        ensureProcessorRunningLocked(false);
                    } else if (!this.mDestroyed) {
                        this.mCompatWorkEnqueuer.c();
                    }
                }
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public void setInterruptIfStopped(boolean z10) {
        this.mInterruptIfStopped = z10;
    }

    private static void enqueueWork(final Context context, final ComponentName componentName, final int i10, final Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        } else if (context != null && componentName != null) {
            b.c(new Runnable() {
                public final void run() {
                    synchronized (r.sLock) {
                        h workEnqueuer = r.getWorkEnqueuer(context, componentName, true, i10);
                        workEnqueuer.a(i10);
                        workEnqueuer.a(intent);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends com.umeng.message.proguard.r> void enqueueWork(android.content.Context r7, java.lang.Class<T> r8, android.content.Intent r9) {
        /*
            java.lang.Object r0 = mRealTimeModeLock
            monitor-enter(r0)
            if (r7 == 0) goto L_0x0058
            if (r8 == 0) goto L_0x0058
            if (r9 != 0) goto L_0x000a
            goto L_0x0058
        L_0x000a:
            java.lang.String r1 = "BaseService"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "enqueue cls:"
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r8.getSimpleName()     // Catch:{ all -> 0x005a }
            r6 = 1
            r3[r6] = r4     // Catch:{ all -> 0x005a }
            com.umeng.message.common.UPLog.i(r1, r3)     // Catch:{ all -> 0x005a }
            java.util.HashMap<java.lang.Class<?>, java.lang.Integer> r1 = sJobMap     // Catch:{ all -> 0x005a }
            boolean r3 = r1.containsKey(r8)     // Catch:{ all -> 0x005a }
            if (r3 != 0) goto L_0x0034
            int r3 = r1.size()     // Catch:{ all -> 0x005a }
            int r3 = r3 + 21000
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x005a }
            r1.put(r8, r4)     // Catch:{ all -> 0x005a }
            goto L_0x0040
        L_0x0034:
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x005a }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x0056
            int r3 = r1.intValue()     // Catch:{ all -> 0x005a }
        L_0x0040:
            java.lang.String r1 = "BaseService"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "jobId:"
            r2[r5] = r4     // Catch:{ all -> 0x005a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x005a }
            r2[r6] = r4     // Catch:{ all -> 0x005a }
            com.umeng.message.common.UPLog.i(r1, r2)     // Catch:{ all -> 0x005a }
            enqueueWork((android.content.Context) r7, (java.lang.Class<?>) r8, (int) r3, (android.content.Intent) r9)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x0056:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x005a:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.r.enqueueWork(android.content.Context, java.lang.Class, android.content.Intent):void");
    }

    public static final class c extends h {

        /* renamed from: a  reason: collision with root package name */
        boolean f16022a;

        /* renamed from: b  reason: collision with root package name */
        boolean f16023b;

        /* renamed from: f  reason: collision with root package name */
        private final Context f16024f;

        /* renamed from: g  reason: collision with root package name */
        private final PowerManager.WakeLock f16025g;

        /* renamed from: h  reason: collision with root package name */
        private final PowerManager.WakeLock f16026h;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            this.f16024f = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f16025g = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f16026h = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        public final void a(Intent intent) {
            try {
                Intent intent2 = new Intent(intent);
                intent2.setComponent(this.f16037c);
                if (this.f16024f.startService(intent2) != null) {
                    synchronized (this) {
                        if (!this.f16022a) {
                            this.f16022a = true;
                            if (!this.f16023b) {
                                this.f16025g.acquire(60000);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }

        public final void b() {
            try {
                synchronized (this) {
                    if (!this.f16023b) {
                        this.f16023b = true;
                        this.f16026h.acquire(600000);
                        this.f16025g.release();
                    }
                }
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }

        public final void c() {
            try {
                synchronized (this) {
                    if (this.f16023b) {
                        if (this.f16022a) {
                            this.f16025g.acquire(60000);
                        }
                        this.f16023b = false;
                        this.f16026h.release();
                    }
                }
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }

        public final void a() {
            synchronized (this) {
                this.f16022a = false;
            }
        }
    }
}
