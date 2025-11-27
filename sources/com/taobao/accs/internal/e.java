package com.taobao.accs.internal;

import android.content.Intent;
import android.os.Process;
import com.taobao.accs.internal.ServiceImpl;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ServiceImpl.AnonymousClass1 f13022a;

    public e(ServiceImpl.AnonymousClass1 r12) {
        this.f13022a = r12;
    }

    public void run() {
        try {
            if (ServiceImpl.this.f13011c == null || !UtilityImpl.e(ServiceImpl.this.f13011c)) {
                Process.killProcess(Process.myPid());
            } else {
                Intent intent = new Intent();
                intent.setAction("org.agoo.android.intent.action.PING_V4");
                intent.setClassName(ServiceImpl.this.f13011c.getPackageName(), j.channelService);
                ServiceImpl.this.f13011c.startService(intent);
                UTMini.getInstance().commitEvent(66001, "probeServiceEnabled", UtilityImpl.j(ServiceImpl.this.f13011c));
                ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao........mContext.startService(intent) [probe][successfully]", new Object[0]);
            }
            ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao........messageServiceBinder [probe][end]", new Object[0]);
        } catch (Throwable th) {
            ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao error........e=" + th, new Object[0]);
        }
    }
}
