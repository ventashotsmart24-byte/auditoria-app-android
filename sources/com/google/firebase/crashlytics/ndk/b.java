package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.ndk.FirebaseCrashlyticsNdk;

public final /* synthetic */ class b implements FirebaseCrashlyticsNdk.SignalHandlerInstaller {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseCrashlyticsNdk f10222a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10223b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f10224c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f10225d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ StaticSessionData f10226e;

    public /* synthetic */ b(FirebaseCrashlyticsNdk firebaseCrashlyticsNdk, String str, String str2, long j10, StaticSessionData staticSessionData) {
        this.f10222a = firebaseCrashlyticsNdk;
        this.f10223b = str;
        this.f10224c = str2;
        this.f10225d = j10;
        this.f10226e = staticSessionData;
    }

    public final void installHandler() {
        this.f10222a.lambda$prepareNativeSession$0(this.f10223b, this.f10224c, this.f10225d, this.f10226e);
    }
}
