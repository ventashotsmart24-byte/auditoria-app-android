package anet.channel;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.Config;
import anet.channel.detect.n;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.entity.c;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import anet.channel.util.i;
import com.taobao.accs.common.Constants;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

public class SessionCenter {
    public static final String TAG = "awcn.SessionCenter";

    /* renamed from: a  reason: collision with root package name */
    static Map<Config, SessionCenter> f3575a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static boolean f3576j = false;

    /* renamed from: b  reason: collision with root package name */
    Context f3577b;

    /* renamed from: c  reason: collision with root package name */
    String f3578c;

    /* renamed from: d  reason: collision with root package name */
    Config f3579d;

    /* renamed from: e  reason: collision with root package name */
    final e f3580e = new e();

    /* renamed from: f  reason: collision with root package name */
    final LruCache<String, SessionRequest> f3581f = new LruCache<>(32);

    /* renamed from: g  reason: collision with root package name */
    final c f3582g = new c();

    /* renamed from: h  reason: collision with root package name */
    final AccsSessionManager f3583h;

    /* renamed from: i  reason: collision with root package name */
    final a f3584i;

    private SessionCenter(Config config) {
        a aVar = new a(this, (d) null);
        this.f3584i = aVar;
        this.f3577b = GlobalAppRuntimeInfo.getContext();
        this.f3579d = config;
        this.f3578c = config.getAppkey();
        aVar.a();
        this.f3583h = new AccsSessionManager(this);
        if (!config.getAppkey().equals("[default]")) {
            AmdcRuntimeInfo.setSign(new d(this, config.getAppkey(), config.getSecurity()));
        }
    }

    public static void checkAndStartAccsSession() {
        for (SessionCenter sessionCenter : f3575a.values()) {
            sessionCenter.f3583h.checkAndStartSession();
        }
    }

    public static synchronized SessionCenter getInstance(String str) {
        SessionCenter instance;
        synchronized (SessionCenter.class) {
            Config configByTag = Config.getConfigByTag(str);
            if (configByTag != null) {
                instance = getInstance(configByTag);
            } else {
                throw new RuntimeException("tag not exist!");
            }
        }
        return instance;
    }

