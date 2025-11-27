package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Request f3847a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ RequestCb f3848b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ RequestStatistic f3849c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ d f3850d;

    public f(d dVar, Request request, RequestCb requestCb, RequestStatistic requestStatistic) {
        this.f3850d = dVar;
        this.f3847a = request;
        this.f3848b = requestCb;
        this.f3849c = requestStatistic;
    }

    public void run() {
        this.f3847a.f3782a.sendBeforeTime = System.currentTimeMillis() - this.f3847a.f3782a.reqStart;
        b.a(this.f3847a, (RequestCb) new g(this));
    }
}
