package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzcw extends zzdl {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcw(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = i10;
        this.zzb = jSONObject;
    }

    public final void zza(zzw zzw) {
        if (RemoteMediaPlayer.zza(this.zzc, this.zza) == -1) {
            setResult(new zzdk(this, new Status(0)));
        } else {
            this.zzc.zzb.zzy(zzb(), new int[]{this.zza}, this.zzb);
        }
    }
}
