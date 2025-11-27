package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13043a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f13044b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f13045c;

    public b(a aVar, String str, boolean z10) {
        this.f13045c = aVar;
        this.f13043a = str;
        this.f13044b = z10;
    }

    public void run() {
        Message a10 = this.f13045c.f13029e.a(this.f13043a);
        if (a10 != null) {
            this.f13045c.f13029e.a(a10, -9);
            this.f13045c.a(this.f13043a, this.f13044b, "receive data time out");
            String d10 = this.f13045c.d();
            ALog.e(d10, this.f13043a + "-> receive data time out!", new Object[0]);
        }
    }
}
