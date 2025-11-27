package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.account.zzc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class zzi extends BaseImplementation.ApiMethodImpl<Result, zzr> {
    private final /* synthetic */ boolean zzae;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzi(zzh zzh, Api api, GoogleApiClient googleApiClient, boolean z10) {
        super((Api<?>) api, googleApiClient);
        this.zzae = z10;
    }

    public final Result createFailedResult(Status status) {
        return new zzp(status);
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzc) ((zzr) anyClient).getService()).zzb(this.zzae);
        setResult(new zzp(Status.RESULT_SUCCESS));
    }
}
