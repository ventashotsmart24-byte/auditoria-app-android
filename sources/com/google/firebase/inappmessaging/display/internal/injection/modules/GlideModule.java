package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;

@Module
public class GlideModule {
    @Provides
    @FirebaseAppScope
    public RequestManager providesGlideRequestManager(Application application, GlideErrorListener glideErrorListener) {
        return Glide.with((Context) application).addDefaultRequestListener(glideErrorListener);
    }
}
