package com.hpplay.component.protocol;

import com.hpplay.component.common.protocol.ProtocolListener;

public class ProtocolInfo {
    private byte[][] protocolData;
    private ProtocolListener protocolListener;

    public byte[][] getProtocolData() {
        return this.protocolData;
    }

    public ProtocolListener getProtocolListener() {
        return this.protocolListener;
    }

    public void setProtocolData(byte[][] bArr) {
        this.protocolData = bArr;
    }

    public void setProtocolListener(ProtocolListener protocolListener2) {
        this.protocolListener = protocolListener2;
    }
}
