package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class h1 implements Consumer {
    public final void accept(Object obj) {
        Logging.logw("Impression store read fail: " + ((Throwable) obj).getMessage());
    }
}