    public static synchronized void init(Context context) {
        synchronized (SessionCenter.class) {
            if (context != null) {
                GlobalAppRuntimeInfo.setContext(context.getApplicationContext());
                if (!f3576j) {
                    Map<Config, SessionCenter> map = f3575a;
                    Config config = Config.DEFAULT_CONFIG;
                    map.put(config, new SessionCenter(config));
                    AppLifecycle.initialize();
                    NetworkStatusHelper.startListener(context);
                    if (!AwcnConfig.isTbNextLaunch()) {
                        StrategyCenter.getInstance().initialize(GlobalAppRuntimeInfo.getContext());
                    }
                    if (GlobalAppRuntimeInfo.isTargetProcess()) {
                        n.a();
                        anet.channel.e.a.a();
                    }
                    f3576j = true;
                }
            } else {
                ALog.e(TAG, "context is null!", (String) null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
        }
    }

    public static synchronized void switchEnvironment(ENV env) {
        int i10;
        synchronized (SessionCenter.class) {
            try {
                if (GlobalAppRuntimeInfo.getEnv() != env) {
                    ALog.i(TAG, "switch env", (String) null, "old", GlobalAppRuntimeInfo.getEnv(), "new", env);
                    GlobalAppRuntimeInfo.setEnv(env);
                    StrategyCenter.getInstance().switchEnv();
                    SpdyAgent instance = SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
                    if (env == ENV.TEST) {
                        i10 = 0;
                    } else {
                        i10 = 1;
                    }
                    instance.switchAccsServer(i10);
                }
                Iterator<Map.Entry<Config, SessionCenter>> it = f3575a.entrySet().iterator();
                while (it.hasNext()) {
                    SessionCenter sessionCenter = (SessionCenter) it.next().getValue();
                    if (sessionCenter.f3579d.getEnv() != env) {
                        ALog.i(TAG, "remove instance", sessionCenter.f3578c, "ENVIRONMENT", sessionCenter.f3579d.getEnv());
                        sessionCenter.f3583h.forceCloseSession(false);
                        sessionCenter.f3584i.b();
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                ALog.e(TAG, "switch env error.", (String) null, th, new Object[0]);
            }
        }
        return;
    }

    public void asyncGet(HttpUrl httpUrl, int i10, long j10, SessionGetCallback sessionGetCallback) {
        if (sessionGetCallback == null) {
            throw new NullPointerException("cb is null");
        } else if (j10 > 0) {
            try {
                b(httpUrl, i10, j10, sessionGetCallback);
            } catch (Exception unused) {
                sessionGetCallback.onSessionGetFail();
            }
        } else {
            throw new InvalidParameterException("timeout must > 0");
        }
    }

    public void b(HttpUrl httpUrl, int i10, long j10, SessionGetCallback sessionGetCallback) {
        SessionInfo b10;
        int i11 = i10;
        SessionGetCallback sessionGetCallback2 = sessionGetCallback;
        if (!f3576j) {
            ALog.e(TAG, "getInternal not inited!", this.f3578c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        } else if (httpUrl == null) {
            throw new InvalidParameterException("httpUrl is null");
        } else if (sessionGetCallback2 != null) {
            String str = this.f3578c;
            Object[] objArr = new Object[6];
            objArr[0] = "u";
            objArr[1] = httpUrl.urlString();
            objArr[2] = "sessionType";
            objArr[3] = i11 == c.f3709a ? "LongLink" : "ShortLink";
            objArr[4] = "timeout";
            objArr[5] = Long.valueOf(j10);
            ALog.d(TAG, "getInternal", str, objArr);
            SessionRequest a10 = a(httpUrl);
            Session a11 = this.f3580e.a(a10, i10);
            if (a11 != null) {
                ALog.d(TAG, "get internal hit cache session", this.f3578c, "session", a11);
                sessionGetCallback2.onSessionGetSuccess(a11);
            } else if (this.f3579d == Config.DEFAULT_CONFIG && i11 != c.f3710b) {
                sessionGetCallback.onSessionGetFail();
            } else if (!GlobalAppRuntimeInfo.isAppBackground() || i11 != c.f3709a || !AwcnConfig.isAccsSessionCreateForbiddenInBg() || (b10 = this.f3582g.b(httpUrl.host())) == null || !b10.isAccs) {
                a10.b(this.f3577b, i10, i.a(this.f3578c), sessionGetCallback, j10);
            } else {
                ALog.w(TAG, "app background, forbid to create accs session", this.f3578c, new Object[0]);
                throw new ConnectException("accs session connecting forbidden in background");
            }
        } else {
            throw new InvalidParameterException("sessionGetCallback is null");
        }
    }

    @Deprecated
    public void enterBackground() {
        AppLifecycle.onBackground();
    }

    @Deprecated
    public void enterForeground() {
        AppLifecycle.onForeground();
    }

    public void forceRecreateAccsSession() {
        this.f3583h.forceCloseSession(true);
    }

    public Session get(String str, long j10) {
        return get(HttpUrl.parse(str), c.f3711c, j10);
    }

    public Session getThrowsException(String str, long j10) {
        return a(HttpUrl.parse(str), c.f3711c, j10, (SessionGetCallback) null);
    }

    public void registerAccsSessionListener(ISessionListener iSessionListener) {
        this.f3583h.registerListener(iSessionListener);
    }

    public void registerPublicKey(String str, int i10) {
        this.f3582g.a(str, i10);
    }

    public void registerSessionInfo(SessionInfo sessionInfo) {
        this.f3582g.a(sessionInfo);
        if (sessionInfo.isKeepAlive) {
            this.f3583h.checkAndStartSession();
        }
    }

    @Deprecated
    public synchronized void switchEnv(ENV env) {
        switchEnvironment(env);
    }

    public void unregisterAccsSessionListener(ISessionListener iSessionListener) {
        this.f3583h.unregisterListener(iSessionListener);
    }

    public void unregisterSessionInfo(String str) {
        SessionInfo a10 = this.f3582g.a(str);
        if (a10 != null && a10.isKeepAlive) {
            this.f3583h.checkAndStartSession();
        }
    }

    public class a implements NetworkStatusHelper.INetworkStatusChangeListener, IStrategyListener, AppLifecycle.AppLifecycleListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f3585a;

        private a() {
            this.f3585a = false;
        }

        public void a() {
            AppLifecycle.registerLifecycleListener(this);
            NetworkStatusHelper.addStatusChangeListener(this);
            StrategyCenter.getInstance().registerListener(this);
        }

        public void b() {
            StrategyCenter.getInstance().unregisterListener(this);
            AppLifecycle.unregisterLifecycleListener(this);
            NetworkStatusHelper.removeStatusChangeListener(this);
        }

        public void background() {
            ALog.i(SessionCenter.TAG, "[background]", SessionCenter.this.f3578c, new Object[0]);
            if (!SessionCenter.f3576j) {
                ALog.e(SessionCenter.TAG, "background not inited!", SessionCenter.this.f3578c, new Object[0]);
                return;
            }
            try {
                StrategyCenter.getInstance().saveData();
                if (AwcnConfig.isAccsSessionCreateForbiddenInBg() && "OPPO".equalsIgnoreCase(Build.BRAND)) {
                    ALog.i(SessionCenter.TAG, "close session for OPPO", SessionCenter.this.f3578c, new Object[0]);
                    SessionCenter.this.f3583h.forceCloseSession(false);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0054 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void forground() {
            /*
                r7 = this;
                anet.channel.SessionCenter r0 = anet.channel.SessionCenter.this
                java.lang.String r0 = r0.f3578c
                r1 = 0
                java.lang.Object[] r2 = new java.lang.Object[r1]
                java.lang.String r3 = "awcn.SessionCenter"
                java.lang.String r4 = "[forground]"
                anet.channel.util.ALog.i(r3, r4, r0, r2)
                anet.channel.SessionCenter r0 = anet.channel.SessionCenter.this
                android.content.Context r0 = r0.f3577b
                if (r0 != 0) goto L_0x0015
                return
            L_0x0015:
                boolean r0 = r7.f3585a
                if (r0 == 0) goto L_0x001a
                return
            L_0x001a:
                r0 = 1
                r7.f3585a = r0
                boolean r2 = anet.channel.SessionCenter.f3576j
                if (r2 != 0) goto L_0x002f
                anet.channel.SessionCenter r0 = anet.channel.SessionCenter.this
                java.lang.String r0 = r0.f3578c
                java.lang.Object[] r1 = new java.lang.Object[r1]
                java.lang.String r2 = "forground not inited!"
                anet.channel.util.ALog.e(r3, r2, r0, r1)
                return
            L_0x002f:
                long r2 = anet.channel.util.AppLifecycle.lastEnterBackgroundTime     // Catch:{ Exception -> 0x0054, all -> 0x0057 }
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 == 0) goto L_0x004d
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0054, all -> 0x0057 }
                long r4 = anet.channel.util.AppLifecycle.lastEnterBackgroundTime     // Catch:{ Exception -> 0x0054, all -> 0x0057 }
                long r2 = r2 - r4
                r4 = 60000(0xea60, double:2.9644E-319)
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x004d
                anet.channel.SessionCenter r2 = anet.channel.SessionCenter.this     // Catch:{ Exception -> 0x0054, all -> 0x0057 }
                anet.channel.AccsSessionManager r2 = r2.f3583h     // Catch:{ Exception -> 0x0054, all -> 0x0057 }
                r2.forceCloseSession(r0)     // Catch:{ Exception -> 0x0054, all -> 0x0057 }
                goto L_0x0054
            L_0x004d:
                anet.channel.SessionCenter r0 = anet.channel.SessionCenter.this     // Catch:{ Exception -> 0x0054, all -> 0x0057 }
                anet.channel.AccsSessionManager r0 = r0.f3583h     // Catch:{ Exception -> 0x0054, all -> 0x0057 }
                r0.checkAndStartSession()     // Catch:{ Exception -> 0x0054, all -> 0x0057 }
            L_0x0054:
                r7.f3585a = r1     // Catch:{ Exception -> 0x005b }
                goto L_0x005b
            L_0x0057:
                r0 = move-exception
                r7.f3585a = r1     // Catch:{ Exception -> 0x005b }
                throw r0     // Catch:{ Exception -> 0x005b }
            L_0x005b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionCenter.a.forground():void");
        }

        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            ALog.e(SessionCenter.TAG, "onNetworkStatusChanged.", SessionCenter.this.f3578c, "networkStatus", networkStatus);
            List<SessionRequest> a10 = SessionCenter.this.f3580e.a();
            if (!a10.isEmpty()) {
                for (SessionRequest a11 : a10) {
                    ALog.d(SessionCenter.TAG, "network change, try recreate session", SessionCenter.this.f3578c, new Object[0]);
                    a11.a((String) null);
                }
            }
            SessionCenter.this.f3583h.checkAndStartSession();
        }

        public void onStrategyUpdated(l.d dVar) {
            SessionCenter.this.a(dVar);
            SessionCenter.this.f3583h.checkAndStartSession();
        }

        public /* synthetic */ a(SessionCenter sessionCenter, d dVar) {
            this();
        }
    }

    @Deprecated
    public Session get(String str, ConnType.TypeLevel typeLevel, long j10) {
        return get(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? c.f3709a : c.f3710b, j10);
    }

    @Deprecated
    public Session getThrowsException(String str, ConnType.TypeLevel typeLevel, long j10) {
        return a(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? c.f3709a : c.f3710b, j10, (SessionGetCallback) null);
    }

    private SessionRequest a(HttpUrl httpUrl) {
        String cNameByHost = StrategyCenter.getInstance().getCNameByHost(httpUrl.host());
        if (cNameByHost == null) {
            cNameByHost = httpUrl.host();
        }
        String scheme = httpUrl.scheme();
        if (!httpUrl.isSchemeLocked()) {
            scheme = StrategyCenter.getInstance().getSchemeByHost(cNameByHost, scheme);
        }
        return a(StringUtils.concatString(scheme, HttpConstant.SCHEME_SPLIT, cNameByHost));
    }

    @Deprecated
    public Session get(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j10) {
        return get(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? c.f3709a : c.f3710b, j10);
    }

    public Session getThrowsException(HttpUrl httpUrl, int i10, long j10) {
        return a(httpUrl, i10, j10, (SessionGetCallback) null);
    }

    public static synchronized SessionCenter getInstance(Config config) {
        SessionCenter sessionCenter;
        Context appContext;
        synchronized (SessionCenter.class) {
            if (config != null) {
                if (!f3576j && (appContext = Utils.getAppContext()) != null) {
                    init(appContext);
                }
                sessionCenter = f3575a.get(config);
                if (sessionCenter == null) {
                    sessionCenter = new SessionCenter(config);
                    f3575a.put(config, sessionCenter);
                }
            } else {
                throw new NullPointerException("config is null!");
            }
        }
        return sessionCenter;
    }

    public Session get(HttpUrl httpUrl, int i10, long j10) {
        try {
            return a(httpUrl, i10, j10, (SessionGetCallback) null);
        } catch (InvalidParameterException e10) {
            InvalidParameterException invalidParameterException = e10;
            ALog.e(TAG, "[Get]param url is invalid", this.f3578c, invalidParameterException, "url", httpUrl);
            return null;
        } catch (TimeoutException e11) {
            TimeoutException timeoutException = e11;
            ALog.e(TAG, "[Get]timeout exception", this.f3578c, timeoutException, "url", httpUrl.urlString());
            return null;
        } catch (ConnectException e12) {
            ConnectException connectException = e12;
            ALog.e(TAG, "[Get]connect exception", this.f3578c, "errMsg", connectException.getMessage(), "url", httpUrl.urlString());
            return null;
        } catch (NoAvailStrategyException e13) {
            NoAvailStrategyException noAvailStrategyException = e13;
            ALog.i(TAG, "[Get]" + noAvailStrategyException.getMessage(), this.f3578c, null, "url", httpUrl.urlString());
            return null;
        } catch (Exception e14) {
            Exception exc = e14;
            ALog.e(TAG, "[Get]" + exc.getMessage(), this.f3578c, (Throwable) null, "url", httpUrl.urlString());
            return null;
        }
    }

    @Deprecated
    public Session getThrowsException(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j10) {
        return a(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? c.f3709a : c.f3710b, j10, (SessionGetCallback) null);
    }

    public Session a(HttpUrl httpUrl, int i10, long j10, SessionGetCallback sessionGetCallback) {
        SessionInfo b10;
        int i11 = i10;
        long j11 = j10;
        if (!f3576j) {
            ALog.e(TAG, "getInternal not inited!", this.f3578c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        } else if (httpUrl != null) {
            String str = this.f3578c;
            Object[] objArr = new Object[6];
            objArr[0] = "u";
            objArr[1] = httpUrl.urlString();
            objArr[2] = "sessionType";
            objArr[3] = i11 == c.f3709a ? "LongLink" : "ShortLink";
            objArr[4] = "timeout";
            objArr[5] = Long.valueOf(j10);
            ALog.d(TAG, "getInternal", str, objArr);
            SessionRequest a10 = a(httpUrl);
            Session a11 = this.f3580e.a(a10, i10);
            if (a11 != null) {
                ALog.d(TAG, "get internal hit cache session", this.f3578c, "session", a11);
            } else if (this.f3579d != Config.DEFAULT_CONFIG || i11 == c.f3710b) {
                if (!GlobalAppRuntimeInfo.isAppBackground() || i11 != c.f3709a || !AwcnConfig.isAccsSessionCreateForbiddenInBg() || (b10 = this.f3582g.b(httpUrl.host())) == null || !b10.isAccs) {
                    a10.a(this.f3577b, i10, i.a(this.f3578c), sessionGetCallback, j10);
                    if (sessionGetCallback == null && j11 > 0 && (i11 == c.f3711c || a10.b() == i11)) {
                        a10.a(j11);
                        a11 = this.f3580e.a(a10, i10);
                        if (a11 == null) {
                            throw new ConnectException("session connecting failed or timeout");
                        }
                    }
                } else {
                    ALog.w(TAG, "app background, forbid to create accs session", this.f3578c, new Object[0]);
                    throw new ConnectException("accs session connecting forbidden in background");
                }
            } else if (sessionGetCallback == null) {
                return null;
            } else {
                sessionGetCallback.onSessionGetFail();
                return null;
            }
            return a11;
        } else {
            throw new InvalidParameterException("httpUrl is null");
        }
    }

    @Deprecated
    public static synchronized SessionCenter getInstance() {
        Context appContext;
        synchronized (SessionCenter.class) {
            if (!f3576j && (appContext = Utils.getAppContext()) != null) {
                init(appContext);
            }
            SessionCenter sessionCenter = null;
            for (Map.Entry next : f3575a.entrySet()) {
                SessionCenter sessionCenter2 = (SessionCenter) next.getValue();
                if (next.getKey() != Config.DEFAULT_CONFIG) {
                    return sessionCenter2;
                }
                sessionCenter = sessionCenter2;
            }
            return sessionCenter;
        }
    }

    @Deprecated
    public static synchronized void init(Context context, String str) {
        synchronized (SessionCenter.class) {
            init(context, str, GlobalAppRuntimeInfo.getEnv());
        }
    }

    public static synchronized void init(Context context, String str, ENV env) {
        synchronized (SessionCenter.class) {
            if (context != null) {
                Config config = Config.getConfig(str, env);
                if (config == null) {
                    config = new Config.Builder().setAppkey(str).setEnv(env).build();
                }
                init(context, config);
            } else {
                ALog.e(TAG, "context is null!", (String) null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
        }
    }

    private void b(l.b bVar) {
        boolean z10;
        boolean z11;
        ALog.i(TAG, "find effectNow", this.f3578c, Constants.KEY_HOST, bVar.f3959a);
        l.a[] aVarArr = bVar.f3966h;
        String[] strArr = bVar.f3964f;
        for (Session next : this.f3580e.a(a(StringUtils.buildKey(bVar.f3961c, bVar.f3959a)))) {
            if (!next.getConnType().isHttpType()) {
                int i10 = 0;
                while (true) {
                    if (i10 >= strArr.length) {
                        z10 = false;
                        break;
                    } else if (next.getIp().equals(strArr[i10])) {
                        z10 = true;
                        break;
                    } else {
                        i10++;
                    }
                }
                if (!z10) {
                    if (ALog.isPrintLog(2)) {
                        ALog.i(TAG, "ip not match", next.f3564p, "session ip", next.getIp(), "ips", Arrays.toString(strArr));
                    }
                    next.close(true);
                } else {
                    int i11 = 0;
                    while (true) {
                        if (i11 < aVarArr.length) {
                            if (next.getPort() == aVarArr[i11].f3951a && next.getConnType().equals(ConnType.valueOf(ConnProtocol.valueOf(aVarArr[i11])))) {
                                z11 = true;
                                break;
                            }
                            i11++;
                        } else {
                            z11 = false;
                            break;
                        }
                    }
                    if (!z11) {
                        if (ALog.isPrintLog(2)) {
                            ALog.i(TAG, "aisle not match", next.f3564p, "port", Integer.valueOf(next.getPort()), "connType", next.getConnType(), "aisle", Arrays.toString(aVarArr));
                        }
                        next.close(true);
                    }
                }
            }
        }
    }

    public static synchronized void init(Context context, Config config) {
        synchronized (SessionCenter.class) {
            if (context == null) {
                ALog.e(TAG, "context is null!", (String) null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            } else if (config != null) {
                init(context);
                if (!f3575a.containsKey(config)) {
                    f3575a.put(config, new SessionCenter(config));
                }
            } else {
                ALog.e(TAG, "paramter config is null!", (String) null, new Object[0]);
                throw new NullPointerException("init failed. config is null");
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(l.d dVar) {
        try {
            l.b[] bVarArr = dVar.f3974b;
            for (l.b bVar : bVarArr) {
                if (bVar.f3969k) {
                    b(bVar);
                }
                if (bVar.f3963e != null) {
                    a(bVar);
                }
            }
        } catch (Exception e10) {
            ALog.e(TAG, "checkStrategy failed", this.f3578c, e10, new Object[0]);
        }
    }

    private void a(l.b bVar) {
        for (Session next : this.f3580e.a(a(StringUtils.buildKey(bVar.f3961c, bVar.f3959a)))) {
            if (!StringUtils.isStringEqual(next.f3560l, bVar.f3963e)) {
                ALog.i(TAG, "unit change", next.f3564p, "session unit", next.f3560l, "unit", bVar.f3963e);
                next.close(true);
            }
        }
    }

    public SessionRequest a(String str) {
        SessionRequest sessionRequest;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f3581f) {
            sessionRequest = this.f3581f.get(str);
            if (sessionRequest == null) {
                sessionRequest = new SessionRequest(str, this);
                this.f3581f.put(str, sessionRequest);
            }
        }
        return sessionRequest;
    }
}
