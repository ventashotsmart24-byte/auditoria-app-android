package com.taobao.accs.net;

class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13117a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ v f13118b;

    public y(v vVar, String str) {
        this.f13118b = vVar;
        this.f13117a = str;
    }

    public void run() {
        String str = this.f13117a;
        if (str != null && str.equals(this.f13118b.O) && this.f13118b.f13102t == 2) {
            boolean unused = this.f13118b.K = false;
            boolean unused2 = this.f13118b.M = true;
            this.f13118b.o();
            this.f13118b.I.setCloseReason("conn timeout");
        }
    }
}
