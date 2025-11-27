package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.CampaignAnalytics;
import com.google.firebase.inappmessaging.ClientAppInfo;
import com.google.firebase.inappmessaging.DismissType;
import com.google.firebase.inappmessaging.EventType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.RenderErrorReason;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class MetricsLoggerClient {
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType, DismissType> dismissTransform;
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason, RenderErrorReason> errorTransform;
    private final AnalyticsConnector analyticsConnector;
    @Blocking
    private final Executor blockingExecutor;
    private final Clock clock;
    private final DeveloperListenerManager developerListenerManager;
    private final EngagementMetricsLoggerInterface engagementMetricsLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;

    /* renamed from: com.google.firebase.inappmessaging.internal.MetricsLoggerClient$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$model$MessageType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.firebase.inappmessaging.model.MessageType[] r0 = com.google.firebase.inappmessaging.model.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = r0
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.CARD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.MODAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.BANNER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.IMAGE_ONLY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.MetricsLoggerClient.AnonymousClass1.<clinit>():void");
        }
    }

    public interface EngagementMetricsLoggerInterface {
        void logEvent(byte[] bArr);
    }

    static {
        HashMap hashMap = new HashMap();
        errorTransform = hashMap;
        HashMap hashMap2 = new HashMap();
        dismissTransform = hashMap2;
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR, RenderErrorReason.UNSPECIFIED_RENDER_ERROR);
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR, RenderErrorReason.IMAGE_FETCH_ERROR);
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_DISPLAY_ERROR, RenderErrorReason.IMAGE_DISPLAY_ERROR);
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT, RenderErrorReason.IMAGE_UNSUPPORTED_FORMAT);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO, DismissType.AUTO);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK, DismissType.CLICK);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.SWIPE, DismissType.SWIPE);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE, DismissType.UNKNOWN_DISMISS_TYPE);
    }

    public MetricsLoggerClient(EngagementMetricsLoggerInterface engagementMetricsLoggerInterface, AnalyticsConnector analyticsConnector2, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock2, DeveloperListenerManager developerListenerManager2, @Blocking Executor executor) {
        this.engagementMetricsLogger = engagementMetricsLoggerInterface;
        this.analyticsConnector = analyticsConnector2;
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.clock = clock2;
        this.developerListenerManager = developerListenerManager2;
        this.blockingExecutor = executor;
    }

    private CampaignAnalytics.Builder createCampaignAnalyticsBuilder(InAppMessage inAppMessage, String str) {
        return CampaignAnalytics.newBuilder().setFiamSdkVersion("20.3.1").setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).setCampaignId(inAppMessage.getCampaignMetadata().getCampaignId()).setClientApp(ClientAppInfo.newBuilder().setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setFirebaseInstanceId(str)).setClientTimestampMillis(this.clock.now());
    }

    private CampaignAnalytics createDismissEntry(InAppMessage inAppMessage, String str, DismissType dismissType) {
        return (CampaignAnalytics) createCampaignAnalyticsBuilder(inAppMessage, str).setDismissType(dismissType).build();
    }

    private CampaignAnalytics createEventEntry(InAppMessage inAppMessage, String str, EventType eventType) {
        return (CampaignAnalytics) createCampaignAnalyticsBuilder(inAppMessage, str).setEventType(eventType).build();
    }

    private CampaignAnalytics createRenderErrorEntry(InAppMessage inAppMessage, String str, RenderErrorReason renderErrorReason) {
        return (CampaignAnalytics) createCampaignAnalyticsBuilder(inAppMessage, str).setRenderErrorReason(renderErrorReason).build();
    }

    private boolean impressionCountsAsConversion(InAppMessage inAppMessage) {
        int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage.getMessageType().ordinal()];
        if (i10 == 1) {
            CardMessage cardMessage = (CardMessage) inAppMessage;
            boolean z10 = !isValidAction(cardMessage.getPrimaryAction());
            boolean z11 = !isValidAction(cardMessage.getSecondaryAction());
            if (!z10 || !z11) {
                return false;
            }
            return true;
        } else if (i10 == 2) {
            return !isValidAction(((ModalMessage) inAppMessage).getAction());
        } else {
            if (i10 == 3) {
                return !isValidAction(((BannerMessage) inAppMessage).getAction());
            }
            if (i10 == 4) {
                return !isValidAction(((ImageOnlyMessage) inAppMessage).getAction());
            }
            Logging.loge("Unable to determine if impression should be counted as conversion.");
            return false;
        }
    }

    private boolean isTestCampaign(InAppMessage inAppMessage) {
        return inAppMessage.getCampaignMetadata().getIsTestMessage();
    }

    private boolean isValidAction(@Nullable Action action) {
        if (action == null || action.getActionUrl() == null || action.getActionUrl().isEmpty()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$logDismiss$3(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType, String str) {
        this.engagementMetricsLogger.logEvent(createDismissEntry(inAppMessage, str, dismissTransform.get(inAppMessagingDismissType)).toByteArray());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$logImpression$0(InAppMessage inAppMessage, String str) {
        this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, str, EventType.IMPRESSION_EVENT_TYPE).toByteArray());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$logMessageClick$1(InAppMessage inAppMessage, String str) {
        this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, str, EventType.CLICK_EVENT_TYPE).toByteArray());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$logRenderError$2(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason, String str) {
        this.engagementMetricsLogger.logEvent(createRenderErrorEntry(inAppMessage, str, errorTransform.get(inAppMessagingErrorReason)).toByteArray());
    }

    private void logEventAsync(InAppMessage inAppMessage, String str, boolean z10) {
        String campaignId = inAppMessage.getCampaignMetadata().getCampaignId();
        Bundle collectAnalyticsParams = collectAnalyticsParams(inAppMessage.getCampaignMetadata().getCampaignName(), campaignId);
        Logging.logd("Sending event=" + str + " params=" + collectAnalyticsParams);
        AnalyticsConnector analyticsConnector2 = this.analyticsConnector;
        if (analyticsConnector2 != null) {
            analyticsConnector2.logEvent("fiam", str, collectAnalyticsParams);
            if (z10) {
                AnalyticsConnector analyticsConnector3 = this.analyticsConnector;
                analyticsConnector3.setUserProperty("fiam", Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION, "fiam:" + campaignId);
                return;
            }
            return;
        }
        Logging.logw("Unable to log event: analytics library is missing");
    }

    public Bundle collectAnalyticsParams(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("_nmid", str2);
        bundle.putString(Constants.ScionAnalytics.PARAM_MESSAGE_NAME, str);
        try {
            bundle.putInt(Constants.ScionAnalytics.PARAM_MESSAGE_DEVICE_TIME, (int) (this.clock.now() / 1000));
        } catch (NumberFormatException e10) {
            Logging.logw("Error while parsing use_device_time in FIAM event: " + e10.getMessage());
        }
        return bundle;
    }

    public void logDismiss(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new u1(this, inAppMessage, inAppMessagingDismissType));
            logEventAsync(inAppMessage, "fiam_dismiss", false);
        }
        this.developerListenerManager.messageDismissed(inAppMessage);
    }

    public void logImpression(InAppMessage inAppMessage) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new s1(this, inAppMessage));
            logEventAsync(inAppMessage, "fiam_impression", impressionCountsAsConversion(inAppMessage));
        }
        this.developerListenerManager.impressionDetected(inAppMessage);
    }

    public void logMessageClick(InAppMessage inAppMessage, Action action) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new t1(this, inAppMessage));
            logEventAsync(inAppMessage, "fiam_action", true);
        }
        this.developerListenerManager.messageClicked(inAppMessage, action);
    }

    public void logRenderError(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new v1(this, inAppMessage, inAppMessagingErrorReason));
        }
        this.developerListenerManager.displayErrorEncountered(inAppMessage, inAppMessagingErrorReason);
    }
}
