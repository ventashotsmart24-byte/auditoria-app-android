package anet.channel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import anet.channel.util.ALog;

class h implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f3727a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f3728b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SessionRequest f3729c;

    public h(SessionRequest sessionRequest, Intent intent, Context context) {
        this.f3729c = sessionRequest;
        this.f3727a = intent;
        this.f3728b = context;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d("awcn.SessionRequest", "onServiceConnected", (String) null, new Object[0]);
        try {
            Messenger messenger = new Messenger(iBinder);
            Message message = new Message();
            message.getData().putParcelable("intent", this.f3727a);
            messenger.send(message);
            try {
                this.f3728b.unbindService(this);
            } catch (Throwable th) {
                ALog.e("awcn.SessionRequest", "onServiceConnected unbindService error.", (String) null, th, new Object[0]);
            }
        } catch (Throwable th2) {
            ALog.e("awcn.SessionRequest", "onServiceConnected unbindService error.", (String) null, th2, new Object[0]);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d("awcn.SessionRequest", "onServiceDisconnected", (String) null, new Object[0]);
        try {
            this.f3728b.unbindService(this);
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "onServiceDisconnected unbindService error.", (String) null, th, new Object[0]);
        }
    }
}
