package com.google.firebase.installations;

import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f10347a;

    public /* synthetic */ b(FirebaseInstallations firebaseInstallations) {
        this.f10347a = firebaseInstallations;
    }

    public final Object call() {
        return this.f10347a.deleteFirebaseInstallationId();
    }
}
