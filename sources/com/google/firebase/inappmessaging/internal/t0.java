package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class t0 implements Consumer {
    public final void accept(Object obj) {
        Logging.logw("Cache read error: " + ((Throwable) obj).getMessage());
    }
}
