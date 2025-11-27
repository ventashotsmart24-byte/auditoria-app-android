package com.taobao.accs.data;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.utl.ALog;

class j extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgDistributeService f12998a;

    public j(MsgDistributeService msgDistributeService) {
        this.f12998a = msgDistributeService;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            ALog.i("MsgDistributeService", "handleMessage on receive msg", Constant.KEY_MSG, message.toString());
            Intent intent = (Intent) message.getData().getParcelable("intent");
            if (intent != null) {
                ALog.i("MsgDistributeService", "handleMessage get intent success", "intent", intent.toString());
                this.f12998a.onStartCommand(intent, 0, 0);
            }
        }
    }
}
