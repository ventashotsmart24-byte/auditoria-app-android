package com.hpplay.sdk.source.proxy;

import com.hpplay.sdk.source.api.ILelinkSourceSDK;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkSourceSDKImp;

public class ModuleLoader {
    private static final String SOURCE_SDK_IMPL = "com.hpplay.sdk.source.process.LelinkSourceSDKImp";
    private static final String TAG = "ModuleLoader";

    public static ILelinkSourceSDK loadSourceSDKImpl() {
        try {
            return (ILelinkSourceSDK) LelinkSourceSDKImp.class.getDeclaredMethod("getInstance", (Class[]) null).invoke(new Object[0], new Object[0]);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }
}
