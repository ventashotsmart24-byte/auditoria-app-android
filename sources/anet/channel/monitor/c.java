package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;

class c implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3762a;

    public c(b bVar) {
        this.f3762a = bVar;
    }

    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f3762a.f3760n.a();
        b.f3752f = 0;
        this.f3762a.d();
    }
}
