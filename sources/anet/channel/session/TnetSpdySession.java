package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.Config;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.SessionInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.entity.b;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.heartbeat.c;
import anet.channel.request.Request;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import com.google.common.primitives.UnsignedBytes;
import com.taobao.accs.common.Constants;
import java.util.List;
import java.util.Map;
import org.android.spdy.SessionCb;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

public class TnetSpdySession extends Session implements SessionCb {
    protected long A = 0;
    protected int B = -1;
    protected DataFrameCb C = null;
    protected IHeartbeat D = null;
    protected IAuth E = null;
    protected String F = null;
    protected ISecurity G = null;
    /* access modifiers changed from: private */
    public int H = 0;
    /* access modifiers changed from: private */
    public boolean I = false;

    /* renamed from: w  reason: collision with root package name */
    protected SpdyAgent f3829w;

    /* renamed from: x  reason: collision with root package name */
    protected SpdySession f3830x;

    /* renamed from: y  reason: collision with root package name */
    protected volatile boolean f3831y = false;

    /* renamed from: z  reason: collision with root package name */
    protected long f3832z;

    public class a extends a {

        /* renamed from: b  reason: collision with root package name */
        private Request f3834b;

        /* renamed from: c  reason: collision with root package name */
        private RequestCb f3835c;

        /* renamed from: d  reason: collision with root package name */
        private int f3836d = 0;

        /* renamed from: e  reason: collision with root package name */
        private long f3837e = 0;

        public a(Request request, RequestCb requestCb) {
            this.f3834b = request;
            this.f3835c = requestCb;
        }

