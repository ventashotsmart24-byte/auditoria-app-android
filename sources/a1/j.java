package a1;

import ca.f1;
import com.google.common.util.concurrent.ListenableFuture;
import h9.t;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import l1.c;
import s9.l;
import t9.i;

public final class j implements ListenableFuture {

    /* renamed from: a  reason: collision with root package name */
    public final f1 f112a;

    /* renamed from: b  reason: collision with root package name */
    public final c f113b;

    public static final class a extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f114a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j jVar) {
            super(1);
            this.f114a = jVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            if (th == null) {
                if (!this.f114a.f113b.isDone()) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else if (th instanceof CancellationException) {
                this.f114a.f113b.cancel(true);
            } else {
                c a10 = this.f114a.f113b;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                a10.p(th);
            }
        }
    }

    public j(f1 f1Var, c cVar) {
        i.g(f1Var, "job");
        i.g(cVar, "underlying");
        this.f112a = f1Var;
        this.f113b = cVar;
        f1Var.e(new a(this));
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.f113b.addListener(runnable, executor);
    }

    public final void b(Object obj) {
        this.f113b.o(obj);
    }

    public boolean cancel(boolean z10) {
        return this.f113b.cancel(z10);
    }

    public Object get() {
        return this.f113b.get();
    }

    public boolean isCancelled() {
        return this.f113b.isCancelled();
    }

    public boolean isDone() {
        return this.f113b.isDone();
    }

    public Object get(long j10, TimeUnit timeUnit) {
        return this.f113b.get(j10, timeUnit);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ j(ca.f1 r1, l1.c r2, int r3, t9.g r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000d
            l1.c r2 = l1.c.s()
            java.lang.String r3 = "create()"
            t9.i.f(r2, r3)
        L_0x000d:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.j.<init>(ca.f1, l1.c, int, t9.g):void");
    }
}
