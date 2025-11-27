package com.hpplay.component.common.wifidirect;

import java.nio.ByteBuffer;

public interface IDataTransmitter {
    void closeTransmitter();

    boolean isConnected();

    void sendP2pData(ByteBuffer byteBuffer);
}
