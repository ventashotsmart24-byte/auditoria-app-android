package c1;

import a1.k;
import a1.q;
import j1.p;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f4575d = k.f("DelayedWorkTracker");

    /* renamed from: a  reason: collision with root package name */
    public final b f4576a;

    /* renamed from: b  reason: collision with root package name */
    public final q f4577b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f4578c = new HashMap();

    /* renamed from: c1.a$a  reason: collision with other inner class name */
    public class C0068a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f4579a;

        public C0068a(p pVar) {
            this.f4579a = pVar;
        }

        public void run() {
            k.c().a(a.f4575d, String.format("Scheduling work %s", new Object[]{this.f4579a.f7089a}), new Throwable[0]);
            a.this.f4576a.e(this.f4579a);
        }
    }

    public a(b bVar, q qVar) {
        this.f4576a = bVar;
        this.f4577b = qVar;
    }

    public void a(p pVar) {
        Runnable runnable = (Runnable) this.f4578c.remove(pVar.f7089a);
        if (runnable != null) {
            this.f4577b.a(runnable);
        }
        C0068a aVar = new C0068a(pVar);
        this.f4578c.put(pVar.f7089a, aVar);
        long currentTimeMillis = System.currentTimeMillis();
        this.f4577b.b(pVar.a() - currentTimeMillis, aVar);
    }

    public void b(String str) {
        Runnable runnable = (Runnable) this.f4578c.remove(str);
        if (runnable != null) {
            this.f4577b.a(runnable);
        }
    }
}
