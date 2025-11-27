package com.taobao.accs.antibrush;

import com.taobao.accs.utl.ALog;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AntiBrush f12888a;

    public a(AntiBrush antiBrush) {
        this.f12888a = antiBrush;
    }

    public void run() {
        ALog.e("AntiBrush", "anti bursh timeout", new Object[0]);
        AntiBrush.onResult(this.f12888a.mContext, false);
    }
}
