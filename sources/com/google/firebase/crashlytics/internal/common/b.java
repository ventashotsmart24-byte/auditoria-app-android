package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;

public final /* synthetic */ class b implements BreadcrumbHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f10209a;

    public /* synthetic */ b(CrashlyticsCore crashlyticsCore) {
        this.f10209a = crashlyticsCore;
    }

    public final void handleBreadcrumb(String str) {
        this.f10209a.log(str);
    }
}
