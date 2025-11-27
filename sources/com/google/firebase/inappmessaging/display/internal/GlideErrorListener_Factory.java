package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

public final class GlideErrorListener_Factory implements Factory<GlideErrorListener> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GlideErrorListener_Factory INSTANCE = new GlideErrorListener_Factory();

        private InstanceHolder() {
        }
    }

    public static GlideErrorListener_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GlideErrorListener newInstance() {
        return new GlideErrorListener();
    }

    public GlideErrorListener get() {
        return newInstance();
    }
}
