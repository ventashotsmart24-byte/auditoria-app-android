package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInAppMessaging f10232a;

    public /* synthetic */ b(FirebaseInAppMessaging firebaseInAppMessaging) {
        this.f10232a = firebaseInAppMessaging;
    }

    public final void accept(Object obj) {
        this.f10232a.triggerInAppMessage((TriggeredInAppMessage) obj);
    }
}
