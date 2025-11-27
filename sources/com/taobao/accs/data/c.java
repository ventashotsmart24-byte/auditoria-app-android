package com.taobao.accs.data;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f12970a;

    public c(a aVar) {
        this.f12970a = aVar;
    }

    public void run() {
        synchronized (this.f12970a) {
            if (this.f12970a.f12966f == 0) {
                ALog.e("AssembleMessage", "timeout", Constants.KEY_DATA_ID, this.f12970a.f12962b);
                int unused = this.f12970a.f12966f = 1;
                this.f12970a.f12968h.clear();
                AppMonitor.getInstance().commitStat(new AssembleMonitor(this.f12970a.f12962b, String.valueOf(this.f12970a.f12966f)));
            }
        }
    }
}
