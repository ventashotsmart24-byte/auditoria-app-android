package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;

class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f3673a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f3674b;

    public m(l lVar, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f3674b = lVar;
        this.f3673a = networkStatus;
    }

    public void run() {
        try {
            NetworkStatusHelper.NetworkStatus networkStatus = this.f3673a;
            if (networkStatus == NetworkStatusHelper.NetworkStatus.NO) {
                return;
            }
            if (networkStatus != NetworkStatusHelper.NetworkStatus.NONE) {
                this.f3674b.f3672a.a(NetworkStatusHelper.getUniqueId(networkStatus));
            }
        } catch (Throwable th) {
            ALog.e("anet.MTUDetector", "MTU detecet fail.", (String) null, th, new Object[0]);
        }
    }
}
