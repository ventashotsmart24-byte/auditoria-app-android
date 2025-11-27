package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserMetadata.SerializeableKeysMap f10215a;

    public /* synthetic */ b(UserMetadata.SerializeableKeysMap serializeableKeysMap) {
        this.f10215a = serializeableKeysMap;
    }

    public final Object call() {
        return this.f10215a.lambda$scheduleSerializationTaskIfNeeded$0();
    }
}
