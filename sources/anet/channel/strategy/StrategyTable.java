package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.e.a;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

class StrategyTable implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    protected static Comparator<StrategyCollection> f3905e = new o();

    /* renamed from: a  reason: collision with root package name */
    protected String f3906a;

    /* renamed from: b  reason: collision with root package name */
    protected volatile String f3907b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, Long> f3908c;

    /* renamed from: d  reason: collision with root package name */
    protected transient boolean f3909d = false;

    /* renamed from: f  reason: collision with root package name */
    private HostLruCache f3910f;

    /* renamed from: g  reason: collision with root package name */
    private volatile transient int f3911g;

    public static class HostLruCache extends SerialLruCache<String, StrategyCollection> {
        public HostLruCache(int i10) {
            super(i10);
        }

        public boolean entryRemoved(Map.Entry<String, StrategyCollection> entry) {
            if (!entry.getValue().f3887d) {
                return true;
            }
            Iterator it = entrySet().iterator();
            while (it.hasNext()) {
                if (!((StrategyCollection) ((Map.Entry) it.next()).getValue()).f3887d) {
                    it.remove();
                    return false;
                }
            }
            return false;
        }
    }

    public StrategyTable(String str) {
        this.f3906a = str;
        a();
    }

    private void b() {
        if (HttpDispatcher.getInstance().isInitHostsChanged(this.f3906a)) {
            for (String next : HttpDispatcher.getInstance().getInitHosts()) {
                this.f3910f.put(next, new StrategyCollection(next));
            }
        }
    }

    private void c() {
        TreeSet treeSet;
        try {
            if (HttpDispatcher.getInstance().isInitHostsChanged(this.f3906a)) {
                synchronized (this.f3910f) {
                    treeSet = null;
                    for (String next : HttpDispatcher.getInstance().getInitHosts()) {
                        if (!this.f3910f.containsKey(next)) {
                            this.f3910f.put(next, new StrategyCollection(next));
                            if (treeSet == null) {
                                treeSet = new TreeSet();
                            }
                            treeSet.add(next);
                        }
                    }
                }
                if (treeSet != null) {
                    a((Set<String>) treeSet);
                }
            }
        } catch (Exception e10) {
            ALog.e("awcn.StrategyTable", "checkInitHost failed", this.f3906a, e10, new Object[0]);
        }
    }

    public void a() {
        if (this.f3910f == null) {
            this.f3910f = new HostLruCache(256);
            b();
        }
        for (StrategyCollection checkInit : this.f3910f.values()) {
            checkInit.checkInit();
        }
        int i10 = 0;
        ALog.i("awcn.StrategyTable", "strategy map", (String) null, "size", Integer.valueOf(this.f3910f.size()));
        if (!GlobalAppRuntimeInfo.isTargetProcess()) {
            i10 = -1;
        }
        this.f3911g = i10;
        if (this.f3908c == null) {
            this.f3908c = new ConcurrentHashMap();
        }
    }

    public String getCnameByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f3910f) {
            strategyCollection = (StrategyCollection) this.f3910f.get(str);
        }
        if (strategyCollection != null && strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0) {
            a(str);
        }
        if (strategyCollection != null) {
            return strategyCollection.f3886c;
        }
        return null;
    }

    public List<IConnStrategy> queryByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str) || !d.c(str)) {
            return Collections.EMPTY_LIST;
        }
        c();
        synchronized (this.f3910f) {
            strategyCollection = (StrategyCollection) this.f3910f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f3910f.put(str, strategyCollection);
            }
        }
        if (strategyCollection.f3885b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
        return strategyCollection.queryStrategyList();
    }

    public void update(l.d dVar) {
        ALog.i("awcn.StrategyTable", "update strategyTable with httpDns response", this.f3906a, new Object[0]);
        try {
            this.f3907b = dVar.f3973a;
            this.f3911g = dVar.f3978f;
            l.b[] bVarArr = dVar.f3974b;
            if (bVarArr != null) {
                synchronized (this.f3910f) {
                    for (l.b bVar : bVarArr) {
                        if (bVar != null) {
                            String str = bVar.f3959a;
                            if (str != null) {
                                if (bVar.f3968j) {
                                    this.f3910f.remove(str);
                                } else {
                                    StrategyCollection strategyCollection = (StrategyCollection) this.f3910f.get(str);
                                    if (strategyCollection == null) {
                                        strategyCollection = new StrategyCollection(bVar.f3959a);
                                        this.f3910f.put(bVar.f3959a, strategyCollection);
                                    }
                                    strategyCollection.update(bVar);
                                }
                            }
                        }
                    }
                }
                this.f3909d = true;
                if (ALog.isPrintLog(1)) {
                    StringBuilder sb = new StringBuilder("uniqueId : ");
                    sb.append(this.f3906a);
                    sb.append("\n-------------------------domains:------------------------------------");
                    ALog.d("awcn.StrategyTable", sb.toString(), (String) null, new Object[0]);
                    synchronized (this.f3910f) {
                        for (Map.Entry entry : this.f3910f.entrySet()) {
                            sb.setLength(0);
                            sb.append((String) entry.getKey());
                            sb.append(" = ");
                            sb.append(((StrategyCollection) entry.getValue()).toString());
                            ALog.d("awcn.StrategyTable", sb.toString(), (String) null, new Object[0]);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ALog.e("awcn.StrategyTable", "fail to update strategyTable", this.f3906a, th, new Object[0]);
        }
    }

    private void b(Set<String> set) {
        TreeSet treeSet = new TreeSet(f3905e);
        synchronized (this.f3910f) {
            treeSet.addAll(this.f3910f.values());
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            StrategyCollection strategyCollection = (StrategyCollection) it.next();
            if (strategyCollection.isExpired() && set.size() < 40) {
                strategyCollection.f3885b = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS + currentTimeMillis;
                set.add(strategyCollection.f3884a);
            } else {
                return;
            }
        }
    }

    private void a(String str) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(str);
        a((Set<String>) treeSet);
    }

    public void a(String str, boolean z10) {
        StrategyCollection strategyCollection;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f3910f) {
                strategyCollection = (StrategyCollection) this.f3910f.get(str);
                if (strategyCollection == null) {
                    strategyCollection = new StrategyCollection(str);
                    this.f3910f.put(str, strategyCollection);
                }
            }
            if (z10 || strategyCollection.f3885b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
                a(str);
            }
        }
    }

    private void a(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            if ((!GlobalAppRuntimeInfo.isAppBackground() || AppLifecycle.lastEnterBackgroundTime <= 0) && NetworkStatusHelper.isConnected()) {
                int amdcLimitLevel = AmdcRuntimeInfo.getAmdcLimitLevel();
                if (amdcLimitLevel != 3) {
                    long currentTimeMillis = System.currentTimeMillis();
                    synchronized (this.f3910f) {
                        for (String str : set) {
                            StrategyCollection strategyCollection = (StrategyCollection) this.f3910f.get(str);
                            if (strategyCollection != null) {
                                strategyCollection.f3885b = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS + currentTimeMillis;
                            }
                        }
                    }
                    if (amdcLimitLevel == 0) {
                        b(set);
                    }
                    HttpDispatcher.getInstance().sendAmdcRequest(set, this.f3911g);
                    return;
                }
                return;
            }
            ALog.i("awcn.StrategyTable", "app in background or no network", this.f3906a, new Object[0]);
        }
    }

    public void a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyCollection strategyCollection;
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyTable", "[notifyConnEvent]", (String) null, "Host", str, "IConnStrategy", iConnStrategy, "ConnEvent", connEvent);
        }
        String str2 = iConnStrategy.getProtocol().protocol;
        if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
            a.a(connEvent.isSuccess);
            ALog.e("awcn.StrategyTable", "enable http3", (String) null, "uniqueId", this.f3906a, "enable", Boolean.valueOf(connEvent.isSuccess));
        }
        if (!connEvent.isSuccess && d.b(iConnStrategy.getIp())) {
            this.f3908c.put(str, Long.valueOf(System.currentTimeMillis()));
            ALog.e("awcn.StrategyTable", "disable ipv6", (String) null, "uniqueId", this.f3906a, Constants.KEY_HOST, str);
        }
        synchronized (this.f3910f) {
            strategyCollection = (StrategyCollection) this.f3910f.get(str);
        }
        if (strategyCollection != null) {
            strategyCollection.notifyConnEvent(iConnStrategy, connEvent);
        }
    }

    public boolean a(String str, long j10) {
        Long l10 = this.f3908c.get(str);
        if (l10 == null) {
            return false;
        }
        if (l10.longValue() + j10 >= System.currentTimeMillis()) {
            return true;
        }
        this.f3908c.remove(str);
        return false;
    }
}
