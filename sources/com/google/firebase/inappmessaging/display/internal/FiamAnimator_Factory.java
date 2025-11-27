package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

public final class FiamAnimator_Factory implements Factory<FiamAnimator> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FiamAnimator_Factory INSTANCE = new FiamAnimator_Factory();

        private InstanceHolder() {
        }
    }

    public static FiamAnimator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FiamAnimator newInstance() {
        return new FiamAnimator();
    }

    public FiamAnimator get() {
        return newInstance();
    }
}
