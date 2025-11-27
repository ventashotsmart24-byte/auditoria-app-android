package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.model.LogDto;

public final class b extends a {
    public final void a(LogDto logDto) {
        if (logDto.isSendImediately()) {
            b(logDto);
        } else {
            CacheManager.getInstance().put(logDto);
        }
    }
}
