package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Action;

public final /* synthetic */ class s implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DisplayCallbacksImpl f10318a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.google.firebase.inappmessaging.model.Action f10319b;

    public /* synthetic */ s(DisplayCallbacksImpl displayCallbacksImpl, com.google.firebase.inappmessaging.model.Action action) {
        this.f10318a = displayCallbacksImpl;
        this.f10319b = action;
    }

    public final void run() {
        this.f10318a.lambda$logMessageClick$3(this.f10319b);
    }
}
