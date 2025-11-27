package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.InputStream;
import y8.u;
import z8.g;
import z8.i2;
import z8.k1;

public class f implements y {

    /* renamed from: a  reason: collision with root package name */
    public final k1.b f20481a;

    /* renamed from: b  reason: collision with root package name */
    public final g f20482b;

    /* renamed from: c  reason: collision with root package name */
    public final k1 f20483c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20484a;

        public a(int i10) {
            this.f20484a = i10;
        }

        public void run() {
            if (!f.this.f20483c.isClosed()) {
                try {
                    f.this.f20483c.b(this.f20484a);
                } catch (Throwable th) {
                    f.this.f20482b.d(th);
                    f.this.f20483c.close();
                }
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t1 f20486a;

        public b(t1 t1Var) {
            this.f20486a = t1Var;
        }

        public void run() {
            try {
                f.this.f20483c.f(this.f20486a);
            } catch (Throwable th) {
                f.this.f20482b.d(th);
                f.this.f20483c.close();
            }
        }
    }

    public class c implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t1 f20488a;

        public c(t1 t1Var) {
            this.f20488a = t1Var;
        }

        public void close() {
            this.f20488a.close();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            f.this.f20483c.m();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            f.this.f20483c.close();
        }
    }

    /* renamed from: z8.f$f  reason: collision with other inner class name */
    public class C0303f extends g implements Closeable {

        /* renamed from: d  reason: collision with root package name */
        public final Closeable f20492d;

        public C0303f(Runnable runnable, Closeable closeable) {
            super(f.this, runnable, (a) null);
            this.f20492d = closeable;
        }

        public void close() {
            this.f20492d.close();
        }
    }

    public class g implements i2.a {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f20494a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20495b;

        public /* synthetic */ g(f fVar, Runnable runnable, a aVar) {
            this(runnable);
        }

        private void a() {
            if (!this.f20495b) {
                this.f20494a.run();
                this.f20495b = true;
            }
        }

        public InputStream next() {
            a();
            return f.this.f20482b.f();
        }

        public g(Runnable runnable) {
            this.f20495b = false;
            this.f20494a = runnable;
        }
    }

    public interface h extends g.d {
    }

    public f(k1.b bVar, h hVar, k1 k1Var) {
        f2 f2Var = new f2((k1.b) Preconditions.checkNotNull(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER));
        this.f20481a = f2Var;
        g gVar = new g(f2Var, hVar);
        this.f20482b = gVar;
        k1Var.E(gVar);
        this.f20483c = k1Var;
    }

    public void b(int i10) {
        this.f20481a.a(new g(this, new a(i10), (a) null));
    }

    public void c(int i10) {
        this.f20483c.c(i10);
    }

    public void close() {
        this.f20483c.I();
        this.f20481a.a(new g(this, new e(), (a) null));
    }

    public void e(u uVar) {
        this.f20483c.e(uVar);
    }

    public void f(t1 t1Var) {
        this.f20481a.a(new C0303f(new b(t1Var), new c(t1Var)));
    }

    public void m() {
        this.f20481a.a(new g(this, new d(), (a) null));
    }
}
