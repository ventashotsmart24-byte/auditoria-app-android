package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class k0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10290a;

    public /* synthetic */ k0(String str) {
        this.f10290a = str;
    }

    public final boolean test(Object obj) {
        return InAppMessageStreamManager.containsTriggeringCondition(this.f10290a, (CampaignProto.ThickContent) obj);
    }
}
