package com.taobao.accs.net;

import android.content.Intent;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.a.a;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.j;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f13047a;

    public d(a aVar) {
        this.f13047a = aVar;
    }

    public void run() {
        ALog.d(this.f13047a.d(), "startChannelService", new Object[0]);
        Intent intent = new Intent(Constants.ACTION_START_SERVICE);
        intent.putExtra(Constants.KEY_APP_KEY, this.f13047a.i());
        intent.putExtra(Constants.KEY_TTID, this.f13047a.f13025a);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, GlobalClientInfo.getContext().getPackageName());
        intent.putExtra("app_sercet", this.f13047a.f13033i.getAppSecret());
        intent.putExtra(Constants.KEY_MODE, AccsClientConfig.mEnv);
        intent.putExtra(Config.PROPERTY_APP_KEY, Config.a(GlobalClientInfo.getContext()));
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f13047a.f13037m);
        intent.setClassName(GlobalClientInfo.getContext().getPackageName(), j.channelService);
        a.a(GlobalClientInfo.getContext(), intent);
        Intent intent2 = new Intent();
        intent2.setAction(AgooConstants.INTENT_FROM_AGOO_REPORT);
        intent2.setPackage(GlobalClientInfo.getContext().getPackageName());
        String packageName = GlobalClientInfo.getContext().getPackageName();
        GlobalClientInfo.getContext().getPackageName();
        intent2.setClassName(packageName, com.taobao.accs.client.a.b());
        a.a(GlobalClientInfo.getContext(), intent2);
    }
}
