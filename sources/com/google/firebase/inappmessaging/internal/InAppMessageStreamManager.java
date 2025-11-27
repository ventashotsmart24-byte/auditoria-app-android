package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import fb.b;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.flowables.ConnectableFlowable;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@FirebaseAppScope
public class InAppMessageStreamManager {
    public static final String ON_FOREGROUND = "ON_FOREGROUND";
    private final AbtIntegrationHelper abtIntegrationHelper;
    private final AnalyticsEventsManager analyticsEventsManager;
    private final ApiClient apiClient;
    private final ConnectableFlowable<String> appForegroundEventFlowable;
    private final RateLimit appForegroundRateLimit;
    @Blocking
    private final Executor blockingExecutor;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ImpressionStorageClient impressionStorageClient;
    private final ConnectableFlowable<String> programmaticTriggerEventFlowable;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final TestDeviceHelper testDeviceHelper;

    /* renamed from: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase[] r0 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase = r0
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.IMAGE_ONLY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.MODAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.CARD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager.AnonymousClass1.<clinit>():void");
        }
    }

    @Inject
    public InAppMessageStreamManager(@AppForeground ConnectableFlowable<String> connectableFlowable, @ProgrammaticTrigger ConnectableFlowable<String> connectableFlowable2, CampaignCacheClient campaignCacheClient2, Clock clock2, ApiClient apiClient2, AnalyticsEventsManager analyticsEventsManager2, Schedulers schedulers2, ImpressionStorageClient impressionStorageClient2, RateLimiterClient rateLimiterClient2, @AppForeground RateLimit rateLimit, TestDeviceHelper testDeviceHelper2, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionHelper dataCollectionHelper2, AbtIntegrationHelper abtIntegrationHelper2, @Blocking Executor executor) {
        this.appForegroundEventFlowable = connectableFlowable;
        this.programmaticTriggerEventFlowable = connectableFlowable2;
        this.campaignCacheClient = campaignCacheClient2;
        this.clock = clock2;
        this.apiClient = apiClient2;
        this.analyticsEventsManager = analyticsEventsManager2;
        this.schedulers = schedulers2;
        this.impressionStorageClient = impressionStorageClient2;
        this.rateLimiterClient = rateLimiterClient2;
        this.appForegroundRateLimit = rateLimit;
        this.testDeviceHelper = testDeviceHelper2;
        this.dataCollectionHelper = dataCollectionHelper2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.abtIntegrationHelper = abtIntegrationHelper2;
        this.blockingExecutor = executor;
    }

    public static FetchEligibleCampaignsResponse cacheExpiringResponse() {
        return (FetchEligibleCampaignsResponse) FetchEligibleCampaignsResponse.newBuilder().setExpirationEpochTimestampMillis(1).build();
    }

    /* access modifiers changed from: private */
    public static int compareByPriority(CampaignProto.ThickContent thickContent, CampaignProto.ThickContent thickContent2) {
        if (thickContent.getIsTestCampaign() && !thickContent2.getIsTestCampaign()) {
            return -1;
        }
        if (!thickContent2.getIsTestCampaign() || thickContent.getIsTestCampaign()) {
            return Integer.compare(thickContent.getPriority().getValue(), thickContent2.getPriority().getValue());
        }
        return 1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean containsTriggeringCondition(java.lang.String r4, com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContent r5) {
        /*
            boolean r0 = isAppForegroundEvent((java.lang.String) r4)
            r1 = 1
            if (r0 == 0) goto L_0x000e
            boolean r0 = r5.getIsTestCampaign()
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            java.util.List r5 = r5.getTriggeringConditionsList()
            java.util.Iterator r5 = r5.iterator()
        L_0x0016:
            boolean r0 = r5.hasNext()
            r2 = 0
            if (r0 == 0) goto L_0x003d
            java.lang.Object r0 = r5.next()
            com.google.firebase.inappmessaging.CommonTypesProto$TriggeringCondition r0 = (com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition) r0
            boolean r3 = hasFiamTrigger(r0, r4)
            if (r3 != 0) goto L_0x002f
            boolean r0 = hasAnalyticsTrigger(r0, r4)
            if (r0 == 0) goto L_0x0016
        L_0x002f:
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r5[r2] = r4
            java.lang.String r4 = "The event %s is contained in the list of triggers"
            java.lang.String r4 = java.lang.String.format(r4, r5)
            com.google.firebase.inappmessaging.internal.Logging.logd(r4)
            return r1
        L_0x003d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager.containsTriggeringCondition(java.lang.String, com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: getContentIfNotRateLimited */
    public Maybe<CampaignProto.ThickContent> lambda$createFirebaseInAppMessageStream$12(String str, CampaignProto.ThickContent thickContent) {
        if (thickContent.getIsTestCampaign() || !isAppForegroundEvent(str)) {
            return Maybe.just(thickContent);
        }
        return this.rateLimiterClient.isRateLimited(this.appForegroundRateLimit).doOnSuccess(new o0()).onErrorResumeNext(Single.just(Boolean.FALSE)).filter(new p0()).map(new q0(thickContent));
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent, io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent>>] */
    /* JADX WARNING: type inference failed for: r5v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent, io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent>>] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: getTriggeredInAppMessageMaybe */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Maybe<com.google.firebase.inappmessaging.model.TriggeredInAppMessage> lambda$createFirebaseInAppMessageStream$14(java.lang.String r2, io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContent, io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContent>> r3, io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContent, io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContent>> r4, io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContent, io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContent>> r5, com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse r6) {
        /*
            r1 = this;
            java.util.List r6 = r6.getMessagesList()
            io.reactivex.Flowable r6 = io.reactivex.Flowable.fromIterable(r6)
            com.google.firebase.inappmessaging.internal.j0 r0 = new com.google.firebase.inappmessaging.internal.j0
            r0.<init>(r1)
            io.reactivex.Flowable r6 = r6.filter(r0)
            com.google.firebase.inappmessaging.internal.k0 r0 = new com.google.firebase.inappmessaging.internal.k0
            r0.<init>(r2)
            io.reactivex.Flowable r6 = r6.filter(r0)
            io.reactivex.Flowable r3 = r6.flatMapMaybe(r3)
            io.reactivex.Flowable r3 = r3.flatMapMaybe(r4)
            io.reactivex.Flowable r3 = r3.flatMapMaybe(r5)
            com.google.firebase.inappmessaging.internal.l0 r4 = new com.google.firebase.inappmessaging.internal.l0
            r4.<init>()
            io.reactivex.Flowable r3 = r3.sorted(r4)
            io.reactivex.Maybe r3 = r3.firstElement()
            com.google.firebase.inappmessaging.internal.m0 r4 = new com.google.firebase.inappmessaging.internal.m0
            r4.<init>(r1, r2)
            io.reactivex.Maybe r2 = r3.flatMap(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$14(java.lang.String, io.reactivex.functions.Function, io.reactivex.functions.Function, io.reactivex.functions.Function, com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse):io.reactivex.Maybe");
    }

    private static boolean hasAnalyticsTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getEvent().getName().equals(str);
    }

    private static boolean hasFiamTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getFiamTrigger().toString().equals(str);
    }

    private static boolean isActive(Clock clock2, CampaignProto.ThickContent thickContent) {
        long j10;
        long j11;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            j11 = thickContent.getVanillaPayload().getCampaignStartTimeMillis();
            j10 = thickContent.getVanillaPayload().getCampaignEndTimeMillis();
        } else if (!thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            return false;
        } else {
            j11 = thickContent.getExperimentalPayload().getCampaignStartTimeMillis();
            j10 = thickContent.getExperimentalPayload().getCampaignEndTimeMillis();
        }
        long now = clock2.now();
        if (now <= j11 || now >= j10) {
            return false;
        }
        return true;
    }

    public static boolean isAppForegroundEvent(CommonTypesProto.TriggeringCondition triggeringCondition) {
        return triggeringCondition.getFiamTrigger().toString().equals(ON_FOREGROUND);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ CampaignProto.ThickContent lambda$createFirebaseInAppMessageStream$10(CampaignProto.ThickContent thickContent, Boolean bool) {
        return thickContent;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$11(CampaignProto.ThickContent thickContent) {
        if (thickContent.getIsTestCampaign()) {
            return Maybe.just(thickContent);
        }
        return this.impressionStorageClient.isImpressed(thickContent).doOnError(new h1()).onErrorResumeNext(Single.just(Boolean.FALSE)).doOnSuccess(new i1(thickContent)).filter(new j1()).map(new k1(thickContent));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$13(CampaignProto.ThickContent thickContent) {
        int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[thickContent.getContent().getMessageDetailsCase().ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            return Maybe.just(thickContent);
        }
        Logging.logd("Filtering non-displayable message");
        return Maybe.empty();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ FetchEligibleCampaignsResponse lambda$createFirebaseInAppMessageStream$16(CampaignImpressionList campaignImpressionList, InstallationIdResult installationIdResult) {
        return this.apiClient.getFiams(installationIdResult, campaignImpressionList);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createFirebaseInAppMessageStream$18(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.impressionStorageClient.clearImpressions(fetchEligibleCampaignsResponse).subscribe();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$20(Maybe maybe, CampaignImpressionList campaignImpressionList) {
        if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logi("Automatic data collection is disabled, not attempting campaign fetch from service.");
            return Maybe.just(cacheExpiringResponse());
        }
        Maybe doOnSuccess = maybe.filter(new x0()).map(new y0(this, campaignImpressionList)).switchIfEmpty(Maybe.just(cacheExpiringResponse())).doOnSuccess(new z0()).doOnSuccess(new a1(this));
        AnalyticsEventsManager analyticsEventsManager2 = this.analyticsEventsManager;
        Objects.requireNonNull(analyticsEventsManager2);
        Maybe doOnSuccess2 = doOnSuccess.doOnSuccess(new b1(analyticsEventsManager2));
        TestDeviceHelper testDeviceHelper2 = this.testDeviceHelper;
        Objects.requireNonNull(testDeviceHelper2);
        return doOnSuccess2.doOnSuccess(new c1(testDeviceHelper2)).doOnError(new d1()).onErrorResumeNext(Maybe.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ b lambda$createFirebaseInAppMessageStream$21(String str) {
        Maybe<FetchEligibleCampaignsResponse> onErrorResumeNext = this.campaignCacheClient.get().doOnSuccess(new i0()).doOnError(new t0()).onErrorResumeNext(Maybe.empty());
        e1 e1Var = new e1(this);
        o1 o1Var = new o1(this, str, new l1(this), new m1(this, str), new n1());
        Maybe onErrorResumeNext2 = this.impressionStorageClient.getAllImpressions().doOnError(new p1()).defaultIfEmpty(CampaignImpressionList.getDefaultInstance()).onErrorResumeNext(Maybe.just(CampaignImpressionList.getDefaultInstance()));
        r1 r1Var = new r1(this, Maybe.zip(taskToMaybe(this.firebaseInstallations.getId(), this.blockingExecutor), taskToMaybe(this.firebaseInstallations.getToken(false), this.blockingExecutor), new q1()).observeOn(this.schedulers.io()));
        if (shouldIgnoreCache(str)) {
            Logging.logi(String.format("Forcing fetch from service rather than cache. Test Device: %s | App Fresh Install: %s", new Object[]{Boolean.valueOf(this.testDeviceHelper.isDeviceInTestMode()), Boolean.valueOf(this.testDeviceHelper.isAppInstallFresh())}));
            return onErrorResumeNext2.flatMap(r1Var).flatMap(o1Var).toFlowable();
        }
        Logging.logd("Attempting to fetch campaigns using cache");
        return onErrorResumeNext.switchIfEmpty((MaybeSource<? extends FetchEligibleCampaignsResponse>) onErrorResumeNext2.flatMap(r1Var).doOnSuccess(e1Var)).flatMap(o1Var).toFlowable();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createFirebaseInAppMessageStream$6(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.campaignCacheClient.put(fetchEligibleCampaignsResponse).doOnComplete(new u0()).doOnError(new v0()).onErrorResumeNext(new w0()).subscribe();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createFirebaseInAppMessageStream$9(Boolean bool) {
        return !bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getContentIfNotRateLimited$23(Boolean bool) {
        return !bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ CampaignProto.ThickContent lambda$getContentIfNotRateLimited$24(CampaignProto.ThickContent thickContent, Boolean bool) {
        return thickContent;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getTriggeredInAppMessageMaybe$25(CampaignProto.ThickContent thickContent) {
        if (this.testDeviceHelper.isDeviceInTestMode() || isActive(this.clock, thickContent)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$28(MaybeEmitter maybeEmitter, Object obj) {
        maybeEmitter.onSuccess(obj);
        maybeEmitter.onComplete();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$29(MaybeEmitter maybeEmitter, Exception exc) {
        maybeEmitter.onError(exc);
        maybeEmitter.onComplete();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$taskToMaybe$30(Task task, Executor executor, MaybeEmitter maybeEmitter) {
        task.addOnSuccessListener(executor, new r0(maybeEmitter));
        task.addOnFailureListener(executor, (OnFailureListener) new s0(maybeEmitter));
    }

    /* access modifiers changed from: private */
    public static void logImpressionStatus(CampaignProto.ThickContent thickContent, Boolean bool) {
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            Logging.logi(String.format("Already impressed campaign %s ? : %s", new Object[]{thickContent.getVanillaPayload().getCampaignName(), bool}));
        } else if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            Logging.logi(String.format("Already impressed experiment %s ? : %s", new Object[]{thickContent.getExperimentalPayload().getCampaignName(), bool}));
        }
    }

    private boolean shouldIgnoreCache(String str) {
        if (this.testDeviceHelper.isAppInstallFresh()) {
            return isAppForegroundEvent(str);
        }
        return this.testDeviceHelper.isDeviceInTestMode();
    }

    private static <T> Maybe<T> taskToMaybe(Task<T> task, @Blocking Executor executor) {
        return Maybe.create(new n0(task, executor));
    }

    /* access modifiers changed from: private */
    /* renamed from: triggeredInAppMessage */
    public Maybe<TriggeredInAppMessage> lambda$getTriggeredInAppMessageMaybe$27(CampaignProto.ThickContent thickContent, String str) {
        String str2;
        String str3;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            str3 = thickContent.getVanillaPayload().getCampaignId();
            str2 = thickContent.getVanillaPayload().getCampaignName();
        } else if (!thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            return Maybe.empty();
        } else {
            str3 = thickContent.getExperimentalPayload().getCampaignId();
            str2 = thickContent.getExperimentalPayload().getCampaignName();
            if (!thickContent.getIsTestCampaign()) {
                this.abtIntegrationHelper.setExperimentActive(thickContent.getExperimentalPayload().getExperimentPayload());
            }
        }
        InAppMessage decode = ProtoMarshallerClient.decode(thickContent.getContent(), str3, str2, thickContent.getIsTestCampaign(), thickContent.getDataBundleMap());
        if (decode.getMessageType().equals(MessageType.UNSUPPORTED)) {
            return Maybe.empty();
        }
        return Maybe.just(new TriggeredInAppMessage(decode, str));
    }

    /* access modifiers changed from: private */
    public static boolean validIID(InstallationIdResult installationIdResult) {
        if (TextUtils.isEmpty(installationIdResult.installationId()) || TextUtils.isEmpty(installationIdResult.installationTokenResult().getToken())) {
            return false;
        }
        return true;
    }

    public Flowable<TriggeredInAppMessage> createFirebaseInAppMessageStream() {
        return Flowable.merge((b) this.appForegroundEventFlowable, (b) this.analyticsEventsManager.getAnalyticsEventsFlowable(), (b) this.programmaticTriggerEventFlowable).doOnNext(new f1()).observeOn(this.schedulers.io()).concatMap(new g1(this)).observeOn(this.schedulers.mainThread());
    }

    public static boolean isAppForegroundEvent(String str) {
        return str.equals(ON_FOREGROUND);
    }
}
