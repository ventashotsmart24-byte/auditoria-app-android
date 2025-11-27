package com.google.android.gms.cast;

import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.internal.zzap;
import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdd extends zzdl {
    final /* synthetic */ long zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdd(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, long j10, int i10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = j10;
        this.zzb = i10;
        this.zzc = jSONObject;
    }

    public final void zza(zzw zzw) {
        zzap zzc2 = this.zzd.zzb;
        zzar zzb2 = zzb();
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(this.zza);
        builder.setResumeState(this.zzb);
        builder.setCustomData(this.zzc);
        zzc2.zzC(zzb2, builder.build());
    }
}
