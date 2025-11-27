package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzcv extends zzdl {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcv(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = i10;
        this.zzb = jSONObject;
    }

    public final void zza(zzw zzw) {
        this.zzc.zzb.zzA(zzb(), 0, -1, (MediaQueueItem[]) null, 0, false, Integer.valueOf(this.zza), this.zzb);
    }
}
