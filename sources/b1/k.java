package b1;

import a1.h;
import a1.s;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import com.google.common.util.concurrent.ListenableFuture;
import j1.p;
import j1.q;
import j1.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import k1.g;
import k1.o;

public class k implements Runnable {

    /* renamed from: t  reason: collision with root package name */
    public static final String f4164t = a1.k.f("WorkerWrapper");

    /* renamed from: a  reason: collision with root package name */
    public Context f4165a;

    /* renamed from: b  reason: collision with root package name */
    public String f4166b;

    /* renamed from: c  reason: collision with root package name */
    public List f4167c;

    /* renamed from: d  reason: collision with root package name */
    public WorkerParameters.a f4168d;

    /* renamed from: e  reason: collision with root package name */
    public p f4169e;

    /* renamed from: f  reason: collision with root package name */
    public ListenableWorker f4170f;

    /* renamed from: g  reason: collision with root package name */
    public m1.a f4171g;

    /* renamed from: h  reason: collision with root package name */
    public ListenableWorker.a f4172h = ListenableWorker.a.a();

    /* renamed from: i  reason: collision with root package name */
    public androidx.work.a f4173i;

    /* renamed from: j  reason: collision with root package name */
    public i1.a f4174j;

    /* renamed from: k  reason: collision with root package name */
    public WorkDatabase f4175k;

    /* renamed from: l  reason: collision with root package name */
    public q f4176l;

    /* renamed from: m  reason: collision with root package name */
    public j1.b f4177m;

    /* renamed from: n  reason: collision with root package name */
    public t f4178n;

    /* renamed from: o  reason: collision with root package name */
    public List f4179o;

    /* renamed from: p  reason: collision with root package name */
    public String f4180p;

    /* renamed from: q  reason: collision with root package name */
    public l1.c f4181q = l1.c.s();

    /* renamed from: r  reason: collision with root package name */
    public ListenableFuture f4182r = null;

    /* renamed from: s  reason: collision with root package name */
    public volatile boolean f4183s;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f4184a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l1.c f4185b;

        public a(ListenableFuture listenableFuture, l1.c cVar) {
            this.f4184a = listenableFuture;
            this.f4185b = cVar;
        }

