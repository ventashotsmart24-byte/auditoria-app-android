package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f12992a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f12993b;

    public h(Context context, Intent intent) {
        this.f12992a = context;
        this.f12993b = intent;
    }

    public void run() {
        g.a().b(this.f12992a, this.f12993b);
    }
}
