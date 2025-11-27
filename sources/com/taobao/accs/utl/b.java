package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccsDataListener f13186a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13187b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f13188c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Intent f13189d;

    public b(AccsDataListener accsDataListener, String str, int i10, Intent intent) {
        this.f13186a = accsDataListener;
        this.f13187b = str;
        this.f13188c = i10;
        this.f13189d = intent;
    }

    public void run() {
        this.f13186a.onBind(this.f13187b, this.f13188c, a.c(this.f13189d));
    }
}
