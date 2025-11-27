package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzi extends zzp {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzi(zzm zzm, GoogleApiClient googleApiClient, String str, String str2, zzbq zzbq) {
        super(googleApiClient);
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        doExecute((zzw) anyClient);
    }

    public final void zza(zzw zzw) {
        try {
            zzw.zzL(this.zza, this.zzb, (zzbq) null, this);
        } catch (IllegalStateException unused) {
            zzc(CastStatusCodes.INVALID_REQUEST);
        }
    }
}
