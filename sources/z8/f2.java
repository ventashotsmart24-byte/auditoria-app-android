package z8;

import java.io.Closeable;
import z8.i2;
import z8.k1;

public final class f2 extends k0 {

    /* renamed from: a  reason: collision with root package name */
    public final k1.b f20625a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20626b;

    public f2(k1.b bVar) {
        this.f20625a = bVar;
    }

    public void a(i2.a aVar) {
        if (!this.f20626b) {
            super.a(aVar);
        } else if (aVar instanceof Closeable) {
            q0.d((Closeable) aVar);
        }
    }

    public k1.b b() {
        return this.f20625a;
    }

    public void d(Throwable th) {
        this.f20626b = true;
        super.d(th);
    }

    public void e(boolean z10) {
        this.f20626b = true;
        super.e(z10);
    }
}
