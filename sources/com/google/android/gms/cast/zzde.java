package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzde extends zzdl {
    final /* synthetic */ double zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzde(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, double d10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = d10;
        this.zzb = jSONObject;
    }

    public final void zza(zzw zzw) {
        this.zzc.zzb.zzG(zzb(), this.zza, this.zzb);
    }
}
