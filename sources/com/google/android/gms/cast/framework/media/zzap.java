package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import org.json.JSONObject;

final class zzap extends zzbl {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzap(RemoteMediaClient remoteMediaClient, int i10, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = i10;
        this.zzb = jSONObject;
    }

    public final void zza() {
        this.zzc.zzd.zzA(zzb(), 0, -1, (MediaQueueItem[]) null, 0, false, Integer.valueOf(this.zza), this.zzb);
    }
}
