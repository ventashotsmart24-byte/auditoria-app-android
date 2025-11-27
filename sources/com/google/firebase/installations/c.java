package com.google.firebase.installations;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f10348a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10349b;

    public /* synthetic */ c(FirebaseInstallations firebaseInstallations, boolean z10) {
        this.f10348a = firebaseInstallations;
        this.f10349b = z10;
    }

    public final void run() {
        this.f10348a.lambda$getToken$2(this.f10349b);
    }
}
