package com.google.firebase.inappmessaging.internal;

import com.google.firebase.installations.InstallationTokenResult;
import io.reactivex.functions.BiFunction;

public final /* synthetic */ class q1 implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        return InstallationIdResult.create((String) obj, (InstallationTokenResult) obj2);
    }
}
