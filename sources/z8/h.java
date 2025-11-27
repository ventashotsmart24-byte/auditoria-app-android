package z8;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class h {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f20667c = Logger.getLogger(h.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final String f20668a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f20669b;

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f20670a;

        public void a() {
            long j10 = this.f20670a;
            long max = Math.max(2 * j10, j10);
            if (h.this.f20669b.compareAndSet(this.f20670a, max)) {
                h.f20667c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{h.this.f20668a, Long.valueOf(max)});
            }
        }

        public long b() {
            return this.f20670a;
        }

        public b(long j10) {
            this.f20670a = j10;
        }
    }

    public h(String str, long j10) {
        boolean z10;
        AtomicLong atomicLong = new AtomicLong();
        this.f20669b = atomicLong;
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "value must be positive");
        this.f20668a = str;
        atomicLong.set(j10);
    }

    public b d() {
        return new b(this.f20669b.get());
    }
}
