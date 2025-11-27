package com.google.firebase.inappmessaging;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class c implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInAppMessagingRegistrar f10233a;

    public /* synthetic */ c(FirebaseInAppMessagingRegistrar firebaseInAppMessagingRegistrar) {
        this.f10233a = firebaseInAppMessagingRegistrar;
    }

    public final Object create(ComponentContainer componentContainer) {
        return this.f10233a.providesFirebaseInAppMessaging(componentContainer);
    }
}
