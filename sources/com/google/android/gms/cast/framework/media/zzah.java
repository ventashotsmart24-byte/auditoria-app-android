package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import org.json.JSONObject;

final class zzah extends zzbl {
    final /* synthetic */ MediaQueueItem[] zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzah(RemoteMediaClient remoteMediaClient, MediaQueueItem[] mediaQueueItemArr, int i10, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzd = remoteMediaClient;
        this.zza = mediaQueueItemArr;
        this.zzb = i10;
        this.zzc = jSONObject;
    }

    public final void zza() {
        this.zzd.zzd.zzw(zzb(), this.zza, this.zzb, 0, -1, -1, this.zzc);
    }
}
