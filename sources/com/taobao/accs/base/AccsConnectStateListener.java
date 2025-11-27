package com.taobao.accs.base;

import androidx.annotation.Keep;
import com.taobao.accs.base.TaoBaseService;

@Keep
public interface AccsConnectStateListener {
    @Keep
    void onConnected(TaoBaseService.ConnectInfo connectInfo);

    @Keep
    void onDisconnected(TaoBaseService.ConnectInfo connectInfo);
}
