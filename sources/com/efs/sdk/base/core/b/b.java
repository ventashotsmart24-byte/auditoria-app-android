package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.a.a;
import com.efs.sdk.base.core.a.c;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;

public final class b implements d {
    public final HttpResponse a(LogDto logDto, boolean z10) {
        HttpResponse httpResponse;
        c a10 = c.a();
        a10.f5127d = logDto.getCp();
        a10.f5128e = logDto.getDe();
        a10.f5130g = logDto.getLogProtocol();
        a10.f5131h = logDto.getLogType();
        a10.f5138o = logDto.getBodySize();
        String a11 = com.efs.sdk.base.core.config.remote.b.a().a(false);
        Log.i("efs.LogSendAction.Codelog", "send data url is ".concat(String.valueOf(a11)));
        if (logDto.getLogBodyType() == 0) {
            httpResponse = a.a().a(a11, a10, logDto.getData(), logDto.isLimitByFlow());
        } else if (1 == logDto.getLogBodyType()) {
            httpResponse = a.a().a(a11, a10, logDto.getFile(), logDto.isLimitByFlow());
        } else {
            httpResponse = new HttpResponse();
        }
        if (httpResponse.succ && z10) {
            FileUtil.delete(logDto.getFile());
        }
        return httpResponse;
    }
}
