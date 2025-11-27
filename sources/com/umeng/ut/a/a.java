package com.umeng.ut.a;

import android.content.Context;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f16216a = new a();

    /* renamed from: a  reason: collision with other field name */
    private long f57a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f58a = null;

    private a() {
    }

    public static a a() {
        return f16216a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.Context r0 = r1.f58a     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x0018
            if (r2 != 0) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            android.content.Context r0 = r2.getApplicationContext()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0016
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001a }
            r1.f58a = r2     // Catch:{ all -> 0x001a }
            goto L_0x0018
        L_0x0016:
            r1.f58a = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)
            return
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.a.a.a(android.content.Context):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m27a() {
        return this.f58a;
    }

    public void a(long j10) {
        this.f57a = j10 - System.currentTimeMillis();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m26a() {
        return System.currentTimeMillis() + this.f57a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m28a() {
        return "" + a();
    }
}
