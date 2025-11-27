package anet.channel.strategy;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

class StrategyCollection implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    String f3884a;

    /* renamed from: b  reason: collision with root package name */
    volatile long f3885b = 0;

    /* renamed from: c  reason: collision with root package name */
    volatile String f3886c = null;

    /* renamed from: d  reason: collision with root package name */
    boolean f3887d = false;

    /* renamed from: e  reason: collision with root package name */
    int f3888e = 0;

    /* renamed from: f  reason: collision with root package name */
    private StrategyList f3889f = null;

    /* renamed from: g  reason: collision with root package name */
    private transient long f3890g = 0;

    /* renamed from: h  reason: collision with root package name */
    private transient boolean f3891h = true;

    public StrategyCollection() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void checkInit() {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x001d }
            long r2 = r5.f3885b     // Catch:{ all -> 0x001d }
            long r0 = r0 - r2
            r2 = 172800000(0xa4cb800, double:8.53745436E-316)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0014
            r0 = 0
            r5.f3889f = r0     // Catch:{ all -> 0x001d }
            monitor-exit(r5)
            return
        L_0x0014:
            anet.channel.strategy.StrategyList r0 = r5.f3889f     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            r0.checkInit()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r5)
            return
        L_0x001d:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.StrategyCollection.checkInit():void");
    }

    public boolean isExpired() {
        if (System.currentTimeMillis() > this.f3885b) {
            return true;
        }
        return false;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyList strategyList = this.f3889f;
        if (strategyList != null) {
            strategyList.notifyConnEvent(iConnStrategy, connEvent);
            if (!connEvent.isSuccess && this.f3889f.shouldRefresh()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f3890g > 60000) {
                    StrategyCenter.getInstance().forceRefreshStrategy(this.f3884a);
                    this.f3890g = currentTimeMillis;
                }
            }
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (this.f3889f == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.f3891h) {
            this.f3891h = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f3884a, this.f3888e);
            policyVersionStat.reportType = 0;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        return this.f3889f.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyList = ");
        sb.append(this.f3885b);
        StrategyList strategyList = this.f3889f;
        if (strategyList != null) {
            sb.append(strategyList.toString());
        } else if (this.f3886c != null) {
            sb.append('[');
            sb.append(this.f3884a);
            sb.append("=>");
            sb.append(this.f3886c);
            sb.append(']');
        } else {
            sb.append("[]");
        }
        return sb.toString();
    }

    public synchronized void update(l.b bVar) {
        l.a[] aVarArr;
        this.f3885b = System.currentTimeMillis() + (((long) bVar.f3960b) * 1000);
        if (!bVar.f3959a.equalsIgnoreCase(this.f3884a)) {
            ALog.e("StrategyCollection", "update error!", (String) null, Constants.KEY_HOST, this.f3884a, "dnsInfo.host", bVar.f3959a);
            return;
        }
        int i10 = this.f3888e;
        int i11 = bVar.f3970l;
        if (i10 != i11) {
            this.f3888e = i11;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f3884a, i11);
            policyVersionStat.reportType = 1;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        this.f3886c = bVar.f3962d;
        String[] strArr = bVar.f3964f;
        if (strArr == null || strArr.length == 0 || (aVarArr = bVar.f3966h) == null || aVarArr.length == 0) {
            l.e[] eVarArr = bVar.f3967i;
            if (eVarArr != null) {
                if (eVarArr.length == 0) {
                }
            }
            this.f3889f = null;
            return;
        }
        if (this.f3889f == null) {
            this.f3889f = new StrategyList();
        }
        this.f3889f.update(bVar);
    }

    public StrategyCollection(String str) {
        this.f3884a = str;
        this.f3887d = DispatchConstants.isAmdcServerDomain(str);
    }
}
