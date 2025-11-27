package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;

final class NetworkStatusMonitor$2 extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.NetworkStatusMonitor", "receiver:" + intent.getAction(), (String) null, new Object[0]);
        }
        ThreadPoolExecutorFactory.submitScheduledTask(new d(this));
    }
}
