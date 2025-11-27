package z8;

import y8.r;

public abstract class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final r f21017a;

    public x(r rVar) {
        this.f21017a = rVar;
    }

    public abstract void a();

    public final void run() {
        r b10 = this.f21017a.b();
        try {
            a();
        } finally {
            this.f21017a.f(b10);
        }
    }
}
