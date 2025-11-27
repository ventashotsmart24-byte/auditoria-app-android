package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;

public class b {

    /* renamed from: a  reason: collision with root package name */
    static int f3747a = 0;

    /* renamed from: b  reason: collision with root package name */
    static long f3748b = 0;

    /* renamed from: c  reason: collision with root package name */
    static long f3749c = 0;

    /* renamed from: d  reason: collision with root package name */
    static long f3750d = 0;

    /* renamed from: e  reason: collision with root package name */
    static long f3751e = 0;

    /* renamed from: f  reason: collision with root package name */
    static long f3752f = 0;

    /* renamed from: g  reason: collision with root package name */
    static double f3753g = 0.0d;

    /* renamed from: h  reason: collision with root package name */
    static double f3754h = 0.0d;

    /* renamed from: i  reason: collision with root package name */
    static double f3755i = 0.0d;

    /* renamed from: j  reason: collision with root package name */
    static double f3756j = 40.0d;

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f3757k = false;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f3758l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f3759m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public e f3760n;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static b f3761a = new b((c) null);
    }

    public /* synthetic */ b(c cVar) {
        this();
    }

    public static /* synthetic */ int b(b bVar) {
        int i10 = bVar.f3759m;
        bVar.f3759m = i10 + 1;
        return i10;
    }

    public synchronized void d() {
        try {
            ALog.i("awcn.BandWidthSampler", "[startNetworkMeter]", (String) null, "NetworkStatus", NetworkStatusHelper.getStatus());
            if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
                f3757k = false;
                return;
            }
            f3757k = true;
        } catch (Exception e10) {
            ALog.w("awcn.BandWidthSampler", "startNetworkMeter fail.", (String) null, e10, new Object[0]);
        }
        return;
    }

    public void e() {
        f3757k = false;
    }

    private b() {
        this.f3758l = 5;
        this.f3759m = 0;
        this.f3760n = new e();
        NetworkStatusHelper.addStatusChangeListener(new c(this));
    }

    public double c() {
        return f3755i;
    }

    public static b a() {
        return a.f3761a;
    }

    public int b() {
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.f3758l;
    }

    public void a(long j10, long j11, long j12) {
        if (f3757k) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "onDataReceived", (String) null, "mRequestStartTime", Long.valueOf(j10), "mRequestFinishedTime", Long.valueOf(j11), "mRequestDataSize", Long.valueOf(j12));
            }
            if (j12 > 3000 && j10 < j11) {
                ThreadPoolExecutorFactory.submitScheduledTask(new d(this, j12, j11, j10));
            }
        }
    }
}
