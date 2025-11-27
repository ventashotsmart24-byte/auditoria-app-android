package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;

@Module
public class HeadlessInAppMessagingModule {
    private final FirebaseInAppMessaging headless;

    public HeadlessInAppMessagingModule(FirebaseInAppMessaging firebaseInAppMessaging) {
        this.headless = firebaseInAppMessaging;
    }

    @Provides
    @FirebaseAppScope
    public FirebaseInAppMessaging providesHeadlesssSingleton() {
        return this.headless;
    }
}
