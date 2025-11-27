package com.taobao.accs.internal;

import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.l;

class a implements l.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ACCSManagerImpl f13015a;

    public a(ACCSManagerImpl aCCSManagerImpl) {
        this.f13015a = aCCSManagerImpl;
    }

    public void a() {
        try {
            ALog.e(ACCSManagerImpl.f13004c, "onForeState", new Object[0]);
            if (AccsClientConfig.getConfigByTag(this.f13015a.f13006b).isForePingEnable()) {
                ACCSManagerImpl aCCSManagerImpl = this.f13015a;
                aCCSManagerImpl.a(aCCSManagerImpl.f13007d);
            }
        } catch (Exception e10) {
            ALog.e(ACCSManagerImpl.f13004c, "onForeState error, Error:", e10, new Object[0]);
        }
    }

    public void b() {
        ALog.e(ACCSManagerImpl.f13004c, "onBackState", new Object[0]);
    }
}
