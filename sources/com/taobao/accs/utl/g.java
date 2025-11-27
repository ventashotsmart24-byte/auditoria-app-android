package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccsDataListener f13214a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f13215b;

    public g(AccsDataListener accsDataListener, boolean z10) {
        this.f13214a = accsDataListener;
        this.f13215b = z10;
    }

    public void run() {
        this.f13214a.onAntiBrush(this.f13215b, (TaoBaseService.ExtraInfo) null);
    }
}
