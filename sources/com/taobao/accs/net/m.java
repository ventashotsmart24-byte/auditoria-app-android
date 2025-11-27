package com.taobao.accs.net;

import android.content.Intent;
import anet.channel.ISessionListener;
import com.hpplay.component.protocol.push.IPushHandler;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Iterator;

class m implements ISessionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f13076a;

    public m(k kVar) {
        this.f13076a = kVar;
    }

    public void onConnectionChanged(Intent intent) {
        TaoBaseService.ConnectInfo connectInfo;
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
            String d10 = this.f13076a.d();
            ALog.e(d10, "onConnectionChanged", "currentHost", "https://" + this.f13076a.f13033i.getInappHost(), "changeHost", stringExtra, IPushHandler.STATE, Boolean.valueOf(booleanExtra));
            if (("https://" + this.f13076a.f13033i.getInappHost()).equals(stringExtra)) {
                g.a(GlobalClientInfo.getContext()).a();
                int intExtra = intent.getIntExtra("errorCode", -1);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                if (!booleanExtra) {
                    new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, intExtra, stringExtra2);
                }
                connectInfo.connected = booleanExtra;
                Iterator<AccsConnectStateListener> it = this.f13076a.n().iterator();
                while (it.hasNext()) {
                    this.f13076a.f13066r.post(new n(this, connectInfo, it.next()));
                }
            }
        }
    }
}
