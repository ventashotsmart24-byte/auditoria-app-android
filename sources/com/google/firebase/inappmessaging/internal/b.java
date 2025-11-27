package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.ExperimentPayloadProto;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbtIntegrationHelper f10246a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExperimentPayloadProto.ExperimentPayload f10247b;

    public /* synthetic */ b(AbtIntegrationHelper abtIntegrationHelper, ExperimentPayloadProto.ExperimentPayload experimentPayload) {
        this.f10246a = abtIntegrationHelper;
        this.f10247b = experimentPayload;
    }

    public final void run() {
        this.f10246a.lambda$setExperimentActive$1(this.f10247b);
    }
}
