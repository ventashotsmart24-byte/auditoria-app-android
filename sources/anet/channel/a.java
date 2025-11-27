package anet.channel;

import android.content.Intent;
import anet.channel.util.ALog;
import java.util.Iterator;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f3609a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccsSessionManager f3610b;

    public a(AccsSessionManager accsSessionManager, Intent intent) {
        this.f3610b = accsSessionManager;
        this.f3609a = intent;
    }

    public void run() {
        Iterator it = AccsSessionManager.f3498c.iterator();
        while (it.hasNext()) {
            try {
                ((ISessionListener) it.next()).onConnectionChanged(this.f3609a);
            } catch (Exception e10) {
                ALog.e("awcn.AccsSessionManager", "notifyListener exception.", (String) null, e10, new Object[0]);
            }
        }
    }
}
