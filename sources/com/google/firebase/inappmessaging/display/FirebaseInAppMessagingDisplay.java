package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import anet.channel.util.HttpConstant;
import com.google.common.primitives.Ints;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import k.a;

@FirebaseAppScope
public class FirebaseInAppMessagingDisplay extends FirebaseInAppMessagingDisplayImpl {
    static final long DISMISS_THRESHOLD_MILLIS = 20000;
    static final long IMPRESSION_THRESHOLD_MILLIS = 5000;
    static final long INTERVAL_MILLIS = 1000;
    /* access modifiers changed from: private */
    public final FiamAnimator animator;
    /* access modifiers changed from: private */
    public final Application application;
    /* access modifiers changed from: private */
    public final RenewableTimer autoDismissTimer;
    private final BindingWrapperFactory bindingWrapperFactory;
    /* access modifiers changed from: private */
    public FirebaseInAppMessagingDisplayCallbacks callbacks;
    String currentlyBoundActivityName;
    private FiamListener fiamListener;
    private final FirebaseInAppMessaging headlessInAppMessaging;
    private final FiamImageLoader imageLoader;
    /* access modifiers changed from: private */
    public final RenewableTimer impressionTimer;
    /* access modifiers changed from: private */
    public InAppMessage inAppMessage;
    private final Map<String, Provider<InAppMessageLayoutConfig>> layoutConfigs;
    /* access modifiers changed from: private */
    public final FiamWindowManager windowManager;

