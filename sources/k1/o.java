package k1;

import a1.e;
import a1.f;
import a1.k;
import android.content.Context;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import j1.p;
import l1.c;

public class o implements Runnable {

    /* renamed from: g  reason: collision with root package name */
    public static final String f7258g = k.f("WorkForegroundRunnable");

    /* renamed from: a  reason: collision with root package name */
    public final c f7259a = c.s();

    /* renamed from: b  reason: collision with root package name */
    public final Context f7260b;

    /* renamed from: c  reason: collision with root package name */
    public final p f7261c;

    /* renamed from: d  reason: collision with root package name */
    public final ListenableWorker f7262d;

    /* renamed from: e  reason: collision with root package name */
    public final f f7263e;

    /* renamed from: f  reason: collision with root package name */
    public final m1.a f7264f;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f7265a;

        public a(c cVar) {
            this.f7265a = cVar;
        }

        public void run() {
            this.f7265a.q(o.this.f7262d.e());
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f7267a;

        public b(c cVar) {
            this.f7267a = cVar;
        }

        public void run() {
            try {
                e eVar = (e) this.f7267a.get();
                if (eVar != null) {
                    k.c().a(o.f7258g, String.format("Updating notification for %s", new Object[]{o.this.f7261c.f7091c}), new Throwable[0]);
                    o.this.f7262d.n(true);
                    o oVar = o.this;
                    oVar.f7259a.q(oVar.f7263e.a(oVar.f7260b, oVar.f7262d.f(), eVar));
                    return;
                }
                throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", new Object[]{o.this.f7261c.f7091c}));
            } catch (Throwable th) {
                o.this.f7259a.p(th);
            }
        }
    }

    public o(Context context, p pVar, ListenableWorker listenableWorker, f fVar, m1.a aVar) {
        this.f7260b = context;
        this.f7261c = pVar;
        this.f7262d = listenableWorker;
        this.f7263e = fVar;
        this.f7264f = aVar;
    }

    public ListenableFuture a() {
        return this.f7259a;
    }

    public void run() {
        if (!this.f7261c.f7105q || x.a.c()) {
            this.f7259a.o((Object) null);
            return;
        }
        c s10 = c.s();
        this.f7264f.a().execute(new a(s10));
        s10.addListener(new b(s10), this.f7264f.a());
    }
}
