package z8;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class c1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f20446b = Logger.getLogger(c1.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f20447a;

    public c1(Runnable runnable) {
        this.f20447a = (Runnable) Preconditions.checkNotNull(runnable, "task");
    }

    public void run() {
        try {
            this.f20447a.run();
        } catch (Throwable th) {
            Logger logger = f20446b;
            Level level = Level.SEVERE;
            logger.log(level, "Exception while executing runnable " + this.f20447a, th);
            Throwables.throwIfUnchecked(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f20447a + ")";
    }
}
