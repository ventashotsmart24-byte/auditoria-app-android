package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Function;
import java.util.HashSet;

public final /* synthetic */ class h0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImpressionStorageClient f10276a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashSet f10277b;

    public /* synthetic */ h0(ImpressionStorageClient impressionStorageClient, HashSet hashSet) {
        this.f10276a = impressionStorageClient;
        this.f10277b = hashSet;
    }

    public final Object apply(Object obj) {
        return this.f10276a.lambda$clearImpressions$4(this.f10277b, (CampaignImpressionList) obj);
    }
}
