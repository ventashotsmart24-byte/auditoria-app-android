package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class v0 implements Consumer {
    public final void accept(Object obj) {
        Logging.logw("Cache write error: " + ((Throwable) obj).getMessage());
    }
}
