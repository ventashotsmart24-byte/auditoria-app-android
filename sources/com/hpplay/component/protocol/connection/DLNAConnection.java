package com.hpplay.component.protocol.connection;

import com.hpplay.component.common.ParamsMap;

public class DLNAConnection extends IConnection {
    public DLNAConnection(ParamsMap paramsMap) {
        super(paramsMap);
    }

    public boolean checkConnection() {
        return this.mProtocolSender.tcpCheckTvState(this.mIp, this.mPort);
    }

    public boolean startConnect() {
        boolean connectServer = this.mProtocolSender.connectServer(this.mTimeout);
        this.mProtocolSender.release();
        return connectServer;
    }
}