        public void run() {
            try {
                this.f4184a.get();
                a1.k.c().a(k.f4164t, String.format("Starting work for %s", new Object[]{k.this.f4169e.f7091c}), new Throwable[0]);
                k kVar = k.this;
                kVar.f4182r = kVar.f4170f.p();
                this.f4185b.q(k.this.f4182r);
            } catch (Throwable th) {
                this.f4185b.p(th);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l1.c f4187a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4188b;

        public b(l1.c cVar, String str) {
            this.f4187a = cVar;
            this.f4188b = str;
        }

        public void run() {
            try {
                ListenableWorker.a aVar = (ListenableWorker.a) this.f4187a.get();
                if (aVar == null) {
                    a1.k.c().b(k.f4164t, String.format("%s returned a null result. Treating it as a failure.", new Object[]{k.this.f4169e.f7091c}), new Throwable[0]);
                } else {
                    a1.k.c().a(k.f4164t, String.format("%s returned a %s result.", new Object[]{k.this.f4169e.f7091c, aVar}), new Throwable[0]);
                    k.this.f4172h = aVar;
                }
            } catch (CancellationException e10) {
                a1.k.c().d(k.f4164t, String.format("%s was cancelled", new Object[]{this.f4188b}), e10);
            } catch (InterruptedException | ExecutionException e11) {
                a1.k.c().b(k.f4164t, String.format("%s failed because it threw an exception/error", new Object[]{this.f4188b}), e11);
            } catch (Throwable th) {
                k.this.f();
                throw th;
            }
            k.this.f();
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f4190a;

        /* renamed from: b  reason: collision with root package name */
        public ListenableWorker f4191b;

        /* renamed from: c  reason: collision with root package name */
        public i1.a f4192c;

        /* renamed from: d  reason: collision with root package name */
        public m1.a f4193d;

        /* renamed from: e  reason: collision with root package name */
        public androidx.work.a f4194e;

        /* renamed from: f  reason: collision with root package name */
        public WorkDatabase f4195f;

        /* renamed from: g  reason: collision with root package name */
        public String f4196g;

        /* renamed from: h  reason: collision with root package name */
        public List f4197h;

        /* renamed from: i  reason: collision with root package name */
        public WorkerParameters.a f4198i = new WorkerParameters.a();

        public c(Context context, androidx.work.a aVar, m1.a aVar2, i1.a aVar3, WorkDatabase workDatabase, String str) {
            this.f4190a = context.getApplicationContext();
            this.f4193d = aVar2;
            this.f4192c = aVar3;
            this.f4194e = aVar;
            this.f4195f = workDatabase;
            this.f4196g = str;
        }

        public k a() {
            return new k(this);
        }

        public c b(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f4198i = aVar;
            }
            return this;
        }

        public c c(List list) {
            this.f4197h = list;
            return this;
        }
    }

    public k(c cVar) {
        this.f4165a = cVar.f4190a;
        this.f4171g = cVar.f4193d;
        this.f4174j = cVar.f4192c;
        this.f4166b = cVar.f4196g;
        this.f4167c = cVar.f4197h;
        this.f4168d = cVar.f4198i;
        this.f4170f = cVar.f4191b;
        this.f4173i = cVar.f4194e;
        WorkDatabase workDatabase = cVar.f4195f;
        this.f4175k = workDatabase;
        this.f4176l = workDatabase.B();
        this.f4177m = this.f4175k.t();
        this.f4178n = this.f4175k.C();
    }

    public final String a(List list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f4166b);
        sb.append(", tags={ ");
        Iterator it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z10) {
                z10 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    public ListenableFuture b() {
        return this.f4181q;
    }

    public final void c(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            a1.k.c().d(f4164t, String.format("Worker result SUCCESS for %s", new Object[]{this.f4180p}), new Throwable[0]);
            if (this.f4169e.d()) {
                h();
            } else {
                m();
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            a1.k.c().d(f4164t, String.format("Worker result RETRY for %s", new Object[]{this.f4180p}), new Throwable[0]);
            g();
        } else {
            a1.k.c().d(f4164t, String.format("Worker result FAILURE for %s", new Object[]{this.f4180p}), new Throwable[0]);
            if (this.f4169e.d()) {
                h();
            } else {
                l();
            }
        }
    }

    public void d() {
        boolean z10;
        this.f4183s = true;
        n();
        ListenableFuture listenableFuture = this.f4182r;
        if (listenableFuture != null) {
            z10 = listenableFuture.isDone();
            this.f4182r.cancel(true);
        } else {
            z10 = false;
        }
        ListenableWorker listenableWorker = this.f4170f;
        if (listenableWorker == null || z10) {
            a1.k.c().a(f4164t, String.format("WorkSpec %s is already done. Not interrupting.", new Object[]{this.f4169e}), new Throwable[0]);
            return;
        }
        listenableWorker.q();
    }

    public final void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f4176l.g(str2) != s.CANCELLED) {
                this.f4176l.d(s.FAILED, str2);
            }
            linkedList.addAll(this.f4177m.a(str2));
        }
    }

    public void f() {
        if (!n()) {
            this.f4175k.c();
            try {
                s g10 = this.f4176l.g(this.f4166b);
                this.f4175k.A().a(this.f4166b);
                if (g10 == null) {
                    i(false);
                } else if (g10 == s.RUNNING) {
                    c(this.f4172h);
                } else if (!g10.a()) {
                    g();
                }
                this.f4175k.r();
            } finally {
                this.f4175k.g();
            }
        }
        List<e> list = this.f4167c;
        if (list != null) {
            for (e cancel : list) {
                cancel.cancel(this.f4166b);
            }
            f.b(this.f4173i, this.f4175k, this.f4167c);
        }
    }

    public final void g() {
        this.f4175k.c();
        try {
            this.f4176l.d(s.ENQUEUED, this.f4166b);
            this.f4176l.t(this.f4166b, System.currentTimeMillis());
            this.f4176l.l(this.f4166b, -1);
            this.f4175k.r();
        } finally {
            this.f4175k.g();
            i(true);
        }
    }

    public final void h() {
        this.f4175k.c();
        try {
            this.f4176l.t(this.f4166b, System.currentTimeMillis());
            this.f4176l.d(s.ENQUEUED, this.f4166b);
            this.f4176l.r(this.f4166b);
            this.f4176l.l(this.f4166b, -1);
            this.f4175k.r();
        } finally {
            this.f4175k.g();
            i(false);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void i(boolean z10) {
        ListenableWorker listenableWorker;
        this.f4175k.c();
        try {
            if (!this.f4175k.B().q()) {
                g.a(this.f4165a, RescheduleReceiver.class, false);
            }
            if (z10) {
                this.f4176l.d(s.ENQUEUED, this.f4166b);
                this.f4176l.l(this.f4166b, -1);
            }
            if (!(this.f4169e == null || (listenableWorker = this.f4170f) == null || !listenableWorker.j())) {
                this.f4174j.a(this.f4166b);
            }
            this.f4175k.r();
            this.f4175k.g();
            this.f4181q.o(Boolean.valueOf(z10));
        } catch (Throwable th) {
            this.f4175k.g();
            throw th;
        }
    }

    public final void j() {
        s g10 = this.f4176l.g(this.f4166b);
        if (g10 == s.RUNNING) {
            a1.k.c().a(f4164t, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.f4166b}), new Throwable[0]);
            i(true);
            return;
        }
        a1.k.c().a(f4164t, String.format("Status for %s is %s; not doing any work", new Object[]{this.f4166b, g10}), new Throwable[0]);
        i(false);
    }

    public final void k() {
        androidx.work.b b10;
        boolean z10;
        if (!n()) {
            this.f4175k.c();
            try {
                p h10 = this.f4176l.h(this.f4166b);
                this.f4169e = h10;
                if (h10 == null) {
                    a1.k.c().b(f4164t, String.format("Didn't find WorkSpec for id %s", new Object[]{this.f4166b}), new Throwable[0]);
                    i(false);
                    this.f4175k.r();
                } else if (h10.f7090b != s.ENQUEUED) {
                    j();
                    this.f4175k.r();
                    a1.k.c().a(f4164t, String.format("%s is not in ENQUEUED state. Nothing more to do.", new Object[]{this.f4169e.f7091c}), new Throwable[0]);
                    this.f4175k.g();
                } else {
                    if (h10.d() || this.f4169e.c()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        p pVar = this.f4169e;
                        if (pVar.f7102n == 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!z10 && currentTimeMillis < pVar.a()) {
                            a1.k.c().a(f4164t, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f4169e.f7091c}), new Throwable[0]);
                            i(true);
                            this.f4175k.r();
                            this.f4175k.g();
                            return;
                        }
                    }
                    this.f4175k.r();
                    this.f4175k.g();
                    if (this.f4169e.d()) {
                        b10 = this.f4169e.f7093e;
                    } else {
                        h b11 = this.f4173i.f().b(this.f4169e.f7092d);
                        if (b11 == null) {
                            a1.k.c().b(f4164t, String.format("Could not create Input Merger %s", new Object[]{this.f4169e.f7092d}), new Throwable[0]);
                            l();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f4169e.f7093e);
                        arrayList.addAll(this.f4176l.i(this.f4166b));
                        b10 = b11.b(arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f4166b), b10, this.f4179o, this.f4168d, this.f4169e.f7099k, this.f4173i.e(), this.f4171g, this.f4173i.m(), new k1.q(this.f4175k, this.f4171g), new k1.p(this.f4175k, this.f4174j, this.f4171g));
                    if (this.f4170f == null) {
                        this.f4170f = this.f4173i.m().b(this.f4165a, this.f4169e.f7091c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f4170f;
                    if (listenableWorker == null) {
                        a1.k.c().b(f4164t, String.format("Could not create Worker %s", new Object[]{this.f4169e.f7091c}), new Throwable[0]);
                        l();
                    } else if (listenableWorker.l()) {
                        a1.k.c().b(f4164t, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new Object[]{this.f4169e.f7091c}), new Throwable[0]);
                        l();
                    } else {
                        this.f4170f.o();
                        if (!o()) {
                            j();
                        } else if (!n()) {
                            l1.c s10 = l1.c.s();
                            o oVar = new o(this.f4165a, this.f4169e, this.f4170f, workerParameters.b(), this.f4171g);
                            this.f4171g.a().execute(oVar);
                            ListenableFuture a10 = oVar.a();
                            a10.addListener(new a(a10, s10), this.f4171g.a());
                            s10.addListener(new b(s10, this.f4180p), this.f4171g.c());
                        }
                    }
                }
            } finally {
                this.f4175k.g();
            }
        }
    }

    public void l() {
        this.f4175k.c();
        try {
            e(this.f4166b);
            this.f4176l.o(this.f4166b, ((ListenableWorker.a.C0055a) this.f4172h).e());
            this.f4175k.r();
        } finally {
            this.f4175k.g();
            i(false);
        }
    }

    public final void m() {
        this.f4175k.c();
        try {
            this.f4176l.d(s.SUCCEEDED, this.f4166b);
            this.f4176l.o(this.f4166b, ((ListenableWorker.a.c) this.f4172h).e());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.f4177m.a(this.f4166b)) {
                if (this.f4176l.g(str) == s.BLOCKED && this.f4177m.b(str)) {
                    a1.k.c().d(f4164t, String.format("Setting status to enqueued for %s", new Object[]{str}), new Throwable[0]);
                    this.f4176l.d(s.ENQUEUED, str);
                    this.f4176l.t(str, currentTimeMillis);
                }
            }
            this.f4175k.r();
        } finally {
            this.f4175k.g();
            i(false);
        }
    }

    public final boolean n() {
        if (!this.f4183s) {
            return false;
        }
        a1.k.c().a(f4164t, String.format("Work interrupted for %s", new Object[]{this.f4180p}), new Throwable[0]);
        s g10 = this.f4176l.g(this.f4166b);
        if (g10 == null) {
            i(false);
        } else {
            i(!g10.a());
        }
        return true;
    }

    public final boolean o() {
        this.f4175k.c();
        try {
            boolean z10 = false;
            if (this.f4176l.g(this.f4166b) == s.ENQUEUED) {
                this.f4176l.d(s.RUNNING, this.f4166b);
                this.f4176l.s(this.f4166b);
                z10 = true;
            }
            this.f4175k.r();
            return z10;
        } finally {
            this.f4175k.g();
        }
    }

    public void run() {
        List a10 = this.f4178n.a(this.f4166b);
        this.f4179o = a10;
        this.f4180p = a(a10);
        k();
    }
}
