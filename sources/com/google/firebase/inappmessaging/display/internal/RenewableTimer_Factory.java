package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

public final class RenewableTimer_Factory implements Factory<RenewableTimer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RenewableTimer_Factory INSTANCE = new RenewableTimer_Factory();

        private InstanceHolder() {
        }
    }

    public static RenewableTimer_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RenewableTimer newInstance() {
        return new RenewableTimer();
    }

    public RenewableTimer get() {
        return newInstance();
    }
}
