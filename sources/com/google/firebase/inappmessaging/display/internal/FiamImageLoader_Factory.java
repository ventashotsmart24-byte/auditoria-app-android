package com.google.firebase.inappmessaging.display.internal;

import com.bumptech.glide.RequestManager;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import javax.inject.Provider;

public final class FiamImageLoader_Factory implements Factory<FiamImageLoader> {
    private final Provider<RequestManager> requestManagerProvider;

    public FiamImageLoader_Factory(Provider<RequestManager> provider) {
        this.requestManagerProvider = provider;
    }

    public static FiamImageLoader_Factory create(Provider<RequestManager> provider) {
        return new FiamImageLoader_Factory(provider);
    }

    public static FiamImageLoader newInstance(RequestManager requestManager) {
        return new FiamImageLoader(requestManager);
    }

    public FiamImageLoader get() {
        return newInstance(this.requestManagerProvider.get());
    }
}
