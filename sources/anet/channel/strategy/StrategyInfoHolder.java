package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.StrategyStatObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.strategy.utils.a;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class StrategyInfoHolder implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    Map<String, StrategyTable> f3895a = new LruStrategyMap();

    /* renamed from: b  reason: collision with root package name */
    volatile StrategyConfig f3896b = null;

    /* renamed from: c  reason: collision with root package name */
    final a f3897c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final StrategyTable f3898d = new StrategyTable("Unknown");

    /* renamed from: e  reason: collision with root package name */
    private final Set<String> f3899e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private volatile String f3900f = "";

    public static class LruStrategyMap extends SerialLruCache<String, StrategyTable> {
        public LruStrategyMap() {
            super(3);
        }

        public boolean entryRemoved(Map.Entry<String, StrategyTable> entry) {
            a.a(new f(this, entry));
            return true;
        }
    }

    private StrategyInfoHolder() {
        try {
            e();
            g();
        } catch (Throwable unused) {
        }
        f();
    }

    public static StrategyInfoHolder a() {
        return new StrategyInfoHolder();
    }

    private void e() {
        NetworkStatusHelper.addStatusChangeListener(this);
        this.f3900f = a(NetworkStatusHelper.getStatus());
    }

    private void f() {
        for (Map.Entry<String, StrategyTable> value : this.f3895a.entrySet()) {
            ((StrategyTable) value.getValue()).a();
        }
        synchronized (this) {
            if (this.f3896b == null) {
                StrategyConfig strategyConfig = new StrategyConfig();
                strategyConfig.b();
                strategyConfig.a(this);
                this.f3896b = strategyConfig;
            }
        }
    }

    private void g() {
        ALog.i("awcn.StrategyInfoHolder", "restore", (String) null, new Object[0]);
        String str = this.f3900f;
        if (!AwcnConfig.isAsyncLoadStrategyEnable()) {
            if (!TextUtils.isEmpty(str)) {
                a(str, true);
            }
            this.f3896b = (StrategyConfig) m.a("StrategyConfig", (StrategyStatObject) null);
            if (this.f3896b != null) {
                this.f3896b.b();
                this.f3896b.a(this);
            }
        }
        a.a(new d(this, str));
    }

    public void b() {
        NetworkStatusHelper.removeStatusChangeListener(this);
    }

    public void c() {
        synchronized (this) {
            for (StrategyTable next : this.f3895a.values()) {
                if (next.f3909d) {
                    StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                    String str = next.f3906a;
                    strategyStatObject.writeStrategyFileId = str;
                    m.a(next, str, strategyStatObject);
                    next.f3909d = false;
                }
            }
            m.a(this.f3896b.a(), "StrategyConfig", (StrategyStatObject) null);
        }
    }

    public StrategyTable d() {
        StrategyTable strategyTable = this.f3898d;
        String str = this.f3900f;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f3895a) {
                strategyTable = this.f3895a.get(str);
                if (strategyTable == null) {
                    strategyTable = new StrategyTable(str);
                    this.f3895a.put(str, strategyTable);
                }
            }
        }
        return strategyTable;
    }

    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f3897c.a();
        this.f3900f = a(networkStatus);
        String str = this.f3900f;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f3895a) {
                if (!this.f3895a.containsKey(str)) {
                    a.a(new e(this, str));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r2 = (anet.channel.strategy.StrategyTable) anet.channel.strategy.m.a(r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r2 == null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2.a();
        r3 = r6.f3895a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r6.f3895a.put(r2.f3906a, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        r3 = r6.f3899e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.f3899e.remove(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
        if (r8 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
        if (r2 == null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0044, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0045, code lost:
        r1.isSucceed = r0;
        anet.channel.appmonitor.AppMonitor.getInstance().commitStat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r8 == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r1 = new anet.channel.statist.StrategyStatObject(0);
        r1.readStrategyFileId = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r7, boolean r8) {
        /*
            r6 = this;
            java.util.Set<java.lang.String> r0 = r6.f3899e
            monitor-enter(r0)
            java.util.Set<java.lang.String> r1 = r6.f3899e     // Catch:{ all -> 0x0054 }
            boolean r1 = r1.contains(r7)     // Catch:{ all -> 0x0054 }
            if (r1 != 0) goto L_0x0052
            java.util.Set<java.lang.String> r1 = r6.f3899e     // Catch:{ all -> 0x0054 }
            r1.add(r7)     // Catch:{ all -> 0x0054 }
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            r0 = 0
            if (r8 == 0) goto L_0x001c
            anet.channel.statist.StrategyStatObject r1 = new anet.channel.statist.StrategyStatObject
            r1.<init>(r0)
            r1.readStrategyFileId = r7
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            java.lang.Object r2 = anet.channel.strategy.m.a(r7, r1)
            anet.channel.strategy.StrategyTable r2 = (anet.channel.strategy.StrategyTable) r2
            if (r2 == 0) goto L_0x0037
            r2.a()
            java.util.Map<java.lang.String, anet.channel.strategy.StrategyTable> r3 = r6.f3895a
            monitor-enter(r3)
            java.util.Map<java.lang.String, anet.channel.strategy.StrategyTable> r4 = r6.f3895a     // Catch:{ all -> 0x0034 }
            java.lang.String r5 = r2.f3906a     // Catch:{ all -> 0x0034 }
            r4.put(r5, r2)     // Catch:{ all -> 0x0034 }
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            goto L_0x0037
        L_0x0034:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r7
        L_0x0037:
            java.util.Set<java.lang.String> r3 = r6.f3899e
            monitor-enter(r3)
            java.util.Set<java.lang.String> r4 = r6.f3899e     // Catch:{ all -> 0x004f }
            r4.remove(r7)     // Catch:{ all -> 0x004f }
            monitor-exit(r3)     // Catch:{ all -> 0x004f }
            if (r8 == 0) goto L_0x004e
            if (r2 == 0) goto L_0x0045
            r0 = 1
        L_0x0045:
            r1.isSucceed = r0
            anet.channel.appmonitor.IAppMonitor r7 = anet.channel.appmonitor.AppMonitor.getInstance()
            r7.commitStat(r1)
        L_0x004e:
            return
        L_0x004f:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x004f }
            throw r7
        L_0x0052:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return
        L_0x0054:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.StrategyInfoHolder.a(java.lang.String, boolean):void");
    }

    private String a(NetworkStatusHelper.NetworkStatus networkStatus) {
        String str = "";
        if (networkStatus.isWifi()) {
            String md5ToHex = StringUtils.md5ToHex(NetworkStatusHelper.getWifiBSSID());
            if (!TextUtils.isEmpty(md5ToHex)) {
                str = md5ToHex;
            }
            return "WIFI$" + str;
        } else if (!networkStatus.isMobile()) {
            return str;
        } else {
            return networkStatus.getType() + "$" + NetworkStatusHelper.getApn();
        }
    }

    public void a(l.d dVar) {
        int i10 = dVar.f3979g;
        if (i10 != 0) {
            AmdcRuntimeInfo.updateAmdcLimit(i10, dVar.f3980h);
        }
        d().update(dVar);
        this.f3896b.a(dVar);
    }
}
