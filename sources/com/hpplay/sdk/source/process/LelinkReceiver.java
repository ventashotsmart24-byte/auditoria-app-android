package com.hpplay.sdk.source.process;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.hpplay.sdk.source.log.SourceLog;

public class LelinkReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.hpplay.source.service.close".equals(intent.getAction())) {
            SourceLog.i("LelinkReceiver", intent.getAction());
            LelinkSdkManager.getInstance().stopPlayWithCallback(1000);
        }
    }
}
