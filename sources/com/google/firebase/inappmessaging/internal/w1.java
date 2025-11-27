package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.Parser;
import java.util.concurrent.Callable;

public final /* synthetic */ class w1 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProtoStorageClient f10331a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Parser f10332b;

    public /* synthetic */ w1(ProtoStorageClient protoStorageClient, Parser parser) {
        this.f10331a = protoStorageClient;
        this.f10332b = parser;
    }

    public final Object call() {
        return this.f10331a.lambda$read$1(this.f10332b);
    }
}
