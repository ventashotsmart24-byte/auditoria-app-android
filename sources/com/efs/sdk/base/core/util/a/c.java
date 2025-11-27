package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.core.util.concurrent.d;
import com.efs.sdk.base.http.HttpResponse;

public final class c extends d<HttpResponse> {

    /* renamed from: a  reason: collision with root package name */
    public b f5308a;

    public c(b bVar) {
        super(bVar);
        this.f5308a = bVar;
    }

    public final HttpResponse b() {
        this.f5308a.f5305e = "post";
        return (HttpResponse) a();
    }
}
