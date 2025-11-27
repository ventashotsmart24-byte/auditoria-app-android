package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdf extends zzdl {
    final /* synthetic */ boolean zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdf(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, boolean z10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = z10;
        this.zzb = jSONObject;
    }

    public final void zza(zzw zzw) {
        this.zzc.zzb.zzF(zzb(), this.zza, this.zzb);
    }
}
