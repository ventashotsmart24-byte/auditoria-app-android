package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

final class zzbd extends zzbl {
    final /* synthetic */ boolean zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbd(RemoteMediaClient remoteMediaClient, boolean z10, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = z10;
        this.zzb = jSONObject;
    }

    public final void zza() {
        this.zzc.zzd.zzF(zzb(), this.zza, this.zzb);
    }
}
