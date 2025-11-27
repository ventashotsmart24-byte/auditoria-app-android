package kotlinx.coroutines.internal;

import ca.i0;
import ca.j0;
import ca.y;
import k9.f;

public final class j extends y implements Runnable, j0 {

    /* renamed from: c  reason: collision with root package name */
    public final y f18273c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18274d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ j0 f18275e;

    /* renamed from: f  reason: collision with root package name */
    public final o f18276f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f18277g;
    private volatile int runningWorkers;

    public j(y yVar, int i10) {
        j0 j0Var;
        this.f18273c = yVar;
        this.f18274d = i10;
        if (yVar instanceof j0) {
            j0Var = (j0) yVar;
        } else {
            j0Var = null;
        }
        this.f18275e = j0Var == null ? i0.a() : j0Var;
        this.f18276f = new o(false);
        this.f18277g = new Object();
    }

    public void L(f fVar, Runnable runnable) {
        if (!O(runnable) && P()) {
            this.f18273c.L(this, this);
        }
    }

    public final boolean O(Runnable runnable) {
        this.f18276f.a(runnable);
        if (this.runningWorkers >= this.f18274d) {
            return true;
        }
        return false;
    }

    public final boolean P() {
        synchronized (this.f18277g) {
            if (this.runningWorkers >= this.f18274d) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r1 = r4.f18277g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.runningWorkers--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r4.f18276f.c() != 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.runningWorkers++;
        r2 = h9.t.f17319a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L_0x0001:
            r1 = 0
        L_0x0002:
            kotlinx.coroutines.internal.o r2 = r4.f18276f
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L_0x002a
            r2.run()     // Catch:{ all -> 0x0010 }
            goto L_0x0016
        L_0x0010:
            r2 = move-exception
            k9.g r3 = k9.g.f18231a
            ca.b0.a(r3, r2)
        L_0x0016:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L_0x0002
            ca.y r2 = r4.f18273c
            boolean r2 = r2.M(r4)
            if (r2 == 0) goto L_0x0002
            ca.y r0 = r4.f18273c
            r0.L(r4, r4)
            return
        L_0x002a:
            java.lang.Object r1 = r4.f18277g
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch:{ all -> 0x0047 }
            int r2 = r2 + -1
            r4.runningWorkers = r2     // Catch:{ all -> 0x0047 }
            kotlinx.coroutines.internal.o r2 = r4.f18276f     // Catch:{ all -> 0x0047 }
            int r2 = r2.c()     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x003d
            monitor-exit(r1)
            return
        L_0x003d:
            int r2 = r4.runningWorkers     // Catch:{ all -> 0x0047 }
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch:{ all -> 0x0047 }
            h9.t r2 = h9.t.f17319a     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            goto L_0x0001
        L_0x0047:
            r0 = move-exception
            monitor-exit(r1)
            goto L_0x004b
        L_0x004a:
            throw r0
        L_0x004b:
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.j.run():void");
    }
}
