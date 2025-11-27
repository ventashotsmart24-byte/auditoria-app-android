package com.hpplay.sdk.source.process;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;

public class LelinkSdkService extends Service {
    private static final String TAG = "LelinkSdkService";
    private LelinkServiceBinder mBinder;

    public IBinder onBind(Intent intent) {
        SourceLog.i(TAG, "onBind");
        return this.mBinder;
    }

    public void onCreate() {
        super.onCreate();
        writeProcessPid();
        HapplayUtils.setApplication(getApplication());
        SourceLog.i(TAG, "onCreate");
        Session.initSession(getApplicationContext());
        this.mBinder = new LelinkServiceBinder(this);
    }

    public void onDestroy() {
        super.onDestroy();
        SourceLog.i(TAG, "onDestroy");
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        SourceLog.i(TAG, "onStartCommand");
        return 2;
    }

    public void writeProcessPid() {
        getSharedPreferences(Constant.KEY_PROCESS_PID, 4).edit().putInt(Constant.KEY_PROCESS_PID, Process.myPid()).apply();
    }
}
