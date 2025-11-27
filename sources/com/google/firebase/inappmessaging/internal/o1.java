package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class o1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10306b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function f10307c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function f10308d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Function f10309e;

    public /* synthetic */ o1(InAppMessageStreamManager inAppMessageStreamManager, String str, Function function, Function function2, Function function3) {
        this.f10305a = inAppMessageStreamManager;
        this.f10306b = str;
        this.f10307c = function;
        this.f10308d = function2;
        this.f10309e = function3;
    }

    public final Object apply(Object obj) {
        return this.f10305a.lambda$createFirebaseInAppMessageStream$14(this.f10306b, this.f10307c, this.f10308d, this.f10309e, (FetchEligibleCampaignsResponse) obj);
    }
}
