package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
public class CampaignCacheClient {
    private final Application application;
    @Nullable
    private FetchEligibleCampaignsResponse cachedResponse;
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    @Inject
    public CampaignCacheClient(@CampaignCache ProtoStorageClient protoStorageClient, Application application2, Clock clock2) {
        this.storageClient = protoStorageClient;
        this.application = application2;
        this.clock = clock2;
    }

    /* access modifiers changed from: private */
    public boolean isResponseValid(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        long expirationEpochTimestampMillis = fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis();
        long now = this.clock.now();
        File file = new File(this.application.getApplicationContext().getFilesDir(), ProtoStorageClientModule.CAMPAIGN_CACHE_FILE);
        if (expirationEpochTimestampMillis != 0) {
            if (now < expirationEpochTimestampMillis) {
                return true;
            }
            return false;
        } else if (!file.exists() || now < file.lastModified() + TimeUnit.DAYS.toMillis(1)) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ FetchEligibleCampaignsResponse lambda$get$1() {
        return this.cachedResponse;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$get$2(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.cachedResponse = fetchEligibleCampaignsResponse;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$get$3(Throwable th) {
        this.cachedResponse = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$put$0(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.cachedResponse = fetchEligibleCampaignsResponse;
    }

    public Maybe<FetchEligibleCampaignsResponse> get() {
        return Maybe.fromCallable(new d(this)).switchIfEmpty(this.storageClient.read(FetchEligibleCampaignsResponse.parser()).doOnSuccess(new e(this))).filter(new f(this)).doOnError(new g(this));
    }

    public Completable put(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return this.storageClient.write(fetchEligibleCampaignsResponse).doOnComplete(new c(this, fetchEligibleCampaignsResponse));
    }
}
