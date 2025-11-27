package anet.channel.request;

import anet.channel.util.ALog;
import java.util.concurrent.Future;

public class b implements Cancelable {
    public static final b NULL = new b((Future<?>) null, (String) null);

    /* renamed from: a  reason: collision with root package name */
    private final Future<?> f3818a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3819b;

    public b(Future<?> future, String str) {
        this.f3818a = future;
        this.f3819b = str;
    }

    public void cancel() {
        if (this.f3818a != null) {
            ALog.i("awcn.FutureCancelable", "cancel request", this.f3819b, new Object[0]);
            this.f3818a.cancel(true);
        }
    }
}
