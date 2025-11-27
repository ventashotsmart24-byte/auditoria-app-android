package com.google.firebase.messaging;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class u implements EventHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging.AutoInit f10396a;

    public /* synthetic */ u(FirebaseMessaging.AutoInit autoInit) {
        this.f10396a = autoInit;
    }

    public final void handle(Event event) {
        this.f10396a.lambda$initialize$0(event);
    }
}
