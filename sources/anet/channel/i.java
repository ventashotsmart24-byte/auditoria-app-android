package anet.channel;

import anet.channel.SessionRequest;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Session f3739a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SessionRequest.a f3740b;

    public i(SessionRequest.a aVar, Session session) {
        this.f3740b = aVar;
        this.f3739a = session;
    }

    public void run() {
        try {
            SessionRequest.a aVar = this.f3740b;
            SessionRequest.this.a(aVar.f3601c, this.f3739a.getConnType().getType(), anet.channel.util.i.a(SessionRequest.this.f3587a.f3578c), (SessionGetCallback) null, 0);
        } catch (Exception unused) {
        }
    }
}
