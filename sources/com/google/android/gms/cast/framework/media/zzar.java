package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import org.json.JSONObject;

final class zzar extends zzbl {
    final /* synthetic */ int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzar(RemoteMediaClient remoteMediaClient, int i10, long j10, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzd = remoteMediaClient;
        this.zza = i10;
        this.zzb = j10;
        this.zzc = jSONObject;
    }

    public final void zza() {
        this.zzd.zzd.zzA(zzb(), this.zza, this.zzb, (MediaQueueItem[]) null, 0, false, (Integer) null, this.zzc);
    }
}
