package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ImpressionStorageClient {
    private static final CampaignImpressionList EMPTY_IMPRESSIONS = CampaignImpressionList.getDefaultInstance();
    private Maybe<CampaignImpressionList> cachedImpressionsMaybe = Maybe.empty();
    private final ProtoStorageClient storageClient;

    @Inject
    public ImpressionStorageClient(@ImpressionStore ProtoStorageClient protoStorageClient) {
        this.storageClient = protoStorageClient;
    }

    private static CampaignImpressionList appendImpression(CampaignImpressionList campaignImpressionList, CampaignImpression campaignImpression) {
        return (CampaignImpressionList) CampaignImpressionList.newBuilder(campaignImpressionList).addAlreadySeenCampaigns(campaignImpression).build();
    }

    private void clearInMemCache() {
        this.cachedImpressionsMaybe = Maybe.empty();
    }

    /* access modifiers changed from: private */
    /* renamed from: initInMemCache */
    public void lambda$storeImpression$0(CampaignImpressionList campaignImpressionList) {
        this.cachedImpressionsMaybe = Maybe.just(campaignImpressionList);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$clearImpressions$4(HashSet hashSet, CampaignImpressionList campaignImpressionList) {
        Logging.logd("Existing impressions: " + campaignImpressionList.toString());
        CampaignImpressionList.Builder newBuilder = CampaignImpressionList.newBuilder();
        for (CampaignImpression next : campaignImpressionList.getAlreadySeenCampaignsList()) {
            if (!hashSet.contains(next.getCampaignId())) {
                newBuilder.addAlreadySeenCampaigns(next);
            }
        }
        CampaignImpressionList campaignImpressionList2 = (CampaignImpressionList) newBuilder.build();
        Logging.logd("New cleared impression list: " + campaignImpressionList2.toString());
        return this.storageClient.write(campaignImpressionList2).doOnComplete(new d0(this, campaignImpressionList2));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllImpressions$2(Throwable th) {
        clearInMemCache();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$storeImpression$1(CampaignImpression campaignImpression, CampaignImpressionList campaignImpressionList) {
        CampaignImpressionList appendImpression = appendImpression(campaignImpressionList, campaignImpression);
        return this.storageClient.write(appendImpression).doOnComplete(new b0(this, appendImpression));
    }

    public Completable clearImpressions(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        String str;
        HashSet hashSet = new HashSet();
        for (CampaignProto.ThickContent next : fetchEligibleCampaignsResponse.getMessagesList()) {
            if (next.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
                str = next.getVanillaPayload().getCampaignId();
            } else {
                str = next.getExperimentalPayload().getCampaignId();
            }
            hashSet.add(str);
        }
        Logging.logd("Potential impressions to clear: " + hashSet.toString());
        return getAllImpressions().defaultIfEmpty(EMPTY_IMPRESSIONS).flatMapCompletable(new h0(this, hashSet));
    }

    public Maybe<CampaignImpressionList> getAllImpressions() {
        return this.cachedImpressionsMaybe.switchIfEmpty(this.storageClient.read(CampaignImpressionList.parser()).doOnSuccess(new z(this))).doOnError(new a0(this));
    }

    public Single<Boolean> isImpressed(CampaignProto.ThickContent thickContent) {
        String str;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            str = thickContent.getVanillaPayload().getCampaignId();
        } else {
            str = thickContent.getExperimentalPayload().getCampaignId();
        }
        return getAllImpressions().map(new e0()).flatMapObservable(new f0()).map(new g0()).contains(str);
    }

    public Completable storeImpression(CampaignImpression campaignImpression) {
        return getAllImpressions().defaultIfEmpty(EMPTY_IMPRESSIONS).flatMapCompletable(new c0(this, campaignImpression));
    }
}
