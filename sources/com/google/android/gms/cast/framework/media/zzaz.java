package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

final class zzaz extends zzbl {
    final /* synthetic */ JSONObject zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaz(RemoteMediaClient remoteMediaClient, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = jSONObject;
    }

    public final void zza() {
        this.zzb.zzd.zzJ(zzb(), this.zza);
    }
}
