package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f12989a;

    public f(d dVar) {
        this.f12989a = dVar;
    }

    public void run() {
        TrafficsMonitor trafficsMonitor = this.f12989a.f12973c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a();
        }
    }
}
