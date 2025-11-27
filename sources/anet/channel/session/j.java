package anet.channel.session;

import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SpdyProtocol;

class j implements AccsSSLCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f3854a;

    public j(TnetSpdySession tnetSpdySession) {
        this.f3854a = tnetSpdySession;
    }

    public byte[] getSSLPublicKey(int i10, byte[] bArr) {
        byte[] bArr2;
        try {
            TnetSpdySession tnetSpdySession = this.f3854a;
            bArr2 = tnetSpdySession.G.decrypt(tnetSpdySession.f3549a, ISecurity.CIPHER_ALGORITHM_AES128, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
            if (bArr2 != null) {
                try {
                    if (ALog.isPrintLog(2)) {
                        ALog.i("getSSLPublicKey", (String) null, "decrypt", new String(bArr2));
                    }
                } catch (Throwable th) {
                    th = th;
                    ALog.e("awcn.TnetSpdySession", "getSSLPublicKey", (String) null, th, new Object[0]);
                    return bArr2;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bArr2 = null;
            ALog.e("awcn.TnetSpdySession", "getSSLPublicKey", (String) null, th, new Object[0]);
            return bArr2;
        }
        return bArr2;
    }
}
