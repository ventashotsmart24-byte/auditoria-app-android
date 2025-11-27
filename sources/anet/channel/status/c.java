package anet.channel.status;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import anet.channel.util.ALog;
import java.util.ArrayList;

final class c extends ConnectivityManager.NetworkCallback {
    public void onAvailable(Network network) {
        super.onAvailable(network);
        ALog.i("awcn.NetworkStatusMonitor", "network onAvailable", (String) null, new Object[0]);
        b.f3857b = true;
    }

    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        super.onLinkPropertiesChanged(network, linkProperties);
        b.f3867l = new ArrayList(linkProperties.getDnsServers());
    }

    public void onLost(Network network) {
        super.onLost(network);
        ALog.i("awcn.NetworkStatusMonitor", "network onLost", (String) null, new Object[0]);
        b.f3857b = false;
    }
}
