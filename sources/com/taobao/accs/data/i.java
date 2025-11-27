package com.taobao.accs.data;

import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.k;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f12994a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f12995b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Intent f12996c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ g f12997d;

    public i(g gVar, String str, String str2, Intent intent) {
        this.f12997d = gVar;
        this.f12994a = str;
        this.f12995b = str2;
        this.f12996c = intent;
    }

    public void run() {
        if (g.f12990a != null && g.f12990a.contains(this.f12994a)) {
            ALog.e("MsgDistribute", "routing msg time out, try election", Constants.KEY_DATA_ID, this.f12994a, Constants.KEY_SERVICE_ID, this.f12995b);
            g.f12990a.remove(this.f12994a);
            k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "timeout", "pkg:" + this.f12996c.getPackage());
        }
    }
}
