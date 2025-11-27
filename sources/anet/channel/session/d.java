package anet.channel.session;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.entity.a;
import anet.channel.entity.b;
import anet.channel.request.Request;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import anet.channel.util.c;
import anet.channel.util.j;
import com.taobao.accs.common.Constants;
import javax.net.ssl.SSLSocketFactory;

public class d extends Session {

    /* renamed from: w  reason: collision with root package name */
    private SSLSocketFactory f3844w;

    public d(Context context, a aVar) {
        super(context, aVar);
        ConnType connType;
        if (this.f3559k == null) {
            String str = this.f3551c;
            if (str == null || !str.startsWith("https")) {
                connType = ConnType.HTTP;
            } else {
                connType = ConnType.HTTPS;
            }
            this.f3558j = connType;
        } else if (AwcnConfig.isHttpsSniEnable() && this.f3558j.equals(ConnType.HTTPS)) {
            this.f3844w = new j(this.f3552d);
        }
    }

    public void close() {
        notifyStatus(6, (b) null);
    }

    public void connect() {
        try {
            IConnStrategy iConnStrategy = this.f3559k;
            if (iConnStrategy == null || iConnStrategy.getIpSource() != 1) {
                Request.Builder redirectEnable = new Request.Builder().setUrl(this.f3551c).setSeq(this.f3564p).setConnectTimeout((int) (((float) this.f3566r) * Utils.getNetworkTimeFactor())).setReadTimeout((int) (((float) this.f3567s) * Utils.getNetworkTimeFactor())).setRedirectEnable(false);
                SSLSocketFactory sSLSocketFactory = this.f3844w;
                if (sSLSocketFactory != null) {
                    redirectEnable.setSslSocketFactory(sSLSocketFactory);
                }
                if (this.f3561m) {
                    redirectEnable.addHeader("Host", this.f3553e);
                }
                if (c.a() && anet.channel.strategy.utils.d.a(this.f3553e)) {
                    try {
                        this.f3554f = c.a(this.f3553e);
                    } catch (Exception unused) {
                    }
                }
                ALog.i("awcn.HttpSession", "HttpSession connect", (String) null, Constants.KEY_HOST, this.f3551c, "ip", this.f3554f, "port", Integer.valueOf(this.f3555g));
                Request build = redirectEnable.build();
                build.setDnsOptimize(this.f3554f, this.f3555g);
                ThreadPoolExecutorFactory.submitPriorityTask(new e(this, build), ThreadPoolExecutorFactory.Priority.LOW);
                return;
            }
            notifyStatus(4, new b(1));
        } catch (Throwable th) {
            ALog.e("awcn.HttpSession", "HTTP connect fail.", (String) null, th, new Object[0]);
        }
    }

    public Runnable getRecvTimeOutRunnable() {
        return null;
    }

