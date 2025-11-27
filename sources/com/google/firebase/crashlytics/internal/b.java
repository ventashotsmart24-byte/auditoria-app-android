package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class b implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10205a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10207c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StaticSessionData f10208d;

    public /* synthetic */ b(String str, String str2, long j10, StaticSessionData staticSessionData) {
        this.f10205a = str;
        this.f10206b = str2;
        this.f10207c = j10;
        this.f10208d = staticSessionData;
    }

    public final void handle(Provider provider) {
        ((CrashlyticsNativeComponent) provider.get()).prepareNativeSession(this.f10205a, this.f10206b, this.f10207c, this.f10208d);
    }
}
