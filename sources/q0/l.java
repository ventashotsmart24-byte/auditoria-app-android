package q0;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class l implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f8925a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque f8926b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    public Runnable f8927c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f8928a;

        public a(Runnable runnable) {
            this.f8928a = runnable;
        }

        public void run() {
            try {
                this.f8928a.run();
            } finally {
                l.this.a();
            }
        }
    }

    public l(Executor executor) {
        this.f8925a = executor;
    }

    public synchronized void a() {
        Runnable runnable = (Runnable) this.f8926b.poll();
        this.f8927c = runnable;
        if (runnable != null) {
            this.f8925a.execute(runnable);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.f8926b.offer(new a(runnable));
        if (this.f8927c == null) {
            a();
        }
    }
}
