package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbx extends zzcc {
    final /* synthetic */ String zza;
    final /* synthetic */ zzce zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbx(zzce zzce, GoogleApiClient googleApiClient, String str) {
        super(zzce, googleApiClient);
        this.zzb = zzce;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        doExecute((zzch) anyClient);
    }

    public final void zza(zzch zzch) {
        zzch.zzr(new zzca(this, zzch), this.zzb.zzd, this.zza);
    }
}
