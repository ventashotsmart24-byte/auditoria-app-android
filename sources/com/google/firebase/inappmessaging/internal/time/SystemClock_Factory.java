package com.google.firebase.inappmessaging.internal.time;

import com.google.firebase.inappmessaging.dagger.internal.Factory;

public final class SystemClock_Factory implements Factory<SystemClock> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SystemClock_Factory INSTANCE = new SystemClock_Factory();

        private InstanceHolder() {
        }
    }

    public static SystemClock_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SystemClock newInstance() {
        return new SystemClock();
    }

    public SystemClock get() {
        return newInstance();
    }
}
