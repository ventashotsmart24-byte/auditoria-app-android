package com.umeng.message.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public abstract class ai {

    /* renamed from: a  reason: collision with root package name */
    final long f15343a;

    /* renamed from: b  reason: collision with root package name */
    long f15344b;

    /* renamed from: c  reason: collision with root package name */
    boolean f15345c = false;

    /* renamed from: d  reason: collision with root package name */
    private final long f15346d;

    /* renamed from: e  reason: collision with root package name */
    private long f15347e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f15348f = new Handler(Looper.getMainLooper()) {
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r10) {
            /*
                r9 = this;
                com.umeng.message.proguard.ai r0 = com.umeng.message.proguard.ai.this
                monitor-enter(r0)
                int r10 = r10.what     // Catch:{ all -> 0x005c }
                r1 = 1
                if (r10 != r1) goto L_0x005a
                com.umeng.message.proguard.ai r10 = com.umeng.message.proguard.ai.this     // Catch:{ all -> 0x005c }
                boolean r2 = r10.f15345c     // Catch:{ all -> 0x005c }
                if (r2 == 0) goto L_0x0010
                monitor-exit(r0)     // Catch:{ all -> 0x005c }
                return
            L_0x0010:
                long r2 = r10.f15344b     // Catch:{ all -> 0x005c }
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x005c }
                long r2 = r2 - r4
                r4 = 0
                int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r10 > 0) goto L_0x0023
                com.umeng.message.proguard.ai r10 = com.umeng.message.proguard.ai.this     // Catch:{ all -> 0x005c }
                r10.e()     // Catch:{ all -> 0x005c }
                goto L_0x005a
            L_0x0023:
                com.umeng.message.proguard.ai r10 = com.umeng.message.proguard.ai.this     // Catch:{ all -> 0x005c }
                long r6 = r10.f15343a     // Catch:{ all -> 0x005c }
                int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r8 >= 0) goto L_0x0036
                r10.a(r2)     // Catch:{ all -> 0x005c }
                android.os.Message r10 = r9.obtainMessage(r1)     // Catch:{ all -> 0x005c }
                r9.sendMessageDelayed(r10, r2)     // Catch:{ all -> 0x005c }
                goto L_0x005a
            L_0x0036:
                long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x005c }
                com.umeng.message.proguard.ai r10 = com.umeng.message.proguard.ai.this     // Catch:{ all -> 0x005c }
                r10.a(r2)     // Catch:{ all -> 0x005c }
                com.umeng.message.proguard.ai r10 = com.umeng.message.proguard.ai.this     // Catch:{ all -> 0x005c }
                long r2 = r10.f15343a     // Catch:{ all -> 0x005c }
                long r6 = r6 + r2
                long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x005c }
                long r6 = r6 - r2
            L_0x0049:
                int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r10 >= 0) goto L_0x0053
                com.umeng.message.proguard.ai r10 = com.umeng.message.proguard.ai.this     // Catch:{ all -> 0x005c }
                long r2 = r10.f15343a     // Catch:{ all -> 0x005c }
                long r6 = r6 + r2
                goto L_0x0049
            L_0x0053:
                android.os.Message r10 = r9.obtainMessage(r1)     // Catch:{ all -> 0x005c }
                r9.sendMessageDelayed(r10, r6)     // Catch:{ all -> 0x005c }
            L_0x005a:
                monitor-exit(r0)     // Catch:{ all -> 0x005c }
                return
            L_0x005c:
                r10 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x005c }
                goto L_0x0060
            L_0x005f:
                throw r10
            L_0x0060:
                goto L_0x005f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ai.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };

    public ai(long j10, long j11) {
        this.f15346d = j10;
        this.f15343a = j11;
    }

    public final synchronized void a() {
        this.f15345c = true;
        this.f15348f.removeMessages(1);
    }

    public abstract void a(long j10);

    public final synchronized ai b() {
        this.f15345c = false;
        if (this.f15346d <= 0) {
            e();
            return this;
        }
        this.f15344b = SystemClock.elapsedRealtime() + this.f15346d;
        Handler handler = this.f15348f;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public final synchronized ai c() {
        this.f15345c = false;
        long elapsedRealtime = this.f15344b - SystemClock.elapsedRealtime();
        this.f15347e = elapsedRealtime;
        if (elapsedRealtime <= 0) {
            return this;
        }
        this.f15348f.removeMessages(1);
        Handler handler = this.f15348f;
        handler.sendMessageAtFrontOfQueue(handler.obtainMessage(2));
        return this;
    }

    public final synchronized ai d() {
        this.f15345c = false;
        if (this.f15347e <= 0) {
            return this;
        }
        this.f15348f.removeMessages(2);
        this.f15344b = this.f15347e + SystemClock.elapsedRealtime();
        Handler handler = this.f15348f;
        handler.sendMessageAtFrontOfQueue(handler.obtainMessage(1));
        return this;
    }

    public abstract void e();
}
