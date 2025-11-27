package s2;

import android.os.Process;
import android.text.TextUtils;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public abstract class d {

    public static final class b extends ScheduledThreadPoolExecutor {
        public b(int i10, int i11, long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            super(i10, threadFactory);
            setMaximumPoolSize(i11);
            setKeepAliveTime(j10, timeUnit);
        }
    }

    public static final class c extends AtomicLong implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final String f9316a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9317b;

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f9316a + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER + incrementAndGet());
            thread.setPriority(this.f9317b);
            thread.setDaemon(true);
            return thread;
        }

        public c(String str) {
            this(str, 5);
        }

        public c(String str, int i10) {
            this.f9316a = str;
            this.f9317b = i10;
        }
    }

    /* renamed from: s2.d$d  reason: collision with other inner class name */
    public static final class C0121d {

        /* renamed from: a  reason: collision with root package name */
        public static final ScheduledThreadPoolExecutor f9318a = new b(4, 512, 1, TimeUnit.SECONDS, new c("base-io"));
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f9319a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9320b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f9321c;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public e(String str, Runnable runnable, boolean z10) {
            this(str, runnable, z10 ? -2 : 10);
        }

        public void run() {
            Process.setThreadPriority(this.f9319a);
            if (this.f9321c != null) {
                if (!TextUtils.isEmpty(this.f9320b)) {
                    Thread.currentThread().setName(this.f9320b);
                }
                try {
                    this.f9321c.run();
                } catch (Exception e10) {
                    m2.a.a(e10, "thread pool manager");
                }
            }
        }

        public e(String str, Runnable runnable, int i10) {
            this.f9319a = i10;
            this.f9320b = str;
            this.f9321c = runnable;
        }
    }

    public static Runnable a(String str, Runnable runnable, boolean z10) {
        return new e(str, runnable, z10);
    }

    public static void b(String str, Runnable runnable, boolean z10) {
        C0121d.f9318a.execute(a(str, runnable, z10));
    }

    public static ScheduledThreadPoolExecutor c() {
        return C0121d.f9318a;
    }
}
