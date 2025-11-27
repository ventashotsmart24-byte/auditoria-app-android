package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

final class zzal extends zzbl {
    final /* synthetic */ int[] zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzal(RemoteMediaClient remoteMediaClient, int[] iArr, int i10, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzd = remoteMediaClient;
        this.zza = iArr;
        this.zzb = i10;
        this.zzc = jSONObject;
    }

    public final void zza() {
        this.zzd.zzd.zzz(zzb(), this.zza, this.zzb, this.zzc);
    }
}
