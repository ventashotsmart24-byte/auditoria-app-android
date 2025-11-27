package anet.channel.e;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static b f3683a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f3684b;

    /* renamed from: c  reason: collision with root package name */
    private static AtomicBoolean f3685c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static AtomicBoolean f3686d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static long f3687e = 21600000;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f3688f;

    /* renamed from: g  reason: collision with root package name */
    private static IStrategyFilter f3689g = new b();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static AtomicInteger f3690h = new AtomicInteger(1);

    /* renamed from: i  reason: collision with root package name */
    private static IStrategyListener f3691i = new c();

    /* renamed from: j  reason: collision with root package name */
    private static NetworkStatusHelper.INetworkStatusChangeListener f3692j = new d();

    /* renamed from: anet.channel.e.a$a  reason: collision with other inner class name */
    public static class C0061a {

        /* renamed from: a  reason: collision with root package name */
        long f3693a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3694b;

        private C0061a() {
        }

        public /* synthetic */ C0061a(b bVar) {
            this();
        }
    }

    public static boolean b() {
        b bVar = f3683a;
        if (bVar != null) {
            return bVar.b(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()));
        }
        return false;
    }

    public static void a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!AwcnConfig.isHttp3Enable()) {
            ALog.i("awcn.Http3ConnDetector", "startDetect", (String) null, "http3 global config close.");
        } else if (f3686d.get()) {
            ALog.e("awcn.Http3ConnDetector", "tnet exception.", (String) null, new Object[0]);
        } else if (NetworkStatusHelper.isConnected()) {
            if (TextUtils.isEmpty(f3684b)) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", (String) null, "host is null");
                return;
            }
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(f3684b, f3689g);
            if (connStrategyListByHost.isEmpty()) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", (String) null, "http3 strategy is null.");
                return;
            }
            if (f3685c.compareAndSet(false, true)) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3.", (String) null, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3 error.", (String) null, th, new Object[0]);
                    f3686d.set(true);
                    return;
                }
            }
            if (f3683a == null) {
                f3683a = new b();
            }
            if (f3683a.a(NetworkStatusHelper.getUniqueId(networkStatus))) {
                ThreadPoolExecutorFactory.submitDetectTask(new e(connStrategyListByHost, networkStatus));
            }
        }
    }

    /* access modifiers changed from: private */
    public static IConnStrategy b(IConnStrategy iConnStrategy) {
        return new g(iConnStrategy);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, C0061a> f3695a = new ConcurrentHashMap();

        public b() {
            a();
        }

        private void a() {
            String string = a.f3688f.getString("networksdk_http3_history_records", (String) null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i10);
                        C0061a aVar = new C0061a((b) null);
                        String string2 = jSONObject.getString("networkUniqueId");
                        aVar.f3693a = jSONObject.getLong(AgooConstants.MESSAGE_TIME);
                        aVar.f3694b = jSONObject.getBoolean("enable");
                        if (a(aVar.f3693a)) {
                            synchronized (this.f3695a) {
                                this.f3695a.put(string2, aVar);
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        }

        public boolean b(String str) {
            synchronized (this.f3695a) {
                C0061a aVar = this.f3695a.get(str);
                if (aVar == null) {
                    return false;
                }
                boolean z10 = aVar.f3694b;
                return z10;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(java.lang.String r5) {
            /*
                r4 = this;
                java.util.Map<java.lang.String, anet.channel.e.a$a> r0 = r4.f3695a
                monitor-enter(r0)
                java.util.Map<java.lang.String, anet.channel.e.a$a> r1 = r4.f3695a     // Catch:{ all -> 0x001c }
                java.lang.Object r5 = r1.get(r5)     // Catch:{ all -> 0x001c }
                anet.channel.e.a$a r5 = (anet.channel.e.a.C0061a) r5     // Catch:{ all -> 0x001c }
                r1 = 1
                if (r5 != 0) goto L_0x0010
                monitor-exit(r0)     // Catch:{ all -> 0x001c }
                return r1
            L_0x0010:
                long r2 = r5.f3693a     // Catch:{ all -> 0x001c }
                boolean r5 = r4.a((long) r2)     // Catch:{ all -> 0x001c }
                if (r5 != 0) goto L_0x0019
                goto L_0x001a
            L_0x0019:
                r1 = 0
            L_0x001a:
                monitor-exit(r0)     // Catch:{ all -> 0x001c }
                return r1
            L_0x001c:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x001c }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.e.a.b.a(java.lang.String):boolean");
        }

        private boolean a(long j10) {
            return System.currentTimeMillis() - j10 < a.f3687e;
        }

        public void a(String str, boolean z10) {
            C0061a aVar = new C0061a((b) null);
            aVar.f3694b = z10;
            aVar.f3693a = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.f3695a) {
                this.f3695a.put(str, aVar);
                for (Map.Entry next : this.f3695a.entrySet()) {
                    String str2 = (String) next.getKey();
                    C0061a aVar2 = (C0061a) next.getValue();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkUniqueId", str2);
                        jSONObject.put(AgooConstants.MESSAGE_TIME, aVar2.f3693a);
                        jSONObject.put("enable", aVar2.f3694b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            a.f3688f.edit().putString("networksdk_http3_history_records", jSONArray.toString()).apply();
        }
    }

    public static void a() {
        try {
            ALog.e("awcn.Http3ConnDetector", "registerListener", (String) null, "http3Enable", Boolean.valueOf(AwcnConfig.isHttp3Enable()));
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
            f3688f = defaultSharedPreferences;
            f3684b = defaultSharedPreferences.getString("http3_detector_host", "");
            a(NetworkStatusHelper.getStatus());
            NetworkStatusHelper.addStatusChangeListener(f3692j);
            StrategyCenter.getInstance().registerListener(f3691i);
        } catch (Exception e10) {
            ALog.e("awcn.Http3ConnDetector", "[registerListener]error", (String) null, e10, new Object[0]);
        }
    }

    public static void a(long j10) {
        if (j10 >= 0) {
            f3687e = j10;
        }
    }

    public static void a(boolean z10) {
        b bVar = f3683a;
        if (bVar != null) {
            bVar.a(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()), z10);
        }
    }
}
