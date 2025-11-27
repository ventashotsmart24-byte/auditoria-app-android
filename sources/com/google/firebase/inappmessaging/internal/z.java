package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class z implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImpressionStorageClient f10341a;

    public /* synthetic */ z(ImpressionStorageClient impressionStorageClient) {
        this.f10341a = impressionStorageClient;
    }

    public final void accept(Object obj) {
        this.f10341a.lambda$storeImpression$0((CampaignImpressionList) obj);
    }
}
