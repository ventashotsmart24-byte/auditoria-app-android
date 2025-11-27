package anet.channel.monitor;

import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f3744a;

    /* renamed from: b  reason: collision with root package name */
    private Map<INetworkQualityChangeListener, f> f3745b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private f f3746c = new f();

    private a() {
    }

    public static a a() {
        if (f3744a == null) {
            synchronized (a.class) {
                if (f3744a == null) {
                    f3744a = new a();
                }
            }
        }
        return f3744a;
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener, f fVar) {
        if (iNetworkQualityChangeListener == null) {
            ALog.e("BandWidthListenerHelp", "listener is null", (String) null, new Object[0]);
        } else if (fVar == null) {
            this.f3746c.f3779b = System.currentTimeMillis();
            this.f3745b.put(iNetworkQualityChangeListener, this.f3746c);
        } else {
            fVar.f3779b = System.currentTimeMillis();
            this.f3745b.put(iNetworkQualityChangeListener, fVar);
        }
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.f3745b.remove(iNetworkQualityChangeListener);
    }

    public void a(double d10) {
        boolean a10;
        for (Map.Entry next : this.f3745b.entrySet()) {
            INetworkQualityChangeListener iNetworkQualityChangeListener = (INetworkQualityChangeListener) next.getKey();
            f fVar = (f) next.getValue();
            if (!(iNetworkQualityChangeListener == null || fVar == null || fVar.b() || fVar.f3778a == (a10 = fVar.a(d10)))) {
                fVar.f3778a = a10;
                iNetworkQualityChangeListener.onNetworkQualityChanged(a10 ? NetworkSpeed.Slow : NetworkSpeed.Fast);
            }
        }
    }
}
