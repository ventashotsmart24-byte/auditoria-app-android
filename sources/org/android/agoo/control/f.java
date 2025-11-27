package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.service.SendMessage;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AgooFactory.a f8606a;

    public f(AgooFactory.a aVar) {
        this.f8606a = aVar;
    }

    public void run() {
        try {
            ALog.d("AgooFactory", "onConnected running tid:" + Thread.currentThread().getId(), new Object[0]);
            this.f8606a.f8587c.doSend(this.f8606a.f8585a);
            ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
            SendMessage unused = this.f8606a.f8587c = null;
            try {
                AgooFactory.mContext.unbindService(this.f8606a.f8588d);
            } catch (Throwable th) {
                ALog.e("AgooFactory", "unbindService error", th, new Object[0]);
            }
        } catch (Throwable th2) {
            ALog.e("AgooFactory", "unbindService error", th2, new Object[0]);
        }
    }
}
