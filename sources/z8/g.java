package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import z8.i2;
import z8.k1;

public final class g implements k1.b {

    /* renamed from: a  reason: collision with root package name */
    public final d f20627a;

    /* renamed from: b  reason: collision with root package name */
    public final k1.b f20628b;

    /* renamed from: c  reason: collision with root package name */
    public final Queue f20629c = new ArrayDeque();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20630a;

        public a(int i10) {
            this.f20630a = i10;
        }

        public void run() {
            g.this.f20628b.c(this.f20630a);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f20632a;

        public b(boolean z10) {
            this.f20632a = z10;
        }

        public void run() {
            g.this.f20628b.e(this.f20632a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Throwable f20634a;

        public c(Throwable th) {
            this.f20634a = th;
        }

        public void run() {
            g.this.f20628b.d(this.f20634a);
        }
    }

    public interface d {
        void f(Runnable runnable);
    }

    public g(k1.b bVar, d dVar) {
        this.f20628b = (k1.b) Preconditions.checkNotNull(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f20627a = (d) Preconditions.checkNotNull(dVar, "transportExecutor");
    }

    public void a(i2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next != null) {
                this.f20629c.add(next);
            } else {
                return;
            }
        }
    }

    public void c(int i10) {
        this.f20627a.f(new a(i10));
    }

    public void d(Throwable th) {
        this.f20627a.f(new c(th));
    }

    public void e(boolean z10) {
        this.f20627a.f(new b(z10));
    }

    public InputStream f() {
        return (InputStream) this.f20629c.poll();
    }
}
