package com.taobao.accs.net;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.b;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.d;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;
import com.taobao.agoo.a.a.c;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushRegisterCallback;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class a {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;

    /* renamed from: n  reason: collision with root package name */
    protected static int f13024n;

    /* renamed from: a  reason: collision with root package name */
    public String f13025a = "android@umeng";

    /* renamed from: b  reason: collision with root package name */
    public String f13026b = "";

    /* renamed from: c  reason: collision with root package name */
    protected int f13027c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f13028d;

    /* renamed from: e  reason: collision with root package name */
    protected d f13029e;

    /* renamed from: f  reason: collision with root package name */
    protected int f13030f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected volatile boolean f13031g = false;

    /* renamed from: h  reason: collision with root package name */
    public b f13032h;

    /* renamed from: i  reason: collision with root package name */
    public AccsClientConfig f13033i;

    /* renamed from: j  reason: collision with root package name */
    protected String f13034j;

    /* renamed from: k  reason: collision with root package name */
    protected String f13035k = null;

    /* renamed from: l  reason: collision with root package name */
    protected LinkedHashMap<Integer, Message> f13036l = new BaseConnection$1(this);

    /* renamed from: m  reason: collision with root package name */
    public String f13037m;

    /* renamed from: o  reason: collision with root package name */
    private long f13038o = 0;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13039p = false;

    /* renamed from: q  reason: collision with root package name */
    private final ArrayList<AccsConnectStateListener> f13040q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private Runnable f13041r;

    /* renamed from: s  reason: collision with root package name */
    private ScheduledFuture<?> f13042s;

    public a(Context context, int i10, String str) {
        this.f13027c = i10;
        this.f13028d = context.getApplicationContext();
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        this.f13033i = configByTag;
        if (configByTag == null) {
            ALog.e(d(), "BaseConnection config null!!", new Object[0]);
            Class<PushAgent> cls = PushAgent.class;
            try {
                int i11 = PushAgent.f6187a;
                Object invoke = cls.getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
                Object invoke2 = cls.getMethod("getRegisterCallback", new Class[0]).invoke(invoke, new Object[0]);
                cls.getMethod(c.JSON_CMD_REGISTER, new Class[]{UPushRegisterCallback.class}).invoke(invoke, new Object[]{invoke2});
                this.f13033i = AccsClientConfig.getConfigByTag(str);
            } catch (Throwable th) {
                ALog.e(d(), "BaseConnection build config", th, new Object[0]);
            }
        }
        AccsClientConfig accsClientConfig = this.f13033i;
        if (accsClientConfig != null) {
            this.f13037m = accsClientConfig.getTag();
            this.f13026b = this.f13033i.getAppKey();
        }
        d dVar = new d(context, this);
        this.f13029e = dVar;
        dVar.f12972b = this.f13027c;
        ALog.d(d(), "new connection", new Object[0]);
    }

    public String a(int i10) {
        if (i10 == 1) {
            return "CONNECTED";
        }
        if (i10 != 2) {
            return (i10 == 3 || i10 != 4) ? "DISCONNECTED" : "DISCONNECTING";
        }
        return "CONNECTING";
    }

    public abstract void a();

    public abstract void a(Message message, boolean z10);

    public abstract void a(String str, boolean z10, String str2);

    public abstract void a(boolean z10, boolean z11);

    public abstract boolean a(String str);

    public abstract void b();

    public void b(Message message, boolean z10) {
        Message message2 = message;
        if (message2.isAck || UtilityImpl.i(this.f13028d)) {
            long a10 = message.getType() != 2 ? this.f13029e.f12974d.a(message2.serviceId, message2.bizId) : 0;
            if (a10 == -1) {
                ALog.e(d(), "sendMessage ready server limit high", Constants.KEY_DATA_ID, message2.dataId);
                this.f13029e.a(message2, (int) ErrorCode.SERVIER_HIGH_LIMIT);
            } else if (a10 == -1000) {
                ALog.e(d(), "sendMessage ready server limit high for brush", Constants.KEY_DATA_ID, message2.dataId);
                this.f13029e.a(message2, (int) ErrorCode.SERVIER_HIGH_LIMIT_BRUSH);
            } else {
                if (a10 > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j10 = this.f13038o;
                    if (currentTimeMillis > j10) {
                        message2.delyTime = a10;
                    } else {
                        message2.delyTime = (j10 + a10) - System.currentTimeMillis();
                    }
                    this.f13038o = System.currentTimeMillis() + message2.delyTime;
                    ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message2.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message2.delyTime));
                } else if ("accs".equals(message2.serviceId)) {
                    ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message2.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message2.delyTime));
                } else if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(d(), "sendMessage ready", Constants.KEY_DATA_ID, message2.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message2.delyTime));
                }
                try {
                    if (TextUtils.isEmpty(this.f13034j)) {
                        this.f13034j = UtilityImpl.j(this.f13028d);
                    }
                    if (!message.isTimeOut()) {
                        a(message, z10);
                    } else {
                        this.f13029e.a(message2, -9);
                    }
                } catch (RejectedExecutionException unused) {
                    this.f13029e.a(message2, (int) ErrorCode.MESSAGE_QUEUE_FULL);
                    ALog.e(d(), "sendMessage ready queue full", "size", Integer.valueOf(ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size()));
                }
            }
        } else {
            ALog.e(d(), "sendMessage ready no network", Constants.KEY_DATA_ID, message2.dataId);
            this.f13029e.a(message2, -13);
        }
    }

    public abstract com.taobao.accs.ut.a.c c();

    public String c(String str) {
        String str2;
        String j10 = UtilityImpl.j(this.f13028d);
        try {
            str2 = URLEncoder.encode(j10);
        } catch (Throwable th) {
            ALog.e(d(), "buildAuthUrl", th, new Object[0]);
            str2 = j10;
        }
        String a10 = UtilityImpl.a(i(), this.f13033i.getAppSecret(), j10);
        StringBuilder sb = new StringBuilder(256);
        sb.append(str);
        sb.append("auth?1=");
        sb.append(str2);
        sb.append("&2=");
        sb.append(a10);
        sb.append("&3=");
        sb.append(i());
        if (this.f13035k != null) {
            sb.append("&4=");
            sb.append(this.f13035k);
        }
        sb.append("&5=");
        sb.append(this.f13027c);
        sb.append("&6=");
        sb.append(UtilityImpl.g(this.f13028d));
        sb.append("&7=");
        sb.append(UtilityImpl.d());
        sb.append("&8=");
        sb.append(this.f13027c == 1 ? "1.1.2" : Integer.valueOf(Constants.SDK_VERSION_CODE));
        sb.append("&9=");
        sb.append(System.currentTimeMillis());
        sb.append("&10=");
        sb.append(1);
        sb.append("&11=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&12=");
        sb.append(this.f13028d.getPackageName());
        sb.append("&13=");
        sb.append(UtilityImpl.l(this.f13028d));
        sb.append("&14=");
        sb.append(this.f13025a);
        sb.append("&15=");
        sb.append(UtilityImpl.b(Build.MODEL));
        sb.append("&16=");
        sb.append(UtilityImpl.b(Build.BRAND));
        sb.append("&17=");
        sb.append("221");
        sb.append("&19=");
        sb.append(l() ^ true ? 1 : 0);
        sb.append("&20=");
        sb.append(this.f13033i.getStoreId());
        return sb.toString();
    }

    public abstract String d();

    public void e() {
    }

    public void f() {
        if (this.f13041r == null) {
            this.f13041r = new c(this);
        }
        g();
        this.f13042s = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f13041r, 40000, TimeUnit.MILLISECONDS);
    }

    public void g() {
        ScheduledFuture<?> scheduledFuture = this.f13042s;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public boolean h() {
        return true;
    }

    public String i() {
        return this.f13026b;
    }

    public b j() {
        if (this.f13032h == null) {
            ALog.d(d(), "new ClientManager", Constants.KEY_CONFIG_TAG, this.f13037m);
            this.f13032h = new b(this.f13028d, this.f13037m);
        }
        return this.f13032h;
    }

    public void k() {
        try {
            ThreadPoolExecutorFactory.schedule(new d(this), NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.w(d(), "startChannelService", th, new Object[0]);
        }
    }

    public boolean l() {
        if (2 == this.f13033i.getSecurity()) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return false;
    }

    public ArrayList<AccsConnectStateListener> n() {
        return this.f13040q;
    }

    public void a(String str, boolean z10, long j10) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new b(this, str, z10), j10, TimeUnit.MILLISECONDS);
    }

    public boolean a(Message message, int i10) {
        boolean z10;
        try {
            int i11 = message.retryTimes;
            if (i11 > 3) {
                return false;
            }
            z10 = true;
            message.retryTimes = i11 + 1;
            message.delyTime = (long) i10;
            String d10 = d();
            ALog.e(d10, "reSend dataid:" + message.dataId + " retryTimes:" + message.retryTimes, new Object[0]);
            b(message, true);
            try {
                if (message.getNetPermanceMonitor() != null) {
                    message.getNetPermanceMonitor().take_date = 0;
                    message.getNetPermanceMonitor().to_tnet_date = 0;
                    NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                    int i12 = message.retryTimes;
                    netPermanceMonitor.retry_times = i12;
                    if (i12 == 1) {
                        k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total", 0.0d);
                    }
                }
            } catch (Throwable th) {
                th = th;
                this.f13029e.a(message, -8);
                ALog.e(d(), "reSend error", th, new Object[0]);
                return z10;
            }
            return z10;
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
            this.f13029e.a(message, -8);
            ALog.e(d(), "reSend error", th, new Object[0]);
            return z10;
        }
    }

    public void a(Context context) {
        try {
            ENV env = ENV.ONLINE;
            int i10 = AccsClientConfig.mEnv;
            if (i10 == 2) {
                env = ENV.TEST;
                SessionCenter.switchEnvironment(env);
            } else if (i10 == 1) {
                env = ENV.PREPARE;
                SessionCenter.switchEnvironment(env);
            }
            SessionCenter.init(context, new Config.Builder().setAppkey(this.f13026b).setAppSecret(this.f13033i.getAppSecret()).setAuthCode(this.f13033i.getAuthCode()).setEnv(env).setTag(this.f13033i.getAppKey()).build());
            String str = ConnType.PK_ACS;
            if (this.f13033i.getInappPubKey() == 10 || this.f13033i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.i(d(), "init awcn register new conn protocol host:", this.f13033i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f13033i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    public void b(int i10) {
        if (i10 < 0) {
            ALog.e(d(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i10));
            Message message = this.f13036l.get(Integer.valueOf(i10));
            if (message != null) {
                a(message, (int) com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
                k.a("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    public void c(int i10) {
        int i11 = 1;
        if (i10 != 1) {
            i11 = 0;
        }
        f13024n = i11;
    }

    public String b(String str) {
        String inappHost = this.f13033i.getInappHost();
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(TextUtils.isEmpty(str) ? "" : str);
        sb.append(inappHost);
        String sb2 = sb.toString();
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("https://");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb3.append(str);
            sb3.append(inappHost);
            return sb3.toString();
        } catch (Throwable th) {
            ALog.e("InAppConnection", "getHost", th, new Object[0]);
            return sb2;
        }
    }

    public void a(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.f13040q) {
            this.f13040q.add(accsConnectStateListener);
        }
    }

    public void b(Message message, int i10) {
        this.f13029e.a(message, i10);
    }

    public void b(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.f13040q) {
            this.f13040q.remove(accsConnectStateListener);
        }
    }
}
