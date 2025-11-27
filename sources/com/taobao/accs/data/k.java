package com.taobao.accs.data;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class k implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgDistributeService f12999a;

    public k(MsgDistributeService msgDistributeService) {
        this.f12999a = msgDistributeService;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
