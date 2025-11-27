package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.b;

public final class c extends a {
    private static boolean c(LogDto logDto) {
        if (logDto.isCp() || ((1 == logDto.getLogProtocol() && !logDto.isSendImediately()) || 1 == logDto.getLogBodyType())) {
            return true;
        }
        return false;
    }

    public final void a(LogDto logDto) {
        if (c(logDto)) {
            b(logDto);
            return;
        }
        byte[] a10 = b.a(logDto.getData());
        if (a10 == null) {
            Log.w("efs.base", "gzip error");
            b(logDto);
            return;
        }
        logDto.setData(a10);
        logDto.setCp("gzip");
        b(logDto);
    }
}
