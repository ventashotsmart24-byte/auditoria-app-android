package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import io.reactivex.functions.Action;

public final /* synthetic */ class r implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DisplayCallbacksImpl f10313a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType f10314b;

    public /* synthetic */ r(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        this.f10313a = displayCallbacksImpl;
        this.f10314b = inAppMessagingDismissType;
    }

    public final void run() {
        this.f10313a.lambda$messageDismissed$2(this.f10314b);
    }
}
