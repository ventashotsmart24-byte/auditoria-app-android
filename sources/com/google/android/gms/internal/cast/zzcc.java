package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
class zzcc extends BaseImplementation.ApiMethodImpl<CastRemoteDisplay.CastRemoteDisplaySessionResult, zzch> {
    final /* synthetic */ zzce zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcc(zzce zzce, GoogleApiClient googleApiClient) {
        super((Api<?>) zzce.zzb, googleApiClient);
        this.zzc = zzce;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzcd(status);
    }

    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    @VisibleForTesting
    /* renamed from: zza */
    public void doExecute(zzch zzch) {
        throw null;
    }
}
