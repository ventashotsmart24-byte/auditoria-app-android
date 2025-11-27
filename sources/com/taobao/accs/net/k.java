package com.taobao.accs.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.ISessionListener;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionInfo;
import anet.channel.entity.ConnType;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.a.c;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.t;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class k extends a implements DataFrameCb {

    /* renamed from: o  reason: collision with root package name */
    private boolean f13063o = true;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public long f13064p = 3600000;

    /* renamed from: q  reason: collision with root package name */
    private ScheduledFuture f13065q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public Handler f13066r = new Handler(Looper.getMainLooper());

    /* renamed from: s  reason: collision with root package name */
    private Runnable f13067s = new l(this);

    /* renamed from: t  reason: collision with root package name */
    private ISessionListener f13068t = new m(this);

    /* renamed from: u  reason: collision with root package name */
    private Runnable f13069u = new t(this);

    /* renamed from: v  reason: collision with root package name */
    private Set<String> f13070v = Collections.synchronizedSet(new HashSet());

    public static class a implements IAuth {

        /* renamed from: a  reason: collision with root package name */
        private String f13071a;

        /* renamed from: b  reason: collision with root package name */
        private int f13072b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f13073c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public a f13074d;

        public a(a aVar, String str) {
            this.f13073c = aVar.d();
            this.f13071a = aVar.c("https://" + str + "/accs/");
            this.f13072b = aVar.f13027c;
            this.f13074d = aVar;
        }

        public void auth(Session session, IAuth.AuthCallback authCallback) {
            ALog.e(this.f13073c, BaseMonitor.ALARM_POINT_AUTH, "URL", this.f13071a);
            session.request(new Request.Builder().setUrl(this.f13071a).build(), new u(this, authCallback));
        }
    }

    public k(Context context, int i10, String str) {
        super(context, i10, str);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f13069u, 120000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public void o() {
        if (this.f13033i.isAccsHeartbeatEnable()) {
            ALog.e(d(), "startAccsHeartBeat", new Object[0]);
            ScheduledFuture scheduledFuture = this.f13065q;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
            Runnable runnable = this.f13067s;
            long j10 = this.f13064p;
            this.f13065q = scheduledExecutor.scheduleAtFixedRate(runnable, j10, j10, TimeUnit.MILLISECONDS);
        }
    }

    public c c() {
        return null;
    }

    public String d() {
        return "InAppConn_" + this.f13037m;
    }

    public void e() {
        ALog.e(d(), "shut down", new Object[0]);
        this.f13063o = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m() {
        /*
            r7 = this;
            boolean r0 = r7.f13031g
            r1 = 0
            if (r0 == 0) goto L_0x0046
            com.taobao.accs.AccsClientConfig r0 = r7.f13033i     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = r0.getAppKey()     // Catch:{ all -> 0x0046 }
            anet.channel.SessionCenter r0 = anet.channel.SessionCenter.getInstance((java.lang.String) r0)     // Catch:{ all -> 0x0046 }
            r2 = 0
            java.lang.String r2 = r7.b((java.lang.String) r2)     // Catch:{ all -> 0x0046 }
            anet.channel.entity.ConnType$TypeLevel r3 = anet.channel.entity.ConnType.TypeLevel.SPDY     // Catch:{ all -> 0x0046 }
            r4 = 0
            anet.channel.Session r0 = r0.get((java.lang.String) r2, (anet.channel.entity.ConnType.TypeLevel) r3, (long) r4)     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = "InAppConn_"
            java.lang.String r3 = "isConnected"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0046 }
            java.lang.String r5 = "state"
            r4[r1] = r5     // Catch:{ all -> 0x0046 }
            r5 = 1
            if (r0 == 0) goto L_0x0033
            boolean r6 = r0.isAvailable()     // Catch:{ all -> 0x0046 }
            if (r6 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r6 = 0
            goto L_0x0034
        L_0x0033:
            r6 = 1
        L_0x0034:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0046 }
            r4[r5] = r6     // Catch:{ all -> 0x0046 }
            com.taobao.accs.utl.ALog.e(r2, r3, r4)     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0046
            boolean r0 = r0.isAvailable()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0046
            r1 = 1
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.k.m():boolean");
    }

    public void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i10, int i11) {
        if (ALog.isPrintLog(ALog.Level.E)) {
            ALog.e(d(), "onDataReceive", "type", Integer.valueOf(i11), "dataid", Integer.valueOf(i10));
        }
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new r(this, i11, bArr, tnetSpdySession));
    }

    public void onException(int i10, int i11, boolean z10, String str) {
        String d10 = d();
        ALog.e(d10, "errorId:" + i11 + "detail:" + str + " dataId:" + i10 + " needRetry:" + z10, new Object[0]);
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new s(this, i10, z10, i11));
    }

    public synchronized void a() {
        ALog.d(d(), "start", new Object[0]);
        this.f13063o = true;
        a(this.f13028d);
    }

    public void b() {
        this.f13030f = 0;
    }

    public void c(int i10) {
        super.c(i10);
    }

    public void a(Message message, boolean z10) {
        if (!this.f13063o || message == null) {
            String d10 = d();
            ALog.e(d10, "not running or msg null! " + this.f13063o, new Object[0]);
            return;
        }
        try {
            if (ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size() <= 1000) {
                ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new o(this, message), message.delyTime, TimeUnit.MILLISECONDS);
                if (message.getType() == 1 && message.cunstomDataId != null) {
                    if (message.isControlFrame() && a(message.cunstomDataId)) {
                        this.f13029e.b(message);
                    }
                    this.f13029e.f12971a.put(message.cunstomDataId, schedule);
                }
                NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                if (netPermanceMonitor != null) {
                    netPermanceMonitor.setDeviceId(UtilityImpl.j(this.f13028d));
                    netPermanceMonitor.setConnType(this.f13027c);
                    netPermanceMonitor.onEnterQueueData();
                    return;
                }
                return;
            }
            throw new RejectedExecutionException("accs");
        } catch (RejectedExecutionException unused) {
            this.f13029e.a(message, (int) ErrorCode.MESSAGE_QUEUE_FULL);
            String d11 = d();
            ALog.e(d11, "send queue full count:" + ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size(), new Object[0]);
        } catch (Throwable th) {
            this.f13029e.a(message, -8);
            ALog.e(d(), "send error", th, new Object[0]);
        }
    }

    public k(Context context, int i10, String str, int i11) {
        super(context, i10, str);
        c(i11);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f13069u, 120000, TimeUnit.MILLISECONDS);
    }

    public void a(String str, boolean z10, long j10) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new p(this, str, z10), j10, TimeUnit.MILLISECONDS);
    }

    public void a(boolean z10, boolean z11) {
        ThreadPoolExecutorFactory.getSendScheduledExecutor().execute(new q(this));
    }

    public void a(String str, boolean z10, String str2) {
        Session session;
        try {
            Message b10 = this.f13029e.b(str);
            if (b10 != null && b10.host != null && (session = SessionCenter.getInstance(this.f13033i.getAppKey()).get(b10.host.toString(), 0)) != null) {
                if (z10) {
                    ALog.e(d(), "close session by time out", new Object[0]);
                    session.close(true);
                    return;
                }
                session.ping(true);
            }
        } catch (Exception e10) {
            ALog.e(d(), "onTimeOut", e10, new Object[0]);
        }
    }

    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture scheduledFuture = this.f13029e.f12971a.get(str);
        boolean cancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (cancel) {
            ALog.e(d(), "cancel", "customDataId", str);
        }
        return cancel;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            ALog.e(d(), "onReceiveAccsHeartbeatResp response data is null", new Object[0]);
            return;
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(d(), "onReceiveAccsHeartbeatResp", "data", jSONObject);
        }
        try {
            int i10 = jSONObject.getInt("timeInterval");
            if (i10 == -1) {
                ScheduledFuture scheduledFuture = this.f13065q;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    return;
                }
                return;
            }
            long j10 = (long) (i10 * 1000);
            if (this.f13064p != j10) {
                if (i10 == 0) {
                    j10 = 3600000;
                }
                this.f13064p = j10;
                ScheduledFuture scheduledFuture2 = this.f13065q;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                }
                ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
                Runnable runnable = this.f13067s;
                long j11 = this.f13064p;
                this.f13065q = scheduledExecutor.scheduleAtFixedRate(runnable, j11, j11, TimeUnit.MILLISECONDS);
            }
        } catch (JSONException e10) {
            ALog.e(d(), "onReceiveAccsHeartbeatResp", "e", e10.getMessage());
        }
    }

    public void a(Context context) {
        boolean z10;
        try {
            if (!this.f13031g) {
                super.a(context);
                if (t.c()) {
                    SessionCenter.getInstance(this.f13033i.getAppKey()).registerAccsSessionListener(this.f13068t);
                }
                String inappHost = this.f13033i.getInappHost();
                if (!h() || !this.f13033i.isKeepalive()) {
                    ALog.d(d(), "initAwcn close keepalive", new Object[0]);
                    z10 = false;
                } else {
                    z10 = true;
                }
                a(SessionCenter.getInstance(this.f13033i.getAppKey()), inappHost, z10);
                this.f13031g = true;
                ALog.i(d(), "initAwcn success!", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    public void a(SessionCenter sessionCenter, String str, boolean z10) {
        if (!this.f13070v.contains(str)) {
            sessionCenter.registerSessionInfo(SessionInfo.create(str, z10, true, new a(this, str), (IHeartbeat) null, this));
            sessionCenter.registerPublicKey(str, this.f13033i.getInappPubKey());
            this.f13070v.add(str);
            ALog.i(d(), "registerSessionInfo", Constants.KEY_HOST, str);
        }
    }

    public void a(AccsClientConfig accsClientConfig) {
        if (accsClientConfig == null) {
            ALog.i(d(), "updateConfig null", new Object[0]);
        } else if (accsClientConfig.equals(this.f13033i)) {
            ALog.w(d(), "updateConfig not any changed", new Object[0]);
        } else if (this.f13031g) {
            try {
                boolean z10 = true;
                ALog.w(d(), "updateConfig", "old", this.f13033i, "new", accsClientConfig);
                String inappHost = this.f13033i.getInappHost();
                String inappHost2 = accsClientConfig.getInappHost();
                SessionCenter instance = SessionCenter.getInstance(this.f13033i.getAppKey());
                if (instance == null) {
                    ALog.w(d(), "updateConfig not need update", new Object[0]);
                    return;
                }
                instance.unregisterSessionInfo(inappHost);
                ALog.w(d(), "updateConfig unregisterSessionInfo", Constants.KEY_HOST, inappHost);
                if (this.f13070v.contains(inappHost)) {
                    this.f13070v.remove(inappHost);
                    ALog.w(d(), "updateConfig removeSessionRegistered", "oldHost", inappHost);
                }
                this.f13033i = accsClientConfig;
                this.f13026b = accsClientConfig.getAppKey();
                this.f13037m = this.f13033i.getTag();
                String str = ConnType.PK_ACS;
                if (this.f13033i.getInappPubKey() == 10 || this.f13033i.getInappPubKey() == 11) {
                    str = ConnType.PK_OPEN;
                }
                ALog.i(d(), "update config register new conn protocol host:", this.f13033i.getInappHost());
                StrategyTemplate.getInstance().registerConnProtocol(this.f13033i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
                if (!h() || !this.f13033i.isKeepalive()) {
                    ALog.i(d(), "updateConfig close keepalive", new Object[0]);
                    z10 = false;
                }
                a(instance, inappHost2, z10);
            } catch (Throwable th) {
                ALog.e(d(), "updateConfig", th, new Object[0]);
            }
        } else if (UtilityImpl.isMainProcess(this.f13028d)) {
            this.f13033i = accsClientConfig;
            a(this.f13028d);
        }
    }
}
