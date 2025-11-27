package com.taobao.accs.net;

import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;
import java.util.UUID;

class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f13075a;

    public l(k kVar) {
        this.f13075a = kVar;
    }

    public void run() {
        ALog.d(this.f13075a.d(), "sendAccsHeartbeatMessage", new Object[0]);
        try {
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest((String) null, (String) null, new p.a().a("dataType", "pingreq").a("timeInterval", Long.valueOf(this.f13075a.f13064p)).a().toString().getBytes(XML.CHARSET_UTF8), UUID.randomUUID().toString());
            accsRequest.setTarget("accs-iot");
            accsRequest.setTargetServiceName("sal");
            k kVar = this.f13075a;
            this.f13075a.a(Message.buildRequest(kVar.f13028d, kVar.b((String) null), this.f13075a.d(), this.f13075a.f13033i.getStoreId(), this.f13075a.f13028d.getPackageName(), Constants.TARGET_SERVICE, accsRequest, true), true);
        } catch (Exception e10) {
            ALog.e(this.f13075a.d(), "send accs heartbeat message", e10, new Object[0]);
        }
    }
}
