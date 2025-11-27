package com.taobao.accs.net;

import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;

class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ConnectInfo f13077a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccsConnectStateListener f13078b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m f13079c;

    public n(m mVar, TaoBaseService.ConnectInfo connectInfo, AccsConnectStateListener accsConnectStateListener) {
        this.f13079c = mVar;
        this.f13077a = connectInfo;
        this.f13078b = accsConnectStateListener;
    }

    public void run() {
        TaoBaseService.ConnectInfo connectInfo = this.f13077a;
        if (connectInfo.connected) {
            this.f13078b.onConnected(connectInfo);
        } else {
            this.f13078b.onDisconnected(connectInfo);
        }
    }
}
