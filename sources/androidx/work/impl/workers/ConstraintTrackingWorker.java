package androidx.work.impl.workers;

import a1.k;
import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b1.j;
import com.google.common.util.concurrent.ListenableFuture;
import f1.c;
import f1.d;
import j1.p;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: k  reason: collision with root package name */
    public static final String f3488k = k.f("ConstraintTrkngWrkr");

    /* renamed from: f  reason: collision with root package name */
    public WorkerParameters f3489f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f3490g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f3491h = false;

    /* renamed from: i  reason: collision with root package name */
    public l1.c f3492i = l1.c.s();

    /* renamed from: j  reason: collision with root package name */
    public ListenableWorker f3493j;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ConstraintTrackingWorker.this.u();
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f3495a;

        public b(ListenableFuture listenableFuture) {
            this.f3495a = listenableFuture;
        }

        public void run() {
            synchronized (ConstraintTrackingWorker.this.f3490g) {
                if (ConstraintTrackingWorker.this.f3491h) {
                    ConstraintTrackingWorker.this.t();
                } else {
                    ConstraintTrackingWorker.this.f3492i.q(this.f3495a);
                }
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f3489f = workerParameters;
    }

    public void b(List list) {
        k.c().a(f3488k, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.f3490g) {
            this.f3491h = true;
        }
    }

    public void d(List list) {
    }

    public m1.a h() {
        return j.j(a()).o();
    }

    public boolean j() {
        ListenableWorker listenableWorker = this.f3493j;
        if (listenableWorker == null || !listenableWorker.j()) {
            return false;
        }
        return true;
    }

    public void m() {
        super.m();
        ListenableWorker listenableWorker = this.f3493j;
        if (listenableWorker != null && !listenableWorker.k()) {
            this.f3493j.q();
        }
    }

    public ListenableFuture p() {
        c().execute(new a());
        return this.f3492i;
    }

    public WorkDatabase r() {
        return j.j(a()).n();
    }

    public void s() {
        this.f3492i.o(ListenableWorker.a.a());
    }

    public void t() {
        this.f3492i.o(ListenableWorker.a.b());
    }

    public void u() {
        String i10 = g().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(i10)) {
            k.c().b(f3488k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        ListenableWorker b10 = i().b(a(), i10, this.f3489f);
        this.f3493j = b10;
        if (b10 == null) {
            k.c().a(f3488k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        p h10 = r().B().h(f().toString());
        if (h10 == null) {
            s();
            return;
        }
        d dVar = new d(a(), h(), this);
        dVar.d(Collections.singletonList(h10));
        if (dVar.c(f().toString())) {
            k.c().a(f3488k, String.format("Constraints met for delegate %s", new Object[]{i10}), new Throwable[0]);
            try {
                ListenableFuture p10 = this.f3493j.p();
                p10.addListener(new b(p10), c());
            } catch (Throwable th) {
                k c10 = k.c();
                String str = f3488k;
                c10.a(str, String.format("Delegated worker %s threw exception in startWork.", new Object[]{i10}), th);
                synchronized (this.f3490g) {
                    if (this.f3491h) {
                        k.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                        t();
                    } else {
                        s();
                    }
                }
            }
        } else {
            k.c().a(f3488k, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{i10}), new Throwable[0]);
            t();
        }
    }
}
