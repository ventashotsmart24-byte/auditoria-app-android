package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccsDataListener f13216a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13217b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f13218c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f13219d;

    public h(AccsDataListener accsDataListener, String str, boolean z10, boolean z11) {
        this.f13216a = accsDataListener;
        this.f13217b = str;
        this.f13218c = z10;
        this.f13219d = z11;
    }

    public void run() {
        this.f13216a.onConnected(new TaoBaseService.ConnectInfo(this.f13217b, this.f13218c, this.f13219d));
    }
}
