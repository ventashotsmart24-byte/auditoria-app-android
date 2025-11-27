package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13082a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f13083b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ k f13084c;

    public p(k kVar, String str, boolean z10) {
        this.f13084c = kVar;
        this.f13082a = str;
        this.f13083b = z10;
    }

    public void run() {
        Message a10 = this.f13084c.f13029e.a(this.f13082a);
        if (a10 != null) {
            this.f13084c.f13029e.a(a10, -9);
            this.f13084c.a(this.f13082a, this.f13083b, "receive data time out");
            String d10 = this.f13084c.d();
            ALog.e(d10, this.f13082a + "-> receive data time out!", new Object[0]);
        }
    }
}
