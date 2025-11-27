package com.google.firebase.auth.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.internal.InternalTokenProvider;

@KeepForSdk
public interface InternalAuthProvider extends InternalTokenProvider {
    @KeepForSdk
    @DeferredApi
    void addIdTokenListener(IdTokenListener idTokenListener);

    @KeepForSdk
    Task<GetTokenResult> getAccessToken(boolean z10);

    String getUid();

    @KeepForSdk
    void removeIdTokenListener(IdTokenListener idTokenListener);
}
