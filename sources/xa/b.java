package xa;

public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final i f9724a = new i();

    /* renamed from: b  reason: collision with root package name */
    public final c f9725b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f9726c;

    public b(c cVar) {
        this.f9725b = cVar;
    }

    public void a(n nVar, Object obj) {
        h a10 = h.a(nVar, obj);
        synchronized (this) {
            this.f9724a.a(a10);
            if (!this.f9726c) {
                this.f9726c = true;
                this.f9725b.d().execute(this);
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r3 = this;
        L_0x0000:
            r0 = 0
            xa.i r1 = r3.f9724a     // Catch:{ InterruptedException -> 0x0027 }
            r2 = 1000(0x3e8, float:1.401E-42)
            xa.h r1 = r1.c(r2)     // Catch:{ InterruptedException -> 0x0027 }
            if (r1 != 0) goto L_0x001f
            monitor-enter(r3)     // Catch:{ InterruptedException -> 0x0027 }
            xa.i r1 = r3.f9724a     // Catch:{ all -> 0x001c }
            xa.h r1 = r1.b()     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x001a
            r3.f9726c = r0     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            r3.f9726c = r0
            return
        L_0x001a:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            goto L_0x001f
        L_0x001c:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r1     // Catch:{ InterruptedException -> 0x0027 }
        L_0x001f:
            xa.c r2 = r3.f9725b     // Catch:{ InterruptedException -> 0x0027 }
            r2.f(r1)     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x0000
        L_0x0025:
            r1 = move-exception
            goto L_0x003f
        L_0x0027:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0025 }
            r1.<init>()     // Catch:{ all -> 0x0025 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0025 }
            r1.append(r2)     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = " was interruppted"
            r1.append(r2)     // Catch:{ all -> 0x0025 }
            r3.f9726c = r0
            return
        L_0x003f:
            r3.f9726c = r0
            goto L_0x0043
        L_0x0042:
            throw r1
        L_0x0043:
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: xa.b.run():void");
    }
}
