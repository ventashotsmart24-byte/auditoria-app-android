package com.taobao.accs.data;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.t;
import com.taobao.accs.utl.v;

public class MsgDistributeService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f12959a = false;

    /* renamed from: b  reason: collision with root package name */
    private Messenger f12960b = new Messenger(new j(this));

    public IBinder onBind(Intent intent) {
        if (t.b() && v.a(this) && !f12959a) {
            f12959a = true;
            try {
                getApplicationContext().bindService(new Intent(this, getClass()), new k(this), 1);
            } catch (Throwable th) {
                ALog.e("MsgDistributeService", "bindService", th, new Object[0]);
                f12959a = false;
            }
        }
        return this.f12960b.getBinder();
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        try {
            ALog.i("MsgDistributeService", "onStartCommand", "action", intent.getAction());
            if (TextUtils.isEmpty(intent.getAction()) || !TextUtils.equals(intent.getAction(), Constants.ACTION_SEND)) {
                ALog.i("MsgDistributeService", "onStartCommand distribute message", new Object[0]);
                intent.setFlags(0);
                g.a(getApplicationContext(), intent);
            } else {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(new l(this, intent));
            }
        } catch (Throwable th) {
            ALog.e("MsgDistributeService", "onStartCommand", th, new Object[0]);
        }
        return 2;
    }
}