    public boolean isAvailable() {
        if (this.f3562n == 4) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:9|10|(1:14)|15|(2:(1:18)|19)|(1:21)|22|(2:24|(2:28|29))|30|31|(1:33)(1:34)|35|36|43) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0073 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087 A[Catch:{ all -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097 A[Catch:{ all -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public anet.channel.request.Cancelable request(anet.channel.request.Request r9, anet.channel.RequestCb r10) {
        /*
            r8 = this;
            anet.channel.request.b r0 = anet.channel.request.b.NULL
            r1 = 0
            if (r9 == 0) goto L_0x0008
            anet.channel.statist.RequestStatistic r2 = r9.f3782a
            goto L_0x000f
        L_0x0008:
            anet.channel.statist.RequestStatistic r2 = new anet.channel.statist.RequestStatistic
            java.lang.String r3 = r8.f3552d
            r2.<init>(r3, r1)
        L_0x000f:
            anet.channel.entity.ConnType r3 = r8.f3558j
            r2.setConnType(r3)
            long r3 = r2.start
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0024
            long r3 = java.lang.System.currentTimeMillis()
            r2.reqStart = r3
            r2.start = r3
        L_0x0024:
            if (r9 == 0) goto L_0x00ca
            if (r10 != 0) goto L_0x002a
            goto L_0x00ca
        L_0x002a:
            javax.net.ssl.SSLSocketFactory r3 = r9.getSslSocketFactory()     // Catch:{ all -> 0x00bb }
            if (r3 != 0) goto L_0x003e
            javax.net.ssl.SSLSocketFactory r3 = r8.f3844w     // Catch:{ all -> 0x00bb }
            if (r3 == 0) goto L_0x003e
            anet.channel.request.Request$Builder r1 = r9.newBuilder()     // Catch:{ all -> 0x00bb }
            javax.net.ssl.SSLSocketFactory r3 = r8.f3844w     // Catch:{ all -> 0x00bb }
            anet.channel.request.Request$Builder r1 = r1.setSslSocketFactory(r3)     // Catch:{ all -> 0x00bb }
        L_0x003e:
            boolean r3 = r8.f3561m     // Catch:{ all -> 0x00bb }
            if (r3 == 0) goto L_0x004f
            if (r1 != 0) goto L_0x0048
            anet.channel.request.Request$Builder r1 = r9.newBuilder()     // Catch:{ all -> 0x00bb }
        L_0x0048:
            java.lang.String r3 = "Host"
            java.lang.String r4 = r8.f3553e     // Catch:{ all -> 0x00bb }
            r1.addHeader(r3, r4)     // Catch:{ all -> 0x00bb }
        L_0x004f:
            if (r1 == 0) goto L_0x0055
            anet.channel.request.Request r9 = r1.build()     // Catch:{ all -> 0x00bb }
        L_0x0055:
            java.lang.String r1 = r8.f3554f     // Catch:{ all -> 0x00bb }
            if (r1 != 0) goto L_0x0073
            anet.channel.util.HttpUrl r1 = r9.getHttpUrl()     // Catch:{ all -> 0x00bb }
            java.lang.String r1 = r1.host()     // Catch:{ all -> 0x00bb }
            boolean r3 = anet.channel.util.c.a()     // Catch:{ all -> 0x00bb }
            if (r3 == 0) goto L_0x0073
            boolean r3 = anet.channel.strategy.utils.d.a((java.lang.String) r1)     // Catch:{ all -> 0x00bb }
            if (r3 == 0) goto L_0x0073
            java.lang.String r1 = anet.channel.util.c.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0073 }
            r8.f3554f = r1     // Catch:{ Exception -> 0x0073 }
        L_0x0073:
            java.lang.String r1 = r8.f3554f     // Catch:{ all -> 0x00bb }
            int r3 = r8.f3555g     // Catch:{ all -> 0x00bb }
            r9.setDnsOptimize(r1, r3)     // Catch:{ all -> 0x00bb }
            anet.channel.entity.ConnType r1 = r8.f3558j     // Catch:{ all -> 0x00bb }
            boolean r1 = r1.isSSL()     // Catch:{ all -> 0x00bb }
            r9.setUrlScheme(r1)     // Catch:{ all -> 0x00bb }
            anet.channel.strategy.IConnStrategy r1 = r8.f3559k     // Catch:{ all -> 0x00bb }
            if (r1 == 0) goto L_0x0097
            anet.channel.statist.RequestStatistic r3 = r9.f3782a     // Catch:{ all -> 0x00bb }
            int r1 = r1.getIpSource()     // Catch:{ all -> 0x00bb }
            anet.channel.strategy.IConnStrategy r4 = r8.f3559k     // Catch:{ all -> 0x00bb }
            int r4 = r4.getIpType()     // Catch:{ all -> 0x00bb }
            r3.setIpInfo(r1, r4)     // Catch:{ all -> 0x00bb }
            goto L_0x009d
        L_0x0097:
            anet.channel.statist.RequestStatistic r1 = r9.f3782a     // Catch:{ all -> 0x00bb }
            r3 = 1
            r1.setIpInfo(r3, r3)     // Catch:{ all -> 0x00bb }
        L_0x009d:
            anet.channel.statist.RequestStatistic r1 = r9.f3782a     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = r8.f3560l     // Catch:{ all -> 0x00bb }
            r1.unit = r3     // Catch:{ all -> 0x00bb }
            anet.channel.request.b r1 = new anet.channel.request.b     // Catch:{ all -> 0x00bb }
            anet.channel.session.f r3 = new anet.channel.session.f     // Catch:{ all -> 0x00bb }
            r3.<init>(r8, r9, r10, r2)     // Catch:{ all -> 0x00bb }
            int r4 = anet.channel.util.h.a(r9)     // Catch:{ all -> 0x00bb }
            java.util.concurrent.Future r3 = anet.channel.thread.ThreadPoolExecutorFactory.submitPriorityTask(r3, r4)     // Catch:{ all -> 0x00bb }
            java.lang.String r9 = r9.getSeq()     // Catch:{ all -> 0x00bb }
            r1.<init>(r3, r9)     // Catch:{ all -> 0x00bb }
            r0 = r1
            goto L_0x00c9
        L_0x00bb:
            r9 = move-exception
            java.lang.String r9 = r9.toString()
            r1 = -101(0xffffffffffffff9b, float:NaN)
            java.lang.String r9 = anet.channel.util.ErrorConstant.formatMsg(r1, r9)
            r10.onFinish(r1, r9, r2)
        L_0x00c9:
            return r0
        L_0x00ca:
            if (r10 == 0) goto L_0x00d5
            r9 = -102(0xffffffffffffff9a, float:NaN)
            java.lang.String r1 = anet.channel.util.ErrorConstant.getErrMsg(r9)
            r10.onFinish(r9, r1, r2)
        L_0x00d5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.d.request(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.request.Cancelable");
    }

    public void close(boolean z10) {
        this.f3568t = false;
        close();
    }
}