    /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
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
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
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
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.IMAGE_ONLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.CARD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.AnonymousClass5.<clinit>():void");
        }
    }

    @Inject
    public FirebaseInAppMessagingDisplay(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, Provider<InAppMessageLayoutConfig>> map, FiamImageLoader fiamImageLoader, RenewableTimer renewableTimer, RenewableTimer renewableTimer2, FiamWindowManager fiamWindowManager, Application application2, BindingWrapperFactory bindingWrapperFactory2, FiamAnimator fiamAnimator) {
        this.headlessInAppMessaging = firebaseInAppMessaging;
        this.layoutConfigs = map;
        this.imageLoader = fiamImageLoader;
        this.impressionTimer = renewableTimer;
        this.autoDismissTimer = renewableTimer2;
        this.windowManager = fiamWindowManager;
        this.application = application2;
        this.bindingWrapperFactory = bindingWrapperFactory2;
        this.animator = fiamAnimator;
    }

    private void bindFiamToActivity(Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            Logging.logi("Binding to activity: " + activity.getLocalClassName());
            this.headlessInAppMessaging.setMessageDisplayComponent(new a(this, activity));
            this.currentlyBoundActivityName = activity.getLocalClassName();
        }
        if (this.inAppMessage != null) {
            showActiveFiam(activity);
        }
    }

    /* access modifiers changed from: private */
    public void cancelTimers() {
        this.impressionTimer.cancel();
        this.autoDismissTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void dismissFiam(Activity activity) {
        Logging.logd("Dismissing fiam");
        notifyFiamDismiss();
        removeDisplayedFiam(activity);
        this.inAppMessage = null;
        this.callbacks = null;
    }

    private List<Action> extractActions(InAppMessage inAppMessage2) {
        ArrayList arrayList = new ArrayList();
        int i10 = AnonymousClass5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage2.getMessageType().ordinal()];
        if (i10 == 1) {
            arrayList.add(((BannerMessage) inAppMessage2).getAction());
        } else if (i10 == 2) {
            arrayList.add(((ModalMessage) inAppMessage2).getAction());
        } else if (i10 == 3) {
            arrayList.add(((ImageOnlyMessage) inAppMessage2).getAction());
        } else if (i10 != 4) {
            arrayList.add(Action.builder().build());
        } else {
            CardMessage cardMessage = (CardMessage) inAppMessage2;
            arrayList.add(cardMessage.getPrimaryAction());
            arrayList.add(cardMessage.getSecondaryAction());
        }
        return arrayList;
    }

    private ImageData extractImageData(InAppMessage inAppMessage2) {
        if (inAppMessage2.getMessageType() != MessageType.CARD) {
            return inAppMessage2.getImageData();
        }
        CardMessage cardMessage = (CardMessage) inAppMessage2;
        ImageData portraitImageData = cardMessage.getPortraitImageData();
        ImageData landscapeImageData = cardMessage.getLandscapeImageData();
        if (getScreenOrientation(this.application) == 1) {
            if (isValidImageData(portraitImageData)) {
                return portraitImageData;
            }
            return landscapeImageData;
        } else if (isValidImageData(landscapeImageData)) {
            return landscapeImageData;
        } else {
            return portraitImageData;
        }
    }

    public static FirebaseInAppMessagingDisplay getInstance() {
        return (FirebaseInAppMessagingDisplay) FirebaseApp.getInstance().get(FirebaseInAppMessagingDisplay.class);
    }

    private static int getScreenOrientation(Application application2) {
        return application2.getResources().getConfiguration().orientation;
    }

    /* access modifiers changed from: private */
    public void inflateBinding(final Activity activity, final BindingWrapper bindingWrapper) {
        Object obj;
        if (this.inAppMessage != null) {
            AnonymousClass2 r02 = new View.OnClickListener() {
                public void onClick(View view) {
                    if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                        FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
                    }
                    FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                }
            };
            HashMap hashMap = new HashMap();
            for (final Action next : extractActions(this.inAppMessage)) {
                if (next == null || TextUtils.isEmpty(next.getActionUrl())) {
                    Logging.logi("No action url found for action. Treating as dismiss.");
                    obj = r02;
                } else {
                    obj = new View.OnClickListener() {
                        public void onClick(View view) {
                            if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                Logging.logi("Calling callback for click action");
                                FirebaseInAppMessagingDisplay.this.callbacks.messageClicked(next);
                            }
                            FirebaseInAppMessagingDisplay.this.launchUriIntent(activity, Uri.parse(next.getActionUrl()));
                            FirebaseInAppMessagingDisplay.this.notifyFiamClick();
                            FirebaseInAppMessagingDisplay.this.removeDisplayedFiam(activity);
                            InAppMessage unused = FirebaseInAppMessagingDisplay.this.inAppMessage = null;
                            FirebaseInAppMessagingDisplayCallbacks unused2 = FirebaseInAppMessagingDisplay.this.callbacks = null;
                        }
                    };
                }
                hashMap.put(next, obj);
            }
            final ViewTreeObserver.OnGlobalLayoutListener inflate = bindingWrapper.inflate(hashMap, r02);
            if (inflate != null) {
                bindingWrapper.getImageView().getViewTreeObserver().addOnGlobalLayoutListener(inflate);
            }
            loadNullableImage(activity, bindingWrapper, extractImageData(this.inAppMessage), new FiamImageLoader.Callback() {
                public void onError(Exception exc) {
                    Logging.loge("Image download failure ");
                    if (inflate != null) {
                        bindingWrapper.getImageView().getViewTreeObserver().removeGlobalOnLayoutListener(inflate);
                    }
                    FirebaseInAppMessagingDisplay.this.cancelTimers();
                    InAppMessage unused = FirebaseInAppMessagingDisplay.this.inAppMessage = null;
                    FirebaseInAppMessagingDisplayCallbacks unused2 = FirebaseInAppMessagingDisplay.this.callbacks = null;
                }

                public void onSuccess() {
                    if (!bindingWrapper.getConfig().backgroundEnabled().booleanValue()) {
                        bindingWrapper.getRootView().setOnTouchListener(new View.OnTouchListener() {
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                if (motionEvent.getAction() != 4) {
                                    return false;
                                }
                                if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                    FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
                                }
                                AnonymousClass4 r12 = AnonymousClass4.this;
                                FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                                return true;
                            }
                        });
                    }
                    FirebaseInAppMessagingDisplay.this.impressionTimer.start(new RenewableTimer.Callback() {
                        public void onFinish() {
                            if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                Logging.logi("Impression timer onFinish for: " + FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                                FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
                            }
                        }
                    }, FirebaseInAppMessagingDisplay.IMPRESSION_THRESHOLD_MILLIS, 1000);
                    if (bindingWrapper.getConfig().autoDismiss().booleanValue()) {
                        FirebaseInAppMessagingDisplay.this.autoDismissTimer.start(new RenewableTimer.Callback() {
                            public void onFinish() {
                                if (!(FirebaseInAppMessagingDisplay.this.inAppMessage == null || FirebaseInAppMessagingDisplay.this.callbacks == null)) {
                                    FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
                                }
                                AnonymousClass4 r02 = AnonymousClass4.this;
                                FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                            }
                        }, FirebaseInAppMessagingDisplay.DISMISS_THRESHOLD_MILLIS, 1000);
                    }
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            FiamWindowManager access$900 = FirebaseInAppMessagingDisplay.this.windowManager;
                            AnonymousClass4 r12 = AnonymousClass4.this;
                            access$900.show(bindingWrapper, activity);
                            if (bindingWrapper.getConfig().animate().booleanValue()) {
                                FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, bindingWrapper.getRootView(), FiamAnimator.Position.TOP);
                            }
                        }
                    });
                }
            });
        }
    }

    private boolean isValidImageData(ImageData imageData) {
        if (imageData == null || TextUtils.isEmpty(imageData.getImageUrl())) {
            return false;
        }
        return true;
    }

    private boolean ishttpOrHttpsUri(Uri uri) {
        String scheme;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        if (scheme.equalsIgnoreCase(HttpConstant.HTTP) || scheme.equalsIgnoreCase("https")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$bindFiamToActivity$0(Activity activity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        if (this.inAppMessage != null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.logd("Active FIAM exists. Skipping trigger");
            return;
        }
        this.inAppMessage = inAppMessage2;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks;
        showActiveFiam(activity);
    }

    /* access modifiers changed from: private */
    public void launchUriIntent(Activity activity, Uri uri) {
        if (!ishttpOrHttpsUri(uri) || !supportsCustomTabs(activity)) {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            ResolveInfo resolveActivity = activity.getPackageManager().resolveActivity(intent, 0);
            intent.addFlags(Ints.MAX_POWER_OF_TWO);
            intent.addFlags(268435456);
            if (resolveActivity != null) {
                activity.startActivity(intent);
            } else {
                Logging.loge("Device cannot resolve intent for: android.intent.action.VIEW");
            }
        } else {
            a a10 = new a.C0094a().a();
            Intent intent2 = a10.f7210a;
            intent2.addFlags(Ints.MAX_POWER_OF_TWO);
            intent2.addFlags(268435456);
            a10.a(activity, uri);
        }
    }

    private void loadNullableImage(Activity activity, BindingWrapper bindingWrapper, ImageData imageData, FiamImageLoader.Callback callback) {
        if (isValidImageData(imageData)) {
            this.imageLoader.load(imageData.getImageUrl()).tag(activity.getClass()).placeholder(R.drawable.image_placeholder).into(bindingWrapper.getImageView(), callback);
        } else {
            callback.onSuccess();
        }
    }

    /* access modifiers changed from: private */
    public void notifyFiamClick() {
        FiamListener fiamListener2 = this.fiamListener;
        if (fiamListener2 != null) {
            fiamListener2.onFiamClick();
        }
    }

    private void notifyFiamDismiss() {
        FiamListener fiamListener2 = this.fiamListener;
        if (fiamListener2 != null) {
            fiamListener2.onFiamDismiss();
        }
    }

    private void notifyFiamTrigger() {
        FiamListener fiamListener2 = this.fiamListener;
        if (fiamListener2 != null) {
            fiamListener2.onFiamTrigger();
        }
    }

    /* access modifiers changed from: private */
    public void removeDisplayedFiam(Activity activity) {
        if (this.windowManager.isFiamDisplayed()) {
            this.imageLoader.cancelTag(activity.getClass());
            this.windowManager.destroy(activity);
            cancelTimers();
        }
    }

    private void showActiveFiam(final Activity activity) {
        final BindingWrapper bindingWrapper;
        if (this.inAppMessage == null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.loge("No active message found to render");
        } else if (this.inAppMessage.getMessageType().equals(MessageType.UNSUPPORTED)) {
            Logging.loge("The message being triggered is not supported by this version of the sdk.");
        } else {
            notifyFiamTrigger();
            InAppMessageLayoutConfig inAppMessageLayoutConfig = (InAppMessageLayoutConfig) this.layoutConfigs.get(InflaterConfigModule.configFor(this.inAppMessage.getMessageType(), getScreenOrientation(this.application))).get();
            int i10 = AnonymousClass5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[this.inAppMessage.getMessageType().ordinal()];
            if (i10 == 1) {
                bindingWrapper = this.bindingWrapperFactory.createBannerBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
            } else if (i10 == 2) {
                bindingWrapper = this.bindingWrapperFactory.createModalBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
            } else if (i10 == 3) {
                bindingWrapper = this.bindingWrapperFactory.createImageBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
            } else if (i10 != 4) {
                Logging.loge("No bindings found for this message type");
                return;
            } else {
                bindingWrapper = this.bindingWrapperFactory.createCardBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
            }
            activity.findViewById(16908290).post(new Runnable() {
                public void run() {
                    FirebaseInAppMessagingDisplay.this.inflateBinding(activity, bindingWrapper);
                }
            });
        }
    }

    private boolean supportsCustomTabs(Activity activity) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        intent.setPackage("com.android.chrome");
        List<ResolveInfo> queryIntentServices = activity.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return false;
        }
        return true;
    }

    private void unbindFiamFromActivity(Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str != null && str.equals(activity.getLocalClassName())) {
            Logging.logi("Unbinding from activity: " + activity.getLocalClassName());
            this.headlessInAppMessaging.clearDisplayListener();
            removeDisplayedFiam(activity);
            this.currentlyBoundActivityName = null;
        }
    }

    public void clearFiamListener() {
        this.fiamListener = null;
    }

    public InAppMessage getCurrentInAppMessage() {
        return this.inAppMessage;
    }

    public void onActivityPaused(Activity activity) {
        unbindFiamFromActivity(activity);
        this.headlessInAppMessaging.removeAllListeners();
        super.onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        bindFiamToActivity(activity);
    }

    public void setFiamListener(FiamListener fiamListener2) {
        this.fiamListener = fiamListener2;
    }

    public void testMessage(Activity activity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage2;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks;
        showActiveFiam(activity);
    }
}
