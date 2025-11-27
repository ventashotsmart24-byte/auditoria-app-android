package com.taobao.accs.net;

import anet.channel.session.TnetSpdySession;
import com.hpplay.cybergarage.upnp.Service;
import com.taobao.accs.ut.a.d;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13086a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ byte[] f13087b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f13088c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ k f13089d;

    public r(k kVar, int i10, byte[] bArr, TnetSpdySession tnetSpdySession) {
        this.f13089d = kVar;
        this.f13086a = i10;
        this.f13087b = bArr;
        this.f13088c = tnetSpdySession;
    }

    public void run() {
        String str;
        if (this.f13086a == 200) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.f13089d.f13029e.a(this.f13087b, this.f13088c.getHost());
                d g10 = this.f13089d.f13029e.g();
                if (g10 != null) {
                    g10.f13145c = String.valueOf(currentTimeMillis);
                    if (this.f13089d.f13027c == 0) {
                        str = Service.ELEM_NAME;
                    } else {
                        str = "inapp";
                    }
                    g10.f13149g = str;
                    g10.a();
                }
            } catch (Throwable th) {
                ALog.e(this.f13089d.d(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.a(th));
            }
        } else {
            String d10 = this.f13089d.d();
            ALog.e(d10, "drop frame len:" + this.f13087b.length + " frameType" + this.f13086a, new Object[0]);
        }
    }
}
