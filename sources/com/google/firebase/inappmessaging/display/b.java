package com.google.firebase.inappmessaging.display;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class b implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInAppMessagingDisplayRegistrar f10236a;

    public /* synthetic */ b(FirebaseInAppMessagingDisplayRegistrar firebaseInAppMessagingDisplayRegistrar) {
        this.f10236a = firebaseInAppMessagingDisplayRegistrar;
    }

    public final Object create(ComponentContainer componentContainer) {
        return this.f10236a.buildFirebaseInAppMessagingUI(componentContainer);
    }
}
