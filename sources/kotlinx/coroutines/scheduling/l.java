package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.z;
import y9.e;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static final long f18343a = b0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    public static final int f18344b = b0.d("kotlinx.coroutines.scheduler.core.pool.size", e.a(z.a(), 2), 1, 0, 8, (Object) null);

    /* renamed from: c  reason: collision with root package name */
    public static final int f18345c = b0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final long f18346d = TimeUnit.SECONDS.toNanos(b0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));

    /* renamed from: e  reason: collision with root package name */
    public static g f18347e = e.f18333a;

    /* renamed from: f  reason: collision with root package name */
    public static final i f18348f = new j(0);

    /* renamed from: g  reason: collision with root package name */
    public static final i f18349g = new j(1);
}
