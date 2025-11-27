package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.dagger.internal.Factory;

public final class ProtoMarshallerClient_Factory implements Factory<ProtoMarshallerClient> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ProtoMarshallerClient_Factory INSTANCE = new ProtoMarshallerClient_Factory();

        private InstanceHolder() {
        }
    }

    public static ProtoMarshallerClient_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ProtoMarshallerClient newInstance() {
        return new ProtoMarshallerClient();
    }

    public ProtoMarshallerClient get() {
        return newInstance();
    }
}
