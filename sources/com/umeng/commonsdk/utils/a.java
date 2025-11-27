package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;

public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    private static final int f15095e = 1;

    /* renamed from: a  reason: collision with root package name */
    private final long f15096a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f15097b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f15098c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f15099d = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public HandlerThread f15100f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Handler f15101g;

    /* renamed from: h  reason: collision with root package name */
    private Handler.Callback f15102h = new Handler.Callback() {
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean handleMessage(android.os.Message r9) {
            /*
                r8 = this;
                com.umeng.commonsdk.utils.a r9 = com.umeng.commonsdk.utils.a.this
                monitor-enter(r9)
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                boolean r0 = r0.f15099d     // Catch:{ all -> 0x008b }
                r1 = 1
                if (r0 == 0) goto L_0x000e
                monitor-exit(r9)     // Catch:{ all -> 0x008b }
                return r1
            L_0x000e:
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                long r2 = r0.f15098c     // Catch:{ all -> 0x008b }
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x008b }
                long r2 = r2 - r4
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 > 0) goto L_0x0036
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                r0.c()     // Catch:{ all -> 0x008b }
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                android.os.HandlerThread r0 = r0.f15100f     // Catch:{ all -> 0x008b }
                if (r0 == 0) goto L_0x0088
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                android.os.HandlerThread r0 = r0.f15100f     // Catch:{ all -> 0x008b }
                r0.quit()     // Catch:{ all -> 0x008b }
                goto L_0x0088
            L_0x0036:
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                long r6 = r0.f15097b     // Catch:{ all -> 0x008b }
                int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r0 >= 0) goto L_0x0054
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                android.os.Handler r0 = r0.f15101g     // Catch:{ all -> 0x008b }
                com.umeng.commonsdk.utils.a r4 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                android.os.Handler r4 = r4.f15101g     // Catch:{ all -> 0x008b }
                android.os.Message r1 = r4.obtainMessage(r1)     // Catch:{ all -> 0x008b }
                r0.sendMessageDelayed(r1, r2)     // Catch:{ all -> 0x008b }
                goto L_0x0088
            L_0x0054:
                long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x008b }
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                r0.a((long) r2)     // Catch:{ all -> 0x008b }
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                long r2 = r0.f15097b     // Catch:{ all -> 0x008b }
                long r6 = r6 + r2
                long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x008b }
                long r6 = r6 - r2
            L_0x0069:
                int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r0 >= 0) goto L_0x0075
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                long r2 = r0.f15097b     // Catch:{ all -> 0x008b }
                long r6 = r6 + r2
                goto L_0x0069
            L_0x0075:
                com.umeng.commonsdk.utils.a r0 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                android.os.Handler r0 = r0.f15101g     // Catch:{ all -> 0x008b }
                com.umeng.commonsdk.utils.a r2 = com.umeng.commonsdk.utils.a.this     // Catch:{ all -> 0x008b }
                android.os.Handler r2 = r2.f15101g     // Catch:{ all -> 0x008b }
                android.os.Message r1 = r2.obtainMessage(r1)     // Catch:{ all -> 0x008b }
                r0.sendMessageDelayed(r1, r6)     // Catch:{ all -> 0x008b }
            L_0x0088:
                monitor-exit(r9)     // Catch:{ all -> 0x008b }
                r9 = 0
                return r9
            L_0x008b:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x008b }
                goto L_0x008f
            L_0x008e:
                throw r0
            L_0x008f:
                goto L_0x008e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.a.AnonymousClass1.handleMessage(android.os.Message):boolean");
        }
    };

    public a(long j10, long j11) {
        this.f15096a = j10;
        this.f15097b = j11;
        if (!d()) {
            HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
            this.f15100f = handlerThread;
            handlerThread.start();
            this.f15101g = new Handler(this.f15100f.getLooper(), this.f15102h);
            return;
        }
        this.f15101g = new Handler(this.f15102h);
    }

    public abstract void a(long j10);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f15099d = true;
        this.f15101g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f15099d = false;
        if (this.f15096a <= 0) {
            c();
            return this;
        }
        this.f15098c = SystemClock.elapsedRealtime() + this.f15096a;
        Handler handler = this.f15101g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
