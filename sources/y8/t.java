package y8;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class t implements Comparable {

    /* renamed from: d  reason: collision with root package name */
    public static final b f20161d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final long f20162e;

    /* renamed from: f  reason: collision with root package name */
    public static final long f20163f;

    /* renamed from: g  reason: collision with root package name */
    public static final long f20164g = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: a  reason: collision with root package name */
    public final c f20165a;

    /* renamed from: b  reason: collision with root package name */
    public final long f20166b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f20167c;

    public static class b extends c {
        public b() {
        }

        public long a() {
            return System.nanoTime();
        }
    }

    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500);
        f20162e = nanos;
        f20163f = -nanos;
    }

    public t(c cVar, long j10, boolean z10) {
        this(cVar, cVar.a(), j10, z10);
    }

    public static t a(long j10, TimeUnit timeUnit) {
        return b(j10, timeUnit, f20161d);
    }

    public static t b(long j10, TimeUnit timeUnit, c cVar) {
        c(timeUnit, "units");
        return new t(cVar, timeUnit.toNanos(j10), true);
    }

    public static Object c(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public final void d(t tVar) {
        if (this.f20165a != tVar.f20165a) {
            throw new AssertionError("Tickers (" + this.f20165a + " and " + tVar.f20165a + ") don't match. Custom Ticker should only be used in tests!");
        }
    }

    /* renamed from: e */
    public int compareTo(t tVar) {
        d(tVar);
        long j10 = this.f20166b - tVar.f20166b;
        if (j10 < 0) {
            return -1;
        }
        if (j10 > 0) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        c cVar = this.f20165a;
        if (cVar != null ? cVar != tVar.f20165a : tVar.f20165a != null) {
            return false;
        }
        if (this.f20166b != tVar.f20166b) {
            return false;
        }
        return true;
    }

    public boolean f(t tVar) {
        d(tVar);
        if (this.f20166b - tVar.f20166b < 0) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (!this.f20167c) {
            if (this.f20166b - this.f20165a.a() > 0) {
                return false;
            }
            this.f20167c = true;
        }
        return true;
    }

    public t h(t tVar) {
        d(tVar);
        if (f(tVar)) {
            return this;
        }
        return tVar;
    }

    public int hashCode() {
        return Arrays.asList(new Object[]{this.f20165a, Long.valueOf(this.f20166b)}).hashCode();
    }

    public long i(TimeUnit timeUnit) {
        long a10 = this.f20165a.a();
        if (!this.f20167c && this.f20166b - a10 <= 0) {
            this.f20167c = true;
        }
        return timeUnit.convert(this.f20166b - a10, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long i10 = i(TimeUnit.NANOSECONDS);
        long abs = Math.abs(i10);
        long j10 = f20164g;
        long j11 = abs / j10;
        long abs2 = Math.abs(i10) % j10;
        StringBuilder sb = new StringBuilder();
        if (i10 < 0) {
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        }
        sb.append(j11);
        if (abs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", new Object[]{Long.valueOf(abs2)}));
        }
        sb.append("s from now");
        if (this.f20165a != f20161d) {
            sb.append(" (ticker=" + this.f20165a + ")");
        }
        return sb.toString();
    }

    public t(c cVar, long j10, long j11, boolean z10) {
        this.f20165a = cVar;
        long min = Math.min(f20162e, Math.max(f20163f, j11));
        this.f20166b = j10 + min;
        this.f20167c = z10 && min <= 0;
    }
}
