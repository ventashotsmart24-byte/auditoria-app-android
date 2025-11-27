package org.android.agoo.control;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class i implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseIntentService f8610a;

    public i(BaseIntentService baseIntentService) {
        this.f8610a = baseIntentService;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
