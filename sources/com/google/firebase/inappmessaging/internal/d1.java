package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class d1 implements Consumer {
    public final void accept(Object obj) {
        Logging.logw("Service fetch error: " + ((Throwable) obj).getMessage());
    }
}
