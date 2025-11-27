package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.http.HttpResponse;

public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private LogDto f5163a;

    /* renamed from: b  reason: collision with root package name */
    private d f5164b;

    /* renamed from: c  reason: collision with root package name */
    private String f5165c;

    public g(LogDto logDto, d dVar, String str) {
        this.f5163a = logDto;
        this.f5164b = dVar;
        this.f5165c = str;
    }

    public final void run() {
        HttpResponse httpResponse;
        int i10;
        d dVar;
        LogDto logDto = this.f5163a;
        if (logDto == null || (dVar = this.f5164b) == null) {
            httpResponse = new HttpResponse();
        } else {
            httpResponse = dVar.a(logDto, true);
        }
        e a10 = e.a();
        String str = this.f5165c;
        if (httpResponse.succ) {
            i10 = 0;
        } else {
            i10 = httpResponse.getHttpCode();
        }
        a10.b(str, i10);
        this.f5165c = null;
        this.f5164b = null;
    }
}
