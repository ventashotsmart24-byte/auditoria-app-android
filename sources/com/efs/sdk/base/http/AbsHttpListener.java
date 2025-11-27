package com.efs.sdk.base.http;

import com.efs.sdk.base.core.util.concurrent.b;

public abstract class AbsHttpListener implements b<HttpResponse> {
    public abstract void onError(HttpResponse httpResponse);

    public abstract void onSuccess(HttpResponse httpResponse);

    public void result(HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ) {
            onError(httpResponse);
        } else {
            onSuccess(httpResponse);
        }
    }
}
