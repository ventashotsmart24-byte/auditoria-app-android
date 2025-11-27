package x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9536a;

    /* renamed from: b  reason: collision with root package name */
    public a f9537b;

    /* renamed from: c  reason: collision with root package name */
    public Object f9538c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9539d;

    public interface a {
        void a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        if (r1 == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        ((android.os.CancellationSignal) r1).cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.f9539d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002d, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r3.f9539d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0033, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f9536a     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0038 }
            return
        L_0x0007:
            r0 = 1
            r3.f9536a = r0     // Catch:{ all -> 0x0038 }
            r3.f9539d = r0     // Catch:{ all -> 0x0038 }
            x.b$a r0 = r3.f9537b     // Catch:{ all -> 0x0038 }
            java.lang.Object r1 = r3.f9538c     // Catch:{ all -> 0x0038 }
            monitor-exit(r3)     // Catch:{ all -> 0x0038 }
            r2 = 0
            if (r0 == 0) goto L_0x001a
            r0.a()     // Catch:{ all -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r0 = move-exception
            goto L_0x0022
        L_0x001a:
            if (r1 == 0) goto L_0x002d
            android.os.CancellationSignal r1 = (android.os.CancellationSignal) r1     // Catch:{ all -> 0x0018 }
            r1.cancel()     // Catch:{ all -> 0x0018 }
            goto L_0x002d
        L_0x0022:
            monitor-enter(r3)
            r3.f9539d = r2     // Catch:{ all -> 0x002a }
            r3.notifyAll()     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x002a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x002d:
            monitor-enter(r3)
            r3.f9539d = r2     // Catch:{ all -> 0x0035 }
            r3.notifyAll()     // Catch:{ all -> 0x0035 }
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            throw r0
        L_0x0038:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0038 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x.b.a():void");
    }

    public boolean b() {
        boolean z10;
        synchronized (this) {
            z10 = this.f9536a;
        }
        return z10;
    }

    public void c(a aVar) {
        synchronized (this) {
            d();
            if (this.f9537b != aVar) {
                this.f9537b = aVar;
                if (this.f9536a) {
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            }
        }
    }

    public final void d() {
        while (this.f9539d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
