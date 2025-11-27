package com.google.firebase.inappmessaging.internal;

import java.util.ArrayList;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbtIntegrationHelper f10241a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f10242b;

    public /* synthetic */ a(AbtIntegrationHelper abtIntegrationHelper, ArrayList arrayList) {
        this.f10241a = abtIntegrationHelper;
        this.f10242b = arrayList;
    }

    public final void run() {
        this.f10241a.lambda$updateRunningExperiments$0(this.f10242b);
    }
}
