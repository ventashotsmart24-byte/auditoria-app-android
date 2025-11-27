package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzab;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzj extends zzab {
    public zzj(zzm zzm, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        doExecute((zzw) anyClient);
    }

    public final void zza(zzw zzw) {
        try {
            zzw.zzN(this);
        } catch (IllegalStateException unused) {
            zzc(CastStatusCodes.INVALID_REQUEST);
        }
    }
}
