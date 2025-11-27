package com.taobao.accs;

import androidx.annotation.Keep;

public interface IAppReceiverV1 extends IAppReceiver {
    @Keep
    void onBindApp(int i10, String str);
}
