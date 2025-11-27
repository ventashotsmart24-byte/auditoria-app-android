package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

final class zzaq extends zzbl {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaq(RemoteMediaClient remoteMediaClient, int i10, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = i10;
        this.zzb = jSONObject;
    }

    public final void zza() {
        this.zzc.zzd.zzy(zzb(), new int[]{this.zza}, this.zzb);
    }
}
