package com.taobao.accs;

import androidx.annotation.Keep;

public interface IAgooAppReceiver extends IAppReceiverV1 {
    @Keep
    String getAppkey();
}
