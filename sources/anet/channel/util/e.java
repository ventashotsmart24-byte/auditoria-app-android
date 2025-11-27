package anet.channel.util;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.NetTypeStat;
import anet.channel.status.NetworkStatusHelper;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4016a;

    public e(d dVar) {
        this.f4016a = dVar;
    }

    public void run() {
        f g10;
        try {
            if (this.f4016a.f4014a.equals(c.b(NetworkStatusHelper.getStatus()))) {
                ALog.e("awcn.Inet64Util", "startIpStackDetect double check", (String) null, new Object[0]);
                int f10 = c.j();
                d dVar = this.f4016a;
                if (dVar.f4015b.ipStackType != f10) {
                    c.f4013e.put(dVar.f4014a, Integer.valueOf(f10));
                    NetTypeStat netTypeStat = this.f4016a.f4015b;
                    netTypeStat.lastIpStackType = netTypeStat.ipStackType;
                    netTypeStat.ipStackType = f10;
                }
                if ((f10 == 2 || f10 == 3) && (g10 = c.k()) != null) {
                    c.f4012d.put(this.f4016a.f4014a, g10);
                    this.f4016a.f4015b.nat64Prefix = g10.toString();
                }
                if (GlobalAppRuntimeInfo.isTargetProcess()) {
                    AppMonitor.getInstance().commitStat(this.f4016a.f4015b);
                }
            }
        } catch (Exception unused) {
        }
    }
}
