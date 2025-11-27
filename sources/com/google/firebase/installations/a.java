package com.google.firebase.installations;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f10345a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10346b;

    public /* synthetic */ a(FirebaseInstallations firebaseInstallations, boolean z10) {
        this.f10345a = firebaseInstallations;
        this.f10346b = z10;
    }

    public final void run() {
        this.f10345a.lambda$doRegistrationOrRefresh$3(this.f10346b);
    }
}
