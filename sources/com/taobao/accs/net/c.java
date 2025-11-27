package com.taobao.accs.net;

import com.taobao.accs.utl.ALog;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f13046a;

    public c(a aVar) {
        this.f13046a = aVar;
    }

    public void run() {
        if (this.f13046a.f13029e.c()) {
            ALog.e(this.f13046a.d(), "receive ping time out! ", new Object[0]);
            g.a(this.f13046a.f13028d).c();
            this.f13046a.a("", false, "receive ping timeout");
            this.f13046a.f13029e.a(-12);
        }
    }
}
