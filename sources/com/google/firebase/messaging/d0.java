package com.google.firebase.messaging;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesQueue f10362a;

    public /* synthetic */ d0(SharedPreferencesQueue sharedPreferencesQueue) {
        this.f10362a = sharedPreferencesQueue;
    }

    public final void run() {
        this.f10362a.syncState();
    }
}
