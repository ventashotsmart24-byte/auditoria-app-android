package m1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import k1.k;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final k f7804a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f7805b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Executor f7806c = new a();

    public class a implements Executor {
        public a() {
        }

        public void execute(Runnable runnable) {
            b.this.d(runnable);
        }
    }

    public b(Executor executor) {
        this.f7804a = new k(executor);
    }

    public Executor a() {
        return this.f7806c;
    }

    public void b(Runnable runnable) {
        this.f7804a.execute(runnable);
    }

    public k c() {
        return this.f7804a;
    }

    public void d(Runnable runnable) {
        this.f7805b.post(runnable);
    }
}
