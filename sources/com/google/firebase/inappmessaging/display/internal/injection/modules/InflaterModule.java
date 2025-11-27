package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.model.InAppMessage;

@Module
public class InflaterModule {
    private final Application application;
    private final InAppMessage inAppMessage;
    private final InAppMessageLayoutConfig inAppMessageLayoutConfig;

    public InflaterModule(InAppMessage inAppMessage2, InAppMessageLayoutConfig inAppMessageLayoutConfig2, Application application2) {
        this.inAppMessage = inAppMessage2;
        this.inAppMessageLayoutConfig = inAppMessageLayoutConfig2;
        this.application = application2;
    }

    @InAppMessageScope
    @Provides
    public InAppMessageLayoutConfig inAppMessageLayoutConfig() {
        return this.inAppMessageLayoutConfig;
    }

    @Provides
    public InAppMessage providesBannerMessage() {
        return this.inAppMessage;
    }

    @InAppMessageScope
    @Provides
    public LayoutInflater providesInflaterservice() {
        return (LayoutInflater) this.application.getSystemService("layout_inflater");
    }
}
