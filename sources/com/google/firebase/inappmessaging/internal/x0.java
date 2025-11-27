package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Predicate;

public final /* synthetic */ class x0 implements Predicate {
    public final boolean test(Object obj) {
        return InAppMessageStreamManager.validIID((InstallationIdResult) obj);
    }
}
