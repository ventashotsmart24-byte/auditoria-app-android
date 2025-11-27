package com.google.firebase.crashlytics.ndk;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsNdkRegistrar f10221a;

    public /* synthetic */ a(CrashlyticsNdkRegistrar crashlyticsNdkRegistrar) {
        this.f10221a = crashlyticsNdkRegistrar;
    }

    public final Object create(ComponentContainer componentContainer) {
        return this.f10221a.buildCrashlyticsNdk(componentContainer);
    }
}
