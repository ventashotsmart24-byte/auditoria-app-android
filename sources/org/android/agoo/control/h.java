package org.android.agoo.control;

import android.content.Intent;

class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f8608a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f8609b;

    public h(g gVar, Intent intent) {
        this.f8609b = gVar;
        this.f8608a = intent;
    }

    public void run() {
        this.f8609b.f8607a.onHandleIntent(this.f8608a);
    }
}
