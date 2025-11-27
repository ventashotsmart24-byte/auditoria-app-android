package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Function;

public final /* synthetic */ class e0 implements Function {
    public final Object apply(Object obj) {
        return ((CampaignImpressionList) obj).getAlreadySeenCampaignsList();
    }
}
