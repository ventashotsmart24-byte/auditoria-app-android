package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class a0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImpressionStorageClient f10243a;

    public /* synthetic */ a0(ImpressionStorageClient impressionStorageClient) {
        this.f10243a = impressionStorageClient;
    }

    public final void accept(Object obj) {
        this.f10243a.lambda$getAllImpressions$2((Throwable) obj);
    }
}
