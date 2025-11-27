package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.entity.b;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

public abstract class Session implements Comparable<Session> {

    /* renamed from: v  reason: collision with root package name */
    static ExecutorService f3548v = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: protected */

    /* renamed from: a  reason: collision with root package name */
    public Context f3549a;

    /* renamed from: b  reason: collision with root package name */
    Map<EventCb, Integer> f3550b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    protected String f3551c;
    /* access modifiers changed from: protected */

    /* renamed from: d  reason: collision with root package name */
    public String f3552d;

    /* renamed from: e  reason: collision with root package name */
    protected String f3553e;

    /* renamed from: f  reason: collision with root package name */
    protected String f3554f;

    /* renamed from: g  reason: collision with root package name */
    protected int f3555g;

    /* renamed from: h  reason: collision with root package name */
    protected String f3556h;

    /* renamed from: i  reason: collision with root package name */
    protected int f3557i;

    /* renamed from: j  reason: collision with root package name */
    protected ConnType f3558j;
    /* access modifiers changed from: protected */

    /* renamed from: k  reason: collision with root package name */
    public IConnStrategy f3559k;

    /* renamed from: l  reason: collision with root package name */
    protected String f3560l;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f3561m;

    /* renamed from: n  reason: collision with root package name */
    protected int f3562n;

    /* renamed from: o  reason: collision with root package name */
    protected Runnable f3563o;

    /* renamed from: p  reason: collision with root package name */
    public final String f3564p;

    /* renamed from: q  reason: collision with root package name */
    public final SessionStatistic f3565q;

    /* renamed from: r  reason: collision with root package name */
    protected int f3566r;

    /* renamed from: s  reason: collision with root package name */
    protected int f3567s;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f3568t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f3569u;

    /* renamed from: w  reason: collision with root package name */
    private boolean f3570w;

    /* renamed from: x  reason: collision with root package name */
    private Future<?> f3571x;

    /* renamed from: y  reason: collision with root package name */
    private List<Long> f3572y;

    /* renamed from: z  reason: collision with root package name */
    private long f3573z;

    public static class a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;

