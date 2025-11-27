package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.http.HttpResponse;

public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private LogDto f5160a;

    /* renamed from: b  reason: collision with root package name */
    private d f5161b;

    /* renamed from: c  reason: collision with root package name */
    private String f5162c;

    public f(LogDto logDto, d dVar, String str) {
        this.f5160a = logDto;
        this.f5161b = dVar;
        this.f5162c = str;
    }

    public final void run() {
        HttpResponse httpResponse;
        int i10;
        d dVar;
        LogDto logDto = this.f5160a;
        if (logDto == null || (dVar = this.f5161b) == null) {
            httpResponse = new HttpResponse();
        } else {
            httpResponse = dVar.a(logDto, true);
        }
        e a10 = e.a();
        String str = this.f5162c;
        if (httpResponse.succ) {
            i10 = 0;
        } else {
            i10 = httpResponse.getHttpCode();
        }
        a10.a(str, i10);
        this.f5162c = null;
        this.f5161b = null;
    }
}
