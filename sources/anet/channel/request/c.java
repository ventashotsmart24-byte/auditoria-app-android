package anet.channel.request;

import anet.channel.util.ALog;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;

public class c implements Cancelable {
    public static final c NULL = new c((SpdySession) null, 0, (String) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f3820a;

    /* renamed from: b  reason: collision with root package name */
    private final SpdySession f3821b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3822c;

    public c(SpdySession spdySession, int i10, String str) {
        this.f3821b = spdySession;
        this.f3820a = i10;
        this.f3822c = str;
    }

    public void cancel() {
        int i10;
        try {
            if (this.f3821b != null && (i10 = this.f3820a) != 0) {
                ALog.i("awcn.TnetCancelable", "cancel tnet request", this.f3822c, "streamId", Integer.valueOf(i10));
                this.f3821b.streamReset((long) this.f3820a, 5);
            }
        } catch (SpdyErrorException e10) {
            ALog.e("awcn.TnetCancelable", "request cancel failed.", this.f3822c, e10, "errorCode", Integer.valueOf(e10.SpdyErrorGetCode()));
        }
    }
}
