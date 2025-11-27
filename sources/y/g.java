package y;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class g {

    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public String f9841a;

        /* renamed from: b  reason: collision with root package name */
        public int f9842b;

        /* renamed from: y.g$a$a  reason: collision with other inner class name */
        public static class C0134a extends Thread {

            /* renamed from: a  reason: collision with root package name */
            public final int f9843a;

            public C0134a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f9843a = i10;
            }

            public void run() {
                Process.setThreadPriority(this.f9843a);
                super.run();
            }
        }

        public a(String str, int i10) {
            this.f9841a = str;
            this.f9842b = i10;
        }

        public Thread newThread(Runnable runnable) {
            return new C0134a(runnable, this.f9841a, this.f9842b);
        }
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Callable f9844a;

        /* renamed from: b  reason: collision with root package name */
        public a0.a f9845b;

        /* renamed from: c  reason: collision with root package name */
        public Handler f9846c;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a0.a f9847a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f9848b;

            public a(a0.a aVar, Object obj) {
                this.f9847a = aVar;
                this.f9848b = obj;
            }

            public void run() {
                this.f9847a.accept(this.f9848b);
            }
        }

        public b(Handler handler, Callable callable, a0.a aVar) {
            this.f9844a = callable;
            this.f9845b = aVar;
            this.f9846c = handler;
        }

        public void run() {
            Object obj;
            try {
                obj = this.f9844a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f9846c.post(new a(this.f9845b, obj));
        }
    }

    public static ThreadPoolExecutor a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void b(Executor executor, Callable callable, a0.a aVar) {
        executor.execute(new b(b.a(), callable, aVar));
    }

    public static Object c(ExecutorService executorService, Callable callable, int i10) {
        try {
            return executorService.submit(callable).get((long) i10, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e10) {
            throw new RuntimeException(e10);
        } catch (InterruptedException e11) {
            throw e11;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
