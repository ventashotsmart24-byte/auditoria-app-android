package anet.channel;

import anet.channel.session.TnetSpdySession;

public interface DataFrameCb {
    void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i10, int i11);

    void onException(int i10, int i11, boolean z10, String str);
}
