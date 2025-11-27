package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Function;

public final /* synthetic */ class c0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImpressionStorageClient f10254a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignImpression f10255b;

    public /* synthetic */ c0(ImpressionStorageClient impressionStorageClient, CampaignImpression campaignImpression) {
        this.f10254a = impressionStorageClient;
        this.f10255b = campaignImpression;
    }

    public final Object apply(Object obj) {
        return this.f10254a.lambda$storeImpression$1(this.f10255b, (CampaignImpressionList) obj);
    }
}
