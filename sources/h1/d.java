package h1;

import a1.k;
import android.content.Context;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class d {

    /* renamed from: f  reason: collision with root package name */
    public static final String f6860f = k.f("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    public final m1.a f6861a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f6862b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f6863c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Set f6864d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    public Object f6865e;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6866a;

        public a(List list) {
            this.f6866a = list;
        }

        public void run() {
            for (f1.a a10 : this.f6866a) {
                a10.a(d.this.f6865e);
            }
        }
    }

    public d(Context context, m1.a aVar) {
        this.f6862b = context.getApplicationContext();
        this.f6861a = aVar;
    }

    public void a(f1.a aVar) {
        synchronized (this.f6863c) {
            if (this.f6864d.add(aVar)) {
                if (this.f6864d.size() == 1) {
                    this.f6865e = b();
                    k.c().a(f6860f, String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.f6865e}), new Throwable[0]);
                    e();
                }
                aVar.a(this.f6865e);
            }
        }
    }

    public abstract Object b();

    public void c(f1.a aVar) {
        synchronized (this.f6863c) {
            if (this.f6864d.remove(aVar) && this.f6864d.isEmpty()) {
                f();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f6863c
            monitor-enter(r0)
            java.lang.Object r1 = r3.f6865e     // Catch:{ all -> 0x002b }
            if (r1 == r4) goto L_0x0029
            if (r1 == 0) goto L_0x0010
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0010
            goto L_0x0029
        L_0x0010:
            r3.f6865e = r4     // Catch:{ all -> 0x002b }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x002b }
            java.util.Set r1 = r3.f6864d     // Catch:{ all -> 0x002b }
            r4.<init>(r1)     // Catch:{ all -> 0x002b }
            m1.a r1 = r3.f6861a     // Catch:{ all -> 0x002b }
            java.util.concurrent.Executor r1 = r1.a()     // Catch:{ all -> 0x002b }
            h1.d$a r2 = new h1.d$a     // Catch:{ all -> 0x002b }
            r2.<init>(r4)     // Catch:{ all -> 0x002b }
            r1.execute(r2)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.d.d(java.lang.Object):void");
    }

    public abstract void e();

    public abstract void f();
}
