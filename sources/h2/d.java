package h2;

import d2.b;
import d2.c;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import s2.d;
import t9.g;
import t9.i;

public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public c f6882a;

    /* renamed from: b  reason: collision with root package name */
    public long f6883b;

    /* renamed from: c  reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f6884c;

    /* renamed from: d  reason: collision with root package name */
    public Future f6885d;

    /* renamed from: e  reason: collision with root package name */
    public String f6886e;

    /* renamed from: f  reason: collision with root package name */
    public long f6887f;

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f6888a;

        public a(d dVar) {
            this.f6888a = dVar;
        }

        public void a(long j10) {
            if (j10 != this.f6888a.f6883b) {
                this.f6888a.f6883b = j10;
                this.f6888a.f6887f = j10;
                Future e10 = this.f6888a.f6885d;
                if (e10 != null) {
                    e10.cancel(true);
                }
                this.f6888a.f6885d = null;
                this.f6888a.l();
            }
        }
    }

    public d(c cVar, long j10) {
        i.g(cVar, "mReporter");
        this.f6882a = cVar;
        this.f6883b = j10;
        this.f6884c = s2.d.c();
        this.f6886e = d.class.getSimpleName();
    }

    public static final void m(d dVar) {
        i.g(dVar, "this$0");
        try {
            dVar.f6882a.c(new a(dVar));
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static final void n(d dVar) {
        i.g(dVar, "this$0");
        try {
            c.a.a(dVar.f6882a, (b) null, 1, (Object) null);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a() {
        i2.a.f6993a.j(this.f6883b);
        k();
        l();
    }

    public void b() {
        this.f6884c.submit(new d.e("interval report trigger", (Runnable) new b(this), false));
    }

    public final void k() {
        Future future = this.f6885d;
        if (future != null) {
            future.cancel(true);
        }
        this.f6885d = null;
    }

    public final void l() {
        this.f6885d = this.f6884c.scheduleAtFixedRate(new d.e("interval report", (Runnable) new c(this), false), this.f6887f, this.f6883b, TimeUnit.MINUTES);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(c cVar, long j10, int i10, g gVar) {
        this(cVar, (i10 & 2) != 0 ? 10 : j10);
    }
}
