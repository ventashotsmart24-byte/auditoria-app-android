package com.hpplay.sdk.source.transceiver;

import com.hpplay.sdk.source.transceiver.bean.RemoteServerBean;

public interface IRemoteServerListener {
    void onServerFailed(int i10);

    void onServerStarted(RemoteServerBean remoteServerBean);
}
