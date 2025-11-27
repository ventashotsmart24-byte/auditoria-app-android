package com.taobao.accs.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;

final class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f12884a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f12885b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Context f12886c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ int f12887d;

    public b(Intent intent, Context context, Context context2, int i10) {
        this.f12884a = intent;
        this.f12885b = context;
        this.f12886c = context2;
        this.f12887d = i10;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d(a.TAG, "bindService connected", "componentName", componentName.toString());
        try {
            Messenger messenger = new Messenger(iBinder);
            Message message = new Message();
            message.getData().putParcelable("intent", this.f12884a);
            messenger.send(message);
            try {
                this.f12885b.unbindService(this);
            } catch (Throwable unused) {
            }
            if (!this.f12886c.getPackageName().equals(componentName.getPackageName())) {
                return;
            }
        } catch (Throwable unused2) {
        }
        k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName());
        if (!this.f12886c.getPackageName().equals(componentName.getPackageName())) {
            return;
        }
        k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName());
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d(a.TAG, "bindService on disconnect", "componentName", componentName.toString());
        try {
            this.f12885b.unbindService(this);
        } catch (Throwable unused) {
        }
        if (this.f12886c.getPackageName().equals(componentName.getPackageName())) {
            k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName(), UtilityImpl.a(this.f12887d - 3), "onServiceDisconnected");
        }
    }
}
