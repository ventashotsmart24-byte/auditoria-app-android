package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c1 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestDeviceHelper f10256a;

    public /* synthetic */ c1(TestDeviceHelper testDeviceHelper) {
        this.f10256a = testDeviceHelper;
    }

    public final void accept(Object obj) {
        this.f10256a.processCampaignFetch((FetchEligibleCampaignsResponse) obj);
    }
}
