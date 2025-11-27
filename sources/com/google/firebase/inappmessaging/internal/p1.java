package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class p1 implements Consumer {
    public final void accept(Object obj) {
        Logging.logw("Impressions store read fail: " + ((Throwable) obj).getMessage());
    }
}
