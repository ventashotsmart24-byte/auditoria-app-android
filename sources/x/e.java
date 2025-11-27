package x;

import a0.h;
import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public abstract class e {

    public static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f9540a;

        public a(Handler handler) {
            this.f9540a = (Handler) h.d(handler);
        }

        public void execute(Runnable runnable) {
            if (!this.f9540a.post((Runnable) h.d(runnable))) {
                throw new RejectedExecutionException(this.f9540a + " is shutting down");
            }
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