        private void a(SuperviseData superviseData, int i10, String str) {
            try {
                this.f3834b.f3782a.rspEnd = System.currentTimeMillis();
                if (!this.f3834b.f3782a.isDone.get()) {
                    if (i10 > 0) {
                        this.f3834b.f3782a.ret = 1;
                    }
                    this.f3834b.f3782a.statusCode = i10;
                    this.f3834b.f3782a.msg = str;
                    if (superviseData != null) {
                        this.f3834b.f3782a.rspEnd = superviseData.responseEnd;
                        this.f3834b.f3782a.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                        RequestStatistic requestStatistic = this.f3834b.f3782a;
                        requestStatistic.sendDataTime = superviseData.sendEnd - requestStatistic.sendStart;
                        this.f3834b.f3782a.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                        this.f3834b.f3782a.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                        this.f3834b.f3782a.sendDataSize = (long) (superviseData.bodySize + superviseData.compressSize);
                        this.f3834b.f3782a.recDataSize = this.f3837e + ((long) superviseData.recvUncompressSize);
                        this.f3834b.f3782a.reqHeadInflateSize = (long) superviseData.uncompressSize;
                        this.f3834b.f3782a.reqHeadDeflateSize = (long) superviseData.compressSize;
                        this.f3834b.f3782a.reqBodyInflateSize = (long) superviseData.bodySize;
                        this.f3834b.f3782a.reqBodyDeflateSize = (long) superviseData.bodySize;
                        this.f3834b.f3782a.rspHeadDeflateSize = (long) superviseData.recvCompressSize;
                        this.f3834b.f3782a.rspHeadInflateSize = (long) superviseData.recvUncompressSize;
                        this.f3834b.f3782a.rspBodyDeflateSize = (long) superviseData.recvBodySize;
                        this.f3834b.f3782a.rspBodyInflateSize = this.f3837e;
                        if (this.f3834b.f3782a.contentLength == 0) {
                            this.f3834b.f3782a.contentLength = (long) superviseData.originContentLength;
                        }
                        SessionStatistic sessionStatistic = TnetSpdySession.this.f3565q;
                        sessionStatistic.recvSizeCount += (long) (superviseData.recvBodySize + superviseData.recvCompressSize);
                        sessionStatistic.sendSizeCount += (long) (superviseData.bodySize + superviseData.compressSize);
                    }
                }
            } catch (Exception unused) {
            }
        }

        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z10, long j10, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.f3834b.getSeq(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z10));
            }
            this.f3837e += (long) spdyByteArray.getDataLength();
            this.f3834b.f3782a.recDataSize += (long) spdyByteArray.getDataLength();
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.f3835c != null) {
                ByteArray a10 = a.C0060a.f3631a.a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.f3835c.onDataReceive(a10, z10);
            }
            TnetSpdySession.this.handleCallbacks(32, (b) null);
        }

        public void spdyOnStreamResponse(SpdySession spdySession, long j10, Map<String, List<String>> map, Object obj) {
            this.f3834b.f3782a.firstDataTime = System.currentTimeMillis() - this.f3834b.f3782a.sendStart;
            this.f3836d = HttpHelper.parseStatusCode(map);
            int unused = TnetSpdySession.this.H = 0;
            ALog.i("awcn.TnetSpdySession", "", this.f3834b.getSeq(), "statusCode", Integer.valueOf(this.f3836d));
            ALog.i("awcn.TnetSpdySession", "", this.f3834b.getSeq(), "response headers", map);
            RequestCb requestCb = this.f3835c;
            if (requestCb != null) {
                requestCb.onResponseCode(this.f3836d, HttpHelper.cloneMap(map));
            }
            TnetSpdySession.this.handleCallbacks(16, (b) null);
            this.f3834b.f3782a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Encoding");
            this.f3834b.f3782a.contentType = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Type");
            this.f3834b.f3782a.contentLength = (long) HttpHelper.parseContentLength(map);
            this.f3834b.f3782a.serverRT = HttpHelper.parseServerRT(map);
            TnetSpdySession.this.handleResponseCode(this.f3834b, this.f3836d);
            TnetSpdySession.this.handleResponseHeaders(this.f3834b, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        public void spdyStreamCloseCallback(SpdySession spdySession, long j10, int i10, Object obj, SuperviseData superviseData) {
            String str;
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.f3834b.getSeq(), "streamId", Long.valueOf(j10), "errorCode", Integer.valueOf(i10));
            }
            if (i10 != 0) {
                this.f3836d = ErrorConstant.ERROR_TNET_REQUEST_FAIL;
                str = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_REQUEST_FAIL, String.valueOf(i10));
                if (i10 != -2005) {
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, str, this.f3834b.f3782a, (Throwable) null));
                }
                ALog.e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.f3834b.getSeq(), "session", TnetSpdySession.this.f3564p, "status code", Integer.valueOf(i10), "URL", this.f3834b.getHttpUrl().simpleUrlString());
            } else {
                str = HttpConstant.SUCCESS;
            }
            this.f3834b.f3782a.tnetErrorCode = i10;
            a(superviseData, this.f3836d, str);
            RequestCb requestCb = this.f3835c;
            if (requestCb != null) {
                requestCb.onFinish(this.f3836d, str, this.f3834b.f3782a);
            }
            if (i10 == -2004) {
                if (!TnetSpdySession.this.f3831y) {
                    TnetSpdySession.this.ping(true);
                }
                if (TnetSpdySession.e(TnetSpdySession.this) >= 2) {
                    ConnEvent connEvent = new ConnEvent();
                    connEvent.isSuccess = false;
                    connEvent.isAccs = TnetSpdySession.this.I;
                    StrategyCenter.getInstance().notifyConnEvent(TnetSpdySession.this.f3552d, TnetSpdySession.this.f3559k, connEvent);
                    TnetSpdySession.this.close(true);
                }
            }
        }
    }

    public TnetSpdySession(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
    }

    public static /* synthetic */ int e(TnetSpdySession tnetSpdySession) {
        int i10 = tnetSpdySession.H + 1;
        tnetSpdySession.H = i10;
        return i10;
    }

    public void auth() {
        IAuth iAuth = this.E;
        if (iAuth != null) {
            iAuth.auth(this, new i(this));
            return;
        }
        notifyStatus(4, (b) null);
        this.f3565q.ret = 1;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(this);
        }
    }

    public void bioPingRecvCallback(SpdySession spdySession, int i10) {
    }

    public void close() {
        ALog.e("awcn.TnetSpdySession", "force close!", this.f3564p, "session", this);
        notifyStatus(7, (b) null);
        try {
            IHeartbeat iHeartbeat = this.D;
            if (iHeartbeat != null) {
                iHeartbeat.stop();
                this.D = null;
            }
            SpdySession spdySession = this.f3830x;
            if (spdySession != null) {
                spdySession.closeSession();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:5|6|7|(1:9)|10|(2:14|15)|16|17|(2:21|(1:23)(6:24|(1:26)(3:27|(1:29)(1:30)|31)|37|(1:41)|42|(2:44|45)(4:46|(1:48)(1:49)|50|57)))|32|(1:34)(1:35)|36|37|39|41|42|(0)(0)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0030 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e4 A[Catch:{ all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e5 A[Catch:{ all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012e A[Catch:{ all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0143 A[Catch:{ all -> 0x016b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect() {
        /*
            r16 = this;
            r10 = r16
            java.lang.String r11 = "awcn.TnetSpdySession"
            int r0 = r10.f3562n
            r12 = 1
            if (r0 == r12) goto L_0x0178
            if (r0 == 0) goto L_0x0178
            r1 = 4
            if (r0 != r1) goto L_0x0010
            goto L_0x0178
        L_0x0010:
            r13 = 0
            r14 = 2
            r15 = 0
            org.android.spdy.SpdyAgent r0 = r10.f3829w     // Catch:{ all -> 0x016b }
            if (r0 != 0) goto L_0x001a
            r16.a()     // Catch:{ all -> 0x016b }
        L_0x001a:
            boolean r0 = anet.channel.util.c.a()     // Catch:{ all -> 0x016b }
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = r10.f3553e     // Catch:{ all -> 0x016b }
            boolean r0 = anet.channel.strategy.utils.d.a((java.lang.String) r0)     // Catch:{ all -> 0x016b }
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = r10.f3553e     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = anet.channel.util.c.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0030 }
            r10.f3554f = r0     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016b }
            java.lang.String r7 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x016b }
            java.lang.String r0 = "connect"
            java.lang.String r2 = r10.f3564p     // Catch:{ all -> 0x016b }
            r3 = 14
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x016b }
            java.lang.String r4 = "host"
            r3[r15] = r4     // Catch:{ all -> 0x016b }
            java.lang.String r4 = r10.f3551c     // Catch:{ all -> 0x016b }
            r3[r12] = r4     // Catch:{ all -> 0x016b }
            java.lang.String r4 = "ip"
            r3[r14] = r4     // Catch:{ all -> 0x016b }
            java.lang.String r4 = r10.f3554f     // Catch:{ all -> 0x016b }
            r5 = 3
            r3[r5] = r4     // Catch:{ all -> 0x016b }
            java.lang.String r4 = "port"
            r3[r1] = r4     // Catch:{ all -> 0x016b }
            int r1 = r10.f3555g     // Catch:{ all -> 0x016b }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x016b }
            r4 = 5
            r3[r4] = r1     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "sessionId"
            r4 = 6
            r3[r4] = r1     // Catch:{ all -> 0x016b }
            r1 = 7
            r3[r1] = r7     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "SpdyProtocol,"
            r4 = 8
            r3[r4] = r1     // Catch:{ all -> 0x016b }
            anet.channel.entity.ConnType r1 = r10.f3558j     // Catch:{ all -> 0x016b }
            r4 = 9
            r3[r4] = r1     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "proxyIp,"
            r4 = 10
            r3[r4] = r1     // Catch:{ all -> 0x016b }
            java.lang.String r1 = r10.f3556h     // Catch:{ all -> 0x016b }
            r4 = 11
            r3[r4] = r1     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "proxyPort,"
            r4 = 12
            r3[r4] = r1     // Catch:{ all -> 0x016b }
            int r1 = r10.f3557i     // Catch:{ all -> 0x016b }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x016b }
            r4 = 13
            r3[r4] = r1     // Catch:{ all -> 0x016b }
            anet.channel.util.ALog.e(r11, r0, r2, r3)     // Catch:{ all -> 0x016b }
            org.android.spdy.SessionInfo r0 = new org.android.spdy.SessionInfo     // Catch:{ all -> 0x016b }
            java.lang.String r2 = r10.f3554f     // Catch:{ all -> 0x016b }
            int r3 = r10.f3555g     // Catch:{ all -> 0x016b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x016b }
            r1.<init>()     // Catch:{ all -> 0x016b }
            java.lang.String r4 = r10.f3551c     // Catch:{ all -> 0x016b }
            r1.append(r4)     // Catch:{ all -> 0x016b }
            java.lang.String r4 = "_"
            r1.append(r4)     // Catch:{ all -> 0x016b }
            java.lang.String r4 = r10.F     // Catch:{ all -> 0x016b }
            r1.append(r4)     // Catch:{ all -> 0x016b }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x016b }
            java.lang.String r5 = r10.f3556h     // Catch:{ all -> 0x016b }
            int r6 = r10.f3557i     // Catch:{ all -> 0x016b }
            anet.channel.entity.ConnType r1 = r10.f3558j     // Catch:{ all -> 0x016b }
            int r9 = r1.getTnetConType()     // Catch:{ all -> 0x016b }
            r1 = r0
            r8 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x016b }
            int r1 = r10.f3566r     // Catch:{ all -> 0x016b }
            float r1 = (float) r1     // Catch:{ all -> 0x016b }
            float r2 = anet.channel.util.Utils.getNetworkTimeFactor()     // Catch:{ all -> 0x016b }
            float r1 = r1 * r2
            int r1 = (int) r1     // Catch:{ all -> 0x016b }
            r0.setConnectionTimeoutMs(r1)     // Catch:{ all -> 0x016b }
            anet.channel.entity.ConnType r1 = r10.f3558j     // Catch:{ all -> 0x016b }
            boolean r1 = r1.isPublicKeyAuto()     // Catch:{ all -> 0x016b }
            if (r1 != 0) goto L_0x0103
            anet.channel.entity.ConnType r1 = r10.f3558j     // Catch:{ all -> 0x016b }
            boolean r1 = r1.isH2S()     // Catch:{ all -> 0x016b }
            if (r1 != 0) goto L_0x0103
            anet.channel.entity.ConnType r1 = r10.f3558j     // Catch:{ all -> 0x016b }
            boolean r1 = r1.isHTTP3()     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x00e5
            goto L_0x0103
        L_0x00e5:
            int r1 = r10.B     // Catch:{ all -> 0x016b }
            if (r1 < 0) goto L_0x00ed
            r0.setPubKeySeqNum(r1)     // Catch:{ all -> 0x016b }
            goto L_0x010f
        L_0x00ed:
            anet.channel.entity.ConnType r1 = r10.f3558j     // Catch:{ all -> 0x016b }
            anet.channel.security.ISecurity r2 = r10.G     // Catch:{ all -> 0x016b }
            if (r2 == 0) goto L_0x00f8
            boolean r2 = r2.isSecOff()     // Catch:{ all -> 0x016b }
            goto L_0x00f9
        L_0x00f8:
            r2 = 1
        L_0x00f9:
            int r1 = r1.getTnetPublicKey(r2)     // Catch:{ all -> 0x016b }
            r10.B = r1     // Catch:{ all -> 0x016b }
            r0.setPubKeySeqNum(r1)     // Catch:{ all -> 0x016b }
            goto L_0x010f
        L_0x0103:
            boolean r1 = r10.f3561m     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x010a
            java.lang.String r1 = r10.f3553e     // Catch:{ all -> 0x016b }
            goto L_0x010c
        L_0x010a:
            java.lang.String r1 = r10.f3552d     // Catch:{ all -> 0x016b }
        L_0x010c:
            r0.setCertHost(r1)     // Catch:{ all -> 0x016b }
        L_0x010f:
            anet.channel.entity.ConnType r1 = r10.f3558j     // Catch:{ all -> 0x016b }
            boolean r1 = r1.isHTTP3()     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x0120
            int r1 = anet.channel.AwcnConfig.getXquicCongControl()     // Catch:{ all -> 0x016b }
            if (r1 < 0) goto L_0x0120
            r0.setXquicCongControl(r1)     // Catch:{ all -> 0x016b }
        L_0x0120:
            org.android.spdy.SpdyAgent r1 = r10.f3829w     // Catch:{ all -> 0x016b }
            org.android.spdy.SpdySession r0 = r1.createSession(r0)     // Catch:{ all -> 0x016b }
            r10.f3830x = r0     // Catch:{ all -> 0x016b }
            int r0 = r0.getRefCount()     // Catch:{ all -> 0x016b }
            if (r0 <= r12) goto L_0x0143
            java.lang.String r0 = "get session ref count > 1!!!"
            java.lang.String r1 = r10.f3564p     // Catch:{ all -> 0x016b }
            java.lang.Object[] r2 = new java.lang.Object[r15]     // Catch:{ all -> 0x016b }
            anet.channel.util.ALog.e(r11, r0, r1, r2)     // Catch:{ all -> 0x016b }
            anet.channel.entity.b r0 = new anet.channel.entity.b     // Catch:{ all -> 0x016b }
            r0.<init>(r12)     // Catch:{ all -> 0x016b }
            r10.notifyStatus(r15, r0)     // Catch:{ all -> 0x016b }
            r16.auth()     // Catch:{ all -> 0x016b }
            return
        L_0x0143:
            r10.notifyStatus(r12, r13)     // Catch:{ all -> 0x016b }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016b }
            r10.f3832z = r0     // Catch:{ all -> 0x016b }
            anet.channel.statist.SessionStatistic r0 = r10.f3565q     // Catch:{ all -> 0x016b }
            java.lang.String r1 = r10.f3556h     // Catch:{ all -> 0x016b }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x016b }
            if (r1 != 0) goto L_0x0157
            goto L_0x0158
        L_0x0157:
            r12 = 0
        L_0x0158:
            r0.isProxy = r12     // Catch:{ all -> 0x016b }
            anet.channel.statist.SessionStatistic r0 = r10.f3565q     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "false"
            r0.isTunnel = r1     // Catch:{ all -> 0x016b }
            boolean r1 = anet.channel.GlobalAppRuntimeInfo.isAppBackground()     // Catch:{ all -> 0x016b }
            r0.isBackground = r1     // Catch:{ all -> 0x016b }
            r0 = 0
            r10.A = r0     // Catch:{ all -> 0x016b }
            goto L_0x0178
        L_0x016b:
            r0 = move-exception
            r10.notifyStatus(r14, r13)
            java.lang.String r1 = r10.f3564p
            java.lang.Object[] r2 = new java.lang.Object[r15]
            java.lang.String r3 = "connect exception "
            anet.channel.util.ALog.e(r11, r3, r1, r0, r2)
        L_0x0178:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.connect():void");
    }

    public Runnable getRecvTimeOutRunnable() {
        return new h(this);
    }

    public byte[] getSSLMeta(SpdySession spdySession) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            ALog.i("awcn.TnetSpdySession", "get sslticket host is null", (String) null, new Object[0]);
            return null;
        }
        try {
            ISecurity iSecurity = this.G;
            if (iSecurity == null) {
                return null;
            }
            Context context = this.f3549a;
            return iSecurity.getBytes(context, "accs_ssl_key2_" + domain);
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "getSSLMeta", (String) null, th, new Object[0]);
            return null;
        }
    }

    public void initConfig(Config config) {
        if (config != null) {
            this.F = config.getAppkey();
            this.G = config.getSecurity();
        }
    }

    public void initSessionInfo(SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            this.C = sessionInfo.dataFrameCb;
            this.E = sessionInfo.auth;
            if (sessionInfo.isKeepAlive) {
                this.f3565q.isKL = 1;
                this.f3568t = true;
                IHeartbeat iHeartbeat = sessionInfo.heartbeat;
                this.D = iHeartbeat;
                boolean z10 = sessionInfo.isAccs;
                this.I = z10;
                if (iHeartbeat == null) {
                    if (!z10 || AwcnConfig.isAccsSessionCreateForbiddenInBg()) {
                        this.D = HeartbeatManager.getDefaultHeartbeat();
                    } else {
                        this.D = HeartbeatManager.getDefaultBackgroundAccsHeartbeat();
                    }
                }
            }
        }
        if (AwcnConfig.isIdleSessionCloseEnable() && this.D == null) {
            this.D = new c();
        }
    }

    public boolean isAvailable() {
        if (this.f3562n == 4) {
            return true;
        }
        return false;
    }

    public void onDisconnect() {
        this.f3831y = false;
    }

    public void ping(boolean z10) {
        ping(z10, this.f3567s);
    }

    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return -1;
        }
        try {
            ISecurity iSecurity = this.G;
            if (iSecurity == null) {
                return -1;
            }
            Context context = this.f3549a;
            if (iSecurity.saveBytes(context, "accs_ssl_key2_" + domain, bArr)) {
                return 0;
            }
            return -1;
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "putSSLMeta", (String) null, th, new Object[0]);
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0111 A[SYNTHETIC, Splitter:B:36:0x0111] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0123 A[Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x016b A[Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a3 A[Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public anet.channel.request.Cancelable request(anet.channel.request.Request r25, anet.channel.RequestCb r26) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            r2 = r26
            java.lang.String r3 = "Host"
            java.lang.String r4 = "awcn.TnetSpdySession"
            anet.channel.request.c r5 = anet.channel.request.c.NULL
            if (r0 == 0) goto L_0x0011
            anet.channel.statist.RequestStatistic r6 = r0.f3782a
            goto L_0x0019
        L_0x0011:
            anet.channel.statist.RequestStatistic r6 = new anet.channel.statist.RequestStatistic
            java.lang.String r7 = r1.f3552d
            r8 = 0
            r6.<init>(r7, r8)
        L_0x0019:
            anet.channel.entity.ConnType r7 = r1.f3558j
            r6.setConnType(r7)
            long r7 = r6.start
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x002e
            long r7 = java.lang.System.currentTimeMillis()
            r6.reqStart = r7
            r6.start = r7
        L_0x002e:
            java.lang.String r7 = r1.f3554f
            int r8 = r1.f3555g
            r6.setIPAndPort(r7, r8)
            anet.channel.strategy.IConnStrategy r7 = r1.f3559k
            int r7 = r7.getIpSource()
            r6.ipRefer = r7
            anet.channel.strategy.IConnStrategy r7 = r1.f3559k
            int r7 = r7.getIpType()
            r6.ipType = r7
            java.lang.String r7 = r1.f3560l
            r6.unit = r7
            if (r0 == 0) goto L_0x01f8
            if (r2 != 0) goto L_0x004f
            goto L_0x01f8
        L_0x004f:
            r7 = 0
            r8 = 2
            org.android.spdy.SpdySession r9 = r1.f3830x     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            if (r9 == 0) goto L_0x01ad
            int r9 = r1.f3562n     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            if (r9 == 0) goto L_0x005c
            r10 = 4
            if (r9 != r10) goto L_0x01ad
        L_0x005c:
            boolean r9 = r1.f3561m     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            if (r9 == 0) goto L_0x0067
            java.lang.String r9 = r1.f3553e     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            int r10 = r1.f3555g     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r0.setDnsOptimize(r9, r10)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
        L_0x0067:
            anet.channel.entity.ConnType r9 = r1.f3558j     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            boolean r9 = r9.isSSL()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r0.setUrlScheme(r9)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.net.URL r11 = r25.getUrl()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            boolean r9 = anet.channel.util.ALog.isPrintLog(r8)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r15 = ""
            r21 = 1
            if (r9 == 0) goto L_0x00b7
            java.lang.String r9 = r25.getSeq()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r12 = "request URL"
            r10[r7] = r12     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r12 = r11.toString()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r10[r21] = r12     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            anet.channel.util.ALog.i(r4, r15, r9, r10)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r9 = r25.getSeq()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r12 = "request Method"
            r10[r7] = r12     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r12 = r25.getMethod()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r10[r21] = r12     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            anet.channel.util.ALog.i(r4, r15, r9, r10)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r9 = r25.getSeq()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r12 = "request headers"
            r10[r7] = r12     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.util.Map r12 = r25.getHeaders()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r10[r21] = r12     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            anet.channel.util.ALog.i(r4, r15, r9, r10)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
        L_0x00b7:
            java.lang.String r9 = r1.f3556h     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            if (r9 != 0) goto L_0x00eb
            int r9 = r1.f3557i     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            if (r9 > 0) goto L_0x00c4
            goto L_0x00eb
        L_0x00c4:
            org.android.spdy.SpdyRequest r9 = new org.android.spdy.SpdyRequest     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r12 = r11.getHost()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            int r13 = r11.getPort()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r14 = r1.f3556h     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            int r10 = r1.f3557i     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r16 = r25.getMethod()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            org.android.spdy.RequestPriority r17 = org.android.spdy.RequestPriority.DEFAULT_PRIORITY     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r18 = -1
            int r19 = r25.getConnectTimeout()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r20 = 0
            r22 = r10
            r10 = r9
            r23 = r15
            r15 = r22
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            goto L_0x00fe
        L_0x00eb:
            r23 = r15
            org.android.spdy.SpdyRequest r9 = new org.android.spdy.SpdyRequest     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r12 = r25.getMethod()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            org.android.spdy.RequestPriority r13 = org.android.spdy.RequestPriority.DEFAULT_PRIORITY     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r14 = -1
            int r15 = r25.getConnectTimeout()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r10 = r9
            r10.<init>((java.net.URL) r11, (java.lang.String) r12, (org.android.spdy.RequestPriority) r13, (int) r14, (int) r15)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
        L_0x00fe:
            int r10 = r25.getReadTimeout()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r9.setRequestRdTimeoutMs(r10)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.util.Map r10 = r25.getHeaders()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            boolean r11 = r10.containsKey(r3)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r12 = ":host"
            if (r11 != 0) goto L_0x0123
            r9.addHeaders(r10)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            boolean r3 = r1.f3561m     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            if (r3 == 0) goto L_0x011b
            java.lang.String r3 = r1.f3553e     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            goto L_0x011f
        L_0x011b:
            java.lang.String r3 = r25.getHost()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
        L_0x011f:
            r9.addHeader(r12, r3)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            goto L_0x013e
        L_0x0123:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.util.Map r11 = r25.getHeaders()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r10.<init>(r11)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.Object r3 = r10.remove(r3)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            boolean r11 = r1.f3561m     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            if (r11 == 0) goto L_0x0138
            java.lang.String r3 = r1.f3553e     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
        L_0x0138:
            r10.put(r12, r3)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r9.addHeaders(r10)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
        L_0x013e:
            byte[] r3 = r25.getBodyBytes()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            org.android.spdy.SpdyDataProvider r10 = new org.android.spdy.SpdyDataProvider     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r10.<init>((byte[]) r3)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            anet.channel.statist.RequestStatistic r3 = r0.f3782a     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r3.sendStart = r11     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            anet.channel.statist.RequestStatistic r3 = r0.f3782a     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            long r11 = r3.sendStart     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            anet.channel.statist.RequestStatistic r13 = r0.f3782a     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            long r13 = r13.start     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            long r11 = r11 - r13
            r3.processTime = r11     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            org.android.spdy.SpdySession r3 = r1.f3830x     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            anet.channel.session.TnetSpdySession$a r11 = new anet.channel.session.TnetSpdySession$a     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r11.<init>(r0, r2)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            int r3 = r3.submitRequest(r9, r10, r1, r11)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            boolean r9 = anet.channel.util.ALog.isPrintLog(r21)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            if (r9 == 0) goto L_0x0180
            java.lang.String r9 = r25.getSeq()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r11 = "streamId"
            r10[r7] = r11     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r10[r21] = r11     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r11 = r23
            anet.channel.util.ALog.d(r4, r11, r9, r10)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
        L_0x0180:
            anet.channel.request.c r9 = new anet.channel.request.c     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            org.android.spdy.SpdySession r10 = r1.f3830x     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            java.lang.String r0 = r25.getSeq()     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r9.<init>(r10, r3, r0)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            anet.channel.statist.SessionStatistic r0 = r1.f3565q     // Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }
            long r10 = r0.requestCount     // Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }
            r12 = 1
            long r10 = r10 + r12
            r0.requestCount = r10     // Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }
            long r10 = r0.stdRCount     // Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }
            long r10 = r10 + r12
            r0.stdRCount = r10     // Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }
            r1.f3832z = r10     // Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }
            anet.channel.heartbeat.IHeartbeat r0 = r1.D     // Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x01a6
            r0.reSchedule()     // Catch:{ SpdyErrorException -> 0x01aa, Exception -> 0x01a8 }
        L_0x01a6:
            r5 = r9
            goto L_0x01f7
        L_0x01a8:
            r5 = r9
            goto L_0x01b9
        L_0x01aa:
            r0 = move-exception
            r5 = r9
            goto L_0x01c4
        L_0x01ad:
            r3 = -301(0xfffffffffffffed3, float:NaN)
            java.lang.String r9 = anet.channel.util.ErrorConstant.getErrMsg(r3)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            anet.channel.statist.RequestStatistic r0 = r0.f3782a     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            r2.onFinish(r3, r9, r0)     // Catch:{ SpdyErrorException -> 0x01c3, Exception -> 0x01b9 }
            goto L_0x01f7
        L_0x01b9:
            r0 = -101(0xffffffffffffff9b, float:NaN)
            java.lang.String r3 = anet.channel.util.ErrorConstant.getErrMsg(r0)
            r2.onFinish(r0, r3, r6)
            goto L_0x01f7
        L_0x01c3:
            r0 = move-exception
        L_0x01c4:
            int r3 = r0.SpdyErrorGetCode()
            r9 = -1104(0xfffffffffffffbb0, float:NaN)
            if (r3 == r9) goto L_0x01d4
            int r3 = r0.SpdyErrorGetCode()
            r9 = -1103(0xfffffffffffffbb1, float:NaN)
            if (r3 != r9) goto L_0x01e6
        L_0x01d4:
            java.lang.String r3 = r1.f3564p
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r9 = "Send request on closed session!!!"
            anet.channel.util.ALog.e(r4, r9, r3, r7)
            anet.channel.entity.b r3 = new anet.channel.entity.b
            r3.<init>(r8)
            r4 = 6
            r1.notifyStatus(r4, r3)
        L_0x01e6:
            int r0 = r0.SpdyErrorGetCode()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r3 = -300(0xfffffffffffffed4, float:NaN)
            java.lang.String r0 = anet.channel.util.ErrorConstant.formatMsg(r3, r0)
            r2.onFinish(r3, r0, r6)
        L_0x01f7:
            return r5
        L_0x01f8:
            if (r2 == 0) goto L_0x0203
            r0 = -102(0xffffffffffffff9a, float:NaN)
            java.lang.String r3 = anet.channel.util.ErrorConstant.getErrMsg(r0)
            r2.onFinish(r0, r3, r6)
        L_0x0203:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.request(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.request.Cancelable");
    }

    public void sendCustomFrame(int i10, byte[] bArr, int i11) {
        SpdySession spdySession;
        int i12;
        int i13 = i10;
        byte[] bArr2 = bArr;
        try {
            if (this.C != null) {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.f3564p, Constants.KEY_DATA_ID, Integer.valueOf(i10), "type", Integer.valueOf(i11));
                if (this.f3562n != 4 || (spdySession = this.f3830x) == null) {
                    ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.f3564p, "sendCustomFrame con invalid mStatus:" + this.f3562n);
                    a(i10, ErrorConstant.ERROR_SESSION_INVALID, true, "session invalid");
                } else if (bArr2 == null || bArr2.length <= 16384) {
                    if (bArr2 == null) {
                        i12 = 0;
                    } else {
                        i12 = bArr2.length;
                    }
                    spdySession.sendCustomControlFrame(i10, i11, 0, i12, bArr);
                    SessionStatistic sessionStatistic = this.f3565q;
                    sessionStatistic.requestCount++;
                    sessionStatistic.cfRCount++;
                    this.f3832z = System.currentTimeMillis();
                    IHeartbeat iHeartbeat = this.D;
                    if (iHeartbeat != null) {
                        iHeartbeat.reSchedule();
                    }
                } else {
                    a(i10, ErrorConstant.ERROR_DATA_TOO_LARGE, false, (String) null);
                }
            }
        } catch (SpdyErrorException e10) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.f3564p, e10, new Object[0]);
            a(i10, ErrorConstant.ERROR_TNET_EXCEPTION, true, "SpdyErrorException: " + e10.toString());
        } catch (Exception e11) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.f3564p, e11, new Object[0]);
            a(i10, -101, true, e11.toString());
        }
    }

    public void setTnetPublicKey(int i10) {
        this.B = i10;
    }

    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i10, int i11) {
        ALog.e("awcn.TnetSpdySession", "spdyCustomControlFrameFailCallback", this.f3564p, Constants.KEY_DATA_ID, Integer.valueOf(i10));
        a(i10, i11, true, "tnet error");
    }

    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i10, int i11, int i12, int i13, byte[] bArr) {
        ALog.e("awcn.TnetSpdySession", "[spdyCustomControlFrameRecvCallback]", this.f3564p, "len", Integer.valueOf(i13), "frameCb", this.C);
        if (ALog.isPrintLog(1) && i13 < 512) {
            String str = "";
            for (int i14 = 0; i14 < bArr.length; i14++) {
                str = str + Integer.toHexString(bArr[i14] & UnsignedBytes.MAX_VALUE) + " ";
            }
            ALog.e("awcn.TnetSpdySession", (String) null, this.f3564p, "str", str);
        }
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onDataReceive(this, bArr, i10, i11);
        } else {
            ALog.e("awcn.TnetSpdySession", "AccsFrameCb is null", this.f3564p, new Object[0]);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(-105, (String) null, "rt"));
        }
        this.f3565q.inceptCount++;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
    }

    public void spdyPingRecvCallback(SpdySession spdySession, long j10, Object obj) {
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.TnetSpdySession", "ping receive", this.f3564p, "Host", this.f3551c, "id", Long.valueOf(j10));
        }
        if (j10 >= 0) {
            this.f3831y = false;
            this.H = 0;
            IHeartbeat iHeartbeat = this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            handleCallbacks(128, (b) null);
        }
    }

    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i10) {
        ALog.e("awcn.TnetSpdySession", "spdySessionCloseCallback", this.f3564p, " errorCode:", Integer.valueOf(i10));
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.stop();
            this.D = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                ALog.e("awcn.TnetSpdySession", "session clean up failed!", (String) null, e10, new Object[0]);
            }
        }
        if (i10 == -3516) {
            ConnEvent connEvent = new ConnEvent();
            connEvent.isSuccess = false;
            StrategyCenter.getInstance().notifyConnEvent(this.f3552d, this.f3559k, connEvent);
        }
        notifyStatus(6, new b(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.f3565q;
            sessionStatistic.requestCount = (long) superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = (long) superviseConnectInfo.keepalive_period_second;
            try {
                if (this.f3558j.isHTTP3()) {
                    if (spdySession != null) {
                        ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionCloseCallback]", this.f3564p, "connectInfo", spdySession.getConnectInfoOnDisConnected());
                    }
                    this.f3565q.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
                    this.f3565q.retransmissionRate = superviseConnectInfo.retransmissionRate;
                    this.f3565q.lossRate = superviseConnectInfo.lossRate;
                    this.f3565q.tlpCount = superviseConnectInfo.tlpCount;
                    this.f3565q.rtoCount = superviseConnectInfo.rtoCount;
                    this.f3565q.srtt = superviseConnectInfo.srtt;
                }
            } catch (Exception unused) {
            }
        }
        SessionStatistic sessionStatistic2 = this.f3565q;
        if (sessionStatistic2.errorCode == 0) {
            sessionStatistic2.errorCode = (long) i10;
        }
        sessionStatistic2.lastPingInterval = (int) (System.currentTimeMillis() - this.f3832z);
        AppMonitor.getInstance().commitStat(this.f3565q);
        if (d.b(this.f3565q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f3565q));
        }
        AppMonitor.getInstance().commitAlarm(this.f3565q.getAlarmObject());
    }

    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        SessionStatistic sessionStatistic = this.f3565q;
        sessionStatistic.connectionTime = (long) superviseConnectInfo.connectTime;
        sessionStatistic.sslTime = (long) superviseConnectInfo.handshakeTime;
        sessionStatistic.sslCalTime = (long) superviseConnectInfo.doHandshakeTime;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        this.A = System.currentTimeMillis();
        notifyStatus(0, new b(1));
        auth();
        ALog.e("awcn.TnetSpdySession", "spdySessionConnectCB connect", this.f3564p, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime", Integer.valueOf(superviseConnectInfo.handshakeTime));
        if (this.f3558j.isHTTP3()) {
            this.f3565q.scid = superviseConnectInfo.scid;
            this.f3565q.dcid = superviseConnectInfo.dcid;
            this.f3565q.congControlKind = superviseConnectInfo.congControlKind;
            ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionConnectCB]", this.f3564p, "connectInfo", spdySession.getConnectInfoOnConnected());
        }
    }

    public void spdySessionFailedError(SpdySession spdySession, int i10, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                ALog.e("awcn.TnetSpdySession", "[spdySessionFailedError]session clean up failed!", (String) null, e10, new Object[0]);
            }
        }
        notifyStatus(2, new b(256, i10, "tnet connect fail"));
        ALog.e("awcn.TnetSpdySession", (String) null, this.f3564p, " errorId:", Integer.valueOf(i10));
        SessionStatistic sessionStatistic = this.f3565q;
        sessionStatistic.errorCode = (long) i10;
        sessionStatistic.ret = 0;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        AppMonitor.getInstance().commitStat(this.f3565q);
        if (d.b(this.f3565q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f3565q));
        }
        AppMonitor.getInstance().commitAlarm(this.f3565q.getAlarmObject());
    }

    public void ping(boolean z10, int i10) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TnetSpdySession", "ping", this.f3564p, Constants.KEY_HOST, this.f3551c, "thread", Thread.currentThread().getName());
        }
        if (z10) {
            try {
                if (this.f3830x != null) {
                    int i11 = this.f3562n;
                    if (i11 == 0 || i11 == 4) {
                        handleCallbacks(64, (b) null);
                        if (!this.f3831y) {
                            this.f3831y = true;
                            this.f3565q.ppkgCount++;
                            this.f3830x.submitPing();
                            if (ALog.isPrintLog(1)) {
                                ALog.d("awcn.TnetSpdySession", this.f3551c + " submit ping ms:" + (System.currentTimeMillis() - this.f3832z) + " force:" + z10, this.f3564p, new Object[0]);
                            }
                            setPingTimeout(i10);
                            this.f3832z = System.currentTimeMillis();
                            IHeartbeat iHeartbeat = this.D;
                            if (iHeartbeat != null) {
                                iHeartbeat.reSchedule();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                SessionStatistic sessionStatistic = this.f3565q;
                if (sessionStatistic != null) {
                    sessionStatistic.closeReason = "session null";
                }
                ALog.e("awcn.TnetSpdySession", this.f3551c + " session null", this.f3564p, new Object[0]);
                close();
            } catch (SpdyErrorException e10) {
                if (e10.SpdyErrorGetCode() == -1104 || e10.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.f3564p, new Object[0]);
                    notifyStatus(6, new b(2));
                }
                ALog.e("awcn.TnetSpdySession", "ping", this.f3564p, e10, new Object[0]);
            } catch (Exception e11) {
                ALog.e("awcn.TnetSpdySession", "ping", this.f3564p, e11, new Object[0]);
            }
        }
    }

    private void a(int i10, int i11, boolean z10, String str) {
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onException(i10, i11, z10, str);
        }
    }

    private void a() {
        SpdyAgent.enableDebug = false;
        this.f3829w = SpdyAgent.getInstance(this.f3549a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        ISecurity iSecurity = this.G;
        if (iSecurity != null && !iSecurity.isSecOff()) {
            this.f3829w.setAccsSslCallback(new j(this));
        }
        if (!AwcnConfig.isTnetHeaderCacheEnable()) {
            try {
                this.f3829w.getClass().getDeclaredMethod("disableHeaderCache", new Class[0]).invoke(this.f3829w, new Object[0]);
                ALog.i("awcn.TnetSpdySession", "tnet disableHeaderCache", (String) null, new Object[0]);
            } catch (Exception e10) {
                ALog.e("awcn.TnetSpdySession", "tnet disableHeaderCache", (String) null, e10, new Object[0]);
            }
        }
    }
}
