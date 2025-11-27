package com.bumptech.glide;

import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import java.util.HashSet;
import java.util.Set;

abstract class GeneratedAppGlideModule extends AppGlideModule {
    public Set<Class<?>> getExcludedModuleClasses() {
        return new HashSet();
    }

    public RequestManagerRetriever.RequestManagerFactory getRequestManagerFactory() {
        return null;
    }
}
