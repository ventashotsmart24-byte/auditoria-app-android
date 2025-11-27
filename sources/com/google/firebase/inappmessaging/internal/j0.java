package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class j0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10287a;

    public /* synthetic */ j0(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f10287a = inAppMessageStreamManager;
    }

    public final boolean test(Object obj) {
        return this.f10287a.lambda$getTriggeredInAppMessageMaybe$25((CampaignProto.ThickContent) obj);
    }
}
