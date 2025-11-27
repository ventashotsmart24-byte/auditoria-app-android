package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

public final class FiamWindowManager_Factory implements Factory<FiamWindowManager> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FiamWindowManager_Factory INSTANCE = new FiamWindowManager_Factory();

        private InstanceHolder() {
        }
    }

    public static FiamWindowManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FiamWindowManager newInstance() {
        return new FiamWindowManager();
    }

    public FiamWindowManager get() {
        return newInstance();
    }
}
