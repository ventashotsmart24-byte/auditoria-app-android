package k1;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class k implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f7243a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public final Executor f7244b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f7245c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public volatile Runnable f7246d;

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final k f7247a;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f7248b;

        public a(k kVar, Runnable runnable) {
            this.f7247a = kVar;
            this.f7248b = runnable;
        }

        public void run() {
            try {
                this.f7248b.run();
            } finally {
                this.f7247a.b();
            }
        }
    }

    public k(Executor executor) {
        this.f7244b = executor;
    }

    public boolean a() {
        boolean z10;
        synchronized (this.f7245c) {
            if (!this.f7243a.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void b() {
        synchronized (this.f7245c) {
            Runnable runnable = (Runnable) this.f7243a.poll();
            this.f7246d = runnable;
            if (runnable != null) {
                this.f7244b.execute(this.f7246d);
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.f7245c) {
            this.f7243a.add(new a(this, runnable));
            if (this.f7246d == null) {
                b();
            }
        }
    }
}