        /* renamed from: a  reason: collision with root package name */
        static final String[] f3574a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        public static String a(int i10) {
            return f3574a[i10];
        }
    }

    public Session(Context context, anet.channel.entity.a aVar) {
        boolean z10 = false;
        this.f3570w = false;
        this.f3560l = null;
        this.f3561m = false;
        this.f3562n = 6;
        this.f3568t = false;
        this.f3569u = true;
        this.f3572y = null;
        this.f3573z = 0;
        this.f3549a = context;
        String a10 = aVar.a();
        this.f3553e = a10;
        this.f3554f = a10;
        this.f3555g = aVar.b();
        this.f3558j = aVar.c();
        String f10 = aVar.f();
        this.f3551c = f10;
        this.f3552d = f10.substring(f10.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.f3567s = aVar.e();
        this.f3566r = aVar.d();
        IConnStrategy iConnStrategy = aVar.f3701a;
        this.f3559k = iConnStrategy;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z10 = true;
        }
        this.f3561m = z10;
        this.f3564p = aVar.h();
        SessionStatistic sessionStatistic = new SessionStatistic(aVar);
        this.f3565q = sessionStatistic;
        sessionStatistic.host = this.f3552d;
    }

    public static void configTnetALog(Context context, String str, int i10, int i11) {
        SpdyAgent instance = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (instance == null || !SpdyAgent.checkLoadSucc()) {
            ALog.e("agent null or configTnetALog load so fail!!!", (String) null, "loadso", Boolean.valueOf(SpdyAgent.checkLoadSucc()));
            return;
        }
        instance.configLogFile(str, i10, i11);
    }

    public void cancelTimeout() {
        Future<?> future;
        if (this.f3563o != null && (future = this.f3571x) != null) {
            future.cancel(true);
        }
    }

    public void checkAvailable() {
        ping(true);
    }

    public abstract void close();

    public void close(boolean z10) {
        this.f3568t = z10;
        close();
    }

    public void connect() {
    }

    public IConnStrategy getConnStrategy() {
        return this.f3559k;
    }

    public ConnType getConnType() {
        return this.f3558j;
    }

    public String getHost() {
        return this.f3551c;
    }

    public String getIp() {
        return this.f3553e;
    }

    public int getPort() {
        return this.f3555g;
    }

    public String getRealHost() {
        return this.f3552d;
    }

    public abstract Runnable getRecvTimeOutRunnable();

    public String getUnit() {
        return this.f3560l;
    }

    public void handleCallbacks(int i10, b bVar) {
        f3548v.submit(new b(this, i10, bVar));
    }

    public void handleResponseCode(Request request, int i10) {
        if (request.getHeaders().containsKey(HttpConstant.X_PV) && i10 >= 500 && i10 < 600) {
            synchronized (this) {
                if (this.f3572y == null) {
                    this.f3572y = new LinkedList();
                }
                if (this.f3572y.size() < 5) {
                    this.f3572y.add(Long.valueOf(System.currentTimeMillis()));
                } else {
                    long longValue = this.f3572y.remove(0).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue <= 60000) {
                        StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                        this.f3572y.clear();
                    } else {
                        this.f3572y.add(Long.valueOf(currentTimeMillis));
                    }
                }
            }
        }
    }

    public void handleResponseHeaders(Request request, Map<String, List<String>> map) {
        try {
            if (map.containsKey(HttpConstant.X_SWITCH_UNIT)) {
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.X_SWITCH_UNIT);
                if (TextUtils.isEmpty(singleHeaderFieldByKey)) {
                    singleHeaderFieldByKey = null;
                }
                if (!StringUtils.isStringEqual(this.f3560l, singleHeaderFieldByKey)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f3573z > 60000) {
                        StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                        this.f3573z = currentTimeMillis;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean isAvailable();

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void notifyStatus(int r9, anet.channel.entity.b r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "awcn.Session"
            java.lang.String r1 = "notifyStatus"
            java.lang.String r2 = r8.f3564p     // Catch:{ all -> 0x0068 }
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = "status"
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = anet.channel.Session.a.a(r9)     // Catch:{ all -> 0x0068 }
            r7 = 1
            r4[r7] = r5     // Catch:{ all -> 0x0068 }
            anet.channel.util.ALog.e(r0, r1, r2, r4)     // Catch:{ all -> 0x0068 }
            int r0 = r8.f3562n     // Catch:{ all -> 0x0068 }
            if (r9 != r0) goto L_0x002a
            java.lang.String r9 = "awcn.Session"
            java.lang.String r10 = "ignore notifyStatus"
            java.lang.String r0 = r8.f3564p     // Catch:{ all -> 0x0068 }
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ all -> 0x0068 }
            anet.channel.util.ALog.i(r9, r10, r0, r1)     // Catch:{ all -> 0x0068 }
            monitor-exit(r8)
            return
        L_0x002a:
            r8.f3562n = r9     // Catch:{ all -> 0x0068 }
            if (r9 == 0) goto L_0x0063
            if (r9 == r3) goto L_0x005d
            r0 = 4
            if (r9 == r0) goto L_0x004b
            r0 = 5
            if (r9 == r0) goto L_0x0045
            r0 = 6
            if (r9 == r0) goto L_0x003a
            goto L_0x0066
        L_0x003a:
            r8.onDisconnect()     // Catch:{ all -> 0x0068 }
            boolean r9 = r8.f3570w     // Catch:{ all -> 0x0068 }
            if (r9 != 0) goto L_0x0066
            r8.handleCallbacks(r3, r10)     // Catch:{ all -> 0x0068 }
            goto L_0x0066
        L_0x0045:
            r9 = 1024(0x400, float:1.435E-42)
            r8.handleCallbacks(r9, r10)     // Catch:{ all -> 0x0068 }
            goto L_0x0066
        L_0x004b:
            anet.channel.strategy.IStrategyInstance r9 = anet.channel.strategy.StrategyCenter.getInstance()     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = r8.f3552d     // Catch:{ all -> 0x0068 }
            java.lang.String r9 = r9.getUnitByHost(r0)     // Catch:{ all -> 0x0068 }
            r8.f3560l = r9     // Catch:{ all -> 0x0068 }
            r9 = 512(0x200, float:7.175E-43)
            r8.handleCallbacks(r9, r10)     // Catch:{ all -> 0x0068 }
            goto L_0x0066
        L_0x005d:
            r9 = 256(0x100, float:3.59E-43)
            r8.handleCallbacks(r9, r10)     // Catch:{ all -> 0x0068 }
            goto L_0x0066
        L_0x0063:
            r8.handleCallbacks(r7, r10)     // Catch:{ all -> 0x0068 }
        L_0x0066:
            monitor-exit(r8)
            return
        L_0x0068:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.Session.notifyStatus(int, anet.channel.entity.b):void");
    }

    public void onDisconnect() {
    }

    public void ping(boolean z10) {
    }

    public void registerEventcb(int i10, EventCb eventCb) {
        Map<EventCb, Integer> map = this.f3550b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i10));
        }
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public void sendCustomFrame(int i10, byte[] bArr, int i11) {
    }

    public void setPingTimeout(int i10) {
        if (this.f3563o == null) {
            this.f3563o = getRecvTimeOutRunnable();
        }
        cancelTimeout();
        Runnable runnable = this.f3563o;
        if (runnable != null) {
            this.f3571x = ThreadPoolExecutorFactory.submitScheduledTask(runnable, (long) i10, TimeUnit.MILLISECONDS);
        }
    }

    public String toString() {
        return "Session@[" + this.f3564p + '|' + this.f3558j + ']';
    }

    public void unReceiveEventCb(EventCb eventCb) {
        Map<EventCb, Integer> map = this.f3550b;
        if (map != null) {
            map.remove(eventCb);
        }
    }

    public int compareTo(Session session) {
        return ConnType.compare(this.f3558j, session.f3558j);
    }

    public void ping(boolean z10, int i10) {
    }
}
