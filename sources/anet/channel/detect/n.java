package anet.channel.detect;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static d f3675a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static ExceptionDetector f3676b = new ExceptionDetector();

    /* renamed from: c  reason: collision with root package name */
    private static k f3677c = new k();

    /* renamed from: d  reason: collision with root package name */
    private static AtomicBoolean f3678d = new AtomicBoolean(false);

    public static void a() {
        try {
            if (f3678d.compareAndSet(false, true)) {
                ALog.i("awcn.NetworkDetector", "registerListener", (String) null, new Object[0]);
                f3675a.b();
                f3676b.a();
                f3677c.a();
            }
        } catch (Exception e10) {
            ALog.e("awcn.NetworkDetector", "[registerListener]error", (String) null, e10, new Object[0]);
        }
    }

    public static void a(RequestStatistic requestStatistic) {
        if (f3678d.get()) {
            f3676b.a(requestStatistic);
        }
    }
}
