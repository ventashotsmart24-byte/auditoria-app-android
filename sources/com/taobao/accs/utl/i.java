package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccsDataListener f13220a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13221b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f13222c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f13223d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ int f13224e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f13225f;

    public i(AccsDataListener accsDataListener, String str, boolean z10, boolean z11, int i10, String str2) {
        this.f13220a = accsDataListener;
        this.f13221b = str;
        this.f13222c = z10;
        this.f13223d = z11;
        this.f13224e = i10;
        this.f13225f = str2;
    }

    public void run() {
        this.f13220a.onDisconnected(new TaoBaseService.ConnectInfo(this.f13221b, this.f13222c, this.f13223d, this.f13224e, this.f13225f));
    }
}
