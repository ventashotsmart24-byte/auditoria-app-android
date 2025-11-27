package com.umeng.message;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

@Deprecated
public class UmengMessageCallbackHandlerService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }
}
