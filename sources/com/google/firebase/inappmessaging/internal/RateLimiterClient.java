package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import com.google.firebase.inappmessaging.internal.time.Clock;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RateLimiterClient {
    private static final RateLimitProto.RateLimit EMPTY_RATE_LIMITS = RateLimitProto.RateLimit.getDefaultInstance();
    private Maybe<RateLimitProto.RateLimit> cachedRateLimts = Maybe.empty();
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    @Inject
    public RateLimiterClient(@RateLimit ProtoStorageClient protoStorageClient, Clock clock2) {
        this.storageClient = protoStorageClient;
        this.clock = clock2;
    }

    private void clearInMemCache() {
        this.cachedRateLimts = Maybe.empty();
    }

    private Maybe<RateLimitProto.RateLimit> getRateLimits() {
        return this.cachedRateLimts.switchIfEmpty(this.storageClient.read(RateLimitProto.RateLimit.parser()).doOnSuccess(new a2(this))).doOnError(new b2(this));
    }

    private static RateLimitProto.Counter increment(RateLimitProto.Counter counter) {
        return (RateLimitProto.Counter) RateLimitProto.Counter.newBuilder(counter).clearValue().setValue(counter.getValue() + 1).build();
    }

    /* access modifiers changed from: private */
    /* renamed from: initInMemCache */
    public void lambda$increment$2(RateLimitProto.RateLimit rateLimit) {
        this.cachedRateLimts = Maybe.just(rateLimit);
    }

    private boolean isLimitExpired(RateLimitProto.Counter counter, com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        if (this.clock.now() - counter.getStartTimeEpoch() > rateLimit.timeToLiveMillis()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getRateLimits$7(Throwable th) {
        clearInMemCache();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$increment$0(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) {
        return !isLimitExpired(counter, rateLimit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ RateLimitProto.RateLimit lambda$increment$1(RateLimitProto.RateLimit rateLimit, com.google.firebase.inappmessaging.model.RateLimit rateLimit2, RateLimitProto.Counter counter) {
        return (RateLimitProto.RateLimit) RateLimitProto.RateLimit.newBuilder(rateLimit).putLimits(rateLimit2.limiterKey(), increment(counter)).build();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$increment$3(RateLimitProto.RateLimit rateLimit) {
        return this.storageClient.write(rateLimit).doOnComplete(new i2(this, rateLimit));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$increment$4(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.RateLimit rateLimit2) {
        return Observable.just(rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter())).filter(new f2(this, rateLimit)).switchIfEmpty(Observable.just(newCounter())).map(new g2(rateLimit2, rateLimit)).flatMapCompletable(new h2(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ RateLimitProto.Counter lambda$isRateLimited$5(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.RateLimit rateLimit2) {
        return rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$isRateLimited$6(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) {
        if (isLimitExpired(counter, rateLimit) || counter.getValue() < rateLimit.limit()) {
            return true;
        }
        return false;
    }

    private RateLimitProto.Counter newCounter() {
        return (RateLimitProto.Counter) RateLimitProto.Counter.newBuilder().setValue(0).setStartTimeEpoch(this.clock.now()).build();
    }

    public Single<Boolean> isRateLimited(com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return getRateLimits().switchIfEmpty(Maybe.just(RateLimitProto.RateLimit.getDefaultInstance())).map(new c2(this, rateLimit)).filter(new d2(this, rateLimit)).isEmpty();
    }

    public Completable increment(com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return getRateLimits().defaultIfEmpty(EMPTY_RATE_LIMITS).flatMapCompletable(new e2(this, rateLimit));
    }
}
