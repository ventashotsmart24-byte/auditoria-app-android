package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzcx extends zzdl {
    final /* synthetic */ int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcx(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i10, long j10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = i10;
        this.zzb = j10;
        this.zzc = jSONObject;
    }

    public final void zza(zzw zzw) {
        if (RemoteMediaPlayer.zza(this.zzd, this.zza) == -1) {
            setResult(new zzdk(this, new Status(0)));
        } else {
            this.zzd.zzb.zzA(zzb(), this.zza, this.zzb, (MediaQueueItem[]) null, 0, false, (Integer) null, this.zzc);
        }
    }
}
