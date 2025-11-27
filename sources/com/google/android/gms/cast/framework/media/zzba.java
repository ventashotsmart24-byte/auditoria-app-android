package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

final class zzba extends zzbl {
    final /* synthetic */ JSONObject zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzba(RemoteMediaClient remoteMediaClient, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = jSONObject;
    }

    public final void zza() {
        this.zzb.zzd.zzr(zzb(), this.zza);
    }
}
