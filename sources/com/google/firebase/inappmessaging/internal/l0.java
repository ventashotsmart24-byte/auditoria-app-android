package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import java.util.Comparator;

public final /* synthetic */ class l0 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return InAppMessageStreamManager.compareByPriority((CampaignProto.ThickContent) obj, (CampaignProto.ThickContent) obj2);
    }
}
