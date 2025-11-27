package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import ca.c0;
import ca.d0;
import ca.e0;
import ca.f1;
import ca.k1;
import ca.n0;
import ca.q;
import ca.y;
import com.google.common.util.concurrent.ListenableFuture;
import h9.m;
import h9.t;
import java.util.concurrent.CancellationException;
import k9.f;
import kotlin.coroutines.Continuation;
import m9.j;
import s9.p;
import t9.g;
import t9.i;

public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: f  reason: collision with root package name */
    public final q f3324f = k1.b((f1) null, 1, (Object) null);

    /* renamed from: g  reason: collision with root package name */
    public final l1.c f3325g;

    /* renamed from: h  reason: collision with root package name */
    public final y f3326h;

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoroutineWorker f3327a;

        public a(CoroutineWorker coroutineWorker) {
            this.f3327a = coroutineWorker;
        }

        public final void run() {
            if (this.f3327a.v().isCancelled()) {
                f1.a.a(this.f3327a.w(), (CancellationException) null, 1, (Object) null);
            }
        }
    }

    public static final class b extends j implements p {

        /* renamed from: b  reason: collision with root package name */
        public Object f3328b;

        /* renamed from: c  reason: collision with root package name */
        public int f3329c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a1.j f3330d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoroutineWorker f3331e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a1.j jVar, CoroutineWorker coroutineWorker, Continuation continuation) {
            super(2, continuation);
            this.f3330d = jVar;
            this.f3331e = coroutineWorker;
        }

        /* renamed from: b */
        public final Object invoke(c0 c0Var, Continuation continuation) {
            return ((b) create(c0Var, continuation)).invokeSuspend(t.f17319a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f3330d, this.f3331e, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            a1.j jVar;
            Object c10 = l9.c.c();
            int i10 = this.f3329c;
            if (i10 == 0) {
                m.b(obj);
                a1.j jVar2 = this.f3330d;
                CoroutineWorker coroutineWorker = this.f3331e;
                this.f3328b = jVar2;
                this.f3329c = 1;
                Object t10 = coroutineWorker.t(this);
                if (t10 == c10) {
                    return c10;
                }
                jVar = jVar2;
                obj = t10;
            } else if (i10 == 1) {
                jVar = (a1.j) this.f3328b;
                m.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar.b(obj);
            return t.f17319a;
        }
    }

    public static final class c extends j implements p {

        /* renamed from: b  reason: collision with root package name */
        public int f3332b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CoroutineWorker f3333c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(CoroutineWorker coroutineWorker, Continuation continuation) {
            super(2, continuation);
            this.f3333c = coroutineWorker;
        }

        /* renamed from: b */
        public final Object invoke(c0 c0Var, Continuation continuation) {
            return ((c) create(c0Var, continuation)).invokeSuspend(t.f17319a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.f3333c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object c10 = l9.c.c();
            int i10 = this.f3332b;
            if (i10 == 0) {
                m.b(obj);
                CoroutineWorker coroutineWorker = this.f3333c;
                this.f3332b = 1;
                obj = coroutineWorker.r(this);
                if (obj == c10) {
                    return c10;
                }
            } else if (i10 == 1) {
                try {
                    m.b(obj);
                } catch (Throwable th) {
                    this.f3333c.v().p(th);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f3333c.v().o((ListenableWorker.a) obj);
            return t.f17319a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        i.g(context, "appContext");
        i.g(workerParameters, "params");
        l1.c s10 = l1.c.s();
        i.f(s10, "create()");
        this.f3325g = s10;
        s10.addListener(new a(this), h().c());
        this.f3326h = n0.a();
    }

    public static /* synthetic */ Object u(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public final ListenableFuture e() {
        q b10 = k1.b((f1) null, 1, (Object) null);
        c0 a10 = d0.a(s().s(b10));
        a1.j jVar = new a1.j(b10, (l1.c) null, 2, (g) null);
        f1 unused = ca.g.b(a10, (f) null, (e0) null, new b(jVar, this, (Continuation) null), 3, (Object) null);
        return jVar;
    }

    public final void m() {
        super.m();
        this.f3325g.cancel(false);
    }

    public final ListenableFuture p() {
        f1 unused = ca.g.b(d0.a(s().s(this.f3324f)), (f) null, (e0) null, new c(this, (Continuation) null), 3, (Object) null);
        return this.f3325g;
    }

    public abstract Object r(Continuation continuation);

    public y s() {
        return this.f3326h;
    }

    public Object t(Continuation continuation) {
        return u(this, continuation);
    }

    public final l1.c v() {
        return this.f3325g;
    }

    public final q w() {
        return this.f3324f;
    }
}
