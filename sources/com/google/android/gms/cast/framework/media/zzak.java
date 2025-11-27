package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

final class zzak extends zzbl {
    final /* synthetic */ int[] zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzak(RemoteMediaClient remoteMediaClient, int[] iArr, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = iArr;
        this.zzb = jSONObject;
    }

    public final void zza() {
        this.zzc.zzd.zzy(zzb(), this.zza, this.zzb);
    }
}
