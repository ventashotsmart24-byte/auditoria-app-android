package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;

public class DisplayCallbacksImpl implements FirebaseInAppMessagingDisplayCallbacks {
    private static final String MESSAGE_CLICK = "message click to metrics logger";
    private final RateLimit appForegroundRateLimit;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final ImpressionStorageClient impressionStorageClient;
    private final InAppMessage inAppMessage;
    private final MetricsLoggerClient metricsLoggerClient;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final String triggeringEvent;
    private boolean wasImpressed = false;

    @VisibleForTesting
    public DisplayCallbacksImpl(ImpressionStorageClient impressionStorageClient2, Clock clock2, Schedulers schedulers2, RateLimiterClient rateLimiterClient2, CampaignCacheClient campaignCacheClient2, RateLimit rateLimit, MetricsLoggerClient metricsLoggerClient2, DataCollectionHelper dataCollectionHelper2, InAppMessage inAppMessage2, String str) {
        this.impressionStorageClient = impressionStorageClient2;
        this.clock = clock2;
        this.schedulers = schedulers2;
        this.rateLimiterClient = rateLimiterClient2;
        this.campaignCacheClient = campaignCacheClient2;
        this.appForegroundRateLimit = rateLimit;
        this.metricsLoggerClient = metricsLoggerClient2;
        this.dataCollectionHelper = dataCollectionHelper2;
        this.inAppMessage = inAppMessage2;
        this.triggeringEvent = str;
    }

    private boolean actionMatches(Action action, Action action2) {
        if (action != null) {
            return action.getActionUrl().equals(action2.getActionUrl());
        }
        if (action2 == null || TextUtils.isEmpty(action2.getActionUrl())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$displayErrorEncountered$4(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        this.metricsLoggerClient.logRenderError(this.inAppMessage, inAppMessagingErrorReason);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$impressionDetected$0() {
        this.metricsLoggerClient.logImpression(this.inAppMessage);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$logMessageClick$3(Action action) {
        this.metricsLoggerClient.logMessageClick(this.inAppMessage, action);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ MaybeSource lambda$maybeToTask$10(TaskCompletionSource taskCompletionSource, Throwable th) {
        if (th instanceof Exception) {
            taskCompletionSource.setException((Exception) th);
        } else {
            taskCompletionSource.setException(new RuntimeException(th));
        }
        return Maybe.empty();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$messageDismissed$2(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        this.metricsLoggerClient.logDismiss(this.inAppMessage, inAppMessagingDismissType);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateWasImpressed$1() {
        this.wasImpressed = true;
    }

    private void logActionNotTaken(String str, Maybe<String> maybe) {
        if (maybe != null) {
            Logging.logd(String.format("Not recording: %s. Reason: %s", new Object[]{str, maybe}));
        } else if (this.inAppMessage.getCampaignMetadata().getIsTestMessage()) {
            Logging.logd(String.format("Not recording: %s. Reason: Message is test message", new Object[]{str}));
        } else if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logd(String.format("Not recording: %s. Reason: Data collection is disabled", new Object[]{str}));
        } else {
            Logging.logd(String.format("Not recording: %s", new Object[]{str}));
        }
    }

    private Task<Void> logImpressionIfNeeded(Completable completable) {
        if (!this.wasImpressed) {
            impressionDetected();
        }
        return maybeToTask(completable.toMaybe(), this.schedulers.io());
    }

    private Task<Void> logMessageClick(Action action) {
        Logging.logd("Attempting to record: message click to metrics logger");
        return logImpressionIfNeeded(Completable.fromAction(new s(this, action)));
    }

    private Completable logToImpressionStore() {
        String campaignId = this.inAppMessage.getCampaignMetadata().getCampaignId();
        Logging.logd("Attempting to record message impression in impression store for id: " + campaignId);
        Completable doOnComplete = this.impressionStorageClient.storeImpression((CampaignImpression) CampaignImpression.newBuilder().setImpressionTimestampMillis(this.clock.now()).setCampaignId(campaignId).build()).doOnError(new t()).doOnComplete(new u());
        if (InAppMessageStreamManager.isAppForegroundEvent(this.triggeringEvent)) {
            return this.rateLimiterClient.increment(this.appForegroundRateLimit).doOnError(new v()).doOnComplete(new w()).onErrorComplete().andThen((CompletableSource) doOnComplete);
        }
        return doOnComplete;
    }

    private static <T> Task<T> maybeToTask(Maybe<T> maybe, Scheduler scheduler) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        maybe.doOnSuccess(new m(taskCompletionSource)).switchIfEmpty(Maybe.fromCallable(new p(taskCompletionSource))).onErrorResumeNext(new q(taskCompletionSource)).subscribeOn(scheduler).subscribe();
        return taskCompletionSource.getTask();
    }

    private boolean shouldLog() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    private Completable updateWasImpressed() {
        return Completable.fromAction(new o(this));
    }

    public Task<Void> displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (shouldLog()) {
            Logging.logd("Attempting to record: " + "render error to metrics logger");
            return maybeToTask(logToImpressionStore().andThen((CompletableSource) Completable.fromAction(new x(this, inAppMessagingErrorReason))).andThen((CompletableSource) updateWasImpressed()).toMaybe(), this.schedulers.io());
        }
        logActionNotTaken("render error to metrics logger");
        return new TaskCompletionSource().getTask();
    }

    public Task<Void> impressionDetected() {
        if (!shouldLog() || this.wasImpressed) {
            logActionNotTaken("message impression to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: " + "message impression to metrics logger");
        return maybeToTask(logToImpressionStore().andThen((CompletableSource) Completable.fromAction(new n(this))).andThen((CompletableSource) updateWasImpressed()).toMaybe(), this.schedulers.io());
    }

    @Deprecated
    public Task<Void> messageClicked() {
        return messageClicked(this.inAppMessage.getAction());
    }

    public Task<Void> messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (shouldLog()) {
            Logging.logd("Attempting to record: " + "message dismissal to metrics logger");
            return logImpressionIfNeeded(Completable.fromAction(new r(this, inAppMessagingDismissType)));
        }
        logActionNotTaken("message dismissal to metrics logger");
        return new TaskCompletionSource().getTask();
    }

    @VisibleForTesting
    public boolean wasImpressed() {
        return this.wasImpressed;
    }

    public Task<Void> messageClicked(Action action) {
        if (!shouldLog()) {
            logActionNotTaken(MESSAGE_CLICK);
            return new TaskCompletionSource().getTask();
        } else if (action.getActionUrl() == null) {
            return messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
        } else {
            return logMessageClick(action);
        }
    }

    private void logActionNotTaken(String str) {
        logActionNotTaken(str, (Maybe<String>) null);
    }
}
