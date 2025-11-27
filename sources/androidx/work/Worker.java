package androidx.work;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import l1.c;

public abstract class Worker extends ListenableWorker {

    /* renamed from: f  reason: collision with root package name */
    public c f3342f;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                Worker.this.f3342f.o(Worker.this.r());
            } catch (Throwable th) {
                Worker.this.f3342f.p(th);
            }
        }
    }

    @Keep
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public final ListenableFuture p() {
        this.f3342f = c.s();
        c().execute(new a());
        return this.f3342f;
    }

    public abstract ListenableWorker.a r();
}
