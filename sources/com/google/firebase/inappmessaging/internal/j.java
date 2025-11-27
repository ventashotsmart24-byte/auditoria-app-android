package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.model.InAppMessage;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeveloperListenerManager.ImpressionExecutorAndListener f10285a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessage f10286b;

    public /* synthetic */ j(DeveloperListenerManager.ImpressionExecutorAndListener impressionExecutorAndListener, InAppMessage inAppMessage) {
        this.f10285a = impressionExecutorAndListener;
        this.f10286b = inAppMessage;
    }

    public final void run() {
        this.f10285a.getListener().impressionDetected(this.f10286b);
    }
}
