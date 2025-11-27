package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i1 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CampaignProto.ThickContent f10282a;

    public /* synthetic */ i1(CampaignProto.ThickContent thickContent) {
        this.f10282a = thickContent;
    }

    public final void accept(Object obj) {
        InAppMessageStreamManager.logImpressionStatus(this.f10282a, (Boolean) obj);
    }
}
