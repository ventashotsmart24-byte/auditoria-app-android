package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.AbstractMessageLite;
import java.util.concurrent.Callable;

public final /* synthetic */ class x1 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProtoStorageClient f10335a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractMessageLite f10336b;

    public /* synthetic */ x1(ProtoStorageClient protoStorageClient, AbstractMessageLite abstractMessageLite) {
        this.f10335a = protoStorageClient;
        this.f10336b = abstractMessageLite;
    }

    public final Object call() {
        return this.f10335a.lambda$write$0(this.f10336b);
    }
}
