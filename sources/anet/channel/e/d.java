package anet.channel.e;

import anet.channel.status.NetworkStatusHelper;

final class d implements NetworkStatusHelper.INetworkStatusChangeListener {
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        a.a(networkStatus);
    }
}
