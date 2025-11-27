package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class d implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsRegistrar f10203a;

    public /* synthetic */ d(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.f10203a = crashlyticsRegistrar;
    }

    public final Object create(ComponentContainer componentContainer) {
        return this.f10203a.buildCrashlytics(componentContainer);
    }
}
