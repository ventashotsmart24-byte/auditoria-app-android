package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.util.ALog;
import java.util.Map;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3620a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ anet.channel.entity.b f3621b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Session f3622c;

    public b(Session session, int i10, anet.channel.entity.b bVar) {
        this.f3622c = session;
        this.f3620a = i10;
        this.f3621b = bVar;
    }

    public void run() {
        try {
            Map<EventCb, Integer> map = this.f3622c.f3550b;
            if (map != null) {
                for (EventCb next : map.keySet()) {
                    if (next != null) {
                        int intValue = this.f3622c.f3550b.get(next).intValue();
                        int i10 = this.f3620a;
                        if ((intValue & i10) != 0) {
                            try {
                                next.onEvent(this.f3622c, i10, this.f3621b);
                            } catch (Exception e10) {
                                ALog.e("awcn.Session", e10.toString(), this.f3622c.f3564p, new Object[0]);
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            ALog.e("awcn.Session", "handleCallbacks", this.f3622c.f3564p, e11, new Object[0]);
        }
    }
}
