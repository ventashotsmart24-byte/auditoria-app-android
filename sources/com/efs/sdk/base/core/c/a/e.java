package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.b.c;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.http.HttpResponse;

public final class e extends a {
    public final void a(LogDto logDto) {
        HttpResponse httpResponse;
        if (!logDto.isSendImediately()) {
            b(logDto);
            return;
        }
        com.efs.sdk.base.core.b.e a10 = com.efs.sdk.base.core.b.e.a();
        if (!logDto.isLimitByFlow() || c.a().a(logDto.getLogType(), logDto.getBodySize())) {
            f.a.f5270a.f5268c.b();
            f.a.f5270a.f5268c.c();
            httpResponse = a10.f5150c.a(logDto, false);
        } else {
            httpResponse = new HttpResponse();
            httpResponse.data = "flow_limit";
        }
        logDto.setResponseDto(httpResponse);
        b(logDto);
    }
}
