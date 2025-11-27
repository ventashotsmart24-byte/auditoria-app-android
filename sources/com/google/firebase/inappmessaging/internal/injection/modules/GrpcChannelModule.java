package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import y8.d;
import y8.s0;

@Module
public class GrpcChannelModule {
    @Singleton
    @Provides
    public d providesGrpcChannel(@Named("host") String str) {
        return s0.b(str).a();
    }

    @Singleton
    @Provides
    @Named("host")
    public String providesServiceHost() {
        return "firebaseinappmessaging.googleapis.com";
    }
}
