package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.model.InAppMessage;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeveloperListenerManager.ErrorsExecutorAndListener f10279a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessage f10280b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason f10281c;

    public /* synthetic */ i(DeveloperListenerManager.ErrorsExecutorAndListener errorsExecutorAndListener, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        this.f10279a = errorsExecutorAndListener;
        this.f10280b = inAppMessage;
        this.f10281c = inAppMessagingErrorReason;
    }

    public final void run() {
        this.f10279a.getListener().displayErrorEncountered(this.f10280b, this.f10281c);
    }
}
