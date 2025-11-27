package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.entity.b;
import anet.channel.request.Request;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Request f3845a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f3846b;

    public e(d dVar, Request request) {
        this.f3846b = dVar;
        this.f3845a = request;
    }

    public void run() {
        int i10 = b.a(this.f3845a, (RequestCb) null).f3838a;
        if (i10 > 0) {
            this.f3846b.notifyStatus(4, new b(1));
        } else {
            this.f3846b.handleCallbacks(256, new b(256, i10, "Http connect fail"));
        }
    }
}
