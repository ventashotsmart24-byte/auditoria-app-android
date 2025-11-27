package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.model.InAppMessage;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeveloperListenerManager.DismissExecutorAndListener f10288a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessage f10289b;

    public /* synthetic */ k(DeveloperListenerManager.DismissExecutorAndListener dismissExecutorAndListener, InAppMessage inAppMessage) {
        this.f10288a = dismissExecutorAndListener;
        this.f10289b = inAppMessage;
    }

    public final void run() {
        this.f10288a.getListener().messageDismissed(this.f10289b);
    }
}
