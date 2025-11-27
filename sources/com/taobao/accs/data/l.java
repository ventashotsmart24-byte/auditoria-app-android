package com.taobao.accs.data;

import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f13000a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MsgDistributeService f13001b;

    public l(MsgDistributeService msgDistributeService, Intent intent) {
        this.f13001b = msgDistributeService;
        this.f13000a = intent;
    }

    public void run() {
        ALog.i("MsgDistributeService", "onStartCommand send message", new Object[0]);
        ACCSManager.AccsRequest accsRequest = (ACCSManager.AccsRequest) this.f13000a.getSerializableExtra(Constants.KEY_SEND_REQDATA);
        String stringExtra = this.f13000a.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = this.f13000a.getStringExtra(Constants.KEY_APP_KEY);
        String stringExtra3 = this.f13000a.getStringExtra(Constants.KEY_CONFIG_TAG);
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = stringExtra2;
        }
        ACCSManager.getAccsInstance(this.f13001b.getApplicationContext(), stringExtra2, stringExtra3).a(this.f13001b.getApplicationContext(), accsRequest, stringExtra, false);
    }
}
