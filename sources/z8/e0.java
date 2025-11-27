package z8;

import com.google.common.base.Preconditions;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import z8.k;

public final class e0 implements k {

    /* renamed from: a  reason: collision with root package name */
    public Random f20474a = new Random();

    /* renamed from: b  reason: collision with root package name */
    public long f20475b = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: c  reason: collision with root package name */
    public long f20476c = TimeUnit.MINUTES.toNanos(2);

    /* renamed from: d  reason: collision with root package name */
    public double f20477d = 1.6d;

    /* renamed from: e  reason: collision with root package name */
    public double f20478e = 0.2d;

    /* renamed from: f  reason: collision with root package name */
    public long f20479f = this.f20475b;

    public static final class a implements k.a {
        public k get() {
            return new e0();
        }
    }

    public long a() {
        long j10 = this.f20479f;
        double d10 = (double) j10;
        double d11 = this.f20477d;
        Double.isNaN(d10);
        this.f20479f = Math.min((long) (d11 * d10), this.f20476c);
        double d12 = this.f20478e;
        Double.isNaN(d10);
        Double.isNaN(d10);
        return j10 + b((-d12) * d10, d12 * d10);
    }

    public final long b(double d10, double d11) {
        boolean z10;
        if (d11 >= d10) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        return (long) ((this.f20474a.nextDouble() * (d11 - d10)) + d10);
    }
}
