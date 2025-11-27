package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;

final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccsDataListener f13190a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13191b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f13192c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Intent f13193d;

    public c(AccsDataListener accsDataListener, String str, int i10, Intent intent) {
        this.f13190a = accsDataListener;
        this.f13191b = str;
        this.f13192c = i10;
        this.f13193d = intent;
    }

    public void run() {
        this.f13190a.onUnbind(this.f13191b, this.f13192c, a.c(this.f13193d));
    }
}
