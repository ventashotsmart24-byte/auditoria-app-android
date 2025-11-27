package com.taobao.accs.net;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;

class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f13094a;

    public t(k kVar) {
        this.f13094a = kVar;
    }

    public void run() {
        try {
            k kVar = this.f13094a;
            if (kVar.f13028d != null && !TextUtils.isEmpty(kVar.i())) {
                ALog.i(this.f13094a.d(), "mTryStartServiceRunable bindapp", new Object[0]);
                this.f13094a.k();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
