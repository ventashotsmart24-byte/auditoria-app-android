package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import org.json.JSONObject;

final class zzai extends zzbl {
    final /* synthetic */ MediaQueueItem zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ JSONObject zzd;
    final /* synthetic */ RemoteMediaClient zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzai(RemoteMediaClient remoteMediaClient, MediaQueueItem mediaQueueItem, int i10, long j10, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zze = remoteMediaClient;
        this.zza = mediaQueueItem;
        this.zzb = i10;
        this.zzc = j10;
        this.zzd = jSONObject;
    }

    public final void zza() {
        this.zze.zzd.zzw(zzb(), new MediaQueueItem[]{this.zza}, this.zzb, 0, 0, this.zzc, this.zzd);
    }
}
