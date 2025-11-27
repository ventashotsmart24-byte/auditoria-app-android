package com.taobao.accs.client;

import com.taobao.accs.utl.UtilityImpl;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GlobalClientInfo f12928a;

    public c(GlobalClientInfo globalClientInfo) {
        this.f12928a = globalClientInfo;
    }

    public void run() {
        GlobalClientInfo.f12901c = UtilityImpl.m(GlobalClientInfo.f12899a);
    }
}
