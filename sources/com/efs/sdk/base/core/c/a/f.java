package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.config.remote.RemoteConfig;
import com.efs.sdk.base.core.config.remote.b;
import com.efs.sdk.base.core.model.LogDto;

public final class f extends a {
    public final void a(LogDto logDto) {
        double d10;
        boolean z10;
        Double d11;
        b a10 = b.a();
        String logType = logDto.getLogType();
        RemoteConfig remoteConfig = a10.f5225d;
        if (!remoteConfig.mUploadSampleRateMap.containsKey(logType) || (d11 = remoteConfig.mUploadSampleRateMap.get(logType)) == null) {
            d10 = 100.0d;
        } else {
            d10 = d11.doubleValue();
        }
        if (b.f5222a.nextDouble() * 100.0d <= d10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            b(logDto);
        }
    }
}
