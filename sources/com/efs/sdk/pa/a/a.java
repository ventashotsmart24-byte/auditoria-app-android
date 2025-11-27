package com.efs.sdk.pa.a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.efs.sdk.pa.PAANRListener;
import java.util.Map;
import java.util.Set;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f5516a;

    /* renamed from: b  reason: collision with root package name */
    final Handler f5517b;

    /* renamed from: c  reason: collision with root package name */
    final Thread f5518c;

    /* renamed from: d  reason: collision with root package name */
    long f5519d;

    /* renamed from: e  reason: collision with root package name */
    long f5520e;

    /* renamed from: f  reason: collision with root package name */
    boolean f5521f;

    /* renamed from: g  reason: collision with root package name */
    Handler f5522g;

    /* renamed from: h  reason: collision with root package name */
    PAANRListener f5523h;

    /* renamed from: i  reason: collision with root package name */
    long f5524i;

    /* renamed from: j  reason: collision with root package name */
    long f5525j;

    /* renamed from: k  reason: collision with root package name */
    final long f5526k;

    /* renamed from: l  reason: collision with root package name */
    boolean f5527l;

    /* renamed from: m  reason: collision with root package name */
    final Runnable f5528m;

    /* renamed from: n  reason: collision with root package name */
    final Runnable f5529n;

    /* renamed from: o  reason: collision with root package name */
    private HandlerThread f5530o;

    /* renamed from: p  reason: collision with root package name */
    private Application f5531p;

    public a(Application application, long j10) {
        this(application, j10, true);
    }

    public static boolean a(StringBuilder sb) {
        Set<Map.Entry<Thread, StackTraceElement[]>> entrySet = Thread.getAllStackTraces().entrySet();
        if (entrySet.size() == 0) {
            return false;
        }
        boolean z10 = false;
        for (Map.Entry next : entrySet) {
            Thread thread = (Thread) next.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
            if (thread.getId() == Looper.getMainLooper().getThread().getId()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(thread.getName());
                sb2.append(" ");
                sb2.append(thread.getPriority());
                sb2.append(" ");
                sb2.append(thread.getState());
                sb2.append("\n");
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    String stackTraceElement2 = stackTraceElement.toString();
                    sb2.append("  at  ");
                    sb2.append(stackTraceElement2);
                    sb2.append(10);
                }
                sb2.append("\n");
                sb.insert(0, sb2);
                z10 = true;
            } else {
                sb.append(thread.getName());
                sb.append(" ");
                sb.append(thread.getPriority());
                sb.append(" ");
                sb.append(thread.getState());
                sb.append("\n");
                for (StackTraceElement stackTraceElement3 : stackTraceElementArr) {
                    String stackTraceElement4 = stackTraceElement3.toString();
                    sb.append("  at  ");
                    sb.append(stackTraceElement4);
                    sb.append(10);
                }
                sb.append("\n");
            }
        }
        if (!z10) {
            sb.insert(0, a(Looper.getMainLooper().getThread()));
        }
        return true;
    }

    public a(Application application, long j10, boolean z10) {
        this.f5516a = true;
        this.f5520e = 4;
        this.f5521f = true;
        this.f5524i = 0;
        this.f5528m = new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
                if (com.efs.sdk.pa.a.a.a(r1) != false) goto L_0x006e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    com.efs.sdk.pa.a.a r0 = com.efs.sdk.pa.a.a.this
                    boolean r0 = r0.f5521f
                    if (r0 == 0) goto L_0x0007
                    return
                L_0x0007:
                    long r0 = android.os.SystemClock.uptimeMillis()
                    com.efs.sdk.pa.a.a r2 = com.efs.sdk.pa.a.a.this
                    long r3 = r2.f5525j
                    long r0 = r0 - r3
                    long r3 = r2.f5526k
                    int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                    if (r5 <= 0) goto L_0x0021
                    com.efs.sdk.pa.PAANRListener r2 = r2.f5523h
                    if (r2 == 0) goto L_0x0021
                    java.lang.Long r0 = java.lang.Long.valueOf(r0)
                    r2.unexcept(r0)
                L_0x0021:
                    com.efs.sdk.pa.a.a r0 = com.efs.sdk.pa.a.a.this
                    boolean r0 = r0.f5516a
                    if (r0 == 0) goto L_0x003a
                    com.efs.sdk.pa.a.a r0 = com.efs.sdk.pa.a.a.this
                    r1 = 0
                    r0.f5524i = r1
                    r1 = 0
                    r0.f5516a = r1
                    com.efs.sdk.pa.a.a r0 = com.efs.sdk.pa.a.a.this
                    android.os.Handler r1 = r0.f5517b
                    java.lang.Runnable r0 = r0.f5529n
                    r1.postAtFrontOfQueue(r0)
                    goto L_0x0081
                L_0x003a:
                    com.efs.sdk.pa.a.a r0 = com.efs.sdk.pa.a.a.this
                    long r1 = r0.f5524i
                    r3 = 1
                    long r1 = r1 + r3
                    r0.f5524i = r1
                    boolean r0 = r0.f5516a
                    if (r0 != 0) goto L_0x0081
                    com.efs.sdk.pa.a.a r0 = com.efs.sdk.pa.a.a.this
                    long r1 = r0.f5524i
                    long r3 = r0.f5520e
                    int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r5 < 0) goto L_0x0081
                    int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r5 != 0) goto L_0x0081
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    boolean r2 = r0.f5527l
                    if (r2 == 0) goto L_0x0068
                    java.lang.Thread r2 = r0.f5518c
                    java.lang.String r2 = com.efs.sdk.pa.a.a.a((java.lang.Thread) r2)
                    r1.append(r2)
                    goto L_0x006e
                L_0x0068:
                    boolean r2 = com.efs.sdk.pa.a.a.a((java.lang.StringBuilder) r1)
                    if (r2 == 0) goto L_0x0081
                L_0x006e:
                    com.efs.sdk.pa.PAANRListener r2 = r0.f5523h
                    if (r2 == 0) goto L_0x0081
                    int r2 = r1.length()
                    if (r2 <= 0) goto L_0x0081
                    com.efs.sdk.pa.PAANRListener r0 = r0.f5523h
                    java.lang.String r1 = r1.toString()
                    r0.anrStack(r1)
                L_0x0081:
                    com.efs.sdk.pa.a.a r0 = com.efs.sdk.pa.a.a.this
                    long r1 = android.os.SystemClock.uptimeMillis()
                    r0.f5525j = r1
                    com.efs.sdk.pa.a.a r0 = com.efs.sdk.pa.a.a.this
                    android.os.Handler r1 = r0.f5522g
                    java.lang.Runnable r2 = r0.f5528m
                    long r3 = r0.f5519d
                    r1.postDelayed(r2, r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.pa.a.a.AnonymousClass1.run():void");
            }
        };
        this.f5529n = new Runnable() {
            public final void run() {
                a.this.f5516a = true;
            }
        };
        this.f5526k = j10;
        this.f5531p = application;
        this.f5527l = z10;
        long j11 = ((long) (((float) j10) * 0.8f)) / this.f5520e;
        this.f5519d = j11;
        if (j11 < 100) {
            this.f5519d = 100;
            this.f5520e = j10 / 100;
        }
        StringBuilder sb = new StringBuilder("anrTrace, final mAnrBeatTime:");
        sb.append(this.f5519d);
        sb.append(", mAnrBeatRate:");
        sb.append(this.f5519d);
        this.f5518c = Looper.getMainLooper().getThread();
        this.f5517b = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("ANR HANDLER THREAD");
        this.f5530o = handlerThread;
        handlerThread.start();
        this.f5522g = new Handler(this.f5530o.getLooper());
    }

    public static String a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        sb.append(thread.getName());
        sb.append(" ");
        sb.append(thread.getPriority());
        sb.append(" ");
        sb.append(thread.getState());
        sb.append("\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            sb.append("  at  ");
            sb.append(stackTraceElement2);
            sb.append(10);
        }
        sb.append("\n");
        return sb.toString();
    }
}
