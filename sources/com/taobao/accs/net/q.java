package com.taobao.accs.net;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.taobao.accs.utl.ALog;

class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f13085a;

    public q(k kVar) {
        this.f13085a = kVar;
    }

    public void run() {
        if (this.f13085a.f13031g) {
            try {
                Session session = SessionCenter.getInstance(this.f13085a.f13033i.getAppKey()).get(this.f13085a.b((String) null), ConnType.TypeLevel.SPDY, 0);
                if (session != null) {
                    ALog.e(this.f13085a.d(), "try session ping", new Object[0]);
                    int pingTimeout = this.f13085a.f13033i.getPingTimeout();
                    if (pingTimeout > 0) {
                        session.ping(true, pingTimeout);
                    } else {
                        session.ping(true);
                    }
                }
            } catch (Exception e10) {
                ALog.e(this.f13085a.d(), "ping error", e10, new Object[0]);
            }
        }
    }
}
