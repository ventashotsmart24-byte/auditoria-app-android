package z8;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a2 implements Executor {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f20331c = Logger.getLogger(a2.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public boolean f20332a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayDeque f20333b;

    public final void a() {
        while (true) {
            Runnable runnable = (Runnable) this.f20333b.poll();
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    Logger logger = f20331c;
                    Level level = Level.SEVERE;
                    logger.log(level, "Exception while executing runnable " + runnable, th);
                }
            } else {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f20333b == null) {
            this.f20333b = new ArrayDeque(4);
        }
        this.f20333b.add(runnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r6.f20333b == null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r6.f20333b != null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r6.f20332a = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(java.lang.Runnable r7) {
        /*
            r6 = this;
            java.lang.String r0 = "'task' must not be null."
            com.google.common.base.Preconditions.checkNotNull(r7, r0)
            boolean r0 = r6.f20332a
            if (r0 != 0) goto L_0x0043
            r0 = 1
            r6.f20332a = r0
            r0 = 0
            r7.run()     // Catch:{ all -> 0x001a }
            java.util.ArrayDeque r7 = r6.f20333b
            if (r7 == 0) goto L_0x0017
        L_0x0014:
            r6.a()
        L_0x0017:
            r6.f20332a = r0
            goto L_0x0046
        L_0x001a:
            r1 = move-exception
            java.util.logging.Logger r2 = f20331c     // Catch:{ all -> 0x0038 }
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0038 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r4.<init>()     // Catch:{ all -> 0x0038 }
            java.lang.String r5 = "Exception while executing runnable "
            r4.append(r5)     // Catch:{ all -> 0x0038 }
            r4.append(r7)     // Catch:{ all -> 0x0038 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0038 }
            r2.log(r3, r7, r1)     // Catch:{ all -> 0x0038 }
            java.util.ArrayDeque r7 = r6.f20333b
            if (r7 == 0) goto L_0x0017
            goto L_0x0014
        L_0x0038:
            r7 = move-exception
            java.util.ArrayDeque r1 = r6.f20333b
            if (r1 == 0) goto L_0x0040
            r6.a()
        L_0x0040:
            r6.f20332a = r0
            throw r7
        L_0x0043:
            r6.b(r7)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.a2.execute(java.lang.Runnable):void");
    }
}
