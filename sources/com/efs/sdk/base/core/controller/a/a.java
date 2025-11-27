package com.efs.sdk.base.core.controller.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;

public final class a extends BroadcastReceiver implements Runnable {
    public final void onReceive(Context context, Intent intent) {
        WorkThreadUtil.submit(this);
    }

    public final void run() {
        GlobalInfoManager.getInstance().refreshNetStatus();
    }
}
