package kotlinx.coroutines.scheduling;

import ca.g0;

public final class k extends h {

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f18342c;

    public k(Runnable runnable, long j10, i iVar) {
        super(j10, iVar);
        this.f18342c = runnable;
    }

    public void run() {
        try {
            this.f18342c.run();
        } finally {
            this.f18340b.a();
        }
    }

    public String toString() {
        return "Task[" + g0.a(this.f18342c) + '@' + g0.b(this.f18342c) + ", " + this.f18339a + ", " + this.f18340b + ']';
    }
}
