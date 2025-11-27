package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import io.reactivex.functions.Action;

public final /* synthetic */ class x implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DisplayCallbacksImpl f10333a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason f10334b;

    public /* synthetic */ x(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        this.f10333a = displayCallbacksImpl;
        this.f10334b = inAppMessagingErrorReason;
    }

    public final void run() {
        this.f10333a.lambda$displayErrorEncountered$4(this.f10334b);
    }
}
