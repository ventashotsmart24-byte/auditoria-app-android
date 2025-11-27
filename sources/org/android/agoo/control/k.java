package org.android.agoo.control;

import android.content.Intent;

class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f8612a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BaseIntentService f8613b;

    public k(BaseIntentService baseIntentService, Intent intent) {
        this.f8613b = baseIntentService;
        this.f8612a = intent;
    }

    public void run() {
        this.f8613b.onHandleIntent(this.f8612a);
    }
}
