package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdg extends zzdl {
    final /* synthetic */ RemoteMediaPlayer zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdg(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
        super(remoteMediaPlayer, googleApiClient);
        this.zza = remoteMediaPlayer;
    }

    public final void zza(zzw zzw) {
        this.zza.zzb.zzB(zzb());
    }
}
