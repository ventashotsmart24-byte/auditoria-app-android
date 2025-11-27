package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TrafficsMonitor.a f12987a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f12988b;

    public e(d dVar, TrafficsMonitor.a aVar) {
        this.f12988b = dVar;
        this.f12987a = aVar;
    }

    public void run() {
        TrafficsMonitor trafficsMonitor = this.f12988b.f12973c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a(this.f12987a);
        }
    }
}
