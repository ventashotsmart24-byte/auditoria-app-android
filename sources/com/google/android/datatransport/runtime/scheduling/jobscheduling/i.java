package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f5846a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5847b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5848c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f5849d;

    public /* synthetic */ i(Uploader uploader, TransportContext transportContext, int i10, Runnable runnable) {
        this.f5846a = uploader;
        this.f5847b = transportContext;
        this.f5848c = i10;
        this.f5849d = runnable;
    }

    public final void run() {
        this.f5846a.lambda$upload$1(this.f5847b, this.f5848c, this.f5849d);
    }
}
