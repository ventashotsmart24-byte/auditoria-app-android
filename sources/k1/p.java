package k1;

import a1.e;
import a1.f;
import a1.k;
import a1.s;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import com.google.common.util.concurrent.ListenableFuture;
import j1.q;
import java.util.UUID;
import l1.c;

public class p implements f {

    /* renamed from: d  reason: collision with root package name */
    public static final String f7269d = k.f("WMFgUpdater");

    /* renamed from: a  reason: collision with root package name */
    public final m1.a f7270a;

    /* renamed from: b  reason: collision with root package name */
    public final i1.a f7271b;

    /* renamed from: c  reason: collision with root package name */
    public final q f7272c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f7273a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UUID f7274b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f7275c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f7276d;

        public a(c cVar, UUID uuid, e eVar, Context context) {
            this.f7273a = cVar;
            this.f7274b = uuid;
            this.f7275c = eVar;
            this.f7276d = context;
        }

        public void run() {
            try {
                if (!this.f7273a.isCancelled()) {
                    String uuid = this.f7274b.toString();
                    s g10 = p.this.f7272c.g(uuid);
                    if (g10 == null || g10.a()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    p.this.f7271b.b(uuid, this.f7275c);
                    this.f7276d.startService(androidx.work.impl.foreground.a.a(this.f7276d, uuid, this.f7275c));
                }
                this.f7273a.o((Object) null);
            } catch (Throwable th) {
                this.f7273a.p(th);
            }
        }
    }

    public p(WorkDatabase workDatabase, i1.a aVar, m1.a aVar2) {
        this.f7271b = aVar;
        this.f7270a = aVar2;
        this.f7272c = workDatabase.B();
    }

    public ListenableFuture a(Context context, UUID uuid, e eVar) {
        c s10 = c.s();
        this.f7270a.b(new a(s10, uuid, eVar, context));
        return s10;
    }
}
