package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class o0 implements Consumer {
    public final void accept(Object obj) {
        Logging.logi("App foreground rate limited ? : " + ((Boolean) obj));
    }
}
