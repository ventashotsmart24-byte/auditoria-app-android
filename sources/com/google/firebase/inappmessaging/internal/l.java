package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeveloperListenerManager.ClicksExecutorAndListener f10292a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessage f10293b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Action f10294c;

    public /* synthetic */ l(DeveloperListenerManager.ClicksExecutorAndListener clicksExecutorAndListener, InAppMessage inAppMessage, Action action) {
        this.f10292a = clicksExecutorAndListener;
        this.f10293b = inAppMessage;
        this.f10294c = action;
    }

    public final void run() {
        this.f10292a.getListener().messageClicked(this.f10293b, this.f10294c);
    }
}
