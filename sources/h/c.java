package h;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public final Object f6845a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f6846b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c  reason: collision with root package name */
    public volatile Handler f6847c;

    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f6848a = new AtomicInteger(0);

        public a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f6848a.getAndIncrement())}));
            return thread;
        }
    }

    public static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    public void a(Runnable runnable) {
        this.f6846b.execute(runnable);
    }

    public boolean b() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public void c(Runnable runnable) {
        if (this.f6847c == null) {
            synchronized (this.f6845a) {
                if (this.f6847c == null) {
                    this.f6847c = d(Looper.getMainLooper());
                }
            }
        }
        this.f6847c.post(runnable);
    }
}
