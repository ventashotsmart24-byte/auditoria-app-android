package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class f1 implements Consumer {
    public final void accept(Object obj) {
        Logging.logd("Event Triggered: " + ((String) obj));
    }
}
