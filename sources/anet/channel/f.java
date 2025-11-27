package anet.channel;

import anet.channel.SessionRequest;
import anet.channel.entity.EventCb;
import anet.channel.entity.b;
import anet.channel.util.ALog;

class f implements EventCb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SessionRequest.IConnCb f3712a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f3713b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SessionRequest f3714c;

    public f(SessionRequest sessionRequest, SessionRequest.IConnCb iConnCb, long j10) {
        this.f3714c = sessionRequest;
        this.f3712a = iConnCb;
        this.f3713b = j10;
    }

    public void onEvent(Session session, int i10, b bVar) {
        int i11;
        String str;
        Session session2 = session;
        int i12 = i10;
        b bVar2 = bVar;
        if (session2 != null) {
            if (bVar2 == null) {
                i11 = 0;
            } else {
                i11 = bVar2.f3707b;
            }
            if (bVar2 == null) {
                str = "";
            } else {
                str = bVar2.f3708c;
            }
            if (i12 == 2) {
                ALog.d("awcn.SessionRequest", (String) null, session2.f3564p, "Session", session2, "EventType", Integer.valueOf(i10), "Event", bVar2);
                this.f3714c.a(session2, i11, str);
                SessionRequest sessionRequest = this.f3714c;
                if (sessionRequest.f3588b.c(sessionRequest, session2)) {
                    this.f3712a.onDisConnect(session2, this.f3713b, i12);
                    return;
                }
                this.f3712a.onFailed(session, this.f3713b, i10, i11);
            } else if (i12 == 256) {
                ALog.d("awcn.SessionRequest", (String) null, session2.f3564p, "Session", session2, "EventType", Integer.valueOf(i10), "Event", bVar2);
                this.f3712a.onFailed(session, this.f3713b, i10, i11);
            } else if (i12 == 512) {
                ALog.d("awcn.SessionRequest", (String) null, session2.f3564p, "Session", session2, "EventType", Integer.valueOf(i10), "Event", bVar2);
                this.f3714c.a(session2, 0, (String) null);
                this.f3712a.onSuccess(session2, this.f3713b);
            }
        }
    }
}
