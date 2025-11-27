package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

final class zzbe extends zzbl {
    final /* synthetic */ double zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbe(RemoteMediaClient remoteMediaClient, double d10, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = d10;
        this.zzb = jSONObject;
    }

    public final void zza() {
        this.zzc.zzd.zzE(zzb(), this.zza, this.zzb);
    }
}
